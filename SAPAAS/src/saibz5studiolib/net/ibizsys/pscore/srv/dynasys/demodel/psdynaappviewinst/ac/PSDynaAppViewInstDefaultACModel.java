/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.dynasys.demodel.psdynaappviewinst.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="3ccc47ddd4b6b0535aaf7e4645e069ee", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDYNAAPPVIEWINSTID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDYNAAPPVIEWINSTNAME", format="")})})
public class PSDynaAppViewInstDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDynaAppViewInstDefaultACModel() {
        this.initAnnotation(PSDynaAppViewInstDefaultACModel.class);
    }
}

