/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.pssyscontent.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="34d978d10eb9aa7fc1486a8d896feb22", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSYSCONTENTID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSYSCONTENTNAME", format="")})})
public class PSSysContentDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSysContentDefaultACModel() {
        this.initAnnotation(PSSysContentDefaultACModel.class);
    }
}

