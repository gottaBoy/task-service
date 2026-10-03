package net.ibizsys.paas.ctrlmodel;

import net.ibizsys.paas.control.IControl;
import net.ibizsys.paas.controller.IViewController;
import net.ibizsys.paas.ctrlhandler.ICtrlRender;
import net.ibizsys.paas.demodel.IDataEntityModel;

/**
 * 控件模型接口
 * 
 * @author Administrator
 *
 */
public interface ICtrlModel extends IControl {
	/**
	 * 初始化控件模型
	 * 
	 * @param iViewController
	 * @throws Exception
	 */
	void init(IViewController iViewController) throws Exception;

	/**
	 * 获取视图控制对象
	 * 
	 * @return
	 */
	IViewController getViewController();

	/**
	 * 获取控件参数
	 * 
	 * @param strParamName
	 * @return
	 */
	Object getCtrlParam(String strParamName);

	/**
	 * 判断是否包含指定参数
	 * 
	 * @param strParamName
	 * @return
	 */
	boolean containsCtrlParam(String strParamName);

	/**
	 * 获取控件参数
	 * 
	 * @param strParamName 参数名称
	 * @param strDefault 默认值
	 * @return
	 */
	String getCtrlParam(String strParamName, String strDefault);

	/**
	 * 获取控件参数
	 * 
	 * @param strParamName
	 * @param bDefault
	 * @return
	 */
	boolean getCtrlParam(String strParamName, boolean bDefault);

	/**
	 * 获取控件参数
	 * 
	 * @param strParamName
	 * @param nDefault
	 * @return
	 */
	int getCtrlParam(String strParamName, int nDefault);

	/**
	 * 获取控件参数名称集合
	 * 
	 * @return
	 */
	java.util.Iterator getCtrlParamNames();

	/**
	 * 获取当前部件绘制器
	 * 
	 * @return
	 */
	ICtrlRender getCtrlRender() throws Exception;

	/**
	 * 获取当前部件绘制器
	 * 
	 * @param strRenderType 绘制器类型
	 * @return
	 */
	ICtrlRender getCtrlRender(String strRenderType) throws Exception;

	/**
	 * 获取实体模型
	 * 
	 * @return
	 */
	IDataEntityModel getDEModel();

	/**
	 * 设置控件参数
	 * 
	 * @param strParamName
	 * @param objValue
	 */
	void setCtrlParam(String strParamName, Object objValue);
}
