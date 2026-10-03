package net.ibizsys.paas.core;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 存储过程参数集合注解
 * 
 * @author Administrator
 *
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DBProcParams {
	/**
	 * 数据库类型
	 * 
	 * @return
	 */
	String dbtype() default "";

	/**
	 * 参数集合
	 * 
	 * @return
	 */
	DBProcParam[] value();
}
