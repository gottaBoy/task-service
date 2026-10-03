package net.ibizsys.paas.core;

/**
 * 插件配置
 * @author Administrator
 *
 */
public class Plugin {
	
	/**
	 * 系统插件
	 */
	public final static String PLUGINTYPE_SYSTEM = "SYSTEM";
	
	/**
	 * 实体服务对象
	 */
	public final static String PLUGINTYPE_SERVICE = "SERVICE";
	
	
	
	/**
	 * 视图消息组
	 */
	public final static String PLUGINTYPE_VIEWMSGGROUP = "VIEWMSGGROUP";
	
	

	private String strType = "";
	
	private String strObj = "";
	
	private String strTarget = "";
	
	private String strCode = "";

	/**
	 * 获取插件类型
	 * @return
	 */
	public String getType() {
		return strType;
	}

	/**
	 * 设置插件类型
	 * @param strType
	 */
	public void setType(String strType) {
		this.strType = strType;
	}

	/**
	 * 获取插件对象
	 * @return
	 */
	public String getObj() {
		return strObj;
	}

	/**
	 * 设置插件对象
	 * @param strObj
	 */
	public void setObj(String strObj) {
		this.strObj = strObj;
	}

	/**
	 * 获取插件目标
	 * @return
	 */
	public String getTarget() {
		return strTarget;
	}

	/**
	 * 设置插件目标
	 * @param strTarget
	 */
	public void setTarget(String strTarget) {
		this.strTarget = strTarget;
	}

	/**
	 * 获取参数
	 * @return
	 */
	public String getCode() {
		return strCode;
	}

	/**
	 * 设置参数
	 * @param strCode
	 */
	public void setCode(String strCode) {
		this.strCode = strCode;
	}
	
	
	
}
