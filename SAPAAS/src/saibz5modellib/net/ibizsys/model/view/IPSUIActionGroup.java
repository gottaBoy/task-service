/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.view;

import java.util.Iterator;
import net.ibizsys.model.core.IPSModelObject;
import net.ibizsys.model.view.IPSUIAction;
import net.ibizsys.model.view.IPSUIActionGroupDetail;

public interface IPSUIActionGroup
extends IPSModelObject {
    public Iterator<IPSUIAction> getPSUIActions();

    public Iterator<IPSUIActionGroupDetail> getPSUIActionGroupDetails();
}

