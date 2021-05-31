package cn.sf.user.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import static org.apache.commons.lang.StringUtils.isBlank;

@Slf4j
public class ObjectUtil {
    private static final ObjectMapper OM = new ObjectMapper();

    public static String toJson(Object o) {
        if (o == null) {
            return "{}";
        }
        try {
            return OM.writeValueAsString(o);
        } catch (JsonProcessingException e) {
            log.error("Fail to convert object to json: {}", o, e);
        }
        return "{}";
    }

    public static <T> Object fromJson(String json, Class<T> tClass) {
        if (isBlank(json)) {
            return null;
        }
        try {
           return OM.readValue(json, tClass);
        } catch (JsonProcessingException e) {
            log.error("Fail to convert json to object: {}", json, e);
        }
        return null;
    }
}
