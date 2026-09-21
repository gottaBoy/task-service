/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.JsonNode
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.model.IPSModelJsonExporter2
 *  net.ibizsys.model.app.view.IPSAppView
 *  net.ibizsys.model.control.toolbar.IPSDECMUIActionItem
 *  net.ibizsys.model.control.toolbar.IPSDEContextMenuItem
 *  net.ibizsys.model.control.toolbar.IPSDETBUIActionItem
 *  net.ibizsys.model.control.toolbar.IPSDEToolbar
 *  net.ibizsys.model.control.toolbar.IPSDEToolbarItem
 *  net.ibizsys.model.dataentity.uiaction.IPSDEUIAction
 *  net.ibizsys.model.res.IPSSysImage
 *  net.ibizsys.model.view.IPSUIAction
 *  net.ibizsys.model.view.IPSUIActionGroupDetail
 *  net.ibizsys.model.wf.uiaction.IPSWFUIAction
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.service.ActionSessionManager
 *  net.ibizsys.paas.util.JsonNodeHelper
 *  net.ibizsys.paas.util.PropertiesHelper
 *  net.ibizsys.paas.util.StringHelper
 */
package net.ibizsys.model.control.toolbar;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Properties;
import net.ibizsys.model.IPSModelJsonExporter2;
import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.IPSSystemRuntime;
import net.ibizsys.model.PSModelRTMeta;
import net.ibizsys.model.app.view.IPSAppView;
import net.ibizsys.model.app.view.IPSAppViewRuntime;
import net.ibizsys.model.control.toolbar.IPSDECMUIActionItem;
import net.ibizsys.model.control.toolbar.IPSDEContextMenuItem;
import net.ibizsys.model.control.toolbar.IPSDETBUIActionItem;
import net.ibizsys.model.control.toolbar.IPSDEToolbar;
import net.ibizsys.model.control.toolbar.IPSDEToolbarItem;
import net.ibizsys.model.control.toolbar.PSDETBGroupItemImpl;
import net.ibizsys.model.control.toolbar.PSDEToolbarItemImpl;
import net.ibizsys.model.dataentity.uiaction.IPSDEUIAction;
import net.ibizsys.model.dataentity.uiaction.IPSDEUIActionRuntime;
import net.ibizsys.model.entity.PSDEToolbarItem;
import net.ibizsys.model.res.IPSSysImage;
import net.ibizsys.model.view.IPSUIAction;
import net.ibizsys.model.view.IPSUIActionGroupDetail;
import net.ibizsys.model.wf.uiaction.IPSWFUIAction;
import net.ibizsys.model.wf.uiaction.IPSWFUIActionRuntime;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.service.ActionSessionManager;
import net.ibizsys.paas.util.JsonNodeHelper;
import net.ibizsys.paas.util.PropertiesHelper;
import net.ibizsys.paas.util.StringHelper;

