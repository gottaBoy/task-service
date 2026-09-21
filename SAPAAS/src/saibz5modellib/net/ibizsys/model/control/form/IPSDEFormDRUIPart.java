/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.control.form;

import net.ibizsys.model.app.view.IPSAppView;
import net.ibizsys.model.control.form.IPSDEFormDetail;
import net.ibizsys.model.control.form.IPSDEFormItemUpdate;
import net.ibizsys.model.dataentity.dr.IPSDEDRItem;

public interface IPSDEFormDRUIPart
extends IPSDEFormDetail {
    public static final int REFRESHACTION_LOAD = 1;
    public static final int REFRESHACTION_SAVE = 2;

    public IPSDEDRItem getPSDEDRItem();

    public IPSAppView getPSAppView();

    public String getEmbedViewId();

    public String getRefreshItems();

    public String getPSDEFIUpdateId();

    public IPSDEFormItemUpdate getPSDEFormItemUpdate() throws Exception;

    public int getRefreshActions();

    public boolean isEnableRefreshAction(int var1);

    public String getParamItem();

    public boolean isNeedSave();
}

