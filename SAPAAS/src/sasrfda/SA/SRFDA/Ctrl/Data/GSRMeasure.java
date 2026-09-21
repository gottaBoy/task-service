/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class GSRMeasure
extends BaseDataEntity {
    public static final String TAG_GSRMEASUREID = "GSRMEASUREID";
    public static final String TAG_GSRMEASURENAME = "GSRMEASURENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_GROUPSTATISTICSREPID = "GROUPSTATISTICSREPID";
    public static final String TAG_GROUPSTATISTICSREPNAME = "GROUPSTATISTICSREPNAME";
    public static final String TAG_ORDERFLAG = "ORDERFLAG";
    public static final String TAG_EXPRESSION = "EXPRESSION";
    public static final String TAG_WIDTH = "WIDTH";
    public static final String TAG_EXPALIAS = "EXPALIAS";
    public static final String TAG_ITEMFORMAT = "ITEMFORMAT";
    public static final String TAG_RECALCFLAG = "RECALCFLAG";
    public static final String TAG_GSRMEASUREGROUPID = "GSRMEASUREGROUPID";
    public static final String TAG_GSRMEASUREGROUPNAME = "GSRMEASUREGROUPNAME";
    public static final String TAG_DEFAULTSORT = "DEFAULTSORT";
    public static final String TAG_THGROUPID = "THGROUPID";
    public static final String TAG_THGROUPNAME = "THGROUPNAME";

    public String getGSRMEASUREID() {
        return this.GetParamStringValue(TAG_GSRMEASUREID, "");
    }

    public void setGSRMEASUREID(String strValue) {
        this.SetParamValue(TAG_GSRMEASUREID, strValue);
    }

    public String getGSRMEASURENAME() {
        return this.GetParamStringValue(TAG_GSRMEASURENAME, "");
    }

    public void setGSRMEASURENAME(String strValue) {
        this.SetParamValue(TAG_GSRMEASURENAME, strValue);
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

    public String getGROUPSTATISTICSREPID() {
        return this.GetParamStringValue(TAG_GROUPSTATISTICSREPID, "");
    }

    public void setGROUPSTATISTICSREPID(String strValue) {
        this.SetParamValue(TAG_GROUPSTATISTICSREPID, strValue);
    }

    public String getGROUPSTATISTICSREPNAME() {
        return this.GetParamStringValue(TAG_GROUPSTATISTICSREPNAME, "");
    }

    public void setGROUPSTATISTICSREPNAME(String strValue) {
        this.SetParamValue(TAG_GROUPSTATISTICSREPNAME, strValue);
    }

    public int getORDERFLAG() {
        return this.GetParamIntValue(TAG_ORDERFLAG, 0);
    }

    public void setORDERFLAG(int strValue) {
        this.SetParamValue(TAG_ORDERFLAG, strValue);
    }

    public String getEXPRESSION() {
        return this.GetParamStringValue(TAG_EXPRESSION, "");
    }

    public void setEXPRESSION(String strValue) {
        this.SetParamValue(TAG_EXPRESSION, strValue);
    }

    public int getWIDTH() {
        return this.GetParamIntValue(TAG_WIDTH, 0);
    }

    public void setWIDTH(int strValue) {
        this.SetParamValue(TAG_WIDTH, strValue);
    }

    public String getEXPALIAS() {
        return this.GetParamStringValue(TAG_EXPALIAS, "");
    }

    public void setEXPALIAS(String strValue) {
        this.SetParamValue(TAG_EXPALIAS, strValue);
    }

    public String getITEMFORMAT() {
        return this.GetParamStringValue(TAG_ITEMFORMAT, "");
    }

    public void setITEMFORMAT(String strValue) {
        this.SetParamValue(TAG_ITEMFORMAT, strValue);
    }

    public boolean getRECALCFLAG() {
        return this.GetParamIntValue(TAG_RECALCFLAG, 0) == 1;
    }

    public void setRECALCFLAG(boolean bValue) {
        this.SetParamValue(TAG_RECALCFLAG, bValue ? 1 : 0);
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

    public String getDEFAULTSORT() {
        return this.GetParamStringValue(TAG_DEFAULTSORT, "");
    }

    public void setDEFAULTSORT(String strValue) {
        this.SetParamValue(TAG_DEFAULTSORT, strValue);
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
}

