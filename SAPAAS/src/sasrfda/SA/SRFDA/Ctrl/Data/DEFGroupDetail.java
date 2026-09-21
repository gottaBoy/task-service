/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class DEFGroupDetail
extends BaseDataEntity {
    public static final String TAG_DEFGROUPDETAILID = "DEFGROUPDETAILID";
    public static final String TAG_DEFGROUPDETAILNAME = "DEFGROUPDETAILNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_DEFLOGICNAME = "DEFLOGICNAME";
    public static final String TAG_SEARCHMODEL = "SEARCHMODEL";
    public static final String TAG_DEFGROUPNAME = "DEFGROUPNAME";
    public static final String TAG_DEFNAME = "DEFNAME";
    public static final String TAG_DEID = "DEID";
    public static final String TAG_DENAME = "DENAME";
    public static final String TAG_DEFGROUPID = "DEFGROUPID";
    public static final String TAG_DEFID = "DEFID";

    public String getDEFGROUPDETAILID() {
        return this.GetParamStringValue(TAG_DEFGROUPDETAILID, "");
    }

    public void setDEFGROUPDETAILID(String strValue) {
        this.SetParamValue(TAG_DEFGROUPDETAILID, strValue);
    }

    public String getDEFGROUPDETAILNAME() {
        return this.GetParamStringValue(TAG_DEFGROUPDETAILNAME, "");
    }

    public void setDEFGROUPDETAILNAME(String strValue) {
        this.SetParamValue(TAG_DEFGROUPDETAILNAME, strValue);
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

    public String getDEFLOGICNAME() {
        return this.GetParamStringValue(TAG_DEFLOGICNAME, "");
    }

    public void setDEFLOGICNAME(String strValue) {
        this.SetParamValue(TAG_DEFLOGICNAME, strValue);
    }

    public String getSEARCHMODEL() {
        return this.GetParamStringValue(TAG_SEARCHMODEL, "");
    }

    public void setSEARCHMODEL(String strValue) {
        this.SetParamValue(TAG_SEARCHMODEL, strValue);
    }

    public String getDEFGROUPNAME() {
        return this.GetParamStringValue(TAG_DEFGROUPNAME, "");
    }

    public void setDEFGROUPNAME(String strValue) {
        this.SetParamValue(TAG_DEFGROUPNAME, strValue);
    }

    public String getDEFNAME() {
        return this.GetParamStringValue(TAG_DEFNAME, "");
    }

    public void setDEFNAME(String strValue) {
        this.SetParamValue(TAG_DEFNAME, strValue);
    }

    public String getDEID() {
        return this.GetParamStringValue(TAG_DEID, "");
    }

    public void setDEID(String strValue) {
        this.SetParamValue(TAG_DEID, strValue);
    }

    public String getDENAME() {
        return this.GetParamStringValue(TAG_DENAME, "");
    }

    public void setDENAME(String strValue) {
        this.SetParamValue(TAG_DENAME, strValue);
    }

    public String getDEFGROUPID() {
        return this.GetParamStringValue(TAG_DEFGROUPID, "");
    }

    public void setDEFGROUPID(String strValue) {
        this.SetParamValue(TAG_DEFGROUPID, strValue);
    }

    public String getDEFID() {
        return this.GetParamStringValue(TAG_DEFID, "");
    }

    public void setDEFID(String strValue) {
        this.SetParamValue(TAG_DEFID, strValue);
    }
}

