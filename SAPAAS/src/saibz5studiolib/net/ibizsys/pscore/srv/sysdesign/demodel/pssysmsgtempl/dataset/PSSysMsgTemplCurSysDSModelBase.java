/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataSet
 *  net.ibizsys.paas.core.DEDataSetQuery
 *  net.ibizsys.paas.demodel.DEDataSetModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.pssysmsgtempl.dataset;

import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.demodel.DEDataSetModelBase;

@DEDataSet(id="00D632F2-C755-4A4A-9D3A-3492307F107B", name="CurSys", queries={@DEDataSetQuery(queryid="C801C41D-40B3-460B-814B-40473A1A32BC", queryname="CurSys")})
public abstract class PSSysMsgTemplCurSysDSModelBase
extends DEDataSetModelBase {
    public PSSysMsgTemplCurSysDSModelBase() {
        this.initAnnotation(PSSysMsgTemplCurSysDSModelBase.class);
    }
}

