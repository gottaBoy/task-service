/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class DevScriptGroup
extends BaseDataEntity {
    public static final String TAG_DEVSCRIPTGROUPID = "DEVSCRIPTGROUPID";
    public static final String TAG_DEVSCRIPTGROUPNAME = "DEVSCRIPTGROUPNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_ORDERFLAG = "ORDERFLAG";
    public static final String TAG_MERGESCRIPT = "MERGESCRIPT";
    public static final String TAG_MERGEFILEPATH = "MERGEFILEPATH";
    public static final String TAG_DEFAULTGROUP = "DEFAULTGROUP";

    public String getDEVSCRIPTGROUPID() {
        return this.GetParamStringValue(TAG_DEVSCRIPTGROUPID, "");
    }

    public void setDEVSCRIPTGROUPID(String strValue) {
        this.SetParamValue(TAG_DEVSCRIPTGROUPID, strValue);
    }

    public String getDEVSCRIPTGROUPNAME() {
        return this.GetParamStringValue(TAG_DEVSCRIPTGROUPNAME, "");
    }

    public void setDEVSCRIPTGROUPNAME(String strValue) {
        this.SetParamValue(TAG_DEVSCRIPTGROUPNAME, strValue);
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

    public int getORDERFLAG() {
        return this.GetParamIntValue(TAG_ORDERFLAG, 0);
    }

    public void setORDERFLAG(int strValue) {
        this.SetParamValue(TAG_ORDERFLAG, strValue);
    }

    public boolean getMERGESCRIPT() {
        return this.GetParamIntValue(TAG_MERGESCRIPT, 0) == 1;
    }

    public void setMERGESCRIPT(boolean bValue) {
        this.SetParamValue(TAG_MERGESCRIPT, bValue ? 1 : 0);
    }

    public String getMERGEFILEPATH() {
        return this.GetParamStringValue(TAG_MERGEFILEPATH, "");
    }

    public void setMERGEFILEPATH(String strValue) {
        this.SetParamValue(TAG_MERGEFILEPATH, strValue);
    }

    public boolean getDEFAULTGROUP() {
        return this.GetParamIntValue(TAG_DEFAULTGROUP, 0) == 1;
    }

    public void setDEFAULTGROUP(boolean bValue) {
        this.SetParamValue(TAG_DEFAULTGROUP, bValue ? 1 : 0);
    }
}

