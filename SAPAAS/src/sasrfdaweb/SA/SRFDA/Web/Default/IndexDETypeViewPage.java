/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.Data.DERINDEX
 *  SA.SRFDA.Ctrl.Data.Page
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  SA.SRFramework.WebEx.Utility.URLHelper
 *  net.sf.json.JSONArray
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.Web.Default;

import SA.SRFDA.Ctrl.Data.DERINDEX;
import SA.SRFDA.Ctrl.Data.Page;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Web.Default.BaseMainPage;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.WebEx.Utility.URLHelper;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Vector;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class IndexDETypeViewPage
extends BaseMainPage {
    protected Vector<DERINDEX> dERIndexlist = null;

    @Override
    protected boolean PreparePageEnv() {
        String strIndexFilter;
        if (!super.PreparePageEnv()) {
            return false;
        }
        this.strPageDataEntityId = this.getWebContext().getSRFDEID();
        if (!this.LoadPageDataEntity()) {
            return false;
        }
        if (this.getDEHelper().IsIndexDE()) {
            this.dERIndexlist = this.getDEHelper().GetDERINDEXs(true);
        }
        if (!StringHelper.IsNullOrEmpty((String)(strIndexFilter = this.getWebContext().GetParamValue("SRFDERINDEXFILTER")))) {
            String[] indexfilters = strIndexFilter.split("[,]");
            Hashtable<String, String> filterMap = new Hashtable<String, String>();
            int i = 0;
            while (i < indexfilters.length) {
                filterMap.put(indexfilters[i].toUpperCase(), "");
                ++i;
            }
            Vector<DERINDEX> indexFilterList = new Vector<DERINDEX>();
            for (DERINDEX derIndex : this.dERIndexlist) {
                String strTypeValue = derIndex.getTYPEVALUE().toUpperCase();
                if (!filterMap.containsKey(strTypeValue)) continue;
                indexFilterList.add(derIndex);
            }
            this.dERIndexlist = indexFilterList;
        } else {
            Vector<DERINDEX> indexFilterList = new Vector<DERINDEX>();
            for (DERINDEX derIndex : this.dERIndexlist) {
                if (derIndex.getSHOWORDER() < 0) continue;
                indexFilterList.add(derIndex);
            }
            this.dERIndexlist = indexFilterList;
        }
        return true;
    }

    protected void OnInitComponents() {
        super.OnInitComponents();
    }

    public String RenderIconView() {
        return this.ctrlIconView();
    }

    public String ctrlIconView() {
        StringBuilderEx strIconView = new StringBuilderEx();
        strIconView.Append("<table align=\"left\" width=\"100%%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" >");
        strIconView.Append("<tr><td height=\"20\"></td></tr><tr>");
        String strIconViewTDScheme = "<td width=\"100\"><table align=\"center\"  border=\"0\" cellspacing=\"0\" cellpadding=\"0\" ><tr><td align=\"center\" ><a href=\"#\"  class='gridlink' onclick='%3$s' ><img border=\"0\" width=\"50\" src=\"%1$s\" alt=\"%2$s\"/></a></td></tr><tr><td align=\"center\" ><a href=\"#\"  class='gridlink' onclick='%3$s' ><span class=\"sx-normaltext\">%2$s</span></a></td></tr></table></td>";
        String strDefaultEditPage = this.getWebContext().getWebExConfig().GetValue("SRFDA.DEFAULTVIEW", "EDITVIEW", "../srfpage/editview.jsp");
        int i = 1;
        for (DERINDEX dERINDEX : this.dERIndexlist) {
            IDEHelper indexDEHelper = this.getDAModelStorage().FindDEHelper(dERINDEX.getDEID());
            String strEditPageId = indexDEHelper.GetEditPageId();
            String strEditPath = strDefaultEditPage;
            JSONObject jsonObject = new JSONObject();
            if (!StringHelper.IsNullOrEmpty((String)strEditPageId)) {
                Page editPage = this.getWebContext().getGlobalHelper().getDAModelStorage().FindPage(strEditPageId);
                if (editPage == null) {
                    this.PageLog(this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u9875\u9762\u5bf9\u8c61[%1$s]", (Object)strEditPageId));
                    return "";
                }
                if (!StringHelper.IsNullOrEmpty((String)editPage.GetTotalPagePath())) {
                    strEditPath = editPage.GetTotalPagePath();
                }
                if (editPage.GetParamValue("ISMODELSTYLE") != null) {
                    jsonObject.put("modal", editPage.isMODALSTYLE());
                }
                if (editPage.getWIDTH() != 0) {
                    jsonObject.put("width", editPage.getWIDTH());
                }
                if (editPage.getHEIGHT() != 0) {
                    jsonObject.put("height", editPage.getHEIGHT());
                }
                if (!StringHelper.IsNullOrEmpty((String)editPage.getWINDOWSTYLE())) {
                    jsonObject.put("windowstyle", (Object)editPage.getWINDOWSTYLE());
                }
            }
            String img = "../images/icon_page.gif";
            if (StringHelper.Length((String)indexDEHelper.getDataEntity().getBIGICON()) > 0) {
                img = indexDEHelper.getDataEntity().getBIGICON();
            }
            String strMethodName = "editview";
            jsonObject.put("deid", (Object)indexDEHelper.getId());
            jsonObject.put("ret", (Object)"ok");
            if (StringHelper.Compare((String)indexDEHelper.GetProperty("MULTIFORM"), (String)"TRUE", (boolean)true) == 0) {
                String strMultiFormField = indexDEHelper.GetProperty("MULTIFORMFIELD");
                String strType = this.getWebContext().GetParamValue(strMultiFormField);
                if (StringHelper.IsNullOrEmpty((String)strType)) {
                    strMethodName = "editviewmultiform";
                    jsonObject.put("mffield", (Object)strMultiFormField);
                } else {
                    strEditPath = URLHelper.AppendURLSeperator((String)strEditPath);
                    strEditPath = String.valueOf(strEditPath) + StringHelper.Format((String)"%1$s=%2$s", (Object)strMultiFormField, (Object)strType);
                }
            }
            jsonObject.put("url", (Object)URLHelper.AppendURLSeperator((String)strEditPath));
            String strMethod = StringHelper.Format((String)"%1$s(%2$s)", (Object)strMethodName, (Object)jsonObject.toString());
            strIconView.Append(strIconViewTDScheme, (Object)img, (Object)indexDEHelper.getLogicName(this.getLanguage()), (Object)strMethod);
            if (i % 5 == 0) {
                strIconView.Append("</tr><tr><td height=\"20\"></td></tr><tr>");
            }
            ++i;
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

    @Override
    protected boolean OnFillPageModel(JSONObject jsonObject) {
        if (!super.OnFillPageModel(jsonObject)) {
            return false;
        }
        ArrayList<JSONObject> items = new ArrayList<JSONObject>();
        String strDefaultEditPage = this.getWebContext().getWebExConfig().GetValue("SRFDA.DEFAULTVIEW", "EDITVIEW", "../srfpage/editview.jsp");
        for (DERINDEX dERINDEX : this.dERIndexlist) {
            IDEHelper indexDEHelper = this.getDAModelStorage().FindDEHelper(dERINDEX.getDEID());
            String strEditPageId = indexDEHelper.GetEditPageId();
            String strEditPath = strDefaultEditPage;
            JSONObject jo = new JSONObject();
            if (!StringHelper.IsNullOrEmpty((String)strEditPageId)) {
                Page editPage = this.getWebContext().getGlobalHelper().getDAModelStorage().FindPage(strEditPageId);
                if (editPage == null) {
                    this.PageLog(this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u9875\u9762\u5bf9\u8c61[%1$s]", (Object)strEditPageId));
                    continue;
                }
                if (!StringHelper.IsNullOrEmpty((String)editPage.GetTotalPagePath())) {
                    strEditPath = editPage.GetTotalPagePath();
                }
                if (editPage.GetParamValue("ISMODELSTYLE") != null) {
                    jo.put("modal", editPage.isMODALSTYLE());
                }
                if (editPage.getWIDTH() != 0) {
                    jo.put("width", editPage.getWIDTH());
                }
                if (editPage.getHEIGHT() != 0) {
                    jo.put("height", editPage.getHEIGHT());
                }
            }
            String img = "../images/icon_page.gif";
            if (StringHelper.Length((String)indexDEHelper.getDataEntity().getBIGICON()) > 0) {
                img = indexDEHelper.getDataEntity().getBIGICON();
            }
            jo.put("icon", (Object)img);
            if (StringHelper.Compare((String)indexDEHelper.GetProperty("MULTIFORM"), (String)"TRUE", (boolean)true) == 0) {
                String strMultiFormField = indexDEHelper.GetProperty("MULTIFORMFIELD");
                String strType = this.getWebContext().GetParamValue(strMultiFormField);
                if (StringHelper.IsNullOrEmpty((String)strType)) {
                    jo.put("mffield", (Object)strMultiFormField);
                    jo.put("mfselect", true);
                } else {
                    strEditPath = URLHelper.AppendURLSeperator((String)strEditPath);
                    strEditPath = String.valueOf(strEditPath) + StringHelper.Format((String)"%1$s=%2$s", (Object)strMultiFormField, (Object)strType);
                }
            }
            jo.put("deid", (Object)indexDEHelper.getId());
            jo.put("url", (Object)URLHelper.AppendURLSeperator((String)strEditPath));
            jo.put("text", (Object)indexDEHelper.getLogicName(this.getLanguage()));
            items.add(jo);
        }
        jsonObject.put("items", (Object)JSONArray.fromArray((Object[])items.toArray()));
        jsonObject.put("typename", (Object)this.getDEHelper().GetIndexTypeDEFHelper().getLogicName(this.getLanguage()));
        return true;
    }

    @Override
    protected String OnGetPageTitle() {
        return this.GetLocalization("PAGE.HEADER.PICKUPVIEW", "\u9009\u62e9\u89c6\u56fe");
    }
}

