/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.Data.Message
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFDA.Web.Default.BaseMainPage
 *  SA.SRFDA.Web.ISRFDAWebContext
 *  SA.SRFDA.Web.SRFDAPage
 *  SA.SRFDA.Web.ViewModel.PageModel
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  SA.SRFramework.WebEx.SRFExTabView
 *  SA.SRFramework.WebEx.SRFExTreePanel
 *  SA.SRFramework.WebEx.SRFExWebContext
 *  SA.SRFramework.WebEx.Script.TabViewJSHelper
 *  SA.SRFramework.WebEx.Script.TreeJSHelper
 *  SA.SRFramework.WebEx.UI.TabViewConfig
 *  SA.SRFramework.WebEx.UI.TabViewPageConfig
 *  SA.SRFramework.WebEx.UI.TreeNodeConfig
 *  SA.SRFramework.WebEx.Utility.URLHelper
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.MSG.Web;

import SA.SRFDA.Ctrl.Data.Message;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.MSG.Web.ViewModel.MessageViewModel;
import SA.SRFDA.Web.Default.BaseMainPage;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFDA.Web.SRFDAPage;
import SA.SRFDA.Web.ViewModel.PageModel;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.WebEx.SRFExTabView;
import SA.SRFramework.WebEx.SRFExTreePanel;
import SA.SRFramework.WebEx.SRFExWebContext;
import SA.SRFramework.WebEx.Script.TabViewJSHelper;
import SA.SRFramework.WebEx.Script.TreeJSHelper;
import SA.SRFramework.WebEx.UI.TabViewConfig;
import SA.SRFramework.WebEx.UI.TabViewPageConfig;
import SA.SRFramework.WebEx.UI.TreeNodeConfig;
import SA.SRFramework.WebEx.Utility.URLHelper;
import java.util.Vector;
import net.sf.json.JSONObject;

