/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;
import java.util.TreeMap;

public class WorkTime
extends BaseDataEntity {
    protected TreeMap<Long, Long> workTimeMap = null;
    public static final int SCHEDULETYPE_WEEK = 1;
    public static final int SCHEDULETYPE_MONTH = 2;
    public static final String TAG_WORKTIMEID = "WORKTIMEID";
    public static final String TAG_WORKTIMENAME = "WORKTIMENAME";
    public static final String TAG_ENABLE = "ENABLE";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_SCHEDULETYPE = "SCHEDULETYPE";
    public static final String TAG_WEEKVALUE = "WEEKVALUE";
    public static final String TAG_MONTHVALUE = "MONTHVALUE";
    public static final String TAG_TIME1START = "TIME1START";
    public static final String TAG_TIME1END = "TIME1END";
    public static final String TAG_TIME2END = "TIME2END";
    public static final String TAG_TIME3END = "TIME3END";
    public static final String TAG_TIME4END = "TIME4END";
    public static final String TAG_TIME2START = "TIME2START";
    public static final String TAG_TIME3START = "TIME3START";
    public static final String TAG_TIME4START = "TIME4START";

    public String getWORKTIMEID() {
        return this.GetParamStringValue(TAG_WORKTIMEID, "");
    }

    public void setWORKTIMEID(String strValue) {
        this.SetParamValue(TAG_WORKTIMEID, strValue);
    }

    public String getWORKTIMENAME() {
        return this.GetParamStringValue(TAG_WORKTIMENAME, "");
    }

    public void setWORKTIMENAME(String strValue) {
        this.SetParamValue(TAG_WORKTIMENAME, strValue);
    }

    public boolean getENABLE() {
        return this.GetParamIntValue(TAG_ENABLE, 0) == 1;
    }

    public void setENABLE(boolean bValue) {
        this.SetParamValue(TAG_ENABLE, bValue ? 1 : 0);
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

    public int getSCHEDULETYPE() {
        return this.GetParamIntValue(TAG_SCHEDULETYPE, 0);
    }

    public void setSCHEDULETYPE(int strValue) {
        this.SetParamValue(TAG_SCHEDULETYPE, strValue);
    }

    public String getWEEKVALUE() {
        return this.GetParamStringValue(TAG_WEEKVALUE, "");
    }

    public void setWEEKVALUE(String strValue) {
        this.SetParamValue(TAG_WEEKVALUE, strValue);
    }

    public String getMONTHVALUE() {
        return this.GetParamStringValue(TAG_MONTHVALUE, "");
    }

    public void setMONTHVALUE(String strValue) {
        this.SetParamValue(TAG_MONTHVALUE, strValue);
    }

    public Date getTIME1START() {
        return this.GetParamDateValue(TAG_TIME1START, null);
    }

    public void setTIME1START(Date strValue) {
        this.SetParamValue(TAG_TIME1START, strValue);
    }

    public Date getTIME1END() {
        return this.GetParamDateValue(TAG_TIME1END, null);
    }

    public void setTIME1END(Date strValue) {
        this.SetParamValue(TAG_TIME1END, strValue);
    }

    public Date getTIME2END() {
        return this.GetParamDateValue(TAG_TIME2END, null);
    }

    public void setTIME2END(Date strValue) {
        this.SetParamValue(TAG_TIME2END, strValue);
    }

    public Date getTIME3END() {
        return this.GetParamDateValue(TAG_TIME3END, null);
    }

    public void setTIME3END(Date strValue) {
        this.SetParamValue(TAG_TIME3END, strValue);
    }

    public Date getTIME4END() {
        return this.GetParamDateValue(TAG_TIME4END, null);
    }

    public void setTIME4END(Date strValue) {
        this.SetParamValue(TAG_TIME4END, strValue);
    }

    public Date getTIME2START() {
        return this.GetParamDateValue(TAG_TIME2START, null);
    }

    public void setTIME2START(Date strValue) {
        this.SetParamValue(TAG_TIME2START, strValue);
    }

    public Date getTIME3START() {
        return this.GetParamDateValue(TAG_TIME3START, null);
    }

    public void setTIME3START(Date strValue) {
        this.SetParamValue(TAG_TIME3START, strValue);
    }

    public Date getTIME4START() {
        return this.GetParamDateValue(TAG_TIME4START, null);
    }

    public void setTIME4START(Date strValue) {
        this.SetParamValue(TAG_TIME4START, strValue);
    }

    public synchronized TreeMap<Long, Long> getWorkTimeMap() {
        if (this.workTimeMap == null) {
            this.workTimeMap = new TreeMap();
            if (this.getTIME1START() != null && this.getTIME1END() != null) {
                this.workTimeMap.put(this.getTIME1START().getTime(), this.getTIME1END().getTime());
            }
            if (this.getTIME2START() != null && this.getTIME2END() != null) {
                this.workTimeMap.put(this.getTIME2START().getTime(), this.getTIME2END().getTime());
            }
            if (this.getTIME3START() != null && this.getTIME3END() != null) {
                this.workTimeMap.put(this.getTIME3START().getTime(), this.getTIME3END().getTime());
            }
            if (this.getTIME4START() != null && this.getTIME4END() != null) {
                this.workTimeMap.put(this.getTIME4START().getTime(), this.getTIME4END().getTime());
            }
        }
        return this.workTimeMap;
    }
}

