/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.web.IWebContext
 *  net.ibizsys.paas.web.WebContext
 *  net.ibizsys.pswf.core.IWFVersionModel
 *  net.ibizsys.pswf.core.WFModelBase
 */
package net.ibizsys.pswf.core;

import java.util.HashMap;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.WebContext;
import net.ibizsys.pswf.core.DefaultDynaWFVersionModel;
import net.ibizsys.pswf.core.DynaWFInstModel;
import net.ibizsys.pswf.core.IDynaWFModel;
import net.ibizsys.pswf.core.IDynaWFVersionModel;
import net.ibizsys.pswf.core.IWFVersionModel;
import net.ibizsys.pswf.core.WFModelBase;

public abstract class DynaWFModelBase
extends WFModelBase
implements IDynaWFModel {
    private HashMap<String, DynaWFInstModel> dynaWFInstModelMap = new HashMap();

    @Override
    public void registerDynaWFVersionModel(IDynaWFVersionModel iDynaWFVersionModel) throws Exception {
        String strDynaSysInstId = iDynaWFVersionModel.getDynaInstId();
        DynaWFInstModel dynaWFInstModel = this.getDynaWFInstModel(strDynaSysInstId);
        dynaWFInstModel.registerWFVersionModel(iDynaWFVersionModel);
    }

    public IWFVersionModel getLastWFVersionModel() {
        String strDynaSysInstId;
        if (WebContext.getCurrent() != null && !StringHelper.isNullOrEmpty((String)(strDynaSysInstId = WebContext.getDynaSysInstId((IWebContext)WebContext.getCurrent())))) {
            DynaWFInstModel dynaWFInstModel = this.getDynaWFInstModel(strDynaSysInstId);
            return dynaWFInstModel.getLastWFVersionModel();
        }
        return super.getLastWFVersionModel();
    }

    public IWFVersionModel getLastWFVersionModel(String strWFMode) throws Exception {
        String strDynaSysInstId;
        if (WebContext.getCurrent() != null && !StringHelper.isNullOrEmpty((String)(strDynaSysInstId = WebContext.getDynaSysInstId((IWebContext)WebContext.getCurrent())))) {
            DynaWFInstModel dynaWFInstModel = this.getDynaWFInstModel(strDynaSysInstId);
            return dynaWFInstModel.getLastWFVersionModel(strWFMode);
        }
        return super.getLastWFVersionModel(strWFMode);
    }

    public IWFVersionModel getWFVersionModel(String strWFVersionId) throws Exception {
        String strDynaSysInstId;
        if (WebContext.getCurrent() != null && !StringHelper.isNullOrEmpty((String)(strDynaSysInstId = WebContext.getDynaSysInstId((IWebContext)WebContext.getCurrent())))) {
            DynaWFInstModel dynaWFInstModel = this.getDynaWFInstModel(strDynaSysInstId);
            return dynaWFInstModel.getWFVersionModel(strWFVersionId);
        }
        return super.getWFVersionModel(strWFVersionId);
    }

    protected DynaWFInstModel getDynaWFInstModel(String strDynaSysInstId) {
        DynaWFInstModel dynaWFInstModel = this.dynaWFInstModelMap.get(strDynaSysInstId);
        if (dynaWFInstModel == null) {
            dynaWFInstModel = new DynaWFInstModel(this, strDynaSysInstId);
            this.dynaWFInstModelMap.put(strDynaSysInstId, dynaWFInstModel);
        }
        return dynaWFInstModel;
    }

    @Override
    public void resetCurrentDynaSysInst() {
        String strDynaSysInstId;
        if (WebContext.getCurrent() != null && !StringHelper.isNullOrEmpty((String)(strDynaSysInstId = WebContext.getDynaSysInstId((IWebContext)WebContext.getCurrent())))) {
            this.dynaWFInstModelMap.remove(strDynaSysInstId);
        }
    }

    @Override
    public void resetAllDynaSysInst() {
        this.dynaWFInstModelMap.clear();
    }

    public IWFVersionModel getWFVersionModelByWFVersion(int nVersion) throws Exception {
        String strDynaSysInstId;
        if (WebContext.getCurrent() != null && !StringHelper.isNullOrEmpty((String)(strDynaSysInstId = WebContext.getDynaSysInstId((IWebContext)WebContext.getCurrent())))) {
            DynaWFInstModel dynaWFInstModel = this.getDynaWFInstModel(strDynaSysInstId);
            return dynaWFInstModel.getWFVersionModelByWFVersion(nVersion);
        }
        return super.getWFVersionModelByWFVersion(nVersion);
    }

    @Override
    public IDynaWFVersionModel createDynaWFVersionModel(IEntity iEntity) throws Exception {
        return new DefaultDynaWFVersionModel();
    }
}

