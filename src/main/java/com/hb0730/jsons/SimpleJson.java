package com.hb0730.jsons;

import java.lang.reflect.Type;

/**
 * 对实现的方法定义
 *
 * @author <a href="mailto:huangbing0730@gmail">hb0730</a>
 * @date 2022/6/18
 * @since 1.0.0
 */
public interface SimpleJson {
    /**
     * 获取实现的core class
     * <ul>
     *     <li>jackson->{@link  com.fasterxml.jackson.databind.ObjectMapper}</li>
     *     <li>gson->{@link  com.google.gson.Gson}</li>
     *     <li>fastJson->{@link  com.alibaba.fastjson.JSON}</li>
     *     <li>fastJson2 -> {@link  com.alibaba.fastjson2.JSON}</li>
     * </ul>
     *
     * @param <C> core class type
     * @return json core class
     */
    <C> C getClient();

    /**
     * 设置 核心类
     * <ul>
     *     <li>jackson->{@link  com.fasterxml.jackson.databind.ObjectMapper}</li>
     *     <li>gson->{@link  com.google.gson.Gson}</li>
     *     <li>fastJson->{@link  com.alibaba.fastjson.JSON}</li>
     *     <li>fastJson2 -> {@link  com.alibaba.fastjson2.JSON}</li>
     * </ul>
     *
     * @param client core class
     * @param <C>    json core class
     */
    <C> void setClient(C client);

    /**
     * to json string
     *
     * @param obj object
     * @return json string
     */
    String toJson(Object obj);

    /**
     * to json string
     * <ul>
     *     <li>jackson->{@link  com.fasterxml.jackson.databind.ObjectMapper}</li>
     *     <li>gson->{@link  com.google.gson.Gson}</li>
     *     <li>fastJson->{@link  com.alibaba.fastjson.JSON}</li>
     *     <li>fastJson2 -> {@link  com.alibaba.fastjson2.JSON}</li>
     * </ul>
     *
     * @param obj    object
     * @param client core class
     * @param <C>    core class type
     * @return json string
     */
    <C> String toJson(Object obj, C client);

    /**
     * json string to Object
     *
     * @param json  json string
     * @param clazz object class
     * @param <T>   object class type
     * @return Object
     */
    <T> T fromJson(String json, Class<T> clazz);

    /**
     * json string to Object
     *
     * @param json   json string
     * @param clazz  object class
     * @param client core class
     * @param <T>    object class type
     * @param <C>    core class type
     * @return Object
     */
    <T, C> T fromJson(String json, Class<T> clazz, C client);

    /**
     * json string to Object
     *
     * @param json json string
     * @param type Object type
     * @param <T>  Object type
     * @return Object
     */
    <T> T fromJson(String json, Type type);

    /**
     * json string to Object
     *
     * @param json   json string
     * @param type   Object type
     * @param client core class
     * @param <T>    Object type
     * @param <C>    core class
     * @return Object
     */
    <T, C> T fromJson(String json, Type type, C client);
}
