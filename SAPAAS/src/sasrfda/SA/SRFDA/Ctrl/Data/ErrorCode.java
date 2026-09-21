/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class ErrorCode
extends BaseDataEntity {
    public static final String TAG_ERRORCODEID = "ERRORCODEID";
    public static final String TAG_ERRORCODENAME = "ERRORCODENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_ERRORGROUP = "ERRORGROUP";
    public static final String TAG_ERRCODE = "ERRCODE";
    public static final String TAG_DESCRIPTION = "DESCRIPTION";

    public String getERRORCODEID() {
        return this.GetParamStringValue(TAG_ERRORCODEID, "");
    }

    public void setERRORCODEID(String strValue) {
        this.SetParamValue(TAG_ERRORCODEID, strValue);
    }

    public String getERRORCODENAME() {
        return this.GetParamStringValue(TAG_ERRORCODENAME, "");
    }

    public void setERRORCODENAME(String strValue) {
        this.SetParamValue(TAG_ERRORCODENAME, strValue);
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

    public String getERRORGROUP() {
        return this.GetParamStringValue(TAG_ERRORGROUP, "");
    }

    public void setERRORGROUP(String strValue) {
        this.SetParamValue(TAG_ERRORGROUP, strValue);
    }

    public String getERRCODE() {
        return this.GetParamStringValue(TAG_ERRCODE, "");
    }

    public void setERRCODE(String strValue) {
        this.SetParamValue(TAG_ERRCODE, strValue);
    }

    public String getDESCRIPTION() {
        return this.GetParamStringValue(TAG_DESCRIPTION, "");
    }

    public void setDESCRIPTION(String strValue) {
        this.SetParamValue(TAG_DESCRIPTION, strValue);
    }
}

