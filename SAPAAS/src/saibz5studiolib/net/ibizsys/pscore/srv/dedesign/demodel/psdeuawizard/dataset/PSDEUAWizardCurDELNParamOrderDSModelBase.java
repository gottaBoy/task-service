/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.codelist.ICodeList
 *  net.ibizsys.paas.core.DEDataSet
 *  net.ibizsys.paas.demodel.CodeListDEDataSetModelBase
 *  net.ibizsys.paas.sysmodel.CodeListGlobal
 */
package net.ibizsys.pscore.srv.dedesign.demodel.psdeuawizard.dataset;

import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.demodel.CodeListDEDataSetModelBase;
import net.ibizsys.paas.sysmodel.CodeListGlobal;

@DEDataSet(id="D479AF71-4C91-4182-AE66-3FE6C41D2358", name="CurDELNParamOrder", queries={})
public abstract class PSDEUAWizardCurDELNParamOrderDSModelBase
extends CodeListDEDataSetModelBase {
    public PSDEUAWizardCurDELNParamOrderDSModelBase() {
        this.initAnnotation(PSDEUAWizardCurDELNParamOrderDSModelBase.class);
    }

    protected ICodeList getCodeList() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.EmtpyCodeListModel");
    }
}

