/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.dao.DAOBase
 *  net.ibizsys.paas.demodel.IDataEntityModel
 */
package SA.SRFDA.PS.Core.JIT.DAO;

import SA.SRFDA.PS.Core.JIT.DEModel.IPSJITDEModel;
import SA.SRFDA.PS.Core.JIT.Entity.PSJITEntity;
import net.ibizsys.paas.dao.DAOBase;
import net.ibizsys.paas.demodel.IDataEntityModel;

public class PSJITDAO
extends DAOBase<PSJITEntity> {
    private IPSJITDEModel<PSJITEntity> iPSJITDEModel = null;

    public void init(IPSJITDEModel<PSJITEntity> iPSJITDEModel) throws Exception {
        this.iPSJITDEModel = iPSJITDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.iPSJITDEModel;
    }
}

