/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.devcenter.demodel.psdcregistryserver.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="d161db630e8ce59c91b41e2f6b713cb3", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDCREGISTRYSERVERID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDCREGISTRYSERVERNAME", format="")})})
public class PSDCRegistryServerDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDCRegistryServerDefaultACModel() {
        this.initAnnotation(PSDCRegistryServerDefaultACModel.class);
    }
}

