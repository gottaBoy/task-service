/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class DEAnalysis
extends BaseDataEntity {
    public static final String TAG_DEANALYSISID = "DEANALYSISID";
    public static final String TAG_DEANALYSISNAME = "DEANALYSISNAME";
    public static final String TAG_ENABLE = "ENABLE";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_CYCLETIMETYPE = "CYCLETIMETYPE";
    public static final String TAG_QUERYCMD = "QUERYCMD";
    public static final String TAG_LASTRUNTIME = "LASTRUNTIME";
    public static final String TAG_RUNINTERVAL = "RUNINTERVAL";
    public static final String TAG_PREVCYCLECOUNT = "PREVCYCLECOUNT";
    public static final String TAG_NEXTCYCLECOUNT = "NEXTCYCLECOUNT";
    public static final String TAG_BEFORECODE = "BEFORECODE";
    public static final String TAG_AFTERCODE = "AFTERCODE";
    public static final String TAG_LOOPAFTERCODE = "LOOPAFTERCODE";
    public static final String TAG_LOOPBEFORECODE = "LOOPBEFORECODE";
    public static final String TAG_PROCNAME = "PROCNAME";
    public static final String TAG_ANALYSISVERSION = "ANALYSISVERSION";
    public static final String TAG_PARAMCODE = "PARAMCODE";
    public static final String TAG_PARAMINITCODE = "PARAMINITCODE";
    public static final String TAG_DENAME = "DENAME";
    public static final String TAG_DEID = "DEID";

    public String getDEANALYSISID() {
        return this.GetParamStringValue(TAG_DEANALYSISID, "");
    }

    public void setDEANALYSISID(String strValue) {
        this.SetParamValue(TAG_DEANALYSISID, strValue);
    }

    public String getDEANALYSISNAME() {
        return this.GetParamStringValue(TAG_DEANALYSISNAME, "");
    }

    public void setDEANALYSISNAME(String strValue) {
        this.SetParamValue(TAG_DEANALYSISNAME, strValue);
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

    public String getCYCLETIMETYPE() {
        return this.GetParamStringValue(TAG_CYCLETIMETYPE, "");
    }

    public void setCYCLETIMETYPE(String strValue) {
        this.SetParamValue(TAG_CYCLETIMETYPE, strValue);
    }

    public String getQUERYCMD() {
        return this.GetParamStringValue(TAG_QUERYCMD, "");
    }

    public void setQUERYCMD(String strValue) {
        this.SetParamValue(TAG_QUERYCMD, strValue);
    }

    public Date getLASTRUNTIME() {
        return this.GetParamDateValue(TAG_LASTRUNTIME, null);
    }

    public void setLASTRUNTIME(Date strValue) {
        this.SetParamValue(TAG_LASTRUNTIME, strValue);
    }

    public String getRUNINTERVAL() {
        return this.GetParamStringValue(TAG_RUNINTERVAL, "");
    }

    public void setRUNINTERVAL(String strValue) {
        this.SetParamValue(TAG_RUNINTERVAL, strValue);
    }

    public int getPREVCYCLECOUNT() {
        return this.GetParamIntValue(TAG_PREVCYCLECOUNT, 0);
    }

    public void setPREVCYCLECOUNT(int strValue) {
        this.SetParamValue(TAG_PREVCYCLECOUNT, strValue);
    }

    public int getNEXTCYCLECOUNT() {
        return this.GetParamIntValue(TAG_NEXTCYCLECOUNT, 0);
    }

    public void setNEXTCYCLECOUNT(int strValue) {
        this.SetParamValue(TAG_NEXTCYCLECOUNT, strValue);
    }

    public String getBEFORECODE() {
        return this.GetParamStringValue(TAG_BEFORECODE, "");
    }

    public void setBEFORECODE(String strValue) {
        this.SetParamValue(TAG_BEFORECODE, strValue);
    }

    public String getAFTERCODE() {
        return this.GetParamStringValue(TAG_AFTERCODE, "");
    }

    public void setAFTERCODE(String strValue) {
        this.SetParamValue(TAG_AFTERCODE, strValue);
    }

    public String getLOOPAFTERCODE() {
        return this.GetParamStringValue(TAG_LOOPAFTERCODE, "");
    }

    public void setLOOPAFTERCODE(String strValue) {
        this.SetParamValue(TAG_LOOPAFTERCODE, strValue);
    }

    public String getLOOPBEFORECODE() {
        return this.GetParamStringValue(TAG_LOOPBEFORECODE, "");
    }

    public void setLOOPBEFORECODE(String strValue) {
        this.SetParamValue(TAG_LOOPBEFORECODE, strValue);
    }

    public String getPROCNAME() {
        return this.GetParamStringValue(TAG_PROCNAME, "");
    }

    public void setPROCNAME(String strValue) {
        this.SetParamValue(TAG_PROCNAME, strValue);
    }

    public String getANALYSISVERSION() {
        return this.GetParamStringValue(TAG_ANALYSISVERSION, "");
    }

    public void setANALYSISVERSION(String strValue) {
        this.SetParamValue(TAG_ANALYSISVERSION, strValue);
    }

    public String getPARAMCODE() {
        return this.GetParamStringValue(TAG_PARAMCODE, "");
    }

    public void setPARAMCODE(String strValue) {
        this.SetParamValue(TAG_PARAMCODE, strValue);
    }

    public String getPARAMINITCODE() {
        return this.GetParamStringValue(TAG_PARAMINITCODE, "");
    }

    public void setPARAMINITCODE(String strValue) {
        this.SetParamValue(TAG_PARAMINITCODE, strValue);
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
}

