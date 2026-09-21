/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
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
import SA.SRFDA.PS.Core.Control.IPSControlContainer;
import SA.SRFDA.PS.Core.Control.IPSControlParam;
import SA.SRFDA.PS.Core.Control.IPSControlType;
import SA.SRFDA.PS.Core.Control.Panel.IPSLayoutPanel;
import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Core.Res.IPSSysCss;
import SA.SRFDA.PS.Core.Res.IPSSysImage;
import SA.SRFDA.PS.Core.View.IPSUIAction;
import SA.SRFDA.PS.Data.PSAppViewRef;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.ArrayList;
import java.util.Iterator;
import net.sf.json.JSONObject;

@PSModelIgnoreMeta
public class SimplePSControlContainerImpl
extends PSObjectImpl
implements IPSControlContainer {
    private IPSObject iPSObject = null;
    private IPSAppView iPSAppView = null;

    @Override
    public ArrayList<IPSControl> getAllPSControls() {
        return null;
    }

    @Override
    public IPSAppCounterRef registerPSAppCounter(IPSAppCounter iPSAppCounter, JSONObject jsonRefMode) throws Exception {
        return null;
    }

    @Override
    public Iterator<IPSAppCounterRef> getPSAppCounterRefs() {
        return null;
    }

    @Override
    public void registerPSSysCss(IPSSysCss iPSSysCss) throws Exception {
    }

    @Override
    public void registerPSSysImage(IPSSysImage iPSSysImage) throws Exception {
    }

    @Override
    public Iterator<IPSSysCss> getPSSysCsses() {
        return null;
    }

    @Override
    public Iterator<IPSSysImage> getPSSysImages() {
        return null;
    }

    @Override
    public void registerPSLayoutPanel(IPSLayoutPanel iPSLayoutPanel) throws Exception {
    }

    @Override
    public Iterator<IPSLayoutPanel> getPSLayoutPanels() {
        return null;
    }

    @Override
    public IPSAppViewRef getPSAppViewRef(String strRefMode, boolean bTry) throws Exception {
        return null;
    }

    @Override
    public IPSAppViewRef registerPSAppViewRef(PSAppViewRef psAppViewRef) throws Exception {
        return null;
    }

    @Override
    public Iterator<IPSAppViewRef> getPSAppViewRefs() {
        return null;
    }

    @Override
    public Iterator<IPSAppViewRef> getPSAppViewRefs(String strRefModePrefix) throws Exception {
        return null;
    }

    @Override
    public IPSAppViewLogic getPSAppViewLogic(String strLogicTag, boolean bTry) throws Exception {
        return null;
    }

    @Override
    public Iterator<IPSAppViewLogic> getPSAppViewLogics() {
        return null;
    }

    @Override
    public void registerPSAppViewLogic(String strKey, IPSAppViewLogic iPSAppViewLogic) throws Exception {
    }

    @Override
    public void registerPSAppViewLogic(IPSAppViewLogic iPSAppViewLogic) throws Exception {
    }

    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSAppView iPSAppView, IPSObject iPSObject) {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.iPSObject = iPSObject;
        this.iPSAppView = iPSAppView;
    }

    @Override
    public IPSAppView getPSAppView() {
        return this.iPSAppView;
    }

    @Override
    public boolean hasPSControl(String strControlName) {
        return false;
    }

    @Override
    public Iterator<IPSControl> getPSControls() {
        return null;
    }

    @Override
    public IPSControl getPSControl(String strControlName) throws Exception {
        return null;
    }

    @Override
    public Iterator<IPSAjaxControl> getPSAjaxControls() {
        return null;
    }

    @Override
    public IPSControl registerPSControl(String strKey, String strPSCtrlType, IPSControlParam iPSControlParam) throws Exception {
        IPSControlType iPSControlType = this.getPSModelStorage().getPSControlType(strPSCtrlType);
        IPSControl iPSControl = iPSControlType.createPSControl(iPSControlParam);
        iPSControl.init(this.getDAGlobalHelper(), this, strKey, iPSControlParam);
        return iPSControl;
    }

    @Override
    public String getPSSysModelInstId() {
        if (this.iPSObject != null) {
            return this.iPSObject.getPSSysModelInstId();
        }
        if (this.iPSAppView != null) {
            return this.iPSAppView.getPSSysModelInstId();
        }
        return null;
    }

    @Override
    public Iterator<IPSAppViewUIAction> getPSAppViewUIActions() {
        return null;
    }

    @Override
    public void registerPSAppViewUIAction(IPSAppViewUIAction iPSAppViewUIAction) throws Exception {
    }

    @Override
    public void registerPSAppViewEngine(String strKey, IPSAppViewEngine iPSAppViewEngine) throws Exception {
    }

    @Override
    public void registerPSAppViewEngine(IPSAppViewEngine iPSAppViewEngine) throws Exception {
    }

    @Override
    public IPSAppViewEngine getPSAppViewEngine(String strEngineTag, boolean bTry) throws Exception {
        return null;
    }

    @Override
    public Iterator<IPSAppViewEngine> getPSAppViewEngines() {
        return null;
    }

    @Override
    public Iterator<IPSUIAction> getPSUIActions() {
        return null;
    }

    @Override
    public void registerPSUIAction(IPSUIAction iPSUIAction, JSONObject actionParam) throws Exception {
    }

    @Override
    public void registerPSUIAction(IPSUIAction iPSUIAction) throws Exception {
    }

    @Override
    public Iterator<IPSAppView> getAllRelatedPSAppViews() throws Exception {
        return null;
    }

    @Override
    public boolean isRegisterPSLayoutPanel() {
        return false;
    }

    @Override
    public boolean isPrepareTemplV2logic() {
        return false;
    }

    @Override
    public boolean isPrepareDefaultPSAppViewLogics() {
        return false;
    }
}

