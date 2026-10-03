/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.wf.demodel;


import java.io.Serializable;
import java.util.ArrayList;

import org.hibernate.SessionFactory;

import net.ibizsys.paas.core.DEDataSetCond;
import net.ibizsys.paas.logic.ICondition;
import net.ibizsys.paas.core.IDEDataSetCond;
import net.ibizsys.paas.core.ISystem;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.sysmodel.SysModelGlobal;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.view.IView;
import net.ibizsys.paas.core.IDEFSearchMode;
import net.ibizsys.paas.core.IDEField;
import net.ibizsys.paas.demodel.DEFSearchModeModel;
import net.ibizsys.paas.demodel.DEFieldModel;
import net.ibizsys.paas.demodel.DEMainStateModel;
import net.ibizsys.paas.demodel.DEDataSyncModel;
import net.ibizsys.paas.demodel.DEActionWizardGroupModel;
import net.ibizsys.paas.demodel.DEActionWizardModel;
import net.ibizsys.paas.demodel.DEDataSetDEAWModel;
import net.ibizsys.paas.demodel.DEActionWizardItemModel;
import net.ibizsys.paas.demodel.DEOPPrivRoleModel;
import net.ibizsys.paas.demodel.DEUniStateModel;
import net.ibizsys.paas.demodel.DEUserRoleModel;
import net.ibizsys.paas.demodel.IDEActionWizardModel;
import net.ibizsys.paas.demodel.DEBATableModel;
import net.ibizsys.psrt.srv.PSRuntimeSysModel;

import net.ibizsys.psrt.srv.wf.demodel.wfucpolicy.ac.*;
import net.ibizsys.psrt.srv.wf.demodel.wfucpolicy.dataset.*;
import net.ibizsys.psrt.srv.wf.demodel.wfucpolicy.dataquery.*;
import net.ibizsys.psrt.srv.wf.demodel.wfucpolicy.uiaction.*;
import net.ibizsys.psrt.srv.wf.entity.WFUCPolicy;
import net.ibizsys.psrt.srv.wf.service.WFUCPolicyService;

/**
 * 实体[WFUCPOLICY]模型对象基类
 */
public abstract class WFUCPolicyDEModelBase extends net.ibizsys.paas.demodel.DataEntityModelBase<WFUCPolicy>  {

    public WFUCPolicyDEModelBase() throws Exception {
        super();

        this.setId("fa6ff2a161c8371f494e170dde6ddb53");
        this.setName("WFUCPOLICY");
        this.setTableName("T_SRFWFUCPOLICY");
        this.setViewName("v_WFUCPOLICY");
        this.setLogicName("工作流候选用户策略");
        this.setDSLink("DEFAULT");
        this.setDataAccCtrlMode(1);
        this.setAuditMode(0);
        if(isRegisterToDEModelGlobal()) {
            DEModelGlobal.registerDEModel("net.ibizsys.psrt.srv.wf.demodel.WFUCPolicyDEModel",this);
            //注册到系统中
            this.getPSRuntimeSysModel().registerDataEntityModel(this);
        }
        this.prepareModels();
    }


