/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.pssysdictcat.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="31255bed2ccdfd9b2fb84a413de83268", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSYSDICTCATID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSYSDICTCATNAME", format="")})})
public class PSSysDictCatDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSysDictCatDefaultACModel() {
        this.initAnnotation(PSSysDictCatDefaultACModel.class);
    }
}

