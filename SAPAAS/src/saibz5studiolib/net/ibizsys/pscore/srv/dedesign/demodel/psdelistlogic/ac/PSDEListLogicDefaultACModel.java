/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.dedesign.demodel.psdelistlogic.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="93e462b5ae14281338147996788c827e", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDELISTLOGICID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDELISTLOGICNAME", format="")})})
public class PSDEListLogicDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDEListLogicDefaultACModel() {
        this.initAnnotation(PSDEListLogicDefaultACModel.class);
    }
}

