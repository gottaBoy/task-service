/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.IM.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class IMVersion
extends BaseDataEntity {
    public static final String TAG_IMVERSIONID = "IMVERSIONID";
    public static final String TAG_IMVERSIONNAME = "IMVERSIONNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_SUPPORTFLAG = "SUPPORTFLAG";
    public static final String TAG_INSTALLPATH = "INSTALLPATH";
    public static final String TAG_DESCRIPTION = "DESCRIPTION";
    public static final String TAG_INTERNALVER = "INTERNALVER";
    public static final String TAG_CAPTION = "CAPTION";

    public boolean isIMVERSIONIDNull() {
        return this.IsParamNull(TAG_IMVERSIONID);
    }

    public String getIMVERSIONID() {
        return this.GetParamStringValue(TAG_IMVERSIONID, "");
    }

    public void setIMVERSIONID(String strValue) {
        this.SetParamValue(TAG_IMVERSIONID, strValue);
    }

    public boolean isIMVERSIONNAMENull() {
        return this.IsParamNull(TAG_IMVERSIONNAME);
    }

    public String getIMVERSIONNAME() {
        return this.GetParamStringValue(TAG_IMVERSIONNAME, "");
    }

    public void setIMVERSIONNAME(String strValue) {
        this.SetParamValue(TAG_IMVERSIONNAME, strValue);
    }

    public boolean isCREATEMANNull() {
        return this.IsParamNull(TAG_CREATEMAN);
    }

    public String getCREATEMAN() {
        return this.GetParamStringValue(TAG_CREATEMAN, "");
    }

    public void setCREATEMAN(String strValue) {
        this.SetParamValue(TAG_CREATEMAN, strValue);
    }

    public boolean isCREATEDATENull() {
        return this.IsParamNull(TAG_CREATEDATE);
    }

    public Date getCREATEDATE() {
        return this.GetParamDateValue(TAG_CREATEDATE, null);
    }

    public void setCREATEDATE(Date dtValue) {
        this.SetParamValue(TAG_CREATEDATE, dtValue);
    }

    public boolean isUPDATEMANNull() {
        return this.IsParamNull(TAG_UPDATEMAN);
    }

    public String getUPDATEMAN() {
        return this.GetParamStringValue(TAG_UPDATEMAN, "");
    }

    public void setUPDATEMAN(String strValue) {
        this.SetParamValue(TAG_UPDATEMAN, strValue);
    }

    public boolean isUPDATEDATENull() {
        return this.IsParamNull(TAG_UPDATEDATE);
    }

    public Date getUPDATEDATE() {
        return this.GetParamDateValue(TAG_UPDATEDATE, null);
    }

    public void setUPDATEDATE(Date dtValue) {
        this.SetParamValue(TAG_UPDATEDATE, dtValue);
    }

    public boolean isSUPPORTFLAGNull() {
        return this.IsParamNull(TAG_SUPPORTFLAG);
    }

    public boolean getSUPPORTFLAG() {
        return this.GetParamIntValue(TAG_SUPPORTFLAG, 0) == 1;
    }

    public void setSUPPORTFLAG(boolean bValue) {
        this.SetParamValue(TAG_SUPPORTFLAG, bValue ? 1 : 0);
    }

    public boolean isINSTALLPATHNull() {
        return this.IsParamNull(TAG_INSTALLPATH);
    }

    public String getINSTALLPATH() {
        return this.GetParamStringValue(TAG_INSTALLPATH, "");
    }

    public void setINSTALLPATH(String strValue) {
        this.SetParamValue(TAG_INSTALLPATH, strValue);
    }

    public boolean isDESCRIPTIONNull() {
        return this.IsParamNull(TAG_DESCRIPTION);
    }

    public String getDESCRIPTION() {
        return this.GetParamStringValue(TAG_DESCRIPTION, "");
    }

    public void setDESCRIPTION(String strValue) {
        this.SetParamValue(TAG_DESCRIPTION, strValue);
    }

    public boolean isINTERNALVERNull() {
        return this.IsParamNull(TAG_INTERNALVER);
    }

    public int getINTERNALVER() {
        return this.GetParamIntValue(TAG_INTERNALVER, 0);
    }

    public void setINTERNALVER(int nValue) {
        this.SetParamValue(TAG_INTERNALVER, nValue);
    }

    public boolean isCAPTIONNull() {
        return this.IsParamNull(TAG_CAPTION);
    }

    public String getCAPTION() {
        return this.GetParamStringValue(TAG_CAPTION, "");
    }

    public void setCAPTION(String strValue) {
        this.SetParamValue(TAG_CAPTION, strValue);
    }
}

