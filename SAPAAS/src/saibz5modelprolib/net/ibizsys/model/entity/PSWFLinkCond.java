/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.entity;

import java.util.ArrayList;
import java.util.Date;
import net.ibizsys.model.entity.BaseDataEntity;

public class PSWFLinkCond
extends BaseDataEntity {
    public static final String LOGICTYPE_GROUP = "GROUP";
    public static final String LOGICTYPE_SINGLE = "SINGLE";
    public static final String LOGICTYPE_CUSTOM = "CUSTOM";
    public static final String GROUPOP_AND = "AND";
    public static final String GROUPOP_OR = "OR";
    public static final String PARAMTYPE_ENTITYFIELD = "ENTITYFIELD";
    public static final String PARAMTYPE_CURTIME = "CURTIME";
    public static final String PARAMTYPE_TIMERULE = "TIMERULE";
    public static final String TAG_PSWFLINKCONDID = "PSWFLINKCONDID";
    public static final String TAG_PSWFLINKCONDNAME = "PSWFLINKCONDNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSWFVERSIONID = "PSWFVERSIONID";
    public static final String TAG_PSWFVERSIONNAME = "PSWFVERSIONNAME";
    public static final String TAG_PSWFLINKID = "PSWFLINKID";
    public static final String TAG_PSWFLINKNAME = "PSWFLINKNAME";
    public static final String TAG_PPSWFLINKCONDID = "PPSWFLINKCONDID";
    public static final String TAG_PPSWFLINKCONDNAME = "PPSWFLINKCONDNAME";
    public static final String TAG_PSDBVALUEOPID = "PSDBVALUEOPID";
    public static final String TAG_PSDBVALUEOPNAME = "PSDBVALUEOPNAME";
    public static final String TAG_LOGICTYPE = "LOGICTYPE";
    public static final String TAG_ORDERVALUE = "ORDERVALUE";
    public static final String TAG_GROUPNOTFLAG = "GROUPNOTFLAG";
    public static final String TAG_CONDVALUE = "CONDVALUE";
    public static final String TAG_CUSTOMDSTPARAM = "CUSTOMDSTPARAM";
    public static final String TAG_GROUPOP = "GROUPOP";
    public static final String TAG_DSTPSDEFID = "DSTPSDEFID";
    public static final String TAG_DSTPSDEFNAME = "DSTPSDEFNAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_PARAMTYPE = "PARAMTYPE";
    private ArrayList<PSWFLinkCond> childPSWFLinkCondList = null;

    public final boolean isPSWFLINKCONDIDNull() {
        return this.isParamNull(TAG_PSWFLINKCONDID);
    }

    public final String getPSWFLINKCONDID() {
        return this.getParamStringValue(TAG_PSWFLINKCONDID, "");
    }

    public final void setPSWFLINKCONDID(String strValue) {
        this.setParamValue(TAG_PSWFLINKCONDID, strValue);
    }

    public final boolean isPSWFLINKCONDNAMENull() {
        return this.isParamNull(TAG_PSWFLINKCONDNAME);
    }

    public final String getPSWFLINKCONDNAME() {
        return this.getParamStringValue(TAG_PSWFLINKCONDNAME, "");
    }

    public final void setPSWFLINKCONDNAME(String strValue) {
        this.setParamValue(TAG_PSWFLINKCONDNAME, strValue);
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

    public final boolean isPPSWFLINKCONDIDNull() {
        return this.isParamNull(TAG_PPSWFLINKCONDID);
    }

    public final String getPPSWFLINKCONDID() {
        return this.getParamStringValue(TAG_PPSWFLINKCONDID, "");
    }

    public final void setPPSWFLINKCONDID(String strValue) {
        this.setParamValue(TAG_PPSWFLINKCONDID, strValue);
    }

    public final boolean isPPSWFLINKCONDNAMENull() {
        return this.isParamNull(TAG_PPSWFLINKCONDNAME);
    }

    public final String getPPSWFLINKCONDNAME() {
        return this.getParamStringValue(TAG_PPSWFLINKCONDNAME, "");
    }

    public final void setPPSWFLINKCONDNAME(String strValue) {
        this.setParamValue(TAG_PPSWFLINKCONDNAME, strValue);
    }

    public final boolean isPSDBVALUEOPIDNull() {
        return this.isParamNull(TAG_PSDBVALUEOPID);
    }

    public final String getPSDBVALUEOPID() {
        return this.getParamStringValue(TAG_PSDBVALUEOPID, "");
    }

    public final void setPSDBVALUEOPID(String strValue) {
        this.setParamValue(TAG_PSDBVALUEOPID, strValue);
    }

    public final boolean isPSDBVALUEOPNAMENull() {
        return this.isParamNull(TAG_PSDBVALUEOPNAME);
    }

    public final String getPSDBVALUEOPNAME() {
        return this.getParamStringValue(TAG_PSDBVALUEOPNAME, "");
    }

    public final void setPSDBVALUEOPNAME(String strValue) {
        this.setParamValue(TAG_PSDBVALUEOPNAME, strValue);
    }

    public final boolean isLOGICTYPENull() {
        return this.isParamNull(TAG_LOGICTYPE);
    }

    public final String getLOGICTYPE() {
        return this.getParamStringValue(TAG_LOGICTYPE, "");
    }

    public final void setLOGICTYPE(String strValue) {
        this.setParamValue(TAG_LOGICTYPE, strValue);
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

    public final boolean isGROUPNOTFLAGNull() {
        return this.isParamNull(TAG_GROUPNOTFLAG);
    }

    public final boolean getGROUPNOTFLAG() {
        return this.getParamIntValue(TAG_GROUPNOTFLAG, 0) == 1;
    }

    public final void setGROUPNOTFLAG(boolean bValue) {
        this.setParamValue(TAG_GROUPNOTFLAG, bValue ? 1 : 0);
    }

    public final boolean isCONDVALUENull() {
        return this.isParamNull(TAG_CONDVALUE);
    }

    public final String getCONDVALUE() {
        return this.getParamStringValue(TAG_CONDVALUE, "");
    }

    public final void setCONDVALUE(String strValue) {
        this.setParamValue(TAG_CONDVALUE, strValue);
    }

    public final boolean isCUSTOMDSTPARAMNull() {
        return this.isParamNull(TAG_CUSTOMDSTPARAM);
    }

    public final String getCUSTOMDSTPARAM() {
        return this.getParamStringValue(TAG_CUSTOMDSTPARAM, "");
    }

    public final void setCUSTOMDSTPARAM(String strValue) {
        this.setParamValue(TAG_CUSTOMDSTPARAM, strValue);
    }

    public final boolean isGROUPOPNull() {
        return this.isParamNull(TAG_GROUPOP);
    }

    public final String getGROUPOP() {
        return this.getParamStringValue(TAG_GROUPOP, "");
    }

    public final void setGROUPOP(String strValue) {
        this.setParamValue(TAG_GROUPOP, strValue);
    }

    public final boolean isDSTPSDEFIDNull() {
        return this.isParamNull(TAG_DSTPSDEFID);
    }

    public final String getDSTPSDEFID() {
        return this.getParamStringValue(TAG_DSTPSDEFID, "");
    }

    public final void setDSTPSDEFID(String strValue) {
        this.setParamValue(TAG_DSTPSDEFID, strValue);
    }

    public final boolean isDSTPSDEFNAMENull() {
        return this.isParamNull(TAG_DSTPSDEFNAME);
    }

    public final String getDSTPSDEFNAME() {
        return this.getParamStringValue(TAG_DSTPSDEFNAME, "");
    }

    public final void setDSTPSDEFNAME(String strValue) {
        this.setParamValue(TAG_DSTPSDEFNAME, strValue);
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

    public final boolean isPARAMTYPENull() {
        return this.isParamNull(TAG_PARAMTYPE);
    }

    public final String getPARAMTYPE() {
        return this.getParamStringValue(TAG_PARAMTYPE, "");
    }

    public final void setPARAMTYPE(String strValue) {
        this.setParamValue(TAG_PARAMTYPE, strValue);
    }

    public ArrayList<PSWFLinkCond> getChildPSWFLinkConds(boolean bCreated) {
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

