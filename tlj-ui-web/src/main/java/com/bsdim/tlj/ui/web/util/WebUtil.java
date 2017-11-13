package com.bsdim.tlj.ui.web.util;

import org.apache.commons.lang3.StringUtils;

/**
 * The web util.
 * <p>
 * Date: 2017-11-27
 *
 * @author Dzmitry Basiachenka
 */
public final class WebUtil {
    private WebUtil() {}

    /**
     * Compares the parameters.
     *
     * @param parameters the parameters.
     * @return true or false.
     */
    public static boolean compareParameters(String... parameters) {
        for (String parameter : parameters) {
            if (StringUtils.isBlank(parameter)) {
                return false;
            }
        }
        return true;
    }
}
