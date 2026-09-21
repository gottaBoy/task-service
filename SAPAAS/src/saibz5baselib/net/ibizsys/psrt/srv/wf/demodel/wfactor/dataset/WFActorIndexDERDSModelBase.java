/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.wf.demodel.wfactor.dataset;

import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.demodel.CodeListDEDataSetModelBase;
import net.ibizsys.paas.sysmodel.CodeListGlobal;

@DEDataSet(id="d7e9d51ebd8eee667063d9a75cf2455a", name="IndexDER", queries={})
public abstract class WFActorIndexDERDSModelBase
extends CodeListDEDataSetModelBase {
    public WFActorIndexDERDSModelBase() {
        this.initAnnotation(WFActorIndexDERDSModelBase.class);
    }

    @Override
    protected ICodeList getCodeList() throws Exception {
        return CodeListGlobal.getCodeList("net.ibizsys.psrt.srv.codelist.WFActorTypeCodeListModel");
    }
}

