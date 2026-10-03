/**
 *  iBizSys 5.0 用户自定义代码
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.wf.service;


import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.db.SqlParamList;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.IServiceWork;
import net.ibizsys.paas.service.ITransaction;
import net.ibizsys.paas.util.DateHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.WebConfig;
import net.ibizsys.psrt.srv.wf.entity.WFInstance;
import net.ibizsys.psrt.srv.wf.entity.WFStep;
import net.ibizsys.psrt.srv.wf.entity.WFStepData;

/**
 * 实体[WFWorkList2] 服务对象
 */
@Component
public class WFWorkList2Service extends WFWorkList2ServiceBase {

    private static final Log log = LogFactory.getLog(WFWorkList2Service.class);
    public WFWorkList2Service () {
        super();

    }

    
    /**
     * 根据工作流实例取消工作列表
     * @param wfInstance
     * @throws Exception
     */
    public List<IEntity> cancelByWFInstance(WFInstance wfInstance)throws Exception {
    	final WFInstance wfInstance2 = wfInstance;
    	final CallResult callResult = new CallResult();
        this.doServiceWork(new IServiceWork() {
            @Override
            public void execute(ITransaction iTransaction) throws Exception {
            	callResult.setUserObject(onCancelByWFInstance(wfInstance2));
            }
        });
        return (List<IEntity>)callResult.getUserObject();
    }
    
    /**
     * 根据工作流实例取消工作列表实现
     * @param wfInstance
     * @throws Exception
     */
    protected List<IEntity> onCancelByWFInstance(WFInstance wfInstance)throws Exception {
    	String strSQL = "" ;
    	List<IEntity> wfWorkList = null ;
    	if(WebConfig.getCurrent().isLowCaseSql()) {
    		strSQL = StringHelper.format("update t_srfwfworklist set cancelflag=1,updatedate=? where  cancelflag=0 and wfinstanceid=?");
    		wfWorkList = this.selectRaw(StringHelper.format("select cancelflag,cancelinform,createdate,createman,originalwfuserid,originalwfusername,updatedate,updateman,userdata,userdata2,userdata3,userdata4,userdatainfo,wfactorid,wfinstanceid,wfinstancename,wflanrestag,wfstepid,wfsteplanrestag,wfstepname,wfworkflowid,wfworkflowname,wfworklistid,wfworklistname,workinform from t_srfwfworklist where cancelflag=0 and wfinstanceid='%1$s'", wfInstance.getWFInstanceId()), null);
    	}else {
    		strSQL = StringHelper.format("UPDATE T_SRFWFWORKLIST SET CANCELFLAG=1,UPDATEDATE=? WHERE  CANCELFLAG=0 AND WFINSTANCEID=?");
    		wfWorkList = this.selectRaw(StringHelper.format("SELECT * FROM T_SRFWFWORKLIST WHERE CANCELFLAG=0 AND WFINSTANCEID='%1$s'", wfInstance.getWFInstanceId()), null);
    	}
		SqlParamList sqlParamList = new SqlParamList();
		sqlParamList.addDateTime(DateHelper.getCurTime());
		sqlParamList.addString(wfInstance.getWFInstanceId());
		this.executeRaw(strSQL, sqlParamList);
		return wfWorkList;
    }
    
    /**
     * 根据工作流步骤数据取消工作列表
     * @param stepData
     * @throws Exception
     */
    public List<IEntity> cancelByWFStepData(WFStepData stepData)throws Exception {
    	final WFStepData stepData2 = stepData;
    	final CallResult callResult = new CallResult();
        this.doServiceWork(new IServiceWork() {
            @Override
            public void execute(ITransaction iTransaction) throws Exception {
            	callResult.setUserObject(onCancelByWFStepData(stepData2));
            	
            }
        });
        return (List<IEntity>)callResult.getUserObject();
    }
    
