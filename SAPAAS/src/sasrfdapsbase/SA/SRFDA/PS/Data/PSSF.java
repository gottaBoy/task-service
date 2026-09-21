/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSSF
extends BaseDataEntity {
    public static final String TAG_PSSFID = "PSSFID";
    public static final String TAG_PSSFNAME = "PSSFNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_PKGLOWERCASE = "PKGLOWERCASE";
    public static final String TAG_VIEWPUBOBJ = "VIEWPUBOBJ";
    public static final String TAG_CTRLPUBOBJ = "CTRLPUBOBJ";
    public static final String TAG_CTRLPARTPUBOBJ = "CTRLPARTPUBOBJ";
    public static final String TAG_EDITORPUBOBJ = "EDITORPUBOBJ";
    public static final String TAG_V2FOLDER = "V2FOLDER";
    public static final String TAG_V2GITPATH = "V2GITPATH";
    public static final String TAG_CLSPKGPARAMS = "CLSPKGPARAMS";
    public static final String TAG_CODEFLAG = "CODEFLAG";
    public static final String TAG_DOCFLAG = "DOCFLAG";
    public static final String TAG_MODELFLAG = "MODELFLAG";
    public static final String TAG_SLNFLAG = "SLNFLAG";

    public final boolean isPSSFIDNull() {
        return this.IsParamNull(TAG_PSSFID);
    }

    public final String getPSSFID() {
        return this.GetParamStringValue(TAG_PSSFID, "");
    }

    public final void setPSSFID(String strValue) {
        this.SetParamValue(TAG_PSSFID, strValue);
    }

    public final boolean isPSSFNAMENull() {
        return this.IsParamNull(TAG_PSSFNAME);
    }

    public final String getPSSFNAME() {
        return this.GetParamStringValue(TAG_PSSFNAME, "");
    }

    public final void setPSSFNAME(String strValue) {
        this.SetParamValue(TAG_PSSFNAME, strValue);
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

    public final boolean isMEMONull() {
        return this.IsParamNull(TAG_MEMO);
    }

    public final String getMEMO() {
        return this.GetParamStringValue(TAG_MEMO, "");
    }

    public final void setMEMO(String strValue) {
        this.SetParamValue(TAG_MEMO, strValue);
    }

    public final boolean isVIEWPUBOBJNull() {
        return this.IsParamNull(TAG_VIEWPUBOBJ);
    }

    public final String getVIEWPUBOBJ() {
        return this.GetParamStringValue(TAG_VIEWPUBOBJ, "");
    }

    public final void setVIEWPUBOBJ(String strValue) {
        this.SetParamValue(TAG_VIEWPUBOBJ, strValue);
    }

    public final boolean isCTRLPUBOBJNull() {
        return this.IsParamNull(TAG_CTRLPUBOBJ);
    }

    public final String getCTRLPUBOBJ() {
        return this.GetParamStringValue(TAG_CTRLPUBOBJ, "");
    }

    public final void setCTRLPUBOBJ(String strValue) {
        this.SetParamValue(TAG_CTRLPUBOBJ, strValue);
    }

    public final boolean isCTRLPARTPUBOBJNull() {
        return this.IsParamNull(TAG_CTRLPARTPUBOBJ);
    }

    public final String getCTRLPARTPUBOBJ() {
        return this.GetParamStringValue(TAG_CTRLPARTPUBOBJ, "");
    }

    public final void setCTRLPARTPUBOBJ(String strValue) {
        this.SetParamValue(TAG_CTRLPARTPUBOBJ, strValue);
    }

    public final boolean isEDITORPUBOBJNull() {
        return this.IsParamNull(TAG_EDITORPUBOBJ);
    }

    public final String getEDITORPUBOBJ() {
        return this.GetParamStringValue(TAG_EDITORPUBOBJ, "");
    }

    public final void setEDITORPUBOBJ(String strValue) {
        this.SetParamValue(TAG_EDITORPUBOBJ, strValue);
    }

    public final boolean isPKGLOWERCASENull() {
        return this.IsParamNull(TAG_PKGLOWERCASE);
    }

    public final boolean getPKGLOWERCASE() {
        return this.GetParamIntValue(TAG_PKGLOWERCASE, 0) == 1;
    }

    public final void setPKGLOWERCASE(boolean bValue) {
        this.SetParamValue(TAG_PKGLOWERCASE, bValue ? 1 : 0);
    }

    public final boolean isV2FOLDERNull() {
        return this.IsParamNull(TAG_V2FOLDER);
    }

    public final String getV2FOLDER() {
        return this.GetParamStringValue(TAG_V2FOLDER, "");
    }

    public final void setV2FOLDER(String strValue) {
        this.SetParamValue(TAG_V2FOLDER, strValue);
    }

    public final boolean isV2GITPATHNull() {
        return this.IsParamNull(TAG_V2GITPATH);
    }

    public final String getV2GITPATH() {
        return this.GetParamStringValue(TAG_V2GITPATH, "");
    }

    public final void setV2GITPATH(String strValue) {
        this.SetParamValue(TAG_V2GITPATH, strValue);
    }

    public final boolean isCLSPKGPARAMSNull() {
        return this.IsParamNull(TAG_CLSPKGPARAMS);
    }

    public final String getCLSPKGPARAMS() {
        return this.GetParamStringValue(TAG_CLSPKGPARAMS, "");
    }

    public final void setCLSPKGPARAMS(String strValue) {
        this.SetParamValue(TAG_CLSPKGPARAMS, strValue);
    }

    public final boolean isCODEFLAGNull() {
        return this.IsParamNull(TAG_CODEFLAG);
    }

    public final boolean getCODEFLAG() {
        return this.GetParamIntValue(TAG_CODEFLAG, 0) == 1;
    }

    public final void setCODEFLAG(boolean bValue) {
        this.SetParamValue(TAG_CODEFLAG, bValue ? 1 : 0);
    }

    public final boolean isDOCFLAGNull() {
        return this.IsParamNull(TAG_DOCFLAG);
    }

    public final boolean getDOCFLAG() {
        return this.GetParamIntValue(TAG_DOCFLAG, 0) == 1;
    }

    public final void setDOCFLAG(boolean bValue) {
        this.SetParamValue(TAG_DOCFLAG, bValue ? 1 : 0);
    }

    public final boolean isMODELFLAGNull() {
        return this.IsParamNull(TAG_MODELFLAG);
    }

    public final boolean getMODELFLAG() {
        return this.GetParamIntValue(TAG_MODELFLAG, 0) == 1;
    }

    public final void setMODELFLAG(boolean bValue) {
        this.SetParamValue(TAG_MODELFLAG, bValue ? 1 : 0);
    }

    public final boolean isSLNFLAGNull() {
        return this.IsParamNull(TAG_SLNFLAG);
    }

    public final boolean getSLNFLAG() {
        return this.GetParamIntValue(TAG_SLNFLAG, 0) == 1;
    }

    public final void setSLNFLAG(boolean bValue) {
        this.SetParamValue(TAG_SLNFLAG, bValue ? 1 : 0);
    }
}

