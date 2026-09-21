/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.entity;

import java.util.Date;
import net.ibizsys.model.entity.BaseDataEntity;

public class PSWFLinkCondType
extends BaseDataEntity {
    public static final String TAG_PSWFLINKCONDTYPEID = "PSWFLINKCONDTYPEID";
    public static final String TAG_PSWFLINKCONDTYPENAME = "PSWFLINKCONDTYPENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_ITEMOBJ = "ITEMOBJ";
    public static final String TAG_MEMO = "MEMO";

    public final boolean isPSWFLINKCONDTYPEIDNull() {
        return this.isParamNull(TAG_PSWFLINKCONDTYPEID);
    }

    public final String getPSWFLINKCONDTYPEID() {
        return this.getParamStringValue(TAG_PSWFLINKCONDTYPEID, "");
    }

    public final void setPSWFLINKCONDTYPEID(String strValue) {
        this.setParamValue(TAG_PSWFLINKCONDTYPEID, strValue);
    }

    public final boolean isPSWFLINKCONDTYPENAMENull() {
        return this.isParamNull(TAG_PSWFLINKCONDTYPENAME);
    }

    public final String getPSWFLINKCONDTYPENAME() {
        return this.getParamStringValue(TAG_PSWFLINKCONDTYPENAME, "");
    }

    public final void setPSWFLINKCONDTYPENAME(String strValue) {
        this.setParamValue(TAG_PSWFLINKCONDTYPENAME, strValue);
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

    public final boolean isITEMOBJNull() {
        return this.isParamNull(TAG_ITEMOBJ);
    }

    public final String getITEMOBJ() {
        return this.getParamStringValue(TAG_ITEMOBJ, "");
    }

    public final void setITEMOBJ(String strValue) {
        this.setParamValue(TAG_ITEMOBJ, strValue);
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

