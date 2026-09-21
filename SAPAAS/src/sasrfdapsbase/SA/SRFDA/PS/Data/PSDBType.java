/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSDBType
extends BaseDataEntity {
    public static final String TAG_PSDBTYPEID = "PSDBTYPEID";
    public static final String TAG_PSDBTYPENAME = "PSDBTYPENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_TYPEHELPER = "TYPEHELPER";
    public static final String TAG_JDBCDRIVERNAME = "JDBCDRIVERNAME";
    public static final String TAG_INSERTSPPUBOBJ = "INSERTSPPUBOBJ";
    public static final String TAG_UPDATESPPUBOBJ = "UPDATESPPUBOBJ";
    public static final String TAG_DELETESPPUBOBJ = "DELETESPPUBOBJ";
    public static final String TAG_DEFDTCOLOBJ = "DEFDTCOLOBJ";
    public static final String TAG_SYSDBCFGOBJ = "SYSDBCFGOBJ";
    public static final String TAG_DEDBCFGOBJ = "DEDBCFGOBJ";
    public static final String TAG_DEDQPUBOBJ = "DEDQPUBOBJ";
    public static final String TAG_DEDQENGOBJ = "DEDQENGOBJ";
    public static final String TAG_DEDSPUBOBJ = "DEDSPUBOBJ";
    public static final String TAG_GETSPPUBOBJ = "GETSPPUBOBJ";
    public static final String TAG_JDBCDIALECT = "JDBCDIALECT";
    public static final String TAG_HIBDIALECT = "HIBDIALECT";
    public static final String TAG_ICONPATH = "ICONPATH";
    public static final String TAG_INSTALLPATH = "INSTALLPATH";
    public static final String TAG_DBCLIENTPATH = "DBCLIENTPATH";

    public final boolean isPSDBTYPEIDNull() {
        return this.IsParamNull(TAG_PSDBTYPEID);
    }

    public final String getPSDBTYPEID() {
        return this.GetParamStringValue(TAG_PSDBTYPEID, "");
    }

    public final void setPSDBTYPEID(String strValue) {
        this.SetParamValue(TAG_PSDBTYPEID, strValue);
    }

    public final boolean isPSDBTYPENAMENull() {
        return this.IsParamNull(TAG_PSDBTYPENAME);
    }

    public final String getPSDBTYPENAME() {
        return this.GetParamStringValue(TAG_PSDBTYPENAME, "");
    }

    public final void setPSDBTYPENAME(String strValue) {
        this.SetParamValue(TAG_PSDBTYPENAME, strValue);
    }

    public final boolean isCREATEMANNull() {
        return this.IsParamNull(TAG_CREATEMAN);
    }

    public final String getCREATEMAN() {
        return this.GetParamStringValue(TAG_CREATEMAN, "");
    }

    public final void setCREATEMAN(String strValue) {
        this.SetParamValue(TAG_CREATEMAN, strValue);
    }

    public final boolean isCREATEDATENull() {
        return this.IsParamNull(TAG_CREATEDATE);
    }

    public final Date getCREATEDATE() {
        return this.GetParamDateValue(TAG_CREATEDATE, null);
    }

    public final void setCREATEDATE(Date dtValue) {
        this.SetParamValue(TAG_CREATEDATE, dtValue);
    }

    public final boolean isUPDATEMANNull() {
        return this.IsParamNull(TAG_UPDATEMAN);
    }

    public final String getUPDATEMAN() {
        return this.GetParamStringValue(TAG_UPDATEMAN, "");
    }

    public final void setUPDATEMAN(String strValue) {
        this.SetParamValue(TAG_UPDATEMAN, strValue);
    }

    public final boolean isUPDATEDATENull() {
        return this.IsParamNull(TAG_UPDATEDATE);
    }

    public final Date getUPDATEDATE() {
        return this.GetParamDateValue(TAG_UPDATEDATE, null);
    }

    public final void setUPDATEDATE(Date dtValue) {
        this.SetParamValue(TAG_UPDATEDATE, dtValue);
    }

    public final boolean isMEMONull() {
        return this.IsParamNull(TAG_MEMO);
    }

    public final String getMEMO() {
        return this.GetParamStringValue(TAG_MEMO, "");
    }

    public final void setMEMO(String strValue) {
        this.SetParamValue(TAG_MEMO, strValue);
    }

    public final boolean isTYPEHELPERNull() {
        return this.IsParamNull(TAG_TYPEHELPER);
    }

    public final String getTYPEHELPER() {
        return this.GetParamStringValue(TAG_TYPEHELPER, "");
    }

    public final void setTYPEHELPER(String strValue) {
        this.SetParamValue(TAG_TYPEHELPER, strValue);
    }

    public final boolean isJDBCDRIVERNAMENull() {
        return this.IsParamNull(TAG_JDBCDRIVERNAME);
    }

    public final String getJDBCDRIVERNAME() {
        return this.GetParamStringValue(TAG_JDBCDRIVERNAME, "");
    }

    public final void setJDBCDRIVERNAME(String strValue) {
        this.SetParamValue(TAG_JDBCDRIVERNAME, strValue);
    }

    public final boolean isINSERTSPPUBOBJNull() {
        return this.IsParamNull(TAG_INSERTSPPUBOBJ);
    }

    public final String getINSERTSPPUBOBJ() {
        return this.GetParamStringValue(TAG_INSERTSPPUBOBJ, "");
    }

    public final void setINSERTSPPUBOBJ(String strValue) {
        this.SetParamValue(TAG_INSERTSPPUBOBJ, strValue);
    }

    public final boolean isUPDATESPPUBOBJNull() {
        return this.IsParamNull(TAG_UPDATESPPUBOBJ);
    }

    public final String getUPDATESPPUBOBJ() {
        return this.GetParamStringValue(TAG_UPDATESPPUBOBJ, "");
    }

    public final void setUPDATESPPUBOBJ(String strValue) {
        this.SetParamValue(TAG_UPDATESPPUBOBJ, strValue);
    }

    public final boolean isDELETESPPUBOBJNull() {
        return this.IsParamNull(TAG_DELETESPPUBOBJ);
    }

    public final String getDELETESPPUBOBJ() {
        return this.GetParamStringValue(TAG_DELETESPPUBOBJ, "");
    }

    public final void setDELETESPPUBOBJ(String strValue) {
        this.SetParamValue(TAG_DELETESPPUBOBJ, strValue);
    }

    public final boolean isDEFDTCOLOBJNull() {
        return this.IsParamNull(TAG_DEFDTCOLOBJ);
    }

    public final String getDEFDTCOLOBJ() {
        return this.GetParamStringValue(TAG_DEFDTCOLOBJ, "");
    }

    public final void setDEFDTCOLOBJ(String strValue) {
        this.SetParamValue(TAG_DEFDTCOLOBJ, strValue);
    }

    public final boolean isSYSDBCFGOBJNull() {
        return this.IsParamNull(TAG_SYSDBCFGOBJ);
    }

    public final String getSYSDBCFGOBJ() {
        return this.GetParamStringValue(TAG_SYSDBCFGOBJ, "");
    }

    public final void setSYSDBCFGOBJ(String strValue) {
        this.SetParamValue(TAG_SYSDBCFGOBJ, strValue);
    }

    public final boolean isDEDBCFGOBJNull() {
        return this.IsParamNull(TAG_DEDBCFGOBJ);
    }

    public final String getDEDBCFGOBJ() {
        return this.GetParamStringValue(TAG_DEDBCFGOBJ, "");
    }

    public final void setDEDBCFGOBJ(String strValue) {
        this.SetParamValue(TAG_DEDBCFGOBJ, strValue);
    }

    public final boolean isDEDQPUBOBJNull() {
        return this.IsParamNull(TAG_DEDQPUBOBJ);
    }

    public final String getDEDQPUBOBJ() {
        return this.GetParamStringValue(TAG_DEDQPUBOBJ, "");
    }

    public final void setDEDQPUBOBJ(String strValue) {
        this.SetParamValue(TAG_DEDQPUBOBJ, strValue);
    }

    public final boolean isDEDQENGOBJNull() {
        return this.IsParamNull(TAG_DEDQENGOBJ);
    }

    public final String getDEDQENGOBJ() {
        return this.GetParamStringValue(TAG_DEDQENGOBJ, "");
    }

    public final void setDEDQENGOBJ(String strValue) {
        this.SetParamValue(TAG_DEDQENGOBJ, strValue);
    }

    public final boolean isDEDSPUBOBJNull() {
        return this.IsParamNull(TAG_DEDSPUBOBJ);
    }

    public final String getDEDSPUBOBJ() {
        return this.GetParamStringValue(TAG_DEDSPUBOBJ, "");
    }

    public final void setDEDSPUBOBJ(String strValue) {
        this.SetParamValue(TAG_DEDSPUBOBJ, strValue);
    }

    public final boolean isGETSPPUBOBJNull() {
        return this.IsParamNull(TAG_GETSPPUBOBJ);
    }

    public final String getGETSPPUBOBJ() {
        return this.GetParamStringValue(TAG_GETSPPUBOBJ, "");
    }

    public final void setGETSPPUBOBJ(String strValue) {
        this.SetParamValue(TAG_GETSPPUBOBJ, strValue);
    }

    public final boolean isJDBCDIALECTNull() {
        return this.IsParamNull(TAG_JDBCDIALECT);
    }

    public final String getJDBCDIALECT() {
        return this.GetParamStringValue(TAG_JDBCDIALECT, "");
    }

    public final void setJDBCDIALECT(String strValue) {
        this.SetParamValue(TAG_JDBCDIALECT, strValue);
    }

    public final boolean isHIBDIALECTNull() {
        return this.IsParamNull(TAG_HIBDIALECT);
    }

    public final String getHIBDIALECT() {
        return this.GetParamStringValue(TAG_HIBDIALECT, "");
    }

    public final void setHIBDIALECT(String strValue) {
        this.SetParamValue(TAG_HIBDIALECT, strValue);
    }

    public final boolean isINSTALLPATHNull() {
        return this.IsParamNull(TAG_INSTALLPATH);
    }

    public final String getINSTALLPATH() {
        return this.GetParamStringValue(TAG_INSTALLPATH, "");
    }

    public final void setINSTALLPATH(String strValue) {
        this.SetParamValue(TAG_INSTALLPATH, strValue);
    }

    public final boolean isDBCLIENTPATHNull() {
        return this.IsParamNull(TAG_DBCLIENTPATH);
    }

    public final String getDBCLIENTPATH() {
        return this.GetParamStringValue(TAG_DBCLIENTPATH, "");
    }

    public final void setDBCLIENTPATH(String strValue) {
        this.SetParamValue(TAG_DBCLIENTPATH, strValue);
    }
}

