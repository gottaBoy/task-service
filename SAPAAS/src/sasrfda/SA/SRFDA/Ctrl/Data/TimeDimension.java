/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class TimeDimension
extends BaseDataEntity {
    public static final String TAG_TIMEDIMENSIONID = "TIMEDIMENSIONID";
    public static final String TAG_TIMEDIMENSIONNAME = "TIMEDIMENSIONNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_BEGINTIME = "BEGINTIME";
    public static final String TAG_ENDTIME = "ENDTIME";
    public static final String TDTYPE_Y = "Y";
    public static final String TDTYPE_YM = "YM";
    public static final String TDTYPE_YMW = "YMW";
    public static final String TDTYPE_YMWD = "YMWD";
    public static final String TDTYPE_YMWDH = "YMWDH";
    public static final String TDTYPE_YMD = "YMD";
    public static final String TDTYPE_YMDH = "YMDH";
    public static final String TDTYPE_YW = "YW";
    public static final String TDTYPE_YWD = "YWD";
    public static final String TDTYPE_YWDH = "YWDH";

    public String getTIMEDIMENSIONID() {
        return this.GetParamStringValue(TAG_TIMEDIMENSIONID, "");
    }

    public void setTIMEDIMENSIONID(String strValue) {
        this.SetParamValue(TAG_TIMEDIMENSIONID, strValue);
    }

    public String getTIMEDIMENSIONNAME() {
        return this.GetParamStringValue(TAG_TIMEDIMENSIONNAME, "");
    }

    public void setTIMEDIMENSIONNAME(String strValue) {
        this.SetParamValue(TAG_TIMEDIMENSIONNAME, strValue);
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

    public Date getBEGINTIME() {
        return this.GetParamDateValue(TAG_BEGINTIME, null);
    }

    public void setBEGINTIME(Date strValue) {
        this.SetParamValue(TAG_BEGINTIME, strValue);
    }

    public Date getENDTIME() {
        return this.GetParamDateValue(TAG_ENDTIME, null);
    }

    public void setENDTIME(Date strValue) {
        this.SetParamValue(TAG_ENDTIME, strValue);
    }
}

