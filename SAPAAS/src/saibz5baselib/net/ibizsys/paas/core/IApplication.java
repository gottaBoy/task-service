package net.ibizsys.paas.core;

/**
 * 应用程序接口
 * 
 * @author lionlau
 *
 */
public interface IApplication extends ISystemObject {
	
	
	/**
	 * 应用程序类型：未知
	 */
	public final static int APPTYPE_UNKNOWN = 0;
	
	
	/**
	 * 应用程序类型：桌面端应用程序
	 */
	public final static int APPTYPE_DESKTOP = 1;
	
	
	/**
	 * 应用程序类型：移动端应用程序
	 */
	public final static int APPTYPE_MOBILE = 2;
	
	
	/**
	 * ExtJS5 技术
	 */
	public final static String PF_EXTJS5 = "EXTJS5";

	/**
	 * JQuery技术
	 */
	public final static String PF_JQUERY = "JQUERY";

	/**
	 * JQuery技术(R2)
	 */
	public final static String PF_JQUERY_R2 = "JQUERY_R2";

	/**
	 * AngularJS技术
	 */
	public final static String PF_ANGULARJS = "ANGULARJS";
	
	
	/**
	 * Angular2（含2.0 以上版本） 技术
	 */
	public final static String PF_ANGULAR = "ANGULAR";
	
	
	/**
	 * Ionic 技术
	 */
	public final static String PF_IONIC = "IONIC";
	
	/**
	 * Vue 技术
	 */
	public final static String PF_VUE = "VUE";
	
	
	/**
	 * VueMob 技术
	 */
	public final static String PF_VUEMOB = "VUEMOB";

	
	/**
	 * Vue 技术(R2)
	 */
	public final static String PF_VUE_R2 = "VUE_R2";
	
	
	/**
	 * VueMob 技术(R2)
	 */
	public final static String PF_VUEMOB_R2 = "VUEMOB_R2";
	

	/**
	 * React 技术
	 */
	public final static String PF_REACT = "REACT";
	
	
	/**
	 * ReactMob 技术
	 */
	public final static String PF_REACTMOB = "REACTMOB";
	
	
	/**
	 * Vue 技术(R3)
	 */
	public final static String PF_VUE_R3 = "VUE_R3";
	
	
	/**
	 * Ionic 技术
	 */
	public final static String PF_IONIC4_R6 = "IONIC4_R6";
	
	/**
	 * 获取系统
	 * 
	 * @return
	 */
	ISystem getSystem();

	/**
	 * 获取应用技术
	 * 
	 * @return
	 */
	String getPFType();

}
