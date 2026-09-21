/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;

public class UserShortcut
extends BaseDataEntity {
    public static final String TAG_USERSHORTCUTID = "USERSHORTCUTID";
    public static final String TAG_USERSHORTCUTNAME = "USERSHORTCUTNAME";
    public static final String TAG_OWNERID = "OWNERID";
    public static final String TAG_SCMODEL = "SCMODEL";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_FUNCNAME = "FUNCNAME";

    public String getUSERSHORTCUTID() {
        return this.GetParamStringValue(TAG_USERSHORTCUTID, "").trim();
    }

    public String getUSERSHORTCUTNAME() {
        return this.GetParamStringValue(TAG_USERSHORTCUTNAME, "");
    }

    public String getCREATEMAN() {
        return this.GetParamStringValue(TAG_CREATEMAN, "");
    }

    public String getUPDATEMAN() {
        return this.GetParamStringValue(TAG_UPDATEMAN, "");
    }

    public String getFUNCNAME() {
        return this.GetParamStringValue(TAG_FUNCNAME, "");
    }

    public String getSCMODEL() {
        return this.GetParamStringValue(TAG_SCMODEL, "");
    }

    public void setUSERSHORTCUTID(String strValue) {
        this.SetParamValue(TAG_USERSHORTCUTID, strValue);
    }

    public void setUSERSHORTCUTNAME(String strValue) {
        this.SetParamValue(TAG_USERSHORTCUTNAME, strValue);
    }

    public void setSCMODEL(String strValue) {
        this.SetParamValue(TAG_SCMODEL, strValue);
    }

    public void setCREATEMAN(String strValue) {
        this.SetParamValue(TAG_CREATEMAN, strValue);
    }

    public void setUPDATEMAN(String strValue) {
        this.SetParamValue(TAG_UPDATEMAN, strValue);
    }

    public void setFUNCNAME(String strValue) {
        this.SetParamValue(TAG_FUNCNAME, strValue);
    }

    public String getOWNERID() {
        return this.GetParamStringValue(TAG_OWNERID, "");
    }

    public void setOWNERID(String strValue) {
        this.SetParamValue(TAG_OWNERID, strValue);
    }
}

