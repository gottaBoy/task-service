/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.util;

import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.paas.core.IDEField;
import net.ibizsys.paas.data.DEFieldDiffItem;
import net.ibizsys.paas.data.IDEFieldDiffItem;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.sysmodel.ICodeListModel;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.StringHelper;

public class DEModelUtil {
    public static ArrayList<IDEFieldDiffItem> getDEDataDiffItems(IDataEntityModel iDEModel, IEntity curData, IEntity oldData) throws Exception {
        return DEModelUtil.getDEDataDiffItems(iDEModel, curData, oldData, false);
    }

    public static ArrayList<IDEFieldDiffItem> getDEDataDiffItems(IDataEntityModel iDEModel, IEntity curData, IEntity oldData, boolean bOnlyEnableAudit) throws Exception {
        ArrayList<IDEFieldDiffItem> deFieldDiffItemList = new ArrayList<IDEFieldDiffItem>();
        Iterator<IDEField> deFields = iDEModel.getDEFields();
        while (deFields.hasNext()) {
            IDEField iDEField = deFields.next();
            if (!iDEField.isPhisicalDEField() || bOnlyEnableAudit && !iDEField.isEnableAudit() || StringHelper.compare(iDEField.getPreDefinedType(), "CREATEDATE", true) == 0 || StringHelper.compare(iDEField.getPreDefinedType(), "CREATEMAN", true) == 0 || StringHelper.compare(iDEField.getPreDefinedType(), "CREATEMANNAME", true) == 0 || StringHelper.compare(iDEField.getPreDefinedType(), "LOGICVALID", true) == 0 || StringHelper.compare(iDEField.getPreDefinedType(), "UPDATEDATE", true) == 0 || StringHelper.compare(iDEField.getPreDefinedType(), "UPDATEMAN", true) == 0 || StringHelper.compare(iDEField.getPreDefinedType(), "UPDATEMANNAME", true) == 0 || StringHelper.compare(iDEField.getDataType(), "PICKUP", true) == 0) continue;
            Object objNewValue = curData.get(iDEField.getName());
            Object objOldValue = oldData.get(iDEField.getName());
            if (objNewValue == null && objOldValue == null || objNewValue != null && objOldValue != null && DataTypeHelper.compare(iDEField.getStdDataType(), objNewValue, objOldValue) == 0L) continue;
            String strNewValueText = "";
            String strOldValueText = "";
            ICodeListModel codeListConfig = null;
            String strCodeListId = iDEField.getCodeListId();
            if (!StringHelper.isNullOrEmpty(strCodeListId)) {
                codeListConfig = (ICodeListModel)CodeListGlobal.getCodeList(strCodeListId);
                if (objNewValue != null && codeListConfig != null) {
                    strNewValueText = codeListConfig.getCodeListText(objNewValue.toString(), true);
                }
                if (objOldValue != null && codeListConfig != null) {
                    strOldValueText = codeListConfig.getCodeListText(objOldValue.toString(), true);
                }
            } else {
                String strItemFormat = iDEField.getValueFormat();
                if (StringHelper.isNullOrEmpty(strItemFormat)) {
                    strItemFormat = "%1$s";
                }
                if (objNewValue != null) {
                    strNewValueText = StringHelper.format(strItemFormat, objNewValue);
                }
                if (objOldValue != null) {
                    strOldValueText = StringHelper.format(strItemFormat, objOldValue);
                }
            }
            DEFieldDiffItem deFieldDiffItem = new DEFieldDiffItem();
            deFieldDiffItem.setDEField(iDEField);
            deFieldDiffItem.setNewText(strNewValueText);
            deFieldDiffItem.setOldText(strOldValueText);
            deFieldDiffItem.setNewValue(objNewValue);
            deFieldDiffItem.setOldValue(objOldValue);
            deFieldDiffItemList.add(deFieldDiffItem);
        }
        return deFieldDiffItemList;
    }
}

