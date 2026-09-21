/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class DEMainState
extends BaseDataEntity {
    public static final String TAG_DEMAINSTATEID = "DEMAINSTATEID";
    public static final String TAG_DEMAINSTATENAME = "DEMAINSTATENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_DEID = "DEID";
    public static final String TAG_DENAME = "DENAME";
    public static final String TAG_LOGICNAME = "LOGICNAME";
    public static final String TAG_QUERYMODELID = "QUERYMODELID";
    public static final String TAG_QUERYMODELNAME = "QUERYMODELNAME";
    public static final String TAG_SDPAGEID = "SDPAGEID";
    public static final String TAG_SDPAGENAME = "SDPAGENAME";
    public static final String TAG_MDPAGEID = "MDPAGEID";
    public static final String TAG_MDPAGENAME = "MDPAGENAME";
    public static final String TAG_USERACTION = "USERACTION";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_ENABLEUPDATE = "ENABLEUPDATE";
    public static final String TAG_ENABLEDELETE = "ENABLEDELETE";
    public static final String TAG_ENABLECREATE = "ENABLECREATE";
    public static final String TAG_ENABLEVIEW = "ENABLEVIEW";
    public static final String TAG_EDITDEMAID = "EDITDEMAID";
    public static final String TAG_EDITDEMANAME = "EDITDEMANAME";
    public static final String TAG_WFMODE = "WFMODE";
    public static final String TAG_DEFAULTSTATE = "DEFAULTSTATE";
    public static final String TAG_DERGROUPID = "DERGROUPID";
    public static final String TAG_DERGROUPNAME = "DERGROUPNAME";

    public boolean isDEMAINSTATEIDNull() {
        return this.IsParamNull(TAG_DEMAINSTATEID);
    }

    public String getDEMAINSTATEID() {
        return this.GetParamStringValue(TAG_DEMAINSTATEID, "");
    }

    public void setDEMAINSTATEID(String strValue) {
        this.SetParamValue(TAG_DEMAINSTATEID, strValue);
    }

    public boolean isDEMAINSTATENAMENull() {
        return this.IsParamNull(TAG_DEMAINSTATENAME);
    }

    public String getDEMAINSTATENAME() {
        return this.GetParamStringValue(TAG_DEMAINSTATENAME, "");
    }

    public void setDEMAINSTATENAME(String strValue) {
        this.SetParamValue(TAG_DEMAINSTATENAME, strValue);
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

    public boolean isQUERYMODELIDNull() {
        return this.IsParamNull(TAG_QUERYMODELID);
    }

    public String getQUERYMODELID() {
        return this.GetParamStringValue(TAG_QUERYMODELID, "");
    }

    public void setQUERYMODELID(String strValue) {
        this.SetParamValue(TAG_QUERYMODELID, strValue);
    }

    public boolean isQUERYMODELNAMENull() {
        return this.IsParamNull(TAG_QUERYMODELNAME);
    }

    public String getQUERYMODELNAME() {
        return this.GetParamStringValue(TAG_QUERYMODELNAME, "");
    }

    public void setQUERYMODELNAME(String strValue) {
        this.SetParamValue(TAG_QUERYMODELNAME, strValue);
    }

    public boolean isSDPAGEIDNull() {
        return this.IsParamNull(TAG_SDPAGEID);
    }

    public String getSDPAGEID() {
        return this.GetParamStringValue(TAG_SDPAGEID, "");
    }

    public void setSDPAGEID(String strValue) {
        this.SetParamValue(TAG_SDPAGEID, strValue);
    }

    public boolean isSDPAGENAMENull() {
        return this.IsParamNull(TAG_SDPAGENAME);
    }

    public String getSDPAGENAME() {
        return this.GetParamStringValue(TAG_SDPAGENAME, "");
    }

    public void setSDPAGENAME(String strValue) {
        this.SetParamValue(TAG_SDPAGENAME, strValue);
    }

    public boolean isMDPAGEIDNull() {
        return this.IsParamNull(TAG_MDPAGEID);
    }

    public String getMDPAGEID() {
        return this.GetParamStringValue(TAG_MDPAGEID, "");
    }

    public void setMDPAGEID(String strValue) {
        this.SetParamValue(TAG_MDPAGEID, strValue);
    }

    public boolean isMDPAGENAMENull() {
        return this.IsParamNull(TAG_MDPAGENAME);
    }

    public String getMDPAGENAME() {
        return this.GetParamStringValue(TAG_MDPAGENAME, "");
    }

    public void setMDPAGENAME(String strValue) {
        this.SetParamValue(TAG_MDPAGENAME, strValue);
    }

    public boolean isUSERACTIONNull() {
        return this.IsParamNull(TAG_USERACTION);
    }

    public int getUSERACTION() {
        return this.GetParamIntValue(TAG_USERACTION, 0);
    }

    public void setUSERACTION(int nValue) {
        this.SetParamValue(TAG_USERACTION, nValue);
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

    public boolean isENABLEUPDATENull() {
        return this.IsParamNull(TAG_ENABLEUPDATE);
    }

    public boolean getENABLEUPDATE() {
        return this.GetParamIntValue(TAG_ENABLEUPDATE, 0) == 1;
    }

    public void setENABLEUPDATE(boolean bValue) {
        this.SetParamValue(TAG_ENABLEUPDATE, bValue ? 1 : 0);
    }

    public boolean isENABLEDELETENull() {
        return this.IsParamNull(TAG_ENABLEDELETE);
    }

    public boolean getENABLEDELETE() {
        return this.GetParamIntValue(TAG_ENABLEDELETE, 0) == 1;
    }

    public void setENABLEDELETE(boolean bValue) {
        this.SetParamValue(TAG_ENABLEDELETE, bValue ? 1 : 0);
    }

    public boolean isENABLECREATENull() {
        return this.IsParamNull(TAG_ENABLECREATE);
    }

    public boolean getENABLECREATE() {
        return this.GetParamIntValue(TAG_ENABLECREATE, 0) == 1;
    }

    public void setENABLECREATE(boolean bValue) {
        this.SetParamValue(TAG_ENABLECREATE, bValue ? 1 : 0);
    }

    public boolean isENABLEVIEWNull() {
        return this.IsParamNull(TAG_ENABLEVIEW);
    }

    public boolean getENABLEVIEW() {
        return this.GetParamIntValue(TAG_ENABLEVIEW, 0) == 1;
    }

    public void setENABLEVIEW(boolean bValue) {
        this.SetParamValue(TAG_ENABLEVIEW, bValue ? 1 : 0);
    }

    public boolean isEDITDEMAIDNull() {
        return this.IsParamNull(TAG_EDITDEMAID);
    }

    public String getEDITDEMAID() {
        return this.GetParamStringValue(TAG_EDITDEMAID, "");
    }

    public void setEDITDEMAID(String strValue) {
        this.SetParamValue(TAG_EDITDEMAID, strValue);
    }

    public boolean isEDITDEMANAMENull() {
        return this.IsParamNull(TAG_EDITDEMANAME);
    }

    public String getEDITDEMANAME() {
        return this.GetParamStringValue(TAG_EDITDEMANAME, "");
    }

    public void setEDITDEMANAME(String strValue) {
        this.SetParamValue(TAG_EDITDEMANAME, strValue);
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

    public final boolean isDEFAULTSTATENull() {
        return this.IsParamNull(TAG_DEFAULTSTATE);
    }

    public final boolean getDEFAULTSTATE() {
        return this.GetParamIntValue(TAG_DEFAULTSTATE, 0) == 1;
    }

    public final void setDEFAULTSTATE(boolean bValue) {
        this.SetParamValue(TAG_DEFAULTSTATE, bValue ? 1 : 0);
    }

    public final boolean isDERGROUPIDNull() {
        return this.IsParamNull(TAG_DERGROUPID);
    }

    public final String getDERGROUPID() {
        return this.GetParamStringValue(TAG_DERGROUPID, "");
    }

    public final void setDERGROUPID(String strValue) {
        this.SetParamValue(TAG_DERGROUPID, strValue);
    }

    public final boolean isDERGROUPNAMENull() {
        return this.IsParamNull(TAG_DERGROUPNAME);
    }

    public final String getDERGROUPNAME() {
        return this.GetParamStringValue(TAG_DERGROUPNAME, "");
    }

    public final void setDERGROUPNAME(String strValue) {
        this.SetParamValue(TAG_DERGROUPNAME, strValue);
    }
}

