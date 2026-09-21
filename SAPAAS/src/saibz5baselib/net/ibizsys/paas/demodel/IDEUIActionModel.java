/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.paas.demodel;

import java.util.ArrayList;
import net.ibizsys.paas.core.IDEUIAction;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.view.IUIActionModel;
import net.ibizsys.paas.web.AjaxActionResult;
import org.hibernate.SessionFactory;

public interface IDEUIActionModel<ET extends IEntity>
extends IDEUIAction,
IUIActionModel {
    public void execute(ArrayList<ET> var1, SessionFactory var2) throws Exception;

    public String getDEActionName();

    public IDataEntityModel<ET> getDEModel();

    public AjaxActionResult getRuntimeModelAjaxActionResult(SessionFactory var1) throws Exception;
}

