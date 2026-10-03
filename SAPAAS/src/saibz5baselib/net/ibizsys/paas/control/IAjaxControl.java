package net.ibizsys.paas.control;

/**
 * 异步处理控件接口
 * 
 * @author Administrator
 *
 */
public interface IAjaxControl extends IControl {
	/**
	 * 获取处理对象
	 * 
	 * @return
	 */
	String getHandler();

	/**
	 * 获取处理参数
	 * 
	 * @return
	 */
	IAjaxControlHandlerParam getHandlerParam();
}
