package net.ibizsys.paas.view;

import net.ibizsys.paas.control.Control;

/**
 * 视图注解
 * 
 * @author Administrator
 *
 */
public @interface View {
	public String id() default "";

	public String name() default "";

	public Control[] controls();
}
