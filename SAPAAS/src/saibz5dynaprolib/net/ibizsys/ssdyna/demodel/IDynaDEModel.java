/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.dataentity.IPSDataEntity
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.saas.demodel.ISaaSDEModel
 */
package net.ibizsys.ssdyna.demodel;

import net.ibizsys.model.dataentity.IPSDataEntity;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.saas.demodel.ISaaSDEModel;
import net.ibizsys.ssdyna.sysmodel.IDynaSysModel;

public interface IDynaDEModel<ET extends IEntity>
extends ISaaSDEModel<ET> {
    public void init(IDynaSysModel var1, IPSDataEntity var2) throws Exception;

    public IDynaSysModel getDynaSysModel();

    public boolean isDynaDETemplMode();
}

