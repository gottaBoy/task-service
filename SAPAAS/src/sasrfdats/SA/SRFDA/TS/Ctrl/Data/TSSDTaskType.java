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

public class TSSDTaskType
extends BaseDataEntity {
    public static final String TAG_TSSDTASKTYPEID = "TSSDTASKTYPEID";
    public static final String TAG_TSSDTASKTYPENAME = "TSSDTASKTYPENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_TASKOBJECT = "TASKOBJECT";
    public static final String TAG_DESCRIPTION = "DESCRIPTION";
    public static final String TAG_TASKTYPEPARAM = "TASKTYPEPARAM";
    protected Properties taskTypeParam = null;

    public synchronized Properties getTaskTypeParam() {
        if (this.taskTypeParam != null) {
            return this.taskTypeParam;
        }
        try {
            this.taskTypeParam = PropertiesHelper.Load((String)this.getTASKTYPEPARAM());
            return this.taskTypeParam;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
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

    public String getTASKOBJECT() {
        return this.GetParamStringValue(TAG_TASKOBJECT, "");
    }

    public void setTASKOBJECT(String strValue) {
        this.SetParamValue(TAG_TASKOBJECT, strValue);
    }

    public String getDESCRIPTION() {
        return this.GetParamStringValue(TAG_DESCRIPTION, "");
    }

    public void setDESCRIPTION(String strValue) {
        this.SetParamValue(TAG_DESCRIPTION, strValue);
    }

    public String getTASKTYPEPARAM() {
        return this.GetParamStringValue(TAG_TASKTYPEPARAM, "");
    }

    public void setTASKTYPEPARAM(String strValue) {
        this.SetParamValue(TAG_TASKTYPEPARAM, strValue);
    }
}

