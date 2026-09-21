/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSAppUITheme
extends BaseDataEntity {
    public static final String TAG_PSAPPUITHEMEID = "PSAPPUITHEMEID";
    public static final String TAG_PSAPPUITHEMENAME = "PSAPPUITHEMENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSSYSAPPID = "PSSYSAPPID";
    public static final String TAG_PSSYSAPPNAME = "PSSYSAPPNAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_THEMETAG = "THEMETAG";
    public static final String TAG_THEMEPARAMS = "THEMEPARAMS";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";
    public static final String TAG_ORDERVALUE = "ORDERVALUE";
    public static final String TAG_THEMEDESC = "THEMEDESC";
    public static final String TAG_USERTAG = "USERTAG";
    public static final String TAG_USERTAG2 = "USERTAG2";
    public static final String TAG_USERCAT = "USERCAT";
    public static final String TAG_USERTAG3 = "USERTAG3";
    public static final String TAG_USERTAG4 = "USERTAG4";
    public static final String TAG_CSSSTYLE = "CSSSTYLE";
    public static final String TAG_THEMEURL = "THEMEURL";

    public final boolean isPSAPPUITHEMEIDNull() {
        return this.IsParamNull(TAG_PSAPPUITHEMEID);
    }

    public final String getPSAPPUITHEMEID() {
        return this.GetParamStringValue(TAG_PSAPPUITHEMEID, "");
    }

    public final void setPSAPPUITHEMEID(String strValue) {
        this.SetParamValue(TAG_PSAPPUITHEMEID, strValue);
    }

    public final boolean isPSAPPUITHEMENAMENull() {
        return this.IsParamNull(TAG_PSAPPUITHEMENAME);
    }

    public final String getPSAPPUITHEMENAME() {
        return this.GetParamStringValue(TAG_PSAPPUITHEMENAME, "");
    }

    public final void setPSAPPUITHEMENAME(String strValue) {
        this.SetParamValue(TAG_PSAPPUITHEMENAME, strValue);
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

    public final boolean isMEMONull() {
        return this.IsParamNull(TAG_MEMO);
    }

    public final String getMEMO() {
        return this.GetParamStringValue(TAG_MEMO, "");
    }

    public final void setMEMO(String strValue) {
        this.SetParamValue(TAG_MEMO, strValue);
    }

    public final boolean isTHEMETAGNull() {
        return this.IsParamNull(TAG_THEMETAG);
    }

    public final String getTHEMETAG() {
        return this.GetParamStringValue(TAG_THEMETAG, "");
    }

    public final void setTHEMETAG(String strValue) {
        this.SetParamValue(TAG_THEMETAG, strValue);
    }

    public final boolean isTHEMEPARAMSNull() {
        return this.IsParamNull(TAG_THEMEPARAMS);
    }

    public final String getTHEMEPARAMS() {
        return this.GetParamStringValue(TAG_THEMEPARAMS, "");
    }

    public final void setTHEMEPARAMS(String strValue) {
        this.SetParamValue(TAG_THEMEPARAMS, strValue);
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

    public final boolean isORDERVALUENull() {
        return this.IsParamNull(TAG_ORDERVALUE);
    }

    public final int getORDERVALUE() {
        return this.GetParamIntValue(TAG_ORDERVALUE, 0);
    }

    public final void setORDERVALUE(int nValue) {
        this.SetParamValue(TAG_ORDERVALUE, nValue);
    }

    public final boolean isTHEMEDESCNull() {
        return this.IsParamNull(TAG_THEMEDESC);
    }

    public final String getTHEMEDESC() {
        return this.GetParamStringValue(TAG_THEMEDESC, "");
    }

    public final void setTHEMEDESC(String strValue) {
        this.SetParamValue(TAG_THEMEDESC, strValue);
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

    public final boolean isCSSSTYLENull() {
        return this.IsParamNull(TAG_CSSSTYLE);
    }

    public final String getCSSSTYLE() {
        return this.GetParamStringValue(TAG_CSSSTYLE, "");
    }

    public final void setCSSSTYLE(String strValue) {
        this.SetParamValue(TAG_CSSSTYLE, strValue);
    }

    public final boolean isTHEMEURLNull() {
        return this.IsParamNull(TAG_THEMEURL);
    }

    public final String getTHEMEURL() {
        return this.GetParamStringValue(TAG_THEMEURL, "");
    }

    public final void setTHEMEURL(String strValue) {
        this.SetParamValue(TAG_THEMEURL, strValue);
    }
}

