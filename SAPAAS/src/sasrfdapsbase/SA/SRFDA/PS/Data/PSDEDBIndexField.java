/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSDEDBIndexField
extends BaseDataEntity {
    public static final String SORTDIR_ASC = "ASC";
    public static final String SORTDIR_DESC = "DESC";
    public static final String TAG_PSDEDBIDXFIELDID = "PSDEDBIDXFIELDID";
    public static final String TAG_PSDEDBIDXFIELDNAME = "PSDEDBIDXFIELDNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSDEDBINDEXID = "PSDEDBINDEXID";
    public static final String TAG_PSDEDBINDEXNAME = "PSDEDBINDEXNAME";
    public static final String TAG_PSDEFID = "PSDEFID";
    public static final String TAG_PSDEFNAME = "PSDEFNAME";
    public static final String TAG_INCMODE = "INCMODE";
    public static final String TAG_SORTDIR = "SORTDIR";
    public static final String TAG_INDEXLENGTH = "INDEXLENGTH";

    public final boolean isPSDEDBIDXFIELDIDNull() {
        return this.IsParamNull(TAG_PSDEDBIDXFIELDID);
    }

    public final String getPSDEDBIDXFIELDID() {
        return this.GetParamStringValue(TAG_PSDEDBIDXFIELDID, "");
    }

    public final void setPSDEDBIDXFIELDID(String strValue) {
        this.SetParamValue(TAG_PSDEDBIDXFIELDID, strValue);
    }

    public final boolean isPSDEDBIDXFIELDNAMENull() {
        return this.IsParamNull(TAG_PSDEDBIDXFIELDNAME);
    }

    public final String getPSDEDBIDXFIELDNAME() {
        return this.GetParamStringValue(TAG_PSDEDBIDXFIELDNAME, "");
    }

    public final void setPSDEDBIDXFIELDNAME(String strValue) {
        this.SetParamValue(TAG_PSDEDBIDXFIELDNAME, strValue);
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

    public final boolean isINCMODENull() {
        return this.IsParamNull(TAG_INCMODE);
    }

    public final boolean getINCMODE() {
        return this.GetParamIntValue(TAG_INCMODE, 0) == 1;
    }

    public final void setINCMODE(boolean bValue) {
        this.SetParamValue(TAG_INCMODE, bValue ? 1 : 0);
    }

    public final boolean isSORTDIRNull() {
        return this.IsParamNull(TAG_SORTDIR);
    }

    public final String getSORTDIR() {
        return this.GetParamStringValue(TAG_SORTDIR, "");
    }

    public final void setSORTDIR(String strValue) {
        this.SetParamValue(TAG_SORTDIR, strValue);
    }

    public final boolean isINDEXLENGTHNull() {
        return this.IsParamNull(TAG_INDEXLENGTH);
    }

    public final int getINDEXLENGTH() {
        return this.GetParamIntValue(TAG_INDEXLENGTH, 0);
    }

    public final void setINDEXLENGTH(int nValue) {
        this.SetParamValue(TAG_INDEXLENGTH, nValue);
    }
}

