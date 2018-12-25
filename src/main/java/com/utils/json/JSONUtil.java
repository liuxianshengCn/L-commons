package com.utils.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author Mr.L
 * @Date $2018-12-25 09:42
 * @Description JSON工具类
 */
@Slf4j
public final class JSONUtil {

    /**
     * 对象转JSON字符串
     *
     * @param object
     * @return
     */
    public static String objectToJsonString(Object object) {
        String result = null;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            result = objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            log.error(object.getClass().getName() + "转String失败", e);
        }
        return result;
    }

    /**
     * json字符串转对象
     *
     * @param json
     * @param classz
     * @param <T>
     * @return
     */
    public static <T> T stringToObject(String json, Class<T> classz) {
        T object = null;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            object = objectMapper.readValue(json, classz);
        } catch (IOException e) {
            log.error(json + "转" + classz.getName() + "失败", e);
        }

        return object;
    }

    /**
     * json字符串转对象
     *
     * @param json
     * @param classz
     * @param <T>
     * @return
     */
    public static <T> List<T> stringToArray(String json, Class<T> classz) {
        List<T> object = null;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JavaType javaType =
                objectMapper.getTypeFactory().constructParametricType(ArrayList.class, classz);
            object = objectMapper.readValue(json, javaType);
        } catch (IOException e) {
            log.error(json + "转" + classz.getName() + "失败", e);
        }

        return object;
    }

    public static void main(String[] args) {
        BigDecimal amount = new BigDecimal(10000);
        Double pro = 30d / 100;
        BigDecimal proa = new BigDecimal(pro.toString());
        BigDecimal lockAmount = amount.multiply(proa).setScale(8, BigDecimal.ROUND_DOWN);
        System.out.println(lockAmount);
    }

}
