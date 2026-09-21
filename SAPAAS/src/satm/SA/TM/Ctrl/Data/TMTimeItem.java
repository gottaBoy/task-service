/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.TM.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class TMTimeItem
extends BaseDataEntity {
    public static final int DAYMODE_VALID = 1;
    public static final int DAYMODE_INVALID = 0;
    public static final int DAYMODE_CUSTOM = 2;
    public static final String MONTHTYPE_EVERY = "EVERY";
    public static final String MONTHTYPE_SOME = "SOME";
    public static final String MONTHDAYTYPE_EVERY = "EVERY";
    public static final String MONTHDAYTYPE_SOME = "SOME";
    public static final String MONTHDAYTYPE_NONE = "NONE";
    public static final String MONTHWEEKTYPE_EVERY = "EVERY";
    public static final String MONTHWEEKTYPE_ONE = "ONE";
    public static final String MONTHWEEKTYPE_TWO = "TWO";
    public static final String MONTHWEEKTYPE_THREE = "THREE";
    public static final String MONTHWEEKTYPE_FOUR = "FOUR";
    public static final String MONTHWEEKTYPE_FIVE = "FIVE";
    public static final String MONTHWEEKTYPE_NONE = "NONE";
    public static final String TAG_TMTIMEITEMID = "TMTIMEITEMID";
    public static final String TAG_TMTIMEITEMNAME = "TMTIMEITEMNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_VERSION = "VERSION";
    public static final String TAG_MONTHVALUE = "MONTHVALUE";
    public static final String TAG_MONTHDAYVALUE = "MONTHDAYVALUE";
    public static final String TAG_MONTHWEEKVALUE = "MONTHWEEKVALUE";
    public static final String TAG_MONTHTYPE = "MONTHTYPE";
    public static final String TAG_MONTHDAYTYPE = "MONTHDAYTYPE";
    public static final String TAG_MONTHWEEKTYPE = "MONTHWEEKTYPE";
    public static final String TAG_BEGINTIME = "BEGINTIME";
    public static final String TAG_BEGINTIME2 = "BEGINTIME2";
    public static final String TAG_ENDTIME2 = "ENDTIME2";
    public static final String TAG_ENDTIME = "ENDTIME";
    public static final String TAG_ENABLETIME = "ENABLETIME";
    public static final String TAG_ENABLETIME2 = "ENABLETIME2";
    public static final String TAG_TMTIMERULEID = "TMTIMERULEID";
    public static final String TAG_TMTIMERULENAME = "TMTIMERULENAME";
    public static final String TAG_DAYMODE = "DAYMODE";
    public static final String TAG_MEMO = "MEMO";

    public boolean isTMTIMEITEMIDNull() {
        return this.IsParamNull(TAG_TMTIMEITEMID);
    }

    public String getTMTIMEITEMID() {
        return this.GetParamStringValue(TAG_TMTIMEITEMID, "");
    }

    public void setTMTIMEITEMID(String strValue) {
        this.SetParamValue(TAG_TMTIMEITEMID, strValue);
    }

    public boolean isTMTIMEITEMNAMENull() {
        return this.IsParamNull(TAG_TMTIMEITEMNAME);
    }

    public String getTMTIMEITEMNAME() {
        return this.GetParamStringValue(TAG_TMTIMEITEMNAME, "");
    }

    public void setTMTIMEITEMNAME(String strValue) {
        this.SetParamValue(TAG_TMTIMEITEMNAME, strValue);
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

    public boolean isVERSIONNull() {
        return this.IsParamNull(TAG_VERSION);
    }

    public int getVERSION() {
        return this.GetParamIntValue(TAG_VERSION, 0);
    }

    public void setVERSION(int strValue) {
        this.SetParamValue(TAG_VERSION, strValue);
    }

    public boolean isMONTHVALUENull() {
        return this.IsParamNull(TAG_MONTHVALUE);
    }

    public String getMONTHVALUE() {
        return this.GetParamStringValue(TAG_MONTHVALUE, "");
    }

    public void setMONTHVALUE(String strValue) {
        this.SetParamValue(TAG_MONTHVALUE, strValue);
    }

    public boolean isMONTHDAYVALUENull() {
        return this.IsParamNull(TAG_MONTHDAYVALUE);
    }

    public String getMONTHDAYVALUE() {
        return this.GetParamStringValue(TAG_MONTHDAYVALUE, "");
    }

    public void setMONTHDAYVALUE(String strValue) {
        this.SetParamValue(TAG_MONTHDAYVALUE, strValue);
    }

    public boolean isMONTHWEEKVALUENull() {
        return this.IsParamNull(TAG_MONTHWEEKVALUE);
    }

    public String getMONTHWEEKVALUE() {
        return this.GetParamStringValue(TAG_MONTHWEEKVALUE, "");
    }

    public void setMONTHWEEKVALUE(String strValue) {
        this.SetParamValue(TAG_MONTHWEEKVALUE, strValue);
    }

    public boolean isMONTHTYPENull() {
        return this.IsParamNull(TAG_MONTHTYPE);
    }

    public String getMONTHTYPE() {
        return this.GetParamStringValue(TAG_MONTHTYPE, "");
    }

    public void setMONTHTYPE(String strValue) {
        this.SetParamValue(TAG_MONTHTYPE, strValue);
    }

    public boolean isMONTHDAYTYPENull() {
        return this.IsParamNull(TAG_MONTHDAYTYPE);
    }

    public String getMONTHDAYTYPE() {
        return this.GetParamStringValue(TAG_MONTHDAYTYPE, "");
    }

    public void setMONTHDAYTYPE(String strValue) {
        this.SetParamValue(TAG_MONTHDAYTYPE, strValue);
    }

    public boolean isMONTHWEEKTYPENull() {
        return this.IsParamNull(TAG_MONTHWEEKTYPE);
    }

    public String getMONTHWEEKTYPE() {
        return this.GetParamStringValue(TAG_MONTHWEEKTYPE, "");
    }

    public void setMONTHWEEKTYPE(String strValue) {
        this.SetParamValue(TAG_MONTHWEEKTYPE, strValue);
    }

    public boolean isBEGINTIMENull() {
        return this.IsParamNull(TAG_BEGINTIME);
    }

    public Date getBEGINTIME() {
        return this.GetParamDateValue(TAG_BEGINTIME, null);
    }

    public void setBEGINTIME(Date strValue) {
        this.SetParamValue(TAG_BEGINTIME, strValue);
    }

    public boolean isBEGINTIME2Null() {
        return this.IsParamNull(TAG_BEGINTIME2);
    }

    public Date getBEGINTIME2() {
        return this.GetParamDateValue(TAG_BEGINTIME2, null);
    }

    public void setBEGINTIME2(Date strValue) {
        this.SetParamValue(TAG_BEGINTIME2, strValue);
    }

    public boolean isENDTIME2Null() {
        return this.IsParamNull(TAG_ENDTIME2);
    }

    public Date getENDTIME2() {
        return this.GetParamDateValue(TAG_ENDTIME2, null);
    }

    public void setENDTIME2(Date strValue) {
        this.SetParamValue(TAG_ENDTIME2, strValue);
    }

    public boolean isENDTIMENull() {
        return this.IsParamNull(TAG_ENDTIME);
    }

    public Date getENDTIME() {
        return this.GetParamDateValue(TAG_ENDTIME, null);
    }

    public void setENDTIME(Date strValue) {
        this.SetParamValue(TAG_ENDTIME, strValue);
    }

    public boolean isENABLETIMENull() {
        return this.IsParamNull(TAG_ENABLETIME);
    }

    public boolean getENABLETIME() {
        return this.GetParamIntValue(TAG_ENABLETIME, 0) == 1;
    }

    public void setENABLETIME(boolean bValue) {
        this.SetParamValue(TAG_ENABLETIME, bValue ? 1 : 0);
    }

    public boolean isENABLETIME2Null() {
        return this.IsParamNull(TAG_ENABLETIME2);
    }

    public boolean getENABLETIME2() {
        return this.GetParamIntValue(TAG_ENABLETIME2, 0) == 1;
    }

    public void setENABLETIME2(boolean bValue) {
        this.SetParamValue(TAG_ENABLETIME2, bValue ? 1 : 0);
    }

    public boolean isTMTIMERULEIDNull() {
        return this.IsParamNull(TAG_TMTIMERULEID);
    }

    public String getTMTIMERULEID() {
        return this.GetParamStringValue(TAG_TMTIMERULEID, "");
    }

    public void setTMTIMERULEID(String strValue) {
        this.SetParamValue(TAG_TMTIMERULEID, strValue);
    }

    public boolean isTMTIMERULENAMENull() {
        return this.IsParamNull(TAG_TMTIMERULENAME);
    }

    public String getTMTIMERULENAME() {
        return this.GetParamStringValue(TAG_TMTIMERULENAME, "");
    }

    public void setTMTIMERULENAME(String strValue) {
        this.SetParamValue(TAG_TMTIMERULENAME, strValue);
    }

    public boolean isDAYMODENull() {
        return this.IsParamNull(TAG_DAYMODE);
    }

    public int getDAYMODE() {
        return this.GetParamIntValue(TAG_DAYMODE, 0);
    }

    public void setDAYMODE(int strValue) {
        this.SetParamValue(TAG_DAYMODE, strValue);
    }

    public boolean isMEMONull() {
        return this.IsParamNull(TAG_MEMO);
    }

    public String getMEMO() {
        return this.GetParamStringValue(TAG_MEMO, "");
    }

    public void setMEMO(String strValue) {
        this.SetParamValue(TAG_MEMO, strValue);
    }
}

