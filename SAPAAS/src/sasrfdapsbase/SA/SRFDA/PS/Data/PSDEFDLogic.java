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

public class PSDEFDLogic
extends BaseDataEntity {
    public static final String LOGICCAT_PANELVISIBLE = "PANELVISIBLE";
    public static final String LOGICCAT_ITEMENABLE = "ITEMENABLE";
    public static final String LOGICCAT_ITEMBLANK = "ITEMBLANK";
    public static final String LOGICCAT_SCRIPTCODE_CHANGE = "SCRIPTCODE_CHANGE";
    public static final String LOGICCAT_SCRIPTCODE_CLICK = "SCRIPTCODE_CLICK";
    public static final String LOGICCAT_SCRIPTCODE_FOCUS = "SCRIPTCODE_FOCUS";
    public static final String LOGICCAT_SCRIPTCODE_BLUR = "SCRIPTCODE_BLUR";
    public static final String LOGICTYPE_GROUP = "GROUP";
    public static final String LOGICTYPE_SINGLE = "SINGLE";
    public static final String LOGICTYPE_CUSTOM = "CUSTOM";
    public static final String GROUPOP_AND = "AND";
    public static final String GROUPOP_OR = "OR";
    public static final String TAG_PSDEFDLOGICID = "PSDEFDLOGICID";
    public static final String TAG_PSDEFDLOGICNAME = "PSDEFDLOGICNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSDEFORMDETAILID = "PSDEFORMDETAILID";
    public static final String TAG_PSDEFORMDETAILNAME = "PSDEFORMDETAILNAME";
    public static final String TAG_PPSDEFDLOGICID = "PPSDEFDLOGICID";
    public static final String TAG_PPSDEFDLOGICNAME = "PPSDEFDLOGICNAME";
    public static final String TAG_LOGICCAT = "LOGICCAT";
    public static final String TAG_LOGICTYPE = "LOGICTYPE";
    public static final String TAG_ORDERVALUE = "ORDERVALUE";
    public static final String TAG_GROUPOP = "GROUPOP";
    public static final String TAG_GROUPNOTFLAG = "GROUPNOTFLAG";
    public static final String TAG_PSDBVALUEOPID = "PSDBVALUEOPID";
    public static final String TAG_PSDBVALUEOPNAME = "PSDBVALUEOPNAME";
    public static final String TAG_CONDVALUE = "CONDVALUE";
    public static final String TAG_FDNAME = "FDNAME";
    private ArrayList<PSDEFDLogic> childPSDEFDLogicList = null;

    public final boolean isPSDEFDLOGICIDNull() {
        return this.IsParamNull(TAG_PSDEFDLOGICID);
    }

    public final String getPSDEFDLOGICID() {
        return this.GetParamStringValue(TAG_PSDEFDLOGICID, "");
    }

    public final void setPSDEFDLOGICID(String strValue) {
        this.SetParamValue(TAG_PSDEFDLOGICID, strValue);
    }

    public final boolean isPSDEFDLOGICNAMENull() {
        return this.IsParamNull(TAG_PSDEFDLOGICNAME);
    }

    public final String getPSDEFDLOGICNAME() {
        return this.GetParamStringValue(TAG_PSDEFDLOGICNAME, "");
    }

    public final void setPSDEFDLOGICNAME(String strValue) {
        this.SetParamValue(TAG_PSDEFDLOGICNAME, strValue);
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

    public final boolean isPSDEFORMDETAILIDNull() {
        return this.IsParamNull(TAG_PSDEFORMDETAILID);
    }

    public final String getPSDEFORMDETAILID() {
        return this.GetParamStringValue(TAG_PSDEFORMDETAILID, "");
    }

    public final void setPSDEFORMDETAILID(String strValue) {
        this.SetParamValue(TAG_PSDEFORMDETAILID, strValue);
    }

    public final boolean isPSDEFORMDETAILNAMENull() {
        return this.IsParamNull(TAG_PSDEFORMDETAILNAME);
    }

    public final String getPSDEFORMDETAILNAME() {
        return this.GetParamStringValue(TAG_PSDEFORMDETAILNAME, "");
    }

    public final void setPSDEFORMDETAILNAME(String strValue) {
        this.SetParamValue(TAG_PSDEFORMDETAILNAME, strValue);
    }

    public final boolean isPPSDEFDLOGICIDNull() {
        return this.IsParamNull(TAG_PPSDEFDLOGICID);
    }

    public final String getPPSDEFDLOGICID() {
        return this.GetParamStringValue(TAG_PPSDEFDLOGICID, "");
    }

    public final void setPPSDEFDLOGICID(String strValue) {
        this.SetParamValue(TAG_PPSDEFDLOGICID, strValue);
    }

    public final boolean isPPSDEFDLOGICNAMENull() {
        return this.IsParamNull(TAG_PPSDEFDLOGICNAME);
    }

    public final String getPPSDEFDLOGICNAME() {
        return this.GetParamStringValue(TAG_PPSDEFDLOGICNAME, "");
    }

    public final void setPPSDEFDLOGICNAME(String strValue) {
        this.SetParamValue(TAG_PPSDEFDLOGICNAME, strValue);
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

    public final boolean isFDNAMENull() {
        return this.IsParamNull(TAG_FDNAME);
    }

    public final String getFDNAME() {
        return this.GetParamStringValue(TAG_FDNAME, "");
    }

    public final void setFDNAME(String strValue) {
        this.SetParamValue(TAG_FDNAME, strValue);
    }

    public ArrayList<PSDEFDLogic> getChildPSDEFDLogics(boolean bCreated) {
        if (this.childPSDEFDLogicList != null) {
            return this.childPSDEFDLogicList;
        }
        if (bCreated) {
            this.childPSDEFDLogicList = new ArrayList();
        }
        return this.childPSDEFDLogicList;
    }

    public void resetChildDatas() {
        if (this.childPSDEFDLogicList != null) {
            this.childPSDEFDLogicList.clear();
            this.childPSDEFDLogicList = null;
        }
    }
}

