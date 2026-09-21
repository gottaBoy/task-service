/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataSet
 *  net.ibizsys.paas.core.DEDataSetQuery
 *  net.ibizsys.paas.demodel.DEDataSetModelBase
 */
package net.ibizsys.pscore.srv.dedesign.demodel.psdeoppriv.dataset;

import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.demodel.DEDataSetModelBase;

@DEDataSet(id="5552E047-D3B5-492C-9BFB-72F998FCBDD7", name="CurSysAndDE", queries={@DEDataSetQuery(queryid="255C30C5-FB63-4AFA-9D49-5FEC7E7654CC", queryname="CurDE"), @DEDataSetQuery(queryid="6A42F4C6-68B5-4CC1-B709-3A028B819DBB", queryname="CurSysNotDE")})
public abstract class PSDEOPPrivCurSysAndDEDSModelBase
extends DEDataSetModelBase {
    public PSDEOPPrivCurSysAndDEDSModelBase() {
        this.initAnnotation(PSDEOPPrivCurSysAndDEDSModelBase.class);
    }
}

