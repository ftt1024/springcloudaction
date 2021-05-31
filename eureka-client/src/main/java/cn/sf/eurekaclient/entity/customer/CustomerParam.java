package cn.sf.eurekaclient.entity.customer;

import lombok.Data;

import java.io.Serializable;

@Data
public class CustomerParam implements Serializable {
    private String name;
    private Integer gender;
}