public class PSDETBUIActionItemImpl
extends PSDEToolbarItemImpl
implements IPSDETBUIActionItem,
IPSDECMUIActionItem {
    private static final ArrayList<IPSDEContextMenuItem> emptyPSDEContextMenuItemList = new ArrayList();
    private IPSAppView frontPSAppView = null;
    private IPSUIAction iPSUIAction = null;
    private ObjectNode uiActionParamJO = null;
    private ArrayList<IPSDEContextMenuItem> psDEContextMenuItemList = null;
    private boolean bHiddenItem = false;
    private int nNoPrivDisplayMode = 2;
    private String strGroupExtractMode = "ITEM";
    private boolean bGroupItem = false;

    public void init(IPSModelStorageContext iPSModelStorageContext, IPSDEToolbar iPSDEToolbar, IPSDEToolbarItem parentPSDEToolbarItem, PSDEToolbarItem psDEToolbarItem, IPSUIAction iPSUIAction) throws Exception {
        this.iPSUIAction = iPSUIAction;
        String strUIActionParam = psDEToolbarItem.getUIACTIONPARAMS().trim();
        if (!StringHelper.isNullOrEmpty((String)strUIActionParam)) {
            if (strUIActionParam.charAt(0) == '{') {
                this.uiActionParamJO = (ObjectNode)JsonNodeHelper.fromString((String)strUIActionParam);
            } else {
                this.uiActionParamJO = JsonNodeHelper.createObjectNode();
                Properties properties = PropertiesHelper.load((String)strUIActionParam);
                Enumeration<Object> keys = properties.keys();
                while (keys.hasMoreElements()) {
                    String strKey = keys.nextElement().toString();
                    String strValue = PropertiesHelper.getProperty((Properties)properties, (String)strKey);
                    this.uiActionParamJO.put(strKey, strValue);
                }
            }
        }
        if (this.iPSUIAction != null && this.iPSUIAction.getUIActionParamJO() != null) {
            ObjectNode uiActionParamJO2;
            Iterator fieldNames;
            if (this.uiActionParamJO == null) {
                this.uiActionParamJO = JsonNodeHelper.createObjectNode();
            }
            if ((fieldNames = (uiActionParamJO2 = this.iPSUIAction.getUIActionParamJO()).fieldNames()) != null) {
                while (fieldNames.hasNext()) {
                    String strFieldName = (String)fieldNames.next();
                    if (this.uiActionParamJO.has(strFieldName)) continue;
                    this.uiActionParamJO.put(strFieldName, uiActionParamJO2.get(strFieldName));
                }
            }
        }
        if (!psDEToolbarItem.isHIDDENITEMNull()) {
            this.bHiddenItem = this.psDEToolbarItem.getHIDDENITEM();
        }
        super.init(iPSModelStorageContext, iPSDEToolbar, parentPSDEToolbarItem, psDEToolbarItem);
    }

    @Override
    protected void onInit() throws Exception {
        if (this.iPSUIAction == null) {
            this.iPSUIAction = this.getPSDEToolbar().getPSDataEntity().getPSDEUIAction(this.getPSDEToolbarItemData().getPSDEUIACTIONID());
        }
        this.nNoPrivDisplayMode = this.psDEToolbarItem.isNOPRIVDMNull() ? (this.iPSUIAction != null ? this.iPSUIAction.getNoPrivDisplayMode(this.getPSDEToolbar().getPSAppView()) : this.getPSDEToolbar().getPSAppView().getButtonNoPrivDisplayMode()) : this.psDEToolbarItem.getNOPRIVDM();
        if (!StringHelper.isNullOrEmpty((String)this.psDEToolbarItem.getGROUPEXTRACTMODE())) {
            this.strGroupExtractMode = this.psDEToolbarItem.getGROUPEXTRACTMODE();
        }
        super.onInit();
    }

    /*
     * Unable to fully structure code
     */
    @Override
    protected void onPreparePSDEToolbarItems() throws Exception {
        psDEToolbarItemList = this.getPSDEToolbarItemList(false);
        if (psDEToolbarItemList != null) {
            psDEToolbarItemList.clear();
        }
        if (this.psDEContextMenuItemList != null) {
            this.psDEContextMenuItemList.clear();
        }
        nViewUARegMode = 0;
        iPSSysEngineConfig = ((IPSSystemRuntime)this.getPSDEToolbar().getPSAppView().getPSSystem()).getPSSysEngineConfig();
        if (iPSSysEngineConfig != null) {
            nViewUARegMode = iPSSysEngineConfig.getViewUARegMode();
        }
        if (nViewUARegMode == 0) {
            if (!this.iPSUIAction.isUIActionGroup((Object)this)) {
                ((IPSAppViewRuntime)this.getPSAppView()).registerPSUIAction(this.iPSUIAction, this.uiActionParamJO);
                return;
            }
            if (!this.iPSUIAction.isValid((Object)this)) {
                return;
            }
        } else if (nViewUARegMode == 1) {
            if (!this.iPSUIAction.isValid((Object)this)) {
                return;
            }
            if (!this.iPSUIAction.isUIActionGroup((Object)this)) {
                ((IPSAppViewRuntime)this.getPSAppView()).registerPSUIAction(this.iPSUIAction, this.uiActionParamJO);
                return;
            }
        }
        this.bGroupItem = true;
        iPSUIActionGroup = this.iPSUIAction.getPSUIActionGroup((Object)this);
        if (iPSUIActionGroup == null) {
            return;
        }
        psUIActionGroupDetails = iPSUIActionGroup.getPSUIActionGroupDetails();
        if (psUIActionGroupDetails == null) {
            return;
        }
        if (this.psDEContextMenuItemList == null) {
            this.psDEContextMenuItemList = new ArrayList<E>();
        }
        if (psDEToolbarItemList == null) {
            psDEToolbarItemList = this.getPSDEToolbarItemList(true);
        }
        psDETBGroupItemImpl = null;
        if (StringHelper.compare((String)this.getGroupExtractMode(), (String)"ITEMS", (boolean)true) == 0) {
            psDEToolbarItem = new PSDEToolbarItem();
            this.psDEToolbarItem.copyTo((IDataObject)psDEToolbarItem, false);
            psDEToolbarItem.setTBITEMTYPE("ITEMS");
            psDEToolbarItem.setPSDEUIACTIONID(null);
            psDEToolbarItem.setPSDEUIACTIONNAME(null);
            psDEToolbarItem.setSHOWMODE(this.getPSDEToolbarItemData().getSHOWMODE());
            psDETBGroupItemImpl = new PSDETBGroupItemImpl();
            psDETBGroupItemImpl.init(this.getPSModelStorageContext(), this.getPSDEToolbar(), this.getParentPSDEToolbarItem(), psDEToolbarItem);
            psDEToolbarItemList.add(psDETBGroupItemImpl);
        }
        bClose = false;
        try {
            block22: {
                strRecursionId = String.valueOf(this.getPSAppView().getId()) + "||" + this.getPSDEToolbar().getId() + "||" + this.iPSUIAction.getId();
                actionSession = ActionSessionManager.getCurrentSession();
                if (actionSession != null) break block22;
                bClose = true;
                actionSession = ActionSessionManager.openSession((String)"PSDETBUIActionItemImpl");
                actionSession.registerRecursion("PSUIAction", (Object)strRecursionId);
                ** GOTO lbl81
            }
            if (actionSession.registerRecursion("PSUIAction", (Object)strRecursionId)) ** GOTO lbl81
            throw new Exception(StringHelper.format((String)"\u754c\u9762\u884c\u4e3a[%1$s]\u5b58\u5728\u9012\u5f52\u5173\u7cfb", (Object)this.iPSUIAction.getName()));
lbl-1000:
            // 1 sources

            {
                iPSUIActionGroupDetail = (IPSUIActionGroupDetail)psUIActionGroupDetails.next();
                iPSUIAction = iPSUIActionGroupDetail.getPSUIAction();
                if (iPSUIAction == null) continue;
                psDEToolbarItem = new PSDEToolbarItem();
                psDEToolbarItem.setTBITEMTYPE("DEUIACTION");
                psDEToolbarItem.setPSDETBITEMID(iPSUIAction.getId());
                strTBItemName = "";
                strTBItemName = StringHelper.isNullOrEmpty((String)iPSUIAction.getCodeName()) != false ? StringHelper.format((String)"stb%1$s", (Object)iPSUIAction.getId().substring(0, 6)) : StringHelper.format((String)"stb%1$s", (Object)iPSUIAction.getCodeName());
                strTBItemName = strTBItemName.toLowerCase();
                psDEToolbarItem.setPSDETBITEMNAME(strTBItemName);
                psDEToolbarItem.setPSDEUIACTIONID(iPSUIAction.getId());
                psDEToolbarItem.setPSDEUIACTIONNAME(iPSUIAction.getName());
                psDEToolbarItem.setSHOWMODE(this.getPSDEToolbarItemData().getSHOWMODE());
                psDEToolbarItem.setUIACTIONPARAMS(iPSUIActionGroupDetail.getUIActionParam());
                iPSUIAction.fillUIActionItem((Object)psDEToolbarItem);
                psDETBUIActionItemImpl = new PSDETBUIActionItemImpl();
                psDETBUIActionItemImpl.init(this.getPSModelStorageContext(), this.getPSDEToolbar(), this.getParentPSDEToolbarItem(), psDEToolbarItem, iPSUIAction);
                if (psDETBGroupItemImpl != null) {
                    psDETBGroupItemImpl.addPSDEToolbarItem(psDETBUIActionItemImpl);
                    continue;
                }
                psDEToolbarItemList.add(psDETBUIActionItemImpl);
lbl81:
                // 5 sources

                ** while (psUIActionGroupDetails.hasNext())
            }
lbl82:
            // 2 sources

            for (IPSDEToolbarItem iPSDEToolbarItem : psDEToolbarItemList) {
                this.psDEContextMenuItemList.add((IPSDEContextMenuItem)iPSDEToolbarItem);
            }
            if (bClose) {
                ActionSessionManager.closeSession();
            }
        }
        catch (Exception ex) {
            if (bClose) {
                ActionSessionManager.closeSession();
            }
            throw ex;
        }
    }

    @PSModelRTMeta(description="\u5b50\u9879\u96c6\u5408", modeltype="SA.SRFDA.PS.Core.Control.Toolbar.IPSDEToolbarItem", hideempty2=true)
    public Iterator<IPSDEToolbarItem> getPSDEToolbarItems() throws Exception {
        ArrayList<IPSDEToolbarItem> psDEToolbarItemList = this.getPSDEToolbarItemList(false);
        if (psDEToolbarItemList != null) {
            return psDEToolbarItemList.iterator();
        }
        return emptyPSDEToolbarItemList.iterator();
    }

    public IPSDEUIAction getPSDEUIAction() {
        if (this.getPSUIAction() instanceof IPSDEUIAction) {
            return (IPSDEUIAction)this.getPSUIAction();
        }
        return null;
    }

    public IPSWFUIAction getPSWFUIAction() {
        if (this.getPSUIAction() instanceof IPSWFUIAction) {
            return (IPSWFUIAction)this.getPSUIAction();
        }
        return null;
    }

    public IPSAppView getPSAppView() {
        return this.getPSDEToolbar().getPSAppView();
    }

    @PSModelRTMeta(description="\u754c\u9762\u884c\u4e3a\u5bf9\u8c61")
    public IPSUIAction getPSUIAction() {
        return this.iPSUIAction;
    }

    @Override
    protected String onGetCaption() {
        return this.iPSUIAction.getCaption(this.getPSAppView().getLanguage());
    }

    @Override
    protected void onFillRelatedPSAppViews(ArrayList<IPSAppView> relatedAppViewList) throws Exception {
        super.onFillRelatedPSAppViews(relatedAppViewList);
        if (this.getFrontPSAppView() != null) {
            relatedAppViewList.add(this.getFrontPSAppView());
        }
    }

    @Override
    @PSModelRTMeta(description="\u662f\u5426\u542f\u7528")
    public boolean isValid() throws Exception {
        if (this.iPSUIAction.isUIActionGroup((Object)this)) {
            ArrayList<IPSDEToolbarItem> psDEToolbarItemList = this.getPSDEToolbarItemList(false);
            return psDEToolbarItemList != null && psDEToolbarItemList.size() > 0;
        }
        if (this.getPSDEUIAction() != null) {
            return this.getPSDEUIAction().isValid((Object)this);
        }
        if (this.getPSWFUIAction() != null) {
            return this.getPSWFUIAction().isValid((Object)this);
        }
        return true;
    }

    @Override
    @PSModelRTMeta(description="\u56fe\u6807\u8d44\u6e90\u5bf9\u8c61")
    public IPSSysImage getPSSysImage() {
        if (super.getPSSysImage() == null) {
            return this.iPSUIAction.getPSSysImage();
        }
        return super.getPSSysImage();
    }

    @Override
    @PSModelRTMeta(description="\u5de5\u5177\u63d0\u793a")
    public String getTooltip() {
        String strTooltipInfo = this.psDEToolbarItem.getTOOLTIPINFO();
        if (!StringHelper.isNullOrEmpty((String)strTooltipInfo)) {
            return strTooltipInfo;
        }
        strTooltipInfo = this.iPSUIAction.getTooltip(this.getPSAppView().getLanguage());
        if (StringHelper.isNullOrEmpty((String)strTooltipInfo)) {
            return this.getCaption();
        }
        return strTooltipInfo;
    }

    @PSModelRTMeta(description="\u542f\u7528\u70b9\u51fb\u5207\u6362\u6a21\u5f0f")
    public boolean isEnableToggleMode() {
        if (this.iPSUIAction != null) {
            return this.iPSUIAction.isEnableToggleMode();
        }
        return false;
    }

    @PSModelRTMeta(description="\u754c\u9762\u884c\u4e3a\u53c2\u6570")
    public ObjectNode getUIActionParamJO() {
        return this.uiActionParamJO;
    }

    public Iterator<IPSDEContextMenuItem> getPSDEContextMenuItems() throws Exception {
        if (this.psDEContextMenuItemList != null) {
            return this.psDEContextMenuItemList.iterator();
        }
        return emptyPSDEContextMenuItemList.iterator();
    }

    @PSModelRTMeta(description="\u662f\u5426\u9690\u85cf")
    public boolean isHiddenItem() {
        return this.bHiddenItem;
    }

    @PSModelRTMeta(description="\u65e0\u6743\u9650\u663e\u793a\u6a21\u5f0f", codelist="BtnNoPrivDisplayMode")
    public int getNoPrivDisplayMode() {
        return this.nNoPrivDisplayMode;
    }

    @PSModelRTMeta(description="\u754c\u9762\u884c\u4e3a\u7ec4\u5c55\u5f00\u6a21\u5f0f", codelist="UGExtractMode")
    public String getGroupExtractMode() {
        return this.strGroupExtractMode;
    }

    protected boolean isGroupItem() {
        return this.bGroupItem;
    }

    @Override
    public ArrayList<ObjectNode> toJsonObjects(ArrayList<ObjectNode> objectNodeList) throws Exception {
        if (this.isGroupItem()) {
            ArrayList<IPSDEToolbarItem> psDEToolbarItemList = this.getPSDEToolbarItemList(false);
            if (psDEToolbarItemList != null && psDEToolbarItemList.size() > 0) {
                if (objectNodeList == null) {
                    objectNodeList = new ArrayList();
                }
                for (IPSDEToolbarItem iPSDEToolbarItem : psDEToolbarItemList) {
                    ((IPSModelJsonExporter2)iPSDEToolbarItem).toJsonObjects(objectNodeList);
                }
            }
            return objectNodeList;
        }
        return super.toJsonObjects(objectNodeList);
    }

    @Override
    protected void onFillJsonObject(ObjectNode objectNode) throws Exception {
        super.onFillJsonObject(objectNode);
        if (this.getPSUIAction() != null) {
            if (!StringHelper.isNullOrEmpty((String)this.getPSUIAction().getDataAccessAction())) {
                objectNode.put("dataaccaction", this.getPSUIAction().getDataAccessAction());
            } else {
                objectNode.put("dataaccaction", "");
            }
            ObjectNode uiNode = JsonNodeHelper.createObjectNode();
            uiNode.put("tag", this.getPSUIAction().getUIActionTag());
            uiNode.put("target", this.getPSUIAction().getActionTarget());
            if (this.getPSUIAction().getUIActionParamJO() != null) {
                uiNode.put("param", (JsonNode)this.getPSUIAction().getUIActionParamJO());
            }
            JsonNodeHelper.put((ObjectNode)objectNode, (String)"uiaction", (Object)uiNode);
        }
    }

    @PSModelRTMeta(description="\u524d\u7aef\u6253\u5f00\u89c6\u56fe", hideempty=true)
    public IPSAppView getFrontPSAppView() throws Exception {
        if (this.frontPSAppView != null) {
            return this.frontPSAppView;
        }
        if (this.getPSDEUIAction() != null) {
            this.frontPSAppView = ((IPSDEUIActionRuntime)this.getPSDEUIAction()).getFrontPSAppView(this);
            if (this.frontPSAppView != null) {
                return this.frontPSAppView;
            }
        }
        if (this.getPSWFUIAction() != null) {
            this.frontPSAppView = ((IPSWFUIActionRuntime)this.getPSWFUIAction()).getFrontPSAppView(this);
            if (this.frontPSAppView != null) {
                return this.frontPSAppView;
            }
        }
        return null;
    }
}

