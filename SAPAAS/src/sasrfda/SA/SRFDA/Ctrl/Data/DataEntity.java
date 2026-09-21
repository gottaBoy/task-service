/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.PropertiesHelper
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Web.Utility.GlobalHelperEx;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.PropertiesHelper;
import java.util.Properties;

public class DataEntity
extends BaseDataEntity {
    public static final int DEDATACHGLOG_NONE = 0;
    public static final int DEDATACHGLOG_SINGLEDATA = 2;
    public static final int DEDATACHGLOG_FULLDATA = 3;
    public static final int DEDATACHGLOG_SINGLEDATA_ASYNC = 4;
    public static final int DEDATACHGLOG_FULLDATA_ASYNC = 5;
    public static final String PROPERTY_VALIDVALUE = "VALIDVALUE";
    public static final String PROPERTY_INVALIDVALUE = "INVALIDVALUE";
    public static final String PROPERTY_MAXDOWNLOADROW = "MAXDOWNLOADROW";
    public static final String PROPERTY_TRANSACTION = "TRANSACTION";
    public static final String PROPERTY_DEHELPER = "DEHELPER";
    public static final String PROPERTY_DATACTRLOBJECT = "DATACTRLOBJECT";
    public static final String PROPERTY_TEMPDATA = "TEMPDATA";
    public static final String PROPERTY_MULTIFORM = "MULTIFORM";
    public static final String PROPERTY_MULTIFORMFIELD = "MULTIFORMFIELD";
    public static final String PROPERTY_MULTIFORMFORMAT = "MULTIFORMFORMAT";
    public static final String PROPERTY_MULTIFORMFORMAT_DEFAULT = "FORM_%1$s_%2$s";
    public static final String PROPERTY_COPYSRCFIELD = "COPYSRCFIELD";
    public static final String PROPERTY_COPYSRCFIELD_DEFAULT = "SRFCOPYID";
    public static final String PROPERTY_IGNORESAVEINDEXERROR = "IGNORESAVEINDEXERROR";
    public static final String PROPERTY_LOGPODBACTION = "LOGPODBACTION";
    public static final String PROPERTY_LOGPODBQUERY = "LOGPODBQUERY";
    public static final String PROPERTY_LOGPODCACTION = "LOGPODCACTION";
    public static final String PROPERTY_DALOG = "DALOG";
    public static final String PROPERTY_DACONFIGVER = "DACONFIGVER";
    public static final int TAG_DETYPE_MAJOR = 1;
    public static final int TAG_DETYPE_ATTACHED = 2;
    public static final int TAG_DETYPE_RELATED = 3;
    public static final String STORAGETYPE_STATIC = "STATIC";
    public static final String STORAGETYPE_DYNAMIC = "DYNAMIC";
    public static final String STORAGETYPE_NONE = "NONE";
    public static final int USERACTION_NOCREATE = 1;
    public static final int USERACTION_NOUPDATE = 2;
    public static final int USERACTION_NODELETE = 4;
    public static final int USERACTION_NOVIEW = 8;
    public static final String PRINTFUNC_AUTO = "AUTO";
    public static final String PRINTFUNC_ENABLE = "ENABLE";
    public static final String PRINTFUNC_DISABLE = "DISABLE";
    public static final int INDEXMODE_NORMAL = 0;
    public static final int INDEXMODE_KEYAPPENDTYPE = 1;
    public static final String TAG_DEID = "DEID";
    public static final String TAG_DENAME = "DENAME";
    public static final String TAG_DELOGICNAME = "DELOGICNAME";
    public static final String TAG_DETYPE = "DETYPE";
    public static final String TAG_TABLENAME = "TABLENAME";
    public static final String TAG_MINORFIELDNAME = "MINORFIELDNAME";
    public static final String TAG_MINORFIELDVALUE = "MINORFIELDVALUE";
    public static final String TAG_MINORTABLENAME = "MINORTABLENAME";
    public static final String TAG_EXTABLENAME = "EXTABLENAME";
    public static final String TAG_DESCRIPTION = "DESCRIPTION";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_RESERVER = "RESERVER";
    public static final String TAG_RESERVER2 = "RESERVER2";
    public static final String TAG_ISLOGICVALID = "ISLOGICVALID";
    public static final String TAG_DEVERSION = "DEVERSION";
    public static final String TAG_SMALLICON = "SMALLICON";
    public static final String TAG_BIGICON = "BIGICON";
    public static final String TAG_VIEWNAME = "VIEWNAME";
    public static final String TAG_GRIDPAGEID = "GRIDPAGEID";
    public static final String TAG_EDITPAGEID = "EDITPAGEID";
    public static final String TAG_PICKUPPAGEID = "PICKUPPAGEID";
    public static final String TAG_MPICKUPPAGEID = "MPICKUPPAGEID";
    public static final String TAG_CONFIGHELPER = "CONFIGHELPER";
    public static final String TAG_DEHELPER = "DEHELPER";
    public static final String TAG_INFOFORMAT = "INFOFORMAT";
    public static final String TAG_INFOFIELD = "INFOFIELD";
    public static final String TAG_ACINFOFORMAT = "ACINFOFORMAT";
    public static final String TAG_ACINFOPARAM = "ACINFOPARAM";
    public static final String TAG_DEGROUP = "DEGROUP";
    public static final String TAG_DEGROUP_SRFDA = "SRFDA";
    public static final String TAG_DEGROUP_APPLICATION = "APPLICATION";
    public static final String TAG_DEGROUP_USER = "USER";
    public static final String TAG_TABLESPACE = "TABLESPACE";
    public static final String TAG_DER11DEID = "DER11DEID";
    public static final String TAG_DATACTRLOBJECT = "DATACTRLOBJECT";
    public static final String TAG_ISSUPPORTFA = "ISSUPPORTFA";
    public static final String TAG_ISINDEXDE = "ISINDEXDE";
    public static final String TAG_ISENABLEWF = "ISENABLEWF";
    public static final String TAG_ISENABLEDP = "ISENABLEDP";
    public static final String TAG_ACEXTINFO = "ACEXTINFO";
    public static final String TAG_ACOBJECT = "ACOBJECT";
    public static final String TAG_DATAACCOBJECT = "DATAACCOBJECT";
    public static final String TAG_ACQUERYMODELID = "ACQUERYMODELID";
    public static final String TAG_ACENABLEDP = "ACENABLEDP";
    public static final String TAG_ACSORTFIELD = "ACSORTFIELD";
    public static final String TAG_ACSORTDIR = "ACSORTDIR";
    public static final String TAG_ISENABLEAUDIT = "ISENABLEAUDIT";
    public static final String TAG_DGROWCLASSHELPER = "DGROWCLASSHELPER";
    public static final String TAG_DGSUMMARYHEIGHT = "DGSUMMARYHEIGHT";
    public static final String TAG_ROWAMOUNT = "ROWAMOUNT";
    public static final String TAG_INHERITMODE = "INHERITMODE";
    public static final String TAG_DBSTORAGE = "DBSTORAGE";
    public static final String TAG_EXITINGMODEL = "EXITINGMODEL";
    public static final String TAG_DEPARAM = "DEPARAM";
    public static final String TAG_DEUSERPARAM = "DEUSERPARAM";
    public static final String TAG_LICENSECODE = "LICENSECODE";
    public static final String TAG_TIPSINFO = "TIPSINFO";
    public static final String TAG_TIPSOBJECT = "TIPSOBJECT";
    public static final String TAG_USERACTION = "USERACTION";
    public static final String TAG_ISDGROWEDIT = "ISDGROWEDIT";
    public static final String TAG_STORAGETYPE = "STORAGETYPE";
    public static final String TAG_DYNAMICINTERVAL = "DYNAMICINTERVAL";
    public static final String TAG_ENABLECOLPRIV = "ENABLECOLPRIV";
    public static final String TAG_LOGAUDITDETAIL = "LOGAUDITDETAIL";
    public static final String TAG_VERSIONCHECK = "VERSIONCHECK";
    public static final String TAG_VERFIELD = "VERFIELD";
    public static final String TAG_VERCHECKTIMER = "VERCHECKTIMER";
    public static final String TAG_DEOBJECT = "DEOBJECT";
    public static final String TAG_DATACTRLINT = "DATACTRLINT";
    public static final String TAG_ENABLEGLOBALMODEL = "ENABLEGLOBALMODEL";
    public static final String TAG_GLOBALMODELOBJ = "GLOBALMODELOBJ";
    public static final String TAG_ACMAXCNT = "ACMAXCNT";
    public static final String TAG_PRINTFUNC = "PRINTFUNC";
    public static final String TAG_DBVERSION = "DBVERSION";
    public static final String TAG_EXPORTINCEMPTY = "EXPORTINCEMPTY";
    public static final String TAG_VERHELPER = "VERHELPER";
    public static final String TAG_DLKHELPER = "DLKHELPER";
    public static final String TAG_DATACHGLOGMODE = "DATACHGLOGMODE";
    public static final String TAG_NODATAINFO = "NODATAINFO";
    public static final String TAG_INDEXMODE = "INDEXMODE";
    public static final String TAG_INFOPAGEID = "INFOPAGEID";
    public static final String TAG_INFOPAGENAME = "INFOPAGENAME";
    public static final String TAG_DATANOTIFYHELPER = "DATANOTIFYHELPER";
    public static final String TAG_MULTIMAJOR = "MULTIMAJOR";
    public static final String TAG_MULTIMAJORFIELD = "MULTIMAJORFIELD";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";
    public static final String TAG_RTINFO = "RTINFO";
    public static final String TAG_VCFLAG = "VCFLAG";
    public static final String TAG_KEYPARAMS = "KEYPARAMS";
    private Properties acExtInfo = null;

    public String getDEID() {
        return this.GetParamStringValue(TAG_DEID, "").trim();
    }

    public String getDENAME() {
        return this.GetParamStringValue(TAG_DENAME, "");
    }

    public String getDELOGICNAME() {
        return this.GetParamStringValue(TAG_DELOGICNAME, "");
    }

    public String getTABLENAME() {
        return this.GetParamStringValue(TAG_TABLENAME, "");
    }

    public String getMINORFIELDNAME() {
        return this.GetParamStringValue(TAG_MINORFIELDNAME, "");
    }

    public String getMINORFIELDVALUE() {
        return this.GetParamStringValue(TAG_MINORFIELDVALUE, "");
    }

    public String getMINORTABLENAME() {
        return this.GetParamStringValue(TAG_MINORTABLENAME, "");
    }

    public String getEXTABLENAME() {
        return this.GetParamStringValue(TAG_EXTABLENAME, "");
    }

    public String getRESERVER() {
        return this.GetParamStringValue(TAG_RESERVER, "");
    }

    public String getRESERVER2() {
        return this.GetParamStringValue(TAG_RESERVER2, "");
    }

    public String getVIEWNAME() {
        return this.GetParamStringValue(TAG_VIEWNAME, "");
    }

    public String getGRIDPAGEID() {
        return this.GetParamStringValue(TAG_GRIDPAGEID, "");
    }

    public String getEDITPAGEID() {
        return this.GetParamStringValue(TAG_EDITPAGEID, "");
    }

    public String getPICKUPPAGEID() {
        return this.GetParamStringValue(TAG_PICKUPPAGEID, "");
    }

    public String getMPICKUPPAGEID() {
        return this.GetParamStringValue(TAG_MPICKUPPAGEID, "");
    }

    public String getCONFIGHELPER() {
        return this.GetParamStringValue(TAG_CONFIGHELPER, "");
    }

    public String getDEHELPER() {
        return this.GetParamStringValue("DEHELPER", "");
    }

    public String getSMALLICON() {
        return this.GetParamStringValue(TAG_SMALLICON, "../sasrfex/images/default/icon_smallicon.png");
    }

    public String getBIGICON() {
        return this.GetParamStringValue(TAG_BIGICON, "../sasrfex/images/default/icon_middleicon.png");
    }

    public String getINFOFORMAT() {
        return this.GetParamStringValue(TAG_INFOFORMAT, "");
    }

    public String getINFOFIELD() {
        return this.GetParamStringValue(TAG_INFOFIELD, "");
    }

    public String getACINFOFORMAT() {
        return this.GetParamStringValue(TAG_ACINFOFORMAT, "");
    }

    public String getACINFOPARAM() {
        return this.GetParamStringValue(TAG_ACINFOPARAM, "");
    }

    public String getACEXTINFO() {
        return this.GetParamStringValue(TAG_ACEXTINFO, "");
    }

    public String getACOBJECT() {
        return this.GetParamStringValue(TAG_ACOBJECT, "");
    }

    public String getDATAACCOBJECT() {
        return this.GetParamStringValue(TAG_DATAACCOBJECT, "");
    }

    public String getACQUERYMODELID() {
        return this.GetParamStringValue(TAG_ACQUERYMODELID, "");
    }

    public boolean isACENABLEDP() {
        return this.GetParamIntValue(TAG_ACENABLEDP, 0) == 1;
    }

    public String getACSORTFIELD() {
        return this.GetParamStringValue(TAG_ACSORTFIELD, "");
    }

    public String getACSORTDIR() {
        return this.GetParamStringValue(TAG_ACSORTDIR, "");
    }

    public boolean isINHERITMODE() {
        return this.GetParamIntValue(TAG_INHERITMODE, 0) == 1;
    }

    public String getDEGROUP() {
        return this.GetParamStringValue(TAG_DEGROUP, "");
    }

    public String getTABLESPACE() {
        return this.GetParamStringValue(TAG_TABLESPACE, "");
    }

    public String getDER11DEID() {
        return this.GetParamStringValue(TAG_DER11DEID, "");
    }

    public String getDATACTRLOBJECT() {
        return this.GetParamStringValue("DATACTRLOBJECT", "");
    }

    public String getDGROWCLASSHELPER() {
        return this.GetParamStringValue(TAG_DGROWCLASSHELPER, "");
    }

    public int getDGSUMMARYHEIGHT() {
        return this.GetParamIntValue(TAG_DGSUMMARYHEIGHT, 0);
    }

    public String getDBSTORAGE() {
        return this.GetParamStringValue(TAG_DBSTORAGE, "");
    }

    public String getDEPARAM() {
        return this.GetParamStringValue(TAG_DEPARAM, "");
    }

    public String getDEUSERPARAM() {
        return this.GetParamStringValue(TAG_DEUSERPARAM, "");
    }

    public String getLICENSECODE() {
        return this.GetParamStringValue(TAG_LICENSECODE, "");
    }

    public int getROWAMOUNT() {
        return this.GetParamIntValue(TAG_ROWAMOUNT, 10000);
    }

    public void setROWAMOUNT(int nValue) {
        this.SetParamValue(TAG_ROWAMOUNT, nValue);
    }

    public void setINHERITMODE(boolean bValue) {
        this.SetParamValue(TAG_INHERITMODE, bValue ? 1 : 0);
    }

    public void setDEID(String strValue) {
        this.SetParamValue(TAG_DEID, strValue);
    }

    public void setDENAME(String strValue) {
        this.SetParamValue(TAG_DENAME, strValue);
    }

    public void setDELOGICNAME(String strValue) {
        this.SetParamValue(TAG_DELOGICNAME, strValue);
    }

    public void setTABLENAME(String strValue) {
        this.SetParamValue(TAG_TABLENAME, strValue);
    }

    public void setMINORFIELDNAME(String strValue) {
        this.SetParamValue(TAG_MINORFIELDNAME, strValue);
    }

    public void setMINORFIELDVALUE(String strValue) {
        this.SetParamValue(TAG_MINORFIELDVALUE, strValue);
    }

    public void setMINORTABLENAME(String strValue) {
        this.SetParamValue(TAG_MINORTABLENAME, strValue);
    }

    public void setEXTABLENAME(String strValue) {
        this.SetParamValue(TAG_EXTABLENAME, strValue);
    }

    public void setRESERVER(String strValue) {
        this.SetParamValue(TAG_RESERVER, strValue);
    }

    public void setRESERVER2(String strValue) {
        this.SetParamValue(TAG_RESERVER2, strValue);
    }

    public void setVIEWNAME(String strValue) {
        this.SetParamValue(TAG_VIEWNAME, strValue);
    }

    public void setGRIDPAGEID(String strValue) {
        this.SetParamValue(TAG_GRIDPAGEID, strValue);
    }

    public void setEDITPAGEID(String strValue) {
        this.SetParamValue(TAG_EDITPAGEID, strValue);
    }

    public void setPICKUPPAGEID(String strValue) {
        this.SetParamValue(TAG_PICKUPPAGEID, strValue);
    }

    public void setCONFIGHELPER(String strValue) {
        this.SetParamValue(TAG_CONFIGHELPER, strValue);
    }

    public void setDEHELPER(String strValue) {
        this.SetParamValue("DEHELPER", strValue);
    }

    public void setINFOFORMAT(String strValue) {
        this.SetParamValue(TAG_INFOFORMAT, strValue);
    }

    public void setINFOFIELD(String strValue) {
        this.SetParamValue(TAG_INFOFIELD, strValue);
    }

    public void setDEGROUP(String strValue) {
        this.SetParamValue(TAG_DEGROUP, strValue);
    }

    public void setTABLESPACE(String strValue) {
        this.SetParamValue(TAG_TABLESPACE, strValue);
    }

    public void setDER11DEID(String strValue) {
        this.SetParamValue(TAG_DER11DEID, strValue);
    }

    public void setDATACTRLOBJECT(String strValue) {
        this.SetParamValue("DATACTRLOBJECT", strValue);
    }

    public void setDBSTORAGE(String strValue) {
        this.SetParamValue(TAG_DBSTORAGE, strValue);
    }

    public void setDEPARAM(String strValue) {
        this.SetParamValue(TAG_DEPARAM, strValue);
    }

    public void setEXITINGMODEL(boolean bValue) {
        this.SetParamValue(TAG_EXITINGMODEL, bValue ? 1 : 0);
    }

    public int getDETYPE() {
        return this.GetParamIntValue(TAG_DETYPE, 0);
    }

    public int getDEVERSION() {
        return this.GetParamIntValue(TAG_DEVERSION, 0);
    }

    public boolean isLOGICVALID() {
        return this.GetParamIntValue(TAG_ISLOGICVALID, 0) == 1;
    }

    public boolean isSUPPORTFA() {
        return this.GetParamIntValue(TAG_ISSUPPORTFA, 0) == 1;
    }

    public boolean isINDEXDE() {
        return this.GetParamIntValue(TAG_ISINDEXDE, 0) == 1;
    }

    public boolean isENABLEWF() {
        return this.GetParamIntValue(TAG_ISENABLEWF, 0) == 1;
    }

    public boolean isENABLEDP() {
        return this.GetParamIntValue(TAG_ISENABLEDP, 0) == 1;
    }

    public boolean isENABLEAUDIT() {
        return this.GetParamIntValue(TAG_ISENABLEAUDIT, 0) == 1;
    }

    public boolean isEXITINGMODEL() {
        return this.GetParamIntValue(TAG_EXITINGMODEL, 0) == 1;
    }

    public String getTIPSINFO() {
        return this.GetParamStringValue(TAG_TIPSINFO, "");
    }

    public void setTIPSINFO(String strValue) {
        this.SetParamValue(TAG_TIPSINFO, strValue);
    }

    public String getTIPSOBJECT() {
        return this.GetParamStringValue(TAG_TIPSOBJECT, "");
    }

    public void setTIPSOBJECT(String strValue) {
        this.SetParamValue(TAG_TIPSOBJECT, strValue);
    }

    public int getUSERACTION() {
        return this.GetParamIntValue(TAG_USERACTION, 0);
    }

    public void setUSERACTION(int strValue) {
        this.SetParamValue(TAG_USERACTION, strValue);
    }

    public boolean getISDGROWEDIT() {
        return this.GetParamIntValue(TAG_ISDGROWEDIT, 0) == 1;
    }

    public void setISDGROWEDIT(boolean bValue) {
        this.SetParamValue(TAG_ISDGROWEDIT, bValue ? 1 : 0);
    }

    public String getSTORAGETYPE() {
        return this.GetParamStringValue(TAG_STORAGETYPE, "");
    }

    public void setSTORAGETYPE(String strValue) {
        this.SetParamValue(TAG_STORAGETYPE, strValue);
    }

    public int getDYNAMICINTERVAL() {
        return this.GetParamIntValue(TAG_DYNAMICINTERVAL, 0);
    }

    public void setDYNAMICINTERVAL(int strValue) {
        this.SetParamValue(TAG_DYNAMICINTERVAL, strValue);
    }

    public boolean getENABLECOLPRIV() {
        return this.GetParamIntValue(TAG_ENABLECOLPRIV, 0) == 1;
    }

    public void setENABLECOLPRIV(boolean bValue) {
        this.SetParamValue(TAG_ENABLECOLPRIV, bValue ? 1 : 0);
    }

    public boolean getLOGAUDITDETAIL() {
        return this.GetParamIntValue(TAG_LOGAUDITDETAIL, 0) == 1;
    }

    public void setLOGAUDITDETAIL(boolean bValue) {
        this.SetParamValue(TAG_LOGAUDITDETAIL, bValue ? 1 : 0);
    }

    public boolean getVERSIONCHECK() {
        return this.GetParamIntValue(TAG_VERSIONCHECK, 0) == 1;
    }

    public void setVERSIONCHECK(boolean bValue) {
        this.SetParamValue(TAG_VERSIONCHECK, bValue ? 1 : 0);
    }

    public String getVERFIELD() {
        return this.GetParamStringValue(TAG_VERFIELD, "");
    }

    public void setVERFIELD(String strValue) {
        this.SetParamValue(TAG_VERFIELD, strValue);
    }

    public int getVERCHECKTIMER() {
        return this.GetParamIntValue(TAG_VERCHECKTIMER, 0);
    }

    public void setVERCHECKTIMER(int strValue) {
        this.SetParamValue(TAG_VERCHECKTIMER, strValue);
    }

    public String getDEOBJECT() {
        return this.GetParamStringValue(TAG_DEOBJECT, "");
    }

    public void setDEOBJECT(String strValue) {
        this.SetParamValue(TAG_DEOBJECT, strValue);
    }

    public String getDATACTRLINT() {
        return this.GetParamStringValue(TAG_DATACTRLINT, "");
    }

    public void setDATACTRLINT(String strValue) {
        this.SetParamValue(TAG_DATACTRLINT, strValue);
    }

    public boolean getENABLEGLOBALMODEL() {
        return this.GetParamIntValue(TAG_ENABLEGLOBALMODEL, 0) == 1;
    }

    public void setENABLEGLOBALMODEL(boolean bValue) {
        this.SetParamValue(TAG_ENABLEGLOBALMODEL, bValue ? 1 : 0);
    }

    public String getGLOBALMODELOBJ() {
        return this.GetParamStringValue(TAG_GLOBALMODELOBJ, "");
    }

    public void setGLOBALMODELOBJ(String strValue) {
        this.SetParamValue(TAG_GLOBALMODELOBJ, strValue);
    }

    public boolean isACMAXCNTNull() {
        return this.IsParamNull(TAG_ACMAXCNT);
    }

    public int getACMAXCNT() {
        return this.GetParamIntValue(TAG_ACMAXCNT, 0);
    }

    public void setACMAXCNT(int strValue) {
        this.SetParamValue(TAG_ACMAXCNT, strValue);
    }

    public boolean isPRINTFUNCNull() {
        return this.IsParamNull(TAG_PRINTFUNC);
    }

    public String getPRINTFUNC() {
        return this.GetParamStringValue(TAG_PRINTFUNC, "");
    }

    public void setPRINTFUNC(String strValue) {
        this.SetParamValue(TAG_PRINTFUNC, strValue);
    }

    public boolean isDBVERSIONNull() {
        return this.IsParamNull(TAG_DBVERSION);
    }

    public int getDBVERSION() {
        return this.GetParamIntValue(TAG_DBVERSION, 0);
    }

    public void setDBVERSION(int strValue) {
        this.SetParamValue(TAG_DBVERSION, strValue);
    }

    public boolean isEXPORTINCEMPTYNull() {
        return this.IsParamNull(TAG_EXPORTINCEMPTY);
    }

    public boolean getEXPORTINCEMPTY() {
        return this.GetParamIntValue(TAG_EXPORTINCEMPTY, 0) == 1;
    }

    public boolean isVERHELPERNull() {
        return this.IsParamNull(TAG_VERHELPER);
    }

    public String getVERHELPER() {
        return this.GetParamStringValue(TAG_VERHELPER, "");
    }

    public void setVERHELPER(String strValue) {
        this.SetParamValue(TAG_VERHELPER, strValue);
    }

    public void setEXPORTINCEMPTY(boolean bValue) {
        this.SetParamValue(TAG_EXPORTINCEMPTY, bValue ? 1 : 0);
    }

    public boolean isDLKHELPERNull() {
        return this.IsParamNull(TAG_DLKHELPER);
    }

    public String getDLKHELPER() {
        return this.GetParamStringValue(TAG_DLKHELPER, "");
    }

    public void setDLKHELPER(String strValue) {
        this.SetParamValue(TAG_DLKHELPER, strValue);
    }

    public boolean isDATACHGLOGMODENull() {
        return this.IsParamNull(TAG_DATACHGLOGMODE);
    }

    public int getDATACHGLOGMODE() {
        return this.GetParamIntValue(TAG_DATACHGLOGMODE, 0);
    }

    public void setDATACHGLOGMODE(int nValue) {
        this.SetParamValue(TAG_DATACHGLOGMODE, nValue);
    }

    public final boolean isNODATAINFONull() {
        return this.IsParamNull(TAG_NODATAINFO);
    }

    public final boolean getNODATAINFO() {
        return this.GetParamIntValue(TAG_NODATAINFO, 0) == 1;
    }

    public final void setNODATAINFO(boolean bValue) {
        this.SetParamValue(TAG_NODATAINFO, bValue ? 1 : 0);
    }

    public final boolean isINDEXMODENull() {
        return this.IsParamNull(TAG_INDEXMODE);
    }

    public final int getINDEXMODE() {
        return this.GetParamIntValue(TAG_INDEXMODE, 0);
    }

    public final void setINDEXMODE(int nValue) {
        this.SetParamValue(TAG_INDEXMODE, nValue);
    }

    public final boolean isINFOPAGEIDNull() {
        return this.IsParamNull(TAG_INFOPAGEID);
    }

    public final String getINFOPAGEID() {
        return this.GetParamStringValue(TAG_INFOPAGEID, "");
    }

    public final void setINFOPAGEID(String strValue) {
        this.SetParamValue(TAG_INFOPAGEID, strValue);
    }

    public final boolean isINFOPAGENAMENull() {
        return this.IsParamNull(TAG_INFOPAGENAME);
    }

    public final String getINFOPAGENAME() {
        return this.GetParamStringValue(TAG_INFOPAGENAME, "");
    }

    public final void setINFOPAGENAME(String strValue) {
        this.SetParamValue(TAG_INFOPAGENAME, strValue);
    }

    public final boolean isDATANOTIFYHELPERNull() {
        return this.IsParamNull(TAG_DATANOTIFYHELPER);
    }

    public final String getDATANOTIFYHELPER() {
        return this.GetParamStringValue(TAG_DATANOTIFYHELPER, "");
    }

    public final void setDATANOTIFYHELPER(String strValue) {
        this.SetParamValue(TAG_DATANOTIFYHELPER, strValue);
    }

    public final boolean isMULTIMAJORNull() {
        return this.IsParamNull(TAG_MULTIMAJOR);
    }

    public final boolean getMULTIMAJOR() {
        return this.GetParamIntValue(TAG_MULTIMAJOR, 0) == 1;
    }

    public final void setMULTIMAJOR(boolean bValue) {
        this.SetParamValue(TAG_MULTIMAJOR, bValue ? 1 : 0);
    }

    public final boolean isMULTIMAJORFIELDNull() {
        return this.IsParamNull(TAG_MULTIMAJORFIELD);
    }

    public final String getMULTIMAJORFIELD() {
        return this.GetParamStringValue(TAG_MULTIMAJORFIELD, "");
    }

    public final void setMULTIMAJORFIELD(String strValue) {
        this.SetParamValue(TAG_MULTIMAJORFIELD, strValue);
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

    public final boolean isRTINFONull() {
        return this.IsParamNull(TAG_RTINFO);
    }

    public final String getRTINFO() {
        return this.GetParamStringValue(TAG_RTINFO, "");
    }

    public final void setRTINFO(String strValue) {
        this.SetParamValue(TAG_RTINFO, strValue);
    }

    public final boolean isVCFLAGNull() {
        return this.IsParamNull(TAG_VCFLAG);
    }

    public final boolean getVCFLAG() {
        return this.GetParamIntValue(TAG_VCFLAG, 0) == 1;
    }

    public final void setVCFLAG(boolean bValue) {
        this.SetParamValue(TAG_VCFLAG, bValue ? 1 : 0);
    }

    public final boolean isKEYPARAMSNull() {
        return this.IsParamNull(TAG_KEYPARAMS);
    }

    public final String getKEYPARAMS() {
        return this.GetParamStringValue(TAG_KEYPARAMS, "");
    }

    public final void setKEYPARAMS(String strValue) {
        this.SetParamValue(TAG_KEYPARAMS, strValue);
    }

    private synchronized void BuildACExtInfo() {
        try {
            if (this.acExtInfo != null) {
                return;
            }
            String strExtInfo = this.getACEXTINFO();
            if (!StringHelper.IsNullOrEmpty((String)strExtInfo)) {
                this.acExtInfo = new Properties();
                this.acExtInfo = PropertiesHelper.Load((Properties)this.acExtInfo, (String)strExtInfo);
            } else {
                this.acExtInfo = new Properties();
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    public Properties getACExtInfo() {
        if (this.acExtInfo == null) {
            this.BuildACExtInfo();
        }
        return this.acExtInfo;
    }

    public boolean IsParamNull(String strParamName) {
        if (!super.IsParamNull(strParamName)) {
            return false;
        }
        return StringHelper.Compare((String)strParamName, (String)TAG_RTINFO, (boolean)true) != 0;
    }

    public Object GetParamValue(String strParamName) {
        String strDEId;
        Object objValue = super.GetParamValue(strParamName);
        if (objValue != null) {
            return objValue;
        }
        if (StringHelper.Compare((String)strParamName, (String)TAG_RTINFO, (boolean)true) == 0 && !StringHelper.IsNullOrEmpty((String)(strDEId = this.getDEID()))) {
            IDEHelper iDEHelper = GlobalHelperEx.getInstance().getDAModelStorage().FindDEHelper(strDEId);
            if (iDEHelper == null) {
                return null;
            }
            return iDEHelper.GetRuntimeInfo();
        }
        return null;
    }
}

