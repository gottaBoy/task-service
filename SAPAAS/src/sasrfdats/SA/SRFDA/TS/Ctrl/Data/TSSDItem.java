/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.TS.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class TSSDItem
extends BaseDataEntity {
    public static final String MONTHTYPE_EVERY = "EVERY";
    public static final String MONTHTYPE_SOME = "SOME";
    public static final String MONTHDAYTYPE_EVERY = "EVERY";
    public static final String MONTHDAYTYPE_SOME = "SOME";
    public static final String MONTHDAYTYPE_NONE = "NONE";
    public static final String MONTHWEEKTYPE_EVERY = "EVERY";
    public static final String MONTHWEEKTYPE_WEEK1 = "ONE";
    public static final String MONTHWEEKTYPE_WEEK2 = "TWO";
    public static final String MONTHWEEKTYPE_WEEK3 = "THREE";
    public static final String MONTHWEEKTYPE_WEEK4 = "FOUR";
    public static final String MONTHWEEKTYPE_WEEK5 = "FIVE";
    public static final String MONTHWEEKTYPE_NONE = "NONE";
    public static final String HOURTYPE_EVERY = "EVERY";
    public static final String HOURTYPE_SOME = "SOME";
    public static final String MINUTETYPE_EVERY = "EVERY";
    public static final String MINUTETYPE_SOME = "SOME";
    public static final String MINUTETYPE_ZERO = "ZERO";
    public static final String SECONDTYPE_EVERY = "EVERY";
    public static final String SECONDTYPE_SOME = "SOME";
    public static final String SECONDTYPE_ZERO = "ZERO";
    public static final String TAG_TSSDITEMID = "TSSDITEMID";
    public static final String TAG_TSSDITEMNAME = "TSSDITEMNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_MONTHVALUE = "MONTHVALUE";
    public static final String TAG_MONTHDAYTYPE = "MONTHDAYTYPE";
    public static final String TAG_MONTHWEEKTYPE = "MONTHWEEKTYPE";
    public static final String TAG_MONTHWEEKVALUE = "MONTHWEEKVALUE";
    public static final String TAG_MONTHTYPE = "MONTHTYPE";
    public static final String TAG_MONTHDAYVALUE = "MONTHDAYVALUE";
    public static final String TAG_HOURTYPE = "HOURTYPE";
    public static final String TAG_MINUTETYPE = "MINUTETYPE";
    public static final String TAG_SECONDTYPE = "SECONDTYPE";
    public static final String TAG_HOURVALUE = "HOURVALUE";
    public static final String TAG_MINUTEVALUE = "MINUTEVALUE";
    public static final String TAG_SECONDVALUE = "SECONDVALUE";
    public static final String TAG_VERSION = "VERSION";

    public String getTSSDITEMID() {
        return this.GetParamStringValue(TAG_TSSDITEMID, "");
    }

    public void setTSSDITEMID(String strValue) {
        this.SetParamValue(TAG_TSSDITEMID, strValue);
    }

    public String getTSSDITEMNAME() {
        return this.GetParamStringValue(TAG_TSSDITEMNAME, "");
    }

    public void setTSSDITEMNAME(String strValue) {
        this.SetParamValue(TAG_TSSDITEMNAME, strValue);
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

    public String getMONTHVALUE() {
        return this.GetParamStringValue(TAG_MONTHVALUE, "");
    }

    public void setMONTHVALUE(String strValue) {
        this.SetParamValue(TAG_MONTHVALUE, strValue);
    }

    public String getMONTHDAYTYPE() {
        return this.GetParamStringValue(TAG_MONTHDAYTYPE, "");
    }

    public void setMONTHDAYTYPE(String strValue) {
        this.SetParamValue(TAG_MONTHDAYTYPE, strValue);
    }

    public String getMONTHWEEKTYPE() {
        return this.GetParamStringValue(TAG_MONTHWEEKTYPE, "");
    }

    public void setMONTHWEEKTYPE(String strValue) {
        this.SetParamValue(TAG_MONTHWEEKTYPE, strValue);
    }

    public String getMONTHWEEKVALUE() {
        return this.GetParamStringValue(TAG_MONTHWEEKVALUE, "");
    }

    public void setMONTHWEEKVALUE(String strValue) {
        this.SetParamValue(TAG_MONTHWEEKVALUE, strValue);
    }

    public String getMONTHTYPE() {
        return this.GetParamStringValue(TAG_MONTHTYPE, "");
    }

    public void setMONTHTYPE(String strValue) {
        this.SetParamValue(TAG_MONTHTYPE, strValue);
    }

    public String getMONTHDAYVALUE() {
        return this.GetParamStringValue(TAG_MONTHDAYVALUE, "");
    }

    public void setMONTHDAYVALUE(String strValue) {
        this.SetParamValue(TAG_MONTHDAYVALUE, strValue);
    }

    public String getHOURTYPE() {
        return this.GetParamStringValue(TAG_HOURTYPE, "");
    }

    public void setHOURTYPE(String strValue) {
        this.SetParamValue(TAG_HOURTYPE, strValue);
    }

    public String getMINUTETYPE() {
        return this.GetParamStringValue(TAG_MINUTETYPE, "");
    }

    public void setMINUTETYPE(String strValue) {
        this.SetParamValue(TAG_MINUTETYPE, strValue);
    }

    public String getSECONDTYPE() {
        return this.GetParamStringValue(TAG_SECONDTYPE, "");
    }

    public void setSECONDTYPE(String strValue) {
        this.SetParamValue(TAG_SECONDTYPE, strValue);
    }

    public String getHOURVALUE() {
        return this.GetParamStringValue(TAG_HOURVALUE, "");
    }

    public void setHOURVALUE(String strValue) {
        this.SetParamValue(TAG_HOURVALUE, strValue);
    }

    public String getMINUTEVALUE() {
        return this.GetParamStringValue(TAG_MINUTEVALUE, "");
    }

    public void setMINUTEVALUE(String strValue) {
        this.SetParamValue(TAG_MINUTEVALUE, strValue);
    }

    public String getSECONDVALUE() {
        return this.GetParamStringValue(TAG_SECONDVALUE, "");
    }

    public void setSECONDVALUE(String strValue) {
        this.SetParamValue(TAG_SECONDVALUE, strValue);
    }

    public int getVERSION() {
        return this.GetParamIntValue(TAG_VERSION, 0);
    }

    public void setVERSION(int strValue) {
        this.SetParamValue(TAG_VERSION, strValue);
    }
}

