/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFDA.PS.Data.PSWFLinkCond;
import SA.SRFDA.PS.Data.PSWFLinkRole;
import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.ArrayList;
import java.util.Date;

public class PSWFLink
extends BaseDataEntity {
    public static final String WFLINKTYPE_TIMEOUT = "TIMEOUT";
    public static final String WFLINKTYPE_IAACTION = "IAACTION";
    public static final String WFLINKTYPE_ROUTE = "ROUTE";
    public static final String TAG_PSWFLINKID = "PSWFLINKID";
    public static final String TAG_PSWFLINKNAME = "PSWFLINKNAME";
    public static final String TAG_ENABLE = "ENABLE";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSWFVERSIONID = "PSWFVERSIONID";
    public static final String TAG_PSWFVERSIONNAME = "PSWFVERSIONNAME";
    public static final String TAG_PSWFID = "PSWFID";
    public static final String TAG_PSWFNAME = "PSWFNAME";
    public static final String TAG_FROMPSWFPROCID = "FROMPSWFPROCID";
    public static final String TAG_FROMPSWFPROCNAME = "FROMPSWFPROCNAME";
    public static final String TAG_TOPSWFPROCID = "TOPSWFPROCID";
    public static final String TAG_TOPSWFPROCNAME = "TOPSWFPROCNAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_ORDERVALUE = "ORDERVALUE";
    public static final String TAG_SRCENDPOINT = "SRCENDPOINT";
    public static final String TAG_DSTENDPOINT = "DSTENDPOINT";
    public static final String TAG_PSSYSTEMID = "PSSYSTEMID";
    public static final String TAG_WFLINKTYPE = "WFLINKTYPE";
    public static final String TAG_LOGICNAME = "LOGICNAME";
    public static final String TAG_NEXTCOND = "NEXTCOND";
    public static final String TAG_SOMEROLEFLAG = "SOMEROLEFLAG";
    public static final String TAG_PSDEVIEWBASEID = "PSDEVIEWBASEID";
    public static final String TAG_PSDEVIEWBASENAME = "PSDEVIEWBASENAME";
    public static final String TAG_LABEL = "LABEL";
    public static final String TAG_DEFAULTLINK = "DEFAULTLINK";
    public static final String TAG_MEMOFIELD = "MEMOFIELD";
    public static final String TAG_USERDATA = "USERDATA";
    public static final String TAG_USERDATA2 = "USERDATA2";
    public static final String TAG_ACTIONFIELD = "ACTIONFIELD";
    public static final String TAG_ACTIONPSCODELISTID = "ACTIONPSCODELISTID";
    public static final String TAG_ACTIONPSCODELISTNAME = "ACTIONPSCODELISTNAME";
    public static final String TAG_ACTORFIELDS = "ACTORFIELDS";
    public static final String TAG_PSWFROLEID = "PSWFROLEID";
    public static final String TAG_PSWFROLENAME = "PSWFROLENAME";
    public static final String TAG_MOBPSDEVIEWID = "MOBPSDEVIEWID";
    public static final String TAG_MOBPSDEVIEWNAME = "MOBPSDEVIEWNAME";
    public static final String TAG_LNPSLANRESID = "LNPSLANRESID";
    public static final String TAG_LNPSLANRESNAME = "LNPSLANRESNAME";
    public static final String TAG_THREADFLAG = "THREADFLAG";
    public static final String TAG_THREADNAME = "THREADNAME";
    public static final String TAG_MODELID = "MODELID";
    public static final String TAG_WFENGINETYPE = "WFENGINETYPE";
    public static final String TAG_CUSTOMCOND = "CUSTOMCOND";
    public static final String TAG_CUSTOMCONDFLAG = "CUSTOMCONDFLAG";
    public static final String TAG_MOBPSDEFORMID = "MOBPSDEFORMID";
    public static final String TAG_MOBPSDEFORMNAME = "MOBPSDEFORMNAME";
    public static final String TAG_PSDEFORMID = "PSDEFORMID";
    public static final String TAG_PSDEFORMNAME = "PSDEFORMNAME";
    public static final String TAG_MOBFORMCODENAME = "MOBFORMCODENAME";
    public static final String TAG_FORMCODENAME = "FORMCODENAME";
    public static final String TAG_VIEWCODENAME = "VIEWCODENAME";
    public static final String TAG_MOBVIEWCODENAME = "MOBVIEWCODENAME";
    private ArrayList<PSWFLinkRole> childPSWFLinkRoleList = null;
    private ArrayList<PSWFLinkCond> childPSWFLinkCondList = null;

    public final boolean isPSWFLINKIDNull() {
        return this.IsParamNull(TAG_PSWFLINKID);
    }

    public final String getPSWFLINKID() {
        return this.GetParamStringValue(TAG_PSWFLINKID, "");
    }

    public final void setPSWFLINKID(String strValue) {
        this.SetParamValue(TAG_PSWFLINKID, strValue);
    }

    public final boolean isPSWFLINKNAMENull() {
        return this.IsParamNull(TAG_PSWFLINKNAME);
    }

    public final String getPSWFLINKNAME() {
        return this.GetParamStringValue(TAG_PSWFLINKNAME, "");
    }

    public final void setPSWFLINKNAME(String strValue) {
        this.SetParamValue(TAG_PSWFLINKNAME, strValue);
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

    public final boolean isPSWFVERSIONIDNull() {
        return this.IsParamNull(TAG_PSWFVERSIONID);
    }

    public final String getPSWFVERSIONID() {
        return this.GetParamStringValue(TAG_PSWFVERSIONID, "");
    }

    public final void setPSWFVERSIONID(String strValue) {
        this.SetParamValue(TAG_PSWFVERSIONID, strValue);
    }

    public final boolean isPSWFVERSIONNAMENull() {
        return this.IsParamNull(TAG_PSWFVERSIONNAME);
    }

    public final String getPSWFVERSIONNAME() {
        return this.GetParamStringValue(TAG_PSWFVERSIONNAME, "");
    }

    public final void setPSWFVERSIONNAME(String strValue) {
        this.SetParamValue(TAG_PSWFVERSIONNAME, strValue);
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

    public final boolean isFROMPSWFPROCIDNull() {
        return this.IsParamNull(TAG_FROMPSWFPROCID);
    }

    public final String getFROMPSWFPROCID() {
        return this.GetParamStringValue(TAG_FROMPSWFPROCID, "");
    }

    public final void setFROMPSWFPROCID(String strValue) {
        this.SetParamValue(TAG_FROMPSWFPROCID, strValue);
    }

    public final boolean isFROMPSWFPROCNAMENull() {
        return this.IsParamNull(TAG_FROMPSWFPROCNAME);
    }

    public final String getFROMPSWFPROCNAME() {
        return this.GetParamStringValue(TAG_FROMPSWFPROCNAME, "");
    }

    public final void setFROMPSWFPROCNAME(String strValue) {
        this.SetParamValue(TAG_FROMPSWFPROCNAME, strValue);
    }

    public final boolean isTOPSWFPROCIDNull() {
        return this.IsParamNull(TAG_TOPSWFPROCID);
    }

    public final String getTOPSWFPROCID() {
        return this.GetParamStringValue(TAG_TOPSWFPROCID, "");
    }

    public final void setTOPSWFPROCID(String strValue) {
        this.SetParamValue(TAG_TOPSWFPROCID, strValue);
    }

    public final boolean isTOPSWFPROCNAMENull() {
        return this.IsParamNull(TAG_TOPSWFPROCNAME);
    }

    public final String getTOPSWFPROCNAME() {
        return this.GetParamStringValue(TAG_TOPSWFPROCNAME, "");
    }

    public final void setTOPSWFPROCNAME(String strValue) {
        this.SetParamValue(TAG_TOPSWFPROCNAME, strValue);
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

    public final boolean isORDERVALUENull() {
        return this.IsParamNull(TAG_ORDERVALUE);
    }

    public final int getORDERVALUE() {
        return this.GetParamIntValue(TAG_ORDERVALUE, 0);
    }

    public final void setORDERVALUE(int nValue) {
        this.SetParamValue(TAG_ORDERVALUE, nValue);
    }

    public final boolean isSRCENDPOINTNull() {
        return this.IsParamNull(TAG_SRCENDPOINT);
    }

    public final String getSRCENDPOINT() {
        return this.GetParamStringValue(TAG_SRCENDPOINT, "");
    }

    public final void setSRCENDPOINT(String strValue) {
        this.SetParamValue(TAG_SRCENDPOINT, strValue);
    }

    public final boolean isDSTENDPOINTNull() {
        return this.IsParamNull(TAG_DSTENDPOINT);
    }

    public final String getDSTENDPOINT() {
        return this.GetParamStringValue(TAG_DSTENDPOINT, "");
    }

    public final void setDSTENDPOINT(String strValue) {
        this.SetParamValue(TAG_DSTENDPOINT, strValue);
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

    public final boolean isWFLINKTYPENull() {
        return this.IsParamNull(TAG_WFLINKTYPE);
    }

    public final String getWFLINKTYPE() {
        return this.GetParamStringValue(TAG_WFLINKTYPE, "");
    }

    public final void setWFLINKTYPE(String strValue) {
        this.SetParamValue(TAG_WFLINKTYPE, strValue);
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

    public final boolean isNEXTCONDNull() {
        return this.IsParamNull(TAG_NEXTCOND);
    }

    public final String getNEXTCOND() {
        return this.GetParamStringValue(TAG_NEXTCOND, "");
    }

    public final void setNEXTCOND(String strValue) {
        this.SetParamValue(TAG_NEXTCOND, strValue);
    }

    public final boolean isSOMEROLEFLAGNull() {
        return this.IsParamNull(TAG_SOMEROLEFLAG);
    }

    public final boolean getSOMEROLEFLAG() {
        return this.GetParamIntValue(TAG_SOMEROLEFLAG, 0) == 1;
    }

    public final void setSOMEROLEFLAG(boolean bValue) {
        this.SetParamValue(TAG_SOMEROLEFLAG, bValue ? 1 : 0);
    }

    public final boolean isPSDEVIEWBASEIDNull() {
        return this.IsParamNull(TAG_PSDEVIEWBASEID);
    }

    public final String getPSDEVIEWBASEID() {
        return this.GetParamStringValue(TAG_PSDEVIEWBASEID, "");
    }

    public final void setPSDEVIEWBASEID(String strValue) {
        this.SetParamValue(TAG_PSDEVIEWBASEID, strValue);
    }

    public final boolean isPSDEVIEWBASENAMENull() {
        return this.IsParamNull(TAG_PSDEVIEWBASENAME);
    }

    public final String getPSDEVIEWBASENAME() {
        return this.GetParamStringValue(TAG_PSDEVIEWBASENAME, "");
    }

    public final void setPSDEVIEWBASENAME(String strValue) {
        this.SetParamValue(TAG_PSDEVIEWBASENAME, strValue);
    }

    public final boolean isLABELNull() {
        return this.IsParamNull(TAG_LABEL);
    }

    public final String getLABEL() {
        return this.GetParamStringValue(TAG_LABEL, "");
    }

    public final void setLABEL(String strValue) {
        this.SetParamValue(TAG_LABEL, strValue);
    }

    public final boolean isDEFAULTLINKNull() {
        return this.IsParamNull(TAG_DEFAULTLINK);
    }

    public final boolean getDEFAULTLINK() {
        return this.GetParamIntValue(TAG_DEFAULTLINK, 0) == 1;
    }

    public final void setDEFAULTLINK(boolean bValue) {
        this.SetParamValue(TAG_DEFAULTLINK, bValue ? 1 : 0);
    }

    public final boolean isMEMOFIELDNull() {
        return this.IsParamNull(TAG_MEMOFIELD);
    }

    public final String getMEMOFIELD() {
        return this.GetParamStringValue(TAG_MEMOFIELD, "");
    }

    public final void setMEMOFIELD(String strValue) {
        this.SetParamValue(TAG_MEMOFIELD, strValue);
    }

    public final boolean isUSERDATANull() {
        return this.IsParamNull(TAG_USERDATA);
    }

    public final String getUSERDATA() {
        return this.GetParamStringValue(TAG_USERDATA, "");
    }

    public final void setUSERDATA(String strValue) {
        this.SetParamValue(TAG_USERDATA, strValue);
    }

    public final boolean isUSERDATA2Null() {
        return this.IsParamNull(TAG_USERDATA2);
    }

    public final String getUSERDATA2() {
        return this.GetParamStringValue(TAG_USERDATA2, "");
    }

    public final void setUSERDATA2(String strValue) {
        this.SetParamValue(TAG_USERDATA2, strValue);
    }

    public final boolean isACTIONFIELDNull() {
        return this.IsParamNull(TAG_ACTIONFIELD);
    }

    public final String getACTIONFIELD() {
        return this.GetParamStringValue(TAG_ACTIONFIELD, "");
    }

    public final void setACTIONFIELD(String strValue) {
        this.SetParamValue(TAG_ACTIONFIELD, strValue);
    }

    public final boolean isACTIONPSCODELISTIDNull() {
        return this.IsParamNull(TAG_ACTIONPSCODELISTID);
    }

    public final String getACTIONPSCODELISTID() {
        return this.GetParamStringValue(TAG_ACTIONPSCODELISTID, "");
    }

    public final void setACTIONPSCODELISTID(String strValue) {
        this.SetParamValue(TAG_ACTIONPSCODELISTID, strValue);
    }

    public final boolean isACTIONPSCODELISTNAMENull() {
        return this.IsParamNull(TAG_ACTIONPSCODELISTNAME);
    }

    public final String getACTIONPSCODELISTNAME() {
        return this.GetParamStringValue(TAG_ACTIONPSCODELISTNAME, "");
    }

    public final void setACTIONPSCODELISTNAME(String strValue) {
        this.SetParamValue(TAG_ACTIONPSCODELISTNAME, strValue);
    }

    public final boolean isACTORFIELDSNull() {
        return this.IsParamNull(TAG_ACTORFIELDS);
    }

    public final String getACTORFIELDS() {
        return this.GetParamStringValue(TAG_ACTORFIELDS, "");
    }

    public final void setACTORFIELDS(String strValue) {
        this.SetParamValue(TAG_ACTORFIELDS, strValue);
    }

    public final boolean isPSWFROLEIDNull() {
        return this.IsParamNull(TAG_PSWFROLEID);
    }

    public final String getPSWFROLEID() {
        return this.GetParamStringValue(TAG_PSWFROLEID, "");
    }

    public final void setPSWFROLEID(String strValue) {
        this.SetParamValue(TAG_PSWFROLEID, strValue);
    }

    public final boolean isPSWFROLENAMENull() {
        return this.IsParamNull(TAG_PSWFROLENAME);
    }

    public final String getPSWFROLENAME() {
        return this.GetParamStringValue(TAG_PSWFROLENAME, "");
    }

    public final void setPSWFROLENAME(String strValue) {
        this.SetParamValue(TAG_PSWFROLENAME, strValue);
    }

    public final boolean isMOBPSDEVIEWIDNull() {
        return this.IsParamNull(TAG_MOBPSDEVIEWID);
    }

    public final String getMOBPSDEVIEWID() {
        return this.GetParamStringValue(TAG_MOBPSDEVIEWID, "");
    }

    public final void setMOBPSDEVIEWID(String strValue) {
        this.SetParamValue(TAG_MOBPSDEVIEWID, strValue);
    }

    public final boolean isMOBPSDEVIEWNAMENull() {
        return this.IsParamNull(TAG_MOBPSDEVIEWNAME);
    }

    public final String getMOBPSDEVIEWNAME() {
        return this.GetParamStringValue(TAG_MOBPSDEVIEWNAME, "");
    }

    public final void setMOBPSDEVIEWNAME(String strValue) {
        this.SetParamValue(TAG_MOBPSDEVIEWNAME, strValue);
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

    public final boolean isTHREADFLAGNull() {
        return this.IsParamNull(TAG_THREADFLAG);
    }

    public final int getTHREADFLAG() {
        return this.GetParamIntValue(TAG_THREADFLAG, 0);
    }

    public final void setTHREADFLAG(int nValue) {
        this.SetParamValue(TAG_THREADFLAG, nValue);
    }

    public final boolean isTHREADNAMENull() {
        return this.IsParamNull(TAG_THREADNAME);
    }

    public final String getTHREADNAME() {
        return this.GetParamStringValue(TAG_THREADNAME, "");
    }

    public final void setTHREADNAME(String strValue) {
        this.SetParamValue(TAG_THREADNAME, strValue);
    }

    public final boolean isMODELIDNull() {
        return this.IsParamNull(TAG_MODELID);
    }

    public final String getMODELID() {
        return this.GetParamStringValue(TAG_MODELID, "");
    }

    public final void setMODELID(String strValue) {
        this.SetParamValue(TAG_MODELID, strValue);
    }

    public final boolean isWFENGINETYPENull() {
        return this.IsParamNull(TAG_WFENGINETYPE);
    }

    public final String getWFENGINETYPE() {
        return this.GetParamStringValue(TAG_WFENGINETYPE, "");
    }

    public final void setWFENGINETYPE(String strValue) {
        this.SetParamValue(TAG_WFENGINETYPE, strValue);
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

    public final boolean isCUSTOMCONDFLAGNull() {
        return this.IsParamNull(TAG_CUSTOMCONDFLAG);
    }

    public final boolean getCUSTOMCONDFLAG() {
        return this.GetParamIntValue(TAG_CUSTOMCONDFLAG, 0) == 1;
    }

    public final void setCUSTOMCONDFLAG(boolean bValue) {
        this.SetParamValue(TAG_CUSTOMCONDFLAG, bValue ? 1 : 0);
    }

    public final boolean isMOBPSDEFORMIDNull() {
        return this.IsParamNull(TAG_MOBPSDEFORMID);
    }

    public final String getMOBPSDEFORMID() {
        return this.GetParamStringValue(TAG_MOBPSDEFORMID, "");
    }

    public final void setMOBPSDEFORMID(String strValue) {
        this.SetParamValue(TAG_MOBPSDEFORMID, strValue);
    }

    public final boolean isMOBPSDEFORMNAMENull() {
        return this.IsParamNull(TAG_MOBPSDEFORMNAME);
    }

    public final String getMOBPSDEFORMNAME() {
        return this.GetParamStringValue(TAG_MOBPSDEFORMNAME, "");
    }

    public final void setMOBPSDEFORMNAME(String strValue) {
        this.SetParamValue(TAG_MOBPSDEFORMNAME, strValue);
    }

    public final boolean isPSDEFORMIDNull() {
        return this.IsParamNull(TAG_PSDEFORMID);
    }

    public final String getPSDEFORMID() {
        return this.GetParamStringValue(TAG_PSDEFORMID, "");
    }

    public final void setPSDEFORMID(String strValue) {
        this.SetParamValue(TAG_PSDEFORMID, strValue);
    }

    public final boolean isPSDEFORMNAMENull() {
        return this.IsParamNull(TAG_PSDEFORMNAME);
    }

    public final String getPSDEFORMNAME() {
        return this.GetParamStringValue(TAG_PSDEFORMNAME, "");
    }

    public final void setPSDEFORMNAME(String strValue) {
        this.SetParamValue(TAG_PSDEFORMNAME, strValue);
    }

    public final boolean isMOBFORMCODENAMENull() {
        return this.IsParamNull(TAG_MOBFORMCODENAME);
    }

    public final String getMOBFORMCODENAME() {
        return this.GetParamStringValue(TAG_MOBFORMCODENAME, "");
    }

    public final void setMOBFORMCODENAME(String strValue) {
        this.SetParamValue(TAG_MOBFORMCODENAME, strValue);
    }

    public final boolean isFORMCODENAMENull() {
        return this.IsParamNull(TAG_FORMCODENAME);
    }

    public final String getFORMCODENAME() {
        return this.GetParamStringValue(TAG_FORMCODENAME, "");
    }

    public final void setFORMCODENAME(String strValue) {
        this.SetParamValue(TAG_FORMCODENAME, strValue);
    }

    public final boolean isVIEWCODENAMENull() {
        return this.IsParamNull(TAG_VIEWCODENAME);
    }

    public final String getVIEWCODENAME() {
        return this.GetParamStringValue(TAG_VIEWCODENAME, "");
    }

    public final void setVIEWCODENAME(String strValue) {
        this.SetParamValue(TAG_VIEWCODENAME, strValue);
    }

    public final boolean isMOBVIEWCODENAMENull() {
        return this.IsParamNull(TAG_MOBVIEWCODENAME);
    }

    public final String getMOBVIEWCODENAME() {
        return this.GetParamStringValue(TAG_MOBVIEWCODENAME, "");
    }

    public final void setMOBVIEWCODENAME(String strValue) {
        this.SetParamValue(TAG_MOBVIEWCODENAME, strValue);
    }

    public ArrayList<PSWFLinkRole> getPSWFLinkRoles(boolean bCreated) {
        if (this.childPSWFLinkRoleList != null) {
            return this.childPSWFLinkRoleList;
        }
        if (bCreated) {
            this.childPSWFLinkRoleList = new ArrayList();
        }
        return this.childPSWFLinkRoleList;
    }

    public ArrayList<PSWFLinkCond> getPSWFLinkConds(boolean bCreated) {
        if (this.childPSWFLinkCondList != null) {
            return this.childPSWFLinkCondList;
        }
        if (bCreated) {
            this.childPSWFLinkCondList = new ArrayList();
        }
        return this.childPSWFLinkCondList;
    }

    public void resetChildDatas() {
        if (this.childPSWFLinkRoleList != null) {
            this.childPSWFLinkRoleList.clear();
            this.childPSWFLinkRoleList = null;
        }
        if (this.childPSWFLinkCondList != null) {
            this.childPSWFLinkCondList.clear();
            this.childPSWFLinkCondList = null;
        }
    }
}

