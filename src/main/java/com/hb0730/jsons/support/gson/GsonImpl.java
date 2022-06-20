package com.hb0730.jsons.support.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hb0730.jsons.SimpleJson;
import com.hb0730.jsons.SimpleJsonException;

/**
 * gson
 *
 * @author <a href="mailto:huangbing0730@gmail">hb0730</a>
 * @date 2022/6/19
 * @since 1.0.0
 */
public class GsonImpl implements SimpleJson {
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
    public String toJson(Object obj) {
        return this.toJson(obj, null);
    }

    @Override
    public <C> String toJson(Object obj, C client) {
        if (null == client) {
            return gson.toJson(obj);
        }
        supportType(client);
        return ((Gson) client).toJson(obj);
    }

    @Override
    public <T> T fromJson(String json, Class<T> clazz) {
        return this.fromJson(json, clazz, null);
    }

    @Override
    public <T, C> T fromJson(String json, Class<T> clazz, C client) {
        if (null == client) {
            return this.gson.fromJson(json, clazz);
        }
        supportType(client);
        return ((Gson) client).fromJson(json, clazz);
    }

    @Override
    public <T, Type> T fromJson(String json, Type type) {
        return this.fromJson(json, type, null);
    }

    @Override
    public <T, Type, C> T fromJson(String json, Type type, C client) {
        supportJavaType(type);
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

    protected <Type> void supportJavaType(Type type) {
        if (!(type instanceof java.lang.reflect.Type)) {
            throw new SimpleJsonException("type mismatch");
        }
    }
}
