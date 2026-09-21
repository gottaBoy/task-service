/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.ctrlmodel;

import java.util.Iterator;
import net.ibizsys.paas.control.IControl;
import net.ibizsys.paas.controller.IViewController;
import net.ibizsys.paas.ctrlhandler.ICtrlRender;
import net.ibizsys.paas.demodel.IDataEntityModel;

public interface ICtrlModel
extends IControl {
    public void init(IViewController var1) throws Exception;

    public IViewController getViewController();

    public Object getCtrlParam(String var1);

    public boolean containsCtrlParam(String var1);

    public String getCtrlParam(String var1, String var2);

    public boolean getCtrlParam(String var1, boolean var2);

    public int getCtrlParam(String var1, int var2);

    public Iterator getCtrlParamNames();

    public ICtrlRender getCtrlRender() throws Exception;

    public ICtrlRender getCtrlRender(String var1) throws Exception;

    public IDataEntityModel getDEModel();

    public void setCtrlParam(String var1, Object var2);
}

