package cn.sf.user.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserBO implements Serializable {
    private String code;
    private String name;
    private String sex;
    private Date birthDate;
    private Integer cnType;
    private String cn;
}
