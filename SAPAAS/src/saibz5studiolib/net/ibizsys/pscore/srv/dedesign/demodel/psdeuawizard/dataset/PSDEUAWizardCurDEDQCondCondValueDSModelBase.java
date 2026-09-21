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

@DEDataSet(id="A3360C2C-E46B-44F8-A6CA-52BFE6776B82", name="CurDEDQCondCondValue", queries={})
public abstract class PSDEUAWizardCurDEDQCondCondValueDSModelBase
extends CodeListDEDataSetModelBase {
    public PSDEUAWizardCurDEDQCondCondValueDSModelBase() {
        this.initAnnotation(PSDEUAWizardCurDEDQCondCondValueDSModelBase.class);
    }

    protected ICodeList getCodeList() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.EmtpyCodeListModel");
    }
}

