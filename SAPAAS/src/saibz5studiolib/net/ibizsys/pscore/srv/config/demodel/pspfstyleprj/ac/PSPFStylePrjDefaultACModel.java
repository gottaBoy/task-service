/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.pspfstyleprj.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="2a0c6b91b2125d9435b3077efa5bab29", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSPFSTYLEPRJID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSPFSTYLEPRJNAME", format="")})})
public class PSPFStylePrjDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSPFStylePrjDefaultACModel() {
        this.initAnnotation(PSPFStylePrjDefaultACModel.class);
    }
}

