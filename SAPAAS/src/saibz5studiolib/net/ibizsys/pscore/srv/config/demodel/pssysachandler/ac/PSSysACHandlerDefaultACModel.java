/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.pssysachandler.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="2a1bdcec556b09b42a22a314e5a78ff5", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSYSACHANDLERID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSYSACHANDLERNAME", format="")})})
public class PSSysACHandlerDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSysACHandlerDefaultACModel() {
        this.initAnnotation(PSSysACHandlerDefaultACModel.class);
    }
}

