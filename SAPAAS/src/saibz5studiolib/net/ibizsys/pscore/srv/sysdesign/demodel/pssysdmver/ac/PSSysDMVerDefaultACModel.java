/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.pssysdmver.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="4953874f99735059cfe1dbd264ddd6cd", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSYSDMVERID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSYSDMVERNAME", format="")})})
public class PSSysDMVerDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSysDMVerDefaultACModel() {
        this.initAnnotation(PSSysDMVerDefaultACModel.class);
    }
}

