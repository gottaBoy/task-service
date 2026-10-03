package net.ibizsys.pswf.core;

/**
 * 流程连接组合条件模型接口
 * @author lionlau
 *
 */
public interface IWFLinkGroupCondModel  extends IWFLinkCondModel
{
	/**
	 * 获取组逻辑
	 * @return
	 */
	String getGroupOP();
	
	
	/**
	 * 是否取反
	 * @return
	 */
	boolean isNotMode();
	
	
	
	/**
	 * 获取子条件集合
	 * @return
	 */
	java.util.Iterator<IWFLinkCondModel> getWFLinkCondModels();
}
