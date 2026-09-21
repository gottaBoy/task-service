/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.psmodelapiint.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="d4d9e35d2b19d436c1682a043808ebf3", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSMODELAPIINTID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSMODELAPIINTNAME", format="")})})
public class PSModelAPIIntDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSModelAPIIntDefaultACModel() {
        this.initAnnotation(PSModelAPIIntDefaultACModel.class);
    }
}

