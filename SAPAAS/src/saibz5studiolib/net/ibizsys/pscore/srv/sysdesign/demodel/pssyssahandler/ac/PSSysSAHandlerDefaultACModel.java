/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.pssyssahandler.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="7e4e88c4ca5f23239170ec8bc21b6116", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSYSSAHANDLERID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSYSSAHANDLERNAME", format="")})})
public class PSSysSAHandlerDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSysSAHandlerDefaultACModel() {
        this.initAnnotation(PSSysSAHandlerDefaultACModel.class);
    }
}

