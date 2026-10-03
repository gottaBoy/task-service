package net.ibizsys.ssdynawf.core;

import net.ibizsys.pswf.core.IWFProcessModel;

/**
 * JIT流程处理模型对象接口
 * @author Administrator
 *
 */
public interface IDynaWFProcessModel extends IWFProcessModel {

	/**
	 * 获取JIT流程版本模型
	 * @return
	 */
	IDynaWFVersionModel getDynaWFVersionModel();
}
