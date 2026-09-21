/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.entity;

import java.util.Date;
import net.ibizsys.model.entity.BaseDataEntity;

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

    public final boolean isPSDATAENTITYIDNull() {
        return this.isParamNull(TAG_PSDATAENTITYID);
    }

    public final String getPSDATAENTITYID() {
        return this.getParamStringValue(TAG_PSDATAENTITYID, "");
    }

    public final void setPSDATAENTITYID(String strValue) {
        this.setParamValue(TAG_PSDATAENTITYID, strValue);
    }

    public final boolean isPSDATAENTITYNAMENull() {
        return this.isParamNull(TAG_PSDATAENTITYNAME);
    }

    public final String getPSDATAENTITYNAME() {
        return this.getParamStringValue(TAG_PSDATAENTITYNAME, "");
    }

    public final void setPSDATAENTITYNAME(String strValue) {
        this.setParamValue(TAG_PSDATAENTITYNAME, strValue);
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

    public final boolean isPSSYSTEMIDNull() {
        return this.isParamNull(TAG_PSSYSTEMID);
    }

    public final String getPSSYSTEMID() {
        return this.getParamStringValue(TAG_PSSYSTEMID, "");
    }

    public final void setPSSYSTEMID(String strValue) {
        this.setParamValue(TAG_PSSYSTEMID, strValue);
    }

    public final boolean isPSSYSTEMNAMENull() {
        return this.isParamNull(TAG_PSSYSTEMNAME);
    }

    public final String getPSSYSTEMNAME() {
        return this.getParamStringValue(TAG_PSSYSTEMNAME, "");
    }

    public final void setPSSYSTEMNAME(String strValue) {
        this.setParamValue(TAG_PSSYSTEMNAME, strValue);
    }

    public final boolean isDESNNull() {
        return this.isParamNull(TAG_DESN);
    }

    public final String getDESN() {
        return this.getParamStringValue(TAG_DESN, "");
    }

    public final void setDESN(String strValue) {
        this.setParamValue(TAG_DESN, strValue);
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

    public final boolean isMEMONull() {
        return this.isParamNull(TAG_MEMO);
    }

    public final String getMEMO() {
        return this.getParamStringValue(TAG_MEMO, "");
    }

    public final void setMEMO(String strValue) {
        this.setParamValue(TAG_MEMO, strValue);
    }

    public final boolean isTABLENAMENull() {
        return this.isParamNull(TAG_TABLENAME);
    }

    public final String getTABLENAME() {
        return this.getParamStringValue(TAG_TABLENAME, "");
    }

    public final void setTABLENAME(String strValue) {
        this.setParamValue(TAG_TABLENAME, strValue);
    }

    public final boolean isVIEWNAMENull() {
        return this.isParamNull(TAG_VIEWNAME);
    }

    public final String getVIEWNAME() {
        return this.getParamStringValue(TAG_VIEWNAME, "");
    }

    public final void setVIEWNAME(String strValue) {
        this.setParamValue(TAG_VIEWNAME, strValue);
    }

    public final boolean isSYSTEMFLAGNull() {
        return this.isParamNull(TAG_SYSTEMFLAG);
    }

    public final boolean getSYSTEMFLAG() {
        return this.getParamIntValue(TAG_SYSTEMFLAG, 0) == 1;
    }

    public final void setSYSTEMFLAG(boolean bValue) {
        this.setParamValue(TAG_SYSTEMFLAG, bValue ? 1 : 0);
    }

    public final boolean isLOGICVALIDNull() {
        return this.isParamNull(TAG_LOGICVALID);
    }

    public final boolean getLOGICVALID() {
        return this.getParamIntValue(TAG_LOGICVALID, 0) == 1;
    }

    public final void setLOGICVALID(boolean bValue) {
        this.setParamValue(TAG_LOGICVALID, bValue ? 1 : 0);
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

    public final boolean isKEYRULENull() {
        return this.isParamNull(TAG_KEYRULE);
    }

    public final String getKEYRULE() {
        return this.getParamStringValue(TAG_KEYRULE, "");
    }

    public final void setKEYRULE(String strValue) {
        this.setParamValue(TAG_KEYRULE, strValue);
    }

    public final boolean isPSMODULEIDNull() {
        return this.isParamNull(TAG_PSMODULEID);
    }

    public final String getPSMODULEID() {
        return this.getParamStringValue(TAG_PSMODULEID, "");
    }

    public final void setPSMODULEID(String strValue) {
        this.setParamValue(TAG_PSMODULEID, strValue);
    }

    public final boolean isPSMODULENAMENull() {
        return this.isParamNull(TAG_PSMODULENAME);
    }

    public final String getPSMODULENAME() {
        return this.getParamStringValue(TAG_PSMODULENAME, "");
    }

    public final void setPSMODULENAME(String strValue) {
        this.setParamValue(TAG_PSMODULENAME, strValue);
    }

    public final boolean isINDEXDETYPENull() {
        return this.isParamNull(TAG_INDEXDETYPE);
    }

    public final String getINDEXDETYPE() {
        return this.getParamStringValue(TAG_INDEXDETYPE, "");
    }

    public final void setINDEXDETYPE(String strValue) {
        this.setParamValue(TAG_INDEXDETYPE, strValue);
    }

    public final boolean isENAMULTIFORMNull() {
        return this.isParamNull(TAG_ENAMULTIFORM);
    }

    public final boolean getENAMULTIFORM() {
        return this.getParamIntValue(TAG_ENAMULTIFORM, 0) == 1;
    }

    public final void setENAMULTIFORM(boolean bValue) {
        this.setParamValue(TAG_ENAMULTIFORM, bValue ? 1 : 0);
    }

    public final boolean isENATEMPDATANull() {
        return this.isParamNull(TAG_ENATEMPDATA);
    }

    public final boolean getENATEMPDATA() {
        return this.getParamIntValue(TAG_ENATEMPDATA, 0) == 1;
    }

    public final void setENATEMPDATA(boolean bValue) {
        this.setParamValue(TAG_ENATEMPDATA, bValue ? 1 : 0);
    }

    public final boolean isDETYPENull() {
        return this.isParamNull(TAG_DETYPE);
    }

    public final int getDETYPE() {
        return this.getParamIntValue(TAG_DETYPE, 0);
    }

    public final void setDETYPE(int nValue) {
        this.setParamValue(TAG_DETYPE, nValue);
    }

    public final boolean isUSERACTIONNull() {
        return this.isParamNull(TAG_USERACTION);
    }

    public final int getUSERACTION() {
        return this.getParamIntValue(TAG_USERACTION, 0);
    }

    public final void setUSERACTION(int nValue) {
        this.setParamValue(TAG_USERACTION, nValue);
    }

    public final boolean isMODELVERNull() {
        return this.isParamNull(TAG_MODELVER);
    }

    public final int getMODELVER() {
        return this.getParamIntValue(TAG_MODELVER, 0);
    }

    public final void setMODELVER(int nValue) {
        this.setParamValue(TAG_MODELVER, nValue);
    }

    public final boolean isDBVERNull() {
        return this.isParamNull(TAG_DBVER);
    }

    public final int getDBVER() {
        return this.getParamIntValue(TAG_DBVER, 0);
    }

    public final void setDBVER(int nValue) {
        this.setParamValue(TAG_DBVER, nValue);
    }

    public final boolean isDSLINKNull() {
        return this.isParamNull(TAG_DSLINK);
    }

    public final String getDSLINK() {
        return this.getParamStringValue(TAG_DSLINK, "");
    }

    public final void setDSLINK(String strValue) {
        this.setParamValue(TAG_DSLINK, strValue);
    }

    public final boolean isDBTABSPACENull() {
        return this.isParamNull(TAG_DBTABSPACE);
    }

    public final String getDBTABSPACE() {
        return this.getParamStringValue(TAG_DBTABSPACE, "");
    }

    public final void setDBTABSPACE(String strValue) {
        this.setParamValue(TAG_DBTABSPACE, strValue);
    }

    public final boolean isENABLEMULTIDSNull() {
        return this.isParamNull(TAG_ENABLEMULTIDS);
    }

    public final boolean getENABLEMULTIDS() {
        return this.getParamIntValue(TAG_ENABLEMULTIDS, 0) == 1;
    }

    public final void setENABLEMULTIDS(boolean bValue) {
        this.setParamValue(TAG_ENABLEMULTIDS, bValue ? 1 : 0);
    }

    public final boolean isEXTABLENAMENull() {
        return this.isParamNull(TAG_EXTABLENAME);
    }

    public final String getEXTABLENAME() {
        return this.getParamStringValue(TAG_EXTABLENAME, "");
    }

    public final void setEXTABLENAME(String strValue) {
        this.setParamValue(TAG_EXTABLENAME, strValue);
    }

    public final boolean isENABLEORGMODELNull() {
        return this.isParamNull(TAG_ENABLEORGMODEL);
    }

    public final boolean getENABLEORGMODEL() {
        return this.getParamIntValue(TAG_ENABLEORGMODEL, 0) == 1;
    }

    public final void setENABLEORGMODEL(boolean bValue) {
        this.setParamValue(TAG_ENABLEORGMODEL, bValue ? 1 : 0);
    }

    public final boolean isENABLEAUDITNull() {
        return this.isParamNull(TAG_ENABLEAUDIT);
    }

    public final boolean getENABLEAUDIT() {
        return this.getParamIntValue(TAG_ENABLEAUDIT, 0) == 1;
    }

    public final void setENABLEAUDIT(boolean bValue) {
        this.setParamValue(TAG_ENABLEAUDIT, bValue ? 1 : 0);
    }

    public final boolean isBASECLSPARAMSNull() {
        return this.isParamNull(TAG_BASECLSPARAMS);
    }

    public final String getBASECLSPARAMS() {
        return this.getParamStringValue(TAG_BASECLSPARAMS, "");
    }

    public final void setBASECLSPARAMS(String strValue) {
        this.setParamValue(TAG_BASECLSPARAMS, strValue);
    }

    public final boolean isSUBSYSDENull() {
        return this.isParamNull(TAG_SUBSYSDE);
    }

    public final boolean getSUBSYSDE() {
        return this.getParamIntValue(TAG_SUBSYSDE, 0) == 1;
    }

    public final void setSUBSYSDE(boolean bValue) {
        this.setParamValue(TAG_SUBSYSDE, bValue ? 1 : 0);
    }

    public final boolean isENABLEDALOGNull() {
        return this.isParamNull(TAG_ENABLEDALOG);
    }

    public final boolean getENABLEDALOG() {
        return this.getParamIntValue(TAG_ENABLEDALOG, 0) == 1;
    }

    public final void setENABLEDALOG(boolean bValue) {
        this.setParamValue(TAG_ENABLEDALOG, bValue ? 1 : 0);
    }

    public final boolean isAUDITMODENull() {
        return this.isParamNull(TAG_AUDITMODE);
    }

    public final int getAUDITMODE() {
        return this.getParamIntValue(TAG_AUDITMODE, 0);
    }

    public final void setAUDITMODE(int nValue) {
        this.setParamValue(TAG_AUDITMODE, nValue);
    }

    public final boolean isDATAACCMODENull() {
        return this.isParamNull(TAG_DATAACCMODE);
    }

    public final int getDATAACCMODE() {
        return this.getParamIntValue(TAG_DATAACCMODE, 0);
    }

    public final void setDATAACCMODE(int nValue) {
        this.setParamValue(TAG_DATAACCMODE, nValue);
    }

    public final boolean isPSSYSIMAGEIDNull() {
        return this.isParamNull(TAG_PSSYSIMAGEID);
    }

    public final String getPSSYSIMAGEID() {
        return this.getParamStringValue(TAG_PSSYSIMAGEID, "");
    }

    public final void setPSSYSIMAGEID(String strValue) {
        this.setParamValue(TAG_PSSYSIMAGEID, strValue);
    }

    public final boolean isPSSYSIMAGENAMENull() {
        return this.isParamNull(TAG_PSSYSIMAGENAME);
    }

    public final String getPSSYSIMAGENAME() {
        return this.getParamStringValue(TAG_PSSYSIMAGENAME, "");
    }

    public final void setPSSYSIMAGENAME(String strValue) {
        this.setParamValue(TAG_PSSYSIMAGENAME, strValue);
    }

    public final boolean isDYNAMICMODENull() {
        return this.isParamNull(TAG_DYNAMICMODE);
    }

    public final int getDYNAMICMODE() {
        return this.getParamIntValue(TAG_DYNAMICMODE, 0);
    }

    public final void setDYNAMICMODE(int nValue) {
        this.setParamValue(TAG_DYNAMICMODE, nValue);
    }

    public final boolean isSVRPUBMODENull() {
        return this.isParamNull(TAG_SVRPUBMODE);
    }

    public final boolean getSVRPUBMODE() {
        return this.getParamIntValue(TAG_SVRPUBMODE, 0) == 1;
    }

    public final void setSVRPUBMODE(boolean bValue) {
        this.setParamValue(TAG_SVRPUBMODE, bValue ? 1 : 0);
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

    public final boolean isVALIDFLAGNull() {
        return this.isParamNull(TAG_VALIDFLAG);
    }

    public final boolean getVALIDFLAG() {
        return this.getParamIntValue(TAG_VALIDFLAG, 0) == 1;
    }

    public final void setVALIDFLAG(boolean bValue) {
        this.setParamValue(TAG_VALIDFLAG, bValue ? 1 : 0);
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

    public final boolean isEXISTINGMODELNull() {
        return this.isParamNull(TAG_EXISTINGMODEL);
    }

    public final boolean getEXISTINGMODEL() {
        return this.getParamIntValue(TAG_EXISTINGMODEL, 0) == 1;
    }

    public final void setEXISTINGMODEL(boolean bValue) {
        this.setParamValue(TAG_EXISTINGMODEL, bValue ? 1 : 0);
    }

    public final boolean isPSSYSREQITEMIDNull() {
        return this.isParamNull(TAG_PSSYSREQITEMID);
    }

    public final String getPSSYSREQITEMID() {
        return this.getParamStringValue(TAG_PSSYSREQITEMID, "");
    }

    public final void setPSSYSREQITEMID(String strValue) {
        this.setParamValue(TAG_PSSYSREQITEMID, strValue);
    }

    public final boolean isPSSYSREQITEMNAMENull() {
        return this.isParamNull(TAG_PSSYSREQITEMNAME);
    }

    public final String getPSSYSREQITEMNAME() {
        return this.getParamStringValue(TAG_PSSYSREQITEMNAME, "");
    }

    public final void setPSSYSREQITEMNAME(String strValue) {
        this.setParamValue(TAG_PSSYSREQITEMNAME, strValue);
    }

    public final boolean isDATACHGLOGMODENull() {
        return this.isParamNull(TAG_DATACHGLOGMODE);
    }

    public final int getDATACHGLOGMODE() {
        return this.getParamIntValue(TAG_DATACHGLOGMODE, 0);
    }

    public final void setDATACHGLOGMODE(int nValue) {
        this.setParamValue(TAG_DATACHGLOGMODE, nValue);
    }

    public final boolean isPSDETOOLBARSCNTNull() {
        return this.isParamNull(TAG_PSDETOOLBARSCNT);
    }

    public final int getPSDETOOLBARSCNT() {
        return this.getParamIntValue(TAG_PSDETOOLBARSCNT, 0);
    }

    public final void setPSDETOOLBARSCNT(int nValue) {
        this.setParamValue(TAG_PSDETOOLBARSCNT, nValue);
    }

    public final boolean isSTORAGEMODENull() {
        return this.isParamNull(TAG_STORAGEMODE);
    }

    public final int getSTORAGEMODE() {
        return this.getParamIntValue(TAG_STORAGEMODE, 0);
    }

    public final void setSTORAGEMODE(int nValue) {
        this.setParamValue(TAG_STORAGEMODE, nValue);
    }

    public final boolean isVIRTUALFLAGNull() {
        return this.isParamNull(TAG_VIRTUALFLAG);
    }

    public final boolean getVIRTUALFLAG() {
        return this.getParamIntValue(TAG_VIRTUALFLAG, 0) == 1;
    }

    public final void setVIRTUALFLAG(boolean bValue) {
        this.setParamValue(TAG_VIRTUALFLAG, bValue ? 1 : 0);
    }

    public final boolean isNOVIEWMODENull() {
        return this.isParamNull(TAG_NOVIEWMODE);
    }

    public final boolean getNOVIEWMODE() {
        return this.getParamIntValue(TAG_NOVIEWMODE, 0) == 1;
    }

    public final void setNOVIEWMODE(boolean bValue) {
        this.setParamValue(TAG_NOVIEWMODE, bValue ? 1 : 0);
    }

    public final boolean isLOGICVALIDVALUENull() {
        return this.isParamNull(TAG_LOGICVALIDVALUE);
    }

    public final String getLOGICVALIDVALUE() {
        return this.getParamStringValue(TAG_LOGICVALIDVALUE, "");
    }

    public final void setLOGICVALIDVALUE(String strValue) {
        this.setParamValue(TAG_LOGICVALIDVALUE, strValue);
    }

    public final boolean isLOGICINVALIDVALUENull() {
        return this.isParamNull(TAG_LOGICINVALIDVALUE);
    }

    public final String getLOGICINVALIDVALUE() {
        return this.getParamStringValue(TAG_LOGICINVALIDVALUE, "");
    }

    public final void setLOGICINVALIDVALUE(String strValue) {
        this.setParamValue(TAG_LOGICINVALIDVALUE, strValue);
    }

    public final boolean isLNPSLANRESIDNull() {
        return this.isParamNull(TAG_LNPSLANRESID);
    }

    public final String getLNPSLANRESID() {
        return this.getParamStringValue(TAG_LNPSLANRESID, "");
    }

    public final void setLNPSLANRESID(String strValue) {
        this.setParamValue(TAG_LNPSLANRESID, strValue);
    }

    public final boolean isLNPSLANRESNAMENull() {
        return this.isParamNull(TAG_LNPSLANRESNAME);
    }

    public final String getLNPSLANRESNAME() {
        return this.getParamStringValue(TAG_LNPSLANRESNAME, "");
    }

    public final void setLNPSLANRESNAME(String strValue) {
        this.setParamValue(TAG_LNPSLANRESNAME, strValue);
    }

    public final boolean isPSHELPMODULEIDNull() {
        return this.isParamNull(TAG_PSHELPMODULEID);
    }

    public final String getPSHELPMODULEID() {
        return this.getParamStringValue(TAG_PSHELPMODULEID, "");
    }

    public final void setPSHELPMODULEID(String strValue) {
        this.setParamValue(TAG_PSHELPMODULEID, strValue);
    }

    public final boolean isPSHELPMODULENAMENull() {
        return this.isParamNull(TAG_PSHELPMODULENAME);
    }

    public final String getPSHELPMODULENAME() {
        return this.getParamStringValue(TAG_PSHELPMODULENAME, "");
    }

    public final void setPSHELPMODULENAME(String strValue) {
        this.setParamValue(TAG_PSHELPMODULENAME, strValue);
    }

    public final boolean isUSERTAGNull() {
        return this.isParamNull(TAG_USERTAG);
    }

    public final String getUSERTAG() {
        return this.getParamStringValue(TAG_USERTAG, "");
    }

    public final void setUSERTAG(String strValue) {
        this.setParamValue(TAG_USERTAG, strValue);
    }

    public final boolean isUSERTAG2Null() {
        return this.isParamNull(TAG_USERTAG2);
    }

    public final String getUSERTAG2() {
        return this.getParamStringValue(TAG_USERTAG2, "");
    }

    public final void setUSERTAG2(String strValue) {
        this.setParamValue(TAG_USERTAG2, strValue);
    }

    public final boolean isVKEYSEPARATORNull() {
        return this.isParamNull(TAG_VKEYSEPARATOR);
    }

    public final String getVKEYSEPARATOR() {
        return this.getParamStringValue(TAG_VKEYSEPARATOR, "");
    }

    public final void setVKEYSEPARATOR(String strValue) {
        this.setParamValue(TAG_VKEYSEPARATOR, strValue);
    }

    public final boolean isVIEWNAME2Null() {
        return this.isParamNull(TAG_VIEWNAME2);
    }

    public final String getVIEWNAME2() {
        return this.getParamStringValue(TAG_VIEWNAME2, "");
    }

    public final void setVIEWNAME2(String strValue) {
        this.setParamValue(TAG_VIEWNAME2, strValue);
    }

    public final boolean isVIEWNAME3Null() {
        return this.isParamNull(TAG_VIEWNAME3);
    }

    public final String getVIEWNAME3() {
        return this.getParamStringValue(TAG_VIEWNAME3, "");
    }

    public final void setVIEWNAME3(String strValue) {
        this.setParamValue(TAG_VIEWNAME3, strValue);
    }

    public final boolean isVIEWNAME4Null() {
        return this.isParamNull(TAG_VIEWNAME4);
    }

    public final String getVIEWNAME4() {
        return this.getParamStringValue(TAG_VIEWNAME4, "");
    }

    public final void setVIEWNAME4(String strValue) {
        this.setParamValue(TAG_VIEWNAME4, strValue);
    }

    public final boolean isVIEWLEVELNull() {
        return this.isParamNull(TAG_VIEWLEVEL);
    }

    public final int getVIEWLEVEL() {
        return this.getParamIntValue(TAG_VIEWLEVEL, 0);
    }

    public final void setVIEWLEVEL(int nValue) {
        this.setParamValue(TAG_VIEWLEVEL, nValue);
    }

    public final boolean isENABLEENTITYCACHENull() {
        return this.isParamNull(TAG_ENABLEENTITYCACHE);
    }

    public final boolean getENABLEENTITYCACHE() {
        return this.getParamIntValue(TAG_ENABLEENTITYCACHE, 0) == 1;
    }

    public final void setENABLEENTITYCACHE(boolean bValue) {
        this.setParamValue(TAG_ENABLEENTITYCACHE, bValue ? 1 : 0);
    }

    public final boolean isMAXENTITYCACHECNTNull() {
        return this.isParamNull(TAG_MAXENTITYCACHECNT);
    }

    public final int getMAXENTITYCACHECNT() {
        return this.getParamIntValue(TAG_MAXENTITYCACHECNT, 0);
    }

    public final void setMAXENTITYCACHECNT(int nValue) {
        this.setParamValue(TAG_MAXENTITYCACHECNT, nValue);
    }

    public final boolean isENTITYCACHETIMEOUTNull() {
        return this.isParamNull(TAG_ENTITYCACHETIMEOUT);
    }

    public final int getENTITYCACHETIMEOUT() {
        return this.getParamIntValue(TAG_ENTITYCACHETIMEOUT, 0);
    }

    public final void setENTITYCACHETIMEOUT(int nValue) {
        this.setParamValue(TAG_ENTITYCACHETIMEOUT, nValue);
    }

    public final boolean isDATAIMPEXPFLAGNull() {
        return this.isParamNull(TAG_DATAIMPEXPFLAG);
    }

    public final int getDATAIMPEXPFLAG() {
        return this.getParamIntValue(TAG_DATAIMPEXPFLAG, 0);
    }

    public final void setDATAIMPEXPFLAG(int nValue) {
        this.setParamValue(TAG_DATAIMPEXPFLAG, nValue);
    }

    public final boolean isMODELIMPEXPFLAGNull() {
        return this.isParamNull(TAG_MODELIMPEXPFLAG);
    }

    public final int getMODELIMPEXPFLAG() {
        return this.getParamIntValue(TAG_MODELIMPEXPFLAG, 0);
    }

    public final void setMODELIMPEXPFLAG(int nValue) {
        this.setParamValue(TAG_MODELIMPEXPFLAG, nValue);
    }

    public final boolean isSERVICEAPIFLAGNull() {
        return this.isParamNull(TAG_SERVICEAPIFLAG);
    }

    public final int getSERVICEAPIFLAG() {
        return this.getParamIntValue(TAG_SERVICEAPIFLAG, 0);
    }

    public final void setSERVICEAPIFLAG(int nValue) {
        this.setParamValue(TAG_SERVICEAPIFLAG, nValue);
    }

    public final boolean isPSSUBSYSSERVICEAPIIDNull() {
        return this.isParamNull(TAG_PSSUBSYSSERVICEAPIID);
    }

    public final String getPSSUBSYSSERVICEAPIID() {
        return this.getParamStringValue(TAG_PSSUBSYSSERVICEAPIID, "");
    }

    public final void setPSSUBSYSSERVICEAPIID(String strValue) {
        this.setParamValue(TAG_PSSUBSYSSERVICEAPIID, strValue);
    }

    public final boolean isPSSUBSYSSERVICEAPINAMENull() {
        return this.isParamNull(TAG_PSSUBSYSSERVICEAPINAME);
    }

    public final String getPSSUBSYSSERVICEAPINAME() {
        return this.getParamStringValue(TAG_PSSUBSYSSERVICEAPINAME, "");
    }

    public final void setPSSUBSYSSERVICEAPINAME(String strValue) {
        this.setParamValue(TAG_PSSUBSYSSERVICEAPINAME, strValue);
    }

    public final boolean isENABLESELECTNull() {
        return this.isParamNull(TAG_ENABLESELECT);
    }

    public final boolean getENABLESELECT() {
        return this.getParamIntValue(TAG_ENABLESELECT, 0) == 1;
    }

    public final void setENABLESELECT(boolean bValue) {
        this.setParamValue(TAG_ENABLESELECT, bValue ? 1 : 0);
    }

    public final boolean isENABLEDEACTIONNull() {
        return this.isParamNull(TAG_ENABLEDEACTION);
    }

    public final boolean getENABLEDEACTION() {
        return this.getParamIntValue(TAG_ENABLEDEACTION, 0) == 1;
    }

    public final void setENABLEDEACTION(boolean bValue) {
        this.setParamValue(TAG_ENABLEDEACTION, bValue ? 1 : 0);
    }

    public final boolean isENABLEDEDATASETNull() {
        return this.isParamNull(TAG_ENABLEDEDATASET);
    }

    public final boolean getENABLEDEDATASET() {
        return this.getParamIntValue(TAG_ENABLEDEDATASET, 0) == 1;
    }

    public final void setENABLEDEDATASET(boolean bValue) {
        this.setParamValue(TAG_ENABLEDEDATASET, bValue ? 1 : 0);
    }

    public final boolean isSERVICECODENAMENull() {
        return this.isParamNull(TAG_SERVICECODENAME);
    }

    public final String getSERVICECODENAME() {
        return this.getParamStringValue(TAG_SERVICECODENAME, "");
    }

    public final void setSERVICECODENAME(String strValue) {
        this.setParamValue(TAG_SERVICECODENAME, strValue);
    }

    public final boolean isACCCTRLARCHNull() {
        return this.isParamNull(TAG_ACCCTRLARCH);
    }

    public final int getACCCTRLARCH() {
        return this.getParamIntValue(TAG_ACCCTRLARCH, 0);
    }

    public final void setACCCTRLARCH(int nValue) {
        this.setParamValue(TAG_ACCCTRLARCH, nValue);
    }

    public final boolean isDYNAMODELFLAGNull() {
        return this.isParamNull(TAG_DYNAMODELFLAG);
    }

    public final int getDYNAMODELFLAG() {
        return this.getParamIntValue(TAG_DYNAMODELFLAG, 0);
    }

    public final void setDYNAMODELFLAG(int nValue) {
        this.setParamValue(TAG_DYNAMODELFLAG, nValue);
    }

    public final boolean isPSDYNADETEMPLIDNull() {
        return this.isParamNull(TAG_PSDYNADETEMPLID);
    }

    public final String getPSDYNADETEMPLID() {
        return this.getParamStringValue(TAG_PSDYNADETEMPLID, "");
    }

    public final void setPSDYNADETEMPLID(String strValue) {
        this.setParamValue(TAG_PSDYNADETEMPLID, strValue);
    }

    public final boolean isPSDYNADETEMPLNAMENull() {
        return this.isParamNull(TAG_PSDYNADETEMPLNAME);
    }

    public final String getPSDYNADETEMPLNAME() {
        return this.getParamStringValue(TAG_PSDYNADETEMPLNAME, "");
    }

    public final void setPSDYNADETEMPLNAME(String strValue) {
        this.setParamValue(TAG_PSDYNADETEMPLNAME, strValue);
    }

    public final boolean isPSDYNAINSTIDNull() {
        return this.isParamNull(TAG_PSDYNAINSTID);
    }

    public final String getPSDYNAINSTID() {
        return this.getParamStringValue(TAG_PSDYNAINSTID, "");
    }

    public final void setPSDYNAINSTID(String strValue) {
        this.setParamValue(TAG_PSDYNAINSTID, strValue);
    }

    public final boolean isPSSYSMODELGROUPIDNull() {
        return this.isParamNull(TAG_PSSYSMODELGROUPID);
    }

    public final String getPSSYSMODELGROUPID() {
        return this.getParamStringValue(TAG_PSSYSMODELGROUPID, "");
    }

    public final void setPSSYSMODELGROUPID(String strValue) {
        this.setParamValue(TAG_PSSYSMODELGROUPID, strValue);
    }

    public final boolean isPSSYSMODELGROUPNAMENull() {
        return this.isParamNull(TAG_PSSYSMODELGROUPNAME);
    }

    public final String getPSSYSMODELGROUPNAME() {
        return this.getParamStringValue(TAG_PSSYSMODELGROUPNAME, "");
    }

    public final void setPSSYSMODELGROUPNAME(String strValue) {
        this.setParamValue(TAG_PSSYSMODELGROUPNAME, strValue);
    }
}

