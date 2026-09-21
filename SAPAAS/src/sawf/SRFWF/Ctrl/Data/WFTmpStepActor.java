/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SRFWF.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class WFTmpStepActor
extends BaseDataEntity {
    public static final String TAG_WFTMPSTEPACTORID = "WFTMPSTEPACTORID";
    public static final String TAG_WFTMPSTEPACTORNAME = "WFTMPSTEPACTORNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PREVPROCESS = "PREVPROCESS";
    public static final String TAG_CONNECTION = "CONNECTION";
    public static final String TAG_WFACTORNAME = "WFACTORNAME";
    public static final String TAG_PREVWFSTEPNAME = "PREVWFSTEPNAME";
    public static final String TAG_WFACTORID = "WFACTORID";
    public static final String TAG_PREVWFSTEPID = "PREVWFSTEPID";
    public static final String TAG_MEMO = "MEMO";

    public String getWFTMPSTEPACTORID() {
        return this.GetParamStringValue(TAG_WFTMPSTEPACTORID, "");
    }

    public void setWFTMPSTEPACTORID(String strValue) {
        this.SetParamValue(TAG_WFTMPSTEPACTORID, strValue);
    }

    public String getWFTMPSTEPACTORNAME() {
        return this.GetParamStringValue(TAG_WFTMPSTEPACTORNAME, "");
    }

    public void setWFTMPSTEPACTORNAME(String strValue) {
        this.SetParamValue(TAG_WFTMPSTEPACTORNAME, strValue);
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

    public String getPREVPROCESS() {
        return this.GetParamStringValue(TAG_PREVPROCESS, "");
    }

    public void setPREVPROCESS(String strValue) {
        this.SetParamValue(TAG_PREVPROCESS, strValue);
    }

    public String getCONNECTION() {
        return this.GetParamStringValue(TAG_CONNECTION, "");
    }

    public void setCONNECTION(String strValue) {
        this.SetParamValue(TAG_CONNECTION, strValue);
    }

    public String getWFACTORNAME() {
        return this.GetParamStringValue(TAG_WFACTORNAME, "");
    }

    public void setWFACTORNAME(String strValue) {
        this.SetParamValue(TAG_WFACTORNAME, strValue);
    }

    public String getPREVWFSTEPNAME() {
        return this.GetParamStringValue(TAG_PREVWFSTEPNAME, "");
    }

    public void setPREVWFSTEPNAME(String strValue) {
        this.SetParamValue(TAG_PREVWFSTEPNAME, strValue);
    }

    public String getWFACTORID() {
        return this.GetParamStringValue(TAG_WFACTORID, "");
    }

    public void setWFACTORID(String strValue) {
        this.SetParamValue(TAG_WFACTORID, strValue);
    }

    public String getPREVWFSTEPID() {
        return this.GetParamStringValue(TAG_PREVWFSTEPID, "");
    }

    public void setPREVWFSTEPID(String strValue) {
        this.SetParamValue(TAG_PREVWFSTEPID, strValue);
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
}

