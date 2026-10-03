package net.ibizsys.paas.core;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 实体逻辑注解
 * 
 * @author Administrator
 *
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DELogic {
	/**
	 * 实体逻辑标识
	 * 
	 * @return
	 */
	String id() default "";

	/**
	 * 实体逻辑名称
	 * 
	 * @return
	 */
	String name() default "";

}
