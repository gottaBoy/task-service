package net.ibizsys.paas.datamodel;

import java.util.ArrayList;

import net.ibizsys.paas.core.DataTypes;
import net.ibizsys.paas.core.IActionContext;
import net.ibizsys.paas.core.ISystem;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.data.IDataItem;
import net.ibizsys.paas.data.IDataItemParam;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.IWebContext;

/**
 * 数据对象模型，基于注解实现
 * 
 * @author Administrator
 *
 */
public class DataItemModel3 extends DataItemParamModel3 implements IDataItem {
	private ArrayList<IDataItemParam> dataItemParamList = new ArrayList<IDataItemParam>();
	private int nDataType = DataTypes.VARCHAR;
	private IDataItemParam[] dataItemParams = null;
	private DataItem dataItem = null;

	public DataItemModel3() {
		this.setFormat("%1$s");
	}

	/**
	 * 初始化
	 * 
	 * @param dataItem
	 */
	public void init(DataItem dataItem) {

		this.dataItem = dataItem;
		if (!StringHelper.isNullOrEmpty(this.dataItem.name())) this.setName(this.dataItem.name());
		if (!StringHelper.isNullOrEmpty(this.dataItem.format())) this.setFormat(this.dataItem.format());
		if (!StringHelper.isNullOrEmpty(this.dataItem.defaultvalue())) this.setDefaultValue(this.dataItem.defaultvalue());
		if (!StringHelper.isNullOrEmpty(this.dataItem.codelistid())) this.setCodeListId(this.dataItem.codelistid());
		if (this.dataItem.datatype() != DataTypes.UNKNOWN) {
			this.setDataType(this.dataItem.datatype());
		}

		if (dataItem.dataitemparams() != null) {
			for (DataItemParam dataItemParam : dataItem.dataitemparams()) {
				DataItemParamModel3 dataItemParamModel = new DataItemParamModel3();
				dataItemParamModel.init(this, dataItemParam);
				this.addDataItemParam(dataItemParamModel);
			}
		}
	}
	
	/**
	 * 初始化
	 * 
	 * @param dataItem
	 */
	public void init(IDataItem iDataItem) {

		if (!StringHelper.isNullOrEmpty(iDataItem.getName())) this.setName(iDataItem.getName());
		if (!StringHelper.isNullOrEmpty(iDataItem.getFormat())) this.setFormat(iDataItem.getFormat());
		if (!StringHelper.isNullOrEmpty(iDataItem.getDefaultValue())) this.setDefaultValue(iDataItem.getDefaultValue());
		if (!StringHelper.isNullOrEmpty(iDataItem.getCodeListId())) this.setCodeListId(iDataItem.getCodeListId());
		if (iDataItem.getDataType() != DataTypes.UNKNOWN) {
			this.setDataType(iDataItem.getDataType());
		}

		if(iDataItem.getDataItemParams()!=null){
			for (IDataItemParam dataItemParam : iDataItem.getDataItemParams()) {
				DataItemParamModel3 dataItemParamModel = new DataItemParamModel3();
				dataItemParamModel.init(this, dataItemParam);
				this.addDataItemParam(dataItemParamModel);
			}
		}
	}
	

	/**
	 * 添加数据项参数
	 * 
	 * @param iDSItemParam
	 */
	public void addDataItemParam(IDataItemParam iDSItemParam) {
		this.dataItemParamList.add(iDSItemParam);
		dataItemParams = this.dataItemParamList.toArray(new IDataItemParam[this.dataItemParamList.size()]);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.data.IDataItem#getDataItemParams()
	 */
	@Override
	public IDataItemParam[] getDataItemParams() {
		if (dataItemParamList == null || dataItemParamList.size() == 0) return null;

		return this.dataItemParams;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.datamodel.DataItemParamModel3#getCurSystem(net.ibizsys.paas.core.IActionContext)
	 */
	@Override
	public ISystem getCurSystem(IActionContext iActionContext) throws Exception {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.datamodel.DataItemParamModel3#getValue(net.ibizsys.paas.web.IWebContext, java.lang.Object)
	 */
	@Override
	public Object getValue(IWebContext iWebContext, Object object) throws Exception {
		if (this.dataItemParamList.size() == 0) {
			return super.getValue(iWebContext, object);
		}

		Object[] objs = new Object[this.dataItemParamList.size()];
		for (int i = 0; i < this.dataItemParamList.size(); i++) {
			IDataItemParam iNUDSItemParam = this.dataItemParamList.get(i);
			objs[i] = iNUDSItemParam.getValue(iWebContext, object);
		}

		return StringHelper.format(this.getFormat(), objs);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.data.IDataItem#getDataType()
	 */
	@Override
	public int getDataType() {
		return nDataType;
	}

	/**
	 * 设置标准数据类型
	 * 
	 * @param nDataType the nDataType to set
	 */
	protected void setDataType(int nDataType) {
		this.nDataType = nDataType;
	}

}
