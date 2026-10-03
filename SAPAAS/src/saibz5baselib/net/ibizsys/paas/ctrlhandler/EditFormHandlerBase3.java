package net.ibizsys.paas.ctrlhandler;

import net.ibizsys.paas.control.form.IFormItem;
import net.ibizsys.paas.ctrlmodel.IFormItemModel;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.AjaxActionResult;
import net.ibizsys.paas.web.FormAjaxActionResult;

/**
 * 编辑表单处理对象基类3，使用固定主键（根据主键配置的默认值）
 * @author Administrator
 *
 */
public abstract class EditFormHandlerBase3 extends EditFormHandlerBase {

	@Override
	protected Object getEditFormKeyValue() throws Exception {
		IFormItemModel iFormItemModel = (IFormItemModel)this.getEditFormModel().getFormItem(IFormItem.KEY,false);
		return iFormItemModel.getDefaultValue(this.getWebContext(),false);
	}
	
	
	/* (non-Javadoc)
	 * @see net.ibizsys.paas.ctrlhandler.EditFormHandlerBase#onLoadDraft()
	 */
	@Override
	protected AjaxActionResult onLoadDraft() throws Exception {
		return this.onLoad();
	}
	
	
	@Override
	protected void fillOutputDatas(IDataObject iDataObject, Boolean bUpdate, FormAjaxActionResult formAjaxActionResult) throws Exception {
		super.fillOutputDatas(iDataObject, bUpdate, formAjaxActionResult);
		
		String strKeyValue = formAjaxActionResult.getData(true).optString(IFormItem.KEY);
		if(StringHelper.isNullOrEmpty(strKeyValue)){
			strKeyValue = DataObject.getStringValue(getEditFormKeyValue(), "");
			JSONObjectHelper.putRaw(formAjaxActionResult.getData(true), IFormItem.KEY, strKeyValue);
		}
	}
}
