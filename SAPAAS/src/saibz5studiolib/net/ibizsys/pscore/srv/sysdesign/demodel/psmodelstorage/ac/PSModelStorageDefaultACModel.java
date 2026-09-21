/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.psmodelstorage.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="7a740e56566ed353b59de22a37f6b8de", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSMODELSTORAGEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSMODELSTORAGENAME", format="")})})
public class PSModelStorageDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSModelStorageDefaultACModel() {
        this.initAnnotation(PSModelStorageDefaultACModel.class);
    }
}

