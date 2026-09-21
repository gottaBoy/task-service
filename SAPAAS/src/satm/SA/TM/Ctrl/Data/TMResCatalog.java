/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.TM.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class TMResCatalog
extends BaseDataEntity {
    public static final String TAG_TMRESCATALOGID = "TMRESCATALOGID";
    public static final String TAG_TMRESCATALOGNAME = "TMRESCATALOGNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_DESCRIPTION = "DESCRIPTION";
    public static final String TAG_PTMRESCATALOGID = "PTMRESCATALOGID";
    public static final String TAG_PTMRESCATALOGNAME = "PTMRESCATALOGNAME";
    public static final String TAG_VERSION = "VERSION";
    public static final String TAG_TMTASKRESAEID = "TMTASKRESAEID";
    public static final String TAG_TMTASKRESAENAME = "TMTASKRESAENAME";

    public boolean isTMRESCATALOGIDNull() {
        return this.IsParamNull(TAG_TMRESCATALOGID);
    }

    public String getTMRESCATALOGID() {
        return this.GetParamStringValue(TAG_TMRESCATALOGID, "");
    }

    public void setTMRESCATALOGID(String strValue) {
        this.SetParamValue(TAG_TMRESCATALOGID, strValue);
    }

    public boolean isTMRESCATALOGNAMENull() {
        return this.IsParamNull(TAG_TMRESCATALOGNAME);
    }

    public String getTMRESCATALOGNAME() {
        return this.GetParamStringValue(TAG_TMRESCATALOGNAME, "");
    }

    public void setTMRESCATALOGNAME(String strValue) {
        this.SetParamValue(TAG_TMRESCATALOGNAME, strValue);
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

    public boolean isDESCRIPTIONNull() {
        return this.IsParamNull(TAG_DESCRIPTION);
    }

    public String getDESCRIPTION() {
        return this.GetParamStringValue(TAG_DESCRIPTION, "");
    }

    public void setDESCRIPTION(String strValue) {
        this.SetParamValue(TAG_DESCRIPTION, strValue);
    }

    public boolean isPTMRESCATALOGIDNull() {
        return this.IsParamNull(TAG_PTMRESCATALOGID);
    }

    public String getPTMRESCATALOGID() {
        return this.GetParamStringValue(TAG_PTMRESCATALOGID, "");
    }

    public void setPTMRESCATALOGID(String strValue) {
        this.SetParamValue(TAG_PTMRESCATALOGID, strValue);
    }

    public boolean isPTMRESCATALOGNAMENull() {
        return this.IsParamNull(TAG_PTMRESCATALOGNAME);
    }

    public String getPTMRESCATALOGNAME() {
        return this.GetParamStringValue(TAG_PTMRESCATALOGNAME, "");
    }

    public void setPTMRESCATALOGNAME(String strValue) {
        this.SetParamValue(TAG_PTMRESCATALOGNAME, strValue);
    }

    public boolean isVERSIONNull() {
        return this.IsParamNull(TAG_VERSION);
    }

    public int getVERSION() {
        return this.GetParamIntValue(TAG_VERSION, 0);
    }

    public void setVERSION(int strValue) {
        this.SetParamValue(TAG_VERSION, strValue);
    }

    public boolean isTMTASKRESAEIDNull() {
        return this.IsParamNull(TAG_TMTASKRESAEID);
    }

    public String getTMTASKRESAEID() {
        return this.GetParamStringValue(TAG_TMTASKRESAEID, "");
    }

    public void setTMTASKRESAEID(String strValue) {
        this.SetParamValue(TAG_TMTASKRESAEID, strValue);
    }

    public boolean isTMTASKRESAENAMENull() {
        return this.IsParamNull(TAG_TMTASKRESAENAME);
    }

    public String getTMTASKRESAENAME() {
        return this.GetParamStringValue(TAG_TMTASKRESAENAME, "");
    }

    public void setTMTASKRESAENAME(String strValue) {
        this.SetParamValue(TAG_TMTASKRESAENAME, strValue);
    }
}

