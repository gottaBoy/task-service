/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.EAI.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class DBProcPkg
extends BaseDataEntity {
    public static final String TAG_EAIDBPROCPKGID = "EAIDBPROCPKGID";
    public static final String TAG_EAIDBPROCPKGNAME = "EAIDBPROCPKGNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PROCMODEL = "PROCMODEL";
    public static final String TAG_DESCRIPTION = "DESCRIPTION";

    public void setDESCRIPTION(String strValue) {
        this.SetParamValue(TAG_DESCRIPTION, strValue);
    }

    public String getDESCRIPTION() {
        return this.GetParamStringValue(TAG_DESCRIPTION, "");
    }

    public boolean isEAIDBPROCPKGIDNull() {
        return this.IsParamNull(TAG_EAIDBPROCPKGID);
    }

    public String getEAIDBPROCPKGID() {
        return this.GetParamStringValue(TAG_EAIDBPROCPKGID, "");
    }

    public void setEAIDBPROCPKGID(String strValue) {
        this.SetParamValue(TAG_EAIDBPROCPKGID, strValue);
    }

    public boolean isEAIDBPROCPKGNAMENull() {
        return this.IsParamNull(TAG_EAIDBPROCPKGNAME);
    }

    public String getEAIDBPROCPKGNAME() {
        return this.GetParamStringValue(TAG_EAIDBPROCPKGNAME, "");
    }

    public void setEAIDBPROCPKGNAME(String strValue) {
        this.SetParamValue(TAG_EAIDBPROCPKGNAME, strValue);
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

    public boolean isPROCMODELNull() {
        return this.IsParamNull(TAG_PROCMODEL);
    }

    public String getPROCMODEL() {
        return this.GetParamStringValue(TAG_PROCMODEL, "");
    }

    public void setPROCMODEL(String strValue) {
        this.SetParamValue(TAG_PROCMODEL, strValue);
    }
}

