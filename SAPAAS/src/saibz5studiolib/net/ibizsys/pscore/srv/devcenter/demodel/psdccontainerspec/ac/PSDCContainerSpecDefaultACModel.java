/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.devcenter.demodel.psdccontainerspec.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="668e688ae971746256c802466bda23e5", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDCCONTAINERSPECID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDCCONTAINERSPECNAME", format="")})})
public class PSDCContainerSpecDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDCContainerSpecDefaultACModel() {
        this.initAnnotation(PSDCContainerSpecDefaultACModel.class);
    }
}

