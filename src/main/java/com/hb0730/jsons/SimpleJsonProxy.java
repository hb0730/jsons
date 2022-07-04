package com.hb0730.jsons;

import com.hb0730.jsons.support.gson.GsonImpl;
import com.hb0730.jsons.support.jackson.JacksonImpl;
import com.hb0730.jsons.support.jsonb.JsonbImpl;
import com.hb0730.jsons.util.ClassUtil;
import com.hb0730.jsons.util.Impls;

/**
 * @author <a href="mailto:huangbing0730@gmail">hb0730</a>
 * @date 2022/6/20
 * @since 1.0.0
 */
public class SimpleJsonProxy implements SimpleJson {
    public static SimpleJsonProxy json = new SimpleJsonProxy();
    private static SimpleJson proxy;

    private void selectJsonProxy() {
        SimpleJson defaultJson = null;
        ClassLoader classLoader = SimpleJsonProxy.class.getClassLoader();
        if (ClassUtil.isPresent(Impls.JACKSON.getValue(), classLoader)) {
            defaultJson = getProxy(JacksonImpl.class);
        } else if (ClassUtil.isPresent(Impls.GSON.getValue(), classLoader)) {
            defaultJson = getProxy(GsonImpl.class);
        } else if (ClassUtil.isPresent(Impls.JSONB.getValue(), classLoader)) {
            defaultJson = getProxy(JsonbImpl.class);
        }
        if (defaultJson == null) {
            throw new SimpleJsonException("Has no JsonImpl defined in environment!");
        }
        proxy = defaultJson;
    }

    private <T extends SimpleJson> T getProxy(Class<T> clazz) {
        try {
            return clazz.newInstance();
        } catch (Exception e) {
            return null;
        }
    }

    private synchronized void checkProxyNotNull(SimpleJson proxy) {
        if (null == proxy) {
            selectJsonProxy();
        }
    }

    /**
     * set jsonImpl
     *
     * @param json jsonImpl
     * @return this
     */
    public SimpleJsonProxy setJson(SimpleJson json) {
        proxy = json;
        return this;
    }

    @Override
    public <C> C getClient() {
        checkProxyNotNull(proxy);
        return proxy.getClient();
    }

    @Override
    public <C> void setClient(C client) {
        checkProxyNotNull(proxy);
        proxy.setClient(client);
    }

    @Override
    public String toJson(Object obj) {
        checkProxyNotNull(proxy);
        return proxy.toJson(obj);
    }

    @Override
    public <C> String toJson(Object obj, C client) {
        checkProxyNotNull(proxy);
        return proxy.toJson(obj, client);
    }

    @Override
    public <T> T fromJson(String json, Class<T> clazz) {
        checkProxyNotNull(proxy);
        return proxy.fromJson(json, clazz);
    }

    @Override
    public <T, C> T fromJson(String json, Class<T> clazz, C client) {
        checkProxyNotNull(proxy);
        return proxy.fromJson(json, clazz, client);
    }

    @Override
    public <T, Type> T fromJson(String json, Type type) {
        checkProxyNotNull(proxy);
        return proxy.fromJson(json, type);
    }

    @Override
    public <T, Type, C> T fromJson(String json, Type type, C client) {
        checkProxyNotNull(proxy);
        return proxy.fromJson(json, type, client);
    }
}
