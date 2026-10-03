package net.ibizsys.ssdynawf.core;

import net.ibizsys.model.wf.IPSWFVersion;
import net.ibizsys.sswf.core.ISaaSWFVersionModel;

/**
 * JIT流程版本模型对象接口
 * @author Administrator
 *
 */
public interface IDynaWFVersionModel extends ISaaSWFVersionModel {

	/**
	 * 获取JIT流程模型对象
	 * @return
	 */
	IDynaWFModel getDynaWFModel();
	
	
	/**
	 * 获取流程版本对象
	 * @return
	 */
	IPSWFVersion getPSWFVersion();
}
