/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.dynasys.demodel.dsdynawf.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="94ed000542e335afa0722bc1cbfdf279", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="DSDYNAWFID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="DSDYNAWFNAME", format="")})})
public abstract class DSDynaWFDefaultACModelBase
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public DSDynaWFDefaultACModelBase() {
        this.initAnnotation(DSDynaWFDefaultACModelBase.class);
    }
}

