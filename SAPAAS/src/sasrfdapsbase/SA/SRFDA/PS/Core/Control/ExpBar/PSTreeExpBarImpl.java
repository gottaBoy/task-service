/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.PS.Core.Control.ExpBar;

import SA.SRFDA.PS.Core.App.View.IPSAppExplorerView;
import SA.SRFDA.PS.Core.App.View.IPSAppViewRef;
import SA.SRFDA.PS.Core.Control.ExpBar.IPSTreeExpBar;
import SA.SRFDA.PS.Core.Control.ExpBar.IPSTreeExpBarParam;
import SA.SRFDA.PS.Core.Control.ExpBar.PSExpBarImpl;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Control.PSControlLogicImpl;
import SA.SRFDA.PS.Core.Control.Tree.IPSDETree;
import SA.SRFDA.PS.Core.Control.Tree.IPSDETreeNode;
import SA.SRFDA.PS.Core.Control.Tree.PSDETreeGridExParamImpl;
import SA.SRFDA.PS.Core.Control.Tree.PSDETreeParamImpl;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDER1N;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Data.PSAppViewRef;
import SA.SRFDA.PS.Data.PSDETreeView;
import SA.SRFDA.PS.Data.PSDEViewCtrl;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Iterator;
import net.sf.json.JSONObject;

