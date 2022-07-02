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
        return doFromJson(json, clazz, client);
    }

    protected abstract <T, C> T doFromJson(String json, Class<T> clazz, C client);

    @Override
    public <T, Type> T fromJson(String json, Type type) {
        return fromJson(json, type, null);
    }

    @Override
    public <T, Type, C> T fromJson(String json, Type type, C client) {
        if (StrUtil.isBlank(json)) {
            return null;
        }
        return doFromJson(json, type, client);
    }

    protected abstract <T, Type, C> T doFromJson(String json, Type type, C client);
}
