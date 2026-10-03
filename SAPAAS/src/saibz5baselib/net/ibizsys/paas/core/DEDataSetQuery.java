package net.ibizsys.paas.core;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 数据集合查询注解
 * 
 * @author Administrator
 *
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DEDataSetQuery {
	/**
	 * 实体数据集合标识
	 * 
	 * @return
	 */
	String queryid() default "";

	/**
	 * 实体数据集合名称
	 * 
	 * @return
	 */
	String queryname() default "";

}
