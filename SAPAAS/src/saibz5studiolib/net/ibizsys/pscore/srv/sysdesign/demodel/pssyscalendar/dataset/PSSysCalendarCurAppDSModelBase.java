/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataSet
 *  net.ibizsys.paas.core.DEDataSetQuery
 *  net.ibizsys.paas.demodel.DEDataSetModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.pssyscalendar.dataset;

import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.demodel.DEDataSetModelBase;

@DEDataSet(id="000FA16F-2A78-4F2C-8285-F6B7DCA8DD75", name="CurApp", queries={@DEDataSetQuery(queryid="000FA16F-2A78-4F2C-8285-F6B7DCA8DD75", queryname="CurApp")})
public abstract class PSSysCalendarCurAppDSModelBase
extends DEDataSetModelBase {
    public PSSysCalendarCurAppDSModelBase() {
        this.initAnnotation(PSSysCalendarCurAppDSModelBase.class);
    }
}

