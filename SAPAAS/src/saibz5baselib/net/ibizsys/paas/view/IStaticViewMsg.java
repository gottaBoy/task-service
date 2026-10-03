package net.ibizsys.paas.view;

import net.ibizsys.paas.core.IModelBase2;

/**
 * 静态视图消息
 * @author Administrator
 *
 */
public interface IStaticViewMsg extends IViewMessage ,IModelBase2 {
	
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
}
