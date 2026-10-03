package net.ibizsys.paas.data.impl;

import java.util.ArrayList;

import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.controller.ViewController;
import net.ibizsys.paas.core.DataTypes;
import net.ibizsys.paas.core.IActionContext;
import net.ibizsys.paas.core.ISystem;
import net.ibizsys.paas.data.IDataItem;
import net.ibizsys.paas.data.IDataItemParam;
import net.ibizsys.paas.data.ISimpleDataObject;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.IWebContext;

/**
 * 数据对象接口实现对象
 * 
 * @author lionlau
 *
 */
public class DataItemImpl extends DataItemParamImpl implements IDataItem {
	private ArrayList<IDataItemParam> dataItemParamList = null;
	private int nDataType = DataTypes.VARCHAR;
	private IDataItemParam[] dataItemParams = null;
	private boolean bMSTag = false;

	public DataItemImpl() {
		this.setFormat("%1$s");
	}

	@Override
	protected void onInit() throws Exception {
		if (StringHelper.compare(this.getName(), MSTAG, true) == 0) {
			bMSTag = true;
		}
		super.onInit();
	}

	/**
	 * 添加数据项参数
	 * 
	 * @param iDSItemParam
	 */
	public void addDataItemParam(IDataItemParam iDSItemParam) {
		if(this.dataItemParamList == null){
			this.dataItemParamList = new ArrayList<IDataItemParam>();
		}
		this.dataItemParamList.add(iDSItemParam);
		this.dataItemParams = this.dataItemParamList.toArray(new IDataItemParam[this.dataItemParamList.size()]);
	}

	@Override
	public IDataItemParam[] getDataItemParams() {
		if (dataItemParamList == null || dataItemParamList.size() == 0){
			return null;
		}

		return this.dataItemParams;
	}

	@Override
	public ISystem getCurSystem(IActionContext iActionContext) throws Exception {
		return null;
	}

	@Override
	public Object getValue(IWebContext iWebContext, Object object) throws Exception {
		if (bMSTag) {
			return StringHelper.format("MSTAG:%1$s", getDEModel().getDEMainStateTag((ISimpleDataObject) object));
		}
		if (this.dataItemParamList == null || this.dataItemParamList.size() == 0) {
			return super.getValue(iWebContext, object);
		}

		Object[] objs = new Object[this.dataItemParamList.size()];
		for (int i = 0; i < this.dataItemParamList.size(); i++) {
			IDataItemParam iDataItemParam = this.dataItemParamList.get(i);
			objs[i] = iDataItemParam.getValue(iWebContext, object);
			if (objs[i] == null) {
				return getDefaultValue();
			}
		}

		String strValue = StringHelper.format(this.getFormat(), objs);
		if (!StringHelper.isNullOrEmpty(getCodeListId())) {
			ICodeList iCodeList = getCodeList(iWebContext, getCodeListId());
			strValue = iCodeList.getCodeListText(strValue, true, object, iWebContext);
		}
		return strValue;

	}

	@Override
	public int getDataType() {
		return nDataType;
	}

	/**
	 * 设置标准数据类型
	 * 
	 * @param nDataType
	 */
	public void setDataType(int nDataType) {
		this.nDataType = nDataType;
	}

	/**
	 * 获取实体模型对象
	 * 
	 * @return
	 * @throws Exception
	 */
	protected IDataEntityModel getDEModel() throws Exception {
		return ViewController.getCurrent().getDEModel();
	}

}
