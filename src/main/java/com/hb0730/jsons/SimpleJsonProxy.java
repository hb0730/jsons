package com.hb0730.jsons;

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
        ClassLoader classLoader = SimpleJsonProxy.class.getClassLoader();
        Impls[] values = Impls.values();
        SimpleJson defaultJson = null;
        for (Impls value : values) {
            String clazzName = value.getValue();
            if (ClassUtil.isPresent(clazzName, classLoader)) {
                defaultJson = getProxy(value.getCalzz());
                break;
            }
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
    public <T, ValueType> T fromJson(String json, ValueType type) {
        checkProxyNotNull(proxy);
        return proxy.fromJson(json, type);
    }

    @Override
    public <T, ValueType, C> T fromJson(String json, ValueType type, C client) {
        checkProxyNotNull(proxy);
        return proxy.fromJson(json, type, client);
    }
}
