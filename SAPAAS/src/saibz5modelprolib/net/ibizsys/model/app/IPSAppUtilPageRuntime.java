/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.app.IPSAppUtilPage
 *  net.ibizsys.model.app.IPSApplication
 */
package net.ibizsys.model.app;

import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.app.IPSAppUtilPage;
import net.ibizsys.model.app.IPSApplication;
import net.ibizsys.model.entity.PSAppUtilPage;

public interface IPSAppUtilPageRuntime
extends IPSAppUtilPage {
    public void init(IPSModelStorageContext var1, IPSApplication var2, PSAppUtilPage var3) throws Exception;
}

