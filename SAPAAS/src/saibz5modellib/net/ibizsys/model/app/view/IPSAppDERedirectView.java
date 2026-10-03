package net.ibizsys.model.app.view;

/**
 * 应用实体重定向视图对象接口
 * @author Administrator
 *
 */
public interface IPSAppDERedirectView extends IPSAppRedirectView,IPSAppDEView
{
	/**
	 * 支持工作流
	 * @return
	 */
	boolean isEnableWorkflow();
}
