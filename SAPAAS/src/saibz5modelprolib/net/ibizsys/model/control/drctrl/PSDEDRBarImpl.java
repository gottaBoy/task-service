/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.model.app.view.IPSAppViewRef
 *  net.ibizsys.model.control.IPSAjaxControlParam
 *  net.ibizsys.model.control.IPSControlContainer
 *  net.ibizsys.model.control.IPSControlParam
 *  net.ibizsys.model.control.drctrl.IPSDEDRBar
 *  net.ibizsys.model.control.drctrl.IPSDEDRBarGroup
 *  net.ibizsys.model.control.drctrl.IPSDEDRBarItem
 *  net.ibizsys.model.control.drctrl.IPSDEDRBarParam
 *  net.ibizsys.model.dataentity.dr.IPSDEDRDetail
 *  net.ibizsys.model.dataentity.dr.IPSDEDRGroup
 *  net.ibizsys.model.res.IPSLanguageRes
 *  net.ibizsys.paas.control.drctrl.DRCtrlItem
 *  net.ibizsys.paas.util.JsonNodeHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.control.drctrl;

import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.PSModelRTMeta;
import net.ibizsys.model.PSModels;
import net.ibizsys.model.app.view.IPSAppViewRef;
import net.ibizsys.model.app.view.IPSAppViewRuntime;
import net.ibizsys.model.control.IPSAjaxControlParam;
import net.ibizsys.model.control.IPSControlContainer;
import net.ibizsys.model.control.IPSControlParam;
import net.ibizsys.model.control.drctrl.IPSDEDRBar;
import net.ibizsys.model.control.drctrl.IPSDEDRBarGroup;
import net.ibizsys.model.control.drctrl.IPSDEDRBarItem;
import net.ibizsys.model.control.drctrl.IPSDEDRBarParam;
import net.ibizsys.model.control.drctrl.PSDEDRBarGroupImpl;
import net.ibizsys.model.control.drctrl.PSDEDRBarItemImpl;
import net.ibizsys.model.control.drctrl.PSDEDRCtrlImpl;
import net.ibizsys.model.dataentity.dr.IPSDEDRDetail;
import net.ibizsys.model.dataentity.dr.IPSDEDRGroup;
import net.ibizsys.model.entity.PSAppViewRef;
import net.ibizsys.model.res.IPSLanguageRes;
import net.ibizsys.paas.control.drctrl.DRCtrlItem;
import net.ibizsys.paas.util.JsonNodeHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEDRBarImpl
extends PSDEDRCtrlImpl
implements IPSDEDRBar {
    private static final Log log = LogFactory.getLog(PSDEDRBarImpl.class);
    protected ArrayList<IPSDEDRBarGroup> psDEDRBarGroupList = new ArrayList();
    protected IPSDEDRBarParam iPSDEDRBarParam = null;
    protected ArrayList<IPSDEDRBarItem> psDEDRBarItemList = new ArrayList();
    private IPSLanguageRes titlePSLanguageRes = null;

    @Override
    public void init(IPSModelStorageContext iPSModelStorageContext, IPSControlContainer iPSControlContainer, String strName, IPSControlParam iPSControlParam) throws Exception {
        try {
            this.iPSDEDRBarParam = (IPSDEDRBarParam)iPSControlParam;
            super.init(iPSModelStorageContext, iPSControlContainer, strName, iPSControlParam);
        }
        catch (Exception ex) {
            String strLogName = StringHelper.format((String)"%1$s[%2$s]", (Object)PSModels.getModelName(this.getModelType()), (Object)this.getFullModelName());
            String strExInfo = StringHelper.format((String)"\u521d\u59cb\u5316\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage());
            log.error((Object)StringHelper.format((String)"%1$s%2$s", (Object)strLogName, (Object)strExInfo), (Throwable)ex);
            throw ex;
        }
    }

    @Override
    protected void onInit() throws Exception {
        if (!StringHelper.isNullOrEmpty((String)this.iPSDEDRBarParam.getTitlePSLanguageResId())) {
            this.titlePSLanguageRes = this.getPSSystem().getPSLanguageRes(this.iPSDEDRBarParam.getTitlePSLanguageResId());
        }
        super.onInit();
    }

    @Override
    protected void fillDRCtrlItems() throws Exception {
        this.drCtrlRootItem.reset();
        this.psDEDRBarGroupList.clear();
        this.psDEDRCtrlItemList.clear();
        this.psDEDRBarItemList.clear();
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
        Iterator psDEDRDetails = this.iPSDEDataRelation.getPSDEDRDetails();
        while (psDEDRDetails.hasNext()) {
            Iterator it;
            ObjectNode drViewParamJO;
            IPSDEDRDetail iPSDEDRDetail = (IPSDEDRDetail)psDEDRDetails.next();
            String strPSDEDRGroupId = iPSDEDRDetail.getPSDEDRGroupId();
            PSDEDRBarGroupImpl psDEDRBarGroupImpl = (PSDEDRBarGroupImpl)psDEDRBarGroupMap.get(strPSDEDRGroupId);
            DRCtrlItem groupDRBarItem = (DRCtrlItem)psDEDRBarGroupItemMap.get(strPSDEDRGroupId);
            if (psDEDRBarGroupImpl == null) {
                IPSDEDRGroup iPSDEDRGroup = this.iPSDEDataRelation.getPSDataEntity().getPSDEDRGroup(strPSDEDRGroupId);
                psDEDRBarGroupImpl = new PSDEDRBarGroupImpl();
                psDEDRBarGroupImpl.init(this.getPSModelStorageContext(), this, iPSDEDRGroup);
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
            psDEDRBarItemImpl.init(this.getPSModelStorageContext(), this, psDEDRBarGroupImpl, iPSDEDRDetail);
            psDEDRBarGroupImpl.addPSDEDRBarItem(psDEDRBarItemImpl);
            this.psDEDRBarItemList.add(psDEDRBarItemImpl);
            DRCtrlItem drBarItem = new DRCtrlItem();
            drBarItem.setId(psDEDRBarItemImpl.getName());
            drBarItem.setText(psDEDRBarItemImpl.getCaption());
            drBarItem.setViewParam("srfparentdeid", this.getPSDataEntity().getId());
            if (psDEDRBarItemImpl.getCapPSLanguageRes() != null) {
                drBarItem.setTextLanResTag(psDEDRBarItemImpl.getCapPSLanguageRes().getLanResTag());
            }
            if (!StringHelper.isNullOrEmpty((String)iPSDEDRDetail.getCounterId())) {
                drBarItem.setCounterId(iPSDEDRDetail.getCounterId());
            }
            if (!StringHelper.isNullOrEmpty((String)iPSDEDRDetail.getEnableMode())) {
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
                String strViewRefMode = StringHelper.format((String)"%1$s:%2$s", (Object)"DRITEM", (Object)strViewId);
                PSAppViewRef psAppViewRef = new PSAppViewRef();
                psAppViewRef.setPSAPPVIEWREFNAME(strViewRefMode);
                psAppViewRef.setMINORPSAPPVIEWID(psDEDRBarItemImpl.getPSAppView().getId());
                psAppViewRef.setParamValue("EMBEDVIEWID", psDEDRBarItemImpl.getEmbedViewId());
                IPSAppViewRef iPSAppViewRef = ((IPSAppViewRuntime)this.getPSAppView()).registerPSAppViewRef(psAppViewRef);
                ObjectNode parentModeJO = iPSAppViewRef.getParentModeJO(true);
                JsonNodeHelper.copy((ObjectNode)psDEDRBarItemImpl.getViewParamJO(), (ObjectNode)parentModeJO, (boolean)false);
                JsonNodeHelper.put((ObjectNode)parentModeJO, (String)"srfparentdeid", (Object)this.getPSDataEntity().getId());
                drBarItem.setDRViewId(strViewId);
            }
            if (psDEDRBarItemImpl.getPSDEDRItem() != null && (drViewParamJO = psDEDRBarItemImpl.getPSDEDRItem().getViewParamJO()) != null && (it = drViewParamJO.fieldNames()) != null) {
                while (it.hasNext()) {
                    String strKey = (String)it.next();
                    String strValue = JsonNodeHelper.getString((ObjectNode)drViewParamJO, (String)strKey, null);
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

    public String getControlType() {
        return "DRBAR";
    }

    @PSModelRTMeta(description="\u5b9e\u4f53\u6570\u636e\u5173\u7cfb\u680f\u5206\u7ec4\u96c6\u5408")
    public Iterator<IPSDEDRBarGroup> getPSDEDRBarGroups() {
        return this.psDEDRBarGroupList.iterator();
    }

    @Override
    public IPSAjaxControlParam getPSAjaxControlParam() {
        return this.iPSDEDRBarParam;
    }

    @PSModelRTMeta(description="\u62ac\u5934")
    public String getTitle() {
        return this.iPSDEDRBarParam.getTitle();
    }

    @PSModelRTMeta(description="\u663e\u793a\u6807\u9898")
    public boolean isShowTitle() {
        Boolean bShowTitle = this.iPSDEDRBarParam.isShowTitle();
        if (bShowTitle == null) {
            return true;
        }
        return bShowTitle;
    }

    @PSModelRTMeta(description="\u62ac\u5934\u8bed\u8a00\u8d44\u6e90")
    public IPSLanguageRes getTitlePSLanguageRes() {
        return this.titlePSLanguageRes;
    }
}

