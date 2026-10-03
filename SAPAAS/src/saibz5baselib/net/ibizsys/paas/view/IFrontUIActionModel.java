package net.ibizsys.paas.view;

/**
 * 前台界面行为模型对象接口
 * 
 * @author Administrator
 *
 */
public interface IFrontUIActionModel extends IUIActionModel {
	/**
	 * 模型属性：前端处理类型
	 */
	public final static String ATTR_FRONTTYPE = "fronttype";

	/**
	 * 模型属性：前端打开视图
	 */
	public final static String ATTR_FRONTVIEW = "frontview";

	/**
	 * 模型属性：前端打开视图类名
	 */
	public final static String ATTR_FRONTVIEW_CLASSNAME = "classname";

	/**
	 * 模型属性：前端打开视图参数
	 */
	public final static String ATTR_FRONTVIEW_VIEWPARAM = "viewparam";

	/**
	 * 模型属性：前端打开视图参数项，操作标识
	 */
	public final static String ATTR_FRONTVIEW_VIEWPARAM_SRFWFIATAG = "srfwfiatag";

	/**
	 * 模型属性：前端打开视图参数项，流程步骤
	 */
	public final static String ATTR_FRONTVIEW_VIEWPARAM_SRFWFSTEP = "srfwfstep";

	/**
	 * 模型属性：前端打开视图标题
	 */
	public final static String ATTR_FRONTVIEW_TITLE = "title";

	/**
	 * 模型属性：前端打开视图标题
	 */
	public final static String ATTR_FRONTVIEW_OPENMODE = "openmode";

	/**
	 * 前端处理类型：向导处理
	 */
	public final static String FRONTTYPE_WIZARD = "WIZARD";

	/**
	 * 前端处理类型：打开页面
	 */
	public final static String FRONTTYPE_SHOWPAGE = "SHOWPAGE";

	/**
	 * 前端处理类型：打开HTML页面
	 */
	public final static String FRONTTYPE_OPENHTMLPAGE = "OPENHTMLPAGE";

	/**
	 * 前端处理类型：其它
	 */
	public final static String FRONTTYPE_OTHER = "OTHER";
}
