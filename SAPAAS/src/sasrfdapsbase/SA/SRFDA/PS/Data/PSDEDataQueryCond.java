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

public class PSDEDataQueryCond
extends BaseDataEntity {
    public static final String CONDTYPE_GROUP = "GROUP";
    public static final String CONDTYPE_SINGLE = "SINGLE";
    public static final String CONDTYPE_CUSTOM = "CUSTOM";
    public static final String GROUPOP_AND = "AND";
    public static final String GROUPOP_OR = "OR";
    public static final String TAG_PSDEDQCONDID = "PSDEDQCONDID";
    public static final String TAG_PSDEDQCONDNAME = "PSDEDQCONDNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSDEDQID = "PSDEDQID";
    public static final String TAG_PSDEDQNAME = "PSDEDQNAME";
    public static final String TAG_PSDEDQJOINID = "PSDEDQJOINID";
    public static final String TAG_PSDEDQJOINNAME = "PSDEDQJOINNAME";
    public static final String TAG_PPSDEDQCONDID = "PPSDEDQCONDID";
    public static final String TAG_PPSDEDQCONDNAME = "PPSDEDQCONDNAME";
    public static final String TAG_CONDTYPE = "CONDTYPE";
    public static final String TAG_GROUPOP = "GROUPOP";
    public static final String TAG_GROUPNOTFLAG = "GROUPNOTFLAG";
    public static final String TAG_PSDEID = "PSDEID";
    public static final String TAG_PSDEFID = "PSDEFID";
    public static final String TAG_PSDEFNAME = "PSDEFNAME";
    public static final String TAG_PSSYSDBVFID = "PSSYSDBVFID";
    public static final String TAG_PSSYSDBVFNAME = "PSSYSDBVFNAME";
    public static final String TAG_PSDBVALUEOPID = "PSDBVALUEOPID";
    public static final String TAG_PSDBVALUEOPNAME = "PSDBVALUEOPNAME";
    public static final String TAG_PSVARTYPEID = "PSVARTYPEID";
    public static final String TAG_PSVARTYPENAME = "PSVARTYPENAME";
    public static final String TAG_CONDVALUE = "CONDVALUE";
    public static final String TAG_CUSTOMCOND = "CUSTOMCOND";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_LEVELTAG = "LEVELTAG";
    public static final String TAG_LEVELVALUE = "LEVELVALUE";
    public static final String TAG_ORDERVALUE = "ORDERVALUE";
    public static final String TAG_IGNOREEMPTY = "IGNOREEMPTY";
    public static final String TAG_CONDTAG = "CONDTAG";
    public static final String TAG_CONDTAG2 = "CONDTAG2";
    public static final String TAG_CUSTOMTYPE = "CUSTOMTYPE";
    private ArrayList<PSDEDataQueryCond> childPSDEDataQueryCondList = null;

    public final boolean isPSDEDQCONDIDNull() {
        return this.IsParamNull(TAG_PSDEDQCONDID);
    }

    public final String getPSDEDQCONDID() {
        return this.GetParamStringValue(TAG_PSDEDQCONDID, "");
    }

    public final void setPSDEDQCONDID(String strValue) {
        this.SetParamValue(TAG_PSDEDQCONDID, strValue);
    }

    public final boolean isPSDEDQCONDNAMENull() {
        return this.IsParamNull(TAG_PSDEDQCONDNAME);
    }

    public final String getPSDEDQCONDNAME() {
        return this.GetParamStringValue(TAG_PSDEDQCONDNAME, "");
    }

    public final void setPSDEDQCONDNAME(String strValue) {
        this.SetParamValue(TAG_PSDEDQCONDNAME, strValue);
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

    public final boolean isPSDEDQIDNull() {
        return this.IsParamNull(TAG_PSDEDQID);
    }

    public final String getPSDEDQID() {
        return this.GetParamStringValue(TAG_PSDEDQID, "");
    }

    public final void setPSDEDQID(String strValue) {
        this.SetParamValue(TAG_PSDEDQID, strValue);
    }

    public final boolean isPSDEDQNAMENull() {
        return this.IsParamNull(TAG_PSDEDQNAME);
    }

    public final String getPSDEDQNAME() {
        return this.GetParamStringValue(TAG_PSDEDQNAME, "");
    }

    public final void setPSDEDQNAME(String strValue) {
        this.SetParamValue(TAG_PSDEDQNAME, strValue);
    }

    public final boolean isPSDEDQJOINIDNull() {
        return this.IsParamNull(TAG_PSDEDQJOINID);
    }

    public final String getPSDEDQJOINID() {
        return this.GetParamStringValue(TAG_PSDEDQJOINID, "");
    }

    public final void setPSDEDQJOINID(String strValue) {
        this.SetParamValue(TAG_PSDEDQJOINID, strValue);
    }

    public final boolean isPSDEDQJOINNAMENull() {
        return this.IsParamNull(TAG_PSDEDQJOINNAME);
    }

    public final String getPSDEDQJOINNAME() {
        return this.GetParamStringValue(TAG_PSDEDQJOINNAME, "");
    }

    public final void setPSDEDQJOINNAME(String strValue) {
        this.SetParamValue(TAG_PSDEDQJOINNAME, strValue);
    }

    public final boolean isPPSDEDQCONDIDNull() {
        return this.IsParamNull(TAG_PPSDEDQCONDID);
    }

    public final String getPPSDEDQCONDID() {
        return this.GetParamStringValue(TAG_PPSDEDQCONDID, "");
    }

    public final void setPPSDEDQCONDID(String strValue) {
        this.SetParamValue(TAG_PPSDEDQCONDID, strValue);
    }

    public final boolean isPPSDEDQCONDNAMENull() {
        return this.IsParamNull(TAG_PPSDEDQCONDNAME);
    }

    public final String getPPSDEDQCONDNAME() {
        return this.GetParamStringValue(TAG_PPSDEDQCONDNAME, "");
    }

    public final void setPPSDEDQCONDNAME(String strValue) {
        this.SetParamValue(TAG_PPSDEDQCONDNAME, strValue);
    }

    public final boolean isCONDTYPENull() {
        return this.IsParamNull(TAG_CONDTYPE);
    }

    public final String getCONDTYPE() {
        return this.GetParamStringValue(TAG_CONDTYPE, "");
    }

    public final void setCONDTYPE(String strValue) {
        this.SetParamValue(TAG_CONDTYPE, strValue);
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

    public final boolean isPSDEIDNull() {
        return this.IsParamNull(TAG_PSDEID);
    }

    public final String getPSDEID() {
        return this.GetParamStringValue(TAG_PSDEID, "");
    }

    public final void setPSDEID(String strValue) {
        this.SetParamValue(TAG_PSDEID, strValue);
    }

    public final boolean isPSDEFIDNull() {
        return this.IsParamNull(TAG_PSDEFID);
    }

    public final String getPSDEFID() {
        return this.GetParamStringValue(TAG_PSDEFID, "");
    }

    public final void setPSDEFID(String strValue) {
        this.SetParamValue(TAG_PSDEFID, strValue);
    }

    public final boolean isPSDEFNAMENull() {
        return this.IsParamNull(TAG_PSDEFNAME);
    }

    public final String getPSDEFNAME() {
        return this.GetParamStringValue(TAG_PSDEFNAME, "");
    }

    public final void setPSDEFNAME(String strValue) {
        this.SetParamValue(TAG_PSDEFNAME, strValue);
    }

    public final boolean isPSSYSDBVFIDNull() {
        return this.IsParamNull(TAG_PSSYSDBVFID);
    }

    public final String getPSSYSDBVFID() {
        return this.GetParamStringValue(TAG_PSSYSDBVFID, "");
    }

    public final void setPSSYSDBVFID(String strValue) {
        this.SetParamValue(TAG_PSSYSDBVFID, strValue);
    }

    public final boolean isPSSYSDBVFNAMENull() {
        return this.IsParamNull(TAG_PSSYSDBVFNAME);
    }

    public final String getPSSYSDBVFNAME() {
        return this.GetParamStringValue(TAG_PSSYSDBVFNAME, "");
    }

    public final void setPSSYSDBVFNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSDBVFNAME, strValue);
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

    public final boolean isPSVARTYPEIDNull() {
        return this.IsParamNull(TAG_PSVARTYPEID);
    }

    public final String getPSVARTYPEID() {
        return this.GetParamStringValue(TAG_PSVARTYPEID, "");
    }

    public final void setPSVARTYPEID(String strValue) {
        this.SetParamValue(TAG_PSVARTYPEID, strValue);
    }

    public final boolean isPSVARTYPENAMENull() {
        return this.IsParamNull(TAG_PSVARTYPENAME);
    }

    public final String getPSVARTYPENAME() {
        return this.GetParamStringValue(TAG_PSVARTYPENAME, "");
    }

    public final void setPSVARTYPENAME(String strValue) {
        this.SetParamValue(TAG_PSVARTYPENAME, strValue);
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

    public final boolean isCUSTOMCONDNull() {
        return this.IsParamNull(TAG_CUSTOMCOND);
    }

    public final String getCUSTOMCOND() {
        return this.GetParamStringValue(TAG_CUSTOMCOND, "");
    }

    public final void setCUSTOMCOND(String strValue) {
        this.SetParamValue(TAG_CUSTOMCOND, strValue);
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

    public final boolean isLEVELTAGNull() {
        return this.IsParamNull(TAG_LEVELTAG);
    }

    public final String getLEVELTAG() {
        return this.GetParamStringValue(TAG_LEVELTAG, "");
    }

    public final void setLEVELTAG(String strValue) {
        this.SetParamValue(TAG_LEVELTAG, strValue);
    }

    public final boolean isLEVELVALUENull() {
        return this.IsParamNull(TAG_LEVELVALUE);
    }

    public final int getLEVELVALUE() {
        return this.GetParamIntValue(TAG_LEVELVALUE, 0);
    }

    public final void setLEVELVALUE(int nValue) {
        this.SetParamValue(TAG_LEVELVALUE, nValue);
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

    public final boolean isIGNOREEMPTYNull() {
        return this.IsParamNull(TAG_IGNOREEMPTY);
    }

    public final int getIGNOREEMPTY() {
        return this.GetParamIntValue(TAG_IGNOREEMPTY, 0);
    }

    public final void setIGNOREEMPTY(int bValue) {
        this.SetParamValue(TAG_IGNOREEMPTY, bValue);
    }

    public final boolean isCONDTAGNull() {
        return this.IsParamNull(TAG_CONDTAG);
    }

    public final String getCONDTAG() {
        return this.GetParamStringValue(TAG_CONDTAG, "");
    }

    public final void setCONDTAG(String strValue) {
        this.SetParamValue(TAG_CONDTAG, strValue);
    }

    public final boolean isCONDTAG2Null() {
        return this.IsParamNull(TAG_CONDTAG2);
    }

    public final String getCONDTAG2() {
        return this.GetParamStringValue(TAG_CONDTAG2, "");
    }

    public final void setCONDTAG2(String strValue) {
        this.SetParamValue(TAG_CONDTAG2, strValue);
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

    public ArrayList<PSDEDataQueryCond> getChildPSDEDataQueryConds(boolean bCreated) {
        if (this.childPSDEDataQueryCondList != null) {
            return this.childPSDEDataQueryCondList;
        }
        if (bCreated) {
            this.childPSDEDataQueryCondList = new ArrayList();
        }
        return this.childPSDEDataQueryCondList;
    }

    public void resetChildDatas() {
        if (this.childPSDEDataQueryCondList != null) {
            this.childPSDEDataQueryCondList.clear();
            this.childPSDEDataQueryCondList = null;
        }
    }
}

