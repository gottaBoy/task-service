package net.ibizsys.paas.core;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 实体数据库过程参数
 * 
 * @author lionlau
 *
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DBProcParam {
	/**
	 * 参数名称
	 * 
	 * @return
	 */
	String name() default "";

	/**
	 * 参数名称
	 * 
	 * @return
	 */
	String outputname() default "";

	/**
	 * 参数方向
	 * 
	 * @return
	 */
	int dir() default 1;

	/**
	 * 数据类型
	 * 
	 * @return
	 */
	int datatype() default 0;

}
