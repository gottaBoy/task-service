/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.pshelparticletype.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="95281f3c9852661805d5dedb554bf026", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSHELPARTICLETYPEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSHELPARTICLETYPENAME", format="")})})
public class PSHelpArticleTypeDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSHelpArticleTypeDefaultACModel() {
        this.initAnnotation(PSHelpArticleTypeDefaultACModel.class);
    }
}

