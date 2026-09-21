/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.KPI.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;

public class KPIInstData
extends BaseDataEntity {
    public static final String TAG_KPIINSTDATAID = "KPIINSTDATAID";
    public static final String TAG_KPIINSTDATANAME = "KPIINSTDATANAME";
    public static final String TAG_KPIINSTID = "KPIINSTID";
    public static final String TAG_DATATYPE = "DATATYPE";
    public static final String TAG_KPISETID = "KPISETID";
    public static final String TAG_KPIVERSION = "KPIVERSION";
    public static final String TAG_MPVALUE = "MPVALUE";
    public static final String TAG_KPIMPNAME = "KPIMPNAME";
    public static final String TAG_KPIPOINTID = "KPIPOINTID";
    public static final String TAG_MPSCORE = "MPSCORE";
    public static final String TAG_MPVALUEINFO = "MPVALUEINFO";
    public static final String TAG_OWNER = "OWNER";
    public static final String TAG_IMPORTANCEFLAG = "IMPORTANCEFLAG";
    public static final String TAG_ACTIVESTEPID = "ACTIVESTEPID";
    public static final String TAG_ACTIVESTEPNAME = "ACTIVESTEPNAME";
    public static final String TAG_ISERROR = "ISERROR";
    public static final String TAG_ERRORINFO = "ERRORINFO";
    public static final String TAG_ISCLOSE = "ISCLOSE";
    public static final String TAG_ISFINISH = "ISFINISH";
    public static final String TAG_ISCANCEL = "ISCANCEL";
    public static final String TAG_CANCELREASON = "CANCELREASON";
    public static final String TAG_STARTTIME = "STARTTIME";
    public static final String TAG_ENDTIME = "ENDTIME";
    public static final String TAG_DESCRIPTION = "DESCRIPTION";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_RESERVER = "RESERVER";
    public static final String TAG_RESERVER2 = "RESERVER2";
    public static final String TAG_WFMODEL = "WFMODEL";
    public static final String TAG_BATSN = "BATSN";

    public String getRESERVER2() {
        return this.GetParamStringValue(TAG_RESERVER2, "");
    }

    public String getRESERVER() {
        return this.GetParamStringValue(TAG_RESERVER, "");
    }

    public String getUPDATEMAN() {
        return this.GetParamStringValue(TAG_UPDATEMAN, "");
    }

    public String getCREATEMAN() {
        return this.GetParamStringValue(TAG_CREATEMAN, "");
    }

    public String getDESCRIPTION() {
        return this.GetParamStringValue(TAG_DESCRIPTION, "");
    }

    public String getCANCELREASON() {
        return this.GetParamStringValue(TAG_CANCELREASON, "");
    }

    public String getERRORINFO() {
        return this.GetParamStringValue(TAG_ERRORINFO, "");
    }

    public String getACTIVESTEPID() {
        return this.GetParamStringValue(TAG_ACTIVESTEPID, "");
    }

    public String getACTIVESTEPNAME() {
        return this.GetParamStringValue(TAG_ACTIVESTEPNAME, "");
    }

    public String getOWNER() {
        return this.GetParamStringValue(TAG_OWNER, "");
    }

    public String getMPVALUEINFO() {
        return this.GetParamStringValue(TAG_MPVALUEINFO, "");
    }

    public String getMPSCORE() {
        return this.GetParamStringValue(TAG_MPSCORE, "");
    }

    public String getKPIPOINTID() {
        return this.GetParamStringValue(TAG_KPIPOINTID, "");
    }

    public String getKPIMPNAME() {
        return this.GetParamStringValue(TAG_KPIMPNAME, "");
    }

    public String getMPVALUE() {
        return this.GetParamStringValue(TAG_MPVALUE, "");
    }

    public String getKPISETID() {
        return this.GetParamStringValue(TAG_KPISETID, "");
    }

    public String getDATATYPE() {
        return this.GetParamStringValue(TAG_DATATYPE, "");
    }

    public String getKPIINSTID() {
        return this.GetParamStringValue(TAG_KPIINSTID, "");
    }

    public String getKPIINSTDATAID() {
        return this.GetParamStringValue(TAG_KPIINSTDATAID, "");
    }

    public String getWFMODEL() {
        return this.GetParamStringValue(TAG_WFMODEL, "");
    }

    public int getBATSN() {
        return this.GetParamIntValue(TAG_BATSN, 0);
    }

    public void setBATSN(int nValue) {
        this.SetParamValue(TAG_BATSN, nValue);
    }

    public void setRESERVER2(String strValue) {
        this.SetParamValue(TAG_RESERVER2, strValue);
    }

    public void setRESERVER(String strValue) {
        this.SetParamValue(TAG_RESERVER, strValue);
    }

    public void setUPDATEMAN(String strValue) {
        this.SetParamValue(TAG_UPDATEMAN, strValue);
    }

    public void setCREATEMAN(String strValue) {
        this.SetParamValue(TAG_CREATEMAN, strValue);
    }

    public void setDESCRIPTION(String strValue) {
        this.SetParamValue(TAG_DESCRIPTION, strValue);
    }

    public void setCANCELREASON(String strValue) {
        this.SetParamValue(TAG_CANCELREASON, strValue);
    }

    public void setERRORINFO(String strValue) {
        this.SetParamValue(TAG_ERRORINFO, strValue);
    }

    public void setACTIVESTEPID(String strValue) {
        this.SetParamValue(TAG_ACTIVESTEPID, strValue);
    }

    public void setACTIVESTEPNAME(String strValue) {
        this.SetParamValue(TAG_ACTIVESTEPNAME, strValue);
    }

    public void setOWNER(String strValue) {
        this.SetParamValue(TAG_OWNER, strValue);
    }

    public void setMPVALUEINFO(String strValue) {
        this.SetParamValue(TAG_MPVALUEINFO, strValue);
    }

    public void setMPSCORE(Object objValue) {
        this.SetParamValue(TAG_MPSCORE, objValue);
    }

    public void setKPIPOINTID(String strValue) {
        this.SetParamValue(TAG_KPIPOINTID, strValue);
    }

    public void setKPIMPNAME(String strValue) {
        this.SetParamValue(TAG_KPIMPNAME, strValue);
    }

    public void setMPVALUE(String strValue) {
        this.SetParamValue(TAG_MPVALUE, strValue);
    }

    public void setKPISETID(String strValue) {
        this.SetParamValue(TAG_KPISETID, strValue);
    }

    public void setDATATYPE(String strValue) {
        this.SetParamValue(TAG_DATATYPE, strValue);
    }

    public void setKPIINSTID(String strValue) {
        this.SetParamValue(TAG_KPIINSTID, strValue);
    }

    public void setKPIINSTDATAID(String strValue) {
        this.SetParamValue(TAG_KPIINSTDATAID, strValue);
    }

    public void setWFMODEL(String strValue) {
        this.SetParamValue(TAG_WFMODEL, strValue);
    }

    public void setKPIINSTDATANAME(String strValue) {
        this.SetParamValue(TAG_KPIINSTDATANAME, strValue);
    }

    public int getKPIVERSION() {
        return this.GetParamIntValue(TAG_KPIVERSION, 0);
    }

    public int getIMPORTANCEFLAG() {
        return this.GetParamIntValue(TAG_IMPORTANCEFLAG, 0);
    }

    public void setKPIVERSION(int nValue) {
        this.SetParamValue(TAG_KPIVERSION, nValue);
    }

    public void setIMPORTANCEFLAG(int nValue) {
        this.SetParamValue(TAG_IMPORTANCEFLAG, nValue);
    }

    public boolean isCLOSE() {
        return this.GetParamIntValue(TAG_ISCLOSE, 0) == 1;
    }

    public boolean isERROR() {
        return this.GetParamIntValue(TAG_ISERROR, 0) == 1;
    }

    public boolean isFINISH() {
        return this.GetParamIntValue(TAG_ISFINISH, 0) == 1;
    }

    public boolean isCANCEL() {
        return this.GetParamIntValue(TAG_ISCANCEL, 0) == 1;
    }

    public void setISCLOSE(boolean bValue) {
        this.SetParamValue(TAG_ISCLOSE, bValue ? 1 : 0);
    }
}

