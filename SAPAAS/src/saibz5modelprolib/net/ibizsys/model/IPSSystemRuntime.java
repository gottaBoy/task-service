/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.IPSSystem
 */
package net.ibizsys.model;

import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.IPSSysEngineConfig;
import net.ibizsys.model.IPSSystem;
import net.ibizsys.model.IPSSystemContainer;
import net.ibizsys.model.dataentity.field.IPSDEFieldType;
import net.ibizsys.model.entity.PSACHandler;
import net.ibizsys.model.entity.PSDEField;
import net.ibizsys.model.entity.PSSystem;
import net.ibizsys.model.res.IPSSysPFPlugin;
import net.ibizsys.model.res.IPSSysPFPluginTempl;

public interface IPSSystemRuntime
extends IPSSystem {
    public static final Integer LOADLEVEL_NONE = 0;
    public static final Integer LOADLEVEL_PREVIEW = 10;
    public static final Integer LOADLEVEL_JIT = 30;
    public static final Integer LOADLEVEL_STARTUP = 50;
    public static final Integer LOADLEVEL_CODE = 60;
    public static final Integer LOADLEVEL_DIFF = 70;
    public static final Integer LOADLEVEL_DOC = 80;
    public static final Integer LOADLEVEL_ALL = 99;

    public void init(IPSModelStorageContext var1, IPSSystemContainer var2, PSSystem var3) throws Exception;

    public void active();

    public void active(boolean var1);

    public PSACHandler getPSAjaxControlHandlerData(String var1, boolean var2) throws Exception;

    public IPSSysEngineConfig getPSSysEngineConfig();

    public IPSDEFieldType getPSDEFieldTypeByDEField(PSDEField var1) throws Exception;

    public String getPSDevCenterDomain();

    public String getPSDevCenterId();

    public String getPSDevCenterName();

    public String getPubSystemId();

    public String getPSDepSlnSysId();

    public IPSSysPFPluginTempl getPSSysPFPluginTempl(String var1, boolean var2) throws Exception;

    public IPSSysPFPlugin getPSSysPFPlugin(String var1) throws Exception;

    public void load(int var1) throws Exception;

    public boolean isDeployMode();
}

