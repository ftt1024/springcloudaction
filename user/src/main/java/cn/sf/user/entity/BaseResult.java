package cn.sf.user.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BaseResult implements Serializable {
    private String code;
    private String message;
    private Object data;

    public static BaseResult fail(String code, String message) {
        return BaseResult.builder().code(code).message(message).build();
    }
}
