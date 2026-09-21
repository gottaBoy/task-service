/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdevstudio.demodel.psmodelbookmark.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="faa3eb73f67134c94fe0cea737d16a88", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSMODELBOOKMARKID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSMODELBOOKMARKNAME", format="")})})
public class PSModelBookmarkDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSModelBookmarkDefaultACModel() {
        this.initAnnotation(PSModelBookmarkDefaultACModel.class);
    }
}

