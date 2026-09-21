/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.psmodelobj.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="3297a66cde126dc6931bece554b46ee4", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSMODELOBJID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSMODELOBJNAME", format="")})})
public class PSModelObjDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSModelObjDefaultACModel() {
        this.initAnnotation(PSModelObjDefaultACModel.class);
    }
}

