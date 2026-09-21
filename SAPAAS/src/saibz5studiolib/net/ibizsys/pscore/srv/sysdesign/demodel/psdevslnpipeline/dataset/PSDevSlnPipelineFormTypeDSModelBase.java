/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.codelist.ICodeList
 *  net.ibizsys.paas.core.DEDataSet
 *  net.ibizsys.paas.demodel.CodeListDEDataSetModelBase
 *  net.ibizsys.paas.sysmodel.CodeListGlobal
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.psdevslnpipeline.dataset;

import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.demodel.CodeListDEDataSetModelBase;
import net.ibizsys.paas.sysmodel.CodeListGlobal;

@DEDataSet(id="1ae553511218c73a13a82c00c02bd0a5", name="FormType", queries={})
public abstract class PSDevSlnPipelineFormTypeDSModelBase
extends CodeListDEDataSetModelBase {
    public PSDevSlnPipelineFormTypeDSModelBase() {
        this.initAnnotation(PSDevSlnPipelineFormTypeDSModelBase.class);
    }

    protected ICodeList getCodeList() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.PipelineTypeCodeListModel");
    }
}

