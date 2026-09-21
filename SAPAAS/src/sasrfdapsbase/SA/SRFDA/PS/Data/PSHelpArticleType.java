/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSHelpArticleType
extends BaseDataEntity {
    public static final String TAG_PSHELPARTICLETYPEID = "PSHELPARTICLETYPEID";
    public static final String TAG_PSHELPARTICLETYPENAME = "PSHELPARTICLETYPENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_TYPEOBJ = "TYPEOBJ";
    public static final String TAG_ARTICLEOBJ = "ARTICLEOBJ";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_PUBOBJ = "PUBOBJ";
    public static final String TAG_PSHELPARTICLETEMPLID = "PSHELPARTICLETEMPLID";
    public static final String TAG_PSHELPARTICLETEMPLNAME = "PSHELPARTICLETEMPLNAME";

    public final boolean isPSHELPARTICLETYPEIDNull() {
        return this.IsParamNull(TAG_PSHELPARTICLETYPEID);
    }

    public final String getPSHELPARTICLETYPEID() {
        return this.GetParamStringValue(TAG_PSHELPARTICLETYPEID, "");
    }

    public final void setPSHELPARTICLETYPEID(String strValue) {
        this.SetParamValue(TAG_PSHELPARTICLETYPEID, strValue);
    }

    public final boolean isPSHELPARTICLETYPENAMENull() {
        return this.IsParamNull(TAG_PSHELPARTICLETYPENAME);
    }

    public final String getPSHELPARTICLETYPENAME() {
        return this.GetParamStringValue(TAG_PSHELPARTICLETYPENAME, "");
    }

    public final void setPSHELPARTICLETYPENAME(String strValue) {
        this.SetParamValue(TAG_PSHELPARTICLETYPENAME, strValue);
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

    public final boolean isARTICLEOBJNull() {
        return this.IsParamNull(TAG_ARTICLEOBJ);
    }

    public final String getARTICLEOBJ() {
        return this.GetParamStringValue(TAG_ARTICLEOBJ, "");
    }

    public final void setARTICLEOBJ(String strValue) {
        this.SetParamValue(TAG_ARTICLEOBJ, strValue);
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

    public final boolean isPSHELPARTICLETEMPLIDNull() {
        return this.IsParamNull(TAG_PSHELPARTICLETEMPLID);
    }

    public final String getPSHELPARTICLETEMPLID() {
        return this.GetParamStringValue(TAG_PSHELPARTICLETEMPLID, "");
    }

    public final void setPSHELPARTICLETEMPLID(String strValue) {
        this.SetParamValue(TAG_PSHELPARTICLETEMPLID, strValue);
    }

    public final boolean isPSHELPARTICLETEMPLNAMENull() {
        return this.IsParamNull(TAG_PSHELPARTICLETEMPLNAME);
    }

    public final String getPSHELPARTICLETEMPLNAME() {
        return this.GetParamStringValue(TAG_PSHELPARTICLETEMPLNAME, "");
    }

    public final void setPSHELPARTICLETEMPLNAME(String strValue) {
        this.SetParamValue(TAG_PSHELPARTICLETEMPLNAME, strValue);
    }
}

