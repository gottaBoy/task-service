/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.BI.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class BIRepPI
extends BaseDataEntity {
    public static final String DSIN_DEFAULT = "DEFAULT";
    public static final String TAG_BIREPPINAME = "BIREPPINAME";
    public static final String TAG_BIREPPIID = "BIREPPIID";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_BIREPPANELNAME = "BIREPPANELNAME";
    public static final String TAG_BIREPPANELID = "BIREPPANELID";
    public static final String TAG_BIREPPARTID = "BIREPPARTID";
    public static final String TAG_BIREPPARTNAME = "BIREPPARTNAME";
    public static final String TAG_CUSTOMCONTENT = "CUSTOMCONTENT";
    public static final String TAG_BIREPPTID = "BIREPPTID";
    public static final String TAG_BIREPPTPARAMID = "BIREPPTPARAMID";
    public static final String TAG_BIREPPTPARAMNAME = "BIREPPTPARAMNAME";
    public static final String TAG_SHOWCAPTION = "SHOWCAPTION";
    public static final String TAG_SHOWBORDER = "SHOWBORDER";
    public static final String TAG_BIREPPDSID = "BIREPPDSID";
    public static final String TAG_BIREPPDSNAME = "BIREPPDSNAME";
    public static final String TAG_BIREPPQID = "BIREPPQID";
    public static final String TAG_BIREPPQNAME = "BIREPPQNAME";
    public static final String TAG_CAPTION = "CAPTION";

    public boolean isBIREPPINAMENull() {
        return this.IsParamNull(TAG_BIREPPINAME);
    }

    public String getBIREPPINAME() {
        return this.GetParamStringValue(TAG_BIREPPINAME, "");
    }

    public void setBIREPPINAME(String strValue) {
        this.SetParamValue(TAG_BIREPPINAME, strValue);
    }

    public boolean isBIREPPIIDNull() {
        return this.IsParamNull(TAG_BIREPPIID);
    }

    public String getBIREPPIID() {
        return this.GetParamStringValue(TAG_BIREPPIID, "");
    }

    public void setBIREPPIID(String strValue) {
        this.SetParamValue(TAG_BIREPPIID, strValue);
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

    public boolean isBIREPPANELNAMENull() {
        return this.IsParamNull(TAG_BIREPPANELNAME);
    }

    public String getBIREPPANELNAME() {
        return this.GetParamStringValue(TAG_BIREPPANELNAME, "");
    }

    public void setBIREPPANELNAME(String strValue) {
        this.SetParamValue(TAG_BIREPPANELNAME, strValue);
    }

    public boolean isBIREPPANELIDNull() {
        return this.IsParamNull(TAG_BIREPPANELID);
    }

    public String getBIREPPANELID() {
        return this.GetParamStringValue(TAG_BIREPPANELID, "");
    }

    public void setBIREPPANELID(String strValue) {
        this.SetParamValue(TAG_BIREPPANELID, strValue);
    }

    public boolean isBIREPPARTIDNull() {
        return this.IsParamNull(TAG_BIREPPARTID);
    }

    public String getBIREPPARTID() {
        return this.GetParamStringValue(TAG_BIREPPARTID, "");
    }

    public void setBIREPPARTID(String strValue) {
        this.SetParamValue(TAG_BIREPPARTID, strValue);
    }

    public boolean isBIREPPARTNAMENull() {
        return this.IsParamNull(TAG_BIREPPARTNAME);
    }

    public String getBIREPPARTNAME() {
        return this.GetParamStringValue(TAG_BIREPPARTNAME, "");
    }

    public void setBIREPPARTNAME(String strValue) {
        this.SetParamValue(TAG_BIREPPARTNAME, strValue);
    }

    public boolean isCUSTOMCONTENTNull() {
        return this.IsParamNull(TAG_CUSTOMCONTENT);
    }

    public String getCUSTOMCONTENT() {
        return this.GetParamStringValue(TAG_CUSTOMCONTENT, "");
    }

    public void setCUSTOMCONTENT(String strValue) {
        this.SetParamValue(TAG_CUSTOMCONTENT, strValue);
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

    public boolean isBIREPPTPARAMIDNull() {
        return this.IsParamNull(TAG_BIREPPTPARAMID);
    }

    public String getBIREPPTPARAMID() {
        return this.GetParamStringValue(TAG_BIREPPTPARAMID, "");
    }

    public void setBIREPPTPARAMID(String strValue) {
        this.SetParamValue(TAG_BIREPPTPARAMID, strValue);
    }

    public boolean isBIREPPTPARAMNAMENull() {
        return this.IsParamNull(TAG_BIREPPTPARAMNAME);
    }

    public String getBIREPPTPARAMNAME() {
        return this.GetParamStringValue(TAG_BIREPPTPARAMNAME, "");
    }

    public void setBIREPPTPARAMNAME(String strValue) {
        this.SetParamValue(TAG_BIREPPTPARAMNAME, strValue);
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

    public boolean isSHOWBORDERNull() {
        return this.IsParamNull(TAG_SHOWBORDER);
    }

    public boolean getSHOWBORDER() {
        return this.GetParamIntValue(TAG_SHOWBORDER, 0) == 1;
    }

    public void setSHOWBORDER(boolean bValue) {
        this.SetParamValue(TAG_SHOWBORDER, bValue ? 1 : 0);
    }

    public boolean isBIREPPDSIDNull() {
        return this.IsParamNull(TAG_BIREPPDSID);
    }

    public String getBIREPPDSID() {
        return this.GetParamStringValue(TAG_BIREPPDSID, "");
    }

    public void setBIREPPDSID(String strValue) {
        this.SetParamValue(TAG_BIREPPDSID, strValue);
    }

    public boolean isBIREPPDSNAMENull() {
        return this.IsParamNull(TAG_BIREPPDSNAME);
    }

    public String getBIREPPDSNAME() {
        return this.GetParamStringValue(TAG_BIREPPDSNAME, "");
    }

    public void setBIREPPDSNAME(String strValue) {
        this.SetParamValue(TAG_BIREPPDSNAME, strValue);
    }

    public boolean isBIREPPQIDNull() {
        return this.IsParamNull(TAG_BIREPPQID);
    }

    public String getBIREPPQID() {
        return this.GetParamStringValue(TAG_BIREPPQID, "");
    }

    public void setBIREPPQID(String strValue) {
        this.SetParamValue(TAG_BIREPPQID, strValue);
    }

    public boolean isBIREPPQNAMENull() {
        return this.IsParamNull(TAG_BIREPPQNAME);
    }

    public String getBIREPPQNAME() {
        return this.GetParamStringValue(TAG_BIREPPQNAME, "");
    }

    public void setBIREPPQNAME(String strValue) {
        this.SetParamValue(TAG_BIREPPQNAME, strValue);
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

