/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.sf.json.JSONObject
 */
package net.ibizsys.paas.sysmodel;

import java.util.ArrayList;
import java.util.HashMap;
import net.ibizsys.paas.core.PluginActionResult;
import net.ibizsys.paas.entity.EntityError;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.service.IServiceCreateParam;
import net.ibizsys.paas.service.IServicePlugin;
import net.ibizsys.paas.service.IServiceRemoveParam;
import net.ibizsys.paas.service.IServiceUpdateParam;
import net.ibizsys.paas.service.ServicePluginBase;
import net.ibizsys.paas.sysmodel.ISystemServicePlugin;
import net.sf.json.JSONObject;

public class SystemServicePlugin
extends ServicePluginBase
implements ISystemServicePlugin {
    protected HashMap<String, IServicePlugin> iServicePluginMap = new HashMap();

    @Override
    public void registerServicePlugin(String strDEName, IServicePlugin iServicePlugin) throws Exception {
        this.iServicePluginMap.put(strDEName, iServicePlugin);
    }

    @Override
    public PluginActionResult doCreate(IService iService, int nActionPos, IEntity iEntity, Object objParam) throws Exception {
        PluginActionResult pluginActionResult;
        IServicePlugin iServicePlugin = this.iServicePluginMap.get(iService.getDEModel().getName());
        if (iServicePlugin == null) {
            iServicePlugin = this.iServicePluginMap.get("");
        }
        if (iServicePlugin != null && (pluginActionResult = iServicePlugin.doCreate(iService, nActionPos, iEntity, objParam)) == PluginActionResult.Replace) {
            return pluginActionResult;
        }
        return super.doCreate(iService, nActionPos, iEntity, objParam);
    }

    @Override
    public PluginActionResult doUpdate(IService iService, int nActionPos, IEntity iEntity, Object objParam) throws Exception {
        PluginActionResult pluginActionResult;
        IServicePlugin iServicePlugin = this.iServicePluginMap.get(iService.getDEModel().getName());
        if (iServicePlugin == null) {
            iServicePlugin = this.iServicePluginMap.get("");
        }
        if (iServicePlugin != null && (pluginActionResult = iServicePlugin.doUpdate(iService, nActionPos, iEntity, objParam)) == PluginActionResult.Replace) {
            return pluginActionResult;
        }
        return super.doUpdate(iService, nActionPos, iEntity, objParam);
    }

    @Override
    public PluginActionResult doRemove(IService iService, int nActionPos, IEntity iEntity, Object objParam) throws Exception {
        PluginActionResult pluginActionResult;
        IServicePlugin iServicePlugin = this.iServicePluginMap.get(iService.getDEModel().getName());
        if (iServicePlugin == null) {
            iServicePlugin = this.iServicePluginMap.get("");
        }
        if (iServicePlugin != null && (pluginActionResult = iServicePlugin.doRemove(iService, nActionPos, iEntity, objParam)) == PluginActionResult.Replace) {
            return pluginActionResult;
        }
        return super.doRemove(iService, nActionPos, iEntity, objParam);
    }

    @Override
    public PluginActionResult doCreate(IService iService, int nActionPos, IServiceCreateParam<?> iServiceCreateParam, Object objParam) throws Exception {
        PluginActionResult pluginActionResult;
        IServicePlugin iServicePlugin = this.iServicePluginMap.get(iService.getDEModel().getName());
        if (iServicePlugin == null) {
            iServicePlugin = this.iServicePluginMap.get("");
        }
        if (iServicePlugin != null && (pluginActionResult = iServicePlugin.doCreate(iService, nActionPos, iServiceCreateParam, objParam)) == PluginActionResult.Replace) {
            return pluginActionResult;
        }
        return super.doCreate(iService, nActionPos, iServiceCreateParam, objParam);
    }

    @Override
    public PluginActionResult doUpdate(IService iService, int nActionPos, IServiceUpdateParam<?> iServiceUpdateParam, Object objParam) throws Exception {
        PluginActionResult pluginActionResult;
        IServicePlugin iServicePlugin = this.iServicePluginMap.get(iService.getDEModel().getName());
        if (iServicePlugin == null) {
            iServicePlugin = this.iServicePluginMap.get("");
        }
        if (iServicePlugin != null && (pluginActionResult = iServicePlugin.doUpdate(iService, nActionPos, iServiceUpdateParam, objParam)) == PluginActionResult.Replace) {
            return pluginActionResult;
        }
        return super.doUpdate(iService, nActionPos, iServiceUpdateParam, objParam);
    }

    @Override
    public PluginActionResult doRemove(IService iService, int nActionPos, IServiceRemoveParam<?> iServiceRemoveParam, Object objParam) throws Exception {
        PluginActionResult pluginActionResult;
        IServicePlugin iServicePlugin = this.iServicePluginMap.get(iService.getDEModel().getName());
        if (iServicePlugin == null) {
            iServicePlugin = this.iServicePluginMap.get("");
        }
        if (iServicePlugin != null && (pluginActionResult = iServicePlugin.doRemove(iService, nActionPos, iServiceRemoveParam, objParam)) == PluginActionResult.Replace) {
            return pluginActionResult;
        }
        return super.doRemove(iService, nActionPos, iServiceRemoveParam, objParam);
    }

    @Override
    public PluginActionResult doCopyDetails(IService iService, int nActionPos, IEntity iEntity, Object objParam) throws Exception {
        PluginActionResult pluginActionResult;
        IServicePlugin iServicePlugin = this.iServicePluginMap.get(iService.getDEModel().getName());
        if (iServicePlugin == null) {
            iServicePlugin = this.iServicePluginMap.get("");
        }
        if (iServicePlugin != null && (pluginActionResult = iServicePlugin.doCopyDetails(iService, nActionPos, iEntity, objParam)) == PluginActionResult.Replace) {
            return pluginActionResult;
        }
        return super.doCopyDetails(iService, nActionPos, iEntity, objParam);
    }

    @Override
    public PluginActionResult doGetDraft(IService iService, int nActionPos, IEntity iEntity, Object objParam) throws Exception {
        PluginActionResult pluginActionResult;
        IServicePlugin iServicePlugin = this.iServicePluginMap.get(iService.getDEModel().getName());
        if (iServicePlugin == null) {
            iServicePlugin = this.iServicePluginMap.get("");
        }
        if (iServicePlugin != null && (pluginActionResult = iServicePlugin.doGetDraft(iService, nActionPos, iEntity, objParam)) == PluginActionResult.Replace) {
            return pluginActionResult;
        }
        return super.doGetDraft(iService, nActionPos, iEntity, objParam);
    }

    @Override
    public PluginActionResult doGetDraftFrom(IService iService, int nActionPos, IEntity iEntity, Object objParam) throws Exception {
        PluginActionResult pluginActionResult;
        IServicePlugin iServicePlugin = this.iServicePluginMap.get(iService.getDEModel().getName());
        if (iServicePlugin == null) {
            iServicePlugin = this.iServicePluginMap.get("");
        }
        if (iServicePlugin != null && (pluginActionResult = iServicePlugin.doGetDraftFrom(iService, nActionPos, iEntity, objParam)) == PluginActionResult.Replace) {
            return pluginActionResult;
        }
        return super.doGetDraftFrom(iService, nActionPos, iEntity, objParam);
    }

    @Override
    public PluginActionResult doExportModel(IService iService, int nActionPos, IEntity iEntity, ArrayList<JSONObject> list, int nExportModelMode, Object objParam) throws Exception {
        PluginActionResult pluginActionResult;
        IServicePlugin iServicePlugin = this.iServicePluginMap.get(iService.getDEModel().getName());
        if (iServicePlugin == null) {
            iServicePlugin = this.iServicePluginMap.get("");
        }
        if (iServicePlugin != null && (pluginActionResult = iServicePlugin.doExportModel(iService, nActionPos, iEntity, list, nExportModelMode, objParam)) == PluginActionResult.Replace) {
            return pluginActionResult;
        }
        return super.doExportModel(iService, nActionPos, iEntity, list, nExportModelMode, objParam);
    }

    @Override
    public PluginActionResult doImportModel(IService iService, int nActionPos, JSONObject jo, Object objParam) throws Exception {
        PluginActionResult pluginActionResult;
        IServicePlugin iServicePlugin = this.iServicePluginMap.get(iService.getDEModel().getName());
        if (iServicePlugin == null) {
            iServicePlugin = this.iServicePluginMap.get("");
        }
        if (iServicePlugin != null && (pluginActionResult = iServicePlugin.doImportModel(iService, nActionPos, jo, objParam)) == PluginActionResult.Replace) {
            return pluginActionResult;
        }
        return super.doImportModel(iService, nActionPos, jo, objParam);
    }

    @Override
    public PluginActionResult doCustomAction(IService iService, String strActionName, int nActionPos, IEntity iEntity, Object objParam) throws Exception {
        PluginActionResult pluginActionResult;
        IServicePlugin iServicePlugin = this.iServicePluginMap.get(iService.getDEModel().getName());
        if (iServicePlugin == null) {
            iServicePlugin = this.iServicePluginMap.get("");
        }
        if (iServicePlugin != null && (pluginActionResult = iServicePlugin.doCustomAction(iService, strActionName, nActionPos, iEntity, objParam)) == PluginActionResult.Replace) {
            return pluginActionResult;
        }
        return super.doCustomAction(iService, strActionName, nActionPos, iEntity, objParam);
    }

    @Override
    public PluginActionResult doCheckEntity(IService iService, int nActionPos, IEntity et, boolean bCreate, boolean bTempMode, EntityError entityError, Object objParam) throws Exception {
        PluginActionResult pluginActionResult;
        IServicePlugin iServicePlugin = this.iServicePluginMap.get(iService.getDEModel().getName());
        if (iServicePlugin == null) {
            iServicePlugin = this.iServicePluginMap.get("");
        }
        if (iServicePlugin != null && (pluginActionResult = iServicePlugin.doCheckEntity(iService, nActionPos, et, bCreate, bTempMode, entityError, objParam)) == PluginActionResult.Replace) {
            return pluginActionResult;
        }
        return super.doCheckEntity(iService, nActionPos, et, bCreate, bTempMode, entityError, objParam);
    }

    @Override
    public PluginActionResult isPrepareLastForUpdate(IService iService, Object objParam) {
        PluginActionResult pluginActionResult;
        IServicePlugin iServicePlugin = this.iServicePluginMap.get(iService.getDEModel().getName());
        if (iServicePlugin == null) {
            iServicePlugin = this.iServicePluginMap.get("");
        }
        if (iServicePlugin != null && (pluginActionResult = iServicePlugin.isPrepareLastForUpdate(iService, objParam)) == PluginActionResult.Replace) {
            return pluginActionResult;
        }
        return super.isPrepareLastForUpdate(iService, objParam);
    }

    @Override
    public PluginActionResult isPrepareLastForRemove(IService iService, Object objParam) {
        PluginActionResult pluginActionResult;
        IServicePlugin iServicePlugin = this.iServicePluginMap.get(iService.getDEModel().getName());
        if (iServicePlugin == null) {
            iServicePlugin = this.iServicePluginMap.get("");
        }
        if (iServicePlugin != null && (pluginActionResult = iServicePlugin.isPrepareLastForRemove(iService, objParam)) == PluginActionResult.Replace) {
            return pluginActionResult;
        }
        return super.isPrepareLastForRemove(iService, objParam);
    }
}

