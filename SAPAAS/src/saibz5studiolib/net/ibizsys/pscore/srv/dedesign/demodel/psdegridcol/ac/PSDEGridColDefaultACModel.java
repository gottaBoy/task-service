/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.dedesign.demodel.psdegridcol.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="ba42e103a81a9e0af8cadc4ae58d1c44", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDEGRIDCOLID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDEGRIDCOLNAME", format="")})})
public class PSDEGridColDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDEGridColDefaultACModel() {
        this.initAnnotation(PSDEGridColDefaultACModel.class);
    }
}

