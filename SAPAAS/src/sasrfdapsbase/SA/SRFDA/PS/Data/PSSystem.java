/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

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
    public static final String TAG_SAASMODE = "SAASMODE";
    public static final String TAG_ENADEFLANRESCONTENT = "ENADEFLANRESCONTENT";
    public static final String TAG_ENABLEDEDATAVER = "ENABLEDEDATAVER";
    public static final String TAG_DEMSACTIONLOGICFLAG = "DEMSACTIONLOGICFLAG";
    public static final String TAG_SSDEMSACTIONLOGICFLAG = "SSDEMSACTIONLOGICFLAG";
    public static final String TAG_ENABLEDERFKEY = "ENABLEDERFKEY";
    public static final String TAG_CTRLAPPENDDEITEMS = "CTRLAPPENDDEITEMS";
    public static final String TAG_AUTOCALCDERER = "AUTOCALCDERER";
    public static final String TAG_ENABLEDEFRESTRICTEDUI = "ENABLEDEFRESTRICTEDUI";
    public static final String TAG_PIAUTOSHOWCAPTION = "PIAUTOSHOWCAPTION";
    public static final String TAG_DTOFORMAT = "DTOFORMAT";
    public static final String TAG_SIMACTIONLOGICS = "SIMACTIONLOGICS";
    public static final String TAG_SCRIPTENGINE = "SCRIPTENGINE";
    public static final String TAG_TAGS = "TAGS";
    public static final String TAG_CUSTOMMODE = "CUSTOMMODE";
    public static final String TAG_CUSTOMCODE = "CUSTOMCODE";
    public static final String TAG_CODENAMEMODE = "CODENAMEMODE";
    public static final String TAG_ENABLEPQL = "ENABLEPQL";
    public static final String TAG_DEDSMAXROWCNT = "DEDSMAXROWCNT";

    public final boolean isLOGICNAMENull() {
        return this.IsParamNull(TAG_LOGICNAME);
    }

    public final String getLOGICNAME() {
        return this.GetParamStringValue(TAG_LOGICNAME, "");
    }

    public final void setLOGICNAME(String strValue) {
        this.SetParamValue(TAG_LOGICNAME, strValue);
    }

    public final boolean isSYSFOLDERNull() {
        return this.IsParamNull(TAG_SYSFOLDER);
    }

    public final String getSYSFOLDER() {
        return this.GetParamStringValue(TAG_SYSFOLDER, "");
    }

    public final void setSYSFOLDER(String strValue) {
        this.SetParamValue(TAG_SYSFOLDER, strValue);
    }

    public final boolean isPSDEVCENTERIDNull() {
        return this.IsParamNull(TAG_PSDEVCENTERID);
    }

    public final String getPSDEVCENTERID() {
        return this.GetParamStringValue(TAG_PSDEVCENTERID, "");
    }

    public final void setPSDEVCENTERID(String strValue) {
        this.SetParamValue(TAG_PSDEVCENTERID, strValue);
    }

    public final boolean isPSDEVCENTERNAMENull() {
        return this.IsParamNull(TAG_PSDEVCENTERNAME);
    }

    public final String getPSDEVCENTERNAME() {
        return this.GetParamStringValue(TAG_PSDEVCENTERNAME, "");
    }

    public final void setPSDEVCENTERNAME(String strValue) {
        this.SetParamValue(TAG_PSDEVCENTERNAME, strValue);
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

    public final boolean isSYSVERNull() {
        return this.IsParamNull(TAG_SYSVER);
    }

    public final String getSYSVER() {
        return this.GetParamStringValue(TAG_SYSVER, "");
    }

    public final void setSYSVER(String strValue) {
        this.SetParamValue(TAG_SYSVER, strValue);
    }

    public final boolean isSRCPSSYSTEMIDNull() {
        return this.IsParamNull(TAG_SRCPSSYSTEMID);
    }

    public final String getSRCPSSYSTEMID() {
        return this.GetParamStringValue(TAG_SRCPSSYSTEMID, "");
    }

    public final void setSRCPSSYSTEMID(String strValue) {
        this.SetParamValue(TAG_SRCPSSYSTEMID, strValue);
    }

    public final boolean isSRCPSSYSTEMNAMENull() {
        return this.IsParamNull(TAG_SRCPSSYSTEMNAME);
    }

    public final String getSRCPSSYSTEMNAME() {
        return this.GetParamStringValue(TAG_SRCPSSYSTEMNAME, "");
    }

    public final void setSRCPSSYSTEMNAME(String strValue) {
        this.SetParamValue(TAG_SRCPSSYSTEMNAME, strValue);
    }

    public final boolean isPSDEVSLNSYSIDNull() {
        return this.IsParamNull(TAG_PSDEVSLNSYSID);
    }

    public final String getPSDEVSLNSYSID() {
        return this.GetParamStringValue(TAG_PSDEVSLNSYSID, "");
    }

    public final void setPSDEVSLNSYSID(String strValue) {
        this.SetParamValue(TAG_PSDEVSLNSYSID, strValue);
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
        return this.IsParamNull("CREATEDATE");
    }

    public final Date getCREATEDATE() {
        return this.GetParamDateValue("CREATEDATE", null);
    }

    public final void setCREATEDATE(Date dtValue) {
        this.SetParamValue("CREATEDATE", dtValue);
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

    public final boolean isPSDEVSLNIDNull() {
        return this.IsParamNull(TAG_PSDEVSLNID);
    }

    public final String getPSDEVSLNID() {
        return this.GetParamStringValue(TAG_PSDEVSLNID, "");
    }

    public final void setPSDEVSLNID(String strValue) {
        this.SetParamValue(TAG_PSDEVSLNID, strValue);
    }

    public final boolean isPSDEVSLNNAMENull() {
        return this.IsParamNull(TAG_PSDEVSLNNAME);
    }

    public final String getPSDEVSLNNAME() {
        return this.GetParamStringValue(TAG_PSDEVSLNNAME, "");
    }

    public final void setPSDEVSLNNAME(String strValue) {
        this.SetParamValue(TAG_PSDEVSLNNAME, strValue);
    }

    public final boolean isDBVERSIONNull() {
        return this.IsParamNull(TAG_DBVERSION);
    }

    public final int getDBVERSION() {
        return this.GetParamIntValue(TAG_DBVERSION, 0);
    }

    public final void setDBVERSION(int nValue) {
        this.SetParamValue(TAG_DBVERSION, nValue);
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

    public final boolean isDBTYPESNull() {
        return this.IsParamNull(TAG_DBTYPES);
    }

    public final String getDBTYPES() {
        return this.GetParamStringValue(TAG_DBTYPES, "");
    }

    public final void setDBTYPES(String strValue) {
        this.SetParamValue(TAG_DBTYPES, strValue);
    }

    public final boolean isDEFPSSYSDEPLOYIDNull() {
        return this.IsParamNull(TAG_DEFPSSYSDEPLOYID);
    }

    public final String getDEFPSSYSDEPLOYID() {
        return this.GetParamStringValue(TAG_DEFPSSYSDEPLOYID, "");
    }

    public final void setDEFPSSYSDEPLOYID(String strValue) {
        this.SetParamValue(TAG_DEFPSSYSDEPLOYID, strValue);
    }

    public final boolean isPSSFIDNull() {
        return this.IsParamNull(TAG_PSSFID);
    }

    public final String getPSSFID() {
        return this.GetParamStringValue(TAG_PSSFID, "");
    }

    public final void setPSSFID(String strValue) {
        this.SetParamValue(TAG_PSSFID, strValue);
    }

    public final boolean isPSSFNAMENull() {
        return this.IsParamNull(TAG_PSSFNAME);
    }

    public final String getPSSFNAME() {
        return this.GetParamStringValue(TAG_PSSFNAME, "");
    }

    public final void setPSSFNAME(String strValue) {
        this.SetParamValue(TAG_PSSFNAME, strValue);
    }

    public final boolean isDOMAINNAMENull() {
        return this.IsParamNull(TAG_DOMAINNAME);
    }

    public final String getDOMAINNAME() {
        return this.GetParamStringValue(TAG_DOMAINNAME, "");
    }

    public final void setDOMAINNAME(String strValue) {
        this.SetParamValue(TAG_DOMAINNAME, strValue);
    }

    public final boolean isDEFSORTMODENull() {
        return this.IsParamNull(TAG_DEFSORTMODE);
    }

    public final String getDEFSORTMODE() {
        return this.GetParamStringValue(TAG_DEFSORTMODE, "");
    }

    public final void setDEFSORTMODE(String strValue) {
        this.SetParamValue(TAG_DEFSORTMODE, strValue);
    }

    public final boolean isLANRESMAXTAGNull() {
        return this.IsParamNull(TAG_LANRESMAXTAG);
    }

    public final int getLANRESMAXTAG() {
        return this.GetParamIntValue(TAG_LANRESMAXTAG, 0);
    }

    public final void setLANRESMAXTAG(int nValue) {
        this.SetParamValue(TAG_LANRESMAXTAG, nValue);
    }

    public final boolean isPSLANGUAGEIDNull() {
        return this.IsParamNull(TAG_PSLANGUAGEID);
    }

    public final String getPSLANGUAGEID() {
        return this.GetParamStringValue(TAG_PSLANGUAGEID, "");
    }

    public final void setPSLANGUAGEID(String strValue) {
        this.SetParamValue(TAG_PSLANGUAGEID, strValue);
    }

    public final boolean isPSLANGUAGENAMENull() {
        return this.IsParamNull(TAG_PSLANGUAGENAME);
    }

    public final String getPSLANGUAGENAME() {
        return this.GetParamStringValue(TAG_PSLANGUAGENAME, "");
    }

    public final void setPSLANGUAGENAME(String strValue) {
        this.SetParamValue(TAG_PSLANGUAGENAME, strValue);
    }

    public final boolean isENABLEMULTILANNull() {
        return this.IsParamNull(TAG_ENABLEMULTILAN);
    }

    public final boolean getENABLEMULTILAN() {
        return this.GetParamIntValue(TAG_ENABLEMULTILAN, 0) == 1;
    }

    public final void setENABLEMULTILAN(boolean bValue) {
        this.SetParamValue(TAG_ENABLEMULTILAN, bValue ? 1 : 0);
    }

    public final boolean isCLEMPTYTEXTNull() {
        return this.IsParamNull(TAG_CLEMPTYTEXT);
    }

    public final String getCLEMPTYTEXT() {
        return this.GetParamStringValue(TAG_CLEMPTYTEXT, "");
    }

    public final void setCLEMPTYTEXT(String strValue) {
        this.SetParamValue(TAG_CLEMPTYTEXT, strValue);
    }

    public final boolean isCLEMPTYTEXTPSLANRESIDNull() {
        return this.IsParamNull(TAG_CLEMPTYTEXTPSLANRESID);
    }

    public final String getCLEMPTYTEXTPSLANRESID() {
        return this.GetParamStringValue(TAG_CLEMPTYTEXTPSLANRESID, "");
    }

    public final void setCLEMPTYTEXTPSLANRESID(String strValue) {
        this.SetParamValue(TAG_CLEMPTYTEXTPSLANRESID, strValue);
    }

    public final boolean isCLEMPTYTEXTPSLANRESNAMENull() {
        return this.IsParamNull(TAG_CLEMPTYTEXTPSLANRESNAME);
    }

    public final String getCLEMPTYTEXTPSLANRESNAME() {
        return this.GetParamStringValue(TAG_CLEMPTYTEXTPSLANRESNAME, "");
    }

    public final void setCLEMPTYTEXTPSLANRESNAME(String strValue) {
        this.SetParamValue(TAG_CLEMPTYTEXTPSLANRESNAME, strValue);
    }

    public final boolean isPSSYSENGINECFGIDNull() {
        return this.IsParamNull(TAG_PSSYSENGINECFGID);
    }

    public final String getPSSYSENGINECFGID() {
        return this.GetParamStringValue(TAG_PSSYSENGINECFGID, "");
    }

    public final void setPSSYSENGINECFGID(String strValue) {
        this.SetParamValue(TAG_PSSYSENGINECFGID, strValue);
    }

    public final boolean isPSSYSENGINECFGNAMENull() {
        return this.IsParamNull(TAG_PSSYSENGINECFGNAME);
    }

    public final String getPSSYSENGINECFGNAME() {
        return this.GetParamStringValue(TAG_PSSYSENGINECFGNAME, "");
    }

    public final void setPSSYSENGINECFGNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSENGINECFGNAME, strValue);
    }

    public final boolean isDEEXPMAXROWCNTNull() {
        return this.IsParamNull(TAG_DEEXPMAXROWCNT);
    }

    public final int getDEEXPMAXROWCNT() {
        return this.GetParamIntValue(TAG_DEEXPMAXROWCNT, 0);
    }

    public final void setDEEXPMAXROWCNT(int nValue) {
        this.SetParamValue(TAG_DEEXPMAXROWCNT, nValue);
    }

    public final boolean isVIEWUAREGMODENull() {
        return this.IsParamNull(TAG_VIEWUAREGMODE);
    }

    public final int getVIEWUAREGMODE() {
        return this.GetParamIntValue(TAG_VIEWUAREGMODE, 0);
    }

    public final void setVIEWUAREGMODE(int nValue) {
        this.SetParamValue(TAG_VIEWUAREGMODE, nValue);
    }

    public final boolean isCHECKMODELVERNull() {
        return this.IsParamNull(TAG_CHECKMODELVER);
    }

    public final int getCHECKMODELVER() {
        return this.GetParamIntValue(TAG_CHECKMODELVER, 0);
    }

    public final void setCHECKMODELVER(int nValue) {
        this.SetParamValue(TAG_CHECKMODELVER, nValue);
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

    public final boolean isSERVICEAPIFLAGNull() {
        return this.IsParamNull(TAG_SERVICEAPIFLAG);
    }

    public final int getSERVICEAPIFLAG() {
        return this.GetParamIntValue(TAG_SERVICEAPIFLAG, 0);
    }

    public final void setSERVICEAPIFLAG(int nValue) {
        this.SetParamValue(TAG_SERVICEAPIFLAG, nValue);
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

    public final boolean isBUGFIXSNull() {
        return this.IsParamNull(TAG_BUGFIXS);
    }

    public final int getBUGFIXS() {
        return this.GetParamIntValue(TAG_BUGFIXS, 0);
    }

    public final void setBUGFIXS(int nValue) {
        this.SetParamValue(TAG_BUGFIXS, nValue);
    }

    public final boolean isDEFSFITEMWIDTHNull() {
        return this.IsParamNull(TAG_DEFSFITEMWIDTH);
    }

    public final int getDEFSFITEMWIDTH() {
        return this.GetParamIntValue(TAG_DEFSFITEMWIDTH, 0);
    }

    public final void setDEFSFITEMWIDTH(int nValue) {
        this.SetParamValue(TAG_DEFSFITEMWIDTH, nValue);
    }

    public final boolean isPUBDBMODELFLAGNull() {
        return this.IsParamNull(TAG_PUBDBMODELFLAG);
    }

    public final boolean getPUBDBMODELFLAG() {
        return this.GetParamIntValue(TAG_PUBDBMODELFLAG, 0) == 1;
    }

    public final void setPUBDBMODELFLAG(boolean bValue) {
        this.SetParamValue(TAG_PUBDBMODELFLAG, bValue ? 1 : 0);
    }

    public final boolean isENABLEOPNAMEMODELNull() {
        return this.IsParamNull(TAG_ENABLEOPNAMEMODEL);
    }

    public final boolean getENABLEOPNAMEMODEL() {
        return this.GetParamIntValue(TAG_ENABLEOPNAMEMODEL, 0) == 1;
    }

    public final void setENABLEOPNAMEMODEL(boolean bValue) {
        this.SetParamValue(TAG_ENABLEOPNAMEMODEL, bValue ? 1 : 0);
    }

    public final boolean isENABLEDBVALUEMODENull() {
        return this.IsParamNull(TAG_ENABLEDBVALUEMODE);
    }

    public final boolean getENABLEDBVALUEMODE() {
        return this.GetParamIntValue(TAG_ENABLEDBVALUEMODE, 0) == 1;
    }

    public final void setENABLEDBVALUEMODE(boolean bValue) {
        this.SetParamValue(TAG_ENABLEDBVALUEMODE, bValue ? 1 : 0);
    }

    public final boolean isENABLEDYNASYSNull() {
        return this.IsParamNull(TAG_ENABLEDYNASYS);
    }

    public final int getENABLEDYNASYS() {
        return this.GetParamIntValue(TAG_ENABLEDYNASYS, 0);
    }

    public final void setENABLEDYNASYS(int nValue) {
        this.SetParamValue(TAG_ENABLEDYNASYS, nValue);
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

    public final boolean isENADEFLANRESCONTENTNull() {
        return this.IsParamNull(TAG_ENADEFLANRESCONTENT);
    }

    public final boolean getENADEFLANRESCONTENT() {
        return this.GetParamIntValue(TAG_ENADEFLANRESCONTENT, 0) == 1;
    }

    public final void setENADEFLANRESCONTENT(boolean bValue) {
        this.SetParamValue(TAG_ENADEFLANRESCONTENT, bValue ? 1 : 0);
    }

    public final boolean isENABLEDEDATAVERNull() {
        return this.IsParamNull(TAG_ENABLEDEDATAVER);
    }

    public final boolean getENABLEDEDATAVER() {
        return this.GetParamIntValue(TAG_ENABLEDEDATAVER, 0) == 1;
    }

    public final void setENABLEDEDATAVER(boolean bValue) {
        this.SetParamValue(TAG_ENABLEDEDATAVER, bValue ? 1 : 0);
    }

    public final boolean isDEMSACTIONLOGICFLAGNull() {
        return this.IsParamNull(TAG_DEMSACTIONLOGICFLAG);
    }

    public final int getDEMSACTIONLOGICFLAG() {
        return this.GetParamIntValue(TAG_DEMSACTIONLOGICFLAG, 0);
    }

    public final void setDEMSACTIONLOGICFLAG(int nValue) {
        this.SetParamValue(TAG_DEMSACTIONLOGICFLAG, nValue);
    }

    public final boolean isSSDEMSACTIONLOGICFLAGNull() {
        return this.IsParamNull(TAG_SSDEMSACTIONLOGICFLAG);
    }

    public final int getSSDEMSACTIONLOGICFLAG() {
        return this.GetParamIntValue(TAG_SSDEMSACTIONLOGICFLAG, 0);
    }

    public final void setSSDEMSACTIONLOGICFLAG(int nValue) {
        this.SetParamValue(TAG_SSDEMSACTIONLOGICFLAG, nValue);
    }

    public final boolean isENABLEDERFKEYNull() {
        return this.IsParamNull(TAG_ENABLEDERFKEY);
    }

    public final boolean getENABLEDERFKEY() {
        return this.GetParamIntValue(TAG_ENABLEDERFKEY, 0) == 1;
    }

    public final void setENABLEDERFKEY(boolean bValue) {
        this.SetParamValue(TAG_ENABLEDERFKEY, bValue ? 1 : 0);
    }

    public final boolean isCTRLAPPENDDEITEMSNull() {
        return this.IsParamNull(TAG_CTRLAPPENDDEITEMS);
    }

    public final boolean getCTRLAPPENDDEITEMS() {
        return this.GetParamIntValue(TAG_CTRLAPPENDDEITEMS, 0) == 1;
    }

    public final void setCTRLAPPENDDEITEMS(boolean bValue) {
        this.SetParamValue(TAG_CTRLAPPENDDEITEMS, bValue ? 1 : 0);
    }

    public final boolean isAUTOCALCDERERNull() {
        return this.IsParamNull(TAG_AUTOCALCDERER);
    }

    public final boolean getAUTOCALCDERER() {
        return this.GetParamIntValue(TAG_AUTOCALCDERER, 0) == 1;
    }

    public final void setAUTOCALCDERER(boolean bValue) {
        this.SetParamValue(TAG_AUTOCALCDERER, bValue ? 1 : 0);
    }

    public final boolean isENABLEDEFRESTRICTEDUINull() {
        return this.IsParamNull(TAG_ENABLEDEFRESTRICTEDUI);
    }

    public final boolean getENABLEDEFRESTRICTEDUI() {
        return this.GetParamIntValue(TAG_ENABLEDEFRESTRICTEDUI, 0) == 1;
    }

    public final void setENABLEDEFRESTRICTEDUI(boolean bValue) {
        this.SetParamValue(TAG_ENABLEDEFRESTRICTEDUI, bValue ? 1 : 0);
    }

    public final boolean isPIAUTOSHOWCAPTIONNull() {
        return this.IsParamNull(TAG_PIAUTOSHOWCAPTION);
    }

    public final boolean getPIAUTOSHOWCAPTION() {
        return this.GetParamIntValue(TAG_PIAUTOSHOWCAPTION, 0) == 1;
    }

    public final void setPIAUTOSHOWCAPTION(boolean bValue) {
        this.SetParamValue(TAG_PIAUTOSHOWCAPTION, bValue ? 1 : 0);
    }

    public final boolean isDTOFORMATNull() {
        return this.IsParamNull(TAG_DTOFORMAT);
    }

    public final String getDTOFORMAT() {
        return this.GetParamStringValue(TAG_DTOFORMAT, "");
    }

    public final void setDTOFORMAT(String strValue) {
        this.SetParamValue(TAG_DTOFORMAT, strValue);
    }

    public final boolean isSIMACTIONLOGICSNull() {
        return this.IsParamNull(TAG_SIMACTIONLOGICS);
    }

    public final int getSIMACTIONLOGICS() {
        return this.GetParamIntValue(TAG_SIMACTIONLOGICS, 0);
    }

    public final void setSIMACTIONLOGICS(int nValue) {
        this.SetParamValue(TAG_SIMACTIONLOGICS, nValue);
    }

    public final boolean isSCRIPTENGINENull() {
        return this.IsParamNull(TAG_SCRIPTENGINE);
    }

    public final String getSCRIPTENGINE() {
        return this.GetParamStringValue(TAG_SCRIPTENGINE, "");
    }

    public final void setSCRIPTENGINE(String strValue) {
        this.SetParamValue(TAG_SCRIPTENGINE, strValue);
    }

    public final boolean isTAGSNull() {
        return this.IsParamNull(TAG_TAGS);
    }

    public final String getTAGS() {
        return this.GetParamStringValue(TAG_TAGS, "");
    }

    public final void setTAGS(String strValue) {
        this.SetParamValue(TAG_TAGS, strValue);
    }

    public final boolean isCUSTOMMODENull() {
        return this.IsParamNull(TAG_CUSTOMMODE);
    }

    public final boolean getCUSTOMMODE() {
        return this.GetParamIntValue(TAG_CUSTOMMODE, 0) == 1;
    }

    public final void setCUSTOMMODE(boolean bValue) {
        this.SetParamValue(TAG_CUSTOMMODE, bValue ? 1 : 0);
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

    public final boolean isDEDSMAXROWCNTNull() {
        return this.IsParamNull(TAG_DEDSMAXROWCNT);
    }

    public final int getDEDSMAXROWCNT() {
        return this.GetParamIntValue(TAG_DEDSMAXROWCNT, 0);
    }

    public final void setDEDSMAXROWCNT(int nValue) {
        this.SetParamValue(TAG_DEDSMAXROWCNT, nValue);
    }
}

