/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.def.demodel.psv3mggrid.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="2ea4b8fe6109a73135a571676f54f8f0", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSV3MGGRIDID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSV3MGGRIDNAME", format="")})})
public class PSV3MGGridDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSV3MGGridDefaultACModel() {
        this.initAnnotation(PSV3MGGridDefaultACModel.class);
    }
}

