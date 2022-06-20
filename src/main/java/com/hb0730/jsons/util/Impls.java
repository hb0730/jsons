package com.hb0730.jsons.util;

/**
 * @author <a href="mailto:huangbing0730@gmail">hb0730</a>
 * @date 2022/6/20
 * @since 1.0.0
 */
public enum Impls {
    /**
     * jackson
     */
    JACKSON("com.fasterxml.jackson.databind.ObjectMapper"),
    /**
     * gson
     */
    GSON("com.google.gson.Gson"),
    ;

    private final String value;

    Impls(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
