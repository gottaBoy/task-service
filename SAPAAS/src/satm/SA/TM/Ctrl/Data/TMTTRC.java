/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.TM.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class TMTTRC
extends BaseDataEntity {
    public static final String TAG_TMTTRCID = "TMTTRCID";
    public static final String TAG_TMTTRCNAME = "TMTTRCNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_TMTASKTYPEID = "TMTASKTYPEID";
    public static final String TAG_TMTASKTYPENAME = "TMTASKTYPENAME";
    public static final String TAG_TMRESCATALOGID = "TMRESCATALOGID";
    public static final String TAG_TMRESCATALOGNAME = "TMRESCATALOGNAME";
    public static final String TAG_DESCRIPTION = "DESCRIPTION";
    public static final String TAG_REQUIREMODE = "REQUIREMODE";
    public static final String TAG_TASKRESTYPE = "TASKRESTYPE";
    public static final String TAG_IMPORTANCEFLAG = "IMPORTANCEFLAG";
    public static final String TAG_EXCLUSIVEFLAG = "EXCLUSIVEFLAG";

    public boolean isTMTTRCIDNull() {
        return this.IsParamNull(TAG_TMTTRCID);
    }

    public String getTMTTRCID() {
        return this.GetParamStringValue(TAG_TMTTRCID, "");
    }

    public void setTMTTRCID(String strValue) {
        this.SetParamValue(TAG_TMTTRCID, strValue);
    }

    public boolean isTMTTRCNAMENull() {
        return this.IsParamNull(TAG_TMTTRCNAME);
    }

    public String getTMTTRCNAME() {
        return this.GetParamStringValue(TAG_TMTTRCNAME, "");
    }

    public void setTMTTRCNAME(String strValue) {
        this.SetParamValue(TAG_TMTTRCNAME, strValue);
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

    public boolean isDESCRIPTIONNull() {
        return this.IsParamNull(TAG_DESCRIPTION);
    }

    public String getDESCRIPTION() {
        return this.GetParamStringValue(TAG_DESCRIPTION, "");
    }

    public void setDESCRIPTION(String strValue) {
        this.SetParamValue(TAG_DESCRIPTION, strValue);
    }

    public boolean isREQUIREMODENull() {
        return this.IsParamNull(TAG_REQUIREMODE);
    }

    public String getREQUIREMODE() {
        return this.GetParamStringValue(TAG_REQUIREMODE, "");
    }

    public void setREQUIREMODE(String strValue) {
        this.SetParamValue(TAG_REQUIREMODE, strValue);
    }

    public boolean isTASKRESTYPENull() {
        return this.IsParamNull(TAG_TASKRESTYPE);
    }

    public String getTASKRESTYPE() {
        return this.GetParamStringValue(TAG_TASKRESTYPE, "");
    }

    public void setTASKRESTYPE(String strValue) {
        this.SetParamValue(TAG_TASKRESTYPE, strValue);
    }

    public boolean isIMPORTANCEFLAGNull() {
        return this.IsParamNull(TAG_IMPORTANCEFLAG);
    }

    public int getIMPORTANCEFLAG() {
        return this.GetParamIntValue(TAG_IMPORTANCEFLAG, 0);
    }

    public void setIMPORTANCEFLAG(int strValue) {
        this.SetParamValue(TAG_IMPORTANCEFLAG, strValue);
    }

    public boolean isEXCLUSIVEFLAGNull() {
        return this.IsParamNull(TAG_EXCLUSIVEFLAG);
    }

    public boolean getEXCLUSIVEFLAG() {
        return this.GetParamIntValue(TAG_EXCLUSIVEFLAG, 0) == 1;
    }

    public void setEXCLUSIVEFLAG(boolean bValue) {
        this.SetParamValue(TAG_EXCLUSIVEFLAG, bValue ? 1 : 0);
    }
}

