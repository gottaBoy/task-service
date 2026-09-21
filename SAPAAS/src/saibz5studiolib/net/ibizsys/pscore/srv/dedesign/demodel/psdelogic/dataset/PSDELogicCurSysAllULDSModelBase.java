/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataSet
 *  net.ibizsys.paas.core.DEDataSetQuery
 *  net.ibizsys.paas.demodel.DEDataSetModelBase
 */
package net.ibizsys.pscore.srv.dedesign.demodel.psdelogic.dataset;

import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.demodel.DEDataSetModelBase;

@DEDataSet(id="F430A935-3871-4187-A729-F47D1FD986F9", name="CurSysAllUL", queries={@DEDataSetQuery(queryid="08719070-3F76-4160-B8D4-0CA65481000E", queryname="CurSysNotDEUL"), @DEDataSetQuery(queryid="6DA2221E-107F-4D0A-8FB2-548592F18202", queryname="CurSysUL")})
public abstract class PSDELogicCurSysAllULDSModelBase
extends DEDataSetModelBase {
    public PSDELogicCurSysAllULDSModelBase() {
        this.initAnnotation(PSDELogicCurSysAllULDSModelBase.class);
    }
}

