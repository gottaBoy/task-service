/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFDA.Web.Default.BaseMainPage
 *  SA.SRFDA.Web.Default.ViewModel.BaseIconPickupViewModel
 *  SA.SRFDA.Web.ISRFDAWebContext
 *  SA.SRFDA.Web.ViewModel.PageModel
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.CAL.Web;

import SA.SRFDA.CAL.Ctrl.Data.CalendarType;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Web.Default.BaseMainPage;
import SA.SRFDA.Web.Default.ViewModel.BaseIconPickupViewModel;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFDA.Web.ViewModel.PageModel;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import java.util.Vector;
import net.sf.json.JSONObject;

public class CalTypeSelectPage
extends BaseMainPage {
    protected BaseIconPickupViewModel iconPickupViewModel = null;

    protected boolean PreparePageEnv() {
        if (!super.PreparePageEnv()) {
            return false;
        }
        this.getWebContext().SetParamValue("SRFDEID", "DE0051");
        this.strPageDataEntityId = this.getWebContext().getSRFDEID();
        return this.LoadPageDataEntity();
    }

    protected PageModel CreatePageModel() {
        return new BaseIconPickupViewModel();
    }

    protected void PreparePageModel() {
        super.PreparePageModel();
        this.iconPickupViewModel = (BaseIconPickupViewModel)this.pageModel;
    }

    public String RenderIconView() {
        IDEDataCtrl iDEDataCtrl = this.getDEHelper().GetDEDataCtrl("", (ISRFDAWebContext)this.getWebContext());
        if (iDEDataCtrl == null) {
            this.PageLog((Object)this, 5, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61", (Object)"DE0051"));
            return "";
        }
        String strCalendarGroup = this.getWebContext().GetParamValue("CALENDARGROUP");
        BaseDataEntity dataEntity = new BaseDataEntity();
        dataEntity.SetParamValue("CALENDARGROUP", (Object)strCalendarGroup);
        CallResult callResult = iDEDataCtrl.CustomCall("LISTUSERCREATETYPE", dataEntity);
        if (callResult.getRetCode() != 0) {
            this.PageLog((Object)this, 1, StringHelper.Format((String)"\u83b7\u53d6\u7528\u6237\u53ef\u5efa\u7acb\u65e5\u5386\u5931\u8d25\u5931\u8d25,%1$s", (Object)callResult.getErrorInfo()));
            return "";
        }
        Vector list = (Vector)callResult.getUserObject();
        StringBuilderEx strIconView = new StringBuilderEx();
        strIconView.Append("<table align=\"left\" width=\"100%%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" >");
        strIconView.Append("<tr><td height=\"20\"></td></tr><tr>");
        String strIconViewTDScheme = "<td width=\"100\"><table align=\"center\"  border=\"0\" cellspacing=\"0\" cellpadding=\"0\" ><tr><td align=\"center\" ><a href=\"#\" class=\"sx-normaltext\" onclick=\"selectcaltype('%3$s')\" ><img border=\"0\"  src=\"%1$s\" alt=\"%2$s\" width='32' height='32'/></a></td></tr><tr><td align=\"center\" ><a href=\"#\" class=\"sx-normaltext\"  onclick=\"selectcaltype('%3$s')\" ><span class=\"sx-normaltext\">%2$s</span></a></td></tr></table></td>";
        int i = 1;
        for (CalendarType calendarType : list) {
            IDEHelper calTypeDEHelper = null;
            String strImage = "";
            if (!StringHelper.IsNullOrEmpty((String)calendarType.getDEID())) {
                calTypeDEHelper = this.getDAModelStorage().FindDEHelper(calendarType.getDEID());
                strImage = calTypeDEHelper.getDataEntity().getBIGICON();
            }
            if (StringHelper.IsNullOrEmpty((String)strImage)) {
                strImage = "../sasrfex/images/default/icon_calendar_b.png";
            }
            strIconView.Append(strIconViewTDScheme, (Object)strImage, (Object)calendarType.getCALENDARTYPENAME(), (Object)calendarType.getCALENDARTYPEID());
            if (i % 5 == 0) {
                strIconView.Append("</tr><tr><td height=\"20\"></td></tr><tr>");
            }
            ++i;
        }
        strIconView.Append("</tr>");
        strIconView.Append("</table>");
        return strIconView.toString();
    }

    protected boolean OnFillPageModel(JSONObject jsonObject) {
        if (!super.OnFillPageModel(jsonObject)) {
            return false;
        }
        Vector<JSONObject> items = new Vector<JSONObject>();
        IDEDataCtrl iDEDataCtrl = this.getDEHelper().GetDEDataCtrl("", (ISRFDAWebContext)this.getWebContext());
        if (iDEDataCtrl == null) {
            this.PageLog((Object)this, 5, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61", (Object)"DE0051"));
            return false;
        }
        String strCalendarGroup = this.getWebContext().GetParamValue("CALENDARGROUP");
        BaseDataEntity dataEntity = new BaseDataEntity();
        dataEntity.SetParamValue("CALENDARGROUP", (Object)strCalendarGroup);
        CallResult callResult = iDEDataCtrl.CustomCall("LISTUSERCREATETYPE", dataEntity);
        if (callResult.getRetCode() != 0) {
            this.PageLog((Object)this, 1, StringHelper.Format((String)"\u83b7\u53d6\u7528\u6237\u53ef\u5efa\u7acb\u65e5\u5386\u7c7b\u578b\u5931\u8d25,%1$s", (Object)callResult.getErrorInfo()));
            return false;
        }
        Vector list = (Vector)callResult.getUserObject();
        for (CalendarType calendarType : list) {
            IDEHelper calTypeDEHelper = null;
            String strImage = "";
            if (!StringHelper.IsNullOrEmpty((String)calendarType.getDEID())) {
                calTypeDEHelper = this.getDAModelStorage().FindDEHelper(calendarType.getDEID());
                strImage = calTypeDEHelper.getDataEntity().getBIGICON();
            }
            if (StringHelper.IsNullOrEmpty((String)strImage)) {
                strImage = "../sasrfex/images/default/icon_calendar_b.png";
            }
            JSONObject jo = new JSONObject();
            jo.put("icon", (Object)strImage);
            jo.put("text", (Object)calendarType.getCALENDARTYPENAME());
            jo.put("id", (Object)calendarType.getCALENDARTYPEID());
            items.add(jo);
        }
        this.iconPickupViewModel.setItems(items);
        this.iconPickupViewModel.setTypeName("\u65e5\u5386\u7c7b\u578b\u9009\u62e9");
        return true;
    }
}

