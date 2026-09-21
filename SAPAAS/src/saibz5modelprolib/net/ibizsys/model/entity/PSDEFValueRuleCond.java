/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.entity;

import java.util.ArrayList;
import java.util.Date;
import net.ibizsys.model.entity.BaseDataEntity;

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
    private ArrayList<PSDEFValueRuleCond> childPSDEFValueRuleCondList = null;

    public final boolean isPSDEFVRCONDIDNull() {
        return this.isParamNull(TAG_PSDEFVRCONDID);
    }

    public final String getPSDEFVRCONDID() {
        return this.getParamStringValue(TAG_PSDEFVRCONDID, "");
    }

    public final void setPSDEFVRCONDID(String strValue) {
        this.setParamValue(TAG_PSDEFVRCONDID, strValue);
    }

    public final boolean isPSDEFVRCONDNAMENull() {
        return this.isParamNull(TAG_PSDEFVRCONDNAME);
    }

    public final String getPSDEFVRCONDNAME() {
        return this.getParamStringValue(TAG_PSDEFVRCONDNAME, "");
    }

    public final void setPSDEFVRCONDNAME(String strValue) {
        this.setParamValue(TAG_PSDEFVRCONDNAME, strValue);
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

    public final boolean isPSDEFVRIDNull() {
        return this.isParamNull(TAG_PSDEFVRID);
    }

    public final String getPSDEFVRID() {
        return this.getParamStringValue(TAG_PSDEFVRID, "");
    }

    public final void setPSDEFVRID(String strValue) {
        this.setParamValue(TAG_PSDEFVRID, strValue);
    }

    public final boolean isPSDEFVRNAMENull() {
        return this.isParamNull(TAG_PSDEFVRNAME);
    }

    public final String getPSDEFVRNAME() {
        return this.getParamStringValue(TAG_PSDEFVRNAME, "");
    }

    public final void setPSDEFVRNAME(String strValue) {
        this.setParamValue(TAG_PSDEFVRNAME, strValue);
    }

    public final boolean isPPSDEFVRCONDIDNull() {
        return this.isParamNull(TAG_PPSDEFVRCONDID);
    }

    public final String getPPSDEFVRCONDID() {
        return this.getParamStringValue(TAG_PPSDEFVRCONDID, "");
    }

    public final void setPPSDEFVRCONDID(String strValue) {
        this.setParamValue(TAG_PPSDEFVRCONDID, strValue);
    }

    public final boolean isPPSDEFVRCONDNAMENull() {
        return this.isParamNull(TAG_PPSDEFVRCONDNAME);
    }

    public final String getPPSDEFVRCONDNAME() {
        return this.getParamStringValue(TAG_PPSDEFVRCONDNAME, "");
    }

    public final void setPPSDEFVRCONDNAME(String strValue) {
        this.setParamValue(TAG_PPSDEFVRCONDNAME, strValue);
    }

    public final boolean isCONDTYPENull() {
        return this.isParamNull(TAG_CONDTYPE);
    }

    public final String getCONDTYPE() {
        return this.getParamStringValue(TAG_CONDTYPE, "");
    }

    public final void setCONDTYPE(String strValue) {
        this.setParamValue(TAG_CONDTYPE, strValue);
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

    public final boolean isMEMONull() {
        return this.isParamNull(TAG_MEMO);
    }

    public final String getMEMO() {
        return this.getParamStringValue(TAG_MEMO, "");
    }

    public final void setMEMO(String strValue) {
        this.setParamValue(TAG_MEMO, strValue);
    }

    public final boolean isLEVELTAGNull() {
        return this.isParamNull(TAG_LEVELTAG);
    }

    public final String getLEVELTAG() {
        return this.getParamStringValue(TAG_LEVELTAG, "");
    }

    public final void setLEVELTAG(String strValue) {
        this.setParamValue(TAG_LEVELTAG, strValue);
    }

    public final boolean isLEVELVALUENull() {
        return this.isParamNull(TAG_LEVELVALUE);
    }

    public final int getLEVELVALUE() {
        return this.getParamIntValue(TAG_LEVELVALUE, 0);
    }

    public final void setLEVELVALUE(int nValue) {
        this.setParamValue(TAG_LEVELVALUE, nValue);
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

    public final boolean isPSDEFIDNull() {
        return this.isParamNull(TAG_PSDEFID);
    }

    public final String getPSDEFID() {
        return this.getParamStringValue(TAG_PSDEFID, "");
    }

    public final void setPSDEFID(String strValue) {
        this.setParamValue(TAG_PSDEFID, strValue);
    }

    public final boolean isPSDEFNAMENull() {
        return this.isParamNull(TAG_PSDEFNAME);
    }

    public final String getPSDEFNAME() {
        return this.getParamStringValue(TAG_PSDEFNAME, "");
    }

    public final void setPSDEFNAME(String strValue) {
        this.setParamValue(TAG_PSDEFNAME, strValue);
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

    public final boolean isCONDVALUENull() {
        return this.isParamNull(TAG_CONDVALUE);
    }

    public final String getCONDVALUE() {
        return this.getParamStringValue(TAG_CONDVALUE, "");
    }

    public final void setCONDVALUE(String strValue) {
        this.setParamValue(TAG_CONDVALUE, strValue);
    }

    public final boolean isPARAMNull() {
        return this.isParamNull(TAG_PARAM);
    }

    public final String getPARAM() {
        return this.getParamStringValue(TAG_PARAM, "");
    }

    public final void setPARAM(String strValue) {
        this.setParamValue(TAG_PARAM, strValue);
    }

    public final boolean isPARAM2Null() {
        return this.isParamNull(TAG_PARAM2);
    }

    public final String getPARAM2() {
        return this.getParamStringValue(TAG_PARAM2, "");
    }

    public final void setPARAM2(String strValue) {
        this.setParamValue(TAG_PARAM2, strValue);
    }

    public final boolean isPARAM3Null() {
        return this.isParamNull(TAG_PARAM3);
    }

    public final int getPARAM3() {
        return this.getParamIntValue(TAG_PARAM3, 0);
    }

    public final void setPARAM3(int nValue) {
        this.setParamValue(TAG_PARAM3, nValue);
    }

    public final boolean isPARAM4Null() {
        return this.isParamNull(TAG_PARAM4);
    }

    public final int getPARAM4() {
        return this.getParamIntValue(TAG_PARAM4, 0);
    }

    public final void setPARAM4(int nValue) {
        this.setParamValue(TAG_PARAM4, nValue);
    }

    public final boolean isPARAM5Null() {
        return this.isParamNull(TAG_PARAM5);
    }

    public final boolean getPARAM5() {
        return this.getParamIntValue(TAG_PARAM5, 0) == 1;
    }

    public final void setPARAM5(boolean bValue) {
        this.setParamValue(TAG_PARAM5, bValue ? 1 : 0);
    }

    public final boolean isPARAM6Null() {
        return this.isParamNull(TAG_PARAM6);
    }

    public final boolean getPARAM6() {
        return this.getParamIntValue(TAG_PARAM6, 0) == 1;
    }

    public final void setPARAM6(boolean bValue) {
        this.setParamValue(TAG_PARAM6, bValue ? 1 : 0);
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

    public final boolean isPARAM7Null() {
        return this.isParamNull(TAG_PARAM7);
    }

    public final String getPARAM7() {
        return this.getParamStringValue(TAG_PARAM7, "");
    }

    public final void setPARAM7(String strValue) {
        this.setParamValue(TAG_PARAM7, strValue);
    }

    public final boolean isPARAM8Null() {
        return this.isParamNull(TAG_PARAM8);
    }

    public final String getPARAM8() {
        return this.getParamStringValue(TAG_PARAM8, "");
    }

    public final void setPARAM8(String strValue) {
        this.setParamValue(TAG_PARAM8, strValue);
    }

    public final boolean isRULEINFONull() {
        return this.isParamNull(TAG_RULEINFO);
    }

    public final String getRULEINFO() {
        return this.getParamStringValue(TAG_RULEINFO, "");
    }

    public final void setRULEINFO(String strValue) {
        this.setParamValue(TAG_RULEINFO, strValue);
    }

    public final boolean isPSDEDQIDNull() {
        return this.isParamNull(TAG_PSDEDQID);
    }

    public final String getPSDEDQID() {
        return this.getParamStringValue(TAG_PSDEDQID, "");
    }

    public final void setPSDEDQID(String strValue) {
        this.setParamValue(TAG_PSDEDQID, strValue);
    }

    public final boolean isPSDEDQNAMENull() {
        return this.isParamNull(TAG_PSDEDQNAME);
    }

    public final String getPSDEDQNAME() {
        return this.getParamStringValue(TAG_PSDEDQNAME, "");
    }

    public final void setPSDEDQNAME(String strValue) {
        this.setParamValue(TAG_PSDEDQNAME, strValue);
    }

    public final boolean isCUSTOMDEFNAMENull() {
        return this.isParamNull(TAG_CUSTOMDEFNAME);
    }

    public final String getCUSTOMDEFNAME() {
        return this.getParamStringValue(TAG_CUSTOMDEFNAME, "");
    }

    public final void setCUSTOMDEFNAME(String strValue) {
        this.setParamValue(TAG_CUSTOMDEFNAME, strValue);
    }

    public final boolean isPARAM9Null() {
        return this.isParamNull(TAG_PARAM9);
    }

    public final int getPARAM9() {
        return this.getParamIntValue(TAG_PARAM9, 0);
    }

    public final void setPARAM9(int nValue) {
        this.setParamValue(TAG_PARAM9, nValue);
    }

    public final boolean isPARAM10Null() {
        return this.isParamNull(TAG_PARAM10);
    }

    public final int getPARAM10() {
        return this.getParamIntValue(TAG_PARAM10, 0);
    }

    public final void setPARAM10(int nValue) {
        this.setParamValue(TAG_PARAM10, nValue);
    }

    public final boolean isMAJORPSDEIDNull() {
        return this.isParamNull(TAG_MAJORPSDEID);
    }

    public final String getMAJORPSDEID() {
        return this.getParamStringValue(TAG_MAJORPSDEID, "");
    }

    public final void setMAJORPSDEID(String strValue) {
        this.setParamValue(TAG_MAJORPSDEID, strValue);
    }

    public final boolean isMAJORPSDENAMENull() {
        return this.isParamNull(TAG_MAJORPSDENAME);
    }

    public final String getMAJORPSDENAME() {
        return this.getParamStringValue(TAG_MAJORPSDENAME, "");
    }

    public final void setMAJORPSDENAME(String strValue) {
        this.setParamValue(TAG_MAJORPSDENAME, strValue);
    }

    public final boolean isMAJORPSDEDSTIDNull() {
        return this.isParamNull(TAG_MAJORPSDEDSTID);
    }

    public final String getMAJORPSDEDSTID() {
        return this.getParamStringValue(TAG_MAJORPSDEDSTID, "");
    }

    public final void setMAJORPSDEDSTID(String strValue) {
        this.setParamValue(TAG_MAJORPSDEDSTID, strValue);
    }

    public final boolean isMAJORPSDEDSTNAMENull() {
        return this.isParamNull(TAG_MAJORPSDEDSTNAME);
    }

    public final String getMAJORPSDEDSTNAME() {
        return this.getParamStringValue(TAG_MAJORPSDEDSTNAME, "");
    }

    public final void setMAJORPSDEDSTNAME(String strValue) {
        this.setParamValue(TAG_MAJORPSDEDSTNAME, strValue);
    }

    public final boolean isEXTMAJORPSDEFIDNull() {
        return this.isParamNull(TAG_EXTMAJORPSDEFID);
    }

    public final String getEXTMAJORPSDEFID() {
        return this.getParamStringValue(TAG_EXTMAJORPSDEFID, "");
    }

    public final void setEXTMAJORPSDEFID(String strValue) {
        this.setParamValue(TAG_EXTMAJORPSDEFID, strValue);
    }

    public final boolean isEXTMAJORPSDEFNAMENull() {
        return this.isParamNull(TAG_EXTMAJORPSDEFNAME);
    }

    public final String getEXTMAJORPSDEFNAME() {
        return this.getParamStringValue(TAG_EXTMAJORPSDEFNAME, "");
    }

    public final void setEXTMAJORPSDEFNAME(String strValue) {
        this.setParamValue(TAG_EXTMAJORPSDEFNAME, strValue);
    }

    public final boolean isEXTMINORPSDEFIDNull() {
        return this.isParamNull(TAG_EXTMINORPSDEFID);
    }

    public final String getEXTMINORPSDEFID() {
        return this.getParamStringValue(TAG_EXTMINORPSDEFID, "");
    }

    public final void setEXTMINORPSDEFID(String strValue) {
        this.setParamValue(TAG_EXTMINORPSDEFID, strValue);
    }

    public final boolean isEXTMINORPSDEFNAMENull() {
        return this.isParamNull(TAG_EXTMINORPSDEFNAME);
    }

    public final String getEXTMINORPSDEFNAME() {
        return this.getParamStringValue(TAG_EXTMINORPSDEFNAME, "");
    }

    public final void setEXTMINORPSDEFNAME(String strValue) {
        this.setParamValue(TAG_EXTMINORPSDEFNAME, strValue);
    }

    public final boolean isKEYCONDFLAGNull() {
        return this.isParamNull(TAG_KEYCONDFLAG);
    }

    public final boolean getKEYCONDFLAG() {
        return this.getParamIntValue(TAG_KEYCONDFLAG, 0) == 1;
    }

    public final void setKEYCONDFLAG(boolean bValue) {
        this.setParamValue(TAG_KEYCONDFLAG, bValue ? 1 : 0);
    }

    public final boolean isPSSYSVALUERULEIDNull() {
        return this.isParamNull(TAG_PSSYSVALUERULEID);
    }

    public final String getPSSYSVALUERULEID() {
        return this.getParamStringValue(TAG_PSSYSVALUERULEID, "");
    }

    public final void setPSSYSVALUERULEID(String strValue) {
        this.setParamValue(TAG_PSSYSVALUERULEID, strValue);
    }

    public final boolean isPSSYSVALUERULENAMENull() {
        return this.isParamNull(TAG_PSSYSVALUERULENAME);
    }

    public final String getPSSYSVALUERULENAME() {
        return this.getParamStringValue(TAG_PSSYSVALUERULENAME, "");
    }

    public final void setPSSYSVALUERULENAME(String strValue) {
        this.setParamValue(TAG_PSSYSVALUERULENAME, strValue);
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

