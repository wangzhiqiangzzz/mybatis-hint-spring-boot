package com.github.hint.context;

import org.apache.commons.lang3.StringUtils;

/**
 * @ClassName MasterContext
 * @Description
 * @Author wzq
 * @Date 2025/5/16 18:09
 * @Version 1.0
 */
public class HintContext {

    private static final ThreadLocal<String> hint = ThreadLocal.withInitial(() -> null);

    public static void markHint(String s) {
        hint.set(s);
    }

    public static boolean isHint() {
        return StringUtils.isNotBlank(hint.get());
    }

    public static String getHint() {
        return hint.get();
    }

    public static void clear() {
        hint.remove();
    }

}
