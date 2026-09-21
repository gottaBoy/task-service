/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSAppUtilView
extends BaseDataEntity {
    public static final String PSAPPVIEWTYPE_APPDEVIEW = "APPDEVIEW";
    public static final String PSAPPVIEWTYPE_APPINDEXVIEW = "APPINDEXVIEW";
    public static final String PSDEVIEWTYPE_APPINDEXVIEW = "APPINDEXVIEW";
    public static final String PSDEVIEWTYPE_APPPORTALVIEW = "APPPORTALVIEW";
    public static final String PSDEVIEWTYPE_SUBSYSDEVIEW = "SUBSYSDEVIEW";
    public static final String PSDEVIEWTYPE_DEMOBMPICKUPVIEW = "DEMOBMPICKUPVIEW";
    public static final String PSDEVIEWTYPE_DETREEGRIDVIEW9 = "DETREEGRIDVIEW9";
    public static final String PSDEVIEWTYPE_DETREEVIEW = "DETREEVIEW";
    public static final String PSDEVIEWTYPE_DETREEVIEW9 = "DETREEVIEW9";
    public static final String PSDEVIEWTYPE_DEMEDITVIEW9 = "DEMEDITVIEW9";
    public static final String PSDEVIEWTYPE_DEPICKUPGRIDVIEW = "DEPICKUPGRIDVIEW";
    public static final String PSDEVIEWTYPE_DETREEEXPVIEW2 = "DETREEEXPVIEW2";
    public static final String PSDEVIEWTYPE_DETREEEXPVIEW = "DETREEEXPVIEW";
    public static final String PSDEVIEWTYPE_DEMOBPICKUPVIEW = "DEMOBPICKUPVIEW";
    public static final String PSDEVIEWTYPE_DETABEXPVIEW = "DETABEXPVIEW";
    public static final String PSDEVIEWTYPE_DEMOBWFMDVIEW = "DEMOBWFMDVIEW";
    public static final String PSDEVIEWTYPE_DEPICKUPVIEW2 = "DEPICKUPVIEW2";
    public static final String PSDEVIEWTYPE_DEMPICKUPVIEW = "DEMPICKUPVIEW";
    public static final String PSDEVIEWTYPE_DEMPICKUPVIEW2 = "DEMPICKUPVIEW2";
    public static final String PSDEVIEWTYPE_DEPICKUPVIEW = "DEPICKUPVIEW";
    public static final String PSDEVIEWTYPE_DEPICKUPTREEVIEW = "DEPICKUPTREEVIEW";
    public static final String PSDEVIEWTYPE_DEWFEXPVIEW = "DEWFEXPVIEW";
    public static final String PSDEVIEWTYPE_DEWFGRIDVIEW = "DEWFGRIDVIEW";
    public static final String PSDEVIEWTYPE_DETREEEXPVIEW3 = "DETREEEXPVIEW3";
    public static final String PSDEVIEWTYPE_DYNADEGRIDVIEW = "DYNADEGRIDVIEW";
    public static final String PSDEVIEWTYPE_DEGRIDVIEW = "DEGRIDVIEW";
    public static final String PSDEVIEWTYPE_DYNADEMPICKUPVIEW = "DYNADEMPICKUPVIEW";
    public static final String PSDEVIEWTYPE_DEGRIDVIEW2 = "DEGRIDVIEW2";
    public static final String PSDEVIEWTYPE_DEGRIDVIEW4 = "DEGRIDVIEW4";
    public static final String PSDEVIEWTYPE_DYNADEMPICKUPVIEW2 = "DYNADEMPICKUPVIEW2";
    public static final String PSDEVIEWTYPE_DEGRIDVIEW9 = "DEGRIDVIEW9";
    public static final String PSDEVIEWTYPE_DYNADEPICKUPVIEW2 = "DYNADEPICKUPVIEW2";
    public static final String PSDEVIEWTYPE_DEGRIDVIEW8 = "DEGRIDVIEW8";
    public static final String PSDEVIEWTYPE_DYNADEPICKUPVIEW = "DYNADEPICKUPVIEW";
    public static final String PSDEVIEWTYPE_DYNADEPICKUPGRIDVIEW = "DYNADEPICKUPGRIDVIEW";
    public static final String PSDEVIEWTYPE_DEMOBTABEXPVIEW = "DEMOBTABEXPVIEW";
    public static final String PSDEVIEWTYPE_DEMOBPICKUPTREEVIEW = "DEMOBPICKUPTREEVIEW";
    public static final String PSDEVIEWTYPE_DEMOBPICKUPMDVIEW = "DEMOBPICKUPMDVIEW";
    public static final String PSDEVIEWTYPE_DEMOBPICKUPLISTVIEW = "DEMOBPICKUPLISTVIEW";
    public static final String PSDEVIEWTYPE_DEMOBINDEXPICKUPMDVIEW = "DEMOBINDEXPICKUPMDVIEW";
    public static final String PSDEVIEWTYPE_DEMOBFORMPICKUPMDVIEW = "DEMOBFORMPICKUPMDVIEW";
    public static final String PSDEVIEWTYPE_DYNADEEDITVIEW2 = "DYNADEEDITVIEW2";
    public static final String PSDEVIEWTYPE_DEWFSTARTVIEW = "DEWFSTARTVIEW";
    public static final String PSDEVIEWTYPE_DYNADEREDIRECTVIEW = "DYNADEREDIRECTVIEW";
    public static final String PSDEVIEWTYPE_DEWFEDITVIEW2 = "DEWFEDITVIEW2";
    public static final String PSDEVIEWTYPE_DEWFEDITVIEW = "DEWFEDITVIEW";
    public static final String PSDEVIEWTYPE_DEWFDATAREDIRECTVIEW = "DEWFDATAREDIRECTVIEW";
    public static final String PSDEVIEWTYPE_DEPORTALVIEW = "DEPORTALVIEW";
    public static final String PSDEVIEWTYPE_DEWFACTIONVIEW = "DEWFACTIONVIEW";
    public static final String PSDEVIEWTYPE_DEPORTALVIEW9 = "DEPORTALVIEW9";
    public static final String PSDEVIEWTYPE_DEREDIRECTVIEW = "DEREDIRECTVIEW";
    public static final String PSDEVIEWTYPE_DEREPORTVIEW = "DEREPORTVIEW";
    public static final String PSDEVIEWTYPE_DEEDITVIEW4 = "DEEDITVIEW4";
    public static final String PSDEVIEWTYPE_DEWFEDITVIEW3 = "DEWFEDITVIEW3";
    public static final String PSDEVIEWTYPE_DYNADEEDITVIEW = "DYNADEEDITVIEW";
    public static final String PSDEVIEWTYPE_DEMOBMDVIEW9 = "DEMOBMDVIEW9";
    public static final String PSDEVIEWTYPE_DEEDITVIEW2 = "DEEDITVIEW2";
    public static final String PSDEVIEWTYPE_DEMOBLISTVIEW = "DEMOBLISTVIEW";
    public static final String PSDEVIEWTYPE_DEMOBEDITVIEW3 = "DEMOBEDITVIEW3";
    public static final String PSDEVIEWTYPE_DEMOBEDITVIEW = "DEMOBEDITVIEW";
    public static final String PSDEVIEWTYPE_DEMOBCUSTOMVIEW = "DEMOBCUSTOMVIEW";
    public static final String PSDEVIEWTYPE_DEEDITVIEW = "DEEDITVIEW";
    public static final String PSDEVIEWTYPE_DEMDCUSTOMVIEW = "DEMDCUSTOMVIEW";
    public static final String PSDEVIEWTYPE_DEINDEXVIEW = "DEINDEXVIEW";
    public static final String PSDEVIEWTYPE_DEHTMLVIEW = "DEHTMLVIEW";
    public static final String PSDEVIEWTYPE_DEEDITVIEW3 = "DEEDITVIEW3";
    public static final String PSDEVIEWTYPE_DEMOBMDVIEW = "DEMOBMDVIEW";
    public static final String PSDEVIEWTYPE_DECUSTOMVIEW = "DECUSTOMVIEW";
    public static final String PSDEVIEWTYPE_DECHARTVIEW9 = "DECHARTVIEW9";
    public static final String PSDEVIEWTYPE_DECHARTVIEW = "DECHARTVIEW";
    public static final String PSDEVIEWTYPE_DEOPTVIEW = "DEOPTVIEW";
    public static final String PSDEVIEWTYPE_DEMOBWFSTARTVIEW = "DEMOBWFSTARTVIEW";
    public static final String PSDEVIEWTYPE_DEMOBWFEDITVIEW3 = "DEMOBWFEDITVIEW3";
    public static final String PSDEVIEWTYPE_DEMOBTREEVIEW = "DEMOBTREEVIEW";
    public static final String PSDEVIEWTYPE_DEMOBWFEDITVIEW = "DEMOBWFEDITVIEW";
    public static final String PSDEVIEWTYPE_DEMOBWFACTIONVIEW = "DEMOBWFACTIONVIEW";
    public static final String PSDEVIEWTYPE_DEEDITVIEW9 = "DEEDITVIEW9";
    public static final String PSDEVIEWTYPE_DEDATAVIEW = "DEDATAVIEW";
    public static final String PSDEVIEWTYPE_DEINDEXPICKUPDATAVIEW = "DEINDEXPICKUPDATAVIEW";
    public static final String PSDEVIEWTYPE_DEFORMPICKUPDATAVIEW = "DEFORMPICKUPDATAVIEW";
    public static final String PSDEVIEWTYPE_DEPICKUPDATAVIEW = "DEPICKUPDATAVIEW";
    public static final String PSDEVIEWTYPE_DEWIZARDVIEW = "DEWIZARDVIEW";
    public static final String PSDEVIEWTYPE_DEMOBWIZARDVIEW = "DEMOBWIZARDVIEW";
    public static final String PSDEVIEWTYPE_DECALENDARVIEW9 = "DECALENDARVIEW9";
    public static final String PSDEVIEWTYPE_DEMOBCALENDARVIEW = "DEMOBCALENDARVIEW";
    public static final String PSDEVIEWTYPE_DEMOBCALENDARVIEW9 = "DEMOBCALENDARVIEW9";
    public static final String PSDEVIEWTYPE_DECALENDARVIEW = "DECALENDARVIEW";
    public static final String PSDEVIEWTYPE_DEMOBPANELVIEW = "DEMOBPANELVIEW";
    public static final String PSDEVIEWTYPE_DEMOBPANELVIEW9 = "DEMOBPANELVIEW9";
    public static final String PSDEVIEWTYPE_DEPANELVIEW = "DEPANELVIEW";
    public static final String PSDEVIEWTYPE_DEPANELVIEW9 = "DEPANELVIEW9";
    public static final String USERREFFLAG_1 = "1";
    public static final String USERREFFLAG_0 = "0";
    public static final String ACCUSERMODE_1 = "1";
    public static final String ACCUSERMODE_2 = "2";
    public static final String ACCUSERMODE_3 = "3";
    public static final String ACCUSERMODE_4 = "4";
    public static final String SYNCCODENAME_1 = "1";
    public static final String SYNCCODENAME_0 = "0";
    public static final String SHOWCAPTIONBAR_1 = "1";
    public static final String SHOWCAPTIONBAR_0 = "0";
    public static final String SYSREFFLAG_1 = "1";
    public static final String SYSREFFLAG_0 = "0";
    public static final String ENABLEVIEWSTYLE_1 = "1";
    public static final String ENABLEVIEWSTYLE_0 = "0";
    public static final String DYNCMODE_1 = "1";
    public static final String DYNCMODE_0 = "0";
    public static final String PREVENTXSS_1 = "1";
    public static final String PREVENTXSS_0 = "0";
    public static final String PSDYNADEVIEWTYPE_APPINDEXVIEW = "APPINDEXVIEW";
    public static final String PSDYNADEVIEWTYPE_APPPORTALVIEW = "APPPORTALVIEW";
    public static final String PSDYNADEVIEWTYPE_SUBSYSDEVIEW = "SUBSYSDEVIEW";
    public static final String PSDYNADEVIEWTYPE_DEMOBMPICKUPVIEW = "DEMOBMPICKUPVIEW";
    public static final String PSDYNADEVIEWTYPE_DETREEGRIDVIEW9 = "DETREEGRIDVIEW9";
    public static final String PSDYNADEVIEWTYPE_DETREEVIEW = "DETREEVIEW";
    public static final String PSDYNADEVIEWTYPE_DETREEVIEW9 = "DETREEVIEW9";
    public static final String PSDYNADEVIEWTYPE_DEMEDITVIEW9 = "DEMEDITVIEW9";
    public static final String PSDYNADEVIEWTYPE_DEPICKUPGRIDVIEW = "DEPICKUPGRIDVIEW";
    public static final String PSDYNADEVIEWTYPE_DETREEEXPVIEW2 = "DETREEEXPVIEW2";
    public static final String PSDYNADEVIEWTYPE_DETREEEXPVIEW = "DETREEEXPVIEW";
    public static final String PSDYNADEVIEWTYPE_DEMOBPICKUPVIEW = "DEMOBPICKUPVIEW";
    public static final String PSDYNADEVIEWTYPE_DETABEXPVIEW = "DETABEXPVIEW";
    public static final String PSDYNADEVIEWTYPE_DEMOBWFMDVIEW = "DEMOBWFMDVIEW";
    public static final String PSDYNADEVIEWTYPE_DEPICKUPVIEW2 = "DEPICKUPVIEW2";
    public static final String PSDYNADEVIEWTYPE_DEMPICKUPVIEW = "DEMPICKUPVIEW";
    public static final String PSDYNADEVIEWTYPE_DEMPICKUPVIEW2 = "DEMPICKUPVIEW2";
    public static final String PSDYNADEVIEWTYPE_DEPICKUPVIEW = "DEPICKUPVIEW";
    public static final String PSDYNADEVIEWTYPE_DEPICKUPTREEVIEW = "DEPICKUPTREEVIEW";
    public static final String PSDYNADEVIEWTYPE_DEWFEXPVIEW = "DEWFEXPVIEW";
    public static final String PSDYNADEVIEWTYPE_DEWFGRIDVIEW = "DEWFGRIDVIEW";
    public static final String PSDYNADEVIEWTYPE_DETREEEXPVIEW3 = "DETREEEXPVIEW3";
    public static final String PSDYNADEVIEWTYPE_DYNADEGRIDVIEW = "DYNADEGRIDVIEW";
    public static final String PSDYNADEVIEWTYPE_DEGRIDVIEW = "DEGRIDVIEW";
    public static final String PSDYNADEVIEWTYPE_DYNADEMPICKUPVIEW = "DYNADEMPICKUPVIEW";
    public static final String PSDYNADEVIEWTYPE_DEGRIDVIEW2 = "DEGRIDVIEW2";
    public static final String PSDYNADEVIEWTYPE_DEGRIDVIEW4 = "DEGRIDVIEW4";
    public static final String PSDYNADEVIEWTYPE_DYNADEMPICKUPVIEW2 = "DYNADEMPICKUPVIEW2";
    public static final String PSDYNADEVIEWTYPE_DEGRIDVIEW9 = "DEGRIDVIEW9";
    public static final String PSDYNADEVIEWTYPE_DYNADEPICKUPVIEW2 = "DYNADEPICKUPVIEW2";
    public static final String PSDYNADEVIEWTYPE_DEGRIDVIEW8 = "DEGRIDVIEW8";
    public static final String PSDYNADEVIEWTYPE_DYNADEPICKUPVIEW = "DYNADEPICKUPVIEW";
    public static final String PSDYNADEVIEWTYPE_DYNADEPICKUPGRIDVIEW = "DYNADEPICKUPGRIDVIEW";
    public static final String PSDYNADEVIEWTYPE_DEMOBTABEXPVIEW = "DEMOBTABEXPVIEW";
    public static final String PSDYNADEVIEWTYPE_DEMOBPICKUPTREEVIEW = "DEMOBPICKUPTREEVIEW";
    public static final String PSDYNADEVIEWTYPE_DEMOBPICKUPMDVIEW = "DEMOBPICKUPMDVIEW";
    public static final String PSDYNADEVIEWTYPE_DEMOBPICKUPLISTVIEW = "DEMOBPICKUPLISTVIEW";
    public static final String PSDYNADEVIEWTYPE_DEMOBINDEXPICKUPMDVIEW = "DEMOBINDEXPICKUPMDVIEW";
    public static final String PSDYNADEVIEWTYPE_DEMOBFORMPICKUPMDVIEW = "DEMOBFORMPICKUPMDVIEW";
    public static final String PSDYNADEVIEWTYPE_DYNADEEDITVIEW2 = "DYNADEEDITVIEW2";
    public static final String PSDYNADEVIEWTYPE_DEWFSTARTVIEW = "DEWFSTARTVIEW";
    public static final String PSDYNADEVIEWTYPE_DYNADEREDIRECTVIEW = "DYNADEREDIRECTVIEW";
    public static final String PSDYNADEVIEWTYPE_DEWFEDITVIEW2 = "DEWFEDITVIEW2";
    public static final String PSDYNADEVIEWTYPE_DEWFEDITVIEW = "DEWFEDITVIEW";
    public static final String PSDYNADEVIEWTYPE_DEWFDATAREDIRECTVIEW = "DEWFDATAREDIRECTVIEW";
    public static final String PSDYNADEVIEWTYPE_DEPORTALVIEW = "DEPORTALVIEW";
    public static final String PSDYNADEVIEWTYPE_DEWFACTIONVIEW = "DEWFACTIONVIEW";
    public static final String PSDYNADEVIEWTYPE_DEPORTALVIEW9 = "DEPORTALVIEW9";
    public static final String PSDYNADEVIEWTYPE_DEREDIRECTVIEW = "DEREDIRECTVIEW";
    public static final String PSDYNADEVIEWTYPE_DEREPORTVIEW = "DEREPORTVIEW";
    public static final String PSDYNADEVIEWTYPE_DEEDITVIEW4 = "DEEDITVIEW4";
    public static final String PSDYNADEVIEWTYPE_DEWFEDITVIEW3 = "DEWFEDITVIEW3";
    public static final String PSDYNADEVIEWTYPE_DYNADEEDITVIEW = "DYNADEEDITVIEW";
    public static final String PSDYNADEVIEWTYPE_DEMOBMDVIEW9 = "DEMOBMDVIEW9";
    public static final String PSDYNADEVIEWTYPE_DEEDITVIEW2 = "DEEDITVIEW2";
    public static final String PSDYNADEVIEWTYPE_DEMOBLISTVIEW = "DEMOBLISTVIEW";
    public static final String PSDYNADEVIEWTYPE_DEMOBEDITVIEW3 = "DEMOBEDITVIEW3";
    public static final String PSDYNADEVIEWTYPE_DEMOBEDITVIEW = "DEMOBEDITVIEW";
    public static final String PSDYNADEVIEWTYPE_DEMOBCUSTOMVIEW = "DEMOBCUSTOMVIEW";
    public static final String PSDYNADEVIEWTYPE_DEEDITVIEW = "DEEDITVIEW";
    public static final String PSDYNADEVIEWTYPE_DEMDCUSTOMVIEW = "DEMDCUSTOMVIEW";
    public static final String PSDYNADEVIEWTYPE_DEINDEXVIEW = "DEINDEXVIEW";
    public static final String PSDYNADEVIEWTYPE_DEHTMLVIEW = "DEHTMLVIEW";
    public static final String PSDYNADEVIEWTYPE_DEEDITVIEW3 = "DEEDITVIEW3";
    public static final String PSDYNADEVIEWTYPE_DEMOBMDVIEW = "DEMOBMDVIEW";
    public static final String PSDYNADEVIEWTYPE_DECUSTOMVIEW = "DECUSTOMVIEW";
    public static final String PSDYNADEVIEWTYPE_DECHARTVIEW9 = "DECHARTVIEW9";
    public static final String PSDYNADEVIEWTYPE_DECHARTVIEW = "DECHARTVIEW";
    public static final String PSDYNADEVIEWTYPE_DEOPTVIEW = "DEOPTVIEW";
    public static final String PSDYNADEVIEWTYPE_DEMOBWFSTARTVIEW = "DEMOBWFSTARTVIEW";
    public static final String PSDYNADEVIEWTYPE_DEMOBWFEDITVIEW3 = "DEMOBWFEDITVIEW3";
    public static final String PSDYNADEVIEWTYPE_DEMOBTREEVIEW = "DEMOBTREEVIEW";
    public static final String PSDYNADEVIEWTYPE_DEMOBWFEDITVIEW = "DEMOBWFEDITVIEW";
    public static final String PSDYNADEVIEWTYPE_DEMOBWFACTIONVIEW = "DEMOBWFACTIONVIEW";
    public static final String PSDYNADEVIEWTYPE_DEEDITVIEW9 = "DEEDITVIEW9";
    public static final String PSDYNADEVIEWTYPE_DEDATAVIEW = "DEDATAVIEW";
    public static final String PSDYNADEVIEWTYPE_DEINDEXPICKUPDATAVIEW = "DEINDEXPICKUPDATAVIEW";
    public static final String PSDYNADEVIEWTYPE_DEFORMPICKUPDATAVIEW = "DEFORMPICKUPDATAVIEW";
    public static final String PSDYNADEVIEWTYPE_DEPICKUPDATAVIEW = "DEPICKUPDATAVIEW";
    public static final String PSDYNADEVIEWTYPE_DEWIZARDVIEW = "DEWIZARDVIEW";
    public static final String PSDYNADEVIEWTYPE_DEMOBWIZARDVIEW = "DEMOBWIZARDVIEW";
    public static final String PSDYNADEVIEWTYPE_DECALENDARVIEW9 = "DECALENDARVIEW9";
    public static final String PSDYNADEVIEWTYPE_DEMOBCALENDARVIEW = "DEMOBCALENDARVIEW";
    public static final String PSDYNADEVIEWTYPE_DEMOBCALENDARVIEW9 = "DEMOBCALENDARVIEW9";
    public static final String PSDYNADEVIEWTYPE_DECALENDARVIEW = "DECALENDARVIEW";
    public static final String PSDYNADEVIEWTYPE_DEMOBPANELVIEW = "DEMOBPANELVIEW";
    public static final String PSDYNADEVIEWTYPE_DEMOBPANELVIEW9 = "DEMOBPANELVIEW9";
    public static final String PSDYNADEVIEWTYPE_DEPANELVIEW = "DEPANELVIEW";
    public static final String PSDYNADEVIEWTYPE_DEPANELVIEW9 = "DEPANELVIEW9";
    public static final String DYNAMODELFLAG_0 = "0";
    public static final String DYNAMODELFLAG_1 = "1";
    public static final String DYNAMODELFLAG_2 = "2";
    public static final String PSAPPUTILVIEWTYPE_APPSTARTVIEW = "APPSTARTVIEW";
    public static final String PSAPPUTILVIEWTYPE_APPLOGINVIEW = "APPLOGINVIEW";
    public static final String PSAPPUTILVIEWTYPE_APPLOGOUTVIEW = "APPLOGOUTVIEW";
    public static final String PSAPPUTILVIEWTYPE_APPFILEUPLOADVIEW = "APPFILEUPLOADVIEW";
    public static final String PSAPPUTILVIEWTYPE_APPPICUPLOADVIEW = "APPPICUPLOADVIEW";
    public static final String PSAPPUTILVIEWTYPE_APPDATAUPLOADVIEW = "APPDATAUPLOADVIEW";
    public static final String PSAPPUTILVIEWTYPE_APPFUNCPICKUPVIEW = "APPFUNCPICKUPVIEW";
    public static final String PSAPPUTILVIEWTYPE_APPERRORVIEW = "APPERRORVIEW";
    public static final String TAG_PSAPPUTILVIEWID = "PSAPPUTILVIEWID";
    public static final String TAG_PSAPPUTILVIEWNAME = "PSAPPUTILVIEWNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSSYSAPPID = "PSSYSAPPID";
    public static final String TAG_PSSYSAPPNAME = "PSSYSAPPNAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_PSAPPMODULEID = "PSAPPMODULEID";
    public static final String TAG_PSAPPMODULENAME = "PSAPPMODULENAME";
    public static final String TAG_PSSYSTEMID = "PSSYSTEMID";
    public static final String TAG_PSAPPVIEWSTYLEID = "PSAPPVIEWSTYLEID";
    public static final String TAG_PSAPPVIEWSTYLENAME = "PSAPPVIEWSTYLENAME";
    public static final String TAG_PSAPPVIEWTYPE = "PSAPPVIEWTYPE";
    public static final String TAG_PSDEVIEWBASEID = "PSDEVIEWBASEID";
    public static final String TAG_PSDEVIEWBASENAME = "PSDEVIEWBASENAME";
    public static final String TAG_PSDEVIEWTYPE = "PSDEVIEWTYPE";
    public static final String TAG_USERREFFLAG = "USERREFFLAG";
    public static final String TAG_CAPTION = "CAPTION";
    public static final String TAG_TITLE = "TITLE";
    public static final String TAG_SUBCAPTION = "SUBCAPTION";
    public static final String TAG_PSSUBVIEWTYPEID = "PSSUBVIEWTYPEID";
    public static final String TAG_PSSUBVIEWTYPENAME = "PSSUBVIEWTYPENAME";
    public static final String TAG_ACCUSERMODE = "ACCUSERMODE";
    public static final String TAG_PSSYSUNIRESID = "PSSYSUNIRESID";
    public static final String TAG_PSSYSUNIRESNAME = "PSSYSUNIRESNAME";
    public static final String TAG_USERPARAMS = "USERPARAMS";
    public static final String TAG_APPVIEWSN = "APPVIEWSN";
    public static final String TAG_PSVIEWMSGGROUPID = "PSVIEWMSGGROUPID";
    public static final String TAG_PSVIEWMSGGROUPNAME = "PSVIEWMSGGROUPNAME";
    public static final String TAG_PSPFSTYLEID = "PSPFSTYLEID";
    public static final String TAG_PSPFSTYLENAME = "PSPFSTYLENAME";
    public static final String TAG_PSPFID = "PSPFID";
    public static final String TAG_TODOTASK = "TODOTASK";
    public static final String TAG_SYNCCODENAME = "SYNCCODENAME";
    public static final String TAG_PSSYSREQITEMID = "PSSYSREQITEMID";
    public static final String TAG_PSSYSREQITEMNAME = "PSSYSREQITEMNAME";
    public static final String TAG_PSVIEWWIZARDGROUPID = "PSVIEWWIZARDGROUPID";
    public static final String TAG_PSVIEWWIZARDGROUPNAME = "PSVIEWWIZARDGROUPNAME";
    public static final String TAG_TITLEPSLANRESID = "TITLEPSLANRESID";
    public static final String TAG_TITLEPSLANRESNAME = "TITLEPSLANRESNAME";
    public static final String TAG_CAPPSLANRESID = "CAPPSLANRESID";
    public static final String TAG_CAPPSLANRESNAME = "CAPPSLANRESNAME";
    public static final String TAG_SUBCAPPSLANRESID = "SUBCAPPSLANRESID";
    public static final String TAG_SUBCAPPSLANRESNAME = "SUBCAPPSLANRESNAME";
    public static final String TAG_PSHELPMODULEID = "PSHELPMODULEID";
    public static final String TAG_PSHELPMODULENAME = "PSHELPMODULENAME";
    public static final String TAG_SHOWCAPTIONBAR = "SHOWCAPTIONBAR";
    public static final String TAG_SYSREFFLAG = "SYSREFFLAG";
    public static final String TAG_PSSYSIMAGEID = "PSSYSIMAGEID";
    public static final String TAG_PSSYSIMAGENAME = "PSSYSIMAGENAME";
    public static final String TAG_ENABLEVIEWSTYLE = "ENABLEVIEWSTYLE";
    public static final String TAG_PSVIEWENGINEID = "PSVIEWENGINEID";
    public static final String TAG_PSVIEWENGINENAME = "PSVIEWENGINENAME";
    public static final String TAG_DYNCMODE = "DYNCMODE";
    public static final String TAG_PREVENTXSS = "PREVENTXSS";
    public static final String TAG_PSAPPTITLEBARID = "PSAPPTITLEBARID";
    public static final String TAG_PSAPPTITLEBARNAME = "PSAPPTITLEBARNAME";
    public static final String TAG_PSSYSCSSID = "PSSYSCSSID";
    public static final String TAG_PSSYSCSSNAME = "PSSYSCSSNAME";
    public static final String TAG_PSSYSDYNAMODELID = "PSSYSDYNAMODELID";
    public static final String TAG_PSSYSDYNAMODELNAME = "PSSYSDYNAMODELNAME";
    public static final String TAG_PSACHANDLERID = "PSACHANDLERID";
    public static final String TAG_PSACHANDLERNAME = "PSACHANDLERNAME";
    public static final String TAG_COLOR = "COLOR";
    public static final String TAG_MODCOLOR = "MODCOLOR";
    public static final String TAG_PSSYSVIEWPANELID = "PSSYSVIEWPANELID";
    public static final String TAG_PSSYSVIEWPANELNAME = "PSSYSVIEWPANELNAME";
    public static final String TAG_PSDYNADEVIEWTEMPLID = "PSDYNADEVIEWTEMPLID";
    public static final String TAG_PSDYNADEVIEWTEMPLNAME = "PSDYNADEVIEWTEMPLNAME";
    public static final String TAG_PSDYNADEVIEWTYPE = "PSDYNADEVIEWTYPE";
    public static final String TAG_DYNAMODELFLAG = "DYNAMODELFLAG";
    public static final String TAG_PSDYNAINSTID = "PSDYNAINSTID";
    public static final String TAG_PSAPPUTILVIEWTYPE = "PSAPPUTILVIEWTYPE";
    public static final String TAG_PSAPPMENUID = "PSAPPMENUID";
    public static final String TAG_PSAPPMENUNAME = "PSAPPMENUNAME";
    public static final String TAG_ERRCODE = "ERRCODE";

    public final boolean isPSAPPUTILVIEWIDNull() {
        return this.IsParamNull(TAG_PSAPPUTILVIEWID);
    }

    public final String getPSAPPUTILVIEWID() {
        return this.GetParamStringValue(TAG_PSAPPUTILVIEWID, "");
    }

    public final void setPSAPPUTILVIEWID(String strValue) {
        this.SetParamValue(TAG_PSAPPUTILVIEWID, strValue);
    }

    public final boolean isPSAPPUTILVIEWNAMENull() {
        return this.IsParamNull(TAG_PSAPPUTILVIEWNAME);
    }

    public final String getPSAPPUTILVIEWNAME() {
        return this.GetParamStringValue(TAG_PSAPPUTILVIEWNAME, "");
    }

    public final void setPSAPPUTILVIEWNAME(String strValue) {
        this.SetParamValue(TAG_PSAPPUTILVIEWNAME, strValue);
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

    public final boolean isMEMONull() {
        return this.IsParamNull(TAG_MEMO);
    }

    public final String getMEMO() {
        return this.GetParamStringValue(TAG_MEMO, "");
    }

    public final void setMEMO(String strValue) {
        this.SetParamValue(TAG_MEMO, strValue);
    }

    public final boolean isPSAPPMODULEIDNull() {
        return this.IsParamNull(TAG_PSAPPMODULEID);
    }

    public final String getPSAPPMODULEID() {
        return this.GetParamStringValue(TAG_PSAPPMODULEID, "");
    }

    public final void setPSAPPMODULEID(String strValue) {
        this.SetParamValue(TAG_PSAPPMODULEID, strValue);
    }

    public final boolean isPSAPPMODULENAMENull() {
        return this.IsParamNull(TAG_PSAPPMODULENAME);
    }

    public final String getPSAPPMODULENAME() {
        return this.GetParamStringValue(TAG_PSAPPMODULENAME, "");
    }

    public final void setPSAPPMODULENAME(String strValue) {
        this.SetParamValue(TAG_PSAPPMODULENAME, strValue);
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

    public final boolean isPSAPPVIEWSTYLEIDNull() {
        return this.IsParamNull(TAG_PSAPPVIEWSTYLEID);
    }

    public final String getPSAPPVIEWSTYLEID() {
        return this.GetParamStringValue(TAG_PSAPPVIEWSTYLEID, "");
    }

    public final void setPSAPPVIEWSTYLEID(String strValue) {
        this.SetParamValue(TAG_PSAPPVIEWSTYLEID, strValue);
    }

    public final boolean isPSAPPVIEWSTYLENAMENull() {
        return this.IsParamNull(TAG_PSAPPVIEWSTYLENAME);
    }

    public final String getPSAPPVIEWSTYLENAME() {
        return this.GetParamStringValue(TAG_PSAPPVIEWSTYLENAME, "");
    }

    public final void setPSAPPVIEWSTYLENAME(String strValue) {
        this.SetParamValue(TAG_PSAPPVIEWSTYLENAME, strValue);
    }

    public final boolean isPSAPPVIEWTYPENull() {
        return this.IsParamNull(TAG_PSAPPVIEWTYPE);
    }

    public final String getPSAPPVIEWTYPE() {
        return this.GetParamStringValue(TAG_PSAPPVIEWTYPE, "");
    }

    public final void setPSAPPVIEWTYPE(String strValue) {
        this.SetParamValue(TAG_PSAPPVIEWTYPE, strValue);
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

    public final boolean isPSDEVIEWTYPENull() {
        return this.IsParamNull(TAG_PSDEVIEWTYPE);
    }

    public final String getPSDEVIEWTYPE() {
        return this.GetParamStringValue(TAG_PSDEVIEWTYPE, "");
    }

    public final void setPSDEVIEWTYPE(String strValue) {
        this.SetParamValue(TAG_PSDEVIEWTYPE, strValue);
    }

    public final boolean isUSERREFFLAGNull() {
        return this.IsParamNull(TAG_USERREFFLAG);
    }

    public final boolean getUSERREFFLAG() {
        return this.GetParamIntValue(TAG_USERREFFLAG, 0) == 1;
    }

    public final void setUSERREFFLAG(boolean bValue) {
        this.SetParamValue(TAG_USERREFFLAG, bValue ? 1 : 0);
    }

    public final boolean isCAPTIONNull() {
        return this.IsParamNull(TAG_CAPTION);
    }

    public final String getCAPTION() {
        return this.GetParamStringValue(TAG_CAPTION, "");
    }

    public final void setCAPTION(String strValue) {
        this.SetParamValue(TAG_CAPTION, strValue);
    }

    public final boolean isTITLENull() {
        return this.IsParamNull(TAG_TITLE);
    }

    public final String getTITLE() {
        return this.GetParamStringValue(TAG_TITLE, "");
    }

    public final void setTITLE(String strValue) {
        this.SetParamValue(TAG_TITLE, strValue);
    }

    public final boolean isSUBCAPTIONNull() {
        return this.IsParamNull(TAG_SUBCAPTION);
    }

    public final String getSUBCAPTION() {
        return this.GetParamStringValue(TAG_SUBCAPTION, "");
    }

    public final void setSUBCAPTION(String strValue) {
        this.SetParamValue(TAG_SUBCAPTION, strValue);
    }

    public final boolean isPSSUBVIEWTYPEIDNull() {
        return this.IsParamNull(TAG_PSSUBVIEWTYPEID);
    }

    public final String getPSSUBVIEWTYPEID() {
        return this.GetParamStringValue(TAG_PSSUBVIEWTYPEID, "");
    }

    public final void setPSSUBVIEWTYPEID(String strValue) {
        this.SetParamValue(TAG_PSSUBVIEWTYPEID, strValue);
    }

    public final boolean isPSSUBVIEWTYPENAMENull() {
        return this.IsParamNull(TAG_PSSUBVIEWTYPENAME);
    }

    public final String getPSSUBVIEWTYPENAME() {
        return this.GetParamStringValue(TAG_PSSUBVIEWTYPENAME, "");
    }

    public final void setPSSUBVIEWTYPENAME(String strValue) {
        this.SetParamValue(TAG_PSSUBVIEWTYPENAME, strValue);
    }

    public final boolean isACCUSERMODENull() {
        return this.IsParamNull(TAG_ACCUSERMODE);
    }

    public final String getACCUSERMODE() {
        return this.GetParamStringValue(TAG_ACCUSERMODE, "");
    }

    public final void setACCUSERMODE(String strValue) {
        this.SetParamValue(TAG_ACCUSERMODE, strValue);
    }

    public final boolean isPSSYSUNIRESIDNull() {
        return this.IsParamNull(TAG_PSSYSUNIRESID);
    }

    public final String getPSSYSUNIRESID() {
        return this.GetParamStringValue(TAG_PSSYSUNIRESID, "");
    }

    public final void setPSSYSUNIRESID(String strValue) {
        this.SetParamValue(TAG_PSSYSUNIRESID, strValue);
    }

    public final boolean isPSSYSUNIRESNAMENull() {
        return this.IsParamNull(TAG_PSSYSUNIRESNAME);
    }

    public final String getPSSYSUNIRESNAME() {
        return this.GetParamStringValue(TAG_PSSYSUNIRESNAME, "");
    }

    public final void setPSSYSUNIRESNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSUNIRESNAME, strValue);
    }

    public final boolean isUSERPARAMSNull() {
        return this.IsParamNull(TAG_USERPARAMS);
    }

    public final String getUSERPARAMS() {
        return this.GetParamStringValue(TAG_USERPARAMS, "");
    }

    public final void setUSERPARAMS(String strValue) {
        this.SetParamValue(TAG_USERPARAMS, strValue);
    }

    public final boolean isAPPVIEWSNNull() {
        return this.IsParamNull(TAG_APPVIEWSN);
    }

    public final String getAPPVIEWSN() {
        return this.GetParamStringValue(TAG_APPVIEWSN, "");
    }

    public final void setAPPVIEWSN(String strValue) {
        this.SetParamValue(TAG_APPVIEWSN, strValue);
    }

    public final boolean isPSVIEWMSGGROUPIDNull() {
        return this.IsParamNull(TAG_PSVIEWMSGGROUPID);
    }

    public final String getPSVIEWMSGGROUPID() {
        return this.GetParamStringValue(TAG_PSVIEWMSGGROUPID, "");
    }

    public final void setPSVIEWMSGGROUPID(String strValue) {
        this.SetParamValue(TAG_PSVIEWMSGGROUPID, strValue);
    }

    public final boolean isPSVIEWMSGGROUPNAMENull() {
        return this.IsParamNull(TAG_PSVIEWMSGGROUPNAME);
    }

    public final String getPSVIEWMSGGROUPNAME() {
        return this.GetParamStringValue(TAG_PSVIEWMSGGROUPNAME, "");
    }

    public final void setPSVIEWMSGGROUPNAME(String strValue) {
        this.SetParamValue(TAG_PSVIEWMSGGROUPNAME, strValue);
    }

    public final boolean isPSPFSTYLEIDNull() {
        return this.IsParamNull(TAG_PSPFSTYLEID);
    }

    public final String getPSPFSTYLEID() {
        return this.GetParamStringValue(TAG_PSPFSTYLEID, "");
    }

    public final void setPSPFSTYLEID(String strValue) {
        this.SetParamValue(TAG_PSPFSTYLEID, strValue);
    }

    public final boolean isPSPFSTYLENAMENull() {
        return this.IsParamNull(TAG_PSPFSTYLENAME);
    }

    public final String getPSPFSTYLENAME() {
        return this.GetParamStringValue(TAG_PSPFSTYLENAME, "");
    }

    public final void setPSPFSTYLENAME(String strValue) {
        this.SetParamValue(TAG_PSPFSTYLENAME, strValue);
    }

    public final boolean isPSPFIDNull() {
        return this.IsParamNull(TAG_PSPFID);
    }

    public final String getPSPFID() {
        return this.GetParamStringValue(TAG_PSPFID, "");
    }

    public final void setPSPFID(String strValue) {
        this.SetParamValue(TAG_PSPFID, strValue);
    }

    public final boolean isTODOTASKNull() {
        return this.IsParamNull(TAG_TODOTASK);
    }

    public final String getTODOTASK() {
        return this.GetParamStringValue(TAG_TODOTASK, "");
    }

    public final void setTODOTASK(String strValue) {
        this.SetParamValue(TAG_TODOTASK, strValue);
    }

    public final boolean isSYNCCODENAMENull() {
        return this.IsParamNull(TAG_SYNCCODENAME);
    }

    public final boolean getSYNCCODENAME() {
        return this.GetParamIntValue(TAG_SYNCCODENAME, 0) == 1;
    }

    public final void setSYNCCODENAME(boolean bValue) {
        this.SetParamValue(TAG_SYNCCODENAME, bValue ? 1 : 0);
    }

    public final boolean isPSSYSREQITEMIDNull() {
        return this.IsParamNull(TAG_PSSYSREQITEMID);
    }

    public final String getPSSYSREQITEMID() {
        return this.GetParamStringValue(TAG_PSSYSREQITEMID, "");
    }

    public final void setPSSYSREQITEMID(String strValue) {
        this.SetParamValue(TAG_PSSYSREQITEMID, strValue);
    }

    public final boolean isPSSYSREQITEMNAMENull() {
        return this.IsParamNull(TAG_PSSYSREQITEMNAME);
    }

    public final String getPSSYSREQITEMNAME() {
        return this.GetParamStringValue(TAG_PSSYSREQITEMNAME, "");
    }

    public final void setPSSYSREQITEMNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSREQITEMNAME, strValue);
    }

    public final boolean isPSVIEWWIZARDGROUPIDNull() {
        return this.IsParamNull(TAG_PSVIEWWIZARDGROUPID);
    }

    public final String getPSVIEWWIZARDGROUPID() {
        return this.GetParamStringValue(TAG_PSVIEWWIZARDGROUPID, "");
    }

    public final void setPSVIEWWIZARDGROUPID(String strValue) {
        this.SetParamValue(TAG_PSVIEWWIZARDGROUPID, strValue);
    }

    public final boolean isPSVIEWWIZARDGROUPNAMENull() {
        return this.IsParamNull(TAG_PSVIEWWIZARDGROUPNAME);
    }

    public final String getPSVIEWWIZARDGROUPNAME() {
        return this.GetParamStringValue(TAG_PSVIEWWIZARDGROUPNAME, "");
    }

    public final void setPSVIEWWIZARDGROUPNAME(String strValue) {
        this.SetParamValue(TAG_PSVIEWWIZARDGROUPNAME, strValue);
    }

    public final boolean isTITLEPSLANRESIDNull() {
        return this.IsParamNull(TAG_TITLEPSLANRESID);
    }

    public final String getTITLEPSLANRESID() {
        return this.GetParamStringValue(TAG_TITLEPSLANRESID, "");
    }

    public final void setTITLEPSLANRESID(String strValue) {
        this.SetParamValue(TAG_TITLEPSLANRESID, strValue);
    }

    public final boolean isTITLEPSLANRESNAMENull() {
        return this.IsParamNull(TAG_TITLEPSLANRESNAME);
    }

    public final String getTITLEPSLANRESNAME() {
        return this.GetParamStringValue(TAG_TITLEPSLANRESNAME, "");
    }

    public final void setTITLEPSLANRESNAME(String strValue) {
        this.SetParamValue(TAG_TITLEPSLANRESNAME, strValue);
    }

    public final boolean isCAPPSLANRESIDNull() {
        return this.IsParamNull(TAG_CAPPSLANRESID);
    }

    public final String getCAPPSLANRESID() {
        return this.GetParamStringValue(TAG_CAPPSLANRESID, "");
    }

    public final void setCAPPSLANRESID(String strValue) {
        this.SetParamValue(TAG_CAPPSLANRESID, strValue);
    }

    public final boolean isCAPPSLANRESNAMENull() {
        return this.IsParamNull(TAG_CAPPSLANRESNAME);
    }

    public final String getCAPPSLANRESNAME() {
        return this.GetParamStringValue(TAG_CAPPSLANRESNAME, "");
    }

    public final void setCAPPSLANRESNAME(String strValue) {
        this.SetParamValue(TAG_CAPPSLANRESNAME, strValue);
    }

    public final boolean isSUBCAPPSLANRESIDNull() {
        return this.IsParamNull(TAG_SUBCAPPSLANRESID);
    }

    public final String getSUBCAPPSLANRESID() {
        return this.GetParamStringValue(TAG_SUBCAPPSLANRESID, "");
    }

    public final void setSUBCAPPSLANRESID(String strValue) {
        this.SetParamValue(TAG_SUBCAPPSLANRESID, strValue);
    }

    public final boolean isSUBCAPPSLANRESNAMENull() {
        return this.IsParamNull(TAG_SUBCAPPSLANRESNAME);
    }

    public final String getSUBCAPPSLANRESNAME() {
        return this.GetParamStringValue(TAG_SUBCAPPSLANRESNAME, "");
    }

    public final void setSUBCAPPSLANRESNAME(String strValue) {
        this.SetParamValue(TAG_SUBCAPPSLANRESNAME, strValue);
    }

    public final boolean isPSHELPMODULEIDNull() {
        return this.IsParamNull(TAG_PSHELPMODULEID);
    }

    public final String getPSHELPMODULEID() {
        return this.GetParamStringValue(TAG_PSHELPMODULEID, "");
    }

    public final void setPSHELPMODULEID(String strValue) {
        this.SetParamValue(TAG_PSHELPMODULEID, strValue);
    }

    public final boolean isPSHELPMODULENAMENull() {
        return this.IsParamNull(TAG_PSHELPMODULENAME);
    }

    public final String getPSHELPMODULENAME() {
        return this.GetParamStringValue(TAG_PSHELPMODULENAME, "");
    }

    public final void setPSHELPMODULENAME(String strValue) {
        this.SetParamValue(TAG_PSHELPMODULENAME, strValue);
    }

    public final boolean isSHOWCAPTIONBARNull() {
        return this.IsParamNull(TAG_SHOWCAPTIONBAR);
    }

    public final boolean getSHOWCAPTIONBAR() {
        return this.GetParamIntValue(TAG_SHOWCAPTIONBAR, 0) == 1;
    }

    public final void setSHOWCAPTIONBAR(boolean bValue) {
        this.SetParamValue(TAG_SHOWCAPTIONBAR, bValue ? 1 : 0);
    }

    public final boolean isSYSREFFLAGNull() {
        return this.IsParamNull(TAG_SYSREFFLAG);
    }

    public final boolean getSYSREFFLAG() {
        return this.GetParamIntValue(TAG_SYSREFFLAG, 0) == 1;
    }

    public final void setSYSREFFLAG(boolean bValue) {
        this.SetParamValue(TAG_SYSREFFLAG, bValue ? 1 : 0);
    }

    public final boolean isPSSYSIMAGEIDNull() {
        return this.IsParamNull(TAG_PSSYSIMAGEID);
    }

    public final String getPSSYSIMAGEID() {
        return this.GetParamStringValue(TAG_PSSYSIMAGEID, "");
    }

    public final void setPSSYSIMAGEID(String strValue) {
        this.SetParamValue(TAG_PSSYSIMAGEID, strValue);
    }

    public final boolean isPSSYSIMAGENAMENull() {
        return this.IsParamNull(TAG_PSSYSIMAGENAME);
    }

    public final String getPSSYSIMAGENAME() {
        return this.GetParamStringValue(TAG_PSSYSIMAGENAME, "");
    }

    public final void setPSSYSIMAGENAME(String strValue) {
        this.SetParamValue(TAG_PSSYSIMAGENAME, strValue);
    }

    public final boolean isENABLEVIEWSTYLENull() {
        return this.IsParamNull(TAG_ENABLEVIEWSTYLE);
    }

    public final boolean getENABLEVIEWSTYLE() {
        return this.GetParamIntValue(TAG_ENABLEVIEWSTYLE, 0) == 1;
    }

    public final void setENABLEVIEWSTYLE(boolean bValue) {
        this.SetParamValue(TAG_ENABLEVIEWSTYLE, bValue ? 1 : 0);
    }

    public final boolean isPSVIEWENGINEIDNull() {
        return this.IsParamNull(TAG_PSVIEWENGINEID);
    }

    public final String getPSVIEWENGINEID() {
        return this.GetParamStringValue(TAG_PSVIEWENGINEID, "");
    }

    public final void setPSVIEWENGINEID(String strValue) {
        this.SetParamValue(TAG_PSVIEWENGINEID, strValue);
    }

    public final boolean isPSVIEWENGINENAMENull() {
        return this.IsParamNull(TAG_PSVIEWENGINENAME);
    }

    public final String getPSVIEWENGINENAME() {
        return this.GetParamStringValue(TAG_PSVIEWENGINENAME, "");
    }

    public final void setPSVIEWENGINENAME(String strValue) {
        this.SetParamValue(TAG_PSVIEWENGINENAME, strValue);
    }

    public final boolean isDYNCMODENull() {
        return this.IsParamNull(TAG_DYNCMODE);
    }

    public final boolean getDYNCMODE() {
        return this.GetParamIntValue(TAG_DYNCMODE, 0) == 1;
    }

    public final void setDYNCMODE(boolean bValue) {
        this.SetParamValue(TAG_DYNCMODE, bValue ? 1 : 0);
    }

    public final boolean isPREVENTXSSNull() {
        return this.IsParamNull(TAG_PREVENTXSS);
    }

    public final boolean getPREVENTXSS() {
        return this.GetParamIntValue(TAG_PREVENTXSS, 0) == 1;
    }

    public final void setPREVENTXSS(boolean bValue) {
        this.SetParamValue(TAG_PREVENTXSS, bValue ? 1 : 0);
    }

    public final boolean isPSAPPTITLEBARIDNull() {
        return this.IsParamNull(TAG_PSAPPTITLEBARID);
    }

    public final String getPSAPPTITLEBARID() {
        return this.GetParamStringValue(TAG_PSAPPTITLEBARID, "");
    }

    public final void setPSAPPTITLEBARID(String strValue) {
        this.SetParamValue(TAG_PSAPPTITLEBARID, strValue);
    }

    public final boolean isPSAPPTITLEBARNAMENull() {
        return this.IsParamNull(TAG_PSAPPTITLEBARNAME);
    }

    public final String getPSAPPTITLEBARNAME() {
        return this.GetParamStringValue(TAG_PSAPPTITLEBARNAME, "");
    }

    public final void setPSAPPTITLEBARNAME(String strValue) {
        this.SetParamValue(TAG_PSAPPTITLEBARNAME, strValue);
    }

    public final boolean isPSSYSCSSIDNull() {
        return this.IsParamNull(TAG_PSSYSCSSID);
    }

    public final String getPSSYSCSSID() {
        return this.GetParamStringValue(TAG_PSSYSCSSID, "");
    }

    public final void setPSSYSCSSID(String strValue) {
        this.SetParamValue(TAG_PSSYSCSSID, strValue);
    }

    public final boolean isPSSYSCSSNAMENull() {
        return this.IsParamNull(TAG_PSSYSCSSNAME);
    }

    public final String getPSSYSCSSNAME() {
        return this.GetParamStringValue(TAG_PSSYSCSSNAME, "");
    }

    public final void setPSSYSCSSNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSCSSNAME, strValue);
    }

    public final boolean isPSSYSDYNAMODELIDNull() {
        return this.IsParamNull(TAG_PSSYSDYNAMODELID);
    }

    public final String getPSSYSDYNAMODELID() {
        return this.GetParamStringValue(TAG_PSSYSDYNAMODELID, "");
    }

    public final void setPSSYSDYNAMODELID(String strValue) {
        this.SetParamValue(TAG_PSSYSDYNAMODELID, strValue);
    }

    public final boolean isPSSYSDYNAMODELNAMENull() {
        return this.IsParamNull(TAG_PSSYSDYNAMODELNAME);
    }

    public final String getPSSYSDYNAMODELNAME() {
        return this.GetParamStringValue(TAG_PSSYSDYNAMODELNAME, "");
    }

    public final void setPSSYSDYNAMODELNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSDYNAMODELNAME, strValue);
    }

    public final boolean isPSACHANDLERIDNull() {
        return this.IsParamNull(TAG_PSACHANDLERID);
    }

    public final String getPSACHANDLERID() {
        return this.GetParamStringValue(TAG_PSACHANDLERID, "");
    }

    public final void setPSACHANDLERID(String strValue) {
        this.SetParamValue(TAG_PSACHANDLERID, strValue);
    }

    public final boolean isPSACHANDLERNAMENull() {
        return this.IsParamNull(TAG_PSACHANDLERNAME);
    }

    public final String getPSACHANDLERNAME() {
        return this.GetParamStringValue(TAG_PSACHANDLERNAME, "");
    }

    public final void setPSACHANDLERNAME(String strValue) {
        this.SetParamValue(TAG_PSACHANDLERNAME, strValue);
    }

    public final boolean isCOLORNull() {
        return this.IsParamNull(TAG_COLOR);
    }

    public final String getCOLOR() {
        return this.GetParamStringValue(TAG_COLOR, "");
    }

    public final void setCOLOR(String strValue) {
        this.SetParamValue(TAG_COLOR, strValue);
    }

    public final boolean isMODCOLORNull() {
        return this.IsParamNull(TAG_MODCOLOR);
    }

    public final String getMODCOLOR() {
        return this.GetParamStringValue(TAG_MODCOLOR, "");
    }

    public final void setMODCOLOR(String strValue) {
        this.SetParamValue(TAG_MODCOLOR, strValue);
    }

    public final boolean isPSSYSVIEWPANELIDNull() {
        return this.IsParamNull(TAG_PSSYSVIEWPANELID);
    }

    public final String getPSSYSVIEWPANELID() {
        return this.GetParamStringValue(TAG_PSSYSVIEWPANELID, "");
    }

    public final void setPSSYSVIEWPANELID(String strValue) {
        this.SetParamValue(TAG_PSSYSVIEWPANELID, strValue);
    }

    public final boolean isPSSYSVIEWPANELNAMENull() {
        return this.IsParamNull(TAG_PSSYSVIEWPANELNAME);
    }

    public final String getPSSYSVIEWPANELNAME() {
        return this.GetParamStringValue(TAG_PSSYSVIEWPANELNAME, "");
    }

    public final void setPSSYSVIEWPANELNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSVIEWPANELNAME, strValue);
    }

    public final boolean isPSDYNADEVIEWTEMPLIDNull() {
        return this.IsParamNull(TAG_PSDYNADEVIEWTEMPLID);
    }

    public final String getPSDYNADEVIEWTEMPLID() {
        return this.GetParamStringValue(TAG_PSDYNADEVIEWTEMPLID, "");
    }

    public final void setPSDYNADEVIEWTEMPLID(String strValue) {
        this.SetParamValue(TAG_PSDYNADEVIEWTEMPLID, strValue);
    }

    public final boolean isPSDYNADEVIEWTEMPLNAMENull() {
        return this.IsParamNull(TAG_PSDYNADEVIEWTEMPLNAME);
    }

    public final String getPSDYNADEVIEWTEMPLNAME() {
        return this.GetParamStringValue(TAG_PSDYNADEVIEWTEMPLNAME, "");
    }

    public final void setPSDYNADEVIEWTEMPLNAME(String strValue) {
        this.SetParamValue(TAG_PSDYNADEVIEWTEMPLNAME, strValue);
    }

    public final boolean isPSDYNADEVIEWTYPENull() {
        return this.IsParamNull(TAG_PSDYNADEVIEWTYPE);
    }

    public final String getPSDYNADEVIEWTYPE() {
        return this.GetParamStringValue(TAG_PSDYNADEVIEWTYPE, "");
    }

    public final void setPSDYNADEVIEWTYPE(String strValue) {
        this.SetParamValue(TAG_PSDYNADEVIEWTYPE, strValue);
    }

    public final boolean isDYNAMODELFLAGNull() {
        return this.IsParamNull(TAG_DYNAMODELFLAG);
    }

    public final int getDYNAMODELFLAG() {
        return this.GetParamIntValue(TAG_DYNAMODELFLAG, 0);
    }

    public final void setDYNAMODELFLAG(int nValue) {
        this.SetParamValue(TAG_DYNAMODELFLAG, nValue);
    }

    public final boolean isPSDYNAINSTIDNull() {
        return this.IsParamNull(TAG_PSDYNAINSTID);
    }

    public final String getPSDYNAINSTID() {
        return this.GetParamStringValue(TAG_PSDYNAINSTID, "");
    }

    public final void setPSDYNAINSTID(String strValue) {
        this.SetParamValue(TAG_PSDYNAINSTID, strValue);
    }

    public final boolean isPSAPPUTILVIEWTYPENull() {
        return this.IsParamNull(TAG_PSAPPUTILVIEWTYPE);
    }

    public final String getPSAPPUTILVIEWTYPE() {
        return this.GetParamStringValue(TAG_PSAPPUTILVIEWTYPE, "");
    }

    public final void setPSAPPUTILVIEWTYPE(String strValue) {
        this.SetParamValue(TAG_PSAPPUTILVIEWTYPE, strValue);
    }

    public final boolean isPSAPPMENUIDNull() {
        return this.IsParamNull(TAG_PSAPPMENUID);
    }

    public final String getPSAPPMENUID() {
        return this.GetParamStringValue(TAG_PSAPPMENUID, "");
    }

    public final void setPSAPPMENUID(String strValue) {
        this.SetParamValue(TAG_PSAPPMENUID, strValue);
    }

    public final boolean isPSAPPMENUNAMENull() {
        return this.IsParamNull(TAG_PSAPPMENUNAME);
    }

    public final String getPSAPPMENUNAME() {
        return this.GetParamStringValue(TAG_PSAPPMENUNAME, "");
    }

    public final void setPSAPPMENUNAME(String strValue) {
        this.SetParamValue(TAG_PSAPPMENUNAME, strValue);
    }

    public final boolean isERRCODENull() {
        return this.IsParamNull(TAG_ERRCODE);
    }

    public final String getERRCODE() {
        return this.GetParamStringValue(TAG_ERRCODE, "");
    }

    public final void setERRCODE(String strValue) {
        this.SetParamValue(TAG_ERRCODE, strValue);
    }
}

