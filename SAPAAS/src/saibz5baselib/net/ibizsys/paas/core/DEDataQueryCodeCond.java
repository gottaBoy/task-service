package net.ibizsys.paas.core;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 实体数据查询代码条件注解
 * 
 * @author Administrator
 *
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DEDataQueryCodeCond {
	/**
	 * 标识
	 * 
	 * @return
	 */
	String id() default "";

	/**
	 * 名称
	 * 
	 * @return
	 */
	String name() default "";

	/**
	 * 条件
	 * 
	 * @return
	 */
	String condition() default "";

}
