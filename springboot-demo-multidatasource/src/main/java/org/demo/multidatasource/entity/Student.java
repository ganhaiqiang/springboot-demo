package org.demo.multidatasource.entity;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;
import lombok.ToString;

@Table(name = "student")
@Data
@ToString
public class Student implements Serializable {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 家庭住址
     */
    private String address;

    private static final long serialVersionUID = 1L;
}