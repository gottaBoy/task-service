/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSSFACHandler
extends BaseDataEntity {
    public static final String CTRLTYPE_GRID = "GRID";
    public static final String CTRLTYPE_FORM = "FORM";
    public static final String CTRLTYPE_SEARCHFORM = "SEARCHFORM";
    public static final String CTRLTYPE_DATAVIEW = "DATAVIEW";
    public static final String CTRLTYPE_TREEGRID = "TREEGRID";
    public static final String CTRLTYPE_WFEXPBAR = "WFEXPBAR";
    public static final String TAG_PSSFACHANDLERID = "PSSFACHANDLERID";
    public static final String TAG_PSSFACHANDLERNAME = "PSSFACHANDLERNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSSFID = "PSSFID";
    public static final String TAG_PSSFNAME = "PSSFNAME";
    public static final String TAG_CTRLTYPE = "CTRLTYPE";
    public static final String TAG_HANDLEROBJ = "HANDLEROBJ";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_PSSYSACHANDLERID = "PSSYSACHANDLERID";
    public static final String TAG_PSSYSACHANDLERNAME = "PSSYSACHANDLERNAME";
    public static final String TAG_TEMPMODE = "TEMPMODE";
    public static final String TAG_HANDLEROBJ2 = "HANDLEROBJ2";
    public static final String TAG_HANDLEROBJ3 = "HANDLEROBJ3";
    public static final String TAG_HANDLEROBJ4 = "HANDLEROBJ4";
    public static final String TAG_JITCTRLOBJ = "JITCTRLOBJ";
    public static final String TAG_JITCTRLOBJ2 = "JITCTRLOBJ2";

    public final boolean isPSSFACHANDLERIDNull() {
        return this.IsParamNull(TAG_PSSFACHANDLERID);
    }

    public final String getPSSFACHANDLERID() {
        return this.GetParamStringValue(TAG_PSSFACHANDLERID, "");
    }

    public final void setPSSFACHANDLERID(String strValue) {
        this.SetParamValue(TAG_PSSFACHANDLERID, strValue);
    }

    public final boolean isPSSFACHANDLERNAMENull() {
        return this.IsParamNull(TAG_PSSFACHANDLERNAME);
    }

    public final String getPSSFACHANDLERNAME() {
        return this.GetParamStringValue(TAG_PSSFACHANDLERNAME, "");
    }

    public final void setPSSFACHANDLERNAME(String strValue) {
        this.SetParamValue(TAG_PSSFACHANDLERNAME, strValue);
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

    public final boolean isPSSFIDNull() {
        return this.IsParamNull(TAG_PSSFID);
    }

    public final String getPSSFID() {
        return this.GetParamStringValue(TAG_PSSFID, "");
    }

    public final void setPSSFID(String strValue) {
        this.SetParamValue(TAG_PSSFID, strValue);
    }

    public final boolean isPSSFNAMENull() {
        return this.IsParamNull(TAG_PSSFNAME);
    }

    public final String getPSSFNAME() {
        return this.GetParamStringValue(TAG_PSSFNAME, "");
    }

    public final void setPSSFNAME(String strValue) {
        this.SetParamValue(TAG_PSSFNAME, strValue);
    }

    public final boolean isCTRLTYPENull() {
        return this.IsParamNull(TAG_CTRLTYPE);
    }

    public final String getCTRLTYPE() {
        return this.GetParamStringValue(TAG_CTRLTYPE, "");
    }

    public final void setCTRLTYPE(String strValue) {
        this.SetParamValue(TAG_CTRLTYPE, strValue);
    }

    public final boolean isHANDLEROBJNull() {
        return this.IsParamNull(TAG_HANDLEROBJ);
    }

    public final String getHANDLEROBJ() {
        return this.GetParamStringValue(TAG_HANDLEROBJ, "");
    }

    public final void setHANDLEROBJ(String strValue) {
        this.SetParamValue(TAG_HANDLEROBJ, strValue);
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

    public final boolean isPSSYSACHANDLERIDNull() {
        return this.IsParamNull(TAG_PSSYSACHANDLERID);
    }

    public final String getPSSYSACHANDLERID() {
        return this.GetParamStringValue(TAG_PSSYSACHANDLERID, "");
    }

    public final void setPSSYSACHANDLERID(String strValue) {
        this.SetParamValue(TAG_PSSYSACHANDLERID, strValue);
    }

    public final boolean isPSSYSACHANDLERNAMENull() {
        return this.IsParamNull(TAG_PSSYSACHANDLERNAME);
    }

    public final String getPSSYSACHANDLERNAME() {
        return this.GetParamStringValue(TAG_PSSYSACHANDLERNAME, "");
    }

    public final void setPSSYSACHANDLERNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSACHANDLERNAME, strValue);
    }

    public final boolean isTEMPMODENull() {
        return this.IsParamNull(TAG_TEMPMODE);
    }

    public final int getTEMPMODE() {
        return this.GetParamIntValue(TAG_TEMPMODE, 0);
    }

    public final void setTEMPMODE(int nValue) {
        this.SetParamValue(TAG_TEMPMODE, nValue);
    }

    public final boolean isHANDLEROBJ2Null() {
        return this.IsParamNull(TAG_HANDLEROBJ2);
    }

    public final String getHANDLEROBJ2() {
        return this.GetParamStringValue(TAG_HANDLEROBJ2, "");
    }

    public final void setHANDLEROBJ2(String strValue) {
        this.SetParamValue(TAG_HANDLEROBJ2, strValue);
    }

    public final boolean isHANDLEROBJ3Null() {
        return this.IsParamNull(TAG_HANDLEROBJ3);
    }

    public final String getHANDLEROBJ3() {
        return this.GetParamStringValue(TAG_HANDLEROBJ3, "");
    }

    public final void setHANDLEROBJ3(String strValue) {
        this.SetParamValue(TAG_HANDLEROBJ3, strValue);
    }

    public final boolean isHANDLEROBJ4Null() {
        return this.IsParamNull(TAG_HANDLEROBJ4);
    }

    public final String getHANDLEROBJ4() {
        return this.GetParamStringValue(TAG_HANDLEROBJ4, "");
    }

    public final void setHANDLEROBJ4(String strValue) {
        this.SetParamValue(TAG_HANDLEROBJ4, strValue);
    }

    public final boolean isJITCTRLOBJNull() {
        return this.IsParamNull(TAG_JITCTRLOBJ);
    }

    public final String getJITCTRLOBJ() {
        return this.GetParamStringValue(TAG_JITCTRLOBJ, "");
    }

    public final void setJITCTRLOBJ(String strValue) {
        this.SetParamValue(TAG_JITCTRLOBJ, strValue);
    }

    public final boolean isJITCTRLOBJ2Null() {
        return this.IsParamNull(TAG_JITCTRLOBJ2);
    }

    public final String getJITCTRLOBJ2() {
        return this.GetParamStringValue(TAG_JITCTRLOBJ2, "");
    }

    public final void setJITCTRLOBJ2(String strValue) {
        this.SetParamValue(TAG_JITCTRLOBJ2, strValue);
    }
}

