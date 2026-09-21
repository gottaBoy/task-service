/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.psdertype.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="c63d1a81db5c622b754f22d753f530bb", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDERTYPEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDERTYPENAME", format="")})})
public class PSDERTypeDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDERTypeDefaultACModel() {
        this.initAnnotation(PSDERTypeDefaultACModel.class);
    }
}

