package com.hb0730.jsons.util;

import com.hb0730.jsons.SimpleJson;
import com.hb0730.jsons.support.gson.GsonImpl;
import com.hb0730.jsons.support.jackson.JacksonImpl;
import com.hb0730.jsons.support.jsonb.JsonbImpl;

/**
 * @author <a href="mailto:huangbing0730@gmail">hb0730</a>
 * @date 2022/6/20
 * @since 1.0.0
 */
public enum Impls {
    /**
     * jackson
     */
    JACKSON("com.fasterxml.jackson.databind.ObjectMapper", JacksonImpl.class),
    /**
     * gson
     */
    GSON("com.google.gson.Gson", GsonImpl.class),
    /**
     * JSONB
     */
    JSONB("jakarta.json.bind", JsonbImpl.class),
    ;

    private final String value;
    private final Class<? extends SimpleJson> clazz;

    Impls(String value, Class<? extends SimpleJson> clazz) {
        this.value = value;
        this.clazz = clazz;
    }

    public String getValue() {
        return value;
    }

    public Class<? extends SimpleJson> getCalzz() {
        return clazz;
    }
}
