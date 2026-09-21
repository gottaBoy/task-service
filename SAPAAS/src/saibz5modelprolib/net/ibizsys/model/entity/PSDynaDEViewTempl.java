/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.entity;

import java.util.Date;
import net.ibizsys.model.entity.BaseDataEntity;

public class PSDynaDEViewTempl
extends BaseDataEntity {
    public static final String VIEWTYPE_APPINDEXVIEW = "APPINDEXVIEW";
    public static final String VIEWTYPE_SUBSYSDEVIEW = "SUBSYSDEVIEW";
    public static final String VIEWTYPE_APPPORTALVIEW = "APPPORTALVIEW";
    public static final String VIEWTYPE_DEMPICKUPVIEW = "DEMPICKUPVIEW";
    public static final String VIEWTYPE_DETREEVIEW = "DETREEVIEW";
    public static final String VIEWTYPE_DETREEGRIDVIEW9 = "DETREEGRIDVIEW9";
    public static final String VIEWTYPE_DETREEEXPVIEW3 = "DETREEEXPVIEW3";
    public static final String VIEWTYPE_DETREEEXPVIEW2 = "DETREEEXPVIEW2";
    public static final String VIEWTYPE_DEMEDITVIEW9 = "DEMEDITVIEW9";
    public static final String VIEWTYPE_DETREEEXPVIEW = "DETREEEXPVIEW";
    public static final String VIEWTYPE_DETABEXPVIEW = "DETABEXPVIEW";
    public static final String VIEWTYPE_DEGRIDVIEW9 = "DEGRIDVIEW9";
    public static final String VIEWTYPE_DEPICKUPVIEW2 = "DEPICKUPVIEW2";
    public static final String VIEWTYPE_DEPICKUPVIEW = "DEPICKUPVIEW";
    public static final String VIEWTYPE_DEMOBMPICKUPVIEW = "DEMOBMPICKUPVIEW";
    public static final String VIEWTYPE_DEPICKUPTREEVIEW = "DEPICKUPTREEVIEW";
    public static final String VIEWTYPE_DEPICKUPGRIDVIEW = "DEPICKUPGRIDVIEW";
    public static final String VIEWTYPE_DEMOBWFMDVIEW = "DEMOBWFMDVIEW";
    public static final String VIEWTYPE_DEMPICKUPVIEW2 = "DEMPICKUPVIEW2";
    public static final String VIEWTYPE_DEGRIDVIEW8 = "DEGRIDVIEW8";
    public static final String VIEWTYPE_DEWFEXPVIEW = "DEWFEXPVIEW";
    public static final String VIEWTYPE_DYNADEGRIDVIEW = "DYNADEGRIDVIEW";
    public static final String VIEWTYPE_DEMOBPICKUPVIEW = "DEMOBPICKUPVIEW";
    public static final String VIEWTYPE_DEWFGRIDVIEW = "DEWFGRIDVIEW";
    public static final String VIEWTYPE_DEGRIDVIEW2 = "DEGRIDVIEW2";
    public static final String VIEWTYPE_DEGRIDVIEW4 = "DEGRIDVIEW4";
    public static final String VIEWTYPE_DETREEVIEW9 = "DETREEVIEW9";
    public static final String VIEWTYPE_DEGRIDVIEW = "DEGRIDVIEW";
    public static final String VIEWTYPE_DEMOBPICKUPLISTVIEW = "DEMOBPICKUPLISTVIEW";
    public static final String VIEWTYPE_DEMOBPICKUPMDVIEW = "DEMOBPICKUPMDVIEW";
    public static final String VIEWTYPE_DEMOBPICKUPTREEVIEW = "DEMOBPICKUPTREEVIEW";
    public static final String VIEWTYPE_DEMOBTABEXPVIEW = "DEMOBTABEXPVIEW";
    public static final String VIEWTYPE_DEMOBFORMPICKUPMDVIEW = "DEMOBFORMPICKUPMDVIEW";
    public static final String VIEWTYPE_DEMOBINDEXPICKUPMDVIEW = "DEMOBINDEXPICKUPMDVIEW";
    public static final String VIEWTYPE_DEPORTALVIEW9 = "DEPORTALVIEW9";
    public static final String VIEWTYPE_DEMOBWFSTARTVIEW = "DEMOBWFSTARTVIEW";
    public static final String VIEWTYPE_DEWFSTARTVIEW = "DEWFSTARTVIEW";
    public static final String VIEWTYPE_DEWFEDITVIEW3 = "DEWFEDITVIEW3";
    public static final String VIEWTYPE_DEWFEDITVIEW2 = "DEWFEDITVIEW2";
    public static final String VIEWTYPE_DEPORTALVIEW = "DEPORTALVIEW";
    public static final String VIEWTYPE_DEWFEDITVIEW = "DEWFEDITVIEW";
    public static final String VIEWTYPE_DEREDIRECTVIEW = "DEREDIRECTVIEW";
    public static final String VIEWTYPE_DEREPORTVIEW = "DEREPORTVIEW";
    public static final String VIEWTYPE_DEWFDATAREDIRECTVIEW = "DEWFDATAREDIRECTVIEW";
    public static final String VIEWTYPE_DEWFACTIONVIEW = "DEWFACTIONVIEW";
    public static final String VIEWTYPE_DEOPTVIEW = "DEOPTVIEW";
    public static final String VIEWTYPE_DEMOBWFEDITVIEW3 = "DEMOBWFEDITVIEW3";
    public static final String VIEWTYPE_DEMOBLISTVIEW = "DEMOBLISTVIEW";
    public static final String VIEWTYPE_DEMOBEDITVIEW3 = "DEMOBEDITVIEW3";
    public static final String VIEWTYPE_DEMOBEDITVIEW = "DEMOBEDITVIEW";
    public static final String VIEWTYPE_DEMOBCUSTOMVIEW = "DEMOBCUSTOMVIEW";
    public static final String VIEWTYPE_DECUSTOMVIEW = "DECUSTOMVIEW";
    public static final String VIEWTYPE_DEMDCUSTOMVIEW = "DEMDCUSTOMVIEW";
    public static final String VIEWTYPE_DEINDEXVIEW = "DEINDEXVIEW";
    public static final String VIEWTYPE_DEHTMLVIEW = "DEHTMLVIEW";
    public static final String VIEWTYPE_DEEDITVIEW4 = "DEEDITVIEW4";
    public static final String VIEWTYPE_DEEDITVIEW2 = "DEEDITVIEW2";
    public static final String VIEWTYPE_DEMOBMDVIEW = "DEMOBMDVIEW";
    public static final String VIEWTYPE_DEMOBMDVIEW9 = "DEMOBMDVIEW9";
    public static final String VIEWTYPE_DEMOBWFEDITVIEW = "DEMOBWFEDITVIEW";
    public static final String VIEWTYPE_DEMOBWFACTIONVIEW = "DEMOBWFACTIONVIEW";
    public static final String VIEWTYPE_DEMOBTREEVIEW = "DEMOBTREEVIEW";
    public static final String VIEWTYPE_DEEDITVIEW3 = "DEEDITVIEW3";
    public static final String VIEWTYPE_DEEDITVIEW = "DEEDITVIEW";
    public static final String VIEWTYPE_DECHARTVIEW9 = "DECHARTVIEW9";
    public static final String VIEWTYPE_DECHARTVIEW = "DECHARTVIEW";
    public static final String VIEWTYPE_DEEDITVIEW9 = "DEEDITVIEW9";
    public static final String VIEWTYPE_DEDATAVIEW = "DEDATAVIEW";
    public static final String VIEWTYPE_DEPICKUPDATAVIEW = "DEPICKUPDATAVIEW";
    public static final String VIEWTYPE_DEINDEXPICKUPDATAVIEW = "DEINDEXPICKUPDATAVIEW";
    public static final String VIEWTYPE_DEFORMPICKUPDATAVIEW = "DEFORMPICKUPDATAVIEW";
    public static final String VIEWTYPE_DEWIZARDVIEW = "DEWIZARDVIEW";
    public static final String VIEWTYPE_DEMOBWIZARDVIEW = "DEMOBWIZARDVIEW";
    public static final String VIEWTYPE_DECALENDARVIEW9 = "DECALENDARVIEW9";
    public static final String VIEWTYPE_DEMOBCALENDARVIEW = "DEMOBCALENDARVIEW";
    public static final String VIEWTYPE_DEMOBCALENDARVIEW9 = "DEMOBCALENDARVIEW9";
    public static final String VIEWTYPE_DECALENDARVIEW = "DECALENDARVIEW";
    public static final String VIEWTYPE_DEMOBPANELVIEW = "DEMOBPANELVIEW";
    public static final String VIEWTYPE_DEMOBPANELVIEW9 = "DEMOBPANELVIEW9";
    public static final String VIEWTYPE_DEPANELVIEW9 = "DEPANELVIEW9";
    public static final String VIEWTYPE_DEPANELVIEW = "DEPANELVIEW";
    public static final String TAG_PSDYNADEVIEWTEMPLID = "PSDYNADEVIEWTEMPLID";
    public static final String TAG_PSDYNADEVIEWTEMPLNAME = "PSDYNADEVIEWTEMPLNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSDYNADETEMPLID = "PSDYNADETEMPLID";
    public static final String TAG_PSDYNADETEMPLNAME = "PSDYNADETEMPLNAME";
    public static final String TAG_VIEWTYPE = "VIEWTYPE";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_CODENAME = "CODENAME";

    public final boolean isPSDYNADEVIEWTEMPLIDNull() {
        return this.isParamNull(TAG_PSDYNADEVIEWTEMPLID);
    }

    public final String getPSDYNADEVIEWTEMPLID() {
        return this.getParamStringValue(TAG_PSDYNADEVIEWTEMPLID, "");
    }

    public final void setPSDYNADEVIEWTEMPLID(String strValue) {
        this.setParamValue(TAG_PSDYNADEVIEWTEMPLID, strValue);
    }

    public final boolean isPSDYNADEVIEWTEMPLNAMENull() {
        return this.isParamNull(TAG_PSDYNADEVIEWTEMPLNAME);
    }

    public final String getPSDYNADEVIEWTEMPLNAME() {
        return this.getParamStringValue(TAG_PSDYNADEVIEWTEMPLNAME, "");
    }

    public final void setPSDYNADEVIEWTEMPLNAME(String strValue) {
        this.setParamValue(TAG_PSDYNADEVIEWTEMPLNAME, strValue);
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

    public final boolean isPSDYNADETEMPLIDNull() {
        return this.isParamNull(TAG_PSDYNADETEMPLID);
    }

    public final String getPSDYNADETEMPLID() {
        return this.getParamStringValue(TAG_PSDYNADETEMPLID, "");
    }

    public final void setPSDYNADETEMPLID(String strValue) {
        this.setParamValue(TAG_PSDYNADETEMPLID, strValue);
    }

    public final boolean isPSDYNADETEMPLNAMENull() {
        return this.isParamNull(TAG_PSDYNADETEMPLNAME);
    }

    public final String getPSDYNADETEMPLNAME() {
        return this.getParamStringValue(TAG_PSDYNADETEMPLNAME, "");
    }

    public final void setPSDYNADETEMPLNAME(String strValue) {
        this.setParamValue(TAG_PSDYNADETEMPLNAME, strValue);
    }

    public final boolean isVIEWTYPENull() {
        return this.isParamNull(TAG_VIEWTYPE);
    }

    public final String getVIEWTYPE() {
        return this.getParamStringValue(TAG_VIEWTYPE, "");
    }

    public final void setVIEWTYPE(String strValue) {
        this.setParamValue(TAG_VIEWTYPE, strValue);
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
}

