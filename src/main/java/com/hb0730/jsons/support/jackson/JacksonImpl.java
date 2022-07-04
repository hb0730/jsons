package com.hb0730.jsons.support.jackson;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hb0730.jsons.SimpleJsonException;
import com.hb0730.jsons.support.AbstractSimpleJson;

/**
 * jackson
 *
 * @author <a href="mailto:huangbing0730@gmail">hb0730</a>
 * @date 2022/6/18
 * @since 1.0.0
 */
public class JacksonImpl extends AbstractSimpleJson {
    private ObjectMapper mapper;

    public JacksonImpl() {
        this(new ObjectMapper());
    }

    public JacksonImpl(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    @SuppressWarnings({"unchecked"})
    public <C> C getClient() {
        return (C) this.mapper;
    }

    @Override
    public <C> void setClient(C client) {
        supportType(client);
        this.mapper = (ObjectMapper) client;
    }

    @Override
    protected <C> String doToJson(Object obj, C client) {
        try {
            if (null == client) {
                return this.mapper.writeValueAsString(obj);
            }
            return ((ObjectMapper) client).writeValueAsString(obj);
        } catch (Exception e) {
            throw new SimpleJsonException(e);
        }
    }

    @Override
    protected <T, C> T doFromJson(String json, Class<T> clazz, C client) {
        try {
            if (null == client) {
                return this.mapper.readValue(json, clazz);
            }
            return ((ObjectMapper) client).readValue(json, clazz);
        } catch (Exception e) {
            throw new SimpleJsonException(e);
        }
    }

    @Override
    @SuppressWarnings({"unchecked"})
    protected <T, ValueType, C> T doFromJson(String json, ValueType type, C client) {
        boolean javaType = type instanceof JavaType;
        try {
            if (null == client && javaType) {
                return this.mapper.readValue(json, (JavaType) type);
            } else if (null == client) {
                return this.mapper.readValue(json, (TypeReference<? extends T>) type);
            }
            if (javaType) {
                return ((ObjectMapper) client).readValue(json, (JavaType) type);
            } else {
                return ((ObjectMapper) client).readValue(json, (TypeReference<? extends T>) type);
            }
        } catch (Exception e) {
            throw new SimpleJsonException(e);
        }
    }

    protected <C> void supportType(C client) {
        if (!(client instanceof ObjectMapper)) {
            throw new SimpleJsonException("type mismatch");
        }
    }

    protected <ValueType> void supportJavaType(ValueType type) {
        if (!(type instanceof JavaType) && !(type instanceof TypeReference)) {
            throw new SimpleJsonException("java type mismatch");
        }
    }
}
