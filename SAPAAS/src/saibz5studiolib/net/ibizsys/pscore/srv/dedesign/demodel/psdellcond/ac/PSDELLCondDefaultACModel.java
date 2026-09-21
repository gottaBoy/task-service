/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.dedesign.demodel.psdellcond.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="9a62552af7b8412dcfa665f5fdc8f010", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDELLCONDID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDELLCONDNAME", format="")})})
public class PSDELLCondDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDELLCondDefaultACModel() {
        this.initAnnotation(PSDELLCondDefaultACModel.class);
    }
}

