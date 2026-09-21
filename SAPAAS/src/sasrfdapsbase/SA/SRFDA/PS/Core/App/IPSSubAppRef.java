/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.App;

import SA.SRFDA.PS.Core.App.AppMenu.IPSAppMenuModel;
import SA.SRFDA.PS.Core.App.Control.IPSAppPortlet;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEUIActionGroup;
import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.App.IPSApplicationObject;
import SA.SRFDA.PS.Core.App.Res.IPSAppPFPluginRef;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.App.View.IPSAppViewRef;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.SubSys.IPSSubApp;
import SA.SRFDA.PS.Data.PSAppSubApp;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Iterator;

public interface IPSSubAppRef
extends IPSApplicationObject {
    public void init(ISRFDAGlobalHelper var1, IPSApplication var2, PSAppSubApp var3) throws Exception;

    public IPSSubApp getPSSubApp();

    public String getPKGCodeName(String var1) throws Exception;

    public String getFolderName();

    public IPSAppMenuModel getPSAppMenuModel();

    public Iterator<IPSAppView> getAllPSAppViews() throws Exception;

    public Iterator<IPSAppMenuModel> getAllPSAppMenuModels() throws Exception;

    public Iterator<IPSAppDEUIActionGroup> getAllPSAppDEUIActionGroups() throws Exception;

    public Iterator<IPSControl> getAllPSDEDRControls() throws Exception;

    public Iterator<IPSControl> getAllPSControls() throws Exception;

    public Iterator<IPSAppViewRef> getAllPSAppViewRefs() throws Exception;

    public Iterator<IPSAppPFPluginRef> getAllPSAppPFPluginRefs() throws Exception;

    public Iterator<IPSAppPortlet> getAllPSAppPortlets() throws Exception;

    public String getModelStamp();

    public String getRefParam();

    public String getRefParam2();

    public String getServiceId();

    public String getAccessKey();

    public String getSysRefType();
}

