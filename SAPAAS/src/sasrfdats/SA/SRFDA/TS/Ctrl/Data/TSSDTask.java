/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.UtilityEx.PropertiesHelper
 */
package SA.SRFDA.TS.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.UtilityEx.PropertiesHelper;
import java.util.Date;
import java.util.Properties;

public class TSSDTask
extends BaseDataEntity {
    public static final String TAG_TSSDTASKID = "TSSDTASKID";
    public static final String TAG_TSSDTASKNAME = "TSSDTASKNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_TSSDTASKTYPEID = "TSSDTASKTYPEID";
    public static final String TAG_TSSDTASKTYPENAME = "TSSDTASKTYPENAME";
    public static final String TAG_TSSDENGINEID = "TSSDENGINEID";
    public static final String TAG_TSSDENGINENAME = "TSSDENGINENAME";
    public static final String TAG_TASKPARAM = "TASKPARAM";
    public static final String TAG_USERDATA = "USERDATA";
    public static final String TAG_DESCRIPTION = "DESCRIPTION";
    public static final String TAG_VERSION = "VERSION";
    public static final String TAG_ENABLEFLAG = "ENABLEFLAG";
    public static final String TAG_USERDATA2 = "USERDATA2";
    public static final String TAG_USERDATA3 = "USERDATA3";
    public static final String TAG_USERDATA4 = "USERDATA4";
    protected Properties taskParam = null;

    public synchronized Properties getTaskParam() {
        if (this.taskParam != null) {
            return this.taskParam;
        }
        try {
            this.taskParam = PropertiesHelper.Load((String)this.getTASKPARAM());
            return this.taskParam;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getTSSDTASKID() {
        return this.GetParamStringValue(TAG_TSSDTASKID, "");
    }

    public void setTSSDTASKID(String strValue) {
        this.SetParamValue(TAG_TSSDTASKID, strValue);
    }

    public String getTSSDTASKNAME() {
        return this.GetParamStringValue(TAG_TSSDTASKNAME, "");
    }

    public void setTSSDTASKNAME(String strValue) {
        this.SetParamValue(TAG_TSSDTASKNAME, strValue);
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

    public String getTSSDTASKTYPEID() {
        return this.GetParamStringValue(TAG_TSSDTASKTYPEID, "");
    }

    public void setTSSDTASKTYPEID(String strValue) {
        this.SetParamValue(TAG_TSSDTASKTYPEID, strValue);
    }

    public String getTSSDTASKTYPENAME() {
        return this.GetParamStringValue(TAG_TSSDTASKTYPENAME, "");
    }

    public void setTSSDTASKTYPENAME(String strValue) {
        this.SetParamValue(TAG_TSSDTASKTYPENAME, strValue);
    }

    public String getTSSDENGINEID() {
        return this.GetParamStringValue(TAG_TSSDENGINEID, "");
    }

    public void setTSSDENGINEID(String strValue) {
        this.SetParamValue(TAG_TSSDENGINEID, strValue);
    }

    public String getTSSDENGINENAME() {
        return this.GetParamStringValue(TAG_TSSDENGINENAME, "");
    }

    public void setTSSDENGINENAME(String strValue) {
        this.SetParamValue(TAG_TSSDENGINENAME, strValue);
    }

    public String getTASKPARAM() {
        return this.GetParamStringValue(TAG_TASKPARAM, "");
    }

    public void setTASKPARAM(String strValue) {
        this.SetParamValue(TAG_TASKPARAM, strValue);
    }

    public String getUSERDATA() {
        return this.GetParamStringValue(TAG_USERDATA, "");
    }

    public void setUSERDATA(String strValue) {
        this.SetParamValue(TAG_USERDATA, strValue);
    }

    public String getDESCRIPTION() {
        return this.GetParamStringValue(TAG_DESCRIPTION, "");
    }

    public void setDESCRIPTION(String strValue) {
        this.SetParamValue(TAG_DESCRIPTION, strValue);
    }

    public int getVERSION() {
        return this.GetParamIntValue(TAG_VERSION, 0);
    }

    public void setVERSION(int strValue) {
        this.SetParamValue(TAG_VERSION, strValue);
    }

    public boolean getENABLEFLAG() {
        return this.GetParamIntValue(TAG_ENABLEFLAG, 0) == 1;
    }

    public void setENABLEFLAG(boolean bValue) {
        this.SetParamValue(TAG_ENABLEFLAG, bValue ? 1 : 0);
    }

    public String getUSERDATA2() {
        return this.GetParamStringValue(TAG_USERDATA2, "");
    }

    public void setUSERDATA2(String strValue) {
        this.SetParamValue(TAG_USERDATA2, strValue);
    }

    public String getUSERDATA3() {
        return this.GetParamStringValue(TAG_USERDATA3, "");
    }

    public void setUSERDATA3(String strValue) {
        this.SetParamValue(TAG_USERDATA3, strValue);
    }

    public String getUSERDATA4() {
        return this.GetParamStringValue(TAG_USERDATA4, "");
    }

    public void setUSERDATA4(String strValue) {
        this.SetParamValue(TAG_USERDATA4, strValue);
    }
}