    private PSRuntimeSysModel pSRuntimeSysModel;
    /**
     * 获取当前系统[PSRuntime]模型对象
     * @return
     */
    public  PSRuntimeSysModel getPSRuntimeSysModel() {
        if(this.pSRuntimeSysModel==null) {
            try {
                this.pSRuntimeSysModel = (PSRuntimeSysModel)SysModelGlobal.getSystem("net.ibizsys.psrt.srv.PSRuntimeSysModel");
            } catch(Exception ex) {
            }
        }
        return this.pSRuntimeSysModel;
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.demodel.DataEntityModelBase#getSystem()
     */
    @Override
    public  ISystem getSystem() {
        return this.getPSRuntimeSysModel();
    }

    private WFUCPolicyService wFUCPolicyService;

    /**
     * 获取实际实体服务对象
     * @return
     */
    public  WFUCPolicyService getRealService() {
        if(this.wFUCPolicyService==null) {
            try {
                this.wFUCPolicyService = (WFUCPolicyService)ServiceGlobal.getService(getServiceId());
            } catch(Exception ex) {
            }
        }
        return this.wFUCPolicyService;
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.demodel.IDataEntityModel#getService()
     */
    @Override
    public IService getService() {
        return this.getRealService();
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.demodel.IDataEntityModel#getServiceId()
     */
    @Override
    public String getServiceId() {
        return "net.ibizsys.psrt.srv.wf.service.WFUCPolicyService";
    }


    /* (non-Javadoc)
     * @see net.ibizsys.paas.demodel.IDataEntityModel#createEntity()
     */
    @Override
    public WFUCPolicy createEntity() {
        return new WFUCPolicy();
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.demodel.DataEntityModelBase#prepareDEFields()
     */
    @Override
    protected void prepareDEFields() throws Exception {
        IDEField iDEField = null;
        IDEFSearchMode iDEFSearchMode = null;
        //注册属性 "BEGINTIME"
        iDEField = this.createDEField("BEGINTIME");
        if(iDEField==null) {
            DEFieldModel deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("4524921b0097a3153310acc103b880e0");
            deFieldModel.setName("BEGINTIME");
            deFieldModel.setDEFType(1);
            deFieldModel.setLogicName("开始时间");
            deFieldModel.setDataType("DATETIME");
            deFieldModel.setStdDataType(5);
            deFieldModel.setImportOrder(1000);
            deFieldModel.setImportTag("");
            deFieldModel.setValueFormat("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS");
            deFieldModel.init();
            iDEField = deFieldModel;
        }
        this.registerDEField(iDEField);
        //注册属性 "CREATEDATE"
        iDEField = this.createDEField("CREATEDATE");
        if(iDEField==null) {
            DEFieldModel deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("7bad0001aaf07769a34d74e1d2226e2a");
            deFieldModel.setName("CREATEDATE");
            deFieldModel.setDEFType(1);
            deFieldModel.setLogicName("建立时间");
            deFieldModel.setDataType("DATETIME");
            deFieldModel.setStdDataType(5);
            deFieldModel.setImportOrder(1000);
            deFieldModel.setImportTag("");
            deFieldModel.setPreDefinedType("CREATEDATE");
            deFieldModel.setValueFormat("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS");
            deFieldModel.init();
            iDEField = deFieldModel;
        }
        this.registerDEField(iDEField);
        //注册属性 "CREATEMAN"
        iDEField = this.createDEField("CREATEMAN");
        if(iDEField==null) {
            DEFieldModel deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("b811e99c2a9d852435322b69223a24e8");
            deFieldModel.setName("CREATEMAN");
            deFieldModel.setDEFType(1);
            deFieldModel.setLogicName("建立人");
            deFieldModel.setDataType("TEXT");
            deFieldModel.setStdDataType(25);
            deFieldModel.setImportOrder(1000);
            deFieldModel.setImportTag("");
            deFieldModel.setPreDefinedType("CREATEMAN");
            deFieldModel.setCodeListId("net.ibizsys.psrt.srv.codelist.SysOperatorCodeListModel");
            deFieldModel.setValueFormat("%1$s");
            deFieldModel.init();
            iDEField = deFieldModel;
        }
        this.registerDEField(iDEField);
        //注册属性 "ENDTIME"
        iDEField = this.createDEField("ENDTIME");
        if(iDEField==null) {
            DEFieldModel deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("68daaa6964e7dca38d318dce40113b06");
            deFieldModel.setName("ENDTIME");
            deFieldModel.setDEFType(1);
            deFieldModel.setLogicName("结束时间");
            deFieldModel.setDataType("DATETIME");
            deFieldModel.setStdDataType(5);
            deFieldModel.setImportOrder(1000);
            deFieldModel.setImportTag("");
            deFieldModel.setValueFormat("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS");
            deFieldModel.init();
            iDEField = deFieldModel;
        }
        this.registerDEField(iDEField);
        //注册属性 "MAJORWFUSERID"
        iDEField = this.createDEField("MAJORWFUSERID");
        if(iDEField==null) {
            DEFieldModel deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("a35a727cda8a3d542852ade71827ff78");
            deFieldModel.setName("MAJORWFUSERID");
            deFieldModel.setDEFType(1);
            deFieldModel.setLogicName("工作流用户");
            deFieldModel.setDataType("PICKUP");
            deFieldModel.setStdDataType(25);
            deFieldModel.setLinkDEField(true);
            deFieldModel.setImportOrder(1000);
            deFieldModel.setImportTag("");
            deFieldModel.setDERName("DER1N_WFUCPOLICY_WFUSER_MAJORWFUSERID");
            deFieldModel.setLinkDEFName("WFUSERID");
            deFieldModel.setValueFormat("%1$s");
            iDEFSearchMode = this.createDEFSearchMode(deFieldModel,"N_MAJORWFUSERID_EQ");
            if(iDEFSearchMode==null) {
                DEFSearchModeModel defSearchModeModel = new DEFSearchModeModel();
                defSearchModeModel.setDEField(deFieldModel);
                defSearchModeModel.setName("N_MAJORWFUSERID_EQ");
                defSearchModeModel.setValueOp("EQ");
                defSearchModeModel.init();
                deFieldModel.registerDEFSearchMode(defSearchModeModel);
            }
            deFieldModel.init();
            iDEField = deFieldModel;
        }
        this.registerDEField(iDEField);
        //注册属性 "MAJORWFUSERNAME"
        iDEField = this.createDEField("MAJORWFUSERNAME");
        if(iDEField==null) {
            DEFieldModel deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("b2980d757878044cbfe91157c4d3dda1");
            deFieldModel.setName("MAJORWFUSERNAME");
            deFieldModel.setDEFType(3);
            deFieldModel.setLogicName("工作流用户");
            deFieldModel.setDataType("PICKUPTEXT");
            deFieldModel.setStdDataType(25);
            deFieldModel.setLinkDEField(true);
            deFieldModel.setImportOrder(1000);
            deFieldModel.setImportTag("");
            deFieldModel.setDERName("DER1N_WFUCPOLICY_WFUSER_MAJORWFUSERID");
            deFieldModel.setLinkDEFName("WFUSERNAME");
            deFieldModel.setPhisicalDEField(false);
            deFieldModel.setValueFormat("%1$s");
            iDEFSearchMode = this.createDEFSearchMode(deFieldModel,"N_MAJORWFUSERNAME_EQ");
            if(iDEFSearchMode==null) {
                DEFSearchModeModel defSearchModeModel = new DEFSearchModeModel();
                defSearchModeModel.setDEField(deFieldModel);
                defSearchModeModel.setName("N_MAJORWFUSERNAME_EQ");
                defSearchModeModel.setValueOp("EQ");
                defSearchModeModel.init();
                deFieldModel.registerDEFSearchMode(defSearchModeModel);
            }
            iDEFSearchMode = this.createDEFSearchMode(deFieldModel,"N_MAJORWFUSERNAME_LIKE");
            if(iDEFSearchMode==null) {
                DEFSearchModeModel defSearchModeModel = new DEFSearchModeModel();
                defSearchModeModel.setDEField(deFieldModel);
                defSearchModeModel.setName("N_MAJORWFUSERNAME_LIKE");
                defSearchModeModel.setValueOp("LIKE");
                defSearchModeModel.init();
                deFieldModel.registerDEFSearchMode(defSearchModeModel);
            }
            deFieldModel.init();
            iDEField = deFieldModel;
        }
        this.registerDEField(iDEField);
        //注册属性 "MEMO"
        iDEField = this.createDEField("MEMO");
        if(iDEField==null) {
            DEFieldModel deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("b34bdbad2c98d3e84bb2c159530584eb");
            deFieldModel.setName("MEMO");
            deFieldModel.setDEFType(1);
            deFieldModel.setLogicName("备注");
            deFieldModel.setDataType("LONGTEXT_1000");
            deFieldModel.setStdDataType(25);
            deFieldModel.setImportOrder(1000);
            deFieldModel.setImportTag("");
            deFieldModel.setValueFormat("%1$s");
            deFieldModel.init();
            iDEField = deFieldModel;
        }
        this.registerDEField(iDEField);
        //注册属性 "MINORWFUSERID"
        iDEField = this.createDEField("MINORWFUSERID");
        if(iDEField==null) {
            DEFieldModel deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("693f380bd70ae7f94670bfddf82b9eab");
            deFieldModel.setName("MINORWFUSERID");
            deFieldModel.setDEFType(1);
            deFieldModel.setLogicName("候选用户");
            deFieldModel.setDataType("PICKUP");
            deFieldModel.setStdDataType(25);
            deFieldModel.setLinkDEField(true);
            deFieldModel.setImportOrder(1000);
            deFieldModel.setImportTag("");
            deFieldModel.setDERName("DER1N_WFUCPOLICY_WFUSER_MINORWFUSERID");
            deFieldModel.setLinkDEFName("WFUSERID");
            deFieldModel.setValueFormat("%1$s");
            iDEFSearchMode = this.createDEFSearchMode(deFieldModel,"N_MINORWFUSERID_EQ");
            if(iDEFSearchMode==null) {
                DEFSearchModeModel defSearchModeModel = new DEFSearchModeModel();
                defSearchModeModel.setDEField(deFieldModel);
                defSearchModeModel.setName("N_MINORWFUSERID_EQ");
                defSearchModeModel.setValueOp("EQ");
                defSearchModeModel.init();
                deFieldModel.registerDEFSearchMode(defSearchModeModel);
            }
            deFieldModel.init();
            iDEField = deFieldModel;
        }
        this.registerDEField(iDEField);
        //注册属性 "MINORWFUSERNAME"
        iDEField = this.createDEField("MINORWFUSERNAME");
        if(iDEField==null) {
            DEFieldModel deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("7eb92b2a7515a487716bc2e456bb0922");
            deFieldModel.setName("MINORWFUSERNAME");
            deFieldModel.setDEFType(3);
            deFieldModel.setLogicName("候选用户");
            deFieldModel.setDataType("PICKUPTEXT");
            deFieldModel.setStdDataType(25);
            deFieldModel.setLinkDEField(true);
            deFieldModel.setImportOrder(1000);
            deFieldModel.setImportTag("");
            deFieldModel.setDERName("DER1N_WFUCPOLICY_WFUSER_MINORWFUSERID");
            deFieldModel.setLinkDEFName("WFUSERNAME");
            deFieldModel.setPhisicalDEField(false);
            deFieldModel.setValueFormat("%1$s");
            iDEFSearchMode = this.createDEFSearchMode(deFieldModel,"N_MINORWFUSERNAME_EQ");
            if(iDEFSearchMode==null) {
                DEFSearchModeModel defSearchModeModel = new DEFSearchModeModel();
                defSearchModeModel.setDEField(deFieldModel);
                defSearchModeModel.setName("N_MINORWFUSERNAME_EQ");
                defSearchModeModel.setValueOp("EQ");
                defSearchModeModel.init();
                deFieldModel.registerDEFSearchMode(defSearchModeModel);
            }
            iDEFSearchMode = this.createDEFSearchMode(deFieldModel,"N_MINORWFUSERNAME_LIKE");
            if(iDEFSearchMode==null) {
                DEFSearchModeModel defSearchModeModel = new DEFSearchModeModel();
                defSearchModeModel.setDEField(deFieldModel);
                defSearchModeModel.setName("N_MINORWFUSERNAME_LIKE");
                defSearchModeModel.setValueOp("LIKE");
                defSearchModeModel.init();
                deFieldModel.registerDEFSearchMode(defSearchModeModel);
            }
            deFieldModel.init();
            iDEField = deFieldModel;
        }
        this.registerDEField(iDEField);
        //注册属性 "POLICYSTATE"
        iDEField = this.createDEField("POLICYSTATE");
        if(iDEField==null) {
            DEFieldModel deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("6668a3295f044f3e4fa3a5b313678e1a");
            deFieldModel.setName("POLICYSTATE");
            deFieldModel.setDEFType(1);
            deFieldModel.setLogicName("策略状态");
            deFieldModel.setDataType("NSCODELIST");
            deFieldModel.setStdDataType(9);
            deFieldModel.setImportOrder(1000);
            deFieldModel.setImportTag("");
            deFieldModel.setCodeListId("net.ibizsys.psrt.srv.codelist.WFUCPolicyStateCodeListModel");
            deFieldModel.setValueFormat("%1$s");
            iDEFSearchMode = this.createDEFSearchMode(deFieldModel,"N_POLICYSTATE_EQ");
            if(iDEFSearchMode==null) {
                DEFSearchModeModel defSearchModeModel = new DEFSearchModeModel();
                defSearchModeModel.setDEField(deFieldModel);
                defSearchModeModel.setName("N_POLICYSTATE_EQ");
                defSearchModeModel.setValueOp("EQ");
                defSearchModeModel.init();
                deFieldModel.registerDEFSearchMode(defSearchModeModel);
            }
            deFieldModel.init();
            iDEField = deFieldModel;
        }
        this.registerDEField(iDEField);
        //注册属性 "UPDATEDATE"
        iDEField = this.createDEField("UPDATEDATE");
        if(iDEField==null) {
            DEFieldModel deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("5c89b30bb06d43dc6306ddade7ccea79");
            deFieldModel.setName("UPDATEDATE");
            deFieldModel.setDEFType(1);
            deFieldModel.setLogicName("更新时间");
            deFieldModel.setDataType("DATETIME");
            deFieldModel.setStdDataType(5);
            deFieldModel.setImportOrder(1000);
            deFieldModel.setImportTag("");
            deFieldModel.setPreDefinedType("UPDATEDATE");
            deFieldModel.setValueFormat("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS");
            deFieldModel.init();
            iDEField = deFieldModel;
        }
        this.registerDEField(iDEField);
        //注册属性 "UPDATEMAN"
        iDEField = this.createDEField("UPDATEMAN");
        if(iDEField==null) {
            DEFieldModel deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("b8209dcdc9f82192ee75d2e649922228");
            deFieldModel.setName("UPDATEMAN");
            deFieldModel.setDEFType(1);
            deFieldModel.setLogicName("更新人");
            deFieldModel.setDataType("TEXT");
            deFieldModel.setStdDataType(25);
            deFieldModel.setImportOrder(1000);
            deFieldModel.setImportTag("");
            deFieldModel.setPreDefinedType("UPDATEMAN");
            deFieldModel.setCodeListId("net.ibizsys.psrt.srv.codelist.SysOperatorCodeListModel");
            deFieldModel.setValueFormat("%1$s");
            deFieldModel.init();
            iDEField = deFieldModel;
        }
        this.registerDEField(iDEField);
        //注册属性 "USERDATA"
        iDEField = this.createDEField("USERDATA");
        if(iDEField==null) {
            DEFieldModel deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("83e668198635603a73aaeb03d52d6dfc");
            deFieldModel.setName("USERDATA");
            deFieldModel.setDEFType(1);
            deFieldModel.setLogicName("用户数据");
            deFieldModel.setDataType("TEXT");
            deFieldModel.setStdDataType(25);
            deFieldModel.setImportOrder(1000);
            deFieldModel.setImportTag("");
            deFieldModel.setValueFormat("%1$s");
            deFieldModel.init();
            iDEField = deFieldModel;
        }
        this.registerDEField(iDEField);
        //注册属性 "USERDATA2"
        iDEField = this.createDEField("USERDATA2");
        if(iDEField==null) {
            DEFieldModel deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("ab869207d39e69c790be6bd4e777a18a");
            deFieldModel.setName("USERDATA2");
            deFieldModel.setDEFType(1);
            deFieldModel.setLogicName("用户数据2");
            deFieldModel.setDataType("TEXT");
            deFieldModel.setStdDataType(25);
            deFieldModel.setImportOrder(1000);
            deFieldModel.setImportTag("");
            deFieldModel.setValueFormat("%1$s");
            deFieldModel.init();
            iDEField = deFieldModel;
        }
        this.registerDEField(iDEField);
        //注册属性 "VALIDFLAG"
        iDEField = this.createDEField("VALIDFLAG");
        if(iDEField==null) {
            DEFieldModel deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("b539615c252ad4734348a713a518aa7a");
            deFieldModel.setName("VALIDFLAG");
            deFieldModel.setDEFType(1);
            deFieldModel.setLogicName("是否启用");
            deFieldModel.setDataType("YESNO");
            deFieldModel.setStdDataType(9);
            deFieldModel.setImportOrder(1000);
            deFieldModel.setImportTag("");
            deFieldModel.setCodeListId("net.ibizsys.psrt.srv.codelist.YesNoCodeListModel");
            deFieldModel.setValueFormat("%1$s");
            deFieldModel.init();
            iDEField = deFieldModel;
        }
        this.registerDEField(iDEField);
        //注册属性 "WFUCPOLICYID"
        iDEField = this.createDEField("WFUCPOLICYID");
        if(iDEField==null) {
            DEFieldModel deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("30bd9aa9621fc1403bf9f4c92cf05991");
            deFieldModel.setName("WFUCPOLICYID");
            deFieldModel.setDEFType(1);
            deFieldModel.setLogicName("工作流候选用户策略标识");
            deFieldModel.setDataType("GUID");
            deFieldModel.setStdDataType(25);
            deFieldModel.setKeyDEField(true);
            deFieldModel.setImportOrder(1000);
            deFieldModel.setImportTag("");
            deFieldModel.setValueFormat("%1$s");
            deFieldModel.init();
            iDEField = deFieldModel;
        }
        this.registerDEField(iDEField);
        //注册属性 "WFUCPOLICYNAME"
        iDEField = this.createDEField("WFUCPOLICYNAME");
        if(iDEField==null) {
            DEFieldModel deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("d04ca432a46f7ce1e2ccf2f2799268ab");
            deFieldModel.setName("WFUCPOLICYNAME");
            deFieldModel.setDEFType(1);
            deFieldModel.setLogicName("工作流候选用户策略名称");
            deFieldModel.setDataType("TEXT");
            deFieldModel.setStdDataType(25);
            deFieldModel.setMajorDEField(true);
            deFieldModel.setImportOrder(1000);
            deFieldModel.setImportTag("");
            deFieldModel.setValueFormat("%1$s");
            iDEFSearchMode = this.createDEFSearchMode(deFieldModel,"N_WFUCPOLICYNAME_LIKE");
            if(iDEFSearchMode==null) {
                DEFSearchModeModel defSearchModeModel = new DEFSearchModeModel();
                defSearchModeModel.setDEField(deFieldModel);
                defSearchModeModel.setName("N_WFUCPOLICYNAME_LIKE");
                defSearchModeModel.setValueOp("LIKE");
                defSearchModeModel.init();
                deFieldModel.registerDEFSearchMode(defSearchModeModel);
            }
            deFieldModel.init();
            iDEField = deFieldModel;
        }
        this.registerDEField(iDEField);

    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.demodel.DataEntityModelBase#prepareDEACModes()
     */
    @Override
    protected void prepareDEACModes() throws Exception {
        //注册  DEFAULT
        WFUCPolicyDefaultACModel _defaultACModel = new WFUCPolicyDefaultACModel();
        _defaultACModel.init(this);
        this.registerDEACMode(_defaultACModel);
    }

    /* (non-Javadoc)
    * @see net.ibizsys.paas.demodel.DataEntityModelBase#prepareDEDBConfigs()
    */
    @Override
    protected void prepareDEDBConfigs() throws Exception {
        net.ibizsys.paas.demodel.DEDBConfigModel mYSQL5ConfigModel = new net.ibizsys.paas.demodel.DEDBConfigModel();
        mYSQL5ConfigModel.setDBType("MYSQL5");
        mYSQL5ConfigModel.setTableName("t_srfwfucpolicy");
        mYSQL5ConfigModel.setViewName("v_wfucpolicy");
        this.registerDEDBConfig(mYSQL5ConfigModel);
    }


    /* (non-Javadoc)
     * @see net.ibizsys.paas.demodel.DataEntityModelBase#prepareDEDataSets()
     */
    @Override
    protected void prepareDEDataSets() throws Exception {
        //注册  DEFAULT
        WFUCPolicyDefaultDSModel _defaultDSModel = new WFUCPolicyDefaultDSModel();
        _defaultDSModel.init(this);
        this.registerDEDataSet(_defaultDSModel);
    }




    /* (non-Javadoc)
     * @see net.ibizsys.paas.demodel.DataEntityModelBase#prepareDEDataQueries()
     */
    @Override
    protected void prepareDEDataQueries() throws Exception {
        //注册  DEFAULT
        WFUCPolicyDefaultDQModel _defaultDQModel = new WFUCPolicyDefaultDQModel();
        _defaultDQModel.init(this);
        this.registerDEDataQuery(_defaultDQModel);
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.demodel.DataEntityModelBase#prepareDEActions()
     */
    @Override
    protected void prepareDEActions() throws Exception {

    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.demodel.DataEntityModelBase#prepareDELogics()
     */
    @Override
    protected void prepareDELogics() throws Exception {
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.demodel.DataEntityModelBase#prepareDEUIActions()
    */
    @Override
    protected void prepareDEUIActions() throws Exception {
        //注册  禁用策略
        WFUCPolicyDisablePolicyUIActionModel disablePolicyUIActionModel = new WFUCPolicyDisablePolicyUIActionModel();
        disablePolicyUIActionModel.init(this);
        this.registerDEUIAction(disablePolicyUIActionModel);
        //注册  启用策略
        WFUCPolicyEnablePolicyUIActionModel enablePolicyUIActionModel = new WFUCPolicyEnablePolicyUIActionModel();
        enablePolicyUIActionModel.init(this);
        this.registerDEUIAction(enablePolicyUIActionModel);
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.demodel.DataEntityModelBase#prepareDEWFs()
     */
    @Override
    protected void prepareDEWFs() throws Exception {
    }


    /* (non-Javadoc)
     * @see net.ibizsys.paas.demodel.DataEntityModelBase#prepareDEUniStates()
     */
    @Override
    protected void prepareDEUniStates() throws Exception {
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.demodel.DataEntityModelBase#prepareDEMainStates()
     */
    @Override
    protected void prepareDEMainStates() throws Exception {
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.demodel.DataEntityModelBase#prepareDEDataSyncs()
     */
    @Override
    protected void prepareDEDataSyncs() throws Exception {
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.demodel.DataEntityModelBase#preparePDTDEViews()
     */
    @Override
    protected void preparePDTDEViews() throws Exception {
        //注册视图 工作流候选用户策略实体表格视图
        this.registerPDTDEView("MDATAVIEW","ffa6e3e36a78805de78c413274f56691");
        //注册视图 工作流候选用户策略实体数据多项选择视图
        this.registerPDTDEView("MPICKUPVIEW","11ed03a6a6adbf05926438afb54d2b65");
        //注册视图 工作流候选用户策略实体数据选择视图
        this.registerPDTDEView("PICKUPVIEW","4cc3a1ba9d575615682ddc3e862a3a5c");
        //注册视图 工作流候选用户策略实体数据重定向视图
        this.registerPDTDEView("REDIRECTVIEW","3bec4a979de98ae49c863a041f3079f5");
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.demodel.DataEntityModelBase#prepareDEOPPrivTagMaps()
     */
    @Override
    protected void prepareDEOPPrivTagMaps()throws Exception {
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.demodel.DataEntityModelBase#prepareDEPrints()
     */
    @Override
    protected void prepareDEPrints()throws Exception {
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.demodel.DataEntityModelBase#prepareDEReports()
     */
    @Override
    protected void prepareDEReports()throws Exception {
    }


    /* (non-Javadoc)
     * @see net.ibizsys.paas.demodel.DataEntityModelBase#prepareDEDataExports()
     */
    @Override
    protected void prepareDEDataExports() throws Exception {
    }


    /* (non-Javadoc)
     * @see net.ibizsys.paas.demodel.DataEntityModelBase#prepareDEActionWizards()
     */
    @Override
    protected void prepareDEActionWizards() throws Exception {
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.demodel.DataEntityModelBase#prepareDEActionWizardGroups()
     */
    @Override
    protected void prepareDEActionWizardGroups() throws Exception {
    }


    /* (non-Javadoc)
     * @see net.ibizsys.paas.demodel.DataEntityModelBase#prepareDEBATables()
     */
    @Override
    protected void prepareDEBATables() throws Exception {
    }


    /* (non-Javadoc)
     * @see net.ibizsys.paas.demodel.DataEntityModelBase#prepareDEUserRoles()
     */
    @Override
    protected void prepareDEUserRoles() throws Exception {
    }


    /* (non-Javadoc)
     * @see net.ibizsys.paas.demodel.DataEntityModelBase#prepareDEOPPrivRoles()
     */
    @Override
    protected void prepareDEOPPrivRoles() throws Exception {
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.demodel.DataEntityModelBase#onFillFetchQuickSearchConditions(net.ibizsys.paas.core.DEDataSetCond, java.lang.String)
     */
    @Override
    protected void onFillFetchQuickSearchConditions(DEDataSetCond groupCondImpl,String strQuickSearch)  throws Exception {
        super.onFillFetchQuickSearchConditions(groupCondImpl,strQuickSearch);

        //放入属性 WFUCPOLICYNAME - 工作流候选用户策略名称
        if(true) {
            DEDataSetCond deDataSetCondImpl = new DEDataSetCond();
            deDataSetCondImpl.setCondType(IDEDataSetCond.CONDTYPE_DEFIELD);
            deDataSetCondImpl.setCondOp(ICondition.CONDOP_LIKE);
            deDataSetCondImpl.setDEFName(WFUCPolicy.FIELD_WFUCPOLICYNAME);
            deDataSetCondImpl.setCondValue(strQuickSearch);
            groupCondImpl.addChildDEDataQueryCond(deDataSetCondImpl);
        }
    }
}