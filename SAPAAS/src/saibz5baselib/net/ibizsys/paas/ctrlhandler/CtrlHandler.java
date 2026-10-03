package net.ibizsys.paas.ctrlhandler;

/**
 * 控件处理器静态对象
 * 
 * @author Administrator
 *
 */
public class CtrlHandler {
	private static ThreadLocal<ICtrlHandler> ctrlHandler = new ThreadLocal<ICtrlHandler>();

	/**
	 * 获取当前控件处理对象
	 * 
	 * @return
	 */
	public static ICtrlHandler getCurrent() {
		return ctrlHandler.get();
	}

	/**
	 * 设置当前控件处理对象
	 * 
	 * @param value
	 */
	public static void setCurrent(ICtrlHandler value) {
		ctrlHandler.set(value);
	}
}
