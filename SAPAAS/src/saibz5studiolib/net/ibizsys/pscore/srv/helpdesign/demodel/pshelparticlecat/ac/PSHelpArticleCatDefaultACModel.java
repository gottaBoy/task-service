/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.helpdesign.demodel.pshelparticlecat.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="f276d8b006098dbd63b548cc8b536feb", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSHELPARTICLECATID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSHELPARTICLECATNAME", format="")})})
public class PSHelpArticleCatDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSHelpArticleCatDefaultACModel() {
        this.initAnnotation(PSHelpArticleCatDefaultACModel.class);
    }
}

