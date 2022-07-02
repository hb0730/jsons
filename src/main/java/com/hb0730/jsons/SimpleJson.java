package com.hb0730.jsons;

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
     * @return json string,可能为空
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
     * @return json string,可能为空
     */
    <C> String toJson(Object obj, C client);

    /**
     * json string to Object
     *
     * @param json  json string
     * @param clazz object class
     * @param <T>   object class type
     * @return Object,可能为空
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
     * @return Object,可能为空
     */
    <T, C> T fromJson(String json, Class<T> clazz, C client);


    /**
     * json string to Object
     *
     * @param json   json字符串
     * @param type   复杂类型,比如:{@link  java.lang.reflect.Type},{@link  com.fasterxml.jackson.core.type.TypeReference}
     * @param <T>    结果类型
     * @param <Type> 复杂类型
     * @return Object,可能为空
     */
    <T, Type> T fromJson(String json, Type type);

    /**
     * json string to Object
     *
     * @param json   json字符串
     * @param type   复杂类型,比如:{@link  java.lang.reflect.Type},{@link  com.fasterxml.jackson.core.type.TypeReference}
     * @param client json客户端
     * @param <T>    结果类型
     * @param <C>    json客户端类型
     * @param <Type> 复杂类型
     * @return Object,可能为空
     */
    <T, Type, C> T fromJson(String json, Type type, C client);
}
