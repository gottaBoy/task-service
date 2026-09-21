/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.wfdesign.demodel.pssyswfcat.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="0cce77eee3755509f226e916bd4605ad", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSYSWFCATID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSYSWFCATNAME", format="")})})
public class PSSysWFCatDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSysWFCatDefaultACModel() {
        this.initAnnotation(PSSysWFCatDefaultACModel.class);
    }
}

