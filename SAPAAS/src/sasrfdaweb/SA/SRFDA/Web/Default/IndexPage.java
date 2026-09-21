/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.XMLConfig
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.WebEx.SRFExControl
 *  SA.SRFramework.WebEx.SRFExMainMenu
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.Web.Default;

import SA.SRFDA.Web.Default.ViewModel.IndexViewModel;
import SA.SRFDA.Web.SRFDAPageEx;
import SA.SRFDA.Web.ViewModel.PageModel;
import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.SRFExControl;
import SA.SRFramework.WebEx.SRFExMainMenu;
import net.sf.json.JSONObject;

public class IndexPage
extends SRFDAPageEx {
    private SRFExMainMenu mainMenu = null;
    protected IndexViewModel indexViewModel = null;
    public static final String PAGEPARAM_CONTAINERTRANSITION = "PAGE.CONTAINER.TRANSITION";
    public static final String PAGEPARAM_LEFTBARWIDTH = "PAGE.LEFTBAR.WIDTH";

    @Override
    protected PageModel CreatePageModel() {
        return new IndexViewModel();
    }

    @Override
    protected void PreparePageModel() {
        super.PreparePageModel();
        this.indexViewModel = (IndexViewModel)this.pageModel;
    }

    @Override
    protected boolean PreparePageEnv() {
        return super.PreparePageEnv();
    }

    protected void OnInitComponents() {
        String strUserId;
        if (this.OnGetUserIdDirectMode() && !StringHelper.IsNullOrEmpty((String)(strUserId = this.getWebContext().GetParamValue("USERID")))) {
            this.getWebContext().Logout();
            this.getWebContext().setCurUserId(strUserId);
            this.getWebContext().setCurUserName(strUserId);
            this.getWebContext().GetUserQueryModelStorage();
        }
        this.LoadMainMenu();
    }

    protected void LoadMainMenu() {
        String strMainMenuId = this.getDAConfigHelper().GetMainMenuExConfigId(this.getWebContext());
        if (!StringHelper.IsNullOrEmpty((String)strMainMenuId)) {
            this.mainMenu = new SRFExMainMenu();
            this.mainMenu.setConfig((XMLConfig)this.getWebContext().getMenuExConfig(strMainMenuId));
            this.mainMenu.setID("mainMenu");
            this.mainMenu.getMenuExConfig().setRenderMode(this.GetMainMenuRenderMode());
            this.AddControl((SRFExControl)this.mainMenu);
        }
    }

    protected String GetMainMenuRenderMode() {
        return "WINDOW";
    }

    public String OutputHeader() {
        return "";
    }

    public String getUserInfo() {
        return StringHelper.Format((String)"%1$s[%2$s]", (Object)this.getWebContext().getCurUserName(), (Object)this.getWebContext().getCurDeptName());
    }

    public String getLogo() {
        String strLogo = "../images/icon_banner.gif";
        return strLogo;
    }

    protected boolean OnGetUserIdDirectMode() {
        return false;
    }

    @Override
    protected boolean OnFillPageModel(JSONObject jsonObject) {
        if (!super.OnFillPageModel(jsonObject)) {
            return false;
        }
        this.indexViewModel.setContainerTransition(this.OnGetContainerTransition());
        this.indexViewModel.setLeftBarWidth(this.OnGetLeftBarWidth());
        return true;
    }

    protected String OnGetContainerTransition() {
        return this.getPageParam(PAGEPARAM_CONTAINERTRANSITION, "");
    }

    protected int OnGetLeftBarWidth() {
        return this.getPageParam(PAGEPARAM_LEFTBARWIDTH, 0);
    }
}

