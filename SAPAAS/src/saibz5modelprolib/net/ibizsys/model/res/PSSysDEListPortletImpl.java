/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.res;

import net.ibizsys.model.res.IPSSysDEListPortlet;
import net.ibizsys.model.res.PSSysPortletImpl;

public class PSSysDEListPortletImpl
extends PSSysPortletImpl
implements IPSSysDEListPortlet {
    @Override
    public String getPSDEListId() {
        return this.psSysPortlet.getPSDELISTID();
    }

    @Override
    public String getPSDEDataSetId() {
        return "";
    }

    @Override
    public String getActiveDataPSDELogicId() {
        return "";
    }
}

