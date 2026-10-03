package net.ibizsys.paas.core;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 实体数据集合注解
 * 
 * @author Administrator
 *
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DEDataSet {
	/**
	 * 实体数据集合标识
	 * 
	 * @return
	 */
	String id() default "";

	/**
	 * 实体数据集合名称
	 * 
	 * @return
	 */
	String name() default "";

	/**
	 * 查询集合
	 * 
	 * @return
	 */
	DEDataSetQuery[] queries();


	
}
