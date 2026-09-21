/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataSet
 *  net.ibizsys.paas.core.DEDataSetQuery
 *  net.ibizsys.paas.demodel.DEDataSetModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.pssfachandler.dataset;

import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.demodel.DEDataSetModelBase;

@DEDataSet(id="56BD9D47-51ED-42B0-845C-333293683B07", name="CurSF", queries={@DEDataSetQuery(queryid="262863D8-6C62-426B-A437-00F6BBD01C31", queryname="CurSF")})
public abstract class PSSFACHandlerCurSFDSModelBase
extends DEDataSetModelBase {
    public PSSFACHandlerCurSFDSModelBase() {
        this.initAnnotation(PSSFACHandlerCurSFDSModelBase.class);
    }
}

