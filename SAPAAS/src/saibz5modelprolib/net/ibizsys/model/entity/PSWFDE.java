/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.entity;

import java.util.Date;
import net.ibizsys.model.entity.BaseDataEntity;

public class PSWFDE
extends BaseDataEntity {
    public static final String TAG_PSWFDEID = "PSWFDEID";
    public static final String TAG_PSWFDENAME = "PSWFDENAME";
    public static final String TAG_ENABLE = "ENABLE";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSWFID = "PSWFID";
    public static final String TAG_PSWFNAME = "PSWFNAME";
    public static final String TAG_WFINSTPSDEFID = "WFINSTPSDEFID";
    public static final String TAG_WFINSTPSDEFNAME = "WFINSTPSDEFNAME";
    public static final String TAG_WFSTATEPSDEFID = "WFSTATEPSDEFID";
    public static final String TAG_WFSTATEPSDEFNAME = "WFSTATEPSDEFNAME";
    public static final String TAG_WFSTEPPSDEFID = "WFSTEPPSDEFID";
    public static final String TAG_WFSTEPPSDEFNAME = "WFSTEPPSDEFNAME";
    public static final String TAG_STATEPSDEFID = "STATEPSDEFID";
    public static final String TAG_STATEPSDEFNAME = "STATEPSDEFNAME";
    public static final String TAG_WFACTORPSDEFID = "WFACTORPSDEFID";
    public static final String TAG_WFACTORPSDEFNAME = "WFACTORPSDEFNAME";
    public static final String TAG_EDITABLEWFSTEP = "EDITABLEWFSTEP";
    public static final String TAG_EXTCNTSTATES = "EXTCNTSTATES";
    public static final String TAG_MYWFWORK = "MYWFWORK";
    public static final String TAG_USERSTART = "USERSTART";
    public static final String TAG_PSDEID = "PSDEID";
    public static final String TAG_PSDENAME = "PSDENAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_PSSYSTEMID = "PSSYSTEMID";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";
    public static final String TAG_CODENAME = "CODENAME";
    public static final String TAG_INITPSDEACTIONID = "INITPSDEACTIONID";
    public static final String TAG_INITPSDEACTIONNAME = "INITPSDEACTIONNAME";
    public static final String TAG_FINISHPSDEACTIONID = "FINISHPSDEACTIONID";
    public static final String TAG_FINISHPSDEACTIONNAME = "FINISHPSDEACTIONNAME";
    public static final String TAG_DEFAULTMODE = "DEFAULTMODE";
    public static final String TAG_WFRETPSDEFID = "WFRETPSDEFID";
    public static final String TAG_WFRETPSDEFNAME = "WFRETPSDEFNAME";
    public static final String TAG_WFVERPSDEFID = "WFVERPSDEFID";
    public static final String TAG_WFVERPSDEFNAME = "WFVERPSDEFNAME";
    public static final String TAG_WFIDPSDEFID = "WFIDPSDEFID";
    public static final String TAG_WFIDPSDEFNAME = "WFIDPSDEFNAME";
    public static final String TAG_WFMODE = "WFMODE";
    public static final String TAG_MYWFWORKPSLANRESID = "MYWFWORKPSLANRESID";
    public static final String TAG_MYWFWORKPSLANRESNAME = "MYWFWORKPSLANRESNAME";
    public static final String TAG_MYWFDATA = "MYWFDATA";
    public static final String TAG_MYWFDATAPSLANRESID = "MYWFDATAPSLANRESID";
    public static final String TAG_MYWFDATAPSLANRESNAME = "MYWFDATAPSLANRESNAME";
    public static final String TAG_WFPROXYMODE = "WFPROXYMODE";
    public static final String TAG_PROXYDATAPSDEFID = "PROXYDATAPSDEFID";
    public static final String TAG_PROXYDATAPSDEFNAME = "PROXYDATAPSDEFNAME";
    public static final String TAG_PROXYMODULEPSDEFID = "PROXYMODULEPSDEFID";
    public static final String TAG_PROXYMODULEPSDEFNAME = "PROXYMODULEPSDEFNAME";
    public static final String TAG_PROXYWFPSDEFID = "PROXYWFPSDEFID";
    public static final String TAG_PROXYWFPSDEFNAME = "PROXYWFPSDEFNAME";
    public static final String TAG_PROXYDATA2PSDEVIEWID = "PROXYDATA2PSDEVIEWID";
    public static final String TAG_PROXYDATA2PSDEVIEWNAME = "PROXYDATA2PSDEVIEWNAME";
    public static final String TAG_MOBPROXYDATA2PSDEVIEWID = "MOBPROXYDATA2PSDEVIEWID";
    public static final String TAG_MOBPROXYDATA2PSDEVIEWNAME = "MOBPROXYDATA2PSDEVIEWNAME";

    public final boolean isPSWFDEIDNull() {
        return this.isParamNull(TAG_PSWFDEID);
    }

    public final String getPSWFDEID() {
        return this.getParamStringValue(TAG_PSWFDEID, "");
    }

    public final void setPSWFDEID(String strValue) {
        this.setParamValue(TAG_PSWFDEID, strValue);
    }

    public final boolean isPSWFDENAMENull() {
        return this.isParamNull(TAG_PSWFDENAME);
    }

    public final String getPSWFDENAME() {
        return this.getParamStringValue(TAG_PSWFDENAME, "");
    }

    public final void setPSWFDENAME(String strValue) {
        this.setParamValue(TAG_PSWFDENAME, strValue);
    }

    public final boolean isENABLENull() {
        return this.isParamNull(TAG_ENABLE);
    }

    public final boolean getENABLE() {
        return this.getParamIntValue(TAG_ENABLE, 0) == 1;
    }

    public final void setENABLE(boolean bValue) {
        this.setParamValue(TAG_ENABLE, bValue ? 1 : 0);
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

    public final boolean isPSWFIDNull() {
        return this.isParamNull(TAG_PSWFID);
    }

    public final String getPSWFID() {
        return this.getParamStringValue(TAG_PSWFID, "");
    }

    public final void setPSWFID(String strValue) {
        this.setParamValue(TAG_PSWFID, strValue);
    }

    public final boolean isPSWFNAMENull() {
        return this.isParamNull(TAG_PSWFNAME);
    }

    public final String getPSWFNAME() {
        return this.getParamStringValue(TAG_PSWFNAME, "");
    }

    public final void setPSWFNAME(String strValue) {
        this.setParamValue(TAG_PSWFNAME, strValue);
    }

    public final boolean isWFINSTPSDEFIDNull() {
        return this.isParamNull(TAG_WFINSTPSDEFID);
    }

    public final String getWFINSTPSDEFID() {
        return this.getParamStringValue(TAG_WFINSTPSDEFID, "");
    }

    public final void setWFINSTPSDEFID(String strValue) {
        this.setParamValue(TAG_WFINSTPSDEFID, strValue);
    }

    public final boolean isWFINSTPSDEFNAMENull() {
        return this.isParamNull(TAG_WFINSTPSDEFNAME);
    }

    public final String getWFINSTPSDEFNAME() {
        return this.getParamStringValue(TAG_WFINSTPSDEFNAME, "");
    }

    public final void setWFINSTPSDEFNAME(String strValue) {
        this.setParamValue(TAG_WFINSTPSDEFNAME, strValue);
    }

    public final boolean isWFSTATEPSDEFIDNull() {
        return this.isParamNull(TAG_WFSTATEPSDEFID);
    }

    public final String getWFSTATEPSDEFID() {
        return this.getParamStringValue(TAG_WFSTATEPSDEFID, "");
    }

    public final void setWFSTATEPSDEFID(String strValue) {
        this.setParamValue(TAG_WFSTATEPSDEFID, strValue);
    }

    public final boolean isWFSTATEPSDEFNAMENull() {
        return this.isParamNull(TAG_WFSTATEPSDEFNAME);
    }

    public final String getWFSTATEPSDEFNAME() {
        return this.getParamStringValue(TAG_WFSTATEPSDEFNAME, "");
    }

    public final void setWFSTATEPSDEFNAME(String strValue) {
        this.setParamValue(TAG_WFSTATEPSDEFNAME, strValue);
    }

    public final boolean isWFSTEPPSDEFIDNull() {
        return this.isParamNull(TAG_WFSTEPPSDEFID);
    }

    public final String getWFSTEPPSDEFID() {
        return this.getParamStringValue(TAG_WFSTEPPSDEFID, "");
    }

    public final void setWFSTEPPSDEFID(String strValue) {
        this.setParamValue(TAG_WFSTEPPSDEFID, strValue);
    }

    public final boolean isWFSTEPPSDEFNAMENull() {
        return this.isParamNull(TAG_WFSTEPPSDEFNAME);
    }

    public final String getWFSTEPPSDEFNAME() {
        return this.getParamStringValue(TAG_WFSTEPPSDEFNAME, "");
    }

    public final void setWFSTEPPSDEFNAME(String strValue) {
        this.setParamValue(TAG_WFSTEPPSDEFNAME, strValue);
    }

    public final boolean isSTATEPSDEFIDNull() {
        return this.isParamNull(TAG_STATEPSDEFID);
    }

    public final String getSTATEPSDEFID() {
        return this.getParamStringValue(TAG_STATEPSDEFID, "");
    }

    public final void setSTATEPSDEFID(String strValue) {
        this.setParamValue(TAG_STATEPSDEFID, strValue);
    }

    public final boolean isSTATEPSDEFNAMENull() {
        return this.isParamNull(TAG_STATEPSDEFNAME);
    }

    public final String getSTATEPSDEFNAME() {
        return this.getParamStringValue(TAG_STATEPSDEFNAME, "");
    }

    public final void setSTATEPSDEFNAME(String strValue) {
        this.setParamValue(TAG_STATEPSDEFNAME, strValue);
    }

    public final boolean isWFACTORPSDEFIDNull() {
        return this.isParamNull(TAG_WFACTORPSDEFID);
    }

    public final String getWFACTORPSDEFID() {
        return this.getParamStringValue(TAG_WFACTORPSDEFID, "");
    }

    public final void setWFACTORPSDEFID(String strValue) {
        this.setParamValue(TAG_WFACTORPSDEFID, strValue);
    }

    public final boolean isWFACTORPSDEFNAMENull() {
        return this.isParamNull(TAG_WFACTORPSDEFNAME);
    }

    public final String getWFACTORPSDEFNAME() {
        return this.getParamStringValue(TAG_WFACTORPSDEFNAME, "");
    }

    public final void setWFACTORPSDEFNAME(String strValue) {
        this.setParamValue(TAG_WFACTORPSDEFNAME, strValue);
    }

    public final boolean isEDITABLEWFSTEPNull() {
        return this.isParamNull(TAG_EDITABLEWFSTEP);
    }

    public final String getEDITABLEWFSTEP() {
        return this.getParamStringValue(TAG_EDITABLEWFSTEP, "");
    }

    public final void setEDITABLEWFSTEP(String strValue) {
        this.setParamValue(TAG_EDITABLEWFSTEP, strValue);
    }

    public final boolean isEXTCNTSTATESNull() {
        return this.isParamNull(TAG_EXTCNTSTATES);
    }

    public final String getEXTCNTSTATES() {
        return this.getParamStringValue(TAG_EXTCNTSTATES, "");
    }

    public final void setEXTCNTSTATES(String strValue) {
        this.setParamValue(TAG_EXTCNTSTATES, strValue);
    }

    public final boolean isMYWFWORKNull() {
        return this.isParamNull(TAG_MYWFWORK);
    }

    public final String getMYWFWORK() {
        return this.getParamStringValue(TAG_MYWFWORK, "");
    }

    public final void setMYWFWORK(String strValue) {
        this.setParamValue(TAG_MYWFWORK, strValue);
    }

    public final boolean isUSERSTARTNull() {
        return this.isParamNull(TAG_USERSTART);
    }

    public final boolean getUSERSTART() {
        return this.getParamIntValue(TAG_USERSTART, 0) == 1;
    }

    public final void setUSERSTART(boolean bValue) {
        this.setParamValue(TAG_USERSTART, bValue ? 1 : 0);
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

    public final boolean isMEMONull() {
        return this.isParamNull(TAG_MEMO);
    }

    public final String getMEMO() {
        return this.getParamStringValue(TAG_MEMO, "");
    }

    public final void setMEMO(String strValue) {
        this.setParamValue(TAG_MEMO, strValue);
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

    public final boolean isVALIDFLAGNull() {
        return this.isParamNull(TAG_VALIDFLAG);
    }

    public final boolean getVALIDFLAG() {
        return this.getParamIntValue(TAG_VALIDFLAG, 0) == 1;
    }

    public final void setVALIDFLAG(boolean bValue) {
        this.setParamValue(TAG_VALIDFLAG, bValue ? 1 : 0);
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

    public final boolean isINITPSDEACTIONIDNull() {
        return this.isParamNull(TAG_INITPSDEACTIONID);
    }

    public final String getINITPSDEACTIONID() {
        return this.getParamStringValue(TAG_INITPSDEACTIONID, "");
    }

    public final void setINITPSDEACTIONID(String strValue) {
        this.setParamValue(TAG_INITPSDEACTIONID, strValue);
    }

    public final boolean isINITPSDEACTIONNAMENull() {
        return this.isParamNull(TAG_INITPSDEACTIONNAME);
    }

    public final String getINITPSDEACTIONNAME() {
        return this.getParamStringValue(TAG_INITPSDEACTIONNAME, "");
    }

    public final void setINITPSDEACTIONNAME(String strValue) {
        this.setParamValue(TAG_INITPSDEACTIONNAME, strValue);
    }

    public final boolean isFINISHPSDEACTIONIDNull() {
        return this.isParamNull(TAG_FINISHPSDEACTIONID);
    }

    public final String getFINISHPSDEACTIONID() {
        return this.getParamStringValue(TAG_FINISHPSDEACTIONID, "");
    }

    public final void setFINISHPSDEACTIONID(String strValue) {
        this.setParamValue(TAG_FINISHPSDEACTIONID, strValue);
    }

    public final boolean isFINISHPSDEACTIONNAMENull() {
        return this.isParamNull(TAG_FINISHPSDEACTIONNAME);
    }

    public final String getFINISHPSDEACTIONNAME() {
        return this.getParamStringValue(TAG_FINISHPSDEACTIONNAME, "");
    }

    public final void setFINISHPSDEACTIONNAME(String strValue) {
        this.setParamValue(TAG_FINISHPSDEACTIONNAME, strValue);
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

    public final boolean isWFRETPSDEFIDNull() {
        return this.isParamNull(TAG_WFRETPSDEFID);
    }

    public final String getWFRETPSDEFID() {
        return this.getParamStringValue(TAG_WFRETPSDEFID, "");
    }

    public final void setWFRETPSDEFID(String strValue) {
        this.setParamValue(TAG_WFRETPSDEFID, strValue);
    }

    public final boolean isWFRETPSDEFNAMENull() {
        return this.isParamNull(TAG_WFRETPSDEFNAME);
    }

    public final String getWFRETPSDEFNAME() {
        return this.getParamStringValue(TAG_WFRETPSDEFNAME, "");
    }

    public final void setWFRETPSDEFNAME(String strValue) {
        this.setParamValue(TAG_WFRETPSDEFNAME, strValue);
    }

    public final boolean isWFVERPSDEFIDNull() {
        return this.isParamNull(TAG_WFVERPSDEFID);
    }

    public final String getWFVERPSDEFID() {
        return this.getParamStringValue(TAG_WFVERPSDEFID, "");
    }

    public final void setWFVERPSDEFID(String strValue) {
        this.setParamValue(TAG_WFVERPSDEFID, strValue);
    }

    public final boolean isWFVERPSDEFNAMENull() {
        return this.isParamNull(TAG_WFVERPSDEFNAME);
    }

    public final String getWFVERPSDEFNAME() {
        return this.getParamStringValue(TAG_WFVERPSDEFNAME, "");
    }

    public final void setWFVERPSDEFNAME(String strValue) {
        this.setParamValue(TAG_WFVERPSDEFNAME, strValue);
    }

    public final boolean isWFIDPSDEFIDNull() {
        return this.isParamNull(TAG_WFIDPSDEFID);
    }

    public final String getWFIDPSDEFID() {
        return this.getParamStringValue(TAG_WFIDPSDEFID, "");
    }

    public final void setWFIDPSDEFID(String strValue) {
        this.setParamValue(TAG_WFIDPSDEFID, strValue);
    }

    public final boolean isWFIDPSDEFNAMENull() {
        return this.isParamNull(TAG_WFIDPSDEFNAME);
    }

    public final String getWFIDPSDEFNAME() {
        return this.getParamStringValue(TAG_WFIDPSDEFNAME, "");
    }

    public final void setWFIDPSDEFNAME(String strValue) {
        this.setParamValue(TAG_WFIDPSDEFNAME, strValue);
    }

    public final boolean isWFMODENull() {
        return this.isParamNull(TAG_WFMODE);
    }

    public final String getWFMODE() {
        return this.getParamStringValue(TAG_WFMODE, "");
    }

    public final void setWFMODE(String strValue) {
        this.setParamValue(TAG_WFMODE, strValue);
    }

    public final boolean isMYWFWORKPSLANRESIDNull() {
        return this.isParamNull(TAG_MYWFWORKPSLANRESID);
    }

    public final String getMYWFWORKPSLANRESID() {
        return this.getParamStringValue(TAG_MYWFWORKPSLANRESID, "");
    }

    public final void setMYWFWORKPSLANRESID(String strValue) {
        this.setParamValue(TAG_MYWFWORKPSLANRESID, strValue);
    }

    public final boolean isMYWFWORKPSLANRESNAMENull() {
        return this.isParamNull(TAG_MYWFWORKPSLANRESNAME);
    }

    public final String getMYWFWORKPSLANRESNAME() {
        return this.getParamStringValue(TAG_MYWFWORKPSLANRESNAME, "");
    }

    public final void setMYWFWORKPSLANRESNAME(String strValue) {
        this.setParamValue(TAG_MYWFWORKPSLANRESNAME, strValue);
    }

    public final boolean isMYWFDATANull() {
        return this.isParamNull(TAG_MYWFDATA);
    }

    public final String getMYWFDATA() {
        return this.getParamStringValue(TAG_MYWFDATA, "");
    }

    public final void setMYWFDATA(String strValue) {
        this.setParamValue(TAG_MYWFDATA, strValue);
    }

    public final boolean isMYWFDATAPSLANRESIDNull() {
        return this.isParamNull(TAG_MYWFDATAPSLANRESID);
    }

    public final String getMYWFDATAPSLANRESID() {
        return this.getParamStringValue(TAG_MYWFDATAPSLANRESID, "");
    }

    public final void setMYWFDATAPSLANRESID(String strValue) {
        this.setParamValue(TAG_MYWFDATAPSLANRESID, strValue);
    }

    public final boolean isMYWFDATAPSLANRESNAMENull() {
        return this.isParamNull(TAG_MYWFDATAPSLANRESNAME);
    }

    public final String getMYWFDATAPSLANRESNAME() {
        return this.getParamStringValue(TAG_MYWFDATAPSLANRESNAME, "");
    }

    public final boolean isWFPROXYMODENull() {
        return this.isParamNull(TAG_WFPROXYMODE);
    }

    public final int getWFPROXYMODE() {
        return this.getParamIntValue(TAG_WFPROXYMODE, 0);
    }

    public final void setWFPROXYMODE(int nValue) {
        this.setParamValue(TAG_WFPROXYMODE, nValue);
    }

    public final boolean isPROXYDATAPSDEFIDNull() {
        return this.isParamNull(TAG_PROXYDATAPSDEFID);
    }

    public final String getPROXYDATAPSDEFID() {
        return this.getParamStringValue(TAG_PROXYDATAPSDEFID, "");
    }

    public final void setPROXYDATAPSDEFID(String strValue) {
        this.setParamValue(TAG_PROXYDATAPSDEFID, strValue);
    }

    public final boolean isPROXYDATAPSDEFNAMENull() {
        return this.isParamNull(TAG_PROXYDATAPSDEFNAME);
    }

    public final String getPROXYDATAPSDEFNAME() {
        return this.getParamStringValue(TAG_PROXYDATAPSDEFNAME, "");
    }

    public final void setPROXYDATAPSDEFNAME(String strValue) {
        this.setParamValue(TAG_PROXYDATAPSDEFNAME, strValue);
    }

    public final boolean isPROXYMODULEPSDEFIDNull() {
        return this.isParamNull(TAG_PROXYMODULEPSDEFID);
    }

    public final String getPROXYMODULEPSDEFID() {
        return this.getParamStringValue(TAG_PROXYMODULEPSDEFID, "");
    }

    public final void setPROXYMODULEPSDEFID(String strValue) {
        this.setParamValue(TAG_PROXYMODULEPSDEFID, strValue);
    }

    public final boolean isPROXYMODULEPSDEFNAMENull() {
        return this.isParamNull(TAG_PROXYMODULEPSDEFNAME);
    }

    public final String getPROXYMODULEPSDEFNAME() {
        return this.getParamStringValue(TAG_PROXYMODULEPSDEFNAME, "");
    }

    public final void setPROXYMODULEPSDEFNAME(String strValue) {
        this.setParamValue(TAG_PROXYMODULEPSDEFNAME, strValue);
    }

    public final boolean isPROXYWFPSDEFIDNull() {
        return this.isParamNull(TAG_PROXYWFPSDEFID);
    }

    public final String getPROXYWFPSDEFID() {
        return this.getParamStringValue(TAG_PROXYWFPSDEFID, "");
    }

    public final void setPROXYWFPSDEFID(String strValue) {
        this.setParamValue(TAG_PROXYWFPSDEFID, strValue);
    }

    public final boolean isPROXYWFPSDEFNAMENull() {
        return this.isParamNull(TAG_PROXYWFPSDEFNAME);
    }

    public final String getPROXYWFPSDEFNAME() {
        return this.getParamStringValue(TAG_PROXYWFPSDEFNAME, "");
    }

    public final void setPROXYWFPSDEFNAME(String strValue) {
        this.setParamValue(TAG_PROXYWFPSDEFNAME, strValue);
    }

    public final boolean isPROXYDATA2PSDEVIEWIDNull() {
        return this.isParamNull(TAG_PROXYDATA2PSDEVIEWID);
    }

    public final String getPROXYDATA2PSDEVIEWID() {
        return this.getParamStringValue(TAG_PROXYDATA2PSDEVIEWID, "");
    }

    public final void setPROXYDATA2PSDEVIEWID(String strValue) {
        this.setParamValue(TAG_PROXYDATA2PSDEVIEWID, strValue);
    }

    public final boolean isPROXYDATA2PSDEVIEWNAMENull() {
        return this.isParamNull(TAG_PROXYDATA2PSDEVIEWNAME);
    }

    public final String getPROXYDATA2PSDEVIEWNAME() {
        return this.getParamStringValue(TAG_PROXYDATA2PSDEVIEWNAME, "");
    }

    public final void setPROXYDATA2PSDEVIEWNAME(String strValue) {
        this.setParamValue(TAG_PROXYDATA2PSDEVIEWNAME, strValue);
    }

    public final boolean isMOBPROXYDATA2PSDEVIEWIDNull() {
        return this.isParamNull(TAG_MOBPROXYDATA2PSDEVIEWID);
    }

    public final String getMOBPROXYDATA2PSDEVIEWID() {
        return this.getParamStringValue(TAG_MOBPROXYDATA2PSDEVIEWID, "");
    }

    public final void setMOBPROXYDATA2PSDEVIEWID(String strValue) {
        this.setParamValue(TAG_MOBPROXYDATA2PSDEVIEWID, strValue);
    }

    public final boolean isMOBPROXYDATA2PSDEVIEWNAMENull() {
        return this.isParamNull(TAG_MOBPROXYDATA2PSDEVIEWNAME);
    }

    public final String getMOBPROXYDATA2PSDEVIEWNAME() {
        return this.getParamStringValue(TAG_MOBPROXYDATA2PSDEVIEWNAME, "");
    }

    public final void setMOBPROXYDATA2PSDEVIEWNAME(String strValue) {
        this.setParamValue(TAG_MOBPROXYDATA2PSDEVIEWNAME, strValue);
    }
}

