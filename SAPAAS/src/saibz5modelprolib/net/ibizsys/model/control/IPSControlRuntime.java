/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.app.view.IPSAppView
 *  net.ibizsys.model.app.view.IPSAppViewRef
 *  net.ibizsys.model.codelist.IPSCodeList
 *  net.ibizsys.model.control.IPSControl
 *  net.ibizsys.model.control.IPSControlContainer
 *  net.ibizsys.model.control.IPSControlParam
 */
package net.ibizsys.model.control;

import java.util.ArrayList;
import net.ibizsys.model.IPSModelObjectRuntime;
import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.app.view.IPSAppView;
import net.ibizsys.model.app.view.IPSAppViewRef;
import net.ibizsys.model.codelist.IPSCodeList;
import net.ibizsys.model.control.IPSControl;
import net.ibizsys.model.control.IPSControlContainer;
import net.ibizsys.model.control.IPSControlParam;
import net.ibizsys.model.control.IPSControlTypeRuntime;
import net.ibizsys.model.res.IPSSysPFPlugin;

public interface IPSControlRuntime
extends IPSControl,
IPSModelObjectRuntime {
    public void init(IPSModelStorageContext var1, IPSControlContainer var2, String var3, IPSControlParam var4) throws Exception;

    public int getOrderValue();

    public void fillRelatedPSAppViews(ArrayList<IPSAppView> var1) throws Exception;

    public void fillRelatedPSCodeLists(ArrayList<IPSCodeList> var1) throws Exception;

    public void fillEmbeddedPSAppViewRefs(String var1, ArrayList<IPSAppViewRef> var2) throws Exception;

    public void setPSControlType(IPSControlTypeRuntime var1);

    public boolean isDesignMode();

    public boolean isEnableCol12ToCol24();

    public IPSSysPFPlugin getPSSysPFPlugin();
}

