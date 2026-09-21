/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.dedesign.demodel.psdegridlogic.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="0dd2d2074de418f8b7dceab68b28b7b5", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDEGRIDLOGICID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDEGRIDLOGICNAME", format="")})})
public class PSDEGridLogicDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDEGridLogicDefaultACModel() {
        this.initAnnotation(PSDEGridLogicDefaultACModel.class);
    }
}

