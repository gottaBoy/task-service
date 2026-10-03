package net.ibizsys.paas.control.grid;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 表格列对象注解
 * 
 * @author Administrator
 *
 */
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface GridColumn {
	/**
	 * 获取标题
	 * 
	 * @return
	 */
	String caption();

	/**
	 * 获取数据项名称
	 * 
	 * @return
	 */
	String dataitemname();
}
