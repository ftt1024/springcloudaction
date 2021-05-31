package cn.sf.customer.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class CustomerRequest implements Serializable {
    private String name;
    private Integer gender;
}
