/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.model.app.view.IPSAppView
 *  net.ibizsys.model.control.IPSControl
 *  net.ibizsys.model.control.toolbar.IPSDEContextMenu
 *  net.ibizsys.model.control.toolbar.IPSDEContextMenuItem
 *  net.ibizsys.model.control.toolbar.IPSDETBSeperatorItem
 *  net.ibizsys.model.control.toolbar.IPSDEToolbar
 *  net.ibizsys.model.control.toolbar.IPSDEToolbarItem
 *  net.ibizsys.model.res.IPSLanguageRes
 *  net.ibizsys.model.res.IPSSysCss
 *  net.ibizsys.model.res.IPSSysImage
 *  net.ibizsys.paas.util.JsonNodeHelper
 *  net.ibizsys.paas.util.StringHelper
 */
package net.ibizsys.model.control.toolbar;

import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.ArrayList;
import net.ibizsys.model.IPSModelObjectRuntime;
import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.IPSSystemRuntime;
import net.ibizsys.model.PSModelRTMeta;
import net.ibizsys.model.PSObjectImpl;
import net.ibizsys.model.app.view.IPSAppView;
import net.ibizsys.model.app.view.IPSAppViewRuntime;
import net.ibizsys.model.control.IPSControl;
import net.ibizsys.model.control.IPSControlObject;
import net.ibizsys.model.control.toolbar.IPSDEContextMenu;
import net.ibizsys.model.control.toolbar.IPSDEContextMenuItem;
import net.ibizsys.model.control.toolbar.IPSDETBSeperatorItem;
import net.ibizsys.model.control.toolbar.IPSDEToolbar;
import net.ibizsys.model.control.toolbar.IPSDEToolbarItem;
import net.ibizsys.model.control.toolbar.IPSDEToolbarItemRuntime;
import net.ibizsys.model.entity.PSDEToolbarItem;
import net.ibizsys.model.res.IPSLanguageRes;
import net.ibizsys.model.res.IPSSysCss;
import net.ibizsys.model.res.IPSSysImage;
import net.ibizsys.model.res.IPSSysPFPlugin;
import net.ibizsys.paas.util.JsonNodeHelper;
import net.ibizsys.paas.util.StringHelper;

