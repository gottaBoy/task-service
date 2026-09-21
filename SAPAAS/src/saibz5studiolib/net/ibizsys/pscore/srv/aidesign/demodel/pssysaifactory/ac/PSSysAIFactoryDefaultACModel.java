/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.aidesign.demodel.pssysaifactory.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="fb440636d9621d48cc9e3468ed6ed56e", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSYSAIFACTORYID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSYSAIFACTORYNAME", format="")})})
public class PSSysAIFactoryDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSysAIFactoryDefaultACModel() {
        this.initAnnotation(PSSysAIFactoryDefaultACModel.class);
    }
}

