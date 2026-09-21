/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.entity;

import java.util.Date;
import net.ibizsys.model.entity.BaseDataEntity;

public class PSACHandler
extends BaseDataEntity {
    public static final int CACHESCOPE_NONE = 0;
    public static final int CACHESCOPE_GLOBAL = 1;
    public static final int CACHESCOPE_ORG = 2;
    public static final int CACHESCOPE_USER = 3;
    public static final int CACHESCOPE_APP = 4;
    public static final String CTRLTYPE_GRID = "GRID";
    public static final String CTRLTYPE_FORM = "FORM";
    public static final String CTRLTYPE_SEARCHFORM = "SEARCHFORM";
    public static final String TAG_PSACHANDLERID = "PSACHANDLERID";
    public static final String TAG_PSACHANDLERNAME = "PSACHANDLERNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSSYSTEMID = "PSSYSTEMID";
    public static final String TAG_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String TAG_PSDEID = "PSDEID";
    public static final String TAG_PSDENAME = "PSDENAME";
    public static final String TAG_HANDLEROBJ = "HANDLEROBJ";
    public static final String TAG_PSSFACHANDLERID = "PSSFACHANDLERID";
    public static final String TAG_PSSFACHANDLERNAME = "PSSFACHANDLERNAME";
    public static final String TAG_CTRLTYPE = "CTRLTYPE";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_READPSDEOPPRIVID = "READPSDEOPPRIVID";
    public static final String TAG_READPSDEOPPRIVNAME = "READPSDEOPPRIVNAME";
    public static final String TAG_CREATEPSDEOPPRIVID = "CREATEPSDEOPPRIVID";
    public static final String TAG_CREATEPSDEOPPRIVINAME = "CREATEPSDEOPPRIVINAME";
    public static final String TAG_UPDATEPSDEOPPRIVID = "UPDATEPSDEOPPRIVID";
    public static final String TAG_UPDATEPSDEOPPRIVNAME = "UPDATEPSDEOPPRIVNAME";
    public static final String TAG_REMOVEPSDEOPPRIVID = "REMOVEPSDEOPPRIVID";
    public static final String TAG_REMOVEPSDEOPPRIVNAME = "REMOVEPSDEOPPRIVNAME";
    public static final String TAG_GETPSDEACTIONID = "GETPSDEACTIONID";
    public static final String TAG_GETPSDEACTIONNAME = "GETPSDEACTIONNAME";
    public static final String TAG_CREATEPSDEACTIONID = "CREATEPSDEACTIONID";
    public static final String TAG_CREATEPSDEACTIONNAME = "CREATEPSDEACTIONNAME";
    public static final String TAG_UPDATEPSDEACTIONID = "UPDATEPSDEACTIONID";
    public static final String TAG_UPDATEPSDEACTIONNAME = "UPDATEPSDEACTIONNAME";
    public static final String TAG_REMOVEPSDEACTIONID = "REMOVEPSDEACTIONID";
    public static final String TAG_REMOVEPSDEACTIONNAME = "REMOVEPSDEACTIONNAME";
    public static final String TAG_GETDRAFTPSDEACTIONID = "GETDRAFTPSDEACTIONID";
    public static final String TAG_GETDRAFTPSDEACTIONNAME = "GETDRAFTPSDEACTIONNAME";
    public static final String TAG_TEMPMODE = "TEMPMODE";
    public static final String TAG_HANDLERPARAMS = "HANDLERPARAMS";
    public static final String TAG_COPYPSDEACTIONID = "COPYPSDEACTIONID";
    public static final String TAG_COPYPSDEACTIONNAME = "COPYPSDEACTIONNAME";
    public static final String TAG_HANDLEROBJ2 = "HANDLEROBJ2";
    public static final String TAG_PSMODULEID = "PSMODULEID";
    public static final String TAG_PSMODULENAME = "PSMODULENAME";
    public static final String TAG_ENABLEORGDR = "ENABLEORGDR";
    public static final String TAG_ENABLESECDR = "ENABLESECDR";
    public static final String TAG_ENABLESECBC = "ENABLESECBC";
    public static final String TAG_ORGDR = "ORGDR";
    public static final String TAG_SECDR = "SECDR";
    public static final String TAG_SECBC = "SECBC";
    public static final String TAG_ENABLEUSERDR = "ENABLEUSERDR";
    public static final String TAG_GETTIMEOUT = "GETTIMEOUT";
    public static final String TAG_CREATETIMEOUT = "CREATETIMEOUT";
    public static final String TAG_UPDATETIMEOUT = "UPDATETIMEOUT";
    public static final String TAG_REMOVETIMEOUT = "REMOVETIMEOUT";
    public static final String TAG_PSSYSUSERDRID = "PSSYSUSERDRID";
    public static final String TAG_PSSYSUSERDRNAME = "PSSYSUSERDRNAME";
    public static final String TAG_PSSYSUSERDRID2 = "PSSYSUSERDRID2";
    public static final String TAG_PSSYSUSERDRNAME2 = "PSSYSUSERDRNAME2";
    public static final String TAG_SYSUSERDRPARAM = "SYSUSERDRPARAM";
    public static final String TAG_SYSUSERDR2PARAM = "SYSUSERDR2PARAM";
    public static final String TAG_ENABLECACHE = "ENABLECACHE";
    public static final String TAG_CACHESCOPE = "CACHESCOPE";
    public static final String TAG_CACHETIMEOUT = "CACHETIMEOUT";
    public static final String TAG_PSSYSUNISTATEID = "PSSYSUNISTATEID";
    public static final String TAG_PSSYSUNISTATENAME = "PSSYSUNISTATENAME";
    public static final String TAG_UNISTATEKEYVALUE = "UNISTATEKEYVALUE";
    public static final String TAG_UNISTATEFIELD = "UNISTATEFIELD";
    public static final String TAG_USERTAG = "USERTAG";
    public static final String TAG_USERTAG2 = "USERTAG2";
    public static final String TAG_USERTAG3 = "USERTAG3";
    public static final String TAG_USERTAG4 = "USERTAG4";
    public static final String TAG_EXPORTPSDEOPPRIVID = "EXPORTPSDEOPPRIVID";
    public static final String TAG_EXPORTPSDEOPPRIVINAME = "EXPORTPSDEOPPRIVINAME";
    public static final String TAG_PSSFID = "PSSFID";
    public static final String TAG_PSSFNAME = "PSSFNAME";
    public static final String TAG_FETCHTIMEOUT = "FETCHTIMEOUT";

    public final boolean isPSACHANDLERIDNull() {
        return this.isParamNull(TAG_PSACHANDLERID);
    }

    public final String getPSACHANDLERID() {
        return this.getParamStringValue(TAG_PSACHANDLERID, "");
    }

    public final void setPSACHANDLERID(String strValue) {
        this.setParamValue(TAG_PSACHANDLERID, strValue);
    }

    public final boolean isPSACHANDLERNAMENull() {
        return this.isParamNull(TAG_PSACHANDLERNAME);
    }

    public final String getPSACHANDLERNAME() {
        return this.getParamStringValue(TAG_PSACHANDLERNAME, "");
    }

    public final void setPSACHANDLERNAME(String strValue) {
        this.setParamValue(TAG_PSACHANDLERNAME, strValue);
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

    public final boolean isHANDLEROBJNull() {
        return this.isParamNull(TAG_HANDLEROBJ);
    }

    public final String getHANDLEROBJ() {
        return this.getParamStringValue(TAG_HANDLEROBJ, "");
    }

    public final void setHANDLEROBJ(String strValue) {
        this.setParamValue(TAG_HANDLEROBJ, strValue);
    }

    public final boolean isPSSFACHANDLERIDNull() {
        return this.isParamNull(TAG_PSSFACHANDLERID);
    }

    public final String getPSSFACHANDLERID() {
        return this.getParamStringValue(TAG_PSSFACHANDLERID, "");
    }

    public final void setPSSFACHANDLERID(String strValue) {
        this.setParamValue(TAG_PSSFACHANDLERID, strValue);
    }

    public final boolean isPSSFACHANDLERNAMENull() {
        return this.isParamNull(TAG_PSSFACHANDLERNAME);
    }

    public final String getPSSFACHANDLERNAME() {
        return this.getParamStringValue(TAG_PSSFACHANDLERNAME, "");
    }

    public final void setPSSFACHANDLERNAME(String strValue) {
        this.setParamValue(TAG_PSSFACHANDLERNAME, strValue);
    }

    public final boolean isCTRLTYPENull() {
        return this.isParamNull(TAG_CTRLTYPE);
    }

    public final String getCTRLTYPE() {
        return this.getParamStringValue(TAG_CTRLTYPE, "");
    }

    public final void setCTRLTYPE(String strValue) {
        this.setParamValue(TAG_CTRLTYPE, strValue);
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

    public final boolean isREADPSDEOPPRIVIDNull() {
        return this.isParamNull(TAG_READPSDEOPPRIVID);
    }

    public final String getREADPSDEOPPRIVID() {
        return this.getParamStringValue(TAG_READPSDEOPPRIVID, "");
    }

    public final void setREADPSDEOPPRIVID(String strValue) {
        this.setParamValue(TAG_READPSDEOPPRIVID, strValue);
    }

    public final boolean isREADPSDEOPPRIVNAMENull() {
        return this.isParamNull(TAG_READPSDEOPPRIVNAME);
    }

    public final String getREADPSDEOPPRIVNAME() {
        return this.getParamStringValue(TAG_READPSDEOPPRIVNAME, "");
    }

    public final void setREADPSDEOPPRIVNAME(String strValue) {
        this.setParamValue(TAG_READPSDEOPPRIVNAME, strValue);
    }

    public final boolean isCREATEPSDEOPPRIVIDNull() {
        return this.isParamNull(TAG_CREATEPSDEOPPRIVID);
    }

    public final String getCREATEPSDEOPPRIVID() {
        return this.getParamStringValue(TAG_CREATEPSDEOPPRIVID, "");
    }

    public final void setCREATEPSDEOPPRIVID(String strValue) {
        this.setParamValue(TAG_CREATEPSDEOPPRIVID, strValue);
    }

    public final boolean isCREATEPSDEOPPRIVINAMENull() {
        return this.isParamNull(TAG_CREATEPSDEOPPRIVINAME);
    }

    public final String getCREATEPSDEOPPRIVINAME() {
        return this.getParamStringValue(TAG_CREATEPSDEOPPRIVINAME, "");
    }

    public final void setCREATEPSDEOPPRIVINAME(String strValue) {
        this.setParamValue(TAG_CREATEPSDEOPPRIVINAME, strValue);
    }

    public final boolean isUPDATEPSDEOPPRIVIDNull() {
        return this.isParamNull(TAG_UPDATEPSDEOPPRIVID);
    }

    public final String getUPDATEPSDEOPPRIVID() {
        return this.getParamStringValue(TAG_UPDATEPSDEOPPRIVID, "");
    }

    public final void setUPDATEPSDEOPPRIVID(String strValue) {
        this.setParamValue(TAG_UPDATEPSDEOPPRIVID, strValue);
    }

    public final boolean isUPDATEPSDEOPPRIVNAMENull() {
        return this.isParamNull(TAG_UPDATEPSDEOPPRIVNAME);
    }

    public final String getUPDATEPSDEOPPRIVNAME() {
        return this.getParamStringValue(TAG_UPDATEPSDEOPPRIVNAME, "");
    }

    public final void setUPDATEPSDEOPPRIVNAME(String strValue) {
        this.setParamValue(TAG_UPDATEPSDEOPPRIVNAME, strValue);
    }

    public final boolean isREMOVEPSDEOPPRIVIDNull() {
        return this.isParamNull(TAG_REMOVEPSDEOPPRIVID);
    }

    public final String getREMOVEPSDEOPPRIVID() {
        return this.getParamStringValue(TAG_REMOVEPSDEOPPRIVID, "");
    }

    public final void setREMOVEPSDEOPPRIVID(String strValue) {
        this.setParamValue(TAG_REMOVEPSDEOPPRIVID, strValue);
    }

    public final boolean isREMOVEPSDEOPPRIVNAMENull() {
        return this.isParamNull(TAG_REMOVEPSDEOPPRIVNAME);
    }

    public final String getREMOVEPSDEOPPRIVNAME() {
        return this.getParamStringValue(TAG_REMOVEPSDEOPPRIVNAME, "");
    }

    public final void setREMOVEPSDEOPPRIVNAME(String strValue) {
        this.setParamValue(TAG_REMOVEPSDEOPPRIVNAME, strValue);
    }

    public final boolean isGETPSDEACTIONIDNull() {
        return this.isParamNull(TAG_GETPSDEACTIONID);
    }

    public final String getGETPSDEACTIONID() {
        return this.getParamStringValue(TAG_GETPSDEACTIONID, "");
    }

    public final void setGETPSDEACTIONID(String strValue) {
        this.setParamValue(TAG_GETPSDEACTIONID, strValue);
    }

    public final boolean isGETPSDEACTIONNAMENull() {
        return this.isParamNull(TAG_GETPSDEACTIONNAME);
    }

    public final String getGETPSDEACTIONNAME() {
        return this.getParamStringValue(TAG_GETPSDEACTIONNAME, "");
    }

    public final void setGETPSDEACTIONNAME(String strValue) {
        this.setParamValue(TAG_GETPSDEACTIONNAME, strValue);
    }

    public final boolean isCREATEPSDEACTIONIDNull() {
        return this.isParamNull(TAG_CREATEPSDEACTIONID);
    }

    public final String getCREATEPSDEACTIONID() {
        return this.getParamStringValue(TAG_CREATEPSDEACTIONID, "");
    }

    public final void setCREATEPSDEACTIONID(String strValue) {
        this.setParamValue(TAG_CREATEPSDEACTIONID, strValue);
    }

    public final boolean isCREATEPSDEACTIONNAMENull() {
        return this.isParamNull(TAG_CREATEPSDEACTIONNAME);
    }

    public final String getCREATEPSDEACTIONNAME() {
        return this.getParamStringValue(TAG_CREATEPSDEACTIONNAME, "");
    }

    public final void setCREATEPSDEACTIONNAME(String strValue) {
        this.setParamValue(TAG_CREATEPSDEACTIONNAME, strValue);
    }

    public final boolean isUPDATEPSDEACTIONIDNull() {
        return this.isParamNull(TAG_UPDATEPSDEACTIONID);
    }

    public final String getUPDATEPSDEACTIONID() {
        return this.getParamStringValue(TAG_UPDATEPSDEACTIONID, "");
    }

    public final void setUPDATEPSDEACTIONID(String strValue) {
        this.setParamValue(TAG_UPDATEPSDEACTIONID, strValue);
    }

    public final boolean isUPDATEPSDEACTIONNAMENull() {
        return this.isParamNull(TAG_UPDATEPSDEACTIONNAME);
    }

    public final String getUPDATEPSDEACTIONNAME() {
        return this.getParamStringValue(TAG_UPDATEPSDEACTIONNAME, "");
    }

    public final void setUPDATEPSDEACTIONNAME(String strValue) {
        this.setParamValue(TAG_UPDATEPSDEACTIONNAME, strValue);
    }

    public final boolean isREMOVEPSDEACTIONIDNull() {
        return this.isParamNull(TAG_REMOVEPSDEACTIONID);
    }

    public final String getREMOVEPSDEACTIONID() {
        return this.getParamStringValue(TAG_REMOVEPSDEACTIONID, "");
    }

    public final void setREMOVEPSDEACTIONID(String strValue) {
        this.setParamValue(TAG_REMOVEPSDEACTIONID, strValue);
    }

    public final boolean isREMOVEPSDEACTIONNAMENull() {
        return this.isParamNull(TAG_REMOVEPSDEACTIONNAME);
    }

    public final String getREMOVEPSDEACTIONNAME() {
        return this.getParamStringValue(TAG_REMOVEPSDEACTIONNAME, "");
    }

    public final void setREMOVEPSDEACTIONNAME(String strValue) {
        this.setParamValue(TAG_REMOVEPSDEACTIONNAME, strValue);
    }

    public final boolean isGETDRAFTPSDEACTIONIDNull() {
        return this.isParamNull(TAG_GETDRAFTPSDEACTIONID);
    }

    public final String getGETDRAFTPSDEACTIONID() {
        return this.getParamStringValue(TAG_GETDRAFTPSDEACTIONID, "");
    }

    public final void setGETDRAFTPSDEACTIONID(String strValue) {
        this.setParamValue(TAG_GETDRAFTPSDEACTIONID, strValue);
    }

    public final boolean isGETDRAFTPSDEACTIONNAMENull() {
        return this.isParamNull(TAG_GETDRAFTPSDEACTIONNAME);
    }

    public final String getGETDRAFTPSDEACTIONNAME() {
        return this.getParamStringValue(TAG_GETDRAFTPSDEACTIONNAME, "");
    }

    public final void setGETDRAFTPSDEACTIONNAME(String strValue) {
        this.setParamValue(TAG_GETDRAFTPSDEACTIONNAME, strValue);
    }

    public final boolean isTEMPMODENull() {
        return this.isParamNull(TAG_TEMPMODE);
    }

    public final int getTEMPMODE() {
        return this.getParamIntValue(TAG_TEMPMODE, 0);
    }

    public final void setTEMPMODE(int nValue) {
        this.setParamValue(TAG_TEMPMODE, nValue);
    }

    public final boolean isHANDLERPARAMSNull() {
        return this.isParamNull(TAG_HANDLERPARAMS);
    }

    public final String getHANDLERPARAMS() {
        return this.getParamStringValue(TAG_HANDLERPARAMS, "");
    }

    public final void setHANDLERPARAMS(String strValue) {
        this.setParamValue(TAG_HANDLERPARAMS, strValue);
    }

    public final boolean isCOPYPSDEACTIONIDNull() {
        return this.isParamNull(TAG_COPYPSDEACTIONID);
    }

    public final String getCOPYPSDEACTIONID() {
        return this.getParamStringValue(TAG_COPYPSDEACTIONID, "");
    }

    public final void setCOPYPSDEACTIONID(String strValue) {
        this.setParamValue(TAG_COPYPSDEACTIONID, strValue);
    }

    public final boolean isCOPYPSDEACTIONNAMENull() {
        return this.isParamNull(TAG_COPYPSDEACTIONNAME);
    }

    public final String getCOPYPSDEACTIONNAME() {
        return this.getParamStringValue(TAG_COPYPSDEACTIONNAME, "");
    }

    public final void setCOPYPSDEACTIONNAME(String strValue) {
        this.setParamValue(TAG_COPYPSDEACTIONNAME, strValue);
    }

    public final boolean isHANDLEROBJ2Null() {
        return this.isParamNull(TAG_HANDLEROBJ2);
    }

    public final String getHANDLEROBJ2() {
        return this.getParamStringValue(TAG_HANDLEROBJ2, "");
    }

    public final void setHANDLEROBJ2(String strValue) {
        this.setParamValue(TAG_HANDLEROBJ2, strValue);
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

    public final boolean isORGDRNull() {
        return this.isParamNull(TAG_ORGDR);
    }

    public final int getORGDR() {
        return this.getParamIntValue(TAG_ORGDR, 0);
    }

    public final void setORGDR(int nValue) {
        this.setParamValue(TAG_ORGDR, nValue);
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

    public final boolean isENABLEUSERDRNull() {
        return this.isParamNull(TAG_ENABLEUSERDR);
    }

    public final boolean getENABLEUSERDR() {
        return this.getParamIntValue(TAG_ENABLEUSERDR, 0) == 1;
    }

    public final void setENABLEUSERDR(boolean bValue) {
        this.setParamValue(TAG_ENABLEUSERDR, bValue ? 1 : 0);
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

    public final boolean isGETTIMEOUTNull() {
        return this.isParamNull(TAG_GETTIMEOUT);
    }

    public final int getGETTIMEOUT() {
        return this.getParamIntValue(TAG_GETTIMEOUT, 0);
    }

    public final void setGETTIMEOUT(int nValue) {
        this.setParamValue(TAG_GETTIMEOUT, nValue);
    }

    public final boolean isCREATETIMEOUTNull() {
        return this.isParamNull(TAG_CREATETIMEOUT);
    }

    public final int getCREATETIMEOUT() {
        return this.getParamIntValue(TAG_CREATETIMEOUT, 0);
    }

    public final void setCREATETIMEOUT(int nValue) {
        this.setParamValue(TAG_CREATETIMEOUT, nValue);
    }

    public final boolean isUPDATETIMEOUTNull() {
        return this.isParamNull(TAG_UPDATETIMEOUT);
    }

    public final int getUPDATETIMEOUT() {
        return this.getParamIntValue(TAG_UPDATETIMEOUT, 0);
    }

    public final void setUPDATETIMEOUT(int nValue) {
        this.setParamValue(TAG_UPDATETIMEOUT, nValue);
    }

    public final boolean isREMOVETIMEOUTNull() {
        return this.isParamNull(TAG_REMOVETIMEOUT);
    }

    public final int getREMOVETIMEOUT() {
        return this.getParamIntValue(TAG_REMOVETIMEOUT, 0);
    }

    public final void setREMOVETIMEOUT(int nValue) {
        this.setParamValue(TAG_REMOVETIMEOUT, nValue);
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

    public final int getCACHESCOPE() {
        return this.getParamIntValue(TAG_CACHESCOPE, 0);
    }

    public final void setCACHESCOPE(int nValue) {
        this.setParamValue(TAG_CACHESCOPE, nValue);
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

    public final boolean isUNISTATEKEYVALUENull() {
        return this.isParamNull(TAG_UNISTATEKEYVALUE);
    }

    public final String getUNISTATEKEYVALUE() {
        return this.getParamStringValue(TAG_UNISTATEKEYVALUE, "");
    }

    public final void setUNISTATEKEYVALUE(String strValue) {
        this.setParamValue(TAG_UNISTATEKEYVALUE, strValue);
    }

    public final boolean isUNISTATEFIELDNull() {
        return this.isParamNull(TAG_UNISTATEFIELD);
    }

    public final String getUNISTATEFIELD() {
        return this.getParamStringValue(TAG_UNISTATEFIELD, "");
    }

    public final void setUNISTATEFIELD(String strValue) {
        this.setParamValue(TAG_UNISTATEFIELD, strValue);
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

    public final boolean isUSERTAG3Null() {
        return this.isParamNull(TAG_USERTAG3);
    }

    public final String getUSERTAG3() {
        return this.getParamStringValue(TAG_USERTAG3, "");
    }

    public final void setUSERTAG3(String strValue) {
        this.setParamValue(TAG_USERTAG3, strValue);
    }

    public final boolean isUSERTAG4Null() {
        return this.isParamNull(TAG_USERTAG4);
    }

    public final String getUSERTAG4() {
        return this.getParamStringValue(TAG_USERTAG4, "");
    }

    public final void setUSERTAG4(String strValue) {
        this.setParamValue(TAG_USERTAG4, strValue);
    }

    public final boolean isEXPORTPSDEOPPRIVIDNull() {
        return this.isParamNull(TAG_EXPORTPSDEOPPRIVID);
    }

    public final String getEXPORTPSDEOPPRIVID() {
        return this.getParamStringValue(TAG_EXPORTPSDEOPPRIVID, "");
    }

    public final void setEXPORTPSDEOPPRIVID(String strValue) {
        this.setParamValue(TAG_EXPORTPSDEOPPRIVID, strValue);
    }

    public final boolean isEXPORTPSDEOPPRIVINAMENull() {
        return this.isParamNull(TAG_EXPORTPSDEOPPRIVINAME);
    }

    public final String getEXPORTPSDEOPPRIVINAME() {
        return this.getParamStringValue(TAG_EXPORTPSDEOPPRIVINAME, "");
    }

    public final void setEXPORTPSDEOPPRIVINAME(String strValue) {
        this.setParamValue(TAG_EXPORTPSDEOPPRIVINAME, strValue);
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

    public final boolean isFETCHTIMEOUTNull() {
        return this.isParamNull(TAG_FETCHTIMEOUT);
    }

    public final int getFETCHTIMEOUT() {
        return this.getParamIntValue(TAG_FETCHTIMEOUT, 0);
    }

    public final void setFETCHTIMEOUT(int nValue) {
        this.setParamValue(TAG_FETCHTIMEOUT, nValue);
    }
}

