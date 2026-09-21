/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.IS.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class ISDEDocItem
extends BaseDataEntity {
    public static final String TAG_ISDEDOCITEMID = "ISDEDOCITEMID";
    public static final String TAG_ISDEDOCITEMNAME = "ISDEDOCITEMNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_ISITEMTYPE = "ISITEMTYPE";
    public static final String TAG_ISGROUPID = "ISGROUPID";
    public static final String TAG_ISGROUPNAME = "ISGROUPNAME";
    public static final String TAG_LASTINDEXTIME = "LASTINDEXTIME";
    public static final String TAG_LASTINDEXTAG = "LASTINDEXTAG";
    public static final String TAG_INDEXLIMIT = "INDEXLIMIT";
    public static final String TAG_DEID = "DEID";
    public static final String TAG_DENAME = "DENAME";
    public static final String TAG_ISFOLDERID = "ISFOLDERID";
    public static final String TAG_ISFOLDERNAME = "ISFOLDERNAME";
    public static final String TAG_PRIVFIELD = "PRIVFIELD";
    public static final String TAG_PAGESIZE = "PAGESIZE";
    public static final String TAG_EXTCOND = "EXTCOND";
    public static final String TAG_PRIVFORMAT = "PRIVFORMAT";
    public static final String TAG_PATHFIELD = "PATHFIELD";
    public static final String TAG_PAGEORDERINFO = "PAGEORDERINFO";
    public static final String TAG_EXTFIELD = "EXTFIELD";

    public boolean isISDEDOCITEMIDNull() {
        return this.IsParamNull(TAG_ISDEDOCITEMID);
    }

    public String getISDEDOCITEMID() {
        return this.GetParamStringValue(TAG_ISDEDOCITEMID, "");
    }

    public void setISDEDOCITEMID(String strValue) {
        this.SetParamValue(TAG_ISDEDOCITEMID, strValue);
    }

    public boolean isISDEDOCITEMNAMENull() {
        return this.IsParamNull(TAG_ISDEDOCITEMNAME);
    }

    public String getISDEDOCITEMNAME() {
        return this.GetParamStringValue(TAG_ISDEDOCITEMNAME, "");
    }

    public void setISDEDOCITEMNAME(String strValue) {
        this.SetParamValue(TAG_ISDEDOCITEMNAME, strValue);
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

    public boolean isISITEMTYPENull() {
        return this.IsParamNull(TAG_ISITEMTYPE);
    }

    public String getISITEMTYPE() {
        return this.GetParamStringValue(TAG_ISITEMTYPE, "");
    }

    public void setISITEMTYPE(String strValue) {
        this.SetParamValue(TAG_ISITEMTYPE, strValue);
    }

    public boolean isISGROUPIDNull() {
        return this.IsParamNull(TAG_ISGROUPID);
    }

    public String getISGROUPID() {
        return this.GetParamStringValue(TAG_ISGROUPID, "");
    }

    public void setISGROUPID(String strValue) {
        this.SetParamValue(TAG_ISGROUPID, strValue);
    }

    public boolean isISGROUPNAMENull() {
        return this.IsParamNull(TAG_ISGROUPNAME);
    }

    public String getISGROUPNAME() {
        return this.GetParamStringValue(TAG_ISGROUPNAME, "");
    }

    public void setISGROUPNAME(String strValue) {
        this.SetParamValue(TAG_ISGROUPNAME, strValue);
    }

    public boolean isLASTINDEXTIMENull() {
        return this.IsParamNull(TAG_LASTINDEXTIME);
    }

    public Date getLASTINDEXTIME() {
        return this.GetParamDateValue(TAG_LASTINDEXTIME, null);
    }

    public void setLASTINDEXTIME(Date strValue) {
        this.SetParamValue(TAG_LASTINDEXTIME, strValue);
    }

    public boolean isLASTINDEXTAGNull() {
        return this.IsParamNull(TAG_LASTINDEXTAG);
    }

    public String getLASTINDEXTAG() {
        return this.GetParamStringValue(TAG_LASTINDEXTAG, "");
    }

    public void setLASTINDEXTAG(String strValue) {
        this.SetParamValue(TAG_LASTINDEXTAG, strValue);
    }

    public boolean isINDEXLIMITNull() {
        return this.IsParamNull(TAG_INDEXLIMIT);
    }

    public int getINDEXLIMIT() {
        return this.GetParamIntValue(TAG_INDEXLIMIT, 0);
    }

    public void setINDEXLIMIT(int strValue) {
        this.SetParamValue(TAG_INDEXLIMIT, strValue);
    }

    public boolean isDEIDNull() {
        return this.IsParamNull(TAG_DEID);
    }

    public String getDEID() {
        return this.GetParamStringValue(TAG_DEID, "");
    }

    public void setDEID(String strValue) {
        this.SetParamValue(TAG_DEID, strValue);
    }

    public boolean isDENAMENull() {
        return this.IsParamNull(TAG_DENAME);
    }

    public String getDENAME() {
        return this.GetParamStringValue(TAG_DENAME, "");
    }

    public void setDENAME(String strValue) {
        this.SetParamValue(TAG_DENAME, strValue);
    }

    public boolean isISFOLDERIDNull() {
        return this.IsParamNull(TAG_ISFOLDERID);
    }

    public String getISFOLDERID() {
        return this.GetParamStringValue(TAG_ISFOLDERID, "");
    }

    public void setISFOLDERID(String strValue) {
        this.SetParamValue(TAG_ISFOLDERID, strValue);
    }

    public boolean isISFOLDERNAMENull() {
        return this.IsParamNull(TAG_ISFOLDERNAME);
    }

    public String getISFOLDERNAME() {
        return this.GetParamStringValue(TAG_ISFOLDERNAME, "");
    }

    public void setISFOLDERNAME(String strValue) {
        this.SetParamValue(TAG_ISFOLDERNAME, strValue);
    }

    public boolean isPRIVFIELDNull() {
        return this.IsParamNull(TAG_PRIVFIELD);
    }

    public String getPRIVFIELD() {
        return this.GetParamStringValue(TAG_PRIVFIELD, "");
    }

    public void setPRIVFIELD(String strValue) {
        this.SetParamValue(TAG_PRIVFIELD, strValue);
    }

    public boolean isPAGESIZENull() {
        return this.IsParamNull(TAG_PAGESIZE);
    }

    public int getPAGESIZE() {
        return this.GetParamIntValue(TAG_PAGESIZE, 0);
    }

    public void setPAGESIZE(int strValue) {
        this.SetParamValue(TAG_PAGESIZE, strValue);
    }

    public boolean isEXTCONDNull() {
        return this.IsParamNull(TAG_EXTCOND);
    }

    public String getEXTCOND() {
        return this.GetParamStringValue(TAG_EXTCOND, "");
    }

    public void setEXTCOND(String strValue) {
        this.SetParamValue(TAG_EXTCOND, strValue);
    }

    public boolean isPRIVFORMATNull() {
        return this.IsParamNull(TAG_PRIVFORMAT);
    }

    public String getPRIVFORMAT() {
        return this.GetParamStringValue(TAG_PRIVFORMAT, "");
    }

    public void setPRIVFORMAT(String strValue) {
        this.SetParamValue(TAG_PRIVFORMAT, strValue);
    }

    public boolean isPATHFIELDNull() {
        return this.IsParamNull(TAG_PATHFIELD);
    }

    public String getPATHFIELD() {
        return this.GetParamStringValue(TAG_PATHFIELD, "");
    }

    public void setPATHFIELD(String strValue) {
        this.SetParamValue(TAG_PATHFIELD, strValue);
    }

    public boolean isPAGEORDERINFONull() {
        return this.IsParamNull(TAG_PAGEORDERINFO);
    }

    public String getPAGEORDERINFO() {
        return this.GetParamStringValue(TAG_PAGEORDERINFO, "");
    }

    public void setPAGEORDERINFO(String strValue) {
        this.SetParamValue(TAG_PAGEORDERINFO, strValue);
    }

    public boolean isEXTFIELDNull() {
        return this.IsParamNull(TAG_EXTFIELD);
    }

    public String getEXTFIELD() {
        return this.GetParamStringValue(TAG_EXTFIELD, "");
    }

    public void setEXTFIELD(String strValue) {
        this.SetParamValue(TAG_EXTFIELD, strValue);
    }
}

