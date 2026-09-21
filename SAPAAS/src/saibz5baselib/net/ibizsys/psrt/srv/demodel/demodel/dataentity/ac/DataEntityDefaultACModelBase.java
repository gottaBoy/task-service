/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.demodel.demodel.dataentity.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="0cbbb4ccda4e86a9e6f16ed5f3a171c2", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="DEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="DENAME", format="")})})
public abstract class DataEntityDefaultACModelBase
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public DataEntityDefaultACModelBase() {
        this.initAnnotation(DataEntityDefaultACModelBase.class);
    }
}

