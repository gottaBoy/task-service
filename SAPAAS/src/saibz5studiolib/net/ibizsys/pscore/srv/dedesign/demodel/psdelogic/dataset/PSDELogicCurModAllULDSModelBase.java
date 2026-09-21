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

@DEDataSet(id="5FB8BDF0-2F43-498C-B135-60B733A7149F", name="CurModAllUL", queries={@DEDataSetQuery(queryid="7C300408-18BD-487D-AF65-06115ABD0FC6", queryname="CurModNotDEUL"), @DEDataSetQuery(queryid="3598FB84-46CE-474F-B1D2-5ED82C459DCB", queryname="CurModUL")})
public abstract class PSDELogicCurModAllULDSModelBase
extends DEDataSetModelBase {
    public PSDELogicCurModAllULDSModelBase() {
        this.initAnnotation(PSDELogicCurModAllULDSModelBase.class);
    }
}

