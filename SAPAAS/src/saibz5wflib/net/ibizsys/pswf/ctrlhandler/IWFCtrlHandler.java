package net.ibizsys.pswf.ctrlhandler;

/**
 * 流程部件处理对象接口
 * 
 * @author lionlau
 *
 */
public interface IWFCtrlHandler {
	
	/**
	 * 启动流程
	 */
	final static String ACTION_WFSTART = "wfstart";

	/**
	 * 流程交互
	 */
	final static String ACTION_WFSUBMIT = "wfsubmit";
}
