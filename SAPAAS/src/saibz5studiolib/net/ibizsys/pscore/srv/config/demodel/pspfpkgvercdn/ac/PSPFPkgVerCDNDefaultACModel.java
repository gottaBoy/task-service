/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.pspfpkgvercdn.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="7d6858b7ef1bad4a890abf25f5cad2f7", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSPFPKGVERCDNID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSPFPKGVERCDNNAME", format="")})})
public class PSPFPkgVerCDNDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSPFPkgVerCDNDefaultACModel() {
        this.initAnnotation(PSPFPkgVerCDNDefaultACModel.class);
    }
}

