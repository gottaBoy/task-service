/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.pssystoolbar.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="5d53a749c18428d5daebb67e09949185", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSYSTOOLBARID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSYSTOOLBARNAME", format="")})})
public class PSSysToolbarDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSysToolbarDefaultACModel() {
        this.initAnnotation(PSSysToolbarDefaultACModel.class);
    }
}

