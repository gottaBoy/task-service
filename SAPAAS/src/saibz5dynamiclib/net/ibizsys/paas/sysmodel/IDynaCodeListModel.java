/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.sysmodel.ICodeListModel
 */
package net.ibizsys.paas.sysmodel;

import net.ibizsys.paas.core.IDynaModelJsonLoader;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.sysmodel.ICodeListModel;
import net.ibizsys.paas.sysmodel.IDynaCodeListModelContainer;

public interface IDynaCodeListModel
extends ICodeListModel,
IDynaModelJsonLoader {
    public void init(IDynaCodeListModelContainer var1, IEntity var2) throws Exception;

    public String getDynaInstId();
}

