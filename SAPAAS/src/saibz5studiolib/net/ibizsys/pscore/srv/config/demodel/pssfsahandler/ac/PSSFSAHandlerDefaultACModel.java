/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.pssfsahandler.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="cd8ddaa940d3b66c9d563f7c8fc92c06", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSFSAHANDLERID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSFSAHANDLERNAME", format="")})})
public class PSSFSAHandlerDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSFSAHandlerDefaultACModel() {
        this.initAnnotation(PSSFSAHandlerDefaultACModel.class);
    }
}

