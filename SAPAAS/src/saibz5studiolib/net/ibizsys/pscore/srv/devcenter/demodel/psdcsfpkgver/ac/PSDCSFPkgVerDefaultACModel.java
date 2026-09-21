/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.devcenter.demodel.psdcsfpkgver.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="0060fe60f8ecdde2af97f515d78877c0", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDCSFPKGVERID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDCSFPKGVERNAME", format="")})})
public class PSDCSFPkgVerDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDCSFPkgVerDefaultACModel() {
        this.initAnnotation(PSDCSFPkgVerDefaultACModel.class);
    }
}

