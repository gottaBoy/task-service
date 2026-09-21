/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Control.List;

import SA.SRFDA.PS.Core.App.View.IPSAppViewUIAction;
import SA.SRFDA.PS.Core.App.View.PSAppViewLogicImpl;
import SA.SRFDA.PS.Core.App.View.PSAppViewUIActionProxy;
import SA.SRFDA.PS.Core.Control.List.IPSDEMobMDCtrl;
import SA.SRFDA.PS.Core.Control.List.IPSDEMobMDCtrlParam;
import SA.SRFDA.PS.Core.Control.List.PSDEListImpl;
import SA.SRFDA.PS.Core.Control.List.PSDEListParamImpl;
import SA.SRFDA.PS.Core.Control.List.PSDEMobMDCtrlParamImpl;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.UIAction.IPSDEUIActionGroup;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.View.IPSUIAction;
import SA.SRFDA.PS.Core.View.IPSUIActionGroup;
import SA.SRFDA.PS.Core.View.IPSUIActionGroupDetail;
import SA.SRFDA.PS.Data.PSAppViewLogic;
import java.util.Iterator;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelImplementMeta(implement="IPSControl", typevalues={"MOBMDCTRL"})
public class PSDEMobMDCtrlImpl
extends PSDEListImpl
implements IPSDEMobMDCtrl {
    private static final Log log = LogFactory.getLog(PSDEMobMDCtrlImpl.class);
    private IPSDEMobMDCtrlParam iPSDEMobMDCtrlParam = null;
    private IPSDEUIActionGroup iPSDEUIActionGroup = null;
    private IPSDEUIActionGroup iPSDEUIActionGroup2 = null;
    private IPSDEUIActionGroup iPSDEUIActionGroup3 = null;
    private IPSDEUIActionGroup iPSDEUIActionGroup4 = null;
    private IPSDEUIActionGroup iPSDEUIActionGroup5 = null;
    private IPSDEUIActionGroup iPSDEUIActionGroup6 = null;

    @Override
    protected PSDEListParamImpl createPSDEListParam() {
        PSDEMobMDCtrlParamImpl psDEListParamImpl = new PSDEMobMDCtrlParamImpl();
        psDEListParamImpl.setPSSysPFPluginId(this.psDEList.getPSSYSPFPLUGINID());
        psDEListParamImpl.setPSAjaxControlHandlerId(this.psDEList.getPSACHANDLERID());
        psDEListParamImpl.setActiveDataPSDELogicId(this.psDEList.getADPSDELOGICID());
        psDEListParamImpl.setPSDEDataSetId(this.psDEList.getPSDEDSID());
        try {
            if (StringHelper.isNullOrEmpty((String)this.psDEList.getPSDEDSID()) && this.getPSDataEntity() != null && this.getPSDataEntity().getDefaultPSDEDataSet() != null) {
                psDEListParamImpl.setPSDEDataSetId(this.getPSDataEntity().getDefaultPSDEDataSet().getId());
            }
        }
        catch (Exception ex) {
            log.error((Object)ex);
        }
        if (!StringHelper.isNullOrEmpty((String)psDEListParamImpl.getPSDEDataSetId())) {
            psDEListParamImpl.setCustomCond(this.psDEList.getCUSTOMCOND());
        }
        return psDEListParamImpl;
    }

    @Override
    protected void onInit() throws Exception {
        String strNo2PSDEUIActionGroupId;
        this.iPSDEMobMDCtrlParam = (IPSDEMobMDCtrlParam)this.getPSAjaxControlParam();
        super.onInit();
        IPSDataEntity iPSDataEntity = this.getPSDataEntity();
        String strPSDEUIActionGroupId = this.iPSDEMobMDCtrlParam.getPSDEUIActionGroupId();
        if (StringHelper.isNullOrEmpty((String)strPSDEUIActionGroupId)) {
            strPSDEUIActionGroupId = this.psDEList.getPSDEUAGROUPID();
        }
        if (!StringHelper.isNullOrEmpty((String)strPSDEUIActionGroupId)) {
            if (this.iPSDEUIActionGroup == null && this.getPSAppDataEntity() != null) {
                this.iPSDEUIActionGroup = this.getPSAppDataEntity().getPSAppDEUIActionGroup(strPSDEUIActionGroupId, true, this);
            }
            if (this.iPSDEUIActionGroup == null) {
                this.iPSDEUIActionGroup = iPSDataEntity.getPSDEUIActionGroup(strPSDEUIActionGroupId);
            }
        }
        if (StringHelper.isNullOrEmpty((String)(strNo2PSDEUIActionGroupId = this.iPSDEMobMDCtrlParam.getNo2PSDEUIActionGroupId()))) {
            strNo2PSDEUIActionGroupId = this.psDEList.getNO2PSDEUAGROUPID();
        }
        if (!StringHelper.isNullOrEmpty((String)strNo2PSDEUIActionGroupId)) {
            if (this.iPSDEUIActionGroup2 == null && this.getPSAppDataEntity() != null) {
                this.iPSDEUIActionGroup2 = this.getPSAppDataEntity().getPSAppDEUIActionGroup(strNo2PSDEUIActionGroupId, true, this);
            }
            if (this.iPSDEUIActionGroup2 == null) {
                this.iPSDEUIActionGroup2 = iPSDataEntity.getPSDEUIActionGroup(strNo2PSDEUIActionGroupId);
            }
        }
        if (this.iPSDEUIActionGroup != null) {
            this.registerPSUIActionGroup(this.iPSDEUIActionGroup);
        }
        if (this.iPSDEUIActionGroup2 != null) {
            this.registerPSUIActionGroup(this.iPSDEUIActionGroup2);
        }
    }

    protected void registerPSUIActionGroup(IPSUIActionGroup iPSDEUIActionGroup) throws Exception {
        Iterator<IPSUIActionGroupDetail> psUIActionGroupDetails = iPSDEUIActionGroup.getPSUIActionGroupDetails();
        if (psUIActionGroupDetails != null) {
            while (psUIActionGroupDetails.hasNext()) {
                IPSUIActionGroupDetail iPSUIActionGroupDetail = psUIActionGroupDetails.next();
                IPSUIAction iPSUIAction = iPSUIActionGroupDetail.getPSUIAction();
                if (iPSUIAction == null) continue;
                if (this.isPrepareTemplV2logic()) {
                    PSAppViewUIActionProxy iPSAppViewUIAction = new PSAppViewUIActionProxy(this, iPSUIAction, this);
                    this.registerPSAppViewUIAction(iPSAppViewUIAction);
                    this.registerPSAppViewLogic(iPSAppViewUIAction, iPSUIActionGroupDetail);
                    continue;
                }
                this.getPSAppView().registerPSUIAction(iPSUIAction);
            }
        }
    }

    @Override
    public String getControlSubType() {
        if (StringHelper.isNullOrEmpty((String)this.getPSControlParam().getCtrlParam())) {
            return super.getControlSubType();
        }
        return this.getPSControlParam().getCtrlParam();
    }

    @Override
    @PSModelRTMeta(description="\u79fb\u52a8\u7aef\u5217\u8868\u6837\u5f0f", codelist="MobMDCtrlTypes")
    public String getMobListStyle() {
        if (StringHelper.isNullOrEmpty((String)this.getPSControlParam().getCtrlParam())) {
            return super.getMobListStyle();
        }
        return this.getPSControlParam().getCtrlParam();
    }

    @Override
    protected String onGetControlType() {
        return "MOBMDCTRL";
    }

    @Override
    @PSModelRTMeta(description="\u754c\u9762\u884c\u4e3a\u7ec4", hideempty2=true, child=true, fields={"PSDEUAGROUPID"})
    public IPSDEUIActionGroup getPSDEUIActionGroup() throws Exception {
        return this.iPSDEUIActionGroup;
    }

    @Override
    @PSModelRTMeta(description="\u754c\u9762\u884c\u4e3a\u7ec42", hideempty2=true, child=true, fields={"NO2PSDEUAGROUPID"})
    public IPSDEUIActionGroup getPSDEUIActionGroup2() throws Exception {
        return this.iPSDEUIActionGroup2;
    }

    @Override
    @PSModelRTMeta(description="\u754c\u9762\u884c\u4e3a\u7ec43", hideempty2=true, child=true)
    public IPSDEUIActionGroup getPSDEUIActionGroup3() throws Exception {
        return this.iPSDEUIActionGroup3;
    }

    @Override
    @PSModelRTMeta(description="\u754c\u9762\u884c\u4e3a\u7ec44", hideempty2=true, child=true)
    public IPSDEUIActionGroup getPSDEUIActionGroup4() throws Exception {
        return this.iPSDEUIActionGroup4;
    }

    @Override
    @PSModelRTMeta(description="\u754c\u9762\u884c\u4e3a\u7ec45", hideempty2=true, child=true)
    public IPSDEUIActionGroup getPSDEUIActionGroup5() throws Exception {
        return this.iPSDEUIActionGroup5;
    }

    @Override
    @PSModelRTMeta(description="\u754c\u9762\u884c\u4e3a\u7ec46", hideempty2=true, child=true)
    public IPSDEUIActionGroup getPSDEUIActionGroup6() throws Exception {
        return this.iPSDEUIActionGroup6;
    }

    protected void registerPSAppViewLogic(IPSAppViewUIAction iPSAppViewUIAction, IPSUIActionGroupDetail iPSUIActionGroupDetail) throws Exception {
        String strLogicTag = StringHelper.format((String)"%1$s_%2$s_click", (Object)this.getName(), (Object)iPSUIActionGroupDetail.getName()).toLowerCase();
        PSAppViewLogic psAppViewLogic = new PSAppViewLogic();
        psAppViewLogic.setPSAPPVIEWLOGICID(strLogicTag);
        psAppViewLogic.setPSAPPVIEWLOGICNAME(strLogicTag);
        psAppViewLogic.setDSTLOGICTYPE("APPVIEWUIACTION");
        psAppViewLogic.setPSAPPVIEWLOGICTYPE("CUSTOM");
        PSAppViewLogicImpl psAppDEViewLogicImpl = new PSAppViewLogicImpl();
        psAppDEViewLogicImpl.init(this.getDAGlobalHelper(), (Object)this, psAppViewLogic, iPSAppViewUIAction);
        this.registerPSAppViewLogic(psAppDEViewLogicImpl);
    }
}

