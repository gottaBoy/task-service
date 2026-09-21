/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.pshelparticletempl.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="412c19ce7ce49a54147da53a6765d453", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSHELPARTICLETEMPLID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSHELPARTICLETEMPLNAME", format="")})})
public class PSHelpArticleTemplDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSHelpArticleTemplDefaultACModel() {
        this.initAnnotation(PSHelpArticleTemplDefaultACModel.class);
    }
}

