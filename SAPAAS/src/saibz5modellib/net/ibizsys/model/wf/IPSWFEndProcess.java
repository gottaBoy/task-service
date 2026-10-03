package net.ibizsys.model.wf;

/**
 * 工作流结束处理对象接口
 * @author Administrator
 *
 */
public interface IPSWFEndProcess extends IPSWFProcess {

	/**
	 * 获取退出状态值
	 * @return
	 */
	String getExitStateValue();
}
