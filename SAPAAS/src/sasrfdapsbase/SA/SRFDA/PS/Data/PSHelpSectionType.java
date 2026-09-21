/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSHelpSectionType
extends BaseDataEntity {
    public static final String TAG_PSHELPSECTIONTYPEID = "PSHELPSECTIONTYPEID";
    public static final String TAG_PSHELPSECTIONTYPENAME = "PSHELPSECTIONTYPENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_TYPEOBJ = "TYPEOBJ";
    public static final String TAG_SECTIONOBJ = "SECTIONOBJ";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_PUBOBJ = "PUBOBJ";
    public static final String TAG_OUTPUTDIR = "OUTPUTDIR";
    public static final String TAG_PSHELPSECTIONTEMPLID = "PSHELPSECTIONTEMPLID";
    public static final String TAG_PSHELPSECTIONTEMPLNAME = "PSHELPSECTIONTEMPLNAME";

    public final boolean isPSHELPSECTIONTYPEIDNull() {
        return this.IsParamNull(TAG_PSHELPSECTIONTYPEID);
    }

    public final String getPSHELPSECTIONTYPEID() {
        return this.GetParamStringValue(TAG_PSHELPSECTIONTYPEID, "");
    }

    public final void setPSHELPSECTIONTYPEID(String strValue) {
        this.SetParamValue(TAG_PSHELPSECTIONTYPEID, strValue);
    }

    public final boolean isPSHELPSECTIONTYPENAMENull() {
        return this.IsParamNull(TAG_PSHELPSECTIONTYPENAME);
    }

    public final String getPSHELPSECTIONTYPENAME() {
        return this.GetParamStringValue(TAG_PSHELPSECTIONTYPENAME, "");
    }

    public final void setPSHELPSECTIONTYPENAME(String strValue) {
        this.SetParamValue(TAG_PSHELPSECTIONTYPENAME, strValue);
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

    public final boolean isTYPEOBJNull() {
        return this.IsParamNull(TAG_TYPEOBJ);
    }

    public final String getTYPEOBJ() {
        return this.GetParamStringValue(TAG_TYPEOBJ, "");
    }

    public final void setTYPEOBJ(String strValue) {
        this.SetParamValue(TAG_TYPEOBJ, strValue);
    }

    public final boolean isSECTIONOBJNull() {
        return this.IsParamNull(TAG_SECTIONOBJ);
    }

    public final String getSECTIONOBJ() {
        return this.GetParamStringValue(TAG_SECTIONOBJ, "");
    }

    public final void setSECTIONOBJ(String strValue) {
        this.SetParamValue(TAG_SECTIONOBJ, strValue);
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

    public final boolean isPUBOBJNull() {
        return this.IsParamNull(TAG_PUBOBJ);
    }

    public final String getPUBOBJ() {
        return this.GetParamStringValue(TAG_PUBOBJ, "");
    }

    public final void setPUBOBJ(String strValue) {
        this.SetParamValue(TAG_PUBOBJ, strValue);
    }

    public final boolean isOUTPUTDIRNull() {
        return this.IsParamNull(TAG_OUTPUTDIR);
    }

    public final boolean getOUTPUTDIR() {
        return this.GetParamIntValue(TAG_OUTPUTDIR, 0) == 1;
    }

    public final void setOUTPUTDIR(boolean bValue) {
        this.SetParamValue(TAG_OUTPUTDIR, bValue ? 1 : 0);
    }

    public final boolean isPSHELPSECTIONTEMPLIDNull() {
        return this.IsParamNull(TAG_PSHELPSECTIONTEMPLID);
    }

    public final String getPSHELPSECTIONTEMPLID() {
        return this.GetParamStringValue(TAG_PSHELPSECTIONTEMPLID, "");
    }

    public final void setPSHELPSECTIONTEMPLID(String strValue) {
        this.SetParamValue(TAG_PSHELPSECTIONTEMPLID, strValue);
    }

    public final boolean isPSHELPSECTIONTEMPLNAMENull() {
        return this.IsParamNull(TAG_PSHELPSECTIONTEMPLNAME);
    }

    public final String getPSHELPSECTIONTEMPLNAME() {
        return this.GetParamStringValue(TAG_PSHELPSECTIONTEMPLNAME, "");
    }

    public final void setPSHELPSECTIONTEMPLNAME(String strValue) {
        this.SetParamValue(TAG_PSHELPSECTIONTEMPLNAME, strValue);
    }
}

