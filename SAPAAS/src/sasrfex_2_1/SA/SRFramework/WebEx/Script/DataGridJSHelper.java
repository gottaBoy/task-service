/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.Script;

import SA.SRFramework.Utility.StringHelper;

public class DataGridJSHelper {
    public static String getClearSelectionScript(String strDataGridId) {
        String strOutput = "";
        strOutput = StringHelper.Format((String)"$P.grid['%1$s'].gridmgr.clearSelections();", (Object)strDataGridId);
        return strOutput;
    }

    public static String getOnRowSelectedEventScript(String strDataGridId, String strEventCode) {
        String strOutput = "";
        strOutput = StringHelper.Format((String)"$P.grid['%1$s'].gridmgr.on('rowselected',function(_T,_R){%2$s});", (Object)strDataGridId, (Object)strEventCode);
        return strOutput;
    }

    public static String getOnRowSelectedCancelEventScript(String strDataGridId, String strEventCode) {
        String strOutput = "";
        strOutput = StringHelper.Format((String)"$P.grid['%1$s'].gridmgr.on('rowselectedcancel',function(_T){%2$s});", (Object)strDataGridId, (Object)strEventCode);
        return strOutput;
    }

    public static String getOnRowClickedEventScript(String strDataGridId, String strEventCode) {
        String strOutput = "";
        strOutput = StringHelper.Format((String)"$P.grid['%1$s'].gridmgr.on('rowclicked',function(_T){%2$s});", (Object)strDataGridId, (Object)strEventCode);
        return strOutput;
    }

    public static String getOnRowDbClickedEventScript(String strDataGridId, String strEventCode) {
        String strOutput = "";
        strOutput = StringHelper.Format((String)"$P.grid['%1$s'].gridmgr.on('rowdbclicked',function(_T){%2$s});", (Object)strDataGridId, (Object)strEventCode);
        return strOutput;
    }

    public static String getOnRowCheckActionEventScript(String strDataGridId, String strEventCode) {
        String strOutput = "";
        strOutput = StringHelper.Format((String)"$P.grid['%1$s'].gridmgr.on('rowcheckaction',function(_T){%2$s});", (Object)strDataGridId, (Object)strEventCode);
        return strOutput;
    }

    public static String getDataReloadScript(String strDataGridId) {
        String strOutput = "";
        strOutput = StringHelper.Format((String)"$P.store['%1$s'].reload();", (Object)strDataGridId);
        return strOutput;
    }

    public static String getDataRemoveScript(String strDataGridId) {
        String strOutput = "";
        strOutput = StringHelper.Format((String)"$P.store['%1$s'].removeAll();", (Object)strDataGridId);
        return strOutput;
    }

    public static String getDataLoadDefaultScript(String strDataGridId) {
        String strOutput = "";
        strOutput = StringHelper.Format((String)"$P.store['%1$s'].loaddefault();", (Object)strDataGridId);
        return strOutput;
    }

    public static String getResetUserParamScript(String strDataGridId) {
        String strOutput = "";
        strOutput = StringHelper.Format((String)"$P.store['%1$s'].userparams = {};", (Object)strDataGridId);
        return strOutput;
    }

    public static String getSetUserParamScript(String strDataGridId, String strKey, String strValue) {
        String strOutput = "";
        strOutput = StringHelper.Format((String)"$P.store['%1$s'].userparams['%2$s'] = %3$s;", (Object)strDataGridId, (Object)strKey.toLowerCase(), (Object)strValue);
        return strOutput;
    }

    public static String getDataGridCheckScript(String strDataGridId, boolean bCheck) {
        String strOutput = "";
        strOutput = StringHelper.Format((String)"$P.grid['%1$s'].gridmgr.checkall(%2$s);", (Object)strDataGridId, (Object)bCheck);
        return strOutput;
    }

    public static String getDataGridCheckAlternativeScript(String strDataGridId) {
        String strOutput = "";
        strOutput = StringHelper.Format((String)"$P.grid['%1$s'].gridmgr.checkalternative();", (Object)strDataGridId);
        return strOutput;
    }

