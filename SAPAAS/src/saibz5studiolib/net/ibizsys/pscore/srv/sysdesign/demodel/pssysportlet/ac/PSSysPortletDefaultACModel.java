/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.pssysportlet.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="de7bd1e3af6168ac5df01513e5779fdc", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSYSPORTLETID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSYSPORTLETNAME", format="")})})
public class PSSysPortletDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSysPortletDefaultACModel() {
        this.initAnnotation(PSSysPortletDefaultACModel.class);
    }
}

