/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.DAConfigPublishContext
 *  SA.SRFDA.Ctrl.IDEMainStateHelper
 *  SA.SRFDA.Web.ISRFDAWebContext
 *  SA.SRFDA.Web.SRFDAWebCTXHelper
 *  SA.SRFramework.Utility.StringHelper
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.Web.Default;

import SA.SRFDA.Ctrl.DAConfigPublishContext;
import SA.SRFDA.Ctrl.IDEMainStateHelper;
import SA.SRFDA.Web.Default.BaseActiveDataPage;
import SA.SRFDA.Web.Default.ViewModel.MainViewModel;
import SA.SRFDA.Web.IDEMainStatePage;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFDA.Web.SRFDAWebCTXHelper;
import SA.SRFDA.Web.ViewModel.PageModel;
import SA.SRFramework.Utility.StringHelper;
import net.sf.json.JSONObject;

public abstract class BaseMainPage
extends BaseActiveDataPage
implements IDEMainStatePage {
    public static final String PPCTRLID_PAGE = "PAGE";
    protected MainViewModel mainPageModel = null;
    private IDEMainStateHelper iDEMainStateHelper = null;

    @Override
    protected boolean OnLoadPageDataEntity() {
        if (!super.OnLoadPageDataEntity()) {
            return false;
        }
        if (this.OnGetEnableDEMainState()) {
            this.iDEMainStateHelper = null;
            String strDEMainState = this.OnGetDEMainState();
            if (!StringHelper.IsNullOrEmpty((String)strDEMainState)) {
                try {
                    this.iDEMainStateHelper = this.getDEHelper().FindDEMainState(strDEMainState);
                }
                catch (Exception e) {
                    this.PageLog(this, 1, StringHelper.Format((String)"\u83b7\u53d6\u5b9e\u4f53\u4e3b\u72b6\u6001\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)e.getMessage()), e);
                }
            }
        }
        return true;
    }

    protected String OnGetDEMainState() {
        return SRFDAWebCTXHelper.GetDEMainState((ISRFDAWebContext)this.getWebContext());
    }

    @Override
    protected void PreparePageModel() {
        super.PreparePageModel();
        this.mainPageModel = (MainViewModel)this.pageModel;
    }

    protected boolean OnGetPickupMode() {
        return this.getPageParam("PAGE.PICKUPMODE", false);
    }

    public String OutputPageCaption() {
        return this.OnGetPageCaption();
    }

    protected String OnGetPageCaption() {
        if (this.IsContainPageParam("PAGE.CAPTIONCONTENT")) {
            return this.getPageParam("PAGE.CAPTIONCONTENT", "");
        }
        if (this.getDEHelper() != null) {
            return this.getDEHelper().getLogicName(this.getLanguage());
        }
        if (this.getPageDataEntity() != null) {
            return this.getPageDataEntity().getDELOGICNAME();
        }
        return "";
    }

    public String OutputPageIcon(boolean bSmall) {
        return this.OnGetPageIcon(bSmall);
    }

    protected String OnGetPageIcon(boolean bSmall) {
        return BaseMainPage.GetPageIcon(this, bSmall);
    }

    protected static String GetPageIcon(BaseMainPage page, boolean bSmall) {
        String strIconPath = "";
        if (page.getPageDataEntity() != null) {
            strIconPath = bSmall ? page.getPageDataEntity().getSMALLICON() : page.getPageDataEntity().getBIGICON();
        }
        if (StringHelper.IsNullOrEmpty((String)strIconPath)) {
            strIconPath = bSmall ? "../sasrfex/images/default/icon_page.png" : "../sasrfex/images/default/icon32_page.png";
        }
        return strIconPath;
    }

    @Override
    protected boolean OnFillPageModel(JSONObject jsonObject) {
        if (!super.OnFillPageModel(jsonObject)) {
            return false;
        }
        this.mainPageModel.setPageCaption(this.OnGetPageCaption());
        this.mainPageModel.setPageIcon(this.OnGetPageIcon(true));
        this.mainPageModel.setPageBigIcon(this.OnGetPageIcon(false));
        this.mainPageModel.setPageTitle(this.OnGetPageTitle());
        return true;
    }

    protected String OnGetPageTitle() {
        if (this.page != null) {
            String strPageTitle = "";
            String strPageLanResId = "";
            if (!this.page.isPAGETITLENull()) {
                strPageTitle = this.page.getPAGETITLE();
            }
            if (!this.page.isTITLELANRESIDNull()) {
                strPageLanResId = this.page.getTITLELANRESID();
            }
            if (!StringHelper.IsNullOrEmpty((String)strPageTitle) || !StringHelper.IsNullOrEmpty((String)strPageLanResId)) {
                return this.GetLocalization(strPageLanResId, strPageTitle);
            }
        }
        return "";
    }

    @Override
    protected PageModel CreatePageModel() {
        return new MainViewModel();
    }

    @Override
    public IDEMainStateHelper getDEMainState() {
        return this.iDEMainStateHelper;
    }

    @Override
    public boolean isEnableDEMainState() {
        return this.OnGetEnableDEMainState() && this.getDEMainState() != null;
    }

    protected boolean OnGetEnableDEMainState() {
        return this.getDEHelper().IsEnableDEMainState();
    }

    protected void ResetDEMainState() {
        this.iDEMainStateHelper = null;
    }

    @Override
    protected void FillDAConfigPublishContext(DAConfigPublishContext daConfigPublishContext) {
        super.FillDAConfigPublishContext(daConfigPublishContext);
        if (this.isEnableDEMainState()) {
            daConfigPublishContext.setDEMainState(this.getDEMainState());
        }
    }

    @Override
    protected boolean OnGetEnableDAConfigV2(String strConfigType) {
        if (StringHelper.Compare((String)strConfigType, (String)"TOOLBAR", (boolean)true) == 0 && this.isEnableDEMainState()) {
            return true;
        }
        return super.OnGetEnableDAConfigV2(strConfigType);
    }
}

