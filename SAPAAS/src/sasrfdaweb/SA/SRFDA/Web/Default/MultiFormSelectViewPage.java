/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.DEFHelper.IDEFHelper
 *  SA.SRFDA.Ctrl.DEFHelper.IPickupDEFHelper
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFDA.Web.ISRFDAWebContext
 *  SA.SRFramework.CodeList.CodeItemConfig
 *  SA.SRFramework.CodeList.CodeListConfig
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.Web.Default;

import SA.SRFDA.Ctrl.DEFHelper.IDEFHelper;
import SA.SRFDA.Ctrl.DEFHelper.IPickupDEFHelper;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Web.Default.BaseMainPage;
import SA.SRFDA.Web.Default.ViewModel.BaseIconPickupViewModel;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFDA.Web.ViewModel.PageModel;
import SA.SRFramework.CodeList.CodeItemConfig;
import SA.SRFramework.CodeList.CodeListConfig;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;
import net.sf.json.JSONObject;

public class MultiFormSelectViewPage
extends BaseMainPage {
    protected IDEFHelper selectDEFHelper = null;
    protected BaseIconPickupViewModel iconPickupViewModel = null;
    protected HashMap<String, String> multiFormFilterMap = null;

    @Override
    protected boolean PreparePageEnv() {
        if (!super.PreparePageEnv()) {
            return false;
        }
        this.strPageDataEntityId = this.getWebContext().getSRFDEID();
        if (!this.LoadPageDataEntity()) {
            return false;
        }
        String strField = this.getDEHelper().GetProperty("MULTIFORMFIELD");
        if (StringHelper.IsNullOrEmpty((String)strField)) {
            this.OutputAlertMsg("\u6ca1\u6709\u6307\u5b9a\u591a\u8868\u5355\u9009\u62e9\u5c5e\u6027", true);
            return false;
        }
        this.selectDEFHelper = this.getDEHelper().GetDEFHelper(strField);
        if (this.selectDEFHelper == null) {
            this.PageLog(this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u5c5e\u6027[%2$s]\u8f85\u52a9\u5bf9\u8c61", (Object)this.getDEHelper().getId(), (Object)strField));
            this.OutputAlertMsg("\u65e0\u6cd5\u83b7\u53d6\u9009\u62e9\u5c5e\u6027\u8f85\u52a9\u5bf9\u8c61", true);
            return false;
        }
        String strMultiFormFilter = this.getWebContext().GetParamValue("SRFMULTIFORMFILTER");
        if (!StringHelper.IsNullOrEmpty((String)strMultiFormFilter)) {
            String[] multiformfilters = strMultiFormFilter.split("[,]");
            this.multiFormFilterMap = new HashMap();
            int i = 0;
            while (i < multiformfilters.length) {
                this.multiFormFilterMap.put(multiformfilters[i].toUpperCase(), "");
                ++i;
            }
        }
        return true;
    }

    @Override
    protected PageModel CreatePageModel() {
        return new BaseIconPickupViewModel();
    }

    @Override
    protected void PreparePageModel() {
        super.PreparePageModel();
        this.iconPickupViewModel = (BaseIconPickupViewModel)this.pageModel;
    }

    public String RenderIconView() {
        StringBuilderEx strIconView = new StringBuilderEx();
        strIconView.Append("<table align=\"left\" width=\"100%%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" >");
        strIconView.Append("<tr><td height=\"20\"></td></tr><tr>");
        String strIconViewTDScheme = "<td width=\"100\"><table align=\"center\"  border=\"0\" cellspacing=\"0\" cellpadding=\"0\" ><tr><td align=\"center\" ><a href=\"#\"  class='gridlink' onclick=\"endview({ret:'ok',id:'%3$s'})\" ><img border=\"0\" width=\"50\" src=\"%1$s\" alt=\"%2$s\"/></a></td></tr><tr><td align=\"center\" ><a href=\"#\"  class='gridlink'  onclick=\"endview({ret:'ok',id:'%3$s'})\" ><span class=\"sx-normaltext\">%2$s</span></a></td></tr></table></td>";
        if (this.selectDEFHelper instanceof IPickupDEFHelper) {
            Vector<BaseDataEntity> list;
            IPickupDEFHelper pickupDEFHelper = (IPickupDEFHelper)this.selectDEFHelper;
            IDEHelper iRealDEHelper = pickupDEFHelper.GetRealDEFHelper().getDEHelper();
            IDEDataCtrl iDataCtrl = iRealDEHelper.GetDEDataCtrl(this.getWebContext().getCurUserId(), (ISRFDAWebContext)this.getWebContext());
            CallResult callResult = iDataCtrl.Select(new BaseDataEntity(), list = new Vector<BaseDataEntity>());
            if (callResult.IsError()) {
                this.PageLog(this, 1, StringHelper.Format((String)"\u67e5\u8be2\u5b9e\u4f53[%1$s]\u6570\u636e\u53d1\u751f\u9519\u8bef\uff0c %2$s", (Object)iRealDEHelper.getId(), (Object)callResult.getErrorInfo()));
                return "";
            }
            int i = 1;
            String strMajorFieldName = iRealDEHelper.GetMajorDEFHelper().getName();
            String strKeyFieldName = iRealDEHelper.GetKeyDEFHelper().getName();
            for (BaseDataEntity dataEntity : list) {
                String img = "../images/icon_page.gif";
                if (StringHelper.Length((String)iRealDEHelper.getDataEntity().getBIGICON()) > 0) {
                    img = iRealDEHelper.getDataEntity().getBIGICON();
                }
                String strLogicName = dataEntity.GetParamStringValue(strMajorFieldName, "");
                String strId = dataEntity.GetParamStringValue(strKeyFieldName, "");
                strIconView.Append(strIconViewTDScheme, (Object)img, (Object)strLogicName, (Object)strId);
                if (i % 5 == 0) {
                    strIconView.Append("</tr><tr><td height=\"20\"></td></tr><tr>");
                }
                ++i;
            }
        } else if (!StringHelper.IsNullOrEmpty((String)this.selectDEFHelper.GetCodeList())) {
            CodeListConfig codeListConfig = this.getWebContext().getCodeListMgr().GetCodeListConfig(this.selectDEFHelper.GetCodeList());
            if (codeListConfig == null) {
                this.PageLog(this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u4ee3\u7801\u8868[%1$s]", (Object)this.selectDEFHelper.GetCodeList()));
                return "";
            }
            int i = 1;
            ArrayList arr = codeListConfig.getCodeItems();
            if (arr != null) {
                int j = 0;
                while (j < arr.size()) {
                    CodeItemConfig codeListItemConfig = (CodeItemConfig)arr.get(j);
                    if (this.multiFormFilterMap == null || this.multiFormFilterMap.containsKey(codeListItemConfig.getValue().toUpperCase())) {
                        String img = "../images/icon_page.gif";
                        if (StringHelper.Length((String)codeListItemConfig.getBigIcon()) > 0) {
                            img = codeListItemConfig.getBigIcon();
                        }
                        String strLogicName = codeListItemConfig.getText();
                        String strId = codeListItemConfig.getValue();
                        strIconView.Append(strIconViewTDScheme, (Object)img, (Object)strLogicName, (Object)strId);
                        if (i % 5 == 0) {
                            strIconView.Append("</tr><tr><td height=\"20\"></td></tr><tr>");
                        }
                        ++i;
                    }
                    ++j;
                }
            }
        }
        strIconView.Append("</tr>");
        strIconView.Append("</table>");
        return strIconView.toString();
    }

    protected void OnInitBackEnd() {
        super.OnInitBackEnd();
    }

    @Override
    protected void OnInit() {
        super.OnInit();
    }

    public String GetSelectObjectName() {
        if (this.selectDEFHelper == null) {
            return "\u672a\u77e5\u5c5e\u6027";
        }
        return this.selectDEFHelper.getLogicName(this.getLanguage());
    }

    @Override
    protected boolean OnFillPageModel(JSONObject jsonObject) {
        if (!super.OnFillPageModel(jsonObject)) {
            return false;
        }
        Vector<JSONObject> items = new Vector<JSONObject>();
        if (this.selectDEFHelper instanceof IPickupDEFHelper) {
            Vector<BaseDataEntity> list;
            IPickupDEFHelper pickupDEFHelper = (IPickupDEFHelper)this.selectDEFHelper;
            IDEHelper iRealDEHelper = pickupDEFHelper.GetRealDEFHelper().getDEHelper();
            IDEDataCtrl iDataCtrl = iRealDEHelper.GetDEDataCtrl(this.getWebContext().getCurUserId(), (ISRFDAWebContext)this.getWebContext());
            CallResult callResult = iDataCtrl.Select(new BaseDataEntity(), list = new Vector<BaseDataEntity>());
            if (callResult.IsError()) {
                this.PageLog(this, 1, StringHelper.Format((String)"\u67e5\u8be2\u5b9e\u4f53[%1$s]\u6570\u636e\u53d1\u751f\u9519\u8bef\uff0c %2$s", (Object)iRealDEHelper.getId(), (Object)callResult.getErrorInfo()));
                return false;
            }
            String strMajorFieldName = iRealDEHelper.GetMajorDEFHelper().getName();
            String strKeyFieldName = iRealDEHelper.GetKeyDEFHelper().getName();
            for (BaseDataEntity dataEntity : list) {
                JSONObject jo = new JSONObject();
                String img = "../images/icon_page.gif";
                if (StringHelper.Length((String)iRealDEHelper.getDataEntity().getBIGICON()) > 0) {
                    img = iRealDEHelper.getDataEntity().getBIGICON();
                }
                jo.put("icon", (Object)img);
                String strLogicName = dataEntity.GetParamStringValue(strMajorFieldName, "");
                String strId = dataEntity.GetParamStringValue(strKeyFieldName, "");
                jo.put("text", (Object)strLogicName);
                jo.put("id", (Object)strId);
                items.add(jo);
            }
        } else if (!StringHelper.IsNullOrEmpty((String)this.selectDEFHelper.GetCodeList())) {
            CodeListConfig codeListConfig = this.getWebContext().getCodeListMgr().GetCodeListConfig(this.selectDEFHelper.GetCodeList());
            if (codeListConfig == null) {
                this.PageLog(this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u4ee3\u7801\u8868[%1$s]", (Object)this.selectDEFHelper.GetCodeList()));
                return false;
            }
            ArrayList arr = codeListConfig.getCodeItems();
            if (arr != null) {
                int j = 0;
                while (j < arr.size()) {
                    JSONObject jo = new JSONObject();
                    CodeItemConfig codeListItemConfig = (CodeItemConfig)arr.get(j);
                    if (this.multiFormFilterMap == null || this.multiFormFilterMap.containsKey(codeListItemConfig.getValue().toUpperCase())) {
                        String img = "../images/icon_page.gif";
                        if (StringHelper.Length((String)codeListItemConfig.getBigIcon()) > 0) {
                            img = codeListItemConfig.getBigIcon();
                        }
                        jo.put("icon", (Object)img);
                        String strLogicName = codeListItemConfig.getText();
                        String strId = codeListItemConfig.getValue();
                        jo.put("text", (Object)strLogicName);
                        jo.put("id", (Object)strId);
                        items.add(jo);
                    }
                    ++j;
                }
            }
        }
        this.iconPickupViewModel.setItems(items);
        this.iconPickupViewModel.setTypeName(this.GetSelectObjectName());
        return true;
    }

    @Override
    protected String OnGetPageTitle() {
        return this.GetLocalization("PAGE.HEADER.PICKUPVIEW", "\u9009\u62e9\u89c6\u56fe");
    }
}
