/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.IS.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class ISDEDataItem
extends BaseDataEntity {
    public static final String TAG_ISDEDATAITEMID = "ISDEDATAITEMID";
    public static final String TAG_ISDEDATAITEMNAME = "ISDEDATAITEMNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_ISITEMTYPE = "ISITEMTYPE";
    public static final String TAG_DENAME = "DENAME";
    public static final String TAG_DEID = "DEID";
    public static final String TAG_INDEXFIELD = "INDEXFIELD";
    public static final String TAG_DESCFIELD = "DESCFIELD";
    public static final String TAG_ISGROUPID = "ISGROUPID";
    public static final String TAG_ISGROUPNAME = "ISGROUPNAME";
    public static final String TAG_LASTINDEXTIME = "LASTINDEXTIME";
    public static final String TAG_DESCFORMAT = "DESCFORMAT";
    public static final String TAG_DESCASHTML = "DESCASHTML";
    public static final String TAG_EXTFIELD = "EXTFIELD";
    public static final String TAG_PAGESIZE = "PAGESIZE";
    public static final String TAG_PAGEORDERINFO = "PAGEORDERINFO";
    public static final String TAG_EXTCOND = "EXTCOND";
    public static final String TAG_LASTINDEXTAG = "LASTINDEXTAG";
    public static final String TAG_INDEXLIMIT = "INDEXLIMIT";
    public static final String TAG_PRIVFORMAT = "PRIVFORMAT";
    public static final String TAG_PRIVFIELD = "PRIVFIELD";

    public String getISDEDATAITEMID() {
        return this.GetParamStringValue(TAG_ISDEDATAITEMID, "");
    }

    public void setISDEDATAITEMID(String strValue) {
        this.SetParamValue(TAG_ISDEDATAITEMID, strValue);
    }

    public String getISDEDATAITEMNAME() {
        return this.GetParamStringValue(TAG_ISDEDATAITEMNAME, "");
    }

    public void setISDEDATAITEMNAME(String strValue) {
        this.SetParamValue(TAG_ISDEDATAITEMNAME, strValue);
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

    public String getISITEMTYPE() {
        return this.GetParamStringValue(TAG_ISITEMTYPE, "");
    }

    public void setISITEMTYPE(String strValue) {
        this.SetParamValue(TAG_ISITEMTYPE, strValue);
    }

    public String getDENAME() {
        return this.GetParamStringValue(TAG_DENAME, "");
    }

    public void setDENAME(String strValue) {
        this.SetParamValue(TAG_DENAME, strValue);
    }

    public String getDEID() {
        return this.GetParamStringValue(TAG_DEID, "");
    }

    public void setDEID(String strValue) {
        this.SetParamValue(TAG_DEID, strValue);
    }

    public String getINDEXFIELD() {
        return this.GetParamStringValue(TAG_INDEXFIELD, "");
    }

    public void setINDEXFIELD(String strValue) {
        this.SetParamValue(TAG_INDEXFIELD, strValue);
    }

    public String getDESCFIELD() {
        return this.GetParamStringValue(TAG_DESCFIELD, "");
    }

    public void setDESCFIELD(String strValue) {
        this.SetParamValue(TAG_DESCFIELD, strValue);
    }

    public String getISGROUPID() {
        return this.GetParamStringValue(TAG_ISGROUPID, "");
    }

    public void setISGROUPID(String strValue) {
        this.SetParamValue(TAG_ISGROUPID, strValue);
    }

    public String getISGROUPNAME() {
        return this.GetParamStringValue(TAG_ISGROUPNAME, "");
    }

    public void setISGROUPNAME(String strValue) {
        this.SetParamValue(TAG_ISGROUPNAME, strValue);
    }

    public Date getLASTINDEXTIME() {
        return this.GetParamDateValue(TAG_LASTINDEXTIME, null);
    }

    public void setLASTINDEXTIME(Date strValue) {
        this.SetParamValue(TAG_LASTINDEXTIME, strValue);
    }

    public void setDESCFORMAT(String strValue) {
        this.SetParamValue(TAG_DESCFORMAT, strValue);
    }

    public boolean getDESCASHTML() {
        return this.GetParamIntValue(TAG_DESCASHTML, 0) == 1;
    }

    public void setDESCASHTML(boolean bValue) {
        this.SetParamValue(TAG_DESCASHTML, bValue ? 1 : 0);
    }

    public String getEXTFIELD() {
        return this.GetParamStringValue(TAG_EXTFIELD, "");
    }

    public void setEXTFIELD(String strValue) {
        this.SetParamValue(TAG_EXTFIELD, strValue);
    }

    public String getDESCFORMAT() {
        return this.GetParamStringValue(TAG_DESCFORMAT, "%1$s");
    }

    public int getPAGESIZE() {
        return this.GetParamIntValue(TAG_PAGESIZE, 500);
    }

    public void setPAGESIZE(int strValue) {
        this.SetParamValue(TAG_PAGESIZE, strValue);
    }

    public String getPAGEORDERINFO() {
        return this.GetParamStringValue(TAG_PAGEORDERINFO, "");
    }

    public void setPAGEORDERINFO(String strValue) {
        this.SetParamValue(TAG_PAGEORDERINFO, strValue);
    }

    public String getEXTCOND() {
        return this.GetParamStringValue(TAG_EXTCOND, "");
    }

    public void setEXTCOND(String strValue) {
        this.SetParamValue(TAG_EXTCOND, strValue);
    }

    public String getLASTINDEXTAG() {
        return this.GetParamStringValue(TAG_LASTINDEXTAG, "");
    }

    public void setLASTINDEXTAG(String strValue) {
        this.SetParamValue(TAG_LASTINDEXTAG, strValue);
    }

    public int getINDEXLIMIT() {
        return this.GetParamIntValue(TAG_INDEXLIMIT, 0);
    }

    public void setINDEXLIMIT(int strValue) {
        this.SetParamValue(TAG_INDEXLIMIT, strValue);
    }

    public String getPRIVFORMAT() {
        return this.GetParamStringValue(TAG_PRIVFORMAT, "");
    }

    public void setPRIVFORMAT(String strValue) {
        this.SetParamValue(TAG_PRIVFORMAT, strValue);
    }

    public String getPRIVFIELD() {
        return this.GetParamStringValue(TAG_PRIVFIELD, "");
    }

    public void setPRIVFIELD(String strValue) {
        this.SetParamValue(TAG_PRIVFIELD, strValue);
    }
}

