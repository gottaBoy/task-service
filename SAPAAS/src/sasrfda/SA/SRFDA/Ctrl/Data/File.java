/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;

public class File
extends BaseDataEntity {
    public static final String TAG_FILE_ID = "FILE_ID";
    public static final String TAG_FILE_NAME = "FILE_NAME";
    public static final String TAG_LOCALPATH = "LOCALPATH";
    public static final String TAG_OWNERTYPE = "OWNERTYPE";
    public static final String TAG_FILESIZE = "FILESIZE";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_OWNERID = "OWNERID";
    public static final String TAG_FOLDER = "FOLDER";
    public static final String TAG_DIGESTCODE = "DIGESTCODE";
    public static final String TAG_PICWIDTH = "PICWIDTH";
    public static final String TAG_PICHEIGHT = "PICHEIGHT";
    public static final String TAG_LOCALPATH2 = "LOCALPATH2";
    public static final String TAG_FILENAME2 = "FILENAME2";

    public String getFILE_ID() {
        return this.GetParamStringValue(TAG_FILE_ID, "").trim();
    }

    public String getFILE_NAME() {
        return this.GetParamStringValue(TAG_FILE_NAME, "");
    }

    public String getOWNERTYPE() {
        return this.GetParamStringValue(TAG_OWNERTYPE, "");
    }

    public String getCREATEMAN() {
        return this.GetParamStringValue(TAG_CREATEMAN, "");
    }

    public String getUPDATEMAN() {
        return this.GetParamStringValue(TAG_UPDATEMAN, "");
    }

    public String getOWNERID() {
        return this.GetParamStringValue(TAG_OWNERID, "");
    }

    public void setFILE_ID(String strValue) {
        this.SetParamValue(TAG_FILE_ID, strValue);
    }

    public void setFILE_NAME(String strValue) {
        this.SetParamValue(TAG_FILE_NAME, strValue);
    }

    public void setOWNERTYPE(String strValue) {
        this.SetParamValue(TAG_OWNERTYPE, strValue);
    }

    public void setCREATEMAN(String strValue) {
        this.SetParamValue(TAG_CREATEMAN, strValue);
    }

    public void setUPDATEMAN(String strValue) {
        this.SetParamValue(TAG_UPDATEMAN, strValue);
    }

    public void setOWNERID(String strValue) {
        this.SetParamValue(TAG_OWNERID, strValue);
    }

    public String getLOCALPATH() {
        return this.GetParamStringValue(TAG_LOCALPATH, "");
    }

    public int getFILESIZE() {
        return this.GetParamIntValue(TAG_FILESIZE, 0);
    }

    public void setLOCALPATH(String strValue) {
        this.SetParamValue(TAG_LOCALPATH, strValue);
    }

    public void setFILESIZE(int nValue) {
        this.SetParamValue(TAG_FILESIZE, nValue);
    }

    public String getFOLDER() {
        return this.GetParamStringValue(TAG_FOLDER, "");
    }

    public void setFOLDER(String strValue) {
        this.SetParamValue(TAG_FOLDER, strValue);
    }

    public final boolean isDIGESTCODENull() {
        return this.IsParamNull(TAG_DIGESTCODE);
    }

    public final String getDIGESTCODE() {
        return this.GetParamStringValue(TAG_DIGESTCODE, "");
    }

    public final void setDIGESTCODE(String strValue) {
        this.SetParamValue(TAG_DIGESTCODE, strValue);
    }

    public final boolean isPICWIDTHNull() {
        return this.IsParamNull(TAG_PICWIDTH);
    }

    public final int getPICWIDTH() {
        return this.GetParamIntValue(TAG_PICWIDTH, 0);
    }

    public final void setPICWIDTH(int nValue) {
        this.SetParamValue(TAG_PICWIDTH, nValue);
    }

    public final boolean isPICHEIGHTNull() {
        return this.IsParamNull(TAG_PICHEIGHT);
    }

    public final int getPICHEIGHT() {
        return this.GetParamIntValue(TAG_PICHEIGHT, 0);
    }

    public final void setPICHEIGHT(int nValue) {
        this.SetParamValue(TAG_PICHEIGHT, nValue);
    }

    public final boolean isLOCALPATH2Null() {
        return this.IsParamNull(TAG_LOCALPATH2);
    }

    public final String getLOCALPATH2() {
        return this.GetParamStringValue(TAG_LOCALPATH2, "");
    }

    public final void setLOCALPATH2(String strValue) {
        this.SetParamValue(TAG_LOCALPATH2, strValue);
    }

    public final boolean isFILENAME2Null() {
        return this.IsParamNull(TAG_FILENAME2);
    }

    public final String getFILENAME2() {
        return this.GetParamStringValue(TAG_FILENAME2, "");
    }

    public final void setFILENAME2(String strValue) {
        this.SetParamValue(TAG_FILENAME2, strValue);
    }
}

