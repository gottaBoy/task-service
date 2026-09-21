/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 *  net.ibizsys.paas.control.tree.ITreeNode
 *  net.ibizsys.paas.util.StringHelper
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Control.Tree;

import SA.SRFDA.PS.Core.App.Control.IPSAppCounter;
import SA.SRFDA.PS.Core.App.Control.IPSAppCounterRef;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEUILogicGroupDetail;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.CodeList.IPSCodeList;
import SA.SRFDA.PS.Core.Control.Counter.IPSSysCounterRef;
import SA.SRFDA.PS.Core.Control.Grid.IPSDEGridColumnType;
import SA.SRFDA.PS.Core.Control.IPSAjaxControlParam;
import SA.SRFDA.PS.Core.Control.IPSControlContainer;
import SA.SRFDA.PS.Core.Control.IPSControlParam;
import SA.SRFDA.PS.Core.Control.PSMDAjaxControlContainerImpl2;
import SA.SRFDA.PS.Core.Control.Tree.IPSDETree;
import SA.SRFDA.PS.Core.Control.Tree.IPSDETreeColumn;
import SA.SRFDA.PS.Core.Control.Tree.IPSDETreeLogic;
import SA.SRFDA.PS.Core.Control.Tree.IPSDETreeNode;
import SA.SRFDA.PS.Core.Control.Tree.IPSDETreeNodeRS;
import SA.SRFDA.PS.Core.Control.Tree.IPSDETreeNodeType;
import SA.SRFDA.PS.Core.Control.Tree.IPSDETreeParam;
import SA.SRFDA.PS.Core.Control.Tree.PSDETreeLogicImpl;
import SA.SRFDA.PS.Core.Control.Tree.PSDETreeNodeRSImpl;
import SA.SRFDA.PS.Core.Control.Tree.PSDETreeParamImpl;
import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Data.PSDETreeColumn;
import SA.SRFDA.PS.Data.PSDETreeLogic;
import SA.SRFDA.PS.Data.PSDETreeNode;
import SA.SRFDA.PS.Data.PSDETreeNodeColumn;
import SA.SRFDA.PS.Data.PSDETreeNodeRS;
import SA.SRFDA.PS.Data.PSDETreeNodeRV;
import SA.SRFDA.PS.Data.PSDETreeView;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import net.ibizsys.paas.control.tree.ITreeNode;
import net.ibizsys.paas.util.StringHelper;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelImplementMeta(implement="IPSControl", typevalues={"TREEVIEW"})
public class PSDETreeImpl
extends PSMDAjaxControlContainerImpl2
implements IPSDETree {
    private static final Log log = LogFactory.getLog(PSDETreeImpl.class);
    protected PSDETreeView psDETree;
    protected ArrayList<IPSDETreeNode> psDETreeNodeList = new ArrayList();
    protected Map<String, IPSDETreeNode> psDETreeNodeMap = new LinkedHashMap<String, IPSDETreeNode>();
    protected ArrayList<IPSDETreeNodeRS> psDETreeNodeRSList = new ArrayList();
    protected Map<String, IPSDETreeNodeRS> psDETreeNodeRSMap = new LinkedHashMap<String, IPSDETreeNodeRS>();
    protected ArrayList<IPSDETreeColumn> psDETreeColumnList = new ArrayList();
    protected Map<String, IPSDETreeColumn> psDETreeColumnMap = new LinkedHashMap<String, IPSDETreeColumn>();
    protected PSDETreeParamImpl psDETreeParamImpl = new PSDETreeParamImpl();
    protected String strCodeName = "";
    protected boolean bForceFit = false;
    protected String strTreeStyle = "";
    protected boolean bNoSort = false;
    protected IPSDEField minorPSDEField = null;
    protected String strMinorSortDir = "";
    private IPSCodeList catPSCodeList = null;
    private String strEmptyText = null;
    private IPSLanguageRes emptyTextPSLanguageRes = null;
    private boolean bEnableTreeGrid = false;
    private int nTreeGridMode = 0;
    private boolean bBufferRenderer = true;
    private IPSDETreeNode rootPSDETreeNode = null;
    private boolean bNoIconDefault = false;
    private IPSSysCounterRef iPSSysCounterRef = null;
    private boolean bEnableCounter = true;
    private boolean bEnableSearchDefault = false;
    private boolean bInvalidId = false;
    protected List<PSDETreeLogicImpl> psDETreeLogicList = new ArrayList<PSDETreeLogicImpl>();
    private int nColumnEnableLink = 2;
    private int nColumnEnableFilter = 2;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSControlContainer iPSControlContainer, String strName, IPSControlParam iPSControlParam) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSControlContainer(iPSControlContainer);
            IPSDETreeParam iPSDETreeParam = (IPSDETreeParam)iPSControlParam;
            this.psDETree = new PSDETreeView();
            if (!StringHelper.isNullOrEmpty((String)iPSDETreeParam.getPSDETreeId())) {
                CallResult callResult = this.getPSModelHelper().getPSDETreeView(iPSDETreeParam.getPSDETreeId(), this.psDETree);
                if (callResult.isError()) {
                    throw new Exception(StringHelper.format((String)"\u83b7\u53d6\u5b9e\u4f53\u6811\u89c6\u56fe\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                this.setId(this.psDETree.getPSDETREEVIEWID());
            } else {
                this.setId(StringHelper.format((String)"%1$s_%2$s", (Object)this.getPSAppView().getId(), (Object)strName));
                this.bInvalidId = true;
            }
            this.setName(strName);
            this.setLogicName(this.psDETree.getPSDETREEVIEWNAME());
            this.setPSObjectData(this.psDETree);
            if (!(this.getPSDataEntity() != null && StringHelper.compare((String)this.psDETree.getPSDEID(), (String)this.getPSDataEntity().getId(), (boolean)true) == 0 || StringHelper.isNullOrEmpty((String)this.psDETree.getPSDEID()))) {
                this.setPSDataEntity(this.getPSAppView().getPSSystem().getPSDataEntity2(this.psDETree.getPSDEID()));
            }
            this.psDETreeParamImpl.setPSAjaxControlHandlerId(this.psDETree.getPSACHANDLERID());
            this.psDETreeParamImpl.setPSCtrlMsgId(this.psDETree.getPSCTRLMSGID());
            this.psDETreeParamImpl.setPSSysPFPluginId(this.psDETree.getPSSYSPFPLUGINID());
            this.psDETreeParamImpl.setPSDEUILogicGroupId(this.psDETree.getPSCTRLLOGICGROUPID());
            this.psDETreeParamImpl.setPSSysCounterId(this.psDETree.getPSSYSCOUNTERID());
            this.psDETreeParamImpl.setPSSysCssId(this.psDETree.getPSSYSCSSID());
            this.psDETreeParamImpl.merge(iPSControlParam);
            this.strCodeName = this.psDETree.getCODENAME();
            if (StringHelper.isNullOrEmpty((String)this.strCodeName)) {
                this.strCodeName = this.getName();
            }
            if (!(StringHelper.isNullOrEmpty((String)this.strCodeName) || this.getPSSystem() != null && this.getPSSystem().getPSSystemSetting().isFixCodeNameAutoCapitalize())) {
                String strHeader = this.strCodeName.substring(0, 1).toUpperCase();
                this.strCodeName = String.valueOf(strHeader) + this.strCodeName.substring(1);
            }
            this.strEmptyText = this.psDETree.getEMPTYTEXT();
            if (!this.psDETree.isBUFFERRENDERERMODENull()) {
                this.bBufferRenderer = this.psDETree.getBUFFERRENDERERMODE();
            }
            if (!this.psDETree.isNOICONDEFAULTNull()) {
                this.bNoIconDefault = this.psDETree.getNOICONDEFAULT();
            }
            if (!this.psDETree.isENABLESEARCHNull()) {
                this.bEnableSearchDefault = this.psDETree.getENABLESEARCH();
            }
            if (!this.psDETree.isCOLENABLELINKNull()) {
                this.nColumnEnableLink = this.psDETree.getCOLENABLELINK();
            } else if (this.getPSApplication() != null) {
                this.nColumnEnableLink = this.getPSApplication().getPSApplicationUI().getGridColumnEnableLink();
            }
            if (!this.psDETree.isCOLENABLEFILTERNull()) {
                this.nColumnEnableFilter = this.psDETree.getCOLENABLEFILTER();
            } else if (this.getPSApplication() != null) {
                this.nColumnEnableFilter = this.getPSApplication().getPSApplicationUI().getGridColumnEnableFilter();
            }
            super.init(iDAGlobalHelper, iPSControlContainer, strName, this.psDETreeParamImpl);
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
        if (!this.psDETree.isTREEGRIDFLAGNull()) {
            this.nTreeGridMode = this.psDETree.getTREEGRIDFLAG();
            boolean bl = this.bEnableTreeGrid = this.getTreeGridMode() != 0;
        }
        if (!StringHelper.isNullOrEmpty((String)this.psDETree.getEMPTYTEXTPSLANRESID())) {
            this.emptyTextPSLanguageRes = this.getPSAppView().getPSApplication().getPSLanguageRes(this.psDETree.getEMPTYTEXTPSLANRESID());
        }
        if (!StringHelper.isNullOrEmpty((String)this.psDETree.getCATPSCODELISTID())) {
            this.catPSCodeList = this.getPSAppView().getPSApplication().getPSSystem().getPSCodeList(this.psDETree.getCATPSCODELISTID());
        }
        if (this.catPSCodeList != null) {
            this.catPSCodeList = this.getPSAppView().getPSApplication().getPSCodeList(this.catPSCodeList, true);
        }
        super.onInit();
        if (this.isEnableCounter()) {
            this.setPSSysCounterRef(this.preparePSSysCounterRef());
        }
        if (!this.bInvalidId) {
            this.onPreparePSDETreeColumns();
            this.onPreparePSDETreeNodes();
            this.onPreparePSDETreeNodeRSes();
            this.onPreparePSDETreeLogics();
        }
        this.initNavParams(this.psDETree);
    }

    protected IPSSysCounterRef preparePSSysCounterRef() throws Exception {
        String strExpBarCounterId = this.psDETreeParamImpl.getPSSysCounterId();
        if (!StringHelper.isNullOrEmpty((String)strExpBarCounterId)) {
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

    protected void setPSSysCounterRef(IPSSysCounterRef iPSSysCounterRef) {
        this.iPSSysCounterRef = iPSSysCounterRef;
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u8ba1\u6570\u5668\u5f15\u7528", hideempty=true, dumpref=true, from="__self__", fields={"PSSYSCOUNTERID"})
    public IPSAppCounterRef getPSAppCounterRef() {
        if (this.getPSSysCounterRef() != null && this.getPSSysCounterRef() instanceof IPSAppCounterRef) {
            return (IPSAppCounterRef)this.getPSSysCounterRef();
        }
        return null;
    }

    @Override
    protected void onCheckControlParam() throws Exception {
        super.onCheckControlParam();
    }

    protected void onPreparePSDETreeNodes() throws Exception {
        this.psDETreeNodeList.clear();
        this.psDETreeNodeMap.clear();
        Vector<PSDETreeNode> psDETreeNodeList = new Vector<PSDETreeNode>();
        CallResult callResult = this.getPSModelHelper().getPSDETreeNodes(this.getId(), psDETreeNodeList);
        if (callResult.isError()) {
            throw new Exception(StringHelper.format((String)"\u67e5\u8be2\u6811\u8282\u70b9\u96c6\u5408\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        HashMap<String, PSDETreeNode> psDETreeNodeMap2 = new HashMap<String, PSDETreeNode>();
        for (PSDETreeNode psDETreeNode : psDETreeNodeList) {
            psDETreeNodeMap2.put(psDETreeNode.getPSDETREENODEID(), psDETreeNode);
        }
        Vector<PSDETreeNodeRV> psDETreeNodeRVList = new Vector<PSDETreeNodeRV>();
        callResult = this.getPSModelHelper().getPSDETreeNodeRVs(this.getId(), psDETreeNodeRVList);
        if (callResult.isError()) {
            throw new Exception(StringHelper.format((String)"\u67e5\u8be2\u6811\u8282\u70b9\u89c6\u56fe\u5f15\u7528\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSDETreeNodeRV psDETreeNodeRV : psDETreeNodeRVList) {
            PSDETreeNode psDETreeNode = (PSDETreeNode)((Object)psDETreeNodeMap2.get(psDETreeNodeRV.getPSDETREENODEID()));
            if (psDETreeNode != null) {
                psDETreeNode.getPSDETreeNodeRVs(true).add(psDETreeNodeRV);
                continue;
            }
            this.getPSSystemUtil().getPSSysConsole().warn(this.getLogName(), StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6811\u8282\u70b9[%1$s]\uff0c\u5ffd\u7565\u6b64\u6a21\u578b", (Object)psDETreeNodeRV.getPSDETREENODEID()), "PSDETREENODERV", "REMOVE", psDETreeNodeRV.getPSDETREENODERVID());
        }
        Vector<PSDETreeNodeColumn> psDETreeNodeColumnList = new Vector<PSDETreeNodeColumn>();
        callResult = this.getPSModelHelper().getPSDETreeNodeColumns(this.getId(), psDETreeNodeColumnList);
        if (callResult.isError()) {
            throw new Exception(StringHelper.format((String)"\u67e5\u8be2\u6811\u8282\u70b9\u8868\u683c\u5217\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSDETreeNodeColumn psDETreeNodeColumn : psDETreeNodeColumnList) {
            PSDETreeNode psDETreeNode = (PSDETreeNode)((Object)psDETreeNodeMap2.get(psDETreeNodeColumn.getPSDETREENODEID()));
            if (psDETreeNode != null) {
                psDETreeNode.getPSDETreeNodeColumns(true).add(psDETreeNodeColumn);
                continue;
            }
            this.getPSSystemUtil().getPSSysConsole().warn(this.getLogName(), StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6811\u8282\u70b9[%1$s]\uff0c\u5ffd\u7565\u6b64\u6a21\u578b", (Object)psDETreeNodeColumn.getPSDETREENODEID()), "PSDETREECOL", "REMOVE", psDETreeNodeColumn.getPSDETREECOLID());
        }
        for (PSDETreeNode psDETreeNode : psDETreeNodeList) {
            IPSDETreeNodeType iPSDETreeNodeType = this.getPSModelStorage().getPSDETreeNodeType(psDETreeNode.getTREENODETYPE());
            IPSDETreeNode iPSDETreeNode = iPSDETreeNodeType.createPSDETreeNode(psDETreeNode);
            iPSDETreeNode.init(this.getDAGlobalHelper(), this, psDETreeNode);
            this.psDETreeNodeList.add(iPSDETreeNode);
            this.psDETreeNodeMap.put(iPSDETreeNode.getId(), iPSDETreeNode);
            if (!iPSDETreeNode.isRootNode()) continue;
            this.rootPSDETreeNode = iPSDETreeNode;
        }
        PSDETreeImpl.sortPSDETreeNode(this.psDETreeNodeList);
        if (this.rootPSDETreeNode != null) {
            this.psDETreeNodeList.remove(this.rootPSDETreeNode);
            this.psDETreeNodeList.add(0, this.rootPSDETreeNode);
        }
    }

    protected void onPreparePSDETreeNodeRSes() throws Exception {
        this.psDETreeNodeRSList.clear();
        this.psDETreeNodeRSMap.clear();
        Vector<PSDETreeNodeRS> psDETreeNodeRSList = new Vector<PSDETreeNodeRS>();
        CallResult callResult = this.getPSModelHelper().getPSDETreeNodeRSes(this.getId(), psDETreeNodeRSList);
        if (callResult.isError()) {
            throw new Exception(StringHelper.format((String)"\u67e5\u8be2\u6811\u8282\u70b9\u5173\u7cfb\u96c6\u5408\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSDETreeNodeRS psDETreeNodeRS : psDETreeNodeRSList) {
            if (!psDETreeNodeRS.isVALIDFLAGNull() && !psDETreeNodeRS.getVALIDFLAG()) continue;
            PSDETreeNodeRSImpl iPSDETreeNodeRS = new PSDETreeNodeRSImpl();
            iPSDETreeNodeRS.init(this.getDAGlobalHelper(), this, psDETreeNodeRS);
            this.psDETreeNodeRSList.add(iPSDETreeNodeRS);
            this.psDETreeNodeRSMap.put(iPSDETreeNodeRS.getId(), iPSDETreeNodeRS);
        }
    }

    protected void onPreparePSDETreeLogics() throws Exception {
        this.psDETreeLogicList.clear();
        this.onPreparePSDETreeLogics(this.getId());
    }

    protected void onPreparePSDETreeLogics(String strPSDETreeId) throws Exception {
        Vector<PSDETreeLogic> psDETreeLogicList = new Vector<PSDETreeLogic>();
        CallResult callResult = this.getPSModelHelper().getPSDETreeLogics(strPSDETreeId, psDETreeLogicList);
        if (callResult.isError()) {
            throw new Exception(StringHelper.format((String)"\u67e5\u8be2\u6811\u89c6\u56fe\u903b\u8f91\u96c6\u5408\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSDETreeLogic psDETreeLogic : psDETreeLogicList) {
            PSDETreeLogicImpl psDETreeLogicImpl = new PSDETreeLogicImpl();
            psDETreeLogicImpl.init(this.getDAGlobalHelper(), this, psDETreeLogic);
            this.psDETreeLogicList.add(psDETreeLogicImpl);
        }
    }

    protected void onPreparePSDETreeColumns() throws Exception {
        if (!this.isEnableTreeGrid()) {
            return;
        }
        this.psDETreeColumnList.clear();
        this.psDETreeColumnMap.clear();
        Vector<PSDETreeColumn> psDETreeColumnList = new Vector<PSDETreeColumn>();
        CallResult callResult = this.getPSModelHelper().getPSDETreeColumns(this.getId(), psDETreeColumnList);
        if (callResult.isError()) {
            throw new Exception(StringHelper.format((String)"\u67e5\u8be2\u6811\u8868\u683c\u5217\u96c6\u5408\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSDETreeColumn psDETreeColumn : psDETreeColumnList) {
            IPSDEGridColumnType iPSDEGridColumnType = this.getPSModelStorage().getPSDEGridColumnType(psDETreeColumn.getGRIDCOLTYPE());
            IPSDETreeColumn iPSDETreeColumn = iPSDEGridColumnType.createPSDETreeColumn(psDETreeColumn);
            iPSDETreeColumn.init(this.getDAGlobalHelper(), this, null, psDETreeColumn);
            this.psDETreeColumnList.add(iPSDETreeColumn);
            this.psDETreeColumnMap.put(iPSDETreeColumn.getId(), iPSDETreeColumn);
        }
    }

    @Override
    protected String onGetControlType() {
        return "TREEVIEW";
    }

    public Iterator<ITreeNode> getTreeNodes() {
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u6811\u8282\u70b9\u96c6\u5408", child=true, group="\u90e8\u4ef6\u5143\u7d20", order=162)
    public Iterator<IPSDETreeNode> getPSDETreeNodes() {
        return this.psDETreeNodeList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u6811\u8282\u70b9\u5173\u7cfb\u96c6\u5408", child=true, group="\u90e8\u4ef6\u5143\u7d20", order=163)
    public Iterator<IPSDETreeNodeRS> getPSDETreeNodeRSs() {
        return this.psDETreeNodeRSList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u540e\u53f0\u90e8\u4ef6\u53c2\u6570")
    public IPSAjaxControlParam getPSAjaxControlParam() {
        return this.psDETreeParamImpl;
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.onGetCodeName();
    }

    @Override
    protected String onGetCodeName() {
        return this.getPSApplication().getViewCodeName(null, this.strCodeName, null);
    }

    @Override
    public String getModelScope() {
        return "DE";
    }

    @Override
    public IPSDETreeNodeRS getPSDETreeNodeRS(String strPSDETreeNodeRSId) throws Exception {
        IPSDETreeNodeRS iPSDETreeNodeRS = this.psDETreeNodeRSMap.get(strPSDETreeNodeRSId);
        if (iPSDETreeNodeRS == null) {
            throw new Exception(StringHelper.format((String)"\u6811\u89c6\u56fe\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u6811\u8282\u70b9\u5173\u7cfb[%1$s]", (Object)strPSDETreeNodeRSId));
        }
        return iPSDETreeNodeRS;
    }

    @Override
    public IPSDETreeNode getPSDETreeNode(String strPSDETreeNodeId) throws Exception {
        IPSDETreeNode iPSDETreeNode = this.psDETreeNodeMap.get(strPSDETreeNodeId);
        if (iPSDETreeNode == null) {
            throw new Exception(StringHelper.format((String)"\u6811\u89c6\u56fe\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u6811\u8282\u70b9[%1$s]", (Object)strPSDETreeNodeId));
        }
        return iPSDETreeNode;
    }

    @Override
    public IPSDETreeColumn getPSDETreeColumn(String strPSDETreeColumnId) throws Exception {
        IPSDETreeColumn iPSDETreeColumn = this.psDETreeColumnMap.get(strPSDETreeColumnId);
        if (iPSDETreeColumn == null) {
            throw new Exception(StringHelper.format((String)"\u6811\u89c6\u56fe\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u6811\u89c6\u56fe\u5217\u5bf9\u8c61[%1$s]", (Object)strPSDETreeColumnId));
        }
        return iPSDETreeColumn;
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u6839\u9009\u62e9", fields={"ROOTSELECT"})
    public boolean isEnableRootSelect() {
        return this.psDETree.getROOTSELECT();
    }

    @Override
    @PSModelRTMeta(description="\u663e\u793a\u6839", fields={"SHOWROOT"})
    public boolean isRootVisible() {
        return this.psDETree.getSHOWROOT();
    }

    @Override
    @PSModelRTMeta(description="\u5206\u7c7b\u4ee3\u7801\u8868\u5bf9\u8c61", hideempty=true, fields={"CATPSCODELISTID"})
    public IPSCodeList getCatPSCodeList() {
        return this.catPSCodeList;
    }

    @Override
    public void fillRelatedPSAppViews(ArrayList<IPSAppView> relatedAppViewList) throws Exception {
        for (IPSDETreeNode iPSDETreeNode : this.psDETreeNodeList) {
            iPSDETreeNode.fillRelatedPSAppViews(relatedAppViewList);
        }
        super.fillRelatedPSAppViews(relatedAppViewList);
    }

    @Override
    @PSModelRTMeta(description="\u65e0\u503c\u5185\u5bb9\u8bed\u8a00\u8d44\u6e90", fields={"EMPTYTEXTPSLANRESID"})
    public IPSLanguageRes getEmptyTextPSLanguageRes() {
        if (this.emptyTextPSLanguageRes == null && this.getPSApplication() != null) {
            return this.getPSApplication().getPSApplicationUI().getMDCtrlEmptyTextPSLanguageRes();
        }
        return this.emptyTextPSLanguageRes;
    }

    @Override
    @PSModelRTMeta(description="\u65e0\u503c\u663e\u793a\u5185\u5bb9", fields={"EMPTYTEXT"})
    public String getEmptyText() {
        if (StringHelper.isNullOrEmpty((String)this.strEmptyText) && this.getPSApplication() != null) {
            return this.getPSApplication().getPSApplicationUI().getMDCtrlEmptyText();
        }
        return this.strEmptyText;
    }

    @Override
    @PSModelRTMeta(description="\u6811\u8868\u683c\u5217\u96c6\u5408", hideempty=true, child=true, group="\u90e8\u4ef6\u5143\u7d20", order=165)
    public Iterator<IPSDETreeColumn> getPSDETreeColumns() {
        if (!this.isEnableTreeGrid() || this.psDETreeColumnList.size() == 0) {
            return null;
        }
        return this.psDETreeColumnList.iterator();
    }

    @Override
    public String getModelType() {
        return "PSDETREEVIEW";
    }

    @Override
    public boolean hasWFDataItems() {
        return false;
    }

    @Override
    public boolean isEnableTreeGrid() {
        return this.bEnableTreeGrid;
    }

    @Override
    public boolean isBufferRenderer() {
        return this.bBufferRenderer;
    }

    @Override
    @PSModelRTMeta(description="\u6839\u8282\u70b9")
    public IPSDETreeNode getRootPSDETreeNode() {
        return this.rootPSDETreeNode;
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u8f93\u51fa\u56fe\u6807", fields={"NOICONDEFAULT"})
    public boolean isOutputIconDefault() {
        return !this.bNoIconDefault;
    }

    public boolean isEnableCounter() {
        return this.bEnableCounter;
    }

    @Override
    @PSModelRTMeta(description="\u6811\u8868\u683c\u6a21\u5f0f", codelist="TreeGridMode", fields={"TREEGRIDFLAG"})
    public int getTreeGridMode() {
        return this.nTreeGridMode;
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u652f\u6301\u641c\u7d22", dump=false)
    public boolean isEnableSearchDefault() {
        return this.bEnableSearchDefault;
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u7f16\u8f91", ignoredumpvalues="false", model="PSDEViewCtrl", fields={"CTRLPARAM6"})
    public boolean isEnableEdit() {
        if (this.psDETreeParamImpl.isEnableEdit() == null) {
            return false;
        }
        return this.psDETreeParamImpl.isEnableEdit();
    }

    public static void sortPSDETreeNode(List<IPSDETreeNode> list) {
        Collections.sort(list, new Comparator<Object>(){

            @Override
            public int compare(Object o1, Object o2) {
                int nRet = 0;
                IPSDETreeNode i1 = (IPSDETreeNode)o1;
                IPSDETreeNode i2 = (IPSDETreeNode)o2;
                nRet = StringHelper.compare((String)i1.getNodeType(), (String)i2.getNodeType(), (boolean)false);
                if (nRet != 0) {
                    return nRet;
                }
                nRet = StringHelper.compare((String)i1.getName(), (String)i2.getName(), (boolean)false);
                return nRet;
            }
        });
    }

    @Override
    @PSModelRTMeta(description="\u6811\u89c6\u56fe\u903b\u8f91\u96c6\u5408", group="\u90e8\u4ef6\u903b\u8f91", order=217)
    public Iterator<? extends IPSDETreeLogic> getPSDETreeLogics() {
        if (this.psDETreeLogicList == null || this.psDETreeLogicList.size() == 0) {
            return null;
        }
        return this.psDETreeLogicList.iterator();
    }

    @Override
    protected Iterator<? extends IPSAppDEUILogicGroupDetail> getPSAppDEUILogicGroupDetails() {
        if (this.psDETreeLogicList == null || this.psDETreeLogicList.size() == 0) {
            return null;
        }
        return this.psDETreeLogicList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u5217\u94fe\u63a5\u6a21\u5f0f", codelist="DEGridColLinkMode", dump=false, fields={"COLENABLELINK"})
    public int getColumnEnableLink() {
        return this.nColumnEnableLink;
    }

    @Override
    @PSModelRTMeta(description="\u56fa\u5b9a\u8d77\u59cb\u5217\u6570", ignoredumpvalues="0", fields={"FROZENCOL"})
    public int getFrozenFirstColumn() {
        if (!this.psDETree.isFROZENCOLNull() && this.psDETree.getFROZENCOL() > 0) {
            return this.psDETree.getFROZENCOL();
        }
        return 0;
    }

    @Override
    @PSModelRTMeta(description="\u56fa\u5b9a\u672b\u5c3e\u5217\u6570", ignoredumpvalues="0", fields={"FROZENLASTCOL"})
    public int getFrozenLastColumn() {
        if (!this.psDETree.isFROZENLASTCOLNull() && this.psDETree.getFROZENLASTCOL() > 0) {
            return this.psDETree.getFROZENLASTCOL();
        }
        return 0;
    }

    @Override
    @PSModelRTMeta(description="\u6811\u89c6\u56fe\u6837\u5f0f", codelist="TreeStyle", fields={"TREESTYLE"})
    public String getTreeStyle() {
        return this.psDETree.getTREESTYLE();
    }
}

