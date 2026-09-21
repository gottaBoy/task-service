/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.pseditorstyle.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="cafa417b111f8b3b76c0b816a2223a40", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSEDITORSTYLEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSEDITORSTYLENAME", format="")})})
public class PSEditorStyleDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSEditorStyleDefaultACModel() {
        this.initAnnotation(PSEditorStyleDefaultACModel.class);
    }
}

