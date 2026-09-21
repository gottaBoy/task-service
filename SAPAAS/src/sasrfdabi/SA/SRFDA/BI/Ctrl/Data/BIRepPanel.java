/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.BI.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class BIRepPanel
extends BaseDataEntity {
    public static final String TAG_BIREPPANELID = "BIREPPANELID";
    public static final String TAG_BIREPPANELNAME = "BIREPPANELNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_BIREPPTID = "BIREPPTID";
    public static final String TAG_BIREPPTNAME = "BIREPPTNAME";
    public static final String TAG_PANELMODEL = "PANELMODEL";
    public static final String TAG_BIREPPARTTYPE = "BIREPPARTTYPE";
    public static final String TAG_BICUBEID = "BICUBEID";
    public static final String TAG_BICUBENAME = "BICUBENAME";
    public static final String TAG_VERSION = "VERSION";
    public static final String TAG_DESCRIPTION = "DESCRIPTION";
    public static final String TAG_ENABLEFILTER = "ENABLEFILTER";

    public boolean isBIREPPANELIDNull() {
        return this.IsParamNull(TAG_BIREPPANELID);
    }

    public String getBIREPPANELID() {
        return this.GetParamStringValue(TAG_BIREPPANELID, "");
    }

    public void setBIREPPANELID(String strValue) {
        this.SetParamValue(TAG_BIREPPANELID, strValue);
    }

    public boolean isBIREPPANELNAMENull() {
        return this.IsParamNull(TAG_BIREPPANELNAME);
    }

    public String getBIREPPANELNAME() {
        return this.GetParamStringValue(TAG_BIREPPANELNAME, "");
    }

    public void setBIREPPANELNAME(String strValue) {
        this.SetParamValue(TAG_BIREPPANELNAME, strValue);
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

    public boolean isBIREPPTIDNull() {
        return this.IsParamNull(TAG_BIREPPTID);
    }

    public String getBIREPPTID() {
        return this.GetParamStringValue(TAG_BIREPPTID, "");
    }

    public void setBIREPPTID(String strValue) {
        this.SetParamValue(TAG_BIREPPTID, strValue);
    }

    public boolean isBIREPPTNAMENull() {
        return this.IsParamNull(TAG_BIREPPTNAME);
    }

    public String getBIREPPTNAME() {
        return this.GetParamStringValue(TAG_BIREPPTNAME, "");
    }

    public void setBIREPPTNAME(String strValue) {
        this.SetParamValue(TAG_BIREPPTNAME, strValue);
    }

    public boolean isPANELMODELNull() {
        return this.IsParamNull(TAG_PANELMODEL);
    }

    public String getPANELMODEL() {
        return this.GetParamStringValue(TAG_PANELMODEL, "");
    }

    public void setPANELMODEL(String strValue) {
        this.SetParamValue(TAG_PANELMODEL, strValue);
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

    public boolean isENABLEFILTERNull() {
        return this.IsParamNull(TAG_ENABLEFILTER);
    }

    public boolean getENABLEFILTER() {
        return this.GetParamIntValue(TAG_ENABLEFILTER, 0) == 1;
    }

    public void setENABLEFILTER(boolean bValue) {
        this.SetParamValue(TAG_ENABLEFILTER, bValue ? 1 : 0);
    }
}

