/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.IDEDataSetFetchContext
 *  net.ibizsys.paas.db.DBFetchResult
 */
package net.ibizsys.pscore.srv.devcenter.demodel.psdcdbview.dataset;

import net.ibizsys.paas.core.IDEDataSetFetchContext;
import net.ibizsys.paas.db.DBFetchResult;
import net.ibizsys.pscore.srv.devcenter.demodel.psdcdbtable.dataset.PSDCDBTableCurDBDSModel;
import net.ibizsys.pscore.srv.devcenter.demodel.psdcdbview.dataset.PSDCDBViewCurDBDSModelBase;

public class PSDCDBViewCurDBDSModel
extends PSDCDBViewCurDBDSModelBase {
    public DBFetchResult fetchDEDataSet(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        return PSDCDBTableCurDBDSModel.fetchDEDataSet(iDEDataSetFetchContext, "GETVIEWS", this.getDEModel());
    }
}

