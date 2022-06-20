# jsons

java json list (jackson,gson,fastjson)

# maven

```xml

<dependency>
    <groupId>com.hb0730</groupId>
    <artifactId>jsons</artifactId>
    <version>${version}</version>
</dependency>
```

# 已实现

* [jackson](https://github.com/FasterXML/jackson-databind)
* [gson](https://github.com/google/gson)

# use

```java
  TestModel model=SimpleJsonProxy.json.fromJson("{\"name\":\"测试\",\"value\":\"222\"}",TestModel.class);
```

# 优先级
```
FastJson > Gson
```