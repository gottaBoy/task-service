/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.entity;

import java.util.Date;
import net.ibizsys.model.entity.BaseDataEntity;

public class PSSystem
extends BaseDataEntity {
    public static final int ACCCTRLARCH_RTSYSROLE = 1;
    public static final int ACCCTRLARCH_SYSROLEANDDEROLE = 2;
    public static final String DBTYPES_MYSQL5 = "MYSQL5";
    public static final String DEFSORTMODE_NAME = "NAME";
    public static final String DEFSORTMODE_CREATEDATE = "CREATEDATE";
    public static final int VIEWUAREGMODE_ALWAYS = 0;
    public static final int VIEWUAREGMODE_VALID = 1;
    public static final int BUGFIXS_GRIDDATAITEMNAME = 1;
    public static final String TAG_PSSYSTEMID = "PSSYSTEMID";
    public static final String TAG_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSDEVSLNID = "PSDEVSLNID";
    public static final String TAG_PSDEVSLNNAME = "PSDEVSLNNAME";
    public static final String TAG_DBVERSION = "DBVERSION";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_DBTYPES = "DBTYPES";
    public static final String TAG_DEFPSSYSDEPLOYID = "DEFPSSYSDEPLOYID";
    public static final String TAG_PSSFID = "PSSFID";
    public static final String TAG_PSSFNAME = "PSSFNAME";
    public static final String TAG_LOGICNAME = "LOGICNAME";
    public static final String TAG_SYSFOLDER = "SYSFOLDER";
    public static final String TAG_PSDEVCENTERID = "PSDEVCENTERID";
    public static final String TAG_PSDEVCENTERNAME = "PSDEVCENTERNAME";
    public static final String TAG_CODENAME = "CODENAME";
    public static final String TAG_SYSVER = "SYSVER";
    public static final String TAG_SRCPSSYSTEMID = "SRCPSSYSTEMID";
    public static final String TAG_SRCPSSYSTEMNAME = "SRCPSSYSTEMNAME";
    public static final String TAG_PSDEVSLNSYSID = "PSDEVSLNSYSID";
    public static final String TAG_MODELVER = "MODELVER";
    public static final String TAG_DOMAINNAME = "DOMAINNAME";
    public static final String TAG_DEFSORTMODE = "DEFSORTMODE";
    public static final String TAG_LANRESMAXTAG = "LANRESMAXTAG";
    public static final String TAG_PSLANGUAGEID = "PSLANGUAGEID";
    public static final String TAG_PSLANGUAGENAME = "PSLANGUAGENAME";
    public static final String TAG_ENABLEMULTILAN = "ENABLEMULTILAN";
    public static final String TAG_CLEMPTYTEXT = "CLEMPTYTEXT";
    public static final String TAG_CLEMPTYTEXTPSLANRESID = "CLEMPTYTEXTPSLANRESID";
    public static final String TAG_CLEMPTYTEXTPSLANRESNAME = "CLEMPTYTEXTPSLANRESNAME";
    public static final String TAG_PSSYSENGINECFGID = "PSSYSENGINECFGID";
    public static final String TAG_PSSYSENGINECFGNAME = "PSSYSENGINECFGNAME";
    public static final String TAG_DEEXPMAXROWCNT = "DEEXPMAXROWCNT";
    public static final String TAG_VIEWUAREGMODE = "VIEWUAREGMODE";
    public static final String TAG_CHECKMODELVER = "CHECKMODELVER";
    public static final String TAG_NOVIEWMODE = "NOVIEWMODE";
    public static final String TAG_SERVICEAPIFLAG = "SERVICEAPIFLAG";
    public static final String TAG_ACCCTRLARCH = "ACCCTRLARCH";
    public static final String TAG_BUGFIXS = "BUGFIXS";
    public static final String TAG_DEFSFITEMWIDTH = "DEFSFITEMWIDTH";
    public static final String TAG_PUBDBMODELFLAG = "PUBDBMODELFLAG";
    public static final String TAG_ENABLEOPNAMEMODEL = "ENABLEOPNAMEMODEL";
    public static final String TAG_ENABLEDBVALUEMODE = "ENABLEDBVALUEMODE";
    public static final String TAG_ENABLEDYNASYS = "ENABLEDYNASYS";

    public final boolean isLOGICNAMENull() {
        return this.isParamNull(TAG_LOGICNAME);
    }

    public final String getLOGICNAME() {
        return this.getParamStringValue(TAG_LOGICNAME, "");
    }

    public final void setLOGICNAME(String strValue) {
        this.setParamValue(TAG_LOGICNAME, strValue);
    }

    public final boolean isSYSFOLDERNull() {
        return this.isParamNull(TAG_SYSFOLDER);
    }

    public final String getSYSFOLDER() {
        return this.getParamStringValue(TAG_SYSFOLDER, "");
    }

    public final void setSYSFOLDER(String strValue) {
        this.setParamValue(TAG_SYSFOLDER, strValue);
    }

    public final boolean isPSDEVCENTERIDNull() {
        return this.isParamNull(TAG_PSDEVCENTERID);
    }

    public final String getPSDEVCENTERID() {
        return this.getParamStringValue(TAG_PSDEVCENTERID, "");
    }

    public final void setPSDEVCENTERID(String strValue) {
        this.setParamValue(TAG_PSDEVCENTERID, strValue);
    }

    public final boolean isPSDEVCENTERNAMENull() {
        return this.isParamNull(TAG_PSDEVCENTERNAME);
    }

    public final String getPSDEVCENTERNAME() {
        return this.getParamStringValue(TAG_PSDEVCENTERNAME, "");
    }

    public final void setPSDEVCENTERNAME(String strValue) {
        this.setParamValue(TAG_PSDEVCENTERNAME, strValue);
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

    public final boolean isSYSVERNull() {
        return this.isParamNull(TAG_SYSVER);
    }

    public final String getSYSVER() {
        return this.getParamStringValue(TAG_SYSVER, "");
    }

    public final void setSYSVER(String strValue) {
        this.setParamValue(TAG_SYSVER, strValue);
    }

    public final boolean isSRCPSSYSTEMIDNull() {
        return this.isParamNull(TAG_SRCPSSYSTEMID);
    }

    public final String getSRCPSSYSTEMID() {
        return this.getParamStringValue(TAG_SRCPSSYSTEMID, "");
    }

    public final void setSRCPSSYSTEMID(String strValue) {
        this.setParamValue(TAG_SRCPSSYSTEMID, strValue);
    }

    public final boolean isSRCPSSYSTEMNAMENull() {
        return this.isParamNull(TAG_SRCPSSYSTEMNAME);
    }

    public final String getSRCPSSYSTEMNAME() {
        return this.getParamStringValue(TAG_SRCPSSYSTEMNAME, "");
    }

    public final void setSRCPSSYSTEMNAME(String strValue) {
        this.setParamValue(TAG_SRCPSSYSTEMNAME, strValue);
    }

    public final boolean isPSDEVSLNSYSIDNull() {
        return this.isParamNull(TAG_PSDEVSLNSYSID);
    }

    public final String getPSDEVSLNSYSID() {
        return this.getParamStringValue(TAG_PSDEVSLNSYSID, "");
    }

    public final void setPSDEVSLNSYSID(String strValue) {
        this.setParamValue(TAG_PSDEVSLNSYSID, strValue);
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
        return this.isParamNull("CREATEDATE");
    }

    public final Date getCREATEDATE() {
        return this.getParamDateValue("CREATEDATE", null);
    }

    public final void setCREATEDATE(Date dtValue) {
        this.setParamValue("CREATEDATE", dtValue);
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

    public final boolean isPSDEVSLNIDNull() {
        return this.isParamNull(TAG_PSDEVSLNID);
    }

    public final String getPSDEVSLNID() {
        return this.getParamStringValue(TAG_PSDEVSLNID, "");
    }

    public final void setPSDEVSLNID(String strValue) {
        this.setParamValue(TAG_PSDEVSLNID, strValue);
    }

    public final boolean isPSDEVSLNNAMENull() {
        return this.isParamNull(TAG_PSDEVSLNNAME);
    }

    public final String getPSDEVSLNNAME() {
        return this.getParamStringValue(TAG_PSDEVSLNNAME, "");
    }

    public final void setPSDEVSLNNAME(String strValue) {
        this.setParamValue(TAG_PSDEVSLNNAME, strValue);
    }

    public final boolean isDBVERSIONNull() {
        return this.isParamNull(TAG_DBVERSION);
    }

    public final int getDBVERSION() {
        return this.getParamIntValue(TAG_DBVERSION, 0);
    }

    public final void setDBVERSION(int nValue) {
        this.setParamValue(TAG_DBVERSION, nValue);
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

    public final boolean isDBTYPESNull() {
        return this.isParamNull(TAG_DBTYPES);
    }

    public final String getDBTYPES() {
        return this.getParamStringValue(TAG_DBTYPES, "");
    }

    public final void setDBTYPES(String strValue) {
        this.setParamValue(TAG_DBTYPES, strValue);
    }

    public final boolean isDEFPSSYSDEPLOYIDNull() {
        return this.isParamNull(TAG_DEFPSSYSDEPLOYID);
    }

    public final String getDEFPSSYSDEPLOYID() {
        return this.getParamStringValue(TAG_DEFPSSYSDEPLOYID, "");
    }

    public final void setDEFPSSYSDEPLOYID(String strValue) {
        this.setParamValue(TAG_DEFPSSYSDEPLOYID, strValue);
    }

    public final boolean isPSSFIDNull() {
        return this.isParamNull(TAG_PSSFID);
    }

    public final String getPSSFID() {
        return this.getParamStringValue(TAG_PSSFID, "");
    }

    public final void setPSSFID(String strValue) {
        this.setParamValue(TAG_PSSFID, strValue);
    }

    public final boolean isPSSFNAMENull() {
        return this.isParamNull(TAG_PSSFNAME);
    }

    public final String getPSSFNAME() {
        return this.getParamStringValue(TAG_PSSFNAME, "");
    }

    public final void setPSSFNAME(String strValue) {
        this.setParamValue(TAG_PSSFNAME, strValue);
    }

    public final boolean isDOMAINNAMENull() {
        return this.isParamNull(TAG_DOMAINNAME);
    }

    public final String getDOMAINNAME() {
        return this.getParamStringValue(TAG_DOMAINNAME, "");
    }

    public final void setDOMAINNAME(String strValue) {
        this.setParamValue(TAG_DOMAINNAME, strValue);
    }

    public final boolean isDEFSORTMODENull() {
        return this.isParamNull(TAG_DEFSORTMODE);
    }

    public final String getDEFSORTMODE() {
        return this.getParamStringValue(TAG_DEFSORTMODE, "");
    }

    public final void setDEFSORTMODE(String strValue) {
        this.setParamValue(TAG_DEFSORTMODE, strValue);
    }

    public final boolean isLANRESMAXTAGNull() {
        return this.isParamNull(TAG_LANRESMAXTAG);
    }

    public final int getLANRESMAXTAG() {
        return this.getParamIntValue(TAG_LANRESMAXTAG, 0);
    }

    public final void setLANRESMAXTAG(int nValue) {
        this.setParamValue(TAG_LANRESMAXTAG, nValue);
    }

    public final boolean isPSLANGUAGEIDNull() {
        return this.isParamNull(TAG_PSLANGUAGEID);
    }

    public final String getPSLANGUAGEID() {
        return this.getParamStringValue(TAG_PSLANGUAGEID, "");
    }

    public final void setPSLANGUAGEID(String strValue) {
        this.setParamValue(TAG_PSLANGUAGEID, strValue);
    }

    public final boolean isPSLANGUAGENAMENull() {
        return this.isParamNull(TAG_PSLANGUAGENAME);
    }

    public final String getPSLANGUAGENAME() {
        return this.getParamStringValue(TAG_PSLANGUAGENAME, "");
    }

    public final void setPSLANGUAGENAME(String strValue) {
        this.setParamValue(TAG_PSLANGUAGENAME, strValue);
    }

    public final boolean isENABLEMULTILANNull() {
        return this.isParamNull(TAG_ENABLEMULTILAN);
    }

    public final boolean getENABLEMULTILAN() {
        return this.getParamIntValue(TAG_ENABLEMULTILAN, 0) == 1;
    }

    public final void setENABLEMULTILAN(boolean bValue) {
        this.setParamValue(TAG_ENABLEMULTILAN, bValue ? 1 : 0);
    }

    public final boolean isCLEMPTYTEXTNull() {
        return this.isParamNull(TAG_CLEMPTYTEXT);
    }

    public final String getCLEMPTYTEXT() {
        return this.getParamStringValue(TAG_CLEMPTYTEXT, "");
    }

    public final void setCLEMPTYTEXT(String strValue) {
        this.setParamValue(TAG_CLEMPTYTEXT, strValue);
    }

    public final boolean isCLEMPTYTEXTPSLANRESIDNull() {
        return this.isParamNull(TAG_CLEMPTYTEXTPSLANRESID);
    }

    public final String getCLEMPTYTEXTPSLANRESID() {
        return this.getParamStringValue(TAG_CLEMPTYTEXTPSLANRESID, "");
    }

    public final void setCLEMPTYTEXTPSLANRESID(String strValue) {
        this.setParamValue(TAG_CLEMPTYTEXTPSLANRESID, strValue);
    }

    public final boolean isCLEMPTYTEXTPSLANRESNAMENull() {
        return this.isParamNull(TAG_CLEMPTYTEXTPSLANRESNAME);
    }

    public final String getCLEMPTYTEXTPSLANRESNAME() {
        return this.getParamStringValue(TAG_CLEMPTYTEXTPSLANRESNAME, "");
    }

    public final void setCLEMPTYTEXTPSLANRESNAME(String strValue) {
        this.setParamValue(TAG_CLEMPTYTEXTPSLANRESNAME, strValue);
    }

    public final boolean isPSSYSENGINECFGIDNull() {
        return this.isParamNull(TAG_PSSYSENGINECFGID);
    }

    public final String getPSSYSENGINECFGID() {
        return this.getParamStringValue(TAG_PSSYSENGINECFGID, "");
    }

    public final void setPSSYSENGINECFGID(String strValue) {
        this.setParamValue(TAG_PSSYSENGINECFGID, strValue);
    }

    public final boolean isPSSYSENGINECFGNAMENull() {
        return this.isParamNull(TAG_PSSYSENGINECFGNAME);
    }

    public final String getPSSYSENGINECFGNAME() {
        return this.getParamStringValue(TAG_PSSYSENGINECFGNAME, "");
    }

    public final void setPSSYSENGINECFGNAME(String strValue) {
        this.setParamValue(TAG_PSSYSENGINECFGNAME, strValue);
    }

    public final boolean isDEEXPMAXROWCNTNull() {
        return this.isParamNull(TAG_DEEXPMAXROWCNT);
    }

    public final int getDEEXPMAXROWCNT() {
        return this.getParamIntValue(TAG_DEEXPMAXROWCNT, 0);
    }

    public final void setDEEXPMAXROWCNT(int nValue) {
        this.setParamValue(TAG_DEEXPMAXROWCNT, nValue);
    }

    public final boolean isVIEWUAREGMODENull() {
        return this.isParamNull(TAG_VIEWUAREGMODE);
    }

    public final int getVIEWUAREGMODE() {
        return this.getParamIntValue(TAG_VIEWUAREGMODE, 0);
    }

    public final void setVIEWUAREGMODE(int nValue) {
        this.setParamValue(TAG_VIEWUAREGMODE, nValue);
    }

    public final boolean isCHECKMODELVERNull() {
        return this.isParamNull(TAG_CHECKMODELVER);
    }

    public final int getCHECKMODELVER() {
        return this.getParamIntValue(TAG_CHECKMODELVER, 0);
    }

    public final void setCHECKMODELVER(int nValue) {
        this.setParamValue(TAG_CHECKMODELVER, nValue);
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

    public final boolean isSERVICEAPIFLAGNull() {
        return this.isParamNull(TAG_SERVICEAPIFLAG);
    }

    public final int getSERVICEAPIFLAG() {
        return this.getParamIntValue(TAG_SERVICEAPIFLAG, 0);
    }

    public final void setSERVICEAPIFLAG(int nValue) {
        this.setParamValue(TAG_SERVICEAPIFLAG, nValue);
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

    public final boolean isBUGFIXSNull() {
        return this.isParamNull(TAG_BUGFIXS);
    }

    public final int getBUGFIXS() {
        return this.getParamIntValue(TAG_BUGFIXS, 0);
    }

    public final void setBUGFIXS(int nValue) {
        this.setParamValue(TAG_BUGFIXS, nValue);
    }

    public final boolean isDEFSFITEMWIDTHNull() {
        return this.isParamNull(TAG_DEFSFITEMWIDTH);
    }

    public final int getDEFSFITEMWIDTH() {
        return this.getParamIntValue(TAG_DEFSFITEMWIDTH, 0);
    }

    public final void setDEFSFITEMWIDTH(int nValue) {
        this.setParamValue(TAG_DEFSFITEMWIDTH, nValue);
    }

    public final boolean isPUBDBMODELFLAGNull() {
        return this.isParamNull(TAG_PUBDBMODELFLAG);
    }

    public final boolean getPUBDBMODELFLAG() {
        return this.getParamIntValue(TAG_PUBDBMODELFLAG, 0) == 1;
    }

    public final void setPUBDBMODELFLAG(boolean bValue) {
        this.setParamValue(TAG_PUBDBMODELFLAG, bValue ? 1 : 0);
    }

    public final boolean isENABLEOPNAMEMODELNull() {
        return this.isParamNull(TAG_ENABLEOPNAMEMODEL);
    }

    public final boolean getENABLEOPNAMEMODEL() {
        return this.getParamIntValue(TAG_ENABLEOPNAMEMODEL, 0) == 1;
    }

    public final void setENABLEOPNAMEMODEL(boolean bValue) {
        this.setParamValue(TAG_ENABLEOPNAMEMODEL, bValue ? 1 : 0);
    }

    public final boolean isENABLEDBVALUEMODENull() {
        return this.isParamNull(TAG_ENABLEDBVALUEMODE);
    }

    public final boolean getENABLEDBVALUEMODE() {
        return this.getParamIntValue(TAG_ENABLEDBVALUEMODE, 0) == 1;
    }

    public final void setENABLEDBVALUEMODE(boolean bValue) {
        this.setParamValue(TAG_ENABLEDBVALUEMODE, bValue ? 1 : 0);
    }

    public final boolean isENABLEDYNASYSNull() {
        return this.isParamNull(TAG_ENABLEDYNASYS);
    }

    public final boolean getENABLEDYNASYS() {
        return this.getParamIntValue(TAG_ENABLEDYNASYS, 0) == 1;
    }

    public final void setENABLEDYNASYS(boolean bValue) {
        this.setParamValue(TAG_ENABLEDYNASYS, bValue ? 1 : 0);
    }
}

