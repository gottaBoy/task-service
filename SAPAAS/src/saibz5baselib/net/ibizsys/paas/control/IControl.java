package net.ibizsys.paas.control;

import net.ibizsys.paas.core.IDataEntity;
import net.ibizsys.paas.core.IModelBase;
import net.ibizsys.paas.view.IView;

/**
 * 控件基础接口
 * 
 * @author lionlau
 *
 */
public interface IControl extends IModelBase {

	/**
	 * 获取控件类型
	 * 
	 * @return
	 */
	String getControlType();

	/**
	 * 获取控件所在视图
	 * 
	 * @return
	 */
	IView getView();

	/**
	 * 获取实体模型对象
	 * 
	 * @return
	 */
	IDataEntity getDataEntity();

}
