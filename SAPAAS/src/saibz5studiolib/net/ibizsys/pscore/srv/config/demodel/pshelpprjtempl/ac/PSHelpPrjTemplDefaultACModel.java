/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.pshelpprjtempl.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="15640f06fa0759c064370b9b569a8802", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSHELPPRJTEMPLID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSHELPPRJTEMPLNAME", format="")})})
public class PSHelpPrjTemplDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSHelpPrjTemplDefaultACModel() {
        this.initAnnotation(PSHelpPrjTemplDefaultACModel.class);
    }
}

