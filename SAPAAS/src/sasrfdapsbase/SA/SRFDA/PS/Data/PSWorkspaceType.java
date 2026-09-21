/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSWorkspaceType
extends BaseDataEntity {
    public static final String WORKSPACEUSAGE_DEMO = "DEMO";
    public static final String WORKSPACEUSAGE_DEVTEMPL = "DEVTEMPL";
    public static final String WORKSPACEUSAGE_DEVSYS = "DEVSYS";
    public static final String WORKSPACEMODE_B = "B";
    public static final String WORKSPACEMODE_C = "C";
    public static final String WORKSPACEMODE_T1 = "T1";
    public static final String WORKSPACEMODE_T2 = "T2";
    public static final String TAG_PSWORKSPACETYPEID = "PSWORKSPACETYPEID";
    public static final String TAG_PSWORKSPACETYPENAME = "PSWORKSPACETYPENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_USERTAG = "USERTAG";
    public static final String TAG_USERTAG2 = "USERTAG2";
    public static final String TAG_TYPEPARAMS = "TYPEPARAMS";
    public static final String TAG_PSMODELLIMITS = "PSMODELLIMITS";
    public static final String TAG_MAXDEVUSER = "MAXDEVUSER";
    public static final String TAG_WORKSPACEUSAGE = "WORKSPACEUSAGE";
    public static final String TAG_EXP = "EXP";
    public static final String TAG_EXP2 = "EXP2";
    public static final String TAG_WORKSPACEMODE = "WORKSPACEMODE";
    public static final String TAG_ENTITYLIST = "ENTITYLIST";

    public final boolean isPSWORKSPACETYPEIDNull() {
        return this.IsParamNull(TAG_PSWORKSPACETYPEID);
    }

    public final String getPSWORKSPACETYPEID() {
        return this.GetParamStringValue(TAG_PSWORKSPACETYPEID, "");
    }

    public final void setPSWORKSPACETYPEID(String strValue) {
        this.SetParamValue(TAG_PSWORKSPACETYPEID, strValue);
    }

    public final boolean isPSWORKSPACETYPENAMENull() {
        return this.IsParamNull(TAG_PSWORKSPACETYPENAME);
    }

    public final String getPSWORKSPACETYPENAME() {
        return this.GetParamStringValue(TAG_PSWORKSPACETYPENAME, "");
    }

    public final void setPSWORKSPACETYPENAME(String strValue) {
        this.SetParamValue(TAG_PSWORKSPACETYPENAME, strValue);
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

    public final boolean isUSERTAGNull() {
        return this.IsParamNull(TAG_USERTAG);
    }

    public final String getUSERTAG() {
        return this.GetParamStringValue(TAG_USERTAG, "");
    }

    public final void setUSERTAG(String strValue) {
        this.SetParamValue(TAG_USERTAG, strValue);
    }

    public final boolean isUSERTAG2Null() {
        return this.IsParamNull(TAG_USERTAG2);
    }

    public final String getUSERTAG2() {
        return this.GetParamStringValue(TAG_USERTAG2, "");
    }

    public final void setUSERTAG2(String strValue) {
        this.SetParamValue(TAG_USERTAG2, strValue);
    }

    public final boolean isTYPEPARAMSNull() {
        return this.IsParamNull(TAG_TYPEPARAMS);
    }

    public final String getTYPEPARAMS() {
        return this.GetParamStringValue(TAG_TYPEPARAMS, "");
    }

    public final void setTYPEPARAMS(String strValue) {
        this.SetParamValue(TAG_TYPEPARAMS, strValue);
    }

    public final boolean isPSMODELLIMITSNull() {
        return this.IsParamNull(TAG_PSMODELLIMITS);
    }

    public final String getPSMODELLIMITS() {
        return this.GetParamStringValue(TAG_PSMODELLIMITS, "");
    }

    public final void setPSMODELLIMITS(String strValue) {
        this.SetParamValue(TAG_PSMODELLIMITS, strValue);
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

    public final boolean isWORKSPACEUSAGENull() {
        return this.IsParamNull(TAG_WORKSPACEUSAGE);
    }

    public final String getWORKSPACEUSAGE() {
        return this.GetParamStringValue(TAG_WORKSPACEUSAGE, "");
    }

    public final void setWORKSPACEUSAGE(String strValue) {
        this.SetParamValue(TAG_WORKSPACEUSAGE, strValue);
    }

    public final boolean isEXPNull() {
        return this.IsParamNull(TAG_EXP);
    }

    public final long getEXP() {
        return this.GetParamLongValue(TAG_EXP, 0L);
    }

    public final void setEXP(long strValue) {
        this.SetParamValue(TAG_EXP, strValue);
    }

    public final boolean isEXP2Null() {
        return this.IsParamNull(TAG_EXP2);
    }

    public final long getEXP2() {
        return this.GetParamLongValue(TAG_EXP2, 0L);
    }

    public final void setEXP2(long nValue) {
        this.SetParamValue(TAG_EXP2, nValue);
    }

    public final boolean isWORKSPACEMODENull() {
        return this.IsParamNull(TAG_WORKSPACEMODE);
    }

    public final String getWORKSPACEMODE() {
        return this.GetParamStringValue(TAG_WORKSPACEMODE, "");
    }

    public final void setWORKSPACEMODE(String strValue) {
        this.SetParamValue(TAG_WORKSPACEMODE, strValue);
    }

    public final boolean isENTITYLISTNull() {
        return this.IsParamNull(TAG_ENTITYLIST);
    }

    public final String getENTITYLIST() {
        return this.GetParamStringValue(TAG_ENTITYLIST, "");
    }

    public final void setENTITYLIST(String strValue) {
        this.SetParamValue(TAG_ENTITYLIST, strValue);
    }
}

