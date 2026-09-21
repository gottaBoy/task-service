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

public class PSPanelLogicLinkCond
extends BaseDataEntity {
    public static final String GROUPOP_AND = "AND";
    public static final String GROUPOP_OR = "OR";
    public static final String LOGICTYPE_GROUP = "GROUP";
    public static final String LOGICTYPE_SINGLE = "SINGLE";
    public static final String LOGICTYPE_CUSTOM = "CUSTOM";
    public static final String PARAMTYPE_ENTITYFIELD = "ENTITYFIELD";
    public static final String PARAMTYPE_CURTIME = "CURTIME";
    public static final String PARAMTYPE_TIMERULE = "TIMERULE";
    public static final String TAG_PSPANELLLCONDID = "PSPANELLLCONDID";
    public static final String TAG_PSPANELLLCONDNAME = "PSPANELLLCONDNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_CONDOP = "CONDOP";
    public static final String TAG_CONDVALUE = "CONDVALUE";
    public static final String TAG_PSPANELLOGICLINKID = "PSPANELLOGICLINKID";
    public static final String TAG_PSPANELLOGICLINKNAME = "PSPANELLOGICLINKNAME";
    public static final String TAG_PPSPANELLLCONDID = "PPSPANELLLCONDID";
    public static final String TAG_PPSPANELLLCONDNAME = "PPSPANELLLCONDNAME";
    public static final String TAG_GROUPNOTFLAG = "GROUPNOTFLAG";
    public static final String TAG_GROUPOP = "GROUPOP";
    public static final String TAG_LOGICTYPE = "LOGICTYPE";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_ORDERVALUE = "ORDERVALUE";
    public static final String TAG_PARAMTYPE = "PARAMTYPE";
    public static final String TAG_DSTPSPANELLPID = "DSTPSPANELLPID";
    public static final String TAG_DSTPSPANELLPNAME = "DSTPSPANELLPNAME";
    public static final String TAG_PSSYSVIEWPANELID = "PSSYSVIEWPANELID";
    public static final String TAG_PSSYSVIEWPANELNAME = "PSSYSVIEWPANELNAME";
    public static final String TAG_PSSYSTEMID = "PSSYSTEMID";
    public static final String TAG_DSTFIELDNAME = "DSTFIELDNAME";
    public static final String TAG_PSSYSVIEWPANELLOGICID = "PSSYSVIEWPANELLOGICID";
    private ArrayList<PSPanelLogicLinkCond> childPSPanelLogicLinkCondList = null;

    public final boolean isPSPANELLLCONDIDNull() {
        return this.IsParamNull(TAG_PSPANELLLCONDID);
    }

    public final String getPSPANELLLCONDID() {
        return this.GetParamStringValue(TAG_PSPANELLLCONDID, "");
    }

    public final void setPSPANELLLCONDID(String strValue) {
        this.SetParamValue(TAG_PSPANELLLCONDID, strValue);
    }

    public final boolean isPSPANELLLCONDNAMENull() {
        return this.IsParamNull(TAG_PSPANELLLCONDNAME);
    }

    public final String getPSPANELLLCONDNAME() {
        return this.GetParamStringValue(TAG_PSPANELLLCONDNAME, "");
    }

    public final void setPSPANELLLCONDNAME(String strValue) {
        this.SetParamValue(TAG_PSPANELLLCONDNAME, strValue);
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

    public final boolean isCONDOPNull() {
        return this.IsParamNull(TAG_CONDOP);
    }

    public final String getCONDOP() {
        return this.GetParamStringValue(TAG_CONDOP, "");
    }

    public final void setCONDOP(String strValue) {
        this.SetParamValue(TAG_CONDOP, strValue);
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

    public final boolean isPSPANELLOGICLINKIDNull() {
        return this.IsParamNull(TAG_PSPANELLOGICLINKID);
    }

    public final String getPSPANELLOGICLINKID() {
        return this.GetParamStringValue(TAG_PSPANELLOGICLINKID, "");
    }

    public final void setPSPANELLOGICLINKID(String strValue) {
        this.SetParamValue(TAG_PSPANELLOGICLINKID, strValue);
    }

    public final boolean isPSPANELLOGICLINKNAMENull() {
        return this.IsParamNull(TAG_PSPANELLOGICLINKNAME);
    }

    public final String getPSPANELLOGICLINKNAME() {
        return this.GetParamStringValue(TAG_PSPANELLOGICLINKNAME, "");
    }

    public final void setPSPANELLOGICLINKNAME(String strValue) {
        this.SetParamValue(TAG_PSPANELLOGICLINKNAME, strValue);
    }

    public final boolean isPPSPANELLLCONDIDNull() {
        return this.IsParamNull(TAG_PPSPANELLLCONDID);
    }

    public final String getPPSPANELLLCONDID() {
        return this.GetParamStringValue(TAG_PPSPANELLLCONDID, "");
    }

    public final void setPPSPANELLLCONDID(String strValue) {
        this.SetParamValue(TAG_PPSPANELLLCONDID, strValue);
    }

    public final boolean isPPSPANELLLCONDNAMENull() {
        return this.IsParamNull(TAG_PPSPANELLLCONDNAME);
    }

    public final String getPPSPANELLLCONDNAME() {
        return this.GetParamStringValue(TAG_PPSPANELLLCONDNAME, "");
    }

    public final void setPPSPANELLLCONDNAME(String strValue) {
        this.SetParamValue(TAG_PPSPANELLLCONDNAME, strValue);
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

    public final boolean isGROUPOPNull() {
        return this.IsParamNull(TAG_GROUPOP);
    }

    public final String getGROUPOP() {
        return this.GetParamStringValue(TAG_GROUPOP, "");
    }

    public final void setGROUPOP(String strValue) {
        this.SetParamValue(TAG_GROUPOP, strValue);
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

    public final boolean isMEMONull() {
        return this.IsParamNull(TAG_MEMO);
    }

    public final String getMEMO() {
        return this.GetParamStringValue(TAG_MEMO, "");
    }

    public final void setMEMO(String strValue) {
        this.SetParamValue(TAG_MEMO, strValue);
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

    public final boolean isPARAMTYPENull() {
        return this.IsParamNull(TAG_PARAMTYPE);
    }

    public final String getPARAMTYPE() {
        return this.GetParamStringValue(TAG_PARAMTYPE, "");
    }

    public final void setPARAMTYPE(String strValue) {
        this.SetParamValue(TAG_PARAMTYPE, strValue);
    }

    public final boolean isDSTPSPANELLPIDNull() {
        return this.IsParamNull(TAG_DSTPSPANELLPID);
    }

    public final String getDSTPSPANELLPID() {
        return this.GetParamStringValue(TAG_DSTPSPANELLPID, "");
    }

    public final void setDSTPSPANELLPID(String strValue) {
        this.SetParamValue(TAG_DSTPSPANELLPID, strValue);
    }

    public final boolean isDSTPSPANELLPNAMENull() {
        return this.IsParamNull(TAG_DSTPSPANELLPNAME);
    }

    public final String getDSTPSPANELLPNAME() {
        return this.GetParamStringValue(TAG_DSTPSPANELLPNAME, "");
    }

    public final void setDSTPSPANELLPNAME(String strValue) {
        this.SetParamValue(TAG_DSTPSPANELLPNAME, strValue);
    }

    public final boolean isPSSYSVIEWPANELIDNull() {
        return this.IsParamNull(TAG_PSSYSVIEWPANELID);
    }

    public final String getPSSYSVIEWPANELID() {
        return this.GetParamStringValue(TAG_PSSYSVIEWPANELID, "");
    }

    public final void setPSSYSVIEWPANELID(String strValue) {
        this.SetParamValue(TAG_PSSYSVIEWPANELID, strValue);
    }

    public final boolean isPSSYSVIEWPANELNAMENull() {
        return this.IsParamNull(TAG_PSSYSVIEWPANELNAME);
    }

    public final String getPSSYSVIEWPANELNAME() {
        return this.GetParamStringValue(TAG_PSSYSVIEWPANELNAME, "");
    }

    public final void setPSSYSVIEWPANELNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSVIEWPANELNAME, strValue);
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

    public final boolean isDSTFIELDNAMENull() {
        return this.IsParamNull(TAG_DSTFIELDNAME);
    }

    public final String getDSTFIELDNAME() {
        return this.GetParamStringValue(TAG_DSTFIELDNAME, "");
    }

    public final void setDSTFIELDNAME(String strValue) {
        this.SetParamValue(TAG_DSTFIELDNAME, strValue);
    }

    public final boolean isPSSYSVIEWPANELLOGICIDNull() {
        return this.IsParamNull(TAG_PSSYSVIEWPANELLOGICID);
    }

    public final String getPSSYSVIEWPANELLOGICID() {
        return this.GetParamStringValue(TAG_PSSYSVIEWPANELLOGICID, "");
    }

    public final void setPSSYSVIEWPANELLOGICID(String strValue) {
        this.SetParamValue(TAG_PSSYSVIEWPANELLOGICID, strValue);
    }

    public ArrayList<PSPanelLogicLinkCond> getChildPSPanelLogicLinkConds(boolean bCreated) {
        if (this.childPSPanelLogicLinkCondList != null) {
            return this.childPSPanelLogicLinkCondList;
        }
        if (bCreated) {
            this.childPSPanelLogicLinkCondList = new ArrayList();
        }
        return this.childPSPanelLogicLinkCondList;
    }

    public void resetChildDatas() {
        if (this.childPSPanelLogicLinkCondList != null) {
            this.childPSPanelLogicLinkCondList.clear();
            this.childPSPanelLogicLinkCondList = null;
        }
    }
}

