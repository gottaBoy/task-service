package net.ibizsys.pswf.core;

import net.ibizsys.paas.sysmodel.IDynaSystemSettingModel;

/**
 * 动态工作流设置模型对象接口
 * @author Administrator
 *
 */
public interface IDynaWFSettingModel extends IDynaWFSetting {

	/**
	 * 初始化
	 * @param iDynaSystemSettingModel
	 * @throws Exception
	 */
	void init(IDynaSystemSettingModel iDynaSystemSettingModel)throws Exception;
	
	
	/**
	 * 获取动态系统设置模型对象
	 * @return
	 */
	IDynaSystemSettingModel getDynaSystemSettingModel();
	
}
