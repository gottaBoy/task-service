/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.dynasys.IPSDynaInst
 *  net.ibizsys.paas.appmodel.IAppViewModel
 *  net.ibizsys.paas.controller.IDynaViewControllerInst
 *  net.ibizsys.paas.core.ModelBase2Impl
 *  net.ibizsys.paas.util.StringHelper
 */
package net.ibizsys.ssdyna.sysmodel;

import java.util.HashMap;
import net.ibizsys.model.dynasys.IPSDynaInst;
import net.ibizsys.paas.appmodel.IAppViewModel;
import net.ibizsys.paas.controller.IDynaViewControllerInst;
import net.ibizsys.paas.core.ModelBase2Impl;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.ssdyna.demodel.IDynaDEModel;
import net.ibizsys.ssdyna.sysmodel.IDynaInstModel;
import net.ibizsys.ssdyna.sysmodel.IDynaSysModel;
import net.ibizsys.ssdynawf.core.IDynaWFModel;

public abstract class DynaInstModelBase
extends ModelBase2Impl
implements IDynaInstModel {
    private IDynaSysModel iDynaSysModel = null;
    private HashMap<String, IDynaDEModel> dynaDEModelMap = new HashMap();
    private HashMap<String, IAppViewModel> appViewModelMap = new HashMap();
    private HashMap<String, IDynaWFModel> dynaWFModelMap = new HashMap();
    private HashMap<String, IDynaViewControllerInst> dynaViewControllerInstMap = new HashMap();
    private String strDynaTag = null;

    @Override
    public void init(IDynaSysModel iDynaSysModel, IPSDynaInst iPSDynaInst) throws Exception {
        this.iDynaSysModel = iDynaSysModel;
        this.strId = iPSDynaInst.getId();
        this.strName = iPSDynaInst.getName();
        this.strDynaTag = iPSDynaInst.getDynaTag();
        this.onInit();
    }

    @Override
    public String getDynaTag() {
        return this.strDynaTag;
    }

    @Override
    public boolean containsDynaDEModel(String strDEName) throws Exception {
        return this.dynaDEModelMap.containsKey(strDEName);
    }

    @Override
    public IDynaDEModel getDynaDEModel(String strDEName, boolean bTryMode) throws Exception {
        IDynaDEModel iDynaDEModel = this.dynaDEModelMap.get(strDEName);
        if (iDynaDEModel == null && !bTryMode) {
            throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u52a8\u6001\u5b9e\u4f53[%1$s]", (Object)strDEName));
        }
        return iDynaDEModel;
    }

    @Override
    public void registerDynaDEModel(IDynaDEModel iDynaDEModel) throws Exception {
        this.dynaDEModelMap.put(iDynaDEModel.getId(), iDynaDEModel);
    }

    @Override
    public IDynaSysModel getDynaSysModel() {
        return this.iDynaSysModel;
    }

    @Override
    public void registerDynaAppViewModel(IAppViewModel iAppViewModel) throws Exception {
        this.appViewModelMap.put(iAppViewModel.getId(), iAppViewModel);
    }

    @Override
    public boolean containsDynaAppViewModel(String strDynaAppViewModelId) {
        return this.appViewModelMap.containsKey(strDynaAppViewModelId);
    }

    @Override
    public IAppViewModel getDynaAppViewModel(String strDynaAppViewModelId, boolean bTryMode) throws Exception {
        IAppViewModel iAppViewModel = this.appViewModelMap.get(strDynaAppViewModelId);
        if (iAppViewModel == null && !bTryMode) {
            throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u52a8\u6001\u5e94\u7528\u89c6\u56fe[%1$s]", (Object)strDynaAppViewModelId));
        }
        return iAppViewModel;
    }

    @Override
    public boolean containsDynaWFModel(String strDEName) throws Exception {
        return this.dynaWFModelMap.containsKey(strDEName);
    }

    @Override
    public IDynaWFModel getDynaWFModel(String strDEName) throws Exception {
        IDynaWFModel iDynaWFModel = this.dynaWFModelMap.get(strDEName);
        if (iDynaWFModel == null) {
            throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u52a8\u6001\u5de5\u4f5c\u6d41[%1$s]", (Object)strDEName));
        }
        return iDynaWFModel;
    }

    @Override
    public void registerDynaWFModel(IDynaWFModel iDynaWFModel) throws Exception {
        this.dynaWFModelMap.put(iDynaWFModel.getId(), iDynaWFModel);
    }

    @Override
    public boolean containsDynaViewControllerInst(String strDynaViewControllerInstId) throws Exception {
        return this.dynaViewControllerInstMap.containsKey(strDynaViewControllerInstId);
    }

    @Override
    public IDynaViewControllerInst getDynaViewControllerInst(String strDynaViewControllerInstId, boolean bTryMode) throws Exception {
        IDynaViewControllerInst iDynaViewControllerInst = this.dynaViewControllerInstMap.get(strDynaViewControllerInstId);
        if (iDynaViewControllerInst == null && !bTryMode) {
            throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u52a8\u6001\u89c6\u56fe\u63a7\u5236\u5668\u5b9e\u4f8b[%1$s]", (Object)strDynaViewControllerInstId));
        }
        return iDynaViewControllerInst;
    }

    @Override
    public void registerDynaViewControllerInst(IDynaViewControllerInst iDynaViewControllerInst) throws Exception {
        this.dynaViewControllerInstMap.put(iDynaViewControllerInst.getId(), iDynaViewControllerInst);
    }
}

