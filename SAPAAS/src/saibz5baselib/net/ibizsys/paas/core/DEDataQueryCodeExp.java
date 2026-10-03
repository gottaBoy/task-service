package net.ibizsys.paas.core;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 实体数据查询表达式注解
 * 
 * @author Administrator
 *
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DEDataQueryCodeExp {
	/**
	 * 标识
	 * 
	 * @return
	 */
	String id() default "";

	/**
	 * 实体属性名称
	 * 
	 * @return
	 */
	String name() default "";

	/**
	 * 表单式
	 * 
	 * @return
	 */
	String expression() default "";

	/**
	 * 排序值
	 * 
	 * @return
	 */
	int showorder() default 0;
}
