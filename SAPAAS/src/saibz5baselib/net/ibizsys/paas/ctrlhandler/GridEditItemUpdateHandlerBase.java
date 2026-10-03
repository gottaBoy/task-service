package net.ibizsys.paas.ctrlhandler;

import net.ibizsys.paas.control.grid.IGridEditItem;
import net.ibizsys.paas.ctrlmodel.IGridEditItemModel;
import net.ibizsys.paas.ctrlmodel.IGridModel;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.AjaxActionResult;
import net.ibizsys.paas.web.GridRowAjaxActionResult;
import net.ibizsys.paas.web.WebContext;
import net.sf.json.JSONObject;

/**
 * 表格编辑项更新处理对象基类
 * 
 * @author lionlau
 *
 */
public abstract class GridEditItemUpdateHandlerBase extends CtrlItemHandlerBase implements IGridEditItemUpdateHandler {
	private IGridModel iGridModel = null;

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.ctrlhandler.IGridEditItemUpdateHandler#init(net.ibizsys.paas.ctrlmodel.IGridModel, net.ibizsys.paas.ctrlhandler.ICtrlHandler)
	 */
	public void init(IGridModel iGridModel, ICtrlHandler iCtrlHandler) throws Exception {
		this.setGridModel(iGridModel);
		super.init(iCtrlHandler);
	}

	/**
	 * 获取表单模型
	 * 
	 * @return
	 */
	public IGridModel getGridModel() {
		return iGridModel;
	}

	/**
	 * 设置表单模型
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
		if (StringHelper.compare(strAction, IGridEditItemUpdateHandler.ACTION_UPDATEGRIDEDITITEM, true) == 0) {
			return onGridEditItemUpdate();
		}

		return super.onProcessAction(strAction);
	}

	/**
	 * 表格编辑项更新
	 * 
	 * @return
	 * @throws Exception
	 */
	protected AjaxActionResult onGridEditItemUpdate() throws Exception {
		GridRowAjaxActionResult gridRowAjaxActionResult = new GridRowAjaxActionResult();
		this.getWebContext().setCurAjaxActionResult(gridRowAjaxActionResult);

		// 获取当前数据对象
		boolean bUpdateFlag = false;
		JSONObject activeDataJsonObject = WebContext.getActiveData(this.getWebContext());
		Object objUFFlag = activeDataJsonObject.opt(IGridEditItem.UF);
		if (objUFFlag != null) {
			bUpdateFlag = (StringHelper.compare(objUFFlag.toString(), "1", false) == 0);
		}

		IEntity iEntity = this.getViewController().getDEModel().createEntity();
		this.fillRowInputValues(iEntity, bUpdateFlag, activeDataJsonObject);

		executeAction(iEntity);

		// 输出
		this.fillRowOutputDatas(iEntity, gridRowAjaxActionResult);
		return gridRowAjaxActionResult;
	}

	/**
	 * 填充行输出数据
	 * 
	 * @param iDataObject 数据实体对象
	 * @param gridRowAjaxActionResult 请求结果
	 * @throws Exception
	 */
	protected void fillRowOutputDatas(IDataObject iDataObject, GridRowAjaxActionResult gridRowAjaxActionResult) throws Exception {
		JSONObject outputData2 = new JSONObject();
		JSONObject outputState2 = new JSONObject();
		JSONObject outputConfig2 = new JSONObject();

		this.getGridModel().fillRowOutputDatas(iDataObject, true, outputData2, outputState2, outputConfig2);

		fillRowOutputDatas(iDataObject, outputData2, outputState2, outputConfig2, gridRowAjaxActionResult);
	}

	/**
	 * 填充行输出数据
	 * 
	 * @param iDataObject 数据实体对象
	 * @param bUpdate 是否更新
	 * @param activeDataJsonObject
	 * @throws Exception
	 */
	protected void fillRowInputValues(IDataObject iDataObject, boolean bUpdate, JSONObject activeDataJsonObject) throws Exception {
		onFillRowInputValues(iDataObject, bUpdate, activeDataJsonObject);
		// 移除忽略输入的值
		java.util.Iterator<IGridEditItem> formItems = this.getGridModel().getGridEditItems();
		while (formItems.hasNext()) {
			IGridEditItem iGridEditItem = formItems.next();
			if (bUpdate) {
				if ((iGridEditItem.getIgnoreInput() & IGridEditItem.IGNOREINPUT_UPDATE) > 0) {
					iDataObject.remove(iGridEditItem.getName());
				}
			} else {
				if ((iGridEditItem.getIgnoreInput() & IGridEditItem.ENABLECOND_CREATE) > 0) {
					iDataObject.remove(iGridEditItem.getName());
				}
			}
		}
	}

	/**
	 * 填充行输入数据
	 * 
	 * @param iDataObject 实体数据
	 * @param bUpdate 是否更新
	 * @param activeDataJsonObject 修改的值
	 * @throws Exception
	 */
	protected void onFillRowInputValues(IDataObject iDataObject, boolean bUpdate, JSONObject activeDataJsonObject) throws Exception {
		java.util.Iterator<IGridEditItem> formItems = this.getGridModel().getGridEditItems();

		// 值预处理
		while (formItems.hasNext()) {
			IGridEditItemModel iGridEditItem = (IGridEditItemModel) formItems.next();
			try {
				Object objValue = iGridEditItem.getInputValue(activeDataJsonObject);
				if (objValue != null && (objValue instanceof String)) {
					String strValue = (String) objValue;
					if (StringHelper.isNullOrEmpty(strValue)) objValue = null;
				}

				iDataObject.set(iGridEditItem.getName(), objValue);
			} catch (Exception ex) {
				// formError.register(iGridEditItem.getName(), iGridEditItem.getCaption(), iGridEditItem.getCapLanId(), GridEditItemError.ERROR_DATATYPE,getGridEditItemErrorInfo(iGridEditItem, GridEditItemError.ERROR_DATATYPE));
			}
		}
	}

	/**
	 * 填充行输出数据
	 * 
	 * @param iDataObject 实体数据
	 * @param outputData 输出数据
	 * @param outputState 输出状态
	 * @param outputConfig 输出控制
	 * @param gridRowAjaxActionResult 请求结果
	 * @throws Exception
	 */
	protected abstract void fillRowOutputDatas(IDataObject iDataObject, JSONObject outputData, JSONObject outputState, JSONObject outputConfig, GridRowAjaxActionResult gridRowAjaxActionResult) throws Exception;

	/**
	 * 执行行为
	 * 
	 * @param iEntity
	 * @return
	 * @throws Exception
	 */
	protected abstract void executeAction(IEntity iEntity) throws Exception;

	/**
	 * 是否支持临时数据
	 * 
	 * @return
	 */
	protected boolean isEnableTempData() {
		return false;
	}
}
