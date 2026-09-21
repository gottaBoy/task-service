/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.EAI.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class DBOPPKG
extends BaseDataEntity {
    public static final String TAG_EAIDBOPPKGID = "EAIDBOPPKGID";
    public static final String TAG_EAIDBOPPKGNAME = "EAIDBOPPKGNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PROCMODEL = "PROCMODEL";
    public static final String TAG_PROCNAME = "PROCNAME";
    public static final String TAG_LOGICNAME = "LOGICNAME";
    public static final String TAG_DESCRIPTION = "DESCRIPTION";
    public static final String TAG_DBSCHEMAMAP = "DBSCHEMAMAP";
    public static final String TAG_INITCODE = "INITCODE";
    public static final String TAG_EXPCODE = "EXPCODE";
    public static final String TAG_EXITCODE = "EXITCODE";
    public static final String TAG_DBSTORAGE = "DBSTORAGE";
    public static final String TAG_DECLARECODE = "DECLARECODE";

    public boolean isEAIDBOPPKGIDNull() {
        return this.IsParamNull(TAG_EAIDBOPPKGID);
    }

    public String getEAIDBOPPKGID() {
        return this.GetParamStringValue(TAG_EAIDBOPPKGID, "");
    }

    public void setEAIDBOPPKGID(String strValue) {
        this.SetParamValue(TAG_EAIDBOPPKGID, strValue);
    }

    public boolean isEAIDBOPPKGNAMENull() {
        return this.IsParamNull(TAG_EAIDBOPPKGNAME);
    }

    public String getEAIDBOPPKGNAME() {
        return this.GetParamStringValue(TAG_EAIDBOPPKGNAME, "");
    }

    public void setEAIDBOPPKGNAME(String strValue) {
        this.SetParamValue(TAG_EAIDBOPPKGNAME, strValue);
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

    public boolean isPROCNAMENull() {
        return this.IsParamNull(TAG_PROCNAME);
    }

    public String getPROCNAME() {
        return this.GetParamStringValue(TAG_PROCNAME, "");
    }

    public void setPROCNAME(String strValue) {
        this.SetParamValue(TAG_PROCNAME, strValue);
    }

    public boolean isLOGICNAMENull() {
        return this.IsParamNull(TAG_LOGICNAME);
    }

    public String getLOGICNAME() {
        return this.GetParamStringValue(TAG_LOGICNAME, "");
    }

    public void setLOGICNAME(String strValue) {
        this.SetParamValue(TAG_LOGICNAME, strValue);
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

    public boolean isDBSCHEMAMAPNull() {
        return this.IsParamNull(TAG_DBSCHEMAMAP);
    }

    public String getDBSCHEMAMAP() {
        return this.GetParamStringValue(TAG_DBSCHEMAMAP, "");
    }

    public void setDBSCHEMAMAP(String strValue) {
        this.SetParamValue(TAG_DBSCHEMAMAP, strValue);
    }

    public boolean isINITCODENull() {
        return this.IsParamNull(TAG_INITCODE);
    }

    public String getINITCODE() {
        return this.GetParamStringValue(TAG_INITCODE, "");
    }

    public void setINITCODE(String strValue) {
        this.SetParamValue(TAG_INITCODE, strValue);
    }

    public boolean isEXPCODENull() {
        return this.IsParamNull(TAG_EXPCODE);
    }

    public String getEXPCODE() {
        return this.GetParamStringValue(TAG_EXPCODE, "");
    }

    public void setEXPCODE(String strValue) {
        this.SetParamValue(TAG_EXPCODE, strValue);
    }

    public boolean isEXITCODENull() {
        return this.IsParamNull(TAG_EXITCODE);
    }

    public String getEXITCODE() {
        return this.GetParamStringValue(TAG_EXITCODE, "");
    }

    public void setEXITCODE(String strValue) {
        this.SetParamValue(TAG_EXITCODE, strValue);
    }

    public boolean isDBSTORAGENull() {
        return this.IsParamNull(TAG_DBSTORAGE);
    }

    public String getDBSTORAGE() {
        return this.GetParamStringValue(TAG_DBSTORAGE, "");
    }

    public void setDBSTORAGE(String strValue) {
        this.SetParamValue(TAG_DBSTORAGE, strValue);
    }

    public boolean isDECLARECODENull() {
        return this.IsParamNull(TAG_DECLARECODE);
    }

    public String getDECLARECODE() {
        return this.GetParamStringValue(TAG_DECLARECODE, "");
    }

    public void setDECLARECODE(String strValue) {
        this.SetParamValue(TAG_DECLARECODE, strValue);
    }
}

