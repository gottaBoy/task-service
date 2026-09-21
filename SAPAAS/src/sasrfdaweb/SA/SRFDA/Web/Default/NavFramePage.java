/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.Data.PP.PPNFView
 *  SA.SRFDA.Ctrl.Data.PP.PPNFViewPage
 *  SA.SRFDA.Ctrl.Data.Page
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.WebEx.SRFExControl
 *  SA.SRFramework.WebEx.SRFExRemotePanel
 *  SA.SRFramework.WebEx.SRFExTabView
 *  SA.SRFramework.WebEx.UI.TabViewPageConfig
 *  SA.SRFramework.WebEx.Utility.URLHelper
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.Web.Default;

import SA.SRFDA.Ctrl.Data.PP.PPNFView;
import SA.SRFDA.Ctrl.Data.PP.PPNFViewPage;
import SA.SRFDA.Ctrl.Data.Page;
import SA.SRFDA.Web.Default.BaseMainPage;
import SA.SRFDA.Web.Default.ViewModel.NavFrameViewModel;
import SA.SRFDA.Web.SRFDAPage;
import SA.SRFDA.Web.ViewModel.PageModel;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.SRFExControl;
import SA.SRFramework.WebEx.SRFExRemotePanel;
import SA.SRFramework.WebEx.SRFExTabView;
import SA.SRFramework.WebEx.UI.TabViewPageConfig;
import SA.SRFramework.WebEx.Utility.URLHelper;
import java.util.Vector;
import net.sf.json.JSONObject;

