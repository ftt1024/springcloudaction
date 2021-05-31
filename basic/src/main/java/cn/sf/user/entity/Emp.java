package cn.sf.user.entity;

import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author sf
 * @since 2021-05-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Emp implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户编号
     */
    private String code;

    /**
     * 密码
     */
    private String password;

    /**
     * 用户名
     */
    private String name;

    /**
     * 性别
     */
    private String sex;

    /**
     * 出生日期
     */
    private LocalDateTime birthDate;

    /**
     * 0：身份证	             1：护照	            2：香港居民身份证	             3：回乡证	             4：台湾身份证5：台胞证6：外国人永久居留证
     */
    private Integer cnType;

    /**
     * 证件号
     */
    private String cn;

    /**
     * 手机号码
     */
    private String mobile;

    /**
     * 办公电话
     */
    private String homePhone;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 最高学历
     */
    private String lastDeucation;

    /**
     * 最高学位
     */
    private String degreeName;

    /**
     * 参加工作时间
     */
    private LocalDateTime joinworkDate;

    /**
     * 员工系统状态 在职,不在职
     */
    private String enableState;

    /**
     * 员工人力状态1：入职	                        2：转正	                        3：调配	                        4：离职	          
     */
    private String trnsevent;

    /**
     * 合同类型
     */
    private String psnType;

    /**
     * 入职时间
     */
    private LocalDateTime creanTime;

    /**
     * 离职时间
     */
    private LocalDateTime retireDate;

    /**
     * 劳动合同主体
     */
    private String majorCorp;

    /**
     * 部门全路径名称
     */
    private String deptName;

    /**
     * 称谓
     */
    private String jobGlbdef1;

    /**
     * 岗位名称
     */
    private String postName;

    /**
     * 岗位序列
     */
    private String seq;

    /**
     * 职务名称
     */
    private String jobName;

    /**
     * 职务类别
     */
    private String jobTypeName;

    /**
     * 职级
     */
    private String jobGradeName;

    /**
     * 职等
     */
    private String jobRankName;

    /**
     * 无用字段
     */
    private String isPass;

    /**
     * 数据生成时间
     */
    private LocalDateTime ts;

    /**
     * 年龄
     */
    private String age;

    /**
     * 上级组织编码
     */
    private String orgCode;

    /**
     * 上级组织
     */
    private String pkOrg;

    /**
     * 负责人
     */
    private String superior;

    /**
     * 分管领导
     */
    private String leader;

    /**
     * 部门编号
     */
    private String deptCode;

    /**
     * 岗位编号
     */
    private String postCode;

    /**
     * 职务编号
     */
    private String jobCode;

    /**
     * 头像链接
     */
    private String portraitUrl;

    /**
     * 名片
     */
    private String mp;

    /**
     * 创建人
     */
    private String createId;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 修改人
     */
    private String updateId;

    /**
     * 修改时间
     */
    private LocalDateTime updateTime;

    /**
     * 员工所属区域
     */
    private String lcsszbm;

    /**
     * 证书
     */
    private String lcsgrzs;

    /**
     * 简介
     */
    private String grjj;

    /**
     * 前后台
     */
    private String qht;

    /**
     * 是否通过基金 从业资格考试 Y:是 N:否
     */
    private String cyzg;

    /**
     * 理顾宝存放照片路径字段
     */
    private String portraitUrlRichgo;

    /**
     * 微信二维码
     */
    private String wechatQrCode;

    /**
     * title称号类型 0：岗位;1：职级;2：荣誉称号;3：隐藏
     */
    private Integer titleType;

    /**
     * title称号
     */
    private String titleValue;

    /**
     * 名片头像路径
     */
    private String mpPortraitUrl;

    /**
     * 手机号是否显示 0：否;1：是
     */
    private Integer mobileIsShow;

    /**
     * 微信号
     */
    private String wechatId;

    /**
     * 理顾类型：6-预离职
     */
    private Integer status;

    /**
     * 理顾头像连接（无权限服务器）
     */
    private String portraitUrlNoAuth;

    /**
     * 头像状态【1-可用】【0-不可用】（无权限）
     */
    private Integer portraitNoAuthStatus;

    /**
     * 民族
     */
    private String mz;

    /**
     * 政治面貌
     */
    private String zzmm;

    /**
     * 户口性质
     */
    private String hkxz;

    /**
     * 特殊人才类别
     */
    private String tsrc;

    /**
     * （人资）特殊人才类别
     */
    private String rztsrc;

    /**
     * 分总/中心总
     */
    private String principal;


}
