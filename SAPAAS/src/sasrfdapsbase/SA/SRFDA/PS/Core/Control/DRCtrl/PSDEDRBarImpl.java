/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.control.drctrl.DRCtrlItem
 *  net.ibizsys.paas.util.JSONObjectHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Control.DRCtrl;

import SA.SRFDA.PS.Core.App.View.IPSAppViewRef;
import SA.SRFDA.PS.Core.Control.DRCtrl.IPSDEDRBar;
import SA.SRFDA.PS.Core.Control.DRCtrl.IPSDEDRBarGroup;
import SA.SRFDA.PS.Core.Control.DRCtrl.IPSDEDRBarItem;
import SA.SRFDA.PS.Core.Control.DRCtrl.IPSDEDRBarParam;
import SA.SRFDA.PS.Core.Control.DRCtrl.PSDEDRBarGroupImpl;
import SA.SRFDA.PS.Core.Control.DRCtrl.PSDEDRBarItemImpl;
import SA.SRFDA.PS.Core.Control.DRCtrl.PSDEDRCtrlImpl;
import SA.SRFDA.PS.Core.Control.IPSAjaxControlParam;
import SA.SRFDA.PS.Core.Control.IPSControlContainer;
import SA.SRFDA.PS.Core.Control.IPSControlParam;
import SA.SRFDA.PS.Core.Control.IPSControlType;
import SA.SRFDA.PS.Core.Control.Tree.IPSDETree;
import SA.SRFDA.PS.Core.Control.Tree.IPSDETreeNode;
import SA.SRFDA.PS.Core.DataEntity.DR.IPSDEDRDetail;
import SA.SRFDA.PS.Core.DataEntity.DR.IPSDEDRGroup;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Data.PSAppViewRef;
import SA.SRFDA.PS.Data.PSDEViewCtrl;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import net.ibizsys.paas.control.drctrl.DRCtrlItem;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelImplementMeta(implement="IPSControl", typevalues={"DRBAR"})
public class PSDEDRBarImpl
extends PSDEDRCtrlImpl
implements IPSDEDRBar {
    private static final Log log = LogFactory.getLog(PSDEDRBarImpl.class);
    protected ArrayList<IPSDEDRBarGroup> psDEDRBarGroupList = new ArrayList();
    protected IPSDEDRBarParam iPSDEDRBarParam = null;
    protected ArrayList<IPSDEDRBarItem> psDEDRBarItemList = new ArrayList();
    private IPSLanguageRes titlePSLanguageRes = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSControlContainer iPSControlContainer, String strName, IPSControlParam iPSControlParam) throws Exception {
        try {
            this.iPSDEDRBarParam = (IPSDEDRBarParam)iPSControlParam;
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
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.iPSDEDRBarParam.getTitlePSLanguageResId())) {
            this.titlePSLanguageRes = this.getPSApplication().getPSLanguageRes(this.iPSDEDRBarParam.getTitlePSLanguageResId());
        }
        super.onInit();
    }

    @Override
    protected void fillDRCtrlItems() throws Exception {
        this.drCtrlRootItem.reset();
        this.psDEDRBarGroupList.clear();
        this.psDEDRCtrlItemList.clear();
        this.psDEDRBarItemList.clear();
        boolean bRegisterPSAppViewRefToContainer = !this.isPrepareDefaultPSAppViewLogics();
        DRCtrlItem formDRBarItem = null;
        if (!this.isHideEditItem()) {
            formDRBarItem = new DRCtrlItem();
            formDRBarItem.setId("form");
            if (this.getPSDEDataRelation() != null) {
                formDRBarItem.setText(this.getPSDEDataRelation().getFormCaption());
                if (this.getPSDEDataRelation().getFormCapPSLanguageRes() != null) {
                    formDRBarItem.setTextLanResTag(this.getPSDEDataRelation().getFormCapPSLanguageRes().getLanResTag());
                }
                if (this.getPSDEDataRelation().getFormPSSysImage() != null) {
                    formDRBarItem.setIconCls(this.getPSDEDataRelation().getFormPSSysImage().getCssClass());
                    formDRBarItem.setIconPath(this.getPSDEDataRelation().getFormPSSysImage().getImagePath());
                    formDRBarItem.setIconClsX(this.getPSDEDataRelation().getFormPSSysImage().getCssClassX());
                    formDRBarItem.setIconPathX(this.getPSDEDataRelation().getFormPSSysImage().getImagePathX());
                }
            } else {
                formDRBarItem.setText(this.getPSDataEntity().getLogicName());
                if (this.getPSDataEntity().getLNPSLanguageRes() != null) {
                    formDRBarItem.setTextLanResTag(this.getPSDataEntity().getLNPSLanguageRes().getLanResTag());
                }
                if (this.getPSDataEntity().getPSSysImage() != null) {
                    formDRBarItem.setIconCls(this.getPSDataEntity().getPSSysImage().getCssClass());
                    formDRBarItem.setIconPath(this.getPSDataEntity().getPSSysImage().getImagePath());
                    formDRBarItem.setIconClsX(this.getPSDataEntity().getPSSysImage().getCssClassX());
                    formDRBarItem.setIconPathX(this.getPSDataEntity().getPSSysImage().getImagePathX());
                }
            }
            formDRBarItem.setExpanded(true);
            this.drCtrlRootItem.getItems().add(formDRBarItem);
        }
        HashMap<String, PSDEDRBarGroupImpl> psDEDRBarGroupMap = new HashMap<String, PSDEDRBarGroupImpl>();
        HashMap<String, DRCtrlItem> psDEDRBarGroupItemMap = new HashMap<String, DRCtrlItem>();
        Iterator<IPSDEDRDetail> psDEDRDetails = this.iPSDEDataRelation.getPSDEDRDetails();
        while (psDEDRDetails.hasNext()) {
            Iterator it;
            JSONObject drViewParamJO;
            IPSDEDRDetail iPSDEDRDetail = psDEDRDetails.next();
            String strPSDEDRGroupId = iPSDEDRDetail.getPSDEDRGroupId();
            PSDEDRBarGroupImpl psDEDRBarGroupImpl = (PSDEDRBarGroupImpl)psDEDRBarGroupMap.get(strPSDEDRGroupId);
            DRCtrlItem groupDRBarItem = (DRCtrlItem)psDEDRBarGroupItemMap.get(strPSDEDRGroupId);
            if (psDEDRBarGroupImpl == null) {
                IPSDEDRGroup iPSDEDRGroup = this.iPSDEDataRelation.getPSDataEntity().getPSDEDRGroup(strPSDEDRGroupId);
                psDEDRBarGroupImpl = new PSDEDRBarGroupImpl();
                psDEDRBarGroupImpl.init(this.getDAGlobalHelper(), this, iPSDEDRGroup);
                this.psDEDRBarGroupList.add(psDEDRBarGroupImpl);
                psDEDRBarGroupMap.put(strPSDEDRGroupId, psDEDRBarGroupImpl);
                groupDRBarItem = new DRCtrlItem();
                groupDRBarItem.setId(iPSDEDRGroup.getId());
                groupDRBarItem.setText(iPSDEDRGroup.getCaption(this.getPSAppView().getLanguage()));
                groupDRBarItem.setExpanded(true);
                if (iPSDEDRGroup.getCapPSLanguageRes() != null) {
                    groupDRBarItem.setTextLanResTag(iPSDEDRGroup.getCapPSLanguageRes().getLanResTag());
                }
                if (iPSDEDRGroup.getPSSysImage() != null) {
                    groupDRBarItem.setIconCls(iPSDEDRGroup.getPSSysImage().getCssClass());
                    groupDRBarItem.setIconPath(iPSDEDRGroup.getPSSysImage().getImagePath());
                    groupDRBarItem.setIconClsX(iPSDEDRGroup.getPSSysImage().getCssClassX());
                    groupDRBarItem.setIconPathX(iPSDEDRGroup.getPSSysImage().getImagePathX());
                }
                if (!psDEDRBarGroupImpl.isHidden()) {
                    if (formDRBarItem != null) {
                        formDRBarItem.getItems().add(groupDRBarItem);
                    } else {
                        this.drCtrlRootItem.getItems().add(groupDRBarItem);
                    }
                }
                psDEDRBarGroupItemMap.put(strPSDEDRGroupId, groupDRBarItem);
            }
            PSDEDRBarItemImpl psDEDRBarItemImpl = new PSDEDRBarItemImpl();
            psDEDRBarItemImpl.init(this.getDAGlobalHelper(), this, psDEDRBarGroupImpl, iPSDEDRDetail);
            psDEDRBarGroupImpl.addPSDEDRBarItem(psDEDRBarItemImpl);
            this.psDEDRBarItemList.add(psDEDRBarItemImpl);
            DRCtrlItem drBarItem = new DRCtrlItem();
            drBarItem.setId(psDEDRBarItemImpl.getName());
            drBarItem.setText(psDEDRBarItemImpl.getCaption());
            drBarItem.setViewParam("srfparentdeid", this.getPSDataEntity().getId());
            if (psDEDRBarItemImpl.getCapPSLanguageRes() != null) {
                drBarItem.setTextLanResTag(psDEDRBarItemImpl.getCapPSLanguageRes().getLanResTag());
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)iPSDEDRDetail.getCounterId())) {
                drBarItem.setCounterId(iPSDEDRDetail.getCounterId());
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)iPSDEDRDetail.getEnableMode())) {
                drBarItem.setEnableMode(iPSDEDRDetail.getEnableMode());
            }
            if (iPSDEDRDetail.getTestPSDEAction() != null) {
                drBarItem.setTestEnableDEActionName(iPSDEDRDetail.getTestPSDEAction().getName());
            }
            if (iPSDEDRDetail.getTestPSDEOPPriv() != null) {
                drBarItem.setTestEnableDEOPPriv(iPSDEDRDetail.getTestPSDEOPPriv().getName());
            }
            if (psDEDRBarItemImpl.getPSAppView() != null) {
                String strViewId = psDEDRBarItemImpl.getName().toUpperCase();
                String strViewRefMode = SA.SRFramework.Utility.StringHelper.Format((String)"%1$s:%2$s", (Object)"DRITEM", (Object)strViewId);
                PSAppViewRef psAppViewRef = new PSAppViewRef();
                psAppViewRef.setPSAPPVIEWREFNAME(strViewRefMode);
                psAppViewRef.setMINORPSAPPVIEWID(psDEDRBarItemImpl.getPSAppView().getId());
                psAppViewRef.setParamValue("EMBEDVIEWID", psDEDRBarItemImpl.getEmbedViewId());
                IPSAppViewRef iPSAppViewRef = null;
                iPSAppViewRef = bRegisterPSAppViewRefToContainer ? this.getPSControlContainer().registerPSAppViewRef(psAppViewRef) : this.registerPSAppViewRef(psAppViewRef);
                JSONObject parentModeJO = iPSAppViewRef.getParentModeJO(true);
                JSONObjectHelper.copy((JSONObject)psDEDRBarItemImpl.getViewParamJO(), (JSONObject)parentModeJO);
                JSONObjectHelper.put((JSONObject)parentModeJO, (String)"srfparentdeid", (Object)this.getPSDataEntity().getId());
                drBarItem.setDRViewId(strViewId);
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)iPSDEDRDetail.getPSDETreeId())) {
                PSDEViewCtrl psDEViewCtrl = new PSDEViewCtrl();
                psDEViewCtrl.setPSDEVIEWCTRLNAME(SA.SRFramework.Utility.StringHelper.Format((String)"%1$s_%2$s_tree", (Object)this.getName(), (Object)iPSDEDRDetail.getName()));
                psDEViewCtrl.setPSDETREEVIEWID(iPSDEDRDetail.getPSDETreeId());
                psDEViewCtrl.setVALIDFLAG(true);
                psDEViewCtrl.setPSDEVIEWCTRLTYPE("TREEVIEW");
                IPSControlType iPSControlType = this.getPSModelStorage().getPSControlType(psDEViewCtrl.getPSDEVIEWCTRLTYPE());
                IPSControlParam iPSControlParam = iPSControlType.createPSControlParam(psDEViewCtrl);
                iPSControlParam.init(this.getDAGlobalHelper(), this.getPSAppView(), psDEViewCtrl);
                IPSDETree iPSDETree = (IPSDETree)this.registerPSControl(psDEViewCtrl.getPSDEVIEWCTRLNAME().toLowerCase(), psDEViewCtrl.getPSDEVIEWCTRLTYPE(), iPSControlParam);
                drBarItem.setDataTreeId(psDEViewCtrl.getPSDEVIEWCTRLNAME().toLowerCase());
                Iterator<IPSDETreeNode> psDETreeNodes = iPSDETree.getPSDETreeNodes();
                if (psDETreeNodes != null) {
                    while (psDETreeNodes.hasNext()) {
                        IPSDETreeNode iPSDETreeNode = psDETreeNodes.next();
                        if (iPSDETreeNode.getNavPSAppView() == null) continue;
                        String strViewId = SA.SRFramework.Utility.StringHelper.Format((String)"%1$s_%2$s", (Object)iPSDETree.getName(), (Object)iPSDETreeNode.getNodeType());
                        String strViewRefMode = SA.SRFramework.Utility.StringHelper.Format((String)"%1$s:%2$s", (Object)"DRITEM", (Object)strViewId);
                        PSAppViewRef psAppViewRef = new PSAppViewRef();
                        psAppViewRef.setPSAPPVIEWREFNAME(strViewRefMode);
                        psAppViewRef.setMINORPSAPPVIEWID(iPSDETreeNode.getNavPSAppView().getId());
                        psAppViewRef.setParamValue("EMBEDVIEWID", strViewId);
                        IPSAppViewRef iPSAppViewRef = null;
                        iPSAppViewRef = bRegisterPSAppViewRefToContainer ? this.getPSControlContainer().registerPSAppViewRef(psAppViewRef) : this.registerPSAppViewRef(psAppViewRef);
                        if (iPSDETreeNode.getNavPSDER() == null) continue;
                        JSONObject parentModeJO = iPSAppViewRef.getParentModeJO(true);
                        iPSDETreeNode.getNavPSDER().fillViewParentModeJO(parentModeJO);
                    }
                }
            }
            if (psDEDRBarItemImpl.getPSDEDRItem() != null && (drViewParamJO = psDEDRBarItemImpl.getPSDEDRItem().getViewParamJO()) != null && (it = drViewParamJO.keys()) != null) {
                while (it.hasNext()) {
                    String strKey = (String)it.next();
                    String strValue = drViewParamJO.optString(strKey);
                    if (strValue == null) continue;
                    drBarItem.setViewParam(strKey, strValue);
                }
            }
            if (iPSDEDRDetail.getPSSysImage() != null) {
                drBarItem.setIconCls(iPSDEDRDetail.getPSSysImage().getCssClass());
                drBarItem.setIconPath(iPSDEDRDetail.getPSSysImage().getImagePath());
                drBarItem.setIconClsX(iPSDEDRDetail.getPSSysImage().getCssClassX());
                drBarItem.setIconPathX(iPSDEDRDetail.getPSSysImage().getImagePathX());
            }
            if (!psDEDRBarGroupImpl.isHidden()) {
                groupDRBarItem.getItems().add(drBarItem);
                continue;
            }
            if (formDRBarItem != null) {
                formDRBarItem.getItems().add(drBarItem);
                continue;
            }
            this.drCtrlRootItem.getItems().add(drBarItem);
        }
        this.psDEDRCtrlItemList.addAll(this.psDEDRBarItemList);
    }

    @Override
    protected String onGetControlType() {
        return "DRBAR";
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u6570\u636e\u5173\u7cfb\u680f\u5206\u7ec4\u96c6\u5408", child=true)
    public Iterator<IPSDEDRBarGroup> getPSDEDRBarGroups() {
        return this.psDEDRBarGroupList.iterator();
    }

    @Override
    public IPSAjaxControlParam getPSAjaxControlParam() {
        return this.iPSDEDRBarParam;
    }

    @Override
    @PSModelRTMeta(description="\u62ac\u5934", model="PSDEViewCtrl", fields={"CAPTION"})
    public String getTitle() {
        return this.iPSDEDRBarParam.getTitle();
    }

    @Override
    @PSModelRTMeta(description="\u663e\u793a\u6807\u9898", model="PSDEViewCtrl", fields={"CTRLPARAM11"})
    public boolean isShowTitle() {
        Boolean bShowTitle = this.iPSDEDRBarParam.isShowTitle();
        if (bShowTitle == null) {
            return true;
        }
        return bShowTitle;
    }

    @Override
    @PSModelRTMeta(description="\u62ac\u5934\u8bed\u8a00\u8d44\u6e90", model="PSDEViewCtrl", fields={"CAPPSLANRESID"})
    public IPSLanguageRes getTitlePSLanguageRes() {
        return this.titlePSLanguageRes;
    }

    @Override
    public String getModelType() {
        return "PSDEDRBAR";
    }
}

