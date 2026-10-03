package net.ibizsys.paas.codelist;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 代码表注解
 * 
 * @author Administrator
 *
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CodeList {
	/**
	 * 代码表标识
	 * 
	 * @return
	 */
	String id() default "";

	/**
	 * 代码表名称
	 * 
	 * @return
	 */
	String name() default "";

	/**
	 * 代码表类型
	 * 
	 * @return
	 */
	String type() default "";

	/**
	 * 用户范围
	 * 
	 * @return
	 */
	boolean userscope();

	/**
	 * 或模式
	 * 
	 * @return
	 */
	String ormode() default "";

	/**
	 * 值分割符号
	 * 
	 * @return
	 */
	String valueseparator() default ";";

	/**
	 * 文本分割符号
	 * 
	 * @return
	 */
	String textseparator() default "、";

	/**
	 * 空白显示文本
	 * 
	 * @return
	 */
	String emptytext() default "未定义";
}
