/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.entity;

import java.util.Date;
import net.ibizsys.model.entity.BaseDataEntity;

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
        return this.isParamNull(TAG_PSDBTYPEID);
    }

    public final String getPSDBTYPEID() {
        return this.getParamStringValue(TAG_PSDBTYPEID, "");
    }

    public final void setPSDBTYPEID(String strValue) {
        this.setParamValue(TAG_PSDBTYPEID, strValue);
    }

    public final boolean isPSDBTYPENAMENull() {
        return this.isParamNull(TAG_PSDBTYPENAME);
    }

    public final String getPSDBTYPENAME() {
        return this.getParamStringValue(TAG_PSDBTYPENAME, "");
    }

    public final void setPSDBTYPENAME(String strValue) {
        this.setParamValue(TAG_PSDBTYPENAME, strValue);
    }

    public final boolean isCREATEMANNull() {
        return this.isParamNull(TAG_CREATEMAN);
    }

    public final String getCREATEMAN() {
        return this.getParamStringValue(TAG_CREATEMAN, "");
    }

    public final void setCREATEMAN(String strValue) {
        this.setParamValue(TAG_CREATEMAN, strValue);
    }

    public final boolean isCREATEDATENull() {
        return this.isParamNull(TAG_CREATEDATE);
    }

    public final Date getCREATEDATE() {
        return this.getParamDateValue(TAG_CREATEDATE, null);
    }

    public final void setCREATEDATE(Date dtValue) {
        this.setParamValue(TAG_CREATEDATE, dtValue);
    }

    public final boolean isUPDATEMANNull() {
        return this.isParamNull(TAG_UPDATEMAN);
    }

    public final String getUPDATEMAN() {
        return this.getParamStringValue(TAG_UPDATEMAN, "");
    }

    public final void setUPDATEMAN(String strValue) {
        this.setParamValue(TAG_UPDATEMAN, strValue);
    }

    public final boolean isUPDATEDATENull() {
        return this.isParamNull(TAG_UPDATEDATE);
    }

    public final Date getUPDATEDATE() {
        return this.getParamDateValue(TAG_UPDATEDATE, null);
    }

    public final void setUPDATEDATE(Date dtValue) {
        this.setParamValue(TAG_UPDATEDATE, dtValue);
    }

    public final boolean isMEMONull() {
        return this.isParamNull(TAG_MEMO);
    }

    public final String getMEMO() {
        return this.getParamStringValue(TAG_MEMO, "");
    }

    public final void setMEMO(String strValue) {
        this.setParamValue(TAG_MEMO, strValue);
    }

    public final boolean isTYPEHELPERNull() {
        return this.isParamNull(TAG_TYPEHELPER);
    }

    public final String getTYPEHELPER() {
        return this.getParamStringValue(TAG_TYPEHELPER, "");
    }

    public final void setTYPEHELPER(String strValue) {
        this.setParamValue(TAG_TYPEHELPER, strValue);
    }

    public final boolean isJDBCDRIVERNAMENull() {
        return this.isParamNull(TAG_JDBCDRIVERNAME);
    }

    public final String getJDBCDRIVERNAME() {
        return this.getParamStringValue(TAG_JDBCDRIVERNAME, "");
    }

    public final void setJDBCDRIVERNAME(String strValue) {
        this.setParamValue(TAG_JDBCDRIVERNAME, strValue);
    }

    public final boolean isINSERTSPPUBOBJNull() {
        return this.isParamNull(TAG_INSERTSPPUBOBJ);
    }

    public final String getINSERTSPPUBOBJ() {
        return this.getParamStringValue(TAG_INSERTSPPUBOBJ, "");
    }

    public final void setINSERTSPPUBOBJ(String strValue) {
        this.setParamValue(TAG_INSERTSPPUBOBJ, strValue);
    }

    public final boolean isUPDATESPPUBOBJNull() {
        return this.isParamNull(TAG_UPDATESPPUBOBJ);
    }

    public final String getUPDATESPPUBOBJ() {
        return this.getParamStringValue(TAG_UPDATESPPUBOBJ, "");
    }

    public final void setUPDATESPPUBOBJ(String strValue) {
        this.setParamValue(TAG_UPDATESPPUBOBJ, strValue);
    }

    public final boolean isDELETESPPUBOBJNull() {
        return this.isParamNull(TAG_DELETESPPUBOBJ);
    }

    public final String getDELETESPPUBOBJ() {
        return this.getParamStringValue(TAG_DELETESPPUBOBJ, "");
    }

    public final void setDELETESPPUBOBJ(String strValue) {
        this.setParamValue(TAG_DELETESPPUBOBJ, strValue);
    }

    public final boolean isDEFDTCOLOBJNull() {
        return this.isParamNull(TAG_DEFDTCOLOBJ);
    }

    public final String getDEFDTCOLOBJ() {
        return this.getParamStringValue(TAG_DEFDTCOLOBJ, "");
    }

    public final void setDEFDTCOLOBJ(String strValue) {
        this.setParamValue(TAG_DEFDTCOLOBJ, strValue);
    }

    public final boolean isSYSDBCFGOBJNull() {
        return this.isParamNull(TAG_SYSDBCFGOBJ);
    }

    public final String getSYSDBCFGOBJ() {
        return this.getParamStringValue(TAG_SYSDBCFGOBJ, "");
    }

    public final void setSYSDBCFGOBJ(String strValue) {
        this.setParamValue(TAG_SYSDBCFGOBJ, strValue);
    }

    public final boolean isDEDBCFGOBJNull() {
        return this.isParamNull(TAG_DEDBCFGOBJ);
    }

    public final String getDEDBCFGOBJ() {
        return this.getParamStringValue(TAG_DEDBCFGOBJ, "");
    }

    public final void setDEDBCFGOBJ(String strValue) {
        this.setParamValue(TAG_DEDBCFGOBJ, strValue);
    }

    public final boolean isDEDQPUBOBJNull() {
        return this.isParamNull(TAG_DEDQPUBOBJ);
    }

    public final String getDEDQPUBOBJ() {
        return this.getParamStringValue(TAG_DEDQPUBOBJ, "");
    }

    public final void setDEDQPUBOBJ(String strValue) {
        this.setParamValue(TAG_DEDQPUBOBJ, strValue);
    }

    public final boolean isDEDQENGOBJNull() {
        return this.isParamNull(TAG_DEDQENGOBJ);
    }

    public final String getDEDQENGOBJ() {
        return this.getParamStringValue(TAG_DEDQENGOBJ, "");
    }

    public final void setDEDQENGOBJ(String strValue) {
        this.setParamValue(TAG_DEDQENGOBJ, strValue);
    }

    public final boolean isDEDSPUBOBJNull() {
        return this.isParamNull(TAG_DEDSPUBOBJ);
    }

    public final String getDEDSPUBOBJ() {
        return this.getParamStringValue(TAG_DEDSPUBOBJ, "");
    }

    public final void setDEDSPUBOBJ(String strValue) {
        this.setParamValue(TAG_DEDSPUBOBJ, strValue);
    }

    public final boolean isGETSPPUBOBJNull() {
        return this.isParamNull(TAG_GETSPPUBOBJ);
    }

    public final String getGETSPPUBOBJ() {
        return this.getParamStringValue(TAG_GETSPPUBOBJ, "");
    }

    public final void setGETSPPUBOBJ(String strValue) {
        this.setParamValue(TAG_GETSPPUBOBJ, strValue);
    }

    public final boolean isJDBCDIALECTNull() {
        return this.isParamNull(TAG_JDBCDIALECT);
    }

    public final String getJDBCDIALECT() {
        return this.getParamStringValue(TAG_JDBCDIALECT, "");
    }

    public final void setJDBCDIALECT(String strValue) {
        this.setParamValue(TAG_JDBCDIALECT, strValue);
    }

    public final boolean isHIBDIALECTNull() {
        return this.isParamNull(TAG_HIBDIALECT);
    }

    public final String getHIBDIALECT() {
        return this.getParamStringValue(TAG_HIBDIALECT, "");
    }

    public final void setHIBDIALECT(String strValue) {
        this.setParamValue(TAG_HIBDIALECT, strValue);
    }

    public final boolean isINSTALLPATHNull() {
        return this.isParamNull(TAG_INSTALLPATH);
    }

    public final String getINSTALLPATH() {
        return this.getParamStringValue(TAG_INSTALLPATH, "");
    }

    public final void setINSTALLPATH(String strValue) {
        this.setParamValue(TAG_INSTALLPATH, strValue);
    }

    public final boolean isDBCLIENTPATHNull() {
        return this.isParamNull(TAG_DBCLIENTPATH);
    }

    public final String getDBCLIENTPATH() {
        return this.getParamStringValue(TAG_DBCLIENTPATH, "");
    }

    public final void setDBCLIENTPATH(String strValue) {
        this.setParamValue(TAG_DBCLIENTPATH, strValue);
    }
}

