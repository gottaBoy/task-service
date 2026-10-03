package net.ibizsys.pswf.core;

/**
 * 流程子流程模型接口
 * @author Administrator
 *
 */
public interface IWFProcSubWFModel
{
	/**
	 * 初始化
	 * @param iWFInteractiveProcessModel
	 * @throws Exception
	 */
	void init(IWFEmbedWFProcessModelBase iWFEmbedWFProcessModelBase) throws Exception;

	/**
	 * 获取嵌入流程处理模型
	 * @return
	 */
	IWFEmbedWFProcessModelBase getWFEmbedWFProcessModelBase();
	
	
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
	 * 获取子流程模型
	 * @return
	 */
	IWFModel getWFModel();
	
	
	
	/**
	 * 获取子流程标识
	 * @return
	 */
	String getWFId();
	
	
	
	
	/**
	 * 获取实体名称
	 * @return
	 */
	String getDEName();
	
	
	
	
	/**
	 * 获取实体数据集合名称
	 * @return
	 */
	String getDEDSName();
	
	
	
	/**
	 * 是否默认挂起
	 * @return
	 */
	boolean isSuspendDefault();
	
	
	/**
	 * 获取子流程版本模型
	 * @return
	 */
	IWFVersionModel getWFVersionModel();
	
	
	
	/**
	 * 获取子流程版本标识
	 * @return
	 */
	String getWFVerId();
}
