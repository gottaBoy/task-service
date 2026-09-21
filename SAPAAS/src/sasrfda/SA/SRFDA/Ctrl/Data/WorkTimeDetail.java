/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class WorkTimeDetail
extends BaseDataEntity {
    public static final int WORKTIMETYPE_WORK = 1;
    public static final int WORKTIMETYPE_NOTWORK = 2;
    public static final int WORKTIMETYPE_CUSTOM = 3;
    public static final String TAG_WORKTIMEDETAILID = "WORKTIMEDETAILID";
    public static final String TAG_WORKTIMEDETAILNAME = "WORKTIMEDETAILNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_WORKTIMETYPE = "WORKTIMETYPE";
    public static final String TAG_WORKTIME = "WORKTIME";
    public static final String TAG_TIME1END = "TIME1END";
    public static final String TAG_TIME1START = "TIME1START";
    public static final String TAG_TIME2END = "TIME2END";
    public static final String TAG_TIME2START = "TIME2START";
    public static final String TAG_TIME3END = "TIME3END";
    public static final String TAG_TIME3START = "TIME3START";
    public static final String TAG_TIME4END = "TIME4END";
    public static final String TAG_TIME4START = "TIME4START";
    public static final String TAG_WORKTIMENAME = "WORKTIMENAME";
    public static final String TAG_WORKTIMEID = "WORKTIMEID";
    public static final String TAG_ENDTIME = "ENDTIME";

    public String getWORKTIMEDETAILID() {
        return this.GetParamStringValue(TAG_WORKTIMEDETAILID, "");
    }

    public void setWORKTIMEDETAILID(String strValue) {
        this.SetParamValue(TAG_WORKTIMEDETAILID, strValue);
    }

    public String getWORKTIMEDETAILNAME() {
        return this.GetParamStringValue(TAG_WORKTIMEDETAILNAME, "");
    }

    public void setWORKTIMEDETAILNAME(String strValue) {
        this.SetParamValue(TAG_WORKTIMEDETAILNAME, strValue);
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

    public int getWORKTIMETYPE() {
        return this.GetParamIntValue(TAG_WORKTIMETYPE, 0);
    }

    public void setWORKTIMETYPE(int strValue) {
        this.SetParamValue(TAG_WORKTIMETYPE, strValue);
    }

    public Date getWORKTIME() {
        return this.GetParamDateValue(TAG_WORKTIME, null);
    }

    public void setWORKTIME(Date strValue) {
        this.SetParamValue(TAG_WORKTIME, strValue);
    }

    public Date getTIME1END() {
        return this.GetParamDateValue(TAG_TIME1END, null);
    }

    public void setTIME1END(Date strValue) {
        this.SetParamValue(TAG_TIME1END, strValue);
    }

    public Date getTIME1START() {
        return this.GetParamDateValue(TAG_TIME1START, null);
    }

    public void setTIME1START(Date strValue) {
        this.SetParamValue(TAG_TIME1START, strValue);
    }

    public Date getTIME2END() {
        return this.GetParamDateValue(TAG_TIME2END, null);
    }

    public void setTIME2END(Date strValue) {
        this.SetParamValue(TAG_TIME2END, strValue);
    }

    public Date getTIME2START() {
        return this.GetParamDateValue(TAG_TIME2START, null);
    }

    public void setTIME2START(Date strValue) {
        this.SetParamValue(TAG_TIME2START, strValue);
    }

    public Date getTIME3END() {
        return this.GetParamDateValue(TAG_TIME3END, null);
    }

    public void setTIME3END(Date strValue) {
        this.SetParamValue(TAG_TIME3END, strValue);
    }

    public Date getTIME3START() {
        return this.GetParamDateValue(TAG_TIME3START, null);
    }

    public void setTIME3START(Date strValue) {
        this.SetParamValue(TAG_TIME3START, strValue);
    }

    public Date getTIME4END() {
        return this.GetParamDateValue(TAG_TIME4END, null);
    }

    public void setTIME4END(Date strValue) {
        this.SetParamValue(TAG_TIME4END, strValue);
    }

    public Date getTIME4START() {
        return this.GetParamDateValue(TAG_TIME4START, null);
    }

    public void setTIME4START(Date strValue) {
        this.SetParamValue(TAG_TIME4START, strValue);
    }

    public String getWORKTIMENAME() {
        return this.GetParamStringValue(TAG_WORKTIMENAME, "");
    }

    public void setWORKTIMENAME(String strValue) {
        this.SetParamValue(TAG_WORKTIMENAME, strValue);
    }

    public String getWORKTIMEID() {
        return this.GetParamStringValue(TAG_WORKTIMEID, "");
    }

    public void setWORKTIMEID(String strValue) {
        this.SetParamValue(TAG_WORKTIMEID, strValue);
    }

    public final boolean isENDTIMENull() {
        return this.IsParamNull(TAG_ENDTIME);
    }

    public final Date getENDTIME() {
        return this.GetParamDateValue(TAG_ENDTIME, null);
    }

    public final void setENDTIME(Date dtValue) {
        this.SetParamValue(TAG_ENDTIME, dtValue);
    }
}

