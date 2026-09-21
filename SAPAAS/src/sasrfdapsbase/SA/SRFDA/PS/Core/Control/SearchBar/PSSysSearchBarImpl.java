/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Control.SearchBar;

import SA.SRFDA.PS.Core.App.Control.IPSAppCounter;
import SA.SRFDA.PS.Core.App.Control.IPSAppCounterRef;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEUILogicGroupDetail;
import SA.SRFDA.PS.Core.App.View.IPSAppDESearchView;
import SA.SRFDA.PS.Core.App.View.IPSAppDESearchView2;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.CodeList.IPSCodeItem;
import SA.SRFDA.PS.Core.Control.Counter.IPSSysCounterRef;
import SA.SRFDA.PS.Core.Control.IPSControlContainer;
import SA.SRFDA.PS.Core.Control.IPSControlParam;
import SA.SRFDA.PS.Core.Control.PSControlContainerImpl;
import SA.SRFDA.PS.Core.Control.SearchBar.IPSSearchBarFilter;
import SA.SRFDA.PS.Core.Control.SearchBar.IPSSearchBarGroup;
import SA.SRFDA.PS.Core.Control.SearchBar.IPSSearchBarItem;
import SA.SRFDA.PS.Core.Control.SearchBar.IPSSearchBarQuickSearch;
import SA.SRFDA.PS.Core.Control.SearchBar.IPSSysSearchBar;
import SA.SRFDA.PS.Core.Control.SearchBar.IPSSysSearchBarLogic;
import SA.SRFDA.PS.Core.Control.SearchBar.IPSSysSearchBarParam;
import SA.SRFDA.PS.Core.Control.SearchBar.PSSysSearchBarFilterImpl;
import SA.SRFDA.PS.Core.Control.SearchBar.PSSysSearchBarGroupImpl;
import SA.SRFDA.PS.Core.Control.SearchBar.PSSysSearchBarLogicImpl;
import SA.SRFDA.PS.Core.Control.SearchBar.PSSysSearchBarParamImpl;
import SA.SRFDA.PS.Core.Control.SearchBar.PSSysSearchBarQuickSearchImpl;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Data.PSSysSearchBar;
import SA.SRFDA.PS.Data.PSSysSearchBarItem;
import SA.SRFDA.PS.Data.PSSysSearchBarLogic;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import net.ibizsys.paas.util.StringHelper;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelImplementMeta(implement="IPSControl", typevalues={"SEARCHBAR"})
public class PSSysSearchBarImpl
extends PSControlContainerImpl
implements IPSSysSearchBar {
    private static final Log log = LogFactory.getLog(PSSysSearchBarImpl.class);
    protected PSSysSearchBar psSysSearchBar;
    private ArrayList<IPSSearchBarItem> psSearchBarItemList = new ArrayList();
    protected PSSysSearchBarParamImpl psSysSearchBarParamImpl = new PSSysSearchBarParamImpl();
    private ArrayList<IPSSearchBarFilter> psSysSearchBarFilterList = new ArrayList();
    private ArrayList<IPSSearchBarQuickSearch> psSysSearchBarQuickSearchList = new ArrayList();
    private ArrayList<IPSSearchBarGroup> psSysSearchBarGroupList = new ArrayList();
    private IPSSysCounterRef iPSSysCounterRef = null;
    private boolean bMobileSearchBar = false;
    private boolean bEnableQuickSearch = true;
    private int nQuickSearchMode = 1;
    private boolean bEnableFilter = true;
    private boolean bEnableGroup = true;
    private int nQuickSearchWidth = 0;
    private int nQuickGroupCount = -1;
    protected List<PSSysSearchBarLogicImpl> psSysSearchBarLogicList = new ArrayList<PSSysSearchBarLogicImpl>();

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSControlContainer iPSControlContainer, String strName, IPSControlParam iPSControlParam) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSControlContainer(iPSControlContainer);
            IPSSysSearchBarParam iPSSysSearchBarParam = (IPSSysSearchBarParam)iPSControlParam;
            if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)iPSSysSearchBarParam.getPSSysSearchBarId())) {
                throw new Exception("\u6ca1\u6709\u6307\u5b9a\u7cfb\u7edf\u641c\u7d22\u680f");
            }
            this.psSysSearchBar = new PSSysSearchBar();
            if ("SRFCURRENTVIEW".equals(iPSSysSearchBarParam.getPSSysSearchBarId())) {
                IPSAppDESearchView iPSAppDESearchView;
                this.psSysSearchBar.setPSSYSSEARCHBARID("SRFCURRENTVIEW");
                this.psSysSearchBar.setMOBFLAG(this.getPSAppView().isMobileView());
                this.psSysSearchBar.setENABLEQUICKSEARCH(0);
                if (this.getPSAppView() instanceof IPSAppDESearchView && (iPSAppDESearchView = (IPSAppDESearchView)((Object)this.getPSAppView())).isEnableQuickSearch()) {
                    this.psSysSearchBar.setENABLEQUICKSEARCH(1);
                }
            } else {
                CallResult callResult = this.getPSModelHelper().getPSSysSearchBar(iPSSysSearchBarParam.getPSSysSearchBarId(), this.psSysSearchBar);
                if (callResult.isError()) {
                    throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u83b7\u53d6\u7cfb\u7edf\u641c\u7d22\u680f\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
            }
            this.setId(this.psSysSearchBar.getPSSYSSEARCHBARID());
            this.setName(strName);
            this.setLogicName(this.psSysSearchBar.getPSSYSSEARCHBARNAME());
            this.setPSObjectData(this.psSysSearchBar);
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psSysSearchBar.getPSDEID())) {
                if (this.getPSDataEntity() != null) {
                    if (SA.SRFramework.Utility.StringHelper.Compare((String)this.psSysSearchBar.getPSDEID(), (String)this.getPSDataEntity().getId(), (boolean)true) != 0) {
                        this.setPSDataEntity(this.getPSDataEntity().getPSSystem().getPSDataEntity2(this.psSysSearchBar.getPSDEID()));
                    }
                } else {
                    this.setPSDataEntity(this.getPSAppView().getPSSystem().getPSDataEntity2(this.psSysSearchBar.getPSDEID()));
                }
            }
            if (this.getId().indexOf("SRFTEMPKEY:") == 0) {
                this.setDesignMode(true);
                this.setPreviewPSPF(this.calcPreviewPSPF());
            }
            this.psSysSearchBarParamImpl.setPSSysPFPluginId(this.psSysSearchBar.getPSSYSPFPLUGINID());
            this.psSysSearchBarParamImpl.setPSCtrlMsgId(this.psSysSearchBar.getPSCTRLMSGID());
            this.psSysSearchBarParamImpl.setPSSysCssId(this.psSysSearchBar.getPSSYSCSSID());
            this.psSysSearchBarParamImpl.setPSDEUILogicGroupId(this.psSysSearchBar.getPSCTRLLOGICGROUPID());
            this.psSysSearchBarParamImpl.merge(iPSControlParam);
            super.init(iDAGlobalHelper, iPSControlContainer, strName, this.psSysSearchBarParamImpl);
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
        if (!this.psSysSearchBar.isMOBFLAGNull()) {
            this.bMobileSearchBar = this.psSysSearchBar.getMOBFLAG();
        }
        if (!this.psSysSearchBar.isENABLEQUICKSEARCHNull()) {
            this.nQuickSearchMode = this.psSysSearchBar.getENABLEQUICKSEARCH();
        }
        this.bEnableQuickSearch = this.getQuickSearchMode() != 0;
        if (!this.psSysSearchBar.isQUICKSEARCHWIDTHNull()) {
            this.nQuickSearchWidth = this.psSysSearchBar.getQUICKSEARCHWIDTH();
            if (this.nQuickSearchWidth <= 0) {
                this.nQuickSearchWidth = 0;
            }
        }
        if (!this.psSysSearchBar.isQUICKGROUPCNTNull()) {
            this.nQuickGroupCount = this.psSysSearchBar.getQUICKGROUPCNT();
        }
        super.onInit();
        this.setPSSysCounterRef(this.preparePSSysCounterRef());
        this.onPreparePSSysSearchBarItems();
        this.onPreparePSSysSearchBarLogics();
    }

    protected IPSSysCounterRef preparePSSysCounterRef() throws Exception {
        String strExpBarCounterId = this.psSysSearchBar.getPSSYSCOUNTERID();
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

    protected void onPreparePSSysSearchBarItems() throws Exception {
        Iterator<IPSCodeItem> psCodeItems;
        IPSAppDESearchView2 iPSAppDESearchView2;
        this.psSearchBarItemList.clear();
        this.psSysSearchBarFilterList.clear();
        this.psSysSearchBarGroupList.clear();
        this.psSysSearchBarQuickSearchList.clear();
        Vector<PSSysSearchBarItem> psSysSearchBarItemList = new Vector<PSSysSearchBarItem>();
        if (!"SRFCURRENTVIEW".equals(this.getId())) {
            CallResult callResult = this.getPSModelHelper().getPSSysSearchBarItems(this.getId(), psSysSearchBarItemList);
            if (callResult.isError()) {
                throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u67e5\u8be2\u641c\u7d22\u680f\u9879\u96c6\u5408\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
            }
        } else if (this.getPSAppView() instanceof IPSAppDESearchView2 && (iPSAppDESearchView2 = (IPSAppDESearchView2)((Object)this.getPSAppView())).isEnableQuickGroup() && iPSAppDESearchView2.getQuickGroupPSCodeList() != null && (psCodeItems = iPSAppDESearchView2.getQuickGroupPSCodeList().getPSCodeItems()) != null) {
            int nGroupCount = 0;
            while (psCodeItems.hasNext()) {
                IPSCodeItem iPSCodeItem = psCodeItems.next();
                boolean bHasChild = false;
                Iterator<IPSCodeItem> childPSCodeItems = iPSCodeItem.getPSCodeItems();
                if (iPSCodeItem.getPSCodeItems() != null) {
                    while (childPSCodeItems.hasNext()) {
                        bHasChild = true;
                        IPSCodeItem childPSCodeItem = childPSCodeItems.next();
                        PSSysSearchBarItem psSysSearchBarItem = new PSSysSearchBarItem();
                        psSysSearchBarItem.setPSSYSSEARCHBARITEMID(childPSCodeItem.getId());
                        psSysSearchBarItem.setPSSYSSEARCHBARITEMNAME(childPSCodeItem.getValue());
                        psSysSearchBarItem.setDATA(childPSCodeItem.getData());
                        psSysSearchBarItem.setCAPTION(childPSCodeItem.getText());
                        psSysSearchBarItem.setITEMTYPE("GROUP");
                        psSysSearchBarItemList.add(psSysSearchBarItem);
                    }
                }
                if (bHasChild) continue;
                PSSysSearchBarItem psSysSearchBarItem = new PSSysSearchBarItem();
                psSysSearchBarItem.setPSSYSSEARCHBARITEMID(iPSCodeItem.getId());
                psSysSearchBarItem.setPSSYSSEARCHBARITEMNAME(iPSCodeItem.getValue());
                psSysSearchBarItem.setDATA(iPSCodeItem.getData());
                psSysSearchBarItem.setCAPTION(iPSCodeItem.getText());
                psSysSearchBarItem.setITEMTYPE("GROUP");
                psSysSearchBarItemList.add(psSysSearchBarItem);
                ++nGroupCount;
            }
            this.nQuickGroupCount = nGroupCount;
        }
        for (PSSysSearchBarItem psSysSearchBarItem : psSysSearchBarItemList) {
            if (!psSysSearchBarItem.isVALIDFLAGNull() && !psSysSearchBarItem.getVALIDFLAG()) continue;
            if (this.bEnableFilter && SA.SRFramework.Utility.StringHelper.Compare((String)psSysSearchBarItem.getITEMTYPE(), (String)"FILTER", (boolean)true) == 0) {
                PSSysSearchBarFilterImpl psSysSearchBarFilterImpl = new PSSysSearchBarFilterImpl();
                psSysSearchBarFilterImpl.init(this.getDAGlobalHelper(), this, psSysSearchBarItem);
                this.psSysSearchBarFilterList.add(psSysSearchBarFilterImpl);
                continue;
            }
            if (this.bEnableQuickSearch && SA.SRFramework.Utility.StringHelper.Compare((String)psSysSearchBarItem.getITEMTYPE(), (String)"QUICKSEARCH", (boolean)true) == 0) {
                PSSysSearchBarQuickSearchImpl psSysSearchBarQuickSearchImpl = new PSSysSearchBarQuickSearchImpl();
                psSysSearchBarQuickSearchImpl.init(this.getDAGlobalHelper(), this, psSysSearchBarItem);
                this.psSysSearchBarQuickSearchList.add(psSysSearchBarQuickSearchImpl);
                continue;
            }
            if (this.bEnableGroup && SA.SRFramework.Utility.StringHelper.Compare((String)psSysSearchBarItem.getITEMTYPE(), (String)"GROUP", (boolean)true) == 0) {
                PSSysSearchBarGroupImpl psSysSearchBarGroupImpl = new PSSysSearchBarGroupImpl();
                psSysSearchBarGroupImpl.init(this.getDAGlobalHelper(), this, psSysSearchBarItem);
                this.psSysSearchBarGroupList.add(psSysSearchBarGroupImpl);
                continue;
            }
            log.error((Object)SA.SRFramework.Utility.StringHelper.Format((String)"\u65e0\u6cd5\u8bc6\u522b\u7684\u641c\u7d22\u680f\u9879\u7c7b\u578b[%1$s]", (Object)psSysSearchBarItem.getITEMTYPE()));
        }
        if (this.psSysSearchBarFilterList.size() == 0) {
            this.bEnableFilter = false;
        }
        if (this.psSysSearchBarGroupList.size() == 0) {
            this.bEnableGroup = false;
        }
        this.psSearchBarItemList.addAll(this.psSysSearchBarFilterList);
        this.psSearchBarItemList.addAll(this.psSysSearchBarQuickSearchList);
        this.psSearchBarItemList.addAll(this.psSysSearchBarGroupList);
    }

    protected void onPreparePSSysSearchBarLogics() throws Exception {
        this.psSysSearchBarLogicList.clear();
        this.onPreparePSSysSearchBarLogics(this.getId());
    }

    protected void onPreparePSSysSearchBarLogics(String strPSSysSearchBarId) throws Exception {
        Vector<PSSysSearchBarLogic> psSysSearchBarLogicList = new Vector<PSSysSearchBarLogic>();
        CallResult callResult = this.getPSModelHelper().getPSSysSearchBarLogics(strPSSysSearchBarId, psSysSearchBarLogicList);
        if (callResult.isError()) {
            throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u67e5\u8be2\u641c\u7d22\u680f\u903b\u8f91\u96c6\u5408\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSSysSearchBarLogic psSysSearchBarLogic : psSysSearchBarLogicList) {
            PSSysSearchBarLogicImpl psSysSearchBarLogicImpl = new PSSysSearchBarLogicImpl();
            psSysSearchBarLogicImpl.init(this.getDAGlobalHelper(), this, psSysSearchBarLogic);
            this.psSysSearchBarLogicList.add(psSysSearchBarLogicImpl);
        }
    }

    @Override
    public Iterator<? extends IPSSearchBarItem> getPSSearchBarItems() {
        return this.psSearchBarItemList.iterator();
    }

    @Override
    public void fillRelatedPSAppViews(ArrayList<IPSAppView> relatedAppViewList) throws Exception {
        super.fillRelatedPSAppViews(relatedAppViewList);
        if (this.psSysSearchBarFilterList != null) {
            for (IPSSearchBarFilter iPSSearchBarFilter : this.psSysSearchBarFilterList) {
                iPSSearchBarFilter.fillRelatedPSAppViews(relatedAppViewList);
            }
        }
    }

    @Override
    protected String onGetControlType() {
        return "SEARCHBAR";
    }

    @Override
    public String getModelScope() {
        return "VIEW";
    }

    @Override
    @PSModelRTMeta(description="\u8fc7\u6ee4\u9879\u96c6\u5408", child=true, group="\u90e8\u4ef6\u5143\u7d20", order=170)
    public Iterator<? extends IPSSearchBarFilter> getPSSearchBarFilters() {
        return this.psSysSearchBarFilterList.iterator();
    }

    @Override
    public IPSSearchBarFilter getPSSearchBarFilter(String strPSSearchBarFilterId, boolean bTryMode) throws Exception {
        Iterator<? extends IPSSearchBarFilter> psSearchBarFilters = this.getPSSearchBarFilters();
        if (psSearchBarFilters != null) {
            while (psSearchBarFilters.hasNext()) {
                IPSSearchBarFilter iPSSearchBarFilter = psSearchBarFilters.next();
                if (!iPSSearchBarFilter.getName().equalsIgnoreCase(strPSSearchBarFilterId)) continue;
                return iPSSearchBarFilter;
            }
        }
        if (bTryMode) {
            return null;
        }
        throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u641c\u7d22\u9762\u677f\u8fc7\u6ee4\u9879[%1$s]", (Object)strPSSearchBarFilterId));
    }

    @Override
    @PSModelRTMeta(description="\u5feb\u901f\u641c\u7d22\u9879\u96c6\u5408", child=true, group="\u90e8\u4ef6\u5143\u7d20", order=171)
    public Iterator<? extends IPSSearchBarQuickSearch> getPSSearchBarQuickSearchs() {
        return this.psSysSearchBarQuickSearchList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u5206\u7ec4\u9879\u96c6\u5408", child=true, group="\u90e8\u4ef6\u5143\u7d20", order=172)
    public Iterator<? extends IPSSearchBarGroup> getPSSearchBarGroups() {
        return this.psSysSearchBarGroupList.iterator();
    }

    @Override
    public String getModelType() {
        return "PSSYSSEARCHBAR";
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.onGetCodeName();
    }

    @Override
    protected String onGetCodeName() {
        return this.getPSApplication().getViewCodeName(null, this.psSysSearchBar.getCODENAME(), null);
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u8ba1\u6570\u5668\u5f15\u7528", hideempty=true)
    public IPSSysCounterRef getPSSysCounterRef() {
        return this.iPSSysCounterRef;
    }

    protected void setPSSysCounterRef(IPSSysCounterRef iPSSysCounterRef) {
        this.iPSSysCounterRef = iPSSysCounterRef;
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u8ba1\u6570\u5668\u5f15\u7528", hideempty=true, dumpref=true)
    public IPSAppCounterRef getPSAppCounterRef() {
        if (this.getPSSysCounterRef() != null && this.getPSSysCounterRef() instanceof IPSAppCounterRef) {
            return (IPSAppCounterRef)this.getPSSysCounterRef();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u641c\u7d22\u680f\u6837\u5f0f", codelist="SearchBarStyle")
    public String getSearchBarStyle() {
        return this.psSysSearchBar.getBARSTYLE();
    }

    @Override
    @PSModelRTMeta(description="\u79fb\u52a8\u7aef\u641c\u7d22\u680f")
    public boolean isMobileSearchBar() {
        return this.bMobileSearchBar;
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u5feb\u901f\u641c\u7d22", group="\u90e8\u4ef6\u5143\u7d20", order=155)
    public boolean isEnableQuickSearch() {
        return this.bEnableQuickSearch;
    }

    @Override
    @PSModelRTMeta(description="\u5feb\u901f\u641c\u7d22\u6846\u5bbd\u5ea6", group="\u90e8\u4ef6\u5143\u7d20", order=156)
    public int getQuickSearchWidth() {
        return this.nQuickSearchWidth;
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u8fc7\u6ee4\u5668", group="\u90e8\u4ef6\u5143\u7d20", order=153)
    public boolean isEnableFilter() {
        return this.bEnableFilter;
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u6570\u636e\u5206\u7ec4", group="\u90e8\u4ef6\u5143\u7d20", order=152)
    public boolean isEnableGroup() {
        return this.bEnableGroup;
    }

    @Override
    @PSModelRTMeta(description="\u5feb\u901f\u641c\u7d22\u6a21\u5f0f", codelist="SearchBarQuickSearchMode")
    public int getQuickSearchMode() {
        return this.nQuickSearchMode;
    }

    @Override
    @PSModelRTMeta(description="\u5feb\u901f\u5206\u7ec4\u663e\u793a\u6570\u91cf", group="\u90e8\u4ef6\u5143\u7d20", order=159)
    public int getQuickGroupCount() {
        return this.nQuickGroupCount;
    }

    @Override
    @PSModelRTMeta(description="\u66f4\u591a\u5206\u7ec4\u663e\u793a\u6587\u672c", group="\u90e8\u4ef6\u5143\u7d20", order=160)
    public String getGroupMoreText() {
        return this.psSysSearchBar.getGROUPMORETEXT();
    }

    @Override
    @PSModelRTMeta(description="\u641c\u7d22\u680f\u903b\u8f91\u96c6\u5408", group="\u90e8\u4ef6\u903b\u8f91", order=217)
    public Iterator<? extends IPSSysSearchBarLogic> getPSSysSearchBarLogics() {
        if (this.psSysSearchBarLogicList == null || this.psSysSearchBarLogicList.size() == 0) {
            return null;
        }
        return this.psSysSearchBarLogicList.iterator();
    }

    @Override
    protected Iterator<? extends IPSAppDEUILogicGroupDetail> getPSAppDEUILogicGroupDetails() {
        if (this.psSysSearchBarLogicList == null || this.psSysSearchBarLogicList.size() == 0) {
            return null;
        }
        return this.psSysSearchBarLogicList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u5206\u7ec4\u6a21\u5f0f", codelist="SearchBarGroupMode", ignoredumpvalues="SINGLE", fields={"GROUPMODE"})
    public String getGroupMode() {
        return this.psSysSearchBar.getGROUPMODE();
    }
}

