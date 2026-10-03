package net.ibizsys.paas.ctrlmodel;

import net.ibizsys.paas.control.ControlTypes;
import net.ibizsys.paas.control.form.IFormItem;
import net.ibizsys.paas.ctrlmodel.form.DynaFormModelBase;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.entity.EntityError;
import net.ibizsys.paas.entity.EntityException;
import net.ibizsys.paas.entity.EntityFieldError;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.WebContext;
import net.sf.json.JSONObject;

/**
 * 动态编辑表单模型
 * @author Administrator
 *
 */
public abstract class DynaEditFormModelBase extends DynaFormModelBase implements IDynaEditFormModel
{
	@Override
	public String getControlType() {
		return ControlTypes.EditForm;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.ctrlmodel.FormModelBase#fillOutputDatas(net.ibizsys.paas.data.IDataObject, boolean, net.sf.json.JSONObject, net.sf.json.JSONObject, net.sf.json.JSONObject)
	 */
	@Override
	public void fillOutputDatas(IDataObject iDataObject, boolean bUpdate, JSONObject data, JSONObject state, JSONObject config) throws Exception {
		if (iDataObject == null) throw new Exception(StringHelper.format("数据对象无效"));

		if (!iDataObject.contains(IFormItem.UF)) {
			iDataObject.set(IFormItem.UF, bUpdate ? 1 : 0);
		}

		if (!iDataObject.contains(IFormItem.SOURCEKEY)) {
			iDataObject.set(IFormItem.SOURCEKEY, "");
		}

		if (!iDataObject.contains(IFormItem.DEID)) {
			if (this.getViewController().getDEModel() != null) {
				iDataObject.set(IFormItem.DEID, this.getViewController().getDEModel().getId());
			}
		}

		super.fillOutputDatas(iDataObject, bUpdate, data, state, config);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.ctrlmodel.IEditFormModel#testValueRule(net.ibizsys.paas.service.IService, net.ibizsys.paas.data.IDataObject, boolean)
	 */
	@Override
	public void testValueRule(IService iService, IDataObject iDataObject, boolean bUpdate) throws Exception {
		EntityError entityError = new EntityError();
		onTestValueRule(iService, iDataObject, bUpdate, entityError);
		if (entityError.hasError()) {
			throw new EntityException(entityError);
		}
	}

	/**
	 * 检查表单值规则
	 * 
	 * @param iService
	 * @param iDataObject
	 * @param bUpdate
	 * @param entityError
	 * @throws Exception
	 */
	protected void onTestValueRule(IService iService, IDataObject iDataObject, boolean bUpdate, EntityError entityError) throws Exception {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.ctrlmodel.IEditFormModel#convertEntityFieldError(net.ibizsys.paas.entity.EntityFieldError)
	 */
	@Override
	public boolean convertEntityFieldError(EntityFieldError entityFieldError) throws Exception {
		IFormItem iFormItem = this.getFormItem(entityFieldError.getFieldName(), true);
		if (iFormItem != null) {
			if (WebContext.getCurrent() != null) {
				entityFieldError.setFieldLogicName(WebContext.getCurrent().getLocalization(iFormItem.getCapLanId(), iFormItem.getCaption()));
			} else {
				entityFieldError.setFieldLogicName(iFormItem.getCaption());
			}
			return true;
		}
		return false;
	}
	
}
