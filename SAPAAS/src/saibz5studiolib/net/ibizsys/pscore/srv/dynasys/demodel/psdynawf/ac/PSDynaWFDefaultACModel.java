/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.dynasys.demodel.psdynawf.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="d52cf5b43378ac6b42ea247e1a934da8", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDYNAWFID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDYNAWFNAME", format="")})})
public class PSDynaWFDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDynaWFDefaultACModel() {
        this.initAnnotation(PSDynaWFDefaultACModel.class);
    }
}

