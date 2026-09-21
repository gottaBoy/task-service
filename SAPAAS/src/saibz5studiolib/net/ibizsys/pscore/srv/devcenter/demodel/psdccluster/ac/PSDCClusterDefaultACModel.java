/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.devcenter.demodel.psdccluster.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="b1eb5cfde47d35dd2fe1b3daea232bd6", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDCCLUSTERID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDCCLUSTERNAME", format="")})})
public class PSDCClusterDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDCClusterDefaultACModel() {
        this.initAnnotation(PSDCClusterDefaultACModel.class);
    }
}

