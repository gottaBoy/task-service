/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSDEMapDataSet
extends BaseDataEntity {
    public static final String TAG_PSDEMAPDSID = "PSDEMAPDSID";
    public static final String TAG_PSDEMAPDSNAME = "PSDEMAPDSNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSDEMAPID = "PSDEMAPID";
    public static final String TAG_PSDEMAPNAME = "PSDEMAPNAME";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_PSDEDATASETID = "PSDEDATASETID";
    public static final String TAG_PSDEDATASETNAME = "PSDEDATASETNAME";
    public static final String TAG_DSTPSDEDATASETID = "DSTPSDEDATASETID";
    public static final String TAG_DSTPSDEDATASETNAME = "DSTPSDEDATASETNAME";
    public static final String TAG_PROPERTYMAP = "PROPERTYMAP";
    public static final String TAG_MAPMODE = "MAPMODE";
    public static final String TAG_ENABLEDQCOND = "ENABLEDQCOND";

    public final boolean isPSDEMAPDSIDNull() {
        return this.IsParamNull(TAG_PSDEMAPDSID);
    }

    public final String getPSDEMAPDSID() {
        return this.GetParamStringValue(TAG_PSDEMAPDSID, "");
    }

    public final void setPSDEMAPDSID(String strValue) {
        this.SetParamValue(TAG_PSDEMAPDSID, strValue);
    }

    public final boolean isPSDEMAPDSNAMENull() {
        return this.IsParamNull(TAG_PSDEMAPDSNAME);
    }

    public final String getPSDEMAPDSNAME() {
        return this.GetParamStringValue(TAG_PSDEMAPDSNAME, "");
    }

    public final void setPSDEMAPDSNAME(String strValue) {
        this.SetParamValue(TAG_PSDEMAPDSNAME, strValue);
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

    public final boolean isPSDEMAPIDNull() {
        return this.IsParamNull(TAG_PSDEMAPID);
    }

    public final String getPSDEMAPID() {
        return this.GetParamStringValue(TAG_PSDEMAPID, "");
    }

    public final void setPSDEMAPID(String strValue) {
        this.SetParamValue(TAG_PSDEMAPID, strValue);
    }

    public final boolean isPSDEMAPNAMENull() {
        return this.IsParamNull(TAG_PSDEMAPNAME);
    }

    public final String getPSDEMAPNAME() {
        return this.GetParamStringValue(TAG_PSDEMAPNAME, "");
    }

    public final void setPSDEMAPNAME(String strValue) {
        this.SetParamValue(TAG_PSDEMAPNAME, strValue);
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

    public final boolean isMEMONull() {
        return this.IsParamNull(TAG_MEMO);
    }

    public final String getMEMO() {
        return this.GetParamStringValue(TAG_MEMO, "");
    }

    public final void setMEMO(String strValue) {
        this.SetParamValue(TAG_MEMO, strValue);
    }

    public final boolean isPSDEDATASETIDNull() {
        return this.IsParamNull(TAG_PSDEDATASETID);
    }

    public final String getPSDEDATASETID() {
        return this.GetParamStringValue(TAG_PSDEDATASETID, "");
    }

    public final void setPSDEDATASETID(String strValue) {
        this.SetParamValue(TAG_PSDEDATASETID, strValue);
    }

    public final boolean isPSDEDATASETNAMENull() {
        return this.IsParamNull(TAG_PSDEDATASETNAME);
    }

    public final String getPSDEDATASETNAME() {
        return this.GetParamStringValue(TAG_PSDEDATASETNAME, "");
    }

    public final void setPSDEDATASETNAME(String strValue) {
        this.SetParamValue(TAG_PSDEDATASETNAME, strValue);
    }

    public final boolean isDSTPSDEDATASETIDNull() {
        return this.IsParamNull(TAG_DSTPSDEDATASETID);
    }

    public final String getDSTPSDEDATASETID() {
        return this.GetParamStringValue(TAG_DSTPSDEDATASETID, "");
    }

    public final void setDSTPSDEDATASETID(String strValue) {
        this.SetParamValue(TAG_DSTPSDEDATASETID, strValue);
    }

    public final boolean isDSTPSDEDATASETNAMENull() {
        return this.IsParamNull(TAG_DSTPSDEDATASETNAME);
    }

    public final String getDSTPSDEDATASETNAME() {
        return this.GetParamStringValue(TAG_DSTPSDEDATASETNAME, "");
    }

    public final void setDSTPSDEDATASETNAME(String strValue) {
        this.SetParamValue(TAG_DSTPSDEDATASETNAME, strValue);
    }

    public final boolean isPROPERTYMAPNull() {
        return this.IsParamNull(TAG_PROPERTYMAP);
    }

    public final String getPROPERTYMAP() {
        return this.GetParamStringValue(TAG_PROPERTYMAP, "");
    }

    public final void setPROPERTYMAP(String strValue) {
        this.SetParamValue(TAG_PROPERTYMAP, strValue);
    }

    public final boolean isMAPMODENull() {
        return this.IsParamNull(TAG_MAPMODE);
    }

    public final String getMAPMODE() {
        return this.GetParamStringValue(TAG_MAPMODE, "");
    }

    public final void setMAPMODE(String strValue) {
        this.SetParamValue(TAG_MAPMODE, strValue);
    }

    public final boolean isENABLEDQCONDNull() {
        return this.IsParamNull(TAG_ENABLEDQCOND);
    }

    public final boolean getENABLEDQCOND() {
        return this.GetParamIntValue(TAG_ENABLEDQCOND, 0) == 1;
    }

    public final void setENABLEDQCOND(boolean bValue) {
        this.SetParamValue(TAG_ENABLEDQCOND, bValue ? 1 : 0);
    }
}

