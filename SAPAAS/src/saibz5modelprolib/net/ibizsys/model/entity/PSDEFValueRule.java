/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.entity;

import java.util.ArrayList;
import java.util.Date;
import net.ibizsys.model.entity.BaseDataEntity;
import net.ibizsys.model.entity.PSDEFValueRuleCond;

public class PSDEFValueRule
extends BaseDataEntity {
    public static final String VRTYPE_GROUP = "GROUP";
    public static final String VRTYPE_NULLRULE = "NULLRULE";
    public static final String VRTYPE_VALUERANGE = "VALUERANGE";
    public static final String VRTYPE_VALUERANGE2 = "VALUERANGE2";
    public static final String VRTYPE_REGEX = "REGEX";
    public static final String VRTYPE_STRINGLENGTH = "STRINGLENGTH";
    public static final String TAG_PSDEFVALUERULEID = "PSDEFVALUERULEID";
    public static final String TAG_PSDEFVALUERULENAME = "PSDEFVALUERULENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSDEFID = "PSDEFID";
    public static final String TAG_PSDEFNAME = "PSDEFNAME";
    public static final String TAG_VRTYPE = "VRTYPE";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_PSDEFVRTYPEDETAILID = "PSDEFVRTYPEDETAILID";
    public static final String TAG_PSDEFVRTYPEDETAILNAME = "PSDEFVRTYPEDETAILNAME";
    public static final String TAG_VRMODEL = "VRMODEL";
    public static final String TAG_DEFAULTMODE = "DEFAULTMODE";
    public static final String TAG_PSDEID = "PSDEID";
    public static final String TAG_PSDENAME = "PSDENAME";
    public static final String TAG_RULEINFO = "RULEINFO";
    public static final String TAG_CODENAME = "CODENAME";
    public static final String TAG_CHECKDEFAULT = "CHECKDEFAULT";
    private ArrayList<PSDEFValueRuleCond> PSDEFValueRuleCondList = null;

    public final boolean isPSDEFVALUERULEIDNull() {
        return this.isParamNull(TAG_PSDEFVALUERULEID);
    }

    public final String getPSDEFVALUERULEID() {
        return this.getParamStringValue(TAG_PSDEFVALUERULEID, "");
    }

    public final void setPSDEFVALUERULEID(String strValue) {
        this.setParamValue(TAG_PSDEFVALUERULEID, strValue);
    }

    public final boolean isPSDEFVALUERULENAMENull() {
        return this.isParamNull(TAG_PSDEFVALUERULENAME);
    }

    public final String getPSDEFVALUERULENAME() {
        return this.getParamStringValue(TAG_PSDEFVALUERULENAME, "");
    }

    public final void setPSDEFVALUERULENAME(String strValue) {
        this.setParamValue(TAG_PSDEFVALUERULENAME, strValue);
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

    public final boolean isVRTYPENull() {
        return this.isParamNull(TAG_VRTYPE);
    }

    public final String getVRTYPE() {
        return this.getParamStringValue(TAG_VRTYPE, "");
    }

    public final void setVRTYPE(String strValue) {
        this.setParamValue(TAG_VRTYPE, strValue);
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

    public final boolean isPSDEFVRTYPEDETAILIDNull() {
        return this.isParamNull(TAG_PSDEFVRTYPEDETAILID);
    }

    public final String getPSDEFVRTYPEDETAILID() {
        return this.getParamStringValue(TAG_PSDEFVRTYPEDETAILID, "");
    }

    public final void setPSDEFVRTYPEDETAILID(String strValue) {
        this.setParamValue(TAG_PSDEFVRTYPEDETAILID, strValue);
    }

    public final boolean isPSDEFVRTYPEDETAILNAMENull() {
        return this.isParamNull(TAG_PSDEFVRTYPEDETAILNAME);
    }

    public final String getPSDEFVRTYPEDETAILNAME() {
        return this.getParamStringValue(TAG_PSDEFVRTYPEDETAILNAME, "");
    }

    public final void setPSDEFVRTYPEDETAILNAME(String strValue) {
        this.setParamValue(TAG_PSDEFVRTYPEDETAILNAME, strValue);
    }

    public final boolean isVRMODELNull() {
        return this.isParamNull(TAG_VRMODEL);
    }

    public final String getVRMODEL() {
        return this.getParamStringValue(TAG_VRMODEL, "");
    }

    public final void setVRMODEL(String strValue) {
        this.setParamValue(TAG_VRMODEL, strValue);
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

    public final boolean isRULEINFONull() {
        return this.isParamNull(TAG_RULEINFO);
    }

    public final String getRULEINFO() {
        return this.getParamStringValue(TAG_RULEINFO, "");
    }

    public final void setRULEINFO(String strValue) {
        this.setParamValue(TAG_RULEINFO, strValue);
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

    public final boolean isCHECKDEFAULTNull() {
        return this.isParamNull(TAG_CHECKDEFAULT);
    }

    public final boolean getCHECKDEFAULT() {
        return this.getParamIntValue(TAG_CHECKDEFAULT, 0) == 1;
    }

    public final void setCHECKDEFAULT(boolean bValue) {
        this.setParamValue(TAG_CHECKDEFAULT, bValue ? 1 : 0);
    }

    public ArrayList<PSDEFValueRuleCond> getPSDEFValueRuleConds(boolean bCreated) {
        if (this.PSDEFValueRuleCondList != null) {
            return this.PSDEFValueRuleCondList;
        }
        if (bCreated) {
            this.PSDEFValueRuleCondList = new ArrayList();
        }
        return this.PSDEFValueRuleCondList;
    }

    public void resetChildDatas() {
        if (this.PSDEFValueRuleCondList != null) {
            this.PSDEFValueRuleCondList.clear();
            this.PSDEFValueRuleCondList = null;
        }
    }
}

