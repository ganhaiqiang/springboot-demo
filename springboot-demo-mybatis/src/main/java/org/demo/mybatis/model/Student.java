package org.demo.mybatis.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;
import tk.mybatis.mapper.annotation.KeySql;
import tk.mybatis.mapper.code.IdentityDialect;

@Data
@ToString
@Table(name = "student")
public class Student implements Serializable {
	/**
	 * 主键
	 */
	@Id
	@KeySql(useGeneratedKeys = true, dialect = IdentityDialect.MYSQL)
	@Column(name = "id")
	private Integer id;

	/**
	 * 姓名
	 */
	@Column(name = "name")
	private String name;

	/**
	 * 年龄
	 */
	@Column(name = "age")
	private Integer age;

	private static final long serialVersionUID = 1L;
}