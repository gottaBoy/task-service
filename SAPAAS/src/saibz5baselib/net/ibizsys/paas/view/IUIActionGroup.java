/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.view;

import java.util.Iterator;
import net.ibizsys.paas.core.IModelBase;
import net.ibizsys.paas.view.IUIActionGroupDetail;

public interface IUIActionGroup
extends IModelBase {
    public Iterator<IUIActionGroupDetail> getDetails();
}

