/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.pssysmaplogic.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="8ae8b50f9a399dadd44edde733e57a9c", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSYSMAPLOGICID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSYSMAPLOGICNAME", format="")})})
public class PSSysMapLogicDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSysMapLogicDefaultACModel() {
        this.initAnnotation(PSSysMapLogicDefaultACModel.class);
    }
}

