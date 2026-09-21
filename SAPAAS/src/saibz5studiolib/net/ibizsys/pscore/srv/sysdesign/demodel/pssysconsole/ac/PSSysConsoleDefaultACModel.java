/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.pssysconsole.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="90364d3d8adad1bbeb4e529bd86dd731", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSYSCONSOLEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSYSCONSOLENAME", format="")})})
public class PSSysConsoleDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSysConsoleDefaultACModel() {
        this.initAnnotation(PSSysConsoleDefaultACModel.class);
    }
}

