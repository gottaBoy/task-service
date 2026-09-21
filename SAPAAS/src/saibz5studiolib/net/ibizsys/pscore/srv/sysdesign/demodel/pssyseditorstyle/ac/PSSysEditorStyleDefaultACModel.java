/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.pssyseditorstyle.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="79268267d3d6f809daa3dd1a2b699962", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSYSEDITORSTYLEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSYSEDITORSTYLENAME", format="")})})
public class PSSysEditorStyleDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSysEditorStyleDefaultACModel() {
        this.initAnnotation(PSSysEditorStyleDefaultACModel.class);
    }
}