public class NavFramePage
extends BaseMainPage {
    protected SRFExTabView tabView = null;
    public String ITEMS = "";
    public String PANELS = "";
    public String LAYOUTCTRLS = "";
    public boolean bCollapsible = true;
    public int PAGECNT = 0;
    protected String strTabViewConfigId = "";
    protected Vector remotePanelList = new Vector();
    protected NavFrameViewModel navFrameViewModel = null;
    protected PPNFView ppNFView = null;

    @Override
    protected void PreparePageParam() {
        BaseDataEntity pageParam;
        super.PreparePageParam();
        if (this.page != null && (pageParam = this.page.getAdvPageParam("PAGE", "PPNFVIEW")) != null && pageParam instanceof PPNFView) {
            this.ppNFView = (PPNFView)pageParam;
        }
    }

    @Override
    protected boolean PreparePageEnv() {
        if (!super.PreparePageEnv()) {
            return false;
        }
        this.strPageDataEntityId = this.getWebContext().getSRFDEID();
        return this.LoadPageDataEntity();
    }

    @Override
    protected PageModel CreatePageModel() {
        return new NavFrameViewModel();
    }

    @Override
    protected void PreparePageModel() {
        super.PreparePageModel();
        this.navFrameViewModel = (NavFrameViewModel)this.pageModel;
    }

    protected void OnInitComponents() {
        super.OnInitComponents();
        this.LoadTabView();
        this.LoadPanel();
    }

    protected void LoadTabView() {
        this.strTabViewConfigId = "SRFDEFAULT.TABVIEW_COMMON_MAIN";
        if (this.getPage().getPageParam("PAGE.TABVIEWID") != null) {
            this.strTabViewConfigId = this.getPage().getPageParam("PAGE.TABVIEWID").toString();
        }
        if (this.getPage().getPageParam("PAGE.SELECTMODE") != null) {
            this.getWebContext().SetParamValue("SELECTMODE", this.getPage().getPageParam("PAGE.SELECTMODE").toString());
        }
        if (StringHelper.IsNullOrEmpty((String)this.strTabViewConfigId)) {
            return;
        }
        this.tabView = NavFramePage.CreateTabView((SRFDAPage)this, "tabView", 400.0, 0.0, this.strTabViewConfigId);
        if (this.tabView != null) {
            this.tabView.getTabViewConfig().setTopHeader(false);
            this.tabView.getTabViewConfig().setBorder(false);
            TabViewPageConfig t = (TabViewPageConfig)this.tabView.getTabViewConfig().getTabViewPages().get(0);
            String strPath = URLHelper.AppendURLSeperator((String)t.getRemoteURL());
            this.getWebContext().RemoveParam("REALURL");
            t.setRemoteURL(String.valueOf(strPath) + this.getWebContext().GetQueryString());
            this.tabView.getTabViewConfig().setResizeChild(true);
            if (this.navFrameViewModel != null && this.navFrameViewModel.getTabViewModel() != null) {
                this.navFrameViewModel.getTabViewModel().setConfigId(this.strTabViewConfigId);
            }
        }
    }

    protected void LoadPanel() {
        String strTitle;
        String strTitleLanResId;
        int nPageCount = 0;
        int i = 1;
        while (i < 10) {
            if (this.getPage().getPageParam("PAGE.NAVPAGES.PAGE" + i) != null) {
                ++nPageCount;
            }
            ++i;
        }
        this.PAGECNT = nPageCount;
        i = 1;
        while (i < 10) {
            if (this.getPage().getPageParam("PAGE.NAVPAGES.PAGE" + i) != null) {
                String[] strNavPage = this.getPage().getPageParam("PAGE.NAVPAGES.PAGE" + i).toString().split("\\|");
                strTitleLanResId = this.getPage().getPageParam("PAGE.NAVPAGES.PAGE" + i + ".TITLELANRESID", "");
                strTitle = this.getWebContext().getGlobalHelper().getLocalizationHelper().GetLocalization(this.getLanguage(), strTitleLanResId, strNavPage[0]);
                SRFExRemotePanel panel = new SRFExRemotePanel();
                panel.InitConfig();
                panel.setID("PAGE" + i);
                panel.getRemotePanelConfig().setCssClass("sx-panel");
                panel.getRemotePanelConfig().setRemoteURL(strNavPage[1]);
                panel.getRemotePanelConfig().setShowLoadIndicator(false);
                panel.getRemotePanelConfig().setExtStyle("width:100%;height:100%;overflow:hidden");
                this.AddControl((SRFExControl)panel);
                this.PANELS = String.valueOf(this.PANELS) + this.Render("PAGE" + i);
                this.LAYOUTCTRLS = String.valueOf(this.LAYOUTCTRLS) + panel.getUniqueID() + "layoutctrls(width,height);";
                if (this.PAGECNT == 1) {
                    this.bCollapsible = false;
                }
                String str = "{  contentEl: '%1$s', title:'%2$s  <a href=# class=gridlink onclick=try{_IFrame.contentWindow.reloadgrid({})}catch(e){}; >[ALL]</a>', border:false, iconCls:'nav', collapsible: %3$s}";
                this.ITEMS = StringHelper.Length((String)this.ITEMS) > 0 ? String.valueOf(this.ITEMS) + "," + StringHelper.Format((String)str, (Object)panel.getUniqueID(), (Object)strTitle, (Object)this.bCollapsible) : String.valueOf(this.ITEMS) + StringHelper.Format((String)str, (Object)panel.getUniqueID(), (Object)strTitle, (Object)this.bCollapsible);
                if (StringHelper.Compare((String)this.getPageModel(), (String)"SL", (boolean)true) == 0) {
                    JSONObject jo = new JSONObject();
                    jo.put("title", (Object)strTitle);
                    jo.put("url", (Object)strNavPage[1]);
                    this.remotePanelList.add(jo);
                }
            }
            ++i;
        }
        if (this.ppNFView != null && this.ppNFView.getPPNFViewPages() != null) {
            this.PAGECNT += this.ppNFView.getPPNFViewPages().size();
            i = 0;
            while (i < this.ppNFView.getPPNFViewPages().size()) {
                PPNFViewPage ppNFViewPage = (PPNFViewPage)this.ppNFView.getPPNFViewPages().get(i);
                strTitleLanResId = ppNFViewPage.getTITLELANRESID();
                strTitle = this.getWebContext().getGlobalHelper().getLocalizationHelper().GetLocalization(this.getLanguage(), strTitleLanResId, ppNFViewPage.getPPNFVIEWPAGENAME());
                Page page = this.getDAModelStorage().FindPage(ppNFViewPage.getPAGEID());
                if (page == null) {
                    this.PageLog(this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53\u9875\u9762[%1$s]", (Object)ppNFViewPage.getPAGEID()));
                    return;
                }
                String strUrl = page.GetTotalPagePath();
                SRFExRemotePanel panel = new SRFExRemotePanel();
                panel.InitConfig();
                panel.setID("PAGE" + i);
                panel.getRemotePanelConfig().setCssClass("sx-panel");
                panel.getRemotePanelConfig().setRemoteURL(strUrl);
                panel.getRemotePanelConfig().setShowLoadIndicator(false);
                panel.getRemotePanelConfig().setExtStyle("width:100%;height:100%;overflow:hidden");
                this.AddControl((SRFExControl)panel);
                this.PANELS = String.valueOf(this.PANELS) + this.Render("PAGE" + i);
                this.LAYOUTCTRLS = String.valueOf(this.LAYOUTCTRLS) + panel.getUniqueID() + "layoutctrls(width,height);";
                if (this.PAGECNT == 1) {
                    this.bCollapsible = false;
                }
                String str = "{  contentEl: '%1$s', title:'%2$s  <a href=# class=gridlink onclick=try{_IFrame.contentWindow.reloadgrid({})}catch(e){}; >[ALL]</a>', border:false, iconCls:'nav', collapsible: %3$s}";
                this.ITEMS = StringHelper.Length((String)this.ITEMS) > 0 ? String.valueOf(this.ITEMS) + "," + StringHelper.Format((String)str, (Object)panel.getUniqueID(), (Object)strTitle, (Object)this.bCollapsible) : String.valueOf(this.ITEMS) + StringHelper.Format((String)str, (Object)panel.getUniqueID(), (Object)strTitle, (Object)this.bCollapsible);
                if (StringHelper.Compare((String)this.getPageModel(), (String)"SL", (boolean)true) == 0) {
                    JSONObject jo = new JSONObject();
                    jo.put("title", (Object)strTitle);
                    jo.put("url", (Object)strUrl);
                    this.remotePanelList.add(jo);
                }
                ++i;
            }
        }
        this.PANELS = String.valueOf(this.PANELS) + "<script language=\"javascript\" type=\"text/javascript\">var LWidth=0;var LHeight=0;</script>";
        if (this.navFrameViewModel != null) {
            this.navFrameViewModel.setPanelList(this.remotePanelList);
        }
    }

    @Override
    protected boolean OnFillPageModel(JSONObject jsonObject) {
        return super.OnFillPageModel(jsonObject);
    }
}

