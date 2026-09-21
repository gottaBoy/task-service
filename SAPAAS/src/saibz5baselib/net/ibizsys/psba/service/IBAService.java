/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psba.service;

import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.psba.core.IBASchemeModel;
import net.ibizsys.psba.core.IBATableModel;

public interface IBAService {
    public IBASchemeModel getBASchemeModel();

    public IBATableModel getBATableModel();

    public void importDEData(IEntity var1) throws Exception;
}

