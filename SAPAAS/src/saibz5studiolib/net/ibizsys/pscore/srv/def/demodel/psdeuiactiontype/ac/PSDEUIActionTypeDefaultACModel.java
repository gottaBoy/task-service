/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.def.demodel.psdeuiactiontype.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="2e0712f81f975d7a4c79d79f1924411a", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDEUIACTIONTYPEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDEUIACTIONTYPENAME", format="")})})
public class PSDEUIActionTypeDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDEUIActionTypeDefaultACModel() {
        this.initAnnotation(PSDEUIActionTypeDefaultACModel.class);
    }
}

