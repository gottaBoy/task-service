/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.model.app.IPSApplication
 *  net.ibizsys.model.app.func.IPSAppFunc
 *  net.ibizsys.model.app.view.IPSAppView
 *  net.ibizsys.model.app.view.IPSAppViewRef
 *  net.ibizsys.model.codelist.IPSCodeList
 *  net.ibizsys.model.control.counter.IPSSysCounter
 *  net.ibizsys.model.control.counter.IPSSysCounterRef
 *  net.ibizsys.model.res.IPSSysCss
 *  net.ibizsys.model.res.IPSSysImage
 *  net.ibizsys.model.view.IPSUIAction
 *  net.ibizsys.model.view.IPSViewType
 */
package net.ibizsys.model.app.view;

import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.ArrayList;
import net.ibizsys.model.IPSModelObjectRuntime;
import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.app.IPSApplication;
import net.ibizsys.model.app.func.IPSAppFunc;
import net.ibizsys.model.app.view.IPSAppView;
import net.ibizsys.model.app.view.IPSAppViewRef;
import net.ibizsys.model.codelist.IPSCodeList;
import net.ibizsys.model.control.counter.IPSSysCounter;
import net.ibizsys.model.control.counter.IPSSysCounterRef;
import net.ibizsys.model.entity.PSAppView;
import net.ibizsys.model.entity.PSAppViewRef;
import net.ibizsys.model.pf.IPSPFStyle;
import net.ibizsys.model.res.IPSSysCss;
import net.ibizsys.model.res.IPSSysImage;
import net.ibizsys.model.view.IPSUIAction;
import net.ibizsys.model.view.IPSViewType;

public interface IPSAppViewRuntime
extends IPSModelObjectRuntime,
IPSAppView {
    public void init(IPSModelStorageContext var1, IPSApplication var2, PSAppView var3) throws Exception;

    public boolean isInited();

    public IPSSysCounterRef registerPSSysCounter(IPSSysCounter var1, ObjectNode var2) throws Exception;

    public void markViewUsage(int var1, Object var2);

    public void fillRelatedPSAppViews(ArrayList<IPSAppView> var1) throws Exception;

    public IPSAppViewRef registerPSAppViewRef(PSAppViewRef var1) throws Exception;

    public void registerPSUIAction(IPSUIAction var1, ObjectNode var2) throws Exception;

    public void registerPSUIAction(IPSUIAction var1) throws Exception;

    public void fillRelatedPSCodeLists(ArrayList<IPSCodeList> var1) throws Exception;

    public void registerPSAppFunc(IPSAppFunc var1) throws Exception;

    public void registerPSSysCss(IPSSysCss var1) throws Exception;

    public void registerPSSysImage(IPSSysImage var1) throws Exception;

    public String generateCtrlUniId();

    public String generateViewUniId();

    public void setPSViewType(IPSViewType var1);

    public String getCodeName();

    public String getFullCodeName();

    public IPSPFStyle getPSPFStyle();
}

