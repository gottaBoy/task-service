/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.codelist.ICodeList
 *  net.ibizsys.paas.core.DEDataSet
 *  net.ibizsys.paas.demodel.CodeListDEDataSetModelBase
 *  net.ibizsys.paas.sysmodel.CodeListGlobal
 */
package net.ibizsys.pscore.srv.dedesign.demodel.psdeutilde.dataset;

import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.demodel.CodeListDEDataSetModelBase;
import net.ibizsys.paas.sysmodel.CodeListGlobal;

@DEDataSet(id="83b7a21691810e6f484ed2d1352232fb", name="FormType", queries={})
public abstract class PSDEUtilDEFormTypeDSModelBase
extends CodeListDEDataSetModelBase {
    public PSDEUtilDEFormTypeDSModelBase() {
        this.initAnnotation(PSDEUtilDEFormTypeDSModelBase.class);
    }

    protected ICodeList getCodeList() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DEUtilTypeCodeListModel");
    }
}

