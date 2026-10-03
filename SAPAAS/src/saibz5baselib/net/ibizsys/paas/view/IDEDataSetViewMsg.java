package net.ibizsys.paas.view;

/**
 * 实体数据集合视图消息对象
 * @author Administrator
 *
 */
public interface IDEDataSetViewMsg extends IStaticViewMsg,IViewMsgCacheSupporter {
	
	/**
	 * 获取标题语言标识
	 * @return
	 */
	String getTitleLanResTag();
	
	
	/**
	 * 获取消息模版编号
	 * @return
	 */
	String getMsgTemplateId();
	
	
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
	 * 获取标题属性
	 * 
	 * @return
	 */
	String getTitleField();

	/**
	 * 获取标题语言资源标记
	 * 
	 * @return
	 */
	String getTitleLanResTagField();
	
	
	/**
	 * 获取消息类型属性
	 * @return
	 */
	String  getMsgTypeField();
	
	
	
	/**
	 * 获取消息位置属性
	 * @return
	 */
	String  getMsgPosField();
	
	
	
	/**
	 * 获取可删除标记属性
	 * @return
	 */
	String getRemoveFlagField();
	
	
	
	/**
	 * 获取内容属性
	 * @return
	 */
	String getContentField();
	
	
	
	/**
	 * 获取上下文数据计算逻辑
	 * @return
	 */
	String getActiveDataDELogicId();
	
	
	
	/**
	 * 获取排序值属性
	 * @return
	 */
	String getOrderValueField();
	
	
	/**
	 * 获取数据源链接
	 * 
	 * @return
	 */
	String getDSLink();
}
