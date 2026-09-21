/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSAppDERS
extends BaseDataEntity {
    public static final String RSVIEWMODE_EXCLUDE = "1";
    public static final String RSVIEWMODE_INCLUDE = "2";
    public static final String TAG_PSAPPDERSID = "PSAPPDERSID";
    public static final String TAG_PSAPPDERSNAME = "PSAPPDERSNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSSYSAPPID = "PSSYSAPPID";
    public static final String TAG_PSSYSAPPNAME = "PSSYSAPPNAME";
    public static final String TAG_CHILDFILTER = "CHILDFILTER";
    public static final String TAG_CODENAME = "CODENAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_ORDERVALUE = "ORDERVALUE";
    public static final String TAG_USERTAG = "USERTAG";
    public static final String TAG_USERTAG2 = "USERTAG2";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";
    public static final String TAG_PSDERID = "PSDERID";
    public static final String TAG_PSDERNAME = "PSDERNAME";
    public static final String TAG_PPSAPPLOCALDEID = "PPSAPPLOCALDEID";
    public static final String TAG_PPSAPPLOCALDENAME = "PPSAPPLOCALDENAME";
    public static final String TAG_CPSAPPLOCALDEID = "CPSAPPLOCALDEID";
    public static final String TAG_CPSAPPLOCALDENAME = "CPSAPPLOCALDENAME";
    public static final String TAG_RSVIEWMODE = "RSVIEWMODE";
    public static final String TAG_CODENAME2 = "CODENAME2";
    public static final String TAG_ARRAYFLAG = "ARRAYFLAG";

    public final boolean isPSAPPDERSIDNull() {
        return this.IsParamNull(TAG_PSAPPDERSID);
    }

    public final String getPSAPPDERSID() {
        return this.GetParamStringValue(TAG_PSAPPDERSID, "");
    }

    public final void setPSAPPDERSID(String strValue) {
        this.SetParamValue(TAG_PSAPPDERSID, strValue);
    }

    public final boolean isPSAPPDERSNAMENull() {
        return this.IsParamNull(TAG_PSAPPDERSNAME);
    }

    public final String getPSAPPDERSNAME() {
        return this.GetParamStringValue(TAG_PSAPPDERSNAME, "");
    }

    public final void setPSAPPDERSNAME(String strValue) {
        this.SetParamValue(TAG_PSAPPDERSNAME, strValue);
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

    public final boolean isPSSYSAPPIDNull() {
        return this.IsParamNull(TAG_PSSYSAPPID);
    }

    public final String getPSSYSAPPID() {
        return this.GetParamStringValue(TAG_PSSYSAPPID, "");
    }

    public final void setPSSYSAPPID(String strValue) {
        this.SetParamValue(TAG_PSSYSAPPID, strValue);
    }

    public final boolean isPSSYSAPPNAMENull() {
        return this.IsParamNull(TAG_PSSYSAPPNAME);
    }

    public final String getPSSYSAPPNAME() {
        return this.GetParamStringValue(TAG_PSSYSAPPNAME, "");
    }

    public final void setPSSYSAPPNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSAPPNAME, strValue);
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

    public final boolean isCODENAMENull() {
        return this.IsParamNull(TAG_CODENAME);
    }

    public final String getCODENAME() {
        return this.GetParamStringValue(TAG_CODENAME, "");
    }

    public final void setCODENAME(String strValue) {
        this.SetParamValue(TAG_CODENAME, strValue);
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

    public final boolean isVALIDFLAGNull() {
        return this.IsParamNull(TAG_VALIDFLAG);
    }

    public final boolean getVALIDFLAG() {
        return this.GetParamIntValue(TAG_VALIDFLAG, 0) == 1;
    }

    public final void setVALIDFLAG(boolean bValue) {
        this.SetParamValue(TAG_VALIDFLAG, bValue ? 1 : 0);
    }

    public final boolean isPSDERIDNull() {
        return this.IsParamNull(TAG_PSDERID);
    }

    public final String getPSDERID() {
        return this.GetParamStringValue(TAG_PSDERID, "");
    }

    public final void setPSDERID(String strValue) {
        this.SetParamValue(TAG_PSDERID, strValue);
    }

    public final boolean isPSDERNAMENull() {
        return this.IsParamNull(TAG_PSDERNAME);
    }

    public final String getPSDERNAME() {
        return this.GetParamStringValue(TAG_PSDERNAME, "");
    }

    public final void setPSDERNAME(String strValue) {
        this.SetParamValue(TAG_PSDERNAME, strValue);
    }

    public final boolean isPPSAPPLOCALDEIDNull() {
        return this.IsParamNull(TAG_PPSAPPLOCALDEID);
    }

    public final String getPPSAPPLOCALDEID() {
        return this.GetParamStringValue(TAG_PPSAPPLOCALDEID, "");
    }

    public final void setPPSAPPLOCALDEID(String strValue) {
        this.SetParamValue(TAG_PPSAPPLOCALDEID, strValue);
    }

    public final boolean isPPSAPPLOCALDENAMENull() {
        return this.IsParamNull(TAG_PPSAPPLOCALDENAME);
    }

    public final String getPPSAPPLOCALDENAME() {
        return this.GetParamStringValue(TAG_PPSAPPLOCALDENAME, "");
    }

    public final void setPPSAPPLOCALDENAME(String strValue) {
        this.SetParamValue(TAG_PPSAPPLOCALDENAME, strValue);
    }

    public final boolean isCPSAPPLOCALDEIDNull() {
        return this.IsParamNull(TAG_CPSAPPLOCALDEID);
    }

    public final String getCPSAPPLOCALDEID() {
        return this.GetParamStringValue(TAG_CPSAPPLOCALDEID, "");
    }

    public final void setCPSAPPLOCALDEID(String strValue) {
        this.SetParamValue(TAG_CPSAPPLOCALDEID, strValue);
    }

    public final boolean isCPSAPPLOCALDENAMENull() {
        return this.IsParamNull(TAG_CPSAPPLOCALDENAME);
    }

    public final String getCPSAPPLOCALDENAME() {
        return this.GetParamStringValue(TAG_CPSAPPLOCALDENAME, "");
    }

    public final void setCPSAPPLOCALDENAME(String strValue) {
        this.SetParamValue(TAG_CPSAPPLOCALDENAME, strValue);
    }

    public final boolean isRSVIEWMODENull() {
        return this.IsParamNull(TAG_RSVIEWMODE);
    }

    public final String getRSVIEWMODE() {
        return this.GetParamStringValue(TAG_RSVIEWMODE, "");
    }

    public final void setRSVIEWMODE(String strValue) {
        this.SetParamValue(TAG_RSVIEWMODE, strValue);
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

