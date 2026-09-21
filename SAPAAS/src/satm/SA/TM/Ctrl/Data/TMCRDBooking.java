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

public class TMCRDBooking
extends BaseDataEntity {
    public static final String TAG_TMCRDBOOKINGID = "TMCRDBOOKINGID";
    public static final String TAG_TMCRDBOOKINGNAME = "TMCRDBOOKINGNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_TMRESBOOKINGTYPE = "TMRESBOOKINGTYPE";
    public static final String TAG_BEGINTIME = "BEGINTIME";
    public static final String TAG_TMRESBASENAME = "TMRESBASENAME";
    public static final String TAG_TMRESBASEID = "TMRESBASEID";
    public static final String TAG_ENDTIME = "ENDTIME";
    public static final String TAG_DESCRIPTION = "DESCRIPTION";
    public static final String TAG_IMPORTANCEFLAG = "IMPORTANCEFLAG";
    public static final String TAG_TMTASKBASEID = "TMTASKBASEID";
    public static final String TAG_TMTASKBASENAME = "TMTASKBASENAME";
    public static final String TAG_TASKRESTYPE = "TASKRESTYPE";
    public static final String TAG_RBSTATE = "RBSTATE";
    public static final String TAG_RBINFO = "RBINFO";
    public static final String TAG_REQUIREMODE = "REQUIREMODE";
    public static final String TAG_EXCLUSIVEFLAG = "EXCLUSIVEFLAG";
    public static final String TAG_PTMRESBOOKINGID = "PTMRESBOOKINGID";
    public static final String TAG_PTMRESBOOKINGNAME = "PTMRESBOOKINGNAME";

    public boolean isTMCRDBOOKINGIDNull() {
        return this.IsParamNull(TAG_TMCRDBOOKINGID);
    }

    public String getTMCRDBOOKINGID() {
        return this.GetParamStringValue(TAG_TMCRDBOOKINGID, "");
    }

    public void setTMCRDBOOKINGID(String strValue) {
        this.SetParamValue(TAG_TMCRDBOOKINGID, strValue);
    }

    public boolean isTMCRDBOOKINGNAMENull() {
        return this.IsParamNull(TAG_TMCRDBOOKINGNAME);
    }

    public String getTMCRDBOOKINGNAME() {
        return this.GetParamStringValue(TAG_TMCRDBOOKINGNAME, "");
    }

    public void setTMCRDBOOKINGNAME(String strValue) {
        this.SetParamValue(TAG_TMCRDBOOKINGNAME, strValue);
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

    public boolean isTMRESBOOKINGTYPENull() {
        return this.IsParamNull(TAG_TMRESBOOKINGTYPE);
    }

    public String getTMRESBOOKINGTYPE() {
        return this.GetParamStringValue(TAG_TMRESBOOKINGTYPE, "");
    }

    public void setTMRESBOOKINGTYPE(String strValue) {
        this.SetParamValue(TAG_TMRESBOOKINGTYPE, strValue);
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

    public boolean isTMRESBASENAMENull() {
        return this.IsParamNull(TAG_TMRESBASENAME);
    }

    public String getTMRESBASENAME() {
        return this.GetParamStringValue(TAG_TMRESBASENAME, "");
    }

    public void setTMRESBASENAME(String strValue) {
        this.SetParamValue(TAG_TMRESBASENAME, strValue);
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

    public boolean isDESCRIPTIONNull() {
        return this.IsParamNull(TAG_DESCRIPTION);
    }

    public String getDESCRIPTION() {
        return this.GetParamStringValue(TAG_DESCRIPTION, "");
    }

    public void setDESCRIPTION(String strValue) {
        this.SetParamValue(TAG_DESCRIPTION, strValue);
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

    public boolean isTMTASKBASEIDNull() {
        return this.IsParamNull(TAG_TMTASKBASEID);
    }

    public String getTMTASKBASEID() {
        return this.GetParamStringValue(TAG_TMTASKBASEID, "");
    }

    public void setTMTASKBASEID(String strValue) {
        this.SetParamValue(TAG_TMTASKBASEID, strValue);
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

    public boolean isREQUIREMODENull() {
        return this.IsParamNull(TAG_REQUIREMODE);
    }

    public String getREQUIREMODE() {
        return this.GetParamStringValue(TAG_REQUIREMODE, "");
    }

    public void setREQUIREMODE(String strValue) {
        this.SetParamValue(TAG_REQUIREMODE, strValue);
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

    public boolean isPTMRESBOOKINGIDNull() {
        return this.IsParamNull(TAG_PTMRESBOOKINGID);
    }

    public String getPTMRESBOOKINGID() {
        return this.GetParamStringValue(TAG_PTMRESBOOKINGID, "");
    }

    public void setPTMRESBOOKINGID(String strValue) {
        this.SetParamValue(TAG_PTMRESBOOKINGID, strValue);
    }

    public boolean isPTMRESBOOKINGNAMENull() {
        return this.IsParamNull(TAG_PTMRESBOOKINGNAME);
    }

    public String getPTMRESBOOKINGNAME() {
        return this.GetParamStringValue(TAG_PTMRESBOOKINGNAME, "");
    }

    public void setPTMRESBOOKINGNAME(String strValue) {
        this.SetParamValue(TAG_PTMRESBOOKINGNAME, strValue);
    }
}

