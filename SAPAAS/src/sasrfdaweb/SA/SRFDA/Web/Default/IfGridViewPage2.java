/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  SA.SRFramework.WebEx.SRFExControl
 *  SA.SRFramework.WebEx.SRFExIFrame
 *  SA.SRFramework.WebEx.Utility.URLHelper
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.Web.Default;

import SA.SRFDA.Web.SRFDAPage;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.WebEx.SRFExControl;
import SA.SRFramework.WebEx.SRFExIFrame;
import SA.SRFramework.WebEx.Utility.URLHelper;
import net.sf.json.JSONObject;

public class IfGridViewPage2
extends SRFDAPage {
    protected SRFExIFrame iFrame = null;
    protected String strIframeURL = "";
    protected String strGridViewPath = "../srfpage/gridview.jsp";
    protected static String strWithOutParam = "";

    static {
        strWithOutParam = "TABVIEWPAGEID";
        strWithOutParam = String.valueOf(strWithOutParam) + "|";
        strWithOutParam = String.valueOf(strWithOutParam) + "TABVIEWID";
        strWithOutParam = String.valueOf(strWithOutParam) + "|";
        strWithOutParam = String.valueOf(strWithOutParam) + "REALURL";
    }

    public IfGridViewPage2() {
        this.setMainPage(true);
        this.setOutputDebug(false);
    }

    public void SetGridViewPath(String strGridViewPath) {
        this.strGridViewPath = strGridViewPath;
    }

    @Override
    protected boolean PreparePageEnv() {
        if (!super.PreparePageEnv()) {
            return false;
        }
        this.setID(this.getWebContext().getTabViewPageId());
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
        String strPath = this.getWebContext().GetParamValue("REALURL");
        if (StringHelper.IsNullOrEmpty((String)strPath)) {
            strPath = this.GetRealGridViewPath();
            strPath = URLHelper.AppendURLSeperator((String)strPath);
            strPath = String.valueOf(strPath) + "SRFIFVIEW=TRUE&";
            strPath = String.valueOf(strPath) + this.getWebContext().GetQueryStringWithout(strWithOutParam);
        }
        strPath = URLHelper.AppendURLSeperator((String)strPath);
        this.strIframeURL = strPath = String.valueOf(strPath) + "SRFIFVIEW=TRUE&";
        this.iFrame.getIFrameConfig().setURL(this.strIframeURL);
        this.AddControl((SRFExControl)this.iFrame);
    }

    protected String GetRealGridViewPath() {
        String strURL = this.getWebContext().GetParamValue("REALURL");
        if (!StringHelper.IsNullOrEmpty((String)strURL)) {
            return strURL;
        }
        return this.strGridViewPath;
    }

    protected void OnInit() {
        super.OnInit();
        StringBuilderEx script = new StringBuilderEx();
        script.Append("var tb=$P.tabview['%3$s']._TAB;tb.iframes['%2$s']='%2$s';var nInnerWidth = tb.getInnerWidth() -8; Ext.getDom('%2$s').style.width = nInnerWidth; var nInnerHeight = tb.getInnerHeight() -8; Ext.getDom('%2$s').style.height = nInnerHeight;tb.on('resize',function(owner,adjWidth,adjHeight,rawWidth,rawHeight){if(rawWidth==undefined){rawWidth=owner.getWidth();}if(rawHeight==undefined){rawHeight=owner.getHeight();}if(rawWidth!=undefined){Ext.getDom('%2$s').style.width = rawWidth-8;}if(rawHeight!=undefined){Ext.getDom('%2$s').style.height=rawHeight-8;}}); ", (Object)this.getWebContext().getTabViewPageId(), (Object)this.iFrame.getUniqueID(), (Object)this.getWebContext().getTabViewId());
        this.RegisterOnReadyScript(3, script.toString());
        script.Reset();
        script.Append("var tb=$P.tabview['%3$s']._TAB;tb.on('tabchange',function(_1,_2){if(_2.id=='%4$s'){var ifr=Ext.getDom('%5$s');if(ifr==null || ifr==undefined)return;if(ifr.contentWindow&&ifr.contentWindow.$P&&ifr.contentWindow.$P.maingrid){ifr.contentWindow.$P.maingrid.getStore().reload();}}}); ", (Object)this.getWebContext().getTabViewPageId(), (Object)this.iFrame.getUniqueID(), (Object)this.getWebContext().getTabViewId(), (Object)this.getWebContext().getTabViewPageId(), (Object)this.iFrame.getUniqueID());
        this.RegisterOnReadyScript(3, script.toString());
    }

    @Override
    protected boolean OnFillPageModel(JSONObject jsonObject) {
        if (!super.OnFillPageModel(jsonObject)) {
            return false;
        }
        jsonObject.put("realurl", (Object)this.strIframeURL);
        return true;
    }
}

