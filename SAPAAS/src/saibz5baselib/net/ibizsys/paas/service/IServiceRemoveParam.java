/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.service;

import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.IServiceActionParam;

public interface IServiceRemoveParam<ET extends IEntity>
extends IServiceActionParam<ET> {
    public boolean isPrepareLast();
}

