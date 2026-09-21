/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.entity;

import java.util.ArrayList;
import java.util.Date;
import net.ibizsys.model.entity.BaseDataEntity;

public class PSDELogicLinkCond
extends BaseDataEntity {
    public static final String LOGICTYPE_GROUP = "GROUP";
    public static final String LOGICTYPE_SINGLE = "SINGLE";
    public static final String LOGICTYPE_CUSTOM = "CUSTOM";
    public static final String GROUPOP_AND = "AND";
    public static final String GROUPOP_OR = "OR";
    public static final String TAG_PSDELLCONDID = "PSDELLCONDID";
    public static final String TAG_PSDELLCONDNAME = "PSDELLCONDNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSDELOGICLINKID = "PSDELOGICLINKID";
    public static final String TAG_PSDELOGICLINKNAME = "PSDELOGICLINKNAME";
    public static final String TAG_PPSDELLCONDID = "PPSDELLCONDID";
    public static final String TAG_PPSDELLCONDNAME = "PPSDELLCONDNAME";
    public static final String TAG_DSTPSDLPARAMID = "DSTPSDLPARAMID";
    public static final String TAG_DSTPSDLPARAMNAME = "DSTPSDLPARAMNAME";
    public static final String TAG_DSTPSDEFID = "DSTPSDEFID";
    public static final String TAG_DSTPSDEFNAME = "DSTPSDEFNAME";
    public static final String TAG_LOGICTYPE = "LOGICTYPE";
    public static final String TAG_ORDERVALUE = "ORDERVALUE";
    public static final String TAG_GROUPOP = "GROUPOP";
    public static final String TAG_GROUPNOTFLAG = "GROUPNOTFLAG";
    public static final String TAG_CONDVALUE = "CONDVALUE";
    public static final String TAG_PSDBVALUEOPID = "PSDBVALUEOPID";
    public static final String TAG_PSDBVALUEOPNAME = "PSDBVALUEOPNAME";
    public static final String TAG_CUSTOMDSTPARAM = "CUSTOMDSTPARAM";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_PSDELOGICID = "PSDELOGICID";
    public static final String TAG_DSTPARAMPSDEID = "DSTPARAMPSDEID";
    private ArrayList<PSDELogicLinkCond> childPSDELogicLinkCondList = null;

    public final boolean isPSDELLCONDIDNull() {
        return this.isParamNull(TAG_PSDELLCONDID);
    }

    public final String getPSDELLCONDID() {
        return this.getParamStringValue(TAG_PSDELLCONDID, "");
    }

    public final void setPSDELLCONDID(String strValue) {
        this.setParamValue(TAG_PSDELLCONDID, strValue);
    }

    public final boolean isPSDELLCONDNAMENull() {
        return this.isParamNull(TAG_PSDELLCONDNAME);
    }

    public final String getPSDELLCONDNAME() {
        return this.getParamStringValue(TAG_PSDELLCONDNAME, "");
    }

    public final void setPSDELLCONDNAME(String strValue) {
        this.setParamValue(TAG_PSDELLCONDNAME, strValue);
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

    public final boolean isPSDELOGICLINKIDNull() {
        return this.isParamNull(TAG_PSDELOGICLINKID);
    }

    public final String getPSDELOGICLINKID() {
        return this.getParamStringValue(TAG_PSDELOGICLINKID, "");
    }

    public final void setPSDELOGICLINKID(String strValue) {
        this.setParamValue(TAG_PSDELOGICLINKID, strValue);
    }

    public final boolean isPSDELOGICLINKNAMENull() {
        return this.isParamNull(TAG_PSDELOGICLINKNAME);
    }

    public final String getPSDELOGICLINKNAME() {
        return this.getParamStringValue(TAG_PSDELOGICLINKNAME, "");
    }

    public final void setPSDELOGICLINKNAME(String strValue) {
        this.setParamValue(TAG_PSDELOGICLINKNAME, strValue);
    }

    public final boolean isPPSDELLCONDIDNull() {
        return this.isParamNull(TAG_PPSDELLCONDID);
    }

    public final String getPPSDELLCONDID() {
        return this.getParamStringValue(TAG_PPSDELLCONDID, "");
    }

    public final void setPPSDELLCONDID(String strValue) {
        this.setParamValue(TAG_PPSDELLCONDID, strValue);
    }

    public final boolean isPPSDELLCONDNAMENull() {
        return this.isParamNull(TAG_PPSDELLCONDNAME);
    }

    public final String getPPSDELLCONDNAME() {
        return this.getParamStringValue(TAG_PPSDELLCONDNAME, "");
    }

    public final void setPPSDELLCONDNAME(String strValue) {
        this.setParamValue(TAG_PPSDELLCONDNAME, strValue);
    }

    public final boolean isDSTPSDLPARAMIDNull() {
        return this.isParamNull(TAG_DSTPSDLPARAMID);
    }

    public final String getDSTPSDLPARAMID() {
        return this.getParamStringValue(TAG_DSTPSDLPARAMID, "");
    }

    public final void setDSTPSDLPARAMID(String strValue) {
        this.setParamValue(TAG_DSTPSDLPARAMID, strValue);
    }

    public final boolean isDSTPSDLPARAMNAMENull() {
        return this.isParamNull(TAG_DSTPSDLPARAMNAME);
    }

    public final String getDSTPSDLPARAMNAME() {
        return this.getParamStringValue(TAG_DSTPSDLPARAMNAME, "");
    }

    public final void setDSTPSDLPARAMNAME(String strValue) {
        this.setParamValue(TAG_DSTPSDLPARAMNAME, strValue);
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

    public final boolean isGROUPOPNull() {
        return this.isParamNull(TAG_GROUPOP);
    }

    public final String getGROUPOP() {
        return this.getParamStringValue(TAG_GROUPOP, "");
    }

    public final void setGROUPOP(String strValue) {
        this.setParamValue(TAG_GROUPOP, strValue);
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

    public final boolean isCUSTOMDSTPARAMNull() {
        return this.isParamNull(TAG_CUSTOMDSTPARAM);
    }

    public final String getCUSTOMDSTPARAM() {
        return this.getParamStringValue(TAG_CUSTOMDSTPARAM, "");
    }

    public final void setCUSTOMDSTPARAM(String strValue) {
        this.setParamValue(TAG_CUSTOMDSTPARAM, strValue);
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

    public final boolean isPSDELOGICIDNull() {
        return this.isParamNull(TAG_PSDELOGICID);
    }

    public final String getPSDELOGICID() {
        return this.getParamStringValue(TAG_PSDELOGICID, "");
    }

    public final void setPSDELOGICID(String strValue) {
        this.setParamValue(TAG_PSDELOGICID, strValue);
    }

    public final boolean isDSTPARAMPSDEIDNull() {
        return this.isParamNull(TAG_DSTPARAMPSDEID);
    }

    public final String getDSTPARAMPSDEID() {
        return this.getParamStringValue(TAG_DSTPARAMPSDEID, "");
    }

    public final void setDSTPARAMPSDEID(String strValue) {
        this.setParamValue(TAG_DSTPARAMPSDEID, strValue);
    }

    public ArrayList<PSDELogicLinkCond> getChildPSDELogicLinkConds(boolean bCreated) {
        if (this.childPSDELogicLinkCondList != null) {
            return this.childPSDELogicLinkCondList;
        }
        if (bCreated) {
            this.childPSDELogicLinkCondList = new ArrayList();
        }
        return this.childPSDELogicLinkCondList;
    }

    public void resetChildDatas() {
        if (this.childPSDELogicLinkCondList != null) {
            this.childPSDELogicLinkCondList.clear();
            this.childPSDELogicLinkCondList = null;
        }
    }
}

