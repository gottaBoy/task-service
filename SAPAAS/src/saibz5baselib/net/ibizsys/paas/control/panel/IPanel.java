package net.ibizsys.paas.control.panel;

import net.ibizsys.paas.control.IControl;

/**
 * 面板部件接口
 * 
 * @author lionlau
 *
 */
public interface IPanel extends IControl {

	

	/**
	 * 获取面板项集合
	 * 
	 * @return
	 */
	java.util.Iterator<IPanelField> getPanelFields();

	/**
	 * 获取指定面板属性
	 * 
	 * @param strName 面板项名称
	 * @param bTryMode 尝试模式
	 * @return
	 * @throws Exception
	 */
	IPanelField getPanelField(String strName, boolean bTryMode) throws Exception;
}
