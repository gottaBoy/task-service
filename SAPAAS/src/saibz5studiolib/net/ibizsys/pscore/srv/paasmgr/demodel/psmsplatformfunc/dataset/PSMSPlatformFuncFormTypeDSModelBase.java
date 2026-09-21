/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.codelist.ICodeList
 *  net.ibizsys.paas.core.DEDataSet
 *  net.ibizsys.paas.demodel.CodeListDEDataSetModelBase
 *  net.ibizsys.paas.sysmodel.CodeListGlobal
 */
package net.ibizsys.pscore.srv.paasmgr.demodel.psmsplatformfunc.dataset;

import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.demodel.CodeListDEDataSetModelBase;
import net.ibizsys.paas.sysmodel.CodeListGlobal;

@DEDataSet(id="8d0d31ce5222dfaccc9ef168d1de21cd", name="FormType", queries={})
public abstract class PSMSPlatformFuncFormTypeDSModelBase
extends CodeListDEDataSetModelBase {
    public PSMSPlatformFuncFormTypeDSModelBase() {
        this.initAnnotation(PSMSPlatformFuncFormTypeDSModelBase.class);
    }

    protected ICodeList getCodeList() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.MSPlatformFuncTypeCodeListModel");
    }
}

