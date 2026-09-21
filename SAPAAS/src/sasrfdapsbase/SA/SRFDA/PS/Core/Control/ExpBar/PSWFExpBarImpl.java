/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Utility.Helper
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.control.expbar.ExpBarItem
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pswf.core.IWFProcessModel
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Control.ExpBar;

import SA.SRFDA.PS.Core.App.Control.IPSAppCounter;
import SA.SRFDA.PS.Core.App.View.IPSAppDEWFView;
import SA.SRFDA.PS.Core.CodeList.IPSCodeItem;
import SA.SRFDA.PS.Core.CodeList.IPSCodeList;
import SA.SRFDA.PS.Core.Control.Counter.IPSSysCounterRef;
import SA.SRFDA.PS.Core.Control.ExpBar.IPSWFExpBar;
import SA.SRFDA.PS.Core.Control.ExpBar.IPSWFExpBarParam;
import SA.SRFDA.PS.Core.Control.ExpBar.PSExpBarImpl;
import SA.SRFDA.PS.Core.Control.IPSControlContainer;
import SA.SRFDA.PS.Core.Control.IPSControlParam;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.WF.IPSDEWF;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Core.WF.IPSWFParallelSubWFProcess;
import SA.SRFDA.PS.Core.WF.IPSWFProcessSubWF;
import SA.SRFDA.PS.Core.WF.IPSWFVersion;
import SA.SRFDA.PS.Core.WF.IPSWorkflow;
import SA.SRFDA.PS.Data.PSAppViewRef;
import SA.SRFDA.PS.Data.PSDEViewBase;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Utility.Helper;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import net.ibizsys.paas.control.expbar.ExpBarItem;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pswf.core.IWFProcessModel;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelImplementMeta(implement="IPSControl", typevalues={"WFEXPBAR"})
public class PSWFExpBarImpl
extends PSExpBarImpl
implements IPSWFExpBar {
    private static final Log log = LogFactory.getLog(PSWFExpBarImpl.class);
    private IPSWFExpBarParam iPSWFExpBarParam = null;
    private Map<String, String> extCntStateMap = new LinkedHashMap<String, String>();

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSControlContainer iPSControlContainer, String strName, IPSControlParam iPSControlParam) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSControlContainer(iPSControlContainer);
            this.iPSWFExpBarParam = (IPSWFExpBarParam)iPSControlParam;
            this.setId(String.valueOf(iPSControlContainer.getPSAppView().getId()) + "_" + strName);
            this.setName(strName);
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
        super.onInit();
        this.fillWFExpBarItems((ExpBarItem)this.getRootItem());
    }

    @Override
    protected IPSSysCounterRef preparePSSysCounterRef() throws Exception {
        String strWFExpCounterId = this.iPSWFExpBarParam.getPSSysCounterId();
        IPSAppCounter iPSSysCounter = null;
        if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strWFExpCounterId)) {
            strWFExpCounterId = Helper.GenUniqueId((String)this.getPSAppView().getPSApplication().getPSSystem().getId(), (String)"WFEXPBAR");
            iPSSysCounter = this.getPSAppView().getPSApplication().getPSAppCounter(strWFExpCounterId, true);
        } else {
            iPSSysCounter = this.getPSAppView().getPSApplication().getPSAppCounter(strWFExpCounterId, false);
        }
        if (iPSSysCounter != null) {
            JSONObject refModeObj = new JSONObject();
            refModeObj.put("srfwfid", (Object)this.getPSWorkflow().getId());
            refModeObj.put("srfdeid", (Object)this.getPSDEWF().getPSDataEntity().getName());
            if (this.isPrepareDefaultPSAppViewLogics()) {
                return this.registerPSAppCounter(iPSSysCounter, refModeObj);
            }
            return this.getPSAppView().registerPSSysCounter(iPSSysCounter, refModeObj);
        }
        return super.preparePSSysCounterRef();
    }

    protected IPSWFExpBarParam getPSWFExpBarParam() {
        return this.iPSWFExpBarParam;
    }

    @Override
    protected String onGetControlType() {
        return "WFEXPBAR";
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u5de5\u4f5c\u6d41\u5bf9\u8c61")
    public IPSDEWF getPSDEWF() {
        return ((IPSAppDEWFView)this.getPSAppView()).getPSDEWF();
    }

    @Override
    @PSModelRTMeta(description="\u5de5\u4f5c\u6d41\u5bf9\u8c61")
    public IPSWorkflow getPSWorkflow() {
        return ((IPSAppDEWFView)this.getPSAppView()).getPSWorkflow();
    }

    @PSModelRTMeta(description="\u5de5\u4f5c\u7248\u672c\u5bf9\u8c61", hideempty2=true)
    public IPSWFVersion getPSWFVersion() {
        return ((IPSAppDEWFView)this.getPSAppView()).getPSWFVersion();
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        try {
            if (this.getPSDEWF().getPSDataEntity().getPSDEWFCount() > 1) {
                return this.getPSDEWF().getCodeName();
            }
        }
        catch (Exception ex) {
            log.error((Object)ex);
        }
        return super.getCodeName();
    }

    protected void fillWFExpBarItems(ExpBarItem rootNode) throws Exception {
        if (this.isOutputMyWorkFirst()) {
            if (this.isOutputSection("MYWFWORK")) {
                this.fillMyWFWorkItems(rootNode);
            }
            if (this.isOutputSection(this.getPSWFExpBarParam().getWFDataSector())) {
                this.fillWFExpBarItems(rootNode, this.getPSWFExpBarParam().getWFDataSector());
            }
            if (this.isOutputMyHistoryWork()) {
                ExpBarItem wfStepTreeNodeConfig = new ExpBarItem();
                String strMyHistoryWorkName = this.getPSWFExpBarParam().getMyHistoryWorkName();
                if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strMyHistoryWorkName)) {
                    strMyHistoryWorkName = "\u5386\u53f2\u5904\u7406";
                }
                wfStepTreeNodeConfig.setText(strMyHistoryWorkName);
                wfStepTreeNodeConfig.setId(SA.SRFramework.Utility.StringHelper.Format((String)"%1$s_HISTORY", (Object)"MYWFWORK"));
                rootNode.getItems().add(wfStepTreeNodeConfig);
            }
        } else {
            if (this.isOutputSection(this.getPSWFExpBarParam().getWFDataSector())) {
                this.fillWFExpBarItems(rootNode, this.getPSWFExpBarParam().getWFDataSector());
            }
            if (this.isOutputSection("MYWFWORK")) {
                this.fillMyWFWorkItems(rootNode);
            }
            if (this.isOutputMyHistoryWork()) {
                ExpBarItem wfStepTreeNodeConfig = new ExpBarItem();
                String strMyHistoryWorkName = this.getPSWFExpBarParam().getMyHistoryWorkName();
                if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strMyHistoryWorkName)) {
                    strMyHistoryWorkName = "\u5386\u53f2\u5904\u7406";
                }
                wfStepTreeNodeConfig.setText(strMyHistoryWorkName);
                wfStepTreeNodeConfig.setId(SA.SRFramework.Utility.StringHelper.Format((String)"%1$s_HISTORY", (Object)"MYWFWORK"));
                rootNode.getItems().add(wfStepTreeNodeConfig);
            }
        }
    }

    protected void fillMyWFWorkItems(ExpBarItem rootNode) throws Exception {
        IPSCodeList wfStepCodeList;
        String strNodeTextFormat = "%1$s";
        ExpBarItem treeNodeConfig = new ExpBarItem();
        treeNodeConfig.setId("MYWFWORK");
        String strMyWFWorkName = this.getPSWFExpBarParam().getMyWorkName();
        if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strMyWFWorkName)) {
            strMyWFWorkName = this.getPSDEWF().getMyWFWorkCaption();
        }
        if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strMyWFWorkName)) {
            strMyWFWorkName = "\u6211\u7684\u5de5\u4f5c";
        }
        treeNodeConfig.setText(SA.SRFramework.Utility.StringHelper.Format((String)strNodeTextFormat, (Object)strMyWFWorkName));
        if (this.getPSDEWF().getMyWFWorkCapPSLanguageRes() != null) {
            treeNodeConfig.setTextLanResTag(this.getPSDEWF().getMyWFWorkCapPSLanguageRes().getLanResTag());
        }
        treeNodeConfig.setCounterId("V");
        treeNodeConfig.setExpViewId(this.getSectionViewId("MYWFWORK"));
        rootNode.getItems().add(treeNodeConfig);
        if (!this.isDynamicCtrl() && (wfStepCodeList = this.getPSWorkflow().getWFStepPSCodeList()) != null) {
            Iterator<IPSCodeItem> codeItems = wfStepCodeList.getPSCodeItems();
            while (codeItems.hasNext()) {
                IPSCodeItem wfStepPSCodeItem = codeItems.next();
                if (!this.isOutputSection("MYWFWORK", wfStepPSCodeItem.getValue())) continue;
                String strWFStepCodeItemValue = wfStepPSCodeItem.getValue();
                IWFProcessModel iWFProcessModel = this.getPSWFVersion().getWFProcessModelByWFStepValue(strWFStepCodeItemValue, true);
                if (iWFProcessModel != null && iWFProcessModel instanceof IPSWFParallelSubWFProcess) {
                    this.fillMyParallelSubWFWorkItems(treeNodeConfig, wfStepPSCodeItem, (IPSWFParallelSubWFProcess)iWFProcessModel);
                    continue;
                }
                ExpBarItem wfStepTreeNodeConfig = new ExpBarItem();
                wfStepTreeNodeConfig.setText(SA.SRFramework.Utility.StringHelper.Format((String)strNodeTextFormat, (Object)wfStepPSCodeItem.getText()));
                wfStepTreeNodeConfig.setId(SA.SRFramework.Utility.StringHelper.Format((String)"%1$s:%2$s", (Object)"MYWFWORK", (Object)wfStepPSCodeItem.getValue()));
                wfStepTreeNodeConfig.setExpViewId(this.getSectionViewId("MYWFWORK", wfStepPSCodeItem.getValue()));
                wfStepTreeNodeConfig.setViewParam("srfwfstep", wfStepPSCodeItem.getValue());
                if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)wfStepPSCodeItem.getIconCls())) {
                    wfStepTreeNodeConfig.setIconCls(wfStepPSCodeItem.getIconCls());
                } else if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)wfStepPSCodeItem.getIconPath())) {
                    wfStepTreeNodeConfig.setIconPath(wfStepPSCodeItem.getIconPath());
                }
                if (this.isEnableCounter()) {
                    wfStepTreeNodeConfig.setCounterId(SA.SRFramework.Utility.StringHelper.Format((String)"V%1$s", (Object)wfStepPSCodeItem.getValue().replace(":", "_")));
                    wfStepTreeNodeConfig.setCounterMode(1);
                }
                if (wfStepPSCodeItem.getTextPSLanguageRes() != null) {
                    wfStepTreeNodeConfig.setTextLanResTag(wfStepPSCodeItem.getTextLanResTag());
                }
                treeNodeConfig.getItems().add(wfStepTreeNodeConfig);
            }
        }
        boolean bExpand = this.getPSWFExpBarParam().isExpandMyWork();
        treeNodeConfig.setExpanded(bExpand);
    }

    protected void fillMyParallelSubWFWorkItems(ExpBarItem treeNodeConfig, IPSCodeItem mainWFStepIPSCodeItem, IPSWFParallelSubWFProcess iPSWFParallelSubWFProcess) throws Exception {
        String strNodeTextFormat = "%1$s";
        Iterator<IPSWFProcessSubWF> psWFProcessSubWFs = iPSWFParallelSubWFProcess.getPSWFProcessSubWFs();
        boolean bOutputWFParallel = this.getPSWFExpBarParam().isOutputWFParallelFolder();
        while (psWFProcessSubWFs.hasNext()) {
            IPSWFProcessSubWF iPSWFProcessSubWF = psWFProcessSubWFs.next();
            IPSWorkflow iWFModel = this.getPSWorkflow().getPSSystem().getPSWorkflow(iPSWFProcessSubWF.getWFId());
            IPSCodeList iCodeList = iWFModel.getWFStepPSCodeList();
            if (iCodeList == null) continue;
            Iterator<IPSCodeItem> codeItems = iCodeList.getPSCodeItems();
            while (codeItems.hasNext()) {
                IPSCodeItem wfStepPSCodeItem = codeItems.next();
                ExpBarItem wfStepTreeNodeConfig = new ExpBarItem();
                wfStepTreeNodeConfig.setTextCls("WFMyWorkTreeNodeText");
                wfStepTreeNodeConfig.setText(SA.SRFramework.Utility.StringHelper.Format((String)strNodeTextFormat, (Object)SA.SRFramework.Utility.StringHelper.Format((String)"%2$s [%1$s]", (Object)iPSWFProcessSubWF.getName(), (Object)wfStepPSCodeItem.getText())));
                wfStepTreeNodeConfig.setId(SA.SRFramework.Utility.StringHelper.Format((String)"%1$s:%2$s:%3$s:%4$s", (Object)"MYWFWORK", (Object)mainWFStepIPSCodeItem.getValue(), (Object)iPSWFProcessSubWF.getCodeName(), (Object)wfStepPSCodeItem.getValue()));
                if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)wfStepPSCodeItem.getIconCls())) {
                    wfStepTreeNodeConfig.setIconCls(wfStepPSCodeItem.getIconCls());
                } else if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)wfStepPSCodeItem.getIconPath())) {
                    wfStepTreeNodeConfig.setIconPath(wfStepPSCodeItem.getIconPath());
                }
                if (this.isEnableCounter()) {
                    wfStepTreeNodeConfig.setCounterId(SA.SRFramework.Utility.StringHelper.Format((String)"V%1$s", (Object)SA.SRFramework.Utility.StringHelper.Format((String)"%1$s:%2$s:%3$s", (Object)mainWFStepIPSCodeItem.getValue(), (Object)iPSWFProcessSubWF.getWFId(), (Object)wfStepPSCodeItem.getValue()).replace(":", "_")));
                    wfStepTreeNodeConfig.setCounterMode(1);
                }
                wfStepTreeNodeConfig.setExpViewId(this.getSectionViewId("MYWFWORK", iPSWFProcessSubWF, wfStepPSCodeItem.getValue()));
                if (wfStepPSCodeItem.getTextPSLanguageRes() != null) {
                    wfStepTreeNodeConfig.setTextLanResTag(wfStepPSCodeItem.getTextLanResTag());
                }
                treeNodeConfig.getItems().add(wfStepTreeNodeConfig);
            }
        }
    }

    protected void fillWFExpBarItems(ExpBarItem rootNode, String strGroup) throws Exception {
        ExpBarItem treeNodeConfig = new ExpBarItem();
        treeNodeConfig.setText(this.getSectionName(strGroup));
        String strTextLanResTag = this.getSectionNameLanResTag(strGroup);
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strTextLanResTag)) {
            treeNodeConfig.setTextLanResTag(strTextLanResTag);
        }
        treeNodeConfig.setId(strGroup);
        treeNodeConfig.setTextCls("WFTreeNodeText");
        treeNodeConfig.setExpViewId(this.getSectionViewId(strGroup));
        rootNode.getItems().add(treeNodeConfig);
        IPSCodeList stateIPSCodeList = this.getPSWorkflow().getEntityStatePSCodeList();
        Iterator<IPSCodeItem> stateCodeItems = stateIPSCodeList.getPSCodeItems();
        while (stateCodeItems.hasNext()) {
            IPSCodeItem codeItemConfig = stateCodeItems.next();
            if (!this.isOutputSection(strGroup, codeItemConfig.getValue())) continue;
            ExpBarItem stateTreeNodeConfig = new ExpBarItem();
            stateTreeNodeConfig.setText(codeItemConfig.getText());
            stateTreeNodeConfig.setId(SA.SRFramework.Utility.StringHelper.Format((String)"%1$s:%2$s", (Object)strGroup, (Object)codeItemConfig.getValue()));
            stateTreeNodeConfig.setTextCls("WFTreeNodeText");
            stateTreeNodeConfig.setExpViewId(this.getSectionViewId(strGroup, codeItemConfig.getValue()));
            stateTreeNodeConfig.setViewParam("srfwfudstate", codeItemConfig.getValue());
            if (codeItemConfig.getTextPSLanguageRes() != null) {
                stateTreeNodeConfig.setTextLanResTag(codeItemConfig.getTextLanResTag());
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)codeItemConfig.getIconCls())) {
                stateTreeNodeConfig.setIconCls(codeItemConfig.getIconCls());
            } else if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)codeItemConfig.getIconPath())) {
                stateTreeNodeConfig.setIconPath(codeItemConfig.getIconPath());
            }
            treeNodeConfig.getItems().add(stateTreeNodeConfig);
            if (!this.isDynamicCtrl() && this.getPSWorkflow().isEntityWFState(codeItemConfig.getValue()) && this.getPSWFExpBarParam().isOutputMyDataWFSteps()) {
                stateTreeNodeConfig.setCounterId(PSWFExpBarImpl.calcWFStepCounterId(SA.SRFramework.Utility.StringHelper.Format((String)"%1$s:%2$s", (Object)strGroup, (Object)codeItemConfig.getValue())));
                IPSCodeList wfStepIPSCodeList = this.getPSWorkflow().getWFStepPSCodeList();
                if (wfStepIPSCodeList == null) continue;
                Iterator<IPSCodeItem> wfStepCodeItems = wfStepIPSCodeList.getPSCodeItems();
                while (wfStepCodeItems.hasNext()) {
                    IPSCodeItem wfStepPSCodeItem = wfStepCodeItems.next();
                    if (!this.isOutputSection(strGroup, codeItemConfig.getValue(), wfStepPSCodeItem.getValue())) continue;
                    String strWFStepCodeItemValue = wfStepPSCodeItem.getValue();
                    IWFProcessModel iWFProcessModel = this.getPSWFVersion().getWFProcessModelByWFStepValue(strWFStepCodeItemValue, true);
                    IPSWFParallelSubWFProcess iPSWFParallelSubWFProcess = null;
                    if (iWFProcessModel != null && iWFProcessModel instanceof IPSWFParallelSubWFProcess) {
                        iPSWFParallelSubWFProcess = (IPSWFParallelSubWFProcess)iWFProcessModel;
                    }
                    if (iPSWFParallelSubWFProcess == null) {
                        ExpBarItem wfStepTreeNodeConfig = new ExpBarItem();
                        wfStepTreeNodeConfig.setText(wfStepPSCodeItem.getText());
                        wfStepTreeNodeConfig.setId(SA.SRFramework.Utility.StringHelper.Format((String)"%1$s:%2$s:%3$s", (Object)strGroup, (Object)codeItemConfig.getValue(), (Object)wfStepPSCodeItem.getValue()));
                        wfStepTreeNodeConfig.setTextCls("WFTreeNodeText");
                        wfStepTreeNodeConfig.setViewParam("srfwfudstate", codeItemConfig.getValue());
                        wfStepTreeNodeConfig.setViewParam("srfwfstep", wfStepPSCodeItem.getValue());
                        wfStepTreeNodeConfig.setExpViewId(this.getSectionViewId(strGroup, codeItemConfig.getValue(), wfStepPSCodeItem.getValue()));
                        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)wfStepPSCodeItem.getIconCls())) {
                            wfStepTreeNodeConfig.setIconCls(wfStepPSCodeItem.getIconCls());
                        } else if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)wfStepPSCodeItem.getIconPath())) {
                            wfStepTreeNodeConfig.setIconPath(wfStepPSCodeItem.getIconPath());
                        }
                        wfStepTreeNodeConfig.setCounterId(PSWFExpBarImpl.calcWFStepCounterId(SA.SRFramework.Utility.StringHelper.Format((String)"%1$s:%2$s:%3$s", (Object)strGroup, (Object)codeItemConfig.getValue(), (Object)wfStepPSCodeItem.getValue())));
                        if (wfStepPSCodeItem.getTextPSLanguageRes() != null) {
                            wfStepTreeNodeConfig.setTextLanResTag(wfStepPSCodeItem.getTextLanResTag());
                        }
                        stateTreeNodeConfig.getItems().add(wfStepTreeNodeConfig);
                        continue;
                    }
                    this.fillWFParallelSubWFWorkItems(stateTreeNodeConfig, SA.SRFramework.Utility.StringHelper.Format((String)"%1$s:%2$s:%3$s", (Object)strGroup, (Object)codeItemConfig.getValue(), (Object)wfStepPSCodeItem.getValue()), (IPSWFParallelSubWFProcess)iWFProcessModel);
                }
                stateTreeNodeConfig.setExpanded(true);
                continue;
            }
            if (this.extCntStateMap.size() <= 0 || !this.extCntStateMap.containsKey("*") && !this.extCntStateMap.containsKey(codeItemConfig.getValue())) continue;
            stateTreeNodeConfig.setCounterId(PSWFExpBarImpl.calcWFStepCounterId2(SA.SRFramework.Utility.StringHelper.Format((String)"%1$s:%2$s", (Object)strGroup, (Object)codeItemConfig.getValue())));
        }
    }

    protected void fillWFParallelSubWFWorkItems(ExpBarItem treeNodeConfig, String strPNodeId, IPSWFParallelSubWFProcess iPSWFParallelSubWFProcess) throws Exception {
        Iterator<IPSWFProcessSubWF> psWFProcessSubWFs = iPSWFParallelSubWFProcess.getPSWFProcessSubWFs();
        boolean bOutputWFParallel = this.getPSWFExpBarParam().isOutputWFParallelFolder();
        if (iPSWFParallelSubWFProcess.getPSWFProcessSubWFCount() <= 1) {
            bOutputWFParallel = false;
        }
        treeNodeConfig.setExpanded(true);
        while (psWFProcessSubWFs.hasNext()) {
            IPSWFProcessSubWF iPSWFProcessSubWF = psWFProcessSubWFs.next();
            IPSWorkflow iWFModel = this.getPSWorkflow().getPSSystem().getPSWorkflow(iPSWFProcessSubWF.getWFId());
            ExpBarItem wfParallelSubWfNodeConfig = null;
            wfParallelSubWfNodeConfig = new ExpBarItem();
            wfParallelSubWfNodeConfig.setText(iPSWFProcessSubWF.getName());
            wfParallelSubWfNodeConfig.setId(SA.SRFramework.Utility.StringHelper.Format((String)"%1$s:%2$s", (Object)treeNodeConfig.getId(), (Object)iPSWFProcessSubWF.getId()));
            wfParallelSubWfNodeConfig.setTextCls("WFTreeNodeText");
            treeNodeConfig.getItems().add(wfParallelSubWfNodeConfig);
            wfParallelSubWfNodeConfig.setCounterId(PSWFExpBarImpl.calcWFStepCounterId(SA.SRFramework.Utility.StringHelper.Format((String)"%1$s:%2$s", (Object)strPNodeId, (Object)iPSWFProcessSubWF.getId())));
            wfParallelSubWfNodeConfig.setExpViewId(this.getSectionViewId(strPNodeId, iPSWFProcessSubWF));
        }
    }

    protected static String calcWFStepCounterId(String strNodeId) {
        String[] parts = strNodeId.split("[:]");
        String strStep = "";
        if (parts.length == 3) {
            strStep = parts[2];
        }
        if (parts.length > 3) {
            int i = 2;
            while (i < parts.length) {
                if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strStep)) {
                    strStep = String.valueOf(strStep) + "_";
                }
                strStep = String.valueOf(strStep) + parts[i];
                ++i;
            }
        }
        return SA.SRFramework.Utility.StringHelper.Format((String)"S%1$s", (Object)strStep);
    }

    protected static String calcWFStepCounterId2(String strNodeId) {
        String[] parts = strNodeId.split("[:]");
        String strStep = "";
        if (parts.length == 2) {
            strStep = parts[1];
        }
        return SA.SRFramework.Utility.StringHelper.Format((String)"E%1$s", (Object)strStep);
    }

    protected boolean isOutputSection(String strSectionName, String strSectionValue) {
        return true;
    }

    protected boolean isOutputSection(String strGroup, String strState, String strWFStep) {
        return true;
    }

    @Override
    protected String getSectionName(String strSectionName) {
        String strKey = SA.SRFramework.Utility.StringHelper.Format((String)"%1$s.%2$s", (Object)"SECTION.NAME", (Object)strSectionName);
        String strName = this.getPSWFExpBarParam().getCtrlParam(strKey, "");
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strName)) {
            return strName;
        }
        if (SA.SRFramework.Utility.StringHelper.Compare((String)strSectionName, (String)"MY", (boolean)true) == 0 || SA.SRFramework.Utility.StringHelper.Compare((String)strSectionName, (String)"ALL", (boolean)true) == 0) {
            String strMyWFDataCaption = this.getPSDEWF().getMyWFDataCaption();
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strMyWFDataCaption)) {
                return strMyWFDataCaption;
            }
            String strDELogicName = this.getPSDataEntity().getLogicName();
            if (SA.SRFramework.Utility.StringHelper.Compare((String)strSectionName, (String)"MY", (boolean)true) == 0) {
                return SA.SRFramework.Utility.StringHelper.Format((String)"\u6211\u7684%1$s", (Object)strDELogicName);
            }
            if (SA.SRFramework.Utility.StringHelper.Compare((String)strSectionName, (String)"ALL", (boolean)true) == 0) {
                return SA.SRFramework.Utility.StringHelper.Format((String)"\u5168\u90e8%1$s", (Object)strDELogicName);
            }
        }
        return super.getSectionName(strSectionName);
    }

    @Override
    protected String getSectionNameLanResTag(String strSectionName) {
        IPSLanguageRes iPSLanguageRes;
        String strKey = SA.SRFramework.Utility.StringHelper.Format((String)"%1$s.%2$s", (Object)"SECTION.NAMELANRESTAG", (Object)strSectionName);
        String strName = this.getPSWFExpBarParam().getCtrlParam(strKey, "");
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strName)) {
            return strName;
        }
        if ((SA.SRFramework.Utility.StringHelper.Compare((String)strSectionName, (String)"MY", (boolean)true) == 0 || SA.SRFramework.Utility.StringHelper.Compare((String)strSectionName, (String)"ALL", (boolean)true) == 0) && (iPSLanguageRes = this.getPSDEWF().getMyWFDataCapPSLanguageRes()) != null) {
            return iPSLanguageRes.getLanResTag();
        }
        return super.getSectionNameLanResTag(strSectionName);
    }

    @Override
    protected String getSectionViewId(String strGroup) throws Exception {
        String strViewId;
        String strPDTParam = "";
        PSDEViewBase psDEViewBase = null;
        if (SA.SRFramework.Utility.StringHelper.Compare((String)strGroup, (String)"MY", (boolean)true) == 0 || SA.SRFramework.Utility.StringHelper.Compare((String)strGroup, (String)"ALL", (boolean)true) == 0) {
            strPDTParam = SA.SRFramework.Utility.StringHelper.Format((String)"%1$s:D", (Object)this.getPSDEWF().getCodeName());
            strViewId = super.getSectionViewId(strPDTParam);
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strViewId)) {
                return strViewId;
            }
            psDEViewBase = this.getPSDataEntity().getPSDEViewDataByPDT("WFMDATAVIEW", strPDTParam, true);
            if (psDEViewBase == null) {
                psDEViewBase = this.getPSDataEntity().getPSDEViewDataByPDT("MDATAVIEW", "", true);
            }
        } else if (SA.SRFramework.Utility.StringHelper.Compare((String)strGroup, (String)"MYWFWORK", (boolean)true) == 0) {
            strPDTParam = SA.SRFramework.Utility.StringHelper.Format((String)"%1$s:W", (Object)this.getPSDEWF().getCodeName());
            strViewId = super.getSectionViewId(strPDTParam);
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strViewId)) {
                return strViewId;
            }
            psDEViewBase = this.getPSDataEntity().getPSDEViewDataByPDT("WFMDATAVIEW", strPDTParam, true);
        }
        if (psDEViewBase != null) {
            String strViewRefMode = SA.SRFramework.Utility.StringHelper.Format((String)"%1$s:%2$s", (Object)"EXPITEM", (Object)strPDTParam);
            String strPSAppDEViewId = Helper.GenUniqueId((String)this.getPSAppView().getPSApplication().getId(), (String)psDEViewBase.getPSDEVIEWBASEID());
            PSAppViewRef psAppViewRef = new PSAppViewRef();
            psAppViewRef.setPSAPPVIEWREFNAME(strViewRefMode);
            psAppViewRef.setMINORPSAPPVIEWID(strPSAppDEViewId);
            psAppViewRef.set("MINORPSDEVIEWBASEID", psDEViewBase.getPSDEVIEWBASEID());
            psAppViewRef.setParamValue("EMBEDVIEWID", this.getPSAppView().generateViewUniId());
            this.getPSAppView().registerPSAppViewRef(psAppViewRef);
            return strPDTParam;
        }
        return "";
    }

    protected String getSectionViewId(String strGroup, String strState) throws Exception {
        String strViewId;
        String strPDTParam;
        String strRealViewId = "";
        PSDEViewBase psDEViewBase = null;
        if (SA.SRFramework.Utility.StringHelper.Compare((String)strGroup, (String)"MY", (boolean)true) == 0 || SA.SRFramework.Utility.StringHelper.Compare((String)strGroup, (String)"ALL", (boolean)true) == 0) {
            strRealViewId = SA.SRFramework.Utility.StringHelper.Format((String)"%1$s:D:%2$s", (Object)this.getPSDEWF().getCodeName(), (Object)strState);
            strPDTParam = strRealViewId;
            strViewId = super.getSectionViewId(strPDTParam);
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strViewId)) {
                return strViewId;
            }
            psDEViewBase = this.getPSDataEntity().getPSDEViewDataByPDT("WFMDATAVIEW", strPDTParam, true);
            if (psDEViewBase == null) {
                strPDTParam = SA.SRFramework.Utility.StringHelper.Format((String)"%1$s:D", (Object)this.getPSDEWF().getCodeName());
                psDEViewBase = this.getPSDataEntity().getPSDEViewDataByPDT("WFMDATAVIEW", strPDTParam, true);
            }
        } else if (SA.SRFramework.Utility.StringHelper.Compare((String)strGroup, (String)"MYWFWORK", (boolean)true) == 0) {
            strRealViewId = SA.SRFramework.Utility.StringHelper.Format((String)"%1$s:W:%2$s", (Object)this.getPSDEWF().getCodeName(), (Object)strState);
            strPDTParam = strRealViewId;
            strViewId = super.getSectionViewId(strPDTParam);
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strViewId)) {
                return strViewId;
            }
            psDEViewBase = this.getPSDataEntity().getPSDEViewDataByPDT("WFMDATAVIEW", strPDTParam, true);
        }
        if (psDEViewBase != null) {
            String strViewRefMode = SA.SRFramework.Utility.StringHelper.Format((String)"%1$s:%2$s", (Object)"EXPITEM", (Object)strRealViewId);
            String strPSAppDEViewId = Helper.GenUniqueId((String)this.getPSAppView().getPSApplication().getId(), (String)psDEViewBase.getPSDEVIEWBASEID());
            PSAppViewRef psAppViewRef = new PSAppViewRef();
            psAppViewRef.setPSAPPVIEWREFNAME(strViewRefMode);
            psAppViewRef.setMINORPSAPPVIEWID(strPSAppDEViewId);
            psAppViewRef.set("MINORPSDEVIEWBASEID", psDEViewBase.getPSDEVIEWBASEID());
            psAppViewRef.setParamValue("EMBEDVIEWID", this.getPSAppView().generateViewUniId());
            this.getPSAppView().registerPSAppViewRef(psAppViewRef);
            return strRealViewId;
        }
        return "";
    }

    protected String getSectionViewId(String strGroup, String strState, String strStep) throws Exception {
        String strRealViewId = "";
        PSDEViewBase psDEViewBase = null;
        if (SA.SRFramework.Utility.StringHelper.Compare((String)strGroup, (String)"MY", (boolean)true) == 0 || SA.SRFramework.Utility.StringHelper.Compare((String)strGroup, (String)"ALL", (boolean)true) == 0) {
            strRealViewId = SA.SRFramework.Utility.StringHelper.Format((String)"%1$s:D:%2$s:%3$s", (Object)this.getPSDEWF().getCodeName(), (Object)strState, (Object)strStep);
            String strPDTParam = strRealViewId;
            String strViewId = super.getSectionViewId(strPDTParam);
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strViewId)) {
                return strViewId;
            }
            psDEViewBase = this.getPSDataEntity().getPSDEViewDataByPDT("WFMDATAVIEW", strPDTParam, true);
            if (psDEViewBase == null) {
                strPDTParam = SA.SRFramework.Utility.StringHelper.Format((String)"%1$s:D:%2$s", (Object)this.getPSDEWF().getCodeName(), (Object)strState);
                psDEViewBase = this.getPSDataEntity().getPSDEViewDataByPDT("WFMDATAVIEW", strPDTParam, true);
            }
            if (psDEViewBase == null) {
                strPDTParam = SA.SRFramework.Utility.StringHelper.Format((String)"%1$s:D", (Object)this.getPSDEWF().getCodeName());
                psDEViewBase = this.getPSDataEntity().getPSDEViewDataByPDT("WFMDATAVIEW", strPDTParam, true);
            }
        } else {
            SA.SRFramework.Utility.StringHelper.Compare((String)strGroup, (String)"MYWFWORK", (boolean)true);
        }
        if (psDEViewBase != null) {
            String strViewRefMode = SA.SRFramework.Utility.StringHelper.Format((String)"%1$s:%2$s", (Object)"EXPITEM", (Object)strRealViewId);
            String strPSAppDEViewId = Helper.GenUniqueId((String)this.getPSAppView().getPSApplication().getId(), (String)psDEViewBase.getPSDEVIEWBASEID());
            PSAppViewRef psAppViewRef = new PSAppViewRef();
            psAppViewRef.setPSAPPVIEWREFNAME(strViewRefMode);
            psAppViewRef.setMINORPSAPPVIEWID(strPSAppDEViewId);
            psAppViewRef.set("MINORPSDEVIEWBASEID", psDEViewBase.getPSDEVIEWBASEID());
            psAppViewRef.setParamValue("EMBEDVIEWID", this.getPSAppView().generateViewUniId());
            this.getPSAppView().registerPSAppViewRef(psAppViewRef);
            return strRealViewId;
        }
        return "";
    }

    protected String getSectionViewId(String strPId, IPSWFProcessSubWF iPSWFProcessSubWF, String strStep) throws Exception {
        String strRealViewId = "";
        IPSDataEntity subWFDEModel = iPSWFProcessSubWF.getPSDataEntity();
        IPSDEWF iPSDEWF = subWFDEModel.getPSDEWF(iPSWFProcessSubWF.getWFId());
        String[] parts = strPId.split("[:]");
        String strGroup = parts[0];
        PSDEViewBase psDEViewBase = null;
        if (SA.SRFramework.Utility.StringHelper.Compare((String)strGroup, (String)"MY", (boolean)true) == 0 || SA.SRFramework.Utility.StringHelper.Compare((String)strGroup, (String)"ALL", (boolean)true) == 0) {
            String strState = iPSDEWF.getEntityWFState();
            strRealViewId = SA.SRFramework.Utility.StringHelper.Format((String)"%4$s:%1$s:D:%2$s:%3$s", (Object)iPSWFProcessSubWF.getCodeName(), (Object)strState, (Object)strStep, (Object)this.getPSDEWF().getCodeName());
            String strPDTParam = strRealViewId;
            String strViewId = super.getSectionViewId(strPDTParam);
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strViewId)) {
                return strViewId;
            }
            strPDTParam = SA.SRFramework.Utility.StringHelper.Format((String)"%1$s:D:%2$s:%3$s", (Object)iPSDEWF.getCodeName(), (Object)strState, (Object)strStep);
            psDEViewBase = subWFDEModel.getPSDEViewDataByPDT("WFMDATAVIEW", strPDTParam, true);
            if (psDEViewBase == null) {
                strPDTParam = SA.SRFramework.Utility.StringHelper.Format((String)"%1$s:D:%2$s", (Object)iPSDEWF.getCodeName(), (Object)strState);
                psDEViewBase = subWFDEModel.getPSDEViewDataByPDT("WFMDATAVIEW", strPDTParam, true);
            }
            if (psDEViewBase == null) {
                strPDTParam = SA.SRFramework.Utility.StringHelper.Format((String)"%1$s:D", (Object)iPSDEWF.getCodeName());
                psDEViewBase = subWFDEModel.getPSDEViewDataByPDT("WFMDATAVIEW", strPDTParam, true);
            }
        } else if (SA.SRFramework.Utility.StringHelper.Compare((String)strGroup, (String)"MYWFWORK", (boolean)true) == 0) {
            strRealViewId = SA.SRFramework.Utility.StringHelper.Format((String)"%1$s:%2$s:W:%3$s", (Object)this.getPSDEWF().getCodeName(), (Object)iPSWFProcessSubWF.getCodeName(), (Object)strStep);
            String strPDTParam = strRealViewId;
            String strViewId = super.getSectionViewId(strPDTParam);
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strViewId)) {
                return strViewId;
            }
            strPDTParam = SA.SRFramework.Utility.StringHelper.Format((String)"%1$s:W:%2$s", (Object)iPSDEWF.getCodeName(), (Object)strStep);
            psDEViewBase = subWFDEModel.getPSDEViewDataByPDT("WFMDATAVIEW", strPDTParam, true);
        }
        if (psDEViewBase != null) {
            String strViewRefMode = SA.SRFramework.Utility.StringHelper.Format((String)"%1$s:%2$s", (Object)"EXPITEM", (Object)strRealViewId);
            String strPSAppDEViewId = Helper.GenUniqueId((String)this.getPSAppView().getPSApplication().getId(), (String)psDEViewBase.getPSDEVIEWBASEID());
            PSAppViewRef psAppViewRef = new PSAppViewRef();
            psAppViewRef.setPSAPPVIEWREFNAME(strViewRefMode);
            psAppViewRef.setMINORPSAPPVIEWID(strPSAppDEViewId);
            psAppViewRef.set("MINORPSDEVIEWBASEID", psDEViewBase.getPSDEVIEWBASEID());
            psAppViewRef.setParamValue("EMBEDVIEWID", this.getPSAppView().generateViewUniId());
            this.getPSAppView().registerPSAppViewRef(psAppViewRef);
            return strRealViewId;
        }
        return "";
    }

    protected String getSectionViewId(String strPId, IPSWFProcessSubWF iPSWFProcessSubWF) throws Exception {
        String strRealViewId = "";
        IPSDataEntity subWFDEModel = iPSWFProcessSubWF.getPSDataEntity();
        IPSDEWF iPSDEWF = subWFDEModel.getPSDEWF(iPSWFProcessSubWF.getWFId());
        String[] parts = strPId.split("[:]");
        String strGroup = parts[0];
        PSDEViewBase psDEViewBase = null;
        if (SA.SRFramework.Utility.StringHelper.Compare((String)strGroup, (String)"MY", (boolean)true) == 0 || SA.SRFramework.Utility.StringHelper.Compare((String)strGroup, (String)"ALL", (boolean)true) == 0) {
            String strState = iPSDEWF.getEntityWFState();
            strRealViewId = SA.SRFramework.Utility.StringHelper.Format((String)"%3$s:%1$s:D:%2$s", (Object)iPSWFProcessSubWF.getCodeName(), (Object)strState, (Object)this.getPSDEWF().getCodeName());
            String strPDTParam = strRealViewId;
            String strViewId = super.getSectionViewId(strPDTParam);
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strViewId)) {
                return strViewId;
            }
            strPDTParam = SA.SRFramework.Utility.StringHelper.Format((String)"%1$s:D:%2$s", (Object)iPSDEWF.getCodeName(), (Object)strState);
            psDEViewBase = subWFDEModel.getPSDEViewDataByPDT("WFMDATAVIEW", strPDTParam, true);
            if (psDEViewBase == null) {
                strPDTParam = SA.SRFramework.Utility.StringHelper.Format((String)"%1$s:D", (Object)iPSDEWF.getCodeName());
                psDEViewBase = subWFDEModel.getPSDEViewDataByPDT("WFMDATAVIEW", strPDTParam, true);
            }
        } else {
            SA.SRFramework.Utility.StringHelper.Compare((String)strGroup, (String)"MYWFWORK", (boolean)true);
        }
        if (psDEViewBase != null) {
            String strViewRefMode = SA.SRFramework.Utility.StringHelper.Format((String)"%1$s:%2$s", (Object)"EXPITEM", (Object)strRealViewId);
            String strPSAppDEViewId = Helper.GenUniqueId((String)this.getPSAppView().getPSApplication().getId(), (String)psDEViewBase.getPSDEVIEWBASEID());
            PSAppViewRef psAppViewRef = new PSAppViewRef();
            psAppViewRef.setPSAPPVIEWREFNAME(strViewRefMode);
            psAppViewRef.setMINORPSAPPVIEWID(strPSAppDEViewId);
            psAppViewRef.set("MINORPSDEVIEWBASEID", psDEViewBase.getPSDEVIEWBASEID());
            psAppViewRef.setParamValue("EMBEDVIEWID", this.getPSAppView().generateViewUniId());
            this.getPSAppView().registerPSAppViewRef(psAppViewRef);
            return strRealViewId;
        }
        return "";
    }

    protected boolean isOutputMyWorkFirst() {
        return this.getPSWFExpBarParam().isOutputMyWorkFirst();
    }

    protected boolean isExpandMyWork() {
        return this.getPSWFExpBarParam().isExpandMyWork();
    }

    protected boolean isOutputMyHistoryWork() {
        return this.getPSWFExpBarParam().isOutputMyHistoryWork();
    }

    @Override
    public String getModelScope() {
        return "DE";
    }
}

