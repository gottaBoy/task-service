/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class Func
extends BaseDataEntity {
    public static final String TAG_FUNCTYPE_DEDATAGRID = "DEDATAGRID";
    public static final String TAG_FUNCTYPE_DEGRIDVIEW = "DEGRIDVIEW";
    public static final String TAG_FUNCTYPE_PAGELINK = "PAGELINK";
    public static final String TAG_FUNCTYPE_JSCODE = "JSCODE";
    public static final String TAG_FUNCTYPE_PAGE = "PAGE";
    public static final String TAG_FUNC_ID = "FUNC_ID";
    public static final String TAG_FUNC_NAME = "FUNC_NAME";
    public static final String TAG_ENABLE = "ENABLE";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_ISSYSTEM = "ISSYSTEM";
    public static final String TAG_FUNCTYPE = "FUNCTYPE";
    public static final String TAG_PAGEPATH = "PAGEPATH";
    public static final String TAG_JSCODE = "JSCODE";
    public static final String TAG_RESOURCEID = "RESOURCEID";
    public static final String TAG_MODULE_NAME = "MODULE_NAME";
    public static final String TAG_DENAME = "DENAME";
    public static final String TAG_DATAGRIDNAME = "DATAGRIDNAME";
    public static final String TAG_PAGENAME = "PAGENAME";
    public static final String TAG_MODULE_ID = "MODULE_ID";
    public static final String TAG_DEID = "DEID";
    public static final String TAG_DATAGRIDID = "DATAGRIDID";
    public static final String TAG_PAGEID = "PAGEID";

    public String getFUNC_ID() {
        return this.GetParamStringValue(TAG_FUNC_ID, "").trim();
    }

    public void setFUNC_ID(String strValue) {
        this.SetParamValue(TAG_FUNC_ID, strValue);
    }

    public String getFUNC_NAME() {
        return this.GetParamStringValue(TAG_FUNC_NAME, "");
    }

    public void setFUNC_NAME(String strValue) {
        this.SetParamValue(TAG_FUNC_NAME, strValue);
    }

    public boolean getENABLE() {
        return this.GetParamIntValue(TAG_ENABLE, 0) == 1;
    }

    public void setENABLE(boolean bValue) {
        this.SetParamValue(TAG_ENABLE, bValue ? 1 : 0);
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

    public boolean getISSYSTEM() {
        return this.GetParamIntValue(TAG_ISSYSTEM, 0) == 1;
    }

    public void setISSYSTEM(boolean bValue) {
        this.SetParamValue(TAG_ISSYSTEM, bValue ? 1 : 0);
    }

    public String getFUNCTYPE() {
        return this.GetParamStringValue(TAG_FUNCTYPE, "");
    }

    public void setFUNCTYPE(String strValue) {
        this.SetParamValue(TAG_FUNCTYPE, strValue);
    }

    public String getPAGEPATH() {
        return this.GetParamStringValue(TAG_PAGEPATH, "");
    }

    public void setPAGEPATH(String strValue) {
        this.SetParamValue(TAG_PAGEPATH, strValue);
    }

    public String getJSCODE() {
        return this.GetParamStringValue("JSCODE", "");
    }

    public void setJSCODE(String strValue) {
        this.SetParamValue("JSCODE", strValue);
    }

    public String getRESOURCEID() {
        return this.GetParamStringValue(TAG_RESOURCEID, "");
    }

    public void setRESOURCEID(String strValue) {
        this.SetParamValue(TAG_RESOURCEID, strValue);
    }

    public String getMODULE_NAME() {
        return this.GetParamStringValue(TAG_MODULE_NAME, "");
    }

    public void setMODULE_NAME(String strValue) {
        this.SetParamValue(TAG_MODULE_NAME, strValue);
    }

    public String getDENAME() {
        return this.GetParamStringValue(TAG_DENAME, "");
    }

    public void setDENAME(String strValue) {
        this.SetParamValue(TAG_DENAME, strValue);
    }

    public String getDATAGRIDNAME() {
        return this.GetParamStringValue(TAG_DATAGRIDNAME, "");
    }

    public void setDATAGRIDNAME(String strValue) {
        this.SetParamValue(TAG_DATAGRIDNAME, strValue);
    }

    public String getPAGENAME() {
        return this.GetParamStringValue(TAG_PAGENAME, "");
    }

    public void setPAGENAME(String strValue) {
        this.SetParamValue(TAG_PAGENAME, strValue);
    }

    public String getMODULE_ID() {
        return this.GetParamStringValue(TAG_MODULE_ID, "");
    }

    public void setMODULE_ID(String strValue) {
        this.SetParamValue(TAG_MODULE_ID, strValue);
    }

    public String getDEID() {
        return this.GetParamStringValue(TAG_DEID, "");
    }

    public void setDEID(String strValue) {
        this.SetParamValue(TAG_DEID, strValue);
    }

    public String getDATAGRIDID() {
        return this.GetParamStringValue(TAG_DATAGRIDID, "");
    }

    public void setDATAGRIDID(String strValue) {
        this.SetParamValue(TAG_DATAGRIDID, strValue);
    }

    public String getPAGEID() {
        return this.GetParamStringValue(TAG_PAGEID, "");
    }

    public void setPAGEID(String strValue) {
        this.SetParamValue(TAG_PAGEID, strValue);
    }

    public boolean isSYSTEM() {
        return this.GetParamIntValue(TAG_ISSYSTEM, 0) == 1;
    }
}

