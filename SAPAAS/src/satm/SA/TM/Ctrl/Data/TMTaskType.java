/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.TM.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class TMTaskType
extends BaseDataEntity {
    public static final String TAG_TMTASKTYPEID = "TMTASKTYPEID";
    public static final String TAG_TMTASKTYPENAME = "TMTASKTYPENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_LEAFTASK = "LEAFTASK";
    public static final String TAG_DESCRIPTION = "DESCRIPTION";
    public static final String TAG_HELPEROBJECT = "HELPEROBJECT";
    public static final String TAG_TASKOBJECT = "TASKOBJECT";

    public boolean isTMTASKTYPEIDNull() {
        return this.IsParamNull(TAG_TMTASKTYPEID);
    }

    public String getTMTASKTYPEID() {
        return this.GetParamStringValue(TAG_TMTASKTYPEID, "");
    }

    public void setTMTASKTYPEID(String strValue) {
        this.SetParamValue(TAG_TMTASKTYPEID, strValue);
    }

    public boolean isTMTASKTYPENAMENull() {
        return this.IsParamNull(TAG_TMTASKTYPENAME);
    }

    public String getTMTASKTYPENAME() {
        return this.GetParamStringValue(TAG_TMTASKTYPENAME, "");
    }

    public void setTMTASKTYPENAME(String strValue) {
        this.SetParamValue(TAG_TMTASKTYPENAME, strValue);
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

    public boolean isLEAFTASKNull() {
        return this.IsParamNull(TAG_LEAFTASK);
    }

    public boolean getLEAFTASK() {
        return this.GetParamIntValue(TAG_LEAFTASK, 0) == 1;
    }

    public void setLEAFTASK(boolean bValue) {
        this.SetParamValue(TAG_LEAFTASK, bValue ? 1 : 0);
    }

    public boolean isDESCRIPTIONNull() {
        return this.IsParamNull(TAG_DESCRIPTION);
    }

    public String getDESCRIPTION() {
        return this.GetParamStringValue(TAG_DESCRIPTION, "");
    }

    public void setDESCRIPTION(String strValue) {
        this.SetParamValue(TAG_DESCRIPTION, strValue);
    }

    public boolean isHELPEROBJECTNull() {
        return this.IsParamNull(TAG_HELPEROBJECT);
    }

    public String getHELPEROBJECT() {
        return this.GetParamStringValue(TAG_HELPEROBJECT, "");
    }

    public void setHELPEROBJECT(String strValue) {
        this.SetParamValue(TAG_HELPEROBJECT, strValue);
    }

    public boolean isTASKOBJECTNull() {
        return this.IsParamNull(TAG_TASKOBJECT);
    }

    public String getTASKOBJECT() {
        return this.GetParamStringValue(TAG_TASKOBJECT, "");
    }

    public void setTASKOBJECT(String strValue) {
        this.SetParamValue(TAG_TASKOBJECT, strValue);
    }
}

