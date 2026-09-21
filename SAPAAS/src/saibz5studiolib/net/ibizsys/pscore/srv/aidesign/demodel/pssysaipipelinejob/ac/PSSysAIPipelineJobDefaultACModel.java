/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.aidesign.demodel.pssysaipipelinejob.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="f3f6245ada366f3d97b51ca8c564605f", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSYSAIPIPELINEJOBID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSYSAIPIPELINEJOBNAME", format="")})})
public class PSSysAIPipelineJobDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSysAIPipelineJobDefaultACModel() {
        this.initAnnotation(PSSysAIPipelineJobDefaultACModel.class);
    }
}

