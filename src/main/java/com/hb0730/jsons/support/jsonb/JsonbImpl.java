package com.hb0730.jsons.support.jsonb;

import com.hb0730.jsons.SimpleJsonException;
import com.hb0730.jsons.support.AbstractSimpleJson;
import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;

import java.lang.reflect.Type;

/**
 * JSON-B
 *
 * @author <a href="mailto:huangbing0730@gmail">hb0730</a>
 * @date 2022/7/4
 */
public class JsonbImpl extends AbstractSimpleJson {
    private Jsonb jsonb;

    public JsonbImpl() {
        this(JsonbBuilder.create());
    }

    public JsonbImpl(Jsonb jsonb) {
        this.jsonb = jsonb;
    }

    @Override
    @SuppressWarnings({"unchecked"})
    public <C> C getClient() {
        return (C) this.jsonb;
    }

    @Override
    public <C> void setClient(C client) {
        supportType(client);
        this.jsonb = (Jsonb) client;
    }

    @Override
    protected <C> String doToJson(Object obj, C client) {
        if (null == client) {
            return this.jsonb.toJson(obj);
        }
        return ((Jsonb) client).toJson(obj);
    }

    @Override
    protected <T, C> T doFromJson(String json, Class<T> clazz, C client) {
        if (null == client) {
            return this.jsonb.fromJson(json, clazz);
        }
        return ((Jsonb) client).fromJson(json, clazz);
    }

    @Override
    protected <T, ValueType, C> T doFromJson(String json, ValueType type, C client) {
        if (null == client) {
            return this.jsonb.fromJson(json, (java.lang.reflect.Type) type);
        }
        return ((Jsonb) client).fromJson(json, (java.lang.reflect.Type) type);
    }

    protected <C> void supportType(C client) {
        if (!(client instanceof Jsonb)) {
            throw new SimpleJsonException("type mismatch");
        }
    }

    protected <ValueType> void supportJavaType(ValueType type) {
        if (!(type instanceof Type)) {
            throw new SimpleJsonException("java type mismatch");
        }
    }

}
