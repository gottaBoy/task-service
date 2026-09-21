/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class GSR2Dimension
extends BaseDataEntity {
    public static final String TAG_GSR2DIMENSIONID = "GSR2DIMENSIONID";
    public static final String TAG_GSR2DIMENSIONNAME = "GSR2DIMENSIONNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_GSR2ID = "GSR2ID";
    public static final String TAG_GSR2NAME = "GSR2NAME";
    public static final String TAG_JOINDEID = "JOINDEID";
    public static final String TAG_JOINDENAME = "JOINDENAME";
    public static final String TAG_ORDERFLAG = "ORDERFLAG";
    public static final String TAG_EXTCOND = "EXTCOND";
    public static final String TAG_DEFAULTFLAG = "DEFAULTFLAG";
    public static final String TAG_ISDRILLDOWN = "ISDRILLDOWN";

    public String getGSR2DIMENSIONID() {
        return this.GetParamStringValue(TAG_GSR2DIMENSIONID, "");
    }

    public void setGSR2DIMENSIONID(String strValue) {
        this.SetParamValue(TAG_GSR2DIMENSIONID, strValue);
    }

    public String getGSR2DIMENSIONNAME() {
        return this.GetParamStringValue(TAG_GSR2DIMENSIONNAME, "");
    }

    public void setGSR2DIMENSIONNAME(String strValue) {
        this.SetParamValue(TAG_GSR2DIMENSIONNAME, strValue);
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

    public String getGSR2ID() {
        return this.GetParamStringValue(TAG_GSR2ID, "");
    }

    public void setGSR2ID(String strValue) {
        this.SetParamValue(TAG_GSR2ID, strValue);
    }

    public String getGSR2NAME() {
        return this.GetParamStringValue(TAG_GSR2NAME, "");
    }

    public void setGSR2NAME(String strValue) {
        this.SetParamValue(TAG_GSR2NAME, strValue);
    }

    public String getJOINDEID() {
        return this.GetParamStringValue(TAG_JOINDEID, "");
    }

    public void setJOINDEID(String strValue) {
        this.SetParamValue(TAG_JOINDEID, strValue);
    }

    public String getJOINDENAME() {
        return this.GetParamStringValue(TAG_JOINDENAME, "");
    }

    public void setJOINDENAME(String strValue) {
        this.SetParamValue(TAG_JOINDENAME, strValue);
    }

    public int getORDERFLAG() {
        return this.GetParamIntValue(TAG_ORDERFLAG, 0);
    }

    public void setORDERFLAG(int strValue) {
        this.SetParamValue(TAG_ORDERFLAG, strValue);
    }

    public String getEXTCOND() {
        return this.GetParamStringValue(TAG_EXTCOND, "");
    }

    public void setEXTCOND(String strValue) {
        this.SetParamValue(TAG_EXTCOND, strValue);
    }

    public boolean getDEFAULTFLAG() {
        return this.GetParamIntValue(TAG_DEFAULTFLAG, 0) == 1;
    }

    public void setDEFAULTFLAG(boolean bValue) {
        this.SetParamValue(TAG_DEFAULTFLAG, bValue ? 1 : 0);
    }

    public boolean getISDRILLDOWN() {
        return this.GetParamIntValue(TAG_ISDRILLDOWN, 1) == 1;
    }

    public void setISDRILLDOWN(boolean bValue) {
        this.SetParamValue(TAG_ISDRILLDOWN, bValue ? 1 : 0);
    }
}

