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

@DEDataSet(id="16D55027-9579-4422-857C-3C2B50E5BF98", name="CurDELogicSrcParamKey", queries={})
public abstract class PSDEUAWizardCurDELogicSrcParamKeyDSModelBase
extends CodeListDEDataSetModelBase {
    public PSDEUAWizardCurDELogicSrcParamKeyDSModelBase() {
        this.initAnnotation(PSDEUAWizardCurDELogicSrcParamKeyDSModelBase.class);
    }

    protected ICodeList getCodeList() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.EmtpyCodeListModel");
    }
}

