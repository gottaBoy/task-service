package net.ibizsys.paas.codelist;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 代码项注解
 * 
 * @author Administrator
 *
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CodeItem {
	/**
	 * 值
	 * 
	 * @return
	 */
	String value();

	/**
	 * 父值
	 * 
	 * @return
	 */
	String parentvalue() default "";

	/**
	 * 文本
	 * 
	 * @return
	 */
	String text() default "";

	/**
	 * 实际文本
	 * 
	 * @return
	 */
	String realtext();

	/**
	 * 颜色
	 * 
	 * @return
	 */
	String color() default "";

	/**
	 * 图标路径
	 * 
	 * @return
	 */
	String iconpath() default "";

	/**
	 * 图标路径倍数格式化
	 * 
	 * @return
	 */
	String iconpathx() default "";

	/**
	 * 图标样式名称
	 * 
	 * @return
	 */
	String iconcls() default "";

	/**
	 * 样式名称倍数格式化
	 * 
	 * @return
	 */
	String iconclsx() default "";

	/**
	 * 文本显示样式名称
	 * 
	 * @return
	 */
	String textcls() default "";

	/**
	 * 用户自定义数据
	 * 
	 * @return
	 */
	String userdata() default "";

	/**
	 * 用户自定义数据2
	 * 
	 * @return
	 */
	String userdata2() default "";

	/**
	 * 禁止选中
	 * 
	 * @return
	 */
	boolean disableselect() default false;
	
	
	
	/**
	 * 文本语言资源标识
	 * 
	 * @return
	 */
	String textlanrestag() default "";
}
