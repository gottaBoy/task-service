/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSSysModelAction
extends BaseDataEntity {
    public static final String PSSYSMODELACTIONNAME_INIT = "INIT";
    public static final String PSSYSMODELACTIONNAME_COPY = "COPY";
    public static final String TAG_PSSYSMODELACTIONID = "PSSYSMODELACTIONID";
    public static final String TAG_PSSYSMODELACTIONNAME = "PSSYSMODELACTIONNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSSYSMODELINSTID = "PSSYSMODELINSTID";
    public static final String TAG_PSSYSMODELINSTNAME = "PSSYSMODELINSTNAME";
    public static final String TAG_SRCPSSYSMODELINSTID = "SRCPSSYSMODELINSTID";
    public static final String TAG_SRCPSSYSMODELINSTNAME = "SRCPSSYSMODELINSTNAME";

    public final boolean isPSSYSMODELACTIONIDNull() {
        return this.IsParamNull(TAG_PSSYSMODELACTIONID);
    }

    public final String getPSSYSMODELACTIONID() {
        return this.GetParamStringValue(TAG_PSSYSMODELACTIONID, "");
    }

    public final void setPSSYSMODELACTIONID(String strValue) {
        this.SetParamValue(TAG_PSSYSMODELACTIONID, strValue);
    }

    public final boolean isPSSYSMODELACTIONNAMENull() {
        return this.IsParamNull(TAG_PSSYSMODELACTIONNAME);
    }

    public final String getPSSYSMODELACTIONNAME() {
        return this.GetParamStringValue(TAG_PSSYSMODELACTIONNAME, "");
    }

    public final void setPSSYSMODELACTIONNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSMODELACTIONNAME, strValue);
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

    public final boolean isSRCPSSYSMODELINSTIDNull() {
        return this.IsParamNull(TAG_SRCPSSYSMODELINSTID);
    }

    public final String getSRCPSSYSMODELINSTID() {
        return this.GetParamStringValue(TAG_SRCPSSYSMODELINSTID, "");
    }

    public final void setSRCPSSYSMODELINSTID(String strValue) {
        this.SetParamValue(TAG_SRCPSSYSMODELINSTID, strValue);
    }

    public final boolean isSRCPSSYSMODELINSTNAMENull() {
        return this.IsParamNull(TAG_SRCPSSYSMODELINSTNAME);
    }

    public final String getSRCPSSYSMODELINSTNAME() {
        return this.GetParamStringValue(TAG_SRCPSSYSMODELINSTNAME, "");
    }

    public final void setSRCPSSYSMODELINSTNAME(String strValue) {
        this.SetParamValue(TAG_SRCPSSYSMODELINSTNAME, strValue);
    }
}

