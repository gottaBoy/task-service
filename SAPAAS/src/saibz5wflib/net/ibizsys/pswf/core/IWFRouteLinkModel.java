package net.ibizsys.pswf.core;

/**
 * 流程路由连接模块接口
 * @author lionlau
 *
 */
public interface IWFRouteLinkModel extends IWFLinkModel
{
	/**
	 * 是否是默认连接
	 * @return
	 */
	boolean isDefault();
	
	
	/**
	 * 获取根连接条件组模型
	 * @return
	 */
	IWFLinkGroupCondModel getWFLinkGroupCondModel();
	
}
