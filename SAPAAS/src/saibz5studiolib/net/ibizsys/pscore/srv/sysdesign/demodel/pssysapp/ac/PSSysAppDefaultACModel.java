/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.pssysapp.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="880ff28bce3940510f5520c641499f99", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSYSAPPID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSYSAPPNAME", format="")})})
public class PSSysAppDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSysAppDefaultACModel() {
        this.initAnnotation(PSSysAppDefaultACModel.class);
    }
}

