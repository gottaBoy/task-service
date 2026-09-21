/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdevstudio.demodel.psdspaneltoolbox.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="b2460bd425224b50d5a2f43b07188383", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDSPANELTOOLBOXID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDSPANELTOOLBOXNAME", format="")})})
public class PSDSPanelToolBoxDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDSPanelToolBoxDefaultACModel() {
        this.initAnnotation(PSDSPanelToolBoxDefaultACModel.class);
    }
}

