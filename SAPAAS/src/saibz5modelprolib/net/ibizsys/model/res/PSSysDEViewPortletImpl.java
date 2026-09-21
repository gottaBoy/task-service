/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.res;

import net.ibizsys.model.res.IPSSysDEViewPortlet;
import net.ibizsys.model.res.PSSysPortletImpl;

public class PSSysDEViewPortletImpl
extends PSSysPortletImpl
implements IPSSysDEViewPortlet {
    @Override
    public String getPSDEViewId() {
        return this.psSysPortlet.getPSDEVIEWID();
    }
}

