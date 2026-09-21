/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.node.ObjectNode
 */
package net.ibizsys.model.app.view;

import com.fasterxml.jackson.databind.node.ObjectNode;
import net.ibizsys.model.app.view.IPSAppView;
import net.ibizsys.model.view.IPSUIAction;

public interface IPSUIActionItem {
    public IPSUIAction getPSUIAction();

    public IPSAppView getPSAppView();

    public ObjectNode getUIActionParamJO();
}

