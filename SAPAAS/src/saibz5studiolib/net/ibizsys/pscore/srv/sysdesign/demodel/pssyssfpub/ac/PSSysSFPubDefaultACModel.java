/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.pssyssfpub.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="ee1714d0da954b118f20d8bec047906a", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSYSSFPUBID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSYSSFPUBNAME", format="")})})
public class PSSysSFPubDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSysSFPubDefaultACModel() {
        this.initAnnotation(PSSysSFPubDefaultACModel.class);
    }
}

