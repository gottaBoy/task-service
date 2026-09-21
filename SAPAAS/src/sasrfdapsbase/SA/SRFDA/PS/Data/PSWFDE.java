/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

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
    public static final String TAG_DYNAMODELFLAG = "DYNAMODELFLAG";
    public static final String TAG_PSDYNAINSTID = "PSDYNAINSTID";
    public static final String TAG_WFPROXYMODE = "WFPROXYMODE";
    public static final String TAG_PROXYDATAPSDEFID = "PROXYDATAPSDEFID";
    public static final String TAG_PROXYDATAPSDEFNAME = "PROXYDATAPSDEFNAME";
    public static final String TAG_PROXYMODULEPSDEFID = "PROXYMODULEPSDEFID";
    public static final String TAG_PROXYMODULEPSDEFNAME = "PROXYMODULEPSDEFNAME";
    public static final String TAG_PROXYWFPSDEFID = "PROXYWFPSDEFID";
    public static final String TAG_PROXYWFPSDEFNAME = "PROXYWFPSDEFNAME";
    public static final String TAG_PROXYDATAPSDEVIEWID = "PROXYDATAPSDEVIEWID";
    public static final String TAG_PROXYDATAPSDEVIEWNAME = "PROXYDATAPSDEVIEWNAME";
    public static final String TAG_MOBPROXYDATAPSDEVIEWID = "MOBPROXYDATAPSDEVIEWID";
    public static final String TAG_MOBPROXYDATAPSDEVIEWNAME = "MOBPROXYDATAPSDEVIEWNAME";
    public static final String TAG_PROXYDATA2PSDEVIEWID = "PROXYDATA2PSDEVIEWID";
    public static final String TAG_PROXYDATA2PSDEVIEWNAME = "PROXYDATA2PSDEVIEWNAME";
    public static final String TAG_MOBPROXYDATA2PSDEVIEWID = "MOBPROXYDATA2PSDEVIEWID";
    public static final String TAG_MOBPROXYDATA2PSDEVIEWNAME = "MOBPROXYDATA2PSDEVIEWNAME";
    public static final String TAG_ACTIONMOBPSDEVIEWID = "ACTIONMOBPSDEVIEWID";
    public static final String TAG_ACTIONMOBPSDEVIEWNAME = "ACTIONMOBPSDEVIEWNAME";
    public static final String TAG_ACTIONPSDEVIEWID = "ACTIONPSDEVIEWID";
    public static final String TAG_ACTIONPSDEVIEWNAME = "ACTIONPSDEVIEWNAME";
    public static final String TAG_STARTMOBPSDEVIEWID = "STARTMOBPSDEVIEWID";
    public static final String TAG_STARTMOBPSDEVIEWNAME = "STARTMOBPSDEVIEWNAME";
    public static final String TAG_STARTPSDEVIEWID = "STARTPSDEVIEWID";
    public static final String TAG_STARTPSDEVIEWNAME = "STARTPSDEVIEWNAME";
    public static final String TAG_PWFINSTPSDEFID = "PWFINSTPSDEFID";
    public static final String TAG_PWFINSTPSDEFNAME = "PWFINSTPSDEFNAME";
    public static final String TAG_STARTVIEWCODENAME = "STARTVIEWCODENAME";
    public static final String TAG_STARTMOBVIEWCODENAME = "STARTMOBVIEWCODENAME";
    public static final String TAG_ACTIONMOBVIEWCODENAME = "ACTIONMOBVIEWCODENAME";
    public static final String TAG_ACTIONVIEWCODENAME = "ACTIONVIEWCODENAME";
    public static final String TAG_WFCATCODE = "WFCATCODE";

    public final boolean isPSWFDEIDNull() {
        return this.IsParamNull(TAG_PSWFDEID);
    }

    public final String getPSWFDEID() {
        return this.GetParamStringValue(TAG_PSWFDEID, "");
    }

    public final void setPSWFDEID(String strValue) {
        this.SetParamValue(TAG_PSWFDEID, strValue);
    }

    public final boolean isPSWFDENAMENull() {
        return this.IsParamNull(TAG_PSWFDENAME);
    }

    public final String getPSWFDENAME() {
        return this.GetParamStringValue(TAG_PSWFDENAME, "");
    }

    public final void setPSWFDENAME(String strValue) {
        this.SetParamValue(TAG_PSWFDENAME, strValue);
    }

    public final boolean isENABLENull() {
        return this.IsParamNull(TAG_ENABLE);
    }

    public final boolean getENABLE() {
        return this.GetParamIntValue(TAG_ENABLE, 0) == 1;
    }

    public final void setENABLE(boolean bValue) {
        this.SetParamValue(TAG_ENABLE, bValue ? 1 : 0);
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

    public final boolean isPSWFIDNull() {
        return this.IsParamNull(TAG_PSWFID);
    }

    public final String getPSWFID() {
        return this.GetParamStringValue(TAG_PSWFID, "");
    }

    public final void setPSWFID(String strValue) {
        this.SetParamValue(TAG_PSWFID, strValue);
    }

    public final boolean isPSWFNAMENull() {
        return this.IsParamNull(TAG_PSWFNAME);
    }

    public final String getPSWFNAME() {
        return this.GetParamStringValue(TAG_PSWFNAME, "");
    }

    public final void setPSWFNAME(String strValue) {
        this.SetParamValue(TAG_PSWFNAME, strValue);
    }

    public final boolean isWFINSTPSDEFIDNull() {
        return this.IsParamNull(TAG_WFINSTPSDEFID);
    }

    public final String getWFINSTPSDEFID() {
        return this.GetParamStringValue(TAG_WFINSTPSDEFID, "");
    }

    public final void setWFINSTPSDEFID(String strValue) {
        this.SetParamValue(TAG_WFINSTPSDEFID, strValue);
    }

    public final boolean isWFINSTPSDEFNAMENull() {
        return this.IsParamNull(TAG_WFINSTPSDEFNAME);
    }

    public final String getWFINSTPSDEFNAME() {
        return this.GetParamStringValue(TAG_WFINSTPSDEFNAME, "");
    }

    public final void setWFINSTPSDEFNAME(String strValue) {
        this.SetParamValue(TAG_WFINSTPSDEFNAME, strValue);
    }

    public final boolean isWFSTATEPSDEFIDNull() {
        return this.IsParamNull(TAG_WFSTATEPSDEFID);
    }

    public final String getWFSTATEPSDEFID() {
        return this.GetParamStringValue(TAG_WFSTATEPSDEFID, "");
    }

    public final void setWFSTATEPSDEFID(String strValue) {
        this.SetParamValue(TAG_WFSTATEPSDEFID, strValue);
    }

    public final boolean isWFSTATEPSDEFNAMENull() {
        return this.IsParamNull(TAG_WFSTATEPSDEFNAME);
    }

    public final String getWFSTATEPSDEFNAME() {
        return this.GetParamStringValue(TAG_WFSTATEPSDEFNAME, "");
    }

    public final void setWFSTATEPSDEFNAME(String strValue) {
        this.SetParamValue(TAG_WFSTATEPSDEFNAME, strValue);
    }

    public final boolean isWFSTEPPSDEFIDNull() {
        return this.IsParamNull(TAG_WFSTEPPSDEFID);
    }

    public final String getWFSTEPPSDEFID() {
        return this.GetParamStringValue(TAG_WFSTEPPSDEFID, "");
    }

    public final void setWFSTEPPSDEFID(String strValue) {
        this.SetParamValue(TAG_WFSTEPPSDEFID, strValue);
    }

    public final boolean isWFSTEPPSDEFNAMENull() {
        return this.IsParamNull(TAG_WFSTEPPSDEFNAME);
    }

    public final String getWFSTEPPSDEFNAME() {
        return this.GetParamStringValue(TAG_WFSTEPPSDEFNAME, "");
    }

    public final void setWFSTEPPSDEFNAME(String strValue) {
        this.SetParamValue(TAG_WFSTEPPSDEFNAME, strValue);
    }

    public final boolean isSTATEPSDEFIDNull() {
        return this.IsParamNull(TAG_STATEPSDEFID);
    }

    public final String getSTATEPSDEFID() {
        return this.GetParamStringValue(TAG_STATEPSDEFID, "");
    }

    public final void setSTATEPSDEFID(String strValue) {
        this.SetParamValue(TAG_STATEPSDEFID, strValue);
    }

    public final boolean isSTATEPSDEFNAMENull() {
        return this.IsParamNull(TAG_STATEPSDEFNAME);
    }

    public final String getSTATEPSDEFNAME() {
        return this.GetParamStringValue(TAG_STATEPSDEFNAME, "");
    }

    public final void setSTATEPSDEFNAME(String strValue) {
        this.SetParamValue(TAG_STATEPSDEFNAME, strValue);
    }

    public final boolean isWFACTORPSDEFIDNull() {
        return this.IsParamNull(TAG_WFACTORPSDEFID);
    }

    public final String getWFACTORPSDEFID() {
        return this.GetParamStringValue(TAG_WFACTORPSDEFID, "");
    }

    public final void setWFACTORPSDEFID(String strValue) {
        this.SetParamValue(TAG_WFACTORPSDEFID, strValue);
    }

    public final boolean isWFACTORPSDEFNAMENull() {
        return this.IsParamNull(TAG_WFACTORPSDEFNAME);
    }

    public final String getWFACTORPSDEFNAME() {
        return this.GetParamStringValue(TAG_WFACTORPSDEFNAME, "");
    }

    public final void setWFACTORPSDEFNAME(String strValue) {
        this.SetParamValue(TAG_WFACTORPSDEFNAME, strValue);
    }

    public final boolean isEDITABLEWFSTEPNull() {
        return this.IsParamNull(TAG_EDITABLEWFSTEP);
    }

    public final String getEDITABLEWFSTEP() {
        return this.GetParamStringValue(TAG_EDITABLEWFSTEP, "");
    }

    public final void setEDITABLEWFSTEP(String strValue) {
        this.SetParamValue(TAG_EDITABLEWFSTEP, strValue);
    }

    public final boolean isEXTCNTSTATESNull() {
        return this.IsParamNull(TAG_EXTCNTSTATES);
    }

    public final String getEXTCNTSTATES() {
        return this.GetParamStringValue(TAG_EXTCNTSTATES, "");
    }

    public final void setEXTCNTSTATES(String strValue) {
        this.SetParamValue(TAG_EXTCNTSTATES, strValue);
    }

    public final boolean isMYWFWORKNull() {
        return this.IsParamNull(TAG_MYWFWORK);
    }

    public final String getMYWFWORK() {
        return this.GetParamStringValue(TAG_MYWFWORK, "");
    }

    public final void setMYWFWORK(String strValue) {
        this.SetParamValue(TAG_MYWFWORK, strValue);
    }

    public final boolean isUSERSTARTNull() {
        return this.IsParamNull(TAG_USERSTART);
    }

    public final boolean getUSERSTART() {
        return this.GetParamIntValue(TAG_USERSTART, 0) == 1;
    }

    public final void setUSERSTART(boolean bValue) {
        this.SetParamValue(TAG_USERSTART, bValue ? 1 : 0);
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

    public final boolean isMEMONull() {
        return this.IsParamNull(TAG_MEMO);
    }

    public final String getMEMO() {
        return this.GetParamStringValue(TAG_MEMO, "");
    }

    public final void setMEMO(String strValue) {
        this.SetParamValue(TAG_MEMO, strValue);
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

    public final boolean isVALIDFLAGNull() {
        return this.IsParamNull(TAG_VALIDFLAG);
    }

    public final boolean getVALIDFLAG() {
        return this.GetParamIntValue(TAG_VALIDFLAG, 0) == 1;
    }

    public final void setVALIDFLAG(boolean bValue) {
        this.SetParamValue(TAG_VALIDFLAG, bValue ? 1 : 0);
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

    public final boolean isINITPSDEACTIONIDNull() {
        return this.IsParamNull(TAG_INITPSDEACTIONID);
    }

    public final String getINITPSDEACTIONID() {
        return this.GetParamStringValue(TAG_INITPSDEACTIONID, "");
    }

    public final void setINITPSDEACTIONID(String strValue) {
        this.SetParamValue(TAG_INITPSDEACTIONID, strValue);
    }

    public final boolean isINITPSDEACTIONNAMENull() {
        return this.IsParamNull(TAG_INITPSDEACTIONNAME);
    }

    public final String getINITPSDEACTIONNAME() {
        return this.GetParamStringValue(TAG_INITPSDEACTIONNAME, "");
    }

    public final void setINITPSDEACTIONNAME(String strValue) {
        this.SetParamValue(TAG_INITPSDEACTIONNAME, strValue);
    }

    public final boolean isFINISHPSDEACTIONIDNull() {
        return this.IsParamNull(TAG_FINISHPSDEACTIONID);
    }

    public final String getFINISHPSDEACTIONID() {
        return this.GetParamStringValue(TAG_FINISHPSDEACTIONID, "");
    }

    public final void setFINISHPSDEACTIONID(String strValue) {
        this.SetParamValue(TAG_FINISHPSDEACTIONID, strValue);
    }

    public final boolean isFINISHPSDEACTIONNAMENull() {
        return this.IsParamNull(TAG_FINISHPSDEACTIONNAME);
    }

    public final String getFINISHPSDEACTIONNAME() {
        return this.GetParamStringValue(TAG_FINISHPSDEACTIONNAME, "");
    }

    public final void setFINISHPSDEACTIONNAME(String strValue) {
        this.SetParamValue(TAG_FINISHPSDEACTIONNAME, strValue);
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

    public final boolean isWFRETPSDEFIDNull() {
        return this.IsParamNull(TAG_WFRETPSDEFID);
    }

    public final String getWFRETPSDEFID() {
        return this.GetParamStringValue(TAG_WFRETPSDEFID, "");
    }

    public final void setWFRETPSDEFID(String strValue) {
        this.SetParamValue(TAG_WFRETPSDEFID, strValue);
    }

    public final boolean isWFRETPSDEFNAMENull() {
        return this.IsParamNull(TAG_WFRETPSDEFNAME);
    }

    public final String getWFRETPSDEFNAME() {
        return this.GetParamStringValue(TAG_WFRETPSDEFNAME, "");
    }

    public final void setWFRETPSDEFNAME(String strValue) {
        this.SetParamValue(TAG_WFRETPSDEFNAME, strValue);
    }

    public final boolean isWFVERPSDEFIDNull() {
        return this.IsParamNull(TAG_WFVERPSDEFID);
    }

    public final String getWFVERPSDEFID() {
        return this.GetParamStringValue(TAG_WFVERPSDEFID, "");
    }

    public final void setWFVERPSDEFID(String strValue) {
        this.SetParamValue(TAG_WFVERPSDEFID, strValue);
    }

    public final boolean isWFVERPSDEFNAMENull() {
        return this.IsParamNull(TAG_WFVERPSDEFNAME);
    }

    public final String getWFVERPSDEFNAME() {
        return this.GetParamStringValue(TAG_WFVERPSDEFNAME, "");
    }

    public final void setWFVERPSDEFNAME(String strValue) {
        this.SetParamValue(TAG_WFVERPSDEFNAME, strValue);
    }

    public final boolean isWFIDPSDEFIDNull() {
        return this.IsParamNull(TAG_WFIDPSDEFID);
    }

    public final String getWFIDPSDEFID() {
        return this.GetParamStringValue(TAG_WFIDPSDEFID, "");
    }

    public final void setWFIDPSDEFID(String strValue) {
        this.SetParamValue(TAG_WFIDPSDEFID, strValue);
    }

    public final boolean isWFIDPSDEFNAMENull() {
        return this.IsParamNull(TAG_WFIDPSDEFNAME);
    }

    public final String getWFIDPSDEFNAME() {
        return this.GetParamStringValue(TAG_WFIDPSDEFNAME, "");
    }

    public final void setWFIDPSDEFNAME(String strValue) {
        this.SetParamValue(TAG_WFIDPSDEFNAME, strValue);
    }

    public final boolean isWFMODENull() {
        return this.IsParamNull(TAG_WFMODE);
    }

    public final String getWFMODE() {
        return this.GetParamStringValue(TAG_WFMODE, "");
    }

    public final void setWFMODE(String strValue) {
        this.SetParamValue(TAG_WFMODE, strValue);
    }

    public final boolean isMYWFWORKPSLANRESIDNull() {
        return this.IsParamNull(TAG_MYWFWORKPSLANRESID);
    }

    public final String getMYWFWORKPSLANRESID() {
        return this.GetParamStringValue(TAG_MYWFWORKPSLANRESID, "");
    }

    public final void setMYWFWORKPSLANRESID(String strValue) {
        this.SetParamValue(TAG_MYWFWORKPSLANRESID, strValue);
    }

    public final boolean isMYWFWORKPSLANRESNAMENull() {
        return this.IsParamNull(TAG_MYWFWORKPSLANRESNAME);
    }

    public final String getMYWFWORKPSLANRESNAME() {
        return this.GetParamStringValue(TAG_MYWFWORKPSLANRESNAME, "");
    }

    public final void setMYWFWORKPSLANRESNAME(String strValue) {
        this.SetParamValue(TAG_MYWFWORKPSLANRESNAME, strValue);
    }

    public final boolean isMYWFDATANull() {
        return this.IsParamNull(TAG_MYWFDATA);
    }

    public final String getMYWFDATA() {
        return this.GetParamStringValue(TAG_MYWFDATA, "");
    }

    public final void setMYWFDATA(String strValue) {
        this.SetParamValue(TAG_MYWFDATA, strValue);
    }

    public final boolean isMYWFDATAPSLANRESIDNull() {
        return this.IsParamNull(TAG_MYWFDATAPSLANRESID);
    }

    public final String getMYWFDATAPSLANRESID() {
        return this.GetParamStringValue(TAG_MYWFDATAPSLANRESID, "");
    }

    public final void setMYWFDATAPSLANRESID(String strValue) {
        this.SetParamValue(TAG_MYWFDATAPSLANRESID, strValue);
    }

    public final boolean isMYWFDATAPSLANRESNAMENull() {
        return this.IsParamNull(TAG_MYWFDATAPSLANRESNAME);
    }

    public final String getMYWFDATAPSLANRESNAME() {
        return this.GetParamStringValue(TAG_MYWFDATAPSLANRESNAME, "");
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

    public final boolean isPSDYNAINSTIDNull() {
        return this.IsParamNull(TAG_PSDYNAINSTID);
    }

    public final String getPSDYNAINSTID() {
        return this.GetParamStringValue(TAG_PSDYNAINSTID, "");
    }

    public final void setPSDYNAINSTID(String strValue) {
        this.SetParamValue(TAG_PSDYNAINSTID, strValue);
    }

    public final boolean isWFPROXYMODENull() {
        return this.IsParamNull(TAG_WFPROXYMODE);
    }

    public final int getWFPROXYMODE() {
        return this.GetParamIntValue(TAG_WFPROXYMODE, 0);
    }

    public final void setWFPROXYMODE(int nValue) {
        this.SetParamValue(TAG_WFPROXYMODE, nValue);
    }

    public final boolean isPROXYDATAPSDEFIDNull() {
        return this.IsParamNull(TAG_PROXYDATAPSDEFID);
    }

    public final String getPROXYDATAPSDEFID() {
        return this.GetParamStringValue(TAG_PROXYDATAPSDEFID, "");
    }

    public final void setPROXYDATAPSDEFID(String strValue) {
        this.SetParamValue(TAG_PROXYDATAPSDEFID, strValue);
    }

    public final boolean isPROXYDATAPSDEFNAMENull() {
        return this.IsParamNull(TAG_PROXYDATAPSDEFNAME);
    }

    public final String getPROXYDATAPSDEFNAME() {
        return this.GetParamStringValue(TAG_PROXYDATAPSDEFNAME, "");
    }

    public final void setPROXYDATAPSDEFNAME(String strValue) {
        this.SetParamValue(TAG_PROXYDATAPSDEFNAME, strValue);
    }

    public final boolean isPROXYMODULEPSDEFIDNull() {
        return this.IsParamNull(TAG_PROXYMODULEPSDEFID);
    }

    public final String getPROXYMODULEPSDEFID() {
        return this.GetParamStringValue(TAG_PROXYMODULEPSDEFID, "");
    }

    public final void setPROXYMODULEPSDEFID(String strValue) {
        this.SetParamValue(TAG_PROXYMODULEPSDEFID, strValue);
    }

    public final boolean isPROXYMODULEPSDEFNAMENull() {
        return this.IsParamNull(TAG_PROXYMODULEPSDEFNAME);
    }

    public final String getPROXYMODULEPSDEFNAME() {
        return this.GetParamStringValue(TAG_PROXYMODULEPSDEFNAME, "");
    }

    public final void setPROXYMODULEPSDEFNAME(String strValue) {
        this.SetParamValue(TAG_PROXYMODULEPSDEFNAME, strValue);
    }

    public final boolean isPROXYWFPSDEFIDNull() {
        return this.IsParamNull(TAG_PROXYWFPSDEFID);
    }

    public final String getPROXYWFPSDEFID() {
        return this.GetParamStringValue(TAG_PROXYWFPSDEFID, "");
    }

    public final void setPROXYWFPSDEFID(String strValue) {
        this.SetParamValue(TAG_PROXYWFPSDEFID, strValue);
    }

    public final boolean isPROXYWFPSDEFNAMENull() {
        return this.IsParamNull(TAG_PROXYWFPSDEFNAME);
    }

    public final String getPROXYWFPSDEFNAME() {
        return this.GetParamStringValue(TAG_PROXYWFPSDEFNAME, "");
    }

    public final void setPROXYWFPSDEFNAME(String strValue) {
        this.SetParamValue(TAG_PROXYWFPSDEFNAME, strValue);
    }

    public final boolean isPROXYDATAPSDEVIEWIDNull() {
        return this.IsParamNull(TAG_PROXYDATAPSDEVIEWID);
    }

    public final String getPROXYDATAPSDEVIEWID() {
        return this.GetParamStringValue(TAG_PROXYDATAPSDEVIEWID, "");
    }

    public final void setPROXYDATAPSDEVIEWID(String strValue) {
        this.SetParamValue(TAG_PROXYDATAPSDEVIEWID, strValue);
    }

    public final boolean isPROXYDATAPSDEVIEWNAMENull() {
        return this.IsParamNull(TAG_PROXYDATAPSDEVIEWNAME);
    }

    public final String getPROXYDATAPSDEVIEWNAME() {
        return this.GetParamStringValue(TAG_PROXYDATAPSDEVIEWNAME, "");
    }

    public final void setPROXYDATAPSDEVIEWNAME(String strValue) {
        this.SetParamValue(TAG_PROXYDATAPSDEVIEWNAME, strValue);
    }

    public final boolean isMOBPROXYDATAPSDEVIEWIDNull() {
        return this.IsParamNull(TAG_MOBPROXYDATAPSDEVIEWID);
    }

    public final String getMOBPROXYDATAPSDEVIEWID() {
        return this.GetParamStringValue(TAG_MOBPROXYDATAPSDEVIEWID, "");
    }

    public final void setMOBPROXYDATAPSDEVIEWID(String strValue) {
        this.SetParamValue(TAG_MOBPROXYDATAPSDEVIEWID, strValue);
    }

    public final boolean isMOBPROXYDATAPSDEVIEWNAMENull() {
        return this.IsParamNull(TAG_MOBPROXYDATAPSDEVIEWNAME);
    }

    public final String getMOBPROXYDATAPSDEVIEWNAME() {
        return this.GetParamStringValue(TAG_MOBPROXYDATAPSDEVIEWNAME, "");
    }

    public final void setMOBPROXYDATAPSDEVIEWNAME(String strValue) {
        this.SetParamValue(TAG_MOBPROXYDATAPSDEVIEWNAME, strValue);
    }

    public final boolean isPROXYDATA2PSDEVIEWIDNull() {
        return this.IsParamNull(TAG_PROXYDATA2PSDEVIEWID);
    }

    public final String getPROXYDATA2PSDEVIEWID() {
        return this.GetParamStringValue(TAG_PROXYDATA2PSDEVIEWID, "");
    }

    public final void setPROXYDATA2PSDEVIEWID(String strValue) {
        this.SetParamValue(TAG_PROXYDATA2PSDEVIEWID, strValue);
    }

    public final boolean isPROXYDATA2PSDEVIEWNAMENull() {
        return this.IsParamNull(TAG_PROXYDATA2PSDEVIEWNAME);
    }

    public final String getPROXYDATA2PSDEVIEWNAME() {
        return this.GetParamStringValue(TAG_PROXYDATA2PSDEVIEWNAME, "");
    }

    public final void setPROXYDATA2PSDEVIEWNAME(String strValue) {
        this.SetParamValue(TAG_PROXYDATA2PSDEVIEWNAME, strValue);
    }

    public final boolean isMOBPROXYDATA2PSDEVIEWIDNull() {
        return this.IsParamNull(TAG_MOBPROXYDATA2PSDEVIEWID);
    }

    public final String getMOBPROXYDATA2PSDEVIEWID() {
        return this.GetParamStringValue(TAG_MOBPROXYDATA2PSDEVIEWID, "");
    }

    public final void setMOBPROXYDATA2PSDEVIEWID(String strValue) {
        this.SetParamValue(TAG_MOBPROXYDATA2PSDEVIEWID, strValue);
    }

    public final boolean isMOBPROXYDATA2PSDEVIEWNAMENull() {
        return this.IsParamNull(TAG_MOBPROXYDATA2PSDEVIEWNAME);
    }

    public final String getMOBPROXYDATA2PSDEVIEWNAME() {
        return this.GetParamStringValue(TAG_MOBPROXYDATA2PSDEVIEWNAME, "");
    }

    public final void setMOBPROXYDATA2PSDEVIEWNAME(String strValue) {
        this.SetParamValue(TAG_MOBPROXYDATA2PSDEVIEWNAME, strValue);
    }

    public final boolean isACTIONMOBPSDEVIEWIDNull() {
        return this.IsParamNull(TAG_ACTIONMOBPSDEVIEWID);
    }

    public final String getACTIONMOBPSDEVIEWID() {
        return this.GetParamStringValue(TAG_ACTIONMOBPSDEVIEWID, "");
    }

    public final void setACTIONMOBPSDEVIEWID(String strValue) {
        this.SetParamValue(TAG_ACTIONMOBPSDEVIEWID, strValue);
    }

    public final boolean isACTIONMOBPSDEVIEWNAMENull() {
        return this.IsParamNull(TAG_ACTIONMOBPSDEVIEWNAME);
    }

    public final String getACTIONMOBPSDEVIEWNAME() {
        return this.GetParamStringValue(TAG_ACTIONMOBPSDEVIEWNAME, "");
    }

    public final void setACTIONMOBPSDEVIEWNAME(String strValue) {
        this.SetParamValue(TAG_ACTIONMOBPSDEVIEWNAME, strValue);
    }

    public final boolean isACTIONPSDEVIEWIDNull() {
        return this.IsParamNull(TAG_ACTIONPSDEVIEWID);
    }

    public final String getACTIONPSDEVIEWID() {
        return this.GetParamStringValue(TAG_ACTIONPSDEVIEWID, "");
    }

    public final void setACTIONPSDEVIEWID(String strValue) {
        this.SetParamValue(TAG_ACTIONPSDEVIEWID, strValue);
    }

    public final boolean isACTIONPSDEVIEWNAMENull() {
        return this.IsParamNull(TAG_ACTIONPSDEVIEWNAME);
    }

    public final String getACTIONPSDEVIEWNAME() {
        return this.GetParamStringValue(TAG_ACTIONPSDEVIEWNAME, "");
    }

    public final void setACTIONPSDEVIEWNAME(String strValue) {
        this.SetParamValue(TAG_ACTIONPSDEVIEWNAME, strValue);
    }

    public final boolean isSTARTMOBPSDEVIEWIDNull() {
        return this.IsParamNull(TAG_STARTMOBPSDEVIEWID);
    }

    public final String getSTARTMOBPSDEVIEWID() {
        return this.GetParamStringValue(TAG_STARTMOBPSDEVIEWID, "");
    }

    public final void setSTARTMOBPSDEVIEWID(String strValue) {
        this.SetParamValue(TAG_STARTMOBPSDEVIEWID, strValue);
    }

    public final boolean isSTARTMOBPSDEVIEWNAMENull() {
        return this.IsParamNull(TAG_STARTMOBPSDEVIEWNAME);
    }

    public final String getSTARTMOBPSDEVIEWNAME() {
        return this.GetParamStringValue(TAG_STARTMOBPSDEVIEWNAME, "");
    }

    public final void setSTARTMOBPSDEVIEWNAME(String strValue) {
        this.SetParamValue(TAG_STARTMOBPSDEVIEWNAME, strValue);
    }

    public final boolean isSTARTPSDEVIEWIDNull() {
        return this.IsParamNull(TAG_STARTPSDEVIEWID);
    }

    public final String getSTARTPSDEVIEWID() {
        return this.GetParamStringValue(TAG_STARTPSDEVIEWID, "");
    }

    public final void setSTARTPSDEVIEWID(String strValue) {
        this.SetParamValue(TAG_STARTPSDEVIEWID, strValue);
    }

    public final boolean isSTARTPSDEVIEWNAMENull() {
        return this.IsParamNull(TAG_STARTPSDEVIEWNAME);
    }

    public final String getSTARTPSDEVIEWNAME() {
        return this.GetParamStringValue(TAG_STARTPSDEVIEWNAME, "");
    }

    public final void setSTARTPSDEVIEWNAME(String strValue) {
        this.SetParamValue(TAG_STARTPSDEVIEWNAME, strValue);
    }

    public final boolean isPWFINSTPSDEFIDNull() {
        return this.IsParamNull(TAG_PWFINSTPSDEFID);
    }

    public final String getPWFINSTPSDEFID() {
        return this.GetParamStringValue(TAG_PWFINSTPSDEFID, "");
    }

    public final void setPWFINSTPSDEFID(String strValue) {
        this.SetParamValue(TAG_PWFINSTPSDEFID, strValue);
    }

    public final boolean isPWFINSTPSDEFNAMENull() {
        return this.IsParamNull(TAG_PWFINSTPSDEFNAME);
    }

    public final String getPWFINSTPSDEFNAME() {
        return this.GetParamStringValue(TAG_PWFINSTPSDEFNAME, "");
    }

    public final void setPWFINSTPSDEFNAME(String strValue) {
        this.SetParamValue(TAG_PWFINSTPSDEFNAME, strValue);
    }

    public final boolean isSTARTVIEWCODENAMENull() {
        return this.IsParamNull(TAG_STARTVIEWCODENAME);
    }

    public final String getSTARTVIEWCODENAME() {
        return this.GetParamStringValue(TAG_STARTVIEWCODENAME, "");
    }

    public final void setSTARTVIEWCODENAME(String strValue) {
        this.SetParamValue(TAG_STARTVIEWCODENAME, strValue);
    }

    public final boolean isSTARTMOBVIEWCODENAMENull() {
        return this.IsParamNull(TAG_STARTMOBVIEWCODENAME);
    }

    public final String getSTARTMOBVIEWCODENAME() {
        return this.GetParamStringValue(TAG_STARTMOBVIEWCODENAME, "");
    }

    public final void setSTARTMOBVIEWCODENAME(String strValue) {
        this.SetParamValue(TAG_STARTMOBVIEWCODENAME, strValue);
    }

    public final boolean isACTIONMOBVIEWCODENAMENull() {
        return this.IsParamNull(TAG_ACTIONMOBVIEWCODENAME);
    }

    public final String getACTIONMOBVIEWCODENAME() {
        return this.GetParamStringValue(TAG_ACTIONMOBVIEWCODENAME, "");
    }

    public final void setACTIONMOBVIEWCODENAME(String strValue) {
        this.SetParamValue(TAG_ACTIONMOBVIEWCODENAME, strValue);
    }

    public final boolean isACTIONVIEWCODENAMENull() {
        return this.IsParamNull(TAG_ACTIONVIEWCODENAME);
    }

    public final String getACTIONVIEWCODENAME() {
        return this.GetParamStringValue(TAG_ACTIONVIEWCODENAME, "");
    }

    public final void setACTIONVIEWCODENAME(String strValue) {
        this.SetParamValue(TAG_ACTIONVIEWCODENAME, strValue);
    }

    public final boolean isWFCATCODENull() {
        return this.IsParamNull(TAG_WFCATCODE);
    }

    public final String getWFCATCODE() {
        return this.GetParamStringValue(TAG_WFCATCODE, "");
    }

    public final void setWFCATCODE(String strValue) {
        this.SetParamValue(TAG_WFCATCODE, strValue);
    }
}

