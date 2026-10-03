package net.ibizsys.paas.core;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 实体界面行为注解
 * 
 * @author Administrator
 *
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DEUIAction {
	/**
	 * 实体界面行为标识
	 * 
	 * @return
	 */
	String id() default "";

	/**
	 * 实体界面行为名称
	 * 
	 * @return
	 */
	String name() default "";

	/**
	 * 操作目标
	 * 
	 * @return
	 */
	String actiontarget() default IDEUIAction.ACTIONTARGET_NONE;

	/**
	 * 实体行为名称
	 * 
	 * @return
	 */
	String deactionname() default "";
}
