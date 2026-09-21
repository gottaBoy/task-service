/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.psdertawi.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="900c2a6615414b2cd3edd19120ca36cc", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDERTAWIID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDERTAWINAME", format="")})})
public class PSDERTAWIDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDERTAWIDefaultACModel() {
        this.initAnnotation(PSDERTAWIDefaultACModel.class);
    }
}

