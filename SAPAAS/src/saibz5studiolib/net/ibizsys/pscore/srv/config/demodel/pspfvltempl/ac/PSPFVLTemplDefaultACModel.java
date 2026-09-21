/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.pspfvltempl.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="a605d42783388055f8df043d5a905720", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSPFVLTEMPLID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSPFVLTEMPLNAME", format="")})})
public class PSPFVLTemplDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSPFVLTemplDefaultACModel() {
        this.initAnnotation(PSPFVLTemplDefaultACModel.class);
    }
}

