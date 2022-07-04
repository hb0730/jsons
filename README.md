<h1 align="center"><a href="https://github.com/hb0730/jsons" target="_blank">jsons</a></h1>
<p align="center">
<a href="https://search.maven.org/artifact/com.hb0730/jsons">
<img alt="Maven Central" src="https://img.shields.io/maven-central/v/com.hb0730/jsons?style=flat-square">
</a>
<a href="https://github.com/hb0730/jsons/blob/master/LICENSE">
<img alt="GitHub" src="https://img.shields.io/github/license/hb0730/jsons?style=flat-square">
</a>
<a href="https://github.com/hb0730/jsons/actions">
<img alt="GitHub Workflow Status" src="https://img.shields.io/github/workflow/status/hb0730/jsons/Tag%20Release?style=flat-square">
</a>
<a href="https://www.oracle.com/java/technologies/javase-downloads.html">
<img alt="jdk" src="https://img.shields.io/badge/jdk-8%2B-green?style=flat-square">
</a>
</p>

# jsons

java json list (jackson,gson ...)

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
* [jsonb](https://github.com/eclipse-ee4j/jsonb-api)

# use

```java
  TestModel model=SimpleJsonProxy.json.fromJson("{\"name\":\"测试\",\"value\":\"222\"}",TestModel.class);
```

# 优先级

```
Jackson > Gson > jsonb
```

# 注意
## JsonB
`JSON-B` 是一个标准绑定层，用于将 Java 对象转换为 JSON 消息/从 JSON 消息转换

`Yasson` 是 `JSON Binding` 的官方参考实现,所以使用`JSON-B`时需要额外依赖
```xml
<dependency>
    <groupId>org.eclipse</groupId>
    <artifactId>yasson</artifactId>
    <version>2.0.4</version>
</dependency>
```
