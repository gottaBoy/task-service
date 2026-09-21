/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.psmodelinit.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="886984a72cf275c3fc04d6a78cbd628f", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSMODELINITID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSMODELINITNAME", format="")})})
public class PSModelInitDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSModelInitDefaultACModel() {
        this.initAnnotation(PSModelInitDefaultACModel.class);
    }
}

