package net.ibizsys.paas.ctrlhandler;

import net.ibizsys.paas.ctrlmodel.IGridModel;

/**
 * 表格操作处理器对象接口
 * @author Administrator
 *
 */
public  abstract class GridActionHandlerBase extends CtrlActionHandlerBase implements IGridActionHandler{

	/**
	 * 获取表格处理器对象
	 * @return
	 */
	protected IGridHandler getGridHandler(){
		return (IGridHandler)this.getCtrlHandler();
	}
	
	/**
	 * 获取表格模型对象
	 * @return
	 */
	protected IGridModel getGridModel(){
		return (IGridModel)getGridHandler().getCtrlModel();
	}
	
	
	
}
