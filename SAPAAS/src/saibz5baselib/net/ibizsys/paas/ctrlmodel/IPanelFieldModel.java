package net.ibizsys.paas.ctrlmodel;

import net.ibizsys.paas.control.panel.IPanelField;

/**
 * 面板属性项模型对象接口
 * 
 * @author lionlau
 *
 */
public interface IPanelFieldModel extends IPanelField {
	
	/**
	 * 输出代码表配置模式：无
	 */
	final static Integer OUTPUTCODELISTCONFIGMODE_NONE = 0;
	
	
	/**
	 * 输出代码表配置模式：只输出选择项
	 */
	final static Integer OUTPUTCODELISTCONFIGMODE_SELECTEDONLY = 1;
	
	
	/**
	 * 输出代码表配置模式：包括子项
	 */
	final static Integer OUTPUTCODELISTCONFIGMODE_INCLUDECHILD = 2;
	
	
	
	/**
	 * 获取表单模型对象
	 * 
	 * @return
	 */
	IPanelModel getPanelModel();

	/**
	 * 是否输出代码表配置
	 * 
	 * @return
	 */
	boolean isOutputCodeListConfig();
	
	
	/**
	 * 获取输出的代码表配置模式
	 * @return
	 */
	int getOutputCodeListConfigMode();

}
