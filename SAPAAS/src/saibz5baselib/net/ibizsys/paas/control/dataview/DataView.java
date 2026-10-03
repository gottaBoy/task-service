package net.ibizsys.paas.control.dataview;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import net.ibizsys.paas.control.Control;
import net.ibizsys.paas.data.DataItem;

/**
 * 数据视图注解
 * 
 * @author Administrator
 *
 */
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Control
public @interface DataView {
	/**
	 * 名称
	 * 
	 * @return
	 */
	String name() default "";

	/**
	 * 类型
	 * 
	 * @return
	 */
	String type() default "DATAVIEW";

	/**
	 * 数据项结合
	 * 
	 * @return
	 */
	DataItem[] dataitems();
}
