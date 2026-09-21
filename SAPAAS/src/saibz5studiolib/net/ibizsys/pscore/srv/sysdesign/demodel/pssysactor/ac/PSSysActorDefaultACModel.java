/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.pssysactor.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="91a830639531de6df2fd428d80aeeae6", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSYSACTORID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSYSACTORNAME", format="")})})
public class PSSysActorDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSysActorDefaultACModel() {
        this.initAnnotation(PSSysActorDefaultACModel.class);
    }
}

