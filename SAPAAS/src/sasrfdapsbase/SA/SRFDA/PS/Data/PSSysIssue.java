/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSSysIssue
extends BaseDataEntity {
    public static final String ISSUESTATE_CREATED = "CREATED";
    public static final String ISSUESTATE_SOLVED = "SOLVED";
    public static final String ISSUESTATE_CANCELLED = "CANCELLED";
    public static final String ISSUETYPE_WARN = "WARN";
    public static final String ISSUETYPE_ERROR = "ERROR";
    public static final String ISSUETYPE_CRITICAL = "CRITICAL";
    public static final String OBJTYPE_CREATEDATAENTITY = "CREATEDATAENTITY";
    public static final String OBJTYPE_UPDATEDATAENTITY = "UPDATEDATAENTITY";
    public static final String OBJTYPE_DELETEDATAENTITY = "DELETEDATAENTITY";
    public static final String OBJTYPE_CREATEDEFIELD = "CREATEDEFIELD";
    public static final String OBJTYPE_UPDATEDEFIELD = "UPDATEDEFIELD";
    public static final String OBJTYPE_DELETEDEFIELD = "DELETEDEFIELD";
    public static final String TAG_PSSYSISSUEID = "PSSYSISSUEID";
    public static final String TAG_PSSYSISSUENAME = "PSSYSISSUENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSSYSTEMID = "PSSYSTEMID";
    public static final String TAG_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String TAG_PSDEID = "PSDEID";
    public static final String TAG_PSDENAME = "PSDENAME";
    public static final String TAG_PSSYSAPPID = "PSSYSAPPID";
    public static final String TAG_PSSYSAPPNAME = "PSSYSAPPNAME";
    public static final String TAG_ISSUESTATE = "ISSUESTATE";
    public static final String TAG_ISSUEINFO = "ISSUEINFO";
    public static final String TAG_FINISHDATE = "FINISHDATE";
    public static final String TAG_CANCELDATE = "CANCELDATE";
    public static final String TAG_PSSYSISSUETYPEID = "PSSYSISSUETYPEID";
    public static final String TAG_PSSYSISSUETYPENAME = "PSSYSISSUETYPENAME";
    public static final String TAG_ISSUETYPE = "ISSUETYPE";
    public static final String TAG_OBJTYPE = "OBJTYPE";
    public static final String TAG_PSOBJNAME = "PSOBJNAME";
    public static final String TAG_PSOBJID = "PSOBJID";
    public static final String TAG_PSOBJ2ID = "PSOBJ2ID";
    public static final String TAG_PSOBJ2NAME = "PSOBJ2NAME";

    public final boolean isPSSYSISSUEIDNull() {
        return this.IsParamNull(TAG_PSSYSISSUEID);
    }

    public final String getPSSYSISSUEID() {
        return this.GetParamStringValue(TAG_PSSYSISSUEID, "");
    }

    public final void setPSSYSISSUEID(String strValue) {
        this.SetParamValue(TAG_PSSYSISSUEID, strValue);
    }

    public final boolean isPSSYSISSUENAMENull() {
        return this.IsParamNull(TAG_PSSYSISSUENAME);
    }

    public final String getPSSYSISSUENAME() {
        return this.GetParamStringValue(TAG_PSSYSISSUENAME, "");
    }

    public final void setPSSYSISSUENAME(String strValue) {
        this.SetParamValue(TAG_PSSYSISSUENAME, strValue);
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

    public final boolean isISSUESTATENull() {
        return this.IsParamNull(TAG_ISSUESTATE);
    }

    public final String getISSUESTATE() {
        return this.GetParamStringValue(TAG_ISSUESTATE, "");
    }

    public final void setISSUESTATE(String strValue) {
        this.SetParamValue(TAG_ISSUESTATE, strValue);
    }

    public final boolean isISSUEINFONull() {
        return this.IsParamNull(TAG_ISSUEINFO);
    }

    public final String getISSUEINFO() {
        return this.GetParamStringValue(TAG_ISSUEINFO, "");
    }

    public final void setISSUEINFO(String strValue) {
        this.SetParamValue(TAG_ISSUEINFO, strValue);
    }

    public final boolean isFINISHDATENull() {
        return this.IsParamNull(TAG_FINISHDATE);
    }

    public final Date getFINISHDATE() {
        return this.GetParamDateValue(TAG_FINISHDATE, null);
    }

    public final void setFINISHDATE(Date dtValue) {
        this.SetParamValue(TAG_FINISHDATE, dtValue);
    }

    public final boolean isCANCELDATENull() {
        return this.IsParamNull(TAG_CANCELDATE);
    }

    public final Date getCANCELDATE() {
        return this.GetParamDateValue(TAG_CANCELDATE, null);
    }

    public final void setCANCELDATE(Date dtValue) {
        this.SetParamValue(TAG_CANCELDATE, dtValue);
    }

    public final boolean isPSSYSISSUETYPEIDNull() {
        return this.IsParamNull(TAG_PSSYSISSUETYPEID);
    }

    public final String getPSSYSISSUETYPEID() {
        return this.GetParamStringValue(TAG_PSSYSISSUETYPEID, "");
    }

    public final void setPSSYSISSUETYPEID(String strValue) {
        this.SetParamValue(TAG_PSSYSISSUETYPEID, strValue);
    }

    public final boolean isPSSYSISSUETYPENAMENull() {
        return this.IsParamNull(TAG_PSSYSISSUETYPENAME);
    }

    public final String getPSSYSISSUETYPENAME() {
        return this.GetParamStringValue(TAG_PSSYSISSUETYPENAME, "");
    }

    public final void setPSSYSISSUETYPENAME(String strValue) {
        this.SetParamValue(TAG_PSSYSISSUETYPENAME, strValue);
    }

    public final boolean isISSUETYPENull() {
        return this.IsParamNull(TAG_ISSUETYPE);
    }

    public final String getISSUETYPE() {
        return this.GetParamStringValue(TAG_ISSUETYPE, "");
    }

    public final void setISSUETYPE(String strValue) {
        this.SetParamValue(TAG_ISSUETYPE, strValue);
    }

    public final boolean isOBJTYPENull() {
        return this.IsParamNull(TAG_OBJTYPE);
    }

    public final String getOBJTYPE() {
        return this.GetParamStringValue(TAG_OBJTYPE, "");
    }

    public final void setOBJTYPE(String strValue) {
        this.SetParamValue(TAG_OBJTYPE, strValue);
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

    public final boolean isPSOBJIDNull() {
        return this.IsParamNull(TAG_PSOBJID);
    }

    public final String getPSOBJID() {
        return this.GetParamStringValue(TAG_PSOBJID, "");
    }

    public final void setPSOBJID(String strValue) {
        this.SetParamValue(TAG_PSOBJID, strValue);
    }

    public final boolean isPSOBJ2IDNull() {
        return this.IsParamNull(TAG_PSOBJ2ID);
    }

    public final String getPSOBJ2ID() {
        return this.GetParamStringValue(TAG_PSOBJ2ID, "");
    }

    public final void setPSOBJ2ID(String strValue) {
        this.SetParamValue(TAG_PSOBJ2ID, strValue);
    }

    public final boolean isPSOBJ2NAMENull() {
        return this.IsParamNull(TAG_PSOBJ2NAME);
    }

    public final String getPSOBJ2NAME() {
        return this.GetParamStringValue(TAG_PSOBJ2NAME, "");
    }

    public final void setPSOBJ2NAME(String strValue) {
        this.SetParamValue(TAG_PSOBJ2NAME, strValue);
    }
}

