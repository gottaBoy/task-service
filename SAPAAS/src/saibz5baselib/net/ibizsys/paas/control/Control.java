package net.ibizsys.paas.control;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 部件注解
 * 
 * @author Administrator
 *
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Control {

	/**
	 * 控件名称
	 * 
	 * @return
	 */
	String name() default "";

	/**
	 * 控件类型
	 * 
	 * @return
	 */
	String type() default "";
}