public class MessagePage
extends BaseMainPage {
    protected SRFExTabView tabView = null;
    protected SRFExTreePanel treePanel = null;
    private static Vector<String> msgFolders = new Vector();
    private static String strIfGridViewPath;
    protected MessageViewModel messageViewModel = null;

    static {
        msgFolders.add("MYMSG");
        msgFolders.add("SENDED");
        msgFolders.add("INBOX");
        msgFolders.add("DRAFT");
        msgFolders.add("REMOVE");
        strIfGridViewPath = "../srfpage/ifgridview2.jsp?REALURL=%1$s";
    }

    protected boolean PreparePageEnv() {
        if (!super.PreparePageEnv()) {
            return false;
        }
        this.strPageDataEntityId = "DE0071";
        return this.LoadPageDataEntity();
    }

    protected PageModel CreatePageModel() {
        return new MessageViewModel();
    }

    protected void PreparePageModel() {
        super.PreparePageModel();
        this.messageViewModel = (MessageViewModel)this.pageModel;
    }

    protected void OnInitComponents() {
        super.OnInitComponents();
        this.LoadTreePanel();
        this.LoadTabView();
    }

    protected void OnInit() {
        super.OnInit();
        StringBuilderEx script = new StringBuilderEx();
        script.Append("var node=$P.tree['%1$s'].getSelectionModel().getSelectedNode();if(node==null)return;\r\n", (Object)this.treePanel.getUniqueID());
        script.Append("if(node == $P.tree['%1$s'].getRootNode()) return;\r\n", (Object)this.treePanel.getUniqueID());
        if (this.tabView != null) {
            script.Append(TabViewJSHelper.getShowTabPageScript2((String)this.tabView.getUniqueID(), (String)"node.id"));
        }
        this.RegisterOnReadyScript(3, TreeJSHelper.getOnSelectionchangeEventScript((String)this.treePanel.getUniqueID(), (String)script.toString()));
    }

    protected void LoadTreePanel() {
        this.treePanel = MessagePage.CreateTreePanel((SRFDAPage)this, (String)"treePanel", (double)200.0, (double)200.0, (String)"SRFMSG.TV_DEFAULT");
        if (this.treePanel != null) {
            this.treePanel.getTreePanelConfig().setBorder(false);
            this.treePanel.getTreePanelConfig().setRootVisible(false);
            this.treePanel.getTreePanelConfig().setShowLine(false);
            this.OnFillTreeMenuConfig(this.treePanel);
            this.treePanel.getTreePanelConfig().setSelectedValue("INBOX");
        }
    }

    protected void OnFillTreeMenuConfig(SRFExTreePanel treePanel) {
        TreeNodeConfig rootNodeConfig = treePanel.getTreePanelConfig().getRootNodeConfig();
        TreeNodeConfig treeNodeConfig = new TreeNodeConfig();
        treeNodeConfig.setText("\u4e2a\u4eba\u6587\u4ef6\u5939");
        treeNodeConfig.setID("MYMSG");
        treeNodeConfig.setIcon("../sasrfex/msg/images/icon_mymsg.png");
        rootNodeConfig.AddChildNode(treeNodeConfig);
        TreeNodeConfig draftTreeNodeConfig = new TreeNodeConfig();
        draftTreeNodeConfig.setText("\u8349\u7a3f");
        draftTreeNodeConfig.setID("DRAFT");
        draftTreeNodeConfig.setIcon("../sasrfex/msg/images/icon_draft.png");
        treeNodeConfig.AddChildNode(draftTreeNodeConfig);
        TreeNodeConfig inboxTreeNodeConfig = new TreeNodeConfig();
        inboxTreeNodeConfig.setText("\u6536\u4ef6\u7bb1" + this.GetNReadNum());
        inboxTreeNodeConfig.setID("INBOX");
        inboxTreeNodeConfig.setIcon("../sasrfex/msg/images/icon_inbox.png");
        treeNodeConfig.AddChildNode(inboxTreeNodeConfig);
        TreeNodeConfig sendedTreeNodeConfig = new TreeNodeConfig();
        sendedTreeNodeConfig.setText("\u5df2\u53d1\u9001\u6d88\u606f");
        sendedTreeNodeConfig.setID("SENDED");
        sendedTreeNodeConfig.setIcon("../sasrfex/msg/images/icon_sended.png");
        treeNodeConfig.AddChildNode(sendedTreeNodeConfig);
        TreeNodeConfig removeTreeNodeConfig = new TreeNodeConfig();
        removeTreeNodeConfig.setText("\u5df2\u5220\u9664\u6d88\u606f");
        removeTreeNodeConfig.setID("REMOVE");
        removeTreeNodeConfig.setIcon("../sasrfex/msg/images/icon_delete.png");
        treeNodeConfig.AddChildNode(removeTreeNodeConfig);
    }

    protected void OnAfterFillTreeMenuConfig(SRFExTreePanel treePanel) {
    }

    protected void OnFillTabViewConfig(TabViewConfig tabViewConfig) {
        for (String strFolder : msgFolders) {
            TabViewPageConfig tvpConfig = new TabViewPageConfig();
            tvpConfig.setID(strFolder);
            tvpConfig.setResourceId("NONE");
            String strPagePath = this.GetMsgFolderPagePath(strFolder);
            if (StringHelper.IsNullOrEmpty((String)strPagePath)) continue;
            strPagePath = URLHelper.AppendURLSeperator((String)strPagePath);
            strPagePath = String.valueOf(strPagePath) + StringHelper.Format((String)"SRFMSGFOLDER=%1$s", (Object)strFolder);
            tvpConfig.setRemoteURL(StringHelper.Format((String)strIfGridViewPath, (Object)SRFExWebContext.EncodeURLParamValue((String)strPagePath)));
            tabViewConfig.AddTabPage(tvpConfig);
        }
    }

    protected String GetMsgFolderPagePath(String strMsgFolder) {
        return "../srfmessage/msggridview.jsp";
    }

    protected void LoadTabView() {
        TabViewConfig tabViewConfig = new TabViewConfig();
        tabViewConfig.setTopHeader(false);
        tabViewConfig.setBorder(false);
        tabViewConfig.setResizeChild(true);
        this.OnFillTabViewConfig(tabViewConfig);
        tabViewConfig.ActiveTabViewPage("INBOX");
        this.tabView = MessagePage.CreateTabView((SRFDAPage)this, (String)"TabView", (double)600.0, (double)0.0, (TabViewConfig)tabViewConfig);
    }

    public String GetNReadNum() {
        String strNReadNum = "";
        if (StringHelper.IsNullOrEmpty((String)this.getPageModel())) {
            try {
                IDEDataCtrl iDataCtrl = this.getDEHelper().GetDEDataCtrl("", (ISRFDAWebContext)this.getWebContext());
                if (iDataCtrl != null) {
                    Message message = new Message();
                    message.setMSGACCOUNTID(this.webContext.getCurUserId());
                    message.setMSGFOLDER("INBOX");
                    message.SetParamValue("ISREADFLAG", (Object)0);
                    Vector messagelist = new Vector();
                    iDataCtrl.Select((BaseDataEntity)message, messagelist);
                    if (messagelist.size() != 0) {
                        strNReadNum = "<font color='red'>(" + String.valueOf(messagelist.size()) + ")</font>";
                    }
                }
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return strNReadNum;
    }

    protected boolean OnFillPageModel(JSONObject jsonObject) {
        if (!super.OnFillPageModel(jsonObject)) {
            return false;
        }
        this.messageViewModel.getTabViewModel().setConfigId("SRFMSG.TABVIEW_PERSONAL");
        this.messageViewModel.getTreePanelModel().setConfigId("SRFMSG.TREEVIEW_PERSONAL");
        return true;
    }

    protected String OnGetPageTitle() {
        return this.GetLocalization("PAGE.HEADER.MESSAGEVIEW", "\u6d88\u606f\u89c6\u56fe");
    }
}

