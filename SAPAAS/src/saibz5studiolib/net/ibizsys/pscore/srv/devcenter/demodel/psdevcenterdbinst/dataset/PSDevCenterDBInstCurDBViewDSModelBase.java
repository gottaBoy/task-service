/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.codelist.ICodeList
 *  net.ibizsys.paas.core.DEDataSet
 *  net.ibizsys.paas.demodel.CodeListDEDataSetModelBase
 *  net.ibizsys.paas.sysmodel.CodeListGlobal
 */
package net.ibizsys.pscore.srv.devcenter.demodel.psdevcenterdbinst.dataset;

import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.demodel.CodeListDEDataSetModelBase;
import net.ibizsys.paas.sysmodel.CodeListGlobal;

@DEDataSet(id="2B251FE8-291C-40DE-A3E4-21F26D1B97C1", name="CurDBView", queries={})
public abstract class PSDevCenterDBInstCurDBViewDSModelBase
extends CodeListDEDataSetModelBase {
    public PSDevCenterDBInstCurDBViewDSModelBase() {
        this.initAnnotation(PSDevCenterDBInstCurDBViewDSModelBase.class);
    }

    protected ICodeList getCodeList() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
    }
}

