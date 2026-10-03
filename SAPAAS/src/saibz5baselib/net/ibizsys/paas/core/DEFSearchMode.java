package net.ibizsys.paas.core;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 属性搜索模式注解
 * 
 * @author Administrator
 *
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DEFSearchMode {
	/**
	 * 属性标识
	 * 
	 * @return
	 */
	String id() default "";

	/**
	 * 属性名称
	 * 
	 * @return
	 */
	String name() default "";

	/**
	 * 获取值函数标识
	 * 
	 * @return
	 */
	String valuefunc() default "";

	/**
	 * 获取值操作符号标识
	 * 
	 * @return
	 */
	String valueop() default "";
}
