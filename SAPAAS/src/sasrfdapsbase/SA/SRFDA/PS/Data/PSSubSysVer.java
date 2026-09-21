/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSSubSysVer
extends BaseDataEntity {
    public static final String TAG_PSSUBSYSVERID = "PSSUBSYSVERID";
    public static final String TAG_PSSUBSYSVERNAME = "PSSUBSYSVERNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSSUBSYSID = "PSSUBSYSID";
    public static final String TAG_PSSUBSYSNAME = "PSSUBSYSNAME";
    public static final String TAG_PSSYSMODELINSTID = "PSSYSMODELINSTID";
    public static final String TAG_PSSYSMODELINSTNAME = "PSSYSMODELINSTNAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_VERLOG = "VERLOG";
    public static final String TAG_VERDETAIL = "VERDETAIL";
    public static final String TAG_VERSION = "VERSION";
    public static final String TAG_CLSPKGPARAMS = "CLSPKGPARAMS";

    public final boolean isPSSUBSYSVERIDNull() {
        return this.IsParamNull(TAG_PSSUBSYSVERID);
    }

    public final String getPSSUBSYSVERID() {
        return this.GetParamStringValue(TAG_PSSUBSYSVERID, "");
    }

    public final void setPSSUBSYSVERID(String strValue) {
        this.SetParamValue(TAG_PSSUBSYSVERID, strValue);
    }

    public final boolean isPSSUBSYSVERNAMENull() {
        return this.IsParamNull(TAG_PSSUBSYSVERNAME);
    }

    public final String getPSSUBSYSVERNAME() {
        return this.GetParamStringValue(TAG_PSSUBSYSVERNAME, "");
    }

    public final void setPSSUBSYSVERNAME(String strValue) {
        this.SetParamValue(TAG_PSSUBSYSVERNAME, strValue);
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

    public final boolean isPSSUBSYSIDNull() {
        return this.IsParamNull(TAG_PSSUBSYSID);
    }

    public final String getPSSUBSYSID() {
        return this.GetParamStringValue(TAG_PSSUBSYSID, "");
    }

    public final void setPSSUBSYSID(String strValue) {
        this.SetParamValue(TAG_PSSUBSYSID, strValue);
    }

    public final boolean isPSSUBSYSNAMENull() {
        return this.IsParamNull(TAG_PSSUBSYSNAME);
    }

    public final String getPSSUBSYSNAME() {
        return this.GetParamStringValue(TAG_PSSUBSYSNAME, "");
    }

    public final void setPSSUBSYSNAME(String strValue) {
        this.SetParamValue(TAG_PSSUBSYSNAME, strValue);
    }

    public final boolean isPSSYSMODELINSTIDNull() {
        return this.IsParamNull(TAG_PSSYSMODELINSTID);
    }

    public final String getPSSYSMODELINSTID() {
        return this.GetParamStringValue(TAG_PSSYSMODELINSTID, "");
    }

    public final void setPSSYSMODELINSTID(String strValue) {
        this.SetParamValue(TAG_PSSYSMODELINSTID, strValue);
    }

    public final boolean isPSSYSMODELINSTNAMENull() {
        return this.IsParamNull(TAG_PSSYSMODELINSTNAME);
    }

    public final String getPSSYSMODELINSTNAME() {
        return this.GetParamStringValue(TAG_PSSYSMODELINSTNAME, "");
    }

    public final void setPSSYSMODELINSTNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSMODELINSTNAME, strValue);
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

    public final boolean isVERLOGNull() {
        return this.IsParamNull(TAG_VERLOG);
    }

    public final String getVERLOG() {
        return this.GetParamStringValue(TAG_VERLOG, "");
    }

    public final void setVERLOG(String strValue) {
        this.SetParamValue(TAG_VERLOG, strValue);
    }

    public final boolean isVERDETAILNull() {
        return this.IsParamNull(TAG_VERDETAIL);
    }

    public final String getVERDETAIL() {
        return this.GetParamStringValue(TAG_VERDETAIL, "");
    }

    public final void setVERDETAIL(String strValue) {
        this.SetParamValue(TAG_VERDETAIL, strValue);
    }

    public final boolean isVERSIONNull() {
        return this.IsParamNull(TAG_VERSION);
    }

    public final int getVERSION() {
        return this.GetParamIntValue(TAG_VERSION, 0);
    }

    public final void setVERSION(int nValue) {
        this.SetParamValue(TAG_VERSION, nValue);
    }

    public final boolean isCLSPKGPARAMSNull() {
        return this.IsParamNull(TAG_CLSPKGPARAMS);
    }

    public final String getCLSPKGPARAMS() {
        return this.GetParamStringValue(TAG_CLSPKGPARAMS, "");
    }

    public final void setCLSPKGPARAMS(String strValue) {
        this.SetParamValue(TAG_CLSPKGPARAMS, strValue);
    }
}

