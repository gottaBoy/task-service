/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.pssyscanvasmodel.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="ac5773b46176cb60ad958734dcc1e81a", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSYSCANVASMODELID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSYSCANVASMODELNAME", format="")})})
public class PSSysCanvasModelDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSysCanvasModelDefaultACModel() {
        this.initAnnotation(PSSysCanvasModelDefaultACModel.class);
    }
}

