/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.dedesign.demodel.psdetreenoderv.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="74095bc4bc346822c3eefb98d1bcf696", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDETREENODERVID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDETREENODERVNAME", format="")})})
public class PSDETreeNodeRVDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDETreeNodeRVDefaultACModel() {
        this.initAnnotation(PSDETreeNodeRVDefaultACModel.class);
    }
}

