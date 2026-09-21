/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.sysmodel.ICodeListModel
 */
package net.ibizsys.paas.sysmodel;

import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.sysmodel.ICodeListModel;
import net.ibizsys.paas.sysmodel.IDynaCodeListModel;

public interface IDynaCodeListModelContainer
extends ICodeListModel {
    public void registerDynaCodeListModel(IDynaCodeListModel var1) throws Exception;

    public void resetCurrentDynaSysInst();

    public void resetAllDynaSysInst();

    public IDynaCodeListModel createDynaCodeListModel(IEntity var1) throws Exception;
}

