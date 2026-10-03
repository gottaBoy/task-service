package net.ibizsys.paas.ctrlmodel;

import net.ibizsys.paas.controller.IDynaViewControllerInst;
import net.ibizsys.paas.core.IDynaModel;

/**
 * 动态控件模型对象接口
 * @author Administrator
 * @Version 5.0.18.5
 *
 */
public interface IDynaCtrlModel extends ICtrlModel,IDynaModel {

	/**
	 * 动态模型：子项集合
	 */
	public final static String ATTR_ITEMS = "items";
	
	
	/**
	 * 动态模型：标题
	 */
	public final static String ATTR_CAPTION = "caption";
	
	
	/**
	 * 动态模型：提示
	 */
	public final static String ATTR_TOOPTIP = "tooltip";
	
	
	/**
	 * 动态模型：图标路径
	 */
	public final static String ATTR_ICONPATH = "iconpath";
	
	
	
	/**
	 * 动态模型：图标样式
	 */
	public final static String ATTR_ICONCLS = "iconcls";
	
	
	
	/**
	 * 动态模型：抬头
	 */
	public final static String ATTR_TITLE = "title";
	
	
	/**
	 * 动态模型：宽度
	 */
	public final static String ATTR_WIDTH = "width";
	
	
	/**
	 * 动态模型：高度
	 */
	public final static String ATTR_HEIGHT = "height";
	
	
	/**
	 * 模型属性：栅格布局 超小列宽
	 */
	final static String ATTR_COLXS = "colxs";
	
	/**
	 * 模型属性：栅格布局 小列宽
	 */
	final static String ATTR_COLSM = "colsm";
	
	/**
	 * 模型属性：栅格布局 中等列宽
	 */
	final static String ATTR_COLMD = "colmd";
	
	/**
	 * 模型属性：栅格布局 大型列宽
	 */
	final static String ATTR_COLLG = "collg";
	
	
	/**
	 * 模型属性：栅格布局 超小偏移数量
	 */
	final static String ATTR_COLXSOFFSET = "colxsoffset";
	
	/**
	 * 模型属性：栅格布局 小偏移数量
	 */
	final static String ATTR_COLSMOFFSET = "colsmoffset";
	
	/**
	 * 模型属性：栅格布局 中等偏移数量
	 */
	final static String ATTR_COLMDOFFSET = "colmdoffset";
	
	/**
	 * 模型属性：栅格布局 大型偏移数量
	 */
	final static String ATTR_COLLGOFFSET = "collgoffset";
	
	

	/**
	 * 初始化控件模型
	 * @param iDynaViewControllerInst
	 * @param modelObject 对象配置
	 * @throws Exception
	 */
	void init(IDynaViewControllerInst iDynaViewControllerInst,Object modelObject) throws Exception;
	
	
	
	/**
	 * 获取动态视图控制器实例对象
	 * @return
	 */
	IDynaViewControllerInst getDynaViewControllerInst(); 
	
	
	
	/**
	 * 是否启用动态部件模式
	 * @since 5.0.18.5
	 * @return
	 */
	boolean isEnableDynaCtrl();
}
