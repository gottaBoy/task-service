package net.ibizsys.paas.core;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 实体数据查询代码注解
 * 
 * @author Administrator
 *
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DEDataQueryCode {

	/**
	 * 数据库类型
	 * 
	 * @return
	 */
	String dbtype() default "";

	/**
	 * 查询代码
	 * 
	 * @return
	 */
	String querycode() default "";

	/**
	 * 查询代码临时
	 * 
	 * @return
	 */
	String querycodetemp() default "";

	/**
	 * 查询代码
	 * 
	 * @return
	 */
	String declarecode() default "";

	/**
	 * 属性表达式
	 * 
	 * @return
	 */
	DEDataQueryCodeExp[] fieldexps();

	/**
	 * 附加条件
	 * 
	 * @return
	 */
	DEDataQueryCodeCond[] conds();
}
