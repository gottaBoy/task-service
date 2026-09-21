/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.pssyssearchbarlogic.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="e9730d5b152c64bc5db8a0bfe0b6747c", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSYSSEARCHBARLOGICID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSYSSEARCHBARLOGICNAME", format="")})})
public class PSSysSearchBarLogicDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSysSearchBarLogicDefaultACModel() {
        this.initAnnotation(PSSysSearchBarLogicDefaultACModel.class);
    }
}

