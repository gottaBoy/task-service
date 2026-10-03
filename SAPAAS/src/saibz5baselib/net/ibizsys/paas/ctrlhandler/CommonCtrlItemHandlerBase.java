package net.ibizsys.paas.ctrlhandler;

import java.util.ArrayList;

import net.ibizsys.paas.core.DEDataSetCond;
import net.ibizsys.paas.core.DEDataSetFetchContext;
import net.ibizsys.paas.core.IDEDataSetCond;
import net.ibizsys.paas.ctrlmodel.IFormModel;
import net.ibizsys.paas.ctrlmodel.IGridModel;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.AjaxActionResult;

/**
 * 通用部件项处理对象基类
 * 
 * @author lionlau
 *
 */
public abstract class CommonCtrlItemHandlerBase extends CtrlItemHandlerBase implements IFormItemHandler,IGridEditItemHandler {

	private IFormModel iFormModel = null;
	private IGridModel iGridModel = null;
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.ctrlhandler.IFormItemHandler#init(net.ibizsys.paas.ctrlmodel.IFormModel, net.ibizsys.paas.ctrlhandler.ICtrlHandler)
	 */
	public void init(IFormModel iFormModel, ICtrlHandler iCtrlHandler) throws Exception {
		this.setFormModel(iFormModel);
		super.init(iCtrlHandler);
	}

	/**
	 * 获取表单模型
	 * 
	 * @return the iFormModel
	 */
	public IFormModel getFormModel() {
		return iFormModel;
	}

	/**
	 * 设置表单模型
	 * 
	 * @param iFormModel the iFormModel to set
	 */
	protected void setFormModel(IFormModel iFormModel) {
		this.iFormModel = iFormModel;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.ctrlhandler.IGridItemHandler#init(net.ibizsys.paas.ctrlmodel.IGridModel, net.ibizsys.paas.ctrlhandler.ICtrlHandler)
	 */
	public void init(IGridModel iGridModel, ICtrlHandler iCtrlHandler) throws Exception {
		this.setGridModel(iGridModel);
		super.init(iCtrlHandler);
	}

	/**
	 * 获取表格模型
	 * 
	 * @return
	 */
	public IGridModel getGridModel() {
		return iGridModel;
	}

	/**
	 * 设置表格模型
	 * 
	 * @param iGridModel
	 */
	protected void setGridModel(IGridModel iGridModel) {
		this.iGridModel = iGridModel;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.ctrlhandler.CtrlHandlerBase#onProcessAction(java.lang .String)
	 */
	@Override
	protected AjaxActionResult onProcessAction(String strAction) throws Exception {
		if (StringHelper.compare(strAction, IFormItemHandler.ACTION_ITEMFETCH, true) == 0) {
			return onItemFetch();
		}

		return super.onProcessAction(strAction);
	}

	/**
	 * 表单项获取数据
	 * 
	 * @return
	 * @throws Exception
	 */
	protected AjaxActionResult onItemFetch() throws Exception {
		throw new Exception("没有实现");
	}

	/**
	 * 填充搜索条件
	 * 
	 * @param deDataSetFetchContextImpl
	 * @throws Exception
	 */
	protected void fillFetchConditions(DEDataSetFetchContext deDataSetFetchContextImpl) throws Exception {
		// 获取动态条件
		if ((this.getCtrlHandler().getTempMode() != ICtrlHandler.TEMPMODE_NONE) && isEnableTempData()) {
			onFillTempDataConditions(deDataSetFetchContextImpl.getConditionList());
		}
		this.onFillFetchConditions(deDataSetFetchContextImpl.getConditionList());

	}

	/**
	 * 填充临时数据条件
	 * 
	 * @param userConditions
	 */
	protected void onFillTempDataConditions(ArrayList<IDEDataSetCond> userConditions) {
		DEDataSetCond deDataSetCondImpl = new DEDataSetCond();
		deDataSetCondImpl.setCondType(IDEDataSetCond.CONDTYPE_CUSTOM);
		deDataSetCondImpl.setCustomCond("t1.SRFDRAFTFLAG = 0");
		userConditions.add(deDataSetCondImpl);
	}

	/**
	 * 填充数据获取条件
	 * 
	 * @param userConditions
	 * @throws Exception
	 */
	protected void onFillFetchConditions(ArrayList<IDEDataSetCond> userConditions) throws Exception {

	}

	/**
	 * 是否支持临时数据
	 * 
	 * @return
	 */
	protected boolean isEnableTempData() {
		return false;
	}
}
