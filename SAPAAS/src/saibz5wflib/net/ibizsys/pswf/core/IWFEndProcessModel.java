package net.ibizsys.pswf.core;

/**
 * 工作流结束处理模型对象接口
 * @author Administrator
 *
 */
public interface IWFEndProcessModel extends IWFProcessModel {

	/**
	 * 获取退出状态值
	 * @return
	 */
	String getExitStateValue();
}
