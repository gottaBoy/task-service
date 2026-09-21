/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.pssysuserroleres.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="ab3a385f814ae189baebf8f2ee1490b1", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSYSUSERROLERESID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSYSUSERROLERESNAME", format="")})})
public class PSSysUserRoleResDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSysUserRoleResDefaultACModel() {
        this.initAnnotation(PSSysUserRoleResDefaultACModel.class);
    }
}

