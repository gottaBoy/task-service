/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.demodel.IDataEntityModel
 *  net.ibizsys.paas.entity.IEntity
 */
package net.ibizsys.pscore.srv.core;

import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.pscore.srv.core.IPSDEFGroupModel;
import net.ibizsys.pscore.srv.core.IPSDEFieldModel;

public interface IPSDataEntityModel<ET extends IEntity>
extends IDataEntityModel<ET> {
    public String getMemo();

    public IPSDEFGroupModel getPSDEFGroupModel(String var1, boolean var2) throws Exception;

    public String getCodeName();

    public String getServiceCodeName();

    public IPSDEFieldModel getDEField(String var1, boolean var2) throws Exception;

    public IPSDEFieldModel getKeyDEField();

    public boolean isTranslateDEFieldServiceCodeName();
}

