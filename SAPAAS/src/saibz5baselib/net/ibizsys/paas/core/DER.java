package net.ibizsys.paas.core;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 实体关系注解
 * 
 * @author Administrator
 *
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DER {
	/**
	 * 关系标识
	 * 
	 * @return
	 */
	String id() default "";

	/**
	 * 关系名称
	 * 
	 * @return
	 */
	String name() default "";

	/**
	 * 类型
	 * 
	 * @return
	 */
	String type() default "";

	/**
	 * 主实体标识
	 * 
	 * @return
	 */
	String majordeid() default "";

	/**
	 * 主实体名称
	 * 
	 * @return
	 */
	String majordename() default "";

	/**
	 * 从实体标识
	 * 
	 * @return
	 */
	String minordeid() default "";

	/**
	 * 从实体名称
	 * 
	 * @return
	 */
	String minordename() default "";

	/**
	 * 关系属性
	 * 
	 * @return
	 */
	String pickupdefname() default "";

	/**
	 * 主从关系
	 * 
	 * @return
	 */
	int masterrs() default 0;

	/**
	 * 索引值
	 * 
	 * @return
	 */
	String indexvalue() default "";
}
