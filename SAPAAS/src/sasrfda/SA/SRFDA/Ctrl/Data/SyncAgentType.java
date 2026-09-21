/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class SyncAgentType
extends BaseDataEntity {
    public static final String TAG_SYNCAGENTTYPEID = "SYNCAGENTTYPEID";
    public static final String TAG_SYNCAGENTTYPENAME = "SYNCAGENTTYPENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_DESCRIPTION = "DESCRIPTION";
    public static final String TAG_ENGINEOBJECT = "ENGINEOBJECT";

    public boolean isSYNCAGENTTYPEIDNull() {
        return this.IsParamNull(TAG_SYNCAGENTTYPEID);
    }

    public String getSYNCAGENTTYPEID() {
        return this.GetParamStringValue(TAG_SYNCAGENTTYPEID, "");
    }

    public void setSYNCAGENTTYPEID(String strValue) {
        this.SetParamValue(TAG_SYNCAGENTTYPEID, strValue);
    }

    public boolean isSYNCAGENTTYPENAMENull() {
        return this.IsParamNull(TAG_SYNCAGENTTYPENAME);
    }

    public String getSYNCAGENTTYPENAME() {
        return this.GetParamStringValue(TAG_SYNCAGENTTYPENAME, "");
    }

    public void setSYNCAGENTTYPENAME(String strValue) {
        this.SetParamValue(TAG_SYNCAGENTTYPENAME, strValue);
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

    public void setCREATEDATE(Date dtValue) {
        this.SetParamValue(TAG_CREATEDATE, dtValue);
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

    public void setUPDATEDATE(Date dtValue) {
        this.SetParamValue(TAG_UPDATEDATE, dtValue);
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

    public boolean isENGINEOBJECTNull() {
        return this.IsParamNull(TAG_ENGINEOBJECT);
    }

    public String getENGINEOBJECT() {
        return this.GetParamStringValue(TAG_ENGINEOBJECT, "");
    }

    public void setENGINEOBJECT(String strValue) {
        this.SetParamValue(TAG_ENGINEOBJECT, strValue);
    }
}

