/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSImageTempl
extends BaseDataEntity {
    public static final String TAG_PSIMAGETEMPLID = "PSIMAGETEMPLID";
    public static final String TAG_PSIMAGETEMPLNAME = "PSIMAGETEMPLNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_IMAGEPATH = "IMAGEPATH";
    public static final String TAG_CSSCLASS = "CSSCLASS";
    public static final String TAG_WIDTH = "WIDTH";
    public static final String TAG_HEIGHT = "HEIGHT";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_GLYPH = "GLYPH";

    public final boolean isPSIMAGETEMPLIDNull() {
        return this.IsParamNull(TAG_PSIMAGETEMPLID);
    }

    public final String getPSIMAGETEMPLID() {
        return this.GetParamStringValue(TAG_PSIMAGETEMPLID, "");
    }

    public final void setPSIMAGETEMPLID(String strValue) {
        this.SetParamValue(TAG_PSIMAGETEMPLID, strValue);
    }

    public final boolean isPSIMAGETEMPLNAMENull() {
        return this.IsParamNull(TAG_PSIMAGETEMPLNAME);
    }

    public final String getPSIMAGETEMPLNAME() {
        return this.GetParamStringValue(TAG_PSIMAGETEMPLNAME, "");
    }

    public final void setPSIMAGETEMPLNAME(String strValue) {
        this.SetParamValue(TAG_PSIMAGETEMPLNAME, strValue);
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

    public final boolean isIMAGEPATHNull() {
        return this.IsParamNull(TAG_IMAGEPATH);
    }

    public final String getIMAGEPATH() {
        return this.GetParamStringValue(TAG_IMAGEPATH, "");
    }

    public final void setIMAGEPATH(String strValue) {
        this.SetParamValue(TAG_IMAGEPATH, strValue);
    }

    public final boolean isCSSCLASSNull() {
        return this.IsParamNull(TAG_CSSCLASS);
    }

    public final String getCSSCLASS() {
        return this.GetParamStringValue(TAG_CSSCLASS, "");
    }

    public final void setCSSCLASS(String strValue) {
        this.SetParamValue(TAG_CSSCLASS, strValue);
    }

    public final boolean isWIDTHNull() {
        return this.IsParamNull(TAG_WIDTH);
    }

    public final int getWIDTH() {
        return this.GetParamIntValue(TAG_WIDTH, 0);
    }

    public final void setWIDTH(int nValue) {
        this.SetParamValue(TAG_WIDTH, nValue);
    }

    public final boolean isHEIGHTNull() {
        return this.IsParamNull(TAG_HEIGHT);
    }

    public final int getHEIGHT() {
        return this.GetParamIntValue(TAG_HEIGHT, 0);
    }

    public final void setHEIGHT(int nValue) {
        this.SetParamValue(TAG_HEIGHT, nValue);
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

    public final boolean isGLYPHNull() {
        return this.IsParamNull(TAG_GLYPH);
    }

    public final String getGLYPH() {
        return this.GetParamStringValue(TAG_GLYPH, "");
    }

    public final void setGLYPH(String strValue) {
        this.SetParamValue(TAG_GLYPH, strValue);
    }
}

