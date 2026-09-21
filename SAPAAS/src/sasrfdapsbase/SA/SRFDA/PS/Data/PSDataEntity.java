/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSDataEntity
extends BaseDataEntity {
    public static final String INDEXDETYPE_INDEX = "INDEX";
    public static final String INDEXDETYPE_INHERIT = "INHERIT";
    public static final int DETYPE_MAJOR = 1;
    public static final int DETYPE_ATTACHED = 2;
    public static final int DETYPE_RELATED = 3;
    public static final String DSLINK_DEFAULT = "DEFAULT";
    public static final String DSLINK_DB1 = "DB1";
    public static final String DSLINK_DB2 = "DB2";
    public static final String DSLINK_DB3 = "DB3";
    public static final String DSLINK_DB4 = "DB4";
    public static final String DBTABSPACE_TABLESPACE = "TABLESPACE";
    public static final String DBTABSPACE_TABLESPACE2 = "TABLESPACE2";
    public static final String DBTABSPACE_TABLESPACE3 = "TABLESPACE3";
    public static final String DBTABSPACE_TABLESPACE4 = "TABLESPACE4";
    public static final int STORAGEMODE_NONE = 0;
    public static final int STORAGEMODE_SQL = 1;
    public static final int STORAGEMODE_NoSQL = 2;
    public static final int STORAGEMODE_SQLAndNoSQL = 3;
    public static final int DATAIMPEXPFLAG_NONE = 0;
    public static final int DATAIMPEXPFLAG_EXPORT = 1;
    public static final int DATAIMPEXPFLAG_IMPORT = 2;
    public static final int DATAIMPEXPFLAG_ALL = 3;
    public static final int MODELIMPEXPFLAG__NONE = 0;
    public static final int MODELIMPEXPFLAG_EXPORT = 1;
    public static final int MODELIMPEXPFLAG_IMPORT = 2;
    public static final int MODELIMPEXPFLAG_ALL = 3;
    public static final int SERVICEAPIFLAG_NO = 0;
    public static final int SERVICEAPIFLAG_YES = 1;
    public static final int MSACTIONLOGICFLAG_NONE = 0;
    public static final int MSACTIONLOGICFLAG_1 = 1;
    public static final int MSACTIONLOGICFLAG_2 = 2;
    public static final int MSACTIONLOGICFLAG_3 = 3;
    public static final String TAG_PSDATAENTITYID = "PSDATAENTITYID";
    public static final String TAG_PSDATAENTITYNAME = "PSDATAENTITYNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSSYSTEMID = "PSSYSTEMID";
    public static final String TAG_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String TAG_DESN = "DESN";
    public static final String TAG_LOGICNAME = "LOGICNAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_TABLENAME = "TABLENAME";
    public static final String TAG_VIEWNAME = "VIEWNAME";
    public static final String TAG_SYSTEMFLAG = "SYSTEMFLAG";
    public static final String TAG_LOGICVALID = "LOGICVALID";
    public static final String TAG_CODENAME = "CODENAME";
    public static final String TAG_KEYRULE = "KEYRULE";
    public static final String TAG_PSMODULEID = "PSMODULEID";
    public static final String TAG_PSMODULENAME = "PSMODULENAME";
    public static final String TAG_INDEXDETYPE = "INDEXDETYPE";
    public static final String TAG_ENAMULTIFORM = "ENAMULTIFORM";
    public static final String TAG_ENATEMPDATA = "ENATEMPDATA";
    public static final String TAG_DETYPE = "DETYPE";
    public static final String TAG_USERACTION = "USERACTION";
    public static final String TAG_MODELVER = "MODELVER";
    public static final String TAG_DBVER = "DBVER";
    public static final String TAG_DSLINK = "DSLINK";
    public static final String TAG_DBTABSPACE = "DBTABSPACE";
    public static final String TAG_ENABLEMULTIDS = "ENABLEMULTIDS";
    public static final String TAG_EXTABLENAME = "EXTABLENAME";
    public static final String TAG_ENABLEORGMODEL = "ENABLEORGMODEL";
    public static final String TAG_ENABLEAUDIT = "ENABLEAUDIT";
    public static final String TAG_BASECLSPARAMS = "BASECLSPARAMS";
    public static final String TAG_SUBSYSDE = "SUBSYSDE";
    public static final String TAG_ENABLEDALOG = "ENABLEDALOG";
    public static final String TAG_AUDITMODE = "AUDITMODE";
    public static final String TAG_DATAACCMODE = "DATAACCMODE";
    public static final String TAG_PSSYSIMAGEID = "PSSYSIMAGEID";
    public static final String TAG_PSSYSIMAGENAME = "PSSYSIMAGENAME";
    public static final String TAG_DYNAMICMODE = "DYNAMICMODE";
    public static final String TAG_SVRPUBMODE = "SVRPUBMODE";
    public static final String TAG_USERPARAMS = "USERPARAMS";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";
    public static final String TAG_TESTCASEFLAG = "TESTCASEFLAG";
    public static final String TAG_EXISTINGMODEL = "EXISTINGMODEL";
    public static final String TAG_PSSYSREQITEMID = "PSSYSREQITEMID";
    public static final String TAG_PSSYSREQITEMNAME = "PSSYSREQITEMNAME";
    public static final String TAG_DATACHGLOGMODE = "DATACHGLOGMODE";
    public static final String TAG_PSDETOOLBARSCNT = "PSDETOOLBARSCNT";
    public static final String TAG_STORAGEMODE = "STORAGEMODE";
    public static final String TAG_VIRTUALFLAG = "VIRTUALFLAG";
    public static final String TAG_NOVIEWMODE = "NOVIEWMODE";
    public static final String TAG_LOGICVALIDVALUE = "LOGICVALIDVALUE";
    public static final String TAG_LOGICINVALIDVALUE = "LOGICINVALIDVALUE";
    public static final String TAG_LNPSLANRESID = "LNPSLANRESID";
    public static final String TAG_LNPSLANRESNAME = "LNPSLANRESNAME";
    public static final String TAG_PSHELPMODULEID = "PSHELPMODULEID";
    public static final String TAG_PSHELPMODULENAME = "PSHELPMODULENAME";
    public static final String TAG_VKEYSEPARATOR = "VKEYSEPARATOR";
    public static final String TAG_VIEWNAME2 = "VIEWNAME2";
    public static final String TAG_VIEWNAME3 = "VIEWNAME3";
    public static final String TAG_VIEWNAME4 = "VIEWNAME4";
    public static final String TAG_USERTAG = "USERTAG";
    public static final String TAG_USERTAG2 = "USERTAG2";
    public static final String TAG_VIEWLEVEL = "VIEWLEVEL";
    public static final String TAG_ENABLEENTITYCACHE = "ENABLEENTITYCACHE";
    public static final String TAG_MAXENTITYCACHECNT = "MAXENTITYCACHECNT";
    public static final String TAG_ENTITYCACHETIMEOUT = "ENTITYCACHETIMEOUT";
    public static final String TAG_DATAIMPEXPFLAG = "DATAIMPEXPFLAG";
    public static final String TAG_MODELIMPEXPFLAG = "MODELIMPEXPFLAG";
    public static final String TAG_SERVICEAPIFLAG = "SERVICEAPIFLAG";
    public static final String TAG_PSSUBSYSSERVICEAPIID = "PSSUBSYSSERVICEAPIID";
    public static final String TAG_PSSUBSYSSERVICEAPINAME = "PSSUBSYSSERVICEAPINAME";
    public static final String TAG_ENABLESELECT = "ENABLESELECT";
    public static final String TAG_ENABLEDEACTION = "ENABLEDEACTION";
    public static final String TAG_ENABLEDEDATASET = "ENABLEDEDATASET";
    public static final String TAG_SERVICECODENAME = "SERVICECODENAME";
    public static final String TAG_ACCCTRLARCH = "ACCCTRLARCH";
    public static final String TAG_DYNAMODELFLAG = "DYNAMODELFLAG";
    public static final String TAG_PSDYNADETEMPLID = "PSDYNADETEMPLID";
    public static final String TAG_PSDYNADETEMPLNAME = "PSDYNADETEMPLNAME";
    public static final String TAG_PSDYNAINSTID = "PSDYNAINSTID";
    public static final String TAG_PSSYSMODELGROUPID = "PSSYSMODELGROUPID";
    public static final String TAG_PSSYSMODELGROUPNAME = "PSSYSMODELGROUPNAME";
    public static final String TAG_SAASMODE = "SAASMODE";
    public static final String TAG_USERTAG3 = "USERTAG3";
    public static final String TAG_USERTAG4 = "USERTAG4";
    public static final String TAG_USERCAT = "USERCAT";
    public static final String TAG_ENABLEDATAVER = "ENABLEDATAVER";
    public static final String TAG_PSSUBSYSSADEID = "PSSUBSYSSADEID";
    public static final String TAG_PSSUBSYSSADENAME = "PSSUBSYSSADENAME";
    public static final String TAG_AUTOMODEL = "AUTOMODEL";
    public static final String TAG_MSACTIONLOGICFLAG = "MSACTIONLOGICFLAG";
    public static final String TAG_ORDERVALUE = "ORDERVALUE";
    public static final String TAG_READONLYMODE = "READONLYMODE";
    public static final String TAG_ENABLEDYNASYS = "ENABLEDYNASYS";
    public static final String TAG_BIZTAG = "BIZTAG";
    public static final String TAG_DEHOLDER = "DEHOLDER";
    public static final String TAG_PSSYSSFPLUGINID = "PSSYSSFPLUGINID";
    public static final String TAG_PSSYSSFPLUGINNAME = "PSSYSSFPLUGINNAME";
    public static final String TAG_DETAG = "DETAG";
    public static final String TAG_DETAG2 = "DETAG2";
    public static final String TAG_CODENAMEMODE = "CODENAMEMODE";
    public static final String TAG_ENABLEPQL = "ENABLEPQL";
    public static final String TAG_PSSYSUNIRESID = "PSSYSUNIRESID";
    public static final String TAG_PSSYSUNIRESNAME = "PSSYSUNIRESNAME";

    public final boolean isPSDATAENTITYIDNull() {
        return this.IsParamNull(TAG_PSDATAENTITYID);
    }

    public final String getPSDATAENTITYID() {
        return this.GetParamStringValue(TAG_PSDATAENTITYID, "");
    }

    public final void setPSDATAENTITYID(String strValue) {
        this.SetParamValue(TAG_PSDATAENTITYID, strValue);
    }

    public final boolean isPSDATAENTITYNAMENull() {
        return this.IsParamNull(TAG_PSDATAENTITYNAME);
    }

    public final String getPSDATAENTITYNAME() {
        return this.GetParamStringValue(TAG_PSDATAENTITYNAME, "");
    }

    public final void setPSDATAENTITYNAME(String strValue) {
        this.SetParamValue(TAG_PSDATAENTITYNAME, strValue);
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

    public final boolean isPSSYSTEMIDNull() {
        return this.IsParamNull(TAG_PSSYSTEMID);
    }

    public final String getPSSYSTEMID() {
        return this.GetParamStringValue(TAG_PSSYSTEMID, "");
    }

    public final void setPSSYSTEMID(String strValue) {
        this.SetParamValue(TAG_PSSYSTEMID, strValue);
    }

    public final boolean isPSSYSTEMNAMENull() {
        return this.IsParamNull(TAG_PSSYSTEMNAME);
    }

    public final String getPSSYSTEMNAME() {
        return this.GetParamStringValue(TAG_PSSYSTEMNAME, "");
    }

    public final void setPSSYSTEMNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSTEMNAME, strValue);
    }

    public final boolean isDESNNull() {
        return this.IsParamNull(TAG_DESN);
    }

    public final String getDESN() {
        return this.GetParamStringValue(TAG_DESN, "");
    }

    public final void setDESN(String strValue) {
        this.SetParamValue(TAG_DESN, strValue);
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

    public final boolean isMEMONull() {
        return this.IsParamNull(TAG_MEMO);
    }

    public final String getMEMO() {
        return this.GetParamStringValue(TAG_MEMO, "");
    }

    public final void setMEMO(String strValue) {
        this.SetParamValue(TAG_MEMO, strValue);
    }

    public final boolean isTABLENAMENull() {
        return this.IsParamNull(TAG_TABLENAME);
    }

    public final String getTABLENAME() {
        return this.GetParamStringValue(TAG_TABLENAME, "");
    }

    public final void setTABLENAME(String strValue) {
        this.SetParamValue(TAG_TABLENAME, strValue);
    }

    public final boolean isVIEWNAMENull() {
        return this.IsParamNull(TAG_VIEWNAME);
    }

    public final String getVIEWNAME() {
        return this.GetParamStringValue(TAG_VIEWNAME, "");
    }

    public final void setVIEWNAME(String strValue) {
        this.SetParamValue(TAG_VIEWNAME, strValue);
    }

    public final boolean isSYSTEMFLAGNull() {
        return this.IsParamNull(TAG_SYSTEMFLAG);
    }

    public final boolean getSYSTEMFLAG() {
        return this.GetParamIntValue(TAG_SYSTEMFLAG, 0) == 1;
    }

    public final void setSYSTEMFLAG(boolean bValue) {
        this.SetParamValue(TAG_SYSTEMFLAG, bValue ? 1 : 0);
    }

    public final boolean isLOGICVALIDNull() {
        return this.IsParamNull(TAG_LOGICVALID);
    }

    public final boolean getLOGICVALID() {
        return this.GetParamIntValue(TAG_LOGICVALID, 0) == 1;
    }

    public final void setLOGICVALID(boolean bValue) {
        this.SetParamValue(TAG_LOGICVALID, bValue ? 1 : 0);
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

    public final boolean isKEYRULENull() {
        return this.IsParamNull(TAG_KEYRULE);
    }

    public final String getKEYRULE() {
        return this.GetParamStringValue(TAG_KEYRULE, "");
    }

    public final void setKEYRULE(String strValue) {
        this.SetParamValue(TAG_KEYRULE, strValue);
    }

    public final boolean isPSMODULEIDNull() {
        return this.IsParamNull(TAG_PSMODULEID);
    }

    public final String getPSMODULEID() {
        return this.GetParamStringValue(TAG_PSMODULEID, "");
    }

    public final void setPSMODULEID(String strValue) {
        this.SetParamValue(TAG_PSMODULEID, strValue);
    }

    public final boolean isPSMODULENAMENull() {
        return this.IsParamNull(TAG_PSMODULENAME);
    }

    public final String getPSMODULENAME() {
        return this.GetParamStringValue(TAG_PSMODULENAME, "");
    }

    public final void setPSMODULENAME(String strValue) {
        this.SetParamValue(TAG_PSMODULENAME, strValue);
    }

    public final boolean isINDEXDETYPENull() {
        return this.IsParamNull(TAG_INDEXDETYPE);
    }

    public final String getINDEXDETYPE() {
        return this.GetParamStringValue(TAG_INDEXDETYPE, "");
    }

    public final void setINDEXDETYPE(String strValue) {
        this.SetParamValue(TAG_INDEXDETYPE, strValue);
    }

    public final boolean isENAMULTIFORMNull() {
        return this.IsParamNull(TAG_ENAMULTIFORM);
    }

    public final int getENAMULTIFORM() {
        return this.GetParamIntValue(TAG_ENAMULTIFORM, 0);
    }

    public final void setENAMULTIFORM(int nValue) {
        this.SetParamValue(TAG_ENAMULTIFORM, nValue);
    }

    public final boolean isENATEMPDATANull() {
        return this.IsParamNull(TAG_ENATEMPDATA);
    }

    public final int getENATEMPDATA() {
        return this.GetParamIntValue(TAG_ENATEMPDATA, 0);
    }

    public final void setENATEMPDATA(int nValue) {
        this.SetParamValue(TAG_ENATEMPDATA, nValue);
    }

    public final boolean isDETYPENull() {
        return this.IsParamNull(TAG_DETYPE);
    }

    public final int getDETYPE() {
        return this.GetParamIntValue(TAG_DETYPE, 0);
    }

    public final void setDETYPE(int nValue) {
        this.SetParamValue(TAG_DETYPE, nValue);
    }

    public final boolean isUSERACTIONNull() {
        return this.IsParamNull(TAG_USERACTION);
    }

    public final int getUSERACTION() {
        return this.GetParamIntValue(TAG_USERACTION, 0);
    }

    public final void setUSERACTION(int nValue) {
        this.SetParamValue(TAG_USERACTION, nValue);
    }

    public final boolean isMODELVERNull() {
        return this.IsParamNull(TAG_MODELVER);
    }

    public final int getMODELVER() {
        return this.GetParamIntValue(TAG_MODELVER, 0);
    }

    public final void setMODELVER(int nValue) {
        this.SetParamValue(TAG_MODELVER, nValue);
    }

    public final boolean isDBVERNull() {
        return this.IsParamNull(TAG_DBVER);
    }

    public final int getDBVER() {
        return this.GetParamIntValue(TAG_DBVER, 0);
    }

    public final void setDBVER(int nValue) {
        this.SetParamValue(TAG_DBVER, nValue);
    }

    public final boolean isDSLINKNull() {
        return this.IsParamNull(TAG_DSLINK);
    }

    public final String getDSLINK() {
        return this.GetParamStringValue(TAG_DSLINK, "");
    }

    public final void setDSLINK(String strValue) {
        this.SetParamValue(TAG_DSLINK, strValue);
    }

    public final boolean isDBTABSPACENull() {
        return this.IsParamNull(TAG_DBTABSPACE);
    }

    public final String getDBTABSPACE() {
        return this.GetParamStringValue(TAG_DBTABSPACE, "");
    }

    public final void setDBTABSPACE(String strValue) {
        this.SetParamValue(TAG_DBTABSPACE, strValue);
    }

    public final boolean isENABLEMULTIDSNull() {
        return this.IsParamNull(TAG_ENABLEMULTIDS);
    }

    public final boolean getENABLEMULTIDS() {
        return this.GetParamIntValue(TAG_ENABLEMULTIDS, 0) == 1;
    }

    public final void setENABLEMULTIDS(boolean bValue) {
        this.SetParamValue(TAG_ENABLEMULTIDS, bValue ? 1 : 0);
    }

    public final boolean isEXTABLENAMENull() {
        return this.IsParamNull(TAG_EXTABLENAME);
    }

    public final String getEXTABLENAME() {
        return this.GetParamStringValue(TAG_EXTABLENAME, "");
    }

    public final void setEXTABLENAME(String strValue) {
        this.SetParamValue(TAG_EXTABLENAME, strValue);
    }

    public final boolean isENABLEORGMODELNull() {
        return this.IsParamNull(TAG_ENABLEORGMODEL);
    }

    public final boolean getENABLEORGMODEL() {
        return this.GetParamIntValue(TAG_ENABLEORGMODEL, 0) == 1;
    }

    public final void setENABLEORGMODEL(boolean bValue) {
        this.SetParamValue(TAG_ENABLEORGMODEL, bValue ? 1 : 0);
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

    public final boolean isBASECLSPARAMSNull() {
        return this.IsParamNull(TAG_BASECLSPARAMS);
    }

    public final String getBASECLSPARAMS() {
        return this.GetParamStringValue(TAG_BASECLSPARAMS, "");
    }

    public final void setBASECLSPARAMS(String strValue) {
        this.SetParamValue(TAG_BASECLSPARAMS, strValue);
    }

    public final boolean isSUBSYSDENull() {
        return this.IsParamNull(TAG_SUBSYSDE);
    }

    public final boolean getSUBSYSDE() {
        return this.GetParamIntValue(TAG_SUBSYSDE, 0) == 1;
    }

    public final void setSUBSYSDE(boolean bValue) {
        this.SetParamValue(TAG_SUBSYSDE, bValue ? 1 : 0);
    }

    public final boolean isENABLEDALOGNull() {
        return this.IsParamNull(TAG_ENABLEDALOG);
    }

    public final boolean getENABLEDALOG() {
        return this.GetParamIntValue(TAG_ENABLEDALOG, 0) == 1;
    }

    public final void setENABLEDALOG(boolean bValue) {
        this.SetParamValue(TAG_ENABLEDALOG, bValue ? 1 : 0);
    }

    public final boolean isAUDITMODENull() {
        return this.IsParamNull(TAG_AUDITMODE);
    }

    public final int getAUDITMODE() {
        return this.GetParamIntValue(TAG_AUDITMODE, 0);
    }

    public final void setAUDITMODE(int nValue) {
        this.SetParamValue(TAG_AUDITMODE, nValue);
    }

    public final boolean isDATAACCMODENull() {
        return this.IsParamNull(TAG_DATAACCMODE);
    }

    public final int getDATAACCMODE() {
        return this.GetParamIntValue(TAG_DATAACCMODE, 0);
    }

    public final void setDATAACCMODE(int nValue) {
        this.SetParamValue(TAG_DATAACCMODE, nValue);
    }

    public final boolean isPSSYSIMAGEIDNull() {
        return this.IsParamNull(TAG_PSSYSIMAGEID);
    }

    public final String getPSSYSIMAGEID() {
        return this.GetParamStringValue(TAG_PSSYSIMAGEID, "");
    }

    public final void setPSSYSIMAGEID(String strValue) {
        this.SetParamValue(TAG_PSSYSIMAGEID, strValue);
    }

    public final boolean isPSSYSIMAGENAMENull() {
        return this.IsParamNull(TAG_PSSYSIMAGENAME);
    }

    public final String getPSSYSIMAGENAME() {
        return this.GetParamStringValue(TAG_PSSYSIMAGENAME, "");
    }

    public final void setPSSYSIMAGENAME(String strValue) {
        this.SetParamValue(TAG_PSSYSIMAGENAME, strValue);
    }

    public final boolean isDYNAMICMODENull() {
        return this.IsParamNull(TAG_DYNAMICMODE);
    }

    public final int getDYNAMICMODE() {
        return this.GetParamIntValue(TAG_DYNAMICMODE, 0);
    }

    public final void setDYNAMICMODE(int nValue) {
        this.SetParamValue(TAG_DYNAMICMODE, nValue);
    }

    public final boolean isSVRPUBMODENull() {
        return this.IsParamNull(TAG_SVRPUBMODE);
    }

    public final boolean getSVRPUBMODE() {
        return this.GetParamIntValue(TAG_SVRPUBMODE, 0) == 1;
    }

    public final void setSVRPUBMODE(boolean bValue) {
        this.SetParamValue(TAG_SVRPUBMODE, bValue ? 1 : 0);
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

    public final boolean isVALIDFLAGNull() {
        return this.IsParamNull(TAG_VALIDFLAG);
    }

    public final boolean getVALIDFLAG() {
        return this.GetParamIntValue(TAG_VALIDFLAG, 0) == 1;
    }

    public final void setVALIDFLAG(boolean bValue) {
        this.SetParamValue(TAG_VALIDFLAG, bValue ? 1 : 0);
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

    public final boolean isEXISTINGMODELNull() {
        return this.IsParamNull(TAG_EXISTINGMODEL);
    }

    public final boolean getEXISTINGMODEL() {
        return this.GetParamIntValue(TAG_EXISTINGMODEL, 0) == 1;
    }

    public final void setEXISTINGMODEL(boolean bValue) {
        this.SetParamValue(TAG_EXISTINGMODEL, bValue ? 1 : 0);
    }

    public final boolean isPSSYSREQITEMIDNull() {
        return this.IsParamNull(TAG_PSSYSREQITEMID);
    }

    public final String getPSSYSREQITEMID() {
        return this.GetParamStringValue(TAG_PSSYSREQITEMID, "");
    }

    public final void setPSSYSREQITEMID(String strValue) {
        this.SetParamValue(TAG_PSSYSREQITEMID, strValue);
    }

    public final boolean isPSSYSREQITEMNAMENull() {
        return this.IsParamNull(TAG_PSSYSREQITEMNAME);
    }

    public final String getPSSYSREQITEMNAME() {
        return this.GetParamStringValue(TAG_PSSYSREQITEMNAME, "");
    }

    public final void setPSSYSREQITEMNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSREQITEMNAME, strValue);
    }

    public final boolean isDATACHGLOGMODENull() {
        return this.IsParamNull(TAG_DATACHGLOGMODE);
    }

    public final int getDATACHGLOGMODE() {
        return this.GetParamIntValue(TAG_DATACHGLOGMODE, 0);
    }

    public final void setDATACHGLOGMODE(int nValue) {
        this.SetParamValue(TAG_DATACHGLOGMODE, nValue);
    }

    public final boolean isPSDETOOLBARSCNTNull() {
        return this.IsParamNull(TAG_PSDETOOLBARSCNT);
    }

    public final int getPSDETOOLBARSCNT() {
        return this.GetParamIntValue(TAG_PSDETOOLBARSCNT, 0);
    }

    public final void setPSDETOOLBARSCNT(int nValue) {
        this.SetParamValue(TAG_PSDETOOLBARSCNT, nValue);
    }

    public final boolean isSTORAGEMODENull() {
        return this.IsParamNull(TAG_STORAGEMODE);
    }

    public final int getSTORAGEMODE() {
        return this.GetParamIntValue(TAG_STORAGEMODE, 0);
    }

    public final void setSTORAGEMODE(int nValue) {
        this.SetParamValue(TAG_STORAGEMODE, nValue);
    }

    public final boolean isVIRTUALFLAGNull() {
        return this.IsParamNull(TAG_VIRTUALFLAG);
    }

    public final boolean getVIRTUALFLAG() {
        return this.GetParamIntValue(TAG_VIRTUALFLAG, 0) == 1;
    }

    public final void setVIRTUALFLAG(boolean bValue) {
        this.SetParamValue(TAG_VIRTUALFLAG, bValue ? 1 : 0);
    }

    public final boolean isNOVIEWMODENull() {
        return this.IsParamNull(TAG_NOVIEWMODE);
    }

    public final boolean getNOVIEWMODE() {
        return this.GetParamIntValue(TAG_NOVIEWMODE, 0) == 1;
    }

    public final void setNOVIEWMODE(boolean bValue) {
        this.SetParamValue(TAG_NOVIEWMODE, bValue ? 1 : 0);
    }

    public final boolean isLOGICVALIDVALUENull() {
        return this.IsParamNull(TAG_LOGICVALIDVALUE);
    }

    public final String getLOGICVALIDVALUE() {
        return this.GetParamStringValue(TAG_LOGICVALIDVALUE, "");
    }

    public final void setLOGICVALIDVALUE(String strValue) {
        this.SetParamValue(TAG_LOGICVALIDVALUE, strValue);
    }

    public final boolean isLOGICINVALIDVALUENull() {
        return this.IsParamNull(TAG_LOGICINVALIDVALUE);
    }

    public final String getLOGICINVALIDVALUE() {
        return this.GetParamStringValue(TAG_LOGICINVALIDVALUE, "");
    }

    public final void setLOGICINVALIDVALUE(String strValue) {
        this.SetParamValue(TAG_LOGICINVALIDVALUE, strValue);
    }

    public final boolean isLNPSLANRESIDNull() {
        return this.IsParamNull(TAG_LNPSLANRESID);
    }

    public final String getLNPSLANRESID() {
        return this.GetParamStringValue(TAG_LNPSLANRESID, "");
    }

    public final void setLNPSLANRESID(String strValue) {
        this.SetParamValue(TAG_LNPSLANRESID, strValue);
    }

    public final boolean isLNPSLANRESNAMENull() {
        return this.IsParamNull(TAG_LNPSLANRESNAME);
    }

    public final String getLNPSLANRESNAME() {
        return this.GetParamStringValue(TAG_LNPSLANRESNAME, "");
    }

    public final void setLNPSLANRESNAME(String strValue) {
        this.SetParamValue(TAG_LNPSLANRESNAME, strValue);
    }

    public final boolean isPSHELPMODULEIDNull() {
        return this.IsParamNull(TAG_PSHELPMODULEID);
    }

    public final String getPSHELPMODULEID() {
        return this.GetParamStringValue(TAG_PSHELPMODULEID, "");
    }

    public final void setPSHELPMODULEID(String strValue) {
        this.SetParamValue(TAG_PSHELPMODULEID, strValue);
    }

    public final boolean isPSHELPMODULENAMENull() {
        return this.IsParamNull(TAG_PSHELPMODULENAME);
    }

    public final String getPSHELPMODULENAME() {
        return this.GetParamStringValue(TAG_PSHELPMODULENAME, "");
    }

    public final void setPSHELPMODULENAME(String strValue) {
        this.SetParamValue(TAG_PSHELPMODULENAME, strValue);
    }

    public final boolean isUSERTAGNull() {
        return this.IsParamNull(TAG_USERTAG);
    }

    public final String getUSERTAG() {
        return this.GetParamStringValue(TAG_USERTAG, "");
    }

    public final void setUSERTAG(String strValue) {
        this.SetParamValue(TAG_USERTAG, strValue);
    }

    public final boolean isUSERTAG2Null() {
        return this.IsParamNull(TAG_USERTAG2);
    }

    public final String getUSERTAG2() {
        return this.GetParamStringValue(TAG_USERTAG2, "");
    }

    public final void setUSERTAG2(String strValue) {
        this.SetParamValue(TAG_USERTAG2, strValue);
    }

    public final boolean isVKEYSEPARATORNull() {
        return this.IsParamNull(TAG_VKEYSEPARATOR);
    }

    public final String getVKEYSEPARATOR() {
        return this.GetParamStringValue(TAG_VKEYSEPARATOR, "");
    }

    public final void setVKEYSEPARATOR(String strValue) {
        this.SetParamValue(TAG_VKEYSEPARATOR, strValue);
    }

    public final boolean isVIEWNAME2Null() {
        return this.IsParamNull(TAG_VIEWNAME2);
    }

    public final String getVIEWNAME2() {
        return this.GetParamStringValue(TAG_VIEWNAME2, "");
    }

    public final void setVIEWNAME2(String strValue) {
        this.SetParamValue(TAG_VIEWNAME2, strValue);
    }

    public final boolean isVIEWNAME3Null() {
        return this.IsParamNull(TAG_VIEWNAME3);
    }

    public final String getVIEWNAME3() {
        return this.GetParamStringValue(TAG_VIEWNAME3, "");
    }

    public final void setVIEWNAME3(String strValue) {
        this.SetParamValue(TAG_VIEWNAME3, strValue);
    }

    public final boolean isVIEWNAME4Null() {
        return this.IsParamNull(TAG_VIEWNAME4);
    }

    public final String getVIEWNAME4() {
        return this.GetParamStringValue(TAG_VIEWNAME4, "");
    }

    public final void setVIEWNAME4(String strValue) {
        this.SetParamValue(TAG_VIEWNAME4, strValue);
    }

    public final boolean isVIEWLEVELNull() {
        return this.IsParamNull(TAG_VIEWLEVEL);
    }

    public final int getVIEWLEVEL() {
        return this.GetParamIntValue(TAG_VIEWLEVEL, 0);
    }

    public final void setVIEWLEVEL(int nValue) {
        this.SetParamValue(TAG_VIEWLEVEL, nValue);
    }

    public final boolean isENABLEENTITYCACHENull() {
        return this.IsParamNull(TAG_ENABLEENTITYCACHE);
    }

    public final boolean getENABLEENTITYCACHE() {
        return this.GetParamIntValue(TAG_ENABLEENTITYCACHE, 0) == 1;
    }

    public final void setENABLEENTITYCACHE(boolean bValue) {
        this.SetParamValue(TAG_ENABLEENTITYCACHE, bValue ? 1 : 0);
    }

    public final boolean isMAXENTITYCACHECNTNull() {
        return this.IsParamNull(TAG_MAXENTITYCACHECNT);
    }

    public final int getMAXENTITYCACHECNT() {
        return this.GetParamIntValue(TAG_MAXENTITYCACHECNT, 0);
    }

    public final void setMAXENTITYCACHECNT(int nValue) {
        this.SetParamValue(TAG_MAXENTITYCACHECNT, nValue);
    }

    public final boolean isENTITYCACHETIMEOUTNull() {
        return this.IsParamNull(TAG_ENTITYCACHETIMEOUT);
    }

    public final int getENTITYCACHETIMEOUT() {
        return this.GetParamIntValue(TAG_ENTITYCACHETIMEOUT, 0);
    }

    public final void setENTITYCACHETIMEOUT(int nValue) {
        this.SetParamValue(TAG_ENTITYCACHETIMEOUT, nValue);
    }

    public final boolean isDATAIMPEXPFLAGNull() {
        return this.IsParamNull(TAG_DATAIMPEXPFLAG);
    }

    public final int getDATAIMPEXPFLAG() {
        return this.GetParamIntValue(TAG_DATAIMPEXPFLAG, 0);
    }

    public final void setDATAIMPEXPFLAG(int nValue) {
        this.SetParamValue(TAG_DATAIMPEXPFLAG, nValue);
    }

    public final boolean isMODELIMPEXPFLAGNull() {
        return this.IsParamNull(TAG_MODELIMPEXPFLAG);
    }

    public final int getMODELIMPEXPFLAG() {
        return this.GetParamIntValue(TAG_MODELIMPEXPFLAG, 0);
    }

    public final void setMODELIMPEXPFLAG(int nValue) {
        this.SetParamValue(TAG_MODELIMPEXPFLAG, nValue);
    }

    public final boolean isSERVICEAPIFLAGNull() {
        return this.IsParamNull(TAG_SERVICEAPIFLAG);
    }

    public final int getSERVICEAPIFLAG() {
        return this.GetParamIntValue(TAG_SERVICEAPIFLAG, 0);
    }

    public final void setSERVICEAPIFLAG(int nValue) {
        this.SetParamValue(TAG_SERVICEAPIFLAG, nValue);
    }

    public final boolean isPSSUBSYSSERVICEAPIIDNull() {
        return this.IsParamNull(TAG_PSSUBSYSSERVICEAPIID);
    }

    public final String getPSSUBSYSSERVICEAPIID() {
        return this.GetParamStringValue(TAG_PSSUBSYSSERVICEAPIID, "");
    }

    public final void setPSSUBSYSSERVICEAPIID(String strValue) {
        this.SetParamValue(TAG_PSSUBSYSSERVICEAPIID, strValue);
    }

    public final boolean isPSSUBSYSSERVICEAPINAMENull() {
        return this.IsParamNull(TAG_PSSUBSYSSERVICEAPINAME);
    }

    public final String getPSSUBSYSSERVICEAPINAME() {
        return this.GetParamStringValue(TAG_PSSUBSYSSERVICEAPINAME, "");
    }

    public final void setPSSUBSYSSERVICEAPINAME(String strValue) {
        this.SetParamValue(TAG_PSSUBSYSSERVICEAPINAME, strValue);
    }

    public final boolean isENABLESELECTNull() {
        return this.IsParamNull(TAG_ENABLESELECT);
    }

    public final boolean getENABLESELECT() {
        return this.GetParamIntValue(TAG_ENABLESELECT, 0) == 1;
    }

    public final void setENABLESELECT(boolean bValue) {
        this.SetParamValue(TAG_ENABLESELECT, bValue ? 1 : 0);
    }

    public final boolean isENABLEDEACTIONNull() {
        return this.IsParamNull(TAG_ENABLEDEACTION);
    }

    public final boolean getENABLEDEACTION() {
        return this.GetParamIntValue(TAG_ENABLEDEACTION, 0) == 1;
    }

    public final void setENABLEDEACTION(boolean bValue) {
        this.SetParamValue(TAG_ENABLEDEACTION, bValue ? 1 : 0);
    }

    public final boolean isENABLEDEDATASETNull() {
        return this.IsParamNull(TAG_ENABLEDEDATASET);
    }

    public final boolean getENABLEDEDATASET() {
        return this.GetParamIntValue(TAG_ENABLEDEDATASET, 0) == 1;
    }

    public final void setENABLEDEDATASET(boolean bValue) {
        this.SetParamValue(TAG_ENABLEDEDATASET, bValue ? 1 : 0);
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

    public final boolean isACCCTRLARCHNull() {
        return this.IsParamNull(TAG_ACCCTRLARCH);
    }

    public final int getACCCTRLARCH() {
        return this.GetParamIntValue(TAG_ACCCTRLARCH, 0);
    }

    public final void setACCCTRLARCH(int nValue) {
        this.SetParamValue(TAG_ACCCTRLARCH, nValue);
    }

    public final boolean isDYNAMODELFLAGNull() {
        return this.IsParamNull(TAG_DYNAMODELFLAG);
    }

    public final int getDYNAMODELFLAG() {
        return this.GetParamIntValue(TAG_DYNAMODELFLAG, 0);
    }

    public final void setDYNAMODELFLAG(int nValue) {
        this.SetParamValue(TAG_DYNAMODELFLAG, nValue);
    }

    public final boolean isPSDYNADETEMPLIDNull() {
        return this.IsParamNull(TAG_PSDYNADETEMPLID);
    }

    public final String getPSDYNADETEMPLID() {
        return this.GetParamStringValue(TAG_PSDYNADETEMPLID, "");
    }

    public final void setPSDYNADETEMPLID(String strValue) {
        this.SetParamValue(TAG_PSDYNADETEMPLID, strValue);
    }

    public final boolean isPSDYNADETEMPLNAMENull() {
        return this.IsParamNull(TAG_PSDYNADETEMPLNAME);
    }

    public final String getPSDYNADETEMPLNAME() {
        return this.GetParamStringValue(TAG_PSDYNADETEMPLNAME, "");
    }

    public final void setPSDYNADETEMPLNAME(String strValue) {
        this.SetParamValue(TAG_PSDYNADETEMPLNAME, strValue);
    }

    public final boolean isPSDYNAINSTIDNull() {
        return this.IsParamNull(TAG_PSDYNAINSTID);
    }

    public final String getPSDYNAINSTID() {
        return this.GetParamStringValue(TAG_PSDYNAINSTID, "");
    }

    public final void setPSDYNAINSTID(String strValue) {
        this.SetParamValue(TAG_PSDYNAINSTID, strValue);
    }

    public final boolean isPSSYSMODELGROUPIDNull() {
        return this.IsParamNull(TAG_PSSYSMODELGROUPID);
    }

    public final String getPSSYSMODELGROUPID() {
        return this.GetParamStringValue(TAG_PSSYSMODELGROUPID, "");
    }

    public final void setPSSYSMODELGROUPID(String strValue) {
        this.SetParamValue(TAG_PSSYSMODELGROUPID, strValue);
    }

    public final boolean isPSSYSMODELGROUPNAMENull() {
        return this.IsParamNull(TAG_PSSYSMODELGROUPNAME);
    }

    public final String getPSSYSMODELGROUPNAME() {
        return this.GetParamStringValue(TAG_PSSYSMODELGROUPNAME, "");
    }

    public final void setPSSYSMODELGROUPNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSMODELGROUPNAME, strValue);
    }

    public final boolean isSAASMODENull() {
        return this.IsParamNull(TAG_SAASMODE);
    }

    public final int getSAASMODE() {
        return this.GetParamIntValue(TAG_SAASMODE, 0);
    }

    public final void setSAASMODE(int nValue) {
        this.SetParamValue(TAG_SAASMODE, nValue);
    }

    public final boolean isUSERTAG3Null() {
        return this.IsParamNull(TAG_USERTAG3);
    }

    public final String getUSERTAG3() {
        return this.GetParamStringValue(TAG_USERTAG3, "");
    }

    public final void setUSERTAG3(String strValue) {
        this.SetParamValue(TAG_USERTAG3, strValue);
    }

    public final boolean isUSERTAG4Null() {
        return this.IsParamNull(TAG_USERTAG4);
    }

    public final String getUSERTAG4() {
        return this.GetParamStringValue(TAG_USERTAG4, "");
    }

    public final void setUSERTAG4(String strValue) {
        this.SetParamValue(TAG_USERTAG4, strValue);
    }

    public final boolean isUSERCATNull() {
        return this.IsParamNull(TAG_USERCAT);
    }

    public final String getUSERCAT() {
        return this.GetParamStringValue(TAG_USERCAT, "");
    }

    public final void setUSERCAT(String strValue) {
        this.SetParamValue(TAG_USERCAT, strValue);
    }

    public final boolean isENABLEDATAVERNull() {
        return this.IsParamNull(TAG_ENABLEDATAVER);
    }

    public final boolean getENABLEDATAVER() {
        return this.GetParamIntValue(TAG_ENABLEDATAVER, 0) == 1;
    }

    public final void setENABLEDATAVER(boolean bValue) {
        this.SetParamValue(TAG_ENABLEDATAVER, bValue ? 1 : 0);
    }

    public final boolean isPSSUBSYSSADEIDNull() {
        return this.IsParamNull(TAG_PSSUBSYSSADEID);
    }

    public final String getPSSUBSYSSADEID() {
        return this.GetParamStringValue(TAG_PSSUBSYSSADEID, "");
    }

    public final void setPSSUBSYSSADEID(String strValue) {
        this.SetParamValue(TAG_PSSUBSYSSADEID, strValue);
    }

    public final boolean isPSSUBSYSSADENAMENull() {
        return this.IsParamNull(TAG_PSSUBSYSSADENAME);
    }

    public final String getPSSUBSYSSADENAME() {
        return this.GetParamStringValue(TAG_PSSUBSYSSADENAME, "");
    }

    public final void setPSSUBSYSSADENAME(String strValue) {
        this.SetParamValue(TAG_PSSUBSYSSADENAME, strValue);
    }

    public final boolean isMSACTIONLOGICFLAGNull() {
        return this.IsParamNull(TAG_MSACTIONLOGICFLAG);
    }

    public final int getMSACTIONLOGICFLAG() {
        return this.GetParamIntValue(TAG_MSACTIONLOGICFLAG, 0);
    }

    public final void setMSACTIONLOGICFLAG(int nValue) {
        this.SetParamValue(TAG_MSACTIONLOGICFLAG, nValue);
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

    public final boolean isREADONLYMODENull() {
        return this.IsParamNull(TAG_READONLYMODE);
    }

    public final int getREADONLYMODE() {
        return this.GetParamIntValue(TAG_READONLYMODE, 0);
    }

    public final void setREADONLYMODE(int nValue) {
        this.SetParamValue(TAG_READONLYMODE, nValue);
    }

    public final boolean isENABLEDYNASYSNull() {
        return this.IsParamNull(TAG_ENABLEDYNASYS);
    }

    public final int getENABLEDYNASYS() {
        return this.GetParamIntValue(TAG_ENABLEDYNASYS, 0);
    }

    public final void setENABLEDYNASYS(int bValue) {
        this.SetParamValue(TAG_ENABLEDYNASYS, bValue);
    }

    public final boolean isBIZTAGNull() {
        return this.IsParamNull(TAG_BIZTAG);
    }

    public final String getBIZTAG() {
        return this.GetParamStringValue(TAG_BIZTAG, "");
    }

    public final void setBIZTAG(String strValue) {
        this.SetParamValue(TAG_BIZTAG, strValue);
    }

    public final boolean isDEHOLDERNull() {
        return this.IsParamNull(TAG_DEHOLDER);
    }

    public final int getDEHOLDER() {
        return this.GetParamIntValue(TAG_DEHOLDER, 0);
    }

    public final void setDEHOLDER(int nValue) {
        this.SetParamValue(TAG_DEHOLDER, nValue);
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

    public final boolean isDETAGNull() {
        return this.IsParamNull(TAG_DETAG);
    }

    public final String getDETAG() {
        return this.GetParamStringValue(TAG_DETAG, "");
    }

    public final void setDETAG(String strValue) {
        this.SetParamValue(TAG_DETAG, strValue);
    }

    public final boolean isDETAG2Null() {
        return this.IsParamNull(TAG_DETAG2);
    }

    public final String getDETAG2() {
        return this.GetParamStringValue(TAG_DETAG2, "");
    }

    public final void setDETAG2(String strValue) {
        this.SetParamValue(TAG_DETAG2, strValue);
    }

    public final boolean isCODENAMEMODENull() {
        return this.IsParamNull(TAG_CODENAMEMODE);
    }

    public final String getCODENAMEMODE() {
        return this.GetParamStringValue(TAG_CODENAMEMODE, "");
    }

    public final void setCODENAMEMODE(String strValue) {
        this.SetParamValue(TAG_CODENAMEMODE, strValue);
    }

    public final boolean isENABLEPQLNull() {
        return this.IsParamNull(TAG_ENABLEPQL);
    }

    public final boolean getENABLEPQL() {
        return this.GetParamIntValue(TAG_ENABLEPQL, 0) == 1;
    }

    public final void setENABLEPQL(boolean bValue) {
        this.SetParamValue(TAG_ENABLEPQL, bValue ? 1 : 0);
    }

    public final boolean isPSSYSUNIRESIDNull() {
        return this.IsParamNull(TAG_PSSYSUNIRESID);
    }

    public final String getPSSYSUNIRESID() {
        return this.GetParamStringValue(TAG_PSSYSUNIRESID, "");
    }

    public final void setPSSYSUNIRESID(String strValue) {
        this.SetParamValue(TAG_PSSYSUNIRESID, strValue);
    }

    public final boolean isPSSYSUNIRESNAMENull() {
        return this.IsParamNull(TAG_PSSYSUNIRESNAME);
    }

    public final String getPSSYSUNIRESNAME() {
        return this.GetParamStringValue(TAG_PSSYSUNIRESNAME, "");
    }

    public final void setPSSYSUNIRESNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSUNIRESNAME, strValue);
    }
}

