/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.ArrayList;
import java.util.Date;

public class PSHelpModule
extends BaseDataEntity {
    public static final String TAG_PSHELPMODULEID = "PSHELPMODULEID";
    public static final String TAG_PSHELPMODULENAME = "PSHELPMODULENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSHELPPRJID = "PSHELPPRJID";
    public static final String TAG_PSHELPPRJNAME = "PSHELPPRJNAME";
    public static final String TAG_PPSHELPMODULEID = "PPSHELPMODULEID";
    public static final String TAG_PPSHELPMODULENAME = "PPSHELPMODULENAME";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_ORDERVALUE = "ORDERVALUE";
    public static final String TAG_PSHELPARTICLEID = "PSHELPARTICLEID";
    public static final String TAG_PSHELPARTICLENAME = "PSHELPARTICLENAME";
    public static final String TAG_MODULESN = "MODULESN";
    public static final String TAG_ARTICLEURL = "ARTICLEURL";
    public static final String TAG_CODENAME = "CODENAME";
    public static final String TAG_USERCAT = "USERCAT";
    public static final String TAG_USERTAG = "USERTAG";
    public static final String TAG_USERTAG2 = "USERTAG2";
    public static final String TAG_USERTAG3 = "USERTAG3";
    public static final String TAG_USERTAG4 = "USERTAG4";
    public static final String TAG_MODPARAM = "MODPARAM";
    public static final String TAG_MODPARAM2 = "MODPARAM2";
    private ArrayList<PSHelpModule> childPSHelpModuleList = null;

    public final boolean isPSHELPMODULEIDNull() {
        return this.IsParamNull(TAG_PSHELPMODULEID);
    }

    public final String getPSHELPMODULEID() {
        return this.GetParamStringValue(TAG_PSHELPMODULEID, "");
    }

    public final void setPSHELPMODULEID(String strValue) {
        this.SetParamValue(TAG_PSHELPMODULEID, strValue);
    }

    public final boolean isPSHELPMODULENAMENull() {
        return this.IsParamNull(TAG_PSHELPMODULENAME);
    }

    public final String getPSHELPMODULENAME() {
        return this.GetParamStringValue(TAG_PSHELPMODULENAME, "");
    }

    public final void setPSHELPMODULENAME(String strValue) {
        this.SetParamValue(TAG_PSHELPMODULENAME, strValue);
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

    public final boolean isPSHELPPRJIDNull() {
        return this.IsParamNull(TAG_PSHELPPRJID);
    }

    public final String getPSHELPPRJID() {
        return this.GetParamStringValue(TAG_PSHELPPRJID, "");
    }

    public final void setPSHELPPRJID(String strValue) {
        this.SetParamValue(TAG_PSHELPPRJID, strValue);
    }

    public final boolean isPSHELPPRJNAMENull() {
        return this.IsParamNull(TAG_PSHELPPRJNAME);
    }

    public final String getPSHELPPRJNAME() {
        return this.GetParamStringValue(TAG_PSHELPPRJNAME, "");
    }

    public final void setPSHELPPRJNAME(String strValue) {
        this.SetParamValue(TAG_PSHELPPRJNAME, strValue);
    }

    public final boolean isPPSHELPMODULEIDNull() {
        return this.IsParamNull(TAG_PPSHELPMODULEID);
    }

    public final String getPPSHELPMODULEID() {
        return this.GetParamStringValue(TAG_PPSHELPMODULEID, "");
    }

    public final void setPPSHELPMODULEID(String strValue) {
        this.SetParamValue(TAG_PPSHELPMODULEID, strValue);
    }

    public final boolean isPPSHELPMODULENAMENull() {
        return this.IsParamNull(TAG_PPSHELPMODULENAME);
    }

    public final String getPPSHELPMODULENAME() {
        return this.GetParamStringValue(TAG_PPSHELPMODULENAME, "");
    }

    public final void setPPSHELPMODULENAME(String strValue) {
        this.SetParamValue(TAG_PPSHELPMODULENAME, strValue);
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

    public final boolean isORDERVALUENull() {
        return this.IsParamNull(TAG_ORDERVALUE);
    }

    public final int getORDERVALUE() {
        return this.GetParamIntValue(TAG_ORDERVALUE, 0);
    }

    public final void setORDERVALUE(int nValue) {
        this.SetParamValue(TAG_ORDERVALUE, nValue);
    }

    public final boolean isPSHELPARTICLEIDNull() {
        return this.IsParamNull(TAG_PSHELPARTICLEID);
    }

    public final String getPSHELPARTICLEID() {
        return this.GetParamStringValue(TAG_PSHELPARTICLEID, "");
    }

    public final void setPSHELPARTICLEID(String strValue) {
        this.SetParamValue(TAG_PSHELPARTICLEID, strValue);
    }

    public final boolean isPSHELPARTICLENAMENull() {
        return this.IsParamNull(TAG_PSHELPARTICLENAME);
    }

    public final String getPSHELPARTICLENAME() {
        return this.GetParamStringValue(TAG_PSHELPARTICLENAME, "");
    }

    public final void setPSHELPARTICLENAME(String strValue) {
        this.SetParamValue(TAG_PSHELPARTICLENAME, strValue);
    }

    public final boolean isMODULESNNull() {
        return this.IsParamNull(TAG_MODULESN);
    }

    public final String getMODULESN() {
        return this.GetParamStringValue(TAG_MODULESN, "");
    }

    public final void setMODULESN(String strValue) {
        this.SetParamValue(TAG_MODULESN, strValue);
    }

    public final boolean isARTICLEURLNull() {
        return this.IsParamNull(TAG_ARTICLEURL);
    }

    public final String getARTICLEURL() {
        return this.GetParamStringValue(TAG_ARTICLEURL, "");
    }

    public final void setARTICLEURL(String strValue) {
        this.SetParamValue(TAG_ARTICLEURL, strValue);
    }

    public final boolean isCODENAMENull() {
        return this.IsParamNull(TAG_CODENAME);
    }

    public final String getCODENAME() {
        return this.GetParamStringValue(TAG_CODENAME, "");
    }

    public final void setCODENAME(String strValue) {
        this.SetParamValue(TAG_CODENAME, strValue);
    }

    public final boolean isUSERCATNull() {
        return this.IsParamNull(TAG_USERCAT);
    }

    public final String getUSERCAT() {
        return this.GetParamStringValue(TAG_USERCAT, "");
    }

    public final void setUSERCAT(String strValue) {
        this.SetParamValue(TAG_USERCAT, strValue);
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

    public final boolean isUSERTAG3Null() {
        return this.IsParamNull(TAG_USERTAG3);
    }

    public final String getUSERTAG3() {
        return this.GetParamStringValue(TAG_USERTAG3, "");
    }

    public final void setUSERTAG3(String strValue) {
        this.SetParamValue(TAG_USERTAG3, strValue);
    }

    public final boolean isUSERTAG4Null() {
        return this.IsParamNull(TAG_USERTAG4);
    }

    public final String getUSERTAG4() {
        return this.GetParamStringValue(TAG_USERTAG4, "");
    }

    public final void setUSERTAG4(String strValue) {
        this.SetParamValue(TAG_USERTAG4, strValue);
    }

    public final boolean isMODPARAMNull() {
        return this.IsParamNull(TAG_MODPARAM);
    }

    public final String getMODPARAM() {
        return this.GetParamStringValue(TAG_MODPARAM, "");
    }

    public final void setMODPARAM(String strValue) {
        this.SetParamValue(TAG_MODPARAM, strValue);
    }

    public final boolean isMODPARAM2Null() {
        return this.IsParamNull(TAG_MODPARAM2);
    }

    public final String getMODPARAM2() {
        return this.GetParamStringValue(TAG_MODPARAM2, "");
    }

    public final void setMODPARAM2(String strValue) {
        this.SetParamValue(TAG_MODPARAM2, strValue);
    }

    public ArrayList<PSHelpModule> getChildPSHelpModules(boolean bCreated) {
        if (this.childPSHelpModuleList != null) {
            return this.childPSHelpModuleList;
        }
        if (bCreated) {
            this.childPSHelpModuleList = new ArrayList();
        }
        return this.childPSHelpModuleList;
    }

    public void resetChildDatas() {
        if (this.childPSHelpModuleList != null) {
            this.childPSHelpModuleList.clear();
            this.childPSHelpModuleList = null;
        }
    }
}

