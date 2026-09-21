/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.dataentity.ds.IPSDEDataSet
 *  net.ibizsys.paas.codelist.ICodeList
 *  net.ibizsys.paas.core.IDataEntity
 *  net.ibizsys.paas.demodel.CodeListDEDataSetModelBase
 */
package net.ibizsys.ssdyna.demodel;

import net.ibizsys.model.dataentity.ds.IPSDEDataSet;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.core.IDataEntity;
import net.ibizsys.paas.demodel.CodeListDEDataSetModelBase;
import net.ibizsys.ssdyna.demodel.IDynaDEModel;

public class DynaCodeListDEDataSetModel
extends CodeListDEDataSetModelBase {
    private IDynaDEModel iDynaDEModel = null;
    private IPSDEDataSet iPSDEDataSet = null;

    public void init(IDynaDEModel iDynaDEModel, IPSDEDataSet iPSDEDataSet) throws Exception {
        this.iDynaDEModel = iDynaDEModel;
        this.iPSDEDataSet = iPSDEDataSet;
        this.strId = this.iPSDEDataSet.getId();
        this.strName = this.iPSDEDataSet.getName();
        this.init((IDataEntity)iDynaDEModel);
    }

    public String getId() {
        return this.strId;
    }

    public String getName() {
        return this.strName;
    }

    protected ICodeList getCodeList() throws Exception {
        return null;
    }
}

