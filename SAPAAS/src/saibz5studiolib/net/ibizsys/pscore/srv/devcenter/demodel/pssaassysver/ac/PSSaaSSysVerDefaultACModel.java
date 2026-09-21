/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.devcenter.demodel.pssaassysver.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="3d4539fd96f139f308d03fcd15089a08", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSAASSYSVERID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSAASSYSVERNAME", format="")})})
public class PSSaaSSysVerDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSaaSSysVerDefaultACModel() {
        this.initAnnotation(PSSaaSSysVerDefaultACModel.class);
    }
}

