/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.EAI.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class EAISQL2DECtrl
extends BaseDataEntity {
    public static final String TAG_EAISQL2DECTRLID = "EAISQL2DECTRLID";
    public static final String TAG_EAISQL2DECTRLNAME = "EAISQL2DECTRLNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_DBSTORAGE = "DBSTORAGE";
    public static final String TAG_QUERYSQL = "QUERYSQL";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_TASKENGINE = "TASKENGINE";
    public static final String TAG_TASKTIME = "TASKTIME";
    public static final String TAG_DEACTIONID = "DEACTIONID";
    public static final String TAG_DEACTIONNAME = "DEACTIONNAME";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";
    public static final String TAG_PAGESIZE = "PAGESIZE";
    public static final String TAG_LASTRUNTIME = "LASTRUNTIME";
    public static final String TAG_LASTRUNTAG = "LASTRUNTAG";
    public static final String TAG_LASTRUNTAG2 = "LASTRUNTAG2";
    public static final String TAG_LASTRUNTAG3 = "LASTRUNTAG3";
    public static final String TAG_ORDERINFO = "ORDERINFO";
    public static final String TAG_CONTEXTPARAMS = "CONTEXTPARAMS";
    public static final String TAG_RUNFLAG = "RUNFLAG";

    public final boolean isEAISQL2DECTRLIDNull() {
        return this.IsParamNull(TAG_EAISQL2DECTRLID);
    }

    public final String getEAISQL2DECTRLID() {
        return this.GetParamStringValue(TAG_EAISQL2DECTRLID, "");
    }

    public final void setEAISQL2DECTRLID(String strValue) {
        this.SetParamValue(TAG_EAISQL2DECTRLID, strValue);
    }

    public final boolean isEAISQL2DECTRLNAMENull() {
        return this.IsParamNull(TAG_EAISQL2DECTRLNAME);
    }

    public final String getEAISQL2DECTRLNAME() {
        return this.GetParamStringValue(TAG_EAISQL2DECTRLNAME, "");
    }

    public final void setEAISQL2DECTRLNAME(String strValue) {
        this.SetParamValue(TAG_EAISQL2DECTRLNAME, strValue);
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

    public final boolean isDBSTORAGENull() {
        return this.IsParamNull(TAG_DBSTORAGE);
    }

    public final String getDBSTORAGE() {
        return this.GetParamStringValue(TAG_DBSTORAGE, "");
    }

    public final void setDBSTORAGE(String strValue) {
        this.SetParamValue(TAG_DBSTORAGE, strValue);
    }

    public final boolean isQUERYSQLNull() {
        return this.IsParamNull(TAG_QUERYSQL);
    }

    public final String getQUERYSQL() {
        return this.GetParamStringValue(TAG_QUERYSQL, "");
    }

    public final void setQUERYSQL(String strValue) {
        this.SetParamValue(TAG_QUERYSQL, strValue);
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

    public final boolean isTASKENGINENull() {
        return this.IsParamNull(TAG_TASKENGINE);
    }

    public final String getTASKENGINE() {
        return this.GetParamStringValue(TAG_TASKENGINE, "");
    }

    public final void setTASKENGINE(String strValue) {
        this.SetParamValue(TAG_TASKENGINE, strValue);
    }

    public final boolean isTASKTIMENull() {
        return this.IsParamNull(TAG_TASKTIME);
    }

    public final String getTASKTIME() {
        return this.GetParamStringValue(TAG_TASKTIME, "");
    }

    public final void setTASKTIME(String strValue) {
        this.SetParamValue(TAG_TASKTIME, strValue);
    }

    public final boolean isDEACTIONIDNull() {
        return this.IsParamNull(TAG_DEACTIONID);
    }

    public final String getDEACTIONID() {
        return this.GetParamStringValue(TAG_DEACTIONID, "");
    }

    public final void setDEACTIONID(String strValue) {
        this.SetParamValue(TAG_DEACTIONID, strValue);
    }

    public final boolean isDEACTIONNAMENull() {
        return this.IsParamNull(TAG_DEACTIONNAME);
    }

    public final String getDEACTIONNAME() {
        return this.GetParamStringValue(TAG_DEACTIONNAME, "");
    }

    public final void setDEACTIONNAME(String strValue) {
        this.SetParamValue(TAG_DEACTIONNAME, strValue);
    }

    public final boolean isVALIDFLAGNull() {
        return this.IsParamNull(TAG_VALIDFLAG);
    }

    public final boolean getVALIDFLAG() {
        return this.GetParamIntValue(TAG_VALIDFLAG, 0) == 1;
    }

    public final void setVALIDFLAG(boolean bValue) {
        this.SetParamValue(TAG_VALIDFLAG, bValue ? 1 : 0);
    }

    public final boolean isPAGESIZENull() {
        return this.IsParamNull(TAG_PAGESIZE);
    }

    public final int getPAGESIZE() {
        return this.GetParamIntValue(TAG_PAGESIZE, 0);
    }

    public final void setPAGESIZE(int nValue) {
        this.SetParamValue(TAG_PAGESIZE, nValue);
    }

    public final boolean isLASTRUNTIMENull() {
        return this.IsParamNull(TAG_LASTRUNTIME);
    }

    public final Date getLASTRUNTIME() {
        return this.GetParamDateValue(TAG_LASTRUNTIME, null);
    }

    public final void setLASTRUNTIME(Date dtValue) {
        this.SetParamValue(TAG_LASTRUNTIME, dtValue);
    }

    public final boolean isLASTRUNTAGNull() {
        return this.IsParamNull(TAG_LASTRUNTAG);
    }

    public final String getLASTRUNTAG() {
        return this.GetParamStringValue(TAG_LASTRUNTAG, "");
    }

    public final void setLASTRUNTAG(String strValue) {
        this.SetParamValue(TAG_LASTRUNTAG, strValue);
    }

    public final boolean isLASTRUNTAG2Null() {
        return this.IsParamNull(TAG_LASTRUNTAG2);
    }

    public final Date getLASTRUNTAG2() {
        return this.GetParamDateValue(TAG_LASTRUNTAG2, null);
    }

    public final void setLASTRUNTAG2(Date dtValue) {
        this.SetParamValue(TAG_LASTRUNTAG2, dtValue);
    }

    public final boolean isLASTRUNTAG3Null() {
        return this.IsParamNull(TAG_LASTRUNTAG3);
    }

    public final int getLASTRUNTAG3() {
        return this.GetParamIntValue(TAG_LASTRUNTAG3, 0);
    }

    public final void setLASTRUNTAG3(int nValue) {
        this.SetParamValue(TAG_LASTRUNTAG3, nValue);
    }

    public final boolean isORDERINFONull() {
        return this.IsParamNull(TAG_ORDERINFO);
    }

    public final String getORDERINFO() {
        return this.GetParamStringValue(TAG_ORDERINFO, "");
    }

    public final void setORDERINFO(String strValue) {
        this.SetParamValue(TAG_ORDERINFO, strValue);
    }

    public final boolean isCONTEXTPARAMSNull() {
        return this.IsParamNull(TAG_CONTEXTPARAMS);
    }

    public final String getCONTEXTPARAMS() {
        return this.GetParamStringValue(TAG_CONTEXTPARAMS, "");
    }

    public final void setCONTEXTPARAMS(String strValue) {
        this.SetParamValue(TAG_CONTEXTPARAMS, strValue);
    }

    public final boolean isRUNFLAGNull() {
        return this.IsParamNull(TAG_RUNFLAG);
    }

    public final boolean getRUNFLAG() {
        return this.GetParamIntValue(TAG_RUNFLAG, 0) == 1;
    }

    public final void setRUNFLAG(boolean bValue) {
        this.SetParamValue(TAG_RUNFLAG, bValue ? 1 : 0);
    }
}

