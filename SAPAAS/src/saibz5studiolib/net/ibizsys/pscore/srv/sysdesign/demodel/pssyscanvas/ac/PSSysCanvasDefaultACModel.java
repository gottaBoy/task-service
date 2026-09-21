/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.pssyscanvas.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="8ff3a707839877890cc6cf705515a52a", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSYSCANVASID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSYSCANVASNAME", format="")})})
public class PSSysCanvasDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSysCanvasDefaultACModel() {
        this.initAnnotation(PSSysCanvasDefaultACModel.class);
    }
}

