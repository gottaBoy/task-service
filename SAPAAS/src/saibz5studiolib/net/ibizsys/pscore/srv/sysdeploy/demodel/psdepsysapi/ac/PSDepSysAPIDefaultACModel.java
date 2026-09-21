/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdeploy.demodel.psdepsysapi.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="ed842cbea9e1e97d41c64c30e364b445", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDEPSYSAPIID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDEPSYSAPINAME", format="")})})
public class PSDepSysAPIDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDepSysAPIDefaultACModel() {
        this.initAnnotation(PSDepSysAPIDefaultACModel.class);
    }
}

