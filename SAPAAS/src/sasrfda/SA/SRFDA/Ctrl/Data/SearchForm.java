/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class SearchForm
extends BaseDataEntity {
    public static final String TAG_SEARCHFORMID = "SEARCHFORMID";
    public static final String TAG_SEARCHFORMNAME = "SEARCHFORMNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_SFMODEL = "SFMODEL";
    public static final String TAG_SFVERSION = "SFVERSION";
    public static final String TAG_DENAME = "DENAME";
    public static final String TAG_DEID = "DEID";
    public static final String TAG_BACKENDCTRL = "BACKENDCTRL";
    public static final String TAG_FORMPLUGIN = "FORMPLUGIN";
    public static final String TAG_FORMSCRIPTEX2 = "FORMSCRIPTEX2";
    public static final String TAG_FORMSCRIPT = "FORMSCRIPT";
    public static final String TAG_FORMSCRIPTEX = "FORMSCRIPTEX";
    public static final String TAG_FIVCSCRIPT = "FIVCSCRIPT";

    public String getSEARCHFORMID() {
        return this.GetParamStringValue(TAG_SEARCHFORMID, "");
    }

    public void setSEARCHFORMID(String strValue) {
        this.SetParamValue(TAG_SEARCHFORMID, strValue);
    }

    public String getSEARCHFORMNAME() {
        return this.GetParamStringValue(TAG_SEARCHFORMNAME, "");
    }

    public void setSEARCHFORMNAME(String strValue) {
        this.SetParamValue(TAG_SEARCHFORMNAME, strValue);
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

    public String getSFMODEL() {
        return this.GetParamStringValue(TAG_SFMODEL, "");
    }

    public void setSFMODEL(String strValue) {
        this.SetParamValue(TAG_SFMODEL, strValue);
    }

    public String getSFVERSION() {
        return this.GetParamStringValue(TAG_SFVERSION, "");
    }

    public void setSFVERSION(String strValue) {
        this.SetParamValue(TAG_SFVERSION, strValue);
    }

    public String getDENAME() {
        return this.GetParamStringValue(TAG_DENAME, "");
    }

    public void setDENAME(String strValue) {
        this.SetParamValue(TAG_DENAME, strValue);
    }

    public String getDEID() {
        return this.GetParamStringValue(TAG_DEID, "");
    }

    public void setDEID(String strValue) {
        this.SetParamValue(TAG_DEID, strValue);
    }

    public String getBACKENDCTRL() {
        return this.GetParamStringValue(TAG_BACKENDCTRL, "");
    }

    public void setBACKENDCTRL(String strValue) {
        this.SetParamValue(TAG_BACKENDCTRL, strValue);
    }

    public String getFORMPLUGIN() {
        return this.GetParamStringValue(TAG_FORMPLUGIN, "");
    }

    public void setFORMPLUGIN(String strValue) {
        this.SetParamValue(TAG_FORMPLUGIN, strValue);
    }

    public String getFORMSCRIPTEX2() {
        return this.GetParamStringValue(TAG_FORMSCRIPTEX2, "");
    }

    public void setFORMSCRIPTEX2(String strValue) {
        this.SetParamValue(TAG_FORMSCRIPTEX2, strValue);
    }

    public String getFORMSCRIPT() {
        return this.GetParamStringValue(TAG_FORMSCRIPT, "");
    }

    public void setFORMSCRIPT(String strValue) {
        this.SetParamValue(TAG_FORMSCRIPT, strValue);
    }

    public String getFORMSCRIPTEX() {
        return this.GetParamStringValue(TAG_FORMSCRIPTEX, "");
    }

    public void setFORMSCRIPTEX(String strValue) {
        this.SetParamValue(TAG_FORMSCRIPTEX, strValue);
    }

    public String getFIVCSCRIPT() {
        return this.GetParamStringValue(TAG_FIVCSCRIPT, "");
    }

    public void setFIVCSCRIPT(String strValue) {
        this.SetParamValue(TAG_FIVCSCRIPT, strValue);
    }
}

