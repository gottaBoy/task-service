package net.ibizsys.model.wf;

import net.ibizsys.pswf.core.IWFRouteLinkModel;
import net.ibizsys.pswf.core.RootWFLinkGroupCondModel;

/**
 * 工作流常规处理连接对象接口
 * 
 * @author lionlau
 *
 */
public interface IPSWFRouteLink extends IPSWFLink, IWFRouteLinkModel {
	/**
	 * 获取流程处理根连接条件对象
	 * 
	 * @return
	 */
	RootWFLinkGroupCondModel getRootWFLinkGroupCondModel();
}
