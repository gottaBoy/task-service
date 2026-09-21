/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.devcenter.demodel.pssaassysapi.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="ccaab37f728aa565cbb9fd71ec55a8fe", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSAASSYSAPIID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSAASSYSAPINAME", format="")})})
public class PSSaaSSysAPIDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSaaSSysAPIDefaultACModel() {
        this.initAnnotation(PSSaaSSysAPIDefaultACModel.class);
    }
}

