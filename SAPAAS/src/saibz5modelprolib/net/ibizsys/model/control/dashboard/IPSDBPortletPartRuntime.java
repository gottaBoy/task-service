/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.app.view.IPSAppView
 *  net.ibizsys.model.app.view.IPSAppViewRef
 *  net.ibizsys.model.codelist.IPSCodeList
 *  net.ibizsys.model.control.IPSControlContainer
 *  net.ibizsys.model.control.IPSControlParam
 *  net.ibizsys.model.control.dashboard.IPSDBPortletPart
 */
package net.ibizsys.model.control.dashboard;

import java.util.ArrayList;
import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.app.view.IPSAppView;
import net.ibizsys.model.app.view.IPSAppViewRef;
import net.ibizsys.model.codelist.IPSCodeList;
import net.ibizsys.model.control.IPSControlContainer;
import net.ibizsys.model.control.IPSControlParam;
import net.ibizsys.model.control.dashboard.IPSDBPortletPart;

public interface IPSDBPortletPartRuntime
extends IPSDBPortletPart {
    public void init(IPSModelStorageContext var1, IPSControlContainer var2, String var3, IPSControlParam var4) throws Exception;

    public void fillRelatedPSAppViews(ArrayList<IPSAppView> var1) throws Exception;

    public void fillRelatedPSCodeLists(ArrayList<IPSCodeList> var1) throws Exception;

    public void fillEmbeddedPSAppViewRefs(String var1, ArrayList<IPSAppViewRef> var2) throws Exception;
}

