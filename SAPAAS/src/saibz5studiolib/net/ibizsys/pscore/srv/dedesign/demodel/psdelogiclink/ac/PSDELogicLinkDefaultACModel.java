/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.dedesign.demodel.psdelogiclink.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="035b897647b8a324be33fb6d2ee00282", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDELOGICLINKID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDELOGICLINKNAME", format="")})})
public class PSDELogicLinkDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDELogicLinkDefaultACModel() {
        this.initAnnotation(PSDELogicLinkDefaultACModel.class);
    }
}

