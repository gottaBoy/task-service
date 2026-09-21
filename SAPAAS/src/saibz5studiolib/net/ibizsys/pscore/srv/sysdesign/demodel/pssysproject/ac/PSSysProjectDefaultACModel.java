/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.pssysproject.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="2391d544fc7c68df1a2d6af6e313dc86", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSYSPROJECTID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSYSPROJECTNAME", format="")})})
public class PSSysProjectDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSysProjectDefaultACModel() {
        this.initAnnotation(PSSysProjectDefaultACModel.class);
    }
}

