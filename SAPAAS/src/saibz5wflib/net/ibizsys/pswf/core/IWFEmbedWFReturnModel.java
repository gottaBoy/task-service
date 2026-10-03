package net.ibizsys.pswf.core;

/**
 * 嵌入流程返回连接模型接口
 * @author Administrator
 *
 */
public interface IWFEmbedWFReturnModel extends IWFLinkModel
{
	/**
	 * 获取返回值
	 * @return
	 */
	String getReturnValue();
	
	
	/**
	 * 获取下一步的条件
	 * @return
	 */
	String getNextCondition();
}
