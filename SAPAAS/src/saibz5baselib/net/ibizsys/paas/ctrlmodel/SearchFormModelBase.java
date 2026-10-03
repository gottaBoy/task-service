package net.ibizsys.paas.ctrlmodel;

import net.ibizsys.paas.control.ControlTypes;
import net.ibizsys.paas.control.form.IFormItem;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.util.StringHelper;

/**
 * 搜索表单模型
 * 
 * @author lionlau
 *
 */
public abstract class SearchFormModelBase extends FormModelBase implements ISearchFormModel {
	@Override
	public String getControlType() {
		return ControlTypes.SearchForm;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.ctrlmodel.FormModelBase#onFillDefaultValues(net.ibizsys.paas.data.IDataObject, boolean)
	 */
	protected void onFillDefaultValues(IDataObject iDataObject, boolean bUpdate) throws Exception {
		java.util.Iterator<IFormItem> formItems = this.getFormItems();

		// 值预处理
		while (formItems.hasNext()) {
			IFormItem iFormItem = formItems.next();
			if (iDataObject.get(iFormItem.getName()) != null) continue;

			Object objValue = iFormItem.getDefaultValue(this.getViewController().getWebContext(), bUpdate);
			if (objValue != null && (objValue instanceof String)) {
				String strValue = (String) objValue;
				if (StringHelper.isNullOrEmpty(strValue)) objValue = null;
			}
			if (objValue == null) {
				objValue = this.getViewController().getWebContext().getPostValue(iFormItem.getName());
			}
			if (objValue == null) {
				continue;
			}
			iDataObject.set(iFormItem.getName(), objValue);
		}
	}
}
