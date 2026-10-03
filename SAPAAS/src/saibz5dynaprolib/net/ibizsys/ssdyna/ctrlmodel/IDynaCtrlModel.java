package net.ibizsys.ssdyna.ctrlmodel;

import net.ibizsys.model.control.IPSControl;
import net.ibizsys.paas.ctrlmodel.ICtrlModel;
import net.ibizsys.ssdyna.view.IDynaViewModel;

import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 * 动态部件对象对象接口
 * @author Administrator
 *
 */
public interface IDynaCtrlModel extends ICtrlModel{

	/**
	 * 初始化
	 * @param iDynaViewModel
	 * @param iPSControl
	 * @throws Exception
	 */
	void init(IDynaViewModel iDynaViewModel,IPSControl iPSControl)throws Exception;
	
	
	
	/**
	 * 获取视图部件
	 * @return
	 */
	IPSControl getPSControl();
	
	
	/**
	 * 是否为动态部件
	 * @return
	 */
	boolean isDynaCtrl();
	
	/**
	 * 将模型导出到JsonObject
	 * @param objectNode
	 * @return
	 * @throws Exception
	 */
	ObjectNode toJsonObject(ObjectNode objectNode)throws Exception;
}
