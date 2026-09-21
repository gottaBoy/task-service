/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class MsgSendQueue
extends BaseDataEntity {
    public static final String CONTENTTYPE_TEXT = "TEXT";
    public static final String CONTENTTYPE_HTML = "HTML";
    public static final int MSGTYPE_INTERNAL = 1;
    public static final int MSGTYPE_EMAIL = 2;
    public static final int MSGTYPE_SMS = 4;
    public static final int MSGTYPE_MSN = 8;
    public static final int MSGTYPE_IM = 16;
    public static final String TAG_MSGSENDQUEUEID = "MSGSENDQUEUEID";
    public static final String TAG_MSGSENDQUEUENAME = "MSGSENDQUEUENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_SUBJECT = "SUBJECT";
    public static final String TAG_CONTENT = "CONTENT";
    public static final String TAG_CONTENTTYPE = "CONTENTTYPE";
    public static final String TAG_ISERROR = "ISERROR";
    public static final String TAG_ISSEND = "ISSEND";
    public static final String TAG_PROCESSTIME = "PROCESSTIME";
    public static final String TAG_DSTUSERS = "DSTUSERS";
    public static final String TAG_DSTADDRESSES = "DSTADDRESSES";
    public static final String TAG_MSGTYPE = "MSGTYPE";
    public static final String TAG_FILEAT = "FILEAT";
    public static final String TAG_FILEAT2 = "FILEAT2";
    public static final String TAG_FILEAT3 = "FILEAT3";
    public static final String TAG_FILEAT4 = "FILEAT4";
    public static final String TAG_IMPORTANCEFLAG = "IMPORTANCEFLAG";
    public static final String TAG_ERRORINFO = "ERRORINFO";
    public static final String TAG_TOTALDSTADDRESSES = "TOTALDSTADDRESSES";
    public static final String TAG_PLANSENDTIME = "PLANSENDTIME";
    public static final String TAG_SENDTAG = "SENDTAG";
    public static final String TAG_USERDATA = "USERDATA";
    public static final String TAG_USERDATA2 = "USERDATA2";
    public static final String TAG_USERDATA3 = "USERDATA3";
    public static final String TAG_USERDATA4 = "USERDATA4";

    public String getMSGSENDQUEUEID() {
        return this.GetParamStringValue(TAG_MSGSENDQUEUEID, "");
    }

    public void setMSGSENDQUEUEID(String strValue) {
        this.SetParamValue(TAG_MSGSENDQUEUEID, strValue);
    }

    public String getMSGSENDQUEUENAME() {
        return this.GetParamStringValue(TAG_MSGSENDQUEUENAME, "");
    }

    public void setMSGSENDQUEUENAME(String strValue) {
        this.SetParamValue(TAG_MSGSENDQUEUENAME, strValue);
    }

    public String getCREATEMAN() {
        return this.GetParamStringValue(TAG_CREATEMAN, "");
    }

    public void setCREATEMAN(String strValue) {
        this.SetParamValue(TAG_CREATEMAN, strValue);
    }

    public Date getCREATEDATE() {
        return this.GetParamDateValue(TAG_CREATEDATE, null);
    }

    public void setCREATEDATE(Date strValue) {
        this.SetParamValue(TAG_CREATEDATE, strValue);
    }

    public String getUPDATEMAN() {
        return this.GetParamStringValue(TAG_UPDATEMAN, "");
    }

    public void setUPDATEMAN(String strValue) {
        this.SetParamValue(TAG_UPDATEMAN, strValue);
    }

    public Date getUPDATEDATE() {
        return this.GetParamDateValue(TAG_UPDATEDATE, null);
    }

    public void setUPDATEDATE(Date strValue) {
        this.SetParamValue(TAG_UPDATEDATE, strValue);
    }

    public String getSUBJECT() {
        return this.GetParamStringValue(TAG_SUBJECT, "");
    }

    public void setSUBJECT(String strValue) {
        this.SetParamValue(TAG_SUBJECT, strValue);
    }

    public String getCONTENT() {
        return this.GetParamStringValue(TAG_CONTENT, "");
    }

    public void setCONTENT(String strValue) {
        this.SetParamValue(TAG_CONTENT, strValue);
    }

    public String getCONTENTTYPE() {
        return this.GetParamStringValue(TAG_CONTENTTYPE, "");
    }

    public void setCONTENTTYPE(String strValue) {
        this.SetParamValue(TAG_CONTENTTYPE, strValue);
    }

    public boolean getISERROR() {
        return this.GetParamIntValue(TAG_ISERROR, 0) == 1;
    }

    public void setISERROR(boolean bValue) {
        this.SetParamValue(TAG_ISERROR, bValue ? 1 : 0);
    }

    public boolean getISSEND() {
        return this.GetParamIntValue(TAG_ISSEND, 0) == 1;
    }

    public void setISSEND(boolean bValue) {
        this.SetParamValue(TAG_ISSEND, bValue ? 1 : 0);
    }

    public Date getPROCESSTIME() {
        return this.GetParamDateValue(TAG_PROCESSTIME, null);
    }

    public void setPROCESSTIME(Date strValue) {
        this.SetParamValue(TAG_PROCESSTIME, strValue);
    }

    public String getDSTUSERS() {
        return this.GetParamStringValue(TAG_DSTUSERS, "");
    }

    public void setDSTUSERS(String strValue) {
        this.SetParamValue(TAG_DSTUSERS, strValue);
    }

    public String getDSTADDRESSES() {
        return this.GetParamStringValue(TAG_DSTADDRESSES, "");
    }

    public void setDSTADDRESSES(String strValue) {
        this.SetParamValue(TAG_DSTADDRESSES, strValue);
    }

    public int getMSGTYPE() {
        return this.GetParamIntValue(TAG_MSGTYPE, 0);
    }

    public void setMSGTYPE(int nValue) {
        this.SetParamValue(TAG_MSGTYPE, nValue);
    }

    public String getFILEAT() {
        return this.GetParamStringValue(TAG_FILEAT, "");
    }

    public void setFILEAT(String strValue) {
        this.SetParamValue(TAG_FILEAT, strValue);
    }

    public String getFILEAT2() {
        return this.GetParamStringValue(TAG_FILEAT2, "");
    }

    public void setFILEAT2(String strValue) {
        this.SetParamValue(TAG_FILEAT2, strValue);
    }

    public String getFILEAT3() {
        return this.GetParamStringValue(TAG_FILEAT3, "");
    }

    public void setFILEAT3(String strValue) {
        this.SetParamValue(TAG_FILEAT3, strValue);
    }

    public String getFILEAT4() {
        return this.GetParamStringValue(TAG_FILEAT4, "");
    }

    public void setFILEAT4(String strValue) {
        this.SetParamValue(TAG_FILEAT4, strValue);
    }

    public String getIMPORTANCEFLAG() {
        return this.GetParamStringValue(TAG_IMPORTANCEFLAG, "");
    }

    public void setIMPORTANCEFLAG(String strValue) {
        this.SetParamValue(TAG_IMPORTANCEFLAG, strValue);
    }

    public String getERRORINFO() {
        return this.GetParamStringValue(TAG_ERRORINFO, "");
    }

    public void setERRORINFO(String strValue) {
        this.SetParamValue(TAG_ERRORINFO, strValue);
    }

    public String getTOTALDSTADDRESSES() {
        return this.GetParamStringValue(TAG_TOTALDSTADDRESSES, "");
    }

    public void setTOTALDSTADDRESSES(String strValue) {
        this.SetParamValue(TAG_TOTALDSTADDRESSES, strValue);
    }

    public Date getPLANSENDTIME() {
        return this.GetParamDateValue(TAG_PLANSENDTIME, null);
    }

    public void setPLANSENDTIME(Date strValue) {
        this.SetParamValue(TAG_PLANSENDTIME, strValue);
    }

    public String getSENDTAG() {
        return this.GetParamStringValue(TAG_SENDTAG, "");
    }

    public void setSENDTAG(String strValue) {
        this.SetParamValue(TAG_SENDTAG, strValue);
    }

    public final boolean isUSERDATANull() {
        return this.IsParamNull(TAG_USERDATA);
    }

    public final String getUSERDATA() {
        return this.GetParamStringValue(TAG_USERDATA, "");
    }

    public final void setUSERDATA(String strValue) {
        this.SetParamValue(TAG_USERDATA, strValue);
    }

    public final boolean isUSERDATA2Null() {
        return this.IsParamNull(TAG_USERDATA2);
    }

    public final String getUSERDATA2() {
        return this.GetParamStringValue(TAG_USERDATA2, "");
    }

    public final void setUSERDATA2(String strValue) {
        this.SetParamValue(TAG_USERDATA2, strValue);
    }

    public final boolean isUSERDATA3Null() {
        return this.IsParamNull(TAG_USERDATA3);
    }

    public final String getUSERDATA3() {
        return this.GetParamStringValue(TAG_USERDATA3, "");
    }

    public final void setUSERDATA3(String strValue) {
        this.SetParamValue(TAG_USERDATA3, strValue);
    }

    public final boolean isUSERDATA4Null() {
        return this.IsParamNull(TAG_USERDATA4);
    }

    public final String getUSERDATA4() {
        return this.GetParamStringValue(TAG_USERDATA4, "");
    }

    public final void setUSERDATA4(String strValue) {
        this.SetParamValue(TAG_USERDATA4, strValue);
    }
}

