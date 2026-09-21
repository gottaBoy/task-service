/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.pswf.core.IWFModel
 */
package net.ibizsys.pswf.core;

import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.pswf.core.IDynaWFVersionModel;
import net.ibizsys.pswf.core.IWFModel;

public interface IDynaWFModel
extends IWFModel {
    public void registerDynaWFVersionModel(IDynaWFVersionModel var1) throws Exception;

    public void resetCurrentDynaSysInst();

    public void resetAllDynaSysInst();

    public IDynaWFVersionModel createDynaWFVersionModel(IEntity var1) throws Exception;
}

