/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.pswf.core.IWFProcessModel
 */
package net.ibizsys.pswf.core;

import java.util.Iterator;
import net.ibizsys.pswf.core.IWFEmbedWFReturnModel;
import net.ibizsys.pswf.core.IWFProcSubWFModel;
import net.ibizsys.pswf.core.IWFProcessModel;

public interface IWFEmbedWFProcessModelBase
extends IWFProcessModel {
    public IWFEmbedWFReturnModel getWFEmbedWFReturnModelByValue(String var1, boolean var2) throws Exception;

    public Iterator<IWFProcSubWFModel> getWFProcSubWFModels();
}

