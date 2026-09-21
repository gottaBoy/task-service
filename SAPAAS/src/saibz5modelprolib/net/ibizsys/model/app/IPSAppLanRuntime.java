/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.app.IPSAppLan
 *  net.ibizsys.model.app.IPSApplication
 */
package net.ibizsys.model.app;

import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.app.IPSAppLan;
import net.ibizsys.model.app.IPSApplication;
import net.ibizsys.model.entity.PSAppLan;

public interface IPSAppLanRuntime
extends IPSAppLan {
    public void init(IPSModelStorageContext var1, IPSApplication var2, PSAppLan var3) throws Exception;
}

