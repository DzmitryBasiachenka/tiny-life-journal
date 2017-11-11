package com.bsdim.tlj.ui.web.util;

import org.apache.commons.lang3.StringUtils;

public final class WebUtil {
    private WebUtil() {}

    public static boolean compareParameters(String... parameters) {
        for (String parameter : parameters) {
            if (StringUtils.isBlank(parameter)) {
                return false;
            }
        }
        return true;
    }
}
