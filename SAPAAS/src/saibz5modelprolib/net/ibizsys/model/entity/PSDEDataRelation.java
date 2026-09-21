/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.entity;

import java.util.Date;
import net.ibizsys.model.entity.BaseDataEntity;

public class PSDEDataRelation
extends BaseDataEntity {
    public static final String TAG_PSDEDATARELATIONID = "PSDEDATARELATIONID";
    public static final String TAG_PSDEDATARELATIONNAME = "PSDEDATARELATIONNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSDEID = "PSDEID";
    public static final String TAG_PSDENAME = "PSDENAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_CODENAME = "CODENAME";
    public static final String TAG_PSSYSCOUNTERID = "PSSYSCOUNTERID";
    public static final String TAG_PSSYSCOUNTERNAME = "PSSYSCOUNTERNAME";
    public static final String TAG_FORMPSDEVIEWBASEID = "FORMPSDEVIEWBASEID";
    public static final String TAG_FORMPSDEVIEWBASENAME = "FORMPSDEVIEWBASENAME";
    public static final String TAG_HIDEEDITITEM = "HIDEEDITITEM";
    public static final String TAG_FORMCAPTION = "FORMCAPTION";
    public static final String TAG_FORMCAPPSLANRESID = "FORMCAPPSLANRESID";
    public static final String TAG_FORMCAPPSLANRESNAME = "FORMCAPPSLANRESNAME";
    public static final String TAG_FORMPSSYSIMAGEID = "FORMPSSYSIMAGEID";
    public static final String TAG_FORMPSSYSIMAGENAME = "FORMPSSYSIMAGENAME";

    public final boolean isPSDEDATARELATIONIDNull() {
        return this.isParamNull(TAG_PSDEDATARELATIONID);
    }

    public final String getPSDEDATARELATIONID() {
        return this.getParamStringValue(TAG_PSDEDATARELATIONID, "");
    }

    public final void setPSDEDATARELATIONID(String strValue) {
        this.setParamValue(TAG_PSDEDATARELATIONID, strValue);
    }

    public final boolean isPSDEDATARELATIONNAMENull() {
        return this.isParamNull(TAG_PSDEDATARELATIONNAME);
    }

    public final String getPSDEDATARELATIONNAME() {
        return this.getParamStringValue(TAG_PSDEDATARELATIONNAME, "");
    }

    public final void setPSDEDATARELATIONNAME(String strValue) {
        this.setParamValue(TAG_PSDEDATARELATIONNAME, strValue);
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

    public final boolean isMEMONull() {
        return this.isParamNull(TAG_MEMO);
    }

    public final String getMEMO() {
        return this.getParamStringValue(TAG_MEMO, "");
    }

    public final void setMEMO(String strValue) {
        this.setParamValue(TAG_MEMO, strValue);
    }

    public final boolean isCODENAMENull() {
        return this.isParamNull(TAG_CODENAME);
    }

    public final String getCODENAME() {
        return this.getParamStringValue(TAG_CODENAME, "");
    }

    public final void setCODENAME(String strValue) {
        this.setParamValue(TAG_CODENAME, strValue);
    }

    public final boolean isPSSYSCOUNTERIDNull() {
        return this.isParamNull(TAG_PSSYSCOUNTERID);
    }

    public final String getPSSYSCOUNTERID() {
        return this.getParamStringValue(TAG_PSSYSCOUNTERID, "");
    }

    public final void setPSSYSCOUNTERID(String strValue) {
        this.setParamValue(TAG_PSSYSCOUNTERID, strValue);
    }

    public final boolean isPSSYSCOUNTERNAMENull() {
        return this.isParamNull(TAG_PSSYSCOUNTERNAME);
    }

    public final String getPSSYSCOUNTERNAME() {
        return this.getParamStringValue(TAG_PSSYSCOUNTERNAME, "");
    }

    public final void setPSSYSCOUNTERNAME(String strValue) {
        this.setParamValue(TAG_PSSYSCOUNTERNAME, strValue);
    }

    public final boolean isFORMPSDEVIEWBASEIDNull() {
        return this.isParamNull(TAG_FORMPSDEVIEWBASEID);
    }

    public final String getFORMPSDEVIEWBASEID() {
        return this.getParamStringValue(TAG_FORMPSDEVIEWBASEID, "");
    }

    public final void setFORMPSDEVIEWBASEID(String strValue) {
        this.setParamValue(TAG_FORMPSDEVIEWBASEID, strValue);
    }

    public final boolean isFORMPSDEVIEWBASENAMENull() {
        return this.isParamNull(TAG_FORMPSDEVIEWBASENAME);
    }

    public final String getFORMPSDEVIEWBASENAME() {
        return this.getParamStringValue(TAG_FORMPSDEVIEWBASENAME, "");
    }

    public final void setFORMPSDEVIEWBASENAME(String strValue) {
        this.setParamValue(TAG_FORMPSDEVIEWBASENAME, strValue);
    }

    public final boolean isHIDEEDITITEMNull() {
        return this.isParamNull(TAG_HIDEEDITITEM);
    }

    public final boolean getHIDEEDITITEM() {
        return this.getParamIntValue(TAG_HIDEEDITITEM, 0) == 1;
    }

    public final void setHIDEEDITITEM(boolean bValue) {
        this.setParamValue(TAG_HIDEEDITITEM, bValue ? 1 : 0);
    }

    public final String getFORMCAPTION() {
        return this.getParamStringValue(TAG_FORMCAPTION, "");
    }

    public final void setFORMCAPTION(String strValue) {
        this.setParamValue(TAG_FORMCAPTION, strValue);
    }

    public final boolean isFORMCAPPSLANRESIDNull() {
        return this.isParamNull(TAG_FORMCAPPSLANRESID);
    }

    public final String getFORMCAPPSLANRESID() {
        return this.getParamStringValue(TAG_FORMCAPPSLANRESID, "");
    }

    public final void setFORMCAPPSLANRESID(String strValue) {
        this.setParamValue(TAG_FORMCAPPSLANRESID, strValue);
    }

    public final boolean isFORMCAPPSLANRESNAMENull() {
        return this.isParamNull(TAG_FORMCAPPSLANRESNAME);
    }

    public final String getFORMCAPPSLANRESNAME() {
        return this.getParamStringValue(TAG_FORMCAPPSLANRESNAME, "");
    }

    public final void setFORMCAPPSLANRESNAME(String strValue) {
        this.setParamValue(TAG_FORMCAPPSLANRESNAME, strValue);
    }

    public final boolean isFORMPSSYSIMAGEIDNull() {
        return this.isParamNull(TAG_FORMPSSYSIMAGEID);
    }

    public final String getFORMPSSYSIMAGEID() {
        return this.getParamStringValue(TAG_FORMPSSYSIMAGEID, "");
    }

    public final void setFORMPSSYSIMAGEID(String strValue) {
        this.setParamValue(TAG_FORMPSSYSIMAGEID, strValue);
    }

    public final boolean isFORMPSSYSIMAGENAMENull() {
        return this.isParamNull(TAG_FORMPSSYSIMAGENAME);
    }

    public final String getFORMPSSYSIMAGENAME() {
        return this.getParamStringValue(TAG_FORMPSSYSIMAGENAME, "");
    }

    public final void setFORMPSSYSIMAGENAME(String strValue) {
        this.setParamValue(TAG_FORMPSSYSIMAGENAME, strValue);
    }
}

