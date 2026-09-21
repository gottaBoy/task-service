/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFDA.PS.Data.PSDEFValueRuleCond;
import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.ArrayList;
import java.util.Date;

public class PSDEFValueRule
extends BaseDataEntity {
    public static final String VRTYPE_GROUP = "GROUP";
    public static final String VRTYPE_NULLRULE = "NULLRULE";
    public static final String VRTYPE_VALUERANGE = "VALUERANGE";
    public static final String VRTYPE_VALUERANGE2 = "VALUERANGE2";
    public static final String VRTYPE_REGEX = "REGEX";
    public static final String VRTYPE_STRINGLENGTH = "STRINGLENGTH";
    public static final String TAG_CUSTOMMODE = "CUSTOMMODE";
    public static final String TAG_CUSTOMCODE = "CUSTOMCODE";
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
    public static final String TAG_PSSYSPFPLUGINID = "PSSYSPFPLUGINID";
    public static final String TAG_PSSYSPFPLUGINNAME = "PSSYSPFPLUGINNAME";
    public static final String TAG_PSSYSSFPLUGINID = "PSSYSSFPLUGINID";
    public static final String TAG_PSSYSSFPLUGINNAME = "PSSYSSFPLUGINNAME";
    public static final String TAG_RULEHOLDER = "RULEHOLDER";
    public static final String TAG_RULETAG = "RULETAG";
    public static final String TAG_RULETAG2 = "RULETAG2";
    public static final String TAG_PSDEFORMID = "PSDEFORMID";
    public static final String TAG_PSDEFORMNAME = "PSDEFORMNAME";
    public static final String TAG_RIPSLANRESID = "RIPSLANRESID";
    public static final String TAG_RIPSLANRESNAME = "RIPSLANRESNAME";
    private ArrayList<PSDEFValueRuleCond> PSDEFValueRuleCondList = null;

    public final boolean isPSDEFVALUERULEIDNull() {
        return this.IsParamNull(TAG_PSDEFVALUERULEID);
    }

    public final String getPSDEFVALUERULEID() {
        return this.GetParamStringValue(TAG_PSDEFVALUERULEID, "");
    }

    public final void setPSDEFVALUERULEID(String strValue) {
        this.SetParamValue(TAG_PSDEFVALUERULEID, strValue);
    }

    public final boolean isPSDEFVALUERULENAMENull() {
        return this.IsParamNull(TAG_PSDEFVALUERULENAME);
    }

    public final String getPSDEFVALUERULENAME() {
        return this.GetParamStringValue(TAG_PSDEFVALUERULENAME, "");
    }

    public final void setPSDEFVALUERULENAME(String strValue) {
        this.SetParamValue(TAG_PSDEFVALUERULENAME, strValue);
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

    public final boolean isVRTYPENull() {
        return this.IsParamNull(TAG_VRTYPE);
    }

    public final String getVRTYPE() {
        return this.GetParamStringValue(TAG_VRTYPE, "");
    }

    public final void setVRTYPE(String strValue) {
        this.SetParamValue(TAG_VRTYPE, strValue);
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

    public final boolean isPSDEFVRTYPEDETAILIDNull() {
        return this.IsParamNull(TAG_PSDEFVRTYPEDETAILID);
    }

    public final String getPSDEFVRTYPEDETAILID() {
        return this.GetParamStringValue(TAG_PSDEFVRTYPEDETAILID, "");
    }

    public final void setPSDEFVRTYPEDETAILID(String strValue) {
        this.SetParamValue(TAG_PSDEFVRTYPEDETAILID, strValue);
    }

    public final boolean isPSDEFVRTYPEDETAILNAMENull() {
        return this.IsParamNull(TAG_PSDEFVRTYPEDETAILNAME);
    }

    public final String getPSDEFVRTYPEDETAILNAME() {
        return this.GetParamStringValue(TAG_PSDEFVRTYPEDETAILNAME, "");
    }

    public final void setPSDEFVRTYPEDETAILNAME(String strValue) {
        this.SetParamValue(TAG_PSDEFVRTYPEDETAILNAME, strValue);
    }

    public final boolean isVRMODELNull() {
        return this.IsParamNull(TAG_VRMODEL);
    }

    public final String getVRMODEL() {
        return this.GetParamStringValue(TAG_VRMODEL, "");
    }

    public final void setVRMODEL(String strValue) {
        this.SetParamValue(TAG_VRMODEL, strValue);
    }

    public final boolean isDEFAULTMODENull() {
        return this.IsParamNull(TAG_DEFAULTMODE);
    }

    public final boolean getDEFAULTMODE() {
        return this.GetParamIntValue(TAG_DEFAULTMODE, 0) == 1;
    }

    public final void setDEFAULTMODE(boolean bValue) {
        this.SetParamValue(TAG_DEFAULTMODE, bValue ? 1 : 0);
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

    public final boolean isPSDENAMENull() {
        return this.IsParamNull(TAG_PSDENAME);
    }

    public final String getPSDENAME() {
        return this.GetParamStringValue(TAG_PSDENAME, "");
    }

    public final void setPSDENAME(String strValue) {
        this.SetParamValue(TAG_PSDENAME, strValue);
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

    public final boolean isCODENAMENull() {
        return this.IsParamNull(TAG_CODENAME);
    }

    public final String getCODENAME() {
        return this.GetParamStringValue(TAG_CODENAME, "");
    }

    public final void setCODENAME(String strValue) {
        this.SetParamValue(TAG_CODENAME, strValue);
    }

    public final boolean isCHECKDEFAULTNull() {
        return this.IsParamNull(TAG_CHECKDEFAULT);
    }

    public final boolean getCHECKDEFAULT() {
        return this.GetParamIntValue(TAG_CHECKDEFAULT, 0) == 1;
    }

    public final void setCHECKDEFAULT(boolean bValue) {
        this.SetParamValue(TAG_CHECKDEFAULT, bValue ? 1 : 0);
    }

    public final boolean isPSSYSPFPLUGINIDNull() {
        return this.IsParamNull(TAG_PSSYSPFPLUGINID);
    }

    public final String getPSSYSPFPLUGINID() {
        return this.GetParamStringValue(TAG_PSSYSPFPLUGINID, "");
    }

    public final void setPSSYSPFPLUGINID(String strValue) {
        this.SetParamValue(TAG_PSSYSPFPLUGINID, strValue);
    }

    public final boolean isPSSYSPFPLUGINNAMENull() {
        return this.IsParamNull(TAG_PSSYSPFPLUGINNAME);
    }

    public final String getPSSYSPFPLUGINNAME() {
        return this.GetParamStringValue(TAG_PSSYSPFPLUGINNAME, "");
    }

    public final void setPSSYSPFPLUGINNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSPFPLUGINNAME, strValue);
    }

    public final boolean isPSSYSSFPLUGINIDNull() {
        return this.IsParamNull(TAG_PSSYSSFPLUGINID);
    }

    public final String getPSSYSSFPLUGINID() {
        return this.GetParamStringValue(TAG_PSSYSSFPLUGINID, "");
    }

    public final void setPSSYSSFPLUGINID(String strValue) {
        this.SetParamValue(TAG_PSSYSSFPLUGINID, strValue);
    }

    public final boolean isPSSYSSFPLUGINNAMENull() {
        return this.IsParamNull(TAG_PSSYSSFPLUGINNAME);
    }

    public final String getPSSYSSFPLUGINNAME() {
        return this.GetParamStringValue(TAG_PSSYSSFPLUGINNAME, "");
    }

    public final void setPSSYSSFPLUGINNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSSFPLUGINNAME, strValue);
    }

    public final boolean isRULEHOLDERNull() {
        return this.IsParamNull(TAG_RULEHOLDER);
    }

    public final int getRULEHOLDER() {
        return this.GetParamIntValue(TAG_RULEHOLDER, 0);
    }

    public final void setRULEHOLDER(int nValue) {
        this.SetParamValue(TAG_RULEHOLDER, nValue);
    }

    public final boolean isRULETAGNull() {
        return this.IsParamNull(TAG_RULETAG);
    }

    public final String getRULETAG() {
        return this.GetParamStringValue(TAG_RULETAG, "");
    }

    public final void setRULETAG(String strValue) {
        this.SetParamValue(TAG_RULETAG, strValue);
    }

    public final boolean isRULETAG2Null() {
        return this.IsParamNull(TAG_RULETAG2);
    }

    public final String getRULETAG2() {
        return this.GetParamStringValue(TAG_RULETAG2, "");
    }

    public final void setRULETAG2(String strValue) {
        this.SetParamValue(TAG_RULETAG2, strValue);
    }

    public final boolean isCUSTOMMODENull() {
        return this.IsParamNull(TAG_CUSTOMMODE);
    }

    public final boolean getCUSTOMMODE() {
        return this.GetParamIntValue(TAG_CUSTOMMODE, 0) == 1;
    }

    public final void setCUSTOMMODE(boolean bValue) {
        this.SetParamValue(TAG_CUSTOMMODE, bValue ? 1 : 0);
    }

    public final boolean isCUSTOMCODENull() {
        return this.IsParamNull(TAG_CUSTOMCODE);
    }

    public final String getCUSTOMCODE() {
        return this.GetParamStringValue(TAG_CUSTOMCODE, "");
    }

    public final void setCUSTOMCODE(String strValue) {
        this.SetParamValue(TAG_CUSTOMCODE, strValue);
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

