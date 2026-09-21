/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.wf.demodel.wfsystemuser.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="3d6fd9746bb1acf4b6af87da05f6a646", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="WFSYSTEMUSERID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="WFSYSTEMUSERNAME", format="")})})
public abstract class WFSystemUserDefaultACModelBase
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public WFSystemUserDefaultACModelBase() {
        this.initAnnotation(WFSystemUserDefaultACModelBase.class);
    }
}

