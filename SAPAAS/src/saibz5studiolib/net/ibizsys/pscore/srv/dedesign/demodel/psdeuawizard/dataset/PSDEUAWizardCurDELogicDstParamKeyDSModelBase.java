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

@DEDataSet(id="9B46B156-A2F3-4466-83DC-DAD477210B7D", name="CurDELogicDstParamKey", queries={})
public abstract class PSDEUAWizardCurDELogicDstParamKeyDSModelBase
extends CodeListDEDataSetModelBase {
    public PSDEUAWizardCurDELogicDstParamKeyDSModelBase() {
        this.initAnnotation(PSDEUAWizardCurDELogicDstParamKeyDSModelBase.class);
    }

    protected ICodeList getCodeList() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.EmtpyCodeListModel");
    }
}

