package com.hb0730.jsons.support.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hb0730.jsons.SimpleJsonException;
import com.hb0730.jsons.support.AbstractSimpleJson;

/**
 * gson
 *
 * @author <a href="mailto:huangbing0730@gmail">hb0730</a>
 * @date 2022/6/19
 * @since 1.0.0
 */
public class GsonImpl extends AbstractSimpleJson {
    private Gson gson;

    public GsonImpl() {
        this(new GsonBuilder().create());
    }

    public GsonImpl(Gson gson) {
        this.gson = gson;
    }

    @Override
    @SuppressWarnings({"unchecked"})
    public <C> C getClient() {
        return (C) this.gson;
    }

    @Override
    public <C> void setClient(C client) {
        supportType(client);
        this.gson = (Gson) client;
    }

    @Override
    protected <C> String doToJson(Object obj, C client) {
        if (null == client) {
            return gson.toJson(obj);
        }
        return ((Gson) client).toJson(obj);
    }

    @Override
    protected <T, C> T doFromJson(String json, Class<T> clazz, C client) {
        if (null == client) {
            return this.gson.fromJson(json, clazz);
        }
        return ((Gson) client).fromJson(json, clazz);
    }

    @Override
    protected <T, ValueType, C> T doFromJson(String json, ValueType type, C client) {
        if (null == client) {
            return this.gson.fromJson(json, (java.lang.reflect.Type) type);
        }
        return ((Gson) client).fromJson(json, (java.lang.reflect.Type) type);
    }

    protected <C> void supportType(C client) {
        if (!(client instanceof Gson)) {
            throw new SimpleJsonException("type mismatch");
        }
    }

    protected <ValueType> void supportJavaType(ValueType type) {
        if (!(type instanceof java.lang.reflect.Type)) {
            throw new SimpleJsonException("type mismatch");
        }
    }
}
