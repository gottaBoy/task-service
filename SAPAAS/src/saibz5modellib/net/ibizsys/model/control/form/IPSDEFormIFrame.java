package net.ibizsys.model.control.form;


/**
 * 表单IFrame部件对象接口
 * @author Administrator
 *
 */
public interface IPSDEFormIFrame extends IPSDEFormDetail
{
	/**
	 * 获取嵌入视图标识
	 * @return
	 */
	String getEmbedViewId();
	
	
	
	/**
	 * 获取额外界面刷新项，定义除主键外需要监控变化的表单项
	 * @return
	 */
	String getRefreshItems();
	
	
	/**
	 * 获取IFrame的路径
	 * @return
	 */
	String getIFrameUrl();
}
