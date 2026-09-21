/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.ctrlmodel.IEditFormPortletModel
 */
package net.ibizsys.paas.ctrlmodel;

import net.ibizsys.paas.ctrlmodel.DynaPortletModelBase;
import net.ibizsys.paas.ctrlmodel.IEditFormPortletModel;

public abstract class DynaEditFormPortletModelBase
extends DynaPortletModelBase
implements IEditFormPortletModel {
    public String getPortletType() {
        return "FORM";
    }
}

