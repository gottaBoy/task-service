/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.dataentity.uiaction;

import java.util.Iterator;
import net.ibizsys.model.IPSSystemObject;
import net.ibizsys.model.dataentity.IPSDataEntityObject;
import net.ibizsys.model.dataentity.uiaction.IPSDEUIAction;
import net.ibizsys.model.dataentity.uiaction.IPSDEUIActionGroupDetail;
import net.ibizsys.model.view.IPSUIActionGroup;

public interface IPSDEUIActionGroup
extends IPSDataEntityObject,
IPSUIActionGroup,
IPSSystemObject {
    public Iterator<IPSDEUIAction> getPSDEUIActions();

    public Iterator<IPSDEUIActionGroupDetail> getPSDEUIActionGroupDetails();
}

