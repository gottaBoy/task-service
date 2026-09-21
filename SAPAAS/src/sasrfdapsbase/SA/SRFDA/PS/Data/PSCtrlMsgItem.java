/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSCtrlMsgItem
extends BaseDataEntity {
    public static final String TAG_PSCTRLMSGITEMID = "PSCTRLMSGITEMID";
    public static final String TAG_PSCTRLMSGITEMNAME = "PSCTRLMSGITEMNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSCTRLMSGID = "PSCTRLMSGID";
    public static final String TAG_PSCTRLMSGNAME = "PSCTRLMSGNAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_TIMEOUT = "TIMEOUT";
    public static final String TAG_CONTENT = "CONTENT";
    public static final String TAG_USERCAT = "USERCAT";
    public static final String TAG_USERTAG4 = "USERTAG4";
    public static final String TAG_USERTAG3 = "USERTAG3";
    public static final String TAG_USERTAG2 = "USERTAG2";
    public static final String TAG_USERTAG = "USERTAG";
    public static final String TAG_CONTENTPSLANRESID = "CONTENTPSLANRESID";
    public static final String TAG_CONTENTPSLANRESNAME = "CONTENTPSLANRESNAME";

    public final boolean isPSCTRLMSGITEMIDNull() {
        return this.IsParamNull(TAG_PSCTRLMSGITEMID);
    }

    public final String getPSCTRLMSGITEMID() {
        return this.GetParamStringValue(TAG_PSCTRLMSGITEMID, "");
    }

    public final void setPSCTRLMSGITEMID(String strValue) {
        this.SetParamValue(TAG_PSCTRLMSGITEMID, strValue);
    }

    public final boolean isPSCTRLMSGITEMNAMENull() {
        return this.IsParamNull(TAG_PSCTRLMSGITEMNAME);
    }

    public final String getPSCTRLMSGITEMNAME() {
        return this.GetParamStringValue(TAG_PSCTRLMSGITEMNAME, "");
    }

    public final void setPSCTRLMSGITEMNAME(String strValue) {
        this.SetParamValue(TAG_PSCTRLMSGITEMNAME, strValue);
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

    public final boolean isPSCTRLMSGIDNull() {
        return this.IsParamNull(TAG_PSCTRLMSGID);
    }

    public final String getPSCTRLMSGID() {
        return this.GetParamStringValue(TAG_PSCTRLMSGID, "");
    }

    public final void setPSCTRLMSGID(String strValue) {
        this.SetParamValue(TAG_PSCTRLMSGID, strValue);
    }

    public final boolean isPSCTRLMSGNAMENull() {
        return this.IsParamNull(TAG_PSCTRLMSGNAME);
    }

    public final String getPSCTRLMSGNAME() {
        return this.GetParamStringValue(TAG_PSCTRLMSGNAME, "");
    }

    public final void setPSCTRLMSGNAME(String strValue) {
        this.SetParamValue(TAG_PSCTRLMSGNAME, strValue);
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

    public final boolean isTIMEOUTNull() {
        return this.IsParamNull(TAG_TIMEOUT);
    }

    public final int getTIMEOUT() {
        return this.GetParamIntValue(TAG_TIMEOUT, 0);
    }

    public final void setTIMEOUT(int nValue) {
        this.SetParamValue(TAG_TIMEOUT, nValue);
    }

    public final boolean isCONTENTNull() {
        return this.IsParamNull(TAG_CONTENT);
    }

    public final String getCONTENT() {
        return this.GetParamStringValue(TAG_CONTENT, "");
    }

    public final void setCONTENT(String strValue) {
        this.SetParamValue(TAG_CONTENT, strValue);
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

    public final boolean isCONTENTPSLANRESIDNull() {
        return this.IsParamNull(TAG_CONTENTPSLANRESID);
    }

    public final String getCONTENTPSLANRESID() {
        return this.GetParamStringValue(TAG_CONTENTPSLANRESID, "");
    }

    public final void setCONTENTPSLANRESID(String strValue) {
        this.SetParamValue(TAG_CONTENTPSLANRESID, strValue);
    }

    public final boolean isCONTENTPSLANRESNAMENull() {
        return this.IsParamNull(TAG_CONTENTPSLANRESNAME);
    }

    public final String getCONTENTPSLANRESNAME() {
        return this.GetParamStringValue(TAG_CONTENTPSLANRESNAME, "");
    }

    public final void setCONTENTPSLANRESNAME(String strValue) {
        this.SetParamValue(TAG_CONTENTPSLANRESNAME, strValue);
    }
}

