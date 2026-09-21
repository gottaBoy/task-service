/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.psdertaw.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="c6fe7302cd7bac6cbc8418f0c2d2a3f5", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDERTAWID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDERTAWNAME", format="")})})
public class PSDERTAWDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDERTAWDefaultACModel() {
        this.initAnnotation(PSDERTAWDefaultACModel.class);
    }
}

