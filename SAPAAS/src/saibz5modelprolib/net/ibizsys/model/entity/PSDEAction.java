/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.entity;

import java.util.Date;
import net.ibizsys.model.entity.BaseDataEntity;

public class PSDEAction
extends BaseDataEntity {
    public static final String ACTIONTYPE_SYSDBPROC = "SYSDBPROC";
    public static final String ACTIONTYPE_USERDBPROC = "USERDBPROC";
    public static final String ACTIONTYPE_USERCUSTOM = "USERCUSTOM";
    public static final String ACTIONTYPE_DELOGIC = "DELOGIC";
    public static final String ACTIONTYPE_BUILTIN = "BUILTIN";
    public static final String REQUESTPARAMTYPE_NONE = "NONE";
    public static final String REQUESTPARAMTYPE_FIELD = "FIELD";
    public static final String REQUESTPARAMTYPE_ENTITY = "ENTITY";
    public static final String TAG_PSDEACTIONID = "PSDEACTIONID";
    public static final String TAG_PSDEACTIONNAME = "PSDEACTIONNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSDEID = "PSDEID";
    public static final String TAG_PSDENAME = "PSDENAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_ACTIONTYPE = "ACTIONTYPE";
    public static final String TAG_PSDESYSPROCID = "PSDESYSPROCID";
    public static final String TAG_PSDESYSPROCNAME = "PSDESYSPROCNAME";
    public static final String TAG_PSDESPACTIONID = "PSDESPACTIONID";
    public static final String TAG_PSDESPACTIONNAME = "PSDESPACTIONNAME";
    public static final String TAG_LOGICNAME = "LOGICNAME";
    public static final String TAG_CALLEROBJ = "CALLEROBJ";
    public static final String TAG_CALLTIMEOUT = "CALLTIMEOUT";
    public static final String TAG_CODENAME = "CODENAME";
    public static final String TAG_PSDELOGICID = "PSDELOGICID";
    public static final String TAG_PSDELOGICNAME = "PSDELOGICNAME";
    public static final String TAG_PUBMODE = "PUBMODE";
    public static final String TAG_PSDEOPPRIVID = "PSDEOPPRIVID";
    public static final String TAG_PSDEOPPRIVNAME = "PSDEOPPRIVNAME";
    public static final String TAG_USERPARAMS = "USERPARAMS";
    public static final String TAG_TESTCASEFLAG = "TESTCASEFLAG";
    public static final String TAG_REQUESTMETHOD = "REQUESTMETHOD";
    public static final String TAG_REQUESTPATH = "REQUESTPATH";
    public static final String TAG_REQUESTPARAMTYPE = "REQUESTPARAMTYPE";
    public static final String TAG_REQUESTFIELD = "REQUESTFIELD";
    public static final String TAG_PARAMTYPE = "PARAMTYPE";
    public static final String TAG_PSDEACTIONTEMPLID = "PSDEACTIONTEMPLID";
    public static final String TAG_PSDEACTIONTEMPLNAME = "PSDEACTIONTEMPLNAME";
    public static final String TAG_EXTENDMODE = "EXTENDMODE";
    public static final String TAG_PSSYSTASKID = "PSSYSTASKID";
    public static final String TAG_PSSYSTASKNAME = "PSSYSTASKNAME";
    public static final String TAG_FINISHFLAG = "FINISHFLAG";
    public static final String TAG_TODOTASK = "TODOTASK";

    public final boolean isPSDEACTIONIDNull() {
        return this.isParamNull(TAG_PSDEACTIONID);
    }

    public final String getPSDEACTIONID() {
        return this.getParamStringValue(TAG_PSDEACTIONID, "");
    }

    public final void setPSDEACTIONID(String strValue) {
        this.setParamValue(TAG_PSDEACTIONID, strValue);
    }

    public final boolean isPSDEACTIONNAMENull() {
        return this.isParamNull(TAG_PSDEACTIONNAME);
    }

    public final String getPSDEACTIONNAME() {
        return this.getParamStringValue(TAG_PSDEACTIONNAME, "");
    }

    public final void setPSDEACTIONNAME(String strValue) {
        this.setParamValue(TAG_PSDEACTIONNAME, strValue);
    }

    public final boolean isCREATEMANNull() {
        return this.isParamNull(TAG_CREATEMAN);
    }

    public final String getCREATEMAN() {
        return this.getParamStringValue(TAG_CREATEMAN, "");
    }

    public final void setCREATEMAN(String strValue) {
        this.setParamValue(TAG_CREATEMAN, strValue);
    }

    public final boolean isCREATEDATENull() {
        return this.isParamNull(TAG_CREATEDATE);
    }

    public final Date getCREATEDATE() {
        return this.getParamDateValue(TAG_CREATEDATE, null);
    }

    public final void setCREATEDATE(Date dtValue) {
        this.setParamValue(TAG_CREATEDATE, dtValue);
    }

    public final boolean isUPDATEMANNull() {
        return this.isParamNull(TAG_UPDATEMAN);
    }

    public final String getUPDATEMAN() {
        return this.getParamStringValue(TAG_UPDATEMAN, "");
    }

    public final void setUPDATEMAN(String strValue) {
        this.setParamValue(TAG_UPDATEMAN, strValue);
    }

    public final boolean isUPDATEDATENull() {
        return this.isParamNull(TAG_UPDATEDATE);
    }

    public final Date getUPDATEDATE() {
        return this.getParamDateValue(TAG_UPDATEDATE, null);
    }

    public final void setUPDATEDATE(Date dtValue) {
        this.setParamValue(TAG_UPDATEDATE, dtValue);
    }

    public final boolean isPSDEIDNull() {
        return this.isParamNull(TAG_PSDEID);
    }

    public final String getPSDEID() {
        return this.getParamStringValue(TAG_PSDEID, "");
    }

    public final void setPSDEID(String strValue) {
        this.setParamValue(TAG_PSDEID, strValue);
    }

    public final boolean isPSDENAMENull() {
        return this.isParamNull(TAG_PSDENAME);
    }

    public final String getPSDENAME() {
        return this.getParamStringValue(TAG_PSDENAME, "");
    }

    public final void setPSDENAME(String strValue) {
        this.setParamValue(TAG_PSDENAME, strValue);
    }

    public final boolean isMEMONull() {
        return this.isParamNull(TAG_MEMO);
    }

    public final String getMEMO() {
        return this.getParamStringValue(TAG_MEMO, "");
    }

    public final void setMEMO(String strValue) {
        this.setParamValue(TAG_MEMO, strValue);
    }

    public final boolean isACTIONTYPENull() {
        return this.isParamNull(TAG_ACTIONTYPE);
    }

    public final String getACTIONTYPE() {
        return this.getParamStringValue(TAG_ACTIONTYPE, "");
    }

    public final void setACTIONTYPE(String strValue) {
        this.setParamValue(TAG_ACTIONTYPE, strValue);
    }

    public final boolean isPSDESYSPROCIDNull() {
        return this.isParamNull(TAG_PSDESYSPROCID);
    }

    public final String getPSDESYSPROCID() {
        return this.getParamStringValue(TAG_PSDESYSPROCID, "");
    }

    public final void setPSDESYSPROCID(String strValue) {
        this.setParamValue(TAG_PSDESYSPROCID, strValue);
    }

    public final boolean isPSDESYSPROCNAMENull() {
        return this.isParamNull(TAG_PSDESYSPROCNAME);
    }

    public final String getPSDESYSPROCNAME() {
        return this.getParamStringValue(TAG_PSDESYSPROCNAME, "");
    }

    public final void setPSDESYSPROCNAME(String strValue) {
        this.setParamValue(TAG_PSDESYSPROCNAME, strValue);
    }

    public final boolean isPSDESPACTIONIDNull() {
        return this.isParamNull(TAG_PSDESPACTIONID);
    }

    public final String getPSDESPACTIONID() {
        return this.getParamStringValue(TAG_PSDESPACTIONID, "");
    }

    public final void setPSDESPACTIONID(String strValue) {
        this.setParamValue(TAG_PSDESPACTIONID, strValue);
    }

    public final boolean isPSDESPACTIONNAMENull() {
        return this.isParamNull(TAG_PSDESPACTIONNAME);
    }

    public final String getPSDESPACTIONNAME() {
        return this.getParamStringValue(TAG_PSDESPACTIONNAME, "");
    }

    public final void setPSDESPACTIONNAME(String strValue) {
        this.setParamValue(TAG_PSDESPACTIONNAME, strValue);
    }

    public final boolean isLOGICNAMENull() {
        return this.isParamNull(TAG_LOGICNAME);
    }

    public final String getLOGICNAME() {
        return this.getParamStringValue(TAG_LOGICNAME, "");
    }

    public final void setLOGICNAME(String strValue) {
        this.setParamValue(TAG_LOGICNAME, strValue);
    }

    public final boolean isCALLEROBJNull() {
        return this.isParamNull(TAG_CALLEROBJ);
    }

    public final String getCALLEROBJ() {
        return this.getParamStringValue(TAG_CALLEROBJ, "");
    }

    public final void setCALLEROBJ(String strValue) {
        this.setParamValue(TAG_CALLEROBJ, strValue);
    }

    public final boolean isCALLTIMEOUTNull() {
        return this.isParamNull(TAG_CALLTIMEOUT);
    }

    public final int getCALLTIMEOUT() {
        return this.getParamIntValue(TAG_CALLTIMEOUT, 0);
    }

    public final void setCALLTIMEOUT(int nValue) {
        this.setParamValue(TAG_CALLTIMEOUT, nValue);
    }

    public final boolean isCODENAMENull() {
        return this.isParamNull(TAG_CODENAME);
    }

    public final String getCODENAME() {
        return this.getParamStringValue(TAG_CODENAME, "");
    }

    public final void setCODENAME(String strValue) {
        this.setParamValue(TAG_CODENAME, strValue);
    }

    public final boolean isPSDELOGICIDNull() {
        return this.isParamNull(TAG_PSDELOGICID);
    }

    public final String getPSDELOGICID() {
        return this.getParamStringValue(TAG_PSDELOGICID, "");
    }

    public final void setPSDELOGICID(String strValue) {
        this.setParamValue(TAG_PSDELOGICID, strValue);
    }

    public final boolean isPSDELOGICNAMENull() {
        return this.isParamNull(TAG_PSDELOGICNAME);
    }

    public final String getPSDELOGICNAME() {
        return this.getParamStringValue(TAG_PSDELOGICNAME, "");
    }

    public final void setPSDELOGICNAME(String strValue) {
        this.setParamValue(TAG_PSDELOGICNAME, strValue);
    }

    public final boolean isPUBMODENull() {
        return this.isParamNull(TAG_PUBMODE);
    }

    public final boolean getPUBMODE() {
        return this.getParamIntValue(TAG_PUBMODE, 0) == 1;
    }

    public final void setPUBMODE(boolean bValue) {
        this.setParamValue(TAG_PUBMODE, bValue ? 1 : 0);
    }

    public final boolean isPSDEOPPRIVIDNull() {
        return this.isParamNull(TAG_PSDEOPPRIVID);
    }

    public final String getPSDEOPPRIVID() {
        return this.getParamStringValue(TAG_PSDEOPPRIVID, "");
    }

    public final void setPSDEOPPRIVID(String strValue) {
        this.setParamValue(TAG_PSDEOPPRIVID, strValue);
    }

    public final boolean isPSDEOPPRIVNAMENull() {
        return this.isParamNull(TAG_PSDEOPPRIVNAME);
    }

    public final String getPSDEOPPRIVNAME() {
        return this.getParamStringValue(TAG_PSDEOPPRIVNAME, "");
    }

    public final void setPSDEOPPRIVNAME(String strValue) {
        this.setParamValue(TAG_PSDEOPPRIVNAME, strValue);
    }

    public final boolean isUSERPARAMSNull() {
        return this.isParamNull(TAG_USERPARAMS);
    }

    public final String getUSERPARAMS() {
        return this.getParamStringValue(TAG_USERPARAMS, "");
    }

    public final void setUSERPARAMS(String strValue) {
        this.setParamValue(TAG_USERPARAMS, strValue);
    }

    public final boolean isTESTCASEFLAGNull() {
        return this.isParamNull(TAG_TESTCASEFLAG);
    }

    public final boolean getTESTCASEFLAG() {
        return this.getParamIntValue(TAG_TESTCASEFLAG, 0) == 1;
    }

    public final void setTESTCASEFLAG(boolean bValue) {
        this.setParamValue(TAG_TESTCASEFLAG, bValue ? 1 : 0);
    }

    public final boolean isREQUESTMETHODNull() {
        return this.isParamNull(TAG_REQUESTMETHOD);
    }

    public final String getREQUESTMETHOD() {
        return this.getParamStringValue(TAG_REQUESTMETHOD, "");
    }

    public final void setREQUESTMETHOD(String strValue) {
        this.setParamValue(TAG_REQUESTMETHOD, strValue);
    }

    public final boolean isREQUESTPATHNull() {
        return this.isParamNull(TAG_REQUESTPATH);
    }

    public final String getREQUESTPATH() {
        return this.getParamStringValue(TAG_REQUESTPATH, "");
    }

    public final void setREQUESTPATH(String strValue) {
        this.setParamValue(TAG_REQUESTPATH, strValue);
    }

    public final boolean isREQUESTPARAMTYPENull() {
        return this.isParamNull(TAG_REQUESTPARAMTYPE);
    }

    public final String getREQUESTPARAMTYPE() {
        return this.getParamStringValue(TAG_REQUESTPARAMTYPE, "");
    }

    public final void setREQUESTPARAMTYPE(String strValue) {
        this.setParamValue(TAG_REQUESTPARAMTYPE, strValue);
    }

    public final boolean isREQUESTFIELDNull() {
        return this.isParamNull(TAG_REQUESTFIELD);
    }

    public final String getREQUESTFIELD() {
        return this.getParamStringValue(TAG_REQUESTFIELD, "");
    }

    public final void setREQUESTFIELD(String strValue) {
        this.setParamValue(TAG_REQUESTFIELD, strValue);
    }

    public final boolean isPARAMTYPENull() {
        return this.isParamNull(TAG_PARAMTYPE);
    }

    public final int getPARAMTYPE() {
        return this.getParamIntValue(TAG_PARAMTYPE, 0);
    }

    public final void setPARAMTYPE(int nValue) {
        this.setParamValue(TAG_PARAMTYPE, nValue);
    }

    public final boolean isPSDEACTIONTEMPLIDNull() {
        return this.isParamNull(TAG_PSDEACTIONTEMPLID);
    }

    public final String getPSDEACTIONTEMPLID() {
        return this.getParamStringValue(TAG_PSDEACTIONTEMPLID, "");
    }

    public final void setPSDEACTIONTEMPLID(String strValue) {
        this.setParamValue(TAG_PSDEACTIONTEMPLID, strValue);
    }

    public final boolean isPSDEACTIONTEMPLNAMENull() {
        return this.isParamNull(TAG_PSDEACTIONTEMPLNAME);
    }

    public final String getPSDEACTIONTEMPLNAME() {
        return this.getParamStringValue(TAG_PSDEACTIONTEMPLNAME, "");
    }

    public final void setPSDEACTIONTEMPLNAME(String strValue) {
        this.setParamValue(TAG_PSDEACTIONTEMPLNAME, strValue);
    }

    public final boolean isEXTENDMODENull() {
        return this.isParamNull(TAG_EXTENDMODE);
    }

    public final int getEXTENDMODE() {
        return this.getParamIntValue(TAG_EXTENDMODE, 0);
    }

    public final void setEXTENDMODE(int nValue) {
        this.setParamValue(TAG_EXTENDMODE, nValue);
    }

    public final boolean isPSSYSTASKIDNull() {
        return this.isParamNull(TAG_PSSYSTASKID);
    }

    public final String getPSSYSTASKID() {
        return this.getParamStringValue(TAG_PSSYSTASKID, "");
    }

    public final void setPSSYSTASKID(String strValue) {
        this.setParamValue(TAG_PSSYSTASKID, strValue);
    }

    public final boolean isPSSYSTASKNAMENull() {
        return this.isParamNull(TAG_PSSYSTASKNAME);
    }

    public final String getPSSYSTASKNAME() {
        return this.getParamStringValue(TAG_PSSYSTASKNAME, "");
    }

    public final void setPSSYSTASKNAME(String strValue) {
        this.setParamValue(TAG_PSSYSTASKNAME, strValue);
    }

    public final boolean isFINISHFLAGNull() {
        return this.isParamNull(TAG_FINISHFLAG);
    }

    public final boolean getFINISHFLAG() {
        return this.getParamIntValue(TAG_FINISHFLAG, 0) == 1;
    }

    public final void setFINISHFLAG(boolean bValue) {
        this.setParamValue(TAG_FINISHFLAG, bValue ? 1 : 0);
    }

    public final boolean isTODOTASKNull() {
        return this.isParamNull(TAG_TODOTASK);
    }

    public final String getTODOTASK() {
        return this.getParamStringValue(TAG_TODOTASK, "");
    }

    public final void setTODOTASK(String strValue) {
        this.setParamValue(TAG_TODOTASK, strValue);
    }
}

