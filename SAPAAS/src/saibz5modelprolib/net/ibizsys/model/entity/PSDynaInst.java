/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.entity;

import java.util.Date;
import net.ibizsys.model.entity.BaseDataEntity;

public class PSDynaInst
extends BaseDataEntity {
    public static final String INSTMODE_DEFAULT = "DEFAULT";
    public static final String INSTMODE_PROXY = "PROXY";
    public static final String TAG_PSDYNAINSTID = "PSDYNAINSTID";
    public static final String TAG_PSDYNAINSTNAME = "PSDYNAINSTNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_PSDYNASYSID = "PSDYNASYSID";
    public static final String TAG_PSDYNASYSNAME = "PSDYNASYSNAME";
    public static final String TAG_USERTAG = "USERTAG";
    public static final String TAG_USERTAG2 = "USERTAG2";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";
    public static final String TAG_PSDEVSLNSYSID = "PSDEVSLNSYSID";
    public static final String TAG_INSTVER = "INSTVER";
    public static final String TAG_PPSDYNAINSTID = "PPSDYNAINSTID";
    public static final String TAG_PPSDYNAINSTNAME = "PPSDYNAINSTNAME";
    public static final String TAG_INSTMODE = "INSTMODE";

    public final boolean isPSDYNAINSTIDNull() {
        return this.isParamNull(TAG_PSDYNAINSTID);
    }

    public final String getPSDYNAINSTID() {
        return this.getParamStringValue(TAG_PSDYNAINSTID, "");
    }

    public final void setPSDYNAINSTID(String strValue) {
        this.setParamValue(TAG_PSDYNAINSTID, strValue);
    }

    public final boolean isPSDYNAINSTNAMENull() {
        return this.isParamNull(TAG_PSDYNAINSTNAME);
    }

    public final String getPSDYNAINSTNAME() {
        return this.getParamStringValue(TAG_PSDYNAINSTNAME, "");
    }

    public final void setPSDYNAINSTNAME(String strValue) {
        this.setParamValue(TAG_PSDYNAINSTNAME, strValue);
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

    public final boolean isMEMONull() {
        return this.isParamNull(TAG_MEMO);
    }

    public final String getMEMO() {
        return this.getParamStringValue(TAG_MEMO, "");
    }

    public final void setMEMO(String strValue) {
        this.setParamValue(TAG_MEMO, strValue);
    }

    public final boolean isPSDYNASYSIDNull() {
        return this.isParamNull(TAG_PSDYNASYSID);
    }

    public final String getPSDYNASYSID() {
        return this.getParamStringValue(TAG_PSDYNASYSID, "");
    }

    public final void setPSDYNASYSID(String strValue) {
        this.setParamValue(TAG_PSDYNASYSID, strValue);
    }

    public final boolean isPSDYNASYSNAMENull() {
        return this.isParamNull(TAG_PSDYNASYSNAME);
    }

    public final String getPSDYNASYSNAME() {
        return this.getParamStringValue(TAG_PSDYNASYSNAME, "");
    }

    public final void setPSDYNASYSNAME(String strValue) {
        this.setParamValue(TAG_PSDYNASYSNAME, strValue);
    }

    public final boolean isUSERTAGNull() {
        return this.isParamNull(TAG_USERTAG);
    }

    public final String getUSERTAG() {
        return this.getParamStringValue(TAG_USERTAG, "");
    }

    public final void setUSERTAG(String strValue) {
        this.setParamValue(TAG_USERTAG, strValue);
    }

    public final boolean isUSERTAG2Null() {
        return this.isParamNull(TAG_USERTAG2);
    }

    public final String getUSERTAG2() {
        return this.getParamStringValue(TAG_USERTAG2, "");
    }

    public final void setUSERTAG2(String strValue) {
        this.setParamValue(TAG_USERTAG2, strValue);
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

    public final boolean isPSDEVSLNSYSIDNull() {
        return this.isParamNull(TAG_PSDEVSLNSYSID);
    }

    public final String getPSDEVSLNSYSID() {
        return this.getParamStringValue(TAG_PSDEVSLNSYSID, "");
    }

    public final void setPSDEVSLNSYSID(String strValue) {
        this.setParamValue(TAG_PSDEVSLNSYSID, strValue);
    }

    public final boolean isINSTVERNull() {
        return this.isParamNull(TAG_INSTVER);
    }

    public final int getINSTVER() {
        return this.getParamIntValue(TAG_INSTVER, 0);
    }

    public final void setINSTVER(int nValue) {
        this.setParamValue(TAG_INSTVER, nValue);
    }

    public final boolean isPPSDYNAINSTIDNull() {
        return this.isParamNull(TAG_PPSDYNAINSTID);
    }

    public final String getPPSDYNAINSTID() {
        return this.getParamStringValue(TAG_PPSDYNAINSTID, "");
    }

    public final void setPPSDYNAINSTID(String strValue) {
        this.setParamValue(TAG_PPSDYNAINSTID, strValue);
    }

    public final boolean isPPSDYNAINSTNAMENull() {
        return this.isParamNull(TAG_PPSDYNAINSTNAME);
    }

    public final String getPPSDYNAINSTNAME() {
        return this.getParamStringValue(TAG_PPSDYNAINSTNAME, "");
    }

    public final void setPPSDYNAINSTNAME(String strValue) {
        this.setParamValue(TAG_PPSDYNAINSTNAME, strValue);
    }

    public final boolean isINSTMODENull() {
        return this.isParamNull(TAG_INSTMODE);
    }

    public final String getINSTMODE() {
        return this.getParamStringValue(TAG_INSTMODE, "");
    }

    public final void setINSTMODE(String strValue) {
        this.setParamValue(TAG_INSTMODE, strValue);
    }
}

