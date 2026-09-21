/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSSysCalendarItemRV
extends BaseDataEntity {
    public static final String TAG_PSSYSCALENDARITEMRVID = "PSSYSCALENDARITEMRVID";
    public static final String TAG_PSSYSCALENDARITEMRVNAME = "PSSYSCALENDARITEMRVNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_REFMODETEXT = "REFMODETEXT";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_VIEWPARAMS = "VIEWPARAMS";
    public static final String TAG_PSDEVIEWBASEID = "PSDEVIEWBASEID";
    public static final String TAG_PSDEVIEWBASENAME = "PSDEVIEWBASENAME";
    public static final String TAG_PSSYSCALENDARITEMID = "PSSYSCALENDARITEMID";
    public static final String TAG_PSSYSCALENDARITEMNAME = "PSSYSCALENDARITEMNAME";
    public static final String TAG_PSSYSCALENDARID = "PSSYSCALENDARID";

    public final boolean isPSSYSCALENDARITEMRVIDNull() {
        return this.IsParamNull(TAG_PSSYSCALENDARITEMRVID);
    }

    public final String getPSSYSCALENDARITEMRVID() {
        return this.GetParamStringValue(TAG_PSSYSCALENDARITEMRVID, "");
    }

    public final void setPSSYSCALENDARITEMRVID(String strValue) {
        this.SetParamValue(TAG_PSSYSCALENDARITEMRVID, strValue);
    }

    public final boolean isPSSYSCALENDARITEMRVNAMENull() {
        return this.IsParamNull(TAG_PSSYSCALENDARITEMRVNAME);
    }

    public final String getPSSYSCALENDARITEMRVNAME() {
        return this.GetParamStringValue(TAG_PSSYSCALENDARITEMRVNAME, "");
    }

    public final void setPSSYSCALENDARITEMRVNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSCALENDARITEMRVNAME, strValue);
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

    public final boolean isREFMODETEXTNull() {
        return this.IsParamNull(TAG_REFMODETEXT);
    }

    public final String getREFMODETEXT() {
        return this.GetParamStringValue(TAG_REFMODETEXT, "");
    }

    public final void setREFMODETEXT(String strValue) {
        this.SetParamValue(TAG_REFMODETEXT, strValue);
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

    public final boolean isVIEWPARAMSNull() {
        return this.IsParamNull(TAG_VIEWPARAMS);
    }

    public final String getVIEWPARAMS() {
        return this.GetParamStringValue(TAG_VIEWPARAMS, "");
    }

    public final void setVIEWPARAMS(String strValue) {
        this.SetParamValue(TAG_VIEWPARAMS, strValue);
    }

    public final boolean isPSDEVIEWBASEIDNull() {
        return this.IsParamNull(TAG_PSDEVIEWBASEID);
    }

    public final String getPSDEVIEWBASEID() {
        return this.GetParamStringValue(TAG_PSDEVIEWBASEID, "");
    }

    public final void setPSDEVIEWBASEID(String strValue) {
        this.SetParamValue(TAG_PSDEVIEWBASEID, strValue);
    }

    public final boolean isPSDEVIEWBASENAMENull() {
        return this.IsParamNull(TAG_PSDEVIEWBASENAME);
    }

    public final String getPSDEVIEWBASENAME() {
        return this.GetParamStringValue(TAG_PSDEVIEWBASENAME, "");
    }

    public final void setPSDEVIEWBASENAME(String strValue) {
        this.SetParamValue(TAG_PSDEVIEWBASENAME, strValue);
    }

    public final boolean isPSSYSCALENDARITEMIDNull() {
        return this.IsParamNull(TAG_PSSYSCALENDARITEMID);
    }

    public final String getPSSYSCALENDARITEMID() {
        return this.GetParamStringValue(TAG_PSSYSCALENDARITEMID, "");
    }

    public final void setPSSYSCALENDARITEMID(String strValue) {
        this.SetParamValue(TAG_PSSYSCALENDARITEMID, strValue);
    }

    public final boolean isPSSYSCALENDARITEMNAMENull() {
        return this.IsParamNull(TAG_PSSYSCALENDARITEMNAME);
    }

    public final String getPSSYSCALENDARITEMNAME() {
        return this.GetParamStringValue(TAG_PSSYSCALENDARITEMNAME, "");
    }

    public final void setPSSYSCALENDARITEMNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSCALENDARITEMNAME, strValue);
    }

    public final boolean isPSSYSCALENDARIDNull() {
        return this.IsParamNull(TAG_PSSYSCALENDARID);
    }

    public final String getPSSYSCALENDARID() {
        return this.GetParamStringValue(TAG_PSSYSCALENDARID, "");
    }

    public final void setPSSYSCALENDARID(String strValue) {
        this.SetParamValue(TAG_PSSYSCALENDARID, strValue);
    }
}

