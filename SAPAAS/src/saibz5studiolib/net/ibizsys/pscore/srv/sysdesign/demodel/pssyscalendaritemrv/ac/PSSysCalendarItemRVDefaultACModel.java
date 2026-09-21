/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.pssyscalendaritemrv.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="9d641b80b7d203c20b884862cf401544", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSYSCALENDARITEMRVID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSYSCALENDARITEMRVNAME", format="")})})
public class PSSysCalendarItemRVDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSysCalendarItemRVDefaultACModel() {
        this.initAnnotation(PSSysCalendarItemRVDefaultACModel.class);
    }
}

