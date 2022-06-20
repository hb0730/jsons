package com.hb0730.jsons;

import com.hb0730.jsons.model.TestModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

class SimpleJsonProxyTest {
    private static final Logger logger = LogManager.getLogger(SimpleJsonProxyTest.class);

    @Test
    void simpleJsonProxyTest() {
        TestModel model = SimpleJsonProxy.json.fromJson("{\"name\":\"测试\",\"value\":\"222\"}", TestModel.class);
        logger.info(model.toString());
    }
}
