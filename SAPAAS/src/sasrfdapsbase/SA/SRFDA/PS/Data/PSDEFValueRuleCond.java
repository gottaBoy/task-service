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

public class PSDEFValueRuleCond
extends BaseDataEntity {
    public static final String CONDTYPE_GROUP = "GROUP";
    public static final String CONDTYPE_NULLRULE = "NULLRULE";
    public static final String CONDTYPE_VALUERANGE = "VALUERANGE";
    public static final String CONDTYPE_VALUERANGE2 = "VALUERANGE2";
    public static final String CONDTYPE_REGEX = "REGEX";
    public static final String CONDTYPE_STRINGLENGTH = "STRINGLENGTH";
    public static final String CONDTYPE_VALUERECURSION = "VALUERECURSION";
    public static final String CONDTYPE_SYSVALUERULE = "SYSVALUERULE";
    public static final String CONDTYPE_SIMPLE = "SIMPLE";
    public static final String GROUPOP_AND = "AND";
    public static final String GROUPOP_OR = "OR";
    public static final String PARAMTYPE_ENTITYFIELD = "ENTITYFIELD";
    public static final String PARAMTYPE_CURTIME = "CURTIME";
    public static final String PARAMTYPE_TIMERULE = "TIMERULE";
    public static final String TAG_PSDEFVRCONDID = "PSDEFVRCONDID";
    public static final String TAG_PSDEFVRCONDNAME = "PSDEFVRCONDNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSDEFVRID = "PSDEFVRID";
    public static final String TAG_PSDEFVRNAME = "PSDEFVRNAME";
    public static final String TAG_PPSDEFVRCONDID = "PPSDEFVRCONDID";
    public static final String TAG_PPSDEFVRCONDNAME = "PPSDEFVRCONDNAME";
    public static final String TAG_CONDTYPE = "CONDTYPE";
    public static final String TAG_GROUPOP = "GROUPOP";
    public static final String TAG_GROUPNOTFLAG = "GROUPNOTFLAG";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_LEVELTAG = "LEVELTAG";
    public static final String TAG_LEVELVALUE = "LEVELVALUE";
    public static final String TAG_ORDERVALUE = "ORDERVALUE";
    public static final String TAG_PSDEFID = "PSDEFID";
    public static final String TAG_PSDEFNAME = "PSDEFNAME";
    public static final String TAG_PSDBVALUEOPID = "PSDBVALUEOPID";
    public static final String TAG_PSDBVALUEOPNAME = "PSDBVALUEOPNAME";
    public static final String TAG_CONDVALUE = "CONDVALUE";
    public static final String TAG_PARAM = "PARAM";
    public static final String TAG_PARAM2 = "PARAM2";
    public static final String TAG_PARAM3 = "PARAM3";
    public static final String TAG_PARAM4 = "PARAM4";
    public static final String TAG_PARAM5 = "PARAM5";
    public static final String TAG_PARAM6 = "PARAM6";
    public static final String TAG_PARAMTYPE = "PARAMTYPE";
    public static final String TAG_PARAM7 = "PARAM7";
    public static final String TAG_PARAM8 = "PARAM8";
    public static final String TAG_RULEINFO = "RULEINFO";
    public static final String TAG_PSDEDQID = "PSDEDQID";
    public static final String TAG_PSDEDQNAME = "PSDEDQNAME";
    public static final String TAG_CUSTOMDEFNAME = "CUSTOMDEFNAME";
    public static final String TAG_PARAM9 = "PARAM9";
    public static final String TAG_PARAM10 = "PARAM10";
    public static final String TAG_MAJORPSDEID = "MAJORPSDEID";
    public static final String TAG_MAJORPSDENAME = "MAJORPSDENAME";
    public static final String TAG_MAJORPSDEDSTID = "MAJORPSDEDSTID";
    public static final String TAG_MAJORPSDEDSTNAME = "MAJORPSDEDSTNAME";
    public static final String TAG_EXTMAJORPSDEFID = "EXTMAJORPSDEFID";
    public static final String TAG_EXTMAJORPSDEFNAME = "EXTMAJORPSDEFNAME";
    public static final String TAG_EXTMINORPSDEFID = "EXTMINORPSDEFID";
    public static final String TAG_EXTMINORPSDEFNAME = "EXTMINORPSDEFNAME";
    public static final String TAG_KEYCONDFLAG = "KEYCONDFLAG";
    public static final String TAG_PSSYSVALUERULEID = "PSSYSVALUERULEID";
    public static final String TAG_PSSYSVALUERULENAME = "PSSYSVALUERULENAME";
    public static final String TAG_CONDTAG = "CONDTAG";
    public static final String TAG_CONDTAG2 = "CONDTAG2";
    public static final String TAG_RIPSLANRESID = "RIPSLANRESID";
    public static final String TAG_RIPSLANRESNAME = "RIPSLANRESNAME";
    private ArrayList<PSDEFValueRuleCond> childPSDEFValueRuleCondList = null;

    public final boolean isPSDEFVRCONDIDNull() {
        return this.IsParamNull(TAG_PSDEFVRCONDID);
    }

    public final String getPSDEFVRCONDID() {
        return this.GetParamStringValue(TAG_PSDEFVRCONDID, "");
    }

    public final void setPSDEFVRCONDID(String strValue) {
        this.SetParamValue(TAG_PSDEFVRCONDID, strValue);
    }

    public final boolean isPSDEFVRCONDNAMENull() {
        return this.IsParamNull(TAG_PSDEFVRCONDNAME);
    }

    public final String getPSDEFVRCONDNAME() {
        return this.GetParamStringValue(TAG_PSDEFVRCONDNAME, "");
    }

    public final void setPSDEFVRCONDNAME(String strValue) {
        this.SetParamValue(TAG_PSDEFVRCONDNAME, strValue);
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

    public final boolean isPSDEFVRIDNull() {
        return this.IsParamNull(TAG_PSDEFVRID);
    }

    public final String getPSDEFVRID() {
        return this.GetParamStringValue(TAG_PSDEFVRID, "");
    }

    public final void setPSDEFVRID(String strValue) {
        this.SetParamValue(TAG_PSDEFVRID, strValue);
    }

    public final boolean isPSDEFVRNAMENull() {
        return this.IsParamNull(TAG_PSDEFVRNAME);
    }

    public final String getPSDEFVRNAME() {
        return this.GetParamStringValue(TAG_PSDEFVRNAME, "");
    }

    public final void setPSDEFVRNAME(String strValue) {
        this.SetParamValue(TAG_PSDEFVRNAME, strValue);
    }

    public final boolean isPPSDEFVRCONDIDNull() {
        return this.IsParamNull(TAG_PPSDEFVRCONDID);
    }

    public final String getPPSDEFVRCONDID() {
        return this.GetParamStringValue(TAG_PPSDEFVRCONDID, "");
    }

    public final void setPPSDEFVRCONDID(String strValue) {
        this.SetParamValue(TAG_PPSDEFVRCONDID, strValue);
    }

    public final boolean isPPSDEFVRCONDNAMENull() {
        return this.IsParamNull(TAG_PPSDEFVRCONDNAME);
    }

    public final String getPPSDEFVRCONDNAME() {
        return this.GetParamStringValue(TAG_PPSDEFVRCONDNAME, "");
    }

    public final void setPPSDEFVRCONDNAME(String strValue) {
        this.SetParamValue(TAG_PPSDEFVRCONDNAME, strValue);
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

    public final boolean isCONDVALUENull() {
        return this.IsParamNull(TAG_CONDVALUE);
    }

    public final String getCONDVALUE() {
        return this.GetParamStringValue(TAG_CONDVALUE, "");
    }

    public final void setCONDVALUE(String strValue) {
        this.SetParamValue(TAG_CONDVALUE, strValue);
    }

    public final boolean isPARAMNull() {
        return this.IsParamNull(TAG_PARAM);
    }

    public final String getPARAM() {
        return this.GetParamStringValue(TAG_PARAM, "");
    }

    public final void setPARAM(String strValue) {
        this.SetParamValue(TAG_PARAM, strValue);
    }

    public final boolean isPARAM2Null() {
        return this.IsParamNull(TAG_PARAM2);
    }

    public final String getPARAM2() {
        return this.GetParamStringValue(TAG_PARAM2, "");
    }

    public final void setPARAM2(String strValue) {
        this.SetParamValue(TAG_PARAM2, strValue);
    }

    public final boolean isPARAM3Null() {
        return this.IsParamNull(TAG_PARAM3);
    }

    public final int getPARAM3() {
        return this.GetParamIntValue(TAG_PARAM3, 0);
    }

    public final void setPARAM3(int nValue) {
        this.SetParamValue(TAG_PARAM3, nValue);
    }

    public final boolean isPARAM4Null() {
        return this.IsParamNull(TAG_PARAM4);
    }

    public final int getPARAM4() {
        return this.GetParamIntValue(TAG_PARAM4, 0);
    }

    public final void setPARAM4(int nValue) {
        this.SetParamValue(TAG_PARAM4, nValue);
    }

    public final boolean isPARAM5Null() {
        return this.IsParamNull(TAG_PARAM5);
    }

    public final boolean getPARAM5() {
        return this.GetParamIntValue(TAG_PARAM5, 0) == 1;
    }

    public final void setPARAM5(boolean bValue) {
        this.SetParamValue(TAG_PARAM5, bValue ? 1 : 0);
    }

    public final boolean isPARAM6Null() {
        return this.IsParamNull(TAG_PARAM6);
    }

    public final boolean getPARAM6() {
        return this.GetParamIntValue(TAG_PARAM6, 0) == 1;
    }

    public final void setPARAM6(boolean bValue) {
        this.SetParamValue(TAG_PARAM6, bValue ? 1 : 0);
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

    public final boolean isPARAM7Null() {
        return this.IsParamNull(TAG_PARAM7);
    }

    public final String getPARAM7() {
        return this.GetParamStringValue(TAG_PARAM7, "");
    }

    public final void setPARAM7(String strValue) {
        this.SetParamValue(TAG_PARAM7, strValue);
    }

    public final boolean isPARAM8Null() {
        return this.IsParamNull(TAG_PARAM8);
    }

    public final String getPARAM8() {
        return this.GetParamStringValue(TAG_PARAM8, "");
    }

    public final void setPARAM8(String strValue) {
        this.SetParamValue(TAG_PARAM8, strValue);
    }

    public final boolean isRULEINFONull() {
        return this.IsParamNull(TAG_RULEINFO);
    }

    public final String getRULEINFO() {
        return this.GetParamStringValue(TAG_RULEINFO, "");
    }

    public final void setRULEINFO(String strValue) {
        this.SetParamValue(TAG_RULEINFO, strValue);
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

    public final boolean isCUSTOMDEFNAMENull() {
        return this.IsParamNull(TAG_CUSTOMDEFNAME);
    }

    public final String getCUSTOMDEFNAME() {
        return this.GetParamStringValue(TAG_CUSTOMDEFNAME, "");
    }

    public final void setCUSTOMDEFNAME(String strValue) {
        this.SetParamValue(TAG_CUSTOMDEFNAME, strValue);
    }

    public final boolean isPARAM9Null() {
        return this.IsParamNull(TAG_PARAM9);
    }

    public final int getPARAM9() {
        return this.GetParamIntValue(TAG_PARAM9, 0);
    }

    public final void setPARAM9(int nValue) {
        this.SetParamValue(TAG_PARAM9, nValue);
    }

    public final boolean isPARAM10Null() {
        return this.IsParamNull(TAG_PARAM10);
    }

    public final int getPARAM10() {
        return this.GetParamIntValue(TAG_PARAM10, 0);
    }

    public final void setPARAM10(int nValue) {
        this.SetParamValue(TAG_PARAM10, nValue);
    }

    public final boolean isMAJORPSDEIDNull() {
        return this.IsParamNull(TAG_MAJORPSDEID);
    }

    public final String getMAJORPSDEID() {
        return this.GetParamStringValue(TAG_MAJORPSDEID, "");
    }

    public final void setMAJORPSDEID(String strValue) {
        this.SetParamValue(TAG_MAJORPSDEID, strValue);
    }

    public final boolean isMAJORPSDENAMENull() {
        return this.IsParamNull(TAG_MAJORPSDENAME);
    }

    public final String getMAJORPSDENAME() {
        return this.GetParamStringValue(TAG_MAJORPSDENAME, "");
    }

    public final void setMAJORPSDENAME(String strValue) {
        this.SetParamValue(TAG_MAJORPSDENAME, strValue);
    }

    public final boolean isMAJORPSDEDSTIDNull() {
        return this.IsParamNull(TAG_MAJORPSDEDSTID);
    }

    public final String getMAJORPSDEDSTID() {
        return this.GetParamStringValue(TAG_MAJORPSDEDSTID, "");
    }

    public final void setMAJORPSDEDSTID(String strValue) {
        this.SetParamValue(TAG_MAJORPSDEDSTID, strValue);
    }

    public final boolean isMAJORPSDEDSTNAMENull() {
        return this.IsParamNull(TAG_MAJORPSDEDSTNAME);
    }

    public final String getMAJORPSDEDSTNAME() {
        return this.GetParamStringValue(TAG_MAJORPSDEDSTNAME, "");
    }

    public final void setMAJORPSDEDSTNAME(String strValue) {
        this.SetParamValue(TAG_MAJORPSDEDSTNAME, strValue);
    }

    public final boolean isEXTMAJORPSDEFIDNull() {
        return this.IsParamNull(TAG_EXTMAJORPSDEFID);
    }

    public final String getEXTMAJORPSDEFID() {
        return this.GetParamStringValue(TAG_EXTMAJORPSDEFID, "");
    }

    public final void setEXTMAJORPSDEFID(String strValue) {
        this.SetParamValue(TAG_EXTMAJORPSDEFID, strValue);
    }

    public final boolean isEXTMAJORPSDEFNAMENull() {
        return this.IsParamNull(TAG_EXTMAJORPSDEFNAME);
    }

    public final String getEXTMAJORPSDEFNAME() {
        return this.GetParamStringValue(TAG_EXTMAJORPSDEFNAME, "");
    }

    public final void setEXTMAJORPSDEFNAME(String strValue) {
        this.SetParamValue(TAG_EXTMAJORPSDEFNAME, strValue);
    }

    public final boolean isEXTMINORPSDEFIDNull() {
        return this.IsParamNull(TAG_EXTMINORPSDEFID);
    }

    public final String getEXTMINORPSDEFID() {
        return this.GetParamStringValue(TAG_EXTMINORPSDEFID, "");
    }

    public final void setEXTMINORPSDEFID(String strValue) {
        this.SetParamValue(TAG_EXTMINORPSDEFID, strValue);
    }

    public final boolean isEXTMINORPSDEFNAMENull() {
        return this.IsParamNull(TAG_EXTMINORPSDEFNAME);
    }

    public final String getEXTMINORPSDEFNAME() {
        return this.GetParamStringValue(TAG_EXTMINORPSDEFNAME, "");
    }

    public final void setEXTMINORPSDEFNAME(String strValue) {
        this.SetParamValue(TAG_EXTMINORPSDEFNAME, strValue);
    }

    public final boolean isKEYCONDFLAGNull() {
        return this.IsParamNull(TAG_KEYCONDFLAG);
    }

    public final boolean getKEYCONDFLAG() {
        return this.GetParamIntValue(TAG_KEYCONDFLAG, 0) == 1;
    }

    public final void setKEYCONDFLAG(boolean bValue) {
        this.SetParamValue(TAG_KEYCONDFLAG, bValue ? 1 : 0);
    }

    public final boolean isPSSYSVALUERULEIDNull() {
        return this.IsParamNull(TAG_PSSYSVALUERULEID);
    }

    public final String getPSSYSVALUERULEID() {
        return this.GetParamStringValue(TAG_PSSYSVALUERULEID, "");
    }

    public final void setPSSYSVALUERULEID(String strValue) {
        this.SetParamValue(TAG_PSSYSVALUERULEID, strValue);
    }

    public final boolean isPSSYSVALUERULENAMENull() {
        return this.IsParamNull(TAG_PSSYSVALUERULENAME);
    }

    public final String getPSSYSVALUERULENAME() {
        return this.GetParamStringValue(TAG_PSSYSVALUERULENAME, "");
    }

    public final void setPSSYSVALUERULENAME(String strValue) {
        this.SetParamValue(TAG_PSSYSVALUERULENAME, strValue);
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

    public final boolean isRIPSLANRESIDNull() {
        return this.IsParamNull(TAG_RIPSLANRESID);
    }

    public final String getRIPSLANRESID() {
        return this.GetParamStringValue(TAG_RIPSLANRESID, "");
    }

    public final void setRIPSLANRESID(String strValue) {
        this.SetParamValue(TAG_RIPSLANRESID, strValue);
    }

    public final boolean isRIPSLANRESNAMENull() {
        return this.IsParamNull(TAG_RIPSLANRESNAME);
    }

    public final String getRIPSLANRESNAME() {
        return this.GetParamStringValue(TAG_RIPSLANRESNAME, "");
    }

    public final void setRIPSLANRESNAME(String strValue) {
        this.SetParamValue(TAG_RIPSLANRESNAME, strValue);
    }

    public ArrayList<PSDEFValueRuleCond> getChildPSDEFValueRuleConds(boolean bCreated) {
        if (this.childPSDEFValueRuleCondList != null) {
            return this.childPSDEFValueRuleCondList;
        }
        if (bCreated) {
            this.childPSDEFValueRuleCondList = new ArrayList();
        }
        return this.childPSDEFValueRuleCondList;
    }

    public void resetChildDatas() {
        if (this.childPSDEFValueRuleCondList != null) {
            this.childPSDEFValueRuleCondList.clear();
            this.childPSDEFValueRuleCondList = null;
        }
    }
}

