/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdevstudio.demodel.pssysmodelmsg.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="b64f067af251df748b6cbb5847139914", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSYSMODELMSGID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSYSMODELMSGNAME", format="")})})
public class PSSysModelMsgDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSysModelMsgDefaultACModel() {
        this.initAnnotation(PSSysModelMsgDefaultACModel.class);
    }
}

