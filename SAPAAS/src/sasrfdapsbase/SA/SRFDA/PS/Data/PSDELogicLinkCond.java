/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.ArrayList;
import java.util.Date;

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
    public static final String TAG_PARAMTYPE = "PARAMTYPE";
    public static final String TAG_SRCPSDLPARAMID = "SRCPSDLPARAMID";
    public static final String TAG_SRCPSDLPARAMNAME = "SRCPSDLPARAMNAME";
    private ArrayList<PSDELogicLinkCond> childPSDELogicLinkCondList = null;

    public final boolean isPSDELLCONDIDNull() {
        return this.IsParamNull(TAG_PSDELLCONDID);
    }

    public final String getPSDELLCONDID() {
        return this.GetParamStringValue(TAG_PSDELLCONDID, "");
    }

    public final void setPSDELLCONDID(String strValue) {
        this.SetParamValue(TAG_PSDELLCONDID, strValue);
    }

    public final boolean isPSDELLCONDNAMENull() {
        return this.IsParamNull(TAG_PSDELLCONDNAME);
    }

    public final String getPSDELLCONDNAME() {
        return this.GetParamStringValue(TAG_PSDELLCONDNAME, "");
    }

    public final void setPSDELLCONDNAME(String strValue) {
        this.SetParamValue(TAG_PSDELLCONDNAME, strValue);
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

    public final boolean isPSDELOGICLINKIDNull() {
        return this.IsParamNull(TAG_PSDELOGICLINKID);
    }

    public final String getPSDELOGICLINKID() {
        return this.GetParamStringValue(TAG_PSDELOGICLINKID, "");
    }

    public final void setPSDELOGICLINKID(String strValue) {
        this.SetParamValue(TAG_PSDELOGICLINKID, strValue);
    }

    public final boolean isPSDELOGICLINKNAMENull() {
        return this.IsParamNull(TAG_PSDELOGICLINKNAME);
    }

    public final String getPSDELOGICLINKNAME() {
        return this.GetParamStringValue(TAG_PSDELOGICLINKNAME, "");
    }

    public final void setPSDELOGICLINKNAME(String strValue) {
        this.SetParamValue(TAG_PSDELOGICLINKNAME, strValue);
    }

    public final boolean isPPSDELLCONDIDNull() {
        return this.IsParamNull(TAG_PPSDELLCONDID);
    }

    public final String getPPSDELLCONDID() {
        return this.GetParamStringValue(TAG_PPSDELLCONDID, "");
    }

    public final void setPPSDELLCONDID(String strValue) {
        this.SetParamValue(TAG_PPSDELLCONDID, strValue);
    }

    public final boolean isPPSDELLCONDNAMENull() {
        return this.IsParamNull(TAG_PPSDELLCONDNAME);
    }

    public final String getPPSDELLCONDNAME() {
        return this.GetParamStringValue(TAG_PPSDELLCONDNAME, "");
    }

    public final void setPPSDELLCONDNAME(String strValue) {
        this.SetParamValue(TAG_PPSDELLCONDNAME, strValue);
    }

    public final boolean isDSTPSDLPARAMIDNull() {
        return this.IsParamNull(TAG_DSTPSDLPARAMID);
    }

    public final String getDSTPSDLPARAMID() {
        return this.GetParamStringValue(TAG_DSTPSDLPARAMID, "");
    }

    public final void setDSTPSDLPARAMID(String strValue) {
        this.SetParamValue(TAG_DSTPSDLPARAMID, strValue);
    }

    public final boolean isDSTPSDLPARAMNAMENull() {
        return this.IsParamNull(TAG_DSTPSDLPARAMNAME);
    }

    public final String getDSTPSDLPARAMNAME() {
        return this.GetParamStringValue(TAG_DSTPSDLPARAMNAME, "");
    }

    public final void setDSTPSDLPARAMNAME(String strValue) {
        this.SetParamValue(TAG_DSTPSDLPARAMNAME, strValue);
    }

    public final boolean isDSTPSDEFIDNull() {
        return this.IsParamNull(TAG_DSTPSDEFID);
    }

    public final String getDSTPSDEFID() {
        return this.GetParamStringValue(TAG_DSTPSDEFID, "");
    }

    public final void setDSTPSDEFID(String strValue) {
        this.SetParamValue(TAG_DSTPSDEFID, strValue);
    }

    public final boolean isDSTPSDEFNAMENull() {
        return this.IsParamNull(TAG_DSTPSDEFNAME);
    }

    public final String getDSTPSDEFNAME() {
        return this.GetParamStringValue(TAG_DSTPSDEFNAME, "");
    }

    public final void setDSTPSDEFNAME(String strValue) {
        this.SetParamValue(TAG_DSTPSDEFNAME, strValue);
    }

    public final boolean isLOGICTYPENull() {
        return this.IsParamNull(TAG_LOGICTYPE);
    }

    public final String getLOGICTYPE() {
        return this.GetParamStringValue(TAG_LOGICTYPE, "");
    }

    public final void setLOGICTYPE(String strValue) {
        this.SetParamValue(TAG_LOGICTYPE, strValue);
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

    public final boolean isGROUPOPNull() {
        return this.IsParamNull(TAG_GROUPOP);
    }

    public final String getGROUPOP() {
        return this.GetParamStringValue(TAG_GROUPOP, "");
    }

    public final void setGROUPOP(String strValue) {
        this.SetParamValue(TAG_GROUPOP, strValue);
    }

    public final boolean isGROUPNOTFLAGNull() {
        return this.IsParamNull(TAG_GROUPNOTFLAG);
    }

    public final boolean getGROUPNOTFLAG() {
        return this.GetParamIntValue(TAG_GROUPNOTFLAG, 0) == 1;
    }

    public final void setGROUPNOTFLAG(boolean bValue) {
        this.SetParamValue(TAG_GROUPNOTFLAG, bValue ? 1 : 0);
    }

    public final boolean isCONDVALUENull() {
        return this.IsParamNull(TAG_CONDVALUE);
    }

    public final String getCONDVALUE() {
        return this.GetParamStringValue(TAG_CONDVALUE, "");
    }

    public final void setCONDVALUE(String strValue) {
        this.SetParamValue(TAG_CONDVALUE, strValue);
    }

    public final boolean isPSDBVALUEOPIDNull() {
        return this.IsParamNull(TAG_PSDBVALUEOPID);
    }

    public final String getPSDBVALUEOPID() {
        return this.GetParamStringValue(TAG_PSDBVALUEOPID, "");
    }

    public final void setPSDBVALUEOPID(String strValue) {
        this.SetParamValue(TAG_PSDBVALUEOPID, strValue);
    }

    public final boolean isPSDBVALUEOPNAMENull() {
        return this.IsParamNull(TAG_PSDBVALUEOPNAME);
    }

    public final String getPSDBVALUEOPNAME() {
        return this.GetParamStringValue(TAG_PSDBVALUEOPNAME, "");
    }

    public final void setPSDBVALUEOPNAME(String strValue) {
        this.SetParamValue(TAG_PSDBVALUEOPNAME, strValue);
    }

    public final boolean isCUSTOMDSTPARAMNull() {
        return this.IsParamNull(TAG_CUSTOMDSTPARAM);
    }

    public final String getCUSTOMDSTPARAM() {
        return this.GetParamStringValue(TAG_CUSTOMDSTPARAM, "");
    }

    public final void setCUSTOMDSTPARAM(String strValue) {
        this.SetParamValue(TAG_CUSTOMDSTPARAM, strValue);
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

    public final boolean isPSDELOGICIDNull() {
        return this.IsParamNull(TAG_PSDELOGICID);
    }

    public final String getPSDELOGICID() {
        return this.GetParamStringValue(TAG_PSDELOGICID, "");
    }

    public final void setPSDELOGICID(String strValue) {
        this.SetParamValue(TAG_PSDELOGICID, strValue);
    }

    public final boolean isDSTPARAMPSDEIDNull() {
        return this.IsParamNull(TAG_DSTPARAMPSDEID);
    }

    public final String getDSTPARAMPSDEID() {
        return this.GetParamStringValue(TAG_DSTPARAMPSDEID, "");
    }

    public final void setDSTPARAMPSDEID(String strValue) {
        this.SetParamValue(TAG_DSTPARAMPSDEID, strValue);
    }

    public final boolean isPARAMTYPENull() {
        return this.IsParamNull(TAG_PARAMTYPE);
    }

    public final String getPARAMTYPE() {
        return this.GetParamStringValue(TAG_PARAMTYPE, "");
    }

    public final void setPARAMTYPE(String strValue) {
        this.SetParamValue(TAG_PARAMTYPE, strValue);
    }

    public final boolean isSRCPSDLPARAMIDNull() {
        return this.IsParamNull(TAG_SRCPSDLPARAMID);
    }

    public final String getSRCPSDLPARAMID() {
        return this.GetParamStringValue(TAG_SRCPSDLPARAMID, "");
    }

    public final void setSRCPSDLPARAMID(String strValue) {
        this.SetParamValue(TAG_SRCPSDLPARAMID, strValue);
    }

    public final boolean isSRCPSDLPARAMNAMENull() {
        return this.IsParamNull(TAG_SRCPSDLPARAMNAME);
    }

    public final String getSRCPSDLPARAMNAME() {
        return this.GetParamStringValue(TAG_SRCPSDLPARAMNAME, "");
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

