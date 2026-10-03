package net.ibizsys.paas.datamodel;

import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.core.IActionContext;
import net.ibizsys.paas.core.ISystem;
import net.ibizsys.paas.core.ModelBaseImpl;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.data.IDataItem;
import net.ibizsys.paas.data.IDataItemParam;
import net.ibizsys.paas.data.ISimpleDataObject;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.IWebContext;

/**
 * 数据项参数对象，基于注解实现
 * 
 * @author lionlau
 *
 */
public class DataItemParamModel3 extends ModelBaseImpl implements IDataItemParam {
	private String strFormat = "";
	private String strName = null;
	private Object objDefaultValue = null;
	private String strCodeListId = null;
	private IDataItem iDataItem = null;
	private DataItemParam dataItemParam = null;

	public DataItemParamModel3() {

	}

	/**
	 * 初始化
	 * 
	 * @param iDataItem
	 * @param dataItemParam
	 */
	public void init(IDataItem iDataItem, DataItemParam dataItemParam) {
		this.iDataItem = iDataItem;
		this.dataItemParam = dataItemParam;

		if (!StringHelper.isNullOrEmpty(dataItemParam.name())) this.setName(dataItemParam.name());
		if (!StringHelper.isNullOrEmpty(dataItemParam.format())) this.setFormat(dataItemParam.format());
		if (!StringHelper.isNullOrEmpty(dataItemParam.defaultvalue())) this.setDefaultValue(dataItemParam.defaultvalue());
		if (!StringHelper.isNullOrEmpty(dataItemParam.codelistid())) this.setCodeListId(dataItemParam.codelistid());
	}

	/**
	 * 初始化
	 * 
	 * @param iDataItem
	 * @param dataItemParam
	 */
	public void init(IDataItem iDataItem, IDataItemParam dataItemParam) {
		this.iDataItem = iDataItem;
		if (!StringHelper.isNullOrEmpty(dataItemParam.getName())) this.setName(dataItemParam.getName());
		if (!StringHelper.isNullOrEmpty(dataItemParam.getFormat())) this.setFormat(dataItemParam.getFormat());
		if (!StringHelper.isNullOrEmpty(dataItemParam.getDefaultValue())) this.setDefaultValue(dataItemParam.getDefaultValue());
		if (!StringHelper.isNullOrEmpty(dataItemParam.getCodeListId())) this.setCodeListId(dataItemParam.getCodeListId());
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.data.IDataItemParam#getFormat()
	 */
	@Override
	public String getFormat() {
		return strFormat;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.ModelBaseImpl#getName()
	 */
	@Override
	public String getName() {
		return strName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.data.IDataItemParam#getDefaultValue()
	 */
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
	 * 设置项名称
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.data.IDataItemParam#getValue(net.ibizsys.paas.web.IWebContext, java.lang.Object)
	 */
	@Override
	public Object getValue(IWebContext iWebContext, Object object) throws Exception {
		if (object instanceof ISimpleDataObject) {
			ISimpleDataObject iSimpleDataObject = (ISimpleDataObject) object;
			if (iSimpleDataObject.isNull(getName())) return this.getDefaultValue();

			Object objValue = iSimpleDataObject.get(this.getName());
			if (objValue == null) return this.getDefaultValue();

			if (!StringHelper.isNullOrEmpty(this.getFormat())) {
				objValue = StringHelper.format(this.getFormat(), objValue);
			}

			if (!StringHelper.isNullOrEmpty(getCodeListId())) {
				ICodeList iCodeList = getCodeList(iWebContext, getCodeListId());
				return iCodeList.getCodeListText(objValue.toString(), true, object, iWebContext);
			}
			return objValue;
		}

		throw new Exception(StringHelper.format("无法识别的数据对象"));
	}

	/**
	 * 获取指定代码表对象
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
	 * 设置代码表标识
	 * 
	 * @param strCodeListId
	 */
	public void setCodeListId(String strCodeListId) {
		this.strCodeListId = strCodeListId;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.data.IDataItemParam#getCodeListId()
	 */
	public String getCodeListId() {
		return this.strCodeListId;
	}

	/**
	 * 获取当前的系统
	 * 
	 * @param iActionContext 行为上下文
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
	protected IDataItem getDataItem() {
		return iDataItem;
	}

	/**
	 * 设置数据项对象
	 * 
	 * @param iDataItem
	 */
	protected void setDataItem(IDataItem iDataItem) {
		this.iDataItem = iDataItem;
	}

}
