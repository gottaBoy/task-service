/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSDEDataSet
extends BaseDataEntity {
    public static final String PREDEFINETYPE_INDEXDE = "INDEXDE";
    public static final String PREDEFINETYPE_MULTIFORM = "MULTIFORM";
    public static final String PREDEFINETYPE_CODELIST = "CODELIST";
    public static final String CACHESCOPE_GLOBAL = "GLOBAL";
    public static final String CACHESCOPE_ORG = "ORG";
    public static final String CACHESCOPE_USER = "USER";
    public static final String MINORSORTDIR_ASC = "ASC";
    public static final String MINORSORTDIR_DESC = "DESC";
    public static final String MAJORSORTDIR_ASC = "ASC";
    public static final String MAJORSORTDIR_DESC = "DESC";
    public static final String TAG_PSDEDATASETID = "PSDEDATASETID";
    public static final String TAG_PSDEDATASETNAME = "PSDEDATASETNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSDEID = "PSDEID";
    public static final String TAG_PSDENAME = "PSDENAME";
    public static final String TAG_DEFAULTMODE = "DEFAULTMODE";
    public static final String TAG_CODENAME = "CODENAME";
    public static final String TAG_LOGICNAME = "LOGICNAME";
    public static final String TAG_PREDEFINETYPE = "PREDEFINETYPE";
    public static final String TAG_PREDEFINEDTYPE = "PREDEFINEDTYPE";
    public static final String TAG_ENABLEGROUP = "ENABLEGROUP";
    public static final String TAG_PSCODELISTID = "PSCODELISTID";
    public static final String TAG_PSCODELISTNAME = "PSCODELISTNAME";
    public static final String TAG_EXTENDMODE = "EXTENDMODE";
    public static final String TAG_ENABLEUSERDR = "ENABLEUSERDR";
    public static final String TAG_ENABLESECDR = "ENABLESECDR";
    public static final String TAG_ENABLESECBC = "ENABLESECBC";
    public static final String TAG_ENABLEORGDR = "ENABLEORGDR";
    public static final String TAG_SECDR = "SECDR";
    public static final String TAG_SECBC = "SECBC";
    public static final String TAG_ORGDR = "ORGDR";
    public static final String TAG_PSSYSUSERDRID = "PSSYSUSERDRID";
    public static final String TAG_PSSYSUSERDRNAME = "PSSYSUSERDRNAME";
    public static final String TAG_PSSYSUSERDRID2 = "PSSYSUSERDRID2";
    public static final String TAG_PSSYSUSERDRNAME2 = "PSSYSUSERDRNAME2";
    public static final String TAG_SYSUSERDRPARAM = "SYSUSERDRPARAM";
    public static final String TAG_SYSUSERDR2PARAM = "SYSUSERDR2PARAM";
    public static final String TAG_TODOTASK = "TODOTASK";
    public static final String TAG_ENABLECACHE = "ENABLECACHE";
    public static final String TAG_CACHESCOPE = "CACHESCOPE";
    public static final String TAG_CACHEPSVARTYPEID = "CACHEPSVARTYPEID";
    public static final String TAG_CACHEPSVARTYPENAME = "CACHEPSVARTYPENAME";
    public static final String TAG_CACHECONDVALUE = "CACHECONDVALUE";
    public static final String TAG_CACHETIMEOUT = "CACHETIMEOUT";
    public static final String TAG_MAJORPSDEFID = "MAJORPSDEFID";
    public static final String TAG_MAJORPSDEFNAME = "MAJORPSDEFNAME";
    public static final String TAG_MINORPSDEFID = "MINORPSDEFID";
    public static final String TAG_MINORPSDEFNAME = "MINORPSDEFNAME";
    public static final String TAG_MINORSORTDIR = "MINORSORTDIR";
    public static final String TAG_MAJORSORTDIR = "MAJORSORTDIR";
    public static final String TAG_PAGESIZE = "PAGESIZE";
    public static final String TAG_PSSYSUNISTATEID = "PSSYSUNISTATEID";
    public static final String TAG_PSSYSUNISTATENAME = "PSSYSUNISTATENAME";
    public static final String TAG_CACHECHECKSTATE = "CACHECHECKSTATE";
    public static final String TAG_CACHESTATEPSDELOGICID = "CACHESTATEPSDELOGICID";
    public static final String TAG_CACHESTATEPSDELOGICNAME = "CACHESTATEPSDELOGICNAME";
    public static final String TAG_PUBMODE = "PUBMODE";
    public static final String TAG_REQUESTMETHOD = "REQUESTMETHOD";
    public static final String TAG_REQUESTPATH = "REQUESTPATH";
    public static final String TAG_ADPSDELOGICID = "ADPSDELOGICID";
    public static final String TAG_ADPSDELOGICNAME = "ADPSDELOGICNAME";
    public static final String TAG_ENABLETEMPDATA = "ENABLETEMPDATA";
    public static final String TAG_PSSUBSYSSADETAILID = "PSSUBSYSSADETAILID";
    public static final String TAG_PSSUBSYSSADETAILNAME = "PSSUBSYSSADETAILNAME";
    public static final String TAG_PSSYSPFPLUGINID = "PSSYSPFPLUGINID";
    public static final String TAG_PSSYSPFPLUGINNAME = "PSSYSPFPLUGINNAME";
    public static final String TAG_PSSYSSFPLUGINID = "PSSYSSFPLUGINID";
    public static final String TAG_PSSYSSFPLUGINNAME = "PSSYSSFPLUGINNAME";
    public static final String TAG_ACTIONHOLDER = "ACTIONHOLDER";
    public static final String TAG_PSDEOPPRIVID = "PSDEOPPRIVID";
    public static final String TAG_PSDEOPPRIVNAME = "PSDEOPPRIVNAME";
    public static final String TAG_ORDERVALUE = "ORDERVALUE";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";
    public static final String TAG_ENABLEAUDIT = "ENABLEAUDIT";
    public static final String TAG_CUSTOMCODE = "CUSTOMCODE";
    public static final String TAG_AGGDATAPSDERID = "AGGDATAPSDERID";
    public static final String TAG_AGGDATAPSDERNAME = "AGGDATAPSDERNAME";
    public static final String TAG_PSDELOGICID = "PSDELOGICID";
    public static final String TAG_PSDELOGICNAME = "PSDELOGICNAME";
    public static final String TAG_BEFORECODE = "BEFORECODE";
    public static final String TAG_AFTERCODE = "AFTERCODE";
    public static final String TAG_CACHECAT = "CACHECAT";
    public static final String TAG_CACHETAG = "CACHETAG";
    public static final String TAG_POTIME = "POTIME";
    public static final String TAG_DSTAG = "DSTAG";
    public static final String TAG_DSTAG2 = "DSTAG2";
    public static final String TAG_DSTAG3 = "DSTAG3";
    public static final String TAG_DSTAG4 = "DSTAG4";
    public static final String TAG_RETVALTYPE = "RETVALTYPE";
    public static final String TAG_OUTPSDEFGROUPID = "OUTPSDEFGROUPID";
    public static final String TAG_OUTPSDEFGROUPNAME = "OUTPSDEFGROUPNAME";
    public static final String TAG_PARAMTYPE = "PARAMTYPE";
    public static final String TAG_INPSSYSDYNAMODELID = "INPSSYSDYNAMODELID";
    public static final String TAG_INPSSYSDYNAMODELNAME = "INPSSYSDYNAMODELNAME";
    public static final String TAG_INPSDEFGROUPID = "INPSDEFGROUPID";
    public static final String TAG_INPSDEFGROUPNAME = "INPSDEFGROUPNAME";
    public static final String TAG_SUBSYSSADETAILMODE = "SUBSYSSADETAILMODE";
    public static final String TAG_SERVICECODENAME = "SERVICECODENAME";
    public static final String TAG_OPTION = "OPTION";
    public static final String TAG_VIEWCOLLEVEL = "VIEWCOLLEVEL";
    public static final String TAG_PREDEFINEDTYPEPARAM = "PREDEFINEDTYPEPARAM";
    public static final String TAG_DATASETPARAMS = "DATASETPARAMS";
    public static final String TAG_UNIONMODE = "UNIONMODE";
    public static final String TAG_DSOPTION = "DSOPTION";
    public static final String TAG_MAXROWCNT = "MAXROWCNT";
    public static final String TAG_PSDEFGROUPID = "PSDEFGROUPID";
    public static final String TAG_PSDEFGROUPNAME = "PSDEFGROUPNAME";

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

    public final boolean isDEFAULTMODENull() {
        return this.IsParamNull(TAG_DEFAULTMODE);
    }

    public final boolean getDEFAULTMODE() {
        return this.GetParamIntValue(TAG_DEFAULTMODE, 0) == 1;
    }

    public final void setDEFAULTMODE(boolean bValue) {
        this.SetParamValue(TAG_DEFAULTMODE, bValue ? 1 : 0);
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

    public final boolean isLOGICNAMENull() {
        return this.IsParamNull(TAG_LOGICNAME);
    }

    public final String getLOGICNAME() {
        return this.GetParamStringValue(TAG_LOGICNAME, "");
    }

    public final void setLOGICNAME(String strValue) {
        this.SetParamValue(TAG_LOGICNAME, strValue);
    }

    public final boolean isPREDEFINETYPENull() {
        return this.IsParamNull(TAG_PREDEFINETYPE);
    }

    public final String getPREDEFINETYPE() {
        return this.GetParamStringValue(TAG_PREDEFINETYPE, "");
    }

    public final void setPREDEFINETYPE(String strValue) {
        this.SetParamValue(TAG_PREDEFINETYPE, strValue);
    }

    public final boolean isENABLEGROUPNull() {
        return this.IsParamNull(TAG_ENABLEGROUP);
    }

    public final int getENABLEGROUP() {
        return this.GetParamIntValue(TAG_ENABLEGROUP, 0);
    }

    public final void setENABLEGROUP(int bValue) {
        this.SetParamValue(TAG_ENABLEGROUP, bValue);
    }

    public final boolean isPSCODELISTIDNull() {
        return this.IsParamNull(TAG_PSCODELISTID);
    }

    public final String getPSCODELISTID() {
        return this.GetParamStringValue(TAG_PSCODELISTID, "");
    }

    public final void setPSCODELISTID(String strValue) {
        this.SetParamValue(TAG_PSCODELISTID, strValue);
    }

    public final boolean isPSCODELISTNAMENull() {
        return this.IsParamNull(TAG_PSCODELISTNAME);
    }

    public final String getPSCODELISTNAME() {
        return this.GetParamStringValue(TAG_PSCODELISTNAME, "");
    }

    public final void setPSCODELISTNAME(String strValue) {
        this.SetParamValue(TAG_PSCODELISTNAME, strValue);
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

    public final boolean isTODOTASKNull() {
        return this.IsParamNull(TAG_TODOTASK);
    }

    public final String getTODOTASK() {
        return this.GetParamStringValue(TAG_TODOTASK, "");
    }

    public final void setTODOTASK(String strValue) {
        this.SetParamValue(TAG_TODOTASK, strValue);
    }

    public final boolean isENABLEUSERDRNull() {
        return this.IsParamNull(TAG_ENABLEUSERDR);
    }

    public final boolean getENABLEUSERDR() {
        return this.GetParamIntValue(TAG_ENABLEUSERDR, 0) == 1;
    }

    public final void setENABLEUSERDR(boolean bValue) {
        this.SetParamValue(TAG_ENABLEUSERDR, bValue ? 1 : 0);
    }

    public final boolean isENABLESECDRNull() {
        return this.IsParamNull(TAG_ENABLESECDR);
    }

    public final boolean getENABLESECDR() {
        return this.GetParamIntValue(TAG_ENABLESECDR, 0) == 1;
    }

    public final void setENABLESECDR(boolean bValue) {
        this.SetParamValue(TAG_ENABLESECDR, bValue ? 1 : 0);
    }

    public final boolean isENABLESECBCNull() {
        return this.IsParamNull(TAG_ENABLESECBC);
    }

    public final boolean getENABLESECBC() {
        return this.GetParamIntValue(TAG_ENABLESECBC, 0) == 1;
    }

    public final void setENABLESECBC(boolean bValue) {
        this.SetParamValue(TAG_ENABLESECBC, bValue ? 1 : 0);
    }

    public final boolean isENABLEORGDRNull() {
        return this.IsParamNull(TAG_ENABLEORGDR);
    }

    public final boolean getENABLEORGDR() {
        return this.GetParamIntValue(TAG_ENABLEORGDR, 0) == 1;
    }

    public final void setENABLEORGDR(boolean bValue) {
        this.SetParamValue(TAG_ENABLEORGDR, bValue ? 1 : 0);
    }

    public final boolean isSECDRNull() {
        return this.IsParamNull(TAG_SECDR);
    }

    public final int getSECDR() {
        return this.GetParamIntValue(TAG_SECDR, 0);
    }

    public final void setSECDR(int nValue) {
        this.SetParamValue(TAG_SECDR, nValue);
    }

    public final boolean isSECBCNull() {
        return this.IsParamNull(TAG_SECBC);
    }

    public final String getSECBC() {
        return this.GetParamStringValue(TAG_SECBC, "");
    }

    public final void setSECBC(String strValue) {
        this.SetParamValue(TAG_SECBC, strValue);
    }

    public final boolean isORGDRNull() {
        return this.IsParamNull(TAG_ORGDR);
    }

    public final int getORGDR() {
        return this.GetParamIntValue(TAG_ORGDR, 0);
    }

    public final void setORGDR(int nValue) {
        this.SetParamValue(TAG_ORGDR, nValue);
    }

    public final boolean isPSSYSUSERDRIDNull() {
        return this.IsParamNull(TAG_PSSYSUSERDRID);
    }

    public final String getPSSYSUSERDRID() {
        return this.GetParamStringValue(TAG_PSSYSUSERDRID, "");
    }

    public final void setPSSYSUSERDRID(String strValue) {
        this.SetParamValue(TAG_PSSYSUSERDRID, strValue);
    }

    public final boolean isPSSYSUSERDRNAMENull() {
        return this.IsParamNull(TAG_PSSYSUSERDRNAME);
    }

    public final String getPSSYSUSERDRNAME() {
        return this.GetParamStringValue(TAG_PSSYSUSERDRNAME, "");
    }

    public final void setPSSYSUSERDRNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSUSERDRNAME, strValue);
    }

    public final boolean isPSSYSUSERDRID2Null() {
        return this.IsParamNull(TAG_PSSYSUSERDRID2);
    }

    public final String getPSSYSUSERDRID2() {
        return this.GetParamStringValue(TAG_PSSYSUSERDRID2, "");
    }

    public final void setPSSYSUSERDRID2(String strValue) {
        this.SetParamValue(TAG_PSSYSUSERDRID2, strValue);
    }

    public final boolean isPSSYSUSERDRNAME2Null() {
        return this.IsParamNull(TAG_PSSYSUSERDRNAME2);
    }

    public final String getPSSYSUSERDRNAME2() {
        return this.GetParamStringValue(TAG_PSSYSUSERDRNAME2, "");
    }

    public final void setPSSYSUSERDRNAME2(String strValue) {
        this.SetParamValue(TAG_PSSYSUSERDRNAME2, strValue);
    }

    public final boolean isSYSUSERDRPARAMNull() {
        return this.IsParamNull(TAG_SYSUSERDRPARAM);
    }

    public final String getSYSUSERDRPARAM() {
        return this.GetParamStringValue(TAG_SYSUSERDRPARAM, "");
    }

    public final void setSYSUSERDRPARAM(String strValue) {
        this.SetParamValue(TAG_SYSUSERDRPARAM, strValue);
    }

    public final boolean isSYSUSERDR2PARAMNull() {
        return this.IsParamNull(TAG_SYSUSERDR2PARAM);
    }

    public final String getSYSUSERDR2PARAM() {
        return this.GetParamStringValue(TAG_SYSUSERDR2PARAM, "");
    }

    public final void setSYSUSERDR2PARAM(String strValue) {
        this.SetParamValue(TAG_SYSUSERDR2PARAM, strValue);
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

    public final boolean isCACHESCOPENull() {
        return this.IsParamNull(TAG_CACHESCOPE);
    }

    public final String getCACHESCOPE() {
        return this.GetParamStringValue(TAG_CACHESCOPE, "");
    }

    public final void setCACHESCOPE(String strValue) {
        this.SetParamValue(TAG_CACHESCOPE, strValue);
    }

    public final boolean isCACHEPSVARTYPEIDNull() {
        return this.IsParamNull(TAG_CACHEPSVARTYPEID);
    }

    public final String getCACHEPSVARTYPEID() {
        return this.GetParamStringValue(TAG_CACHEPSVARTYPEID, "");
    }

    public final void setCACHEPSVARTYPEID(String strValue) {
        this.SetParamValue(TAG_CACHEPSVARTYPEID, strValue);
    }

    public final boolean isCACHEPSVARTYPENAMENull() {
        return this.IsParamNull(TAG_CACHEPSVARTYPENAME);
    }

    public final String getCACHEPSVARTYPENAME() {
        return this.GetParamStringValue(TAG_CACHEPSVARTYPENAME, "");
    }

    public final void setCACHEPSVARTYPENAME(String strValue) {
        this.SetParamValue(TAG_CACHEPSVARTYPENAME, strValue);
    }

    public final boolean isCACHECONDVALUENull() {
        return this.IsParamNull(TAG_CACHECONDVALUE);
    }

    public final String getCACHECONDVALUE() {
        return this.GetParamStringValue(TAG_CACHECONDVALUE, "");
    }

    public final void setCACHECONDVALUE(String strValue) {
        this.SetParamValue(TAG_CACHECONDVALUE, strValue);
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

    public final boolean isMAJORPSDEFIDNull() {
        return this.IsParamNull(TAG_MAJORPSDEFID);
    }

    public final String getMAJORPSDEFID() {
        return this.GetParamStringValue(TAG_MAJORPSDEFID, "");
    }

    public final void setMAJORPSDEFID(String strValue) {
        this.SetParamValue(TAG_MAJORPSDEFID, strValue);
    }

    public final boolean isMAJORPSDEFNAMENull() {
        return this.IsParamNull(TAG_MAJORPSDEFNAME);
    }

    public final String getMAJORPSDEFNAME() {
        return this.GetParamStringValue(TAG_MAJORPSDEFNAME, "");
    }

    public final void setMAJORPSDEFNAME(String strValue) {
        this.SetParamValue(TAG_MAJORPSDEFNAME, strValue);
    }

    public final boolean isMINORPSDEFIDNull() {
        return this.IsParamNull(TAG_MINORPSDEFID);
    }

    public final String getMINORPSDEFID() {
        return this.GetParamStringValue(TAG_MINORPSDEFID, "");
    }

    public final void setMINORPSDEFID(String strValue) {
        this.SetParamValue(TAG_MINORPSDEFID, strValue);
    }

    public final boolean isMINORPSDEFNAMENull() {
        return this.IsParamNull(TAG_MINORPSDEFNAME);
    }

    public final String getMINORPSDEFNAME() {
        return this.GetParamStringValue(TAG_MINORPSDEFNAME, "");
    }

    public final void setMINORPSDEFNAME(String strValue) {
        this.SetParamValue(TAG_MINORPSDEFNAME, strValue);
    }

    public final boolean isMINORSORTDIRNull() {
        return this.IsParamNull(TAG_MINORSORTDIR);
    }

    public final String getMINORSORTDIR() {
        return this.GetParamStringValue(TAG_MINORSORTDIR, "");
    }

    public final void setMINORSORTDIR(String strValue) {
        this.SetParamValue(TAG_MINORSORTDIR, strValue);
    }

    public final boolean isMAJORSORTDIRNull() {
        return this.IsParamNull(TAG_MAJORSORTDIR);
    }

    public final String getMAJORSORTDIR() {
        return this.GetParamStringValue(TAG_MAJORSORTDIR, "");
    }

    public final void setMAJORSORTDIR(String strValue) {
        this.SetParamValue(TAG_MAJORSORTDIR, strValue);
    }

    public final boolean isPAGESIZENull() {
        return this.IsParamNull(TAG_PAGESIZE);
    }

    public final int getPAGESIZE() {
        return this.GetParamIntValue(TAG_PAGESIZE, 0);
    }

    public final void setPAGESIZE(int nValue) {
        this.SetParamValue(TAG_PAGESIZE, nValue);
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

    public final boolean isCACHECHECKSTATENull() {
        return this.IsParamNull(TAG_CACHECHECKSTATE);
    }

    public final String getCACHECHECKSTATE() {
        return this.GetParamStringValue(TAG_CACHECHECKSTATE, "");
    }

    public final void setCACHECHECKSTATE(String strValue) {
        this.SetParamValue(TAG_CACHECHECKSTATE, strValue);
    }

    public final boolean isCACHESTATEPSDELOGICIDNull() {
        return this.IsParamNull(TAG_CACHESTATEPSDELOGICID);
    }

    public final String getCACHESTATEPSDELOGICID() {
        return this.GetParamStringValue(TAG_CACHESTATEPSDELOGICID, "");
    }

    public final void setCACHESTATEPSDELOGICID(String strValue) {
        this.SetParamValue(TAG_CACHESTATEPSDELOGICID, strValue);
    }

    public final boolean isCACHESTATEPSDELOGICNAMENull() {
        return this.IsParamNull(TAG_CACHESTATEPSDELOGICNAME);
    }

    public final String getCACHESTATEPSDELOGICNAME() {
        return this.GetParamStringValue(TAG_CACHESTATEPSDELOGICNAME, "");
    }

    public final void setCACHESTATEPSDELOGICNAME(String strValue) {
        this.SetParamValue(TAG_CACHESTATEPSDELOGICNAME, strValue);
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

    public final boolean isADPSDELOGICIDNull() {
        return this.IsParamNull(TAG_ADPSDELOGICID);
    }

    public final String getADPSDELOGICID() {
        return this.GetParamStringValue(TAG_ADPSDELOGICID, "");
    }

    public final void setADPSDELOGICID(String strValue) {
        this.SetParamValue(TAG_ADPSDELOGICID, strValue);
    }

    public final boolean isADPSDELOGICNAMENull() {
        return this.IsParamNull(TAG_ADPSDELOGICNAME);
    }

    public final String getADPSDELOGICNAME() {
        return this.GetParamStringValue(TAG_ADPSDELOGICNAME, "");
    }

    public final void setADPSDELOGICNAME(String strValue) {
        this.SetParamValue(TAG_ADPSDELOGICNAME, strValue);
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

    public final boolean isREQUESTMETHODNull() {
        return this.IsParamNull(TAG_REQUESTMETHOD);
    }

    public final String getREQUESTMETHOD() {
        return this.GetParamStringValue(TAG_REQUESTMETHOD, "");
    }

    public final void setREQUESTMETHOD(String strValue) {
        this.SetParamValue(TAG_REQUESTMETHOD, strValue);
    }

    public final boolean isENABLETEMPDATANull() {
        return this.IsParamNull(TAG_ENABLETEMPDATA);
    }

    public final boolean getENABLETEMPDATA() {
        return this.GetParamIntValue(TAG_ENABLETEMPDATA, 0) == 1;
    }

    public final void setENABLETEMPDATA(boolean bValue) {
        this.SetParamValue(TAG_ENABLETEMPDATA, bValue ? 1 : 0);
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

    public final boolean isACTIONHOLDERNull() {
        return this.IsParamNull(TAG_ACTIONHOLDER);
    }

    public final int getACTIONHOLDER() {
        return this.GetParamIntValue(TAG_ACTIONHOLDER, 0);
    }

    public final void setACTIONHOLDER(int nValue) {
        this.SetParamValue(TAG_ACTIONHOLDER, nValue);
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

    public final boolean isENABLEAUDITNull() {
        return this.IsParamNull(TAG_ENABLEAUDIT);
    }

    public final boolean getENABLEAUDIT() {
        return this.GetParamIntValue(TAG_ENABLEAUDIT, 0) == 1;
    }

    public final void setENABLEAUDIT(boolean bValue) {
        this.SetParamValue(TAG_ENABLEAUDIT, bValue ? 1 : 0);
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

    public final boolean isAGGDATAPSDERIDNull() {
        return this.IsParamNull(TAG_AGGDATAPSDERID);
    }

    public final String getAGGDATAPSDERID() {
        return this.GetParamStringValue(TAG_AGGDATAPSDERID, "");
    }

    public final void setAGGDATAPSDERID(String strValue) {
        this.SetParamValue(TAG_AGGDATAPSDERID, strValue);
    }

    public final boolean isAGGDATAPSDERNAMENull() {
        return this.IsParamNull(TAG_AGGDATAPSDERNAME);
    }

    public final String getAGGDATAPSDERNAME() {
        return this.GetParamStringValue(TAG_AGGDATAPSDERNAME, "");
    }

    public final void setAGGDATAPSDERNAME(String strValue) {
        this.SetParamValue(TAG_AGGDATAPSDERNAME, strValue);
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

    public final boolean isCACHECATNull() {
        return this.IsParamNull(TAG_CACHECAT);
    }

    public final String getCACHECAT() {
        return this.GetParamStringValue(TAG_CACHECAT, "");
    }

    public final void setCACHECAT(String strValue) {
        this.SetParamValue(TAG_CACHECAT, strValue);
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

    public final boolean isPOTIMENull() {
        return this.IsParamNull(TAG_POTIME);
    }

    public final int getPOTIME() {
        return this.GetParamIntValue(TAG_POTIME, 0);
    }

    public final void setPOTIME(int nValue) {
        this.SetParamValue(TAG_POTIME, nValue);
    }

    public final boolean isDSTAGNull() {
        return this.IsParamNull(TAG_DSTAG);
    }

    public final String getDSTAG() {
        return this.GetParamStringValue(TAG_DSTAG, "");
    }

    public final void setDSTAG(String strValue) {
        this.SetParamValue(TAG_DSTAG, strValue);
    }

    public final boolean isDSTAG2Null() {
        return this.IsParamNull(TAG_DSTAG2);
    }

    public final String getDSTAG2() {
        return this.GetParamStringValue(TAG_DSTAG2, "");
    }

    public final void setDSTAG2(String strValue) {
        this.SetParamValue(TAG_DSTAG2, strValue);
    }

    public final boolean isDSTAG3Null() {
        return this.IsParamNull(TAG_DSTAG3);
    }

    public final String getDSTAG3() {
        return this.GetParamStringValue(TAG_DSTAG3, "");
    }

    public final void setDSTAG3(String strValue) {
        this.SetParamValue(TAG_DSTAG3, strValue);
    }

    public final boolean isDSTAG4Null() {
        return this.IsParamNull(TAG_DSTAG4);
    }

    public final String getDSTAG4() {
        return this.GetParamStringValue(TAG_DSTAG4, "");
    }

    public final void setDSTAG4(String strValue) {
        this.SetParamValue(TAG_DSTAG4, strValue);
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

    public final boolean isPARAMTYPENull() {
        return this.IsParamNull(TAG_PARAMTYPE);
    }

    public final int getPARAMTYPE() {
        return this.GetParamIntValue(TAG_PARAMTYPE, 0);
    }

    public final void setPARAMTYPE(int nValue) {
        this.SetParamValue(TAG_PARAMTYPE, nValue);
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

    public final boolean isOPTIONNull() {
        return this.IsParamNull(TAG_OPTION);
    }

    public final int getOPTION() {
        return this.GetParamIntValue(TAG_OPTION, 0);
    }

    public final void setOPTION(int nValue) {
        this.SetParamValue(TAG_OPTION, nValue);
    }

    public final boolean isVIEWCOLLEVELNull() {
        return this.IsParamNull(TAG_VIEWCOLLEVEL);
    }

    public final int getVIEWCOLLEVEL() {
        return this.GetParamIntValue(TAG_VIEWCOLLEVEL, 0);
    }

    public final void setVIEWCOLLEVEL(int nValue) {
        this.SetParamValue(TAG_VIEWCOLLEVEL, nValue);
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

    public final boolean isDATASETPARAMSNull() {
        return this.IsParamNull(TAG_DATASETPARAMS);
    }

    public final String getDATASETPARAMS() {
        return this.GetParamStringValue(TAG_DATASETPARAMS, "");
    }

    public final void setDATASETPARAMS(String strValue) {
        this.SetParamValue(TAG_DATASETPARAMS, strValue);
    }

    public final boolean isUNIONMODENull() {
        return this.IsParamNull(TAG_UNIONMODE);
    }

    public final String getUNIONMODE() {
        return this.GetParamStringValue(TAG_UNIONMODE, "");
    }

    public final void setUNIONMODE(String strValue) {
        this.SetParamValue(TAG_UNIONMODE, strValue);
    }

    public final boolean isDSOPTIONNull() {
        return this.IsParamNull(TAG_DSOPTION);
    }

    public final int getDSOPTION() {
        return this.GetParamIntValue(TAG_DSOPTION, 0);
    }

    public final void setDSOPTION(int nValue) {
        this.SetParamValue(TAG_DSOPTION, nValue);
    }

    public final boolean isMAXROWCNTNull() {
        return this.IsParamNull(TAG_MAXROWCNT);
    }

    public final int getMAXROWCNT() {
        return this.GetParamIntValue(TAG_MAXROWCNT, 0);
    }

    public final void setMAXROWCNT(int nValue) {
        this.SetParamValue(TAG_MAXROWCNT, nValue);
    }

    public final boolean isPSDEFGROUPIDNull() {
        return this.IsParamNull(TAG_PSDEFGROUPID);
    }

    public final String getPSDEFGROUPID() {
        return this.GetParamStringValue(TAG_PSDEFGROUPID, "");
    }

    public final void setPSDEFGROUPID(String strValue) {
        this.SetParamValue(TAG_PSDEFGROUPID, strValue);
    }

    public final boolean isPSDEFGROUPNAMENull() {
        return this.IsParamNull(TAG_PSDEFGROUPNAME);
    }

    public final String getPSDEFGROUPNAME() {
        return this.GetParamStringValue(TAG_PSDEFGROUPNAME, "");
    }

    public final void setPSDEFGROUPNAME(String strValue) {
        this.SetParamValue(TAG_PSDEFGROUPNAME, strValue);
    }
}

