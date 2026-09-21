/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.BI.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class BIDimension
extends BaseDataEntity {
    public static final String DIMENSIONTYPE_TIME = "TIMEDIMENSION";
    public static final String DIMENSIONTYPE_STANDARD = "STANDARDDIMENSION";
    public static final String TAG_BIDIMENSIONID = "BIDIMENSIONID";
    public static final String TAG_BIDIMENSIONNAME = "BIDIMENSIONNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_BICUBEDIMENSIONTYPE = "BICUBEDIMENSIONTYPE";
    public static final String TAG_BICUBEID = "BICUBEID";
    public static final String TAG_BICUBENAME = "BICUBENAME";
    public static final String TAG_DIMENSIONTYPE = "DIMENSIONTYPE";
    public static final String TAG_BICATALOGID = "BICATALOGID";
    public static final String TAG_BICATALOGNAME = "BICATALOGNAME";
    public static final String TAG_CAPTION = "CAPTION";
    public static final String TAG_DESCRIPTION = "DESCRIPTION";
    public static final String TAG_ORDERFLAG = "ORDERFLAG";
    public static final String TAG_QUERYCTRL = "QUERYCTRL";
    public static final String TAG_CUSTOMQUERYCTRL = "CUSTOMQUERYCTRL";
    public static final String TAG_QUERYCTRLPARAM = "QUERYCTRLPARAM";
    public static final String TAG_COLUMNWIDTH = "COLUMNWIDTH";
    public static final String TAG_JOINDEFID = "JOINDEFID";
    public static final String TAG_JOINDEFNAME = "JOINDEFNAME";

    public String getBIDIMENSIONID() {
        return this.GetParamStringValue(TAG_BIDIMENSIONID, "");
    }

    public void setBIDIMENSIONID(String strValue) {
        this.SetParamValue(TAG_BIDIMENSIONID, strValue);
    }

    public String getBIDIMENSIONNAME() {
        return this.GetParamStringValue(TAG_BIDIMENSIONNAME, "");
    }

    public void setBIDIMENSIONNAME(String strValue) {
        this.SetParamValue(TAG_BIDIMENSIONNAME, strValue);
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

    public String getBICUBEDIMENSIONTYPE() {
        return this.GetParamStringValue(TAG_BICUBEDIMENSIONTYPE, "");
    }

    public void setBICUBEDIMENSIONTYPE(String strValue) {
        this.SetParamValue(TAG_BICUBEDIMENSIONTYPE, strValue);
    }

    public String getBICUBEID() {
        return this.GetParamStringValue(TAG_BICUBEID, "");
    }

    public void setBICUBEID(String strValue) {
        this.SetParamValue(TAG_BICUBEID, strValue);
    }

    public String getBICUBENAME() {
        return this.GetParamStringValue(TAG_BICUBENAME, "");
    }

    public void setBICUBENAME(String strValue) {
        this.SetParamValue(TAG_BICUBENAME, strValue);
    }

    public String getDIMENSIONTYPE() {
        return this.GetParamStringValue(TAG_DIMENSIONTYPE, "");
    }

    public void setDIMENSIONTYPE(String strValue) {
        this.SetParamValue(TAG_DIMENSIONTYPE, strValue);
    }

    public String getBICATALOGID() {
        return this.GetParamStringValue(TAG_BICATALOGID, "");
    }

    public void setBICATALOGID(String strValue) {
        this.SetParamValue(TAG_BICATALOGID, strValue);
    }

    public String getBICATALOGNAME() {
        return this.GetParamStringValue(TAG_BICATALOGNAME, "");
    }

    public void setBICATALOGNAME(String strValue) {
        this.SetParamValue(TAG_BICATALOGNAME, strValue);
    }

    public String getCAPTION() {
        return this.GetParamStringValue(TAG_CAPTION, "");
    }

    public void setCAPTION(String strValue) {
        this.SetParamValue(TAG_CAPTION, strValue);
    }

    public String getDESCRIPTION() {
        return this.GetParamStringValue(TAG_DESCRIPTION, "");
    }

    public void setDESCRIPTION(String strValue) {
        this.SetParamValue(TAG_DESCRIPTION, strValue);
    }

    public int getORDERFLAG() {
        return this.GetParamIntValue(TAG_ORDERFLAG, 0);
    }

    public void setORDERFLAG(int strValue) {
        this.SetParamValue(TAG_ORDERFLAG, strValue);
    }

    public String getQUERYCTRL() {
        return this.GetParamStringValue(TAG_QUERYCTRL, "");
    }

    public void setQUERYCTRL(String strValue) {
        this.SetParamValue(TAG_QUERYCTRL, strValue);
    }

    public String getCUSTOMQUERYCTRL() {
        return this.GetParamStringValue(TAG_CUSTOMQUERYCTRL, "");
    }

    public void setCUSTOMQUERYCTRL(String strValue) {
        this.SetParamValue(TAG_CUSTOMQUERYCTRL, strValue);
    }

    public String getQUERYCTRLPARAM() {
        return this.GetParamStringValue(TAG_QUERYCTRLPARAM, "");
    }

    public void setQUERYCTRLPARAM(String strValue) {
        this.SetParamValue(TAG_QUERYCTRLPARAM, strValue);
    }

    public boolean isCOLUMNWIDTHNull() {
        return this.IsParamNull(TAG_COLUMNWIDTH);
    }

    public int getCOLUMNWIDTH() {
        return this.GetParamIntValue(TAG_COLUMNWIDTH, 0);
    }

    public void setCOLUMNWIDTH(int strValue) {
        this.SetParamValue(TAG_COLUMNWIDTH, strValue);
    }

    public boolean isJOINDEFIDNull() {
        return this.IsParamNull(TAG_JOINDEFID);
    }

    public String getJOINDEFID() {
        return this.GetParamStringValue(TAG_JOINDEFID, "");
    }

    public void setJOINDEFID(String strValue) {
        this.SetParamValue(TAG_JOINDEFID, strValue);
    }

    public boolean isJOINDEFNAMENull() {
        return this.IsParamNull(TAG_JOINDEFNAME);
    }

    public String getJOINDEFNAME() {
        return this.GetParamStringValue(TAG_JOINDEFNAME, "");
    }

    public void setJOINDEFNAME(String strValue) {
        this.SetParamValue(TAG_JOINDEFNAME, strValue);
    }
}

