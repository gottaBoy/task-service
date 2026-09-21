/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.appmodel.AppViewModel
 *  net.ibizsys.paas.core.ModelBase2Impl
 */
package net.ibizsys.ssdyna.core;

import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.paas.appmodel.AppViewModel;
import net.ibizsys.paas.core.ModelBase2Impl;
import net.ibizsys.ssdyna.core.IDynaDEViewTemplModel;

public class DynaDEViewTemplModel
extends ModelBase2Impl
implements IDynaDEViewTemplModel {
    private ArrayList<AppViewModel> appViewModelList = null;

    @Override
    public void registerAppDynaDEView(String strAppId, String strAppViewId, String strUrl, Object userData) throws Exception {
        if (this.appViewModelList == null) {
            this.appViewModelList = new ArrayList();
        }
        AppViewModel appViewModel = new AppViewModel();
        appViewModel.setAppId(strAppId);
        appViewModel.setId(strAppViewId);
        appViewModel.setViewUrl(strUrl);
        appViewModel.setUserData(userData);
        this.appViewModelList.add(appViewModel);
    }

    public void setId(String strId) {
        this.strId = strId;
    }

    public void setName(String strName) {
        this.strName = strName;
    }

    @Override
    public Iterator<AppViewModel> getAppDynaDEViews() {
        if (this.appViewModelList == null || this.appViewModelList.size() == 0) {
            return null;
        }
        return this.appViewModelList.iterator();
    }
}