public class PSDEToolbarItemImpl
extends PSObjectImpl
implements IPSDEToolbarItem,
IPSDEContextMenuItem,
IPSDEToolbarItemRuntime,
IPSControlObject {
    protected static final ArrayList<IPSDEToolbarItem> emptyPSDEToolbarItemList = new ArrayList();
    private IPSDEToolbar iPSDEToolbar = null;
    private IPSDEToolbarItem parentPSDEToolbarItem = null;
    protected PSDEToolbarItem psDEToolbarItem = null;
    private ArrayList<IPSDEToolbarItem> psDEToolbarItemList = null;
    private String strCaption = "";
    private boolean bShowCaption = true;
    private boolean bShowIcon = true;
    private IPSSysImage iPSSysImage = null;
    private IPSSysCss iPSSysCss = null;
    private IPSDEContextMenu iPSDEContextMenu = null;
    private IPSDEContextMenuItem parentPSDEContextMenuItem = null;
    private IPSSysPFPlugin iPSSysPFPlugin = null;
    private IPSLanguageRes capPSLanguageRes = null;
    private IPSLanguageRes tooltipPSLanguageRes = null;
    private double fWidth = 0.0;
    private double fHeight = 0.0;

    @Override
    public void init(IPSModelStorageContext iPSModelStorageContext, IPSDEToolbar iPSDEToolbar, IPSDEToolbarItem parentPSDEToolbarItem, PSDEToolbarItem psDEToolbarItem) throws Exception {
        this.setPSModelStorageContext(iPSModelStorageContext);
        this.setPSDEToolbar(iPSDEToolbar);
        this.setParentPSDEToolbarItem(parentPSDEToolbarItem);
        this.setPSDEToolbarItemData(psDEToolbarItem);
        this.setId(this.psDEToolbarItem.getPSDETBITEMID());
        this.setName(this.psDEToolbarItem.getPSDETBITEMNAME());
        this.strCaption = psDEToolbarItem.getCAPTION();
        if (!this.psDEToolbarItem.isWIDTHNull()) {
            this.fWidth = this.psDEToolbarItem.getWIDTH();
        }
        if (StringHelper.compare((String)this.psDEToolbarItem.getSHOWMODE(), (String)"ICONANDSHORTWORD", (boolean)true) == 0) {
            this.bShowCaption = true;
            this.bShowIcon = true;
        } else if (StringHelper.compare((String)this.psDEToolbarItem.getSHOWMODE(), (String)"ICON", (boolean)true) == 0) {
            this.bShowCaption = false;
            this.bShowIcon = true;
        } else if (StringHelper.compare((String)this.psDEToolbarItem.getSHOWMODE(), (String)"SHORTWORD", (boolean)true) == 0) {
            this.bShowCaption = true;
            this.bShowIcon = false;
        }
        if (!StringHelper.isNullOrEmpty((String)psDEToolbarItem.getPSSYSCSSID())) {
            this.iPSSysCss = this.iPSDEToolbar.getPSAppView().getPSApplication().getPSSystem().getPSSysCss(psDEToolbarItem.getPSSYSCSSID());
            if (this.iPSDEToolbar.getPSAppView() != null) {
                ((IPSAppViewRuntime)this.iPSDEToolbar.getPSAppView()).registerPSSysCss(this.iPSSysCss);
            }
        }
        if (!StringHelper.isNullOrEmpty((String)psDEToolbarItem.getPSSYSIMAGEID())) {
            this.iPSSysImage = this.iPSDEToolbar.getPSAppView().getPSApplication().getPSSystem().getPSSysImage(psDEToolbarItem.getPSSYSIMAGEID());
            if (this.iPSDEToolbar.getPSAppView() != null) {
                ((IPSAppViewRuntime)this.iPSDEToolbar.getPSAppView()).registerPSSysImage(this.iPSSysImage);
            }
        }
        if (!StringHelper.isNullOrEmpty((String)psDEToolbarItem.getPSSYSPFPLUGINID())) {
            this.iPSSysPFPlugin = ((IPSSystemRuntime)this.iPSDEToolbar.getPSAppView().getPSApplication().getPSSystem()).getPSSysPFPlugin(psDEToolbarItem.getPSSYSPFPLUGINID());
        }
        if (!StringHelper.isNullOrEmpty((String)psDEToolbarItem.getCAPPSLANRESID())) {
            this.capPSLanguageRes = this.iPSDEToolbar.getPSAppView().getPSApplication().getPSSystem().getPSLanguageRes(psDEToolbarItem.getCAPPSLANRESID());
        }
        if (!StringHelper.isNullOrEmpty((String)psDEToolbarItem.getTIPPSLANRESID())) {
            this.tooltipPSLanguageRes = this.iPSDEToolbar.getPSAppView().getPSApplication().getPSSystem().getPSLanguageRes(psDEToolbarItem.getTIPPSLANRESID());
        }
        this.onInit();
    }

    @Override
    protected void onInit() throws Exception {
        super.onInit();
        this.onPreparePSDEToolbarItems();
    }

    protected void onPreparePSDEToolbarItems() throws Exception {
        ArrayList<PSDEToolbarItem> psDEToolbarItemList;
        if (this.psDEToolbarItemList != null) {
            this.psDEToolbarItemList.clear();
        }
        if ((psDEToolbarItemList = this.psDEToolbarItem.getChildPSDEToolbarItems(false)) == null || psDEToolbarItemList.size() == 0) {
            return;
        }
        if (this.psDEToolbarItemList == null) {
            this.psDEToolbarItemList = new ArrayList();
        }
        boolean bLastSeperator = true;
        for (PSDEToolbarItem psDEToolbarItem : psDEToolbarItemList) {
            IPSDEToolbarItem iPSDEToolbarItem = this.getPSModelStorageContext().createPSDEToolbarItem(this.iPSDEToolbar, this, psDEToolbarItem);
            if (!iPSDEToolbarItem.isValid()) continue;
            if (iPSDEToolbarItem instanceof IPSDETBSeperatorItem) {
                if (bLastSeperator) continue;
                bLastSeperator = true;
            } else {
                bLastSeperator = false;
            }
            this.psDEToolbarItemList.add(iPSDEToolbarItem);
        }
        if (bLastSeperator && this.psDEToolbarItemList.size() > 0) {
            this.psDEToolbarItemList.remove(this.psDEToolbarItemList.size() - 1);
        }
        if (this.psDEToolbarItemList.size() == 0) {
            this.psDEToolbarItemList = null;
        }
    }

    @PSModelRTMeta(description="\u6807\u9898")
    public String getCaption() {
        if (StringHelper.isNullOrEmpty((String)this.strCaption)) {
            return this.onGetCaption();
        }
        return this.strCaption;
    }

    protected String onGetCaption() {
        return "";
    }

    public IPSDEToolbar getPSDEToolbar() {
        return this.iPSDEToolbar;
    }

    protected void setPSDEToolbar(IPSDEToolbar iPSDEToolbar) {
        this.iPSDEToolbar = iPSDEToolbar;
        if (this.iPSDEToolbar == null) {
            this.iPSDEContextMenu = null;
        } else if (this.iPSDEToolbar instanceof IPSDEContextMenu) {
            this.iPSDEContextMenu = (IPSDEContextMenu)this.iPSDEToolbar;
        }
    }

    public IPSDEToolbarItem getParentPSDEToolbarItem() {
        return this.parentPSDEToolbarItem;
    }

    protected void setParentPSDEToolbarItem(IPSDEToolbarItem parentPSDEToolbarItem) {
        this.parentPSDEToolbarItem = parentPSDEToolbarItem;
        if (this.parentPSDEToolbarItem == null) {
            this.parentPSDEContextMenuItem = null;
        } else if (this.parentPSDEToolbarItem instanceof IPSDEContextMenuItem) {
            this.parentPSDEContextMenuItem = (IPSDEContextMenuItem)this.parentPSDEToolbarItem;
        }
    }

    public PSDEToolbarItem getPSDEToolbarItemData() {
        return this.psDEToolbarItem;
    }

    protected void setPSDEToolbarItemData(PSDEToolbarItem psDEToolbarItem) {
        this.psDEToolbarItem = psDEToolbarItem;
    }

    @PSModelRTMeta(description="\u9879\u7c7b\u578b", codelist="TBItemType")
    public String getItemType() {
        return this.getPSDEToolbarItemData().getTBITEMTYPE();
    }

    @Override
    public void fillRelatedPSAppViews(ArrayList<IPSAppView> relatedAppViewList) throws Exception {
        this.onFillRelatedPSAppViews(relatedAppViewList);
    }

    protected void onFillRelatedPSAppViews(ArrayList<IPSAppView> relatedAppViewList) throws Exception {
        if (this.psDEToolbarItemList == null) {
            return;
        }
        for (IPSDEToolbarItem iPSDEToolbarItem : this.psDEToolbarItemList) {
            ((IPSDEToolbarItemRuntime)iPSDEToolbarItem).fillRelatedPSAppViews(relatedAppViewList);
        }
    }

    public boolean isValid() throws Exception {
        return true;
    }

    @PSModelRTMeta(description="\u662f\u5426\u663e\u793a\u6807\u9898")
    public boolean isShowCaption() {
        return this.bShowCaption;
    }

    @PSModelRTMeta(description="\u662f\u5426\u663e\u793a\u56fe\u6807")
    public boolean isShowIcon() {
        return this.bShowIcon;
    }

    @PSModelRTMeta(description="\u5de5\u5177\u63d0\u793a")
    public String getTooltip() {
        return this.getCaption();
    }

    @Override
    public String getPSSysModelInstId() {
        return ((IPSModelObjectRuntime)this.iPSDEToolbar).getPSSysModelInstId();
    }

    @PSModelRTMeta(description="\u56fe\u6807\u8d44\u6e90\u5bf9\u8c61")
    public IPSSysImage getPSSysImage() {
        return this.iPSSysImage;
    }

    @PSModelRTMeta(description="\u7cfb\u7edf\u6837\u5f0f")
    public IPSSysCss getPSSysCss() {
        return this.iPSSysCss;
    }

    public IPSDEContextMenu getPSDEContextMenu() {
        return this.iPSDEContextMenu;
    }

    public IPSDEContextMenuItem getParentPSDEContextMenuItem() {
        return this.parentPSDEContextMenuItem;
    }

    @Override
    @PSModelRTMeta(description="\u524d\u7aef\u5e94\u7528\u63d2\u4ef6")
    public IPSSysPFPlugin getPSSysPFPlugin() {
        return this.iPSSysPFPlugin;
    }

    @PSModelRTMeta(description="\u6807\u9898\u8bed\u8a00\u8d44\u6e90")
    public IPSLanguageRes getCapPSLanguageRes() {
        return this.capPSLanguageRes;
    }

    @PSModelRTMeta(description="\u63d0\u793a\u8bed\u8a00\u8d44\u6e90")
    public IPSLanguageRes getTooltipPSLanguageRes() {
        return this.tooltipPSLanguageRes;
    }

    @PSModelRTMeta(description="\u5de5\u5177\u680f\u9879\u5bbd\u5ea6")
    public double getWidth() {
        return this.fWidth;
    }

    @PSModelRTMeta(description="\u5de5\u5177\u680f\u9879\u9ad8\u5ea6")
    public double getHeight() {
        return this.fHeight;
    }

    @Override
    public void fillPSDEToolbarItems(ArrayList<IPSDEToolbarItem> psDEToolbarItemList) {
        psDEToolbarItemList.add(this);
    }

    protected ArrayList<IPSDEToolbarItem> getPSDEToolbarItemList(boolean bCreate) {
        if (this.psDEToolbarItemList == null && bCreate) {
            this.psDEToolbarItemList = new ArrayList();
        }
        return this.psDEToolbarItemList;
    }

    public ArrayList<ObjectNode> toJsonObjects(ArrayList<ObjectNode> objectNodeList) throws Exception {
        if (objectNodeList == null) {
            objectNodeList = new ArrayList();
        }
        ObjectNode objectNode = JsonNodeHelper.createObjectNode();
        this.onFillJsonObject(objectNode);
        objectNodeList.add(objectNode);
        return objectNodeList;
    }

    protected void onFillJsonObject(ObjectNode objectNode) throws Exception {
        JsonNodeHelper.put((ObjectNode)objectNode, (String)"name", (Object)this.getName());
        JsonNodeHelper.put((ObjectNode)objectNode, (String)"type", (Object)this.getItemType());
        if (this.isShowCaption()) {
            JsonNodeHelper.put((ObjectNode)objectNode, (String)"showcap", (Object)true);
            if (!StringHelper.isNullOrEmpty((String)this.getCaption())) {
                JsonNodeHelper.put((ObjectNode)objectNode, (String)"caption", (Object)this.getCaption());
            }
        }
    }

    @Override
    public IPSControl getOwnedPSControl() {
        if (this.getPSDEToolbar() != null) {
            return this.getPSDEToolbar();
        }
        return this.getPSDEContextMenu();
    }
}

