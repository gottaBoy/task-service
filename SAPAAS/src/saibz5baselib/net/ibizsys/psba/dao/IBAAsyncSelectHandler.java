/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psba.dao;

import net.ibizsys.paas.core.IAsyncHandler;
import net.ibizsys.psba.entity.IBAEntity;

public interface IBAAsyncSelectHandler
extends IAsyncHandler {
    public void processBAEntity(IBAEntity var1);
}

