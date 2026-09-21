/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.ctrlmodel;

import net.ibizsys.paas.ctrlmodel.IEditFormPortletModel;
import net.ibizsys.paas.ctrlmodel.PortletModelBase;

public abstract class EditFormPortletModelBase
extends PortletModelBase
implements IEditFormPortletModel {
    @Override
    public String getPortletType() {
        return "FORM";
    }
}

