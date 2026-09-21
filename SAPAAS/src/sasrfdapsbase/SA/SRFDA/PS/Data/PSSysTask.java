/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSSysTask
extends BaseDataEntity {
    public static final int TASKTYPE_10 = 10;
    public static final int TASKTYPE_20 = 20;
    public static final int TASKTYPE_30 = 30;
    public static final int TASKTYPE_40 = 40;
    public static final int TASKTYPE_50 = 50;
    public static final String TAG_PSSYSTASKID = "PSSYSTASKID";
    public static final String TAG_PSSYSTASKNAME = "PSSYSTASKNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSSYSTEMID = "PSSYSTEMID";
    public static final String TAG_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String TAG_TODOTASKINFO = "TODOTASKINFO";
    public static final String TAG_PSOBJID = "PSOBJID";
    public static final String TAG_PSOBJNAME = "PSOBJNAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_IMPORTANCEFLAG = "IMPORTANCEFLAG";
    public static final String TAG_PSSYSREQITEMID = "PSSYSREQITEMID";
    public static final String TAG_PSSYSREQITEMNAME = "PSSYSREQITEMNAME";
    public static final String TAG_PSDEID = "PSDEID";
    public static final String TAG_PSDENAME = "PSDENAME";
    public static final String TAG_PSSYSAPPID = "PSSYSAPPID";
    public static final String TAG_PSSYSAPPNAME = "PSSYSAPPNAME";
    public static final String TAG_MODELTYPEID = "MODELTYPEID";
    public static final String TAG_MODELTYPENAME = "MODELTYPENAME";
    public static final String TAG_PSSYSTASKDATASCNT = "PSSYSTASKDATASCNT";
    public static final String TAG_FINISHFLAG = "FINISHFLAG";
    public static final String TAG_TASKTYPE = "TASKTYPE";
    public static final String TAG_TARGET = "TARGET";

    public final boolean isPSSYSTASKIDNull() {
        return this.IsParamNull(TAG_PSSYSTASKID);
    }

    public final String getPSSYSTASKID() {
        return this.GetParamStringValue(TAG_PSSYSTASKID, "");
    }

    public final void setPSSYSTASKID(String strValue) {
        this.SetParamValue(TAG_PSSYSTASKID, strValue);
    }

    public final boolean isPSSYSTASKNAMENull() {
        return this.IsParamNull(TAG_PSSYSTASKNAME);
    }

    public final String getPSSYSTASKNAME() {
        return this.GetParamStringValue(TAG_PSSYSTASKNAME, "");
    }

    public final void setPSSYSTASKNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSTASKNAME, strValue);
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

    public final boolean isPSSYSTEMIDNull() {
        return this.IsParamNull(TAG_PSSYSTEMID);
    }

    public final String getPSSYSTEMID() {
        return this.GetParamStringValue(TAG_PSSYSTEMID, "");
    }

    public final void setPSSYSTEMID(String strValue) {
        this.SetParamValue(TAG_PSSYSTEMID, strValue);
    }

    public final boolean isPSSYSTEMNAMENull() {
        return this.IsParamNull(TAG_PSSYSTEMNAME);
    }

    public final String getPSSYSTEMNAME() {
        return this.GetParamStringValue(TAG_PSSYSTEMNAME, "");
    }

    public final void setPSSYSTEMNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSTEMNAME, strValue);
    }

    public final boolean isTODOTASKINFONull() {
        return this.IsParamNull(TAG_TODOTASKINFO);
    }

    public final String getTODOTASKINFO() {
        return this.GetParamStringValue(TAG_TODOTASKINFO, "");
    }

    public final void setTODOTASKINFO(String strValue) {
        this.SetParamValue(TAG_TODOTASKINFO, strValue);
    }

    public final boolean isPSOBJIDNull() {
        return this.IsParamNull(TAG_PSOBJID);
    }

    public final String getPSOBJID() {
        return this.GetParamStringValue(TAG_PSOBJID, "");
    }

    public final void setPSOBJID(String strValue) {
        this.SetParamValue(TAG_PSOBJID, strValue);
    }

    public final boolean isPSOBJNAMENull() {
        return this.IsParamNull(TAG_PSOBJNAME);
    }

    public final String getPSOBJNAME() {
        return this.GetParamStringValue(TAG_PSOBJNAME, "");
    }

    public final void setPSOBJNAME(String strValue) {
        this.SetParamValue(TAG_PSOBJNAME, strValue);
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

    public final boolean isIMPORTANCEFLAGNull() {
        return this.IsParamNull(TAG_IMPORTANCEFLAG);
    }

    public final boolean getIMPORTANCEFLAG() {
        return this.GetParamIntValue(TAG_IMPORTANCEFLAG, 0) == 1;
    }

    public final void setIMPORTANCEFLAG(boolean bValue) {
        this.SetParamValue(TAG_IMPORTANCEFLAG, bValue ? 1 : 0);
    }

    public final boolean isPSSYSREQITEMIDNull() {
        return this.IsParamNull(TAG_PSSYSREQITEMID);
    }

    public final String getPSSYSREQITEMID() {
        return this.GetParamStringValue(TAG_PSSYSREQITEMID, "");
    }

    public final void setPSSYSREQITEMID(String strValue) {
        this.SetParamValue(TAG_PSSYSREQITEMID, strValue);
    }

    public final boolean isPSSYSREQITEMNAMENull() {
        return this.IsParamNull(TAG_PSSYSREQITEMNAME);
    }

    public final String getPSSYSREQITEMNAME() {
        return this.GetParamStringValue(TAG_PSSYSREQITEMNAME, "");
    }

    public final void setPSSYSREQITEMNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSREQITEMNAME, strValue);
    }

    public final boolean isPSDEIDNull() {
        return this.IsParamNull(TAG_PSDEID);
    }

    public final String getPSDEID() {
        return this.GetParamStringValue(TAG_PSDEID, "");
    }

    public final void setPSDEID(String strValue) {
        this.SetParamValue(TAG_PSDEID, strValue);
    }

    public final boolean isPSDENAMENull() {
        return this.IsParamNull(TAG_PSDENAME);
    }

    public final String getPSDENAME() {
        return this.GetParamStringValue(TAG_PSDENAME, "");
    }

    public final void setPSDENAME(String strValue) {
        this.SetParamValue(TAG_PSDENAME, strValue);
    }

    public final boolean isPSSYSAPPIDNull() {
        return this.IsParamNull(TAG_PSSYSAPPID);
    }

    public final String getPSSYSAPPID() {
        return this.GetParamStringValue(TAG_PSSYSAPPID, "");
    }

    public final void setPSSYSAPPID(String strValue) {
        this.SetParamValue(TAG_PSSYSAPPID, strValue);
    }

    public final boolean isPSSYSAPPNAMENull() {
        return this.IsParamNull(TAG_PSSYSAPPNAME);
    }

    public final String getPSSYSAPPNAME() {
        return this.GetParamStringValue(TAG_PSSYSAPPNAME, "");
    }

    public final void setPSSYSAPPNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSAPPNAME, strValue);
    }

    public final boolean isMODELTYPEIDNull() {
        return this.IsParamNull(TAG_MODELTYPEID);
    }

    public final String getMODELTYPEID() {
        return this.GetParamStringValue(TAG_MODELTYPEID, "");
    }

    public final void setMODELTYPEID(String strValue) {
        this.SetParamValue(TAG_MODELTYPEID, strValue);
    }

    public final boolean isMODELTYPENAMENull() {
        return this.IsParamNull(TAG_MODELTYPENAME);
    }

    public final String getMODELTYPENAME() {
        return this.GetParamStringValue(TAG_MODELTYPENAME, "");
    }

    public final void setMODELTYPENAME(String strValue) {
        this.SetParamValue(TAG_MODELTYPENAME, strValue);
    }

    public final boolean isPSSYSTASKDATASCNTNull() {
        return this.IsParamNull(TAG_PSSYSTASKDATASCNT);
    }

    public final int getPSSYSTASKDATASCNT() {
        return this.GetParamIntValue(TAG_PSSYSTASKDATASCNT, 0);
    }

    public final void setPSSYSTASKDATASCNT(int nValue) {
        this.SetParamValue(TAG_PSSYSTASKDATASCNT, nValue);
    }

    public final boolean isFINISHFLAGNull() {
        return this.IsParamNull(TAG_FINISHFLAG);
    }

    public final boolean getFINISHFLAG() {
        return this.GetParamIntValue(TAG_FINISHFLAG, 0) == 1;
    }

    public final void setFINISHFLAG(boolean bValue) {
        this.SetParamValue(TAG_FINISHFLAG, bValue ? 1 : 0);
    }

    public final boolean isTASKTYPENull() {
        return this.IsParamNull(TAG_TASKTYPE);
    }

    public final int getTASKTYPE() {
        return this.GetParamIntValue(TAG_TASKTYPE, 0);
    }

    public final void setTASKTYPE(int nValue) {
        this.SetParamValue(TAG_TASKTYPE, nValue);
    }

    public final boolean isTARGETNull() {
        return this.IsParamNull(TAG_TARGET);
    }

    public final String getTARGET() {
        return this.GetParamStringValue(TAG_TARGET, "");
    }

    public final void setTARGET(String strValue) {
        this.SetParamValue(TAG_TARGET, strValue);
    }
}

