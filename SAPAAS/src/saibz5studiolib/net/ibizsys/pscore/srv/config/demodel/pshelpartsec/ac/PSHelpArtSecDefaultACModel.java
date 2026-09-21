/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.pshelpartsec.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="2674263b2e6d5f364c20bb0faf9b6914", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSHELPARTSECID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSHELPARTSECNAME", format="")})})
public class PSHelpArtSecDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSHelpArtSecDefaultACModel() {
        this.initAnnotation(PSHelpArtSecDefaultACModel.class);
    }
}

