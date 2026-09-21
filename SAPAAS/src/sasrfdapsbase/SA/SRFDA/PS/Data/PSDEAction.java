/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

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
    public static final String ACTIONMODE_CREATE = "CREATE";
    public static final String ACTIONMODE_CREATE2 = "CREATE2";
    public static final String ACTIONMODE_READ = "READ";
    public static final String ACTIONMODE_UPDATE = "UPDATE";
    public static final String ACTIONMODE_UPDATE2 = "UPDATE2";
    public static final String ACTIONMODE_DELETE = "DELETE";
    public static final String ACTIONMODE_CUSTOM = "CUSTOM";
    public static final String ACTIONMODE_CUSTOM2 = "CUSTOM2";
    public static final String ACTIONMODE_UNKNOWN = "UNKNOWN";
    public static final String ACTIONMODE_GETDRAFT = "GETDRAFT";
    public static final int VRMODE_NODEFAULT = 0;
    public static final int VRMODE_DEFAULT = 1;
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
    public static final String TAG_ACTIONMODE = "ACTIONMODE";
    public static final String TAG_PSSUBSYSSADETAILID = "PSSUBSYSSADETAILID";
    public static final String TAG_PSSUBSYSSADETAILNAME = "PSSUBSYSSADETAILNAME";
    public static final String TAG_ACTIONHOLDER = "ACTIONHOLDER";
    public static final String TAG_PSSYSPFPLUGINID = "PSSYSPFPLUGINID";
    public static final String TAG_PSSYSPFPLUGINNAME = "PSSYSPFPLUGINNAME";
    public static final String TAG_PSSYSSFPLUGINID = "PSSYSSFPLUGINID";
    public static final String TAG_PSSYSSFPLUGINNAME = "PSSYSSFPLUGINNAME";
    public static final String TAG_TESTACTIONMODE = "TESTACTIONMODE";
    public static final String TAG_VRMODE = "VRMODE";
    public static final String TAG_ORDERVALUE = "ORDERVALUE";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";
    public static final String TAG_TSMODE = "TSMODE";
    public static final String TAG_BATCHACTIONMODE = "BATCHACTIONMODE";
    public static final String TAG_PSDEDATAQUERYID = "PSDEDATAQUERYID";
    public static final String TAG_PSDEDATAQUERYNAME = "PSDEDATAQUERYNAME";
    public static final String TAG_CUSTOMCODE = "CUSTOMCODE";
    public static final String TAG_ENABLEAUDIT = "ENABLEAUDIT";
    public static final String TAG_PREPARELAST = "PREPARELAST";
    public static final String TAG_INPSDEFGROUPID = "INPSDEFGROUPID";
    public static final String TAG_INPSDEFGROUPNAME = "INPSDEFGROUPNAME";
    public static final String TAG_OUTPSDEFGROUPID = "OUTPSDEFGROUPID";
    public static final String TAG_OUTPSDEFGROUPNAME = "OUTPSDEFGROUPNAME";
    public static final String TAG_RETSTDDATATYPE = "RETSTDDATATYPE";
    public static final String TAG_RETVALTYPE = "RETVALTYPE";
    public static final String TAG_INPSSYSDYNAMODELID = "INPSSYSDYNAMODELID";
    public static final String TAG_INPSSYSDYNAMODELNAME = "INPSSYSDYNAMODELNAME";
    public static final String TAG_OUTPSSYSDYNAMODELID = "OUTPSSYSDYNAMODELID";
    public static final String TAG_OUTPSSYSDYNAMODELNAME = "OUTPSSYSDYNAMODELNAME";
    public static final String TAG_BEFORECODE = "BEFORECODE";
    public static final String TAG_AFTERCODE = "AFTERCODE";
    public static final String TAG_ENABLECACHE = "ENABLECACHE";
    public static final String TAG_CACHETAG = "CACHETAG";
    public static final String TAG_CACHECAT = "CACHECAT";
    public static final String TAG_CACHESCOPE = "CACHESCOPE";
    public static final String TAG_CACHETIMEOUT = "CACHETIMEOUT";
    public static final String TAG_POTIME = "POTIME";
    public static final String TAG_ACTIONTAG = "ACTIONTAG";
    public static final String TAG_ACTIONTAG2 = "ACTIONTAG2";
    public static final String TAG_ACTIONTAG3 = "ACTIONTAG3";
    public static final String TAG_ACTIONTAG4 = "ACTIONTAG4";
    public static final String TAG_PREDEFINEDTYPE = "PREDEFINEDTYPE";
    public static final String TAG_PREDEFINEDTYPETEXT = "PREDEFINEDTYPETEXT";
    public static final String TAG_PSDEDATASETID = "PSDEDATASETID";
    public static final String TAG_PSDEDATASETNAME = "PSDEDATASETNAME";
    public static final String TAG_RAWSERVICEURL = "RAWSERVICEURL";
    public static final String TAG_RAWSERVICEMETHOD = "RAWSERVICEMETHOD";
    public static final String TAG_OUTREFPSDEID = "OUTREFPSDEID";
    public static final String TAG_OUTREFPSDENAME = "OUTREFPSDENAME";
    public static final String TAG_OUTREFPSDEFGROUPID = "OUTREFPSDEFGROUPID";
    public static final String TAG_OUTREFPSDEFGROUPNAME = "OUTREFPSDEFGROUPNAME";
    public static final String TAG_PSDEMAINSTATEID = "PSDEMAINSTATEID";
    public static final String TAG_PSDEMAINSTATENAME = "PSDEMAINSTATENAME";
    public static final String TAG_SUBSYSSADETAILMODE = "SUBSYSSADETAILMODE";
    public static final String TAG_SERVICECODENAME = "SERVICECODENAME";
    public static final String TAG_PSSYSUNISTATEID = "PSSYSUNISTATEID";
    public static final String TAG_PSSYSUNISTATENAME = "PSSYSUNISTATENAME";
    public static final String TAG_PREDEFINEDTYPEPARAM = "PREDEFINEDTYPEPARAM";
    public static final String TAG_ACTIONPARAMS = "ACTIONPARAMS";
    public static final String TAG_SYNCEVENT = "SYNCEVENT";
    public static final String TAG_NEEDRESOURCEKEY = "NEEDRESOURCEKEY";

    public final boolean isPSDEACTIONIDNull() {
        return this.IsParamNull(TAG_PSDEACTIONID);
    }

    public final String getPSDEACTIONID() {
        return this.GetParamStringValue(TAG_PSDEACTIONID, "");
    }

    public final void setPSDEACTIONID(String strValue) {
        this.SetParamValue(TAG_PSDEACTIONID, strValue);
    }

    public final boolean isPSDEACTIONNAMENull() {
        return this.IsParamNull(TAG_PSDEACTIONNAME);
    }

    public final String getPSDEACTIONNAME() {
        return this.GetParamStringValue(TAG_PSDEACTIONNAME, "");
    }

    public final void setPSDEACTIONNAME(String strValue) {
        this.SetParamValue(TAG_PSDEACTIONNAME, strValue);
    }

    public final boolean isCREATEMANNull() {
        return this.IsParamNull(TAG_CREATEMAN);
    }

    public final String getCREATEMAN() {
        return this.GetParamStringValue(TAG_CREATEMAN, "");
    }

    public final void setCREATEMAN(String strValue) {
        this.SetParamValue(TAG_CREATEMAN, strValue);
    }

    public final boolean isCREATEDATENull() {
        return this.IsParamNull(TAG_CREATEDATE);
    }

    public final Date getCREATEDATE() {
        return this.GetParamDateValue(TAG_CREATEDATE, null);
    }

    public final void setCREATEDATE(Date dtValue) {
        this.SetParamValue(TAG_CREATEDATE, dtValue);
    }

    public final boolean isUPDATEMANNull() {
        return this.IsParamNull(TAG_UPDATEMAN);
    }

    public final String getUPDATEMAN() {
        return this.GetParamStringValue(TAG_UPDATEMAN, "");
    }

    public final void setUPDATEMAN(String strValue) {
        this.SetParamValue(TAG_UPDATEMAN, strValue);
    }

    public final boolean isUPDATEDATENull() {
        return this.IsParamNull(TAG_UPDATEDATE);
    }

    public final Date getUPDATEDATE() {
        return this.GetParamDateValue(TAG_UPDATEDATE, null);
    }

    public final void setUPDATEDATE(Date dtValue) {
        this.SetParamValue(TAG_UPDATEDATE, dtValue);
    }

    public final boolean isPSDEIDNull() {
        return this.IsParamNull(TAG_PSDEID);
    }

    public final String getPSDEID() {
        return this.GetParamStringValue(TAG_PSDEID, "");
    }

    public final void setPSDEID(String strValue) {
        this.SetParamValue(TAG_PSDEID, strValue);
    }

    public final boolean isPSDENAMENull() {
        return this.IsParamNull(TAG_PSDENAME);
    }

    public final String getPSDENAME() {
        return this.GetParamStringValue(TAG_PSDENAME, "");
    }

    public final void setPSDENAME(String strValue) {
        this.SetParamValue(TAG_PSDENAME, strValue);
    }

    public final boolean isMEMONull() {
        return this.IsParamNull(TAG_MEMO);
    }

    public final String getMEMO() {
        return this.GetParamStringValue(TAG_MEMO, "");
    }

    public final void setMEMO(String strValue) {
        this.SetParamValue(TAG_MEMO, strValue);
    }

    public final boolean isACTIONTYPENull() {
        return this.IsParamNull(TAG_ACTIONTYPE);
    }

    public final String getACTIONTYPE() {
        return this.GetParamStringValue(TAG_ACTIONTYPE, "");
    }

    public final void setACTIONTYPE(String strValue) {
        this.SetParamValue(TAG_ACTIONTYPE, strValue);
    }

    public final boolean isPSDESYSPROCIDNull() {
        return this.IsParamNull(TAG_PSDESYSPROCID);
    }

    public final String getPSDESYSPROCID() {
        return this.GetParamStringValue(TAG_PSDESYSPROCID, "");
    }

    public final void setPSDESYSPROCID(String strValue) {
        this.SetParamValue(TAG_PSDESYSPROCID, strValue);
    }

    public final boolean isPSDESYSPROCNAMENull() {
        return this.IsParamNull(TAG_PSDESYSPROCNAME);
    }

    public final String getPSDESYSPROCNAME() {
        return this.GetParamStringValue(TAG_PSDESYSPROCNAME, "");
    }

    public final void setPSDESYSPROCNAME(String strValue) {
        this.SetParamValue(TAG_PSDESYSPROCNAME, strValue);
    }

    public final boolean isPSDESPACTIONIDNull() {
        return this.IsParamNull(TAG_PSDESPACTIONID);
    }

    public final String getPSDESPACTIONID() {
        return this.GetParamStringValue(TAG_PSDESPACTIONID, "");
    }

    public final void setPSDESPACTIONID(String strValue) {
        this.SetParamValue(TAG_PSDESPACTIONID, strValue);
    }

    public final boolean isPSDESPACTIONNAMENull() {
        return this.IsParamNull(TAG_PSDESPACTIONNAME);
    }

    public final String getPSDESPACTIONNAME() {
        return this.GetParamStringValue(TAG_PSDESPACTIONNAME, "");
    }

    public final void setPSDESPACTIONNAME(String strValue) {
        this.SetParamValue(TAG_PSDESPACTIONNAME, strValue);
    }

    public final boolean isLOGICNAMENull() {
        return this.IsParamNull(TAG_LOGICNAME);
    }

    public final String getLOGICNAME() {
        return this.GetParamStringValue(TAG_LOGICNAME, "");
    }

    public final void setLOGICNAME(String strValue) {
        this.SetParamValue(TAG_LOGICNAME, strValue);
    }

    public final boolean isCALLEROBJNull() {
        return this.IsParamNull(TAG_CALLEROBJ);
    }

    public final String getCALLEROBJ() {
        return this.GetParamStringValue(TAG_CALLEROBJ, "");
    }

    public final void setCALLEROBJ(String strValue) {
        this.SetParamValue(TAG_CALLEROBJ, strValue);
    }

    public final boolean isCALLTIMEOUTNull() {
        return this.IsParamNull(TAG_CALLTIMEOUT);
    }

    public final int getCALLTIMEOUT() {
        return this.GetParamIntValue(TAG_CALLTIMEOUT, 0);
    }

    public final void setCALLTIMEOUT(int nValue) {
        this.SetParamValue(TAG_CALLTIMEOUT, nValue);
    }

    public final boolean isCODENAMENull() {
        return this.IsParamNull(TAG_CODENAME);
    }

    public final String getCODENAME() {
        return this.GetParamStringValue(TAG_CODENAME, "");
    }

    public final void setCODENAME(String strValue) {
        this.SetParamValue(TAG_CODENAME, strValue);
    }

    public final boolean isPSDELOGICIDNull() {
        return this.IsParamNull(TAG_PSDELOGICID);
    }

    public final String getPSDELOGICID() {
        return this.GetParamStringValue(TAG_PSDELOGICID, "");
    }

    public final void setPSDELOGICID(String strValue) {
        this.SetParamValue(TAG_PSDELOGICID, strValue);
    }

    public final boolean isPSDELOGICNAMENull() {
        return this.IsParamNull(TAG_PSDELOGICNAME);
    }

    public final String getPSDELOGICNAME() {
        return this.GetParamStringValue(TAG_PSDELOGICNAME, "");
    }

    public final void setPSDELOGICNAME(String strValue) {
        this.SetParamValue(TAG_PSDELOGICNAME, strValue);
    }

    public final boolean isPUBMODENull() {
        return this.IsParamNull(TAG_PUBMODE);
    }

    public final boolean getPUBMODE() {
        return this.GetParamIntValue(TAG_PUBMODE, 0) == 1;
    }

    public final void setPUBMODE(boolean bValue) {
        this.SetParamValue(TAG_PUBMODE, bValue ? 1 : 0);
    }

    public final boolean isPSDEOPPRIVIDNull() {
        return this.IsParamNull(TAG_PSDEOPPRIVID);
    }

    public final String getPSDEOPPRIVID() {
        return this.GetParamStringValue(TAG_PSDEOPPRIVID, "");
    }

    public final void setPSDEOPPRIVID(String strValue) {
        this.SetParamValue(TAG_PSDEOPPRIVID, strValue);
    }

    public final boolean isPSDEOPPRIVNAMENull() {
        return this.IsParamNull(TAG_PSDEOPPRIVNAME);
    }

    public final String getPSDEOPPRIVNAME() {
        return this.GetParamStringValue(TAG_PSDEOPPRIVNAME, "");
    }

    public final void setPSDEOPPRIVNAME(String strValue) {
        this.SetParamValue(TAG_PSDEOPPRIVNAME, strValue);
    }

    public final boolean isUSERPARAMSNull() {
        return this.IsParamNull(TAG_USERPARAMS);
    }

    public final String getUSERPARAMS() {
        return this.GetParamStringValue(TAG_USERPARAMS, "");
    }

    public final void setUSERPARAMS(String strValue) {
        this.SetParamValue(TAG_USERPARAMS, strValue);
    }

    public final boolean isTESTCASEFLAGNull() {
        return this.IsParamNull(TAG_TESTCASEFLAG);
    }

    public final boolean getTESTCASEFLAG() {
        return this.GetParamIntValue(TAG_TESTCASEFLAG, 0) == 1;
    }

    public final void setTESTCASEFLAG(boolean bValue) {
        this.SetParamValue(TAG_TESTCASEFLAG, bValue ? 1 : 0);
    }

    public final boolean isREQUESTMETHODNull() {
        return this.IsParamNull(TAG_REQUESTMETHOD);
    }

    public final String getREQUESTMETHOD() {
        return this.GetParamStringValue(TAG_REQUESTMETHOD, "");
    }

    public final void setREQUESTMETHOD(String strValue) {
        this.SetParamValue(TAG_REQUESTMETHOD, strValue);
    }

    public final boolean isREQUESTPATHNull() {
        return this.IsParamNull(TAG_REQUESTPATH);
    }

    public final String getREQUESTPATH() {
        return this.GetParamStringValue(TAG_REQUESTPATH, "");
    }

    public final void setREQUESTPATH(String strValue) {
        this.SetParamValue(TAG_REQUESTPATH, strValue);
    }

    public final boolean isREQUESTPARAMTYPENull() {
        return this.IsParamNull(TAG_REQUESTPARAMTYPE);
    }

    public final String getREQUESTPARAMTYPE() {
        return this.GetParamStringValue(TAG_REQUESTPARAMTYPE, "");
    }

    public final void setREQUESTPARAMTYPE(String strValue) {
        this.SetParamValue(TAG_REQUESTPARAMTYPE, strValue);
    }

    public final boolean isREQUESTFIELDNull() {
        return this.IsParamNull(TAG_REQUESTFIELD);
    }

    public final String getREQUESTFIELD() {
        return this.GetParamStringValue(TAG_REQUESTFIELD, "");
    }

    public final void setREQUESTFIELD(String strValue) {
        this.SetParamValue(TAG_REQUESTFIELD, strValue);
    }

    public final boolean isPARAMTYPENull() {
        return this.IsParamNull(TAG_PARAMTYPE);
    }

    public final int getPARAMTYPE() {
        return this.GetParamIntValue(TAG_PARAMTYPE, 0);
    }

    public final void setPARAMTYPE(int nValue) {
        this.SetParamValue(TAG_PARAMTYPE, nValue);
    }

    public final boolean isPSDEACTIONTEMPLIDNull() {
        return this.IsParamNull(TAG_PSDEACTIONTEMPLID);
    }

    public final String getPSDEACTIONTEMPLID() {
        return this.GetParamStringValue(TAG_PSDEACTIONTEMPLID, "");
    }

    public final void setPSDEACTIONTEMPLID(String strValue) {
        this.SetParamValue(TAG_PSDEACTIONTEMPLID, strValue);
    }

    public final boolean isPSDEACTIONTEMPLNAMENull() {
        return this.IsParamNull(TAG_PSDEACTIONTEMPLNAME);
    }

    public final String getPSDEACTIONTEMPLNAME() {
        return this.GetParamStringValue(TAG_PSDEACTIONTEMPLNAME, "");
    }

    public final void setPSDEACTIONTEMPLNAME(String strValue) {
        this.SetParamValue(TAG_PSDEACTIONTEMPLNAME, strValue);
    }

    public final boolean isEXTENDMODENull() {
        return this.IsParamNull(TAG_EXTENDMODE);
    }

    public final int getEXTENDMODE() {
        return this.GetParamIntValue(TAG_EXTENDMODE, 0);
    }

    public final void setEXTENDMODE(int nValue) {
        this.SetParamValue(TAG_EXTENDMODE, nValue);
    }

    public final boolean isPSSYSTASKIDNull() {
        return this.IsParamNull(TAG_PSSYSTASKID);
    }

    public final String getPSSYSTASKID() {
        return this.GetParamStringValue(TAG_PSSYSTASKID, "");
    }

    public final void setPSSYSTASKID(String strValue) {
        this.SetParamValue(TAG_PSSYSTASKID, strValue);
    }

    public final boolean isPSSYSTASKNAMENull() {
        return this.IsParamNull(TAG_PSSYSTASKNAME);
    }

    public final String getPSSYSTASKNAME() {
        return this.GetParamStringValue(TAG_PSSYSTASKNAME, "");
    }

    public final void setPSSYSTASKNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSTASKNAME, strValue);
    }

    public final boolean isFINISHFLAGNull() {
        return this.IsParamNull(TAG_FINISHFLAG);
    }

    public final boolean getFINISHFLAG() {
        return this.GetParamIntValue(TAG_FINISHFLAG, 0) == 1;
    }

    public final void setFINISHFLAG(boolean bValue) {
        this.SetParamValue(TAG_FINISHFLAG, bValue ? 1 : 0);
    }

    public final boolean isTODOTASKNull() {
        return this.IsParamNull(TAG_TODOTASK);
    }

    public final String getTODOTASK() {
        return this.GetParamStringValue(TAG_TODOTASK, "");
    }

    public final void setTODOTASK(String strValue) {
        this.SetParamValue(TAG_TODOTASK, strValue);
    }

    public final boolean isACTIONMODENull() {
        return this.IsParamNull(TAG_ACTIONMODE);
    }

    public final String getACTIONMODE() {
        return this.GetParamStringValue(TAG_ACTIONMODE, "");
    }

    public final void setACTIONMODE(String strValue) {
        this.SetParamValue(TAG_ACTIONMODE, strValue);
    }

    public final boolean isPSSUBSYSSADETAILIDNull() {
        return this.IsParamNull(TAG_PSSUBSYSSADETAILID);
    }

    public final String getPSSUBSYSSADETAILID() {
        return this.GetParamStringValue(TAG_PSSUBSYSSADETAILID, "");
    }

    public final void setPSSUBSYSSADETAILID(String strValue) {
        this.SetParamValue(TAG_PSSUBSYSSADETAILID, strValue);
    }

    public final boolean isPSSUBSYSSADETAILNAMENull() {
        return this.IsParamNull(TAG_PSSUBSYSSADETAILNAME);
    }

    public final String getPSSUBSYSSADETAILNAME() {
        return this.GetParamStringValue(TAG_PSSUBSYSSADETAILNAME, "");
    }

    public final void setPSSUBSYSSADETAILNAME(String strValue) {
        this.SetParamValue(TAG_PSSUBSYSSADETAILNAME, strValue);
    }

    public final boolean isACTIONHOLDERNull() {
        return this.IsParamNull(TAG_ACTIONHOLDER);
    }

    public final int getACTIONHOLDER() {
        return this.GetParamIntValue(TAG_ACTIONHOLDER, 0);
    }

    public final void setACTIONHOLDER(int nValue) {
        this.SetParamValue(TAG_ACTIONHOLDER, nValue);
    }

    public final boolean isPSSYSPFPLUGINIDNull() {
        return this.IsParamNull(TAG_PSSYSPFPLUGINID);
    }

    public final String getPSSYSPFPLUGINID() {
        return this.GetParamStringValue(TAG_PSSYSPFPLUGINID, "");
    }

    public final void setPSSYSPFPLUGINID(String strValue) {
        this.SetParamValue(TAG_PSSYSPFPLUGINID, strValue);
    }

    public final boolean isPSSYSPFPLUGINNAMENull() {
        return this.IsParamNull(TAG_PSSYSPFPLUGINNAME);
    }

    public final String getPSSYSPFPLUGINNAME() {
        return this.GetParamStringValue(TAG_PSSYSPFPLUGINNAME, "");
    }

    public final void setPSSYSPFPLUGINNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSPFPLUGINNAME, strValue);
    }

    public final boolean isPSSYSSFPLUGINIDNull() {
        return this.IsParamNull(TAG_PSSYSSFPLUGINID);
    }

    public final String getPSSYSSFPLUGINID() {
        return this.GetParamStringValue(TAG_PSSYSSFPLUGINID, "");
    }

    public final void setPSSYSSFPLUGINID(String strValue) {
        this.SetParamValue(TAG_PSSYSSFPLUGINID, strValue);
    }

    public final boolean isPSSYSSFPLUGINNAMENull() {
        return this.IsParamNull(TAG_PSSYSSFPLUGINNAME);
    }

    public final String getPSSYSSFPLUGINNAME() {
        return this.GetParamStringValue(TAG_PSSYSSFPLUGINNAME, "");
    }

    public final void setPSSYSSFPLUGINNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSSFPLUGINNAME, strValue);
    }

    public final boolean isTESTACTIONMODENull() {
        return this.IsParamNull(TAG_TESTACTIONMODE);
    }

    public final int getTESTACTIONMODE() {
        return this.GetParamIntValue(TAG_TESTACTIONMODE, 0);
    }

    public final void setTESTACTIONMODE(int nValue) {
        this.SetParamValue(TAG_TESTACTIONMODE, nValue);
    }

    public final boolean isVRMODENull() {
        return this.IsParamNull(TAG_VRMODE);
    }

    public final int getVRMODE() {
        return this.GetParamIntValue(TAG_VRMODE, 0);
    }

    public final void setVRMODE(int nValue) {
        this.SetParamValue(TAG_VRMODE, nValue);
    }

    public final boolean isORDERVALUENull() {
        return this.IsParamNull(TAG_ORDERVALUE);
    }

    public final int getORDERVALUE() {
        return this.GetParamIntValue(TAG_ORDERVALUE, 0);
    }

    public final void setORDERVALUE(int nValue) {
        this.SetParamValue(TAG_ORDERVALUE, nValue);
    }

    public final boolean isVALIDFLAGNull() {
        return this.IsParamNull(TAG_VALIDFLAG);
    }

    public final boolean getVALIDFLAG() {
        return this.GetParamIntValue(TAG_VALIDFLAG, 0) == 1;
    }

    public final void setVALIDFLAG(boolean bValue) {
        this.SetParamValue(TAG_VALIDFLAG, bValue ? 1 : 0);
    }

    public final boolean isTSMODENull() {
        return this.IsParamNull(TAG_TSMODE);
    }

    public final String getTSMODE() {
        return this.GetParamStringValue(TAG_TSMODE, "");
    }

    public final void setTSMODE(String strValue) {
        this.SetParamValue(TAG_TSMODE, strValue);
    }

    public final boolean isBATCHACTIONMODENull() {
        return this.IsParamNull(TAG_BATCHACTIONMODE);
    }

    public final int getBATCHACTIONMODE() {
        return this.GetParamIntValue(TAG_BATCHACTIONMODE, 0);
    }

    public final void setBATCHACTIONMODE(int nValue) {
        this.SetParamValue(TAG_BATCHACTIONMODE, nValue);
    }

    public final boolean isPSDEDATAQUERYIDNull() {
        return this.IsParamNull(TAG_PSDEDATAQUERYID);
    }

    public final String getPSDEDATAQUERYID() {
        return this.GetParamStringValue(TAG_PSDEDATAQUERYID, "");
    }

    public final void setPSDEDATAQUERYID(String strValue) {
        this.SetParamValue(TAG_PSDEDATAQUERYID, strValue);
    }

    public final boolean isPSDEDATAQUERYNAMENull() {
        return this.IsParamNull(TAG_PSDEDATAQUERYNAME);
    }

    public final String getPSDEDATAQUERYNAME() {
        return this.GetParamStringValue(TAG_PSDEDATAQUERYNAME, "");
    }

    public final void setPSDEDATAQUERYNAME(String strValue) {
        this.SetParamValue(TAG_PSDEDATAQUERYNAME, strValue);
    }

    public final boolean isCUSTOMCODENull() {
        return this.IsParamNull(TAG_CUSTOMCODE);
    }

    public final String getCUSTOMCODE() {
        return this.GetParamStringValue(TAG_CUSTOMCODE, "");
    }

    public final void setCUSTOMCODE(String strValue) {
        this.SetParamValue(TAG_CUSTOMCODE, strValue);
    }

    public final boolean isENABLEAUDITNull() {
        return this.IsParamNull(TAG_ENABLEAUDIT);
    }

    public final boolean getENABLEAUDIT() {
        return this.GetParamIntValue(TAG_ENABLEAUDIT, 0) == 1;
    }

    public final void setENABLEAUDIT(boolean bValue) {
        this.SetParamValue(TAG_ENABLEAUDIT, bValue ? 1 : 0);
    }

    public final boolean isPREPARELASTNull() {
        return this.IsParamNull(TAG_PREPARELAST);
    }

    public final int getPREPARELAST() {
        return this.GetParamIntValue(TAG_PREPARELAST, 0);
    }

    public final void setPREPARELAST(int bValue) {
        this.SetParamValue(TAG_PREPARELAST, bValue);
    }

    public final boolean isINPSDEFGROUPIDNull() {
        return this.IsParamNull(TAG_INPSDEFGROUPID);
    }

    public final String getINPSDEFGROUPID() {
        return this.GetParamStringValue(TAG_INPSDEFGROUPID, "");
    }

    public final void setINPSDEFGROUPID(String strValue) {
        this.SetParamValue(TAG_INPSDEFGROUPID, strValue);
    }

    public final boolean isINPSDEFGROUPNAMENull() {
        return this.IsParamNull(TAG_INPSDEFGROUPNAME);
    }

    public final String getINPSDEFGROUPNAME() {
        return this.GetParamStringValue(TAG_INPSDEFGROUPNAME, "");
    }

    public final void setINPSDEFGROUPNAME(String strValue) {
        this.SetParamValue(TAG_INPSDEFGROUPNAME, strValue);
    }

    public final boolean isOUTPSDEFGROUPIDNull() {
        return this.IsParamNull(TAG_OUTPSDEFGROUPID);
    }

    public final String getOUTPSDEFGROUPID() {
        return this.GetParamStringValue(TAG_OUTPSDEFGROUPID, "");
    }

    public final void setOUTPSDEFGROUPID(String strValue) {
        this.SetParamValue(TAG_OUTPSDEFGROUPID, strValue);
    }

    public final boolean isOUTPSDEFGROUPNAMENull() {
        return this.IsParamNull(TAG_OUTPSDEFGROUPNAME);
    }

    public final String getOUTPSDEFGROUPNAME() {
        return this.GetParamStringValue(TAG_OUTPSDEFGROUPNAME, "");
    }

    public final void setOUTPSDEFGROUPNAME(String strValue) {
        this.SetParamValue(TAG_OUTPSDEFGROUPNAME, strValue);
    }

    public final boolean isRETVALTYPENull() {
        return this.IsParamNull(TAG_RETVALTYPE);
    }

    public final String getRETVALTYPE() {
        return this.GetParamStringValue(TAG_RETVALTYPE, "");
    }

    public final void setRETVALTYPE(String strValue) {
        this.SetParamValue(TAG_RETVALTYPE, strValue);
    }

    public final boolean isRETSTDDATATYPENull() {
        return this.IsParamNull(TAG_RETSTDDATATYPE);
    }

    public final int getRETSTDDATATYPE() {
        return this.GetParamIntValue(TAG_RETSTDDATATYPE, 0);
    }

    public final void setRETSTDDATATYPE(int nValue) {
        this.SetParamValue(TAG_RETSTDDATATYPE, nValue);
    }

    public final boolean isINPSSYSDYNAMODELIDNull() {
        return this.IsParamNull(TAG_INPSSYSDYNAMODELID);
    }

    public final String getINPSSYSDYNAMODELID() {
        return this.GetParamStringValue(TAG_INPSSYSDYNAMODELID, "");
    }

    public final void setINPSSYSDYNAMODELID(String strValue) {
        this.SetParamValue(TAG_INPSSYSDYNAMODELID, strValue);
    }

    public final boolean isINPSSYSDYNAMODELNAMENull() {
        return this.IsParamNull(TAG_INPSSYSDYNAMODELNAME);
    }

    public final String getINPSSYSDYNAMODELNAME() {
        return this.GetParamStringValue(TAG_INPSSYSDYNAMODELNAME, "");
    }

    public final void setINPSSYSDYNAMODELNAME(String strValue) {
        this.SetParamValue(TAG_INPSSYSDYNAMODELNAME, strValue);
    }

    public final boolean isOUTPSSYSDYNAMODELIDNull() {
        return this.IsParamNull(TAG_OUTPSSYSDYNAMODELID);
    }

    public final String getOUTPSSYSDYNAMODELID() {
        return this.GetParamStringValue(TAG_OUTPSSYSDYNAMODELID, "");
    }

    public final void setOUTPSSYSDYNAMODELID(String strValue) {
        this.SetParamValue(TAG_OUTPSSYSDYNAMODELID, strValue);
    }

    public final boolean isOUTPSSYSDYNAMODELNAMENull() {
        return this.IsParamNull(TAG_OUTPSSYSDYNAMODELNAME);
    }

    public final String getOUTPSSYSDYNAMODELNAME() {
        return this.GetParamStringValue(TAG_OUTPSSYSDYNAMODELNAME, "");
    }

    public final void setOUTPSSYSDYNAMODELNAME(String strValue) {
        this.SetParamValue(TAG_OUTPSSYSDYNAMODELNAME, strValue);
    }

    public final boolean isBEFORECODENull() {
        return this.IsParamNull(TAG_BEFORECODE);
    }

    public final String getBEFORECODE() {
        return this.GetParamStringValue(TAG_BEFORECODE, "");
    }

    public final void setBEFORECODE(String strValue) {
        this.SetParamValue(TAG_BEFORECODE, strValue);
    }

    public final boolean isAFTERCODENull() {
        return this.IsParamNull(TAG_AFTERCODE);
    }

    public final String getAFTERCODE() {
        return this.GetParamStringValue(TAG_AFTERCODE, "");
    }

    public final void setAFTERCODE(String strValue) {
        this.SetParamValue(TAG_AFTERCODE, strValue);
    }

    public final boolean isENABLECACHENull() {
        return this.IsParamNull(TAG_ENABLECACHE);
    }

    public final boolean getENABLECACHE() {
        return this.GetParamIntValue(TAG_ENABLECACHE, 0) == 1;
    }

    public final void setENABLECACHE(boolean bValue) {
        this.SetParamValue(TAG_ENABLECACHE, bValue ? 1 : 0);
    }

    public final boolean isCACHETAGNull() {
        return this.IsParamNull(TAG_CACHETAG);
    }

    public final String getCACHETAG() {
        return this.GetParamStringValue(TAG_CACHETAG, "");
    }

    public final void setCACHETAG(String strValue) {
        this.SetParamValue(TAG_CACHETAG, strValue);
    }

    public final boolean isCACHECATNull() {
        return this.IsParamNull(TAG_CACHECAT);
    }

    public final String getCACHECAT() {
        return this.GetParamStringValue(TAG_CACHECAT, "");
    }

    public final void setCACHECAT(String strValue) {
        this.SetParamValue(TAG_CACHECAT, strValue);
    }

    public final boolean isCACHESCOPENull() {
        return this.IsParamNull(TAG_CACHESCOPE);
    }

    public final String getCACHESCOPE() {
        return this.GetParamStringValue(TAG_CACHESCOPE, "");
    }

    public final void setCACHESCOPE(String strValue) {
        this.SetParamValue(TAG_CACHESCOPE, strValue);
    }

    public final boolean isCACHETIMEOUTNull() {
        return this.IsParamNull(TAG_CACHETIMEOUT);
    }

    public final int getCACHETIMEOUT() {
        return this.GetParamIntValue(TAG_CACHETIMEOUT, 0);
    }

    public final void setCACHETIMEOUT(int nValue) {
        this.SetParamValue(TAG_CACHETIMEOUT, nValue);
    }

    public final boolean isPOTIMENull() {
        return this.IsParamNull(TAG_POTIME);
    }

    public final int getPOTIME() {
        return this.GetParamIntValue(TAG_POTIME, 0);
    }

    public final void setPOTIME(int nValue) {
        this.SetParamValue(TAG_POTIME, nValue);
    }

    public final boolean isACTIONTAGNull() {
        return this.IsParamNull(TAG_ACTIONTAG);
    }

    public final String getACTIONTAG() {
        return this.GetParamStringValue(TAG_ACTIONTAG, "");
    }

    public final void setACTIONTAG(String strValue) {
        this.SetParamValue(TAG_ACTIONTAG, strValue);
    }

    public final boolean isACTIONTAG2Null() {
        return this.IsParamNull(TAG_ACTIONTAG2);
    }

    public final String getACTIONTAG2() {
        return this.GetParamStringValue(TAG_ACTIONTAG2, "");
    }

    public final void setACTIONTAG2(String strValue) {
        this.SetParamValue(TAG_ACTIONTAG2, strValue);
    }

    public final boolean isACTIONTAG3Null() {
        return this.IsParamNull(TAG_ACTIONTAG3);
    }

    public final String getACTIONTAG3() {
        return this.GetParamStringValue(TAG_ACTIONTAG3, "");
    }

    public final void setACTIONTAG3(String strValue) {
        this.SetParamValue(TAG_ACTIONTAG3, strValue);
    }

    public final boolean isACTIONTAG4Null() {
        return this.IsParamNull(TAG_ACTIONTAG4);
    }

    public final String getACTIONTAG4() {
        return this.GetParamStringValue(TAG_ACTIONTAG4, "");
    }

    public final void setACTIONTAG4(String strValue) {
        this.SetParamValue(TAG_ACTIONTAG4, strValue);
    }

    public final boolean isPREDEFINEDTYPENull() {
        return this.IsParamNull(TAG_PREDEFINEDTYPE);
    }

    public final String getPREDEFINEDTYPE() {
        return this.GetParamStringValue(TAG_PREDEFINEDTYPE, "");
    }

    public final void setPREDEFINEDTYPE(String strValue) {
        this.SetParamValue(TAG_PREDEFINEDTYPE, strValue);
    }

    public final boolean isPREDEFINEDTYPETEXTNull() {
        return this.IsParamNull(TAG_PREDEFINEDTYPETEXT);
    }

    public final String getPREDEFINEDTYPETEXT() {
        return this.GetParamStringValue(TAG_PREDEFINEDTYPETEXT, "");
    }

    public final void setPREDEFINEDTYPETEXT(String strValue) {
        this.SetParamValue(TAG_PREDEFINEDTYPETEXT, strValue);
    }

    public final boolean isPSDEDATASETIDNull() {
        return this.IsParamNull(TAG_PSDEDATASETID);
    }

    public final String getPSDEDATASETID() {
        return this.GetParamStringValue(TAG_PSDEDATASETID, "");
    }

    public final void setPSDEDATASETID(String strValue) {
        this.SetParamValue(TAG_PSDEDATASETID, strValue);
    }

    public final boolean isPSDEDATASETNAMENull() {
        return this.IsParamNull(TAG_PSDEDATASETNAME);
    }

    public final String getPSDEDATASETNAME() {
        return this.GetParamStringValue(TAG_PSDEDATASETNAME, "");
    }

    public final void setPSDEDATASETNAME(String strValue) {
        this.SetParamValue(TAG_PSDEDATASETNAME, strValue);
    }

    public final boolean isRAWSERVICEURLNull() {
        return this.IsParamNull(TAG_RAWSERVICEURL);
    }

    public final String getRAWSERVICEURL() {
        return this.GetParamStringValue(TAG_RAWSERVICEURL, "");
    }

    public final void setRAWSERVICEURL(String strValue) {
        this.SetParamValue(TAG_RAWSERVICEURL, strValue);
    }

    public final boolean isRAWSERVICEMETHODNull() {
        return this.IsParamNull(TAG_RAWSERVICEMETHOD);
    }

    public final String getRAWSERVICEMETHOD() {
        return this.GetParamStringValue(TAG_RAWSERVICEMETHOD, "");
    }

    public final void setRAWSERVICEMETHOD(String strValue) {
        this.SetParamValue(TAG_RAWSERVICEMETHOD, strValue);
    }

    public final boolean isOUTREFPSDEIDNull() {
        return this.IsParamNull(TAG_OUTREFPSDEID);
    }

    public final String getOUTREFPSDEID() {
        return this.GetParamStringValue(TAG_OUTREFPSDEID, "");
    }

    public final void setOUTREFPSDEID(String strValue) {
        this.SetParamValue(TAG_OUTREFPSDEID, strValue);
    }

    public final boolean isOUTREFPSDENAMENull() {
        return this.IsParamNull(TAG_OUTREFPSDENAME);
    }

    public final String getOUTREFPSDENAME() {
        return this.GetParamStringValue(TAG_OUTREFPSDENAME, "");
    }

    public final void setOUTREFPSDENAME(String strValue) {
        this.SetParamValue(TAG_OUTREFPSDENAME, strValue);
    }

    public final boolean isOUTREFPSDEFGROUPIDNull() {
        return this.IsParamNull(TAG_OUTREFPSDEFGROUPID);
    }

    public final String getOUTREFPSDEFGROUPID() {
        return this.GetParamStringValue(TAG_OUTREFPSDEFGROUPID, "");
    }

    public final void setOUTREFPSDEFGROUPID(String strValue) {
        this.SetParamValue(TAG_OUTREFPSDEFGROUPID, strValue);
    }

    public final boolean isOUTREFPSDEFGROUPNAMENull() {
        return this.IsParamNull(TAG_OUTREFPSDEFGROUPNAME);
    }

    public final String getOUTREFPSDEFGROUPNAME() {
        return this.GetParamStringValue(TAG_OUTREFPSDEFGROUPNAME, "");
    }

    public final void setOUTREFPSDEFGROUPNAME(String strValue) {
        this.SetParamValue(TAG_OUTREFPSDEFGROUPNAME, strValue);
    }

    public final boolean isPSDEMAINSTATEIDNull() {
        return this.IsParamNull(TAG_PSDEMAINSTATEID);
    }

    public final String getPSDEMAINSTATEID() {
        return this.GetParamStringValue(TAG_PSDEMAINSTATEID, "");
    }

    public final void setPSDEMAINSTATEID(String strValue) {
        this.SetParamValue(TAG_PSDEMAINSTATEID, strValue);
    }

    public final boolean isPSDEMAINSTATENAMENull() {
        return this.IsParamNull(TAG_PSDEMAINSTATENAME);
    }

    public final String getPSDEMAINSTATENAME() {
        return this.GetParamStringValue(TAG_PSDEMAINSTATENAME, "");
    }

    public final void setPSDEMAINSTATENAME(String strValue) {
        this.SetParamValue(TAG_PSDEMAINSTATENAME, strValue);
    }

    public final boolean isSUBSYSSADETAILMODENull() {
        return this.IsParamNull(TAG_SUBSYSSADETAILMODE);
    }

    public final int getSUBSYSSADETAILMODE() {
        return this.GetParamIntValue(TAG_SUBSYSSADETAILMODE, 0);
    }

    public final void setSUBSYSSADETAILMODE(int bValue) {
        this.SetParamValue(TAG_SUBSYSSADETAILMODE, bValue);
    }

    public final boolean isSERVICECODENAMENull() {
        return this.IsParamNull(TAG_SERVICECODENAME);
    }

    public final String getSERVICECODENAME() {
        return this.GetParamStringValue(TAG_SERVICECODENAME, "");
    }

    public final void setSERVICECODENAME(String strValue) {
        this.SetParamValue(TAG_SERVICECODENAME, strValue);
    }

    public final boolean isPSSYSUNISTATEIDNull() {
        return this.IsParamNull(TAG_PSSYSUNISTATEID);
    }

    public final String getPSSYSUNISTATEID() {
        return this.GetParamStringValue(TAG_PSSYSUNISTATEID, "");
    }

    public final void setPSSYSUNISTATEID(String strValue) {
        this.SetParamValue(TAG_PSSYSUNISTATEID, strValue);
    }

    public final boolean isPSSYSUNISTATENAMENull() {
        return this.IsParamNull(TAG_PSSYSUNISTATENAME);
    }

    public final String getPSSYSUNISTATENAME() {
        return this.GetParamStringValue(TAG_PSSYSUNISTATENAME, "");
    }

    public final void setPSSYSUNISTATENAME(String strValue) {
        this.SetParamValue(TAG_PSSYSUNISTATENAME, strValue);
    }

    public final boolean isPREDEFINEDTYPEPARAMNull() {
        return this.IsParamNull(TAG_PREDEFINEDTYPEPARAM);
    }

    public final String getPREDEFINEDTYPEPARAM() {
        return this.GetParamStringValue(TAG_PREDEFINEDTYPEPARAM, "");
    }

    public final void setPREDEFINEDTYPEPARAM(String strValue) {
        this.SetParamValue(TAG_PREDEFINEDTYPEPARAM, strValue);
    }

    public final boolean isACTIONPARAMSNull() {
        return this.IsParamNull(TAG_ACTIONPARAMS);
    }

    public final String getACTIONPARAMS() {
        return this.GetParamStringValue(TAG_ACTIONPARAMS, "");
    }

    public final void setACTIONPARAMS(String strValue) {
        this.SetParamValue(TAG_ACTIONPARAMS, strValue);
    }

    public final boolean isSYNCEVENTNull() {
        return this.IsParamNull(TAG_SYNCEVENT);
    }

    public final int getSYNCEVENT() {
        return this.GetParamIntValue(TAG_SYNCEVENT, 0);
    }

    public final void setSYNCEVENT(int nValue) {
        this.SetParamValue(TAG_SYNCEVENT, nValue);
    }

    public final boolean isNEEDRESOURCEKEYNull() {
        return this.IsParamNull(TAG_NEEDRESOURCEKEY);
    }

    public final boolean getNEEDRESOURCEKEY() {
        return this.GetParamIntValue(TAG_NEEDRESOURCEKEY, 0) == 1;
    }

    public final void setNEEDRESOURCEKEY(boolean bValue) {
        this.SetParamValue(TAG_NEEDRESOURCEKEY, bValue ? 1 : 0);
    }
}

