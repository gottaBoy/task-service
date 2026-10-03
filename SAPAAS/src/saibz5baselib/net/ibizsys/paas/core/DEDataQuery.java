package net.ibizsys.paas.core;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 实体数据查询注解
 * 
 * @author Administrator
 *
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DEDataQuery {
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
	 * 是否为默认查询
	 * 
	 * @return
	 */
	boolean defaultmode() default false;
	
	
	
	/**
	 * 视图级别
	 * @return
	 */
	int viewlevel() default -1;
}
