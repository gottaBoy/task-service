/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.dedesign.demodel.psdefuimode.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="5872fb90094dc91ead3f278cc2d6b8ff", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDEFFORMITEMID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDEFFORMITEMNAME", format="")})})
public class PSDEFUIModeDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDEFUIModeDefaultACModel() {
        this.initAnnotation(PSDEFUIModeDefaultACModel.class);
    }
}

