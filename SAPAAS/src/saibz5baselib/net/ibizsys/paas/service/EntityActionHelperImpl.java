/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.service;

import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.entity.IEntityActionHelper;
import net.ibizsys.paas.service.IService;

public class EntityActionHelperImpl
implements IEntityActionHelper {
    private IService iService = null;

    public void init(IService iService) throws Exception {
        this.iService = iService;
    }

    @Override
    public void create(IEntity iEntity) throws Exception {
        this.iService.create(iEntity);
    }

    @Override
    public void update(IEntity iEntity) throws Exception {
        this.iService.update(iEntity);
    }

    @Override
    public void save(IEntity iEntity) throws Exception {
        this.iService.save(iEntity);
    }

    @Override
    public void remove(IEntity iEntity) throws Exception {
        this.iService.remove(iEntity);
    }

    @Override
    public boolean get(IEntity iEntity, boolean bTryMode) throws Exception {
        return this.iService.get(iEntity, bTryMode);
    }

    @Override
    public boolean select(IEntity iEntity, boolean bTryMode) throws Exception {
        return this.iService.select(iEntity, bTryMode);
    }
}

