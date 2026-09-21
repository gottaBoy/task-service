/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringBuilderEx
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.App.View;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEAction;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEField;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntity;
import SA.SRFDA.PS.Core.App.View.IPSAppDERedirectView;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.App.View.IPSAppViewRef;
import SA.SRFDA.PS.Core.App.View.PSAppDEViewImpl;
import SA.SRFDA.PS.Core.App.View.PSAppViewRefImpl;
import SA.SRFDA.PS.Core.App.WF.IPSAppWFVer;
import SA.SRFDA.PS.Core.CodeList.IPSCodeItem;
import SA.SRFDA.PS.Core.CodeList.IPSCodeList;
import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEAction;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.IPSSystemRuntime;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Data.PSAppViewRef;
import SA.SRFDA.PS.Data.PSDEViewBase;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringBuilderEx;
import net.ibizsys.paas.util.StringHelper;

@PSModelImplementMeta(implement="IPSAppDEView", typevalues={"DEREDIRECTVIEW"})
public class PSAppDERedirectViewImpl
extends PSAppDEViewImpl
implements IPSAppDERedirectView {
    private Map<String, IPSAppView> redirectPSAppViewMap = new LinkedHashMap<String, IPSAppView>();
    private Map<String, IPSAppViewRef> redirectPSAppViewRefMap = new LinkedHashMap<String, IPSAppViewRef>();
    private boolean bEnableWorkflow = false;
    private Map<String, IPSAppView> refRedirectPSAppViewMap = new LinkedHashMap<String, IPSAppView>();
    private boolean bEnableCustomGetDataAction = false;
    private IPSDEAction getDataPSDEAction = null;
    private IPSDEField typePSDEField = null;
    private IPSAppDEAction getDataPSAppDEAction = null;
    private IPSAppDEField typePSAppDEField = null;

    @Override
    protected void onInit() throws Exception {
        this.bEnableWorkflow = true;
        if (!this.psViewBase.isVIEWPARAM5Null()) {
            this.bEnableWorkflow = this.psViewBase.getVIEWPARAM5();
        }
        if (!this.psViewBase.isVIEWPARAM6Null()) {
            this.bEnableCustomGetDataAction = this.psViewBase.getVIEWPARAM6();
        }
        if (this.isEnableCustomGetDataAction()) {
            if (StringHelper.isNullOrEmpty((String)this.psViewBase.getVIEWPARAM8())) {
                throw new Exception(StringHelper.format((String)"\u6ca1\u6709\u6307\u5b9a\u83b7\u53d6\u6570\u636e\u884c\u4e3a"));
            }
            if (StringHelper.isNullOrEmpty((String)this.psViewBase.getVIEWPARAM2())) {
                throw new Exception(StringHelper.format((String)"\u6ca1\u6709\u6307\u5b9a\u6570\u636e\u8bc6\u522b\u5c5e\u6027"));
            }
            this.getDataPSDEAction = this.getPSDataEntity().getPSDEAction(this.psViewBase.getVIEWPARAM8(), true);
            if (this.getDataPSDEAction == null) {
                throw new Exception(StringHelper.format((String)"\u5b9e\u4f53[%1$s]\u4e0d\u5b58\u5728\u6307\u5b9a\u884c\u4e3a[%2$s]", (Object)this.getPSDataEntity().getName(), (Object)this.psViewBase.getVIEWPARAM8()));
            }
            this.typePSDEField = this.getPSDataEntity().getPSDEField(this.psViewBase.getVIEWPARAM2(), true);
            if (this.typePSDEField == null) {
                throw new Exception(StringHelper.format((String)"\u5b9e\u4f53[%1$s]\u4e0d\u5b58\u5728\u6307\u5b9a\u5c5e\u6027[%2$s]", (Object)this.getPSDataEntity().getName(), (Object)this.psViewBase.getVIEWPARAM2()));
            }
        } else if (this.getPSSystem().isEnableModelRT()) {
            this.typePSDEField = this.getPSDataEntity().getDataTypePSDEField();
            if (this.typePSDEField != null) {
                this.getDataPSDEAction = this.getPSDataEntity().getPSDEAction("GET", true);
                if (this.getDataPSDEAction == null) {
                    this.typePSDEField = null;
                }
            }
        }
        if (this.getPSAppDataEntity() != null) {
            if (this.getGetDataPSDEAction() != null) {
                this.getDataPSAppDEAction = this.getPSAppDataEntity().getPSAppDEAction(this.getGetDataPSDEAction(), true);
            }
            if (this.getTypePSDEField() != null) {
                this.typePSAppDEField = this.getPSAppDataEntity().getPSAppDEField(this.getTypePSDEField(), true);
            }
        }
        super.onInit();
    }

    @Override
    @PSModelRTMeta(description="\u542f\u7528\u5de5\u4f5c\u6d41")
    public boolean isEnableWorkflow() {
        return this.bEnableWorkflow;
    }

    @Override
    @PSModelRTMeta(description="\u91cd\u5b9a\u5411\u89c6\u56fe")
    public boolean isRedirectView() {
        return true;
    }

    protected void registerRedirectPSAppView(String strRDMode, IPSAppView iPSAppView) throws Exception {
        this.registerRedirectPSAppView(strRDMode, iPSAppView, null);
    }

    protected void registerRedirectPSAppView(String strRDMode, IPSAppView iPSAppView, PSAppViewRef psAppViewRef) throws Exception {
        strRDMode = strRDMode.toUpperCase();
        this.redirectPSAppViewMap.put(strRDMode, iPSAppView);
        if (psAppViewRef == null) {
            psAppViewRef = new PSAppViewRef();
        }
        psAppViewRef.setPSAPPVIEWREFNAME(strRDMode);
        psAppViewRef.setPSAPPVIEWREFID(KeyValueHelper.genUniqueId((String)this.getId(), (String)strRDMode));
        psAppViewRef.setMINORPSAPPVIEWID(iPSAppView.getId());
        psAppViewRef.set("AUTOMODEL", 1);
        PSAppViewRefImpl psAppViewRefImpl = new PSAppViewRefImpl();
        psAppViewRefImpl.init(this.getDAGlobalHelper(), this, psAppViewRef);
        psAppViewRefImpl.setRefPSAppView(iPSAppView);
        this.redirectPSAppViewRefMap.put(strRDMode, psAppViewRefImpl);
    }

    @Override
    public Iterator<IPSAppView> getRedirectPSAppViews() {
        if (this.redirectPSAppViewMap.size() == 0) {
            return null;
        }
        return this.redirectPSAppViewMap.values().iterator();
    }

    @Override
    public Iterator<String> getRedirectModes() {
        if (this.redirectPSAppViewMap.size() == 0) {
            return null;
        }
        return this.redirectPSAppViewMap.keySet().iterator();
    }

    @Override
    public IPSAppView getRedirectPSAppView(String strRDMode, boolean bTryMode) throws Exception {
        IPSAppView iPSAppView = this.redirectPSAppViewMap.get(strRDMode.toUpperCase());
        if (iPSAppView == null && !bTryMode) {
            throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a[%1$s]\u91cd\u5b9a\u5411\u89c6\u56fe", (Object)strRDMode));
        }
        return iPSAppView;
    }

    @Override
    protected void onPreparePSAppViewRefs() throws Exception {
        StringBuilderEx sb;
        super.onPreparePSAppViewRefs();
        LinkedHashMap<String, IPSAppWFVer> psAppWFVerMap = null;
        if (StringHelper.compare((String)this.getPSApplication().getAppMode(), (String)"WFAPP", (boolean)false) == 0) {
            psAppWFVerMap = new LinkedHashMap<String, IPSAppWFVer>();
            Iterator<IPSAppWFVer> psAppWFVers = this.getPSApplication().getAllPSAppWFVers();
            if (psAppWFVers != null) {
                while (psAppWFVers.hasNext()) {
                    IPSAppWFVer iPSAppWFVer = psAppWFVers.next();
                    if (iPSAppWFVer.getPSWFVersion() == null) continue;
                    psAppWFVerMap.put(iPSAppWFVer.getPSWFVersion().getId(), iPSAppWFVer);
                }
            }
        }
        IPSCodeList typePSCodeList = null;
        boolean bFixBug = true;
        if (this.getDynaInstMode() == 2 && this.getPSSystem() instanceof IPSSystemRuntime) {
            IPSSystemRuntime iPSSystemRuntime = (IPSSystemRuntime)((Object)this.getPSSystem());
            if (iPSSystemRuntime.getDynaInstMode() != 0) {
                bFixBug = false;
            }
            if (iPSSystemRuntime.getDynaInstMode() == 1) {
                if (this.getTypePSAppDEField() != null && this.getTypePSDEField().getPSCodeList() != null && StringHelper.compare((String)this.getTypePSDEField().getPSCodeList().getPredefinedType(), (String)"MODULEINST", (boolean)false) == 0) {
                    typePSCodeList = this.getTypePSDEField().getPSCodeList();
                } else if (this.getPSDataEntity().getDataTypePSDEField() != null && this.getPSDataEntity().getDataTypePSDEField().getPSCodeList() != null && StringHelper.compare((String)this.getPSDataEntity().getDataTypePSDEField().getPSCodeList().getPredefinedType(), (String)"MODULEINST", (boolean)false) == 0) {
                    typePSCodeList = this.getPSDataEntity().getDataTypePSDEField().getPSCodeList();
                }
            }
        }
        ArrayList<PSDEViewBase> psDEViewBaseList = this.getPSDataEntity().getSDPSDEViewDataList(this.isEnableWorkflow(), this.isMobileView());
        if (bFixBug) {
            for (PSDEViewBase psDEViewBase : psDEViewBaseList) {
                if (!StringHelper.isNullOrEmpty((String)psDEViewBase.getPSWFVERSIONID()) && psAppWFVerMap != null && !psAppWFVerMap.containsKey(psDEViewBase.getPSWFVERSIONID())) continue;
                sb = new StringBuilderEx();
                if (StringHelper.compare((String)psDEViewBase.getPSDEID(), (String)this.getPSDataEntity().getId(), (boolean)true) != 0) continue;
                sb.append("%1$s:", (Object)psDEViewBase.getPSDENAME());
                sb.append(psDEViewBase.getPREDEFINEVIEWTYPE());
                if (!StringHelper.isNullOrEmpty((String)psDEViewBase.getPDVTPARAM())) {
                    sb.append(":%1$s", (Object)psDEViewBase.getPDVTPARAM());
                }
                this.registerRedirectPSAppView(sb.toString(), this.getPSApplication().getPSAppView(KeyValueHelper.genUniqueId((String)this.getPSApplication().getId(), (String)psDEViewBase.getPSDEVIEWBASEID()), psDEViewBase.getPSDEVIEWBASEID(), this));
            }
        }
        for (PSDEViewBase psDEViewBase : psDEViewBaseList) {
            Iterator<IPSCodeItem> psCodeItems;
            if (!StringHelper.isNullOrEmpty((String)psDEViewBase.getPSWFVERSIONID()) && psAppWFVerMap != null && !psAppWFVerMap.containsKey(psDEViewBase.getPSWFVERSIONID())) continue;
            sb = new StringBuilderEx();
            sb.append(psDEViewBase.getPREDEFINEVIEWTYPE());
            String strPDVTParam = psDEViewBase.getPDVTPARAM();
            if (StringHelper.isNullOrEmpty((String)strPDVTParam)) {
                strPDVTParam = psDEViewBase.getParamStringValue("SRFDATATYPE", "");
            }
            if (!StringHelper.isNullOrEmpty((String)strPDVTParam)) {
                sb.append(":%1$s", (Object)strPDVTParam);
            } else if (typePSCodeList != null && (psCodeItems = typePSCodeList.getPSCodeItems()) != null) {
                while (psCodeItems.hasNext()) {
                    IPSCodeItem iPSCodeItem = psCodeItems.next();
                    String strRDMode = String.format("%1$s:%2$s", sb.toString(), iPSCodeItem.getValue());
                    PSAppViewRef psAppViewRef = new PSAppViewRef();
                    String strViewParams = String.format("%1$s%2$s=%3$s", "SRFNAVCTX.", "srfdynainstid", iPSCodeItem.getData());
                    psAppViewRef.setVIEWPARAMS(strViewParams);
                    this.registerRedirectPSAppView(strRDMode, this.getPSApplication().getPSAppView(KeyValueHelper.genUniqueId((String)this.getPSApplication().getId(), (String)psDEViewBase.getPSDEVIEWBASEID()), psDEViewBase.getPSDEVIEWBASEID(), this), psAppViewRef);
                }
            }
            PSAppViewRef psAppViewRef = null;
            if (StringHelper.compare((String)psDEViewBase.getPSDEID(), (String)this.getPSDataEntity().getId(), (boolean)true) != 0) {
                psAppViewRef = new PSAppViewRef();
                String strCurDEName = null;
                strCurDEName = this.getPSAppDataEntity() != null ? this.getPSAppDataEntity().getCodeName() : this.getPSDataEntity().getCodeName();
                IPSDataEntity otherPSDataEntity = this.getPSSystem().getPSDataEntity2(psDEViewBase.getPSDEID());
                IPSAppDataEntity otherPSAppDataEntity = this.getPSApplication().getPSAppDataEntity(otherPSDataEntity, true);
                String strNextDEName = null;
                strNextDEName = otherPSAppDataEntity != null ? otherPSAppDataEntity.getCodeName() : otherPSDataEntity.getCodeName();
                String strViewParams = String.format("%1$s%2$s=%%%3$s%%", "SRFNAVCTX.", strNextDEName, strCurDEName);
                psAppViewRef.setVIEWPARAMS(strViewParams);
            }
            this.registerRedirectPSAppView(sb.toString(), this.getPSApplication().getPSAppView(KeyValueHelper.genUniqueId((String)this.getPSApplication().getId(), (String)psDEViewBase.getPSDEVIEWBASEID()), psDEViewBase.getPSDEVIEWBASEID(), this), psAppViewRef);
        }
        String strRefHeader = "RDITEM:";
        Iterator<String> refModes = this.getAppViewRefModes();
        if (refModes != null) {
            while (refModes.hasNext()) {
                String strRefMode = refModes.next();
                if (strRefMode.indexOf(strRefHeader) != 0) continue;
                IPSAppViewRef iPSAppViewRef = this.getPSAppViewRef(strRefMode, false);
                String strRDMode = strRefMode.substring(strRefHeader.length());
                PSAppViewRef psAppViewRef = null;
                if (iPSAppViewRef.getModelData() instanceof PSAppViewRef) {
                    psAppViewRef = (PSAppViewRef)iPSAppViewRef.getModelData();
                }
                this.registerRedirectPSAppView(strRDMode, iPSAppViewRef.getRefPSAppView(), psAppViewRef);
                this.refRedirectPSAppViewMap.put(strRDMode, iPSAppViewRef.getRefPSAppView());
            }
        }
    }

    @Override
    public int check() throws Exception {
        return super.check();
    }

    @Override
    public void fillRelatedPSAppViews(ArrayList<IPSAppView> relatedAppViewList) throws Exception {
        relatedAppViewList.addAll(this.redirectPSAppViewMap.values());
        super.fillRelatedPSAppViews(relatedAppViewList);
    }

    @Override
    public Iterator<String> getRefRedirectModes() {
        if (this.refRedirectPSAppViewMap.size() == 0) {
            return null;
        }
        return this.refRedirectPSAppViewMap.keySet().iterator();
    }

    @Override
    @PSModelRTMeta(description="\u81ea\u5b9a\u4e49\u83b7\u53d6\u6570\u636e\u884c\u4e3a")
    public boolean isEnableCustomGetDataAction() {
        return this.bEnableCustomGetDataAction;
    }

    @Override
    @PSModelRTMeta(description="\u83b7\u53d6\u6570\u636e\u884c\u4e3a")
    public IPSDEAction getGetDataPSDEAction() {
        return this.getDataPSDEAction;
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u7c7b\u578b\u8bc6\u522b\u5c5e\u6027")
    public IPSDEField getTypePSDEField() {
        return this.typePSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u83b7\u53d6\u6570\u636e\u5e94\u7528\u5b9e\u4f53\u884c\u4e3a", dumpref=true, from="IPSAppDataEntity", group="\u89c6\u56fe\u903b\u8f91", order=204)
    public IPSAppDEAction getGetDataPSAppDEAction() {
        return this.getDataPSAppDEAction;
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u5b9e\u4f53\u6570\u636e\u7c7b\u578b\u8bc6\u522b\u5c5e\u6027", dumpref=true, from="IPSAppDataEntity", group="\u89c6\u56fe\u903b\u8f91", order=204)
    public IPSAppDEField getTypePSAppDEField() {
        return this.typePSAppDEField;
    }

    @Override
    @PSModelRTMeta(description="\u91cd\u5b9a\u5411\u89c6\u56fe\u5f15\u7528\u96c6\u5408", child=true, group="\u89c6\u56fe\u903b\u8f91", order=215)
    public Iterator<IPSAppViewRef> getRedirectPSAppViewRefs() {
        if (this.redirectPSAppViewRefMap.size() == 0) {
            return null;
        }
        return this.redirectPSAppViewRefMap.values().iterator();
    }
}

