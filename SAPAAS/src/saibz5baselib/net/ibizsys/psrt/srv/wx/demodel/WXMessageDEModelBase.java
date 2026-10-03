/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.wx.demodel;


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

import net.ibizsys.psrt.srv.wx.demodel.wxmessage.ac.*;
import net.ibizsys.psrt.srv.wx.demodel.wxmessage.dataset.*;
import net.ibizsys.psrt.srv.wx.demodel.wxmessage.dataquery.*;
import net.ibizsys.psrt.srv.wx.entity.WXMessage;
import net.ibizsys.psrt.srv.wx.service.WXMessageService;

/**
 * 实体[WXMESSAGE]模型对象基类
 */
public abstract class WXMessageDEModelBase extends net.ibizsys.paas.demodel.DataEntityModelBase<WXMessage>  {

    public WXMessageDEModelBase() throws Exception {
        super();

        this.setId("657d40a805a0f204934829160a198bb7");
        this.setName("WXMESSAGE");
        this.setTableName("T_SRFWXMESSAGE");
        this.setViewName("v_WXMESSAGE");
        this.setLogicName("微信消息");
        this.setDSLink("DEFAULT");
        this.setDataAccCtrlMode(1);
        this.setAuditMode(0);
        if(isRegisterToDEModelGlobal()) {
            DEModelGlobal.registerDEModel("net.ibizsys.psrt.srv.wx.demodel.WXMessageDEModel",this);
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

    private WXMessageService wXMessageService;

    /**
     * 获取实际实体服务对象
     * @return
     */
    public  WXMessageService getRealService() {
        if(this.wXMessageService==null) {
            try {
                this.wXMessageService = (WXMessageService)ServiceGlobal.getService(getServiceId());
            } catch(Exception ex) {
            }
        }
        return this.wXMessageService;
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
        return "net.ibizsys.psrt.srv.wx.service.WXMessageService";
    }


    /* (non-Javadoc)
     * @see net.ibizsys.paas.demodel.IDataEntityModel#createEntity()
     */
    @Override
    public WXMessage createEntity() {
        return new WXMessage();
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.demodel.DataEntityModelBase#prepareDEFields()
     */
    @Override
    protected void prepareDEFields() throws Exception {
        IDEField iDEField = null;
        IDEFSearchMode iDEFSearchMode = null;
        //注册属性 "CNT"
        iDEField = this.createDEField("CNT");
        if(iDEField==null) {
            DEFieldModel deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("1102c55dbba90ee50a4b55165117d225");
            deFieldModel.setName("CNT");
            deFieldModel.setDEFType(1);
            deFieldModel.setLogicName("输入内容数量");
            deFieldModel.setDataType("INT");
            deFieldModel.setStdDataType(9);
            deFieldModel.setImportOrder(1000);
            deFieldModel.setImportTag("");
            deFieldModel.setValueFormat("%1$s");
            deFieldModel.init();
            iDEField = deFieldModel;
        }
        this.registerDEField(iDEField);
        //注册属性 "CONTENT"
        iDEField = this.createDEField("CONTENT");
        if(iDEField==null) {
            DEFieldModel deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("e30e04f2fb4d0bd8f74e6d323c731366");
            deFieldModel.setName("CONTENT");
            deFieldModel.setDEFType(1);
            deFieldModel.setLogicName("文本消息内容");
            deFieldModel.setDataType("LONGTEXT_1000");
            deFieldModel.setStdDataType(25);
            deFieldModel.setImportOrder(1000);
            deFieldModel.setImportTag("");
            deFieldModel.setValueFormat("%1$s");
            deFieldModel.init();
            iDEField = deFieldModel;
        }
        this.registerDEField(iDEField);
        //注册属性 "CREATEDATE"
        iDEField = this.createDEField("CREATEDATE");
        if(iDEField==null) {
            DEFieldModel deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("933e389a1181f6c3679a406ec31136b5");
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
            deFieldModel.setId("b7ca547ea00571bfeb97ab68cf909bec");
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
        //注册属性 "EVENT"
        iDEField = this.createDEField("EVENT");
        if(iDEField==null) {
            DEFieldModel deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("593728baed6bb8f9dadd9b0cc8dfd06f");
            deFieldModel.setName("EVENT");
            deFieldModel.setDEFType(1);
            deFieldModel.setLogicName("事件");
            deFieldModel.setDataType("TEXT");
            deFieldModel.setStdDataType(25);
            deFieldModel.setImportOrder(1000);
            deFieldModel.setImportTag("");
            deFieldModel.setValueFormat("%1$s");
            deFieldModel.init();
            iDEField = deFieldModel;
        }
        this.registerDEField(iDEField);
        //注册属性 "EVENTKEY"
        iDEField = this.createDEField("EVENTKEY");
        if(iDEField==null) {
            DEFieldModel deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("f89c776c0999717ee5301826e1612978");
            deFieldModel.setName("EVENTKEY");
            deFieldModel.setDEFType(1);
            deFieldModel.setLogicName("EventKey");
            deFieldModel.setDataType("TEXT");
            deFieldModel.setStdDataType(25);
            deFieldModel.setImportOrder(1000);
            deFieldModel.setImportTag("");
            deFieldModel.setValueFormat("%1$s");
            deFieldModel.init();
            iDEField = deFieldModel;
        }
        this.registerDEField(iDEField);
        //注册属性 "FORMAT"
        iDEField = this.createDEField("FORMAT");
        if(iDEField==null) {
            DEFieldModel deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("362ab06ca5ffd24d21c5363e47265fd4");
            deFieldModel.setName("FORMAT");
            deFieldModel.setDEFType(1);
            deFieldModel.setLogicName("语音格式");
            deFieldModel.setDataType("TEXT");
            deFieldModel.setStdDataType(25);
            deFieldModel.setImportOrder(1000);
            deFieldModel.setImportTag("");
            deFieldModel.setValueFormat("%1$s");
            deFieldModel.init();
            iDEField = deFieldModel;
        }
        this.registerDEField(iDEField);
        //注册属性 "FROMUSERNAME"
        iDEField = this.createDEField("FROMUSERNAME");
        if(iDEField==null) {
            DEFieldModel deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("3260e8290a2393240b31d51f136622c9");
            deFieldModel.setName("FROMUSERNAME");
            deFieldModel.setDEFType(1);
            deFieldModel.setLogicName("发送方帐号");
            deFieldModel.setDataType("TEXT");
            deFieldModel.setStdDataType(25);
            deFieldModel.setImportOrder(1000);
            deFieldModel.setImportTag("");
            deFieldModel.setValueFormat("%1$s");
            deFieldModel.init();
            iDEField = deFieldModel;
        }
        this.registerDEField(iDEField);
        //注册属性 "INCOMETIME"
        iDEField = this.createDEField("INCOMETIME");
        if(iDEField==null) {
            DEFieldModel deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("733f4bef2c54cb144054c0054f0b43e6");
            deFieldModel.setName("INCOMETIME");
            deFieldModel.setDEFType(1);
            deFieldModel.setLogicName("进入时间");
            deFieldModel.setDataType("DATETIME");
            deFieldModel.setStdDataType(5);
            deFieldModel.setImportOrder(1000);
            deFieldModel.setImportTag("");
            deFieldModel.setValueFormat("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS");
            deFieldModel.init();
            iDEField = deFieldModel;
        }
        this.registerDEField(iDEField);
        //注册属性 "LOCATION_PREC"
        iDEField = this.createDEField("LOCATION_PREC");
        if(iDEField==null) {
            DEFieldModel deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("23bc8adc562c39f95ce8dc4afef5b99d");
            deFieldModel.setName("LOCATION_PREC");
            deFieldModel.setDEFType(1);
            deFieldModel.setLogicName("位置精度");
            deFieldModel.setDataType("DECIMAL");
            deFieldModel.setStdDataType(6);
            deFieldModel.setImportOrder(1000);
            deFieldModel.setImportTag("");
            deFieldModel.setValueFormat("%1$s");
            deFieldModel.init();
            iDEField = deFieldModel;
        }
        this.registerDEField(iDEField);
        //注册属性 "LOCATION_X"
        iDEField = this.createDEField("LOCATION_X");
        if(iDEField==null) {
            DEFieldModel deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("e7eb2508217dfc967d41a08b7309940d");
            deFieldModel.setName("LOCATION_X");
            deFieldModel.setDEFType(1);
            deFieldModel.setLogicName("地理位置维度");
            deFieldModel.setDataType("TEXT");
            deFieldModel.setStdDataType(25);
            deFieldModel.setImportOrder(1000);
            deFieldModel.setImportTag("");
            deFieldModel.setValueFormat("%1$s");
            deFieldModel.init();
            iDEField = deFieldModel;
        }
        this.registerDEField(iDEField);
        //注册属性 "LOCATION_Y"
        iDEField = this.createDEField("LOCATION_Y");
        if(iDEField==null) {
            DEFieldModel deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("dda9ad9943dd4483df1c95ac1a184555");
            deFieldModel.setName("LOCATION_Y");
            deFieldModel.setDEFType(1);
            deFieldModel.setLogicName("地理位置经度");
            deFieldModel.setDataType("TEXT");
            deFieldModel.setStdDataType(25);
            deFieldModel.setImportOrder(1000);
            deFieldModel.setImportTag("");
            deFieldModel.setValueFormat("%1$s");
            deFieldModel.init();
            iDEField = deFieldModel;
        }
        this.registerDEField(iDEField);
        //注册属性 "MEDIAID"
        iDEField = this.createDEField("MEDIAID");
        if(iDEField==null) {
            DEFieldModel deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("71a86db63d55e5447b0efa90c73ef4b0");
            deFieldModel.setName("MEDIAID");
            deFieldModel.setDEFType(1);
            deFieldModel.setLogicName("图片消息媒体编号");
            deFieldModel.setDataType("TEXT");
            deFieldModel.setStdDataType(25);
            deFieldModel.setImportOrder(1000);
            deFieldModel.setImportTag("");
            deFieldModel.setValueFormat("%1$s");
            deFieldModel.init();
            iDEField = deFieldModel;
        }
        this.registerDEField(iDEField);
        //注册属性 "MSGTYPE"
        iDEField = this.createDEField("MSGTYPE");
        if(iDEField==null) {
            DEFieldModel deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("11a59cf27d449cb02f25eb93ef36940b");
            deFieldModel.setName("MSGTYPE");
            deFieldModel.setDEFType(1);
            deFieldModel.setLogicName("消息类型");
            deFieldModel.setDataType("SSCODELIST");
            deFieldModel.setStdDataType(25);
            deFieldModel.setImportOrder(1000);
            deFieldModel.setImportTag("");
            deFieldModel.setCodeListId("net.ibizsys.psrt.srv.codelist.WXMsgTypeCodeListModel");
            deFieldModel.setValueFormat("%1$s");
            iDEFSearchMode = this.createDEFSearchMode(deFieldModel,"N_MSGTYPE_EQ");
            if(iDEFSearchMode==null) {
                DEFSearchModeModel defSearchModeModel = new DEFSearchModeModel();
                defSearchModeModel.setDEField(deFieldModel);
                defSearchModeModel.setName("N_MSGTYPE_EQ");
                defSearchModeModel.setValueOp("EQ");
                defSearchModeModel.init();
                deFieldModel.registerDEFSearchMode(defSearchModeModel);
            }
            deFieldModel.init();
            iDEField = deFieldModel;
        }
        this.registerDEField(iDEField);
        //注册属性 "PICURL"
        iDEField = this.createDEField("PICURL");
        if(iDEField==null) {
            DEFieldModel deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("00ffa708c5012c6aba614fbcc176e56c");
            deFieldModel.setName("PICURL");
            deFieldModel.setDEFType(1);
            deFieldModel.setLogicName("图片路径");
            deFieldModel.setDataType("TEXT");
            deFieldModel.setStdDataType(25);
            deFieldModel.setImportOrder(1000);
            deFieldModel.setImportTag("");
            deFieldModel.setValueFormat("%1$s");
            deFieldModel.init();
            iDEField = deFieldModel;
        }
        this.registerDEField(iDEField);
        //注册属性 "RESERVER"
        iDEField = this.createDEField("RESERVER");
        if(iDEField==null) {
            DEFieldModel deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("6a248b0fb864c8caaae54afc024440eb");
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
        //注册属性 "RESERVER2"
        iDEField = this.createDEField("RESERVER2");
        if(iDEField==null) {
            DEFieldModel deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("14b5767e26e0c54df56fe89a92a1b1ed");
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
        //注册属性 "RESERVER3"
        iDEField = this.createDEField("RESERVER3");
        if(iDEField==null) {
            DEFieldModel deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("d8ffcb2c3f8b87b45850bad866e7d5d8");
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
        //注册属性 "RESERVER4"
        iDEField = this.createDEField("RESERVER4");
        if(iDEField==null) {
            DEFieldModel deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("3325156a1d7ceecbf97e8bf7a9927fb4");
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
        //注册属性 "RESPARTICLECOUNT"
        iDEField = this.createDEField("RESPARTICLECOUNT");
        if(iDEField==null) {
            DEFieldModel deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("f524db282f4f38a9585e0927264bee25");
            deFieldModel.setName("RESPARTICLECOUNT");
            deFieldModel.setDEFType(1);
            deFieldModel.setLogicName("反馈图文消息的数量");
            deFieldModel.setDataType("INT");
            deFieldModel.setStdDataType(9);
            deFieldModel.setImportOrder(1000);
            deFieldModel.setImportTag("");
            deFieldModel.setValueFormat("%1$s");
            deFieldModel.init();
            iDEField = deFieldModel;
        }
        this.registerDEField(iDEField);
        //注册属性 "RESPARTICLES"
        iDEField = this.createDEField("RESPARTICLES");
        if(iDEField==null) {
            DEFieldModel deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("6415db9bcc0d76745209da534ade1767");
            deFieldModel.setName("RESPARTICLES");
            deFieldModel.setDEFType(1);
            deFieldModel.setLogicName("反馈的文章内容");
            deFieldModel.setDataType("LONGTEXT");
            deFieldModel.setStdDataType(21);
            deFieldModel.setImportOrder(1000);
            deFieldModel.setImportTag("");
            deFieldModel.setValueFormat("%1$s");
            deFieldModel.init();
            iDEField = deFieldModel;
        }
        this.registerDEField(iDEField);
        //注册属性 "RESPDESC"
        iDEField = this.createDEField("RESPDESC");
        if(iDEField==null) {
            DEFieldModel deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("a4a49a0c818eba99db90cda6f9e7b488");
            deFieldModel.setName("RESPDESC");
            deFieldModel.setDEFType(1);
            deFieldModel.setLogicName("返回描述");
            deFieldModel.setDataType("TEXT");
            deFieldModel.setStdDataType(25);
            deFieldModel.setImportOrder(1000);
            deFieldModel.setImportTag("");
            deFieldModel.setValueFormat("%1$s");
            deFieldModel.init();
            iDEField = deFieldModel;
        }
        this.registerDEField(iDEField);
        //注册属性 "RESPMEDIAID"
        iDEField = this.createDEField("RESPMEDIAID");
        if(iDEField==null) {
            DEFieldModel deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("1ea6e7493bd251cf44417508259450fa");
            deFieldModel.setName("RESPMEDIAID");
            deFieldModel.setDEFType(1);
            deFieldModel.setLogicName("返回图片消息媒体编号");
            deFieldModel.setDataType("TEXT");
            deFieldModel.setStdDataType(25);
            deFieldModel.setImportOrder(1000);
            deFieldModel.setImportTag("");
            deFieldModel.setValueFormat("%1$s");
            deFieldModel.init();
            iDEField = deFieldModel;
        }
        this.registerDEField(iDEField);
        //注册属性 "RESPMSGTYPE"
        iDEField = this.createDEField("RESPMSGTYPE");
        if(iDEField==null) {
            DEFieldModel deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("a1aafdeda712ef3c31ce3d2efa0d9c75");
            deFieldModel.setName("RESPMSGTYPE");
            deFieldModel.setDEFType(1);
            deFieldModel.setLogicName("反馈消息类型");
            deFieldModel.setDataType("SSCODELIST");
            deFieldModel.setStdDataType(25);
            deFieldModel.setImportOrder(1000);
            deFieldModel.setImportTag("");
            deFieldModel.setCodeListId("net.ibizsys.psrt.srv.codelist.WXMsgTypeCodeListModel");
            deFieldModel.setValueFormat("%1$s");
            iDEFSearchMode = this.createDEFSearchMode(deFieldModel,"N_RESPMSGTYPE_EQ");
            if(iDEFSearchMode==null) {
                DEFSearchModeModel defSearchModeModel = new DEFSearchModeModel();
                defSearchModeModel.setDEField(deFieldModel);
                defSearchModeModel.setName("N_RESPMSGTYPE_EQ");
                defSearchModeModel.setValueOp("EQ");
                defSearchModeModel.init();
                deFieldModel.registerDEFSearchMode(defSearchModeModel);
            }
            deFieldModel.init();
            iDEField = deFieldModel;
        }
        this.registerDEField(iDEField);
        //注册属性 "RESPTIME"
        iDEField = this.createDEField("RESPTIME");
        if(iDEField==null) {
            DEFieldModel deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("1bd5bd2c4075d205defe26349b8209b0");
            deFieldModel.setName("RESPTIME");
            deFieldModel.setDEFType(1);
            deFieldModel.setLogicName("反馈时间");
            deFieldModel.setDataType("DATETIME");
            deFieldModel.setStdDataType(5);
            deFieldModel.setImportOrder(1000);
            deFieldModel.setImportTag("");
            deFieldModel.setValueFormat("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS");
            deFieldModel.init();
            iDEField = deFieldModel;
        }
        this.registerDEField(iDEField);
        //注册属性 "RESPTITLE"
        iDEField = this.createDEField("RESPTITLE");
        if(iDEField==null) {
            DEFieldModel deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("d9ab9f002deb43906291793f64657c50");
            deFieldModel.setName("RESPTITLE");
            deFieldModel.setDEFType(1);
            deFieldModel.setLogicName("返回标题");
            deFieldModel.setDataType("TEXT");
            deFieldModel.setStdDataType(25);
            deFieldModel.setImportOrder(1000);
            deFieldModel.setImportTag("");
            deFieldModel.setValueFormat("%1$s");
            deFieldModel.init();
            iDEField = deFieldModel;
        }
        this.registerDEField(iDEField);
        //注册属性 "RESULT"
        iDEField = this.createDEField("RESULT");
        if(iDEField==null) {
            DEFieldModel deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("24d663dd7938aa0f375b4b29b41cd382");
            deFieldModel.setName("RESULT");
            deFieldModel.setDEFType(1);
            deFieldModel.setLogicName("结果内容");
            deFieldModel.setDataType("LONGTEXT_1000");
            deFieldModel.setStdDataType(25);
            deFieldModel.setImportOrder(1000);
            deFieldModel.setImportTag("");
            deFieldModel.setValueFormat("%1$s");
            deFieldModel.init();
            iDEField = deFieldModel;
        }
        this.registerDEField(iDEField);
        //注册属性 "SCALE"
        iDEField = this.createDEField("SCALE");
        if(iDEField==null) {
            DEFieldModel deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("2f51a014cb29e6a478bb02061a8ae94a");
            deFieldModel.setName("SCALE");
            deFieldModel.setDEFType(1);
            deFieldModel.setLogicName("地图缩放大小");
            deFieldModel.setDataType("INT");
            deFieldModel.setStdDataType(9);
            deFieldModel.setImportOrder(1000);
            deFieldModel.setImportTag("");
            deFieldModel.setValueFormat("%1$s");
            deFieldModel.init();
            iDEField = deFieldModel;
        }
        this.registerDEField(iDEField);
        //注册属性 "SCANCODEINFO"
        iDEField = this.createDEField("SCANCODEINFO");
        if(iDEField==null) {
            DEFieldModel deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("cf5daed5d6835d138f8293f5e94267d2");
            deFieldModel.setName("SCANCODEINFO");
            deFieldModel.setDEFType(1);
            deFieldModel.setLogicName("ScanCodeInfo");
            deFieldModel.setDataType("TEXT");
            deFieldModel.setStdDataType(25);
            deFieldModel.setImportOrder(1000);
            deFieldModel.setImportTag("");
            deFieldModel.setValueFormat("%1$s");
            deFieldModel.init();
            iDEField = deFieldModel;
        }
        this.registerDEField(iDEField);
        //注册属性 "SCANTYPE"
        iDEField = this.createDEField("SCANTYPE");
        if(iDEField==null) {
            DEFieldModel deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("174d144d5596f064075f94b405816eec");
            deFieldModel.setName("SCANTYPE");
            deFieldModel.setDEFType(1);
            deFieldModel.setLogicName("ScanType");
            deFieldModel.setDataType("TEXT");
            deFieldModel.setStdDataType(25);
            deFieldModel.setImportOrder(1000);
            deFieldModel.setImportTag("");
            deFieldModel.setValueFormat("%1$s");
            deFieldModel.init();
            iDEField = deFieldModel;
        }
        this.registerDEField(iDEField);
        //注册属性 "THUMBMEDIAID"
        iDEField = this.createDEField("THUMBMEDIAID");
        if(iDEField==null) {
            DEFieldModel deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("e9c863a802e3c1e49d584713462817a6");
            deFieldModel.setName("THUMBMEDIAID");
            deFieldModel.setDEFType(1);
            deFieldModel.setLogicName("视频消息缩略图的媒体编号");
            deFieldModel.setDataType("TEXT");
            deFieldModel.setStdDataType(25);
            deFieldModel.setImportOrder(1000);
            deFieldModel.setImportTag("");
            deFieldModel.setValueFormat("%1$s");
            deFieldModel.init();
            iDEField = deFieldModel;
        }
        this.registerDEField(iDEField);
        //注册属性 "TOUSERNAME"
        iDEField = this.createDEField("TOUSERNAME");
        if(iDEField==null) {
            DEFieldModel deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("42f67a413d323918ff954ecc39e2209b");
            deFieldModel.setName("TOUSERNAME");
            deFieldModel.setDEFType(1);
            deFieldModel.setLogicName("开发者微信号");
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
            deFieldModel.setId("f835c5fd950e142c0c0cca396d04b453");
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
            deFieldModel.setId("2a918b420c54d883bb3dd599e8230431");
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
        //注册属性 "WXACCOUNTID"
        iDEField = this.createDEField("WXACCOUNTID");
        if(iDEField==null) {
            DEFieldModel deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("e514a75d168afa9f619fa3886fdc8201");
            deFieldModel.setName("WXACCOUNTID");
            deFieldModel.setDEFType(1);
            deFieldModel.setLogicName("微信公众号");
            deFieldModel.setDataType("PICKUP");
            deFieldModel.setStdDataType(25);
            deFieldModel.setLinkDEField(true);
            deFieldModel.setImportOrder(1000);
            deFieldModel.setImportTag("");
            deFieldModel.setDERName("DER1N_WXMESSAGE_WXACCOUNT_WXACCOUNTID");
            deFieldModel.setLinkDEFName("WXACCOUNTID");
            deFieldModel.setValueFormat("%1$s");
            iDEFSearchMode = this.createDEFSearchMode(deFieldModel,"N_WXACCOUNTID_EQ");
            if(iDEFSearchMode==null) {
                DEFSearchModeModel defSearchModeModel = new DEFSearchModeModel();
                defSearchModeModel.setDEField(deFieldModel);
                defSearchModeModel.setName("N_WXACCOUNTID_EQ");
                defSearchModeModel.setValueOp("EQ");
                defSearchModeModel.init();
                deFieldModel.registerDEFSearchMode(defSearchModeModel);
            }
            deFieldModel.init();
            iDEField = deFieldModel;
        }
        this.registerDEField(iDEField);
        //注册属性 "WXACCOUNTNAME"
        iDEField = this.createDEField("WXACCOUNTNAME");
        if(iDEField==null) {
            DEFieldModel deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("e1bfdaf4212268e2b319f3e1aee053b2");
            deFieldModel.setName("WXACCOUNTNAME");
            deFieldModel.setDEFType(1);
            deFieldModel.setLogicName("微信公众号");
            deFieldModel.setDataType("PICKUPTEXT");
            deFieldModel.setStdDataType(25);
            deFieldModel.setLinkDEField(true);
            deFieldModel.setImportOrder(1000);
            deFieldModel.setImportTag("");
            deFieldModel.setDERName("DER1N_WXMESSAGE_WXACCOUNT_WXACCOUNTID");
            deFieldModel.setLinkDEFName("WXACCOUNTNAME");
            deFieldModel.setValueFormat("%1$s");
            iDEFSearchMode = this.createDEFSearchMode(deFieldModel,"N_WXACCOUNTNAME_EQ");
            if(iDEFSearchMode==null) {
                DEFSearchModeModel defSearchModeModel = new DEFSearchModeModel();
                defSearchModeModel.setDEField(deFieldModel);
                defSearchModeModel.setName("N_WXACCOUNTNAME_EQ");
                defSearchModeModel.setValueOp("EQ");
                defSearchModeModel.init();
                deFieldModel.registerDEFSearchMode(defSearchModeModel);
            }
            iDEFSearchMode = this.createDEFSearchMode(deFieldModel,"N_WXACCOUNTNAME_LIKE");
            if(iDEFSearchMode==null) {
                DEFSearchModeModel defSearchModeModel = new DEFSearchModeModel();
                defSearchModeModel.setDEField(deFieldModel);
                defSearchModeModel.setName("N_WXACCOUNTNAME_LIKE");
                defSearchModeModel.setValueOp("LIKE");
                defSearchModeModel.init();
                deFieldModel.registerDEFSearchMode(defSearchModeModel);
            }
            deFieldModel.init();
            iDEField = deFieldModel;
        }
        this.registerDEField(iDEField);
        //注册属性 "WXENTAPPID"
        iDEField = this.createDEField("WXENTAPPID");
        if(iDEField==null) {
            DEFieldModel deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("ba33f6b3660d72d385fd09898c2e3b3f");
            deFieldModel.setName("WXENTAPPID");
            deFieldModel.setDEFType(1);
            deFieldModel.setLogicName("微信企业应用");
            deFieldModel.setDataType("PICKUP");
            deFieldModel.setStdDataType(25);
            deFieldModel.setLinkDEField(true);
            deFieldModel.setImportOrder(1000);
            deFieldModel.setImportTag("");
            deFieldModel.setDERName("DER1N_WXMESSAGE_WXENTAPP_WXENTAPPID");
            deFieldModel.setLinkDEFName("WXENTAPPID");
            deFieldModel.setValueFormat("%1$s");
            iDEFSearchMode = this.createDEFSearchMode(deFieldModel,"N_WXENTAPPID_EQ");
            if(iDEFSearchMode==null) {
                DEFSearchModeModel defSearchModeModel = new DEFSearchModeModel();
                defSearchModeModel.setDEField(deFieldModel);
                defSearchModeModel.setName("N_WXENTAPPID_EQ");
                defSearchModeModel.setValueOp("EQ");
                defSearchModeModel.init();
                deFieldModel.registerDEFSearchMode(defSearchModeModel);
            }
            deFieldModel.init();
            iDEField = deFieldModel;
        }
        this.registerDEField(iDEField);
        //注册属性 "WXENTAPPNAME"
        iDEField = this.createDEField("WXENTAPPNAME");
        if(iDEField==null) {
            DEFieldModel deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("4bced993f68a2f3442200ef794b3faf1");
            deFieldModel.setName("WXENTAPPNAME");
            deFieldModel.setDEFType(1);
            deFieldModel.setLogicName("微信企业应用");
            deFieldModel.setDataType("PICKUPTEXT");
            deFieldModel.setStdDataType(25);
            deFieldModel.setLinkDEField(true);
            deFieldModel.setImportOrder(1000);
            deFieldModel.setImportTag("");
            deFieldModel.setDERName("DER1N_WXMESSAGE_WXENTAPP_WXENTAPPID");
            deFieldModel.setLinkDEFName("WXENTAPPNAME");
            deFieldModel.setValueFormat("%1$s");
            iDEFSearchMode = this.createDEFSearchMode(deFieldModel,"N_WXENTAPPNAME_EQ");
            if(iDEFSearchMode==null) {
                DEFSearchModeModel defSearchModeModel = new DEFSearchModeModel();
                defSearchModeModel.setDEField(deFieldModel);
                defSearchModeModel.setName("N_WXENTAPPNAME_EQ");
                defSearchModeModel.setValueOp("EQ");
                defSearchModeModel.init();
                deFieldModel.registerDEFSearchMode(defSearchModeModel);
            }
            iDEFSearchMode = this.createDEFSearchMode(deFieldModel,"N_WXENTAPPNAME_LIKE");
            if(iDEFSearchMode==null) {
                DEFSearchModeModel defSearchModeModel = new DEFSearchModeModel();
                defSearchModeModel.setDEField(deFieldModel);
                defSearchModeModel.setName("N_WXENTAPPNAME_LIKE");
                defSearchModeModel.setValueOp("LIKE");
                defSearchModeModel.init();
                deFieldModel.registerDEFSearchMode(defSearchModeModel);
            }
            deFieldModel.init();
            iDEField = deFieldModel;
        }
        this.registerDEField(iDEField);
        //注册属性 "WXMESSAGEID"
        iDEField = this.createDEField("WXMESSAGEID");
        if(iDEField==null) {
            DEFieldModel deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("ced0fa8e116db2223542dae39107a8c5");
            deFieldModel.setName("WXMESSAGEID");
            deFieldModel.setDEFType(1);
            deFieldModel.setLogicName("微信消息标识");
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
        //注册属性 "WXMESSAGENAME"
        iDEField = this.createDEField("WXMESSAGENAME");
        if(iDEField==null) {
            DEFieldModel deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("04d78b8573219ea0b1f3b381059132cf");
            deFieldModel.setName("WXMESSAGENAME");
            deFieldModel.setDEFType(1);
            deFieldModel.setLogicName("微信消息名称");
            deFieldModel.setDataType("TEXT");
            deFieldModel.setStdDataType(25);
            deFieldModel.setMajorDEField(true);
            deFieldModel.setImportOrder(1000);
            deFieldModel.setImportTag("");
            deFieldModel.setValueFormat("%1$s");
            iDEFSearchMode = this.createDEFSearchMode(deFieldModel,"N_WXMESSAGENAME_LIKE");
            if(iDEFSearchMode==null) {
                DEFSearchModeModel defSearchModeModel = new DEFSearchModeModel();
                defSearchModeModel.setDEField(deFieldModel);
                defSearchModeModel.setName("N_WXMESSAGENAME_LIKE");
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
        WXMessageDefaultACModel _defaultACModel = new WXMessageDefaultACModel();
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
        mYSQL5ConfigModel.setTableName("t_srfwxmessage");
        mYSQL5ConfigModel.setViewName("v_wxmessage");
        this.registerDEDBConfig(mYSQL5ConfigModel);
    }


    /* (non-Javadoc)
     * @see net.ibizsys.paas.demodel.DataEntityModelBase#prepareDEDataSets()
     */
    @Override
    protected void prepareDEDataSets() throws Exception {
        //注册  DEFAULT
        WXMessageDefaultDSModel _defaultDSModel = new WXMessageDefaultDSModel();
        _defaultDSModel.init(this);
        this.registerDEDataSet(_defaultDSModel);
    }




    /* (non-Javadoc)
     * @see net.ibizsys.paas.demodel.DataEntityModelBase#prepareDEDataQueries()
     */
    @Override
    protected void prepareDEDataQueries() throws Exception {
        //注册  DEFAULT
        WXMessageDefaultDQModel _defaultDQModel = new WXMessageDefaultDQModel();
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
        //注册视图 微信消息实体表格视图
        this.registerPDTDEView("MDATAVIEW","33c6cb0764660e300785aea12b29cda1");
        //注册视图 微信消息实体数据多项选择视图
        this.registerPDTDEView("MPICKUPVIEW","0b26c22b11f60ea6cfffdb10580645af");
        //注册视图 微信消息实体数据选择视图
        this.registerPDTDEView("PICKUPVIEW","c04e3e2a5d821406255d642c9667b6dc");
        //注册视图 微信消息实体数据重定向视图
        this.registerPDTDEView("REDIRECTVIEW","597036171bf0a4833cb9b5cd021dded1");
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

        //放入属性 WXMESSAGENAME - 微信消息名称
        if(true) {
            DEDataSetCond deDataSetCondImpl = new DEDataSetCond();
            deDataSetCondImpl.setCondType(IDEDataSetCond.CONDTYPE_DEFIELD);
            deDataSetCondImpl.setCondOp(ICondition.CONDOP_LIKE);
            deDataSetCondImpl.setDEFName(WXMessage.FIELD_WXMESSAGENAME);
            deDataSetCondImpl.setCondValue(strQuickSearch);
            groupCondImpl.addChildDEDataQueryCond(deDataSetCondImpl);
        }
    }
}