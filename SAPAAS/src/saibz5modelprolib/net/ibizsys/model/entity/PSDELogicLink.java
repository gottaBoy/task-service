/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.entity;

import java.util.ArrayList;
import java.util.Date;
import net.ibizsys.model.entity.BaseDataEntity;
import net.ibizsys.model.entity.PSDELogicLinkCond;

public class PSDELogicLink
extends BaseDataEntity {
    public static final String TAG_PSDELOGICLINKID = "PSDELOGICLINKID";
    public static final String TAG_PSDELOGICLINKNAME = "PSDELOGICLINKNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_SRCPSDELOGICNODEID = "SRCPSDELOGICNODEID";
    public static final String TAG_SRCPSDELOGICNODENAME = "SRCPSDELOGICNODENAME";
    public static final String TAG_DSTPSDELOGICNODEID = "DSTPSDELOGICNODEID";
    public static final String TAG_DSTPSDELOGICNODENAME = "DSTPSDELOGICNODENAME";
    public static final String TAG_PSDELOGICID = "PSDELOGICID";
    public static final String TAG_PSDELOGICNAME = "PSDELOGICNAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_ORDERVALUE = "ORDERVALUE";
    public static final String TAG_DEFAULTLINK = "DEFAULTLINK";
    private ArrayList<PSDELogicLinkCond> childPSDELogicLinkCondList = null;

    public final boolean isPSDELOGICLINKIDNull() {
        return this.isParamNull(TAG_PSDELOGICLINKID);
    }

    public final String getPSDELOGICLINKID() {
        return this.getParamStringValue(TAG_PSDELOGICLINKID, "");
    }

    public final void setPSDELOGICLINKID(String strValue) {
        this.setParamValue(TAG_PSDELOGICLINKID, strValue);
    }

    public final boolean isPSDELOGICLINKNAMENull() {
        return this.isParamNull(TAG_PSDELOGICLINKNAME);
    }

    public final String getPSDELOGICLINKNAME() {
        return this.getParamStringValue(TAG_PSDELOGICLINKNAME, "");
    }

    public final void setPSDELOGICLINKNAME(String strValue) {
        this.setParamValue(TAG_PSDELOGICLINKNAME, strValue);
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

    public final boolean isSRCPSDELOGICNODEIDNull() {
        return this.isParamNull(TAG_SRCPSDELOGICNODEID);
    }

    public final String getSRCPSDELOGICNODEID() {
        return this.getParamStringValue(TAG_SRCPSDELOGICNODEID, "");
    }

    public final void setSRCPSDELOGICNODEID(String strValue) {
        this.setParamValue(TAG_SRCPSDELOGICNODEID, strValue);
    }

    public final boolean isSRCPSDELOGICNODENAMENull() {
        return this.isParamNull(TAG_SRCPSDELOGICNODENAME);
    }

    public final String getSRCPSDELOGICNODENAME() {
        return this.getParamStringValue(TAG_SRCPSDELOGICNODENAME, "");
    }

    public final void setSRCPSDELOGICNODENAME(String strValue) {
        this.setParamValue(TAG_SRCPSDELOGICNODENAME, strValue);
    }

    public final boolean isDSTPSDELOGICNODEIDNull() {
        return this.isParamNull(TAG_DSTPSDELOGICNODEID);
    }

    public final String getDSTPSDELOGICNODEID() {
        return this.getParamStringValue(TAG_DSTPSDELOGICNODEID, "");
    }

    public final void setDSTPSDELOGICNODEID(String strValue) {
        this.setParamValue(TAG_DSTPSDELOGICNODEID, strValue);
    }

    public final boolean isDSTPSDELOGICNODENAMENull() {
        return this.isParamNull(TAG_DSTPSDELOGICNODENAME);
    }

    public final String getDSTPSDELOGICNODENAME() {
        return this.getParamStringValue(TAG_DSTPSDELOGICNODENAME, "");
    }

    public final void setDSTPSDELOGICNODENAME(String strValue) {
        this.setParamValue(TAG_DSTPSDELOGICNODENAME, strValue);
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

    public final boolean isMEMONull() {
        return this.isParamNull(TAG_MEMO);
    }

    public final String getMEMO() {
        return this.getParamStringValue(TAG_MEMO, "");
    }

    public final void setMEMO(String strValue) {
        this.setParamValue(TAG_MEMO, strValue);
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

    public final boolean isDEFAULTLINKNull() {
        return this.isParamNull(TAG_DEFAULTLINK);
    }

    public final boolean getDEFAULTLINK() {
        return this.getParamIntValue(TAG_DEFAULTLINK, 0) == 1;
    }

    public final void setDEFAULTLINK(boolean bValue) {
        this.setParamValue(TAG_DEFAULTLINK, bValue ? 1 : 0);
    }

    public ArrayList<PSDELogicLinkCond> getPSDELogicLinkConds(boolean bCreated) {
        if (this.childPSDELogicLinkCondList != null) {
            return this.childPSDELogicLinkCondList;
        }
        if (bCreated) {
            this.childPSDELogicLinkCondList = new ArrayList();
        }
        return this.childPSDELogicLinkCondList;
    }

    public void resetChildDatas() {
        if (this.childPSDELogicLinkCondList != null) {
            this.childPSDELogicLinkCondList.clear();
            this.childPSDELogicLinkCondList = null;
        }
    }
}

