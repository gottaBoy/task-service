/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFDA.Ctrl.DEFHelper.IDEFHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.Utility.StringHelper;
import java.util.Hashtable;

public class DEDSCtrl
extends BaseDataEntity {
    public static final String FIELDCTRLMODE_PERMIT = "PERMIT";
    public static final String FIELDCTRLMODE_DENY = "DENY";
    protected Hashtable<String, String> ctrlFieldMap = null;
    public static final String TAG_DEDSCTRLID = "DEDSCTRLID";
    public static final String TAG_DEDSCTRLNAME = "DEDSCTRLNAME";
    public static final String TAG_DEID = "DEID";
    public static final String TAG_DENAME = "DENAME";
    public static final String TAG_DEFID = "DEFID";
    public static final String TAG_DEFNAME = "DEFNAME";
    public static final String TAG_DEFVALUE = "DEFVALUE";
    public static final String TAG_DENYACTIONS = "DENYACTIONS";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_RESERVER = "RESERVER";
    public static final String TAG_RESERVER2 = "RESERVER2";
    public static final String TAG_DESCRIPTION = "DESCRIPTION";
    public static final String TAG_CTRLFIELDS = "CTRLFIELDS";
    public static final String TAG_FIELDCTRLMODE = "FIELDCTRLMODE";
    protected IDEFHelper iDEFHelper = null;
    protected Object objDEFValue = null;

    public String getDEDSCTRLID() {
        return this.GetParamStringValue(TAG_DEDSCTRLID, "").trim();
    }

    public String getDEDSCTRLNAME() {
        return this.GetParamStringValue(TAG_DEDSCTRLNAME, "");
    }

    public String getRESERVER() {
        return this.GetParamStringValue(TAG_RESERVER, "");
    }

    public String getRESERVER2() {
        return this.GetParamStringValue(TAG_RESERVER2, "");
    }

    public String getDENYACTIONS() {
        return this.GetParamStringValue(TAG_DENYACTIONS, "");
    }

    public void setDENYACTIONS(String strValue) {
        this.SetParamValue(TAG_DENYACTIONS, strValue);
    }

    public void setDEDSCTRLID(String strValue) {
        this.SetParamValue(TAG_DEDSCTRLID, strValue);
    }

    public void setDEDSCTRLNAME(String strValue) {
        this.SetParamValue(TAG_DEDSCTRLNAME, strValue);
    }

    public void setDEID(String strValue) {
        this.SetParamValue(TAG_DEID, strValue);
    }

    public void setRESERVER(String strValue) {
        this.SetParamValue(TAG_RESERVER, strValue);
    }

    public void setRESERVER2(String strValue) {
        this.SetParamValue(TAG_RESERVER2, strValue);
    }

    public String getDENAME() {
        return this.GetParamStringValue(TAG_DENAME, "");
    }

    public String getDEID() {
        return this.GetParamStringValue(TAG_DEID, "");
    }

    public String getDEFNAME() {
        return this.GetParamStringValue(TAG_DEFNAME, "");
    }

    public String getDEFID() {
        return this.GetParamStringValue(TAG_DEFID, "");
    }

    public String getDEFVALUE() {
        return this.GetParamStringValue(TAG_DEFVALUE, "");
    }

    public IDEFHelper getDEFHelper() {
        return this.iDEFHelper;
    }

    public void setDEFHelper(IDEFHelper helper) {
        this.iDEFHelper = helper;
    }

    public Object getDEFValue() {
        return this.objDEFValue;
    }

    public void setDEFValue(Object objDEFValue) {
        this.objDEFValue = objDEFValue;
    }

    public boolean isDESCRIPTIONNull() {
        return this.IsParamNull(TAG_DESCRIPTION);
    }

    public String getDESCRIPTION() {
        return this.GetParamStringValue(TAG_DESCRIPTION, "");
    }

    public void setDESCRIPTION(String strValue) {
        this.SetParamValue(TAG_DESCRIPTION, strValue);
    }

    public boolean isCTRLFIELDSNull() {
        return this.IsParamNull(TAG_CTRLFIELDS);
    }

    public String getCTRLFIELDS() {
        return this.GetParamStringValue(TAG_CTRLFIELDS, "");
    }

    public void setCTRLFIELDS(String strValue) {
        this.SetParamValue(TAG_CTRLFIELDS, strValue);
    }

    public boolean isFIELDCTRLMODENull() {
        return this.IsParamNull(TAG_FIELDCTRLMODE);
    }

    public String getFIELDCTRLMODE() {
        return this.GetParamStringValue(TAG_FIELDCTRLMODE, "");
    }

    public void setFIELDCTRLMODE(String strValue) {
        this.SetParamValue(TAG_FIELDCTRLMODE, strValue);
    }

    public void InitCtrlFields() {
        String strCtrlFields = this.getCTRLFIELDS();
        if (StringHelper.IsNullOrEmpty((String)strCtrlFields)) {
            return;
        }
        this.ctrlFieldMap = new Hashtable();
        String[] fields = StringHelper.SplitEx((String)strCtrlFields);
        int i = 0;
        while (i < fields.length) {
            this.ctrlFieldMap.put(fields[i].toUpperCase(), "");
            ++i;
        }
    }

    public Hashtable<String, String> getCtrlFields() {
        return this.ctrlFieldMap;
    }
}

