/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.view;

import java.util.ArrayList;
import net.ibizsys.paas.controller.IViewController;
import net.ibizsys.paas.sysmodel.ISystemModel;
import net.ibizsys.paas.sysmodel.ISystemModelObject;
import net.ibizsys.paas.view.IViewMessage;
import net.ibizsys.paas.view.IViewMsgGroup;
import net.ibizsys.paas.view.IViewMsgModel;

public interface IViewMsgGroupModel
extends IViewMsgGroup,
ISystemModelObject {
    public void init(ISystemModel var1) throws Exception;

    public String getUniqueTag();

    public void registerViewMsgModel(IViewMsgModel var1) throws Exception;

    public void fillViewMessages(IViewController var1, ArrayList<IViewMessage> var2) throws Exception;
}

