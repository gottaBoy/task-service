package net.ibizsys.paas.sysmodel;

import net.ibizsys.paas.core.IModelBase3;

/**
 * 系统成员模型对象接口
 * @author Administrator
 *
 */
public interface ISystemPartModel extends IModelBase3{

	/**
	 * 获取系统模型对象
	 * @return
	 */
	ISystemModel getSystemModel();
	
	/**
	 * 安装运行时数据
	 */
	void installRTDatas() throws Exception;
}
