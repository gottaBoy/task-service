/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSSysBDTableDE
extends BaseDataEntity {
    public static final String TAG_PSSYSBDTABLEDEID = "PSSYSBDTABLEDEID";
    public static final String TAG_PSSYSBDTABLEDENAME = "PSSYSBDTABLEDENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSSYSBDTABLEID = "PSSYSBDTABLEID";
    public static final String TAG_PSSYSBDTABLENAME = "PSSYSBDTABLENAME";
    public static final String TAG_PSDEID = "PSDEID";
    public static final String TAG_PSDENAME = "PSDENAME";
    public static final String TAG_DEFAULTFLAG = "DEFAULTFLAG";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_ADDCOLMODE = "ADDCOLMODE";
    public static final String TAG_COLFILTER = "COLFILTER";
    public static final String TAG_INCDENAME = "INCDENAME";
    public static final String TAG_PSSYSBDCOLSETID = "PSSYSBDCOLSETID";
    public static final String TAG_PSSYSBDCOLSETNAME = "PSSYSBDCOLSETNAME";
    public static final String TAG_PSSYSBDSCHEMEID = "PSSYSBDSCHEMEID";
    public static final String TAG_PSSYSBDSCHEMENAME = "PSSYSBDSCHEMENAME";
    public static final String TAG_ROWKEYFORMAT = "ROWKEYFORMAT";
    public static final String TAG_ROWKEYPARAMS = "ROWKEYPARAMS";

    public final boolean isPSSYSBDTABLEDEIDNull() {
        return this.IsParamNull(TAG_PSSYSBDTABLEDEID);
    }

    public final String getPSSYSBDTABLEDEID() {
        return this.GetParamStringValue(TAG_PSSYSBDTABLEDEID, "");
    }

    public final void setPSSYSBDTABLEDEID(String strValue) {
        this.SetParamValue(TAG_PSSYSBDTABLEDEID, strValue);
    }

    public final boolean isPSSYSBDTABLEDENAMENull() {
        return this.IsParamNull(TAG_PSSYSBDTABLEDENAME);
    }

    public final String getPSSYSBDTABLEDENAME() {
        return this.GetParamStringValue(TAG_PSSYSBDTABLEDENAME, "");
    }

    public final void setPSSYSBDTABLEDENAME(String strValue) {
        this.SetParamValue(TAG_PSSYSBDTABLEDENAME, strValue);
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

    public final boolean isPSSYSBDTABLEIDNull() {
        return this.IsParamNull(TAG_PSSYSBDTABLEID);
    }

    public final String getPSSYSBDTABLEID() {
        return this.GetParamStringValue(TAG_PSSYSBDTABLEID, "");
    }

    public final void setPSSYSBDTABLEID(String strValue) {
        this.SetParamValue(TAG_PSSYSBDTABLEID, strValue);
    }

    public final boolean isPSSYSBDTABLENAMENull() {
        return this.IsParamNull(TAG_PSSYSBDTABLENAME);
    }

    public final String getPSSYSBDTABLENAME() {
        return this.GetParamStringValue(TAG_PSSYSBDTABLENAME, "");
    }

    public final void setPSSYSBDTABLENAME(String strValue) {
        this.SetParamValue(TAG_PSSYSBDTABLENAME, strValue);
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

    public final boolean isDEFAULTFLAGNull() {
        return this.IsParamNull(TAG_DEFAULTFLAG);
    }

    public final boolean getDEFAULTFLAG() {
        return this.GetParamIntValue(TAG_DEFAULTFLAG, 0) == 1;
    }

    public final void setDEFAULTFLAG(boolean bValue) {
        this.SetParamValue(TAG_DEFAULTFLAG, bValue ? 1 : 0);
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

    public final boolean isADDCOLMODENull() {
        return this.IsParamNull(TAG_ADDCOLMODE);
    }

    public final int getADDCOLMODE() {
        return this.GetParamIntValue(TAG_ADDCOLMODE, 0);
    }

    public final void setADDCOLMODE(int nValue) {
        this.SetParamValue(TAG_ADDCOLMODE, nValue);
    }

    public final boolean isCOLFILTERNull() {
        return this.IsParamNull(TAG_COLFILTER);
    }

    public final String getCOLFILTER() {
        return this.GetParamStringValue(TAG_COLFILTER, "");
    }

    public final void setCOLFILTER(String strValue) {
        this.SetParamValue(TAG_COLFILTER, strValue);
    }

    public final boolean isINCDENAMENull() {
        return this.IsParamNull(TAG_INCDENAME);
    }

    public final boolean getINCDENAME() {
        return this.GetParamIntValue(TAG_INCDENAME, 0) == 1;
    }

    public final void setINCDENAME(boolean bValue) {
        this.SetParamValue(TAG_INCDENAME, bValue ? 1 : 0);
    }

    public final boolean isPSSYSBDCOLSETIDNull() {
        return this.IsParamNull(TAG_PSSYSBDCOLSETID);
    }

    public final String getPSSYSBDCOLSETID() {
        return this.GetParamStringValue(TAG_PSSYSBDCOLSETID, "");
    }

    public final void setPSSYSBDCOLSETID(String strValue) {
        this.SetParamValue(TAG_PSSYSBDCOLSETID, strValue);
    }

    public final boolean isPSSYSBDCOLSETNAMENull() {
        return this.IsParamNull(TAG_PSSYSBDCOLSETNAME);
    }

    public final String getPSSYSBDCOLSETNAME() {
        return this.GetParamStringValue(TAG_PSSYSBDCOLSETNAME, "");
    }

    public final void setPSSYSBDCOLSETNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSBDCOLSETNAME, strValue);
    }

    public final boolean isPSSYSBDSCHEMEIDNull() {
        return this.IsParamNull(TAG_PSSYSBDSCHEMEID);
    }

    public final String getPSSYSBDSCHEMEID() {
        return this.GetParamStringValue(TAG_PSSYSBDSCHEMEID, "");
    }

    public final void setPSSYSBDSCHEMEID(String strValue) {
        this.SetParamValue(TAG_PSSYSBDSCHEMEID, strValue);
    }

    public final boolean isPSSYSBDSCHEMENAMENull() {
        return this.IsParamNull(TAG_PSSYSBDSCHEMENAME);
    }

    public final String getPSSYSBDSCHEMENAME() {
        return this.GetParamStringValue(TAG_PSSYSBDSCHEMENAME, "");
    }

    public final void setPSSYSBDSCHEMENAME(String strValue) {
        this.SetParamValue(TAG_PSSYSBDSCHEMENAME, strValue);
    }

    public final boolean isROWKEYFORMATNull() {
        return this.IsParamNull(TAG_ROWKEYFORMAT);
    }

    public final String getROWKEYFORMAT() {
        return this.GetParamStringValue(TAG_ROWKEYFORMAT, "");
    }

    public final void setROWKEYFORMAT(String strValue) {
        this.SetParamValue(TAG_ROWKEYFORMAT, strValue);
    }

    public final boolean isROWKEYPARAMSNull() {
        return this.IsParamNull(TAG_ROWKEYPARAMS);
    }

    public final String getROWKEYPARAMS() {
        return this.GetParamStringValue(TAG_ROWKEYPARAMS, "");
    }

    public final void setROWKEYPARAMS(String strValue) {
        this.SetParamValue(TAG_ROWKEYPARAMS, strValue);
    }
}

