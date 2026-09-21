/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.ctrlmodel;

import java.util.Iterator;
import net.ibizsys.paas.ctrlmodel.IAppMenuModel;

public interface IAppMenuModelGlobalPlugin {
    public void registerAppMenuModel(String var1, IAppMenuModel var2);

    public IAppMenuModel getAppMenuModel(Class var1) throws Exception;

    public IAppMenuModel getAppMenuModel(String var1) throws Exception;

    public Iterator<IAppMenuModel> getAllAppMenuModels() throws Exception;
}

