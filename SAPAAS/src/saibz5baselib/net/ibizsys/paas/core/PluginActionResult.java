package net.ibizsys.paas.core;

/**
 * 插件操作结果对象
 * @author Administrator
 *
 */
public class PluginActionResult {
	
	/**
	 * 替换原有操作
	 */
	public final static int RESULT_REPLACE = 1;
	
	
	/**
	 * 继续原有操作
	 */
	public final static int RESULT_CONTINUE = 2;
	
	/**
	 * 替换原有操作
	 */
	public final static PluginActionResult Replace = new PluginActionResult(RESULT_REPLACE);
	
	
	/**
	 * 继续原有操作
	 */
	public final static PluginActionResult Continue = new PluginActionResult(RESULT_CONTINUE);
	
	
	
	
	private int nResult  = RESULT_REPLACE;
	
	
	private Object objUserObject = null;

	
	public PluginActionResult(int nResult){
		this.nResult = nResult;
	}
	
	
	public PluginActionResult(int nResult,Object objUserObject){
		this.nResult = nResult;
		this.objUserObject = objUserObject;
	}

	/**
	 * 获取结果
	 * @return
	 */
	public int getResult() {
		return nResult;
	}

	/**
	 * 获取用户对象
	 * @return
	 */
	public Object getUserObject() {
		return objUserObject;
	}



	
}
