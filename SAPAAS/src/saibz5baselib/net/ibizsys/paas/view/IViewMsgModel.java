/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.view;

import java.util.ArrayList;
import net.ibizsys.paas.controller.IViewController;
import net.ibizsys.paas.core.IModelBase2;
import net.ibizsys.paas.sysmodel.ISystemModel;
import net.ibizsys.paas.sysmodel.ISystemModelObject;
import net.ibizsys.paas.view.IViewMessage;

public interface IViewMsgModel
extends IViewMessage,
IModelBase2,
ISystemModelObject {
    public static final int DYNAMICMODE_STATIC = 0;
    public static final int DYNAMICMODE_DEDATASET = 1;
    public static final String ACTIVEDATA_VIEWID = "SRFVIEWID";
    public static final String ACTIVEDATA_VIEWCLS = "SRFVIEWCLS";
    public static final String ACTIVEDATA_DEID = "SRFDEID";
    public static final String ACTIVEDATA_DENAME = "SRFDENAME";
    public static final String ACTIVEDATA_KEY = "SRFKEY";
    public static final String ACTIVEDATA_DERID = "SRFDERID";

    public void init(ISystemModel var1) throws Exception;

    public String getUniqueTag();

    public int getOrderValue();

    public int fillViewMessages(IViewController var1, ArrayList<IViewMsgModel> var2) throws Exception;
}

