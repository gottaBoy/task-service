package net.ibizsys.paas.view;

/**
 * 实体数据集合视图消息模型对象接口
 * @author Administrator
 *
 */
public interface IDEDataSetViewMsgModel extends  IDEDataSetViewMsg,IViewMsgModel {
	
	/**
	 * 重置缓存
	 */
	void resetCache();
}
