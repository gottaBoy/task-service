/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.codelist.ICodeList
 *  net.ibizsys.paas.core.DEDataSet
 *  net.ibizsys.paas.demodel.CodeListDEDataSetModelBase
 *  net.ibizsys.paas.sysmodel.CodeListGlobal
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.psdevslnpipelinestep.dataset;

import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.demodel.CodeListDEDataSetModelBase;
import net.ibizsys.paas.sysmodel.CodeListGlobal;

@DEDataSet(id="07b853268d95ab06c8d94ecf3b820faa", name="FormType", queries={})
public abstract class PSDevSlnPipelineStepFormTypeDSModelBase
extends CodeListDEDataSetModelBase {
    public PSDevSlnPipelineStepFormTypeDSModelBase() {
        this.initAnnotation(PSDevSlnPipelineStepFormTypeDSModelBase.class);
    }

    protected ICodeList getCodeList() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.PipelineStepTypeCodeListModel");
    }
}

