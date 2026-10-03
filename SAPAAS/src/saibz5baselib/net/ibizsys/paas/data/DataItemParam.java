package net.ibizsys.paas.data;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 数据项参数注解
 * 
 * @author Administrator
 *
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataItemParam {
	/**
	 * 获取格式化
	 * 
	 * @return
	 */
	String format() default "";

	/**
	 * 名称
	 * 
	 * @return
	 */
	String name() default "";

	/**
	 * 获取默认值
	 * 
	 * @return
	 */
	String defaultvalue() default "";

	/**
	 * @return
	 */
	String codelistid() default "";
}
