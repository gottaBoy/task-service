/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.BaseDEDataCtrl
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFDA.Web.ISRFDAWebContext
 *  SA.SRFDA.Web.SRFDAPage
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Data.CallParam
 *  SA.SRFramework.Data.DataTypeParse
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.DateParser
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  SA.SRFramework.Web.WebUtility
 *  SA.SRFramework.WebEx.SRFExAjaxActionResultEx
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.CAL.Web;

import SA.SRFDA.CAL.Ctrl.CalScheduleHelper;
import SA.SRFDA.CAL.Ctrl.Data.Calendar;
import SA.SRFDA.CAL.Ctrl.Data.CalendarType;
import SA.SRFDA.Ctrl.BaseDEDataCtrl;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFDA.Web.SRFDAPage;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Data.CallParam;
import SA.SRFramework.Data.DataTypeParse;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.DateParser;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.Web.WebUtility;
import SA.SRFramework.WebEx.SRFExAjaxActionResultEx;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class CalendarDataPage
extends SRFDAPage {
    public static final String TAG_ACTION_FETCHEVENT = "FETCHEVENT";
    public static final String TAG_ACTION_ADDEVENT = "ADDEVENT";
    public static final String TAG_ACTION_DELEVENT = "DELEVENT";
    public static final String TAG_ACTION_EDITEVENT = "EDITEVENT";
    private static final Log log = LogFactory.getLog(CalendarDataPage.class);
    protected IDEDataCtrl iDEDataCtrl = null;

    public CalendarDataPage() {
        this.setMainPage(true);
        this.setOutputDebug(false);
    }

    protected boolean PreparePageEnv() {
        if (!super.PreparePageEnv()) {
            return false;
        }
        this.strPageDataEntityId = "DE0050";
        if (!this.LoadPageDataEntity()) {
            return false;
        }
        if (!StringHelper.IsNullOrEmpty((String)this.getPageModel())) {
            this.getResponse().setContentType("text/html; charset=UTF-8");
        }
        this.iDEDataCtrl = this.getDEHelper().GetDEDataCtrl("", (ISRFDAWebContext)this.getWebContext());
        if (this.iDEDataCtrl == null) {
            this.PageLog((Object)this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u64cd\u4f5c\u5bf9\u8c61", (Object)"DE0050"));
            return false;
        }
        return true;
    }

    protected void OnInitBackEnd() {
        super.OnInitBackEnd();
        if (StringHelper.Compare((String)this.strPageModel, (String)"SL", (boolean)true) == 0) {
            this.getResponse().setContentType("text/xml; charset=UTF-8");
        }
    }

    protected void OnLoadBackEnd() {
        String strAction = this.getWebContext().getAction();
        if (StringHelper.Compare((String)strAction, (String)TAG_ACTION_ADDEVENT, (boolean)true) == 0) {
            this.OnAddEvent();
            return;
        }
        if (StringHelper.Compare((String)strAction, (String)TAG_ACTION_EDITEVENT, (boolean)true) == 0) {
            this.OnEditEvent();
            return;
        }
        if (StringHelper.Compare((String)strAction, (String)TAG_ACTION_DELEVENT, (boolean)true) == 0) {
            this.OnDeleletEvent();
            return;
        }
        if (StringHelper.Compare((String)strAction, (String)TAG_ACTION_FETCHEVENT, (boolean)true) == 0) {
            this.OnFetchEvent();
            return;
        }
    }

    protected void OnFetchEvent() {
        String strFromDate = this.getWebContext().GetParamValue("FROM");
        String strToDate = this.getWebContext().GetParamValue("TO");
        String strCalendarGroup = this.getWebContext().GetParamValue("CALENDARGROUP");
        Object beginTime = DataTypeParse.TestDateTime((String)strFromDate);
        Object EndTime = DataTypeParse.TestDateTime((String)strToDate);
        if (this.getWebContext().getWebExConfig().GetValue("SRFCAL", "CALSEQ", false)) {
            CalScheduleHelper calSecheduleHelper = new CalScheduleHelper((ISRFDAGlobalHelper)this.getWebContext().getGlobalHelper());
            calSecheduleHelper.CreateCalendar(strCalendarGroup, (Timestamp)beginTime, (Timestamp)EndTime);
        }
        Vector<CallParam> params = new Vector<CallParam>();
        params.add(new CallParam((Object)this.getWebContext().getCurUserId()));
        params.add(new CallParam(beginTime));
        params.add(new CallParam(beginTime));
        params.add(new CallParam(beginTime));
        params.add(new CallParam(EndTime));
        if (!StringHelper.IsNullOrEmpty((String)strCalendarGroup)) {
            params.add(new CallParam((Object)strCalendarGroup));
        }
        String strSql = "";
        strSql = StringHelper.IsNullOrEmpty((String)strCalendarGroup) ? "select * from  v_SRFCalendar WHERE ENABLE=1 AND (CALSEQID IS NULL OR  CALENDARID <> CALSEQID ) AND  OWNERID=? AND ((BEGINTIME<? AND ENDTIME>? ) OR (BEGINTIME>=? AND BEGINTIME<? )) ORDER BY BEGINTIME" : "select * from  v_SRFCalendar WHERE ENABLE =1 AND (CALSEQID IS NULL OR  CALENDARID <> CALSEQID ) AND  OWNERID=? AND ((BEGINTIME<? AND ENDTIME>? ) OR (BEGINTIME>=? AND BEGINTIME<? )) AND CALENDARGROUP=? ORDER BY BEGINTIME";
        Vector list = new Vector();
        CallResult callResult = BaseDEDataCtrl.SelectMulti((ISRFDAGlobalHelper)this.getWebContext().getGlobalHelper(), (String)strSql, params, list, (String)Calendar.class.getName());
        if (callResult.getRetCode() == 0) {
            StringBuilderEx sb = new StringBuilderEx();
            sb.Append("<data>");
            for (Calendar calendar : list) {
                sb.Append("<event id=\"%1$s\">", (Object)calendar.getCALENDARID());
                sb.Append("<start_date><![CDATA[%1$s]]></start_date>", (Object)DateParser.toDateTimeString((Date)calendar.getBEGINTIME()));
                sb.Append("<end_date><![CDATA[%1$s]]></end_date>", (Object)DateParser.toDateTimeString((Date)calendar.getENDTIME()));
                if (StringHelper.IsNullOrEmpty((String)this.strPageModel)) {
                    sb.Append("<text><![CDATA[%1$s]]></text>", (Object)(String.valueOf(WebUtility.TextToHTML((String)calendar.getCALENDARNAME())) + "<BR>" + WebUtility.TextToHTML((String)calendar.getCONTENT())));
                } else {
                    sb.Append("<text><![CDATA[%1$s]]></text>", (Object)calendar.getCALENDARNAME());
                }
                sb.Append("<details><![CDATA[%1$s]]></details>", (Object)calendar.getCONTENT());
                sb.Append("<caltype><![CDATA[%1$s]]></caltype>", (Object)calendar.getCALENDARTYPEID());
                sb.Append("<calseqid><![CDATA[%1$s]]></calseqid>", (Object)calendar.getCALSEQID());
                sb.Append("</event>");
            }
            sb.Append("</data>");
            String strOutput = sb.toString();
            this.Output(strOutput);
        }
    }

    protected void OnAddEvent() {
        SRFExAjaxActionResultEx actionResult = new SRFExAjaxActionResultEx();
        String strEventName = this.getWebContext().GetPostValue("text");
        String strStartTime = this.getWebContext().GetPostValue("starttime");
        String strEndTime = this.getWebContext().GetPostValue("endtime");
        String strCalType = this.getWebContext().GetPostValue("caltype");
        Timestamp dtStartTime = new Timestamp(Long.parseLong(strStartTime));
        Timestamp dtEndTime = new Timestamp(Long.parseLong(strEndTime));
        Calendar calendar = new Calendar();
        calendar.setCALENDARNAME(strEventName);
        calendar.setOWNERID(this.getWebContext().getCurUserId());
        calendar.setIMPORTANCE("NORMAL");
        calendar.setBEGINTIME(dtStartTime);
        calendar.setENDTIME(dtEndTime);
        calendar.setCALENDARTYPEID(strCalType);
        CallResult callResult = this.iDEDataCtrl.Save(true, (BaseDataEntity)calendar);
        if (callResult.getRetCode() != 0) {
            actionResult.From(callResult);
            this.Output(actionResult.ToJSONString());
            return;
        }
        actionResult.getItemObject().put("id", (Object)calendar.getCALENDARID());
        if (StringHelper.IsNullOrEmpty((String)this.strPageModel)) {
            actionResult.getItemObject().put("text", (Object)(String.valueOf(WebUtility.TextToHTML((String)calendar.getCALENDARNAME())) + "<BR>" + WebUtility.TextToHTML((String)calendar.getCONTENT())));
        } else {
            actionResult.getItemObject().put("text", (Object)calendar.getCALENDARNAME());
            actionResult.getItemObject().put("details", (Object)calendar.getCONTENT());
        }
        actionResult.getItemObject().put("begintime", calendar.getBEGINTIME().getTime());
        actionResult.getItemObject().put("endtime", calendar.getENDTIME().getTime());
        actionResult.getItemObject().put("caltype", (Object)calendar.getCALENDARTYPEID());
        actionResult.getItemObject().put("calseqid", (Object)calendar.getCALSEQID());
        this.Output(actionResult.ToJSONString());
    }

    protected void OnEditEvent() {
        String strEndTimeDEFName;
        SRFExAjaxActionResultEx actionResult = new SRFExAjaxActionResultEx();
        String strEventId = this.getWebContext().GetPostValue("id");
        String strStartTime = this.getWebContext().GetPostValue("starttime");
        String strEndTime = this.getWebContext().GetPostValue("endtime");
        Timestamp dtStartTime = new Timestamp(Long.parseLong(strStartTime));
        Timestamp dtEndTime = new Timestamp(Long.parseLong(strEndTime));
        Calendar calendar = new Calendar();
        calendar.setCALENDARID(strEventId);
        CallResult callResult = this.iDEDataCtrl.Get((BaseDataEntity)calendar);
        if (callResult.getRetCode() != 0) {
            actionResult.From(callResult);
            this.Output(actionResult.ToJSONString());
            return;
        }
        CalendarType calendarType = new CalendarType();
        calendarType.setCALENDARTYPEID(calendar.getCALENDARTYPEID());
        IDEDataCtrl iCalTypeDataCtrl = this.getDAModelStorage().FindDEDataCtrl("DE0051", (ISRFDAWebContext)this.getWebContext());
        if (iCalTypeDataCtrl == null) {
            actionResult.From(callResult);
            this.Output(actionResult.ToJSONString());
            return;
        }
        callResult = iCalTypeDataCtrl.Get((BaseDataEntity)calendarType);
        if (callResult.getRetCode() != 0) {
            actionResult.From(callResult);
            this.Output(actionResult.ToJSONString());
            return;
        }
        BaseDataEntity saveData = new BaseDataEntity();
        IDEDataCtrl iCalendarDataCtrl = null;
        if (!StringHelper.IsNullOrEmpty((String)calendarType.getDEID())) {
            IDEHelper tmpDEHelper = this.getDAModelStorage().FindDEHelper(calendarType.getDEID());
            if (tmpDEHelper == null) {
                actionResult.setRetCode(1);
                actionResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u8f85\u52a9\u5bf9\u8c61", (Object)calendarType.getDEID()));
                this.Output(actionResult.ToJSONString());
                return;
            }
            iCalendarDataCtrl = tmpDEHelper.GetDEDataCtrl("", (ISRFDAWebContext)this.getWebContext());
            if (iCalendarDataCtrl == null) {
                actionResult.setRetCode(1);
                actionResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61", (Object)calendarType.getDEID()));
                this.Output(actionResult.ToJSONString());
                return;
            }
            saveData.SetParamValue(tmpDEHelper.GetKeyDEFHelper().getName(), (Object)strEventId);
        } else {
            iCalendarDataCtrl = this.iDEDataCtrl;
            saveData.SetParamValue("CALENDARID", (Object)strEventId);
        }
        String strBeginTimeDEFName = calendarType.getBEGINTIMEDEFNAME();
        if (StringHelper.IsNullOrEmpty((String)strBeginTimeDEFName)) {
            strBeginTimeDEFName = "BEGINTIME";
        }
        if (StringHelper.IsNullOrEmpty((String)(strEndTimeDEFName = calendarType.getENDTIMEDEFNAME()))) {
            strEndTimeDEFName = "ENDTIME";
        }
        saveData.SetParamValue(strBeginTimeDEFName, (Object)dtStartTime);
        saveData.SetParamValue(strEndTimeDEFName, (Object)dtEndTime);
        callResult = iCalendarDataCtrl.Save(false, saveData);
        if (callResult.getRetCode() != 0) {
            actionResult.From(callResult);
            this.Output(actionResult.ToJSONString());
            return;
        }
        calendar.setCALENDARID(strEventId);
        callResult = this.iDEDataCtrl.Get((BaseDataEntity)calendar);
        if (callResult.getRetCode() != 0) {
            actionResult.From(callResult);
            this.Output(actionResult.ToJSONString());
            return;
        }
        actionResult.getItemObject().put("id", (Object)calendar.getCALENDARID());
        if (StringHelper.IsNullOrEmpty((String)this.strPageModel)) {
            actionResult.getItemObject().put("text", (Object)(String.valueOf(WebUtility.TextToHTML((String)calendar.getCALENDARNAME())) + "<BR>" + WebUtility.TextToHTML((String)calendar.getCONTENT())));
        } else {
            actionResult.getItemObject().put("text", (Object)calendar.getCALENDARNAME());
            actionResult.getItemObject().put("details", (Object)calendar.getCONTENT());
        }
        actionResult.getItemObject().put("begintime", calendar.getBEGINTIME().getTime());
        actionResult.getItemObject().put("endtime", calendar.getENDTIME().getTime());
        actionResult.getItemObject().put("caltype", (Object)calendar.getCALENDARTYPEID());
        actionResult.getItemObject().put("calseqid", (Object)calendar.getCALSEQID());
        this.Output(actionResult.ToJSONString());
    }

    protected void OnDeleletEvent() {
        SRFExAjaxActionResultEx actionResult = new SRFExAjaxActionResultEx();
        String strEventId = this.getWebContext().GetPostValue("id");
        Calendar calendar = new Calendar();
        calendar.setCALENDARID(strEventId);
        CallResult callResult = this.iDEDataCtrl.Get((BaseDataEntity)calendar);
        if (callResult.getRetCode() != 0) {
            actionResult.From(callResult);
            this.Output(actionResult.ToJSONString());
            return;
        }
        CalendarType calendarType = new CalendarType();
        calendarType.setCALENDARTYPEID(calendar.getCALENDARTYPEID());
        IDEDataCtrl iCalTypeDataCtrl = this.getDAModelStorage().FindDEDataCtrl("DE0051", (ISRFDAWebContext)this.getWebContext());
        if (iCalTypeDataCtrl == null) {
            actionResult.From(callResult);
            this.Output(actionResult.ToJSONString());
            return;
        }
        callResult = iCalTypeDataCtrl.Get((BaseDataEntity)calendarType);
        if (callResult.getRetCode() != 0) {
            actionResult.From(callResult);
            this.Output(actionResult.ToJSONString());
            return;
        }
        BaseDataEntity removeData = new BaseDataEntity();
        IDEDataCtrl iCalendarDataCtrl = null;
        if (!StringHelper.IsNullOrEmpty((String)calendarType.getDEID())) {
            IDEHelper tmpDEHelper = this.getDAModelStorage().FindDEHelper(calendarType.getDEID());
            if (tmpDEHelper == null) {
                actionResult.setRetCode(1);
                actionResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u8f85\u52a9\u5bf9\u8c61", (Object)calendarType.getDEID()));
                this.Output(actionResult.ToJSONString());
                return;
            }
            iCalendarDataCtrl = tmpDEHelper.GetDEDataCtrl("", (ISRFDAWebContext)this.getWebContext());
            if (iCalendarDataCtrl == null) {
                actionResult.setRetCode(1);
                actionResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61", (Object)calendarType.getDEID()));
                this.Output(actionResult.ToJSONString());
                return;
            }
            removeData.SetParamValue(tmpDEHelper.GetKeyDEFHelper().getName(), (Object)strEventId);
        } else {
            iCalendarDataCtrl = this.iDEDataCtrl;
            removeData.SetParamValue("CALENDARID", (Object)strEventId);
        }
        callResult = this.OnDeleletEventBeforeRemove(iCalendarDataCtrl, removeData);
        if (callResult.getRetCode() != 0) {
            actionResult.From(callResult);
            this.Output(actionResult.ToJSONString());
            return;
        }
        callResult = iCalendarDataCtrl.Remove(removeData);
        if (callResult.getRetCode() != 0) {
            actionResult.From(callResult);
            this.Output(actionResult.ToJSONString());
            return;
        }
        actionResult.getItemObject().put("id", (Object)strEventId);
        this.Output(actionResult.ToJSONString());
    }

    protected CallResult OnDeleletEventBeforeRemove(IDEDataCtrl iDEDataCtrl, BaseDataEntity dataEntity) {
        CallResult callResult = this.OnTestDataAction(iDEDataCtrl.GetDEHelper(), dataEntity, "DELETE");
        if (callResult.getRetCode() != 0) {
            return callResult;
        }
        return iDEDataCtrl.TestDataLock(dataEntity, this.GetDataLockKey(dataEntity));
    }

    protected CallResult OnTestDataAction(IDEHelper iDEHelper, BaseDataEntity dataEntity, String strAction) {
        return iDEHelper.GetDataAccHelper().Test((ISRFDAWebContext)this.getWebContext(), dataEntity, strAction);
    }

    protected String GetDataLockKey(BaseDataEntity dataEntity) {
        try {
            return this.getDEHelper().GetDataLockKey((ISRFDAWebContext)this.getWebContext(), dataEntity);
        }
        catch (Exception ex) {
            this.getPage().PageLog((Object)this, 1, StringHelper.Format((String)"\u83b7\u53d6\u6570\u636e\u5bf9\u8c61\u9501\u94a5\u5319\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            return "";
        }
    }
}

