/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSDEDBIndex
extends BaseDataEntity {
    public static final String INDEXTYPE_NORMAL = "NORMAL";
    public static final String INDEXTYPE_UNIQUE = "UNIQUE";
    public static final String TAG_PSDEDBINDEXID = "PSDEDBINDEXID";
    public static final String TAG_PSDEDBINDEXNAME = "PSDEDBINDEXNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSDEID = "PSDEID";
    public static final String TAG_PSDENAME = "PSDENAME";
    public static final String TAG_ALLOWREVERSE = "ALLOWREVERSE";
    public static final String TAG_INCFIELDS = "INCFIELDS";
    public static final String TAG_INDEXFIELDS = "INDEXFIELDS";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_INDEXTYPE = "INDEXTYPE";
    public static final String TAG_REMOVEFLAG = "REMOVEFLAG";
    public static final String TAG_CODENAME = "CODENAME";

    public final boolean isPSDEDBINDEXIDNull() {
        return this.IsParamNull(TAG_PSDEDBINDEXID);
    }

    public final String getPSDEDBINDEXID() {
        return this.GetParamStringValue(TAG_PSDEDBINDEXID, "");
    }

    public final void setPSDEDBINDEXID(String strValue) {
        this.SetParamValue(TAG_PSDEDBINDEXID, strValue);
    }

    public final boolean isPSDEDBINDEXNAMENull() {
        return this.IsParamNull(TAG_PSDEDBINDEXNAME);
    }

    public final String getPSDEDBINDEXNAME() {
        return this.GetParamStringValue(TAG_PSDEDBINDEXNAME, "");
    }

    public final void setPSDEDBINDEXNAME(String strValue) {
        this.SetParamValue(TAG_PSDEDBINDEXNAME, strValue);
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

    public final boolean isALLOWREVERSENull() {
        return this.IsParamNull(TAG_ALLOWREVERSE);
    }

    public final boolean getALLOWREVERSE() {
        return this.GetParamIntValue(TAG_ALLOWREVERSE, 0) == 1;
    }

    public final void setALLOWREVERSE(boolean bValue) {
        this.SetParamValue(TAG_ALLOWREVERSE, bValue ? 1 : 0);
    }

    public final boolean isINCFIELDSNull() {
        return this.IsParamNull(TAG_INCFIELDS);
    }

    public final String getINCFIELDS() {
        return this.GetParamStringValue(TAG_INCFIELDS, "");
    }

    public final void setINCFIELDS(String strValue) {
        this.SetParamValue(TAG_INCFIELDS, strValue);
    }

    public final boolean isINDEXFIELDSNull() {
        return this.IsParamNull(TAG_INDEXFIELDS);
    }

    public final String getINDEXFIELDS() {
        return this.GetParamStringValue(TAG_INDEXFIELDS, "");
    }

    public final void setINDEXFIELDS(String strValue) {
        this.SetParamValue(TAG_INDEXFIELDS, strValue);
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

    public final boolean isINDEXTYPENull() {
        return this.IsParamNull(TAG_INDEXTYPE);
    }

    public final String getINDEXTYPE() {
        return this.GetParamStringValue(TAG_INDEXTYPE, "");
    }

    public final void setINDEXTYPE(String strValue) {
        this.SetParamValue(TAG_INDEXTYPE, strValue);
    }

    public final boolean isREMOVEFLAGNull() {
        return this.IsParamNull(TAG_REMOVEFLAG);
    }

    public final boolean getREMOVEFLAG() {
        return this.GetParamIntValue(TAG_REMOVEFLAG, 0) == 1;
    }

    public final void setREMOVEFLAG(boolean bValue) {
        this.SetParamValue(TAG_REMOVEFLAG, bValue ? 1 : 0);
    }

    public final boolean isCODENAMENull() {
        return this.IsParamNull(TAG_CODENAME);
    }

    public final String getCODENAME() {
        return this.GetParamStringValue(TAG_CODENAME, "");
    }

    public final void setCODENAME(String strValue) {
        this.SetParamValue(TAG_CODENAME, strValue);
    }
}

