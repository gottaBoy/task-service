/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataSet
 *  net.ibizsys.paas.core.DEDataSetQuery
 *  net.ibizsys.paas.demodel.DEDataSetModelBase
 */
package net.ibizsys.pscore.srv.dedesign.demodel.psdetoolbar.dataset;

import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.demodel.DEDataSetModelBase;

@DEDataSet(id="B768A6E1-DE25-4943-BD31-33997CE928B3", name="SysAndDERange", queries={@DEDataSetQuery(queryid="6A8B7AD7-6EAA-42B2-B117-0CABA7C16D04", queryname="DERange"), @DEDataSetQuery(queryid="2D51C359-97CA-4BBC-A3D1-EF3B95B3B871", queryname="SysRange")})
public abstract class PSDEToolbarSysAndDERangeDSModelBase
extends DEDataSetModelBase {
    public PSDEToolbarSysAndDERangeDSModelBase() {
        this.initAnnotation(PSDEToolbarSysAndDERangeDSModelBase.class);
    }
}

