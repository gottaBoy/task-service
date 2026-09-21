/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.saas.dao.DAOBase
 */
package net.ibizsys.ssdyna.dao;

import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.ssdyna.dao.IDynaDAO;
import net.ibizsys.ssdyna.demodel.IDynaDEModel;

public abstract class DAOBase<ET extends IEntity>
extends net.ibizsys.saas.dao.DAOBase<ET>
implements IDynaDAO<ET> {
    @Override
    public boolean isDynaDETemplMode() {
        if (this.getDEModel() instanceof IDynaDEModel) {
            return ((IDynaDEModel)this.getDEModel()).isDynaDETemplMode();
        }
        return false;
    }
}

