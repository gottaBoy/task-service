/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.common.demodel;


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

import net.ibizsys.psrt.srv.common.demodel.orguserlevel.ac.*;
import net.ibizsys.psrt.srv.common.demodel.orguserlevel.dataset.*;
import net.ibizsys.psrt.srv.common.demodel.orguserlevel.dataquery.*;
import net.ibizsys.psrt.srv.common.entity.OrgUserLevel;
import net.ibizsys.psrt.srv.common.service.OrgUserLevelService;

/**
 * 实体[ORGUSERLEVEL]模型对象基类
 */
public abstract class OrgUserLevelDEModelBase extends net.ibizsys.paas.demodel.DataEntityModelBase<OrgUserLevel>  {

    public OrgUserLevelDEModelBase() throws Exception {
        super();

        this.setId("e6c870c62a861cfd5593212fa41d6f88");
        this.setName("ORGUSERLEVEL");
        this.setTableName("T_SRFORGUSERLEVEL");
        this.setViewName("v_ORGUSERLEVEL");
        this.setLogicName("组织人员级别");
        this.setDSLink("DEFAULT");
        this.setDataAccCtrlMode(1);
        this.setAuditMode(0);
        if(isRegisterToDEModelGlobal()) {
            DEModelGlobal.registerDEModel("net.ibizsys.psrt.srv.common.demodel.OrgUserLevelDEModel",this);
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

    private OrgUserLevelService orgUserLevelService;

    /**
     * 获取实际实体服务对象
     * @return
     */
    public  OrgUserLevelService getRealService() {
        if(this.orgUserLevelService==null) {
            try {
                this.orgUserLevelService = (OrgUserLevelService)ServiceGlobal.getService(getServiceId());
            } catch(Exception ex) {
            }
        }
        return this.orgUserLevelService;
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
        return "net.ibizsys.psrt.srv.common.service.OrgUserLevelService";
    }


    /* (non-Javadoc)
     * @see net.ibizsys.paas.demodel.IDataEntityModel#createEntity()
     */
    @Override
    public OrgUserLevel createEntity() {
        return new OrgUserLevel();
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.demodel.DataEntityModelBase#prepareDEFields()
     */
    @Override
    protected void prepareDEFields() throws Exception {
        IDEField iDEField = null;
        IDEFSearchMode iDEFSearchMode = null;
        //注册属性 "CREATEDATE"
        iDEField = this.createDEField("CREATEDATE");
        if(iDEField==null) {
            DEFieldModel deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("8fbd6a75362869cb3e90b7522d73b8ee");
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
            deFieldModel.setId("17b73c83afe018b2ebd42eb97a319499");
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
        //注册属性 "LEVELCODE"
        iDEField = this.createDEField("LEVELCODE");
        if(iDEField==null) {
            DEFieldModel deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("63b5cea15fafd945e1d7ea73978ad510");
            deFieldModel.setName("LEVELCODE");
            deFieldModel.setDEFType(1);
            deFieldModel.setLogicName("级别代码");
            deFieldModel.setDataType("TEXT");
            deFieldModel.setStdDataType(25);
            deFieldModel.setImportOrder(1000);
            deFieldModel.setImportTag("");
            deFieldModel.setValueFormat("%1$s");
            deFieldModel.init();
            iDEField = deFieldModel;
        }
        this.registerDEField(iDEField);
        //注册属性 "MEMO"
        iDEField = this.createDEField("MEMO");
        if(iDEField==null) {
            DEFieldModel deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("8a694838784453d1de8044f3face8c55");
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
        //注册属性 "ORDERVALUE"
        iDEField = this.createDEField("ORDERVALUE");
        if(iDEField==null) {
            DEFieldModel deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("2f458512fbe6eed9d3c7efbd9c94d0f0");
            deFieldModel.setName("ORDERVALUE");
            deFieldModel.setDEFType(1);
            deFieldModel.setLogicName("排序值");
            deFieldModel.setDataType("INT");
            deFieldModel.setStdDataType(9);
            deFieldModel.setImportOrder(1000);
            deFieldModel.setImportTag("");
            deFieldModel.setValueFormat("%1$s");
            deFieldModel.init();
            iDEField = deFieldModel;
        }
        this.registerDEField(iDEField);
        //注册属性 "ORGUSERLEVELID"
        iDEField = this.createDEField("ORGUSERLEVELID");
        if(iDEField==null) {
            DEFieldModel deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("b955becd53942b7e38276a19ef8d8c56");
            deFieldModel.setName("ORGUSERLEVELID");
            deFieldModel.setDEFType(1);
            deFieldModel.setLogicName("组织人员级别标识");
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
        //注册属性 "ORGUSERLEVELNAME"
        iDEField = this.createDEField("ORGUSERLEVELNAME");
        if(iDEField==null) {
            DEFieldModel deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("c3839aa63577786d5e38a99426741581");
            deFieldModel.setName("ORGUSERLEVELNAME");
            deFieldModel.setDEFType(1);
            deFieldModel.setLogicName("人员级别名称");
            deFieldModel.setDataType("TEXT");
            deFieldModel.setStdDataType(25);
            deFieldModel.setMajorDEField(true);
            deFieldModel.setImportOrder(1000);
            deFieldModel.setImportTag("");
            deFieldModel.setValueFormat("%1$s");
            iDEFSearchMode = this.createDEFSearchMode(deFieldModel,"N_ORGUSERLEVELNAME_LIKE");
            if(iDEFSearchMode==null) {
                DEFSearchModeModel defSearchModeModel = new DEFSearchModeModel();
                defSearchModeModel.setDEField(deFieldModel);
                defSearchModeModel.setName("N_ORGUSERLEVELNAME_LIKE");
                defSearchModeModel.setValueOp("LIKE");
                defSearchModeModel.init();
                deFieldModel.registerDEFSearchMode(defSearchModeModel);
            }
            deFieldModel.init();
            iDEField = deFieldModel;
        }
        this.registerDEField(iDEField);
        //注册属性 "RESERVER"
        iDEField = this.createDEField("RESERVER");
        if(iDEField==null) {
            DEFieldModel deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("a498d2afdbf9a4782b206b6cd2f29fde");
            deFieldModel.setName("RESERVER");
            deFieldModel.setDEFType(1);
            deFieldModel.setLogicName("保留字段");
            deFieldModel.setDataType("TEXT");
            deFieldModel.setStdDataType(25);
            deFieldModel.setImportOrder(1000);
            deFieldModel.setImportTag("");
            deFieldModel.setValueFormat("%1$s");
            deFieldModel.init();
            iDEField = deFieldModel;
        }
        this.registerDEField(iDEField);
        //注册属性 "RESERVER10"
        iDEField = this.createDEField("RESERVER10");
        if(iDEField==null) {
            DEFieldModel deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("e7bfaa0e4ed41e3f68063efb00e8e4b4");
            deFieldModel.setName("RESERVER10");
            deFieldModel.setDEFType(1);
            deFieldModel.setLogicName("保留字段10");
            deFieldModel.setDataType("TEXT");
            deFieldModel.setStdDataType(25);
            deFieldModel.setImportOrder(1000);
            deFieldModel.setImportTag("");
            deFieldModel.setValueFormat("%1$s");
            deFieldModel.init();
            iDEField = deFieldModel;
        }
        this.registerDEField(iDEField);
        //注册属性 "RESERVER11"
        iDEField = this.createDEField("RESERVER11");
        if(iDEField==null) {
            DEFieldModel deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("57ffa907c16b4413610961e76d043745");
            deFieldModel.setName("RESERVER11");
            deFieldModel.setDEFType(1);
            deFieldModel.setLogicName("保留字段11");
            deFieldModel.setDataType("INT");
            deFieldModel.setStdDataType(9);
            deFieldModel.setImportOrder(1000);
            deFieldModel.setImportTag("");
            deFieldModel.setValueFormat("%1$s");
            deFieldModel.init();
            iDEField = deFieldModel;
        }
        this.registerDEField(iDEField);
        //注册属性 "RESERVER12"
        iDEField = this.createDEField("RESERVER12");
        if(iDEField==null) {
            DEFieldModel deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("da279eb71fed2fe909e238e56f085426");
            deFieldModel.setName("RESERVER12");
            deFieldModel.setDEFType(1);
            deFieldModel.setLogicName("保留字段12");
            deFieldModel.setDataType("INT");
            deFieldModel.setStdDataType(9);
            deFieldModel.setImportOrder(1000);
            deFieldModel.setImportTag("");
            deFieldModel.setValueFormat("%1$s");
            deFieldModel.init();
            iDEField = deFieldModel;
        }
        this.registerDEField(iDEField);
        //注册属性 "RESERVER13"
        iDEField = this.createDEField("RESERVER13");
        if(iDEField==null) {
            DEFieldModel deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("a2a806e5ca03abbb1011ef42b4b453ab");
            deFieldModel.setName("RESERVER13");
            deFieldModel.setDEFType(1);
            deFieldModel.setLogicName("保留字段13");
            deFieldModel.setDataType("INT");
            deFieldModel.setStdDataType(9);
            deFieldModel.setImportOrder(1000);
            deFieldModel.setImportTag("");
            deFieldModel.setValueFormat("%1$s");
            deFieldModel.init();
            iDEField = deFieldModel;
        }
        this.registerDEField(iDEField);
        //注册属性 "RESERVER14"
        iDEField = this.createDEField("RESERVER14");
        if(iDEField==null) {
            DEFieldModel deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("d5f9e2d63abf8d2fef4777e40fa9e08c");
            deFieldModel.setName("RESERVER14");
            deFieldModel.setDEFType(1);
            deFieldModel.setLogicName("保留字段14");
            deFieldModel.setDataType("INT");
            deFieldModel.setStdDataType(9);
            deFieldModel.setImportOrder(1000);
            deFieldModel.setImportTag("");
            deFieldModel.setValueFormat("%1$s");
            deFieldModel.init();
            iDEField = deFieldModel;
        }
        this.registerDEField(iDEField);
        //注册属性 "RESERVER15"
        iDEField = this.createDEField("RESERVER15");
        if(iDEField==null) {
            DEFieldModel deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("2171148ac10e7d2c37e6ac03d66fd55b");
            deFieldModel.setName("RESERVER15");
            deFieldModel.setDEFType(1);
            deFieldModel.setLogicName("保留字段15");
            deFieldModel.setDataType("DECIMAL");
            deFieldModel.setStdDataType(6);
            deFieldModel.setImportOrder(1000);
            deFieldModel.setImportTag("");
            deFieldModel.setValueFormat("%1$s");
            deFieldModel.init();
            iDEField = deFieldModel;
        }
        this.registerDEField(iDEField);
        //注册属性 "RESERVER16"
        iDEField = this.createDEField("RESERVER16");
        if(iDEField==null) {
            DEFieldModel deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("b49a6705bea4025b9a75de28e18ac93e");
            deFieldModel.setName("RESERVER16");
            deFieldModel.setDEFType(1);
            deFieldModel.setLogicName("保留字段16");
            deFieldModel.setDataType("DECIMAL");
            deFieldModel.setStdDataType(6);
            deFieldModel.setImportOrder(1000);
            deFieldModel.setImportTag("");
            deFieldModel.setValueFormat("%1$s");
            deFieldModel.init();
            iDEField = deFieldModel;
        }
        this.registerDEField(iDEField);
        //注册属性 "RESERVER17"
        iDEField = this.createDEField("RESERVER17");
        if(iDEField==null) {
            DEFieldModel deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("2f49d388b853f6da3d6ba2f8194bd324");
            deFieldModel.setName("RESERVER17");
            deFieldModel.setDEFType(1);
            deFieldModel.setLogicName("保留字段17");
            deFieldModel.setDataType("DECIMAL");
            deFieldModel.setStdDataType(6);
            deFieldModel.setImportOrder(1000);
            deFieldModel.setImportTag("");
            deFieldModel.setValueFormat("%1$s");
            deFieldModel.init();
            iDEField = deFieldModel;
        }
        this.registerDEField(iDEField);
        //注册属性 "RESERVER18"
        iDEField = this.createDEField("RESERVER18");
        if(iDEField==null) {
            DEFieldModel deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("e9d7365d90a65ac8089599583d1e8388");
            deFieldModel.setName("RESERVER18");
            deFieldModel.setDEFType(1);
            deFieldModel.setLogicName("保留字段18");
            deFieldModel.setDataType("DECIMAL");
            deFieldModel.setStdDataType(6);
            deFieldModel.setImportOrder(1000);
            deFieldModel.setImportTag("");
            deFieldModel.setValueFormat("%1$s");
            deFieldModel.init();
            iDEField = deFieldModel;
        }
        this.registerDEField(iDEField);
        //注册属性 "RESERVER19"
        iDEField = this.createDEField("RESERVER19");
        if(iDEField==null) {
            DEFieldModel deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("0e0d8829deadf601861f67d529bbca41");
            deFieldModel.setName("RESERVER19");
            deFieldModel.setDEFType(1);
            deFieldModel.setLogicName("保留字段19");
            deFieldModel.setDataType("DATETIME");
            deFieldModel.setStdDataType(5);
            deFieldModel.setImportOrder(1000);
            deFieldModel.setImportTag("");
            deFieldModel.setValueFormat("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS");
            deFieldModel.init();
            iDEField = deFieldModel;
        }
        this.registerDEField(iDEField);
        //注册属性 "RESERVER2"
        iDEField = this.createDEField("RESERVER2");
        if(iDEField==null) {
            DEFieldModel deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("b493f250c5224ea5928d42d1acb500c0");
            deFieldModel.setName("RESERVER2");
            deFieldModel.setDEFType(1);
            deFieldModel.setLogicName("保留字段2");
            deFieldModel.setDataType("TEXT");
            deFieldModel.setStdDataType(25);
            deFieldModel.setImportOrder(1000);
            deFieldModel.setImportTag("");
            deFieldModel.setValueFormat("%1$s");
            deFieldModel.init();
            iDEField = deFieldModel;
        }
        this.registerDEField(iDEField);
        //注册属性 "RESERVER20"
        iDEField = this.createDEField("RESERVER20");
        if(iDEField==null) {
            DEFieldModel deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("c2b7821a725ca4e9a016f38a159fddfd");
            deFieldModel.setName("RESERVER20");
            deFieldModel.setDEFType(1);
            deFieldModel.setLogicName("保留字段20");
            deFieldModel.setDataType("DATETIME");
            deFieldModel.setStdDataType(5);
            deFieldModel.setImportOrder(1000);
            deFieldModel.setImportTag("");
            deFieldModel.setValueFormat("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS");
            deFieldModel.init();
            iDEField = deFieldModel;
        }
        this.registerDEField(iDEField);
        //注册属性 "RESERVER21"
        iDEField = this.createDEField("RESERVER21");
        if(iDEField==null) {
            DEFieldModel deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("2b85fe41e7c0ad147cf91881c051341c");
            deFieldModel.setName("RESERVER21");
            deFieldModel.setDEFType(1);
            deFieldModel.setLogicName("保留字段21");
            deFieldModel.setDataType("DATETIME");
            deFieldModel.setStdDataType(5);
            deFieldModel.setImportOrder(1000);
            deFieldModel.setImportTag("");
            deFieldModel.setValueFormat("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS");
            deFieldModel.init();
            iDEField = deFieldModel;
        }
        this.registerDEField(iDEField);
        //注册属性 "RESERVER22"
        iDEField = this.createDEField("RESERVER22");
        if(iDEField==null) {
            DEFieldModel deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("e4bd05f4796302bae244e4c02dd047e4");
            deFieldModel.setName("RESERVER22");
            deFieldModel.setDEFType(1);
            deFieldModel.setLogicName("保留字段22");
            deFieldModel.setDataType("DATETIME");
            deFieldModel.setStdDataType(5);
            deFieldModel.setImportOrder(1000);
            deFieldModel.setImportTag("");
            deFieldModel.setValueFormat("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS");
            deFieldModel.init();
            iDEField = deFieldModel;
        }
        this.registerDEField(iDEField);
        //注册属性 "RESERVER23"
        iDEField = this.createDEField("RESERVER23");
        if(iDEField==null) {
            DEFieldModel deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("909505a9e6953fffd06c1f458522a2cd");
            deFieldModel.setName("RESERVER23");
            deFieldModel.setDEFType(1);
            deFieldModel.setLogicName("保留字段23");
            deFieldModel.setDataType("LONGTEXT");
            deFieldModel.setStdDataType(21);
            deFieldModel.setImportOrder(1000);
            deFieldModel.setImportTag("");
            deFieldModel.setValueFormat("%1$s");
            deFieldModel.init();
            iDEField = deFieldModel;
        }
        this.registerDEField(iDEField);
        //注册属性 "RESERVER24"
        iDEField = this.createDEField("RESERVER24");
        if(iDEField==null) {
            DEFieldModel deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("4ce6bbff659af1cf492790eecf08bf0f");
            deFieldModel.setName("RESERVER24");
            deFieldModel.setDEFType(1);
            deFieldModel.setLogicName("保留字段24");
            deFieldModel.setDataType("LONGTEXT");
            deFieldModel.setStdDataType(21);
            deFieldModel.setImportOrder(1000);
            deFieldModel.setImportTag("");
            deFieldModel.setValueFormat("%1$s");
            deFieldModel.init();
            iDEField = deFieldModel;
        }
        this.registerDEField(iDEField);
        //注册属性 "RESERVER25"
        iDEField = this.createDEField("RESERVER25");
        if(iDEField==null) {
            DEFieldModel deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("29faf3f8e6ee3036d97aacc437d949e0");
            deFieldModel.setName("RESERVER25");
            deFieldModel.setDEFType(1);
            deFieldModel.setLogicName("保留字段25");
            deFieldModel.setDataType("TEXT");
            deFieldModel.setStdDataType(25);
            deFieldModel.setImportOrder(1000);
            deFieldModel.setImportTag("");
            deFieldModel.setValueFormat("%1$s");
            deFieldModel.init();
            iDEField = deFieldModel;
        }
        this.registerDEField(iDEField);
        //注册属性 "RESERVER26"
        iDEField = this.createDEField("RESERVER26");
        if(iDEField==null) {
            DEFieldModel deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("c1f602a98620ee87747676aec1c54e8b");
            deFieldModel.setName("RESERVER26");
            deFieldModel.setDEFType(1);
            deFieldModel.setLogicName("保留字段26");
            deFieldModel.setDataType("TEXT");
            deFieldModel.setStdDataType(25);
            deFieldModel.setImportOrder(1000);
            deFieldModel.setImportTag("");
            deFieldModel.setValueFormat("%1$s");
            deFieldModel.init();
            iDEField = deFieldModel;
        }
        this.registerDEField(iDEField);
        //注册属性 "RESERVER27"
        iDEField = this.createDEField("RESERVER27");
        if(iDEField==null) {
            DEFieldModel deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("1dbf74231321c8228b6eed4e1b4fa64c");
            deFieldModel.setName("RESERVER27");
            deFieldModel.setDEFType(1);
            deFieldModel.setLogicName("保留字段27");
            deFieldModel.setDataType("TEXT");
            deFieldModel.setStdDataType(25);
            deFieldModel.setImportOrder(1000);
            deFieldModel.setImportTag("");
            deFieldModel.setValueFormat("%1$s");
            deFieldModel.init();
            iDEField = deFieldModel;
        }
        this.registerDEField(iDEField);
        //注册属性 "RESERVER28"
        iDEField = this.createDEField("RESERVER28");
        if(iDEField==null) {
            DEFieldModel deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("c744c1cf2c472e821cdfd68b981f4198");
            deFieldModel.setName("RESERVER28");
            deFieldModel.setDEFType(1);
            deFieldModel.setLogicName("保留字段28");
            deFieldModel.setDataType("TEXT");
            deFieldModel.setStdDataType(25);
            deFieldModel.setImportOrder(1000);
            deFieldModel.setImportTag("");
            deFieldModel.setValueFormat("%1$s");
            deFieldModel.init();
            iDEField = deFieldModel;
        }
        this.registerDEField(iDEField);
        //注册属性 "RESERVER29"
        iDEField = this.createDEField("RESERVER29");
        if(iDEField==null) {
            DEFieldModel deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("d9f4b7f016be9c132b3e487b6376fb2c");
            deFieldModel.setName("RESERVER29");
            deFieldModel.setDEFType(1);
            deFieldModel.setLogicName("保留字段29");
            deFieldModel.setDataType("TEXT");
            deFieldModel.setStdDataType(25);
            deFieldModel.setImportOrder(1000);
            deFieldModel.setImportTag("");
            deFieldModel.setValueFormat("%1$s");
            deFieldModel.init();
            iDEField = deFieldModel;
        }
        this.registerDEField(iDEField);
        //注册属性 "RESERVER3"
        iDEField = this.createDEField("RESERVER3");
        if(iDEField==null) {
            DEFieldModel deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("d3673c8f4cab204208ac39e09c1ae146");
            deFieldModel.setName("RESERVER3");
            deFieldModel.setDEFType(1);
            deFieldModel.setLogicName("保留字段3");
            deFieldModel.setDataType("TEXT");
            deFieldModel.setStdDataType(25);
            deFieldModel.setImportOrder(1000);
            deFieldModel.setImportTag("");
            deFieldModel.setValueFormat("%1$s");
            deFieldModel.init();
            iDEField = deFieldModel;
        }
        this.registerDEField(iDEField);
        //注册属性 "RESERVER30"
        iDEField = this.createDEField("RESERVER30");
        if(iDEField==null) {
            DEFieldModel deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("bd6956a1a135005b94d3fd276203d7f2");
            deFieldModel.setName("RESERVER30");
            deFieldModel.setDEFType(1);
            deFieldModel.setLogicName("保留字段30");
            deFieldModel.setDataType("TEXT");
            deFieldModel.setStdDataType(25);
            deFieldModel.setImportOrder(1000);
            deFieldModel.setImportTag("");
            deFieldModel.setValueFormat("%1$s");
            deFieldModel.init();
            iDEField = deFieldModel;
        }
        this.registerDEField(iDEField);
        //注册属性 "RESERVER4"
        iDEField = this.createDEField("RESERVER4");
        if(iDEField==null) {
            DEFieldModel deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("719657fda06cc172c7e3e860a981da91");
            deFieldModel.setName("RESERVER4");
            deFieldModel.setDEFType(1);
            deFieldModel.setLogicName("保留字段4");
            deFieldModel.setDataType("TEXT");
            deFieldModel.setStdDataType(25);
            deFieldModel.setImportOrder(1000);
            deFieldModel.setImportTag("");
            deFieldModel.setValueFormat("%1$s");
            deFieldModel.init();
            iDEField = deFieldModel;
        }
        this.registerDEField(iDEField);
        //注册属性 "RESERVER5"
        iDEField = this.createDEField("RESERVER5");
        if(iDEField==null) {
            DEFieldModel deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("54b74cd6d207552e3fce307d7320bb78");
            deFieldModel.setName("RESERVER5");
            deFieldModel.setDEFType(1);
            deFieldModel.setLogicName("保留字段5");
            deFieldModel.setDataType("TEXT");
            deFieldModel.setStdDataType(25);
            deFieldModel.setImportOrder(1000);
            deFieldModel.setImportTag("");
            deFieldModel.setValueFormat("%1$s");
            deFieldModel.init();
            iDEField = deFieldModel;
        }
        this.registerDEField(iDEField);
        //注册属性 "RESERVER6"
        iDEField = this.createDEField("RESERVER6");
        if(iDEField==null) {
            DEFieldModel deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("75cee414bc5d1d11be4b5c65175dd06d");
            deFieldModel.setName("RESERVER6");
            deFieldModel.setDEFType(1);
            deFieldModel.setLogicName("保留字段6");
            deFieldModel.setDataType("TEXT");
            deFieldModel.setStdDataType(25);
            deFieldModel.setImportOrder(1000);
            deFieldModel.setImportTag("");
            deFieldModel.setValueFormat("%1$s");
            deFieldModel.init();
            iDEField = deFieldModel;
        }
        this.registerDEField(iDEField);
        //注册属性 "RESERVER7"
        iDEField = this.createDEField("RESERVER7");
        if(iDEField==null) {
            DEFieldModel deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("a6cd9f999be5d5364bec39f8a3a9249f");
            deFieldModel.setName("RESERVER7");
            deFieldModel.setDEFType(1);
            deFieldModel.setLogicName("保留字段7");
            deFieldModel.setDataType("TEXT");
            deFieldModel.setStdDataType(25);
            deFieldModel.setImportOrder(1000);
            deFieldModel.setImportTag("");
            deFieldModel.setValueFormat("%1$s");
            deFieldModel.init();
            iDEField = deFieldModel;
        }
        this.registerDEField(iDEField);
        //注册属性 "RESERVER8"
        iDEField = this.createDEField("RESERVER8");
        if(iDEField==null) {
            DEFieldModel deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("f9900e4debf73e719095ab116ad07ecb");
            deFieldModel.setName("RESERVER8");
            deFieldModel.setDEFType(1);
            deFieldModel.setLogicName("保留字段8");
            deFieldModel.setDataType("TEXT");
            deFieldModel.setStdDataType(25);
            deFieldModel.setImportOrder(1000);
            deFieldModel.setImportTag("");
            deFieldModel.setValueFormat("%1$s");
            deFieldModel.init();
            iDEField = deFieldModel;
        }
        this.registerDEField(iDEField);
        //注册属性 "RESERVER9"
        iDEField = this.createDEField("RESERVER9");
        if(iDEField==null) {
            DEFieldModel deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("e23bb1991501a91fda53068625a7e02a");
            deFieldModel.setName("RESERVER9");
            deFieldModel.setDEFType(1);
            deFieldModel.setLogicName("保留字段9");
            deFieldModel.setDataType("TEXT");
            deFieldModel.setStdDataType(25);
            deFieldModel.setImportOrder(1000);
            deFieldModel.setImportTag("");
            deFieldModel.setValueFormat("%1$s");
            deFieldModel.init();
            iDEField = deFieldModel;
        }
        this.registerDEField(iDEField);
        //注册属性 "UPDATEDATE"
        iDEField = this.createDEField("UPDATEDATE");
        if(iDEField==null) {
            DEFieldModel deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("4f620f63e8ff38f86fc69f7c71822b65");
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
            deFieldModel.setId("c21c7a68f7fb491aa1c741d5e3c68b89");
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
        //注册属性 "VALIDFLAG"
        iDEField = this.createDEField("VALIDFLAG");
        if(iDEField==null) {
            DEFieldModel deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("1bbc44603d61f2899f3e7f4331583b66");
            deFieldModel.setName("VALIDFLAG");
            deFieldModel.setDEFType(1);
            deFieldModel.setLogicName("启用标志");
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

    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.demodel.DataEntityModelBase#prepareDEACModes()
     */
    @Override
    protected void prepareDEACModes() throws Exception {
        //注册  DEFAULT
        OrgUserLevelDefaultACModel _defaultACModel = new OrgUserLevelDefaultACModel();
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
        mYSQL5ConfigModel.setTableName("t_srforguserlevel");
        mYSQL5ConfigModel.setViewName("v_orguserlevel");
        this.registerDEDBConfig(mYSQL5ConfigModel);
    }


    /* (non-Javadoc)
     * @see net.ibizsys.paas.demodel.DataEntityModelBase#prepareDEDataSets()
     */
    @Override
    protected void prepareDEDataSets() throws Exception {
        //注册  DEFAULT
        OrgUserLevelDefaultDSModel _defaultDSModel = new OrgUserLevelDefaultDSModel();
        _defaultDSModel.init(this);
        this.registerDEDataSet(_defaultDSModel);
    }




    /* (non-Javadoc)
     * @see net.ibizsys.paas.demodel.DataEntityModelBase#prepareDEDataQueries()
     */
    @Override
    protected void prepareDEDataQueries() throws Exception {
        //注册  DEFAULT
        OrgUserLevelDefaultDQModel _defaultDQModel = new OrgUserLevelDefaultDQModel();
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
        //注册视图 组织人员级别实体数据多项选择视图
        this.registerPDTDEView("MPICKUPVIEW","df44e7ae8859e7b4cc7c02fc662e7070");
        //注册视图 组织人员级别实体数据选择视图
        this.registerPDTDEView("PICKUPVIEW","1c2b8e948aff0a34e0b145d2931d1914");
        //注册视图 组织人员级别实体数据重定向视图
        this.registerPDTDEView("REDIRECTVIEW","fdfefc5718cd614c631a658d19145e1b");
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

        //放入属性 ORGUSERLEVELNAME - 人员级别名称
        if(true) {
            DEDataSetCond deDataSetCondImpl = new DEDataSetCond();
            deDataSetCondImpl.setCondType(IDEDataSetCond.CONDTYPE_DEFIELD);
            deDataSetCondImpl.setCondOp(ICondition.CONDOP_LIKE);
            deDataSetCondImpl.setDEFName(OrgUserLevel.FIELD_ORGUSERLEVELNAME);
            deDataSetCondImpl.setCondValue(strQuickSearch);
            groupCondImpl.addChildDEDataQueryCond(deDataSetCondImpl);
        }
    }
}