package com.hb0730.jsons.support;

import cn.hutool.core.util.StrUtil;
import com.hb0730.jsons.SimpleJson;

/**
 * @author <a href="mailto:huangbing0730@gmail">hb0730</a>
 * @date 2022/7/2
 * @since 1.0.1
 */
public abstract class AbstractSimpleJson implements SimpleJson {
    @Override
    public String toJson(Object obj) {
        return toJson(obj, null);
    }

    @Override
    public <C> String toJson(Object obj, C client) {
        if (null == obj) {
            return null;
        }
        if (null != client) {
            supportType(client);
        }
        return doToJson(obj, client);
    }

    protected abstract <C> String doToJson(Object obj, C client);

    @Override
    public <T> T fromJson(String json, Class<T> clazz) {
        return this.fromJson(json, clazz, null);
    }

    @Override
    public <T, C> T fromJson(String json, Class<T> clazz, C client) {
        if (StrUtil.isBlank(json)) {
            return null;
        }
        if (null != client) {
            supportType(client);
        }
        return doFromJson(json, clazz, client);
    }

    protected abstract <T, C> T doFromJson(String json, Class<T> clazz, C client);

    @Override
    public <T, ValueType> T fromJson(String json, ValueType type) {
        return fromJson(json, type, null);
    }

    @Override
    public <T, ValueType, C> T fromJson(String json, ValueType type, C client) {
        if (StrUtil.isBlank(json)) {
            return null;
        }
        supportJavaType(type);
        if (null != client) {
            supportType(client);
        }
        return doFromJson(json, type, client);
    }

    protected abstract <T, ValueType, C> T doFromJson(String json, ValueType type, C client);

    /**
     * 是否为支持的客户端类型
     *
     * @param client 客户端类型
     * @param <C>    客户端类型
     */
    protected abstract <C> void supportType(C client);

    /**
     * 是否为支持的Java序列化类型
     *
     * @param type       java 类型
     * @param <ValueType> java 类型
     */
    protected abstract <ValueType> void supportJavaType(ValueType type);
}
