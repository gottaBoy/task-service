/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.entity;

import java.util.ArrayList;
import java.util.Date;
import net.ibizsys.model.entity.BaseDataEntity;

public class PSDEFDLogic
extends BaseDataEntity {
    public static final String LOGICCAT_PANELVISIBLE = "PANELVISIBLE";
    public static final String LOGICCAT_ITEMENABLE = "ITEMENABLE";
    public static final String LOGICCAT_ITEMBLANK = "ITEMBLANK";
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
        return this.isParamNull(TAG_PSDEFDLOGICID);
    }

    public final String getPSDEFDLOGICID() {
        return this.getParamStringValue(TAG_PSDEFDLOGICID, "");
    }

    public final void setPSDEFDLOGICID(String strValue) {
        this.setParamValue(TAG_PSDEFDLOGICID, strValue);
    }

    public final boolean isPSDEFDLOGICNAMENull() {
        return this.isParamNull(TAG_PSDEFDLOGICNAME);
    }

    public final String getPSDEFDLOGICNAME() {
        return this.getParamStringValue(TAG_PSDEFDLOGICNAME, "");
    }

    public final void setPSDEFDLOGICNAME(String strValue) {
        this.setParamValue(TAG_PSDEFDLOGICNAME, strValue);
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

    public final boolean isPSDEFORMDETAILIDNull() {
        return this.isParamNull(TAG_PSDEFORMDETAILID);
    }

    public final String getPSDEFORMDETAILID() {
        return this.getParamStringValue(TAG_PSDEFORMDETAILID, "");
    }

    public final void setPSDEFORMDETAILID(String strValue) {
        this.setParamValue(TAG_PSDEFORMDETAILID, strValue);
    }

    public final boolean isPSDEFORMDETAILNAMENull() {
        return this.isParamNull(TAG_PSDEFORMDETAILNAME);
    }

    public final String getPSDEFORMDETAILNAME() {
        return this.getParamStringValue(TAG_PSDEFORMDETAILNAME, "");
    }

    public final void setPSDEFORMDETAILNAME(String strValue) {
        this.setParamValue(TAG_PSDEFORMDETAILNAME, strValue);
    }

    public final boolean isPPSDEFDLOGICIDNull() {
        return this.isParamNull(TAG_PPSDEFDLOGICID);
    }

    public final String getPPSDEFDLOGICID() {
        return this.getParamStringValue(TAG_PPSDEFDLOGICID, "");
    }

    public final void setPPSDEFDLOGICID(String strValue) {
        this.setParamValue(TAG_PPSDEFDLOGICID, strValue);
    }

    public final boolean isPPSDEFDLOGICNAMENull() {
        return this.isParamNull(TAG_PPSDEFDLOGICNAME);
    }

    public final String getPPSDEFDLOGICNAME() {
        return this.getParamStringValue(TAG_PPSDEFDLOGICNAME, "");
    }

    public final void setPPSDEFDLOGICNAME(String strValue) {
        this.setParamValue(TAG_PPSDEFDLOGICNAME, strValue);
    }

    public final boolean isLOGICCATNull() {
        return this.isParamNull(TAG_LOGICCAT);
    }

    public final String getLOGICCAT() {
        return this.getParamStringValue(TAG_LOGICCAT, "");
    }

    public final void setLOGICCAT(String strValue) {
        this.setParamValue(TAG_LOGICCAT, strValue);
    }

    public final boolean isLOGICTYPENull() {
        return this.isParamNull(TAG_LOGICTYPE);
    }

    public final String getLOGICTYPE() {
        return this.getParamStringValue(TAG_LOGICTYPE, "");
    }

    public final void setLOGICTYPE(String strValue) {
        this.setParamValue(TAG_LOGICTYPE, strValue);
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

    public final boolean isFDNAMENull() {
        return this.isParamNull(TAG_FDNAME);
    }

    public final String getFDNAME() {
        return this.getParamStringValue(TAG_FDNAME, "");
    }

    public final void setFDNAME(String strValue) {
        this.setParamValue(TAG_FDNAME, strValue);
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

