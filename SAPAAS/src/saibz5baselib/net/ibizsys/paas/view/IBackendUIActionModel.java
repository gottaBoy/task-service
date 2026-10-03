package net.ibizsys.paas.view;

/**
 * 后台界面模型对象接口
 * @author Administrator
 *
 */
public interface IBackendUIActionModel extends IUIActionModel {

	/**
	 * 模型属性：重新加载数据
	 */
	public final static String ATTR_RELOADDATA = "reloaddata";
	
	/**
	 * 模型属性：完成提示信息
	 */
	public final static String ATTR_SUCCESSMSG = "successmsg";
	
	/**
	 * 模型属性：数据访问行为
	 */
	public final static String ATTR_DATAACCESSACTION = "dataaccessaction";
	
	/**
	 * 模型属性：关闭编辑视图
	 */
	public final static String ATTR_CLOSEEDITVIEW = "closeeditview";

	/**
	 * 模型属性：后台行为名称
	 */
	public final static String ATTR_DEACTIONNAME = "deactionname";
	
	
	/**
	 * 模型属性：确认提示信息
	 */
	public final static String ATTR_CONFIRMMSG = "confirmmsg";
	
}
