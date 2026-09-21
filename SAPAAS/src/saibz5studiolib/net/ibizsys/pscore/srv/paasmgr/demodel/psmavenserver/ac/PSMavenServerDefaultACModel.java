/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.paasmgr.demodel.psmavenserver.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="a4303a87e37289e8bc9fb141c5950b49", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSMAVENSERVERID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSMAVENSERVERNAME", format="")})})
public class PSMavenServerDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSMavenServerDefaultACModel() {
        this.initAnnotation(PSMavenServerDefaultACModel.class);
    }
}

