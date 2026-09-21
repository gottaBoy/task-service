/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.node.ObjectNode
 */
package net.ibizsys.model.view;

import com.fasterxml.jackson.databind.node.ObjectNode;
import net.ibizsys.model.core.IPSModelObject;
import net.ibizsys.model.view.IPSUIAction;
import net.ibizsys.model.view.IPSUIActionGroup;

public interface IPSUIActionGroupDetail
extends IPSModelObject {
    public IPSUIActionGroup getPSUIActionGroup();

    public IPSUIAction getPSUIAction();

    public ObjectNode getUIActionParamJO();

    public String getUIActionParam();

    public boolean isAddSeparator();
}

