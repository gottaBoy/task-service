/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.pssubde.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="2d7378ec86d6761e6dfc10807c89afb3", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSUBDEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSUBDENAME", format="")})})
public class PSSubDEDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSubDEDefaultACModel() {
        this.initAnnotation(PSSubDEDefaultACModel.class);
    }
}

