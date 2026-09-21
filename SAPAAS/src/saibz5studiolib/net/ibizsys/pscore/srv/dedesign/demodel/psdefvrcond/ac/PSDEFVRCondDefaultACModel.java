/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.dedesign.demodel.psdefvrcond.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="f37ba0ffaf3c54a95bcf15595893f4cd", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDEFVRCONDID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDEFVRCONDNAME", format="")})})
public class PSDEFVRCondDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDEFVRCondDefaultACModel() {
        this.initAnnotation(PSDEFVRCondDefaultACModel.class);
    }
}

