/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class DataGridEx
extends BaseDataEntity {
    public static final String TAG_DATAGRIDEXID = "DATAGRIDEXID";
    public static final String TAG_DATAGRIDEXNAME = "DATAGRIDEXNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_DEID = "DEID";
    public static final String TAG_DENAME = "DENAME";
    public static final String TAG_DGEXMODEL = "DGEXMODEL";
    public static final String TAG_VERSION = "VERSION";
    public static final String TAG_NOSORT = "NOSORT";
    public static final String TAG_BACKENDCTRL = "BACKENDCTRL";
    public static final String TAG_CONFIGPATH = "CONFIGPATH";
    public static final String TAG_PAGESIZE = "PAGESIZE";
    public static final String TAG_FETCHTIMEOUT = "FETCHTIMEOUT";
    public static final String TAG_NODEFSORT = "NODEFSORT";
    public static final String TAG_SORTFIELD = "SORTFIELD";
    public static final String TAG_SORTDIR = "SORTDIR";
    public static final String TAG_RENDERMODE = "RENDERMODE";

    public String getDATAGRIDEXID() {
        return this.GetParamStringValue(TAG_DATAGRIDEXID, "");
    }

    public void setDATAGRIDEXID(String strValue) {
        this.SetParamValue(TAG_DATAGRIDEXID, strValue);
    }

    public String getDATAGRIDEXNAME() {
        return this.GetParamStringValue(TAG_DATAGRIDEXNAME, "");
    }

    public void setDATAGRIDEXNAME(String strValue) {
        this.SetParamValue(TAG_DATAGRIDEXNAME, strValue);
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

    public String getDEID() {
        return this.GetParamStringValue(TAG_DEID, "");
    }

    public void setDEID(String strValue) {
        this.SetParamValue(TAG_DEID, strValue);
    }

    public String getDENAME() {
        return this.GetParamStringValue(TAG_DENAME, "");
    }

    public void setDENAME(String strValue) {
        this.SetParamValue(TAG_DENAME, strValue);
    }

    public String getDGEXMODEL() {
        return this.GetParamStringValue(TAG_DGEXMODEL, "");
    }

    public void setDGEXMODEL(String strValue) {
        this.SetParamValue(TAG_DGEXMODEL, strValue);
    }

    public int getVERSION() {
        return this.GetParamIntValue(TAG_VERSION, 0);
    }

    public void setVERSION(int strValue) {
        this.SetParamValue(TAG_VERSION, strValue);
    }

    public boolean getNOSORT() {
        return this.GetParamIntValue(TAG_NOSORT, 0) == 1;
    }

    public void setNOSORT(boolean bValue) {
        this.SetParamValue(TAG_NOSORT, bValue ? 1 : 0);
    }

    public String getBACKENDCTRL() {
        return this.GetParamStringValue(TAG_BACKENDCTRL, "");
    }

    public void setBACKENDCTRL(String strValue) {
        this.SetParamValue(TAG_BACKENDCTRL, strValue);
    }

    public String getCONFIGPATH() {
        return this.GetParamStringValue(TAG_CONFIGPATH, "");
    }

    public int getPAGESIZE() {
        return this.GetParamIntValue(TAG_PAGESIZE, 0);
    }

    public void setPAGESIZE(int strValue) {
        this.SetParamValue(TAG_PAGESIZE, strValue);
    }

    public int getFETCHTIMEOUT() {
        return this.GetParamIntValue(TAG_FETCHTIMEOUT, 0);
    }

    public void setFETCHTIMEOUT(int strValue) {
        this.SetParamValue(TAG_FETCHTIMEOUT, strValue);
    }

    public boolean getNODEFSORT() {
        return this.GetParamIntValue(TAG_NODEFSORT, 0) == 1;
    }

    public void setNODEFSORT(boolean bValue) {
        this.SetParamValue(TAG_NODEFSORT, bValue ? 1 : 0);
    }

    public String getSORTFIELD() {
        return this.GetParamStringValue(TAG_SORTFIELD, "");
    }

    public void setSORTFIELD(String strValue) {
        this.SetParamValue(TAG_SORTFIELD, strValue);
    }

    public String getSORTDIR() {
        return this.GetParamStringValue(TAG_SORTDIR, "");
    }

    public void setSORTDIR(String strValue) {
        this.SetParamValue(TAG_SORTDIR, strValue);
    }

    public boolean isRENDERMODENull() {
        return this.IsParamNull(TAG_RENDERMODE);
    }

    public String getRENDERMODE() {
        return this.GetParamStringValue(TAG_RENDERMODE, "");
    }

    public void setRENDERMODE(String strValue) {
        this.SetParamValue(TAG_RENDERMODE, strValue);
    }
}