@PSModelImplementMeta(implement="IPSControl", typevalues={"TREEEXPBAR"})
public class PSTreeExpBarImpl
extends PSExpBarImpl
implements IPSTreeExpBar {
    public static final String TREENAME = "_tree";
    private IPSDETree iPSDETree = null;
    private IPSTreeExpBarParam iPSTreeExpBarParam = null;

    @Override
    protected void onInit() throws Exception {
        Iterator<IPSDETreeNode> psDETreeNodes;
        String strKey;
        Iterator<String> ctrlParamNames;
        PSDEViewCtrl treePSDEViewCtrl;
        PSDETreeParamImpl psDETreeParamImpl;
        this.iPSTreeExpBarParam = (IPSTreeExpBarParam)this.getPSControlParam();
        boolean bIFrameMode = false;
        if (this.getPSAppView() instanceof IPSAppExplorerView) {
            bIFrameMode = ((IPSAppExplorerView)this.getPSAppView()).isIFrameMode();
        }
        boolean bTreeGridExMode = false;
        if (!StringHelper.IsNullOrEmpty((String)this.iPSTreeExpBarParam.getPSDETreeId())) {
            PSDETreeView psDETree = new PSDETreeView();
            CallResult callResult = this.getPSModelHelper().getPSDETreeView(this.iPSTreeExpBarParam.getPSDETreeId(), psDETree);
            if (callResult != null && callResult.isOk()) {
                boolean bl = bTreeGridExMode = psDETree.getTREEGRIDFLAG() == 1;
            }
        }
        if (!bTreeGridExMode) {
            psDETreeParamImpl = new PSDETreeParamImpl();
            treePSDEViewCtrl = new PSDEViewCtrl();
            treePSDEViewCtrl.setPSDEVIEWCTRLNAME(String.valueOf(this.getName()) + TREENAME);
            treePSDEViewCtrl.setPSDETREEVIEWID(this.iPSTreeExpBarParam.getPSDETreeId());
            if (this.iPSTreeExpBarParam.isEnableEdit() != null) {
                treePSDEViewCtrl.setCTRLPARAM6(this.iPSTreeExpBarParam.isEnableEdit());
            }
            treePSDEViewCtrl.setPSACHANDLERID(this.iPSTreeExpBarParam.getPSDEViewCtrlData().getSUBPSACHANDLERID());
            psDETreeParamImpl.init(this.getDAGlobalHelper(), this.getPSAppView(), treePSDEViewCtrl);
            if (this.iPSTreeExpBarParam.getCtrlParamNames() != null) {
                ctrlParamNames = this.iPSTreeExpBarParam.getCtrlParamNames();
                while (ctrlParamNames.hasNext()) {
                    strKey = ctrlParamNames.next();
                    psDETreeParamImpl.setCtrlParam(strKey, this.iPSTreeExpBarParam.getCtrlParam(strKey));
                }
            }
            this.iPSDETree = (IPSDETree)this.registerPSControl(String.valueOf(this.getName()) + TREENAME, "TREEVIEW", psDETreeParamImpl);
        } else {
            psDETreeParamImpl = new PSDETreeGridExParamImpl();
            treePSDEViewCtrl = new PSDEViewCtrl();
            treePSDEViewCtrl.setPSDEVIEWCTRLNAME(String.valueOf(this.getName()) + TREENAME);
            treePSDEViewCtrl.setPSDETREEVIEWID(this.iPSTreeExpBarParam.getPSDETreeId());
            if (this.iPSTreeExpBarParam.isEnableEdit() != null) {
                treePSDEViewCtrl.setCTRLPARAM6(this.iPSTreeExpBarParam.isEnableEdit());
            }
            treePSDEViewCtrl.setPSACHANDLERID(this.iPSTreeExpBarParam.getPSDEViewCtrlData().getSUBPSACHANDLERID());
            psDETreeParamImpl.init(this.getDAGlobalHelper(), this.getPSAppView(), treePSDEViewCtrl);
            if (this.iPSTreeExpBarParam.getCtrlParamNames() != null) {
                ctrlParamNames = this.iPSTreeExpBarParam.getCtrlParamNames();
                while (ctrlParamNames.hasNext()) {
                    strKey = ctrlParamNames.next();
                    psDETreeParamImpl.setCtrlParam(strKey, this.iPSTreeExpBarParam.getCtrlParam(strKey));
                }
            }
            this.iPSDETree = (IPSDETree)this.registerPSControl(String.valueOf(this.getName()) + TREENAME, "TREEGRIDEX", psDETreeParamImpl);
        }
        if (this.iPSDETree != null && this.isPrepareDefaultPSAppViewLogics()) {
            this.iPSDETree.registerPSControlLogic(new PSControlLogicImpl(this){

                @Override
                public String getName() {
                    return StringHelper.Format((String)"%1$s_selectionchange", (Object)super.getName());
                }

                @Override
                public String getLogicTag() {
                    return PSTreeExpBarImpl.this.getPSDETree().getName();
                }

                @Override
                public String getEventNames() {
                    return "SELECTIONCHANGE";
                }
            });
            this.iPSDETree.registerPSControlLogic(new PSControlLogicImpl(this){

                @Override
                public String getName() {
                    return StringHelper.Format((String)"%1$s_load", (Object)super.getName());
                }

                @Override
                public String getLogicTag() {
                    return PSTreeExpBarImpl.this.getPSDETree().getName();
                }

                @Override
                public String getEventNames() {
                    return "LOAD";
                }
            });
        }
        if ((psDETreeNodes = this.iPSDETree.getPSDETreeNodes()) != null) {
            boolean bRegisterPSAppViewRefToContainer = !this.isPrepareDefaultPSAppViewLogics();
            while (psDETreeNodes.hasNext()) {
                String strKey2;
                Iterator keys;
                IPSDETreeNode iPSDETreeNode = psDETreeNodes.next();
                if (StringHelper.IsNullOrEmpty((String)iPSDETreeNode.getNavPSDEViewId())) continue;
                String strExpId = iPSDETreeNode.getNodeType();
                String strViewRefMode = StringHelper.Format((String)"%1$s:%2$s", (Object)"EXPITEM", (Object)strExpId);
                PSAppViewRef psAppViewRef = new PSAppViewRef();
                psAppViewRef.setPSAPPVIEWREFNAME(strViewRefMode);
                psAppViewRef.setREFMODETEXT(StringHelper.Format((String)"[%1$s]\u5bfc\u822a\u89c6\u56fe", (Object)iPSDETreeNode.getName()));
                psAppViewRef.setMINORPSAPPVIEWID(iPSDETreeNode.getNavPSAppView().getId());
                if (!bIFrameMode) {
                    psAppViewRef.setParamValue("EMBEDVIEWID", iPSDETreeNode.getEmbedViewId());
                }
                IPSAppViewRef ipsAppViewRef = null;
                ipsAppViewRef = bRegisterPSAppViewRefToContainer ? this.getPSControlContainer().registerPSAppViewRef(psAppViewRef) : this.registerPSAppViewRef(psAppViewRef);
                if (iPSDETreeNode.getNavViewParam() != null) {
                    JSONObject joViewParam = ipsAppViewRef.getViewParam(true);
                    keys = iPSDETreeNode.getNavViewParam().keys();
                    while (keys.hasNext()) {
                        strKey2 = keys.next().toString();
                        joViewParam.put(strKey2, iPSDETreeNode.getNavViewParam().get(strKey2));
                    }
                }
                if (bRegisterPSAppViewRefToContainer) continue;
                JSONObject parentDataJO = ipsAppViewRef.getParentDataJO(true);
                if (iPSDETreeNode.getNavViewParam() != null) {
                    keys = iPSDETreeNode.getNavViewParam().keys();
                    while (keys.hasNext()) {
                        strKey2 = keys.next().toString();
                        if (parentDataJO.has(strKey2)) continue;
                        parentDataJO.put(strKey2, iPSDETreeNode.getNavViewParam().get(strKey2));
                    }
                }
                if (!StringHelper.IsNullOrEmpty((String)iPSDETreeNode.getNavFilter()) && !parentDataJO.has("srfparentdefname")) {
                    parentDataJO.put("srfparentdefname", (Object)iPSDETreeNode.getNavFilter());
                }
                if (iPSDETreeNode.getNavPSDER() == null || !(iPSDETreeNode.getNavPSDER() instanceof IPSDER1N)) continue;
                IPSDER1N iPSDER1N = (IPSDER1N)iPSDETreeNode.getNavPSDER();
                if (!parentDataJO.has("srfparentmode")) {
                    parentDataJO.put("srfparentmode", (Object)iPSDER1N.getName());
                }
                if (!parentDataJO.has("srfparentdename")) {
                    parentDataJO.put("srfparentdename", (Object)iPSDER1N.getMajorDEName());
                }
                if (parentDataJO.has("srfparentdefname")) continue;
                parentDataJO.put("srfparentdefname", (Object)iPSDER1N.getPickupDEFName());
            }
        }
        super.onInit();
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u6811\u89c6\u56fe")
    public IPSDETree getPSDETree() {
        return this.iPSDETree;
    }

    @Override
    protected String onGetControlType() {
        return "TREEEXPBAR";
    }

    @Override
    public String getModelScope() {
        return "DE";
    }

    @Override
    protected IPSControl onGetXDataPSControl() {
        return this.getPSDETree();
    }
}

