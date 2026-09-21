/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.codelist.IPSCodeList
 *  net.ibizsys.paas.data.impl.DataItemParamImpl
 */
package net.ibizsys.model.data;

import net.ibizsys.model.codelist.IPSCodeList;
import net.ibizsys.model.data.IPSDataItemParam;
import net.ibizsys.paas.data.impl.DataItemParamImpl;

public class PSDataItemParamImpl
extends DataItemParamImpl
implements IPSDataItemParam {
    private IPSCodeList iPSCodeList = null;

    @Override
    public IPSCodeList getPSCodeList() {
        return this.iPSCodeList;
    }

    public void setPSCodeList(IPSCodeList iPSCodeList) {
        this.iPSCodeList = iPSCodeList;
    }
}

