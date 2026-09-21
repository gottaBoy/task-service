/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.pssystemas.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="0609ba535aa7e8633ce68e72aa7f58b4", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSYSTEMASID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSYSTEMASNAME", format="")})})
public class PSSystemASDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSystemASDefaultACModel() {
        this.initAnnotation(PSSystemASDefaultACModel.class);
    }
}

