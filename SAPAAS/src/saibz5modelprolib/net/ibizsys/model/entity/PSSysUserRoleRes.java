/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.entity;

import java.util.Date;
import net.ibizsys.model.entity.BaseDataEntity;

public class PSSysUserRoleRes
extends BaseDataEntity {
    public static final String TAG_PSSYSUSERROLERESID = "PSSYSUSERROLERESID";
    public static final String TAG_PSSYSUSERROLERESNAME = "PSSYSUSERROLERESNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSSYSOPPRIVID = "PSSYSOPPRIVID";
    public static final String TAG_PSSYSOPPRIVNAME = "PSSYSOPPRIVNAME";
    public static final String TAG_PSSYSUNIRESID = "PSSYSUNIRESID";
    public static final String TAG_PSSYSUNIRESNAME = "PSSYSUNIRESNAME";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";
    public static final String TAG_MEMO = "MEMO";

    public final boolean isPSSYSUSERROLERESIDNull() {
        return this.isParamNull(TAG_PSSYSUSERROLERESID);
    }

    public final String getPSSYSUSERROLERESID() {
        return this.getParamStringValue(TAG_PSSYSUSERROLERESID, "");
    }

    public final void setPSSYSUSERROLERESID(String strValue) {
        this.setParamValue(TAG_PSSYSUSERROLERESID, strValue);
    }

    public final boolean isPSSYSUSERROLERESNAMENull() {
        return this.isParamNull(TAG_PSSYSUSERROLERESNAME);
    }

    public final String getPSSYSUSERROLERESNAME() {
        return this.getParamStringValue(TAG_PSSYSUSERROLERESNAME, "");
    }

    public final void setPSSYSUSERROLERESNAME(String strValue) {
        this.setParamValue(TAG_PSSYSUSERROLERESNAME, strValue);
    }

    public final boolean isCREATEMANNull() {
        return this.isParamNull(TAG_CREATEMAN);
    }

    public final String getCREATEMAN() {
        return this.getParamStringValue(TAG_CREATEMAN, "");
    }

    public final void setCREATEMAN(String strValue) {
        this.setParamValue(TAG_CREATEMAN, strValue);
    }

    public final boolean isCREATEDATENull() {
        return this.isParamNull(TAG_CREATEDATE);
    }

    public final Date getCREATEDATE() {
        return this.getParamDateValue(TAG_CREATEDATE, null);
    }

    public final void setCREATEDATE(Date dtValue) {
        this.setParamValue(TAG_CREATEDATE, dtValue);
    }

    public final boolean isUPDATEMANNull() {
        return this.isParamNull(TAG_UPDATEMAN);
    }

    public final String getUPDATEMAN() {
        return this.getParamStringValue(TAG_UPDATEMAN, "");
    }

    public final void setUPDATEMAN(String strValue) {
        this.setParamValue(TAG_UPDATEMAN, strValue);
    }

    public final boolean isUPDATEDATENull() {
        return this.isParamNull(TAG_UPDATEDATE);
    }

    public final Date getUPDATEDATE() {
        return this.getParamDateValue(TAG_UPDATEDATE, null);
    }

    public final void setUPDATEDATE(Date dtValue) {
        this.setParamValue(TAG_UPDATEDATE, dtValue);
    }

    public final boolean isPSSYSOPPRIVIDNull() {
        return this.isParamNull(TAG_PSSYSOPPRIVID);
    }

    public final String getPSSYSOPPRIVID() {
        return this.getParamStringValue(TAG_PSSYSOPPRIVID, "");
    }

    public final void setPSSYSOPPRIVID(String strValue) {
        this.setParamValue(TAG_PSSYSOPPRIVID, strValue);
    }

    public final boolean isPSSYSOPPRIVNAMENull() {
        return this.isParamNull(TAG_PSSYSOPPRIVNAME);
    }

    public final String getPSSYSOPPRIVNAME() {
        return this.getParamStringValue(TAG_PSSYSOPPRIVNAME, "");
    }

    public final void setPSSYSOPPRIVNAME(String strValue) {
        this.setParamValue(TAG_PSSYSOPPRIVNAME, strValue);
    }

    public final boolean isPSSYSUNIRESIDNull() {
        return this.isParamNull(TAG_PSSYSUNIRESID);
    }

    public final String getPSSYSUNIRESID() {
        return this.getParamStringValue(TAG_PSSYSUNIRESID, "");
    }

    public final void setPSSYSUNIRESID(String strValue) {
        this.setParamValue(TAG_PSSYSUNIRESID, strValue);
    }

    public final boolean isPSSYSUNIRESNAMENull() {
        return this.isParamNull(TAG_PSSYSUNIRESNAME);
    }

    public final String getPSSYSUNIRESNAME() {
        return this.getParamStringValue(TAG_PSSYSUNIRESNAME, "");
    }

    public final void setPSSYSUNIRESNAME(String strValue) {
        this.setParamValue(TAG_PSSYSUNIRESNAME, strValue);
    }

    public final boolean isVALIDFLAGNull() {
        return this.isParamNull(TAG_VALIDFLAG);
    }

    public final boolean getVALIDFLAG() {
        return this.getParamIntValue(TAG_VALIDFLAG, 0) == 1;
    }

    public final void setVALIDFLAG(boolean bValue) {
        this.setParamValue(TAG_VALIDFLAG, bValue ? 1 : 0);
    }

    public final boolean isMEMONull() {
        return this.isParamNull(TAG_MEMO);
    }

    public final String getMEMO() {
        return this.getParamStringValue(TAG_MEMO, "");
    }

    public final void setMEMO(String strValue) {
        this.setParamValue(TAG_MEMO, strValue);
    }
}

