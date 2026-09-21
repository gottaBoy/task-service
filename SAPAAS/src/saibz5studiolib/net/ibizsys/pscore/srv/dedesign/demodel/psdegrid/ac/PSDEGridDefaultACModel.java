/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.dedesign.demodel.psdegrid.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="9492821fdc8cdf0cec0c0095099a513c", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDEGRIDID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDEGRIDNAME", format="")})})
public class PSDEGridDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDEGridDefaultACModel() {
        this.initAnnotation(PSDEGridDefaultACModel.class);
    }
}

