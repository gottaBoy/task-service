/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.data.impl;

import java.util.ArrayList;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.controller.ViewController;
import net.ibizsys.paas.core.IActionContext;
import net.ibizsys.paas.core.ISystem;
import net.ibizsys.paas.data.IDataItem;
import net.ibizsys.paas.data.IDataItemParam;
import net.ibizsys.paas.data.ISimpleDataObject;
import net.ibizsys.paas.data.impl.DataItemParamImpl;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.IWebContext;

public class DataItemImpl
extends DataItemParamImpl
implements IDataItem {
    private ArrayList<IDataItemParam> dataItemParamList = null;
    private int nDataType = 25;
    private IDataItemParam[] dataItemParams = null;
    private boolean bMSTag = false;

    public DataItemImpl() {
        this.setFormat("%1$s");
    }

    @Override
    protected void onInit() throws Exception {
        if (StringHelper.compare(this.getName(), "srfmstag", true) == 0) {
            this.bMSTag = true;
        }
        super.onInit();
    }

    public void addDataItemParam(IDataItemParam iDSItemParam) {
        if (this.dataItemParamList == null) {
            this.dataItemParamList = new ArrayList();
        }
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
        if (this.bMSTag) {
            return StringHelper.format("MSTAG:%1$s", this.getDEModel().getDEMainStateTag((ISimpleDataObject)object));
        }
        if (this.dataItemParamList == null || this.dataItemParamList.size() == 0) {
            return super.getValue(iWebContext, object);
        }
        Object[] objs = new Object[this.dataItemParamList.size()];
        int i = 0;
        while (i < this.dataItemParamList.size()) {
            IDataItemParam iDataItemParam = this.dataItemParamList.get(i);
            objs[i] = iDataItemParam.getValue(iWebContext, object);
            if (objs[i] == null) {
                return this.getDefaultValue();
            }
            ++i;
        }
        String strValue = StringHelper.format(this.getFormat(), objs);
        if (!StringHelper.isNullOrEmpty(this.getCodeListId())) {
            ICodeList iCodeList = this.getCodeList(iWebContext, this.getCodeListId());
            strValue = iCodeList.getCodeListText(strValue, true, object, iWebContext);
        }
        return strValue;
    }

    @Override
    public int getDataType() {
        return this.nDataType;
    }

    public void setDataType(int nDataType) {
        this.nDataType = nDataType;
    }

    protected IDataEntityModel getDEModel() throws Exception {
        return ViewController.getCurrent().getDEModel();
    }
}

