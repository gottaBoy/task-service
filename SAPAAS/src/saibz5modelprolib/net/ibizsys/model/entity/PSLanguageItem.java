/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.entity;

import java.util.Date;
import net.ibizsys.model.entity.BaseDataEntity;

public class PSLanguageItem
extends BaseDataEntity {
    public static final String TAG_PSLANGUAGEITEMID = "PSLANGUAGEITEMID";
    public static final String TAG_PSLANGUAGEITEMNAME = "PSLANGUAGEITEMNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSLANGUAGERESID = "PSLANGUAGERESID";
    public static final String TAG_PSLANGUAGERESNAME = "PSLANGUAGERESNAME";
    public static final String TAG_CONTENT = "CONTENT";
    public static final String TAG_CONTENT2 = "CONTENT2";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_PSLANGUAGEID = "PSLANGUAGEID";
    public static final String TAG_PSLANGUAGENAME = "PSLANGUAGENAME";
    public static final String TAG_PSSYSTEMID = "PSSYSTEMID";
    public static final String TAG_PSSYSTEMNAME = "PSSYSTEMNAME";

    public final boolean isPSLANGUAGEITEMIDNull() {
        return this.isParamNull(TAG_PSLANGUAGEITEMID);
    }

    public final String getPSLANGUAGEITEMID() {
        return this.getParamStringValue(TAG_PSLANGUAGEITEMID, "");
    }

    public final void setPSLANGUAGEITEMID(String strValue) {
        this.setParamValue(TAG_PSLANGUAGEITEMID, strValue);
    }

    public final boolean isPSLANGUAGEITEMNAMENull() {
        return this.isParamNull(TAG_PSLANGUAGEITEMNAME);
    }

    public final String getPSLANGUAGEITEMNAME() {
        return this.getParamStringValue(TAG_PSLANGUAGEITEMNAME, "");
    }

    public final void setPSLANGUAGEITEMNAME(String strValue) {
        this.setParamValue(TAG_PSLANGUAGEITEMNAME, strValue);
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

    public final boolean isPSLANGUAGERESIDNull() {
        return this.isParamNull(TAG_PSLANGUAGERESID);
    }

    public final String getPSLANGUAGERESID() {
        return this.getParamStringValue(TAG_PSLANGUAGERESID, "");
    }

    public final void setPSLANGUAGERESID(String strValue) {
        this.setParamValue(TAG_PSLANGUAGERESID, strValue);
    }

    public final boolean isPSLANGUAGERESNAMENull() {
        return this.isParamNull(TAG_PSLANGUAGERESNAME);
    }

    public final String getPSLANGUAGERESNAME() {
        return this.getParamStringValue(TAG_PSLANGUAGERESNAME, "");
    }

    public final void setPSLANGUAGERESNAME(String strValue) {
        this.setParamValue(TAG_PSLANGUAGERESNAME, strValue);
    }

    public final boolean isCONTENTNull() {
        return this.isParamNull(TAG_CONTENT);
    }

    public final String getCONTENT() {
        return this.getParamStringValue(TAG_CONTENT, "");
    }

    public final void setCONTENT(String strValue) {
        this.setParamValue(TAG_CONTENT, strValue);
    }

    public final boolean isCONTENT2Null() {
        return this.isParamNull(TAG_CONTENT2);
    }

    public final String getCONTENT2() {
        return this.getParamStringValue(TAG_CONTENT2, "");
    }

    public final void setCONTENT2(String strValue) {
        this.setParamValue(TAG_CONTENT2, strValue);
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

    public final boolean isPSLANGUAGEIDNull() {
        return this.isParamNull(TAG_PSLANGUAGEID);
    }

    public final String getPSLANGUAGEID() {
        return this.getParamStringValue(TAG_PSLANGUAGEID, "");
    }

    public final void setPSLANGUAGEID(String strValue) {
        this.setParamValue(TAG_PSLANGUAGEID, strValue);
    }

    public final boolean isPSLANGUAGENAMENull() {
        return this.isParamNull(TAG_PSLANGUAGENAME);
    }

    public final String getPSLANGUAGENAME() {
        return this.getParamStringValue(TAG_PSLANGUAGENAME, "");
    }

    public final void setPSLANGUAGENAME(String strValue) {
        this.setParamValue(TAG_PSLANGUAGENAME, strValue);
    }

    public final boolean isPSSYSTEMIDNull() {
        return this.isParamNull(TAG_PSSYSTEMID);
    }

    public final String getPSSYSTEMID() {
        return this.getParamStringValue(TAG_PSSYSTEMID, "");
    }

    public final void setPSSYSTEMID(String strValue) {
        this.setParamValue(TAG_PSSYSTEMID, strValue);
    }

    public final boolean isPSSYSTEMNAMENull() {
        return this.isParamNull(TAG_PSSYSTEMNAME);
    }

    public final String getPSSYSTEMNAME() {
        return this.getParamStringValue(TAG_PSSYSTEMNAME, "");
    }

    public final void setPSSYSTEMNAME(String strValue) {
        this.setParamValue(TAG_PSSYSTEMNAME, strValue);
    }
}

