/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSSysBDColumn
extends BaseDataEntity {
    public static final String TAG_PSSYSBDCOLUMNID = "PSSYSBDCOLUMNID";
    public static final String TAG_PSSYSBDCOLUMNNAME = "PSSYSBDCOLUMNNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSSYSBDTABLEID = "PSSYSBDTABLEID";
    public static final String TAG_PSSYSBDTABLENAME = "PSSYSBDTABLENAME";
    public static final String TAG_CODENAME = "CODENAME";
    public static final String TAG_LOGICNAME = "LOGICNAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_PSSYSBDCOLSETID = "PSSYSBDCOLSETID";
    public static final String TAG_PSSYSBDCOLSETNAME = "PSSYSBDCOLSETNAME";
    public static final String TAG_PSSYSBDTABLEDEID = "PSSYSBDTABLEDEID";
    public static final String TAG_PSSYSBDTABLEDENAME = "PSSYSBDTABLEDENAME";
    public static final String TAG_PSDEID = "PSDEID";
    public static final String TAG_PSDENAME = "PSDENAME";
    public static final String TAG_PSDEFID = "PSDEFID";
    public static final String TAG_PSDEFNAME = "PSDEFNAME";
    public static final String TAG_UNIONKEYVALUE = "UNIONKEYVALUE";

    public final boolean isPSSYSBDCOLUMNIDNull() {
        return this.IsParamNull(TAG_PSSYSBDCOLUMNID);
    }

    public final String getPSSYSBDCOLUMNID() {
        return this.GetParamStringValue(TAG_PSSYSBDCOLUMNID, "");
    }

    public final void setPSSYSBDCOLUMNID(String strValue) {
        this.SetParamValue(TAG_PSSYSBDCOLUMNID, strValue);
    }

    public final boolean isPSSYSBDCOLUMNNAMENull() {
        return this.IsParamNull(TAG_PSSYSBDCOLUMNNAME);
    }

    public final String getPSSYSBDCOLUMNNAME() {
        return this.GetParamStringValue(TAG_PSSYSBDCOLUMNNAME, "");
    }

    public final void setPSSYSBDCOLUMNNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSBDCOLUMNNAME, strValue);
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

    public final boolean isCODENAMENull() {
        return this.IsParamNull(TAG_CODENAME);
    }

    public final String getCODENAME() {
        return this.GetParamStringValue(TAG_CODENAME, "");
    }

    public final void setCODENAME(String strValue) {
        this.SetParamValue(TAG_CODENAME, strValue);
    }

    public final boolean isLOGICNAMENull() {
        return this.IsParamNull(TAG_LOGICNAME);
    }

    public final String getLOGICNAME() {
        return this.GetParamStringValue(TAG_LOGICNAME, "");
    }

    public final void setLOGICNAME(String strValue) {
        this.SetParamValue(TAG_LOGICNAME, strValue);
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

    public final boolean isPSDEFIDNull() {
        return this.IsParamNull(TAG_PSDEFID);
    }

    public final String getPSDEFID() {
        return this.GetParamStringValue(TAG_PSDEFID, "");
    }

    public final void setPSDEFID(String strValue) {
        this.SetParamValue(TAG_PSDEFID, strValue);
    }

    public final boolean isPSDEFNAMENull() {
        return this.IsParamNull(TAG_PSDEFNAME);
    }

    public final String getPSDEFNAME() {
        return this.GetParamStringValue(TAG_PSDEFNAME, "");
    }

    public final void setPSDEFNAME(String strValue) {
        this.SetParamValue(TAG_PSDEFNAME, strValue);
    }

    public final boolean isUNIONKEYVALUENull() {
        return this.IsParamNull(TAG_UNIONKEYVALUE);
    }

    public final String getUNIONKEYVALUE() {
        return this.GetParamStringValue(TAG_UNIONKEYVALUE, "");
    }

    public final void setUNIONKEYVALUE(String strValue) {
        this.SetParamValue(TAG_UNIONKEYVALUE, strValue);
    }
}

