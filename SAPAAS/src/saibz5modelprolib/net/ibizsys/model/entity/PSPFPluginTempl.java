/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.entity;

import java.util.Date;
import net.ibizsys.model.entity.BaseDataEntity;

public class PSPFPluginTempl
extends BaseDataEntity {
    public static final String TAG_PSPFPLUGINTEMPLID = "PSPFPLUGINTEMPLID";
    public static final String TAG_PSPFPLUGINTEMPLNAME = "PSPFPLUGINTEMPLNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSPFID = "PSPFID";
    public static final String TAG_PSPFNAME = "PSPFNAME";
    public static final String TAG_PSPFPLUGINID = "PSPFPLUGINID";
    public static final String TAG_PSPFPLUGINNAME = "PSPFPLUGINNAME";
    public static final String TAG_TEMPLCODE = "TEMPLCODE";
    public static final String TAG_TEMPLCODE2 = "TEMPLCODE2";
    public static final String TAG_TEMPLCODE3 = "TEMPLCODE3";
    public static final String TAG_TEMPLCODE4 = "TEMPLCODE4";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_TEMPLDESC = "TEMPLDESC";
    public static final String TAG_PSPFPUBCODEID = "PSPFPUBCODEID";
    public static final String TAG_PSPFPUBCODENAME = "PSPFPUBCODENAME";

    public final boolean isPSPFPLUGINTEMPLIDNull() {
        return this.isParamNull(TAG_PSPFPLUGINTEMPLID);
    }

    public final String getPSPFPLUGINTEMPLID() {
        return this.getParamStringValue(TAG_PSPFPLUGINTEMPLID, "");
    }

    public final void setPSPFPLUGINTEMPLID(String strValue) {
        this.setParamValue(TAG_PSPFPLUGINTEMPLID, strValue);
    }

    public final boolean isPSPFPLUGINTEMPLNAMENull() {
        return this.isParamNull(TAG_PSPFPLUGINTEMPLNAME);
    }

    public final String getPSPFPLUGINTEMPLNAME() {
        return this.getParamStringValue(TAG_PSPFPLUGINTEMPLNAME, "");
    }

    public final void setPSPFPLUGINTEMPLNAME(String strValue) {
        this.setParamValue(TAG_PSPFPLUGINTEMPLNAME, strValue);
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

    public final boolean isPSPFIDNull() {
        return this.isParamNull(TAG_PSPFID);
    }

    public final String getPSPFID() {
        return this.getParamStringValue(TAG_PSPFID, "");
    }

    public final void setPSPFID(String strValue) {
        this.setParamValue(TAG_PSPFID, strValue);
    }

    public final boolean isPSPFNAMENull() {
        return this.isParamNull(TAG_PSPFNAME);
    }

    public final String getPSPFNAME() {
        return this.getParamStringValue(TAG_PSPFNAME, "");
    }

    public final void setPSPFNAME(String strValue) {
        this.setParamValue(TAG_PSPFNAME, strValue);
    }

    public final boolean isPSPFPLUGINIDNull() {
        return this.isParamNull(TAG_PSPFPLUGINID);
    }

    public final String getPSPFPLUGINID() {
        return this.getParamStringValue(TAG_PSPFPLUGINID, "");
    }

    public final void setPSPFPLUGINID(String strValue) {
        this.setParamValue(TAG_PSPFPLUGINID, strValue);
    }

    public final boolean isPSPFPLUGINNAMENull() {
        return this.isParamNull(TAG_PSPFPLUGINNAME);
    }

    public final String getPSPFPLUGINNAME() {
        return this.getParamStringValue(TAG_PSPFPLUGINNAME, "");
    }

    public final void setPSPFPLUGINNAME(String strValue) {
        this.setParamValue(TAG_PSPFPLUGINNAME, strValue);
    }

    public final boolean isTEMPLCODENull() {
        return this.isParamNull(TAG_TEMPLCODE);
    }

    public final String getTEMPLCODE() {
        return this.getParamStringValue(TAG_TEMPLCODE, "");
    }

    public final void setTEMPLCODE(String strValue) {
        this.setParamValue(TAG_TEMPLCODE, strValue);
    }

    public final boolean isTEMPLCODE2Null() {
        return this.isParamNull(TAG_TEMPLCODE2);
    }

    public final String getTEMPLCODE2() {
        return this.getParamStringValue(TAG_TEMPLCODE2, "");
    }

    public final void setTEMPLCODE2(String strValue) {
        this.setParamValue(TAG_TEMPLCODE2, strValue);
    }

    public final boolean isTEMPLCODE3Null() {
        return this.isParamNull(TAG_TEMPLCODE3);
    }

    public final String getTEMPLCODE3() {
        return this.getParamStringValue(TAG_TEMPLCODE3, "");
    }

    public final void setTEMPLCODE3(String strValue) {
        this.setParamValue(TAG_TEMPLCODE3, strValue);
    }

    public final boolean isTEMPLCODE4Null() {
        return this.isParamNull(TAG_TEMPLCODE4);
    }

    public final String getTEMPLCODE4() {
        return this.getParamStringValue(TAG_TEMPLCODE4, "");
    }

    public final void setTEMPLCODE4(String strValue) {
        this.setParamValue(TAG_TEMPLCODE4, strValue);
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

    public final boolean isTEMPLDESCNull() {
        return this.isParamNull(TAG_TEMPLDESC);
    }

    public final String getTEMPLDESC() {
        return this.getParamStringValue(TAG_TEMPLDESC, "");
    }

    public final void setTEMPLDESC(String strValue) {
        this.setParamValue(TAG_TEMPLDESC, strValue);
    }

    public final boolean isPSPFPUBCODEIDNull() {
        return this.isParamNull(TAG_PSPFPUBCODEID);
    }

    public final String getPSPFPUBCODEID() {
        return this.getParamStringValue(TAG_PSPFPUBCODEID, "");
    }

    public final void setPSPFPUBCODEID(String strValue) {
        this.setParamValue(TAG_PSPFPUBCODEID, strValue);
    }

    public final boolean isPSPFPUBCODENAMENull() {
        return this.isParamNull(TAG_PSPFPUBCODENAME);
    }

    public final String getPSPFPUBCODENAME() {
        return this.getParamStringValue(TAG_PSPFPUBCODENAME, "");
    }

    public final void setPSPFPUBCODENAME(String strValue) {
        this.setParamValue(TAG_PSPFPUBCODENAME, strValue);
    }
}

