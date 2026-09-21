/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSModelPlugin
extends BaseDataEntity {
    public static final String PLUGINTYPE_DIFF = "DIFF";
    public static final String PLUGINTYPE_CHECK = "CHECK";
    public static final String TAG_PSMODELPLUGINID = "PSMODELPLUGINID";
    public static final String TAG_PSMODELPLUGINNAME = "PSMODELPLUGINNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_DIFFOBJ = "DIFFOBJ";
    public static final String TAG_PSMODELID = "PSMODELID";
    public static final String TAG_PSMODELNAME = "PSMODELNAME";
    public static final String TAG_PLUGINTYPE = "PLUGINTYPE";
    public static final String TAG_PLUGINPARAMS = "PLUGINPARAMS";
    public static final String TAG_JSCODE = "JSCODE";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";

    public final boolean isPSMODELPLUGINIDNull() {
        return this.IsParamNull(TAG_PSMODELPLUGINID);
    }

    public final String getPSMODELPLUGINID() {
        return this.GetParamStringValue(TAG_PSMODELPLUGINID, "");
    }

    public final void setPSMODELPLUGINID(String strValue) {
        this.SetParamValue(TAG_PSMODELPLUGINID, strValue);
    }

    public final boolean isPSMODELPLUGINNAMENull() {
        return this.IsParamNull(TAG_PSMODELPLUGINNAME);
    }

    public final String getPSMODELPLUGINNAME() {
        return this.GetParamStringValue(TAG_PSMODELPLUGINNAME, "");
    }

    public final void setPSMODELPLUGINNAME(String strValue) {
        this.SetParamValue(TAG_PSMODELPLUGINNAME, strValue);
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

    public final boolean isMEMONull() {
        return this.IsParamNull(TAG_MEMO);
    }

    public final String getMEMO() {
        return this.GetParamStringValue(TAG_MEMO, "");
    }

    public final void setMEMO(String strValue) {
        this.SetParamValue(TAG_MEMO, strValue);
    }

    public final boolean isDIFFOBJNull() {
        return this.IsParamNull(TAG_DIFFOBJ);
    }

    public final String getDIFFOBJ() {
        return this.GetParamStringValue(TAG_DIFFOBJ, "");
    }

    public final void setDIFFOBJ(String strValue) {
        this.SetParamValue(TAG_DIFFOBJ, strValue);
    }

    public final boolean isPSMODELIDNull() {
        return this.IsParamNull(TAG_PSMODELID);
    }

    public final String getPSMODELID() {
        return this.GetParamStringValue(TAG_PSMODELID, "");
    }

    public final void setPSMODELID(String strValue) {
        this.SetParamValue(TAG_PSMODELID, strValue);
    }

    public final boolean isPSMODELNAMENull() {
        return this.IsParamNull(TAG_PSMODELNAME);
    }

    public final String getPSMODELNAME() {
        return this.GetParamStringValue(TAG_PSMODELNAME, "");
    }

    public final void setPSMODELNAME(String strValue) {
        this.SetParamValue(TAG_PSMODELNAME, strValue);
    }

    public final boolean isPLUGINTYPENull() {
        return this.IsParamNull(TAG_PLUGINTYPE);
    }

    public final String getPLUGINTYPE() {
        return this.GetParamStringValue(TAG_PLUGINTYPE, "");
    }

    public final void setPLUGINTYPE(String strValue) {
        this.SetParamValue(TAG_PLUGINTYPE, strValue);
    }

    public final boolean isPLUGINPARAMSNull() {
        return this.IsParamNull(TAG_PLUGINPARAMS);
    }

    public final String getPLUGINPARAMS() {
        return this.GetParamStringValue(TAG_PLUGINPARAMS, "");
    }

    public final void setPLUGINPARAMS(String strValue) {
        this.SetParamValue(TAG_PLUGINPARAMS, strValue);
    }

    public final boolean isJSCODENull() {
        return this.IsParamNull(TAG_JSCODE);
    }

    public final String getJSCODE() {
        return this.GetParamStringValue(TAG_JSCODE, "");
    }

    public final void setJSCODE(String strValue) {
        this.SetParamValue(TAG_JSCODE, strValue);
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
}

