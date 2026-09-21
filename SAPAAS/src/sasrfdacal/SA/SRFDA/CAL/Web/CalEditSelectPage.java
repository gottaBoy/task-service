/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.Data.Page
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFDA.Web.Default.BaseMainPage
 *  SA.SRFDA.Web.ISRFDAWebContext
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.WebEx.Utility.URLHelper
 */
package SA.SRFDA.CAL.Web;

import SA.SRFDA.CAL.Ctrl.Data.Calendar;
import SA.SRFDA.CAL.Ctrl.Data.CalendarType;
import SA.SRFDA.Ctrl.Data.Page;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.Web.Default.BaseMainPage;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.Utility.URLHelper;

public class CalEditSelectPage
extends BaseMainPage {
    protected String strCalendarId = "";

    protected boolean PreparePageEnv() {
        if (!super.PreparePageEnv()) {
            return false;
        }
        String strPagePath = "";
        this.strCalendarId = this.getWebContext().GetParamValue("CALENDARID");
        if (!StringHelper.IsNullOrEmpty((String)this.strCalendarId)) {
            this.strPageDataEntityId = "DE0050";
            if (!this.LoadPageDataEntity()) {
                return false;
            }
            Calendar calendar = new Calendar();
            calendar.setCALENDARID(this.strCalendarId);
            IDEDataCtrl iDEDataCtrl = this.getDEHelper().GetDEDataCtrl("", (ISRFDAWebContext)this.getWebContext());
            if (iDEDataCtrl == null) {
                this.PageLog((Object)this, 1, "\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61");
                return false;
            }
            CallResult callResult = iDEDataCtrl.Get((BaseDataEntity)calendar);
            if (callResult == null || callResult.getRetCode() != 0) {
                this.PageLog((Object)this, "\u83b7\u53d6\u65e5\u5386\u4fe1\u606f\u5931\u8d25", callResult);
                return false;
            }
            if (!StringHelper.IsNullOrEmpty((String)calendar.getCALENDARTYPEID())) {
                CalendarType calendarType = new CalendarType();
                calendarType.setCALENDARTYPEID(calendar.getCALENDARTYPEID());
                IDEDataCtrl iCalTypeDataCtrl = this.getDAModelStorage().FindDEDataCtrl("DE0051", (ISRFDAWebContext)this.getWebContext());
                if (iCalTypeDataCtrl == null) {
                    this.PageLog((Object)this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61", (Object)"DE0051"));
                    return false;
                }
                callResult = iCalTypeDataCtrl.Get((BaseDataEntity)calendarType);
                if (callResult.getRetCode() != 0) {
                    this.PageLog((Object)this, 1, StringHelper.Format((String)"\u83b7\u53d6\u65e5\u5386\u7c7b\u578b[%1$s]\u5931\u8d25\uff0c%2$s", (Object)((Object)calendarType), (Object)callResult.getErrorInfo()));
                    return false;
                }
                String strPageId = calendarType.getEDITPAGEID();
                if (!StringHelper.IsNullOrEmpty((String)strPageId)) {
                    Page relatedPage = this.getDAModelStorage().FindPage(strPageId);
                    strPagePath = relatedPage.GetTotalPagePath();
                } else {
                    strPagePath = calendarType.getEDITPATH();
                }
                if (strPagePath.indexOf("SRFDEID") < 0 && !StringHelper.IsNullOrEmpty((String)calendarType.getDEID())) {
                    strPagePath = URLHelper.AppendURLSeperator((String)strPagePath);
                    strPagePath = String.valueOf(strPagePath) + "SRFDEID=" + calendarType.getDEID();
                }
                if (!StringHelper.IsNullOrEmpty((String)strPagePath) && !StringHelper.IsNullOrEmpty((String)calendarType.getDEID())) {
                    strPagePath = URLHelper.AppendURLSeperator((String)strPagePath);
                    strPagePath = String.valueOf(strPagePath) + this.getDAModelStorage().FindDEHelper(calendarType.getDEID()).GetKeyDEFHelper().getName() + "=" + this.strCalendarId;
                }
                if (!StringHelper.IsNullOrEmpty((String)strPagePath)) {
                    strPagePath = URLHelper.AppendURLSeperator((String)strPagePath);
                    strPagePath = String.valueOf(strPagePath) + "CALENDARID=";
                }
            }
            if (StringHelper.IsNullOrEmpty((String)strPagePath)) {
                strPagePath = "../srfcalendar/caleditview.jsp?CALENDARID=";
            }
            strPagePath = String.valueOf(strPagePath) + this.strCalendarId;
        } else {
            String strCalType = this.getWebContext().GetParamValue("CALTYPE");
            if (StringHelper.IsNullOrEmpty((String)strCalType)) {
                this.PageLog((Object)this, 1, "\u6ca1\u6709\u6307\u5b9a\u65e5\u5386\u6570\u636e\u6216\u65e5\u5386\u7c7b\u578b");
                return false;
            }
            CalendarType calendarType = new CalendarType();
            calendarType.setCALENDARTYPEID(strCalType);
            IDEDataCtrl iCalTypeDataCtrl = this.getDAModelStorage().FindDEDataCtrl("DE0051", (ISRFDAWebContext)this.getWebContext());
            if (iCalTypeDataCtrl == null) {
                this.PageLog((Object)this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61", (Object)"DE0051"));
                return false;
            }
            CallResult callResult = iCalTypeDataCtrl.Get((BaseDataEntity)calendarType);
            if (callResult.getRetCode() != 0) {
                this.PageLog((Object)this, 1, StringHelper.Format((String)"\u83b7\u53d6\u65e5\u5386\u7c7b\u578b[%1$s]\u5931\u8d25\uff0c%2$s", (Object)((Object)calendarType), (Object)callResult.getErrorInfo()));
                return false;
            }
            String strPageId = calendarType.getEDITPAGEID();
            if (!StringHelper.IsNullOrEmpty((String)strPageId)) {
                Page relatedPage = this.getDAModelStorage().FindPage(strPageId);
                strPagePath = relatedPage.GetTotalPagePath();
            } else {
                strPagePath = calendarType.getEDITPATH();
            }
            strPagePath = StringHelper.IsNullOrEmpty((String)strPagePath) ? "../srfcalendar/caleditview.jsp?" : String.valueOf(strPagePath) + "&";
            strPagePath = String.valueOf(strPagePath) + this.getWebContext().GetQueryString();
            if (strPagePath.indexOf("SRFDEID") < 0 && !StringHelper.IsNullOrEmpty((String)calendarType.getDEID())) {
                strPagePath = URLHelper.AppendURLSeperator((String)strPagePath);
                strPagePath = String.valueOf(strPagePath) + "SRFDEID=" + calendarType.getDEID();
            }
        }
        strPagePath = String.valueOf(strPagePath) + "&SEQMODE=" + this.getWebContext().GetParamValue("SEQMODE");
        try {
            if (StringHelper.IsNullOrEmpty((String)this.getPageModel())) {
                this.getResponse().sendRedirect(strPagePath);
            } else {
                this.getResponse().getWriter().write(CalEditSelectPage.OutputRedirectModel((String)strPagePath));
            }
            return false;
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return true;
        }
    }
}

