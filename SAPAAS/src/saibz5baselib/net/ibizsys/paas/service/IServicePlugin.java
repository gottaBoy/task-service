/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.sf.json.JSONObject
 */
package net.ibizsys.paas.service;

import java.util.ArrayList;
import net.ibizsys.paas.core.IPlugin;
import net.ibizsys.paas.core.PluginActionResult;
import net.ibizsys.paas.entity.EntityError;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.service.IServiceCreateParam;
import net.ibizsys.paas.service.IServiceRemoveParam;
import net.ibizsys.paas.service.IServiceUpdateParam;
import net.sf.json.JSONObject;

public interface IServicePlugin
extends IPlugin {
    public PluginActionResult doGetDraft(IService var1, int var2, IEntity var3, Object var4) throws Exception;

    public PluginActionResult doGetDraftFrom(IService var1, int var2, IEntity var3, Object var4) throws Exception;

    public PluginActionResult doCreate(IService var1, int var2, IEntity var3, Object var4) throws Exception;

    public PluginActionResult doUpdate(IService var1, int var2, IEntity var3, Object var4) throws Exception;

    public PluginActionResult doRemove(IService var1, int var2, IEntity var3, Object var4) throws Exception;

    public PluginActionResult doCreate(IService var1, int var2, IServiceCreateParam<?> var3, Object var4) throws Exception;

    public PluginActionResult doUpdate(IService var1, int var2, IServiceUpdateParam<?> var3, Object var4) throws Exception;

    public PluginActionResult doRemove(IService var1, int var2, IServiceRemoveParam<?> var3, Object var4) throws Exception;

    public PluginActionResult doCopyDetails(IService var1, int var2, IEntity var3, Object var4) throws Exception;

    public PluginActionResult doExportModel(IService var1, int var2, IEntity var3, ArrayList<JSONObject> var4, int var5, Object var6) throws Exception;

    public PluginActionResult doImportModel(IService var1, int var2, JSONObject var3, Object var4) throws Exception;

    public PluginActionResult doCustomAction(IService var1, String var2, int var3, IEntity var4, Object var5) throws Exception;

    public PluginActionResult doCheckEntity(IService var1, int var2, IEntity var3, boolean var4, boolean var5, EntityError var6, Object var7) throws Exception;

    public PluginActionResult isPrepareLastForUpdate(IService var1, Object var2);

    public PluginActionResult isPrepareLastForRemove(IService var1, Object var2);
}

