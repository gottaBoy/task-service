/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.pssysdeployas.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="cb65f2a01942aa28ae29ac70c10dbd01", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSYSDEPLOYASID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSYSDEPLOYASNAME", format="")})})
public class PSSysDeployASDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSysDeployASDefaultACModel() {
        this.initAnnotation(PSSysDeployASDefaultACModel.class);
    }
}

