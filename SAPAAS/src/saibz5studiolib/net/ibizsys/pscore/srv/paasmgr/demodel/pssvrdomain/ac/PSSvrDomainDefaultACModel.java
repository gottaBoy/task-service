/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.paasmgr.demodel.pssvrdomain.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="3e8be1891daf41f1614b73ba9be2c03a", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSVRDOMAINID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSVRDOMAINNAME", format="")})})
public class PSSvrDomainDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSvrDomainDefaultACModel() {
        this.initAnnotation(PSSvrDomainDefaultACModel.class);
    }
}

