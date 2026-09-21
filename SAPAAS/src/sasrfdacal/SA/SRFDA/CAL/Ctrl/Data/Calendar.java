/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.CAL.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class Calendar
extends BaseDataEntity {
    public static final String TAG_CALENDARID = "CALENDARID";
    public static final String TAG_CALENDARNAME = "CALENDARNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_OWNERID = "OWNERID";
    public static final String TAG_CONTENT = "CONTENT";
    public static final String TAG_ATTACHMENT = "ATTACHMENT";
    public static final String TAG_BEGINTIME = "BEGINTIME";
    public static final String TAG_ENDTIME = "ENDTIME";
    public static final String TAG_IMPORTANCE = "IMPORTANCE";
    public static final String TAG_USERTAG = "USERTAG";
    public static final String TAG_ADDRESS = "ADDRESS";
    public static final String TAG_USERDATA = "USERDATA";
    public static final String TAG_USERDATA2 = "USERDATA2";
    public static final String TAG_ISSEQUENCE = "ISSEQUENCE";
    public static final String TAG_CALSEQID = "CALSEQID";
    public static final String TAG_CALENDARTYPENAME = "CALENDARTYPENAME";
    public static final String TAG_CALENDARGROUP = "CALENDARGROUP";
    public static final String TAG_CALENDARTYPEID = "CALENDARTYPEID";
    public static final String TAG_CALSCHEDULEID = "CALSCHEDULEID";
    public static final String TAG_IMPORTANCE_LOW = "LOW";
    public static final String TAG_IMPORTANCE_NORMAL = "NORMAL";
    public static final String TAG_IMPORTANCE_HIGH = "HIGH";

    public String getCALENDARID() {
        return this.GetParamStringValue(TAG_CALENDARID, "");
    }

    public void setCALENDARID(String strValue) {
        this.SetParamValue(TAG_CALENDARID, strValue);
    }

    public String getCALENDARNAME() {
        return this.GetParamStringValue(TAG_CALENDARNAME, "");
    }

    public void setCALENDARNAME(String strValue) {
        this.SetParamValue(TAG_CALENDARNAME, strValue);
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

    public String getOWNERID() {
        return this.GetParamStringValue(TAG_OWNERID, "");
    }

    public void setOWNERID(String strValue) {
        this.SetParamValue(TAG_OWNERID, strValue);
    }

    public String getCONTENT() {
        return this.GetParamStringValue(TAG_CONTENT, "");
    }

    public void setCONTENT(String strValue) {
        this.SetParamValue(TAG_CONTENT, strValue);
    }

    public String getATTACHMENT() {
        return this.GetParamStringValue(TAG_ATTACHMENT, "");
    }

    public void setATTACHMENT(String strValue) {
        this.SetParamValue(TAG_ATTACHMENT, strValue);
    }

    public Date getBEGINTIME() {
        return this.GetParamDateValue(TAG_BEGINTIME, null);
    }

    public void setBEGINTIME(Date strValue) {
        this.SetParamValue(TAG_BEGINTIME, strValue);
    }

    public void setBEGINTIME(Object strValue) {
        this.SetParamValue(TAG_BEGINTIME, strValue);
    }

    public Date getENDTIME() {
        return this.GetParamDateValue(TAG_ENDTIME, null);
    }

    public void setENDTIME(Date strValue) {
        this.SetParamValue(TAG_ENDTIME, strValue);
    }

    public void setENDTIME(Object strValue) {
        this.SetParamValue(TAG_ENDTIME, strValue);
    }

    public String getIMPORTANCE() {
        return this.GetParamStringValue(TAG_IMPORTANCE, "");
    }

    public void setIMPORTANCE(String strValue) {
        this.SetParamValue(TAG_IMPORTANCE, strValue);
    }

    public String getUSERTAG() {
        return this.GetParamStringValue(TAG_USERTAG, "");
    }

    public void setUSERTAG(String strValue) {
        this.SetParamValue(TAG_USERTAG, strValue);
    }

    public String getADDRESS() {
        return this.GetParamStringValue(TAG_ADDRESS, "");
    }

    public void setADDRESS(String strValue) {
        this.SetParamValue(TAG_ADDRESS, strValue);
    }

    public String getUSERDATA() {
        return this.GetParamStringValue(TAG_USERDATA, "");
    }

    public void setUSERDATA(String strValue) {
        this.SetParamValue(TAG_USERDATA, strValue);
    }

    public String getUSERDATA2() {
        return this.GetParamStringValue(TAG_USERDATA2, "");
    }

    public void setUSERDATA2(String strValue) {
        this.SetParamValue(TAG_USERDATA2, strValue);
    }

    public boolean getISSEQUENCE() {
        return this.GetParamIntValue(TAG_ISSEQUENCE, 0) == 1;
    }

    public void setISSEQUENCE(boolean bValue) {
        this.SetParamValue(TAG_ISSEQUENCE, bValue ? 1 : 0);
    }

    public String getCALSEQID() {
        return this.GetParamStringValue(TAG_CALSEQID, "");
    }

    public void setCALSEQID(String strValue) {
        this.SetParamValue(TAG_CALSEQID, strValue);
    }

    public String getCALENDARTYPENAME() {
        return this.GetParamStringValue(TAG_CALENDARTYPENAME, "");
    }

    public void setCALENDARTYPENAME(String strValue) {
        this.SetParamValue(TAG_CALENDARTYPENAME, strValue);
    }

    public String getCALENDARGROUP() {
        return this.GetParamStringValue(TAG_CALENDARGROUP, "");
    }

    public void setCALENDARGROUP(String strValue) {
        this.SetParamValue(TAG_CALENDARGROUP, strValue);
    }

    public String getCALENDARTYPEID() {
        return this.GetParamStringValue(TAG_CALENDARTYPEID, "");
    }

    public void setCALENDARTYPEID(String strValue) {
        this.SetParamValue(TAG_CALENDARTYPEID, strValue);
    }

    public String getCALSCHEDULEID() {
        return this.GetParamStringValue(TAG_CALSCHEDULEID, "");
    }

    public void setCALSCHEDULEID(String strValue) {
        this.SetParamValue(TAG_CALSCHEDULEID, strValue);
    }
}

