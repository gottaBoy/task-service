/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.WT.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class WTServiceSessionStep
extends BaseDataEntity {
    public static final String TAG_WTSVRSESSIONSTEPID = "WTSVRSESSIONSTEPID";
    public static final String TAG_WTSVRSESSIONSTEPNAME = "WTSVRSESSIONSTEPNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_WTSERVICESESSIONID = "WTSERVICESESSIONID";
    public static final String TAG_WTSERVICESESSIONNAME = "WTSERVICESESSIONNAME";
    public static final String TAG_SENDTEXT = "SENDTEXT";
    public static final String TAG_SENDCONTENT = "SENDCONTENT";
    public static final String TAG_RECVCONTENT = "RECVCONTENT";
    public static final String TAG_RECVTEXT = "RECVTEXT";
    public static final String TAG_RECVTIME = "RECVTIME";
    public static final String TAG_STEPSN = "STEPSN";
    public static final String TAG_SENDTITLE = "SENDTITLE";
    public static final String TAG_SENDPICURL = "SENDPICURL";
    public static final String TAG_SENDDETAILURL = "SENDDETAILURL";

    public final boolean isWTSVRSESSIONSTEPIDNull() {
        return this.IsParamNull(TAG_WTSVRSESSIONSTEPID);
    }

    public final String getWTSVRSESSIONSTEPID() {
        return this.GetParamStringValue(TAG_WTSVRSESSIONSTEPID, "");
    }

    public final void setWTSVRSESSIONSTEPID(String strValue) {
        this.SetParamValue(TAG_WTSVRSESSIONSTEPID, strValue);
    }

    public final boolean isWTSVRSESSIONSTEPNAMENull() {
        return this.IsParamNull(TAG_WTSVRSESSIONSTEPNAME);
    }

    public final String getWTSVRSESSIONSTEPNAME() {
        return this.GetParamStringValue(TAG_WTSVRSESSIONSTEPNAME, "");
    }

    public final void setWTSVRSESSIONSTEPNAME(String strValue) {
        this.SetParamValue(TAG_WTSVRSESSIONSTEPNAME, strValue);
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

    public final boolean isWTSERVICESESSIONIDNull() {
        return this.IsParamNull(TAG_WTSERVICESESSIONID);
    }

    public final String getWTSERVICESESSIONID() {
        return this.GetParamStringValue(TAG_WTSERVICESESSIONID, "");
    }

    public final void setWTSERVICESESSIONID(String strValue) {
        this.SetParamValue(TAG_WTSERVICESESSIONID, strValue);
    }

    public final boolean isWTSERVICESESSIONNAMENull() {
        return this.IsParamNull(TAG_WTSERVICESESSIONNAME);
    }

    public final String getWTSERVICESESSIONNAME() {
        return this.GetParamStringValue(TAG_WTSERVICESESSIONNAME, "");
    }

    public final void setWTSERVICESESSIONNAME(String strValue) {
        this.SetParamValue(TAG_WTSERVICESESSIONNAME, strValue);
    }

    public final boolean isSENDTEXTNull() {
        return this.IsParamNull(TAG_SENDTEXT);
    }

    public final String getSENDTEXT() {
        return this.GetParamStringValue(TAG_SENDTEXT, "");
    }

    public final void setSENDTEXT(String strValue) {
        this.SetParamValue(TAG_SENDTEXT, strValue);
    }

    public final boolean isSENDCONTENTNull() {
        return this.IsParamNull(TAG_SENDCONTENT);
    }

    public final String getSENDCONTENT() {
        return this.GetParamStringValue(TAG_SENDCONTENT, "");
    }

    public final void setSENDCONTENT(String strValue) {
        this.SetParamValue(TAG_SENDCONTENT, strValue);
    }

    public final boolean isRECVCONTENTNull() {
        return this.IsParamNull(TAG_RECVCONTENT);
    }

    public final String getRECVCONTENT() {
        return this.GetParamStringValue(TAG_RECVCONTENT, "");
    }

    public final void setRECVCONTENT(String strValue) {
        this.SetParamValue(TAG_RECVCONTENT, strValue);
    }

    public final boolean isRECVTEXTNull() {
        return this.IsParamNull(TAG_RECVTEXT);
    }

    public final String getRECVTEXT() {
        return this.GetParamStringValue(TAG_RECVTEXT, "");
    }

    public final void setRECVTEXT(String strValue) {
        this.SetParamValue(TAG_RECVTEXT, strValue);
    }

    public final boolean isRECVTIMENull() {
        return this.IsParamNull(TAG_RECVTIME);
    }

    public final Date getRECVTIME() {
        return this.GetParamDateValue(TAG_RECVTIME, null);
    }

    public final void setRECVTIME(Date dtValue) {
        this.SetParamValue(TAG_RECVTIME, dtValue);
    }

    public final boolean isSTEPSNNull() {
        return this.IsParamNull(TAG_STEPSN);
    }

    public final int getSTEPSN() {
        return this.GetParamIntValue(TAG_STEPSN, 0);
    }

    public final void setSTEPSN(int nValue) {
        this.SetParamValue(TAG_STEPSN, nValue);
    }

    public final boolean isSENDTITLENull() {
        return this.IsParamNull(TAG_SENDTITLE);
    }

    public final String getSENDTITLE() {
        return this.GetParamStringValue(TAG_SENDTITLE, "");
    }

    public final void setSENDTITLE(String strValue) {
        this.SetParamValue(TAG_SENDTITLE, strValue);
    }

    public final boolean isSENDPICURLNull() {
        return this.IsParamNull(TAG_SENDPICURL);
    }

    public final String getSENDPICURL() {
        return this.GetParamStringValue(TAG_SENDPICURL, "");
    }

    public final void setSENDPICURL(String strValue) {
        this.SetParamValue(TAG_SENDPICURL, strValue);
    }

    public final boolean isSENDDETAILURLNull() {
        return this.IsParamNull(TAG_SENDDETAILURL);
    }

    public final String getSENDDETAILURL() {
        return this.GetParamStringValue(TAG_SENDDETAILURL, "");
    }

    public final void setSENDDETAILURL(String strValue) {
        this.SetParamValue(TAG_SENDDETAILURL, strValue);
    }
}

