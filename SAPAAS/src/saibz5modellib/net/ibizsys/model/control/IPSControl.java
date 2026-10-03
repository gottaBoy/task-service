package net.ibizsys.model.control;

import net.ibizsys.model.IPSModelJsonExporter;
import net.ibizsys.model.app.view.IPSAppView;
import net.ibizsys.model.core.IPSModelObject;
import net.ibizsys.model.dataentity.IPSDataEntity;
import net.ibizsys.model.res.IPSSysCss;
import net.ibizsys.paas.control.IControl;

/**
 * 视图部件对象接口
 * @author Administrator
 *
 */
public interface IPSControl extends IControl,IPSModelObject,IPSModelJsonExporter{

	/**
	 * 是否拥有部件模型
	 * 
	 * @return
	 */
	boolean hasCtrlModel();
	
	
	
	/**
	 * 获取控件参数对象
	 * @return
	 */
	IPSControlParam getPSControlParam(); 
	
	
	/**
	 * 获取部件绑定实体对象
	 * @return
	 */
	IPSDataEntity getPSDataEntity();
	
	
	
	/**
	 * 获取部件所在的应用视图对象
	 * 
	 * @return
	 */
	IPSAppView getPSAppView();

	/**
	 * 获取部件类型
	 * 
	 * @return
	 */
	IPSControlType getPSControlType();
	
	
	
	/**
	 * 获取控件容器对象
	 * @return
	 */
	IPSControlContainer getPSControlContainer();
	
	
	

	/**
	 * 获取控件容器对象
	 * @return
	 */
	IPSControlXDataContainer getPSControlXDataContainer();
	
	
	
	/**
	 * 获取控件宽度
	 * 
	 * @return
	 */
	double getWidth();

	/**
	 * 获取控件高度
	 * 
	 * @return
	 */
	double getHeight();
	
	
	
	/**
	 * 获取部件样式
	 * @return
	 */
	IPSSysCss getPSSysCss();
	
	
	
	
	/**
	 * 获取部件子类型
	 * @return
	 */
	String getControlSubType();
	
	
	/**
	 * 是否为视图默认部件
	 * @return
	 */
	boolean isDefaultCtrl();

	/**
	 * 是否为用户扩展动态部件
	 * @return
	 */
	boolean isDynamicCtrl();
	
	
	/**
	 * 获取动态视图内容
	 * @return
	 */
	String getDynaViewContent() throws Exception;
	
	
	
	/**
	 * 获取动态模型内容
	 * @return
	 */
	String getDynaModelContent() throws Exception;
}
