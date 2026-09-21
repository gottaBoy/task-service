/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.control.expbar.ExpBarRootItem
 *  net.ibizsys.paas.util.StringHelper
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Control.ExpBar;

import SA.SRFDA.PS.Core.App.Control.IPSAppCounter;
import SA.SRFDA.PS.Core.App.Control.IPSAppCounterRef;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.Control.Counter.IPSSysCounterRef;
import SA.SRFDA.PS.Core.Control.ExpBar.IPSExpBar;
import SA.SRFDA.PS.Core.Control.ExpBar.IPSExpBarParam;
import SA.SRFDA.PS.Core.Control.IPSAjaxControlParam;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Control.IPSControlContainer;
import SA.SRFDA.PS.Core.Control.IPSControlParam;
import SA.SRFDA.PS.Core.Control.PSAjaxControlContainerImpl;
import SA.SRFDA.PS.Core.Control.Toolbar.IPSDEToolbar;
import SA.SRFDA.PS.Core.Control.Toolbar.PSDEToolbarParamImpl;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Core.Res.IPSSysImage;
import SA.SRFDA.PS.Data.PSDEViewCtrl;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.paas.control.expbar.ExpBarRootItem;
import net.ibizsys.paas.util.StringHelper;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelImplementMeta(implement="IPSControl", typevalues={"EXPBAR"})
public class PSExpBarImpl
extends PSAjaxControlContainerImpl
implements IPSExpBar {
    private static final Log log = LogFactory.getLog(PSExpBarImpl.class);
    public static final String TOOLBARNAME = "_toolbar";
    private IPSExpBarParam iPSExpBarParam = null;
    protected ExpBarRootItem expBarRootItem = new ExpBarRootItem();
    private IPSSysCounterRef iPSSysCounterRef = null;
    private IPSLanguageRes titlePSLanguageRes = null;
    private boolean bEnableCounter = true;
    private boolean bEnableSearch = false;
    private boolean bShowTitleBar = true;
    private IPSDEToolbar iPSDEToolbar = null;
    private IPSSysImage iPSSysImage = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSControlContainer iPSControlContainer, String strName, IPSControlParam iPSControlParam) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSControlContainer(iPSControlContainer);
            this.iPSExpBarParam = (IPSExpBarParam)iPSControlParam;
            this.setId(String.valueOf(iPSControlContainer.getPSAppView().getId()) + "_" + strName);
            this.setName(strName);
            if (this.iPSExpBarParam.getEnableCounter() != null) {
                this.bEnableCounter = this.iPSExpBarParam.getEnableCounter();
            }
            if (this.iPSExpBarParam.getEnableSearch() != null) {
                this.bEnableSearch = this.iPSExpBarParam.getEnableSearch();
            }
            if (this.iPSExpBarParam.getShowTitleBar() != null) {
                this.bShowTitleBar = this.iPSExpBarParam.getShowTitleBar();
            }
            super.init(iDAGlobalHelper, iPSControlContainer, strName, iPSControlParam);
        }
        catch (Exception ex) {
            this.throwCriticalInitException(ex);
            String strLogName = StringHelper.format((String)"%1$s[%2$s]", (Object)PSModels.getModelName((String)this.getModelType()), (Object)this.getFullModelName());
            String strExInfo = StringHelper.format((String)"\u521d\u59cb\u5316\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage());
            log.error((Object)StringHelper.format((String)"%1$s%2$s", (Object)strLogName, (Object)strExInfo), (Throwable)ex);
            if (this.getPSSystemUtil() != null) {
                this.getPSSystemUtil().getPSSysConsole().error(strLogName, strExInfo);
            }
            this.throwInitException(ex);
        }
    }

    @Override
    protected void onInit() throws Exception {
        if (this.getPSDEToolbar() == null && !SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.iPSExpBarParam.getPSDEToolbarId())) {
            PSDEViewCtrl psDEViewCtrl = new PSDEViewCtrl();
            psDEViewCtrl.setPSDEVIEWCTRLNAME(String.valueOf(this.getName()) + TOOLBARNAME);
            psDEViewCtrl.setPSDEVIEWCTRLTYPE("TOOLBAR");
            psDEViewCtrl.setPSDETOOLBARID(this.iPSExpBarParam.getPSDEToolbarId());
            PSDEToolbarParamImpl psDEToolbarParamImpl = new PSDEToolbarParamImpl();
            psDEToolbarParamImpl.setOwner(this.getXDataPSControl());
            psDEToolbarParamImpl.init(this.getDAGlobalHelper(), this.getPSAppView(), psDEViewCtrl);
            IPSDEToolbar iPSDEToolbar = (IPSDEToolbar)this.registerPSControl(String.valueOf(this.getName()) + TOOLBARNAME, "TOOLBAR", psDEToolbarParamImpl);
            if (iPSDEToolbar != null) {
                this.setPSDEToolbar(iPSDEToolbar);
            }
        }
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.iPSExpBarParam.getTitlePSLanguageResId())) {
            this.titlePSLanguageRes = this.getPSApplication().getPSLanguageRes(this.iPSExpBarParam.getTitlePSLanguageResId());
        }
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.iPSExpBarParam.getPSSysImageId())) {
            this.iPSSysImage = this.getPSSystem().getPSSysImage(this.iPSExpBarParam.getPSSysImageId());
        }
        super.onInit();
        if (this.isEnableCounter()) {
            this.setPSSysCounterRef(this.preparePSSysCounterRef());
        }
    }

    protected IPSSysCounterRef preparePSSysCounterRef() throws Exception {
        String strExpBarCounterId = this.iPSExpBarParam.getPSSysCounterId();
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strExpBarCounterId)) {
            IPSAppCounter iPSSysCounter = this.getPSAppView().getPSApplication().getPSAppCounter(strExpBarCounterId, false);
            JSONObject refModeObj = new JSONObject();
            if (this.isPrepareDefaultPSAppViewLogics()) {
                return this.registerPSAppCounter(iPSSysCounter, refModeObj);
            }
            return this.getPSAppView().registerPSSysCounter(iPSSysCounter, refModeObj);
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u8ba1\u6570\u5668\u5f15\u7528", hideempty=true)
    public IPSSysCounterRef getPSSysCounterRef() {
        return this.iPSSysCounterRef;
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u8ba1\u6570\u5668\u5f15\u7528", hideempty=true, dumpref=true)
    public IPSAppCounterRef getPSAppCounterRef() {
        if (this.getPSSysCounterRef() != null && this.getPSSysCounterRef() instanceof IPSAppCounterRef) {
            return (IPSAppCounterRef)this.getPSSysCounterRef();
        }
        return null;
    }

    protected void setPSSysCounterRef(IPSSysCounterRef iPSSysCounterRef) {
        this.iPSSysCounterRef = iPSSysCounterRef;
    }

    @Override
    protected String onGetControlType() {
        return "EXPBAR";
    }

    @Override
    public void fillRelatedPSAppViews(ArrayList<IPSAppView> relatedAppViewList) throws Exception {
        super.fillRelatedPSAppViews(relatedAppViewList);
    }

    @Override
    public IPSAjaxControlParam getPSAjaxControlParam() {
        return this.iPSExpBarParam;
    }

    @Override
    public ExpBarRootItem getRootItem() {
        return this.expBarRootItem;
    }

    protected boolean isOutputSection(String strSectionName) {
        return true;
    }

    protected String getSectionName(String strSectionName) {
        return strSectionName;
    }

    protected String getSectionNameLanResTag(String strSectionName) {
        return "";
    }

    protected String getSectionViewId(String strGroup) throws Exception {
        String strViewRefMode = SA.SRFramework.Utility.StringHelper.Format((String)"%1$s:%2$s", (Object)"EXPITEM", (Object)strGroup);
        IPSAppView iPSAppView = this.getPSAppView().getRefPSAppView(strViewRefMode, true);
        if (iPSAppView == null) {
            return "";
        }
        return strGroup;
    }

    @Override
    @PSModelRTMeta(description="\u6a21\u578b\u8303\u56f4", dump=false)
    public String getModelScope() {
        return "VIEW";
    }

    @Override
    @PSModelRTMeta(description="\u62ac\u5934")
    public String getTitle() {
        return this.iPSExpBarParam.getTitle();
    }

    @Override
    @PSModelRTMeta(description="\u62ac\u5934\u8bed\u8a00\u8d44\u6e90\u5bf9\u8c61")
    public IPSLanguageRes getTitlePSLanguageRes() {
        return this.titlePSLanguageRes;
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u8ba1\u6570\u5668")
    public boolean isEnableCounter() {
        return this.bEnableCounter;
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u641c\u7d22")
    public boolean isEnableSearch() {
        return this.bEnableSearch;
    }

    @Override
    @PSModelRTMeta(description="\u663e\u793a\u6807\u9898\u680f")
    public boolean isShowTitleBar() {
        return this.bShowTitleBar;
    }

    @Override
    public String getModelType() {
        return "PSEXPBAR";
    }

    @Override
    @PSModelRTMeta(description="\u5bfc\u822a\u5de5\u5177\u680f")
    public IPSDEToolbar getPSDEToolbar() {
        return this.iPSDEToolbar;
    }

    protected void setPSDEToolbar(IPSDEToolbar iPSDEToolbar) {
        this.iPSDEToolbar = iPSDEToolbar;
    }

    @Override
    @PSModelRTMeta(description="\u5bfc\u822a\u680f\u6570\u636e\u90e8\u4ef6")
    public IPSControl getXDataPSControl() {
        return this.onGetXDataPSControl();
    }

    protected IPSControl onGetXDataPSControl() {
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u5bfc\u822a\u680f\u6570\u636e\u90e8\u4ef6\u540d\u79f0")
    public String getXDataControlName() {
        try {
            if (this.getXDataPSControl() != null) {
                return this.getXDataPSControl().getName();
            }
            return null;
        }
        catch (Exception ex) {
            log.error((Object)ex);
            return null;
        }
    }

    @Override
    @PSModelRTMeta(description="\u6807\u9898\u56fe\u6807")
    public IPSSysImage getPSSysImage() {
        return this.iPSSysImage;
    }

    @Override
    protected boolean isExportModelAlways() {
        return true;
    }

    @Override
    @PSModelRTMeta(description="\u90e8\u4ef6\u96c6\u5408", hideempty2=true, child=true, modelreftype="IGNOREDESIGN")
    public Iterator<IPSControl> getPSControls() {
        return super.getPSControls();
    }
}

