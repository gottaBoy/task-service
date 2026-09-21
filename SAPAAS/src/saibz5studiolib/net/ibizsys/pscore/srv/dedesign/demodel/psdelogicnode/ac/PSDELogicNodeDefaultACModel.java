/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.dedesign.demodel.psdelogicnode.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="98176886535e472a4018b37dc7a2d26f", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDELOGICNODEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDELOGICNODENAME", format="")})})
public class PSDELogicNodeDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDELogicNodeDefaultACModel() {
        this.initAnnotation(PSDELogicNodeDefaultACModel.class);
    }
}

