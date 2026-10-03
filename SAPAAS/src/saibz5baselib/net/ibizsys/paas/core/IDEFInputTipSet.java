package net.ibizsys.paas.core;

/**
 * 实体属性输入提示集合
 * @author Administrator
 *
 */
public interface IDEFInputTipSet extends ISystemObject,IModelBase2 {
	
	/**
	 * 获取实体名称
	 * 
	 * @return
	 */
	String getDEName();

	/**
	 * 获取实体数据集合名称
	 * 
	 * @return
	 */
	String getDEDataSetName();

	
	/**
	 * 获取可关闭标记属性
	 * @return
	 */
	String getEnableCloseField();
	
	
	
	/**
	 * 获取内容属性
	 * @return
	 */
	String getContentField();
	
	
	
	/**
	 * 获取唯一标识属性
	 * @return
	 */
	String getUniqueTagField();
	
	
	
	/**
	 * 获取链接属性
	 * @return
	 */
	String getLinkField();
}
