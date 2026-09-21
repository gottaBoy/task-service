/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.entity;

import java.util.Date;
import net.ibizsys.model.entity.BaseDataEntity;

public class PSDEDataQuery
extends BaseDataEntity {
    public static final String TAG_PSDEDATAQUERYID = "PSDEDATAQUERYID";
    public static final String TAG_PSDEDATAQUERYNAME = "PSDEDATAQUERYNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSDEID = "PSDEID";
    public static final String TAG_PSDENAME = "PSDENAME";
    public static final String TAG_DQSN = "DQSN";
    public static final String TAG_DQJOINMODEL = "DQJOINMODEL";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_CODENAME = "CODENAME";
    public static final String TAG_LOGICNAME = "LOGICNAME";
    public static final String TAG_CUSTOMMODE = "CUSTOMMODE";
    public static final String TAG_PRIVMODE = "PRIVMODE";
    public static final String TAG_EXTENDMODE = "EXTENDMODE";
    public static final String TAG_DEFAULTMODE = "DEFAULTMODE";
    public static final String TAG_VIEWCOLLEVEL = "VIEWCOLLEVEL";
    public static final String TAG_PUBMODE = "PUBMODE";
    public static final String TAG_REQUESTPATH = "REQUESTPATH";
    public static final String TAG_REQUESTMETHOD = "REQUESTMETHOD";
    public static final String TAG_QUERYVIEWFLAG = "QUERYVIEWFLAG";

    public final boolean isPSDEDATAQUERYIDNull() {
        return this.isParamNull(TAG_PSDEDATAQUERYID);
    }

    public final String getPSDEDATAQUERYID() {
        return this.getParamStringValue(TAG_PSDEDATAQUERYID, "");
    }

    public final void setPSDEDATAQUERYID(String strValue) {
        this.setParamValue(TAG_PSDEDATAQUERYID, strValue);
    }

    public final boolean isPSDEDATAQUERYNAMENull() {
        return this.isParamNull(TAG_PSDEDATAQUERYNAME);
    }

    public final String getPSDEDATAQUERYNAME() {
        return this.getParamStringValue(TAG_PSDEDATAQUERYNAME, "");
    }

    public final void setPSDEDATAQUERYNAME(String strValue) {
        this.setParamValue(TAG_PSDEDATAQUERYNAME, strValue);
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

    public final boolean isDQSNNull() {
        return this.isParamNull(TAG_DQSN);
    }

    public final String getDQSN() {
        return this.getParamStringValue(TAG_DQSN, "");
    }

    public final void setDQSN(String strValue) {
        this.setParamValue(TAG_DQSN, strValue);
    }

    public final boolean isDQJOINMODELNull() {
        return this.isParamNull(TAG_DQJOINMODEL);
    }

    public final String getDQJOINMODEL() {
        return this.getParamStringValue(TAG_DQJOINMODEL, "");
    }

    public final void setDQJOINMODEL(String strValue) {
        this.setParamValue(TAG_DQJOINMODEL, strValue);
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

    public final boolean isCUSTOMMODENull() {
        return this.isParamNull(TAG_CUSTOMMODE);
    }

    public final boolean getCUSTOMMODE() {
        return this.getParamIntValue(TAG_CUSTOMMODE, 0) == 1;
    }

    public final void setCUSTOMMODE(boolean bValue) {
        this.setParamValue(TAG_CUSTOMMODE, bValue ? 1 : 0);
    }

    public final boolean isPRIVMODENull() {
        return this.isParamNull(TAG_PRIVMODE);
    }

    public final boolean getPRIVMODE() {
        return this.getParamIntValue(TAG_PRIVMODE, 0) == 1;
    }

    public final void setPRIVMODE(boolean bValue) {
        this.setParamValue(TAG_PRIVMODE, bValue ? 1 : 0);
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

    public final boolean isDEFAULTMODENull() {
        return this.isParamNull(TAG_DEFAULTMODE);
    }

    public final boolean getDEFAULTMODE() {
        return this.getParamIntValue(TAG_DEFAULTMODE, 0) == 1;
    }

    public final void setDEFAULTMODE(boolean bValue) {
        this.setParamValue(TAG_DEFAULTMODE, bValue ? 1 : 0);
    }

    public final boolean isVIEWCOLLEVELNull() {
        return this.isParamNull(TAG_VIEWCOLLEVEL);
    }

    public final int getVIEWCOLLEVEL() {
        return this.getParamIntValue(TAG_VIEWCOLLEVEL, 0);
    }

    public final void setVIEWCOLLEVEL(int nValue) {
        this.setParamValue(TAG_VIEWCOLLEVEL, nValue);
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

    public final boolean isQUERYVIEWFLAGNull() {
        return this.isParamNull(TAG_QUERYVIEWFLAG);
    }

    public final boolean getQUERYVIEWFLAG() {
        return this.getParamIntValue(TAG_QUERYVIEWFLAG, 0) == 1;
    }

    public final void setQUERYVIEWFLAG(boolean bValue) {
        this.setParamValue(TAG_QUERYVIEWFLAG, bValue ? 1 : 0);
    }
}

