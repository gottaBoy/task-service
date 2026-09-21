/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.dedesign.demodel.psder.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="cd0e76e3551b2d95646054aafa51562a", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDERID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDERNAME", format="")})})
public class PSDERDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDERDefaultACModel() {
        this.initAnnotation(PSDERDefaultACModel.class);
    }
}

