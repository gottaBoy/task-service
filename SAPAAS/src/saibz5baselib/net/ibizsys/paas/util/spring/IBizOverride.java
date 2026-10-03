package net.ibizsys.paas.util.spring;

/**
 * 重写Spring注解
 * 
 * @author Administrator
 *
 */
public @interface IBizOverride {

	/**
	 * 定义继承类，没有制定则自动计算
	 * 
	 * @return
	 */
	String superclass() default "";
}
