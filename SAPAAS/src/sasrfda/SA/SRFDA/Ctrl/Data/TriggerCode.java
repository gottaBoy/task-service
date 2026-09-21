/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class TriggerCode
extends BaseDataEntity {
    public static final String EXECMODE_ROW = "For Each Row";
    public static final String EXECMODE_STATEMENT = "For Each Statement";
    public static final String TAG_TRIGGERCODEID = "TRIGGERCODEID";
    public static final String TAG_TRIGGERCODENAME = "TRIGGERCODENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_DETRIGGERID = "DETRIGGERID";
    public static final String TAG_DETRIGGERNAME = "DETRIGGERNAME";
    public static final String TAG_DBTYPE = "DBTYPE";
    public static final String TAG_EXECMODE = "EXECMODE";
    public static final String TAG_SEARCHCOND = "SEARCHCOND";
    public static final String TAG_TRIGGERBODY = "TRIGGERBODY";
    public static final String TAG_DECLARECODE = "DECLARECODE";

    public String getTRIGGERCODEID() {
        return this.GetParamStringValue(TAG_TRIGGERCODEID, "");
    }

    public void setTRIGGERCODEID(String strValue) {
        this.SetParamValue(TAG_TRIGGERCODEID, strValue);
    }

    public String getTRIGGERCODENAME() {
        return this.GetParamStringValue(TAG_TRIGGERCODENAME, "");
    }

    public void setTRIGGERCODENAME(String strValue) {
        this.SetParamValue(TAG_TRIGGERCODENAME, strValue);
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

    public String getDETRIGGERID() {
        return this.GetParamStringValue(TAG_DETRIGGERID, "");
    }

    public void setDETRIGGERID(String strValue) {
        this.SetParamValue(TAG_DETRIGGERID, strValue);
    }

    public String getDETRIGGERNAME() {
        return this.GetParamStringValue(TAG_DETRIGGERNAME, "");
    }

    public void setDETRIGGERNAME(String strValue) {
        this.SetParamValue(TAG_DETRIGGERNAME, strValue);
    }

    public String getDBTYPE() {
        return this.GetParamStringValue(TAG_DBTYPE, "");
    }

    public void setDBTYPE(String strValue) {
        this.SetParamValue(TAG_DBTYPE, strValue);
    }

    public String getEXECMODE() {
        return this.GetParamStringValue(TAG_EXECMODE, "");
    }

    public void setEXECMODE(String strValue) {
        this.SetParamValue(TAG_EXECMODE, strValue);
    }

    public String getSEARCHCOND() {
        return this.GetParamStringValue(TAG_SEARCHCOND, "");
    }

    public void setSEARCHCOND(String strValue) {
        this.SetParamValue(TAG_SEARCHCOND, strValue);
    }

    public String getTRIGGERBODY() {
        return this.GetParamStringValue(TAG_TRIGGERBODY, "");
    }

    public void setTRIGGERBODY(String strValue) {
        this.SetParamValue(TAG_TRIGGERBODY, strValue);
    }

    public String getDECLARECODE() {
        return this.GetParamStringValue(TAG_DECLARECODE, "");
    }

    public void setDECLARECODE(String strValue) {
        this.SetParamValue(TAG_DECLARECODE, strValue);
    }
}

