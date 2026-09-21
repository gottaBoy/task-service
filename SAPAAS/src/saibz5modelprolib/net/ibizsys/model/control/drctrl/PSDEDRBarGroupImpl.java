/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.control.drctrl.IPSDEDRBar
 *  net.ibizsys.model.control.drctrl.IPSDEDRBarItem
 *  net.ibizsys.model.core.IPSModelObject
 *  net.ibizsys.model.dataentity.dr.IPSDEDRGroup
 *  net.ibizsys.model.res.IPSLanguageRes
 */
package net.ibizsys.model.control.drctrl;

import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.PSModelRTMeta;
import net.ibizsys.model.PSObjectImpl;
import net.ibizsys.model.control.drctrl.IPSDEDRBar;
import net.ibizsys.model.control.drctrl.IPSDEDRBarGroupRuntime;
import net.ibizsys.model.control.drctrl.IPSDEDRBarItem;
import net.ibizsys.model.core.IPSModelObject;
import net.ibizsys.model.dataentity.dr.IPSDEDRGroup;
import net.ibizsys.model.res.IPSLanguageRes;

public class PSDEDRBarGroupImpl
extends PSObjectImpl
implements IPSDEDRBarGroupRuntime {
    private IPSDEDRBar iPSDEDRBar;
    private IPSDEDRGroup iPSDEDRGroup;
    protected ArrayList<IPSDEDRBarItem> psDEDRBarItemList = new ArrayList();

    @Override
    public void init(IPSModelStorageContext iPSModelStorageContext, IPSDEDRBar iPSDEDRBar, IPSDEDRGroup iPSDEDRGroup) throws Exception {
        this.setPSModelStorageContext(iPSModelStorageContext);
        this.iPSDEDRBar = iPSDEDRBar;
        this.iPSDEDRGroup = iPSDEDRGroup;
        this.setId(this.iPSDEDRGroup.getId());
        this.setName(this.iPSDEDRGroup.getName());
        this.onInit();
    }

    @PSModelRTMeta(description="\u5b9e\u4f53\u6570\u636e\u5173\u7cfb\u680f")
    public IPSDEDRBar getPSDEDRBar() {
        return this.iPSDEDRBar;
    }

    @PSModelRTMeta(description="\u6807\u9898")
    public String getCaption() {
        return this.iPSDEDRGroup.getCaption(this.iPSDEDRBar.getPSAppView().getLanguage());
    }

    @PSModelRTMeta(description="\u5b9e\u4f53\u6570\u636e\u5173\u7cfb\u680f\u9879\u96c6\u5408")
    public Iterator<IPSDEDRBarItem> getPSDEDRBarItems() {
        return this.psDEDRBarItemList.iterator();
    }

    public void addPSDEDRBarItem(IPSDEDRBarItem iPSDEDRBarItem) {
        this.psDEDRBarItemList.add(iPSDEDRBarItem);
    }

    @PSModelRTMeta(description="\u6570\u636e\u5173\u7cfb\u5206\u7ec4\u5bf9\u8c61")
    public IPSDEDRGroup getPSDEDRGroup() {
        return this.iPSDEDRGroup;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSSysModelInstId((IPSModelObject)this.iPSDEDRBar);
    }

    @PSModelRTMeta(description="\u9690\u85cf\u5206\u7ec4")
    public boolean isHidden() {
        return this.getPSDEDRGroup().isHidden();
    }

    @PSModelRTMeta(description="\u6807\u9898\u8bed\u8a00\u7cfb\u7edf\u5bf9\u8c61")
    public IPSLanguageRes getCapPSLanguageRes() {
        return this.iPSDEDRGroup.getCapPSLanguageRes();
    }
}

