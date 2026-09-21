/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class DEShortcut
extends BaseDataEntity {
    public static final int SHORTCUTTYPE_PICKUPLINK = 1;
    public static final String TAG_DESHORTCUTID = "DESHORTCUTID";
    public static final String TAG_DESHORTCUTNAME = "DESHORTCUTNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_SHORTCUTTYPE = "SHORTCUTTYPE";
    public static final String TAG_SHOWORDER = "SHOWORDER";
    public static final String TAG_ICONPATH = "ICONPATH";
    public static final String TAG_JSCODE = "JSCODE";
    public static final String TAG_DENAME = "DENAME";
    public static final String TAG_DEID = "DEID";

    public String getDESHORTCUTID() {
        return this.GetParamStringValue(TAG_DESHORTCUTID, "");
    }

    public void setDESHORTCUTID(String strValue) {
        this.SetParamValue(TAG_DESHORTCUTID, strValue);
    }

    public String getDESHORTCUTNAME() {
        return this.GetParamStringValue(TAG_DESHORTCUTNAME, "");
    }

    public void setDESHORTCUTNAME(String strValue) {
        this.SetParamValue(TAG_DESHORTCUTNAME, strValue);
    }

    public String getCREATEMAN() {
        return this.GetParamStringValue(TAG_CREATEMAN, "");
    }

    public void setCREATEMAN(String strValue) {
        this.SetParamValue(TAG_CREATEMAN, strValue);
    }

    public Date getCREATEDATE() {
        return this.GetParamDateValue(TAG_CREATEDATE, null);
    }

    public void setCREATEDATE(Date strValue) {
        this.SetParamValue(TAG_CREATEDATE, strValue);
    }

    public String getUPDATEMAN() {
        return this.GetParamStringValue(TAG_UPDATEMAN, "");
    }

    public void setUPDATEMAN(String strValue) {
        this.SetParamValue(TAG_UPDATEMAN, strValue);
    }

    public Date getUPDATEDATE() {
        return this.GetParamDateValue(TAG_UPDATEDATE, null);
    }

    public void setUPDATEDATE(Date strValue) {
        this.SetParamValue(TAG_UPDATEDATE, strValue);
    }

    public int getSHORTCUTTYPE() {
        return this.GetParamIntValue(TAG_SHORTCUTTYPE, 0);
    }

    public void setSHORTCUTTYPE(int strValue) {
        this.SetParamValue(TAG_SHORTCUTTYPE, strValue);
    }

    public String getSHOWORDER() {
        return this.GetParamStringValue(TAG_SHOWORDER, "");
    }

    public void setSHOWORDER(String strValue) {
        this.SetParamValue(TAG_SHOWORDER, strValue);
    }

    public String getICONPATH() {
        return this.GetParamStringValue(TAG_ICONPATH, "");
    }

    public void setICONPATH(String strValue) {
        this.SetParamValue(TAG_ICONPATH, strValue);
    }

    public String getJSCODE() {
        return this.GetParamStringValue(TAG_JSCODE, "");
    }

    public void setJSCODE(String strValue) {
        this.SetParamValue(TAG_JSCODE, strValue);
    }

    public String getDENAME() {
        return this.GetParamStringValue(TAG_DENAME, "");
    }

    public void setDENAME(String strValue) {
        this.SetParamValue(TAG_DENAME, strValue);
    }

    public String getDEID() {
        return this.GetParamStringValue(TAG_DEID, "");
    }

    public void setDEID(String strValue) {
        this.SetParamValue(TAG_DEID, strValue);
    }
}

