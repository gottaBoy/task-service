/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.TM.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.sql.Timestamp;
import java.util.Date;

public class TMTaskRes
extends BaseDataEntity {
    public static final String REQUIREMODE_NECESSARY = "NECESSARY";
    public static final String REQUIREMODE_OPTIONAL = "OPTIONAL";
    public static final String TAG_TMTASKRESID = "TMTASKRESID";
    public static final String TAG_TMTASKRESNAME = "TMTASKRESNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_TMTASKBASENAME = "TMTASKBASENAME";
    public static final String TAG_TASKRESTYPE = "TASKRESTYPE";
    public static final String TAG_TMTASKBASEID = "TMTASKBASEID";
    public static final String TAG_TMRESCATALOGID = "TMRESCATALOGID";
    public static final String TAG_TMRESCATALOGNAME = "TMRESCATALOGNAME";
    public static final String TAG_REQUIREMODE = "REQUIREMODE";
    public static final String TAG_DESCRIPTION = "DESCRIPTION";
    public static final String TAG_TMRESCDID = "TMRESCDID";
    public static final String TAG_TMRESCDNAME = "TMRESCDNAME";
    public static final String TAG_TMRESBASEID = "TMRESBASEID";
    public static final String TAG_TMRESBOOKINGID = "TMRESBOOKINGID";
    public static final String TAG_TMRESBOOKINGNAME = "TMRESBOOKINGNAME";
    public static final String TAG_RBSTATE = "RBSTATE";
    public static final String TAG_RBINFO = "RBINFO";
    public static final String TAG_IMPORTANCEFLAG = "IMPORTANCEFLAG";
    public static final String TAG_EXCLUSIVEFLAG = "EXCLUSIVEFLAG";
    public static final String TAG_DURATION = "DURATION";
    public static final String TAG_CUSTOMTRTIME = "CUSTOMTRTIME";
    public static final String TAG_BEGINTIME = "BEGINTIME";
    public static final String TAG_ENDTIME = "ENDTIME";
    public static final String TAG_ROOTTMTASKBASEID = "ROOTTMTASKBASEID";
    public static final String TAG_ROOTTMTASKBASENAME = "ROOTTMTASKBASENAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_TASKTYPE = "TASKTYPE";

    public boolean isTMTASKRESIDNull() {
        return this.IsParamNull(TAG_TMTASKRESID);
    }

    public String getTMTASKRESID() {
        return this.GetParamStringValue(TAG_TMTASKRESID, "");
    }

    public void setTMTASKRESID(String strValue) {
        this.SetParamValue(TAG_TMTASKRESID, strValue);
    }

    public boolean isTMTASKRESNAMENull() {
        return this.IsParamNull(TAG_TMTASKRESNAME);
    }

    public String getTMTASKRESNAME() {
        return this.GetParamStringValue(TAG_TMTASKRESNAME, "");
    }

    public void setTMTASKRESNAME(String strValue) {
        this.SetParamValue(TAG_TMTASKRESNAME, strValue);
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

    public boolean isTMTASKBASENAMENull() {
        return this.IsParamNull(TAG_TMTASKBASENAME);
    }

    public String getTMTASKBASENAME() {
        return this.GetParamStringValue(TAG_TMTASKBASENAME, "");
    }

    public void setTMTASKBASENAME(String strValue) {
        this.SetParamValue(TAG_TMTASKBASENAME, strValue);
    }

    public boolean isTASKRESTYPENull() {
        return this.IsParamNull(TAG_TASKRESTYPE);
    }

    public String getTASKRESTYPE() {
        return this.GetParamStringValue(TAG_TASKRESTYPE, "");
    }

    public void setTASKRESTYPE(String strValue) {
        this.SetParamValue(TAG_TASKRESTYPE, strValue);
    }

    public boolean isTMTASKBASEIDNull() {
        return this.IsParamNull(TAG_TMTASKBASEID);
    }

    public String getTMTASKBASEID() {
        return this.GetParamStringValue(TAG_TMTASKBASEID, "");
    }

    public void setTMTASKBASEID(String strValue) {
        this.SetParamValue(TAG_TMTASKBASEID, strValue);
    }

    public boolean isTMRESCATALOGIDNull() {
        return this.IsParamNull(TAG_TMRESCATALOGID);
    }

    public String getTMRESCATALOGID() {
        return this.GetParamStringValue(TAG_TMRESCATALOGID, "");
    }

    public void setTMRESCATALOGID(String strValue) {
        this.SetParamValue(TAG_TMRESCATALOGID, strValue);
    }

    public boolean isTMRESCATALOGNAMENull() {
        return this.IsParamNull(TAG_TMRESCATALOGNAME);
    }

    public String getTMRESCATALOGNAME() {
        return this.GetParamStringValue(TAG_TMRESCATALOGNAME, "");
    }

    public void setTMRESCATALOGNAME(String strValue) {
        this.SetParamValue(TAG_TMRESCATALOGNAME, strValue);
    }

    public boolean isREQUIREMODENull() {
        return this.IsParamNull(TAG_REQUIREMODE);
    }

    public String getREQUIREMODE() {
        return this.GetParamStringValue(TAG_REQUIREMODE, "");
    }

    public void setREQUIREMODE(String strValue) {
        this.SetParamValue(TAG_REQUIREMODE, strValue);
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

    public boolean isTMRESCDIDNull() {
        return this.IsParamNull(TAG_TMRESCDID);
    }

    public String getTMRESCDID() {
        return this.GetParamStringValue(TAG_TMRESCDID, "");
    }

    public void setTMRESCDID(String strValue) {
        this.SetParamValue(TAG_TMRESCDID, strValue);
    }

    public boolean isTMRESCDNAMENull() {
        return this.IsParamNull(TAG_TMRESCDNAME);
    }

    public String getTMRESCDNAME() {
        return this.GetParamStringValue(TAG_TMRESCDNAME, "");
    }

    public void setTMRESCDNAME(String strValue) {
        this.SetParamValue(TAG_TMRESCDNAME, strValue);
    }

    public boolean isTMRESBASEIDNull() {
        return this.IsParamNull(TAG_TMRESBASEID);
    }

    public String getTMRESBASEID() {
        return this.GetParamStringValue(TAG_TMRESBASEID, "");
    }

    public void setTMRESBASEID(String strValue) {
        this.SetParamValue(TAG_TMRESBASEID, strValue);
    }

    public boolean isTMRESBOOKINGIDNull() {
        return this.IsParamNull(TAG_TMRESBOOKINGID);
    }

    public String getTMRESBOOKINGID() {
        return this.GetParamStringValue(TAG_TMRESBOOKINGID, "");
    }

    public void setTMRESBOOKINGID(String strValue) {
        this.SetParamValue(TAG_TMRESBOOKINGID, strValue);
    }

    public boolean isTMRESBOOKINGNAMENull() {
        return this.IsParamNull(TAG_TMRESBOOKINGNAME);
    }

    public String getTMRESBOOKINGNAME() {
        return this.GetParamStringValue(TAG_TMRESBOOKINGNAME, "");
    }

    public void setTMRESBOOKINGNAME(String strValue) {
        this.SetParamValue(TAG_TMRESBOOKINGNAME, strValue);
    }

    public boolean isRBSTATENull() {
        return this.IsParamNull(TAG_RBSTATE);
    }

    public String getRBSTATE() {
        return this.GetParamStringValue(TAG_RBSTATE, "");
    }

    public void setRBSTATE(String strValue) {
        this.SetParamValue(TAG_RBSTATE, strValue);
    }

    public boolean isRBINFONull() {
        return this.IsParamNull(TAG_RBINFO);
    }

    public String getRBINFO() {
        return this.GetParamStringValue(TAG_RBINFO, "");
    }

    public void setRBINFO(String strValue) {
        this.SetParamValue(TAG_RBINFO, strValue);
    }

    public boolean isIMPORTANCEFLAGNull() {
        return this.IsParamNull(TAG_IMPORTANCEFLAG);
    }

    public int getIMPORTANCEFLAG() {
        return this.GetParamIntValue(TAG_IMPORTANCEFLAG, 0);
    }

    public void setIMPORTANCEFLAG(int strValue) {
        this.SetParamValue(TAG_IMPORTANCEFLAG, strValue);
    }

    public boolean isEXCLUSIVEFLAGNull() {
        return this.IsParamNull(TAG_EXCLUSIVEFLAG);
    }

    public boolean getEXCLUSIVEFLAG() {
        return this.GetParamIntValue(TAG_EXCLUSIVEFLAG, 0) == 1;
    }

    public void setEXCLUSIVEFLAG(boolean bValue) {
        this.SetParamValue(TAG_EXCLUSIVEFLAG, bValue ? 1 : 0);
    }

    public boolean isDURATIONNull() {
        return this.IsParamNull(TAG_DURATION);
    }

    public int getDURATION() {
        return this.GetParamIntValue(TAG_DURATION, 0);
    }

    public void setDURATION(int strValue) {
        this.SetParamValue(TAG_DURATION, strValue);
    }

    public boolean isCUSTOMTRTIMENull() {
        return this.IsParamNull(TAG_CUSTOMTRTIME);
    }

    public boolean getCUSTOMTRTIME() {
        return this.GetParamIntValue(TAG_CUSTOMTRTIME, 0) == 1;
    }

    public void setCUSTOMTRTIME(boolean bValue) {
        this.SetParamValue(TAG_CUSTOMTRTIME, bValue ? 1 : 0);
    }

    public boolean isBEGINTIMENull() {
        return this.IsParamNull(TAG_BEGINTIME);
    }

    public Timestamp getBEGINTIME() {
        return this.GetParamTimestampValue(TAG_BEGINTIME, null);
    }

    public void setBEGINTIME(Timestamp strValue) {
        this.SetParamValue(TAG_BEGINTIME, strValue);
    }

    public boolean isENDTIMENull() {
        return this.IsParamNull(TAG_ENDTIME);
    }

    public Timestamp getENDTIME() {
        return this.GetParamTimestampValue(TAG_ENDTIME, null);
    }

    public void setENDTIME(Timestamp strValue) {
        this.SetParamValue(TAG_ENDTIME, strValue);
    }

    public boolean isROOTTMTASKBASEIDNull() {
        return this.IsParamNull(TAG_ROOTTMTASKBASEID);
    }

    public String getROOTTMTASKBASEID() {
        return this.GetParamStringValue(TAG_ROOTTMTASKBASEID, "");
    }

    public void setROOTTMTASKBASEID(String strValue) {
        this.SetParamValue(TAG_ROOTTMTASKBASEID, strValue);
    }

    public boolean isROOTTMTASKBASENAMENull() {
        return this.IsParamNull(TAG_ROOTTMTASKBASENAME);
    }

    public String getROOTTMTASKBASENAME() {
        return this.GetParamStringValue(TAG_ROOTTMTASKBASENAME, "");
    }

    public void setROOTTMTASKBASENAME(String strValue) {
        this.SetParamValue(TAG_ROOTTMTASKBASENAME, strValue);
    }

    public boolean isMEMONull() {
        return this.IsParamNull(TAG_MEMO);
    }

    public String getMEMO() {
        return this.GetParamStringValue(TAG_MEMO, "");
    }

    public void setMEMO(String strValue) {
        this.SetParamValue(TAG_MEMO, strValue);
    }

    public boolean isTASKTYPENull() {
        return this.IsParamNull(TAG_TASKTYPE);
    }

    public String getTASKTYPE() {
        return this.GetParamStringValue(TAG_TASKTYPE, "");
    }

    public void setTASKTYPE(String strValue) {
        this.SetParamValue(TAG_TASKTYPE, strValue);
    }
}

