/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.IDEDataSetFetchContext
 *  net.ibizsys.paas.db.DBFetchResult
 */
package net.ibizsys.pscore.srv.devcenter.demodel.psdevcenterdbinst.dataset;

import net.ibizsys.paas.core.IDEDataSetFetchContext;
import net.ibizsys.paas.db.DBFetchResult;
import net.ibizsys.pscore.srv.devcenter.demodel.psdevcenterdbinst.dataset.PSDevCenterDBInstCurDBTableDSModel;
import net.ibizsys.pscore.srv.devcenter.demodel.psdevcenterdbinst.dataset.PSDevCenterDBInstCurDBViewDSModelBase;

public class PSDevCenterDBInstCurDBViewDSModel
extends PSDevCenterDBInstCurDBViewDSModelBase {
    public DBFetchResult fetchDEDataSet(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        return PSDevCenterDBInstCurDBTableDSModel.fetchDEDataSet(iDEDataSetFetchContext, "GETVIEWS");
    }
}

