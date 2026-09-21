/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.PS.Core.Control.ExpBar;

import SA.SRFDA.PS.Core.App.View.IPSAppViewRef;
import SA.SRFDA.PS.Core.Control.ExpBar.IPSGanttExpBar;
import SA.SRFDA.PS.Core.Control.ExpBar.IPSGanttExpBarParam;
import SA.SRFDA.PS.Core.Control.ExpBar.PSMDControlExpBarImplBase2;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Control.Tree.IPSDEGantt;
import SA.SRFDA.PS.Core.Control.Tree.IPSDETreeNode;
import SA.SRFDA.PS.Core.Control.Tree.PSDEGanttParamImpl;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDER1N;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Data.PSAppViewRef;
import SA.SRFDA.PS.Data.PSDEViewCtrl;
import java.util.Iterator;
import net.ibizsys.paas.util.StringHelper;
import net.sf.json.JSONObject;

@PSModelImplementMeta(implement="IPSControl", typevalues={"GANTTEXPBAR"})
public class PSGanttExpBarImpl
extends PSMDControlExpBarImplBase2
implements IPSGanttExpBar {
    public static final String GANTTNAME = "_gantt";
    private IPSDEGantt iPSDEGantt = null;
    private IPSGanttExpBarParam iPSGanttExpBarParam = null;

    @Override
    protected void onInit() throws Exception {
        this.iPSGanttExpBarParam = (IPSGanttExpBarParam)this.getPSControlParam();
        PSDEGanttParamImpl psDEGanttParamImpl = new PSDEGanttParamImpl();
        PSDEViewCtrl gridPSDEViewCtrl = new PSDEViewCtrl();
        gridPSDEViewCtrl.setPSDEVIEWCTRLNAME(String.valueOf(this.getName()) + GANTTNAME);
        gridPSDEViewCtrl.setPSDETREEVIEWID(this.iPSGanttExpBarParam.getPSDETreeId());
        gridPSDEViewCtrl.setPSACHANDLERID(this.iPSGanttExpBarParam.getPSDEViewCtrlData().getSUBPSACHANDLERID());
        psDEGanttParamImpl.init(this.getDAGlobalHelper(), this.getPSAppView(), gridPSDEViewCtrl);
        if (this.iPSGanttExpBarParam.getCtrlParamNames() != null) {
            Iterator<String> ctrlParamNames = this.iPSGanttExpBarParam.getCtrlParamNames();
            while (ctrlParamNames.hasNext()) {
                String strKey = ctrlParamNames.next();
                psDEGanttParamImpl.setCtrlParam(strKey, this.iPSGanttExpBarParam.getCtrlParam(strKey));
            }
        }
        this.iPSDEGantt = (IPSDEGantt)this.registerPSControl(String.valueOf(this.getName()) + GANTTNAME, "GANTT", psDEGanttParamImpl);
        super.onInit();
        Iterator<IPSDETreeNode> psDETreeNodes = this.iPSDEGantt.getPSDETreeNodes();
        if (psDETreeNodes != null) {
            boolean bRegisterPSAppViewRefToContainer = !this.isPrepareDefaultPSAppViewLogics();
            while (psDETreeNodes.hasNext()) {
                String strKey;
                Iterator keys;
                IPSDETreeNode iPSDEGanttNode = psDETreeNodes.next();
                if (StringHelper.isNullOrEmpty((String)iPSDEGanttNode.getNavPSDEViewId())) continue;
                String strExpId = iPSDEGanttNode.getNodeType();
                String strViewRefMode = StringHelper.format((String)"%1$s:%2$s", (Object)"EXPITEM", (Object)strExpId);
                PSAppViewRef psAppViewRef = new PSAppViewRef();
                psAppViewRef.setPSAPPVIEWREFNAME(strViewRefMode);
                psAppViewRef.setREFMODETEXT(StringHelper.format((String)"[%1$s]\u5bfc\u822a\u89c6\u56fe", (Object)iPSDEGanttNode.getName()));
                psAppViewRef.setMINORPSAPPVIEWID(iPSDEGanttNode.getNavPSAppView().getId());
                psAppViewRef.setParamValue("EMBEDVIEWID", iPSDEGanttNode.getEmbedViewId());
                IPSAppViewRef ipsAppViewRef = null;
                ipsAppViewRef = bRegisterPSAppViewRefToContainer ? this.getPSControlContainer().registerPSAppViewRef(psAppViewRef) : this.registerPSAppViewRef(psAppViewRef);
                if (iPSDEGanttNode.getNavViewParam() != null) {
                    JSONObject joViewParam = ipsAppViewRef.getViewParam(true);
                    keys = iPSDEGanttNode.getNavViewParam().keys();
                    while (keys.hasNext()) {
                        strKey = keys.next().toString();
                        joViewParam.put(strKey, iPSDEGanttNode.getNavViewParam().get(strKey));
                    }
                }
                if (bRegisterPSAppViewRefToContainer) continue;
                JSONObject parentDataJO = ipsAppViewRef.getParentDataJO(true);
                if (iPSDEGanttNode.getNavViewParam() != null) {
                    keys = iPSDEGanttNode.getNavViewParam().keys();
                    while (keys.hasNext()) {
                        strKey = keys.next().toString();
                        if (parentDataJO.has(strKey)) continue;
                        parentDataJO.put(strKey, iPSDEGanttNode.getNavViewParam().get(strKey));
                    }
                }
                if (!StringHelper.isNullOrEmpty((String)iPSDEGanttNode.getNavFilter()) && !parentDataJO.has("srfparentdefname")) {
                    parentDataJO.put("srfparentdefname", (Object)iPSDEGanttNode.getNavFilter());
                }
                if (iPSDEGanttNode.getNavPSDER() == null || !(iPSDEGanttNode.getNavPSDER() instanceof IPSDER1N)) continue;
                IPSDER1N iPSDER1N = (IPSDER1N)iPSDEGanttNode.getNavPSDER();
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
    }

    @Override
    @PSModelRTMeta(description="\u7518\u7279\u90e8\u4ef6")
    public IPSDEGantt getPSDEGantt() {
        return this.iPSDEGantt;
    }

    @Override
    protected String onGetControlType() {
        return "GANTTEXPBAR";
    }

    @Override
    protected IPSControl onGetXDataPSControl() {
        return this.getPSDEGantt();
    }
}

