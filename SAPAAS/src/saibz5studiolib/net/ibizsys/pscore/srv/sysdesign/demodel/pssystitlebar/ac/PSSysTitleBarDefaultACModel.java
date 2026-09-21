/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.pssystitlebar.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="1619d57b14b27f98ce6cf688bba929d4", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSYSTITLEBARID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSYSTITLEBARNAME", format="")})})
public class PSSysTitleBarDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSysTitleBarDefaultACModel() {
        this.initAnnotation(PSSysTitleBarDefaultACModel.class);
    }
}

