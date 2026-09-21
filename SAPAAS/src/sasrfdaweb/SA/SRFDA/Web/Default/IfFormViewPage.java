/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  SA.SRFramework.WebEx.SRFExControl
 *  SA.SRFramework.WebEx.SRFExIFrame
 *  SA.SRFramework.WebEx.Script.TabViewJSHelper
 *  SA.SRFramework.WebEx.Script.TabViewPageJSHelper
 *  SA.SRFramework.WebEx.Utility.URLHelper
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.Web.Default;

import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Web.SRFDAPage;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.WebEx.SRFExControl;
import SA.SRFramework.WebEx.SRFExIFrame;
import SA.SRFramework.WebEx.Script.TabViewJSHelper;
import SA.SRFramework.WebEx.Script.TabViewPageJSHelper;
import SA.SRFramework.WebEx.Utility.URLHelper;
import java.util.TreeMap;
import net.sf.json.JSONObject;

public class IfFormViewPage
extends SRFDAPage {
    protected SRFExIFrame iFrame = null;
    protected String strIframeURL = "";
    protected String strEmptyFrameURL = "../srfpage/emptyframe.jsp?";
    protected String strEditViewPath = "../srfpage/embededitview.jsp";

    public IfFormViewPage() {
        this.setMainPage(true);
        this.setOutputDebug(false);
    }

    @Override
    protected boolean PreparePageEnv() {
        if (!super.PreparePageEnv()) {
            return false;
        }
        this.setID(this.getWebContext().getTabViewPageId());
        this.strEmptyFrameURL = String.valueOf(this.strEmptyFrameURL) + this.getWebContext().GetParamsString("SRFPDEID|SRFCAPTION");
        return true;
    }

    protected void OnInitComponents() {
        super.OnInitComponents();
        this.CreateIFrame();
    }

    protected void CreateIFrame() {
        if (this.iFrame != null) {
            return;
        }
        this.iFrame = new SRFExIFrame();
        this.iFrame.InitConfig();
        this.iFrame.setID("iframe");
        this.iFrame.getIFrameConfig().setWidth(0);
        this.iFrame.getIFrameConfig().setHeight(0);
        this.iFrame.getIFrameConfig().setScroll("no");
        String strWithOutParam = "TABVIEWPAGEID";
        strWithOutParam = String.valueOf(strWithOutParam) + "|";
        strWithOutParam = String.valueOf(strWithOutParam) + "TABVIEWID";
        String strPath = this.GetRealEditViewPath();
        strPath = URLHelper.AppendURLSeperator((String)strPath);
        this.strIframeURL = String.valueOf(strPath) + this.getWebContext().GetQueryStringWithout(strWithOutParam);
        this.strIframeURL = URLHelper.AppendURLSeperator((String)this.strIframeURL);
        this.iFrame.getIFrameConfig().setURL("");
        this.strEmptyFrameURL = this.strIframeURL;
        TreeMap<String, String> params = new TreeMap<String, String>();
        params.put("SRFMASKINFO", this.GetEmptyInfo());
        this.strEmptyFrameURL = String.valueOf(this.strEmptyFrameURL) + URLHelper.GetQueryString(params);
        this.AddControl((SRFExControl)this.iFrame);
    }

    protected String GetRealEditViewPath() {
        String strPath = this.getWebContext().GetParamValue("REALURL");
        if (!StringHelper.IsNullOrEmpty((String)strPath)) {
            return strPath;
        }
        return this.strEditViewPath;
    }

    protected String GetEmptyInfo() {
        IDEHelper iPDEHelper = this.getDAModelStorage().FindDEHelper(this.getWebContext().getSRFPDEID());
        if (iPDEHelper == null) {
            return "";
        }
        String strPDELogicName = iPDEHelper.getLogicName(this.getLanguage());
        String strCaption = this.getWebContext().GetParamValue("SRFCAPTION");
        String strEmptyInfoFmt = this.GetLocalization("PAGE.COMMON.IFFORMVIEW.EMPTYINFO", "\u8bf7\u5148\u5efa\u7acb\u3010%1$s\u3011\u5e76\u4fdd\u5b58\uff0c\u624d\u80fd\u5bf9\u3010%2$s\u3011\u8fdb\u884c\u7ba1\u7406\u3002");
        return StringHelper.Format((String)strEmptyInfoFmt, (Object)strPDELogicName, (Object)strCaption);
    }

    protected void OnInit() {
        super.OnInit();
        StringBuilderEx script = new StringBuilderEx();
        script.Append("var _TVD = %1$s;\r\n", (Object)TabViewJSHelper.getGetDataScript((String)this.getWebContext().getTabViewId()));
        script.Append("var varURL = '%1$s';\r\n", (Object)this.strIframeURL);
        script.Append("var _URLExt = Ext.urlEncode(_TVD);\r\n");
        script.Append("if(_URLExt=='' || $V(_TVD._COPYMODE,false)){varURL='%1$s';}\r\n", (Object)this.strEmptyFrameURL);
        script.Append("else{\r\n");
        script.Append(" varURL += _URLExt;\r\n");
        script.Append("}\r\n");
        script.Append("Ext.getDom('%1$s').src = varURL;", (Object)this.iFrame.getUniqueID());
        this.RegisterUncacheOnReadyScript(3, TabViewPageJSHelper.getOnDataChangedEventScript((String)this.getWebContext().getTabViewId(), (String)this.getWebContext().getTabViewPageId(), (String)script.toString()));
        this.RegisterUncacheOnReadyScript(3, script.toString());
        script.Reset();
        script.Append("var tb=$P.tabview['%3$s']._TAB;tb.iframes['%2$s']='%2$s';var nInnerWidth = tb.getInnerWidth() -8; Ext.getDom('%2$s').style.width = nInnerWidth; var nInnerHeight = tb.getInnerHeight() -8; Ext.getDom('%2$s').style.height = nInnerHeight;tb.on('resize',function(owner,adjWidth,adjHeight,rawWidth,rawHeight){if(rawWidth==undefined){rawWidth=owner.getWidth();}if(rawHeight==undefined){rawHeight=owner.getHeight();}if(rawWidth!=undefined){Ext.getDom('%2$s').style.width = rawWidth-8;}if(rawHeight!=undefined){Ext.getDom('%2$s').style.height = rawHeight-8;}}); ", (Object)this.getWebContext().getTabViewPageId(), (Object)this.iFrame.getUniqueID(), (Object)this.getWebContext().getTabViewId());
        this.RegisterOnReadyScript(3, script.toString());
    }

    @Override
    protected boolean OnFillPageModel(JSONObject jsonObject) {
        if (!super.OnFillPageModel(jsonObject)) {
            return false;
        }
        jsonObject.put("emptyinfo", (Object)this.GetEmptyInfo());
        jsonObject.put("realurl", (Object)this.strIframeURL);
        return true;
    }
}

