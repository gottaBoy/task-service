/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.BI.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class BIRepFilter
extends BaseDataEntity {
    public static final String TAG_BIREPFILTERID = "BIREPFILTERID";
    public static final String TAG_BIREPFILTERNAME = "BIREPFILTERNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_CUSTOMLAYOUT = "CUSTOMLAYOUT";
    public static final String TAG_BIREPPARTTYPE = "BIREPPARTTYPE";
    public static final String TAG_BICUBEID = "BICUBEID";
    public static final String TAG_BICUBENAME = "BICUBENAME";
    public static final String TAG_VERSION = "VERSION";
    public static final String TAG_DESCRIPTION = "DESCRIPTION";
    public static final String TAG_CUSTOMOBJECT = "CUSTOMOBJECT";
    public static final String TAG_BIREPPLID = "BIREPPLID";
    public static final String TAG_BIREPPLNAME = "BIREPPLNAME";
    public static final String TAG_PLPARAM = "PLPARAM";
    public static final String TAG_COLUMNMODEL = "COLUMNMODEL";
    public static final String TAG_CAPTIONWIDTH = "CAPTIONWIDTH";

    public boolean isBIREPFILTERIDNull() {
        return this.IsParamNull(TAG_BIREPFILTERID);
    }

    public String getBIREPFILTERID() {
        return this.GetParamStringValue(TAG_BIREPFILTERID, "");
    }

    public void setBIREPFILTERID(String strValue) {
        this.SetParamValue(TAG_BIREPFILTERID, strValue);
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

    public boolean isCUSTOMLAYOUTNull() {
        return this.IsParamNull(TAG_CUSTOMLAYOUT);
    }

    public String getCUSTOMLAYOUT() {
        return this.GetParamStringValue(TAG_CUSTOMLAYOUT, "");
    }

    public void setCUSTOMLAYOUT(String strValue) {
        this.SetParamValue(TAG_CUSTOMLAYOUT, strValue);
    }

    public boolean isBIREPPARTTYPENull() {
        return this.IsParamNull(TAG_BIREPPARTTYPE);
    }

    public String getBIREPPARTTYPE() {
        return this.GetParamStringValue(TAG_BIREPPARTTYPE, "");
    }

    public void setBIREPPARTTYPE(String strValue) {
        this.SetParamValue(TAG_BIREPPARTTYPE, strValue);
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

    public boolean isBICUBENAMENull() {
        return this.IsParamNull(TAG_BICUBENAME);
    }

    public String getBICUBENAME() {
        return this.GetParamStringValue(TAG_BICUBENAME, "");
    }

    public void setBICUBENAME(String strValue) {
        this.SetParamValue(TAG_BICUBENAME, strValue);
    }

    public boolean isVERSIONNull() {
        return this.IsParamNull(TAG_VERSION);
    }

    public int getVERSION() {
        return this.GetParamIntValue(TAG_VERSION, 0);
    }

    public void setVERSION(int strValue) {
        this.SetParamValue(TAG_VERSION, strValue);
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

    public boolean isCUSTOMOBJECTNull() {
        return this.IsParamNull(TAG_CUSTOMOBJECT);
    }

    public String getCUSTOMOBJECT() {
        return this.GetParamStringValue(TAG_CUSTOMOBJECT, "");
    }

    public void setCUSTOMOBJECT(String strValue) {
        this.SetParamValue(TAG_CUSTOMOBJECT, strValue);
    }

    public boolean isBIREPPLIDNull() {
        return this.IsParamNull(TAG_BIREPPLID);
    }

    public String getBIREPPLID() {
        return this.GetParamStringValue(TAG_BIREPPLID, "");
    }

    public void setBIREPPLID(String strValue) {
        this.SetParamValue(TAG_BIREPPLID, strValue);
    }

    public boolean isBIREPPLNAMENull() {
        return this.IsParamNull(TAG_BIREPPLNAME);
    }

    public String getBIREPPLNAME() {
        return this.GetParamStringValue(TAG_BIREPPLNAME, "");
    }

    public void setBIREPPLNAME(String strValue) {
        this.SetParamValue(TAG_BIREPPLNAME, strValue);
    }

    public boolean isPLPARAMNull() {
        return this.IsParamNull(TAG_PLPARAM);
    }

    public String getPLPARAM() {
        return this.GetParamStringValue(TAG_PLPARAM, "");
    }

    public void setPLPARAM(String strValue) {
        this.SetParamValue(TAG_PLPARAM, strValue);
    }

    public boolean isCOLUMNMODELNull() {
        return this.IsParamNull(TAG_COLUMNMODEL);
    }

    public String getCOLUMNMODEL() {
        return this.GetParamStringValue(TAG_COLUMNMODEL, "");
    }

    public void setCOLUMNMODEL(String strValue) {
        this.SetParamValue(TAG_COLUMNMODEL, strValue);
    }

    public boolean isCAPTIONWIDTHNull() {
        return this.IsParamNull(TAG_CAPTIONWIDTH);
    }

    public int getCAPTIONWIDTH() {
        return this.GetParamIntValue(TAG_CAPTIONWIDTH, 0);
    }

    public void setCAPTIONWIDTH(int strValue) {
        this.SetParamValue(TAG_CAPTIONWIDTH, strValue);
    }
}