    public static String getDataGridCheckedRows(String strDataGridId) {
        String strOutput = "";
        strOutput = StringHelper.Format((String)"$P.grid['%1$s'].gridmgr.getcheckedrows()", (Object)strDataGridId);
        return strOutput;
    }

    public static String getDataGridCheckedRows(String strDataGridId, String strKey) {
        String strOutput = "";
        strOutput = StringHelper.Format((String)"$P.grid['%1$s'].gridmgr.getcheckedrows2('%2$s')", (Object)strDataGridId, (Object)strKey.toUpperCase());
        return strOutput;
    }

    public static String getDataGridCheckedRows(String strDataGridId, String strKey, boolean bKey) {
        String strOutput = "";
        strKey = bKey ? strKey.toUpperCase() : strKey.toLowerCase();
        strOutput = StringHelper.Format((String)"$P.grid['%1$s'].gridmgr.getcheckedrows2('%2$s')", (Object)strDataGridId, (Object)strKey);
        return strOutput;
    }

    public static String getDataGridCheckedRowCount(String strDataGridId) {
        String strOutput = "";
        strOutput = StringHelper.Format((String)"$P.grid['%1$s'].gridmgr.getcheckedrowcount()", (Object)strDataGridId);
        return strOutput;
    }

    public static String getSelectedRecord(String strDataGridId) {
        String strOutput = "";
        strOutput = StringHelper.Format((String)"$P.grid['%1$s'].gridmgr.getSelected()", (Object)strDataGridId);
        return strOutput;
    }

    public static String getSelectedRecordKeys(String strDataGridId) {
        String strOutput = "";
        strOutput = StringHelper.Format((String)"$P.grid['%1$s'].gridmgr.getSelectedKeys()", (Object)strDataGridId);
        return strOutput;
    }

    public static String getDataGridNewRow(String strDataGridId) {
        String strOutput = "";
        strOutput = StringHelper.Format((String)"$P.grid['%1$s'].gridmgr.newrow();", (Object)strDataGridId);
        return strOutput;
    }

    public static String getDataGridNewRow(String strDataGridId, String strParam) {
        String strOutput = "";
        strOutput = StringHelper.Format((String)"$P.grid['%1$s'].gridmgr.newrow(%2$s);", (Object)strDataGridId, (Object)strParam);
        return strOutput;
    }

    public static String getDataGridSaveRow(String strDataGridId) {
        String strOutput = "";
        strOutput = StringHelper.Format((String)"$P.grid['%1$s'].gridmgr.saverow();", (Object)strDataGridId);
        return strOutput;
    }

    public static String getSetDataGridEditable(String strDataGridId, boolean bEdit) {
        String strOutput = "";
        strOutput = StringHelper.Format((String)"$P.grid['%1$s'].gridmgr.seteditable(%2$s);", (Object)strDataGridId, (Object)(bEdit ? "true" : "false"));
        return strOutput;
    }

    public static String getSetDataGridEditable(String strDataGridId, String strValue) {
        String strOutput = "";
        strOutput = StringHelper.Format((String)"$P.grid['%1$s'].gridmgr.seteditable(%2$s);", (Object)strDataGridId, (Object)strValue);
        return strOutput;
    }

    public static String getGetDataGridEditable(String strDataGridId) {
        String strOutput = "";
        strOutput = StringHelper.Format((String)"$P.grid['%1$s'].gridmgr.geteditable()", (Object)strDataGridId);
        return strOutput;
    }

    public static String getOnEditableChangeEventScript(String strDataGridId, String strEventCode) {
        String strOutput = "";
        strOutput = StringHelper.Format((String)"$P.grid['%1$s'].gridmgr.on('editablechange',function(_T){%2$s});", (Object)strDataGridId, (Object)strEventCode);
        return strOutput;
    }

    public static String getOnRowSavedEventScript(String strDataGridId, String strEventCode) {
        String strOutput = "";
        strOutput = StringHelper.Format((String)"$P.grid['%1$s'].gridmgr.on('rowsaved',function(_T){%2$s});", (Object)strDataGridId, (Object)strEventCode);
        return strOutput;
    }
}

