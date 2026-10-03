package net.ibizsys.paas.ctrlhandler;

import net.ibizsys.paas.control.form.IFormItem;
import net.ibizsys.paas.ctrlmodel.IFormItemModel;
import net.ibizsys.paas.ctrlmodel.IFormModel;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.AjaxActionResult;
import net.ibizsys.paas.web.FormAjaxActionResult;
import net.ibizsys.paas.web.WebContext;
import net.sf.json.JSONObject;

/**
 * 表单项更新处理对象基类
 * 
 * @author lionlau
 *
 */
public abstract class FormItemUpdateHandlerBase extends CtrlItemHandlerBase implements IFormItemUpdateHandler {
	private IFormModel iFormModel = null;

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.ctrlhandler.IFormItemUpdateHandler#init(net.ibizsys.paas.ctrlmodel.IFormModel, net.ibizsys.paas.ctrlhandler.ICtrlHandler)
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
	 * @param iFormModel
	 */
	protected void setFormModel(IFormModel iFormModel) {
		this.iFormModel = iFormModel;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.ctrlhandler.CtrlHandlerBase#onProcessAction(java.lang .String)
	 */
	@Override
	protected AjaxActionResult onProcessAction(String strAction) throws Exception {
		if (StringHelper.compare(strAction, IFormItemUpdateHandler.ACTION_UPDATEFORMITEM, true) == 0) {
			return onFormItemUpdate();
		}

		return super.onProcessAction(strAction);
	}

	/**
	 * 表单项更新
	 * 
	 * @return
	 * @throws Exception
	 */
	protected AjaxActionResult onFormItemUpdate() throws Exception {
		FormAjaxActionResult formAjaxActionResult = new FormAjaxActionResult();
		this.getWebContext().setCurAjaxActionResult(formAjaxActionResult);

		// 获取当前数据对象
		boolean bUpdateFlag = false;
		JSONObject activeDataJsonObject = WebContext.getActiveData(this.getWebContext());
		Object objUFFlag = activeDataJsonObject.opt(IFormItem.UF);
		if (objUFFlag != null) {
			bUpdateFlag = (StringHelper.compare(objUFFlag.toString(), "1", false) == 0);
		}

		IEntity iEntity = this.getViewController().getDEModel().createEntity();
		this.fillInputValues(iEntity, bUpdateFlag, activeDataJsonObject);

		executeAction(iEntity);

		// 输出
		this.fillOutputDatas(iEntity, formAjaxActionResult);
		return formAjaxActionResult;
	}

	/**
	 * 通过数据实体填充表单
	 * 
	 * @param iDataObject 数据
	 * @param formAjaxActionResult 请求结果
	 * @throws Exception
	 */
	protected void fillOutputDatas(IDataObject iDataObject, FormAjaxActionResult formAjaxActionResult) throws Exception {
		JSONObject outputData2 = new JSONObject();
		JSONObject outputState2 = new JSONObject();
		JSONObject outputConfig2 = new JSONObject();

		this.getFormModel().fillOutputDatas(iDataObject, true, outputData2, outputState2, outputConfig2);

		fillOutputDatas(iDataObject, outputData2, outputState2, outputConfig2, formAjaxActionResult);
	}

	/**
	 * 填充数据实体对象
	 * 
	 * @param iDataObject 数据实体对象
	 * @param bIgnoreEmpty 是否忽略空检查
	 * @param formItemErrors 表单项错误集合
	 * @return
	 */
	protected void fillInputValues(IDataObject iDataObject, boolean bUpdate, JSONObject activeDataJsonObject) throws Exception {
		onFillInputValues(iDataObject, bUpdate, activeDataJsonObject);
		// 移除忽略输入的值
		java.util.Iterator<IFormItem> formItems = this.getFormModel().getFormItems();
		while (formItems.hasNext()) {
			IFormItem iFormItem = formItems.next();
			if (bUpdate) {
				if ((iFormItem.getIgnoreInput() & IFormItem.IGNOREINPUT_UPDATE) > 0) {
					iDataObject.remove(iFormItem.getName());
				}
			} else {
				if ((iFormItem.getIgnoreInput() & IFormItem.ENABLECOND_CREATE) > 0) {
					iDataObject.remove(iFormItem.getName());
				}
			}
		}
	}

	/**
	 * 填充表单值
	 * 
	 * @param iDataObject 数据实体对象
	 * @param bUpdate 是否更新
	 * @param activeDataJsonObject 变化的值
	 * @throws Exception
	 */
	protected void onFillInputValues(IDataObject iDataObject, boolean bUpdate, JSONObject activeDataJsonObject) throws Exception {
		java.util.Iterator<IFormItem> formItems = this.getFormModel().getFormItems();

		// 值预处理
		while (formItems.hasNext()) {
			IFormItemModel iFormItem = (IFormItemModel) formItems.next();
			try {
				Object objValue = iFormItem.getInputValue(activeDataJsonObject);
				if (objValue != null && (objValue instanceof String)) {
					String strValue = (String) objValue;
					if (StringHelper.isNullOrEmpty(strValue)) objValue = null;
				}

				iDataObject.set(iFormItem.getName(), objValue);
			} catch (Exception ex) {
				// formError.register(iFormItem.getName(), iFormItem.getCaption(), iFormItem.getCapLanId(), FormItemError.ERROR_DATATYPE,getFormItemErrorInfo(iFormItem, FormItemError.ERROR_DATATYPE));
			}
		}
	}

	/**
	 * 填充输出的数据
	 * 
	 * @param iDataObject 数据实体对象
	 * @param outputData
	 * @param outputState
	 * @param outputConfig
	 * @param formAjaxActionResult
	 * @throws Exception
	 */
	protected abstract void fillOutputDatas(IDataObject iDataObject, JSONObject outputData, JSONObject outputState, JSONObject outputConfig, FormAjaxActionResult formAjaxActionResult) throws Exception;

	/**
	 * 执行行为
	 * 
	 * @param iEntity 数据实体对象
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
