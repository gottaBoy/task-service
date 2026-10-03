package net.ibizsys.ssdyna.ctrlhandler;

import net.ibizsys.model.control.IPSControl;
import net.ibizsys.paas.ctrlhandler.ICtrlHandler;
import net.ibizsys.ssdyna.view.IDynaViewModel;

/**
 * 动态部件处理对象接口
 * @author Administrator
 *
 */
public interface IDynaCtrlHandler extends ICtrlHandler {

	/**
	 * 初始化
	 * @param iDynaViewModel
	 * @param iPSControl
	 * @throws Exception
	 */
	void init(IDynaViewModel iDynaViewModel,IPSControl iPSControl)throws Exception;
	
	
	
	/**
	 * 获取部件对象
	 * @return
	 */
	IPSControl getPSControl();
}
