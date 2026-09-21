/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Control.Toolbar;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEUILogicGroupDetail;
import SA.SRFDA.PS.Core.App.View.IPSAppDEXDataView;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.Control.IPSControlContainer;
import SA.SRFDA.PS.Core.Control.IPSControlParam;
import SA.SRFDA.PS.Core.Control.PSControlImpl;
import SA.SRFDA.PS.Core.Control.Toolbar.IPSDETBSeperatorItem;
import SA.SRFDA.PS.Core.Control.Toolbar.IPSDETBUIActionItem;
import SA.SRFDA.PS.Core.Control.Toolbar.IPSDEToolbar;
import SA.SRFDA.PS.Core.Control.Toolbar.IPSDEToolbarItem;
import SA.SRFDA.PS.Core.Control.Toolbar.IPSDEToolbarLogic;
import SA.SRFDA.PS.Core.Control.Toolbar.IPSDEToolbarParam;
import SA.SRFDA.PS.Core.Control.Toolbar.IPSToolbarItemType;
import SA.SRFDA.PS.Core.Control.Toolbar.PSDEToolbarLogicImpl;
import SA.SRFDA.PS.Core.Control.Toolbar.PSDEToolbarParamImpl;
import SA.SRFDA.PS.Core.DataEntity.UIAction.IPSDEUIActionGroup;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Data.PSDEToolbar;
import SA.SRFDA.PS.Data.PSDEToolbarItem;
import SA.SRFDA.PS.Data.PSDEToolbarLogic;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelImplementMeta(implement="IPSControl", typevalues={"TOOLBAR"})
public class PSDEToolbarImpl
extends PSControlImpl
implements IPSDEToolbar {
    private static final Log log = LogFactory.getLog(PSDEToolbarImpl.class);
    protected PSDEToolbar psDEToolbar;
    protected ArrayList<IPSDEToolbarItem> psDEToolbarItemList = new ArrayList();
    protected ArrayList<IPSDEToolbarItem> allPSDEToolbarItemList = new ArrayList();
    protected PSDEToolbarParamImpl psDEToolbarParamImpl = new PSDEToolbarParamImpl();
    private static final Pattern codeNamePattern = Pattern.compile("[a-zA-Z_$][a-zA-Z0-9_$]*");
    private boolean bInvalidToolbar = false;
    protected List<PSDEToolbarLogicImpl> psDEToolbarLogicList = new ArrayList<PSDEToolbarLogicImpl>();

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSControlContainer iPSControlContainer, String strName, IPSControlParam iPSControlParam) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSControlContainer(iPSControlContainer);
            IPSDEToolbarParam iPSDEToolbarParam = (IPSDEToolbarParam)iPSControlParam;
            this.psDEToolbar = new PSDEToolbar();
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)iPSDEToolbarParam.getPSDEToolbarId())) {
                CallResult callResult = this.getPSModelHelper().getPSDEToolbar(iPSDEToolbarParam.getPSDEToolbarId(), this.psDEToolbar);
                if (callResult.isError()) {
                    throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u83b7\u53d6\u5b9e\u4f53\u5de5\u5177\u680f\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                this.setId(this.psDEToolbar.getPSDETOOLBARID());
            } else {
                this.setId(SA.SRFramework.Utility.StringHelper.Format((String)"%1$s_%2$s", (Object)this.getPSAppView().getId(), (Object)strName));
                this.bInvalidToolbar = true;
            }
            this.setName(strName);
            this.setLogicName(this.psDEToolbar.getPSDETOOLBARNAME());
            this.setPSObjectData(this.psDEToolbar);
            if (!(this.getPSDataEntity() != null && SA.SRFramework.Utility.StringHelper.Compare((String)this.psDEToolbar.getPSDEID(), (String)this.getPSDataEntity().getId(), (boolean)true) == 0 || SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEToolbar.getPSDEID()))) {
                this.setPSDataEntity(this.getPSAppView().getPSSystem().getPSDataEntity2(this.psDEToolbar.getPSDEID()));
            }
            this.psDEToolbarParamImpl.setPSDEToolbarId(this.psDEToolbar.getPSDETOOLBARID());
            this.psDEToolbarParamImpl.setPSDEUIActionGroupId(this.psDEToolbar.getPSDEUAGROUPID());
            this.psDEToolbarParamImpl.setNo2PSDEUIActionGroupId(this.psDEToolbar.getNO2PSDEUAGROUPID());
            this.psDEToolbarParamImpl.setNo3PSDEUIActionGroupId(this.psDEToolbar.getNO3PSDEUAGROUPID());
            this.psDEToolbarParamImpl.setNo4PSDEUIActionGroupId(this.psDEToolbar.getNO4PSDEUAGROUPID());
            this.psDEToolbarParamImpl.setNo5PSDEUIActionGroupId(this.psDEToolbar.getNO5PSDEUAGROUPID());
            this.psDEToolbarParamImpl.setNo6PSDEUIActionGroupId(this.psDEToolbar.getNO6PSDEUAGROUPID());
            this.psDEToolbarParamImpl.setToolbarStyle(this.psDEToolbar.getTOOLBARSTYLE());
            this.psDEToolbarParamImpl.setPSSysPFPluginId(this.psDEToolbar.getPSSYSPFPLUGINID());
            this.psDEToolbarParamImpl.setPSSysCssId(this.psDEToolbar.getPSSYSCSSID());
            this.psDEToolbarParamImpl.setPSDEUILogicGroupId(this.psDEToolbar.getPSCTRLLOGICGROUPID());
            this.psDEToolbarParamImpl.merge(iPSControlParam);
            super.init(iDAGlobalHelper, iPSControlContainer, strName, this.psDEToolbarParamImpl);
        }
        catch (Exception ex) {
            String strExInfo = StringHelper.format((String)"\u521d\u59cb\u5316\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage());
            log.error((Object)StringHelper.format((String)"%1$s%2$s", (Object)this.getLogName(), (Object)strExInfo), (Throwable)ex);
            if (this.getPSSystemUtil() != null) {
                this.getPSSystemUtil().getPSSysConsole().error(this.getLogName(), strExInfo);
            }
            throw ex;
        }
    }

    @Override
    protected void onInit() throws Exception {
        super.onInit();
        this.onPreparePSDEToolbarItems();
        this.onPreparePSDEToolbarLogics();
    }

    protected void onPreparePSDEToolbarItems() throws Exception {
        CallResult callResult;
        this.psDEToolbarItemList.clear();
        this.allPSDEToolbarItemList.clear();
        Vector<PSDEToolbarItem> psDEToolbarItemList = new Vector<PSDEToolbarItem>();
        if (!this.bInvalidToolbar && (callResult = this.getPSModelHelper().getPSDEToolbarItems(this.getId(), psDEToolbarItemList)).isError()) {
            throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u67e5\u8be2\u5de5\u5177\u680f\u9879\u96c6\u5408\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        HashMap<String, PSDEToolbarItem> psDEToolbarItemMap = new HashMap<String, PSDEToolbarItem>();
        HashMap<String, PSDEToolbarItem> psDEToolbarItemMap2 = new HashMap<String, PSDEToolbarItem>();
        int nSysTBItemIndex = 1;
        Vector<PSDEToolbarItem> psDEToolbarItemList2 = new Vector<PSDEToolbarItem>();
        for (PSDEToolbarItem psDEToolbarItem : psDEToolbarItemList) {
            String[] parts;
            String strPSDETBName;
            if (this.getPSApplication() != null && !SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)(strPSDETBName = psDEToolbarItem.getPSDETBITEMNAME())) && (parts = strPSDETBName.split("[.]")).length == 2) {
                if (SA.SRFramework.Utility.StringHelper.Compare((String)parts[1], (String)this.getPSApplication().getPKGCodeName(), (boolean)true) != 0) continue;
                psDEToolbarItem.setPSDETBITEMNAME(parts[0]);
            }
            psDEToolbarItemMap.put(psDEToolbarItem.getPSDETBITEMID(), psDEToolbarItem);
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)psDEToolbarItem.getPSDETBITEMNAME())) {
                if (psDEToolbarItemMap2.containsKey(psDEToolbarItem.getPSDETBITEMNAME().toLowerCase())) {
                    psDEToolbarItem.setPSDETBITEMNAME("");
                } else {
                    Matcher m = codeNamePattern.matcher(psDEToolbarItem.getPSDETBITEMNAME());
                    boolean b = m.matches();
                    if (!b) {
                        psDEToolbarItem.setPSDETBITEMNAME("");
                    } else {
                        psDEToolbarItemMap2.put(psDEToolbarItem.getPSDETBITEMNAME().toLowerCase(), psDEToolbarItem);
                    }
                }
            }
            if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)psDEToolbarItem.getPSDETBITEMNAME())) {
                do {
                    psDEToolbarItem.setPSDETBITEMNAME(SA.SRFramework.Utility.StringHelper.Format((String)"systbitem%1$s", (Object)nSysTBItemIndex));
                    ++nSysTBItemIndex;
                } while (psDEToolbarItemMap2.containsKey(psDEToolbarItem.getPSDETBITEMNAME().toLowerCase()));
                psDEToolbarItemMap2.put(psDEToolbarItem.getPSDETBITEMNAME().toLowerCase(), psDEToolbarItem);
            }
            psDEToolbarItemList2.add(psDEToolbarItem);
        }
        psDEToolbarItemList.clear();
        psDEToolbarItemList.addAll(psDEToolbarItemList2);
        for (PSDEToolbarItem psDEToolbarItem : psDEToolbarItemList) {
            if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)psDEToolbarItem.getPPSDETBITEMID())) continue;
            PSDEToolbarItem parentPSDEToolbarItem = (PSDEToolbarItem)((Object)psDEToolbarItemMap.get(psDEToolbarItem.getPPSDETBITEMID()));
            if (parentPSDEToolbarItem != null) {
                parentPSDEToolbarItem.getChildPSDEToolbarItems(true).add(psDEToolbarItem);
                continue;
            }
            this.getPSSystemUtil().getPSSysConsole().warn(this.getLogName(), SA.SRFramework.Utility.StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5de5\u5177\u680f\u9879\u7236\u9879[%1$s]\uff0c\u5ffd\u7565\u6b64\u6a21\u578b", (Object)psDEToolbarItem.getPPSDETBITEMID()), "PSDETBITEM", "REMOVE", psDEToolbarItem.getPSDETBITEMID());
        }
        boolean bLastSeperator = true;
        for (PSDEToolbarItem psDEToolbarItem : psDEToolbarItemList) {
            IPSDETBUIActionItem iPSDETBUIActionItem;
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)psDEToolbarItem.getPPSDETBITEMID())) continue;
            IPSToolbarItemType iPSToolbarItemType = this.getPSModelStorage().getPSToolbarItemType(psDEToolbarItem.getTBITEMTYPE());
            IPSDEToolbarItem iPSDEToolbarItem = iPSToolbarItemType.createPSDEToolbarItem(psDEToolbarItem);
            iPSDEToolbarItem.init(this.getDAGlobalHelper(), this, null, psDEToolbarItem);
            if (!iPSDEToolbarItem.isValid()) continue;
            if (iPSDEToolbarItem instanceof IPSDETBSeperatorItem) {
                if (bLastSeperator) continue;
                bLastSeperator = true;
            } else {
                bLastSeperator = false;
            }
            if (iPSDEToolbarItem instanceof IPSDETBUIActionItem && (iPSDETBUIActionItem = (IPSDETBUIActionItem)iPSDEToolbarItem).getPSDEUIAction().isUIActionGroup(iPSDETBUIActionItem)) {
                Iterator<IPSDEToolbarItem> childPSDEToolbarItems = iPSDETBUIActionItem.getPSDEToolbarItems();
                if (childPSDEToolbarItems == null) continue;
                while (childPSDEToolbarItems.hasNext()) {
                    this.psDEToolbarItemList.add(childPSDEToolbarItems.next());
                }
                continue;
            }
            this.psDEToolbarItemList.add(iPSDEToolbarItem);
        }
        if (bLastSeperator && this.psDEToolbarItemList.size() > 0) {
            this.psDEToolbarItemList.remove(this.psDEToolbarItemList.size() - 1);
        }
        for (IPSDEToolbarItem iPSDEToolbarItem : this.psDEToolbarItemList) {
            iPSDEToolbarItem.fillPSDEToolbarItems(this.allPSDEToolbarItemList);
        }
    }

    protected void onPreparePSDEToolbarLogics() throws Exception {
        this.psDEToolbarLogicList.clear();
        this.onPreparePSDEToolbarLogics(this.getId());
    }

    protected void onPreparePSDEToolbarLogics(String strPSDEToolbarId) throws Exception {
        Vector<PSDEToolbarLogic> psDEToolbarLogicList = new Vector<PSDEToolbarLogic>();
        CallResult callResult = this.getPSModelHelper().getPSDEToolbarLogics(strPSDEToolbarId, psDEToolbarLogicList);
        if (callResult.isError()) {
            throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u67e5\u8be2\u5de5\u5177\u680f\u903b\u8f91\u96c6\u5408\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSDEToolbarLogic psDEToolbarLogic : psDEToolbarLogicList) {
            PSDEToolbarLogicImpl psDEToolbarLogicImpl = new PSDEToolbarLogicImpl();
            psDEToolbarLogicImpl.init(this.getDAGlobalHelper(), this, psDEToolbarLogic);
            this.psDEToolbarLogicList.add(psDEToolbarLogicImpl);
        }
    }

    @Override
    protected String onGetControlType() {
        return "TOOLBAR";
    }

    @Override
    @PSModelRTMeta(description="\u5de5\u5177\u680f\u9879\u96c6\u5408", modeltype="SA.SRFDA.PS.Core.Control.Toolbar.IPSDEToolbarItemAll", child=true, outputdoc="false")
    public Iterator<IPSDEToolbarItem> getPSDEToolbarItems() {
        return this.psDEToolbarItemList.iterator();
    }

    @Override
    public IPSDEUIActionGroup getPSDEUIActionGroup(String strPSSysDEUIActionId) throws Exception {
        String strPSDEUIActionGroupId = "";
        strPSDEUIActionGroupId = SA.SRFramework.Utility.StringHelper.Compare((String)strPSSysDEUIActionId, (String)"VIEW_DEBHGROUP001", (boolean)true) == 0 || SA.SRFramework.Utility.StringHelper.Compare((String)strPSSysDEUIActionId, (String)"VIEW_DEBHGROUPEX001", (boolean)true) == 0 ? this.psDEToolbarParamImpl.getPSDEUIActionGroupId() : (SA.SRFramework.Utility.StringHelper.Compare((String)strPSSysDEUIActionId, (String)"VIEW_DEBHGROUP002", (boolean)true) == 0 || SA.SRFramework.Utility.StringHelper.Compare((String)strPSSysDEUIActionId, (String)"VIEW_DEBHGROUPEX002", (boolean)true) == 0 ? this.psDEToolbarParamImpl.getNo2PSDEUIActionGroupId() : (SA.SRFramework.Utility.StringHelper.Compare((String)strPSSysDEUIActionId, (String)"VIEW_DEBHGROUP003", (boolean)true) == 0 || SA.SRFramework.Utility.StringHelper.Compare((String)strPSSysDEUIActionId, (String)"VIEW_DEBHGROUPEX003", (boolean)true) == 0 ? this.psDEToolbarParamImpl.getNo3PSDEUIActionGroupId() : (SA.SRFramework.Utility.StringHelper.Compare((String)strPSSysDEUIActionId, (String)"VIEW_DEBHGROUP004", (boolean)true) == 0 || SA.SRFramework.Utility.StringHelper.Compare((String)strPSSysDEUIActionId, (String)"VIEW_DEBHGROUPEX004", (boolean)true) == 0 ? this.psDEToolbarParamImpl.getNo4PSDEUIActionGroupId() : (SA.SRFramework.Utility.StringHelper.Compare((String)strPSSysDEUIActionId, (String)"VIEW_DEBHGROUP005", (boolean)true) == 0 || SA.SRFramework.Utility.StringHelper.Compare((String)strPSSysDEUIActionId, (String)"VIEW_DEBHGROUPEX005", (boolean)true) == 0 ? this.psDEToolbarParamImpl.getNo5PSDEUIActionGroupId() : (SA.SRFramework.Utility.StringHelper.Compare((String)strPSSysDEUIActionId, (String)"VIEW_DEBHGROUP006", (boolean)true) == 0 || SA.SRFramework.Utility.StringHelper.Compare((String)strPSSysDEUIActionId, (String)"VIEW_DEBHGROUPEX006", (boolean)true) == 0 ? this.psDEToolbarParamImpl.getNo6PSDEUIActionGroupId() : strPSSysDEUIActionId)))));
        if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strPSDEUIActionGroupId)) {
            return null;
        }
        try {
            IPSDEUIActionGroup iPSDEUIActionGroup = null;
            if (this.getPSAppDataEntity() != null) {
                iPSDEUIActionGroup = this.getPSAppDataEntity().getPSAppDEUIActionGroup(strPSDEUIActionGroupId, true, this);
            }
            if (iPSDEUIActionGroup == null) {
                iPSDEUIActionGroup = this.getPSDataEntity().getPSDEUIActionGroup(strPSDEUIActionGroupId);
            }
            return iPSDEUIActionGroup;
        }
        catch (Exception ex) {
            throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5de5\u5177\u680f\u9884\u7f6e\u754c\u9762\u884c\u4e3a\u7ec4[%1$s]\u7ed1\u5b9a\u7684\u5bf9\u8c61[%2$s]", (Object)strPSSysDEUIActionId, (Object)strPSDEUIActionGroupId), ex);
        }
    }

    @Override
    public void fillRelatedPSAppViews(ArrayList<IPSAppView> relatedAppViewList) throws Exception {
        super.fillRelatedPSAppViews(relatedAppViewList);
        for (IPSDEToolbarItem iPSDEToolbarItem : this.psDEToolbarItemList) {
            iPSDEToolbarItem.fillRelatedPSAppViews(relatedAppViewList);
        }
    }

    @Override
    public String getModelScope() {
        return "DE";
    }

    @Override
    @PSModelRTMeta(description="\u5de5\u5177\u680f\u6837\u5f0f", model="PSDEViewCtrl", fields={"CTRLPARAM3"})
    public String getToolbarStyle() {
        return this.psDEToolbarParamImpl.getToolbarStyle();
    }

    @Override
    public String getModelType() {
        return "PSDETOOLBAR";
    }

    @Override
    @PSModelRTMeta(description="\u5168\u90e8\u5de5\u5177\u680f\u9879\u96c6\u5408", group="\u90e8\u4ef6\u5143\u7d20", order=165)
    public Iterator<IPSDEToolbarItem> getAllPSDEToolbarItems() throws Exception {
        return this.allPSDEToolbarItemList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u5de5\u5177\u680f\u6240\u6709\u8005", outputdoc="false", ignorert=3)
    public Object getOwner() {
        if (this.psDEToolbarParamImpl.getOwner() != null) {
            return this.psDEToolbarParamImpl.getOwner();
        }
        return this.getPSControlContainer();
    }

    @Override
    protected boolean isExportModelAlways() {
        return true;
    }

    @Override
    @PSModelRTMeta(description="\u5de5\u5177\u680f\u903b\u8f91\u96c6\u5408", group="\u90e8\u4ef6\u903b\u8f91", order=217)
    public Iterator<? extends IPSDEToolbarLogic> getPSDEToolbarLogics() {
        if (this.psDEToolbarLogicList == null || this.psDEToolbarLogicList.size() == 0) {
            return null;
        }
        return this.psDEToolbarLogicList.iterator();
    }

    @Override
    protected Iterator<? extends IPSAppDEUILogicGroupDetail> getPSAppDEUILogicGroupDetails() {
        if (this.psDEToolbarLogicList == null || this.psDEToolbarLogicList.size() == 0) {
            return null;
        }
        return this.psDEToolbarLogicList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u754c\u9762\u884c\u4e3a\u6570\u636e\u90e8\u4ef6\u540d\u79f0")
    public String getXDataControlName() {
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEToolbarParamImpl.getRefCtrlName())) {
            return this.psDEToolbarParamImpl.getRefCtrlName();
        }
        if (this.getOwner() instanceof IPSAppDEXDataView) {
            return ((IPSAppDEXDataView)this.getOwner()).getXDataControlName();
        }
        return null;
    }
}

