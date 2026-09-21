/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.control.list.IPSDEMobMDCtrl
 *  net.ibizsys.model.control.list.IPSDEMobMDCtrlParam
 *  net.ibizsys.model.dataentity.IPSDataEntity
 *  net.ibizsys.model.dataentity.uiaction.IPSDEUIActionGroup
 *  net.ibizsys.paas.util.StringHelper
 */
package net.ibizsys.model.control.list;

import net.ibizsys.model.PSModelRTMeta;
import net.ibizsys.model.control.list.IPSDEMobMDCtrl;
import net.ibizsys.model.control.list.IPSDEMobMDCtrlParam;
import net.ibizsys.model.control.list.PSDEListImpl;
import net.ibizsys.model.control.list.PSDEListParamImpl;
import net.ibizsys.model.control.list.PSDEMobMDCtrlParamImpl;
import net.ibizsys.model.dataentity.IPSDataEntity;
import net.ibizsys.model.dataentity.uiaction.IPSDEUIActionGroup;
import net.ibizsys.paas.util.StringHelper;

public class PSDEMobMDCtrlImpl
extends PSDEListImpl
implements IPSDEMobMDCtrl {
    private IPSDEMobMDCtrlParam iPSDEMobMDCtrlParam = null;
    private IPSDEUIActionGroup iPSDEUIActionGroup = null;
    private IPSDEUIActionGroup iPSDEUIActionGroup2 = null;
    private IPSDEUIActionGroup iPSDEUIActionGroup3 = null;
    private IPSDEUIActionGroup iPSDEUIActionGroup4 = null;
    private IPSDEUIActionGroup iPSDEUIActionGroup5 = null;
    private IPSDEUIActionGroup iPSDEUIActionGroup6 = null;

    @Override
    protected PSDEListParamImpl createPSDEListParam() {
        return new PSDEMobMDCtrlParamImpl();
    }

    @Override
    protected void onInit() throws Exception {
        this.iPSDEMobMDCtrlParam = (IPSDEMobMDCtrlParam)this.getPSAjaxControlParam();
        super.onInit();
        IPSDataEntity iPSDataEntity = this.getPSDataEntity();
        if (!StringHelper.isNullOrEmpty((String)this.iPSDEMobMDCtrlParam.getPSDEUIActionGroupId())) {
            this.iPSDEUIActionGroup = iPSDataEntity.getPSDEUIActionGroup(this.iPSDEMobMDCtrlParam.getPSDEUIActionGroupId());
        }
        if (!StringHelper.isNullOrEmpty((String)this.iPSDEMobMDCtrlParam.getNo2PSDEUIActionGroupId())) {
            this.iPSDEUIActionGroup2 = iPSDataEntity.getPSDEUIActionGroup(this.iPSDEMobMDCtrlParam.getNo2PSDEUIActionGroupId());
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
    public String getControlType() {
        return "MOBMDCTRL";
    }

    @PSModelRTMeta(description="\u754c\u9762\u884c\u4e3a\u7ec4", hideempty2=true)
    public IPSDEUIActionGroup getPSDEUIActionGroup() throws Exception {
        return this.iPSDEUIActionGroup;
    }

    @PSModelRTMeta(description="\u754c\u9762\u884c\u4e3a\u7ec42", hideempty2=true)
    public IPSDEUIActionGroup getPSDEUIActionGroup2() throws Exception {
        return this.iPSDEUIActionGroup2;
    }

    @PSModelRTMeta(description="\u754c\u9762\u884c\u4e3a\u7ec43", hideempty2=true)
    public IPSDEUIActionGroup getPSDEUIActionGroup3() throws Exception {
        return this.iPSDEUIActionGroup3;
    }

    @PSModelRTMeta(description="\u754c\u9762\u884c\u4e3a\u7ec44", hideempty2=true)
    public IPSDEUIActionGroup getPSDEUIActionGroup4() throws Exception {
        return this.iPSDEUIActionGroup4;
    }

    @PSModelRTMeta(description="\u754c\u9762\u884c\u4e3a\u7ec45", hideempty2=true)
    public IPSDEUIActionGroup getPSDEUIActionGroup5() throws Exception {
        return this.iPSDEUIActionGroup5;
    }

    @PSModelRTMeta(description="\u754c\u9762\u884c\u4e3a\u7ec46", hideempty2=true)
    public IPSDEUIActionGroup getPSDEUIActionGroup6() throws Exception {
        return this.iPSDEUIActionGroup6;
    }
}

