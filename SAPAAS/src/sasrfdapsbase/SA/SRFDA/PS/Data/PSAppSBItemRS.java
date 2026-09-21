/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSAppSBItemRS
extends BaseDataEntity {
    public static final String USERCAT_CAT1 = "CAT1";
    public static final String USERCAT_CAT2 = "CAT2";
    public static final String USERCAT_CAT3 = "CAT3";
    public static final String USERCAT_CAT4 = "CAT4";
    public static final String USERCAT_CAT5 = "CAT5";
    public static final String USERCAT_CAT6 = "CAT6";
    public static final String USERCAT_CAT7 = "CAT7";
    public static final String USERCAT_CAT8 = "CAT8";
    public static final String USERCAT_CAT9 = "CAT9";
    public static final String TAG_PSAPPSBITEMRSID = "PSAPPSBITEMRSID";
    public static final String TAG_PSAPPSBITEMRSNAME = "PSAPPSBITEMRSNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_USERTAG4 = "USERTAG4";
    public static final String TAG_USERTAG3 = "USERTAG3";
    public static final String TAG_USERTAG2 = "USERTAG2";
    public static final String TAG_USERTAG = "USERTAG";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_PSAPPSTORYBOARDID = "PSAPPSTORYBOARDID";
    public static final String TAG_PSAPPSTORYBOARDNAME = "PSAPPSTORYBOARDNAME";
    public static final String TAG_ORDERVALUE = "ORDERVALUE";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";
    public static final String TAG_PSSYSAPPID = "PSSYSAPPID";
    public static final String TAG_PPSAPPSBITEMID = "PPSAPPSBITEMID";
    public static final String TAG_PPSAPPSBITEMNAME = "PPSAPPSBITEMNAME";
    public static final String TAG_CPSAPPSBITEMID = "CPSAPPSBITEMID";
    public static final String TAG_CPSAPPSBITEMNAME = "CPSAPPSBITEMNAME";
    public static final String TAG_RSTYPE = "RSTYPE";
    public static final String TAG_DSTENDPOINT = "DSTENDPOINT";
    public static final String TAG_SRCENDPOINT = "SRCENDPOINT";
    public static final String TAG_USERFLAG = "USERFLAG";
    public static final String TAG_USERCAT = "USERCAT";
    public static final String TAG_CODENAME = "CODENAME";

    public final boolean isPSAPPSBITEMRSIDNull() {
        return this.IsParamNull(TAG_PSAPPSBITEMRSID);
    }

    public final String getPSAPPSBITEMRSID() {
        return this.GetParamStringValue(TAG_PSAPPSBITEMRSID, "");
    }

    public final void setPSAPPSBITEMRSID(String strValue) {
        this.SetParamValue(TAG_PSAPPSBITEMRSID, strValue);
    }

    public final boolean isPSAPPSBITEMRSNAMENull() {
        return this.IsParamNull(TAG_PSAPPSBITEMRSNAME);
    }

    public final String getPSAPPSBITEMRSNAME() {
        return this.GetParamStringValue(TAG_PSAPPSBITEMRSNAME, "");
    }

    public final void setPSAPPSBITEMRSNAME(String strValue) {
        this.SetParamValue(TAG_PSAPPSBITEMRSNAME, strValue);
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

    public final boolean isUSERTAG4Null() {
        return this.IsParamNull(TAG_USERTAG4);
    }

    public final String getUSERTAG4() {
        return this.GetParamStringValue(TAG_USERTAG4, "");
    }

    public final void setUSERTAG4(String strValue) {
        this.SetParamValue(TAG_USERTAG4, strValue);
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

    public final boolean isUSERTAG2Null() {
        return this.IsParamNull(TAG_USERTAG2);
    }

    public final String getUSERTAG2() {
        return this.GetParamStringValue(TAG_USERTAG2, "");
    }

    public final void setUSERTAG2(String strValue) {
        this.SetParamValue(TAG_USERTAG2, strValue);
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

    public final boolean isMEMONull() {
        return this.IsParamNull(TAG_MEMO);
    }

    public final String getMEMO() {
        return this.GetParamStringValue(TAG_MEMO, "");
    }

    public final void setMEMO(String strValue) {
        this.SetParamValue(TAG_MEMO, strValue);
    }

    public final boolean isPSAPPSTORYBOARDIDNull() {
        return this.IsParamNull(TAG_PSAPPSTORYBOARDID);
    }

    public final String getPSAPPSTORYBOARDID() {
        return this.GetParamStringValue(TAG_PSAPPSTORYBOARDID, "");
    }

    public final void setPSAPPSTORYBOARDID(String strValue) {
        this.SetParamValue(TAG_PSAPPSTORYBOARDID, strValue);
    }

    public final boolean isPSAPPSTORYBOARDNAMENull() {
        return this.IsParamNull(TAG_PSAPPSTORYBOARDNAME);
    }

    public final String getPSAPPSTORYBOARDNAME() {
        return this.GetParamStringValue(TAG_PSAPPSTORYBOARDNAME, "");
    }

    public final void setPSAPPSTORYBOARDNAME(String strValue) {
        this.SetParamValue(TAG_PSAPPSTORYBOARDNAME, strValue);
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

    public final boolean isVALIDFLAGNull() {
        return this.IsParamNull(TAG_VALIDFLAG);
    }

    public final boolean getVALIDFLAG() {
        return this.GetParamIntValue(TAG_VALIDFLAG, 0) == 1;
    }

    public final void setVALIDFLAG(boolean bValue) {
        this.SetParamValue(TAG_VALIDFLAG, bValue ? 1 : 0);
    }

    public final boolean isPSSYSAPPIDNull() {
        return this.IsParamNull(TAG_PSSYSAPPID);
    }

    public final String getPSSYSAPPID() {
        return this.GetParamStringValue(TAG_PSSYSAPPID, "");
    }

    public final void setPSSYSAPPID(String strValue) {
        this.SetParamValue(TAG_PSSYSAPPID, strValue);
    }

    public final boolean isPPSAPPSBITEMIDNull() {
        return this.IsParamNull(TAG_PPSAPPSBITEMID);
    }

    public final String getPPSAPPSBITEMID() {
        return this.GetParamStringValue(TAG_PPSAPPSBITEMID, "");
    }

    public final void setPPSAPPSBITEMID(String strValue) {
        this.SetParamValue(TAG_PPSAPPSBITEMID, strValue);
    }

    public final boolean isPPSAPPSBITEMNAMENull() {
        return this.IsParamNull(TAG_PPSAPPSBITEMNAME);
    }

    public final String getPPSAPPSBITEMNAME() {
        return this.GetParamStringValue(TAG_PPSAPPSBITEMNAME, "");
    }

    public final void setPPSAPPSBITEMNAME(String strValue) {
        this.SetParamValue(TAG_PPSAPPSBITEMNAME, strValue);
    }

    public final boolean isCPSAPPSBITEMIDNull() {
        return this.IsParamNull(TAG_CPSAPPSBITEMID);
    }

    public final String getCPSAPPSBITEMID() {
        return this.GetParamStringValue(TAG_CPSAPPSBITEMID, "");
    }

    public final void setCPSAPPSBITEMID(String strValue) {
        this.SetParamValue(TAG_CPSAPPSBITEMID, strValue);
    }

    public final boolean isCPSAPPSBITEMNAMENull() {
        return this.IsParamNull(TAG_CPSAPPSBITEMNAME);
    }

    public final String getCPSAPPSBITEMNAME() {
        return this.GetParamStringValue(TAG_CPSAPPSBITEMNAME, "");
    }

    public final void setCPSAPPSBITEMNAME(String strValue) {
        this.SetParamValue(TAG_CPSAPPSBITEMNAME, strValue);
    }

    public final boolean isRSTYPENull() {
        return this.IsParamNull(TAG_RSTYPE);
    }

    public final String getRSTYPE() {
        return this.GetParamStringValue(TAG_RSTYPE, "");
    }

    public final void setRSTYPE(String strValue) {
        this.SetParamValue(TAG_RSTYPE, strValue);
    }

    public final boolean isDSTENDPOINTNull() {
        return this.IsParamNull(TAG_DSTENDPOINT);
    }

    public final String getDSTENDPOINT() {
        return this.GetParamStringValue(TAG_DSTENDPOINT, "");
    }

    public final void setDSTENDPOINT(String strValue) {
        this.SetParamValue(TAG_DSTENDPOINT, strValue);
    }

    public final boolean isSRCENDPOINTNull() {
        return this.IsParamNull(TAG_SRCENDPOINT);
    }

    public final String getSRCENDPOINT() {
        return this.GetParamStringValue(TAG_SRCENDPOINT, "");
    }

    public final void setSRCENDPOINT(String strValue) {
        this.SetParamValue(TAG_SRCENDPOINT, strValue);
    }

    public final boolean isUSERFLAGNull() {
        return this.IsParamNull(TAG_USERFLAG);
    }

    public final boolean getUSERFLAG() {
        return this.GetParamIntValue(TAG_USERFLAG, 0) == 1;
    }

    public final void setUSERFLAG(boolean bValue) {
        this.SetParamValue(TAG_USERFLAG, bValue ? 1 : 0);
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

    public final boolean isCODENAMENull() {
        return this.IsParamNull(TAG_CODENAME);
    }

    public final String getCODENAME() {
        return this.GetParamStringValue(TAG_CODENAME, "");
    }

    public final void setCODENAME(String strValue) {
        this.SetParamValue(TAG_CODENAME, strValue);
    }
}

