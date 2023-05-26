package utils;


import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.List;
import java.util.Map;

/**
 * JSON处理工具类
 * @author chengsukai
 */
public class JsonUtil {

    /**
     * 通用ObjectMapper
     */
    public static ObjectMapper mapper = new ObjectMapper();

    static {
        // json->bean ,忽略bean中不存在的属性
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        // 解析器支持解析单引号
        mapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
        // 解析器支持解析特殊字符
        mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);
    }

    /**
     * Bean->JSON bytes
     *
     * @param bean
     * @return JSON bytes
     */
    public static byte[] toJsonBytes(final Object bean) {

        try {
            return mapper.writeValueAsBytes(bean);
        } catch (final JsonProcessingException e) {
            throw new IllegalArgumentException(e);
        }

    }

    /**
     * Bean->JSON
     *
     * @param bean
     * @return JSON
     */
    public static String toJson(final Object bean) {

        if (bean == null) {
            return null;
        }
        try {
            return mapper.writeValueAsString(bean);
        } catch (final JsonProcessingException e) {
            throw new IllegalArgumentException(e);
        }

    }

    /**
     * JSON bytes->BEAN
     *
     * @param json
     *            bytes
     * @param clazz
     * @return bean
     */
    public static <T> T toBean(final byte[] json, final Class<T> clazz) {

        if (null == json) {
            return null;
        }
        try {
            return mapper.readValue(json, clazz);
        } catch (final Exception e) {
            throw new IllegalArgumentException(e);
        }

    }

    /**
     * JSON->BEAN
     *
     * @param json
     * @param clazz
     * @return bean
     */
    public static <T> T toBean(final String json, final Class<T> clazz) {

        if (null == json) {
            return null;
        }
        try {
            return mapper.readValue(json, clazz);
        } catch (final Exception e) {
            throw new IllegalArgumentException(e);
        }

    }

    /**
     * JSON->Bean
     *
     * @param json
     * @param clazz
     * @return bean
     */
    public static <T> T toBean(final String json, final Class<?> clazz, final Class<?>... parameterClasses) {

        if (null == json) {
            return null;
        }
        try {
            return mapper.readValue(json, mapper.getTypeFactory().constructParametricType(clazz, parameterClasses));
        } catch (final Exception e) {
            throw new IllegalArgumentException(e);
        }

    }

    /**
     * JSON->List
     *
     * @param json
     * @param clazz
     * @return list
     */
    public static <T> List<T> toList(final String json, final Class<T> clazz) {

        if (null == json) {
            return null;
        }
        try {
            return mapper.readValue(json, mapper.getTypeFactory().constructCollectionType(List.class, clazz));
        } catch (final Exception e) {
            throw new IllegalArgumentException(e);
        }
    }

    /**
     * Bean->Bean
     *
     * @param source
     * @param target
     * @return target bean
     */
    public static <T> T convertBean(final Object source, final Class<T> target) {

        return toBean(toJson(source), target);
    }

    /**
     * JSON->JsonNode
     *
     * @param json
     * @return JsonNode
     */
    public static JsonNode toJsonNode(final String json) {

        if (null == json) {
            return null;
        }
        try {

            return mapper.readTree(json);
        } catch (final Exception e) {
            throw new IllegalArgumentException(e);
        }
    }

    /*
     * public static <T> ResponseDto<T> toResponseBean(final String json, final Class<T> clazz) {
     * 
     * if (null == json) { return null; } try { return mapper.readValue(json, mapper.getTypeFactory().constructParametricType(ResponseDto.class,
     * clazz)); } catch (final Exception e) { throw new IllegalArgumentException(e); }
     * 
     * }
     */

    public static <T> T convertValue(final Object fromValue, final Class<T> toValueType) {

        return mapper.convertValue(fromValue, toValueType);

    }

    /*
     * public static <T> ReturnMessage<T> toResultBean(final String json, final Class<T> clazz) {
     * 
     * if (null == json) { return null; } try { return mapper.readValue(json, mapper.getTypeFactory().constructParametricType(ReturnMessage.class,
     * clazz)); } catch (final Exception e) { throw new IllegalArgumentException(e); }
     * 
     * }
     * 
     * public static <T> InnerResultMessage<T> toInnerBean(final String json, final Class<T> clazz) {
     * 
     * if (null == json) { return null; } try { return mapper.readValue(json,
     * mapper.getTypeFactory().constructParametricType(InnerResultMessage.class, clazz)); } catch (final Exception e) { throw new
     * IllegalArgumentException(e); }
     * 
     * }
     */

    /**
     * Bean-> mapper
     *
     * @param bean
     * @return JSON bytes
     */
    public static Map toMap(final Object bean) {

        if (bean == null) {
            return null;
        }
        try {
            return mapper.convertValue(bean, Map.class);
        } catch (final Exception e) {
            throw new IllegalArgumentException(e);
        }

    }

    public static <T> T toResultBean(final String json, final Class<T> clazz, final JavaType... javaType) {

        if (null == json) {
            return null;
        }
        try {
            return mapper.readValue(json, mapper.getTypeFactory().constructParametricType(clazz, javaType));
        } catch (final Exception e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static <T> T toResultBean(final String json, final TypeReference<T> typeReference) {

        if (null == json) {
            return null;
        }
        try {
            return mapper.readValue(json, typeReference);
        } catch (final Exception e) {
            throw new IllegalArgumentException(e);
        }
    }

}
