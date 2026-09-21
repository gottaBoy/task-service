/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSDBSysProcTempl
extends BaseDataEntity {
    public static final String TAG_PSDBSYSPROCTEMPLID = "PSDBSYSPROCTEMPLID";
    public static final String TAG_PSDBSYSPROCTEMPLNAME = "PSDBSYSPROCTEMPLNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSDBTYPEID = "PSDBTYPEID";
    public static final String TAG_PSDBTYPENAME = "PSDBTYPENAME";
    public static final String TAG_PSDBSYSPROCTYPEID = "PSDBSYSPROCTYPEID";
    public static final String TAG_PSDBSYSPROCTYPENAME = "PSDBSYSPROCTYPENAME";
    public static final String TAG_CODETEMPL = "CODETEMPL";
    public static final String TAG_PUBOBJ = "PUBOBJ";
    public static final String TAG_MEMO = "MEMO";

    public final boolean isPSDBSYSPROCTEMPLIDNull() {
        return this.IsParamNull(TAG_PSDBSYSPROCTEMPLID);
    }

    public final String getPSDBSYSPROCTEMPLID() {
        return this.GetParamStringValue(TAG_PSDBSYSPROCTEMPLID, "");
    }

    public final void setPSDBSYSPROCTEMPLID(String strValue) {
        this.SetParamValue(TAG_PSDBSYSPROCTEMPLID, strValue);
    }

    public final boolean isPSDBSYSPROCTEMPLNAMENull() {
        return this.IsParamNull(TAG_PSDBSYSPROCTEMPLNAME);
    }

    public final String getPSDBSYSPROCTEMPLNAME() {
        return this.GetParamStringValue(TAG_PSDBSYSPROCTEMPLNAME, "");
    }

    public final void setPSDBSYSPROCTEMPLNAME(String strValue) {
        this.SetParamValue(TAG_PSDBSYSPROCTEMPLNAME, strValue);
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

    public final boolean isPSDBTYPEIDNull() {
        return this.IsParamNull(TAG_PSDBTYPEID);
    }

    public final String getPSDBTYPEID() {
        return this.GetParamStringValue(TAG_PSDBTYPEID, "");
    }

    public final void setPSDBTYPEID(String strValue) {
        this.SetParamValue(TAG_PSDBTYPEID, strValue);
    }

    public final boolean isPSDBTYPENAMENull() {
        return this.IsParamNull(TAG_PSDBTYPENAME);
    }

    public final String getPSDBTYPENAME() {
        return this.GetParamStringValue(TAG_PSDBTYPENAME, "");
    }

    public final void setPSDBTYPENAME(String strValue) {
        this.SetParamValue(TAG_PSDBTYPENAME, strValue);
    }

    public final boolean isPSDBSYSPROCTYPEIDNull() {
        return this.IsParamNull(TAG_PSDBSYSPROCTYPEID);
    }

    public final String getPSDBSYSPROCTYPEID() {
        return this.GetParamStringValue(TAG_PSDBSYSPROCTYPEID, "");
    }

    public final void setPSDBSYSPROCTYPEID(String strValue) {
        this.SetParamValue(TAG_PSDBSYSPROCTYPEID, strValue);
    }

    public final boolean isPSDBSYSPROCTYPENAMENull() {
        return this.IsParamNull(TAG_PSDBSYSPROCTYPENAME);
    }

    public final String getPSDBSYSPROCTYPENAME() {
        return this.GetParamStringValue(TAG_PSDBSYSPROCTYPENAME, "");
    }

    public final void setPSDBSYSPROCTYPENAME(String strValue) {
        this.SetParamValue(TAG_PSDBSYSPROCTYPENAME, strValue);
    }

    public final boolean isCODETEMPLNull() {
        return this.IsParamNull(TAG_CODETEMPL);
    }

    public final String getCODETEMPL() {
        return this.GetParamStringValue(TAG_CODETEMPL, "");
    }

    public final void setCODETEMPL(String strValue) {
        this.SetParamValue(TAG_CODETEMPL, strValue);
    }

    public final boolean isPUBOBJNull() {
        return this.IsParamNull(TAG_PUBOBJ);
    }

    public final String getPUBOBJ() {
        return this.GetParamStringValue(TAG_PUBOBJ, "");
    }

    public final void setPUBOBJ(String strValue) {
        this.SetParamValue(TAG_PUBOBJ, strValue);
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

