/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.pssyscontentcat.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="576f84031deb870947190f53401f2f0c", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSYSCONTENTCATID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSYSCONTENTCATNAME", format="")})})
public class PSSysContentCatDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSysContentCatDefaultACModel() {
        this.initAnnotation(PSSysContentCatDefaultACModel.class);
    }
}

