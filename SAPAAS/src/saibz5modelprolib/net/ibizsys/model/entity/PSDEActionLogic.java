/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.entity;

import java.util.Date;
import net.ibizsys.model.entity.BaseDataEntity;

public class PSDEActionLogic
extends BaseDataEntity {
    public static final String ATTACHMODE_BEFORE = "BEFORE";
    public static final String ATTACHMODE_AFTER = "AFTER";
    public static final String TAG_PSDEACTIONLOGICID = "PSDEACTIONLOGICID";
    public static final String TAG_PSDEACTIONLOGICNAME = "PSDEACTIONLOGICNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSDEACTIONID = "PSDEACTIONID";
    public static final String TAG_PSDEACTIONNAME = "PSDEACTIONNAME";
    public static final String TAG_PSDELOGICID = "PSDELOGICID";
    public static final String TAG_PSDELOGICNAME = "PSDELOGICNAME";
    public static final String TAG_ORDERVALUE = "ORDERVALUE";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_ATTACHMODE = "ATTACHMODE";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";
    public static final String TAG_PSDEID = "PSDEID";
    public static final String TAG_PSDENAME = "PSDENAME";
    public static final String TAG_INTERNALLOGIC = "INTERNALLOGIC";
    public static final String TAG_DSTPSDEID = "DSTPSDEID";
    public static final String TAG_DSTPSDENAME = "DSTPSDENAME";
    public static final String TAG_DSTPSDEACTIONID = "DSTPSDEACTIONID";
    public static final String TAG_DSTPSDEACTIONNAME = "DSTPSDEACTIONNAME";
    public static final String TAG_CLONEPARAMFLAG = "CLONEPARAMFLAG";
    public static final String TAG_IGNOREEXCEPTION = "IGNOREEXCEPTION";

    public final boolean isPSDEACTIONLOGICIDNull() {
        return this.isParamNull(TAG_PSDEACTIONLOGICID);
    }

    public final String getPSDEACTIONLOGICID() {
        return this.getParamStringValue(TAG_PSDEACTIONLOGICID, "");
    }

    public final void setPSDEACTIONLOGICID(String strValue) {
        this.setParamValue(TAG_PSDEACTIONLOGICID, strValue);
    }

    public final boolean isPSDEACTIONLOGICNAMENull() {
        return this.isParamNull(TAG_PSDEACTIONLOGICNAME);
    }

    public final String getPSDEACTIONLOGICNAME() {
        return this.getParamStringValue(TAG_PSDEACTIONLOGICNAME, "");
    }

    public final void setPSDEACTIONLOGICNAME(String strValue) {
        this.setParamValue(TAG_PSDEACTIONLOGICNAME, strValue);
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

    public final boolean isPSDEACTIONIDNull() {
        return this.isParamNull(TAG_PSDEACTIONID);
    }

    public final String getPSDEACTIONID() {
        return this.getParamStringValue(TAG_PSDEACTIONID, "");
    }

    public final void setPSDEACTIONID(String strValue) {
        this.setParamValue(TAG_PSDEACTIONID, strValue);
    }

    public final boolean isPSDEACTIONNAMENull() {
        return this.isParamNull(TAG_PSDEACTIONNAME);
    }

    public final String getPSDEACTIONNAME() {
        return this.getParamStringValue(TAG_PSDEACTIONNAME, "");
    }

    public final void setPSDEACTIONNAME(String strValue) {
        this.setParamValue(TAG_PSDEACTIONNAME, strValue);
    }

    public final boolean isPSDELOGICIDNull() {
        return this.isParamNull(TAG_PSDELOGICID);
    }

    public final String getPSDELOGICID() {
        return this.getParamStringValue(TAG_PSDELOGICID, "");
    }

    public final void setPSDELOGICID(String strValue) {
        this.setParamValue(TAG_PSDELOGICID, strValue);
    }

    public final boolean isPSDELOGICNAMENull() {
        return this.isParamNull(TAG_PSDELOGICNAME);
    }

    public final String getPSDELOGICNAME() {
        return this.getParamStringValue(TAG_PSDELOGICNAME, "");
    }

    public final void setPSDELOGICNAME(String strValue) {
        this.setParamValue(TAG_PSDELOGICNAME, strValue);
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

    public final boolean isMEMONull() {
        return this.isParamNull(TAG_MEMO);
    }

    public final String getMEMO() {
        return this.getParamStringValue(TAG_MEMO, "");
    }

    public final void setMEMO(String strValue) {
        this.setParamValue(TAG_MEMO, strValue);
    }

    public final boolean isATTACHMODENull() {
        return this.isParamNull(TAG_ATTACHMODE);
    }

    public final String getATTACHMODE() {
        return this.getParamStringValue(TAG_ATTACHMODE, "");
    }

    public final void setATTACHMODE(String strValue) {
        this.setParamValue(TAG_ATTACHMODE, strValue);
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

    public final boolean isINTERNALLOGICNull() {
        return this.isParamNull(TAG_INTERNALLOGIC);
    }

    public final boolean getINTERNALLOGIC() {
        return this.getParamIntValue(TAG_INTERNALLOGIC, 0) == 1;
    }

    public final void setINTERNALLOGIC(boolean bValue) {
        this.setParamValue(TAG_INTERNALLOGIC, bValue ? 1 : 0);
    }

    public final boolean isDSTPSDEIDNull() {
        return this.isParamNull(TAG_DSTPSDEID);
    }

    public final String getDSTPSDEID() {
        return this.getParamStringValue(TAG_DSTPSDEID, "");
    }

    public final void setDSTPSDEID(String strValue) {
        this.setParamValue(TAG_DSTPSDEID, strValue);
    }

    public final boolean isDSTPSDENAMENull() {
        return this.isParamNull(TAG_DSTPSDENAME);
    }

    public final String getDSTPSDENAME() {
        return this.getParamStringValue(TAG_DSTPSDENAME, "");
    }

    public final void setDSTPSDENAME(String strValue) {
        this.setParamValue(TAG_DSTPSDENAME, strValue);
    }

    public final boolean isVALIDFLAGNull() {
        return this.isParamNull(TAG_VALIDFLAG);
    }

    public final boolean getVALIDFLAG() {
        return this.getParamIntValue(TAG_VALIDFLAG, 0) == 1;
    }

    public final void setVALIDFLAG(boolean bValue) {
        this.setParamValue(TAG_VALIDFLAG, bValue ? 1 : 0);
    }

    public final boolean isDSTPSDEACTIONIDNull() {
        return this.isParamNull(TAG_DSTPSDEACTIONID);
    }

    public final String getDSTPSDEACTIONID() {
        return this.getParamStringValue(TAG_DSTPSDEACTIONID, "");
    }

    public final void setDSTPSDEACTIONID(String strValue) {
        this.setParamValue(TAG_DSTPSDEACTIONID, strValue);
    }

    public final boolean isDSTPSDEACTIONNAMENull() {
        return this.isParamNull(TAG_DSTPSDEACTIONNAME);
    }

    public final String getDSTPSDEACTIONNAME() {
        return this.getParamStringValue(TAG_DSTPSDEACTIONNAME, "");
    }

    public final void setDSTPSDEACTIONNAME(String strValue) {
        this.setParamValue(TAG_DSTPSDEACTIONNAME, strValue);
    }

    public final boolean isCLONEPARAMFLAGNull() {
        return this.isParamNull(TAG_CLONEPARAMFLAG);
    }

    public final boolean getCLONEPARAMFLAG() {
        return this.getParamIntValue(TAG_CLONEPARAMFLAG, 0) == 1;
    }

    public final void setCLONEPARAMFLAG(boolean bValue) {
        this.setParamValue(TAG_CLONEPARAMFLAG, bValue ? 1 : 0);
    }

    public final boolean isIGNOREEXCEPTIONNull() {
        return this.isParamNull(TAG_IGNOREEXCEPTION);
    }

    public final boolean getIGNOREEXCEPTION() {
        return this.getParamIntValue(TAG_IGNOREEXCEPTION, 0) == 1;
    }

    public final void setIGNOREEXCEPTION(boolean bValue) {
        this.setParamValue(TAG_IGNOREEXCEPTION, bValue ? 1 : 0);
    }
}

