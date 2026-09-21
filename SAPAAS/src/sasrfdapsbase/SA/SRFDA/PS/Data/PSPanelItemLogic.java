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

public class PSPanelItemLogic
extends BaseDataEntity {
    public static final String GROUPOP_AND = "AND";
    public static final String GROUPOP_OR = "OR";
    public static final String LOGICTYPE_GROUP = "GROUP";
    public static final String LOGICTYPE_SINGLE = "SINGLE";
    public static final String LOGICTYPE_CUSTOM = "CUSTOM";
    public static final String LOGICCAT_PANELVISIBLE = "PANELVISIBLE";
    public static final String LOGICCAT_ITEMENABLE = "ITEMENABLE";
    public static final String LOGICCAT_ITEMBLANK = "ITEMBLANK";
    public static final String LOGICCAT_SCRIPTCODE_CHANGE = "SCRIPTCODE_CHANGE";
    public static final String LOGICCAT_SCRIPTCODE_CLICK = "SCRIPTCODE_CLICK";
    public static final String LOGICCAT_SCRIPTCODE_FOCUS = "SCRIPTCODE_FOCUS";
    public static final String LOGICCAT_SCRIPTCODE_BLUR = "SCRIPTCODE_BLUR";
    public static final String TAG_PSPANELITEMLOGICID = "PSPANELITEMLOGICID";
    public static final String TAG_PSPANELITEMLOGICNAME = "PSPANELITEMLOGICNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSSYSVIEWPANELID = "PSSYSVIEWPANELID";
    public static final String TAG_PSSYSVIEWPANELNAME = "PSSYSVIEWPANELNAME";
    public static final String TAG_PSSYSVIEWPANELITEMID = "PSSYSVIEWPANELITEMID";
    public static final String TAG_PSSYSVIEWPANELITEMNAME = "PSSYSVIEWPANELITEMNAME";
    public static final String TAG_PPSPANELITEMLOGICID = "PPSPANELITEMLOGICID";
    public static final String TAG_PPSPANELITEMLOGICNAME = "PPSPANELITEMLOGICNAME";
    public static final String TAG_CONDVALUE = "CONDVALUE";
    public static final String TAG_GROUPNOTFLAG = "GROUPNOTFLAG";
    public static final String TAG_GROUPOP = "GROUPOP";
    public static final String TAG_ORDERVALUE = "ORDERVALUE";
    public static final String TAG_LOGICTYPE = "LOGICTYPE";
    public static final String TAG_LOGICCAT = "LOGICCAT";
    public static final String TAG_CONDOP = "CONDOP";
    public static final String TAG_DSTPSPANELMODELID = "DSTPSPANELMODELID";
    public static final String TAG_DSTPSPANELMODELNAME = "DSTPSPANELMODELNAME";
    public static final String TAG_DSTFIELDNAME = "DSTFIELDNAME";
    private ArrayList<PSPanelItemLogic> childPSPanelItemLogicList = null;

    public final boolean isPSPANELITEMLOGICIDNull() {
        return this.IsParamNull(TAG_PSPANELITEMLOGICID);
    }

    public final String getPSPANELITEMLOGICID() {
        return this.GetParamStringValue(TAG_PSPANELITEMLOGICID, "");
    }

    public final void setPSPANELITEMLOGICID(String strValue) {
        this.SetParamValue(TAG_PSPANELITEMLOGICID, strValue);
    }

    public final boolean isPSPANELITEMLOGICNAMENull() {
        return this.IsParamNull(TAG_PSPANELITEMLOGICNAME);
    }

    public final String getPSPANELITEMLOGICNAME() {
        return this.GetParamStringValue(TAG_PSPANELITEMLOGICNAME, "");
    }

    public final void setPSPANELITEMLOGICNAME(String strValue) {
        this.SetParamValue(TAG_PSPANELITEMLOGICNAME, strValue);
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

    public final boolean isPSSYSVIEWPANELITEMIDNull() {
        return this.IsParamNull(TAG_PSSYSVIEWPANELITEMID);
    }

    public final String getPSSYSVIEWPANELITEMID() {
        return this.GetParamStringValue(TAG_PSSYSVIEWPANELITEMID, "");
    }

    public final void setPSSYSVIEWPANELITEMID(String strValue) {
        this.SetParamValue(TAG_PSSYSVIEWPANELITEMID, strValue);
    }

    public final boolean isPSSYSVIEWPANELITEMNAMENull() {
        return this.IsParamNull(TAG_PSSYSVIEWPANELITEMNAME);
    }

    public final String getPSSYSVIEWPANELITEMNAME() {
        return this.GetParamStringValue(TAG_PSSYSVIEWPANELITEMNAME, "");
    }

    public final void setPSSYSVIEWPANELITEMNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSVIEWPANELITEMNAME, strValue);
    }

    public final boolean isPPSPANELITEMLOGICIDNull() {
        return this.IsParamNull(TAG_PPSPANELITEMLOGICID);
    }

    public final String getPPSPANELITEMLOGICID() {
        return this.GetParamStringValue(TAG_PPSPANELITEMLOGICID, "");
    }

    public final void setPPSPANELITEMLOGICID(String strValue) {
        this.SetParamValue(TAG_PPSPANELITEMLOGICID, strValue);
    }

    public final boolean isPPSPANELITEMLOGICNAMENull() {
        return this.IsParamNull(TAG_PPSPANELITEMLOGICNAME);
    }

    public final String getPPSPANELITEMLOGICNAME() {
        return this.GetParamStringValue(TAG_PPSPANELITEMLOGICNAME, "");
    }

    public final void setPPSPANELITEMLOGICNAME(String strValue) {
        this.SetParamValue(TAG_PPSPANELITEMLOGICNAME, strValue);
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

    public final boolean isORDERVALUENull() {
        return this.IsParamNull(TAG_ORDERVALUE);
    }

    public final int getORDERVALUE() {
        return this.GetParamIntValue(TAG_ORDERVALUE, 0);
    }

    public final void setORDERVALUE(int nValue) {
        this.SetParamValue(TAG_ORDERVALUE, nValue);
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

    public final boolean isLOGICCATNull() {
        return this.IsParamNull(TAG_LOGICCAT);
    }

    public final String getLOGICCAT() {
        return this.GetParamStringValue(TAG_LOGICCAT, "");
    }

    public final void setLOGICCAT(String strValue) {
        this.SetParamValue(TAG_LOGICCAT, strValue);
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

    public final boolean isDSTPSPANELMODELIDNull() {
        return this.IsParamNull(TAG_DSTPSPANELMODELID);
    }

    public final String getDSTPSPANELMODELID() {
        return this.GetParamStringValue(TAG_DSTPSPANELMODELID, "");
    }

    public final void setDSTPSPANELMODELID(String strValue) {
        this.SetParamValue(TAG_DSTPSPANELMODELID, strValue);
    }

    public final boolean isDSTPSPANELMODELNAMENull() {
        return this.IsParamNull(TAG_DSTPSPANELMODELNAME);
    }

    public final String getDSTPSPANELMODELNAME() {
        return this.GetParamStringValue(TAG_DSTPSPANELMODELNAME, "");
    }

    public final void setDSTPSPANELMODELNAME(String strValue) {
        this.SetParamValue(TAG_DSTPSPANELMODELNAME, strValue);
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

    public ArrayList<PSPanelItemLogic> getChildPSPanelItemLogics(boolean bCreated) {
        if (this.childPSPanelItemLogicList != null) {
            return this.childPSPanelItemLogicList;
        }
        if (bCreated) {
            this.childPSPanelItemLogicList = new ArrayList();
        }
        return this.childPSPanelItemLogicList;
    }

    public void resetChildDatas() {
        if (this.childPSPanelItemLogicList != null) {
            this.childPSPanelItemLogicList.clear();
            this.childPSPanelItemLogicList = null;
        }
    }
}

