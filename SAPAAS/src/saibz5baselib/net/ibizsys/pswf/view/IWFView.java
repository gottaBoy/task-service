package net.ibizsys.pswf.view;

import net.ibizsys.paas.view.IView;
import net.ibizsys.pswf.core.IWFModel;
import net.ibizsys.pswf.core.IWFVersionModel;

/**
 * 工作流视图对象接口
 * @author Administrator
 *
 */
public interface IWFView extends IView {

	/**
	 * 是否为流程交互模式
	 * 
	 * @return
	 */
	boolean isWFIAMode();

	
	/**
	 * 获取流程步骤值
	 * 
	 * @return
	 */
	String getWFStepValue();
	
	

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
	 * 获取流程版本号，-1为最新
	 * 
	 * @return
	 */
	int getWFVersion();
}
