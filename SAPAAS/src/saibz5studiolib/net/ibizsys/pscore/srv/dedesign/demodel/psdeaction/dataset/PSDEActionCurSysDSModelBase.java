/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataSet
 *  net.ibizsys.paas.core.DEDataSetQuery
 *  net.ibizsys.paas.demodel.DEDataSetModelBase
 */
package net.ibizsys.pscore.srv.dedesign.demodel.psdeaction.dataset;

import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.demodel.DEDataSetModelBase;

@DEDataSet(id="5F1DD712-CBB3-4A45-8527-BE2EB0DB51AA", name="CurSys", queries={@DEDataSetQuery(queryid="C16C64D4-4F24-4A4D-8FE3-D5AF97684B59", queryname="CurSys")})
public abstract class PSDEActionCurSysDSModelBase
extends DEDataSetModelBase {
    public PSDEActionCurSysDSModelBase() {
        this.initAnnotation(PSDEActionCurSysDSModelBase.class);
    }
}

