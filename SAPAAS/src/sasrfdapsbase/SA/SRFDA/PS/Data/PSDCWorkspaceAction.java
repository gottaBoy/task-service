/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSDCWorkspaceAction
extends BaseDataEntity {
    public static final String ACTIONTYPE_INSTALLSYS = "INSTALLSYS";
    public static final String ACTIONTYPE_UNINSTALLSYS = "UNINSTALLSYS";
    public static final String ACTIONTYPE_CREATE = "CREATE";
    public static final String ACTIONTYPE_DESTORY = "DESTORY";
    public static final int ACTIONSTATE_10 = 10;
    public static final int ACTIONSTATE_20 = 20;
    public static final int ACTIONSTATE_30 = 30;
    public static final int ACTIONSTATE_40 = 40;
    public static final String TAG_PSDCWORKSPACEACTIONID = "PSDCWORKSPACEACTIONID";
    public static final String TAG_PSDCWORKSPACEACTIONNAME = "PSDCWORKSPACEACTIONNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSDCWORKSPACEID = "PSDCWORKSPACEID";
    public static final String TAG_PSDCWORKSPACENAME = "PSDCWORKSPACENAME";
    public static final String TAG_PSDEVCENTERID = "PSDEVCENTERID";
    public static final String TAG_PSDEVCENTERNAME = "PSDEVCENTERNAME";
    public static final String TAG_ACTIONTYPE = "ACTIONTYPE";
    public static final String TAG_ACTIONSTATE = "ACTIONSTATE";
    public static final String TAG_ACTIONPARAM = "ACTIONPARAM";
    public static final String TAG_ACTIONPARAM2 = "ACTIONPARAM2";
    public static final String TAG_ACTIONPARAM3 = "ACTIONPARAM3";
    public static final String TAG_ACTIONPARAM4 = "ACTIONPARAM4";
    public static final String TAG_ACTIONPARAM5 = "ACTIONPARAM5";
    public static final String TAG_ACTIONPARAM6 = "ACTIONPARAM6";
    public static final String TAG_ACTIONRESULT = "ACTIONRESULT";
    public static final String TAG_BEGINTIME = "BEGINTIME";
    public static final String TAG_ENDTIME = "ENDTIME";
    public static final String TAG_PSDSCONSOLEID = "PSDSCONSOLEID";
    public static final String TAG_PSDEVSLNSYSID = "PSDEVSLNSYSID";

    public final boolean isPSDCWORKSPACEACTIONIDNull() {
        return this.IsParamNull(TAG_PSDCWORKSPACEACTIONID);
    }

    public final String getPSDCWORKSPACEACTIONID() {
        return this.GetParamStringValue(TAG_PSDCWORKSPACEACTIONID, "");
    }

    public final void setPSDCWORKSPACEACTIONID(String strValue) {
        this.SetParamValue(TAG_PSDCWORKSPACEACTIONID, strValue);
    }

    public final boolean isPSDCWORKSPACEACTIONNAMENull() {
        return this.IsParamNull(TAG_PSDCWORKSPACEACTIONNAME);
    }

    public final String getPSDCWORKSPACEACTIONNAME() {
        return this.GetParamStringValue(TAG_PSDCWORKSPACEACTIONNAME, "");
    }

    public final void setPSDCWORKSPACEACTIONNAME(String strValue) {
        this.SetParamValue(TAG_PSDCWORKSPACEACTIONNAME, strValue);
    }

    public final boolean isCREATEMANNull() {
        return this.IsParamNull(TAG_CREATEMAN);
    }

    public final String getCREATEMAN() {
        return this.GetParamStringValue(TAG_CREATEMAN, "");
    }

    public final void setCREATEMAN(String strValue) {
        this.SetParamValue(TAG_CREATEMAN, strValue);
    }

    public final boolean isCREATEDATENull() {
        return this.IsParamNull(TAG_CREATEDATE);
    }

    public final Date getCREATEDATE() {
        return this.GetParamDateValue(TAG_CREATEDATE, null);
    }

    public final void setCREATEDATE(Date dtValue) {
        this.SetParamValue(TAG_CREATEDATE, dtValue);
    }

    public final boolean isUPDATEMANNull() {
        return this.IsParamNull(TAG_UPDATEMAN);
    }

    public final String getUPDATEMAN() {
        return this.GetParamStringValue(TAG_UPDATEMAN, "");
    }

    public final void setUPDATEMAN(String strValue) {
        this.SetParamValue(TAG_UPDATEMAN, strValue);
    }

    public final boolean isUPDATEDATENull() {
        return this.IsParamNull(TAG_UPDATEDATE);
    }

    public final Date getUPDATEDATE() {
        return this.GetParamDateValue(TAG_UPDATEDATE, null);
    }

    public final void setUPDATEDATE(Date dtValue) {
        this.SetParamValue(TAG_UPDATEDATE, dtValue);
    }

    public final boolean isPSDCWORKSPACEIDNull() {
        return this.IsParamNull(TAG_PSDCWORKSPACEID);
    }

    public final String getPSDCWORKSPACEID() {
        return this.GetParamStringValue(TAG_PSDCWORKSPACEID, "");
    }

    public final void setPSDCWORKSPACEID(String strValue) {
        this.SetParamValue(TAG_PSDCWORKSPACEID, strValue);
    }

    public final boolean isPSDCWORKSPACENAMENull() {
        return this.IsParamNull(TAG_PSDCWORKSPACENAME);
    }

    public final String getPSDCWORKSPACENAME() {
        return this.GetParamStringValue(TAG_PSDCWORKSPACENAME, "");
    }

    public final void setPSDCWORKSPACENAME(String strValue) {
        this.SetParamValue(TAG_PSDCWORKSPACENAME, strValue);
    }

    public final boolean isPSDEVCENTERIDNull() {
        return this.IsParamNull(TAG_PSDEVCENTERID);
    }

    public final String getPSDEVCENTERID() {
        return this.GetParamStringValue(TAG_PSDEVCENTERID, "");
    }

    public final void setPSDEVCENTERID(String strValue) {
        this.SetParamValue(TAG_PSDEVCENTERID, strValue);
    }

    public final boolean isPSDEVCENTERNAMENull() {
        return this.IsParamNull(TAG_PSDEVCENTERNAME);
    }

    public final String getPSDEVCENTERNAME() {
        return this.GetParamStringValue(TAG_PSDEVCENTERNAME, "");
    }

    public final void setPSDEVCENTERNAME(String strValue) {
        this.SetParamValue(TAG_PSDEVCENTERNAME, strValue);
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

    public final boolean isACTIONSTATENull() {
        return this.IsParamNull(TAG_ACTIONSTATE);
    }

    public final int getACTIONSTATE() {
        return this.GetParamIntValue(TAG_ACTIONSTATE, 0);
    }

    public final void setACTIONSTATE(int nValue) {
        this.SetParamValue(TAG_ACTIONSTATE, nValue);
    }

    public final boolean isACTIONPARAMNull() {
        return this.IsParamNull(TAG_ACTIONPARAM);
    }

    public final String getACTIONPARAM() {
        return this.GetParamStringValue(TAG_ACTIONPARAM, "");
    }

    public final void setACTIONPARAM(String strValue) {
        this.SetParamValue(TAG_ACTIONPARAM, strValue);
    }

    public final boolean isACTIONPARAM2Null() {
        return this.IsParamNull(TAG_ACTIONPARAM2);
    }

    public final String getACTIONPARAM2() {
        return this.GetParamStringValue(TAG_ACTIONPARAM2, "");
    }

    public final void setACTIONPARAM2(String strValue) {
        this.SetParamValue(TAG_ACTIONPARAM2, strValue);
    }

    public final boolean isACTIONPARAM3Null() {
        return this.IsParamNull(TAG_ACTIONPARAM3);
    }

    public final String getACTIONPARAM3() {
        return this.GetParamStringValue(TAG_ACTIONPARAM3, "");
    }

    public final void setACTIONPARAM3(String strValue) {
        this.SetParamValue(TAG_ACTIONPARAM3, strValue);
    }

    public final boolean isACTIONPARAM4Null() {
        return this.IsParamNull(TAG_ACTIONPARAM4);
    }

    public final String getACTIONPARAM4() {
        return this.GetParamStringValue(TAG_ACTIONPARAM4, "");
    }

    public final void setACTIONPARAM4(String strValue) {
        this.SetParamValue(TAG_ACTIONPARAM4, strValue);
    }

    public final boolean isACTIONPARAM5Null() {
        return this.IsParamNull(TAG_ACTIONPARAM5);
    }

    public final int getACTIONPARAM5() {
        return this.GetParamIntValue(TAG_ACTIONPARAM5, 0);
    }

    public final void setACTIONPARAM5(int nValue) {
        this.SetParamValue(TAG_ACTIONPARAM5, nValue);
    }

    public final boolean isACTIONPARAM6Null() {
        return this.IsParamNull(TAG_ACTIONPARAM6);
    }

    public final int getACTIONPARAM6() {
        return this.GetParamIntValue(TAG_ACTIONPARAM6, 0);
    }

    public final void setACTIONPARAM6(int nValue) {
        this.SetParamValue(TAG_ACTIONPARAM6, nValue);
    }

    public final boolean isACTIONRESULTNull() {
        return this.IsParamNull(TAG_ACTIONRESULT);
    }

    public final String getACTIONRESULT() {
        return this.GetParamStringValue(TAG_ACTIONRESULT, "");
    }

    public final void setACTIONRESULT(String strValue) {
        this.SetParamValue(TAG_ACTIONRESULT, strValue);
    }

    public final boolean isBEGINTIMENull() {
        return this.IsParamNull(TAG_BEGINTIME);
    }

    public final Date getBEGINTIME() {
        return this.GetParamDateValue(TAG_BEGINTIME, null);
    }

    public final void setBEGINTIME(Date dtValue) {
        this.SetParamValue(TAG_BEGINTIME, dtValue);
    }

    public final boolean isENDTIMENull() {
        return this.IsParamNull(TAG_ENDTIME);
    }

    public final Date getENDTIME() {
        return this.GetParamDateValue(TAG_ENDTIME, null);
    }

    public final void setENDTIME(Date dtValue) {
        this.SetParamValue(TAG_ENDTIME, dtValue);
    }

    public final boolean isPSDSCONSOLEIDNull() {
        return this.IsParamNull(TAG_PSDSCONSOLEID);
    }

    public final String getPSDSCONSOLEID() {
        return this.GetParamStringValue(TAG_PSDSCONSOLEID, "");
    }

    public final void setPSDSCONSOLEID(String strValue) {
        this.SetParamValue(TAG_PSDSCONSOLEID, strValue);
    }

    public final boolean isPSDEVSLNSYSIDNull() {
        return this.IsParamNull(TAG_PSDEVSLNSYSID);
    }

    public final String getPSDEVSLNSYSID() {
        return this.GetParamStringValue(TAG_PSDEVSLNSYSID, "");
    }

    public final void setPSDEVSLNSYSID(String strValue) {
        this.SetParamValue(TAG_PSDEVSLNSYSID, strValue);
    }
}

