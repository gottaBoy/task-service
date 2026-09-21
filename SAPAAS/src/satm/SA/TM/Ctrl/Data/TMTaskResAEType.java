/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.TM.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class TMTaskResAEType
extends BaseDataEntity {
    public static final String TAG_TMTASKRESAETYPEID = "TMTASKRESAETYPEID";
    public static final String TAG_TMTASKRESAETYPENAME = "TMTASKRESAETYPENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_ENGINEOBJECT = "ENGINEOBJECT";
    public static final String TAG_DESCRIPTION = "DESCRIPTION";

    public boolean isTMTASKRESAETYPEIDNull() {
        return this.IsParamNull(TAG_TMTASKRESAETYPEID);
    }

    public String getTMTASKRESAETYPEID() {
        return this.GetParamStringValue(TAG_TMTASKRESAETYPEID, "");
    }

    public void setTMTASKRESAETYPEID(String strValue) {
        this.SetParamValue(TAG_TMTASKRESAETYPEID, strValue);
    }

    public boolean isTMTASKRESAETYPENAMENull() {
        return this.IsParamNull(TAG_TMTASKRESAETYPENAME);
    }

    public String getTMTASKRESAETYPENAME() {
        return this.GetParamStringValue(TAG_TMTASKRESAETYPENAME, "");
    }

    public void setTMTASKRESAETYPENAME(String strValue) {
        this.SetParamValue(TAG_TMTASKRESAETYPENAME, strValue);
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

    public boolean isENGINEOBJECTNull() {
        return this.IsParamNull(TAG_ENGINEOBJECT);
    }

    public String getENGINEOBJECT() {
        return this.GetParamStringValue(TAG_ENGINEOBJECT, "");
    }

    public void setENGINEOBJECT(String strValue) {
        this.SetParamValue(TAG_ENGINEOBJECT, strValue);
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
}

