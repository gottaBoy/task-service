/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.entity;

import java.util.Date;
import net.ibizsys.model.entity.BaseDataEntity;

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

    public final boolean isPSDEDATASETIDNull() {
        return this.isParamNull(TAG_PSDEDATASETID);
    }

    public final String getPSDEDATASETID() {
        return this.getParamStringValue(TAG_PSDEDATASETID, "");
    }

    public final void setPSDEDATASETID(String strValue) {
        this.setParamValue(TAG_PSDEDATASETID, strValue);
    }

    public final boolean isPSDEDATASETNAMENull() {
        return this.isParamNull(TAG_PSDEDATASETNAME);
    }

    public final String getPSDEDATASETNAME() {
        return this.getParamStringValue(TAG_PSDEDATASETNAME, "");
    }

    public final void setPSDEDATASETNAME(String strValue) {
        this.setParamValue(TAG_PSDEDATASETNAME, strValue);
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

    public final boolean isDEFAULTMODENull() {
        return this.isParamNull(TAG_DEFAULTMODE);
    }

    public final boolean getDEFAULTMODE() {
        return this.getParamIntValue(TAG_DEFAULTMODE, 0) == 1;
    }

    public final void setDEFAULTMODE(boolean bValue) {
        this.setParamValue(TAG_DEFAULTMODE, bValue ? 1 : 0);
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

    public final boolean isLOGICNAMENull() {
        return this.isParamNull(TAG_LOGICNAME);
    }

    public final String getLOGICNAME() {
        return this.getParamStringValue(TAG_LOGICNAME, "");
    }

    public final void setLOGICNAME(String strValue) {
        this.setParamValue(TAG_LOGICNAME, strValue);
    }

    public final boolean isPREDEFINETYPENull() {
        return this.isParamNull(TAG_PREDEFINETYPE);
    }

    public final String getPREDEFINETYPE() {
        return this.getParamStringValue(TAG_PREDEFINETYPE, "");
    }

    public final void setPREDEFINETYPE(String strValue) {
        this.setParamValue(TAG_PREDEFINETYPE, strValue);
    }

    public final boolean isENABLEGROUPNull() {
        return this.isParamNull(TAG_ENABLEGROUP);
    }

    public final boolean getENABLEGROUP() {
        return this.getParamIntValue(TAG_ENABLEGROUP, 0) == 1;
    }

    public final void setENABLEGROUP(boolean bValue) {
        this.setParamValue(TAG_ENABLEGROUP, bValue ? 1 : 0);
    }

    public final boolean isPSCODELISTIDNull() {
        return this.isParamNull(TAG_PSCODELISTID);
    }

    public final String getPSCODELISTID() {
        return this.getParamStringValue(TAG_PSCODELISTID, "");
    }

    public final void setPSCODELISTID(String strValue) {
        this.setParamValue(TAG_PSCODELISTID, strValue);
    }

    public final boolean isPSCODELISTNAMENull() {
        return this.isParamNull(TAG_PSCODELISTNAME);
    }

    public final String getPSCODELISTNAME() {
        return this.getParamStringValue(TAG_PSCODELISTNAME, "");
    }

    public final void setPSCODELISTNAME(String strValue) {
        this.setParamValue(TAG_PSCODELISTNAME, strValue);
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

    public final boolean isTODOTASKNull() {
        return this.isParamNull(TAG_TODOTASK);
    }

    public final String getTODOTASK() {
        return this.getParamStringValue(TAG_TODOTASK, "");
    }

    public final void setTODOTASK(String strValue) {
        this.setParamValue(TAG_TODOTASK, strValue);
    }

    public final boolean isENABLEUSERDRNull() {
        return this.isParamNull(TAG_ENABLEUSERDR);
    }

    public final boolean getENABLEUSERDR() {
        return this.getParamIntValue(TAG_ENABLEUSERDR, 0) == 1;
    }

    public final void setENABLEUSERDR(boolean bValue) {
        this.setParamValue(TAG_ENABLEUSERDR, bValue ? 1 : 0);
    }

    public final boolean isENABLESECDRNull() {
        return this.isParamNull(TAG_ENABLESECDR);
    }

    public final boolean getENABLESECDR() {
        return this.getParamIntValue(TAG_ENABLESECDR, 0) == 1;
    }

    public final void setENABLESECDR(boolean bValue) {
        this.setParamValue(TAG_ENABLESECDR, bValue ? 1 : 0);
    }

    public final boolean isENABLESECBCNull() {
        return this.isParamNull(TAG_ENABLESECBC);
    }

    public final boolean getENABLESECBC() {
        return this.getParamIntValue(TAG_ENABLESECBC, 0) == 1;
    }

    public final void setENABLESECBC(boolean bValue) {
        this.setParamValue(TAG_ENABLESECBC, bValue ? 1 : 0);
    }

    public final boolean isENABLEORGDRNull() {
        return this.isParamNull(TAG_ENABLEORGDR);
    }

    public final boolean getENABLEORGDR() {
        return this.getParamIntValue(TAG_ENABLEORGDR, 0) == 1;
    }

    public final void setENABLEORGDR(boolean bValue) {
        this.setParamValue(TAG_ENABLEORGDR, bValue ? 1 : 0);
    }

    public final boolean isSECDRNull() {
        return this.isParamNull(TAG_SECDR);
    }

    public final int getSECDR() {
        return this.getParamIntValue(TAG_SECDR, 0);
    }

    public final void setSECDR(int nValue) {
        this.setParamValue(TAG_SECDR, nValue);
    }

    public final boolean isSECBCNull() {
        return this.isParamNull(TAG_SECBC);
    }

    public final String getSECBC() {
        return this.getParamStringValue(TAG_SECBC, "");
    }

    public final void setSECBC(String strValue) {
        this.setParamValue(TAG_SECBC, strValue);
    }

    public final boolean isORGDRNull() {
        return this.isParamNull(TAG_ORGDR);
    }

    public final int getORGDR() {
        return this.getParamIntValue(TAG_ORGDR, 0);
    }

    public final void setORGDR(int nValue) {
        this.setParamValue(TAG_ORGDR, nValue);
    }

    public final boolean isPSSYSUSERDRIDNull() {
        return this.isParamNull(TAG_PSSYSUSERDRID);
    }

    public final String getPSSYSUSERDRID() {
        return this.getParamStringValue(TAG_PSSYSUSERDRID, "");
    }

    public final void setPSSYSUSERDRID(String strValue) {
        this.setParamValue(TAG_PSSYSUSERDRID, strValue);
    }

    public final boolean isPSSYSUSERDRNAMENull() {
        return this.isParamNull(TAG_PSSYSUSERDRNAME);
    }

    public final String getPSSYSUSERDRNAME() {
        return this.getParamStringValue(TAG_PSSYSUSERDRNAME, "");
    }

    public final void setPSSYSUSERDRNAME(String strValue) {
        this.setParamValue(TAG_PSSYSUSERDRNAME, strValue);
    }

    public final boolean isPSSYSUSERDRID2Null() {
        return this.isParamNull(TAG_PSSYSUSERDRID2);
    }

    public final String getPSSYSUSERDRID2() {
        return this.getParamStringValue(TAG_PSSYSUSERDRID2, "");
    }

    public final void setPSSYSUSERDRID2(String strValue) {
        this.setParamValue(TAG_PSSYSUSERDRID2, strValue);
    }

    public final boolean isPSSYSUSERDRNAME2Null() {
        return this.isParamNull(TAG_PSSYSUSERDRNAME2);
    }

    public final String getPSSYSUSERDRNAME2() {
        return this.getParamStringValue(TAG_PSSYSUSERDRNAME2, "");
    }

    public final void setPSSYSUSERDRNAME2(String strValue) {
        this.setParamValue(TAG_PSSYSUSERDRNAME2, strValue);
    }

    public final boolean isSYSUSERDRPARAMNull() {
        return this.isParamNull(TAG_SYSUSERDRPARAM);
    }

    public final String getSYSUSERDRPARAM() {
        return this.getParamStringValue(TAG_SYSUSERDRPARAM, "");
    }

    public final void setSYSUSERDRPARAM(String strValue) {
        this.setParamValue(TAG_SYSUSERDRPARAM, strValue);
    }

    public final boolean isSYSUSERDR2PARAMNull() {
        return this.isParamNull(TAG_SYSUSERDR2PARAM);
    }

    public final String getSYSUSERDR2PARAM() {
        return this.getParamStringValue(TAG_SYSUSERDR2PARAM, "");
    }

    public final void setSYSUSERDR2PARAM(String strValue) {
        this.setParamValue(TAG_SYSUSERDR2PARAM, strValue);
    }

    public final boolean isENABLECACHENull() {
        return this.isParamNull(TAG_ENABLECACHE);
    }

    public final boolean getENABLECACHE() {
        return this.getParamIntValue(TAG_ENABLECACHE, 0) == 1;
    }

    public final void setENABLECACHE(boolean bValue) {
        this.setParamValue(TAG_ENABLECACHE, bValue ? 1 : 0);
    }

    public final boolean isCACHESCOPENull() {
        return this.isParamNull(TAG_CACHESCOPE);
    }

    public final String getCACHESCOPE() {
        return this.getParamStringValue(TAG_CACHESCOPE, "");
    }

    public final void setCACHESCOPE(String strValue) {
        this.setParamValue(TAG_CACHESCOPE, strValue);
    }

    public final boolean isCACHEPSVARTYPEIDNull() {
        return this.isParamNull(TAG_CACHEPSVARTYPEID);
    }

    public final String getCACHEPSVARTYPEID() {
        return this.getParamStringValue(TAG_CACHEPSVARTYPEID, "");
    }

    public final void setCACHEPSVARTYPEID(String strValue) {
        this.setParamValue(TAG_CACHEPSVARTYPEID, strValue);
    }

    public final boolean isCACHEPSVARTYPENAMENull() {
        return this.isParamNull(TAG_CACHEPSVARTYPENAME);
    }

    public final String getCACHEPSVARTYPENAME() {
        return this.getParamStringValue(TAG_CACHEPSVARTYPENAME, "");
    }

    public final void setCACHEPSVARTYPENAME(String strValue) {
        this.setParamValue(TAG_CACHEPSVARTYPENAME, strValue);
    }

    public final boolean isCACHECONDVALUENull() {
        return this.isParamNull(TAG_CACHECONDVALUE);
    }

    public final String getCACHECONDVALUE() {
        return this.getParamStringValue(TAG_CACHECONDVALUE, "");
    }

    public final void setCACHECONDVALUE(String strValue) {
        this.setParamValue(TAG_CACHECONDVALUE, strValue);
    }

    public final boolean isCACHETIMEOUTNull() {
        return this.isParamNull(TAG_CACHETIMEOUT);
    }

    public final int getCACHETIMEOUT() {
        return this.getParamIntValue(TAG_CACHETIMEOUT, 0);
    }

    public final void setCACHETIMEOUT(int nValue) {
        this.setParamValue(TAG_CACHETIMEOUT, nValue);
    }

    public final boolean isMAJORPSDEFIDNull() {
        return this.isParamNull(TAG_MAJORPSDEFID);
    }

    public final String getMAJORPSDEFID() {
        return this.getParamStringValue(TAG_MAJORPSDEFID, "");
    }

    public final void setMAJORPSDEFID(String strValue) {
        this.setParamValue(TAG_MAJORPSDEFID, strValue);
    }

    public final boolean isMAJORPSDEFNAMENull() {
        return this.isParamNull(TAG_MAJORPSDEFNAME);
    }

    public final String getMAJORPSDEFNAME() {
        return this.getParamStringValue(TAG_MAJORPSDEFNAME, "");
    }

    public final void setMAJORPSDEFNAME(String strValue) {
        this.setParamValue(TAG_MAJORPSDEFNAME, strValue);
    }

    public final boolean isMINORPSDEFIDNull() {
        return this.isParamNull(TAG_MINORPSDEFID);
    }

    public final String getMINORPSDEFID() {
        return this.getParamStringValue(TAG_MINORPSDEFID, "");
    }

    public final void setMINORPSDEFID(String strValue) {
        this.setParamValue(TAG_MINORPSDEFID, strValue);
    }

    public final boolean isMINORPSDEFNAMENull() {
        return this.isParamNull(TAG_MINORPSDEFNAME);
    }

    public final String getMINORPSDEFNAME() {
        return this.getParamStringValue(TAG_MINORPSDEFNAME, "");
    }

    public final void setMINORPSDEFNAME(String strValue) {
        this.setParamValue(TAG_MINORPSDEFNAME, strValue);
    }

    public final boolean isMINORSORTDIRNull() {
        return this.isParamNull(TAG_MINORSORTDIR);
    }

    public final String getMINORSORTDIR() {
        return this.getParamStringValue(TAG_MINORSORTDIR, "");
    }

    public final void setMINORSORTDIR(String strValue) {
        this.setParamValue(TAG_MINORSORTDIR, strValue);
    }

    public final boolean isMAJORSORTDIRNull() {
        return this.isParamNull(TAG_MAJORSORTDIR);
    }

    public final String getMAJORSORTDIR() {
        return this.getParamStringValue(TAG_MAJORSORTDIR, "");
    }

    public final void setMAJORSORTDIR(String strValue) {
        this.setParamValue(TAG_MAJORSORTDIR, strValue);
    }

    public final boolean isPAGESIZENull() {
        return this.isParamNull(TAG_PAGESIZE);
    }

    public final int getPAGESIZE() {
        return this.getParamIntValue(TAG_PAGESIZE, 0);
    }

    public final void setPAGESIZE(int nValue) {
        this.setParamValue(TAG_PAGESIZE, nValue);
    }

    public final boolean isPSSYSUNISTATEIDNull() {
        return this.isParamNull(TAG_PSSYSUNISTATEID);
    }

    public final String getPSSYSUNISTATEID() {
        return this.getParamStringValue(TAG_PSSYSUNISTATEID, "");
    }

    public final void setPSSYSUNISTATEID(String strValue) {
        this.setParamValue(TAG_PSSYSUNISTATEID, strValue);
    }

    public final boolean isPSSYSUNISTATENAMENull() {
        return this.isParamNull(TAG_PSSYSUNISTATENAME);
    }

    public final String getPSSYSUNISTATENAME() {
        return this.getParamStringValue(TAG_PSSYSUNISTATENAME, "");
    }

    public final void setPSSYSUNISTATENAME(String strValue) {
        this.setParamValue(TAG_PSSYSUNISTATENAME, strValue);
    }

    public final boolean isCACHECHECKSTATENull() {
        return this.isParamNull(TAG_CACHECHECKSTATE);
    }

    public final String getCACHECHECKSTATE() {
        return this.getParamStringValue(TAG_CACHECHECKSTATE, "");
    }

    public final void setCACHECHECKSTATE(String strValue) {
        this.setParamValue(TAG_CACHECHECKSTATE, strValue);
    }

    public final boolean isCACHESTATEPSDELOGICIDNull() {
        return this.isParamNull(TAG_CACHESTATEPSDELOGICID);
    }

    public final String getCACHESTATEPSDELOGICID() {
        return this.getParamStringValue(TAG_CACHESTATEPSDELOGICID, "");
    }

    public final void setCACHESTATEPSDELOGICID(String strValue) {
        this.setParamValue(TAG_CACHESTATEPSDELOGICID, strValue);
    }

    public final boolean isCACHESTATEPSDELOGICNAMENull() {
        return this.isParamNull(TAG_CACHESTATEPSDELOGICNAME);
    }

    public final String getCACHESTATEPSDELOGICNAME() {
        return this.getParamStringValue(TAG_CACHESTATEPSDELOGICNAME, "");
    }

    public final void setCACHESTATEPSDELOGICNAME(String strValue) {
        this.setParamValue(TAG_CACHESTATEPSDELOGICNAME, strValue);
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

    public final boolean isADPSDELOGICIDNull() {
        return this.isParamNull(TAG_ADPSDELOGICID);
    }

    public final String getADPSDELOGICID() {
        return this.getParamStringValue(TAG_ADPSDELOGICID, "");
    }

    public final void setADPSDELOGICID(String strValue) {
        this.setParamValue(TAG_ADPSDELOGICID, strValue);
    }

    public final boolean isADPSDELOGICNAMENull() {
        return this.isParamNull(TAG_ADPSDELOGICNAME);
    }

    public final String getADPSDELOGICNAME() {
        return this.getParamStringValue(TAG_ADPSDELOGICNAME, "");
    }

    public final void setADPSDELOGICNAME(String strValue) {
        this.setParamValue(TAG_ADPSDELOGICNAME, strValue);
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

    public final boolean isREQUESTMETHODNull() {
        return this.isParamNull(TAG_REQUESTMETHOD);
    }

    public final String getREQUESTMETHOD() {
        return this.getParamStringValue(TAG_REQUESTMETHOD, "");
    }

    public final void setREQUESTMETHOD(String strValue) {
        this.setParamValue(TAG_REQUESTMETHOD, strValue);
    }

    public final boolean isENABLETEMPDATANull() {
        return this.isParamNull(TAG_ENABLETEMPDATA);
    }

    public final boolean getENABLETEMPDATA() {
        return this.getParamIntValue(TAG_ENABLETEMPDATA, 0) == 1;
    }

    public final void setENABLETEMPDATA(boolean bValue) {
        this.setParamValue(TAG_ENABLETEMPDATA, bValue ? 1 : 0);
    }
}

