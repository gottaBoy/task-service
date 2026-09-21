/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSSubSysSADERS
extends BaseDataEntity {
    public static final String TAG_PSSUBSYSSADERSID = "PSSUBSYSSADERSID";
    public static final String TAG_PSSUBSYSSADERSNAME = "PSSUBSYSSADERSNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSSUBSYSSERVICEAPIID = "PSSUBSYSSERVICEAPIID";
    public static final String TAG_PSSUBSYSSERVICEAPINAME = "PSSUBSYSSERVICEAPINAME";
    public static final String TAG_PPSSUBSYSSADEID = "PPSSUBSYSSADEID";
    public static final String TAG_PPSSUBSYSSADENAME = "PPSSUBSYSSADENAME";
    public static final String TAG_CPSSUBSYSSADEID = "CPSSUBSYSSADEID";
    public static final String TAG_CPSSUBSYSSADENAME = "CPSSUBSYSSADENAME";
    public static final String TAG_CHILDFILTER = "CHILDFILTER";
    public static final String TAG_USERTAG2 = "USERTAG2";
    public static final String TAG_USERTAG = "USERTAG";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";
    public static final String TAG_CODENAME = "CODENAME";
    public static final String TAG_ORDERVALUE = "ORDERVALUE";
    public static final String TAG_CODENAME2 = "CODENAME2";
    public static final String TAG_USERCAT = "USERCAT";
    public static final String TAG_USERTAG3 = "USERTAG3";
    public static final String TAG_USERTAG4 = "USERTAG4";
    public static final String TAG_RSTAG = "RSTAG";
    public static final String TAG_RSTAG2 = "RSTAG2";
    public static final String TAG_ARRAYFLAG = "ARRAYFLAG";

    public final boolean isPSSUBSYSSADERSIDNull() {
        return this.IsParamNull(TAG_PSSUBSYSSADERSID);
    }

    public final String getPSSUBSYSSADERSID() {
        return this.GetParamStringValue(TAG_PSSUBSYSSADERSID, "");
    }

    public final void setPSSUBSYSSADERSID(String strValue) {
        this.SetParamValue(TAG_PSSUBSYSSADERSID, strValue);
    }

    public final boolean isPSSUBSYSSADERSNAMENull() {
        return this.IsParamNull(TAG_PSSUBSYSSADERSNAME);
    }

    public final String getPSSUBSYSSADERSNAME() {
        return this.GetParamStringValue(TAG_PSSUBSYSSADERSNAME, "");
    }

    public final void setPSSUBSYSSADERSNAME(String strValue) {
        this.SetParamValue(TAG_PSSUBSYSSADERSNAME, strValue);
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

    public final boolean isPSSUBSYSSERVICEAPIIDNull() {
        return this.IsParamNull(TAG_PSSUBSYSSERVICEAPIID);
    }

    public final String getPSSUBSYSSERVICEAPIID() {
        return this.GetParamStringValue(TAG_PSSUBSYSSERVICEAPIID, "");
    }

    public final void setPSSUBSYSSERVICEAPIID(String strValue) {
        this.SetParamValue(TAG_PSSUBSYSSERVICEAPIID, strValue);
    }

    public final boolean isPSSUBSYSSERVICEAPINAMENull() {
        return this.IsParamNull(TAG_PSSUBSYSSERVICEAPINAME);
    }

    public final String getPSSUBSYSSERVICEAPINAME() {
        return this.GetParamStringValue(TAG_PSSUBSYSSERVICEAPINAME, "");
    }

    public final void setPSSUBSYSSERVICEAPINAME(String strValue) {
        this.SetParamValue(TAG_PSSUBSYSSERVICEAPINAME, strValue);
    }

    public final boolean isPPSSUBSYSSADEIDNull() {
        return this.IsParamNull(TAG_PPSSUBSYSSADEID);
    }

    public final String getPPSSUBSYSSADEID() {
        return this.GetParamStringValue(TAG_PPSSUBSYSSADEID, "");
    }

    public final void setPPSSUBSYSSADEID(String strValue) {
        this.SetParamValue(TAG_PPSSUBSYSSADEID, strValue);
    }

    public final boolean isPPSSUBSYSSADENAMENull() {
        return this.IsParamNull(TAG_PPSSUBSYSSADENAME);
    }

    public final String getPPSSUBSYSSADENAME() {
        return this.GetParamStringValue(TAG_PPSSUBSYSSADENAME, "");
    }

    public final void setPPSSUBSYSSADENAME(String strValue) {
        this.SetParamValue(TAG_PPSSUBSYSSADENAME, strValue);
    }

    public final boolean isCPSSUBSYSSADEIDNull() {
        return this.IsParamNull(TAG_CPSSUBSYSSADEID);
    }

    public final String getCPSSUBSYSSADEID() {
        return this.GetParamStringValue(TAG_CPSSUBSYSSADEID, "");
    }

    public final void setCPSSUBSYSSADEID(String strValue) {
        this.SetParamValue(TAG_CPSSUBSYSSADEID, strValue);
    }

    public final boolean isCPSSUBSYSSADENAMENull() {
        return this.IsParamNull(TAG_CPSSUBSYSSADENAME);
    }

    public final String getCPSSUBSYSSADENAME() {
        return this.GetParamStringValue(TAG_CPSSUBSYSSADENAME, "");
    }

    public final void setCPSSUBSYSSADENAME(String strValue) {
        this.SetParamValue(TAG_CPSSUBSYSSADENAME, strValue);
    }

    public final boolean isCHILDFILTERNull() {
        return this.IsParamNull(TAG_CHILDFILTER);
    }

    public final String getCHILDFILTER() {
        return this.GetParamStringValue(TAG_CHILDFILTER, "");
    }

    public final void setCHILDFILTER(String strValue) {
        this.SetParamValue(TAG_CHILDFILTER, strValue);
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

    public final boolean isVALIDFLAGNull() {
        return this.IsParamNull(TAG_VALIDFLAG);
    }

    public final boolean getVALIDFLAG() {
        return this.GetParamIntValue(TAG_VALIDFLAG, 0) == 1;
    }

    public final void setVALIDFLAG(boolean bValue) {
        this.SetParamValue(TAG_VALIDFLAG, bValue ? 1 : 0);
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

    public final boolean isORDERVALUENull() {
        return this.IsParamNull(TAG_ORDERVALUE);
    }

    public final int getORDERVALUE() {
        return this.GetParamIntValue(TAG_ORDERVALUE, 0);
    }

    public final void setORDERVALUE(int nValue) {
        this.SetParamValue(TAG_ORDERVALUE, nValue);
    }

    public final boolean isCODENAME2Null() {
        return this.IsParamNull(TAG_CODENAME2);
    }

    public final String getCODENAME2() {
        return this.GetParamStringValue(TAG_CODENAME2, "");
    }

    public final void setCODENAME2(String strValue) {
        this.SetParamValue(TAG_CODENAME2, strValue);
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

    public final boolean isRSTAGNull() {
        return this.IsParamNull(TAG_RSTAG);
    }

    public final String getRSTAG() {
        return this.GetParamStringValue(TAG_RSTAG, "");
    }

    public final void setRSTAG(String strValue) {
        this.SetParamValue(TAG_RSTAG, strValue);
    }

    public final boolean isRSTAG2Null() {
        return this.IsParamNull(TAG_RSTAG2);
    }

    public final String getRSTAG2() {
        return this.GetParamStringValue(TAG_RSTAG2, "");
    }

    public final void setRSTAG2(String strValue) {
        this.SetParamValue(TAG_RSTAG2, strValue);
    }

    public final boolean isARRAYFLAGNull() {
        return this.IsParamNull(TAG_ARRAYFLAG);
    }

    public final boolean getARRAYFLAG() {
        return this.GetParamIntValue(TAG_ARRAYFLAG, 0) == 1;
    }

    public final void setARRAYFLAG(boolean bValue) {
        this.SetParamValue(TAG_ARRAYFLAG, bValue ? 1 : 0);
    }
}

