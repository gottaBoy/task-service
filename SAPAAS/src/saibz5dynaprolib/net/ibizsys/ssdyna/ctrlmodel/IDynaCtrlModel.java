/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.model.control.IPSControl
 *  net.ibizsys.paas.ctrlmodel.ICtrlModel
 */
package net.ibizsys.ssdyna.ctrlmodel;

import com.fasterxml.jackson.databind.node.ObjectNode;
import net.ibizsys.model.control.IPSControl;
import net.ibizsys.paas.ctrlmodel.ICtrlModel;
import net.ibizsys.ssdyna.view.IDynaViewModel;

public interface IDynaCtrlModel
extends ICtrlModel {
    public void init(IDynaViewModel var1, IPSControl var2) throws Exception;

    public IPSControl getPSControl();

    public boolean isDynaCtrl();

    public ObjectNode toJsonObject(ObjectNode var1) throws Exception;
}

