/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.core;

import net.ibizsys.paas.core.IApplication;
import net.ibizsys.paas.core.IApplicationRuntime;
import net.ibizsys.paas.core.ISystem;
import net.ibizsys.paas.core.ISystemRuntime;

public interface IModelStorage {
    public ISystem getSystem(String var1) throws Exception;

    public IApplication getApplication(String var1) throws Exception;

    public ISystemRuntime getSystemRuntime(String var1) throws Exception;

    public IApplicationRuntime getApplicationRuntime(String var1) throws Exception;

    public String getSystemSetting(String var1, String var2);
}

