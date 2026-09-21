/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.entity;

import java.util.Date;
import net.ibizsys.model.entity.BaseDataEntity;

public class PSLanguageRes
extends BaseDataEntity {
    public static final String LANRESTYPE_DE_LNAME = "DE.LNAME";
    public static final String LANRESTYPE_DEF_LNAME = "DEF.LNAME";
    public static final String LANRESTYPE_CL_ITEM_LNAME = "CL.ITEM.LNAME";
    public static final String LANRESTYPE_TBB_TEXT = "TBB.TEXT";
    public static final String LANRESTYPE_TBB_TOOLTIP = "TBB.TOOLTIP";
    public static final String LANRESTYPE_MENUITEM_CAPTION = "MENUITEM.CAPTION";
    public static final String LANRESTYPE_PAGE_HEADER = "PAGE.HEADER";
    public static final String LANRESTYPE_PAGE_COMMON = "PAGE.COMMON";
    public static final String LANRESTYPE_CONTROL = "CONTROL";
    public static final String LANRESTYPE_ERROR_STD = "ERROR.STD";
    public static final String LANRESTYPE_CTRL = "CTRL";
    public static final String LANRESTYPE_COMMON = "COMMON";
    public static final String LANRESTYPE_OTHER = "OTHER";
    public static final String TAG_PSLANGUAGERESID = "PSLANGUAGERESID";
    public static final String TAG_PSLANGUAGERESNAME = "PSLANGUAGERESNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSSYSTEMID = "PSSYSTEMID";
    public static final String TAG_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String TAG_PSSYSLANRESID = "PSSYSLANRESID";
    public static final String TAG_PSSYSLANRESNAME = "PSSYSLANRESNAME";
    public static final String TAG_LANRESTYPE = "LANRESTYPE";
    public static final String TAG_USERDATA = "USERDATA";
    public static final String TAG_LANRESTAG = "LANRESTAG";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_CONTENT = "CONTENT";
    public static final String TAG_CONTENT2 = "CONTENT2";
    public static final String TAG_PSDEID = "PSDEID";
    public static final String TAG_PSDENAME = "PSDENAME";
    public static final String TAG_PSDEVIEWBASEID = "PSDEVIEWBASEID";
    public static final String TAG_PSDEVIEWBASENAME = "PSDEVIEWBASENAME";
    public static final String TAG_PSSYSAPPID = "PSSYSAPPID";
    public static final String TAG_PSSYSAPPNAME = "PSSYSAPPNAME";
    public static final String TAG_PSAPPVIEWID = "PSAPPVIEWID";
    public static final String TAG_PSAPPVIEWNAME = "PSAPPVIEWNAME";
    public static final String TAG_PSWFID = "PSWFID";
    public static final String TAG_PSWFNAME = "PSWFNAME";
    public static final String TAG_PSWFVERSIONID = "PSWFVERSIONID";
    public static final String TAG_PSWFVERSIONNAME = "PSWFVERSIONNAME";
    public static final String TAG_PSDEFID = "PSDEFID";
    public static final String TAG_PSDEFNAME = "PSDEFNAME";
    public static final String TAG_PSLANITEMSCNT = "PSLANITEMSCNT";
    public static final String TAG_SHORTTAG = "SHORTTAG";
    public static final String TAG_APPREFFLAG = "APPREFFLAG";

    public final boolean isPSLANGUAGERESIDNull() {
        return this.isParamNull(TAG_PSLANGUAGERESID);
    }

    public final String getPSLANGUAGERESID() {
        return this.getParamStringValue(TAG_PSLANGUAGERESID, "");
    }

    public final void setPSLANGUAGERESID(String strValue) {
        this.setParamValue(TAG_PSLANGUAGERESID, strValue);
    }

    public final boolean isPSLANGUAGERESNAMENull() {
        return this.isParamNull(TAG_PSLANGUAGERESNAME);
    }

    public final String getPSLANGUAGERESNAME() {
        return this.getParamStringValue(TAG_PSLANGUAGERESNAME, "");
    }

    public final void setPSLANGUAGERESNAME(String strValue) {
        this.setParamValue(TAG_PSLANGUAGERESNAME, strValue);
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

    public final boolean isPSSYSTEMIDNull() {
        return this.isParamNull(TAG_PSSYSTEMID);
    }

    public final String getPSSYSTEMID() {
        return this.getParamStringValue(TAG_PSSYSTEMID, "");
    }

    public final void setPSSYSTEMID(String strValue) {
        this.setParamValue(TAG_PSSYSTEMID, strValue);
    }

    public final boolean isPSSYSTEMNAMENull() {
        return this.isParamNull(TAG_PSSYSTEMNAME);
    }

    public final String getPSSYSTEMNAME() {
        return this.getParamStringValue(TAG_PSSYSTEMNAME, "");
    }

    public final void setPSSYSTEMNAME(String strValue) {
        this.setParamValue(TAG_PSSYSTEMNAME, strValue);
    }

    public final boolean isPSSYSLANRESIDNull() {
        return this.isParamNull(TAG_PSSYSLANRESID);
    }

    public final String getPSSYSLANRESID() {
        return this.getParamStringValue(TAG_PSSYSLANRESID, "");
    }

    public final void setPSSYSLANRESID(String strValue) {
        this.setParamValue(TAG_PSSYSLANRESID, strValue);
    }

    public final boolean isPSSYSLANRESNAMENull() {
        return this.isParamNull(TAG_PSSYSLANRESNAME);
    }

    public final String getPSSYSLANRESNAME() {
        return this.getParamStringValue(TAG_PSSYSLANRESNAME, "");
    }

    public final void setPSSYSLANRESNAME(String strValue) {
        this.setParamValue(TAG_PSSYSLANRESNAME, strValue);
    }

    public final boolean isLANRESTYPENull() {
        return this.isParamNull(TAG_LANRESTYPE);
    }

    public final String getLANRESTYPE() {
        return this.getParamStringValue(TAG_LANRESTYPE, "");
    }

    public final void setLANRESTYPE(String strValue) {
        this.setParamValue(TAG_LANRESTYPE, strValue);
    }

    public final boolean isUSERDATANull() {
        return this.isParamNull(TAG_USERDATA);
    }

    public final String getUSERDATA() {
        return this.getParamStringValue(TAG_USERDATA, "");
    }

    public final void setUSERDATA(String strValue) {
        this.setParamValue(TAG_USERDATA, strValue);
    }

    public final boolean isLANRESTAGNull() {
        return this.isParamNull(TAG_LANRESTAG);
    }

    public final String getLANRESTAG() {
        return this.getParamStringValue(TAG_LANRESTAG, "");
    }

    public final void setLANRESTAG(String strValue) {
        this.setParamValue(TAG_LANRESTAG, strValue);
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

    public final boolean isCONTENTNull() {
        return this.isParamNull(TAG_CONTENT);
    }

    public final String getCONTENT() {
        return this.getParamStringValue(TAG_CONTENT, "");
    }

    public final void setCONTENT(String strValue) {
        this.setParamValue(TAG_CONTENT, strValue);
    }

    public final boolean isCONTENT2Null() {
        return this.isParamNull(TAG_CONTENT2);
    }

    public final String getCONTENT2() {
        return this.getParamStringValue(TAG_CONTENT2, "");
    }

    public final void setCONTENT2(String strValue) {
        this.setParamValue(TAG_CONTENT2, strValue);
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

    public final boolean isPSDEVIEWBASEIDNull() {
        return this.isParamNull(TAG_PSDEVIEWBASEID);
    }

    public final String getPSDEVIEWBASEID() {
        return this.getParamStringValue(TAG_PSDEVIEWBASEID, "");
    }

    public final void setPSDEVIEWBASEID(String strValue) {
        this.setParamValue(TAG_PSDEVIEWBASEID, strValue);
    }

    public final boolean isPSDEVIEWBASENAMENull() {
        return this.isParamNull(TAG_PSDEVIEWBASENAME);
    }

    public final String getPSDEVIEWBASENAME() {
        return this.getParamStringValue(TAG_PSDEVIEWBASENAME, "");
    }

    public final void setPSDEVIEWBASENAME(String strValue) {
        this.setParamValue(TAG_PSDEVIEWBASENAME, strValue);
    }

    public final boolean isPSSYSAPPIDNull() {
        return this.isParamNull(TAG_PSSYSAPPID);
    }

    public final String getPSSYSAPPID() {
        return this.getParamStringValue(TAG_PSSYSAPPID, "");
    }

    public final void setPSSYSAPPID(String strValue) {
        this.setParamValue(TAG_PSSYSAPPID, strValue);
    }

    public final boolean isPSSYSAPPNAMENull() {
        return this.isParamNull(TAG_PSSYSAPPNAME);
    }

    public final String getPSSYSAPPNAME() {
        return this.getParamStringValue(TAG_PSSYSAPPNAME, "");
    }

    public final void setPSSYSAPPNAME(String strValue) {
        this.setParamValue(TAG_PSSYSAPPNAME, strValue);
    }

    public final boolean isPSAPPVIEWIDNull() {
        return this.isParamNull(TAG_PSAPPVIEWID);
    }

    public final String getPSAPPVIEWID() {
        return this.getParamStringValue(TAG_PSAPPVIEWID, "");
    }

    public final void setPSAPPVIEWID(String strValue) {
        this.setParamValue(TAG_PSAPPVIEWID, strValue);
    }

    public final boolean isPSAPPVIEWNAMENull() {
        return this.isParamNull(TAG_PSAPPVIEWNAME);
    }

    public final String getPSAPPVIEWNAME() {
        return this.getParamStringValue(TAG_PSAPPVIEWNAME, "");
    }

    public final void setPSAPPVIEWNAME(String strValue) {
        this.setParamValue(TAG_PSAPPVIEWNAME, strValue);
    }

    public final boolean isPSWFIDNull() {
        return this.isParamNull(TAG_PSWFID);
    }

    public final String getPSWFID() {
        return this.getParamStringValue(TAG_PSWFID, "");
    }

    public final void setPSWFID(String strValue) {
        this.setParamValue(TAG_PSWFID, strValue);
    }

    public final boolean isPSWFNAMENull() {
        return this.isParamNull(TAG_PSWFNAME);
    }

    public final String getPSWFNAME() {
        return this.getParamStringValue(TAG_PSWFNAME, "");
    }

    public final void setPSWFNAME(String strValue) {
        this.setParamValue(TAG_PSWFNAME, strValue);
    }

    public final boolean isPSWFVERSIONIDNull() {
        return this.isParamNull(TAG_PSWFVERSIONID);
    }

    public final String getPSWFVERSIONID() {
        return this.getParamStringValue(TAG_PSWFVERSIONID, "");
    }

    public final void setPSWFVERSIONID(String strValue) {
        this.setParamValue(TAG_PSWFVERSIONID, strValue);
    }

    public final boolean isPSWFVERSIONNAMENull() {
        return this.isParamNull(TAG_PSWFVERSIONNAME);
    }

    public final String getPSWFVERSIONNAME() {
        return this.getParamStringValue(TAG_PSWFVERSIONNAME, "");
    }

    public final void setPSWFVERSIONNAME(String strValue) {
        this.setParamValue(TAG_PSWFVERSIONNAME, strValue);
    }

    public final boolean isPSDEFIDNull() {
        return this.isParamNull(TAG_PSDEFID);
    }

    public final String getPSDEFID() {
        return this.getParamStringValue(TAG_PSDEFID, "");
    }

    public final void setPSDEFID(String strValue) {
        this.setParamValue(TAG_PSDEFID, strValue);
    }

    public final boolean isPSDEFNAMENull() {
        return this.isParamNull(TAG_PSDEFNAME);
    }

    public final String getPSDEFNAME() {
        return this.getParamStringValue(TAG_PSDEFNAME, "");
    }

    public final void setPSDEFNAME(String strValue) {
        this.setParamValue(TAG_PSDEFNAME, strValue);
    }

    public final boolean isPSLANITEMSCNTNull() {
        return this.isParamNull(TAG_PSLANITEMSCNT);
    }

    public final int getPSLANITEMSCNT() {
        return this.getParamIntValue(TAG_PSLANITEMSCNT, 0);
    }

    public final void setPSLANITEMSCNT(int nValue) {
        this.setParamValue(TAG_PSLANITEMSCNT, nValue);
    }

    public final boolean isSHORTTAGNull() {
        return this.isParamNull(TAG_SHORTTAG);
    }

    public final String getSHORTTAG() {
        return this.getParamStringValue(TAG_SHORTTAG, "");
    }

    public final void setSHORTTAG(String strValue) {
        this.setParamValue(TAG_SHORTTAG, strValue);
    }

    public final boolean isAPPREFFLAGNull() {
        return this.isParamNull(TAG_APPREFFLAG);
    }

    public final boolean getAPPREFFLAG() {
        return this.getParamIntValue(TAG_APPREFFLAG, 0) == 1;
    }

    public final void setAPPREFFLAG(boolean bValue) {
        this.setParamValue(TAG_APPREFFLAG, bValue ? 1 : 0);
    }
}

