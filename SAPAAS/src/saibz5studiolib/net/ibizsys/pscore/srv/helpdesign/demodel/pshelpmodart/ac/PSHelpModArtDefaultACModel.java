/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.helpdesign.demodel.pshelpmodart.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="32ca010c679e37a20d9115a11cfd8dd0", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSHELPMODARTID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSHELPMODARTNAME", format="")})})
public class PSHelpModArtDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSHelpModArtDefaultACModel() {
        this.initAnnotation(PSHelpModArtDefaultACModel.class);
    }
}

