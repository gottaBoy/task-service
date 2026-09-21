/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.PS.Core.Control;

import SA.SRFDA.PS.Core.App.Control.IPSAppCounter;
import SA.SRFDA.PS.Core.App.Control.IPSAppCounterRef;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.App.View.IPSAppViewEngine;
import SA.SRFDA.PS.Core.App.View.IPSAppViewLogic;
import SA.SRFDA.PS.Core.App.View.IPSAppViewRef;
import SA.SRFDA.PS.Core.App.View.IPSAppViewUIAction;
import SA.SRFDA.PS.Core.Control.IPSAjaxControl;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Control.IPSControlParam;
import SA.SRFDA.PS.Core.Control.Panel.IPSLayoutPanel;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.Res.IPSSysCss;
import SA.SRFDA.PS.Core.Res.IPSSysImage;
import SA.SRFDA.PS.Core.View.IPSUIAction;
import SA.SRFDA.PS.Data.PSAppViewRef;
import java.util.ArrayList;
import java.util.Iterator;
import net.sf.json.JSONObject;

@PSModelInterfaceMeta(title="\u754c\u9762\u90e8\u4ef6\u5bb9\u5668\u6a21\u578b\u57fa\u7840\u5bf9\u8c61\u63a5\u53e3")
public interface IPSControlContainer
extends IPSModelObject {
    public IPSAppView getPSAppView();

    public boolean hasPSControl(String var1);

    public Iterator<IPSControl> getPSControls();

    public IPSControl getPSControl(String var1) throws Exception;

    public Iterator<IPSAjaxControl> getPSAjaxControls();

    public IPSControl registerPSControl(String var1, String var2, IPSControlParam var3) throws Exception;

    public Iterator<IPSAppViewUIAction> getPSAppViewUIActions();

    public void registerPSAppViewUIAction(IPSAppViewUIAction var1) throws Exception;

    public void registerPSAppViewEngine(String var1, IPSAppViewEngine var2) throws Exception;

    public void registerPSAppViewEngine(IPSAppViewEngine var1) throws Exception;

    public IPSAppViewEngine getPSAppViewEngine(String var1, boolean var2) throws Exception;

    public Iterator<IPSAppViewEngine> getPSAppViewEngines();

    public IPSAppViewLogic getPSAppViewLogic(String var1, boolean var2) throws Exception;

    public Iterator<IPSAppViewLogic> getPSAppViewLogics();

    public void registerPSAppViewLogic(String var1, IPSAppViewLogic var2) throws Exception;

    public void registerPSAppViewLogic(IPSAppViewLogic var1) throws Exception;

    public Iterator<IPSUIAction> getPSUIActions();

    public void registerPSUIAction(IPSUIAction var1, JSONObject var2) throws Exception;

    public void registerPSUIAction(IPSUIAction var1) throws Exception;

    public IPSAppViewRef getPSAppViewRef(String var1, boolean var2) throws Exception;

    public IPSAppViewRef registerPSAppViewRef(PSAppViewRef var1) throws Exception;

    public Iterator<IPSAppViewRef> getPSAppViewRefs();

    public Iterator<IPSAppViewRef> getPSAppViewRefs(String var1) throws Exception;

    public Iterator<IPSAppView> getAllRelatedPSAppViews() throws Exception;

    public void registerPSLayoutPanel(IPSLayoutPanel var1) throws Exception;

    public Iterator<IPSLayoutPanel> getPSLayoutPanels();

    public boolean isRegisterPSLayoutPanel();

    public void registerPSSysCss(IPSSysCss var1) throws Exception;

    public void registerPSSysImage(IPSSysImage var1) throws Exception;

    public Iterator<IPSSysCss> getPSSysCsses();

    public Iterator<IPSSysImage> getPSSysImages();

    public IPSAppCounterRef registerPSAppCounter(IPSAppCounter var1, JSONObject var2) throws Exception;

    public Iterator<IPSAppCounterRef> getPSAppCounterRefs();

    public boolean isPrepareTemplV2logic();

    public boolean isPrepareDefaultPSAppViewLogics();

    public ArrayList<IPSControl> getAllPSControls();
}

