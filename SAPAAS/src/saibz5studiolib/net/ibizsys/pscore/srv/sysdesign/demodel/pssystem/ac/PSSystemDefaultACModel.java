/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.pssystem.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="46d10302ef3fd53acb2dbbfec480e7f5", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSYSTEMID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSYSTEMNAME", format="")})})
public class PSSystemDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSystemDefaultACModel() {
        this.initAnnotation(PSSystemDefaultACModel.class);
    }
}

