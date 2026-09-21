/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.BI.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class BIRepFI
extends BaseDataEntity {
    public static final String TAG_BIREPFIID = "BIREPFIID";
    public static final String TAG_BIREPFINAME = "BIREPFINAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_BIREPFILTERNAME = "BIREPFILTERNAME";
    public static final String TAG_BIREPFILTERID = "BIREPFILTERID";
    public static final String TAG_FITYPE = "FITYPE";
    public static final String TAG_ORDERFLAG = "ORDERFLAG";
    public static final String TAG_COLSPAN = "COLSPAN";
    public static final String TAG_FIPARAMS = "FIPARAMS";
    public static final String TAG_CAPTION = "CAPTION";
    public static final String TAG_SHOWCAPTION = "SHOWCAPTION";
    public static final String TAG_BICUBEID = "BICUBEID";
    public static final String TAG_BICUBEDIMENSIONID = "BICUBEDIMENSIONID";
    public static final String TAG_BICUBEDIMENSIONNAME = "BICUBEDIMENSIONNAME";

    public boolean isBIREPFIIDNull() {
        return this.IsParamNull(TAG_BIREPFIID);
    }

    public String getBIREPFIID() {
        return this.GetParamStringValue(TAG_BIREPFIID, "");
    }

    public void setBIREPFIID(String strValue) {
        this.SetParamValue(TAG_BIREPFIID, strValue);
    }

    public boolean isBIREPFINAMENull() {
        return this.IsParamNull(TAG_BIREPFINAME);
    }

    public String getBIREPFINAME() {
        return this.GetParamStringValue(TAG_BIREPFINAME, "");
    }

    public void setBIREPFINAME(String strValue) {
        this.SetParamValue(TAG_BIREPFINAME, strValue);
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

    public void setCREATEDATE(Date strValue) {
        this.SetParamValue(TAG_CREATEDATE, strValue);
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

    public void setUPDATEDATE(Date strValue) {
        this.SetParamValue(TAG_UPDATEDATE, strValue);
    }

    public boolean isBIREPFILTERNAMENull() {
        return this.IsParamNull(TAG_BIREPFILTERNAME);
    }

    public String getBIREPFILTERNAME() {
        return this.GetParamStringValue(TAG_BIREPFILTERNAME, "");
    }

    public void setBIREPFILTERNAME(String strValue) {
        this.SetParamValue(TAG_BIREPFILTERNAME, strValue);
    }

    public boolean isBIREPFILTERIDNull() {
        return this.IsParamNull(TAG_BIREPFILTERID);
    }

    public String getBIREPFILTERID() {
        return this.GetParamStringValue(TAG_BIREPFILTERID, "");
    }

    public void setBIREPFILTERID(String strValue) {
        this.SetParamValue(TAG_BIREPFILTERID, strValue);
    }

    public boolean isFITYPENull() {
        return this.IsParamNull(TAG_FITYPE);
    }

    public String getFITYPE() {
        return this.GetParamStringValue(TAG_FITYPE, "");
    }

    public void setFITYPE(String strValue) {
        this.SetParamValue(TAG_FITYPE, strValue);
    }

    public boolean isORDERFLAGNull() {
        return this.IsParamNull(TAG_ORDERFLAG);
    }

    public int getORDERFLAG() {
        return this.GetParamIntValue(TAG_ORDERFLAG, 0);
    }

    public void setORDERFLAG(int strValue) {
        this.SetParamValue(TAG_ORDERFLAG, strValue);
    }

    public boolean isCOLSPANNull() {
        return this.IsParamNull(TAG_COLSPAN);
    }

    public int getCOLSPAN() {
        return this.GetParamIntValue(TAG_COLSPAN, 0);
    }

    public void setCOLSPAN(int strValue) {
        this.SetParamValue(TAG_COLSPAN, strValue);
    }

    public boolean isFIPARAMSNull() {
        return this.IsParamNull(TAG_FIPARAMS);
    }

    public String getFIPARAMS() {
        return this.GetParamStringValue(TAG_FIPARAMS, "");
    }

    public void setFIPARAMS(String strValue) {
        this.SetParamValue(TAG_FIPARAMS, strValue);
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

    public boolean isSHOWCAPTIONNull() {
        return this.IsParamNull(TAG_SHOWCAPTION);
    }

    public boolean getSHOWCAPTION() {
        return this.GetParamIntValue(TAG_SHOWCAPTION, 0) == 1;
    }

    public void setSHOWCAPTION(boolean bValue) {
        this.SetParamValue(TAG_SHOWCAPTION, bValue ? 1 : 0);
    }

    public boolean isBICUBEIDNull() {
        return this.IsParamNull(TAG_BICUBEID);
    }

    public String getBICUBEID() {
        return this.GetParamStringValue(TAG_BICUBEID, "");
    }

    public void setBICUBEID(String strValue) {
        this.SetParamValue(TAG_BICUBEID, strValue);
    }

    public boolean isBICUBEDIMENSIONIDNull() {
        return this.IsParamNull(TAG_BICUBEDIMENSIONID);
    }

    public String getBICUBEDIMENSIONID() {
        return this.GetParamStringValue(TAG_BICUBEDIMENSIONID, "");
    }

    public void setBICUBEDIMENSIONID(String strValue) {
        this.SetParamValue(TAG_BICUBEDIMENSIONID, strValue);
    }

    public boolean isBICUBEDIMENSIONNAMENull() {
        return this.IsParamNull(TAG_BICUBEDIMENSIONNAME);
    }

    public String getBICUBEDIMENSIONNAME() {
        return this.GetParamStringValue(TAG_BICUBEDIMENSIONNAME, "");
    }

    public void setBICUBEDIMENSIONNAME(String strValue) {
        this.SetParamValue(TAG_BICUBEDIMENSIONNAME, strValue);
    }
}

