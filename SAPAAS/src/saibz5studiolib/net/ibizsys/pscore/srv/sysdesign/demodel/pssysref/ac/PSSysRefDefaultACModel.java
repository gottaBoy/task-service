/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.pssysref.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="f6b452c93bac2d5427598807e808b459", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSYSREFID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSYSREFNAME", format="")})})
public class PSSysRefDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSysRefDefaultACModel() {
        this.initAnnotation(PSSysRefDefaultACModel.class);
    }
}

