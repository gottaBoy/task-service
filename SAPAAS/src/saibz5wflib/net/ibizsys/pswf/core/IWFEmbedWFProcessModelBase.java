package net.ibizsys.pswf.core;

/**
 * 嵌入流程模型基础对象接口
 * @author Administrator
 *
 */
public interface IWFEmbedWFProcessModelBase extends IWFProcessModel
{
	/**
	 * 通过返回值获取对应的连接
	 * @param strValue
	 * @param bTryMode
	 * @return
	 * @throws Exception
	 */
	IWFEmbedWFReturnModel getWFEmbedWFReturnModelByValue(String strValue,boolean bTryMode)throws Exception;
	
	
	
	/**
	 * 获取流程处理子流程模型
	 * @return
	 */
	java.util.Iterator<IWFProcSubWFModel> getWFProcSubWFModels();
	
	
	
	
}
