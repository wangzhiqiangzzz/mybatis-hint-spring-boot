package com.github.hint.autoconfigure;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @ClassName HintProperties
 * @Description
 * @Author wzq
 * @Date 2025/5/19 15:25
 * @Version 1.0
 */

@ConfigurationProperties(prefix = HintProperties.HINT_PREFIX)
public class HintProperties {

    public static final String HINT_PREFIX = "hint";

    private boolean enable = false;

    public boolean getEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }
}
