/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

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
    public static final String TAG_PSMODULEID = "PSMODULEID";
    public static final String TAG_PSMODULENAME = "PSMODULENAME";
    public static final String TAG_LOCKFLAG = "LOCKFLAG";
    public static final String TAG_CODENAME = "CODENAME";

    public final boolean isPSLANGUAGERESIDNull() {
        return this.IsParamNull(TAG_PSLANGUAGERESID);
    }

    public final String getPSLANGUAGERESID() {
        return this.GetParamStringValue(TAG_PSLANGUAGERESID, "");
    }

    public final void setPSLANGUAGERESID(String strValue) {
        this.SetParamValue(TAG_PSLANGUAGERESID, strValue);
    }

    public final boolean isPSLANGUAGERESNAMENull() {
        return this.IsParamNull(TAG_PSLANGUAGERESNAME);
    }

    public final String getPSLANGUAGERESNAME() {
        return this.GetParamStringValue(TAG_PSLANGUAGERESNAME, "");
    }

    public final void setPSLANGUAGERESNAME(String strValue) {
        this.SetParamValue(TAG_PSLANGUAGERESNAME, strValue);
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

    public final boolean isPSSYSTEMIDNull() {
        return this.IsParamNull(TAG_PSSYSTEMID);
    }

    public final String getPSSYSTEMID() {
        return this.GetParamStringValue(TAG_PSSYSTEMID, "");
    }

    public final void setPSSYSTEMID(String strValue) {
        this.SetParamValue(TAG_PSSYSTEMID, strValue);
    }

    public final boolean isPSSYSTEMNAMENull() {
        return this.IsParamNull(TAG_PSSYSTEMNAME);
    }

    public final String getPSSYSTEMNAME() {
        return this.GetParamStringValue(TAG_PSSYSTEMNAME, "");
    }

    public final void setPSSYSTEMNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSTEMNAME, strValue);
    }

    public final boolean isPSSYSLANRESIDNull() {
        return this.IsParamNull(TAG_PSSYSLANRESID);
    }

    public final String getPSSYSLANRESID() {
        return this.GetParamStringValue(TAG_PSSYSLANRESID, "");
    }

    public final void setPSSYSLANRESID(String strValue) {
        this.SetParamValue(TAG_PSSYSLANRESID, strValue);
    }

    public final boolean isPSSYSLANRESNAMENull() {
        return this.IsParamNull(TAG_PSSYSLANRESNAME);
    }

    public final String getPSSYSLANRESNAME() {
        return this.GetParamStringValue(TAG_PSSYSLANRESNAME, "");
    }

    public final void setPSSYSLANRESNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSLANRESNAME, strValue);
    }

    public final boolean isLANRESTYPENull() {
        return this.IsParamNull(TAG_LANRESTYPE);
    }

    public final String getLANRESTYPE() {
        return this.GetParamStringValue(TAG_LANRESTYPE, "");
    }

    public final void setLANRESTYPE(String strValue) {
        this.SetParamValue(TAG_LANRESTYPE, strValue);
    }

    public final boolean isUSERDATANull() {
        return this.IsParamNull(TAG_USERDATA);
    }

    public final String getUSERDATA() {
        return this.GetParamStringValue(TAG_USERDATA, "");
    }

    public final void setUSERDATA(String strValue) {
        this.SetParamValue(TAG_USERDATA, strValue);
    }

    public final boolean isLANRESTAGNull() {
        return this.IsParamNull(TAG_LANRESTAG);
    }

    public final String getLANRESTAG() {
        return this.GetParamStringValue(TAG_LANRESTAG, "");
    }

    public final void setLANRESTAG(String strValue) {
        this.SetParamValue(TAG_LANRESTAG, strValue);
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

    public final boolean isCONTENTNull() {
        return this.IsParamNull(TAG_CONTENT);
    }

    public final String getCONTENT() {
        return this.GetParamStringValue(TAG_CONTENT, "");
    }

    public final void setCONTENT(String strValue) {
        this.SetParamValue(TAG_CONTENT, strValue);
    }

    public final boolean isCONTENT2Null() {
        return this.IsParamNull(TAG_CONTENT2);
    }

    public final String getCONTENT2() {
        return this.GetParamStringValue(TAG_CONTENT2, "");
    }

    public final void setCONTENT2(String strValue) {
        this.SetParamValue(TAG_CONTENT2, strValue);
    }

    public final boolean isPSDEIDNull() {
        return this.IsParamNull(TAG_PSDEID);
    }

    public final String getPSDEID() {
        return this.GetParamStringValue(TAG_PSDEID, "");
    }

    public final void setPSDEID(String strValue) {
        this.SetParamValue(TAG_PSDEID, strValue);
    }

    public final boolean isPSDENAMENull() {
        return this.IsParamNull(TAG_PSDENAME);
    }

    public final String getPSDENAME() {
        return this.GetParamStringValue(TAG_PSDENAME, "");
    }

    public final void setPSDENAME(String strValue) {
        this.SetParamValue(TAG_PSDENAME, strValue);
    }

    public final boolean isPSDEVIEWBASEIDNull() {
        return this.IsParamNull(TAG_PSDEVIEWBASEID);
    }

    public final String getPSDEVIEWBASEID() {
        return this.GetParamStringValue(TAG_PSDEVIEWBASEID, "");
    }

    public final void setPSDEVIEWBASEID(String strValue) {
        this.SetParamValue(TAG_PSDEVIEWBASEID, strValue);
    }

    public final boolean isPSDEVIEWBASENAMENull() {
        return this.IsParamNull(TAG_PSDEVIEWBASENAME);
    }

    public final String getPSDEVIEWBASENAME() {
        return this.GetParamStringValue(TAG_PSDEVIEWBASENAME, "");
    }

    public final void setPSDEVIEWBASENAME(String strValue) {
        this.SetParamValue(TAG_PSDEVIEWBASENAME, strValue);
    }

    public final boolean isPSSYSAPPIDNull() {
        return this.IsParamNull(TAG_PSSYSAPPID);
    }

    public final String getPSSYSAPPID() {
        return this.GetParamStringValue(TAG_PSSYSAPPID, "");
    }

    public final void setPSSYSAPPID(String strValue) {
        this.SetParamValue(TAG_PSSYSAPPID, strValue);
    }

    public final boolean isPSSYSAPPNAMENull() {
        return this.IsParamNull(TAG_PSSYSAPPNAME);
    }

    public final String getPSSYSAPPNAME() {
        return this.GetParamStringValue(TAG_PSSYSAPPNAME, "");
    }

    public final void setPSSYSAPPNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSAPPNAME, strValue);
    }

    public final boolean isPSAPPVIEWIDNull() {
        return this.IsParamNull(TAG_PSAPPVIEWID);
    }

    public final String getPSAPPVIEWID() {
        return this.GetParamStringValue(TAG_PSAPPVIEWID, "");
    }

    public final void setPSAPPVIEWID(String strValue) {
        this.SetParamValue(TAG_PSAPPVIEWID, strValue);
    }

    public final boolean isPSAPPVIEWNAMENull() {
        return this.IsParamNull(TAG_PSAPPVIEWNAME);
    }

    public final String getPSAPPVIEWNAME() {
        return this.GetParamStringValue(TAG_PSAPPVIEWNAME, "");
    }

    public final void setPSAPPVIEWNAME(String strValue) {
        this.SetParamValue(TAG_PSAPPVIEWNAME, strValue);
    }

    public final boolean isPSWFIDNull() {
        return this.IsParamNull(TAG_PSWFID);
    }

    public final String getPSWFID() {
        return this.GetParamStringValue(TAG_PSWFID, "");
    }

    public final void setPSWFID(String strValue) {
        this.SetParamValue(TAG_PSWFID, strValue);
    }

    public final boolean isPSWFNAMENull() {
        return this.IsParamNull(TAG_PSWFNAME);
    }

    public final String getPSWFNAME() {
        return this.GetParamStringValue(TAG_PSWFNAME, "");
    }

    public final void setPSWFNAME(String strValue) {
        this.SetParamValue(TAG_PSWFNAME, strValue);
    }

    public final boolean isPSWFVERSIONIDNull() {
        return this.IsParamNull(TAG_PSWFVERSIONID);
    }

    public final String getPSWFVERSIONID() {
        return this.GetParamStringValue(TAG_PSWFVERSIONID, "");
    }

    public final void setPSWFVERSIONID(String strValue) {
        this.SetParamValue(TAG_PSWFVERSIONID, strValue);
    }

    public final boolean isPSWFVERSIONNAMENull() {
        return this.IsParamNull(TAG_PSWFVERSIONNAME);
    }

    public final String getPSWFVERSIONNAME() {
        return this.GetParamStringValue(TAG_PSWFVERSIONNAME, "");
    }

    public final void setPSWFVERSIONNAME(String strValue) {
        this.SetParamValue(TAG_PSWFVERSIONNAME, strValue);
    }

    public final boolean isPSDEFIDNull() {
        return this.IsParamNull(TAG_PSDEFID);
    }

    public final String getPSDEFID() {
        return this.GetParamStringValue(TAG_PSDEFID, "");
    }

    public final void setPSDEFID(String strValue) {
        this.SetParamValue(TAG_PSDEFID, strValue);
    }

    public final boolean isPSDEFNAMENull() {
        return this.IsParamNull(TAG_PSDEFNAME);
    }

    public final String getPSDEFNAME() {
        return this.GetParamStringValue(TAG_PSDEFNAME, "");
    }

    public final void setPSDEFNAME(String strValue) {
        this.SetParamValue(TAG_PSDEFNAME, strValue);
    }

    public final boolean isPSLANITEMSCNTNull() {
        return this.IsParamNull(TAG_PSLANITEMSCNT);
    }

    public final int getPSLANITEMSCNT() {
        return this.GetParamIntValue(TAG_PSLANITEMSCNT, 0);
    }

    public final void setPSLANITEMSCNT(int nValue) {
        this.SetParamValue(TAG_PSLANITEMSCNT, nValue);
    }

    public final boolean isSHORTTAGNull() {
        return this.IsParamNull(TAG_SHORTTAG);
    }

    public final String getSHORTTAG() {
        return this.GetParamStringValue(TAG_SHORTTAG, "");
    }

    public final void setSHORTTAG(String strValue) {
        this.SetParamValue(TAG_SHORTTAG, strValue);
    }

    public final boolean isAPPREFFLAGNull() {
        return this.IsParamNull(TAG_APPREFFLAG);
    }

    public final boolean getAPPREFFLAG() {
        return this.GetParamIntValue(TAG_APPREFFLAG, 0) == 1;
    }

    public final void setAPPREFFLAG(boolean bValue) {
        this.SetParamValue(TAG_APPREFFLAG, bValue ? 1 : 0);
    }

    public final boolean isPSMODULEIDNull() {
        return this.IsParamNull(TAG_PSMODULEID);
    }

    public final String getPSMODULEID() {
        return this.GetParamStringValue(TAG_PSMODULEID, "");
    }

    public final void setPSMODULEID(String strValue) {
        this.SetParamValue(TAG_PSMODULEID, strValue);
    }

    public final boolean isPSMODULENAMENull() {
        return this.IsParamNull(TAG_PSMODULENAME);
    }

    public final String getPSMODULENAME() {
        return this.GetParamStringValue(TAG_PSMODULENAME, "");
    }

    public final void setPSMODULENAME(String strValue) {
        this.SetParamValue(TAG_PSMODULENAME, strValue);
    }

    public final boolean isLOCKFLAGNull() {
        return this.IsParamNull(TAG_LOCKFLAG);
    }

    public final boolean getLOCKFLAG() {
        return this.GetParamIntValue(TAG_LOCKFLAG, 0) == 1;
    }

    public final void setLOCKFLAG(boolean bValue) {
        this.SetParamValue(TAG_LOCKFLAG, bValue ? 1 : 0);
    }

    public final boolean isCODENAMENull() {
        return this.IsParamNull(TAG_CODENAME);
    }

    public final String getCODENAME() {
        return this.GetParamStringValue(TAG_CODENAME, "");
    }

    public final void setCODENAME(String strValue) {
        this.SetParamValue(TAG_CODENAME, strValue);
    }
}

