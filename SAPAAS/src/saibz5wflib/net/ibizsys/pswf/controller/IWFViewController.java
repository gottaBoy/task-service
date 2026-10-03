package net.ibizsys.pswf.controller;

import net.ibizsys.paas.controller.IViewController;
import net.ibizsys.pswf.core.IWFModel;
import net.ibizsys.pswf.core.IWFVersionModel;

/**
 * 流程视图控制器接口
 * 
 * @author lionlau
 *
 */
public interface IWFViewController extends IViewController {
	/**
	 * 是否为流程交互模式
	 * 
	 * @return
	 */
	boolean isWFIAMode();

	/**
	 * 获取流程模型
	 * 
	 * @return
	 */
	IWFModel getWFModel();

	/**
	 * 获取流程版本模型
	 * 
	 * @return
	 */
	IWFVersionModel getWFVersionModel();

	/**
	 * 获取流程步骤值
	 * 
	 * @return
	 */
	String getWFStepValue();

	/**
	 * 获取流程版本号，-1为最新
	 * 
	 * @return
	 */
	int getWFVersion();
}
