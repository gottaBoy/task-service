/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.IDEDataSetFetchContext
 *  net.ibizsys.paas.db.DBFetchResult
 */
package net.ibizsys.pscore.srv.dedesign.demodel.psdeuawizard.dataset;

import net.ibizsys.paas.core.IDEDataSetFetchContext;
import net.ibizsys.paas.db.DBFetchResult;
import net.ibizsys.pscore.srv.dedesign.demodel.psdeuawizard.dataset.PSDEUAWizardCurDEMSState2ValueDSModelBase;
import net.ibizsys.pscore.srv.dedesign.demodel.psdeuawizard.dataset.PSDEUAWizardCurDEMSStateValueDSModel;

public class PSDEUAWizardCurDEMSState2ValueDSModel
extends PSDEUAWizardCurDEMSState2ValueDSModelBase {
    public DBFetchResult fetchDEDataSet(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        return PSDEUAWizardCurDEMSStateValueDSModel.fetchDEDataSet(iDEDataSetFetchContext, 2);
    }
}

