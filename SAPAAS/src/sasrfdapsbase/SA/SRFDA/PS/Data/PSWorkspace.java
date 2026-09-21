/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSWorkspace
extends BaseDataEntity {
    public static final String WORKSPACETYPE_DEMO = "DEMO";
    public static final int WORKSPACESTATE_10 = 10;
    public static final int WORKSPACESTATE_20 = 20;
    public static final int WORKSPACESTATE_30 = 30;
    public static final int WORKSPACESTATE_35 = 35;
    public static final int WORKSPACESTATE_40 = 40;
    public static final String TAG_PSWORKSPACEID = "PSWORKSPACEID";
    public static final String TAG_PSWORKSPACENAME = "PSWORKSPACENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSSVRDOMAINID = "PSSVRDOMAINID";
    public static final String TAG_PSSVRDOMAINNAME = "PSSVRDOMAINNAME";
    public static final String TAG_PSDEVCENTERID = "PSDEVCENTERID";
    public static final String TAG_PSDEVCENTERNAME = "PSDEVCENTERNAME";
    public static final String TAG_WORKSPACETYPE = "WORKSPACETYPE";
    public static final String TAG_WORKSPACESTATE = "WORKSPACESTATE";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_PARAM = "PARAM";
    public static final String TAG_PARAM2 = "PARAM2";
    public static final String TAG_PARAM3 = "PARAM3";
    public static final String TAG_PARAM4 = "PARAM4";
    public static final String TAG_PARAM5 = "PARAM5";
    public static final String TAG_PARAM6 = "PARAM6";
    public static final String TAG_PARAM7 = "PARAM7";
    public static final String TAG_PARAM8 = "PARAM8";
    public static final String TAG_WORKSPACELEVEL = "WORKSPACELEVEL";
    public static final String TAG_EXPIREDTIME = "EXPIREDTIME";
    public static final String TAG_MAXDEVUSER = "MAXDEVUSER";

    public final boolean isPSWORKSPACEIDNull() {
        return this.IsParamNull(TAG_PSWORKSPACEID);
    }

    public final String getPSWORKSPACEID() {
        return this.GetParamStringValue(TAG_PSWORKSPACEID, "");
    }

    public final void setPSWORKSPACEID(String strValue) {
        this.SetParamValue(TAG_PSWORKSPACEID, strValue);
    }

    public final boolean isPSWORKSPACENAMENull() {
        return this.IsParamNull(TAG_PSWORKSPACENAME);
    }

    public final String getPSWORKSPACENAME() {
        return this.GetParamStringValue(TAG_PSWORKSPACENAME, "");
    }

    public final void setPSWORKSPACENAME(String strValue) {
        this.SetParamValue(TAG_PSWORKSPACENAME, strValue);
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

    public final boolean isPSSVRDOMAINIDNull() {
        return this.IsParamNull(TAG_PSSVRDOMAINID);
    }

    public final String getPSSVRDOMAINID() {
        return this.GetParamStringValue(TAG_PSSVRDOMAINID, "");
    }

    public final void setPSSVRDOMAINID(String strValue) {
        this.SetParamValue(TAG_PSSVRDOMAINID, strValue);
    }

    public final boolean isPSSVRDOMAINNAMENull() {
        return this.IsParamNull(TAG_PSSVRDOMAINNAME);
    }

    public final String getPSSVRDOMAINNAME() {
        return this.GetParamStringValue(TAG_PSSVRDOMAINNAME, "");
    }

    public final void setPSSVRDOMAINNAME(String strValue) {
        this.SetParamValue(TAG_PSSVRDOMAINNAME, strValue);
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

    public final boolean isWORKSPACETYPENull() {
        return this.IsParamNull(TAG_WORKSPACETYPE);
    }

    public final String getWORKSPACETYPE() {
        return this.GetParamStringValue(TAG_WORKSPACETYPE, "");
    }

    public final void setWORKSPACETYPE(String strValue) {
        this.SetParamValue(TAG_WORKSPACETYPE, strValue);
    }

    public final boolean isWORKSPACESTATENull() {
        return this.IsParamNull(TAG_WORKSPACESTATE);
    }

    public final int getWORKSPACESTATE() {
        return this.GetParamIntValue(TAG_WORKSPACESTATE, 0);
    }

    public final void setWORKSPACESTATE(int nValue) {
        this.SetParamValue(TAG_WORKSPACESTATE, nValue);
    }

    public final boolean isVALIDFLAGNull() {
        return this.IsParamNull(TAG_VALIDFLAG);
    }

    public final boolean getVALIDFLAG() {
        return this.GetParamIntValue(TAG_VALIDFLAG, 0) == 1;
    }

    public final void setVALIDFLAG(boolean bValue) {
        this.SetParamValue(TAG_VALIDFLAG, bValue ? 1 : 0);
    }

    public final boolean isMEMONull() {
        return this.IsParamNull(TAG_MEMO);
    }

    public final String getMEMO() {
        return this.GetParamStringValue(TAG_MEMO, "");
    }

    public final void setMEMO(String strValue) {
        this.SetParamValue(TAG_MEMO, strValue);
    }

    public final boolean isPARAMNull() {
        return this.IsParamNull(TAG_PARAM);
    }

    public final String getPARAM() {
        return this.GetParamStringValue(TAG_PARAM, "");
    }

    public final void setPARAM(String strValue) {
        this.SetParamValue(TAG_PARAM, strValue);
    }

    public final boolean isPARAM2Null() {
        return this.IsParamNull(TAG_PARAM2);
    }

    public final String getPARAM2() {
        return this.GetParamStringValue(TAG_PARAM2, "");
    }

    public final void setPARAM2(String strValue) {
        this.SetParamValue(TAG_PARAM2, strValue);
    }

    public final boolean isPARAM3Null() {
        return this.IsParamNull(TAG_PARAM3);
    }

    public final String getPARAM3() {
        return this.GetParamStringValue(TAG_PARAM3, "");
    }

    public final void setPARAM3(String strValue) {
        this.SetParamValue(TAG_PARAM3, strValue);
    }

    public final boolean isPARAM4Null() {
        return this.IsParamNull(TAG_PARAM4);
    }

    public final String getPARAM4() {
        return this.GetParamStringValue(TAG_PARAM4, "");
    }

    public final void setPARAM4(String strValue) {
        this.SetParamValue(TAG_PARAM4, strValue);
    }

    public final boolean isPARAM5Null() {
        return this.IsParamNull(TAG_PARAM5);
    }

    public final int getPARAM5() {
        return this.GetParamIntValue(TAG_PARAM5, 0);
    }

    public final void setPARAM5(int nValue) {
        this.SetParamValue(TAG_PARAM5, nValue);
    }

    public final boolean isPARAM6Null() {
        return this.IsParamNull(TAG_PARAM6);
    }

    public final int getPARAM6() {
        return this.GetParamIntValue(TAG_PARAM6, 0);
    }

    public final void setPARAM6(int nValue) {
        this.SetParamValue(TAG_PARAM6, nValue);
    }

    public final boolean isPARAM7Null() {
        return this.IsParamNull(TAG_PARAM7);
    }

    public final int getPARAM7() {
        return this.GetParamIntValue(TAG_PARAM7, 0);
    }

    public final void setPARAM7(int nValue) {
        this.SetParamValue(TAG_PARAM7, nValue);
    }

    public final boolean isPARAM8Null() {
        return this.IsParamNull(TAG_PARAM8);
    }

    public final int getPARAM8() {
        return this.GetParamIntValue(TAG_PARAM8, 0);
    }

    public final void setPARAM8(int nValue) {
        this.SetParamValue(TAG_PARAM8, nValue);
    }

    public final boolean isWORKSPACELEVELNull() {
        return this.IsParamNull(TAG_WORKSPACELEVEL);
    }

    public final int getWORKSPACELEVEL() {
        return this.GetParamIntValue(TAG_WORKSPACELEVEL, 0);
    }

    public final void setWORKSPACELEVEL(int nValue) {
        this.SetParamValue(TAG_WORKSPACELEVEL, nValue);
    }

    public final boolean isEXPIREDTIMENull() {
        return this.IsParamNull(TAG_EXPIREDTIME);
    }

    public final Date getEXPIREDTIME() {
        return this.GetParamDateValue(TAG_EXPIREDTIME, null);
    }

    public final void setEXPIREDTIME(Date dtValue) {
        this.SetParamValue(TAG_EXPIREDTIME, dtValue);
    }

    public final boolean isMAXDEVUSERNull() {
        return this.IsParamNull(TAG_MAXDEVUSER);
    }

    public final int getMAXDEVUSER() {
        return this.GetParamIntValue(TAG_MAXDEVUSER, 0);
    }

    public final void setMAXDEVUSER(int nValue) {
        this.SetParamValue(TAG_MAXDEVUSER, nValue);
    }
}

