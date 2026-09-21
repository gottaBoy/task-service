/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psba.service;

import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.psba.core.IBASchemeModel;
import net.ibizsys.psba.core.IBATableModel;
import net.ibizsys.psba.dao.IBADAO;
import net.ibizsys.psba.service.IBAService;

public abstract class BAServiceBase
implements IBAService {
    @Override
    public abstract IBASchemeModel getBASchemeModel();

    @Override
    public abstract IBATableModel getBATableModel();

    protected abstract IBADAO getBADAO();

    @Override
    public void importDEData(IEntity et) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }

    protected void onImportDEDataSelfMode(IEntity et) throws Exception {
    }

    protected void onImportDEDataChildMode(IEntity et) throws Exception {
    }
}

