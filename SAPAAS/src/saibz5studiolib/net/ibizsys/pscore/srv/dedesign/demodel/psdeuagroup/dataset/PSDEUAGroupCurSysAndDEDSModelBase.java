/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataSet
 *  net.ibizsys.paas.core.DEDataSetQuery
 *  net.ibizsys.paas.demodel.DEDataSetModelBase
 */
package net.ibizsys.pscore.srv.dedesign.demodel.psdeuagroup.dataset;

import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.demodel.DEDataSetModelBase;

@DEDataSet(id="0439D013-F9D2-4EF2-8662-2DF25EE0E099", name="CurSysAndDE", queries={@DEDataSetQuery(queryid="F8954415-66A2-4483-BDFA-E2C737B80C08", queryname="CurDE"), @DEDataSetQuery(queryid="4AFFA45F-157E-4B8D-B267-BEFC71DC1777", queryname="CurSys")})
public abstract class PSDEUAGroupCurSysAndDEDSModelBase
extends DEDataSetModelBase {
    public PSDEUAGroupCurSysAndDEDSModelBase() {
        this.initAnnotation(PSDEUAGroupCurSysAndDEDSModelBase.class);
    }
}

