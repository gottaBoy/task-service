/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.model.IPSModelJsonExporter2
 *  net.ibizsys.model.app.view.IPSAppView
 *  net.ibizsys.model.control.IPSControlContainer
 *  net.ibizsys.model.control.IPSControlParam
 *  net.ibizsys.model.control.toolbar.IPSDETBSeperatorItem
 *  net.ibizsys.model.control.toolbar.IPSDETBUIActionItem
 *  net.ibizsys.model.control.toolbar.IPSDEToolbar
 *  net.ibizsys.model.control.toolbar.IPSDEToolbarItem
 *  net.ibizsys.model.control.toolbar.IPSDEToolbarParam
 *  net.ibizsys.model.dataentity.IPSDataEntity
 *  net.ibizsys.model.dataentity.uiaction.IPSDEUIActionGroup
 *  net.ibizsys.paas.core.CallResult
 *  net.ibizsys.paas.util.JsonNodeHelper
 *  net.ibizsys.paas.util.StringHelper
 */
package net.ibizsys.model.control.toolbar;

import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.ibizsys.model.IPSModelJsonExporter2;
import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.PSModelRTMeta;
import net.ibizsys.model.app.view.IPSAppView;
import net.ibizsys.model.control.IPSControlContainer;
import net.ibizsys.model.control.IPSControlParam;
import net.ibizsys.model.control.PSControlImpl;
import net.ibizsys.model.control.toolbar.IPSDETBSeperatorItem;
import net.ibizsys.model.control.toolbar.IPSDETBUIActionItem;
import net.ibizsys.model.control.toolbar.IPSDEToolbar;
import net.ibizsys.model.control.toolbar.IPSDEToolbarItem;
import net.ibizsys.model.control.toolbar.IPSDEToolbarItemRuntime;
import net.ibizsys.model.control.toolbar.IPSDEToolbarParam;
import net.ibizsys.model.control.toolbar.PSDEToolbarParamImpl;
import net.ibizsys.model.dataentity.IPSDataEntity;
import net.ibizsys.model.dataentity.uiaction.IPSDEUIActionGroup;
import net.ibizsys.model.entity.PSDEToolbar;
import net.ibizsys.model.entity.PSDEToolbarItem;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.util.JsonNodeHelper;
import net.ibizsys.paas.util.StringHelper;

