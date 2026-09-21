/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

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
    public static final String TAG_CODENAME = "CODENAME";
    public static final String TAG_USERCAT = "USERCAT";
    public static final String TAG_USERPSDEACTIONID = "USERPSDEACTIONID";
    public static final String TAG_USERPSDEACTIONNAME = "USERPSDEACTIONNAME";
    public static final String TAG_USER2PSDEACTIONID = "USER2PSDEACTIONID";
    public static final String TAG_USER2PSDEACTIONNAME = "USER2PSDEACTIONNAME";
    public static final String TAG_USERPSDEOPPRIVID = "USERPSDEOPPRIVID";
    public static final String TAG_USERPSDEOPPRIVINAME = "USERPSDEOPPRIVINAME";
    public static final String TAG_USER2PSDEOPPRIVID = "USER2PSDEOPPRIVID";
    public static final String TAG_USER2PSDEOPPRIVINAME = "USER2PSDEOPPRIVINAME";
    public static final String TAG_HANDLERTAG = "HANDLERTAG";
    public static final String TAG_HANDLERTAG2 = "HANDLERTAG2";
    public static final String TAG_CUSTOMCOND = "CUSTOMCOND";
    public static final String TAG_MOVEPSDEACTIONID = "MOVEPSDEACTIONID";
    public static final String TAG_MOVEPSDEACTIONNAME = "MOVEPSDEACTIONNAME";
    public static final String TAG_CUSTOMTYPE = "CUSTOMTYPE";
    public static final String TAG_GROUPPSDEID = "GROUPPSDEID";
    public static final String TAG_GROUPPSDENAME = "GROUPPSDENAME";
    public static final String TAG_GROUPMOVEPSDEACTIONID = "GROUPMOVEPSDEACTIONID";
    public static final String TAG_GROUPMOVEPSDEACTIONNAME = "GROUPMOVEPSDEACTIONNAME";

    public final boolean isPSACHANDLERIDNull() {
        return this.IsParamNull(TAG_PSACHANDLERID);
    }

    public final String getPSACHANDLERID() {
        return this.GetParamStringValue(TAG_PSACHANDLERID, "");
    }

    public final void setPSACHANDLERID(String strValue) {
        this.SetParamValue(TAG_PSACHANDLERID, strValue);
    }

    public final boolean isPSACHANDLERNAMENull() {
        return this.IsParamNull(TAG_PSACHANDLERNAME);
    }

    public final String getPSACHANDLERNAME() {
        return this.GetParamStringValue(TAG_PSACHANDLERNAME, "");
    }

    public final void setPSACHANDLERNAME(String strValue) {
        this.SetParamValue(TAG_PSACHANDLERNAME, strValue);
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

    public final boolean isHANDLEROBJNull() {
        return this.IsParamNull(TAG_HANDLEROBJ);
    }

    public final String getHANDLEROBJ() {
        return this.GetParamStringValue(TAG_HANDLEROBJ, "");
    }

    public final void setHANDLEROBJ(String strValue) {
        this.SetParamValue(TAG_HANDLEROBJ, strValue);
    }

    public final boolean isPSSFACHANDLERIDNull() {
        return this.IsParamNull(TAG_PSSFACHANDLERID);
    }

    public final String getPSSFACHANDLERID() {
        return this.GetParamStringValue(TAG_PSSFACHANDLERID, "");
    }

    public final void setPSSFACHANDLERID(String strValue) {
        this.SetParamValue(TAG_PSSFACHANDLERID, strValue);
    }

    public final boolean isPSSFACHANDLERNAMENull() {
        return this.IsParamNull(TAG_PSSFACHANDLERNAME);
    }

    public final String getPSSFACHANDLERNAME() {
        return this.GetParamStringValue(TAG_PSSFACHANDLERNAME, "");
    }

    public final void setPSSFACHANDLERNAME(String strValue) {
        this.SetParamValue(TAG_PSSFACHANDLERNAME, strValue);
    }

    public final boolean isCTRLTYPENull() {
        return this.IsParamNull(TAG_CTRLTYPE);
    }

    public final String getCTRLTYPE() {
        return this.GetParamStringValue(TAG_CTRLTYPE, "");
    }

    public final void setCTRLTYPE(String strValue) {
        this.SetParamValue(TAG_CTRLTYPE, strValue);
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

    public final boolean isREADPSDEOPPRIVIDNull() {
        return this.IsParamNull(TAG_READPSDEOPPRIVID);
    }

    public final String getREADPSDEOPPRIVID() {
        return this.GetParamStringValue(TAG_READPSDEOPPRIVID, "");
    }

    public final void setREADPSDEOPPRIVID(String strValue) {
        this.SetParamValue(TAG_READPSDEOPPRIVID, strValue);
    }

    public final boolean isREADPSDEOPPRIVNAMENull() {
        return this.IsParamNull(TAG_READPSDEOPPRIVNAME);
    }

    public final String getREADPSDEOPPRIVNAME() {
        return this.GetParamStringValue(TAG_READPSDEOPPRIVNAME, "");
    }

    public final void setREADPSDEOPPRIVNAME(String strValue) {
        this.SetParamValue(TAG_READPSDEOPPRIVNAME, strValue);
    }

    public final boolean isCREATEPSDEOPPRIVIDNull() {
        return this.IsParamNull(TAG_CREATEPSDEOPPRIVID);
    }

    public final String getCREATEPSDEOPPRIVID() {
        return this.GetParamStringValue(TAG_CREATEPSDEOPPRIVID, "");
    }

    public final void setCREATEPSDEOPPRIVID(String strValue) {
        this.SetParamValue(TAG_CREATEPSDEOPPRIVID, strValue);
    }

    public final boolean isCREATEPSDEOPPRIVINAMENull() {
        return this.IsParamNull(TAG_CREATEPSDEOPPRIVINAME);
    }

    public final String getCREATEPSDEOPPRIVINAME() {
        return this.GetParamStringValue(TAG_CREATEPSDEOPPRIVINAME, "");
    }

    public final void setCREATEPSDEOPPRIVINAME(String strValue) {
        this.SetParamValue(TAG_CREATEPSDEOPPRIVINAME, strValue);
    }

    public final boolean isUPDATEPSDEOPPRIVIDNull() {
        return this.IsParamNull(TAG_UPDATEPSDEOPPRIVID);
    }

    public final String getUPDATEPSDEOPPRIVID() {
        return this.GetParamStringValue(TAG_UPDATEPSDEOPPRIVID, "");
    }

    public final void setUPDATEPSDEOPPRIVID(String strValue) {
        this.SetParamValue(TAG_UPDATEPSDEOPPRIVID, strValue);
    }

    public final boolean isUPDATEPSDEOPPRIVNAMENull() {
        return this.IsParamNull(TAG_UPDATEPSDEOPPRIVNAME);
    }

    public final String getUPDATEPSDEOPPRIVNAME() {
        return this.GetParamStringValue(TAG_UPDATEPSDEOPPRIVNAME, "");
    }

    public final void setUPDATEPSDEOPPRIVNAME(String strValue) {
        this.SetParamValue(TAG_UPDATEPSDEOPPRIVNAME, strValue);
    }

    public final boolean isREMOVEPSDEOPPRIVIDNull() {
        return this.IsParamNull(TAG_REMOVEPSDEOPPRIVID);
    }

    public final String getREMOVEPSDEOPPRIVID() {
        return this.GetParamStringValue(TAG_REMOVEPSDEOPPRIVID, "");
    }

    public final void setREMOVEPSDEOPPRIVID(String strValue) {
        this.SetParamValue(TAG_REMOVEPSDEOPPRIVID, strValue);
    }

    public final boolean isREMOVEPSDEOPPRIVNAMENull() {
        return this.IsParamNull(TAG_REMOVEPSDEOPPRIVNAME);
    }

    public final String getREMOVEPSDEOPPRIVNAME() {
        return this.GetParamStringValue(TAG_REMOVEPSDEOPPRIVNAME, "");
    }

    public final void setREMOVEPSDEOPPRIVNAME(String strValue) {
        this.SetParamValue(TAG_REMOVEPSDEOPPRIVNAME, strValue);
    }

    public final boolean isGETPSDEACTIONIDNull() {
        return this.IsParamNull(TAG_GETPSDEACTIONID);
    }

    public final String getGETPSDEACTIONID() {
        return this.GetParamStringValue(TAG_GETPSDEACTIONID, "");
    }

    public final void setGETPSDEACTIONID(String strValue) {
        this.SetParamValue(TAG_GETPSDEACTIONID, strValue);
    }

    public final boolean isGETPSDEACTIONNAMENull() {
        return this.IsParamNull(TAG_GETPSDEACTIONNAME);
    }

    public final String getGETPSDEACTIONNAME() {
        return this.GetParamStringValue(TAG_GETPSDEACTIONNAME, "");
    }

    public final void setGETPSDEACTIONNAME(String strValue) {
        this.SetParamValue(TAG_GETPSDEACTIONNAME, strValue);
    }

    public final boolean isCREATEPSDEACTIONIDNull() {
        return this.IsParamNull(TAG_CREATEPSDEACTIONID);
    }

    public final String getCREATEPSDEACTIONID() {
        return this.GetParamStringValue(TAG_CREATEPSDEACTIONID, "");
    }

    public final void setCREATEPSDEACTIONID(String strValue) {
        this.SetParamValue(TAG_CREATEPSDEACTIONID, strValue);
    }

    public final boolean isCREATEPSDEACTIONNAMENull() {
        return this.IsParamNull(TAG_CREATEPSDEACTIONNAME);
    }

    public final String getCREATEPSDEACTIONNAME() {
        return this.GetParamStringValue(TAG_CREATEPSDEACTIONNAME, "");
    }

    public final void setCREATEPSDEACTIONNAME(String strValue) {
        this.SetParamValue(TAG_CREATEPSDEACTIONNAME, strValue);
    }

    public final boolean isUPDATEPSDEACTIONIDNull() {
        return this.IsParamNull(TAG_UPDATEPSDEACTIONID);
    }

    public final String getUPDATEPSDEACTIONID() {
        return this.GetParamStringValue(TAG_UPDATEPSDEACTIONID, "");
    }

    public final void setUPDATEPSDEACTIONID(String strValue) {
        this.SetParamValue(TAG_UPDATEPSDEACTIONID, strValue);
    }

    public final boolean isUPDATEPSDEACTIONNAMENull() {
        return this.IsParamNull(TAG_UPDATEPSDEACTIONNAME);
    }

    public final String getUPDATEPSDEACTIONNAME() {
        return this.GetParamStringValue(TAG_UPDATEPSDEACTIONNAME, "");
    }

    public final void setUPDATEPSDEACTIONNAME(String strValue) {
        this.SetParamValue(TAG_UPDATEPSDEACTIONNAME, strValue);
    }

    public final boolean isREMOVEPSDEACTIONIDNull() {
        return this.IsParamNull(TAG_REMOVEPSDEACTIONID);
    }

    public final String getREMOVEPSDEACTIONID() {
        return this.GetParamStringValue(TAG_REMOVEPSDEACTIONID, "");
    }

    public final void setREMOVEPSDEACTIONID(String strValue) {
        this.SetParamValue(TAG_REMOVEPSDEACTIONID, strValue);
    }

    public final boolean isREMOVEPSDEACTIONNAMENull() {
        return this.IsParamNull(TAG_REMOVEPSDEACTIONNAME);
    }

    public final String getREMOVEPSDEACTIONNAME() {
        return this.GetParamStringValue(TAG_REMOVEPSDEACTIONNAME, "");
    }

    public final void setREMOVEPSDEACTIONNAME(String strValue) {
        this.SetParamValue(TAG_REMOVEPSDEACTIONNAME, strValue);
    }

    public final boolean isGETDRAFTPSDEACTIONIDNull() {
        return this.IsParamNull(TAG_GETDRAFTPSDEACTIONID);
    }

    public final String getGETDRAFTPSDEACTIONID() {
        return this.GetParamStringValue(TAG_GETDRAFTPSDEACTIONID, "");
    }

    public final void setGETDRAFTPSDEACTIONID(String strValue) {
        this.SetParamValue(TAG_GETDRAFTPSDEACTIONID, strValue);
    }

    public final boolean isGETDRAFTPSDEACTIONNAMENull() {
        return this.IsParamNull(TAG_GETDRAFTPSDEACTIONNAME);
    }

    public final String getGETDRAFTPSDEACTIONNAME() {
        return this.GetParamStringValue(TAG_GETDRAFTPSDEACTIONNAME, "");
    }

    public final void setGETDRAFTPSDEACTIONNAME(String strValue) {
        this.SetParamValue(TAG_GETDRAFTPSDEACTIONNAME, strValue);
    }

    public final boolean isTEMPMODENull() {
        return this.IsParamNull(TAG_TEMPMODE);
    }

    public final int getTEMPMODE() {
        return this.GetParamIntValue(TAG_TEMPMODE, 0);
    }

    public final void setTEMPMODE(int nValue) {
        this.SetParamValue(TAG_TEMPMODE, nValue);
    }

    public final boolean isHANDLERPARAMSNull() {
        return this.IsParamNull(TAG_HANDLERPARAMS);
    }

    public final String getHANDLERPARAMS() {
        return this.GetParamStringValue(TAG_HANDLERPARAMS, "");
    }

    public final void setHANDLERPARAMS(String strValue) {
        this.SetParamValue(TAG_HANDLERPARAMS, strValue);
    }

    public final boolean isCOPYPSDEACTIONIDNull() {
        return this.IsParamNull(TAG_COPYPSDEACTIONID);
    }

    public final String getCOPYPSDEACTIONID() {
        return this.GetParamStringValue(TAG_COPYPSDEACTIONID, "");
    }

    public final void setCOPYPSDEACTIONID(String strValue) {
        this.SetParamValue(TAG_COPYPSDEACTIONID, strValue);
    }

    public final boolean isCOPYPSDEACTIONNAMENull() {
        return this.IsParamNull(TAG_COPYPSDEACTIONNAME);
    }

    public final String getCOPYPSDEACTIONNAME() {
        return this.GetParamStringValue(TAG_COPYPSDEACTIONNAME, "");
    }

    public final void setCOPYPSDEACTIONNAME(String strValue) {
        this.SetParamValue(TAG_COPYPSDEACTIONNAME, strValue);
    }

    public final boolean isHANDLEROBJ2Null() {
        return this.IsParamNull(TAG_HANDLEROBJ2);
    }

    public final String getHANDLEROBJ2() {
        return this.GetParamStringValue(TAG_HANDLEROBJ2, "");
    }

    public final void setHANDLEROBJ2(String strValue) {
        this.SetParamValue(TAG_HANDLEROBJ2, strValue);
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

    public final boolean isORGDRNull() {
        return this.IsParamNull(TAG_ORGDR);
    }

    public final int getORGDR() {
        return this.GetParamIntValue(TAG_ORGDR, 0);
    }

    public final void setORGDR(int nValue) {
        this.SetParamValue(TAG_ORGDR, nValue);
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

    public final boolean isENABLEUSERDRNull() {
        return this.IsParamNull(TAG_ENABLEUSERDR);
    }

    public final boolean getENABLEUSERDR() {
        return this.GetParamIntValue(TAG_ENABLEUSERDR, 0) == 1;
    }

    public final void setENABLEUSERDR(boolean bValue) {
        this.SetParamValue(TAG_ENABLEUSERDR, bValue ? 1 : 0);
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

    public final boolean isGETTIMEOUTNull() {
        return this.IsParamNull(TAG_GETTIMEOUT);
    }

    public final int getGETTIMEOUT() {
        return this.GetParamIntValue(TAG_GETTIMEOUT, 0);
    }

    public final void setGETTIMEOUT(int nValue) {
        this.SetParamValue(TAG_GETTIMEOUT, nValue);
    }

    public final boolean isCREATETIMEOUTNull() {
        return this.IsParamNull(TAG_CREATETIMEOUT);
    }

    public final int getCREATETIMEOUT() {
        return this.GetParamIntValue(TAG_CREATETIMEOUT, 0);
    }

    public final void setCREATETIMEOUT(int nValue) {
        this.SetParamValue(TAG_CREATETIMEOUT, nValue);
    }

    public final boolean isUPDATETIMEOUTNull() {
        return this.IsParamNull(TAG_UPDATETIMEOUT);
    }

    public final int getUPDATETIMEOUT() {
        return this.GetParamIntValue(TAG_UPDATETIMEOUT, 0);
    }

    public final void setUPDATETIMEOUT(int nValue) {
        this.SetParamValue(TAG_UPDATETIMEOUT, nValue);
    }

    public final boolean isREMOVETIMEOUTNull() {
        return this.IsParamNull(TAG_REMOVETIMEOUT);
    }

    public final int getREMOVETIMEOUT() {
        return this.GetParamIntValue(TAG_REMOVETIMEOUT, 0);
    }

    public final void setREMOVETIMEOUT(int nValue) {
        this.SetParamValue(TAG_REMOVETIMEOUT, nValue);
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

    public final int getCACHESCOPE() {
        return this.GetParamIntValue(TAG_CACHESCOPE, 0);
    }

    public final void setCACHESCOPE(int nValue) {
        this.SetParamValue(TAG_CACHESCOPE, nValue);
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

    public final boolean isUNISTATEKEYVALUENull() {
        return this.IsParamNull(TAG_UNISTATEKEYVALUE);
    }

    public final String getUNISTATEKEYVALUE() {
        return this.GetParamStringValue(TAG_UNISTATEKEYVALUE, "");
    }

    public final void setUNISTATEKEYVALUE(String strValue) {
        this.SetParamValue(TAG_UNISTATEKEYVALUE, strValue);
    }

    public final boolean isUNISTATEFIELDNull() {
        return this.IsParamNull(TAG_UNISTATEFIELD);
    }

    public final String getUNISTATEFIELD() {
        return this.GetParamStringValue(TAG_UNISTATEFIELD, "");
    }

    public final void setUNISTATEFIELD(String strValue) {
        this.SetParamValue(TAG_UNISTATEFIELD, strValue);
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

    public final boolean isEXPORTPSDEOPPRIVIDNull() {
        return this.IsParamNull(TAG_EXPORTPSDEOPPRIVID);
    }

    public final String getEXPORTPSDEOPPRIVID() {
        return this.GetParamStringValue(TAG_EXPORTPSDEOPPRIVID, "");
    }

    public final void setEXPORTPSDEOPPRIVID(String strValue) {
        this.SetParamValue(TAG_EXPORTPSDEOPPRIVID, strValue);
    }

    public final boolean isEXPORTPSDEOPPRIVINAMENull() {
        return this.IsParamNull(TAG_EXPORTPSDEOPPRIVINAME);
    }

    public final String getEXPORTPSDEOPPRIVINAME() {
        return this.GetParamStringValue(TAG_EXPORTPSDEOPPRIVINAME, "");
    }

    public final void setEXPORTPSDEOPPRIVINAME(String strValue) {
        this.SetParamValue(TAG_EXPORTPSDEOPPRIVINAME, strValue);
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

    public final boolean isFETCHTIMEOUTNull() {
        return this.IsParamNull(TAG_FETCHTIMEOUT);
    }

    public final int getFETCHTIMEOUT() {
        return this.GetParamIntValue(TAG_FETCHTIMEOUT, 0);
    }

    public final void setFETCHTIMEOUT(int nValue) {
        this.SetParamValue(TAG_FETCHTIMEOUT, nValue);
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

    public final boolean isUSERCATNull() {
        return this.IsParamNull(TAG_USERCAT);
    }

    public final String getUSERCAT() {
        return this.GetParamStringValue(TAG_USERCAT, "");
    }

    public final void setUSERCAT(String strValue) {
        this.SetParamValue(TAG_USERCAT, strValue);
    }

    public final boolean isUSERPSDEACTIONIDNull() {
        return this.IsParamNull(TAG_USERPSDEACTIONID);
    }

    public final String getUSERPSDEACTIONID() {
        return this.GetParamStringValue(TAG_USERPSDEACTIONID, "");
    }

    public final void setUSERPSDEACTIONID(String strValue) {
        this.SetParamValue(TAG_USERPSDEACTIONID, strValue);
    }

    public final boolean isUSERPSDEACTIONNAMENull() {
        return this.IsParamNull(TAG_USERPSDEACTIONNAME);
    }

    public final String getUSERPSDEACTIONNAME() {
        return this.GetParamStringValue(TAG_USERPSDEACTIONNAME, "");
    }

    public final void setUSERPSDEACTIONNAME(String strValue) {
        this.SetParamValue(TAG_USERPSDEACTIONNAME, strValue);
    }

    public final boolean isUSER2PSDEACTIONIDNull() {
        return this.IsParamNull(TAG_USER2PSDEACTIONID);
    }

    public final String getUSER2PSDEACTIONID() {
        return this.GetParamStringValue(TAG_USER2PSDEACTIONID, "");
    }

    public final void setUSER2PSDEACTIONID(String strValue) {
        this.SetParamValue(TAG_USER2PSDEACTIONID, strValue);
    }

    public final boolean isUSER2PSDEACTIONNAMENull() {
        return this.IsParamNull(TAG_USER2PSDEACTIONNAME);
    }

    public final String getUSER2PSDEACTIONNAME() {
        return this.GetParamStringValue(TAG_USER2PSDEACTIONNAME, "");
    }

    public final void setUSER2PSDEACTIONNAME(String strValue) {
        this.SetParamValue(TAG_USER2PSDEACTIONNAME, strValue);
    }

    public final boolean isUSERPSDEOPPRIVIDNull() {
        return this.IsParamNull(TAG_USERPSDEOPPRIVID);
    }

    public final String getUSERPSDEOPPRIVID() {
        return this.GetParamStringValue(TAG_USERPSDEOPPRIVID, "");
    }

    public final void setUSERPSDEOPPRIVID(String strValue) {
        this.SetParamValue(TAG_USERPSDEOPPRIVID, strValue);
    }

    public final boolean isUSERPSDEOPPRIVINAMENull() {
        return this.IsParamNull(TAG_USERPSDEOPPRIVINAME);
    }

    public final String getUSERPSDEOPPRIVINAME() {
        return this.GetParamStringValue(TAG_USERPSDEOPPRIVINAME, "");
    }

    public final void setUSERPSDEOPPRIVINAME(String strValue) {
        this.SetParamValue(TAG_USERPSDEOPPRIVINAME, strValue);
    }

    public final boolean isUSER2PSDEOPPRIVIDNull() {
        return this.IsParamNull(TAG_USER2PSDEOPPRIVID);
    }

    public final String getUSER2PSDEOPPRIVID() {
        return this.GetParamStringValue(TAG_USER2PSDEOPPRIVID, "");
    }

    public final void setUSER2PSDEOPPRIVID(String strValue) {
        this.SetParamValue(TAG_USER2PSDEOPPRIVID, strValue);
    }

    public final boolean isUSER2PSDEOPPRIVINAMENull() {
        return this.IsParamNull(TAG_USER2PSDEOPPRIVINAME);
    }

    public final String getUSER2PSDEOPPRIVINAME() {
        return this.GetParamStringValue(TAG_USER2PSDEOPPRIVINAME, "");
    }

    public final void setUSER2PSDEOPPRIVINAME(String strValue) {
        this.SetParamValue(TAG_USER2PSDEOPPRIVINAME, strValue);
    }

    public final boolean isHANDLERTAGNull() {
        return this.IsParamNull(TAG_HANDLERTAG);
    }

    public final String getHANDLERTAG() {
        return this.GetParamStringValue(TAG_HANDLERTAG, "");
    }

    public final void setHANDLERTAG(String strValue) {
        this.SetParamValue(TAG_HANDLERTAG, strValue);
    }

    public final boolean isHANDLERTAG2Null() {
        return this.IsParamNull(TAG_HANDLERTAG2);
    }

    public final String getHANDLERTAG2() {
        return this.GetParamStringValue(TAG_HANDLERTAG2, "");
    }

    public final void setHANDLERTAG2(String strValue) {
        this.SetParamValue(TAG_HANDLERTAG2, strValue);
    }

    public final boolean isCUSTOMCONDNull() {
        return this.IsParamNull(TAG_CUSTOMCOND);
    }

    public final String getCUSTOMCOND() {
        return this.GetParamStringValue(TAG_CUSTOMCOND, "");
    }

    public final void setCUSTOMCOND(String strValue) {
        this.SetParamValue(TAG_CUSTOMCOND, strValue);
    }

    public final boolean isMOVEPSDEACTIONIDNull() {
        return this.IsParamNull(TAG_MOVEPSDEACTIONID);
    }

    public final String getMOVEPSDEACTIONID() {
        return this.GetParamStringValue(TAG_MOVEPSDEACTIONID, "");
    }

    public final void setMOVEPSDEACTIONID(String strValue) {
        this.SetParamValue(TAG_MOVEPSDEACTIONID, strValue);
    }

    public final boolean isMOVEPSDEACTIONNAMENull() {
        return this.IsParamNull(TAG_MOVEPSDEACTIONNAME);
    }

    public final String getMOVEPSDEACTIONNAME() {
        return this.GetParamStringValue(TAG_MOVEPSDEACTIONNAME, "");
    }

    public final void setMOVEPSDEACTIONNAME(String strValue) {
        this.SetParamValue(TAG_MOVEPSDEACTIONNAME, strValue);
    }

    public final boolean isCUSTOMTYPENull() {
        return this.IsParamNull(TAG_CUSTOMTYPE);
    }

    public final String getCUSTOMTYPE() {
        return this.GetParamStringValue(TAG_CUSTOMTYPE, "");
    }

    public final void setCUSTOMTYPE(String strValue) {
        this.SetParamValue(TAG_CUSTOMTYPE, strValue);
    }

    public final boolean isGROUPPSDEIDNull() {
        return this.IsParamNull(TAG_GROUPPSDEID);
    }

    public final String getGROUPPSDEID() {
        return this.GetParamStringValue(TAG_GROUPPSDEID, "");
    }

    public final void setGROUPPSDEID(String strValue) {
        this.SetParamValue(TAG_GROUPPSDEID, strValue);
    }

    public final boolean isGROUPPSDENAMENull() {
        return this.IsParamNull(TAG_GROUPPSDENAME);
    }

    public final String getGROUPPSDENAME() {
        return this.GetParamStringValue(TAG_GROUPPSDENAME, "");
    }

    public final void setGROUPPSDENAME(String strValue) {
        this.SetParamValue(TAG_GROUPPSDENAME, strValue);
    }

    public final boolean isGROUPMOVEPSDEACTIONIDNull() {
        return this.IsParamNull(TAG_GROUPMOVEPSDEACTIONID);
    }

    public final String getGROUPMOVEPSDEACTIONID() {
        return this.GetParamStringValue(TAG_GROUPMOVEPSDEACTIONID, "");
    }

    public final void setGROUPMOVEPSDEACTIONID(String strValue) {
        this.SetParamValue(TAG_GROUPMOVEPSDEACTIONID, strValue);
    }

    public final boolean isGROUPMOVEPSDEACTIONNAMENull() {
        return this.IsParamNull(TAG_GROUPMOVEPSDEACTIONNAME);
    }

    public final String getGROUPMOVEPSDEACTIONNAME() {
        return this.GetParamStringValue(TAG_GROUPMOVEPSDEACTIONNAME, "");
    }

    public final void setGROUPMOVEPSDEACTIONNAME(String strValue) {
        this.SetParamValue(TAG_GROUPMOVEPSDEACTIONNAME, strValue);
    }
}

