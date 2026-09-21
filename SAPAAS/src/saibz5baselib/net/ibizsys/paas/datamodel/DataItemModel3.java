/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.datamodel;

import java.util.ArrayList;
import net.ibizsys.paas.core.IActionContext;
import net.ibizsys.paas.core.ISystem;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.data.IDataItem;
import net.ibizsys.paas.data.IDataItemParam;
import net.ibizsys.paas.datamodel.DataItemParamModel3;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.IWebContext;

public class DataItemModel3
extends DataItemParamModel3
implements IDataItem {
    private ArrayList<IDataItemParam> dataItemParamList = new ArrayList();
    private int nDataType = 25;
    private IDataItemParam[] dataItemParams = null;
    private DataItem dataItem = null;

    public DataItemModel3() {
        this.setFormat("%1$s");
    }

    public void init(DataItem dataItem) {
        this.dataItem = dataItem;
        if (!StringHelper.isNullOrEmpty(this.dataItem.name())) {
            this.setName(this.dataItem.name());
        }
        if (!StringHelper.isNullOrEmpty(this.dataItem.format())) {
            this.setFormat(this.dataItem.format());
        }
        if (!StringHelper.isNullOrEmpty(this.dataItem.defaultvalue())) {
            this.setDefaultValue(this.dataItem.defaultvalue());
        }
        if (!StringHelper.isNullOrEmpty(this.dataItem.codelistid())) {
            this.setCodeListId(this.dataItem.codelistid());
        }
        if (this.dataItem.datatype() != 0) {
            this.setDataType(this.dataItem.datatype());
        }
        if (dataItem.dataitemparams() != null) {
            DataItemParam[] dataItemParamArray = dataItem.dataitemparams();
            int n = dataItemParamArray.length;
            int n2 = 0;
            while (n2 < n) {
                DataItemParam dataItemParam = dataItemParamArray[n2];
                DataItemParamModel3 dataItemParamModel = new DataItemParamModel3();
                dataItemParamModel.init((IDataItem)this, dataItemParam);
                this.addDataItemParam(dataItemParamModel);
                ++n2;
            }
        }
    }

    public void init(IDataItem iDataItem) {
        if (!StringHelper.isNullOrEmpty(iDataItem.getName())) {
            this.setName(iDataItem.getName());
        }
        if (!StringHelper.isNullOrEmpty(iDataItem.getFormat())) {
            this.setFormat(iDataItem.getFormat());
        }
        if (!StringHelper.isNullOrEmpty(iDataItem.getDefaultValue())) {
            this.setDefaultValue(iDataItem.getDefaultValue());
        }
        if (!StringHelper.isNullOrEmpty(iDataItem.getCodeListId())) {
            this.setCodeListId(iDataItem.getCodeListId());
        }
        if (iDataItem.getDataType() != 0) {
            this.setDataType(iDataItem.getDataType());
        }
        if (iDataItem.getDataItemParams() != null) {
            IDataItemParam[] iDataItemParamArray = iDataItem.getDataItemParams();
            int n = iDataItemParamArray.length;
            int n2 = 0;
            while (n2 < n) {
                IDataItemParam dataItemParam = iDataItemParamArray[n2];
                DataItemParamModel3 dataItemParamModel = new DataItemParamModel3();
                dataItemParamModel.init((IDataItem)this, dataItemParam);
                this.addDataItemParam(dataItemParamModel);
                ++n2;
            }
        }
    }

    public void addDataItemParam(IDataItemParam iDSItemParam) {
        this.dataItemParamList.add(iDSItemParam);
        this.dataItemParams = this.dataItemParamList.toArray(new IDataItemParam[this.dataItemParamList.size()]);
    }

    @Override
    public IDataItemParam[] getDataItemParams() {
        if (this.dataItemParamList == null || this.dataItemParamList.size() == 0) {
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
        if (this.dataItemParamList.size() == 0) {
            return super.getValue(iWebContext, object);
        }
        Object[] objs = new Object[this.dataItemParamList.size()];
        int i = 0;
        while (i < this.dataItemParamList.size()) {
            IDataItemParam iNUDSItemParam = this.dataItemParamList.get(i);
            objs[i] = iNUDSItemParam.getValue(iWebContext, object);
            ++i;
        }
        return StringHelper.format(this.getFormat(), objs);
    }

    @Override
    public int getDataType() {
        return this.nDataType;
    }

    protected void setDataType(int nDataType) {
        this.nDataType = nDataType;
    }
}

