/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.util;

import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.data.IDataItem;
import net.ibizsys.paas.data.IDataItemParam;
import net.ibizsys.paas.data.ISimpleDataObject;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.IWebContext;

public class DataItemHelper {
    public static Object getValue(IDataItem iDataItem, IWebContext iWebContext, Object object) throws Exception {
        if (iDataItem.getDataItemParams() == null || iDataItem.getDataItemParams().length == 0) {
            return DataItemHelper.internalGetDataItemValue(iDataItem, iWebContext, object);
        }
        Object[] objs = new Object[iDataItem.getDataItemParams().length];
        int i = 0;
        while (i < iDataItem.getDataItemParams().length) {
            IDataItemParam iDataItemParam = iDataItem.getDataItemParams()[i];
            objs[i] = DataItemHelper.internalGetDataItemParamValue(iDataItemParam, iWebContext, object);
            ++i;
        }
        return StringHelper.format(iDataItem.getFormat(), objs);
    }

    public static Object getValue2(IDataItem iDataItem, IWebContext iWebContext, Object object) throws Exception {
        if (iDataItem.getDataItemParams() == null || iDataItem.getDataItemParams().length == 0) {
            return DataItemHelper.internalGetDataItemValue(iDataItem, iWebContext, object, true);
        }
        Object[] objs = new Object[iDataItem.getDataItemParams().length];
        int i = 0;
        while (i < iDataItem.getDataItemParams().length) {
            IDataItemParam iDataItemParam = iDataItem.getDataItemParams()[i];
            objs[i] = DataItemHelper.internalGetDataItemParamValue(iDataItemParam, iWebContext, object, true);
            ++i;
        }
        return StringHelper.format(iDataItem.getFormat(), objs);
    }

    protected static Object internalGetDataItemValue(IDataItem iDataItem, IWebContext iWebContext, Object object) throws Exception {
        return DataItemHelper.internalGetDataItemValue(iDataItem, iWebContext, object, false);
    }

    protected static Object internalGetDataItemValue(IDataItem iDataItem, IWebContext iWebContext, Object object, Boolean bConvert) throws Exception {
        if (object instanceof ISimpleDataObject) {
            ICodeList iCodeList;
            String strCodeListId;
            ISimpleDataObject iSimpleDataObject = (ISimpleDataObject)object;
            if (iSimpleDataObject.isNull(iDataItem.getName())) {
                return iDataItem.getDefaultValue();
            }
            Object objValue = iSimpleDataObject.get(iDataItem.getName());
            if (objValue == null) {
                return iDataItem.getDefaultValue();
            }
            if (!StringHelper.isNullOrEmpty(iDataItem.getFormat())) {
                objValue = StringHelper.format(iDataItem.getFormat(), objValue);
            }
            if (bConvert.booleanValue() && !StringHelper.isNullOrEmpty(strCodeListId = iDataItem.getCodeListId()) && (iCodeList = CodeListGlobal.getCodeList(strCodeListId)) != null) {
                return iCodeList.getCodeListText(objValue.toString(), true);
            }
            return objValue;
        }
        throw new Exception(StringHelper.format("\u65e0\u6cd5\u8bc6\u522b\u7684\u6570\u636e\u5bf9\u8c61"));
    }

    protected static Object internalGetDataItemParamValue(IDataItemParam iDataItemParam, IWebContext iWebContext, Object object) throws Exception {
        return DataItemHelper.internalGetDataItemParamValue(iDataItemParam, iWebContext, object, false);
    }

    protected static Object internalGetDataItemParamValue(IDataItemParam iDataItemParam, IWebContext iWebContext, Object object, Boolean bConvert) throws Exception {
        if (object instanceof ISimpleDataObject) {
            ICodeList iCodeList;
            String strCodeListId;
            ISimpleDataObject iSimpleDataObject = (ISimpleDataObject)object;
            if (iSimpleDataObject.isNull(iDataItemParam.getName())) {
                return iDataItemParam.getDefaultValue();
            }
            Object objValue = iSimpleDataObject.get(iDataItemParam.getName());
            if (objValue == null) {
                return iDataItemParam.getDefaultValue();
            }
            if (!StringHelper.isNullOrEmpty(iDataItemParam.getFormat())) {
                objValue = StringHelper.format(iDataItemParam.getFormat(), objValue);
            }
            if (bConvert.booleanValue() && !StringHelper.isNullOrEmpty(strCodeListId = iDataItemParam.getCodeListId()) && (iCodeList = CodeListGlobal.getCodeList(strCodeListId)) != null) {
                return iCodeList.getCodeListText(objValue.toString(), true);
            }
            return objValue;
        }
        throw new Exception(StringHelper.format("\u65e0\u6cd5\u8bc6\u522b\u7684\u6570\u636e\u5bf9\u8c61"));
    }
}

