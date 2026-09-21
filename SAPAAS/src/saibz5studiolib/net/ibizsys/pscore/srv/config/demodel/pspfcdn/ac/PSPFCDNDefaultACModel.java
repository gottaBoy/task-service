/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.pspfcdn.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="33fb500f531873b069b6b07b5197b327", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSPFCDNID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSPFCDNNAME", format="")})})
public class PSPFCDNDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSPFCDNDefaultACModel() {
        this.initAnnotation(PSPFCDNDefaultACModel.class);
    }
}

