/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSDevSysDiffItem
extends BaseDataEntity {
    public static final String OBJTYPE_CREATEDATAENTITY = "CREATEDATAENTITY";
    public static final String OBJTYPE_UPDATEDATAENTITY = "UPDATEDATAENTITY";
    public static final String OBJTYPE_DELETEDATAENTITY = "DELETEDATAENTITY";
    public static final String OBJTYPE_CREATEDEFIELD = "CREATEDEFIELD";
    public static final String OBJTYPE_UPDATEDEFIELD = "UPDATEDEFIELD";
    public static final String OBJTYPE_DELETEDEFIELD = "DELETEDEFIELD";
    public static final String SYNCACTION_NONE = "NONE";
    public static final String SYNCACTION_UPDATESRC = "UPDATESRC";
    public static final String SYNCACTION_UPDATEDST = "UPDATEDST";
    public static final String DIFFTYPE_NOTMATCH = "NOTMATCH";
    public static final String DIFFTYPE_SRCNOTEXISTS = "SRCNOTEXISTS";
    public static final String DIFFTYPE_DSTNOTEXISTS = "DSTNOTEXISTS";
    public static final String TAG_PSDEVSYSDIFFITEMID = "PSDEVSYSDIFFITEMID";
    public static final String TAG_PSDEVSYSDIFFITEMNAME = "PSDEVSYSDIFFITEMNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSDEVSYSDIFFREPID = "PSDEVSYSDIFFREPID";
    public static final String TAG_PSDEVSYSDIFFREPNAME = "PSDEVSYSDIFFREPNAME";
    public static final String TAG_OBJTYPE = "OBJTYPE";
    public static final String TAG_PSOBJID = "PSOBJID";
    public static final String TAG_PSOBJNAME = "PSOBJNAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_SYNCACTION = "SYNCACTION";
    public static final String TAG_SYNCRESULT = "SYNCRESULT";
    public static final String TAG_SYNCRESULTINFO = "SYNCRESULTINFO";
    public static final String TAG_DIFFTYPE = "DIFFTYPE";
    public static final String TAG_PSDEID = "PSDEID";
    public static final String TAG_PSDENAME = "PSDENAME";
    public static final String TAG_PSSYSAPPNAME = "PSSYSAPPNAME";
    public static final String TAG_PSSYSAPPID = "PSSYSAPPID";

    public final boolean isPSDEVSYSDIFFITEMIDNull() {
        return this.IsParamNull(TAG_PSDEVSYSDIFFITEMID);
    }

    public final String getPSDEVSYSDIFFITEMID() {
        return this.GetParamStringValue(TAG_PSDEVSYSDIFFITEMID, "");
    }

    public final void setPSDEVSYSDIFFITEMID(String strValue) {
        this.SetParamValue(TAG_PSDEVSYSDIFFITEMID, strValue);
    }

    public final boolean isPSDEVSYSDIFFITEMNAMENull() {
        return this.IsParamNull(TAG_PSDEVSYSDIFFITEMNAME);
    }

    public final String getPSDEVSYSDIFFITEMNAME() {
        return this.GetParamStringValue(TAG_PSDEVSYSDIFFITEMNAME, "");
    }

    public final void setPSDEVSYSDIFFITEMNAME(String strValue) {
        this.SetParamValue(TAG_PSDEVSYSDIFFITEMNAME, strValue);
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

    public final boolean isPSDEVSYSDIFFREPIDNull() {
        return this.IsParamNull(TAG_PSDEVSYSDIFFREPID);
    }

    public final String getPSDEVSYSDIFFREPID() {
        return this.GetParamStringValue(TAG_PSDEVSYSDIFFREPID, "");
    }

    public final void setPSDEVSYSDIFFREPID(String strValue) {
        this.SetParamValue(TAG_PSDEVSYSDIFFREPID, strValue);
    }

    public final boolean isPSDEVSYSDIFFREPNAMENull() {
        return this.IsParamNull(TAG_PSDEVSYSDIFFREPNAME);
    }

    public final String getPSDEVSYSDIFFREPNAME() {
        return this.GetParamStringValue(TAG_PSDEVSYSDIFFREPNAME, "");
    }

    public final void setPSDEVSYSDIFFREPNAME(String strValue) {
        this.SetParamValue(TAG_PSDEVSYSDIFFREPNAME, strValue);
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

    public final boolean isSYNCACTIONNull() {
        return this.IsParamNull(TAG_SYNCACTION);
    }

    public final String getSYNCACTION() {
        return this.GetParamStringValue(TAG_SYNCACTION, "");
    }

    public final void setSYNCACTION(String strValue) {
        this.SetParamValue(TAG_SYNCACTION, strValue);
    }

    public final boolean isSYNCRESULTNull() {
        return this.IsParamNull(TAG_SYNCRESULT);
    }

    public final boolean getSYNCRESULT() {
        return this.GetParamIntValue(TAG_SYNCRESULT, 0) == 1;
    }

    public final void setSYNCRESULT(boolean bValue) {
        this.SetParamValue(TAG_SYNCRESULT, bValue ? 1 : 0);
    }

    public final boolean isSYNCRESULTINFONull() {
        return this.IsParamNull(TAG_SYNCRESULTINFO);
    }

    public final String getSYNCRESULTINFO() {
        return this.GetParamStringValue(TAG_SYNCRESULTINFO, "");
    }

    public final void setSYNCRESULTINFO(String strValue) {
        this.SetParamValue(TAG_SYNCRESULTINFO, strValue);
    }

    public final boolean isDIFFTYPENull() {
        return this.IsParamNull(TAG_DIFFTYPE);
    }

    public final String getDIFFTYPE() {
        return this.GetParamStringValue(TAG_DIFFTYPE, "");
    }

    public final void setDIFFTYPE(String strValue) {
        this.SetParamValue(TAG_DIFFTYPE, strValue);
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

    public final boolean isPSSYSAPPNAMENull() {
        return this.IsParamNull(TAG_PSSYSAPPNAME);
    }

    public final String getPSSYSAPPNAME() {
        return this.GetParamStringValue(TAG_PSSYSAPPNAME, "");
    }

    public final void setPSSYSAPPNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSAPPNAME, strValue);
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
}

