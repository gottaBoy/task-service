package net.ibizsys.paas.core;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import net.ibizsys.paas.data.DataItem;

/**
 * 实体自填模式注解
 * 
 * @author Administrator
 *
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DEACMode {
	/**
	 * 实体自动填充标识
	 * 
	 * @return
	 */
	String id() default "";

	/**
	 * 实体自动填充名称
	 * 
	 * @return
	 */
	String name() default "";

	/**
	 * 数据项集合
	 * 
	 * @return
	 */
	DataItem[] dataitems();

	/**
	 * 默认模式
	 * 
	 * @return
	 */
	boolean defaultmode() default false;
}
