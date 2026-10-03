package net.ibizsys.paas.core;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 实体属性注解
 * 
 * @author Administrator
 *
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DEField {
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
	 * 属性逻辑名称
	 * 
	 * @return
	 */
	String logicname() default "";

	/**
	 * 数据类型
	 * 
	 * @return
	 */
	String datatype() default "";

	/**
	 * 标准数据类型
	 * 
	 * @return
	 */
	int stddatatype() default 0;

	/**
	 * 属性搜索模型
	 * 
	 * @return
	 */
	DEFSearchMode[] defsearchmodes();

	/**
	 * 主键属性
	 * 
	 * @return
	 */
	boolean keyfield() default false;

	/**
	 * 主属性
	 * 
	 * @return
	 */
	boolean majorfield() default false;

	/**
	 * 链接属性
	 * 
	 * @return
	 */
	boolean linkfield() default false;

	/**
	 * 属性的预定义类型
	 */
	String pdt() default "";

	/**
	 * 公式属性
	 * 
	 * @return
	 */
	boolean formulafield() default false;

	/**
	 * 物理化属性
	 * 
	 * @return
	 */
	boolean phisicalfield() default true;

	/**
	 * 继承属性
	 * 
	 * @return
	 */
	boolean inheritfield() default false;

}
