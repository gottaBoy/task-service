/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.entity;

import java.util.Date;
import net.ibizsys.model.entity.BaseDataEntity;

public class PSSysImage
extends BaseDataEntity {
    public static final String TAG_PSSYSIMAGEID = "PSSYSIMAGEID";
    public static final String TAG_PSSYSIMAGENAME = "PSSYSIMAGENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSSYSTEMID = "PSSYSTEMID";
    public static final String TAG_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String TAG_PSIMAGETEMPLID = "PSIMAGETEMPLID";
    public static final String TAG_PSIMAGETEMPLNAME = "PSIMAGETEMPLNAME";
    public static final String TAG_IMAGEPATH = "IMAGEPATH";
    public static final String TAG_CSSCLASS = "CSSCLASS";
    public static final String TAG_WIDTH = "WIDTH";
    public static final String TAG_HEIGHT = "HEIGHT";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_GLYPH = "GLYPH";
    public static final String TAG_CSSCLASSX = "CSSCLASSX";
    public static final String TAG_IMAGEPATHX = "IMAGEPATHX";

    public final boolean isPSSYSIMAGEIDNull() {
        return this.isParamNull(TAG_PSSYSIMAGEID);
    }

    public final String getPSSYSIMAGEID() {
        return this.getParamStringValue(TAG_PSSYSIMAGEID, "");
    }

    public final void setPSSYSIMAGEID(String strValue) {
        this.setParamValue(TAG_PSSYSIMAGEID, strValue);
    }

    public final boolean isPSSYSIMAGENAMENull() {
        return this.isParamNull(TAG_PSSYSIMAGENAME);
    }

    public final String getPSSYSIMAGENAME() {
        return this.getParamStringValue(TAG_PSSYSIMAGENAME, "");
    }

    public final void setPSSYSIMAGENAME(String strValue) {
        this.setParamValue(TAG_PSSYSIMAGENAME, strValue);
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

    public final boolean isPSIMAGETEMPLIDNull() {
        return this.isParamNull(TAG_PSIMAGETEMPLID);
    }

    public final String getPSIMAGETEMPLID() {
        return this.getParamStringValue(TAG_PSIMAGETEMPLID, "");
    }

    public final void setPSIMAGETEMPLID(String strValue) {
        this.setParamValue(TAG_PSIMAGETEMPLID, strValue);
    }

    public final boolean isPSIMAGETEMPLNAMENull() {
        return this.isParamNull(TAG_PSIMAGETEMPLNAME);
    }

    public final String getPSIMAGETEMPLNAME() {
        return this.getParamStringValue(TAG_PSIMAGETEMPLNAME, "");
    }

    public final void setPSIMAGETEMPLNAME(String strValue) {
        this.setParamValue(TAG_PSIMAGETEMPLNAME, strValue);
    }

    public final boolean isIMAGEPATHNull() {
        return this.isParamNull(TAG_IMAGEPATH);
    }

    public final String getIMAGEPATH() {
        return this.getParamStringValue(TAG_IMAGEPATH, "");
    }

    public final void setIMAGEPATH(String strValue) {
        this.setParamValue(TAG_IMAGEPATH, strValue);
    }

    public final boolean isCSSCLASSNull() {
        return this.isParamNull(TAG_CSSCLASS);
    }

    public final String getCSSCLASS() {
        return this.getParamStringValue(TAG_CSSCLASS, "");
    }

    public final void setCSSCLASS(String strValue) {
        this.setParamValue(TAG_CSSCLASS, strValue);
    }

    public final boolean isWIDTHNull() {
        return this.isParamNull(TAG_WIDTH);
    }

    public final int getWIDTH() {
        return this.getParamIntValue(TAG_WIDTH, 0);
    }

    public final void setWIDTH(int nValue) {
        this.setParamValue(TAG_WIDTH, nValue);
    }

    public final boolean isHEIGHTNull() {
        return this.isParamNull(TAG_HEIGHT);
    }

    public final int getHEIGHT() {
        return this.getParamIntValue(TAG_HEIGHT, 0);
    }

    public final void setHEIGHT(int nValue) {
        this.setParamValue(TAG_HEIGHT, nValue);
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

    public final boolean isGLYPHNull() {
        return this.isParamNull(TAG_GLYPH);
    }

    public final String getGLYPH() {
        return this.getParamStringValue(TAG_GLYPH, "");
    }

    public final void setGLYPH(String strValue) {
        this.setParamValue(TAG_GLYPH, strValue);
    }

    public final boolean isCSSCLASSXNull() {
        return this.isParamNull(TAG_CSSCLASSX);
    }

    public final String getCSSCLASSX() {
        return this.getParamStringValue(TAG_CSSCLASSX, "");
    }

    public final void setCSSCLASSX(String strValue) {
        this.setParamValue(TAG_CSSCLASSX, strValue);
    }

    public final boolean isIMAGEPATHXNull() {
        return this.isParamNull(TAG_IMAGEPATHX);
    }

    public final String getIMAGEPATHX() {
        return this.getParamStringValue(TAG_IMAGEPATHX, "");
    }

    public final void setIMAGEPATHX(String strValue) {
        this.setParamValue(TAG_IMAGEPATHX, strValue);
    }
}

