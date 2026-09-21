/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.IModelBase2
 */
package net.ibizsys.pscore.srv.core;

import java.util.Iterator;
import net.ibizsys.paas.core.IModelBase2;
import net.ibizsys.pscore.srv.core.IPSDEFGroupDetailModel;

public interface IPSDEFGroupModel
extends IModelBase2 {
    public String getMemo();

    public Iterator<IPSDEFGroupDetailModel> getPSDEFGroupDetailModels();

    public IPSDEFGroupDetailModel getPSDEFGroupDetailModel(String var1, boolean var2) throws Exception;
}

