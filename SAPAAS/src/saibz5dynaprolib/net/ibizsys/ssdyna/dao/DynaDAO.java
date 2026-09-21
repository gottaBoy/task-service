/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.demodel.IDataEntityModel
 */
package net.ibizsys.ssdyna.dao;

import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.ssdyna.dao.DAOBase;
import net.ibizsys.ssdyna.demodel.IDynaDEModel;
import net.ibizsys.ssdyna.entity.DynaEntity;

public class DynaDAO
extends DAOBase<DynaEntity> {
    private IDynaDEModel<DynaEntity> iDynaDEModel = null;

    public void init(IDynaDEModel<DynaEntity> iDynaDEModel) throws Exception {
        this.iDynaDEModel = iDynaDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.iDynaDEModel;
    }
}

