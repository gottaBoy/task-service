package net.ibizsys.ssdyna.ctrlmodel;

import net.ibizsys.model.control.IPSControl;
import net.ibizsys.model.control.form.IPSDEForm;
import net.ibizsys.model.control.form.IPSDEFormItem;
import net.ibizsys.paas.control.form.FormError;
import net.ibizsys.paas.control.form.IFormItem;
import net.ibizsys.paas.ctrlmodel.SearchFormItemModel;
import net.ibizsys.paas.ctrlmodel.SearchFormModelBase;
import net.ibizsys.paas.data.IDataItem;
import net.ibizsys.paas.data.IDataItemParam;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.datamodel.DataItemModel;
import net.ibizsys.paas.datamodel.DataItemParamModel;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.util.JsonNodeHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.ssdyna.view.IDynaViewModel;

import com.fasterxml.jackson.databind.node.ObjectNode;

public class DynaSearchFormModel extends SearchFormModelBase implements IDynaCtrlModel {
	
	private static final org.apache.commons.logging.Log log = org.apache.commons.logging.LogFactory.getLog(DynaSearchFormModel.class);
	private IPSControl iPSControl= null;
	
	@Override
	public void init(IDynaViewModel iDynaViewModel, IPSControl iPSControl) throws Exception {
		this.iPSControl = iPSControl;
		this.init(iDynaViewModel);
	}
	
	
	@Override
	public IPSControl getPSControl() {
		return this.iPSControl;
	}
	
	public IPSDEForm getPSDEForm() {
		return (IPSDEForm) getPSControl();
	}

	@Override
	public IDataEntityModel getDEModel() {
		try {
			if (getPSControl().getPSDataEntity() != null) {
				return ((IDynaViewModel)this.getViewController()).getDynaSysModel().getDynaDEModel(getPSControl().getPSDataEntity().getId());
			}
		} catch (Exception ex) {
			log.error(ex);
		}
		return super.getDEModel();
	}

	
	/**
	 * 准备表单项模型
	 * 
	 * @throws Exception
	 */
	protected void prepareFormItems() throws Exception {
		super.prepareFormItems();
		IFormItem iFormItem = null;
		IPSDEForm iPSDEForm = this.getPSDEForm();
		java.util.Iterator<IFormItem> formItems = iPSDEForm.getFormItems();
		while (formItems.hasNext()) {
			IFormItem iFormItem2 = formItems.next();
			IPSDEFormItem formitem = (IPSDEFormItem) iFormItem2;
			// formitem.name}
			iFormItem = this.createFormItem(formitem.getName());
			if (iFormItem == null) {
				SearchFormItemModel  formItem = new SearchFormItemModel ();
				formItem.setForm(this);
				formItem.setName(formitem.getName());
				formItem.setDEFName(formitem.getDEFName());
				if (formitem.getEnableCond() != 3) {
					formItem.setEnableCond(formitem.getEnableCond());
				}
				if (formitem.getIgnoreInput() != 0) {
					formItem.setIgnoreInput(formitem.getIgnoreInput());
				}
				if (!StringHelper.isNullOrEmpty(formitem.getCreateDVT())) {
					formItem.setCreateDVT(formitem.getCreateDVT());
				}
				if (!StringHelper.isNullOrEmpty(formitem.getCreateDV())) {
					formItem.setCreateDV(formitem.getCreateDV());
				}
				if (!StringHelper.isNullOrEmpty(formitem.getUpdateDVT())) {
					formItem.setUpdateDVT(formitem.getUpdateDVT());
				}
				if (!StringHelper.isNullOrEmpty(formitem.getUpdateDV())) {
					formItem.setUpdateDV(formitem.getUpdateDV());
				}
				if (formitem.getCodeList() != null) {
					formItem.setCodeListId(formitem.getCodeList().getId());
				}
				if (!StringHelper.isNullOrEmpty(formitem.getUserDictCatId())) {
					formItem.setUserDictCatId(formitem.getUserDictCatId());
				}
				if (!StringHelper.isNullOrEmpty(formitem.getCaption())) {
					formItem.setCaption(formitem.getCaption());
				}
				if (!formitem.isAllowEmpty()) {
					formItem.setAllowEmpty(false);
				}
				if (formitem.isNeedCodeListConfig()) {
					formItem.setOutputCodeListConfig(true);
					if (!StringHelper.isNullOrEmpty(formitem.getOutputCodeListConfigMode())) {
						formItem.setOutputCodeListConfigMode(formitem.getOutputCodeListConfigMode());
					}
				}
				if (!StringHelper.isNullOrEmpty(formitem.getValueTranslator())) {
					formItem.setValueTranslator(formitem.getValueTranslator());
				}
				if (formitem.getInputTip() != null) {
					formItem.setInputTip(formitem.getInputTip());
				}
				// 设置数据项参数
				if (formitem.getDataItem() != null) {
					IDataItem dataitem = formitem.getDataItem();
					DataItemModel dataItem = new DataItemModel();
					dataItem.setName(formitem.getName());
					if (formitem.getDEField() != null) {
						dataItem.setDataType(formitem.getDEField().getStdDataType());
					}
					dataItem.setFormat(formitem.getDataItem().getFormat());
					if (!StringHelper.isNullOrEmpty(dataitem.getCodeListId())) {
						dataItem.setCodeListId(formitem.getCodeList().getId());
					}
					if (dataitem.getDataItemParams() != null) {
						for (IDataItemParam dataitemparam : dataitem.getDataItemParams()) {
							// 注册参数
							DataItemParamModel dataItemParam = new DataItemParamModel();
							dataItemParam.setName(dataitemparam.getName());
							dataItemParam.setFormat(dataitemparam.getFormat());
							dataItem.addDataItemParam(dataItemParam);
						}
					}
					formItem.setDataItem(dataItem);
				}
				formItem.init();
				iFormItem = formItem;
			}
			this.registerFormItem(iFormItem);
		}

	}

	/**
	 * 填充表单值
	 * 
	 * @param iDataObject
	 * @param bUpdate
	 * @param bIgnoreEmpty
	 * @param formError
	 * @throws Exception
	 */
	@Override
	protected void onFillInputValues(IDataObject iDataObject, boolean bUpdate, boolean bIgnoreEmpty, FormError formError) throws Exception {
		super.onFillInputValues(iDataObject, bUpdate, bIgnoreEmpty, formError);
		if (formError.hasError())
			return;

		// <#list form_fdlogics as fdlogic>
		// ${fdlogic}
		// </#list>

	}
	
	@Override
	public ObjectNode toJsonObject(ObjectNode objectNode) throws Exception {
		if(objectNode == null){
			objectNode = JsonNodeHelper.createObjectNode();
		}
		onFillJsonObject(objectNode);
		return objectNode;
	}
	
	protected void onFillJsonObject(ObjectNode objectNode) throws Exception {
		if(getPSControl()!=null){
			DynaCtrlModelBase.toJsonObject(objectNode,getPSControl());
		}
	}
	
	@Override
	public boolean isDynaCtrl() {
		if(this.getPSControl()!=null){
			return this.getPSControl().isDynamicCtrl();
		}
		return false;
	}
}
