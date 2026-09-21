/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.appdesign.demodel.psdcmobpackcert.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="eadd8522f2ac2da27474c830abfc3b71", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDCMOBPACKCERTID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDCMOBPACKCERTNAME", format="")})})
public class PSDCMobPackCertDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDCMobPackCertDefaultACModel() {
        this.initAnnotation(PSDCMobPackCertDefaultACModel.class);
    }
}

