/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.BaseDEDataCtrl
 *  SA.SRFDA.Web.Default.BaseMainPage
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFDA.Web.ViewModel.PageModel
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  SA.SRFramework.WebEx.Script.BrowserJSHelper
 *  SA.SRFramework.WebEx.Utility.URLHelper
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.CAL.Web;

import SA.SRFDA.CAL.Ctrl.Data.CalendarType;
import SA.SRFDA.CAL.Ctrl.Data.PP.PPCalendar;
import SA.SRFDA.CAL.Web.ViewModel.CalendarViewModel;
import SA.SRFDA.Ctrl.BaseDEDataCtrl;
import SA.SRFDA.Web.Default.BaseMainPage;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFDA.Web.ViewModel.PageModel;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.WebEx.Script.BrowserJSHelper;
import SA.SRFramework.WebEx.Utility.URLHelper;
import java.util.Vector;
import net.sf.json.JSONObject;

public class CalendarPage
extends BaseMainPage {
    public static final String TAG_CALENDARDATAPATH = "PAGE.CALENDARDATAPATH";
    public static final String TAG_CALENDARGROUP = "PAGE.CALENDARGROUP";
    public static final String TAG_CALENDARINITVIEW = "PAGE.CALENDARINITVIEW";
    public static final String TAG_CALENDARSTARTHOUR = "PAGE.CALENDARSTARTHOUR";
    public static final String PPCTRLID_CALENDAR = "CALENDAR";
    protected StringBuilderEx cssSelectCode = new StringBuilderEx();
    protected CalendarViewModel calendarViewModel = null;
    protected PPCalendar ppCalendar = null;

    protected void PreparePageParam() {
        BaseDataEntity pageParam;
        super.PreparePageParam();
        if (this.page != null && (pageParam = this.page.getAdvPageParam(PPCTRLID_CALENDAR, "PP_CALENDAR")) != null && pageParam instanceof PPCalendar) {
            this.ppCalendar = (PPCalendar)pageParam;
        }
    }

    protected void OnInitComponents() {
    }

    protected PageModel CreatePageModel() {
        return new CalendarViewModel();
    }

    protected void PreparePageModel() {
        super.PreparePageModel();
        this.calendarViewModel = (CalendarViewModel)this.pageModel;
    }

    public String GetCalendarTypeCode() {
        StringBuilderEx script = new StringBuilderEx();
        script.Append(BrowserJSHelper.getShowDialogScriptEx((String)"", (String)"'../srfcalendar/caltypeselectview.jsp?CalendarGroup='+varCalendarGroup", (String)"{}", (int)500, (int)300, (String)"no", (String)"no", (String)"no"));
        script.Append("if(_DIALOGRESULT==null || _DIALOGRESULT.ret == null || _DIALOGRESULT.ret == undefined){return;}\r\n");
        script.Append("if( _DIALOGRESULT.ret!='ok')return;\r\n");
        script.Append("varCalType =_DIALOGRESULT.caltype;\r\n");
        return script.toString();
    }

    public String GetCalendarDataPath() {
        String strCalendarDataPath = "";
        if (this.ppCalendar != null) {
            strCalendarDataPath = this.ppCalendar.getDATAPATH();
        }
        if (StringHelper.IsNullOrEmpty((String)strCalendarDataPath)) {
            strCalendarDataPath = "../srfcalendar/calendarbackend.jsp?";
        }
        return this.getPageParam(TAG_CALENDARDATAPATH, strCalendarDataPath);
    }

    public String GetCalendarGroup() {
        String strCalendarGroup = "";
        if (this.ppCalendar != null) {
            strCalendarGroup = this.ppCalendar.getCALENDARGROUP();
        }
        return this.getPageParam(TAG_CALENDARGROUP, strCalendarGroup);
    }

    public String GetCalendarInitView() {
        String strCalInitView = "";
        if (this.ppCalendar != null) {
            strCalInitView = this.ppCalendar.getINITVIEW();
        }
        if (StringHelper.IsNullOrEmpty((String)strCalInitView)) {
            strCalInitView = "week";
        }
        return this.getPageParam(TAG_CALENDARINITVIEW, strCalInitView);
    }

    public String GetCalendarStartHour() {
        int nStartHour = 8;
        if (this.ppCalendar != null && !this.ppCalendar.isSTARTHOURNull()) {
            nStartHour = this.ppCalendar.getSTARTHOUR();
        }
        return this.getPageParam(TAG_CALENDARSTARTHOUR, StringHelper.Format((String)"%1$s", (Object)nStartHour));
    }

    public String GetCalendarTypeStyle() {
        String strSQL = "";
        String strCalendarGroup = this.GetCalendarGroup();
        strSQL = StringHelper.IsNullOrEmpty((String)strCalendarGroup) ? StringHelper.Format((String)"select * from t_SRFCalendarType where CalendarGroup = '' OR CalendarGroup IS NULL") : StringHelper.Format((String)"select * from t_SRFCalendarType where UPPER(CalendarGroup) = '%1$s'", (Object)strCalendarGroup.toUpperCase());
        Vector list = new Vector();
        CallResult callResult = BaseDEDataCtrl.SelectMulti((ISRFDAGlobalHelper)this.getWebContext().getGlobalHelper(), (String)strSQL, null, list, (String)CalendarType.class.getName());
        if (callResult.IsError()) {
            this.PageLog((Object)this, 1, StringHelper.Format((String)"\u67e5\u8be2\u65e5\u5386\u7c7b\u578b\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            return "";
        }
        StringBuilderEx output = new StringBuilderEx();
        int nIndex = 0;
        for (CalendarType calendarType : list) {
            output.Append(".dhx_cal_event.caltype_%1$s div{\r\n", (Object)nIndex);
            if (!StringHelper.IsNullOrEmpty((String)calendarType.getBKCOLOR())) {
                output.Append("background-color:%1$s !important;\r\n", (Object)calendarType.getBKCOLOR());
            }
            if (!StringHelper.IsNullOrEmpty((String)calendarType.getCOLOR())) {
                output.Append("color:%1$s !important;\r\n", (Object)calendarType.getCOLOR());
            } else {
                output.Append("color:black !important;\r\n");
            }
            output.Append("}\r\n", (Object)nIndex);
            this.cssSelectCode.Append("if(event.caltype=='%1$s'){return 'caltype_%2$s';}", (Object)calendarType.getCALENDARTYPEID(), (Object)nIndex);
            ++nIndex;
        }
        return output.toString();
    }

    public String GetCalTypeCssSelectCode() {
        return this.cssSelectCode.toString();
    }

    protected Vector GetCalendarTypeList() {
        Vector<JSONObject> calendarTypes = new Vector<JSONObject>();
        String strSQL = "";
        String strCalendarGroup = this.GetCalendarGroup();
        strSQL = StringHelper.IsNullOrEmpty((String)strCalendarGroup) ? StringHelper.Format((String)"select * from t_SRFCalendarType where CalendarGroup = '' OR CalendarGroup IS NULL") : StringHelper.Format((String)"select * from t_SRFCalendarType where UPPER(CalendarGroup) = '%1$s'", (Object)strCalendarGroup.toUpperCase());
        Vector list = new Vector();
        CallResult callResult = BaseDEDataCtrl.SelectMulti((ISRFDAGlobalHelper)this.getWebContext().getGlobalHelper(), (String)strSQL, null, list, (String)CalendarType.class.getName());
        if (callResult.IsError()) {
            this.PageLog((Object)this, 1, StringHelper.Format((String)"\u67e5\u8be2\u65e5\u5386\u7c7b\u578b\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            return null;
        }
        for (CalendarType calendarType : list) {
            JSONObject jo = new JSONObject();
            jo.put("caltypeid", (Object)calendarType.getCALENDARTYPEID());
            jo.put("color", (Object)calendarType.getCOLOR());
            jo.put("bkcolor", (Object)calendarType.getBKCOLOR());
            calendarTypes.add(jo);
        }
        return calendarTypes;
    }

    protected boolean OnFillPageModel(JSONObject jsonObject) {
        if (!super.OnFillPageModel(jsonObject)) {
            return false;
        }
        this.calendarViewModel.getCalendarModel().setStartHour(Integer.parseInt(this.GetCalendarStartHour()));
        this.calendarViewModel.getCalendarModel().setGroup(this.GetCalendarGroup());
        String strURL = this.GetCalendarDataPath();
        strURL = URLHelper.AppendURLSeperator((String)strURL);
        strURL = String.valueOf(strURL) + StringHelper.Format((String)"SRFPAGEMODEL=%1$s", (Object)this.getPageModel());
        this.calendarViewModel.getCalendarModel().setBackendUrl(strURL);
        this.calendarViewModel.getCalendarModel().setInitView(this.GetCalendarInitView());
        this.calendarViewModel.setCalTypeStyleList(this.GetCalendarTypeList());
        return true;
    }
}

