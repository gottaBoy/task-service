/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdevstudio.demodel.psdsconsole.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="148ccb9703ab7c552eb010fbc94363ed", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDSCONSOLEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDSCONSOLENAME", format="")})})
public class PSDSConsoleDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDSConsoleDefaultACModel() {
        this.initAnnotation(PSDSConsoleDefaultACModel.class);
    }
}

