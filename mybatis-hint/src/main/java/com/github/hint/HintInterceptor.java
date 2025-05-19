package com.github.hint;

import com.github.hint.context.HintContext;
import org.apache.ibatis.cache.CacheKey;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

/**
 * @ClassName HintInterceptor
 * @Description
 * @Author wzq
 * @Date 2025/5/19 14:09
 * @Version 1.0
 */

@Intercepts({
        @Signature(type = Executor.class, method = "query", args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class}),
        @Signature(type = Executor.class, method = "query", args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class, CacheKey.class, BoundSql.class}
        )
})
public class HintInterceptor implements Interceptor{

        @Override
        public Object intercept(Invocation invocation) throws Throwable {
                if (HintContext.isHint()) {
                        String hint = HintContext.getHint();
                        HintContext.clear();
                        Object[] args = invocation.getArgs();
                        MappedStatement ms = (MappedStatement) args[0];
                        Object parameter = args[1];
                        RowBounds rowBounds = (RowBounds) args[2];
                        ResultHandler resultHandler = (ResultHandler) args[3];
                        Executor executor = (Executor) invocation.getTarget();
                        CacheKey cacheKey;
                        BoundSql boundSql;

                        if (args.length == 4) {
                                //4 个参数时
                                boundSql = ms.getBoundSql(parameter);
                                cacheKey = executor.createCacheKey(ms, parameter, rowBounds, boundSql);
                        } else {
                                //6 个参数时
                                cacheKey = (CacheKey) args[4];
                                boundSql = (BoundSql) args[5];
                        }

                        String originalSql = boundSql.getSql();
                        String newSql = originalSql.replaceFirst("(?i)SELECT\\s+", "SELECT "+hint+" ");
                        // 使用MetaObject对象将新的SQL语句设置到BoundSql对象中
                        MetaObject metaObject = SystemMetaObject.forObject(boundSql);
                        metaObject.setValue("sql", newSql);
                        return executor.query(ms, parameter, rowBounds, resultHandler, cacheKey, boundSql);
                }

                return invocation.proceed();
        }

        @Override
        public Object plugin(Object target) {
                return Plugin.wrap(target, this);
        }
}
