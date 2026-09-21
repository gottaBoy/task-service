/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.psmavenservertype.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="59b8bd49b9cc97f71925e5a786c933d8", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSMAVENSERVERTYPEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSMAVENSERVERTYPENAME", format="")})})
public class PSMavenServerTypeDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSMavenServerTypeDefaultACModel() {
        this.initAnnotation(PSMavenServerTypeDefaultACModel.class);
    }
}

