/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSDCCodeSnippet
extends BaseDataEntity {
    public static final String CODETARGET_NONE = "NONE";
    public static final String CODETARGET_PSDATAENTITY = "PSDATAENTITY";
    public static final String CODETARGET_PSSYSTEM = "PSSYSTEM";
    public static final String CODETARGET_PSSYSAPP = "PSSYSAPP";
    public static final String CODETARGET_PSAPPVIEW = "PSAPPVIEW";
    public static final String CODETARGET_PSSYSTEMDBCFG = "PSSYSTEMDBCFG";
    public static final String CODECAT_EDITOR = "EDITOR";
    public static final String CODECAT_CONTROL = "CONTROL";
    public static final String CODECAT_VIEW = "VIEW";
    public static final String CODECAT_DEMODEL = "DEMODEL";
    public static final String CODECAT_SYSMODEL = "SYSMODEL";
    public static final String CODECAT_USERCAT = "USERCAT";
    public static final String CODECAT_USERCAT2 = "USERCAT2";
    public static final String TAG_PSDCCODESNIPPETID = "PSDCCODESNIPPETID";
    public static final String TAG_PSDCCODESNIPPETNAME = "PSDCCODESNIPPETNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSDEVCENTERID = "PSDEVCENTERID";
    public static final String TAG_PSDEVCENTERNAME = "PSDEVCENTERNAME";
    public static final String TAG_ALLDCFLAG = "ALLDCFLAG";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_TEMPLCODE = "TEMPLCODE";
    public static final String TAG_TEMPLCODE2 = "TEMPLCODE2";
    public static final String TAG_CODETARGET = "CODETARGET";
    public static final String TAG_CODECAT = "CODECAT";
    public static final String TAG_KEYWORDS = "KEYWORDS";
    public static final String TAG_REFMODE = "REFMODE";

    public final boolean isPSDCCODESNIPPETIDNull() {
        return this.IsParamNull(TAG_PSDCCODESNIPPETID);
    }

    public final String getPSDCCODESNIPPETID() {
        return this.GetParamStringValue(TAG_PSDCCODESNIPPETID, "");
    }

    public final void setPSDCCODESNIPPETID(String strValue) {
        this.SetParamValue(TAG_PSDCCODESNIPPETID, strValue);
    }

    public final boolean isPSDCCODESNIPPETNAMENull() {
        return this.IsParamNull(TAG_PSDCCODESNIPPETNAME);
    }

    public final String getPSDCCODESNIPPETNAME() {
        return this.GetParamStringValue(TAG_PSDCCODESNIPPETNAME, "");
    }

    public final void setPSDCCODESNIPPETNAME(String strValue) {
        this.SetParamValue(TAG_PSDCCODESNIPPETNAME, strValue);
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

    public final boolean isPSDEVCENTERIDNull() {
        return this.IsParamNull(TAG_PSDEVCENTERID);
    }

    public final String getPSDEVCENTERID() {
        return this.GetParamStringValue(TAG_PSDEVCENTERID, "");
    }

    public final void setPSDEVCENTERID(String strValue) {
        this.SetParamValue(TAG_PSDEVCENTERID, strValue);
    }

    public final boolean isPSDEVCENTERNAMENull() {
        return this.IsParamNull(TAG_PSDEVCENTERNAME);
    }

    public final String getPSDEVCENTERNAME() {
        return this.GetParamStringValue(TAG_PSDEVCENTERNAME, "");
    }

    public final void setPSDEVCENTERNAME(String strValue) {
        this.SetParamValue(TAG_PSDEVCENTERNAME, strValue);
    }

    public final boolean isALLDCFLAGNull() {
        return this.IsParamNull(TAG_ALLDCFLAG);
    }

    public final boolean getALLDCFLAG() {
        return this.GetParamIntValue(TAG_ALLDCFLAG, 0) == 1;
    }

    public final void setALLDCFLAG(boolean bValue) {
        this.SetParamValue(TAG_ALLDCFLAG, bValue ? 1 : 0);
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

    public final boolean isTEMPLCODENull() {
        return this.IsParamNull(TAG_TEMPLCODE);
    }

    public final String getTEMPLCODE() {
        return this.GetParamStringValue(TAG_TEMPLCODE, "");
    }

    public final void setTEMPLCODE(String strValue) {
        this.SetParamValue(TAG_TEMPLCODE, strValue);
    }

    public final boolean isTEMPLCODE2Null() {
        return this.IsParamNull(TAG_TEMPLCODE2);
    }

    public final String getTEMPLCODE2() {
        return this.GetParamStringValue(TAG_TEMPLCODE2, "");
    }

    public final void setTEMPLCODE2(String strValue) {
        this.SetParamValue(TAG_TEMPLCODE2, strValue);
    }

    public final boolean isCODETARGETNull() {
        return this.IsParamNull(TAG_CODETARGET);
    }

    public final String getCODETARGET() {
        return this.GetParamStringValue(TAG_CODETARGET, "");
    }

    public final void setCODETARGET(String strValue) {
        this.SetParamValue(TAG_CODETARGET, strValue);
    }

    public final boolean isCODECATNull() {
        return this.IsParamNull(TAG_CODECAT);
    }

    public final String getCODECAT() {
        return this.GetParamStringValue(TAG_CODECAT, "");
    }

    public final void setCODECAT(String strValue) {
        this.SetParamValue(TAG_CODECAT, strValue);
    }

    public final boolean isKEYWORDSNull() {
        return this.IsParamNull(TAG_KEYWORDS);
    }

    public final String getKEYWORDS() {
        return this.GetParamStringValue(TAG_KEYWORDS, "");
    }

    public final void setKEYWORDS(String strValue) {
        this.SetParamValue(TAG_KEYWORDS, strValue);
    }

    public final boolean isREFMODENull() {
        return this.IsParamNull(TAG_REFMODE);
    }

    public final String getREFMODE() {
        return this.GetParamStringValue(TAG_REFMODE, "");
    }

    public final void setREFMODE(String strValue) {
        this.SetParamValue(TAG_REFMODE, strValue);
    }
}