    /**
     * 根据工作流步骤数据取消工作列表实现
     * @param stepData
     * @throws Exception
     */
    protected List<IEntity> onCancelByWFStepData(WFStepData stepData)throws Exception {
    	String strSQL = "" ;
    	List<IEntity> wfWorkList = null ;
    	if(WebConfig.getCurrent().isLowCaseSql()) {
    		strSQL = StringHelper.format("update t_srfwfworklist set cancelflag=1,updatedate=? where wfstepid = ? and wfinstanceid=? and wfactorid=? and cancelflag=0");
    		wfWorkList = this.selectRaw(StringHelper.format("select cancelflag,cancelinform,createdate,createman,originalwfuserid,originalwfusername,updatedate,updateman,userdata,userdata2,userdata3,userdata4,userdatainfo,wfactorid,wfinstanceid,wfinstancename,wflanrestag,wfstepid,wfsteplanrestag,wfstepname,wfworkflowid,wfworkflowname,wfworklistid,wfworklistname,workinform from t_srfwfworklist where wfstepid = '%1$s' and wfinstanceid='%2$s' and wfactorid= '%3$s' and cancelflag=0", stepData.getWFStepId(), stepData.getWFInstanceId(), stepData.getActorId()), null);
    	}else {
    		strSQL = StringHelper.format("UPDATE T_SRFWFWORKLIST SET CANCELFLAG=1,UPDATEDATE=? WHERE WFSTEPID = ? AND WFINSTANCEID=? AND WFACTORID=? and cancelflag=0");
    		wfWorkList = this.selectRaw(StringHelper.format("SELECT * FROM T_SRFWFWORKLIST WHERE WFSTEPID = '%1$s' AND WFINSTANCEID='%2$s' AND WFACTORID= '%3$s' and cancelflag=0", stepData.getWFStepId(), stepData.getWFInstanceId(), stepData.getActorId()), null);
    	}
    	SqlParamList sqlParamList = new SqlParamList();
		sqlParamList.addDateTime(DateHelper.getCurTime());
		sqlParamList.addString(stepData.getWFStepId());
		sqlParamList.addString(stepData.getWFInstanceId());
		sqlParamList.addString(stepData.getActorId());
		this.executeRaw(strSQL, sqlParamList);
		return wfWorkList;
    }
    
    /**
     * 根据工作流步骤取消工作列表
     * @param wfStep
     * @throws Exception
     */
    public List<IEntity> cancelByWFStep(WFStep wfStep)throws Exception {
    	final WFStep wfStep2 = wfStep;
    	final CallResult callResult = new CallResult();
        this.doServiceWork(new IServiceWork() {
            @Override
            public void execute(ITransaction iTransaction) throws Exception {
            	callResult.setUserObject(onCancelByWFStep(wfStep2));
            }
        });
        return (List<IEntity>)callResult.getUserObject();
    }
    
    /**
     * 根据工作流步骤取消工作列表实现
     * @param wfStep
     * @throws Exception
     */
    protected List<IEntity> onCancelByWFStep(WFStep wfStep)throws Exception {
    	String strSQL = "" ;
    	List<IEntity> wfWorkList = null ;
    	if(WebConfig.getCurrent().isLowCaseSql()) {
    		strSQL = StringHelper.format("update t_srfwfworklist set cancelflag=1,updatedate=? where wfstepid = ? and wfinstanceid=? and cancelflag=0");
    		wfWorkList = this.selectRaw(StringHelper.format("select cancelflag,cancelinform,createdate,createman,originalwfuserid,originalwfusername,updatedate,updateman,userdata,userdata2,userdata3,userdata4,userdatainfo,wfactorid,wfinstanceid,wfinstancename,wflanrestag,wfstepid,wfsteplanrestag,wfstepname,wfworkflowid,wfworkflowname,wfworklistid,wfworklistname,workinform from t_srfwfworklist where wfstepid = '%1$s' and wfinstanceid='%2$s' and cancelflag=0", wfStep.getWFStepId(), wfStep.getWFInstanceId()), null);
    	}else {
    		strSQL = StringHelper.format("UPDATE T_SRFWFWORKLIST SET CANCELFLAG=1,UPDATEDATE=? WHERE WFSTEPID = ? AND WFINSTANCEID=? and cancelflag=0");
    		wfWorkList = this.selectRaw(StringHelper.format("SELECT * FROM T_SRFWFWORKLIST WHERE WFSTEPID = '%1$s' AND WFINSTANCEID='%2$s' and cancelflag=0", wfStep.getWFStepId(), wfStep.getWFInstanceId()), null);
    	}
    	
		SqlParamList sqlParamList = new SqlParamList();
		sqlParamList.addDateTime(DateHelper.getCurTime());
		sqlParamList.addString(wfStep.getWFStepId());
		sqlParamList.addString(wfStep.getWFInstanceId());
		this.executeRaw(strSQL, sqlParamList);
		return wfWorkList;
    }
    
}