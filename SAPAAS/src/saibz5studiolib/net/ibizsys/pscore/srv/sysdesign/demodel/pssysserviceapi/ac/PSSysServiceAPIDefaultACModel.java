/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.pssysserviceapi.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="fb4a3aa813544c1c95349b27c6b2de71", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSYSSERVICEAPIID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSYSSERVICEAPINAME", format="")})})
public class PSSysServiceAPIDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSysServiceAPIDefaultACModel() {
        this.initAnnotation(PSSysServiceAPIDefaultACModel.class);
    }
}

