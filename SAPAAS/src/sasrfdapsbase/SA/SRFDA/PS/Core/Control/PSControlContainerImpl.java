/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.util.JSONObjectHelper
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Control;

import SA.SRFDA.PS.Core.App.Control.IPSAppCounter;
import SA.SRFDA.PS.Core.App.Control.IPSAppCounterRef;
import SA.SRFDA.PS.Core.App.Control.PSAppCounterRefImpl;
import SA.SRFDA.PS.Core.App.View.IPSAppRedirectView;
import SA.SRFDA.PS.Core.App.View.IPSAppUIAction;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.App.View.IPSAppViewEngine;
import SA.SRFDA.PS.Core.App.View.IPSAppViewLogic;
import SA.SRFDA.PS.Core.App.View.IPSAppViewRef;
import SA.SRFDA.PS.Core.App.View.IPSAppViewUIAction;
import SA.SRFDA.PS.Core.App.View.IPSAppViewUIActionRuntime;
import SA.SRFDA.PS.Core.App.View.PSAppViewLogicImpl;
import SA.SRFDA.PS.Core.App.View.PSAppViewRefImpl;
import SA.SRFDA.PS.Core.App.View.PSAppViewUIActionProxy;
import SA.SRFDA.PS.Core.Control.IPSAjaxControl;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Control.IPSControlContainer;
import SA.SRFDA.PS.Core.Control.IPSControlContainerRuntime;
import SA.SRFDA.PS.Core.Control.IPSControlParam;
import SA.SRFDA.PS.Core.Control.IPSControlType;
import SA.SRFDA.PS.Core.Control.PSControlImpl;
import SA.SRFDA.PS.Core.Control.Panel.IPSLayoutPanel;
import SA.SRFDA.PS.Core.Control.Toolbar.IPSDEContextMenu;
import SA.SRFDA.PS.Core.Control.Toolbar.IPSDEToolbar;
import SA.SRFDA.PS.Core.Control.Toolbar.PSDEContextMenuParamImpl;
import SA.SRFDA.PS.Core.Control.Toolbar.PSDEToolbarParamImpl;
import SA.SRFDA.PS.Core.DataEntity.UIAction.IPSDEUIAction;
import SA.SRFDA.PS.Core.DataEntity.UIAction.IPSDEUIActionGroup;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.Res.IPSSysCss;
import SA.SRFDA.PS.Core.Res.IPSSysImage;
import SA.SRFDA.PS.Core.Util.PSModelUtil;
import SA.SRFDA.PS.Core.View.IPSUIAction;
import SA.SRFDA.PS.Core.View.IPSUIActionGroup;
import SA.SRFDA.PS.Core.View.IPSUIActionGroupDetail;
import SA.SRFDA.PS.Data.PSAppViewLogic;
import SA.SRFDA.PS.Data.PSAppViewRef;
import SA.SRFDA.PS.Data.PSDEViewCtrl;
import SA.SRFDA.PS.Data.PSSysIssue;
import SA.SRFramework.Utility.StringHelper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSControlContainerImpl
extends PSControlImpl
implements IPSControlContainer,
IPSControlContainerRuntime {
    private static final Log log = LogFactory.getLog(PSControlContainerImpl.class);
    private static final HashMap<String, IPSAppCounterRef> emptyPSAppCounterRefMap = new HashMap();
    private static final ArrayList<IPSAppViewUIAction> emptyPSAppViewUIActionList = new ArrayList();
    private static final ArrayList<IPSAppViewLogic> emptyPSAppViewLogicList = new ArrayList();
    private static final ArrayList<IPSAppViewEngine> emptyPSAppViewEngineList = new ArrayList();
    private static final ArrayList<IPSUIAction> emptyPSUIActionList = new ArrayList();
    private static final HashMap<String, IPSAppViewRef> emptyPSAppViewRefMap = new HashMap();
    private static final HashMap<String, IPSLayoutPanel> emptyPSLayoutPanelMap = new HashMap();
    private static final HashMap<String, IPSSysImage> emptyPSSysImageMap = new HashMap();
    private static final HashMap<String, IPSSysCss> emptyPSSysCssMap = new HashMap();
    private Map<String, IPSSysImage> psSysImageMap = null;
    private Map<String, IPSSysCss> psSysCssMap = null;
    private ArrayList<IPSUIAction> psUIActionList = null;
    private Map<String, IPSUIAction> psUIActionMap = null;
    private Map<String, JSONObject> psUIActionParamMap = null;
    private Map<String, IPSLayoutPanel> psLayoutPanelMap = null;
    private Map<String, IPSControl> psControlMap = new LinkedHashMap<String, IPSControl>();
    private Map<String, IPSAjaxControl> psControlMap2 = new LinkedHashMap<String, IPSAjaxControl>();
    private ArrayList<IPSAppViewEngine> psAppViewEngineList = null;
    private Map<String, IPSAppViewEngine> psAppViewEngineMap = null;
    private ArrayList<IPSAppViewUIAction> psAppViewUIActionList = null;
    private ArrayList<IPSAppViewLogic> psAppViewLogicList = null;
    private Map<String, IPSAppViewLogic> psAppViewLogicMap = null;
    private Map<String, IPSAppViewRef> psAppViewRefMap = null;
    private Map<String, IPSAppCounterRef> psAppCounterRefMap = null;

    @Override
    protected int onCheck() throws Exception {
        int nRet = 0;
        Iterator<IPSControl> psControls = this.getPSControls();
        if (psControls != null) {
            while (psControls.hasNext()) {
                IPSControl iPSControl = psControls.next();
                nRet += iPSControl.check();
            }
        }
        return nRet += super.onCheck();
    }

    @Override
    public IPSControl registerPSControl(String strKey, String strPSCtrlType, IPSControlParam iPSControlParam) throws Exception {
        IPSControlType iPSControlType = this.getPSModelStorage().getPSControlType(strPSCtrlType);
        IPSControl iPSControl = iPSControlType.createPSControl(iPSControlParam);
        this.registerPSControl(strKey, iPSControl);
        iPSControl.init(this.getDAGlobalHelper(), this, strKey, iPSControlParam);
        return iPSControl;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void registerPSControl(String strKey, IPSControl iPSControl) {
        if (!StringHelper.IsNullOrEmpty((String)strKey)) {
            strKey = strKey.toLowerCase();
        }
        Map<String, IPSControl> map = this.psControlMap;
        synchronized (map) {
            this.psControlMap.put(strKey, iPSControl);
            if (iPSControl instanceof IPSAjaxControl) {
                this.psControlMap2.put(strKey, (IPSAjaxControl)iPSControl);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public IPSControl getPSControl(String strControlName) throws Exception {
        if (!StringHelper.IsNullOrEmpty((String)strControlName)) {
            strControlName = strControlName.toLowerCase();
        }
        IPSControl iPSControl = null;
        Map<String, IPSControl> map = this.psControlMap;
        synchronized (map) {
            iPSControl = this.psControlMap.get(strControlName);
        }
        if (iPSControl == null) {
            throw new Exception(StringHelper.Format((String)"\u89c6\u56fe[%1$s]\u65e0\u6cd5\u83b7\u53d6\u90e8\u4ef6[%2$s]", (Object)this.getPSAppView().getFullCodeName(), (Object)strControlName));
        }
        return iPSControl;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean hasPSControl(String strControlName) {
        if (!StringHelper.IsNullOrEmpty((String)strControlName)) {
            strControlName = strControlName.toLowerCase();
        }
        Map<String, IPSControl> map = this.psControlMap;
        synchronized (map) {
            return this.psControlMap.containsKey(strControlName);
        }
    }

    @Override
    @PSModelRTMeta(description="\u90e8\u4ef6\u96c6\u5408", hideempty2=true, child=true, dumpref=true, modelreftype="IGNOREDESIGN", outputdoc="false", rtdump=2)
    public Iterator<IPSControl> getPSControls() {
        if (this.psControlMap.size() <= 1) {
            return this.psControlMap.values().iterator();
        }
        ArrayList<IPSControl> psControlList = new ArrayList<IPSControl>();
        psControlList.addAll(this.psControlMap.values());
        Collections.sort(psControlList, new Comparator<IPSControl>(){

            @Override
            public int compare(IPSControl arg0, IPSControl arg1) {
                return Integer.valueOf(arg0.getOrderValue()).compareTo(arg1.getOrderValue());
            }
        });
        return psControlList.iterator();
    }

    @Override
    public Iterator<IPSAjaxControl> getPSAjaxControls() {
        return this.psControlMap2.values().iterator();
    }

    @Override
    @PSModelRTMeta(description="\u5168\u90e8\u90e8\u4ef6\u96c6\u5408", hideempty2=true, outputdoc="false")
    public ArrayList<IPSControl> getAllPSControls() {
        return this.onGetAllPSControls();
    }

    protected ArrayList<IPSControl> onGetAllPSControls() {
        ArrayList<IPSControl> psControlList = new ArrayList<IPSControl>();
        for (IPSControl iPSControl : this.psControlMap.values()) {
            ArrayList<IPSControl> psControlList2;
            psControlList.add(iPSControl);
            if (!(iPSControl instanceof IPSControlContainer) || (psControlList2 = ((IPSControlContainer)((Object)iPSControl)).getAllPSControls()) == null) continue;
            psControlList.addAll(psControlList2);
        }
        return psControlList;
    }

    @Override
    @PSModelRTMeta(description="\u89c6\u56fe\u754c\u9762\u884c\u4e3a\u96c6\u5408", child=true, modeltype="SA.SRFDA.PS.Core.App.View.IPSAppViewUIAction", outputdoc="false")
    public Iterator<IPSAppViewUIAction> getPSAppViewUIActions() {
        if (this.psAppViewUIActionList != null) {
            return this.psAppViewUIActionList.iterator();
        }
        return emptyPSAppViewUIActionList.iterator();
    }

    @Override
    public void registerPSAppViewUIAction(IPSAppViewUIAction iPSAppViewUIAction) throws Exception {
        if (this.isEnableUIModelEx()) {
            return;
        }
        if (this.psAppViewUIActionList == null) {
            this.psAppViewUIActionList = new ArrayList();
        }
        if (!this.psAppViewUIActionList.contains(iPSAppViewUIAction)) {
            IPSAppUIAction iPSAppUIAction;
            this.psAppViewUIActionList.add(iPSAppViewUIAction);
            this.registerPSUIAction(iPSAppViewUIAction.getPSUIAction(), iPSAppViewUIAction.getUIActionParamJO());
            if (iPSAppViewUIAction.getPSUIAction() instanceof IPSAppUIAction && (iPSAppUIAction = (IPSAppUIAction)iPSAppViewUIAction.getPSUIAction()).getPSAppCounter() != null && iPSAppViewUIAction.getPSAppCounterRef() == null) {
                String strCounterParamJOString = iPSAppUIAction.getCounterParamJOString();
                JSONObject counterJO = null;
                if (!StringHelper.IsNullOrEmpty((String)strCounterParamJOString)) {
                    counterJO = JSONObjectHelper.fromString2((String)strCounterParamJOString);
                }
                IPSAppCounterRef iPSAppCounterRef = this.registerPSAppCounter(iPSAppUIAction.getPSAppCounter(), counterJO);
                if (iPSAppViewUIAction instanceof IPSAppViewUIActionRuntime) {
                    ((IPSAppViewUIActionRuntime)((Object)iPSAppViewUIAction)).setPSAppCounterRef(iPSAppCounterRef);
                }
            }
        }
    }

    @Override
    @PSModelRTMeta(description="\u89c6\u56fe\u754c\u9762\u5f15\u64ce\u96c6\u5408", hideempty2=true, child=true, outputdoc="false")
    public Iterator<IPSAppViewEngine> getPSAppViewEngines() {
        if (this.psAppViewEngineList != null) {
            return this.psAppViewEngineList.iterator();
        }
        return emptyPSAppViewEngineList.iterator();
    }

    @Override
    public IPSAppViewEngine getPSAppViewEngine(String strEngineTag, boolean bTry) throws Exception {
        IPSAppViewEngine iPSAppViewEngine = null;
        if (this.psAppViewEngineMap != null) {
            iPSAppViewEngine = this.psAppViewEngineMap.get(strEngineTag);
        }
        if (iPSAppViewEngine == null && !bTry) {
            throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u89c6\u56fe\u754c\u9762\u5f15\u64ce[%1$s]", (Object)strEngineTag));
        }
        return iPSAppViewEngine;
    }

    @Override
    public void registerPSAppViewEngine(IPSAppViewEngine iPSAppViewEngine) throws Exception {
        this.registerPSAppViewEngine(null, iPSAppViewEngine);
    }

    @Override
    public void registerPSAppViewEngine(String strKey, IPSAppViewEngine iPSAppViewEngine) throws Exception {
        if (this.psAppViewEngineList == null) {
            this.psAppViewEngineList = new ArrayList();
        }
        if (this.psAppViewEngineMap == null) {
            this.psAppViewEngineMap = new LinkedHashMap<String, IPSAppViewEngine>();
        }
        if (StringHelper.IsNullOrEmpty((String)strKey)) {
            strKey = iPSAppViewEngine.getName().toLowerCase();
        }
        this.psAppViewEngineMap.put(strKey, iPSAppViewEngine);
        this.psAppViewEngineList.add(iPSAppViewEngine);
        if (this.psAppViewEngineList.size() > 1) {
            PSModelUtil.sort(this.psAppViewEngineList);
        }
    }

    @Override
    public void logPSControlIssue(IPSControl iPSControl, PSSysIssue psSysIssueV3) throws Exception {
    }

    @Override
    public void registerPSAppViewLogic(IPSAppViewLogic iPSAppViewLogic) throws Exception {
        this.registerPSAppViewLogic(null, iPSAppViewLogic);
    }

    @Override
    public void registerPSAppViewLogic(String strKey, IPSAppViewLogic iPSAppViewLogic) throws Exception {
        if (this.isEnableUIModelEx()) {
            if ("APPVIEWUIACTION".equals(iPSAppViewLogic.getLogicType())) {
                return;
            }
            if (!("VIEWEVENT".equals(iPSAppViewLogic.getLogicTrigger()) || "CTRLEVENT".equals(iPSAppViewLogic.getLogicTrigger()) || "TIMER".equals(iPSAppViewLogic.getLogicTrigger()) || "CUSTOM".equals(iPSAppViewLogic.getLogicTrigger()))) {
                if (!StringHelper.IsNullOrEmpty((String)iPSAppViewLogic.getPSViewCtrlName())) {
                    if (this.hasPSControl(iPSAppViewLogic.getPSViewCtrlName())) {
                        IPSControl iPSControl = this.getPSControl(iPSAppViewLogic.getPSViewCtrlName());
                        iPSControl.registerPSControlLogic(iPSAppViewLogic);
                    } else {
                        log.warn((Object)String.format("\u65e0\u6cd5\u83b7\u53d6\u89c6\u56fe\u90e8\u4ef6[%1$s]\uff0c\u5ffd\u7565\u6ce8\u518c\u5e94\u7528\u89c6\u56fe\u903b\u8f91[%2$s][%3$s]", iPSAppViewLogic.getPSViewCtrlName(), iPSAppViewLogic.getName(), iPSAppViewLogic.getLogicTrigger()));
                    }
                    return;
                }
                this.registerPSControlLogic(iPSAppViewLogic);
                return;
            }
        }
        if (this.psAppViewLogicList == null) {
            this.psAppViewLogicList = new ArrayList();
        }
        if (this.psAppViewLogicMap == null) {
            this.psAppViewLogicMap = new LinkedHashMap<String, IPSAppViewLogic>();
        }
        if (StringHelper.IsNullOrEmpty((String)strKey)) {
            strKey = iPSAppViewLogic.getName().toLowerCase();
        }
        if (this.psAppViewLogicMap.containsKey(strKey)) {
            throw new Exception(StringHelper.Format((String)"\u5f53\u524d\u89c6\u56fe\u5df2\u5b58\u5728\u6807\u8bc6\u4e3a[%1$s]\u7684\u89c6\u56fe\u903b\u8f91", (Object)strKey));
        }
        this.psAppViewLogicMap.put(strKey, iPSAppViewLogic);
        this.psAppViewLogicList.add(iPSAppViewLogic);
    }

    @Override
    @PSModelRTMeta(description="\u89c6\u56fe\u903b\u8f91\u96c6\u5408", hideempty2=true, child=true, outputdoc="false")
    public Iterator<IPSAppViewLogic> getPSAppViewLogics() {
        if (this.psAppViewLogicList != null) {
            return this.psAppViewLogicList.iterator();
        }
        return emptyPSAppViewLogicList.iterator();
    }

    @Override
    public IPSAppViewLogic getPSAppViewLogic(String strLogicTag, boolean bTry) throws Exception {
        IPSAppViewLogic iPSAppViewLogic = null;
        if (this.psAppViewLogicMap != null) {
            iPSAppViewLogic = this.psAppViewLogicMap.get(strLogicTag);
        }
        if (iPSAppViewLogic == null && !bTry) {
            throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u89c6\u56fe\u903b\u8f91[%1$s]", (Object)strLogicTag));
        }
        return iPSAppViewLogic;
    }

    @Override
    @PSModelRTMeta(description="\u754c\u9762\u884c\u4e3a\u96c6\u5408", outputdoc="false")
    public Iterator<IPSUIAction> getPSUIActions() {
        if (this.psUIActionList != null) {
            return this.psUIActionList.iterator();
        }
        return emptyPSUIActionList.iterator();
    }

    @Override
    public void registerPSUIAction(IPSUIAction iPSUIAction, JSONObject actionParam) throws Exception {
        if (this.psUIActionList == null) {
            this.psUIActionList = new ArrayList();
        }
        if (this.psUIActionMap == null) {
            this.psUIActionMap = new LinkedHashMap<String, IPSUIAction>();
        }
        if (!StringHelper.IsNullOrEmpty((String)iPSUIAction.getId())) {
            if (this.psUIActionMap.containsKey(iPSUIAction.getId())) {
                return;
            }
            this.psUIActionMap.put(iPSUIAction.getId(), iPSUIAction);
            if (actionParam != null) {
                if (this.psUIActionParamMap == null) {
                    this.psUIActionParamMap = new LinkedHashMap<String, JSONObject>();
                }
                this.psUIActionParamMap.put(iPSUIAction.getId(), actionParam);
            }
        }
        this.psUIActionList.add(iPSUIAction);
        IPSAppView refPSAppView = iPSUIAction.getFrontPSAppView(this);
        if (refPSAppView != null) {
            if (StringHelper.Compare((String)iPSUIAction.getUIActionMode(), (String)"BACKEND", (boolean)true) == 0 || StringHelper.Compare((String)iPSUIAction.getUIActionMode(), (String)"WFBACKEND", (boolean)true) == 0) {
                this.getPSAppView().getPSApplication().markPSAppViewUsage(refPSAppView.getId(), 2, this);
            } else if ((StringHelper.Compare((String)iPSUIAction.getUIActionMode(), (String)"FRONT", (boolean)true) == 0 || StringHelper.Compare((String)iPSUIAction.getUIActionMode(), (String)"WFFRONT", (boolean)true) == 0) && StringHelper.Compare((String)iPSUIAction.getFrontProcessType(), (String)"WIZARD", (boolean)true) == 0) {
                this.getPSAppView().getPSApplication().markPSAppViewUsage(refPSAppView.getId(), 2, this);
            } else {
                this.getPSAppView().getPSApplication().markPSAppViewUsage(refPSAppView.getId(), 1, this);
            }
        }
        if (!StringHelper.IsNullOrEmpty((String)iPSUIAction.getViewLogicAttachMode()) && !StringHelper.IsNullOrEmpty((String)iPSUIAction.getPSSysViewLogicId()) && this.getPSAppView().getPSPFStyle().getPFEngineVer() < 20) {
            IPSDEUIAction iPSDEUIAction;
            PSAppViewLogic psAppViewLogic = new PSAppViewLogic();
            psAppViewLogic.setPSAPPVIEWID(this.getId());
            psAppViewLogic.setPSAPPVIEWNAME(this.getName());
            psAppViewLogic.setPSAPPVIEWLOGICID(iPSUIAction.getId());
            psAppViewLogic.setPSAPPVIEWLOGICNAME(String.valueOf(iPSUIAction.getUIActionTag()) + "_VL");
            psAppViewLogic.setINITLOGICMODE(false);
            psAppViewLogic.setParamValue("DSTLOGICTYPE", iPSUIAction.getViewLogicType());
            psAppViewLogic.setParamValue("PSDELOGICID", iPSUIAction.getPSDEUILogicId());
            psAppViewLogic.setParamValue("PSSYSVIEWLOGICID", iPSUIAction.getPSSysViewLogicId());
            if (iPSUIAction instanceof IPSDEUIAction && (iPSDEUIAction = (IPSDEUIAction)iPSUIAction).getPSDataEntity() != null) {
                psAppViewLogic.setParamValue("PSDEID", iPSDEUIAction.getPSDataEntity().getId());
            }
            PSAppViewLogicImpl psAppViewLogicImpl = new PSAppViewLogicImpl();
            psAppViewLogicImpl.init(this.getDAGlobalHelper(), this, psAppViewLogic);
            this.registerPSAppViewLogic(String.valueOf(iPSUIAction.getUIActionTag()) + "_VL", psAppViewLogicImpl);
        }
        if (iPSUIAction.getNextPSUIAction() != null) {
            this.registerPSUIAction(iPSUIAction.getNextPSUIAction());
        }
    }

    @Override
    public void registerPSUIAction(IPSUIAction iPSUIAction) throws Exception {
        this.registerPSUIAction(iPSUIAction, null);
    }

    @Override
    public IPSAppViewRef registerPSAppViewRef(PSAppViewRef psAppViewRef) throws Exception {
        if (this.psAppViewRefMap == null) {
            this.psAppViewRefMap = new LinkedHashMap<String, IPSAppViewRef>();
        }
        PSAppViewRefImpl iPSAppViewRef = new PSAppViewRefImpl();
        iPSAppViewRef.init(this.getDAGlobalHelper(), this, psAppViewRef);
        this.psAppViewRefMap.put(psAppViewRef.getPSAPPVIEWREFNAME().toUpperCase(), iPSAppViewRef);
        return iPSAppViewRef;
    }

    @Override
    public IPSAppViewRef getPSAppViewRef(String strRefMode, boolean bTry) throws Exception {
        IPSAppViewRef iPSAppViewRef = null;
        if (this.psAppViewRefMap != null) {
            iPSAppViewRef = this.psAppViewRefMap.get(strRefMode.toUpperCase());
        }
        if (iPSAppViewRef == null) {
            if (bTry) {
                return null;
            }
            throw new Exception(StringHelper.Format((String)"\u5e94\u7528\u89c6\u56fe[%1$s]\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5f15\u7528\u89c6\u56fe[%2$s]", (Object)this.getName(), (Object)strRefMode));
        }
        return iPSAppViewRef;
    }

    @Override
    @PSModelRTMeta(description="\u89c6\u56fe\u5bf9\u8c61\u5f15\u7528", child=true, outputdoc="false")
    public Iterator<IPSAppViewRef> getPSAppViewRefs() {
        if (this.psAppViewRefMap != null) {
            return this.psAppViewRefMap.values().iterator();
        }
        return emptyPSAppViewRefMap.values().iterator();
    }

    @Override
    public Iterator<IPSAppViewRef> getPSAppViewRefs(String strRefMode) throws Exception {
        if (this.psAppViewRefMap == null) {
            return null;
        }
        strRefMode = strRefMode.toUpperCase();
        ArrayList<IPSAppViewRef> psAppViewRefList = new ArrayList<IPSAppViewRef>();
        for (String strKey : this.psAppViewRefMap.keySet()) {
            IPSAppViewRef iPSAppViewRef;
            if (strKey.indexOf(strRefMode) != 0 || (iPSAppViewRef = this.psAppViewRefMap.get(strKey)) == null || iPSAppViewRef.getRefPSAppView() == null) continue;
            psAppViewRefList.add(iPSAppViewRef);
        }
        if (psAppViewRefList.size() == 0) {
            return null;
        }
        return psAppViewRefList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u5168\u90e8\u5173\u8054\u89c6\u56fe", hideempty2=true, outputdoc="false")
    public Iterator<IPSAppView> getAllRelatedPSAppViews() throws Exception {
        ArrayList<IPSAppView> relatedPSAppViewList = new ArrayList<IPSAppView>();
        this.fillRelatedPSAppViews(relatedPSAppViewList);
        LinkedHashMap<String, IPSAppView> relatedPSAppViewMap = new LinkedHashMap<String, IPSAppView>();
        for (IPSAppView iPSAppView : relatedPSAppViewList) {
            if (iPSAppView == null) continue;
            relatedPSAppViewMap.put(iPSAppView.getId(), iPSAppView);
        }
        return relatedPSAppViewMap.values().iterator();
    }

    @Override
    public void fillRelatedPSAppViews(ArrayList<IPSAppView> relatedAppViewList) throws Exception {
        this.onFillRelatedPSAppViews(relatedAppViewList);
        super.fillRelatedPSAppViews(relatedAppViewList);
    }

    protected void onFillRelatedPSAppViews(ArrayList<IPSAppView> relatedAppViewList) throws Exception {
        ArrayList<IPSAppView> relatedAppViewList2 = new ArrayList<IPSAppView>();
        for (IPSControl iPSControl : this.psControlMap.values()) {
            try {
                iPSControl.fillRelatedPSAppViews(relatedAppViewList2);
            }
            catch (Exception ex) {
                throw new Exception(StringHelper.Format((String)"\u5e94\u7528\u89c6\u56fe[%1$s]\u90e8\u4ef6[%2$s]\u586b\u5145\u5173\u8054\u89c6\u56fe\u53d1\u751f\u5f02\u5e38", (Object)this.getName(), (Object)iPSControl.getName()), ex);
            }
        }
        if (this.psAppViewRefMap != null) {
            for (IPSAppViewRef iPSAppViewRef : this.psAppViewRefMap.values()) {
                try {
                    if (iPSAppViewRef.getRefPSAppView() == null) continue;
                    relatedAppViewList2.add(iPSAppViewRef.getRefPSAppView());
                }
                catch (Exception ex) {
                    throw new Exception(StringHelper.Format((String)"\u5e94\u7528\u89c6\u56fe[%1$s]\u89c6\u56fe\u5f15\u7528[%2$s]\u53d1\u751f\u5f02\u5e38", (Object)this.getName(), (Object)iPSAppViewRef.getName()), ex);
                }
            }
        }
        if (this.psUIActionList != null) {
            for (IPSUIAction iPSUIAction : this.psUIActionList) {
                IPSAppView refPSAppView = iPSUIAction.getFrontPSAppView(this);
                if (refPSAppView == null) continue;
                relatedAppViewList2.add(refPSAppView);
            }
        }
        for (IPSAppView iPSAppView : relatedAppViewList2) {
            IPSAppRedirectView iPSAppRedirectView;
            Iterator<IPSAppView> redirectPSAppViews;
            relatedAppViewList.add(iPSAppView);
            if (!(iPSAppView instanceof IPSAppRedirectView) || (redirectPSAppViews = (iPSAppRedirectView = (IPSAppRedirectView)iPSAppView).getRedirectPSAppViews()) == null) continue;
            while (redirectPSAppViews.hasNext()) {
                relatedAppViewList.add(redirectPSAppViews.next());
            }
        }
    }

    @Override
    public void registerPSLayoutPanel(IPSLayoutPanel iPSLayoutPanel) throws Exception {
        if (this.psLayoutPanelMap == null) {
            this.psLayoutPanelMap = new LinkedHashMap<String, IPSLayoutPanel>();
        }
        this.psLayoutPanelMap.put(iPSLayoutPanel.getName(), iPSLayoutPanel);
    }

    @Override
    @PSModelRTMeta(description="\u89c6\u56fe\u5f15\u7528\u5e03\u5c40\u9762\u677f\u96c6\u5408", outputdoc="false")
    public Iterator<IPSLayoutPanel> getPSLayoutPanels() {
        if (this.psLayoutPanelMap != null) {
            return this.psLayoutPanelMap.values().iterator();
        }
        return emptyPSLayoutPanelMap.values().iterator();
    }

    @Override
    public boolean isRegisterPSLayoutPanel() {
        return this.getPSControlContainer().isRegisterPSLayoutPanel();
    }

    @Override
    public void registerPSSysCss(IPSSysCss iPSSysCss) throws Exception {
        if (this.psSysCssMap == null) {
            this.psSysCssMap = new LinkedHashMap<String, IPSSysCss>();
        }
        this.psSysCssMap.put(iPSSysCss.getId(), iPSSysCss);
    }

    @Override
    public void registerPSSysImage(IPSSysImage iPSSysImage) throws Exception {
        if (this.psSysImageMap == null) {
            this.psSysImageMap = new LinkedHashMap<String, IPSSysImage>();
        }
        this.psSysImageMap.put(iPSSysImage.getId(), iPSSysImage);
    }

    @Override
    @PSModelRTMeta(description="\u5f15\u7528\u6837\u5f0f\u8d44\u6e90\u96c6\u5408", outputdoc="false")
    public Iterator<IPSSysCss> getPSSysCsses() {
        if (this.psSysCssMap != null) {
            return this.psSysCssMap.values().iterator();
        }
        return emptyPSSysCssMap.values().iterator();
    }

    @Override
    @PSModelRTMeta(description="\u5f15\u7528\u56fe\u7247\u8d44\u6e90\u96c6\u5408", outputdoc="false")
    public Iterator<IPSSysImage> getPSSysImages() {
        if (this.psSysImageMap != null) {
            return this.psSysImageMap.values().iterator();
        }
        return emptyPSSysImageMap.values().iterator();
    }

    @Override
    public IPSAppCounterRef registerPSAppCounter(IPSAppCounter iPSAppCounter, JSONObject jsonRefMode) throws Exception {
        String strId;
        IPSAppCounterRef iPSAppCounterRef;
        if (this.getPSAppView() != null) {
            this.getPSAppView().registerPSSysCounter(iPSAppCounter, jsonRefMode);
        }
        if (this.psAppCounterRefMap == null) {
            this.psAppCounterRefMap = new LinkedHashMap<String, IPSAppCounterRef>();
        }
        if (jsonRefMode == null) {
            jsonRefMode = new JSONObject();
        }
        if ((iPSAppCounterRef = this.psAppCounterRefMap.get(strId = StringHelper.Format((String)"%1$s|%2$s", (Object)iPSAppCounter.getId(), (Object)jsonRefMode.toString()))) == null) {
            if (iPSAppCounter instanceof IPSAppCounter) {
                PSAppCounterRefImpl psAppCounterRefImpl = new PSAppCounterRefImpl();
                psAppCounterRefImpl.init(this.getDAGlobalHelper(), iPSAppCounter, jsonRefMode);
                iPSAppCounterRef = psAppCounterRefImpl;
            } else {
                iPSAppCounterRef = new PSAppCounterRefImpl();
                iPSAppCounterRef.init(this.getDAGlobalHelper(), iPSAppCounter, jsonRefMode);
            }
            this.psAppCounterRefMap.put(strId, iPSAppCounterRef);
        }
        return iPSAppCounterRef;
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u8ba1\u6570\u5668\u5f15\u7528\u96c6\u5408", child=true, outputdoc="false")
    public Iterator<IPSAppCounterRef> getPSAppCounterRefs() {
        if (this.psAppCounterRefMap != null) {
            return this.psAppCounterRefMap.values().iterator();
        }
        return emptyPSAppCounterRefMap.values().iterator();
    }

    @Override
    public void fillEmbeddedPSAppViewRefs(String strContainerId, ArrayList<IPSAppViewRef> embeddedPSAppViewRefList) throws Exception {
        if (this.psAppViewRefMap != null) {
            for (IPSAppViewRef iPSAppViewRef : this.psAppViewRefMap.values()) {
                if (StringHelper.IsNullOrEmpty((String)iPSAppViewRef.getEmbedId())) continue;
                PSAppViewRefImpl psAppViewRefImpl = new PSAppViewRefImpl();
                PSAppViewRef psAppViewRef = new PSAppViewRef();
                psAppViewRef.setMINORPSAPPVIEWID(iPSAppViewRef.getRefPSAppView().getId());
                psAppViewRef.setREFMODETEXT(iPSAppViewRef.getRefModeDesc());
                psAppViewRefImpl.init(this.getDAGlobalHelper(), this, psAppViewRef);
                psAppViewRefImpl.setRefPSAppView(iPSAppViewRef.getRefPSAppView());
                String strFullViewId = "";
                strFullViewId = StringHelper.IsNullOrEmpty((String)strContainerId) ? iPSAppViewRef.getEmbedId() : StringHelper.Format((String)"%1$s_%2$s", (Object)strContainerId, (Object)iPSAppViewRef.getEmbedId());
                psAppViewRefImpl.setEmbedId(strFullViewId);
                embeddedPSAppViewRefList.add(iPSAppViewRef);
                Iterator<IPSAppViewRef> subEmbeddedPSAppViewRefs = iPSAppViewRef.getRefPSAppView().getEmbeddedPSAppViewRefs(strFullViewId);
                if (subEmbeddedPSAppViewRefs == null) continue;
                while (subEmbeddedPSAppViewRefs.hasNext()) {
                    embeddedPSAppViewRefList.add(subEmbeddedPSAppViewRefs.next());
                }
            }
        }
        super.fillEmbeddedPSAppViewRefs(strContainerId, embeddedPSAppViewRefList);
    }

    protected IPSDEToolbar registerPSDEToolbar(String strToolbarName, String strPSDEToolbarId, String strPSDEUAGroupId, String strNo2PSDEUAGroupId) throws Exception {
        try {
            String strToolbarTag = StringHelper.Format((String)"%1$s_%2$s", (Object)this.getName(), (Object)strToolbarName).toLowerCase();
            PSDEViewCtrl psDEViewCtrl = new PSDEViewCtrl();
            psDEViewCtrl.setPSDEVIEWCTRLNAME(strToolbarTag);
            psDEViewCtrl.setPSDEVIEWCTRLTYPE("TOOLBAR");
            psDEViewCtrl.setPSDETOOLBARID(strPSDEToolbarId);
            psDEViewCtrl.setPSDEUAGROUPID(strPSDEUAGroupId);
            psDEViewCtrl.setNO2PSDEUAGROUPID(strNo2PSDEUAGroupId);
            PSDEToolbarParamImpl psDEToolbarParamImpl = new PSDEToolbarParamImpl();
            psDEToolbarParamImpl.setOwner(this);
            psDEToolbarParamImpl.init(this.getDAGlobalHelper(), null, psDEViewCtrl);
            IPSDEToolbar iPSDEToolbar = (IPSDEToolbar)this.registerPSControl(strToolbarTag, "TOOLBAR", psDEToolbarParamImpl);
            return iPSDEToolbar;
        }
        catch (Exception ex) {
            throw new Exception(StringHelper.Format((String)"\u6ce8\u518c\u5de5\u5177\u680f[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)strToolbarName, (Object)ex.getMessage()), ex);
        }
    }

    protected IPSDEContextMenu registerPSDEContextMenu(String strContextMenuName, String strPSDEContextMenuId, String strPSDEUAGroupId, String strNo2PSDEUAGroupId) throws Exception {
        try {
            String strContextMenuTag = StringHelper.Format((String)"%1$s_%2$s", (Object)this.getName(), (Object)strContextMenuName).toLowerCase();
            PSDEViewCtrl psDEViewCtrl = new PSDEViewCtrl();
            psDEViewCtrl.setPSDEVIEWCTRLNAME(strContextMenuTag);
            psDEViewCtrl.setPSDEVIEWCTRLTYPE("CONTEXTMENU");
            psDEViewCtrl.setPSDETOOLBARID(strPSDEContextMenuId);
            psDEViewCtrl.setPSDEUAGROUPID(strPSDEUAGroupId);
            psDEViewCtrl.setNO2PSDEUAGROUPID(strNo2PSDEUAGroupId);
            PSDEContextMenuParamImpl psDEContextMenuParamImpl = new PSDEContextMenuParamImpl();
            psDEContextMenuParamImpl.setOwner(this);
            psDEContextMenuParamImpl.init(this.getDAGlobalHelper(), null, psDEViewCtrl);
            IPSDEContextMenu iPSDEContextMenu = (IPSDEContextMenu)this.registerPSControl(strContextMenuTag, "CONTEXTMENU", psDEContextMenuParamImpl);
            return iPSDEContextMenu;
        }
        catch (Exception ex) {
            throw new Exception(StringHelper.Format((String)"\u6ce8\u518c\u4e0a\u4e0b\u6587\u83dc\u5355[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)strContextMenuName, (Object)ex.getMessage()), ex);
        }
    }

    protected IPSUIActionGroup registerPSUIActionGroup(String strLogicTagFormat, String strPSUIActionGroupId) throws Exception {
        IPSDEUIActionGroup iPSUIActionGroup = null;
        if (this.getPSAppDataEntity() != null) {
            iPSUIActionGroup = this.getPSAppDataEntity().getPSAppDEUIActionGroup(strPSUIActionGroupId, true, this);
        }
        if (iPSUIActionGroup == null && this.getPSDataEntity() != null) {
            iPSUIActionGroup = this.getPSDataEntity().getPSDEUIActionGroup(strPSUIActionGroupId);
        }
        if (iPSUIActionGroup == null) {
            return null;
        }
        this.registerPSUIActionGroup(strLogicTagFormat, iPSUIActionGroup);
        return iPSUIActionGroup;
    }

    protected void registerPSUIActionGroup(String strLogicTagFormat, IPSUIActionGroup iPSUIActionGroup) throws Exception {
        Iterator<IPSUIActionGroupDetail> psUIActionGroupDetails = iPSUIActionGroup.getPSUIActionGroupDetails();
        if (psUIActionGroupDetails != null) {
            while (psUIActionGroupDetails.hasNext()) {
                IPSUIActionGroupDetail iPSUIActionGroupDetail = psUIActionGroupDetails.next();
                IPSUIAction iPSUIAction = iPSUIActionGroupDetail.getPSUIAction();
                if (iPSUIAction == null) continue;
                if (this.isPrepareTemplV2logic()) {
                    PSAppViewUIActionProxy iPSAppViewUIAction = new PSAppViewUIActionProxy(this, iPSUIAction, this);
                    this.registerPSAppViewUIAction(iPSAppViewUIAction);
                    this.registerPSAppViewLogic(strLogicTagFormat, iPSAppViewUIAction, iPSUIActionGroupDetail);
                    continue;
                }
                this.getPSAppView().registerPSUIAction(iPSUIAction);
            }
        }
    }

    protected void registerPSAppViewLogic(String strLogicTagFormat, IPSAppViewUIAction iPSAppViewUIAction, IPSUIActionGroupDetail iPSUIActionGroupDetail) throws Exception {
        String strLogicTag = "";
        strLogicTag = StringHelper.IsNullOrEmpty((String)strLogicTagFormat) ? StringHelper.Format((String)"%1$s_%2$s_click", (Object)this.getName(), (Object)iPSUIActionGroupDetail.getName()).toLowerCase() : StringHelper.Format((String)strLogicTagFormat, (Object)this.getName(), (Object)iPSUIActionGroupDetail.getName()).toLowerCase();
        PSAppViewLogic psAppViewLogic = new PSAppViewLogic();
        psAppViewLogic.setPSAPPVIEWLOGICID(strLogicTag);
        psAppViewLogic.setPSAPPVIEWLOGICNAME(strLogicTag);
        psAppViewLogic.setDSTLOGICTYPE("APPVIEWUIACTION");
        psAppViewLogic.setPSAPPVIEWLOGICTYPE("CUSTOM");
        PSAppViewLogicImpl psAppDEViewLogicImpl = new PSAppViewLogicImpl();
        psAppDEViewLogicImpl.init(this.getDAGlobalHelper(), (Object)this, psAppViewLogic, iPSAppViewUIAction);
        this.registerPSAppViewLogic(psAppDEViewLogicImpl);
    }
}

