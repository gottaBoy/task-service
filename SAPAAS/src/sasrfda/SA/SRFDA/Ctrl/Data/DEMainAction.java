/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class DEMainAction
extends BaseDataEntity {
    public static final String ACTIONTYPE_INSERT = "INSERT";
    public static final String ACTIONTYPE_UPDATE = "UPDATE";
    public static final String ACTIONTYPE_DELETE = "DELETE";
    public static final String ACTIONTYPE_CUSTOMCALL = "CUSTOMCALL";
    public static final String TAG_DEMAINACTIONID = "DEMAINACTIONID";
    public static final String TAG_DEMAINACTIONNAME = "DEMAINACTIONNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_DEID = "DEID";
    public static final String TAG_DENAME = "DENAME";
    public static final String TAG_LOGICNAME = "LOGICNAME";
    public static final String TAG_UPDATEFLAG = "UPDATEFLAG";
    public static final String TAG_DEBEHAVIORID = "DEBEHAVIORID";
    public static final String TAG_DEBEHAVIORNAME = "DEBEHAVIORNAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_FORMID = "FORMID";
    public static final String TAG_FORMNAME = "FORMNAME";
    public static final String TAG_WFMODE = "WFMODE";
    public static final String TAG_UPDATEMAFONLY = "UPDATEMAFONLY";
    public static final String TAG_ACTIONTYPE = "ACTIONTYPE";
    public static final String TAG_ACTIONMODE = "ACTIONMODE";
    public static final String TAG_DATAACCACTION = "DATAACCACTION";

    public boolean isDEMAINACTIONIDNull() {
        return this.IsParamNull(TAG_DEMAINACTIONID);
    }

    public String getDEMAINACTIONID() {
        return this.GetParamStringValue(TAG_DEMAINACTIONID, "");
    }

    public void setDEMAINACTIONID(String strValue) {
        this.SetParamValue(TAG_DEMAINACTIONID, strValue);
    }

    public boolean isDEMAINACTIONNAMENull() {
        return this.IsParamNull(TAG_DEMAINACTIONNAME);
    }

    public String getDEMAINACTIONNAME() {
        return this.GetParamStringValue(TAG_DEMAINACTIONNAME, "");
    }

    public void setDEMAINACTIONNAME(String strValue) {
        this.SetParamValue(TAG_DEMAINACTIONNAME, strValue);
    }

    public boolean isCREATEMANNull() {
        return this.IsParamNull(TAG_CREATEMAN);
    }

    public String getCREATEMAN() {
        return this.GetParamStringValue(TAG_CREATEMAN, "");
    }

    public void setCREATEMAN(String strValue) {
        this.SetParamValue(TAG_CREATEMAN, strValue);
    }

    public boolean isCREATEDATENull() {
        return this.IsParamNull(TAG_CREATEDATE);
    }

    public Date getCREATEDATE() {
        return this.GetParamDateValue(TAG_CREATEDATE, null);
    }

    public void setCREATEDATE(Date dtValue) {
        this.SetParamValue(TAG_CREATEDATE, dtValue);
    }

    public boolean isUPDATEMANNull() {
        return this.IsParamNull(TAG_UPDATEMAN);
    }

    public String getUPDATEMAN() {
        return this.GetParamStringValue(TAG_UPDATEMAN, "");
    }

    public void setUPDATEMAN(String strValue) {
        this.SetParamValue(TAG_UPDATEMAN, strValue);
    }

    public boolean isUPDATEDATENull() {
        return this.IsParamNull(TAG_UPDATEDATE);
    }

    public Date getUPDATEDATE() {
        return this.GetParamDateValue(TAG_UPDATEDATE, null);
    }

    public void setUPDATEDATE(Date dtValue) {
        this.SetParamValue(TAG_UPDATEDATE, dtValue);
    }

    public boolean isDEIDNull() {
        return this.IsParamNull(TAG_DEID);
    }

    public String getDEID() {
        return this.GetParamStringValue(TAG_DEID, "");
    }

    public void setDEID(String strValue) {
        this.SetParamValue(TAG_DEID, strValue);
    }

    public boolean isDENAMENull() {
        return this.IsParamNull(TAG_DENAME);
    }

    public String getDENAME() {
        return this.GetParamStringValue(TAG_DENAME, "");
    }

    public void setDENAME(String strValue) {
        this.SetParamValue(TAG_DENAME, strValue);
    }

    public boolean isLOGICNAMENull() {
        return this.IsParamNull(TAG_LOGICNAME);
    }

    public String getLOGICNAME() {
        return this.GetParamStringValue(TAG_LOGICNAME, "");
    }

    public void setLOGICNAME(String strValue) {
        this.SetParamValue(TAG_LOGICNAME, strValue);
    }

    public boolean isUPDATEFLAGNull() {
        return this.IsParamNull(TAG_UPDATEFLAG);
    }

    public boolean getUPDATEFLAG() {
        return this.GetParamIntValue(TAG_UPDATEFLAG, 0) == 1;
    }

    public void setUPDATEFLAG(boolean bValue) {
        this.SetParamValue(TAG_UPDATEFLAG, bValue ? 1 : 0);
    }

    public boolean isDEBEHAVIORIDNull() {
        return this.IsParamNull(TAG_DEBEHAVIORID);
    }

    public String getDEBEHAVIORID() {
        return this.GetParamStringValue(TAG_DEBEHAVIORID, "");
    }

    public void setDEBEHAVIORID(String strValue) {
        this.SetParamValue(TAG_DEBEHAVIORID, strValue);
    }

    public boolean isDEBEHAVIORNAMENull() {
        return this.IsParamNull(TAG_DEBEHAVIORNAME);
    }

    public String getDEBEHAVIORNAME() {
        return this.GetParamStringValue(TAG_DEBEHAVIORNAME, "");
    }

    public void setDEBEHAVIORNAME(String strValue) {
        this.SetParamValue(TAG_DEBEHAVIORNAME, strValue);
    }

    public boolean isMEMONull() {
        return this.IsParamNull(TAG_MEMO);
    }

    public String getMEMO() {
        return this.GetParamStringValue(TAG_MEMO, "");
    }

    public void setMEMO(String strValue) {
        this.SetParamValue(TAG_MEMO, strValue);
    }

    public boolean isFORMIDNull() {
        return this.IsParamNull(TAG_FORMID);
    }

    public String getFORMID() {
        return this.GetParamStringValue(TAG_FORMID, "");
    }

    public void setFORMID(String strValue) {
        this.SetParamValue(TAG_FORMID, strValue);
    }

    public boolean isFORMNAMENull() {
        return this.IsParamNull(TAG_FORMNAME);
    }

    public String getFORMNAME() {
        return this.GetParamStringValue(TAG_FORMNAME, "");
    }

    public void setFORMNAME(String strValue) {
        this.SetParamValue(TAG_FORMNAME, strValue);
    }

    public final boolean isWFMODENull() {
        return this.IsParamNull(TAG_WFMODE);
    }

    public final boolean getWFMODE() {
        return this.GetParamIntValue(TAG_WFMODE, 0) == 1;
    }

    public final void setWFMODE(boolean bValue) {
        this.SetParamValue(TAG_WFMODE, bValue ? 1 : 0);
    }

    public final boolean isUPDATEMAFONLYNull() {
        return this.IsParamNull(TAG_UPDATEMAFONLY);
    }

    public final boolean getUPDATEMAFONLY() {
        return this.GetParamIntValue(TAG_UPDATEMAFONLY, 0) == 1;
    }

    public final void setUPDATEMAFONLY(boolean bValue) {
        this.SetParamValue(TAG_UPDATEMAFONLY, bValue ? 1 : 0);
    }

    public final boolean isACTIONTYPENull() {
        return this.IsParamNull(TAG_ACTIONTYPE);
    }

    public final String getACTIONTYPE() {
        return this.GetParamStringValue(TAG_ACTIONTYPE, "");
    }

    public final void setACTIONTYPE(String strValue) {
        this.SetParamValue(TAG_ACTIONTYPE, strValue);
    }

    public final boolean isACTIONMODENull() {
        return this.IsParamNull(TAG_ACTIONMODE);
    }

    public final String getACTIONMODE() {
        return this.GetParamStringValue(TAG_ACTIONMODE, "");
    }

    public final void setACTIONMODE(String strValue) {
        this.SetParamValue(TAG_ACTIONMODE, strValue);
    }

    public final boolean isDATAACCACTIONNull() {
        return this.IsParamNull(TAG_DATAACCACTION);
    }

    public final String getDATAACCACTION() {
        return this.GetParamStringValue(TAG_DATAACCACTION, "");
    }

    public final void setDATAACCACTION(String strValue) {
        this.SetParamValue(TAG_DATAACCACTION, strValue);
    }
}

