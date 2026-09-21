/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.paas.ctrlmodel;

import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.paas.control.menu.AppMenuItem;
import net.ibizsys.paas.control.menu.AppMenuRootItem;
import net.ibizsys.paas.control.menu.IAppMenuItem;
import net.ibizsys.paas.ctrlmodel.CtrlModelBase;
import net.ibizsys.paas.ctrlmodel.IAppMenuModel;
import net.ibizsys.paas.sysmodel.ISystemUtil;
import net.ibizsys.paas.sysmodel.util.IAppCustomizeUtil;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.MDAjaxActionResult;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class AppMenuModelBase
extends CtrlModelBase
implements IAppMenuModel {
    private static final Log log = LogFactory.getLog(AppMenuModelBase.class);
    private AppMenuRootItem appMenuRootItem = new AppMenuRootItem();
    private boolean bPrepareRootItem = false;

    public void init() throws Exception {
        this.onInit();
        this.prepareCtrlModel();
    }

    @Override
    protected void onInit() throws Exception {
        super.onInit();
    }

    @Override
    protected void prepareCtrlModel() throws Exception {
        if (!this.bPrepareRootItem) {
            this.bPrepareRootItem = true;
            this.onPrepareRootItem(this.getRootItem());
        }
    }

    @Override
    public AppMenuRootItem getRootItem() {
        return this.appMenuRootItem;
    }

    @Override
    public Iterator<IAppMenuItem> getAppMenuItems() {
        return this.getRootItem().getItems().iterator();
    }

    @Override
    public String getControlType() {
        return "APPMENU";
    }

    protected void onPrepareRootItem(AppMenuRootItem appMenuRootItem) throws Exception {
    }

    @Override
    public void fillFetchResult(MDAjaxActionResult fetchResult) throws Exception {
        Iterator<IAppMenuItem> appMenuItems = null;
        if (this.isEnableCustomize() && this.getViewController() != null) {
            ISystemUtil iSystemUtil = this.getViewController().getAppModel().getSystemModel().getSystemUtil("APPCUSTOMIZE", true);
            if (iSystemUtil != null) {
                appMenuItems = ((IAppCustomizeUtil)iSystemUtil).getAppMenuItems(this);
            } else {
                log.warn((Object)StringHelper.format("\u5e94\u7528\u83dc\u5355[%1$s]\u542f\u7528\u81ea\u5b9a\u4e49\uff0c\u4f46\u7cfb\u7edf\u6ca1\u6709\u63d0\u4f9b\u5e94\u7528\u81ea\u5b9a\u4e49\u7ec4\u4ef6"));
            }
        }
        if (appMenuItems == null) {
            appMenuItems = this.getAppMenuItems();
        }
        while (appMenuItems.hasNext()) {
            IAppMenuItem iAppMenuItem = appMenuItems.next();
            if (iAppMenuItem.getFiller() != null) {
                ArrayList<JSONObject> list = iAppMenuItem.getFiller().toJSONObjects(iAppMenuItem);
                if (list == null) continue;
                fetchResult.getRows().addAll(list);
                continue;
            }
            JSONObject jo = AppMenuItem.toJSONObject(iAppMenuItem, null);
            if (jo == null) continue;
            fetchResult.getRows().add(jo);
        }
    }
}

