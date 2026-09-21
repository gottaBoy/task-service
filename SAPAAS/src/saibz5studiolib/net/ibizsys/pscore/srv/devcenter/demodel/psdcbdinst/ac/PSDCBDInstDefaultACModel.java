/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.devcenter.demodel.psdcbdinst.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="ab9dc5be1594ee23cc0d781f84b90320", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDCBDINSTID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDCBDINSTNAME", format="")})})
public class PSDCBDInstDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDCBDInstDefaultACModel() {
        this.initAnnotation(PSDCBDInstDefaultACModel.class);
    }
}

