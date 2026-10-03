package net.ibizsys.paas.data.impl;

import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.core.IActionContext;
import net.ibizsys.paas.core.ISystem;
import net.ibizsys.paas.core.ModelBaseImpl;
import net.ibizsys.paas.data.IDataItem;
import net.ibizsys.paas.data.IDataItemParam;
import net.ibizsys.paas.data.ISimpleDataObject;
import net.ibizsys.paas.datamodel.DataItemModel3;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.IWebContext;

/**
 * 数据项参数对象
 * 
 * @author lionlau
 *
 */
public class DataItemParamImpl extends ModelBaseImpl implements IDataItemParam {
	private String strFormat = "";
	private Object objDefaultValue = null;
	private String strCodeListId = null;
	private IDataItem iDataItem = null;

	public DataItemParamImpl() {

	}

	@Override
	public String getFormat() {
		return strFormat;
	}

	@Override
	public Object getDefaultValue() {
		return this.objDefaultValue;
	}

	/**
	 * 设置值格式化
	 * 
	 * @param strFormat
	 */
	public void setFormat(String strFormat) {
		this.strFormat = strFormat;
	}

	/**
	 * 设置数据项名称
	 * 
	 * @param strName
	 */
	public void setName(String strName) {
		this.strName = strName;
	}

	/**
	 * 设置默认值
	 * 
	 * @param objDefaultValue
	 */
	public void setDefaultValue(Object objDefaultValue) {
		this.objDefaultValue = objDefaultValue;
	}

	@Override
	public Object getValue(IWebContext iWebContext, Object object) throws Exception {
		if (object instanceof ISimpleDataObject) {
			ISimpleDataObject iSimpleDataObject = (ISimpleDataObject) object;
			if (iSimpleDataObject.isNull(getName())) return this.getDefaultValue();

			Object objValue = iSimpleDataObject.get(this.getName());
			if (objValue == null) return this.getDefaultValue();

			if (!StringHelper.isNullOrEmpty(getCodeListId())) {
				ICodeList iCodeList = getCodeList(iWebContext, getCodeListId());
				objValue = iCodeList.getCodeListText(objValue.toString(), true, object, iWebContext);
			}

			if (!StringHelper.isNullOrEmpty(this.getFormat())) {
				objValue = StringHelper.format(this.getFormat(), objValue);
			}
			return objValue;
		}

		throw new Exception(StringHelper.format("无法识别的数据对象"));
	}

	/**
	 * 获取代码表对象
	 * 
	 * @param iWebContext
	 * @param strCodeListId
	 * @return
	 * @throws Exception
	 */
	protected ICodeList getCodeList(IWebContext iWebContext, String strCodeListId) throws Exception {
		return CodeListGlobal.getCodeList(strCodeListId);
	}

	/**
	 * 设置代码表对象标识
	 * 
	 * @param strCodeListId
	 */
	public void setCodeListId(String strCodeListId) {
		this.strCodeListId = strCodeListId;
	}

	public String getCodeListId() {
		return this.strCodeListId;
	}

	/**
	 * 获取当前系统
	 * 
	 * @param iActionContext
	 * @return
	 * @throws Exception
	 */
	public ISystem getCurSystem(IActionContext iActionContext) throws Exception {
		if (this.iDataItem != null && (this.iDataItem instanceof DataItemModel3)) {
			((DataItemModel3) this.iDataItem).getCurSystem(iActionContext);
		}
		return null;
	}

	/**
	 * 获取数据项对象
	 * 
	 * @return
	 */
	public IDataItem getDataItem() {
		return iDataItem;
	}

	/**
	 * 设置数据项对象
	 * 
	 * @param iDataItem
	 */
	public void setDataItem(IDataItem iDataItem) {
		this.iDataItem = iDataItem;
	}

}
