/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.devcenter.demodel.psdcdeployserver.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="8b13132afc90ade6c5b6c5a4a8edc6bd", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDCDEPLOYSERVERID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDCDEPLOYSERVERNAME", format="")})})
public class PSDCDeployServerDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDCDeployServerDefaultACModel() {
        this.initAnnotation(PSDCDeployServerDefaultACModel.class);
    }
}

