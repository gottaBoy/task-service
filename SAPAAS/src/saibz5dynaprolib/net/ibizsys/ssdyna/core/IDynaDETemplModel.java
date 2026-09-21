/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.ssdyna.core;

import java.util.Iterator;
import net.ibizsys.ssdyna.core.IDynaDEFormTemplModel;
import net.ibizsys.ssdyna.core.IDynaDETempl;
import net.ibizsys.ssdyna.core.IDynaDEViewTemplModel;

public interface IDynaDETemplModel
extends IDynaDETempl {
    public void registerDynaDEViewTemplModel(IDynaDEViewTemplModel var1) throws Exception;

    public IDynaDEViewTemplModel getDynaDEViewTemplModel(String var1) throws Exception;

    public Iterator<IDynaDEViewTemplModel> getDynaDEViewTemplModels();

    public void registerDynaDEFormTemplModel(IDynaDEFormTemplModel var1) throws Exception;

    public IDynaDEFormTemplModel getDynaDEFormTemplModel(String var1) throws Exception;

    public Iterator<IDynaDEFormTemplModel> getDynaDEFormTemplModels();
}

