/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSDevSlnSysDepInst
extends BaseDataEntity {
    public static final int DEPINSTSTATE_30 = 30;
    public static final int DEPINSTSTATE_31 = 31;
    public static final int DEPINSTSTATE_35 = 35;
    public static final int DEPINSTSTATE_40 = 40;
    public static final int DEPINSTSTATE_42 = 42;
    public static final int BACKUPSTATE_10 = 10;
    public static final int BACKUPSTATE_20 = 20;
    public static final int BACKUPSTATE_30 = 30;
    public static final int BACKUPSTATE_40 = 40;
    public static final String TAG_PSDEVSLNSYSDEPINSTID = "PSDEVSLNSYSDEPINSTID";
    public static final String TAG_PSDEVSLNSYSDEPINSTNAME = "PSDEVSLNSYSDEPINSTNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSDEVSLNSYSID = "PSDEVSLNSYSID";
    public static final String TAG_PSDEVSLNSYSNAME = "PSDEVSLNSYSNAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_PSTASKSERVERID = "PSTASKSERVERID";
    public static final String TAG_PSTASKSERVERNAME = "PSTASKSERVERNAME";
    public static final String TAG_PSSYSMODELINSTID = "PSSYSMODELINSTID";
    public static final String TAG_PSSYSMODELINSTNAME = "PSSYSMODELINSTNAME";
    public static final String TAG_DEPINSTSTATE = "DEPINSTSTATE";
    public static final String TAG_MODELVER = "MODELVER";
    public static final String TAG_PSDEVCENTERID = "PSDEVCENTERID";
    public static final String TAG_PSDEVCENTERNAME = "PSDEVCENTERNAME";
    public static final String TAG_BACKUPFILEPATH = "BACKUPFILEPATH";
    public static final String TAG_BACKUPSIZE = "BACKUPSIZE";
    public static final String TAG_BACKUPTIME = "BACKUPTIME";
    public static final String TAG_BEGINBACKUPTIME = "BEGINBACKUPTIME";
    public static final String TAG_ENDBACKUPTIME = "ENDBACKUPTIME";
    public static final String TAG_BACKUPSTATE = "BACKUPSTATE";
    public static final String TAG_SINGLEINSTMODE = "SINGLEINSTMODE";
    public static final String TAG_MODELPSDEVCENTERSVNID = "MODELPSDEVCENTERSVNID";
    public static final String TAG_MODELPSDEVCENTERSVNNAME = "MODELPSDEVCENTERSVNNAME";
    public static final String TAG_INSTTAG = "INSTTAG";
    public static final String TAG_INSTTAG2 = "INSTTAG2";
    public static final String TAG_INSTTAG3 = "INSTTAG3";
    public static final String TAG_INSTTAG4 = "INSTTAG4";
    public static final String TAG_INSTVER = "INSTVER";

    public final boolean isPSDEVSLNSYSDEPINSTIDNull() {
        return this.IsParamNull(TAG_PSDEVSLNSYSDEPINSTID);
    }

    public final String getPSDEVSLNSYSDEPINSTID() {
        return this.GetParamStringValue(TAG_PSDEVSLNSYSDEPINSTID, "");
    }

    public final void setPSDEVSLNSYSDEPINSTID(String strValue) {
        this.SetParamValue(TAG_PSDEVSLNSYSDEPINSTID, strValue);
    }

    public final boolean isPSDEVSLNSYSDEPINSTNAMENull() {
        return this.IsParamNull(TAG_PSDEVSLNSYSDEPINSTNAME);
    }

    public final String getPSDEVSLNSYSDEPINSTNAME() {
        return this.GetParamStringValue(TAG_PSDEVSLNSYSDEPINSTNAME, "");
    }

    public final void setPSDEVSLNSYSDEPINSTNAME(String strValue) {
        this.SetParamValue(TAG_PSDEVSLNSYSDEPINSTNAME, strValue);
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

    public final boolean isPSDEVSLNSYSIDNull() {
        return this.IsParamNull(TAG_PSDEVSLNSYSID);
    }

    public final String getPSDEVSLNSYSID() {
        return this.GetParamStringValue(TAG_PSDEVSLNSYSID, "");
    }

    public final void setPSDEVSLNSYSID(String strValue) {
        this.SetParamValue(TAG_PSDEVSLNSYSID, strValue);
    }

    public final boolean isPSDEVSLNSYSNAMENull() {
        return this.IsParamNull(TAG_PSDEVSLNSYSNAME);
    }

    public final String getPSDEVSLNSYSNAME() {
        return this.GetParamStringValue(TAG_PSDEVSLNSYSNAME, "");
    }

    public final void setPSDEVSLNSYSNAME(String strValue) {
        this.SetParamValue(TAG_PSDEVSLNSYSNAME, strValue);
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

    public final boolean isPSTASKSERVERIDNull() {
        return this.IsParamNull(TAG_PSTASKSERVERID);
    }

    public final String getPSTASKSERVERID() {
        return this.GetParamStringValue(TAG_PSTASKSERVERID, "");
    }

    public final void setPSTASKSERVERID(String strValue) {
        this.SetParamValue(TAG_PSTASKSERVERID, strValue);
    }

    public final boolean isPSTASKSERVERNAMENull() {
        return this.IsParamNull(TAG_PSTASKSERVERNAME);
    }

    public final String getPSTASKSERVERNAME() {
        return this.GetParamStringValue(TAG_PSTASKSERVERNAME, "");
    }

    public final void setPSTASKSERVERNAME(String strValue) {
        this.SetParamValue(TAG_PSTASKSERVERNAME, strValue);
    }

    public final boolean isPSSYSMODELINSTIDNull() {
        return this.IsParamNull(TAG_PSSYSMODELINSTID);
    }

    public final String getPSSYSMODELINSTID() {
        return this.GetParamStringValue(TAG_PSSYSMODELINSTID, "");
    }

    public final void setPSSYSMODELINSTID(String strValue) {
        this.SetParamValue(TAG_PSSYSMODELINSTID, strValue);
    }

    public final boolean isPSSYSMODELINSTNAMENull() {
        return this.IsParamNull(TAG_PSSYSMODELINSTNAME);
    }

    public final String getPSSYSMODELINSTNAME() {
        return this.GetParamStringValue(TAG_PSSYSMODELINSTNAME, "");
    }

    public final void setPSSYSMODELINSTNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSMODELINSTNAME, strValue);
    }

    public final boolean isDEPINSTSTATENull() {
        return this.IsParamNull(TAG_DEPINSTSTATE);
    }

    public final int getDEPINSTSTATE() {
        return this.GetParamIntValue(TAG_DEPINSTSTATE, 0);
    }

    public final void setDEPINSTSTATE(int nValue) {
        this.SetParamValue(TAG_DEPINSTSTATE, nValue);
    }

    public final boolean isMODELVERNull() {
        return this.IsParamNull(TAG_MODELVER);
    }

    public final int getMODELVER() {
        return this.GetParamIntValue(TAG_MODELVER, 0);
    }

    public final void setMODELVER(int nValue) {
        this.SetParamValue(TAG_MODELVER, nValue);
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

    public final boolean isBACKUPFILEPATHNull() {
        return this.IsParamNull(TAG_BACKUPFILEPATH);
    }

    public final String getBACKUPFILEPATH() {
        return this.GetParamStringValue(TAG_BACKUPFILEPATH, "");
    }

    public final void setBACKUPFILEPATH(String strValue) {
        this.SetParamValue(TAG_BACKUPFILEPATH, strValue);
    }

    public final boolean isBACKUPSIZENull() {
        return this.IsParamNull(TAG_BACKUPSIZE);
    }

    public final int getBACKUPSIZE() {
        return this.GetParamIntValue(TAG_BACKUPSIZE, 0);
    }

    public final void setBACKUPSIZE(int nValue) {
        this.SetParamValue(TAG_BACKUPSIZE, nValue);
    }

    public final boolean isBACKUPTIMENull() {
        return this.IsParamNull(TAG_BACKUPTIME);
    }

    public final Date getBACKUPTIME() {
        return this.GetParamDateValue(TAG_BACKUPTIME, null);
    }

    public final void setBACKUPTIME(Date dtValue) {
        this.SetParamValue(TAG_BACKUPTIME, dtValue);
    }

    public final boolean isBEGINBACKUPTIMENull() {
        return this.IsParamNull(TAG_BEGINBACKUPTIME);
    }

    public final Date getBEGINBACKUPTIME() {
        return this.GetParamDateValue(TAG_BEGINBACKUPTIME, null);
    }

    public final void setBEGINBACKUPTIME(Date dtValue) {
        this.SetParamValue(TAG_BEGINBACKUPTIME, dtValue);
    }

    public final boolean isENDBACKUPTIMENull() {
        return this.IsParamNull(TAG_ENDBACKUPTIME);
    }

    public final Date getENDBACKUPTIME() {
        return this.GetParamDateValue(TAG_ENDBACKUPTIME, null);
    }

    public final void setENDBACKUPTIME(Date dtValue) {
        this.SetParamValue(TAG_ENDBACKUPTIME, dtValue);
    }

    public final boolean isBACKUPSTATENull() {
        return this.IsParamNull(TAG_BACKUPSTATE);
    }

    public final int getBACKUPSTATE() {
        return this.GetParamIntValue(TAG_BACKUPSTATE, 0);
    }

    public final void setBACKUPSTATE(int nValue) {
        this.SetParamValue(TAG_BACKUPSTATE, nValue);
    }

    public final boolean isSINGLEINSTMODENull() {
        return this.IsParamNull(TAG_SINGLEINSTMODE);
    }

    public final boolean getSINGLEINSTMODE() {
        return this.GetParamIntValue(TAG_SINGLEINSTMODE, 0) == 1;
    }

    public final void setSINGLEINSTMODE(boolean bValue) {
        this.SetParamValue(TAG_SINGLEINSTMODE, bValue ? 1 : 0);
    }

    public final boolean isMODELPSDEVCENTERSVNIDNull() {
        return this.IsParamNull(TAG_MODELPSDEVCENTERSVNID);
    }

    public final String getMODELPSDEVCENTERSVNID() {
        return this.GetParamStringValue(TAG_MODELPSDEVCENTERSVNID, "");
    }

    public final void setMODELPSDEVCENTERSVNID(String strValue) {
        this.SetParamValue(TAG_MODELPSDEVCENTERSVNID, strValue);
    }

    public final boolean isMODELPSDEVCENTERSVNNAMENull() {
        return this.IsParamNull(TAG_MODELPSDEVCENTERSVNNAME);
    }

    public final String getMODELPSDEVCENTERSVNNAME() {
        return this.GetParamStringValue(TAG_MODELPSDEVCENTERSVNNAME, "");
    }

    public final void setMODELPSDEVCENTERSVNNAME(String strValue) {
        this.SetParamValue(TAG_MODELPSDEVCENTERSVNNAME, strValue);
    }

    public final boolean isINSTTAGNull() {
        return this.IsParamNull(TAG_INSTTAG);
    }

    public final String getINSTTAG() {
        return this.GetParamStringValue(TAG_INSTTAG, "");
    }

    public final void setINSTTAG(String strValue) {
        this.SetParamValue(TAG_INSTTAG, strValue);
    }

    public final boolean isINSTTAG2Null() {
        return this.IsParamNull(TAG_INSTTAG2);
    }

    public final String getINSTTAG2() {
        return this.GetParamStringValue(TAG_INSTTAG2, "");
    }

    public final void setINSTTAG2(String strValue) {
        this.SetParamValue(TAG_INSTTAG2, strValue);
    }

    public final boolean isINSTTAG3Null() {
        return this.IsParamNull(TAG_INSTTAG3);
    }

    public final String getINSTTAG3() {
        return this.GetParamStringValue(TAG_INSTTAG3, "");
    }

    public final void setINSTTAG3(String strValue) {
        this.SetParamValue(TAG_INSTTAG3, strValue);
    }

    public final boolean isINSTTAG4Null() {
        return this.IsParamNull(TAG_INSTTAG4);
    }

    public final String getINSTTAG4() {
        return this.GetParamStringValue(TAG_INSTTAG4, "");
    }

    public final void setINSTTAG4(String strValue) {
        this.SetParamValue(TAG_INSTTAG4, strValue);
    }

    public final boolean isINSTVERNull() {
        return this.IsParamNull(TAG_INSTVER);
    }

    public final int getINSTVER() {
        return this.GetParamIntValue(TAG_INSTVER, 0);
    }

    public final void setINSTVER(int nValue) {
        this.SetParamValue(TAG_INSTVER, nValue);
    }
}

