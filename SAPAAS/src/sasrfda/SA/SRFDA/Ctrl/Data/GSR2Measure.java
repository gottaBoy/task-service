/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class GSR2Measure
extends BaseDataEntity {
    public static final String TAG_GSR2MEASUREID = "GSR2MEASUREID";
    public static final String TAG_GSR2MEASURENAME = "GSR2MEASURENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_GSR2ID = "GSR2ID";
    public static final String TAG_GSR2NAME = "GSR2NAME";
    public static final String TAG_ORDERFLAG = "ORDERFLAG";
    public static final String TAG_DEFID = "DEFID";
    public static final String TAG_DEFNAME = "DEFNAME";
    public static final String TAG_GSRMEASUREGROUPID = "GSRMEASUREGROUPID";
    public static final String TAG_GSRMEASUREGROUPNAME = "GSRMEASUREGROUPNAME";
    public static final String TAG_THGROUPID = "THGROUPID";
    public static final String TAG_THGROUPNAME = "THGROUPNAME";
    public static final String TAG_WIDTH = "WIDTH";
    public static final String TAG_DEFAULTSORT = "DEFAULTSORT";
    public static final String TAG_ITEMFORMAT = "ITEMFORMAT";
    public static final String TAG_SLEXP = "SLEXP";

    public String getGSR2MEASUREID() {
        return this.GetParamStringValue(TAG_GSR2MEASUREID, "");
    }

    public void setGSR2MEASUREID(String strValue) {
        this.SetParamValue(TAG_GSR2MEASUREID, strValue);
    }

    public String getGSR2MEASURENAME() {
        return this.GetParamStringValue(TAG_GSR2MEASURENAME, "");
    }

    public void setGSR2MEASURENAME(String strValue) {
        this.SetParamValue(TAG_GSR2MEASURENAME, strValue);
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

    public int getORDERFLAG() {
        return this.GetParamIntValue(TAG_ORDERFLAG, 0);
    }

    public void setORDERFLAG(int strValue) {
        this.SetParamValue(TAG_ORDERFLAG, strValue);
    }

    public String getDEFID() {
        return this.GetParamStringValue(TAG_DEFID, "");
    }

    public void setDEFID(String strValue) {
        this.SetParamValue(TAG_DEFID, strValue);
    }

    public String getDEFNAME() {
        return this.GetParamStringValue(TAG_DEFNAME, "");
    }

    public void setDEFNAME(String strValue) {
        this.SetParamValue(TAG_DEFNAME, strValue);
    }

    public String getGSRMEASUREGROUPID() {
        return this.GetParamStringValue(TAG_GSRMEASUREGROUPID, "");
    }

    public void setGSRMEASUREGROUPID(String strValue) {
        this.SetParamValue(TAG_GSRMEASUREGROUPID, strValue);
    }

    public String getGSRMEASUREGROUPNAME() {
        return this.GetParamStringValue(TAG_GSRMEASUREGROUPNAME, "");
    }

    public void setGSRMEASUREGROUPNAME(String strValue) {
        this.SetParamValue(TAG_GSRMEASUREGROUPNAME, strValue);
    }

    public String getTHGROUPID() {
        return this.GetParamStringValue(TAG_THGROUPID, "");
    }

    public void setTHGROUPID(String strValue) {
        this.SetParamValue(TAG_THGROUPID, strValue);
    }

    public String getTHGROUPNAME() {
        return this.GetParamStringValue(TAG_THGROUPNAME, "");
    }

    public void setTHGROUPNAME(String strValue) {
        this.SetParamValue(TAG_THGROUPNAME, strValue);
    }

    public int getWIDTH() {
        return this.GetParamIntValue(TAG_WIDTH, 0);
    }

    public void setWIDTH(int strValue) {
        this.SetParamValue(TAG_WIDTH, strValue);
    }

    public String getDEFAULTSORT() {
        return this.GetParamStringValue(TAG_DEFAULTSORT, "");
    }

    public void setDEFAULTSORT(String strValue) {
        this.SetParamValue(TAG_DEFAULTSORT, strValue);
    }

    public String getITEMFORMAT() {
        return this.GetParamStringValue(TAG_ITEMFORMAT, "");
    }

    public void setITEMFORMAT(String strValue) {
        this.SetParamValue(TAG_ITEMFORMAT, strValue);
    }

    public String getSLEXP() {
        return this.GetParamStringValue(TAG_SLEXP, "");
    }

    public void setSLEXP(String strValue) {
        this.SetParamValue(TAG_SLEXP, strValue);
    }
}

