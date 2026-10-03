package net.ibizsys.paas.control.grid;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import net.ibizsys.paas.control.Control;
import net.ibizsys.paas.data.DataItem;

/**
 * 表格对象注解
 * 
 * @author Administrator
 *
 */
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Control
public @interface Grid {
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
	String type() default "GRID";

	/**
	 * 表格列模型
	 * 
	 * @return
	 */
	GridColumn[] gridcolumns();

	/**
	 * 表格数据项
	 * 
	 * @return
	 */
	DataItem[] griddataitems();
}
