/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.dedesign.demodel.psdetreenode.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="dd2e58dcdf452ead721f5ba437039c39", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDETREENODEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDETREENODENAME", format="")})})
public class PSDETreeNodeDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDETreeNodeDefaultACModel() {
        this.initAnnotation(PSDETreeNodeDefaultACModel.class);
    }
}

