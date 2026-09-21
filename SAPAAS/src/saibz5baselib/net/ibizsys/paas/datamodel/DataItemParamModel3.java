/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.datamodel;

import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.core.IActionContext;
import net.ibizsys.paas.core.ISystem;
import net.ibizsys.paas.core.ModelBaseImpl;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.data.IDataItem;
import net.ibizsys.paas.data.IDataItemParam;
import net.ibizsys.paas.data.ISimpleDataObject;
import net.ibizsys.paas.datamodel.DataItemModel3;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.IWebContext;

public class DataItemParamModel3
extends ModelBaseImpl
implements IDataItemParam {
    private String strFormat = "";
    private String strName = null;
    private Object objDefaultValue = null;
    private String strCodeListId = null;
    private IDataItem iDataItem = null;
    private DataItemParam dataItemParam = null;

    public void init(IDataItem iDataItem, DataItemParam dataItemParam) {
        this.iDataItem = iDataItem;
        this.dataItemParam = dataItemParam;
        if (!StringHelper.isNullOrEmpty(dataItemParam.name())) {
            this.setName(dataItemParam.name());
        }
        if (!StringHelper.isNullOrEmpty(dataItemParam.format())) {
            this.setFormat(dataItemParam.format());
        }
        if (!StringHelper.isNullOrEmpty(dataItemParam.defaultvalue())) {
            this.setDefaultValue(dataItemParam.defaultvalue());
        }
        if (!StringHelper.isNullOrEmpty(dataItemParam.codelistid())) {
            this.setCodeListId(dataItemParam.codelistid());
        }
    }

    public void init(IDataItem iDataItem, IDataItemParam dataItemParam) {
        this.iDataItem = iDataItem;
        if (!StringHelper.isNullOrEmpty(dataItemParam.getName())) {
            this.setName(dataItemParam.getName());
        }
        if (!StringHelper.isNullOrEmpty(dataItemParam.getFormat())) {
            this.setFormat(dataItemParam.getFormat());
        }
        if (!StringHelper.isNullOrEmpty(dataItemParam.getDefaultValue())) {
            this.setDefaultValue(dataItemParam.getDefaultValue());
        }
        if (!StringHelper.isNullOrEmpty(dataItemParam.getCodeListId())) {
            this.setCodeListId(dataItemParam.getCodeListId());
        }
    }

    @Override
    public String getFormat() {
        return this.strFormat;
    }

    @Override
    public String getName() {
        return this.strName;
    }

    @Override
    public Object getDefaultValue() {
        return this.objDefaultValue;
    }

    public void setFormat(String strFormat) {
        this.strFormat = strFormat;
    }

    public void setName(String strName) {
        this.strName = strName;
    }

    public void setDefaultValue(Object objDefaultValue) {
        this.objDefaultValue = objDefaultValue;
    }

    @Override
    public Object getValue(IWebContext iWebContext, Object object) throws Exception {
        if (object instanceof ISimpleDataObject) {
            ISimpleDataObject iSimpleDataObject = (ISimpleDataObject)object;
            if (iSimpleDataObject.isNull(this.getName())) {
                return this.getDefaultValue();
            }
            Object objValue = iSimpleDataObject.get(this.getName());
            if (objValue == null) {
                return this.getDefaultValue();
            }
            if (!StringHelper.isNullOrEmpty(this.getFormat())) {
                objValue = StringHelper.format(this.getFormat(), objValue);
            }
            if (!StringHelper.isNullOrEmpty(this.getCodeListId())) {
                ICodeList iCodeList = this.getCodeList(iWebContext, this.getCodeListId());
                return iCodeList.getCodeListText(objValue.toString(), true, object, iWebContext);
            }
            return objValue;
        }
        throw new Exception(StringHelper.format("\u65e0\u6cd5\u8bc6\u522b\u7684\u6570\u636e\u5bf9\u8c61"));
    }

    protected ICodeList getCodeList(IWebContext iWebContext, String strCodeListId) throws Exception {
        return CodeListGlobal.getCodeList(strCodeListId);
    }

    public void setCodeListId(String strCodeListId) {
        this.strCodeListId = strCodeListId;
    }

    @Override
    public String getCodeListId() {
        return this.strCodeListId;
    }

    public ISystem getCurSystem(IActionContext iActionContext) throws Exception {
        if (this.iDataItem != null && this.iDataItem instanceof DataItemModel3) {
            ((DataItemModel3)this.iDataItem).getCurSystem(iActionContext);
        }
        return null;
    }

    protected IDataItem getDataItem() {
        return this.iDataItem;
    }

    protected void setDataItem(IDataItem iDataItem) {
        this.iDataItem = iDataItem;
    }
}

