/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.codelist.ICodeList
 *  net.ibizsys.paas.core.DEDataSet
 *  net.ibizsys.paas.demodel.CodeListDEDataSetModelBase
 *  net.ibizsys.paas.sysmodel.CodeListGlobal
 */
package net.ibizsys.pscore.srv.devcenter.demodel.psdcsyncdata.dataset;

import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.demodel.CodeListDEDataSetModelBase;
import net.ibizsys.paas.sysmodel.CodeListGlobal;

@DEDataSet(id="192050d287e9353d9f5274d5e21b3287", name="FormType", queries={})
public abstract class PSDCSyncDataFormTypeDSModelBase
extends CodeListDEDataSetModelBase {
    public PSDCSyncDataFormTypeDSModelBase() {
        this.initAnnotation(PSDCSyncDataFormTypeDSModelBase.class);
    }

    protected ICodeList getCodeList() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DCSyncDataTypeCodeListModel");
    }
}

