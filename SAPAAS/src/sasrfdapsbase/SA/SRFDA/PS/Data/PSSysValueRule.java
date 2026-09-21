/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSSysValueRule
extends BaseDataEntity {
    public static final String RULETYPE_SCRIPT = "SCRIPT";
    public static final String RULETYPE_REG = "REG";
    public static final String TAG_PSSYSVALUERULEID = "PSSYSVALUERULEID";
    public static final String TAG_PSSYSVALUERULENAME = "PSSYSVALUERULENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSSYSTEMID = "PSSYSTEMID";
    public static final String TAG_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String TAG_PSVALUERULEID = "PSVALUERULEID";
    public static final String TAG_PSVALUERULENAME = "PSVALUERULENAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_RULEINFO = "RULEINFO";
    public static final String TAG_RULETYPE = "RULETYPE";
    public static final String TAG_SCRIPT = "SCRIPT";
    public static final String TAG_REGEXPCODE = "REGEXPCODE";
    public static final String TAG_CUSTOMOBJ = "CUSTOMOBJ";
    public static final String TAG_CUSTOMPARAMS = "CUSTOMPARAMS";
    public static final String TAG_PSMODULEID = "PSMODULEID";
    public static final String TAG_PSMODULENAME = "PSMODULENAME";
    public static final String TAG_LOCKFLAG = "LOCKFLAG";
    public static final String TAG_PSDYNAINSTID = "PSDYNAINSTID";
    public static final String TAG_DYNAMODELFLAG = "DYNAMODELFLAG";
    public static final String TAG_CODENAME = "CODENAME";
    public static final String TAG_USERTAG = "USERTAG";
    public static final String TAG_USERTAG2 = "USERTAG2";
    public static final String TAG_USERTAG3 = "USERTAG3";
    public static final String TAG_USERTAG4 = "USERTAG4";
    public static final String TAG_REGEXPCODE2 = "REGEXPCODE2";
    public static final String TAG_REGEXPCODE3 = "REGEXPCODE3";
    public static final String TAG_REGEXPCODE4 = "REGEXPCODE4";
    public static final String TAG_PSSYSSFPLUGINID = "PSSYSSFPLUGINID";
    public static final String TAG_PSSYSSFPLUGINNAME = "PSSYSSFPLUGINNAME";
    public static final String TAG_PSSYSPFPLUGINID = "PSSYSPFPLUGINID";
    public static final String TAG_PSSYSPFPLUGINNAME = "PSSYSPFPLUGINNAME";
    public static final String TAG_RULEHOLDER = "RULEHOLDER";
    public static final String TAG_RULETAG = "RULETAG";
    public static final String TAG_RULETAG2 = "RULETAG2";
    public static final String TAG_RIPSLANRESID = "RIPSLANRESID";
    public static final String TAG_RIPSLANRESNAME = "RIPSLANRESNAME";

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

    public final boolean isPSSYSTEMIDNull() {
        return this.IsParamNull(TAG_PSSYSTEMID);
    }

    public final String getPSSYSTEMID() {
        return this.GetParamStringValue(TAG_PSSYSTEMID, "");
    }

    public final void setPSSYSTEMID(String strValue) {
        this.SetParamValue(TAG_PSSYSTEMID, strValue);
    }

    public final boolean isPSSYSTEMNAMENull() {
        return this.IsParamNull(TAG_PSSYSTEMNAME);
    }

    public final String getPSSYSTEMNAME() {
        return this.GetParamStringValue(TAG_PSSYSTEMNAME, "");
    }

    public final void setPSSYSTEMNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSTEMNAME, strValue);
    }

    public final boolean isPSVALUERULEIDNull() {
        return this.IsParamNull(TAG_PSVALUERULEID);
    }

    public final String getPSVALUERULEID() {
        return this.GetParamStringValue(TAG_PSVALUERULEID, "");
    }

    public final void setPSVALUERULEID(String strValue) {
        this.SetParamValue(TAG_PSVALUERULEID, strValue);
    }

    public final boolean isPSVALUERULENAMENull() {
        return this.IsParamNull(TAG_PSVALUERULENAME);
    }

    public final String getPSVALUERULENAME() {
        return this.GetParamStringValue(TAG_PSVALUERULENAME, "");
    }

    public final void setPSVALUERULENAME(String strValue) {
        this.SetParamValue(TAG_PSVALUERULENAME, strValue);
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

    public final boolean isRULEINFONull() {
        return this.IsParamNull(TAG_RULEINFO);
    }

    public final String getRULEINFO() {
        return this.GetParamStringValue(TAG_RULEINFO, "");
    }

    public final void setRULEINFO(String strValue) {
        this.SetParamValue(TAG_RULEINFO, strValue);
    }

    public final boolean isRULETYPENull() {
        return this.IsParamNull(TAG_RULETYPE);
    }

    public final String getRULETYPE() {
        return this.GetParamStringValue(TAG_RULETYPE, "");
    }

    public final void setRULETYPE(String strValue) {
        this.SetParamValue(TAG_RULETYPE, strValue);
    }

    public final boolean isSCRIPTNull() {
        return this.IsParamNull("SCRIPT");
    }

    public final String getSCRIPT() {
        return this.GetParamStringValue("SCRIPT", "");
    }

    public final void setSCRIPT(String strValue) {
        this.SetParamValue("SCRIPT", strValue);
    }

    public final boolean isREGEXPCODENull() {
        return this.IsParamNull(TAG_REGEXPCODE);
    }

    public final String getREGEXPCODE() {
        return this.GetParamStringValue(TAG_REGEXPCODE, "");
    }

    public final void setREGEXPCODE(String strValue) {
        this.SetParamValue(TAG_REGEXPCODE, strValue);
    }

    public final boolean isCUSTOMOBJNull() {
        return this.IsParamNull(TAG_CUSTOMOBJ);
    }

    public final String getCUSTOMOBJ() {
        return this.GetParamStringValue(TAG_CUSTOMOBJ, "");
    }

    public final void setCUSTOMOBJ(String strValue) {
        this.SetParamValue(TAG_CUSTOMOBJ, strValue);
    }

    public final boolean isCUSTOMPARAMSNull() {
        return this.IsParamNull(TAG_CUSTOMPARAMS);
    }

    public final String getCUSTOMPARAMS() {
        return this.GetParamStringValue(TAG_CUSTOMPARAMS, "");
    }

    public final void setCUSTOMPARAMS(String strValue) {
        this.SetParamValue(TAG_CUSTOMPARAMS, strValue);
    }

    public final boolean isPSMODULEIDNull() {
        return this.IsParamNull(TAG_PSMODULEID);
    }

    public final String getPSMODULEID() {
        return this.GetParamStringValue(TAG_PSMODULEID, "");
    }

    public final void setPSMODULEID(String strValue) {
        this.SetParamValue(TAG_PSMODULEID, strValue);
    }

    public final boolean isPSMODULENAMENull() {
        return this.IsParamNull(TAG_PSMODULENAME);
    }

    public final String getPSMODULENAME() {
        return this.GetParamStringValue(TAG_PSMODULENAME, "");
    }

    public final void setPSMODULENAME(String strValue) {
        this.SetParamValue(TAG_PSMODULENAME, strValue);
    }

    public final boolean isLOCKFLAGNull() {
        return this.IsParamNull(TAG_LOCKFLAG);
    }

    public final boolean getLOCKFLAG() {
        return this.GetParamIntValue(TAG_LOCKFLAG, 0) == 1;
    }

    public final void setLOCKFLAG(boolean bValue) {
        this.SetParamValue(TAG_LOCKFLAG, bValue ? 1 : 0);
    }

    public final boolean isPSDYNAINSTIDNull() {
        return this.IsParamNull(TAG_PSDYNAINSTID);
    }

    public final String getPSDYNAINSTID() {
        return this.GetParamStringValue(TAG_PSDYNAINSTID, "");
    }

    public final void setPSDYNAINSTID(String strValue) {
        this.SetParamValue(TAG_PSDYNAINSTID, strValue);
    }

    public final boolean isDYNAMODELFLAGNull() {
        return this.IsParamNull(TAG_DYNAMODELFLAG);
    }

    public final int getDYNAMODELFLAG() {
        return this.GetParamIntValue(TAG_DYNAMODELFLAG, 0);
    }

    public final void setDYNAMODELFLAG(int nValue) {
        this.SetParamValue(TAG_DYNAMODELFLAG, nValue);
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

    public final boolean isUSERTAGNull() {
        return this.IsParamNull(TAG_USERTAG);
    }

    public final String getUSERTAG() {
        return this.GetParamStringValue(TAG_USERTAG, "");
    }

    public final void setUSERTAG(String strValue) {
        this.SetParamValue(TAG_USERTAG, strValue);
    }

    public final boolean isUSERTAG2Null() {
        return this.IsParamNull(TAG_USERTAG2);
    }

    public final String getUSERTAG2() {
        return this.GetParamStringValue(TAG_USERTAG2, "");
    }

    public final void setUSERTAG2(String strValue) {
        this.SetParamValue(TAG_USERTAG2, strValue);
    }

    public final boolean isUSERTAG3Null() {
        return this.IsParamNull(TAG_USERTAG3);
    }

    public final String getUSERTAG3() {
        return this.GetParamStringValue(TAG_USERTAG3, "");
    }

    public final void setUSERTAG3(String strValue) {
        this.SetParamValue(TAG_USERTAG3, strValue);
    }

    public final boolean isUSERTAG4Null() {
        return this.IsParamNull(TAG_USERTAG4);
    }

    public final String getUSERTAG4() {
        return this.GetParamStringValue(TAG_USERTAG4, "");
    }

    public final void setUSERTAG4(String strValue) {
        this.SetParamValue(TAG_USERTAG4, strValue);
    }

    public final boolean isREGEXPCODE2Null() {
        return this.IsParamNull(TAG_REGEXPCODE2);
    }

    public final String getREGEXPCODE2() {
        return this.GetParamStringValue(TAG_REGEXPCODE2, "");
    }

    public final void setREGEXPCODE2(String strValue) {
        this.SetParamValue(TAG_REGEXPCODE2, strValue);
    }

    public final boolean isREGEXPCODE3Null() {
        return this.IsParamNull(TAG_REGEXPCODE3);
    }

    public final String getREGEXPCODE3() {
        return this.GetParamStringValue(TAG_REGEXPCODE3, "");
    }

    public final void setREGEXPCODE3(String strValue) {
        this.SetParamValue(TAG_REGEXPCODE3, strValue);
    }

    public final boolean isREGEXPCODE4Null() {
        return this.IsParamNull(TAG_REGEXPCODE4);
    }

    public final String getREGEXPCODE4() {
        return this.GetParamStringValue(TAG_REGEXPCODE4, "");
    }

    public final void setREGEXPCODE4(String strValue) {
        this.SetParamValue(TAG_REGEXPCODE4, strValue);
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
}

