/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.TM.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.sql.Timestamp;
import java.util.Date;

public class TMResDayBKTime
extends BaseDataEntity {
    public static final String TAG_TMRESDAYBKTIMEID = "TMRESDAYBKTIMEID";
    public static final String TAG_TMRESDAYBKTIMENAME = "TMRESDAYBKTIMENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_DURATION = "DURATION";
    public static final String TAG_TMRESBASEID = "TMRESBASEID";
    public static final String TAG_TMRESBASENAME = "TMRESBASENAME";
    public static final String TAG_BOOKINGTYPE = "BOOKINGTYPE";
    public static final String TAG_DAYVALUE = "DAYVALUE";
    public static final String TAG_DAYID = "DAYID";

    public boolean isTMRESDAYBKTIMEIDNull() {
        return this.IsParamNull(TAG_TMRESDAYBKTIMEID);
    }

    public String getTMRESDAYBKTIMEID() {
        return this.GetParamStringValue(TAG_TMRESDAYBKTIMEID, "");
    }

    public void setTMRESDAYBKTIMEID(String strValue) {
        this.SetParamValue(TAG_TMRESDAYBKTIMEID, strValue);
    }

    public boolean isTMRESDAYBKTIMENAMENull() {
        return this.IsParamNull(TAG_TMRESDAYBKTIMENAME);
    }

    public String getTMRESDAYBKTIMENAME() {
        return this.GetParamStringValue(TAG_TMRESDAYBKTIMENAME, "");
    }

    public void setTMRESDAYBKTIMENAME(String strValue) {
        this.SetParamValue(TAG_TMRESDAYBKTIMENAME, strValue);
    }

    public boolean isCREATEMANNull() {
        return this.IsParamNull(TAG_CREATEMAN);
    }

    public String getCREATEMAN() {
        return this.GetParamStringValue(TAG_CREATEMAN, "");
    }

    public void setCREATEMAN(String strValue) {
        this.SetParamValue(TAG_CREATEMAN, strValue);
    }

    public boolean isCREATEDATENull() {
        return this.IsParamNull(TAG_CREATEDATE);
    }

    public Date getCREATEDATE() {
        return this.GetParamDateValue(TAG_CREATEDATE, null);
    }

    public void setCREATEDATE(Date strValue) {
        this.SetParamValue(TAG_CREATEDATE, strValue);
    }

    public boolean isUPDATEMANNull() {
        return this.IsParamNull(TAG_UPDATEMAN);
    }

    public String getUPDATEMAN() {
        return this.GetParamStringValue(TAG_UPDATEMAN, "");
    }

    public void setUPDATEMAN(String strValue) {
        this.SetParamValue(TAG_UPDATEMAN, strValue);
    }

    public boolean isUPDATEDATENull() {
        return this.IsParamNull(TAG_UPDATEDATE);
    }

    public Date getUPDATEDATE() {
        return this.GetParamDateValue(TAG_UPDATEDATE, null);
    }

    public void setUPDATEDATE(Date strValue) {
        this.SetParamValue(TAG_UPDATEDATE, strValue);
    }

    public boolean isDURATIONNull() {
        return this.IsParamNull(TAG_DURATION);
    }

    public int getDURATION() {
        return this.GetParamIntValue(TAG_DURATION, 0);
    }

    public void setDURATION(int strValue) {
        this.SetParamValue(TAG_DURATION, strValue);
    }

    public boolean isTMRESBASEIDNull() {
        return this.IsParamNull(TAG_TMRESBASEID);
    }

    public String getTMRESBASEID() {
        return this.GetParamStringValue(TAG_TMRESBASEID, "");
    }

    public void setTMRESBASEID(String strValue) {
        this.SetParamValue(TAG_TMRESBASEID, strValue);
    }

    public boolean isTMRESBASENAMENull() {
        return this.IsParamNull(TAG_TMRESBASENAME);
    }

    public String getTMRESBASENAME() {
        return this.GetParamStringValue(TAG_TMRESBASENAME, "");
    }

    public void setTMRESBASENAME(String strValue) {
        this.SetParamValue(TAG_TMRESBASENAME, strValue);
    }

    public boolean isBOOKINGTYPENull() {
        return this.IsParamNull(TAG_BOOKINGTYPE);
    }

    public String getBOOKINGTYPE() {
        return this.GetParamStringValue(TAG_BOOKINGTYPE, "");
    }

    public void setBOOKINGTYPE(String strValue) {
        this.SetParamValue(TAG_BOOKINGTYPE, strValue);
    }

    public boolean isDAYVALUENull() {
        return this.IsParamNull(TAG_DAYVALUE);
    }

    public Timestamp getDAYVALUE() {
        return this.GetParamTimestampValue(TAG_DAYVALUE, null);
    }

    public void setDAYVALUE(Timestamp strValue) {
        this.SetParamValue(TAG_DAYVALUE, strValue);
    }

    public boolean isDAYIDNull() {
        return this.IsParamNull(TAG_DAYID);
    }

    public String getDAYID() {
        return this.GetParamStringValue(TAG_DAYID, "");
    }

    public void setDAYID(String strValue) {
        this.SetParamValue(TAG_DAYID, strValue);
    }
}

