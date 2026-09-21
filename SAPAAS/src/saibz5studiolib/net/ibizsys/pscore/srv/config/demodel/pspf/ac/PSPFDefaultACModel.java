/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.pspf.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="ffaf090276d78ad10a4d3bd584aeed56", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSPFID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSPFNAME", format="")})})
public class PSPFDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSPFDefaultACModel() {
        this.initAnnotation(PSPFDefaultACModel.class);
    }
}

