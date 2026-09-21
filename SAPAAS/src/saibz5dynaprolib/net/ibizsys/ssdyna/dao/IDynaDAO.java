/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.saas.dao.ISaaSDAO
 */
package net.ibizsys.ssdyna.dao;

import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.saas.dao.ISaaSDAO;

public interface IDynaDAO<ET extends IEntity>
extends ISaaSDAO<ET> {
    public boolean isDynaDETemplMode();
}

