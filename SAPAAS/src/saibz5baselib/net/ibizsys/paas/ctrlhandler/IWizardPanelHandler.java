package net.ibizsys.paas.ctrlhandler;

/**
 * 向导面板处理对象接口
 * 
 * @author Administrator
 *
 */
public interface IWizardPanelHandler extends ICtrlHandler {
	/**
	 * 初始化向导
	 */
	final static String ACTION_INIT = "init";

	/**
	 * 完成向导
	 */
	final static String ACTION_FINISH = "finish";

}
