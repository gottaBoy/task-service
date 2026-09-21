/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.psmodelobjref.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="96503a35e80459a873cce737b6b16dab", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSMODELOBJREFID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSMODELOBJREFNAME", format="")})})
public class PSModelObjRefDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSModelObjRefDefaultACModel() {
        this.initAnnotation(PSModelObjRefDefaultACModel.class);
    }
}

