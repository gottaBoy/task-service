/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.psmodelapimethod.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="083b41e94420ab229d1f35069db6e4d1", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSMODELAPIMETHODID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSMODELAPIMETHODNAME", format="")})})
public class PSModelAPIMethodDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSModelAPIMethodDefaultACModel() {
        this.initAnnotation(PSModelAPIMethodDefaultACModel.class);
    }
}

