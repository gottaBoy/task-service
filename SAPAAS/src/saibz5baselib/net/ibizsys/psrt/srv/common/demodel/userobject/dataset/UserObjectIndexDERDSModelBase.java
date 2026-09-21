/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.common.demodel.userobject.dataset;

import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.demodel.CodeListDEDataSetModelBase;
import net.ibizsys.paas.sysmodel.CodeListGlobal;

@DEDataSet(id="e560c77eda8c75691964f30fa7b826c7", name="IndexDER", queries={})
public abstract class UserObjectIndexDERDSModelBase
extends CodeListDEDataSetModelBase {
    public UserObjectIndexDERDSModelBase() {
        this.initAnnotation(UserObjectIndexDERDSModelBase.class);
    }

    @Override
    protected ICodeList getCodeList() throws Exception {
        return CodeListGlobal.getCodeList("net.ibizsys.psrt.srv.codelist.CodeList5CodeListModel");
    }
}

