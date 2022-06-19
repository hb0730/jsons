package com.hb0730.jsons.gson;

import com.fasterxml.jackson.core.type.TypeReference;
import com.hb0730.jsons.model.TestModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class GsonImplTest {
    private static final Logger logger = LogManager.getLogger(GsonImplTest.class);
    GsonImpl gson = new GsonImpl();


    @Test
    void toJsonTest() {
        TestModel model = new TestModel();
        model.setName("测试");
        model.setValue("222");
        String json = gson.toJson(model);
        logger.info(json);
    }

    @Test
    void toJsonListTest() {
        List<TestModel> models = new ArrayList<>();
        TestModel model1 = new TestModel();
        model1.setValue("1");
        model1.setName("c1");
        models.add(model1);
        TestModel model2 = new TestModel();
        model2.setValue("2");
        model2.setName("c2");
        models.add(model2);
        String json = gson.toJson(models);
        logger.info(json);
    }

    @Test
    void fromJsonTest() {
        TestModel model = gson.fromJson("{\"name\":\"测试\",\"value\":\"222\"}", TestModel.class);
        Assertions.assertNotNull(model);
        logger.info(model.toString());
    }

    @Test
    void fromJsonJavaTypeTest() {
        List<TestModel> model = gson.fromJson("[{\"name\":\"c1\",\"value\":\"1\"},{\"name\":\"c2\",\"value\":\"2\"}]",
            new TypeReference<List<TestModel>>() {
            }.getType());
        Assertions.assertNotNull(model);
        logger.info(model.toString());
    }

}
