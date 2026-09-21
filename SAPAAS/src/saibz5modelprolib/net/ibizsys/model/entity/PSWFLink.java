/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.entity;

import java.util.ArrayList;
import java.util.Date;
import net.ibizsys.model.entity.BaseDataEntity;
import net.ibizsys.model.entity.PSWFLinkCond;

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
    public static final String TAG_CODENAME = "CODENAME";
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
    private ArrayList<PSWFLinkCond> childPSWFLinkCondList = null;

    public final boolean isPSWFLINKIDNull() {
        return this.isParamNull(TAG_PSWFLINKID);
    }

    public final String getPSWFLINKID() {
        return this.getParamStringValue(TAG_PSWFLINKID, "");
    }

    public final void setPSWFLINKID(String strValue) {
        this.setParamValue(TAG_PSWFLINKID, strValue);
    }

    public final boolean isPSWFLINKNAMENull() {
        return this.isParamNull(TAG_PSWFLINKNAME);
    }

    public final String getPSWFLINKNAME() {
        return this.getParamStringValue(TAG_PSWFLINKNAME, "");
    }

    public final void setPSWFLINKNAME(String strValue) {
        this.setParamValue(TAG_PSWFLINKNAME, strValue);
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

    public final boolean isPSWFVERSIONIDNull() {
        return this.isParamNull(TAG_PSWFVERSIONID);
    }

    public final String getPSWFVERSIONID() {
        return this.getParamStringValue(TAG_PSWFVERSIONID, "");
    }

    public final void setPSWFVERSIONID(String strValue) {
        this.setParamValue(TAG_PSWFVERSIONID, strValue);
    }

    public final boolean isPSWFVERSIONNAMENull() {
        return this.isParamNull(TAG_PSWFVERSIONNAME);
    }

    public final String getPSWFVERSIONNAME() {
        return this.getParamStringValue(TAG_PSWFVERSIONNAME, "");
    }

    public final void setPSWFVERSIONNAME(String strValue) {
        this.setParamValue(TAG_PSWFVERSIONNAME, strValue);
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

    public final boolean isFROMPSWFPROCIDNull() {
        return this.isParamNull(TAG_FROMPSWFPROCID);
    }

    public final String getFROMPSWFPROCID() {
        return this.getParamStringValue(TAG_FROMPSWFPROCID, "");
    }

    public final void setFROMPSWFPROCID(String strValue) {
        this.setParamValue(TAG_FROMPSWFPROCID, strValue);
    }

    public final boolean isFROMPSWFPROCNAMENull() {
        return this.isParamNull(TAG_FROMPSWFPROCNAME);
    }

    public final String getFROMPSWFPROCNAME() {
        return this.getParamStringValue(TAG_FROMPSWFPROCNAME, "");
    }

    public final void setFROMPSWFPROCNAME(String strValue) {
        this.setParamValue(TAG_FROMPSWFPROCNAME, strValue);
    }

    public final boolean isTOPSWFPROCIDNull() {
        return this.isParamNull(TAG_TOPSWFPROCID);
    }

    public final String getTOPSWFPROCID() {
        return this.getParamStringValue(TAG_TOPSWFPROCID, "");
    }

    public final void setTOPSWFPROCID(String strValue) {
        this.setParamValue(TAG_TOPSWFPROCID, strValue);
    }

    public final boolean isTOPSWFPROCNAMENull() {
        return this.isParamNull(TAG_TOPSWFPROCNAME);
    }

    public final String getTOPSWFPROCNAME() {
        return this.getParamStringValue(TAG_TOPSWFPROCNAME, "");
    }

    public final void setTOPSWFPROCNAME(String strValue) {
        this.setParamValue(TAG_TOPSWFPROCNAME, strValue);
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

    public final boolean isORDERVALUENull() {
        return this.isParamNull(TAG_ORDERVALUE);
    }

    public final int getORDERVALUE() {
        return this.getParamIntValue(TAG_ORDERVALUE, 0);
    }

    public final void setORDERVALUE(int nValue) {
        this.setParamValue(TAG_ORDERVALUE, nValue);
    }

    public final boolean isSRCENDPOINTNull() {
        return this.isParamNull(TAG_SRCENDPOINT);
    }

    public final String getSRCENDPOINT() {
        return this.getParamStringValue(TAG_SRCENDPOINT, "");
    }

    public final void setSRCENDPOINT(String strValue) {
        this.setParamValue(TAG_SRCENDPOINT, strValue);
    }

    public final boolean isDSTENDPOINTNull() {
        return this.isParamNull(TAG_DSTENDPOINT);
    }

    public final String getDSTENDPOINT() {
        return this.getParamStringValue(TAG_DSTENDPOINT, "");
    }

    public final void setDSTENDPOINT(String strValue) {
        this.setParamValue(TAG_DSTENDPOINT, strValue);
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

    public final boolean isWFLINKTYPENull() {
        return this.isParamNull(TAG_WFLINKTYPE);
    }

    public final String getWFLINKTYPE() {
        return this.getParamStringValue(TAG_WFLINKTYPE, "");
    }

    public final void setWFLINKTYPE(String strValue) {
        this.setParamValue(TAG_WFLINKTYPE, strValue);
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

    public final boolean isNEXTCONDNull() {
        return this.isParamNull(TAG_NEXTCOND);
    }

    public final String getNEXTCOND() {
        return this.getParamStringValue(TAG_NEXTCOND, "");
    }

    public final void setNEXTCOND(String strValue) {
        this.setParamValue(TAG_NEXTCOND, strValue);
    }

    public final boolean isSOMEROLEFLAGNull() {
        return this.isParamNull(TAG_SOMEROLEFLAG);
    }

    public final boolean getSOMEROLEFLAG() {
        return this.getParamIntValue(TAG_SOMEROLEFLAG, 0) == 1;
    }

    public final void setSOMEROLEFLAG(boolean bValue) {
        this.setParamValue(TAG_SOMEROLEFLAG, bValue ? 1 : 0);
    }

    public final boolean isPSDEVIEWBASEIDNull() {
        return this.isParamNull(TAG_PSDEVIEWBASEID);
    }

    public final String getPSDEVIEWBASEID() {
        return this.getParamStringValue(TAG_PSDEVIEWBASEID, "");
    }

    public final void setPSDEVIEWBASEID(String strValue) {
        this.setParamValue(TAG_PSDEVIEWBASEID, strValue);
    }

    public final boolean isPSDEVIEWBASENAMENull() {
        return this.isParamNull(TAG_PSDEVIEWBASENAME);
    }

    public final String getPSDEVIEWBASENAME() {
        return this.getParamStringValue(TAG_PSDEVIEWBASENAME, "");
    }

    public final void setPSDEVIEWBASENAME(String strValue) {
        this.setParamValue(TAG_PSDEVIEWBASENAME, strValue);
    }

    public final boolean isLABELNull() {
        return this.isParamNull(TAG_LABEL);
    }

    public final String getLABEL() {
        return this.getParamStringValue(TAG_LABEL, "");
    }

    public final void setLABEL(String strValue) {
        this.setParamValue(TAG_LABEL, strValue);
    }

    public final boolean isDEFAULTLINKNull() {
        return this.isParamNull(TAG_DEFAULTLINK);
    }

    public final boolean getDEFAULTLINK() {
        return this.getParamIntValue(TAG_DEFAULTLINK, 0) == 1;
    }

    public final void setDEFAULTLINK(boolean bValue) {
        this.setParamValue(TAG_DEFAULTLINK, bValue ? 1 : 0);
    }

    public final boolean isMEMOFIELDNull() {
        return this.isParamNull(TAG_MEMOFIELD);
    }

    public final String getMEMOFIELD() {
        return this.getParamStringValue(TAG_MEMOFIELD, "");
    }

    public final void setMEMOFIELD(String strValue) {
        this.setParamValue(TAG_MEMOFIELD, strValue);
    }

    public final boolean isUSERDATANull() {
        return this.isParamNull(TAG_USERDATA);
    }

    public final String getUSERDATA() {
        return this.getParamStringValue(TAG_USERDATA, "");
    }

    public final void setUSERDATA(String strValue) {
        this.setParamValue(TAG_USERDATA, strValue);
    }

    public final boolean isUSERDATA2Null() {
        return this.isParamNull(TAG_USERDATA2);
    }

    public final String getUSERDATA2() {
        return this.getParamStringValue(TAG_USERDATA2, "");
    }

    public final void setUSERDATA2(String strValue) {
        this.setParamValue(TAG_USERDATA2, strValue);
    }

    public final boolean isACTIONFIELDNull() {
        return this.isParamNull(TAG_ACTIONFIELD);
    }

    public final String getACTIONFIELD() {
        return this.getParamStringValue(TAG_ACTIONFIELD, "");
    }

    public final void setACTIONFIELD(String strValue) {
        this.setParamValue(TAG_ACTIONFIELD, strValue);
    }

    public final boolean isACTIONPSCODELISTIDNull() {
        return this.isParamNull(TAG_ACTIONPSCODELISTID);
    }

    public final String getACTIONPSCODELISTID() {
        return this.getParamStringValue(TAG_ACTIONPSCODELISTID, "");
    }

    public final void setACTIONPSCODELISTID(String strValue) {
        this.setParamValue(TAG_ACTIONPSCODELISTID, strValue);
    }

    public final boolean isACTIONPSCODELISTNAMENull() {
        return this.isParamNull(TAG_ACTIONPSCODELISTNAME);
    }

    public final String getACTIONPSCODELISTNAME() {
        return this.getParamStringValue(TAG_ACTIONPSCODELISTNAME, "");
    }

    public final void setACTIONPSCODELISTNAME(String strValue) {
        this.setParamValue(TAG_ACTIONPSCODELISTNAME, strValue);
    }

    public final boolean isACTORFIELDSNull() {
        return this.isParamNull(TAG_ACTORFIELDS);
    }

    public final String getACTORFIELDS() {
        return this.getParamStringValue(TAG_ACTORFIELDS, "");
    }

    public final void setACTORFIELDS(String strValue) {
        this.setParamValue(TAG_ACTORFIELDS, strValue);
    }

    public final boolean isPSWFROLEIDNull() {
        return this.isParamNull(TAG_PSWFROLEID);
    }

    public final String getPSWFROLEID() {
        return this.getParamStringValue(TAG_PSWFROLEID, "");
    }

    public final void setPSWFROLEID(String strValue) {
        this.setParamValue(TAG_PSWFROLEID, strValue);
    }

    public final boolean isPSWFROLENAMENull() {
        return this.isParamNull(TAG_PSWFROLENAME);
    }

    public final String getPSWFROLENAME() {
        return this.getParamStringValue(TAG_PSWFROLENAME, "");
    }

    public final void setPSWFROLENAME(String strValue) {
        this.setParamValue(TAG_PSWFROLENAME, strValue);
    }

    public final boolean isMOBPSDEVIEWIDNull() {
        return this.isParamNull(TAG_MOBPSDEVIEWID);
    }

    public final String getMOBPSDEVIEWID() {
        return this.getParamStringValue(TAG_MOBPSDEVIEWID, "");
    }

    public final void setMOBPSDEVIEWID(String strValue) {
        this.setParamValue(TAG_MOBPSDEVIEWID, strValue);
    }

    public final boolean isMOBPSDEVIEWNAMENull() {
        return this.isParamNull(TAG_MOBPSDEVIEWNAME);
    }

    public final String getMOBPSDEVIEWNAME() {
        return this.getParamStringValue(TAG_MOBPSDEVIEWNAME, "");
    }

    public final void setMOBPSDEVIEWNAME(String strValue) {
        this.setParamValue(TAG_MOBPSDEVIEWNAME, strValue);
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

    public final boolean isTHREADFLAGNull() {
        return this.isParamNull(TAG_THREADFLAG);
    }

    public final int getTHREADFLAG() {
        return this.getParamIntValue(TAG_THREADFLAG, 0);
    }

    public final void setTHREADFLAG(int nValue) {
        this.setParamValue(TAG_THREADFLAG, nValue);
    }

    public final boolean isTHREADNAMENull() {
        return this.isParamNull(TAG_THREADNAME);
    }

    public final String getTHREADNAME() {
        return this.getParamStringValue(TAG_THREADNAME, "");
    }

    public final void setTHREADNAME(String strValue) {
        this.setParamValue(TAG_THREADNAME, strValue);
    }

    public final boolean isMODELIDNull() {
        return this.isParamNull(TAG_MODELID);
    }

    public final String getMODELID() {
        return this.getParamStringValue(TAG_MODELID, "");
    }

    public final void setMODELID(String strValue) {
        this.setParamValue(TAG_MODELID, strValue);
    }

    public final boolean isWFENGINETYPENull() {
        return this.isParamNull(TAG_WFENGINETYPE);
    }

    public final String getWFENGINETYPE() {
        return this.getParamStringValue(TAG_WFENGINETYPE, "");
    }

    public final void setWFENGINETYPE(String strValue) {
        this.setParamValue(TAG_WFENGINETYPE, strValue);
    }

    public final boolean isCUSTOMCONDNull() {
        return this.isParamNull(TAG_CUSTOMCOND);
    }

    public final String getCUSTOMCOND() {
        return this.getParamStringValue(TAG_CUSTOMCOND, "");
    }

    public final void setCUSTOMCOND(String strValue) {
        this.setParamValue(TAG_CUSTOMCOND, strValue);
    }

    public final boolean isCUSTOMCONDFLAGNull() {
        return this.isParamNull(TAG_CUSTOMCONDFLAG);
    }

    public final boolean getCUSTOMCONDFLAG() {
        return this.getParamIntValue(TAG_CUSTOMCONDFLAG, 0) == 1;
    }

    public final void setCUSTOMCONDFLAG(boolean bValue) {
        this.setParamValue(TAG_CUSTOMCONDFLAG, bValue ? 1 : 0);
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
        if (this.childPSWFLinkCondList != null) {
            this.childPSWFLinkCondList.clear();
            this.childPSWFLinkCondList = null;
        }
    }
}

