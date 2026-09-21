/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSDynaDETempl
extends BaseDataEntity {
    public static final String TAG_PSDYNADETEMPLID = "PSDYNADETEMPLID";
    public static final String TAG_PSDYNADETEMPLNAME = "PSDYNADETEMPLNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSSYSTEMID = "PSSYSTEMID";
    public static final String TAG_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String TAG_TEMPLPSDEID = "TEMPLPSDEID";
    public static final String TAG_TEMPLPSDENAME = "TEMPLPSDENAME";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_TYPEPSDEFID = "TYPEPSDEFID";
    public static final String TAG_TYPEPSDEFNAME = "TYPEPSDEFNAME";

    public final boolean isPSDYNADETEMPLIDNull() {
        return this.IsParamNull(TAG_PSDYNADETEMPLID);
    }

    public final String getPSDYNADETEMPLID() {
        return this.GetParamStringValue(TAG_PSDYNADETEMPLID, "");
    }

    public final void setPSDYNADETEMPLID(String strValue) {
        this.SetParamValue(TAG_PSDYNADETEMPLID, strValue);
    }

    public final boolean isPSDYNADETEMPLNAMENull() {
        return this.IsParamNull(TAG_PSDYNADETEMPLNAME);
    }

    public final String getPSDYNADETEMPLNAME() {
        return this.GetParamStringValue(TAG_PSDYNADETEMPLNAME, "");
    }

    public final void setPSDYNADETEMPLNAME(String strValue) {
        this.SetParamValue(TAG_PSDYNADETEMPLNAME, strValue);
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

    public final boolean isTEMPLPSDEIDNull() {
        return this.IsParamNull(TAG_TEMPLPSDEID);
    }

    public final String getTEMPLPSDEID() {
        return this.GetParamStringValue(TAG_TEMPLPSDEID, "");
    }

    public final void setTEMPLPSDEID(String strValue) {
        this.SetParamValue(TAG_TEMPLPSDEID, strValue);
    }

    public final boolean isTEMPLPSDENAMENull() {
        return this.IsParamNull(TAG_TEMPLPSDENAME);
    }

    public final String getTEMPLPSDENAME() {
        return this.GetParamStringValue(TAG_TEMPLPSDENAME, "");
    }

    public final void setTEMPLPSDENAME(String strValue) {
        this.SetParamValue(TAG_TEMPLPSDENAME, strValue);
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

    public final boolean isTYPEPSDEFIDNull() {
        return this.IsParamNull(TAG_TYPEPSDEFID);
    }

    public final String getTYPEPSDEFID() {
        return this.GetParamStringValue(TAG_TYPEPSDEFID, "");
    }

    public final void setTYPEPSDEFID(String strValue) {
        this.SetParamValue(TAG_TYPEPSDEFID, strValue);
    }

    public final boolean isTYPEPSDEFNAMENull() {
        return this.IsParamNull(TAG_TYPEPSDEFNAME);
    }

    public final String getTYPEPSDEFNAME() {
        return this.GetParamStringValue(TAG_TYPEPSDEFNAME, "");
    }

    public final void setTYPEPSDEFNAME(String strValue) {
        this.SetParamValue(TAG_TYPEPSDEFNAME, strValue);
    }
}

