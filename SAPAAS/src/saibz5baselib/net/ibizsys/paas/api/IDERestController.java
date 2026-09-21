/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.api;

import net.ibizsys.paas.api.IRestController;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.service.IService;

public interface IDERestController
extends IRestController {
    public IService getService();

    public IDataEntityModel getDEModel();
}

