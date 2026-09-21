/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.pssystranslator.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="4de0013138e2b9be07df39e0ed6667cc", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSYSTRANSLATORID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSYSTRANSLATORNAME", format="")})})
public class PSSysTranslatorDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSysTranslatorDefaultACModel() {
        this.initAnnotation(PSSysTranslatorDefaultACModel.class);
    }
}

