/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.common.demodel.portalpage.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="f63040021720d1401ec2014d30b02bb6", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PORTALPAGEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PORTALPAGENAME", format="")})})
public abstract class PortalPageDefaultACModelBase
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PortalPageDefaultACModelBase() {
        this.initAnnotation(PortalPageDefaultACModelBase.class);
    }
}

