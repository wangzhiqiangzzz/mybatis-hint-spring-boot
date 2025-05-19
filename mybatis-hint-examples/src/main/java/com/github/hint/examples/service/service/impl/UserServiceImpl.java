package com.github.hint.examples.service.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.hint.context.HintContext;
import com.github.hint.enums.MysqlEnum;
import com.github.hint.examples.service.dao.entity.User;
import com.github.hint.examples.service.dao.mapper.UserMapper;
import com.github.hint.examples.service.dto.UserInfoVO;
import com.github.hint.examples.service.service.IUserService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户信息表 服务实现类
 * </p>
 *
 * @author wzq
 * @since 2025-05-19
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Override
    public UserInfoVO getInfoById(Long id) {

        HintContext.markHint(MysqlEnum.TO_MASTER.getHint());
        User pojo = this.getById(id);
        if (pojo == null) {
            return null;
        }
        UserInfoVO userInfoVO = new UserInfoVO();
        userInfoVO.setCode(pojo.getCode());
        userInfoVO.setName(pojo.getUsername());
        return userInfoVO;
    }
}
