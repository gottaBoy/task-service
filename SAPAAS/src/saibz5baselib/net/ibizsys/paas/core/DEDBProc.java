package net.ibizsys.paas.core;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 实体数据库过程注解
 * 
 * @author lionlau
 *
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DEDBProc {
	/**
	 * 过程名称
	 * 
	 * @return
	 */
	String id() default "";

	/**
	 * 过程名称
	 * 
	 * @return
	 */
	String name() default "";

	/**
	 * 过程名称
	 * 
	 * @return
	 */
	String procname() default "";

	/**
	 * 超时
	 * 
	 * @return
	 */
	int timeout() default -1;

}
