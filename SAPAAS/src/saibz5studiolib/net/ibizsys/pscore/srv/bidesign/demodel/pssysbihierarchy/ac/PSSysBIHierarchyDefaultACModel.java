/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.bidesign.demodel.pssysbihierarchy.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="be37de262514ea9d123296fa0454fa4a", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSYSBIHIERARCHYID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSYSBIHIERARCHYNAME", format="")})})
public class PSSysBIHierarchyDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSysBIHierarchyDefaultACModel() {
        this.initAnnotation(PSSysBIHierarchyDefaultACModel.class);
    }
}

