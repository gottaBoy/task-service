package net.ibizsys.paas.ctrlhandler;

import net.ibizsys.paas.control.form.IFormItem;
import net.ibizsys.paas.ctrlmodel.ICtrlModel;
import net.ibizsys.paas.ctrlmodel.ISearchFormModel;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.entity.SimpleEntity;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.AjaxActionResult;
import net.ibizsys.paas.web.FormAjaxActionResult;
import net.ibizsys.paas.web.WebContext;
import net.sf.json.JSONObject;

/**
 * 搜索表单部件处理对象
 * 
 * @author lionlau
 *
 */
public abstract class SearchFormHandlerBase extends CtrlHandlerBase implements ISearchFormHandler {
	/**
	 * 获取当前的搜索表单模型
	 * 
	 * @return
	 */
	protected ISearchFormModel getSearchFormModel() {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.ctrlhandler.ICtrlHandler#getCtrlModel()
	 */
	@Override
	public ICtrlModel getCtrlModel() {
		return getSearchFormModel();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.ctrlhandler.CtrlHandlerBase#onProcessAction(java.lang .String)
	 */
	@Override
	protected AjaxActionResult onProcessAction(String strAction) throws Exception {
		if (StringHelper.compare(strAction, ACTION_LOADDRAFT, true) == 0) {
			return onLoadDraft();
		}

		if (StringHelper.compare(strAction, ACTION_LOAD, true) == 0) {
			return onLoad();
		}

		if (StringHelper.compare(strAction, ACTION_ITEMFETCH, true) == 0) {
			return onItemAction(strAction);
		}

		if (StringHelper.compare(strAction, ACTION_SEARCH, true) == 0) {
			return onSearch();
		}
		return super.onProcessAction(strAction);
	}

	/**
	 * 表单项操作
	 * 
	 * @return
	 * @throws Exception
	 */
	protected AjaxActionResult onItemAction(String strAction) throws Exception {
		String strFormItemName = WebContext.getFormItemId(this.getWebContext());
		ICtrlItemHandler iCtrlItemHandler = this.getCtrlItemHandler(ITEMACTIONTYPE_FORMITEM + strFormItemName);
		return iCtrlItemHandler.processAction(strAction);
	}

	/*
	 * 表单搜索处理
	 */
	protected AjaxActionResult onSearch() throws Exception {
		FormAjaxActionResult FormAjaxActionResult = new FormAjaxActionResult();
		this.getWebContext().setCurAjaxActionResult(FormAjaxActionResult);

		IDataObject iDataObject = new DataObject();
		this.fillInputValues(iDataObject, true);

		this.fillOutputDatas(iDataObject, FormAjaxActionResult);

		return FormAjaxActionResult;

	}

	/**
	 * 通过数据实体填充表单
	 * 
	 * @param iDataObject
	 * @return
	 */
	protected void fillOutputDatas(IDataObject iDataObject, FormAjaxActionResult formAjaxActionResult) throws Exception {
		JSONObject outputData = formAjaxActionResult.getData(true);
		JSONObject outputState = formAjaxActionResult.getState(true);
		JSONObject outputConfig = formAjaxActionResult.getConfig(true);
		this.getSearchFormModel().fillOutputDatas(iDataObject, false, outputData, outputState, outputConfig);
	}

	/**
	 * 填充数据实体对象
	 * 
	 * @param iDataObject 数据实体s对象
	 * @param bIgnoreEmpty 是否忽略空检查
	 * @param formItemErrors 表单项错误集合
	 * @return
	 */
	protected void fillInputValues(IDataObject iDataObject, boolean bIgnoreEmpty) throws Exception {
		this.getSearchFormModel().fillInputValues(iDataObject, true, bIgnoreEmpty);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.control.impl.SDAjaxControlHandlerImpl#onLoad()
	 */
	protected AjaxActionResult onLoadDraft() throws Exception {
		FormAjaxActionResult formAjaxActionResult = new FormAjaxActionResult();
		this.getWebContext().setCurAjaxActionResult(formAjaxActionResult);

		// 获取数据
		IEntity iEntity = getDraftEntity();

		iEntity.set(IFormItem.UF, 0);
		iEntity.set(IFormItem.TEMPMODE, this.getTempMode());
		this.fillOutputDatas(iEntity, formAjaxActionResult);
		return formAjaxActionResult;
	}
	
	
	/**
	 * 获取表单默认值
	 * @return
	 * @throws Exception
	 */
	protected IEntity getDraftEntity()throws Exception{
		IEntity iEntity = new SimpleEntity();
		this.getSearchFormModel().fillDefaultValues(iEntity, false);
		return iEntity;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.control.impl.SDAjaxControlHandlerImpl#onLoad()
	 */
	protected AjaxActionResult onLoad() throws Exception {
		FormAjaxActionResult formAjaxActionResult = new FormAjaxActionResult();
		this.getWebContext().setCurAjaxActionResult(formAjaxActionResult);

		IEntity iEntity = getEntity(null);
		// 获取数据
		iEntity.set(IFormItem.UF, 0);
		iEntity.set(IFormItem.TEMPMODE, this.getTempMode());
		this.fillOutputDatas(iEntity, formAjaxActionResult);
		return formAjaxActionResult;
	}
	
	
	/**
	 * 获取数据
	 * 
	 * @param objKeyValue
	 * @return
	 * @throws Exception
	 */
	protected IEntity getEntity(Object objKeyValue) throws Exception {
		return new SimpleEntity();
	}

}
