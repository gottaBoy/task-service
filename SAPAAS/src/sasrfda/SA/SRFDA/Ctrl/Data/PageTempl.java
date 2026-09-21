/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PageTempl
extends BaseDataEntity {
    public static final String TAG_PAGETEMPLID = "PAGETEMPLID";
    public static final String TAG_PAGETEMPLNAME = "PAGETEMPLNAME";
    public static final String TAG_ENABLE = "ENABLE";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PAGEPARAM = "PAGEPARAM";
    public static final String TAG_PAGEPATH = "PAGEPATH";
    public static final String TAG_VERSION = "VERSION";
    public static final String TAG_ISSYTEM = "ISSYTEM";
    public static final String TAG_TOOLBAR = "TOOLBAR";
    public static final String TAG_DESCRIPTION = "DESCRIPTION";
    public static final String TAG_PAGEFUNC = "PAGEFUNC";
    public static final String TAG_DEFAULTPAGEFUNC = "DEFAULTPAGEFUNC";
    public static final String TAG_PAGEFUNC2 = "PAGEFUNC2";

    public String getPAGETEMPLID() {
        return this.GetParamStringValue(TAG_PAGETEMPLID, "");
    }

    public void setPAGETEMPLID(String strValue) {
        this.SetParamValue(TAG_PAGETEMPLID, strValue);
    }

    public String getPAGETEMPLNAME() {
        return this.GetParamStringValue(TAG_PAGETEMPLNAME, "");
    }

    public void setPAGETEMPLNAME(String strValue) {
        this.SetParamValue(TAG_PAGETEMPLNAME, strValue);
    }

    public boolean getENABLE() {
        return this.GetParamIntValue(TAG_ENABLE, 0) == 1;
    }

    public void setENABLE(boolean bValue) {
        this.SetParamValue(TAG_ENABLE, bValue ? 1 : 0);
    }

    public String getCREATEMAN() {
        return this.GetParamStringValue(TAG_CREATEMAN, "");
    }

    public void setCREATEMAN(String strValue) {
        this.SetParamValue(TAG_CREATEMAN, strValue);
    }

    public Date getCREATEDATE() {
        return this.GetParamDateValue(TAG_CREATEDATE, null);
    }

    public void setCREATEDATE(Date strValue) {
        this.SetParamValue(TAG_CREATEDATE, strValue);
    }

    public String getUPDATEMAN() {
        return this.GetParamStringValue(TAG_UPDATEMAN, "");
    }

    public void setUPDATEMAN(String strValue) {
        this.SetParamValue(TAG_UPDATEMAN, strValue);
    }

    public Date getUPDATEDATE() {
        return this.GetParamDateValue(TAG_UPDATEDATE, null);
    }

    public void setUPDATEDATE(Date strValue) {
        this.SetParamValue(TAG_UPDATEDATE, strValue);
    }

    public String getPAGEPARAM() {
        return this.GetParamStringValue(TAG_PAGEPARAM, "");
    }

    public void setPAGEPARAM(String strValue) {
        this.SetParamValue(TAG_PAGEPARAM, strValue);
    }

    public String getPAGEPATH() {
        return this.GetParamStringValue(TAG_PAGEPATH, "");
    }

    public void setPAGEPATH(String strValue) {
        this.SetParamValue(TAG_PAGEPATH, strValue);
    }

    public int getVERSION() {
        return this.GetParamIntValue(TAG_VERSION, 0);
    }

    public void setVERSION(int strValue) {
        this.SetParamValue(TAG_VERSION, strValue);
    }

    public boolean getISSYTEM() {
        return this.GetParamIntValue(TAG_ISSYTEM, 0) == 1;
    }

    public void setISSYTEM(boolean bValue) {
        this.SetParamValue(TAG_ISSYTEM, bValue ? 1 : 0);
    }

    public String getTOOLBAR() {
        return this.GetParamStringValue(TAG_TOOLBAR, "");
    }

    public void setTOOLBAR(String strValue) {
        this.SetParamValue(TAG_TOOLBAR, strValue);
    }

    public String getDESCRIPTION() {
        return this.GetParamStringValue(TAG_DESCRIPTION, "");
    }

    public void setDESCRIPTION(String strValue) {
        this.SetParamValue(TAG_DESCRIPTION, strValue);
    }

    public int getPAGEFUNC() {
        return this.GetParamIntValue(TAG_PAGEFUNC, 0);
    }

    public void setPAGEFUNC(int strValue) {
        this.SetParamValue(TAG_PAGEFUNC, strValue);
    }

    public boolean getDEFAULTPAGEFUNC() {
        return this.GetParamIntValue(TAG_DEFAULTPAGEFUNC, 0) == 1;
    }

    public void setDEFAULTPAGEFUNC(boolean bValue) {
        this.SetParamValue(TAG_DEFAULTPAGEFUNC, bValue ? 1 : 0);
    }

    public String getPAGEFUNC2() {
        return this.GetParamStringValue(TAG_PAGEFUNC2, "");
    }

    public void setPAGEFUNC2(String strValue) {
        this.SetParamValue(TAG_PAGEFUNC2, strValue);
    }
}