public class PSDEToolbarImpl
extends PSControlImpl
implements IPSDEToolbar {
    protected PSDEToolbar psDEToolbar;
    protected ArrayList<IPSDEToolbarItem> psDEToolbarItemList = new ArrayList();
    protected ArrayList<IPSDEToolbarItem> allPSDEToolbarItemList = new ArrayList();
    protected PSDEToolbarParamImpl psDEToolbarParamImpl = new PSDEToolbarParamImpl();
    private static final Pattern codeNamePattern = Pattern.compile("[a-zA-Z_$][a-zA-Z0-9_$]*");

    @Override
    public void init(IPSModelStorageContext iPSModelStorageContext, IPSControlContainer iPSControlContainer, String strName, IPSControlParam iPSControlParam) throws Exception {
        this.setPSModelStorageContext(iPSModelStorageContext);
        this.setPSControlContainer(iPSControlContainer);
        IPSDEToolbarParam iPSDEToolbarParam = (IPSDEToolbarParam)iPSControlParam;
        this.psDEToolbar = new PSDEToolbar();
        CallResult callResult = this.getPSModelQueryHelper().getPSDEToolbar(iPSDEToolbarParam.getPSDEToolbarId(), this.psDEToolbar);
        if (callResult.isError()) {
            throw new Exception(StringHelper.format((String)"\u83b7\u53d6\u5b9e\u4f53\u5de5\u5177\u680f\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        this.setId(this.psDEToolbar.getPSDETOOLBARID());
        this.setName(strName);
        this.setLogicName(this.psDEToolbar.getPSDETOOLBARNAME());
        this.setPSObjectData(this.psDEToolbar);
        if (!StringHelper.isNullOrEmpty((String)this.psDEToolbar.getPSDEID())) {
            IPSDataEntity iPSDataEntity = this.getPSAppView().getPSApplication().getPSSystem().getPSDataEntity(this.psDEToolbar.getPSDEID());
            this.setPSDataEntity(iPSDataEntity);
        }
        this.psDEToolbarParamImpl.setPSDEToolbarId(this.psDEToolbar.getPSDETOOLBARID());
        this.psDEToolbarParamImpl.setPSDEUIActionGroupId(this.psDEToolbar.getPSDEUAGROUPID());
        this.psDEToolbarParamImpl.setNo2PSDEUIActionGroupId(this.psDEToolbar.getNO2PSDEUAGROUPID());
        this.psDEToolbarParamImpl.setNo3PSDEUIActionGroupId(this.psDEToolbar.getNO3PSDEUAGROUPID());
        this.psDEToolbarParamImpl.setNo4PSDEUIActionGroupId(this.psDEToolbar.getNO4PSDEUAGROUPID());
        this.psDEToolbarParamImpl.setNo5PSDEUIActionGroupId(this.psDEToolbar.getNO5PSDEUAGROUPID());
        this.psDEToolbarParamImpl.setNo6PSDEUIActionGroupId(this.psDEToolbar.getNO6PSDEUAGROUPID());
        this.psDEToolbarParamImpl.setToolbarStyle(this.psDEToolbar.getTOOLBARSTYLE());
        this.psDEToolbarParamImpl.merge(iPSControlParam);
        super.init(iPSModelStorageContext, iPSControlContainer, strName, this.psDEToolbarParamImpl);
    }

    @Override
    protected void onInit() throws Exception {
        super.onInit();
        this.onPreparePSDEToolbarItems();
    }

    protected void onPreparePSDEToolbarItems() throws Exception {
        this.psDEToolbarItemList.clear();
        this.allPSDEToolbarItemList.clear();
        Vector<PSDEToolbarItem> psDEToolbarItemList = new Vector<PSDEToolbarItem>();
        CallResult callResult = this.getPSModelQueryHelper().getPSDEToolbarItems(this.getId(), psDEToolbarItemList);
        if (callResult.isError()) {
            throw new Exception(StringHelper.format((String)"\u67e5\u8be2\u5de5\u5177\u680f\u9879\u96c6\u5408\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        HashMap<String, PSDEToolbarItem> psDEToolbarItemMap = new HashMap<String, PSDEToolbarItem>();
        int nSysTBItemIndex = 1;
        for (PSDEToolbarItem psDEToolbarItem : psDEToolbarItemList) {
            Matcher m;
            boolean b;
            psDEToolbarItemMap.put(psDEToolbarItem.getPSDETBITEMID(), psDEToolbarItem);
            if (StringHelper.isNullOrEmpty((String)psDEToolbarItem.getPSDETBITEMNAME()) || (b = (m = codeNamePattern.matcher(psDEToolbarItem.getPSDETBITEMNAME())).matches())) continue;
            psDEToolbarItem.setPSDETBITEMNAME(StringHelper.format((String)"systbitem%1$s", (Object)nSysTBItemIndex));
            ++nSysTBItemIndex;
        }
        for (PSDEToolbarItem psDEToolbarItem : psDEToolbarItemList) {
            PSDEToolbarItem parentPSDEToolbarItem;
            if (StringHelper.isNullOrEmpty((String)psDEToolbarItem.getPPSDETBITEMID()) || (parentPSDEToolbarItem = (PSDEToolbarItem)((Object)psDEToolbarItemMap.get(psDEToolbarItem.getPPSDETBITEMID()))) == null) continue;
            parentPSDEToolbarItem.getChildPSDEToolbarItems(true).add(psDEToolbarItem);
        }
        boolean bLastSeperator = true;
        for (PSDEToolbarItem psDEToolbarItem : psDEToolbarItemList) {
            IPSDETBUIActionItem iPSDETBUIActionItem;
            IPSDEToolbarItem iPSDEToolbarItem;
            if (!StringHelper.isNullOrEmpty((String)psDEToolbarItem.getPPSDETBITEMID()) || !(iPSDEToolbarItem = this.getPSModelStorageContext().createPSDEToolbarItem(this, null, psDEToolbarItem)).isValid()) continue;
            if (iPSDEToolbarItem instanceof IPSDETBSeperatorItem) {
                if (bLastSeperator) continue;
                bLastSeperator = true;
            } else {
                bLastSeperator = false;
            }
            if (iPSDEToolbarItem instanceof IPSDETBUIActionItem && (iPSDETBUIActionItem = (IPSDETBUIActionItem)iPSDEToolbarItem).getPSDEUIAction().isUIActionGroup((Object)iPSDETBUIActionItem)) {
                Iterator childPSDEToolbarItems = iPSDETBUIActionItem.getPSDEToolbarItems();
                if (childPSDEToolbarItems == null) continue;
                while (childPSDEToolbarItems.hasNext()) {
                    this.psDEToolbarItemList.add((IPSDEToolbarItem)childPSDEToolbarItems.next());
                }
                continue;
            }
            this.psDEToolbarItemList.add(iPSDEToolbarItem);
        }
        if (bLastSeperator && this.psDEToolbarItemList.size() > 0) {
            this.psDEToolbarItemList.remove(this.psDEToolbarItemList.size() - 1);
        }
        for (IPSDEToolbarItem iPSDEToolbarItem : this.psDEToolbarItemList) {
            ((IPSDEToolbarItemRuntime)iPSDEToolbarItem).fillPSDEToolbarItems(this.allPSDEToolbarItemList);
        }
    }

    @PSModelRTMeta(description="\u90e8\u4ef6\u7c7b\u578b")
    public String getControlType() {
        return "TOOLBAR";
    }

    @PSModelRTMeta(description="\u5de5\u5177\u680f\u9879\u96c6\u5408")
    public Iterator<IPSDEToolbarItem> getPSDEToolbarItems() {
        return this.psDEToolbarItemList.iterator();
    }

    public IPSDEUIActionGroup getPSDEUIActionGroup(String strPSSysDEUIActionId) throws Exception {
        String strPSDEUIActionGroupId = "";
        strPSDEUIActionGroupId = StringHelper.compare((String)strPSSysDEUIActionId, (String)"VIEW_DEBHGROUP001", (boolean)true) == 0 ? this.psDEToolbarParamImpl.getPSDEUIActionGroupId() : (StringHelper.compare((String)strPSSysDEUIActionId, (String)"VIEW_DEBHGROUP002", (boolean)true) == 0 ? this.psDEToolbarParamImpl.getNo2PSDEUIActionGroupId() : (StringHelper.compare((String)strPSSysDEUIActionId, (String)"VIEW_DEBHGROUP003", (boolean)true) == 0 ? this.psDEToolbarParamImpl.getNo3PSDEUIActionGroupId() : (StringHelper.compare((String)strPSSysDEUIActionId, (String)"VIEW_DEBHGROUP004", (boolean)true) == 0 ? this.psDEToolbarParamImpl.getNo4PSDEUIActionGroupId() : (StringHelper.compare((String)strPSSysDEUIActionId, (String)"VIEW_DEBHGROUP005", (boolean)true) == 0 ? this.psDEToolbarParamImpl.getNo5PSDEUIActionGroupId() : (StringHelper.compare((String)strPSSysDEUIActionId, (String)"VIEW_DEBHGROUP006", (boolean)true) == 0 ? this.psDEToolbarParamImpl.getNo6PSDEUIActionGroupId() : strPSSysDEUIActionId)))));
        if (StringHelper.isNullOrEmpty((String)strPSDEUIActionGroupId)) {
            return null;
        }
        try {
            return this.getPSDataEntity().getPSDEUIActionGroup(strPSDEUIActionGroupId);
        }
        catch (Exception ex) {
            throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u5de5\u5177\u680f\u9884\u7f6e\u754c\u9762\u884c\u4e3a\u7ec4[%1$s]\u7ed1\u5b9a\u7684\u5bf9\u8c61[%2$s]", (Object)strPSSysDEUIActionId, (Object)strPSDEUIActionGroupId), ex);
        }
    }

    @Override
    public void fillRelatedPSAppViews(ArrayList<IPSAppView> relatedAppViewList) throws Exception {
        super.fillRelatedPSAppViews(relatedAppViewList);
        for (IPSDEToolbarItem iPSDEToolbarItem : this.psDEToolbarItemList) {
            ((IPSDEToolbarItemRuntime)iPSDEToolbarItem).fillRelatedPSAppViews(relatedAppViewList);
        }
    }

    @PSModelRTMeta(description="\u5de5\u5177\u680f\u6837\u5f0f")
    public String getToolbarStyle() {
        return this.psDEToolbarParamImpl.getToolbarStyle();
    }

    @Override
    public String getModelType() {
        return "PSDETOOLBAR";
    }

    public Iterator<IPSDEToolbarItem> getAllPSDEToolbarItems() throws Exception {
        return this.allPSDEToolbarItemList.iterator();
    }

    @Override
    protected void onFillJsonObject(ObjectNode objectNode) throws Exception {
        super.onFillJsonObject(objectNode);
        ArrayList itemList = new ArrayList();
        Iterator<IPSDEToolbarItem> psDEToolbarItems = this.getPSDEToolbarItems();
        while (psDEToolbarItems.hasNext()) {
            IPSDEToolbarItem iPSDEToolbarItem = psDEToolbarItems.next();
            ((IPSModelJsonExporter2)iPSDEToolbarItem).toJsonObjects(itemList);
        }
        JsonNodeHelper.put((ObjectNode)objectNode, (String)"items", itemList);
    }
}

