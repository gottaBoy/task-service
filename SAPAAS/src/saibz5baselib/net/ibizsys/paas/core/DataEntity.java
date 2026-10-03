package net.ibizsys.paas.core;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 实体对象模型注解
 * 
 * @author Administrator
 *
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataEntity {
	/**
	 * 实体标识
	 * 
	 * @return
	 */
	String id() default "";

	/**
	 * 实体名称
	 * 
	 * @return
	 */
	String name() default "";

	/**
	 * 实体逻辑名称
	 * 
	 * @return
	 */
	String logicname() default "";

	/**
	 * 表名词
	 * 
	 * @return
	 */
	String tablename() default "";

	/**
	 * 视图名称
	 * 
	 * @return
	 */
	String viewname() default "";

	/**
	 * 逻辑有效
	 * 
	 * @return
	 */
	boolean logicvalid() default false;

	/**
	 * 有效值
	 * 
	 * @return
	 */
	String validvalue() default "1";

	/**
	 * 无效值
	 * 
	 * @return
	 */
	String invalidvalue() default "0";
}
