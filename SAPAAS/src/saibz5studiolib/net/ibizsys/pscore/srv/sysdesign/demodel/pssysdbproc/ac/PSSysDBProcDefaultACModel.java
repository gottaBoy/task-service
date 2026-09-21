/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.pssysdbproc.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="9b2b55334eb07df5a1bd0059d8637850", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSYSDBPROCID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSYSDBPROCNAME", format="")})})
public class PSSysDBProcDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSysDBProcDefaultACModel() {
        this.initAnnotation(PSSysDBProcDefaultACModel.class);
    }
}

