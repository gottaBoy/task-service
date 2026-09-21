/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class HelpDocItem
extends BaseDataEntity {
    public static final String TAG_HELPDOCITEMID = "HELPDOCITEMID";
    public static final String TAG_HELPDOCITEMNAME = "HELPDOCITEMNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_LINK = "LINK";
    public static final String TAG_PAGESTYLE = "PAGESTYLE";
    public static final String TAG_HELPDOCNAME = "HELPDOCNAME";
    public static final String TAG_DENAME = "DENAME";
    public static final String TAG_PAGENAME = "PAGENAME";
    public static final String TAG_HELPDOCID = "HELPDOCID";
    public static final String TAG_DEID = "DEID";
    public static final String TAG_PAGEID = "PAGEID";

    public String getHELPDOCITEMID() {
        return this.GetParamStringValue(TAG_HELPDOCITEMID, "");
    }

    public void setHELPDOCITEMID(String strValue) {
        this.SetParamValue(TAG_HELPDOCITEMID, strValue);
    }

    public String getHELPDOCITEMNAME() {
        return this.GetParamStringValue(TAG_HELPDOCITEMNAME, "");
    }

    public void setHELPDOCITEMNAME(String strValue) {
        this.SetParamValue(TAG_HELPDOCITEMNAME, strValue);
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

    public String getLINK() {
        return this.GetParamStringValue(TAG_LINK, "");
    }

    public void setLINK(String strValue) {
        this.SetParamValue(TAG_LINK, strValue);
    }

    public String getPAGESTYLE() {
        return this.GetParamStringValue(TAG_PAGESTYLE, "");
    }

    public void setPAGESTYLE(String strValue) {
        this.SetParamValue(TAG_PAGESTYLE, strValue);
    }

    public String getHELPDOCNAME() {
        return this.GetParamStringValue(TAG_HELPDOCNAME, "");
    }

    public void setHELPDOCNAME(String strValue) {
        this.SetParamValue(TAG_HELPDOCNAME, strValue);
    }

    public String getDENAME() {
        return this.GetParamStringValue(TAG_DENAME, "");
    }

    public void setDENAME(String strValue) {
        this.SetParamValue(TAG_DENAME, strValue);
    }

    public String getPAGENAME() {
        return this.GetParamStringValue(TAG_PAGENAME, "");
    }

    public void setPAGENAME(String strValue) {
        this.SetParamValue(TAG_PAGENAME, strValue);
    }

    public String getHELPDOCID() {
        return this.GetParamStringValue(TAG_HELPDOCID, "");
    }

    public void setHELPDOCID(String strValue) {
        this.SetParamValue(TAG_HELPDOCID, strValue);
    }

    public String getDEID() {
        return this.GetParamStringValue(TAG_DEID, "");
    }

    public void setDEID(String strValue) {
        this.SetParamValue(TAG_DEID, strValue);
    }

    public String getPAGEID() {
        return this.GetParamStringValue(TAG_PAGEID, "");
    }

    public void setPAGEID(String strValue) {
        this.SetParamValue(TAG_PAGEID, strValue);
    }
}

