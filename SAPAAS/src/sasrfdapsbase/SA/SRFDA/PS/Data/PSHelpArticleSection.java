/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSHelpArticleSection
extends BaseDataEntity {
    public static final String TAG_PSHELPARTSECID = "PSHELPARTSECID";
    public static final String TAG_PSHELPARTSECNAME = "PSHELPARTSECNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSHELPARTICLETYPEID = "PSHELPARTICLETYPEID";
    public static final String TAG_PSHELPARTICLETYPENAME = "PSHELPARTICLETYPENAME";
    public static final String TAG_PSHELPSECTIONTYPEID = "PSHELPSECTIONTYPEID";
    public static final String TAG_PSHELPSECTIONTYPENAME = "PSHELPSECTIONTYPENAME";
    public static final String TAG_ORDERVALUE = "ORDERVALUE";
    public static final String TAG_MEMO = "MEMO";

    public final boolean isPSHELPARTSECIDNull() {
        return this.IsParamNull(TAG_PSHELPARTSECID);
    }

    public final String getPSHELPARTSECID() {
        return this.GetParamStringValue(TAG_PSHELPARTSECID, "");
    }

    public final void setPSHELPARTSECID(String strValue) {
        this.SetParamValue(TAG_PSHELPARTSECID, strValue);
    }

    public final boolean isPSHELPARTSECNAMENull() {
        return this.IsParamNull(TAG_PSHELPARTSECNAME);
    }

    public final String getPSHELPARTSECNAME() {
        return this.GetParamStringValue(TAG_PSHELPARTSECNAME, "");
    }

    public final void setPSHELPARTSECNAME(String strValue) {
        this.SetParamValue(TAG_PSHELPARTSECNAME, strValue);
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

    public final boolean isORDERVALUENull() {
        return this.IsParamNull(TAG_ORDERVALUE);
    }

    public final int getORDERVALUE() {
        return this.GetParamIntValue(TAG_ORDERVALUE, 0);
    }

    public final void setORDERVALUE(int nValue) {
        this.SetParamValue(TAG_ORDERVALUE, nValue);
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

