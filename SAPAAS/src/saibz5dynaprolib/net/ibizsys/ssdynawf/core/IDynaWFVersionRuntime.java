package net.ibizsys.ssdynawf.core;

import net.ibizsys.model.wf.IPSWFVersion;

/**
 * 动态工作流版本运行时接口
 * @author Administrator
 *
 */
public interface IDynaWFVersionRuntime {

	/**
	 * 初始化
	 * @param iDynaWFModel
	 * @param iPSWFVersion
	 * @throws Exception
	 */
	void init(IDynaWFModel iDynaWFModel, IPSWFVersion iPSWFVersion) throws Exception ;
}
