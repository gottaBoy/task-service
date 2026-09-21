/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.demodel;

import net.ibizsys.paas.core.IDER1N;
import net.ibizsys.paas.demodel.IDataEntityModel;

public interface IDER1NModel
extends IDER1N {
    public IDataEntityModel getMajorDEModel() throws Exception;

    public IDataEntityModel getMinorDEModel() throws Exception;
}

