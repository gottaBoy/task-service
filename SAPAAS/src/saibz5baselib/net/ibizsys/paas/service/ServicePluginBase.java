/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.sf.json.JSONObject
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.paas.service;

import java.util.ArrayList;
import net.ibizsys.paas.core.IPlugin;
import net.ibizsys.paas.core.PluginActionResult;
import net.ibizsys.paas.core.PluginBase;
import net.ibizsys.paas.entity.EntityError;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.service.IServiceCreateParam;
import net.ibizsys.paas.service.IServicePlugin;
import net.ibizsys.paas.service.IServiceRemoveParam;
import net.ibizsys.paas.service.IServiceUpdateParam;
import net.ibizsys.paas.sysmodel.ISystemPlugin;
import net.sf.json.JSONObject;
import org.hibernate.SessionFactory;

public abstract class ServicePluginBase
extends PluginBase
implements IServicePlugin {
    private IServicePlugin prevServicePlugin = null;
    private SessionFactory sessionFactory = null;

    @Override
    public PluginActionResult doGetDraft(IService iService, int nActionPos, IEntity iEntity, Object objParam) throws Exception {
        if (this.prevServicePlugin != null) {
            return this.prevServicePlugin.doGetDraft(iService, nActionPos, iEntity, objParam);
        }
        return PluginActionResult.Continue;
    }

    @Override
    public PluginActionResult doGetDraftFrom(IService iService, int nActionPos, IEntity iEntity, Object objParam) throws Exception {
        if (this.prevServicePlugin != null) {
            return this.prevServicePlugin.doGetDraftFrom(iService, nActionPos, iEntity, objParam);
        }
        return PluginActionResult.Continue;
    }

    @Override
    public PluginActionResult doCreate(IService iService, int nActionPos, IEntity iEntity, Object objParam) throws Exception {
        if (this.prevServicePlugin != null) {
            return this.prevServicePlugin.doCreate(iService, nActionPos, iEntity, objParam);
        }
        return PluginActionResult.Continue;
    }

    @Override
    public PluginActionResult doUpdate(IService iService, int nActionPos, IEntity iEntity, Object objParam) throws Exception {
        if (this.prevServicePlugin != null) {
            return this.prevServicePlugin.doUpdate(iService, nActionPos, iEntity, objParam);
        }
        return PluginActionResult.Continue;
    }

    @Override
    public PluginActionResult doRemove(IService iService, int nActionPos, IEntity iEntity, Object objParam) throws Exception {
        if (this.prevServicePlugin != null) {
            return this.prevServicePlugin.doRemove(iService, nActionPos, iEntity, objParam);
        }
        return PluginActionResult.Continue;
    }

    @Override
    public PluginActionResult doCreate(IService iService, int nActionPos, IServiceCreateParam<?> iServiceCreateParam, Object objParam) throws Exception {
        if (this.prevServicePlugin != null) {
            return this.prevServicePlugin.doCreate(iService, nActionPos, iServiceCreateParam, objParam);
        }
        return PluginActionResult.Continue;
    }

    @Override
    public PluginActionResult doUpdate(IService iService, int nActionPos, IServiceUpdateParam<?> iServiceUpdateParam, Object objParam) throws Exception {
        if (this.prevServicePlugin != null) {
            return this.prevServicePlugin.doUpdate(iService, nActionPos, iServiceUpdateParam, objParam);
        }
        return PluginActionResult.Continue;
    }

    @Override
    public PluginActionResult doRemove(IService iService, int nActionPos, IServiceRemoveParam<?> iServiceRemoveParam, Object objParam) throws Exception {
        if (this.prevServicePlugin != null) {
            return this.prevServicePlugin.doRemove(iService, nActionPos, iServiceRemoveParam, objParam);
        }
        return PluginActionResult.Continue;
    }

    @Override
    public PluginActionResult doCopyDetails(IService iService, int nActionPos, IEntity iEntity, Object objParam) throws Exception {
        if (this.prevServicePlugin != null) {
            return this.prevServicePlugin.doCopyDetails(iService, nActionPos, iEntity, objParam);
        }
        return PluginActionResult.Continue;
    }

    @Override
    public PluginActionResult doExportModel(IService iService, int nActionPos, IEntity iEntity, ArrayList<JSONObject> list, int nExportModelMode, Object objParam) throws Exception {
        if (this.prevServicePlugin != null) {
            return this.prevServicePlugin.doExportModel(iService, nActionPos, iEntity, list, nExportModelMode, objParam);
        }
        return PluginActionResult.Continue;
    }

    @Override
    public PluginActionResult doImportModel(IService iService, int nActionPos, JSONObject jo, Object objParam) throws Exception {
        if (this.prevServicePlugin != null) {
            return this.prevServicePlugin.doImportModel(iService, nActionPos, jo, objParam);
        }
        return PluginActionResult.Continue;
    }

    @Override
    public PluginActionResult doCustomAction(IService iService, String strActionName, int nActionPos, IEntity iEntity, Object objParam) throws Exception {
        if (this.prevServicePlugin != null) {
            return this.prevServicePlugin.doCustomAction(iService, strActionName, nActionPos, iEntity, objParam);
        }
        return PluginActionResult.Continue;
    }

    @Override
    public PluginActionResult doCheckEntity(IService iService, int nActionPos, IEntity et, boolean bCreate, boolean bTempMode, EntityError entityError, Object objParam) throws Exception {
        if (this.prevServicePlugin != null) {
            return this.prevServicePlugin.doCheckEntity(iService, nActionPos, et, bCreate, bTempMode, entityError, objParam);
        }
        return PluginActionResult.Continue;
    }

    @Override
    public PluginActionResult isPrepareLastForUpdate(IService iService, Object objParam) {
        if (this.prevServicePlugin != null) {
            return this.prevServicePlugin.isPrepareLastForUpdate(iService, objParam);
        }
        return PluginActionResult.Continue;
    }

    @Override
    public PluginActionResult isPrepareLastForRemove(IService iService, Object objParam) {
        if (this.prevServicePlugin != null) {
            return this.prevServicePlugin.isPrepareLastForRemove(iService, objParam);
        }
        return PluginActionResult.Continue;
    }

    @Override
    public void setPrevPlugin(IPlugin iPlugin) {
        super.setPrevPlugin(iPlugin);
        if (iPlugin instanceof IServicePlugin) {
            this.prevServicePlugin = (IServicePlugin)iPlugin;
        }
        if (iPlugin instanceof ISystemPlugin) {
            this.prevServicePlugin = ((ISystemPlugin)iPlugin).getServicePlugin();
        }
    }

    public SessionFactory getSessionFactory() {
        return this.sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}

