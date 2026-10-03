package net.ibizsys.pswf.core;

import net.ibizsys.paas.codelist.ICodeList;


/**
 * 流程版本模型
 * @author lionlau
 *
 */
public interface IWFVersionModel
{
	/**
	 * 初始化
	 * @param iWFModel
	 * @throws Exception
	 */
	void init(IWFModel iWFModel) throws Exception;
	
	
	/**
	 * 获取标识
	 * @return
	 */
	String getId();
	
	
	/**
	 * 获取名称
	 * @return
	 */
	String getName();
	
	
	
	/**
	 * 获取流程版本
	 * @return
	 */
	int getWFVersion();
	
	
	/**
	 * 获取工作流模型对象
	 * @return
	 */
	IWFModel getWFModel();
	
	
	/**
	 * 获取流程处理集合
	 * @return
	 */
	java.util.Iterator<IWFProcessModel> getWFProcessModels();
	
	
	
	/**
	 * 获取流程连接集合
	 * @return
	 */
	java.util.Iterator<IWFLinkModel> getWFLinkModels();
	
	
	
	/**
	 * 获取流程处理模型对象
	 * @return
	 */
	IWFProcessModel  getWFProcessModel(String strWFProcessModelName,boolean bTryMode)throws Exception;
	
	
	
	/**
	 * 获取流程步骤值对应的处理模型对象
	 * @param strWFStepValue
	 * @param bTryMode 尝试模式
	 * @return
	 * @throws Exception
	 */
	IWFProcessModel getWFProcessModelByWFStepValue(String strWFStepValue,boolean bTryMode)throws Exception;
	
	
	
	/**
	 * 获取开始的流程处理
	 * @return
	 */
	IWFProcessModel getStartWFProcessModel();
	
	
	
	/**
	 * 获取当前流程版本是否有并行子流程处理模型
	 * @return
	 */
	boolean hasWFParallelSubWFProcessModel();
	
	
	
	/**
	 * 获取流程模式
	 * @return
	 */
	String getWFMode();
	
	
	
	
	/**
	 * 获取标准业务流程模型
	 * @return
	 */
	String getBPMNModel();
	
	
	
	
	/**
	 * 获取流程步骤代码表模型
	 * @return
	 */
	ICodeList getWFStepCodeList();
}
