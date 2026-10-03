package net.ibizsys.paas.core;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.sysmodel.BackendServiceBase;
import net.ibizsys.paas.util.ObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.psrt.srv.common.entity.DEDataChg;
import net.ibizsys.psrt.srv.common.entity.DEDataChg2;
import net.ibizsys.psrt.srv.common.entity.DEDataChgDisp;
import net.ibizsys.psrt.srv.common.service.DEDataChg2Service;
import net.ibizsys.psrt.srv.common.service.DEDataChgDispService;
import net.ibizsys.psrt.srv.common.service.DEDataChgService;

/**
 * 实体数据变化派发服务
 * 
 * @author LionLau
 * 
 */
public class DEDataChangeDispatchBackendService extends BackendServiceBase {
	private static Log log = LogFactory.getLog(DEDataChangeDispatchBackendService.class);

	/**
	 * 轮询间隔时间
	 */
	public final static String PARAM_POLLTIMER = "POLLTIMER";

	/**
	 * 查询的SQL语句
	 */
	public final static String PARAM_QUERYSQL = "QUERYSQL";

	private int nPollTimer = 15000;

	private Timer pollTimer = null;

	protected ArrayList<IDEDataChangeDispatcher> dataChangeDispatcherList = new ArrayList<IDEDataChangeDispatcher>();

	// protected String strQuerySQL = "select t1.* from T_SRFDEDataChg T1 ORDER BY t1.CREATEDATE ";

	private DEDataChgDispService deDataChgDispService = null;

	private DEDataChgService deDataChgService = null;

	private DEDataChg2Service deDataChg2Service = null;

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.sysmodel.BackendServiceBase#onInit()
	 */
	@Override
	protected void onInit() throws Exception {
		deDataChgDispService = (DEDataChgDispService) ServiceGlobal.getService(DEDataChgDispService.class);
		deDataChgService = (DEDataChgService) ServiceGlobal.getService(DEDataChgService.class);
		deDataChg2Service = (DEDataChg2Service) ServiceGlobal.getService(DEDataChg2Service.class);
		super.onInit();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.sysmodel.BackendServiceBase#onStart()
	 */
	@Override
	protected void onStart() throws Exception {
		nPollTimer = Integer.parseInt(this.getServiceParam(PARAM_POLLTIMER, "15000"));
		// strQuerySQL = this.getServiceParam(PARAM_QUERYSQL, strQuerySQL);

		SelectCond selectCond = new SelectCond();
		selectCond.set(DEDataChgDisp.FIELD_VALIDFLAG, 1);
		ArrayList<DEDataChgDisp> deDataChgDispList = deDataChgDispService.select(selectCond);

		for (DEDataChgDisp deDataChgDisp : deDataChgDispList) {
			Object objDEDataChgDisp = ObjectHelper.create(deDataChgDisp.getEngineObject());
			if (objDEDataChgDisp == null) {
				throw new Exception(StringHelper.format("无法建立实体数据变更分发引擎对象[%1$s]", deDataChgDisp.getEngineObject()));
			}

			IDEDataChangeDispatcher iDEDataChangeDispatcher = null;
			if (!(objDEDataChgDisp instanceof IDEDataChangeDispatcher)) {
				throw new Exception(StringHelper.format("实体数据变更分发引擎对象[%1$s]类型不正确", deDataChgDisp.getEngineObject()));
			}

			iDEDataChangeDispatcher = (IDEDataChangeDispatcher) objDEDataChgDisp;
			iDEDataChangeDispatcher.init(deDataChgDisp);

			dataChangeDispatcherList.add(iDEDataChangeDispatcher);
		}

		if (pollTimer == null) {
			pollTimer = new Timer("DEDATACHANGEDISPATCH");
			pollTimer.schedule(new TimerTask() {
				@Override
				public void run() {
					runTask();
				}
			}, nPollTimer, nPollTimer);
		}

		log.info(StringHelper.format("DEDataChangeDispatchService Start"));

		super.onStart();

	}

	// /**
	// * 准备实体数据变更派发引擎
	// * @throws Exception
	// */
	// protected void prepareDEDataChangeDispatcher() throws Exception
	// {
	// dataChangeDispatchs.clear();
	//
	// ArrayList<DEDataChgDisp> deDataChgDisps = new ArrayList<DEDataChgDisp>();
	// CallResult callResult =
	// this.getGlobalHelper().getDAModelHelper().GetValidDEDataChgDisps(deDataChgDisps);
	// if(callResult.IsError())
	// {
	// throw new
	// Exception(StringHelper.format("查询启用的实体数据变更派发引擎发生错误，%1$s",callResult.getErrorInfo()));
	// }
	//
	//
	// for(DEDataChgDisp deDataChgDisp : deDataChgDisps )
	// {
	// Object deDataChgDispObj =
	// ObjectHelper.create(deDataChgDisp.getEngineObject());
	// if(deDataChgDispObj == null)
	// {
	// log.error(StringHelper.format("无法建立引擎对象[%1$s]",deDataChgDisp.getEngineObject()));
	// continue;
	// }
	//
	// if(!(deDataChgDispObj instanceof IDEDataChangeDispatch))
	// {
	// log.error(StringHelper.format("引擎对象[%1$s]类型不正确",deDataChgDisp.getEngineObject()));
	// continue;
	// }
	//
	// try
	// {
	// IDEDataChangeDispatch iDEDataChangeDispatch =
	// (IDEDataChangeDispatch)deDataChgDispObj;
	// iDEDataChangeDispatch.Init(this.getGlobalHelper(), deDataChgDisp);
	// dataChangeDispatchs.add(iDEDataChangeDispatch);
	// }
	// catch(Exception ex)
	// {
	// log.error(StringHelper.format("引擎对象[%1$s]初始化发生异常，%2$s",deDataChgDisp.getEngineObject(),ex.getMessage()));
	// continue;
	// }
	// }
	// }

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.sysmodel.BackendServiceBase#onStop()
	 */
	@Override
	protected void onStop() throws Exception {
		log.info(StringHelper.format("DEDataChangeDispatchService Stop"));

		if (pollTimer != null) {
			pollTimer.cancel();
			pollTimer = null;
		}

		dataChangeDispatcherList.clear();

		super.onStop();
	}

	@Override
	protected void onRun() throws Exception {

		super.onRun();

		SelectCond selectCond = new SelectCond();
		selectCond.setOrderInfo("ORDER BY CREATEDATE");
		selectCond.setMaxRowCount(500);
		ArrayList<DEDataChg> deDataChgList = deDataChgService.select(selectCond);
		for (DEDataChg deDataChg : deDataChgList) {

			String strDispError = "";
			DEDataChg2 deDataChg2 = new DEDataChg2();
			deDataChg.copyTo(deDataChg2, false);
			deDataChg2.setDEDataChg2Id(deDataChg.getDEDataChgId());
			deDataChg2.setDEDataChg2Name(deDataChg.getDEDataChgName());

			try {
				DefaultDEDataChangeDispatchParam dataChangeDispatchParam = new DefaultDEDataChangeDispatchParam(DEModelGlobal.getDEModel(deDataChg.getDEName()), deDataChg);

				if (deDataChg.getEventType() == IService.DATACHGEVENT_DELETE) {

				} else {

					// 判断是否已经展开数据
					// if (deDataChg.isDATANull()) {
					// IDEDataCtrl iDEDataCtrl = this.getGlobalHelper().getDAModelStorage().FindGlobalDEDataCtrl(deDataChg.getDEID(), "SA.SRFDA.Ctrl.DEDataChangeDispatchService");
					//
					// BaseDataEntity dataEntity = new BaseDataEntity();
					// dataEntity.SetParamValue(iDEDataCtrl.GetDEHelper().GetKeyDEFHelper().getName(), iDEDataCtrl.GetDEHelper().GetKeyDEFHelper().GetDEFValue(deDataChg.getDATAKEY()));
					//
					// XMLNode rootNode = new XMLNode();
					// rootNode.setNodeName("SRFDAXMLEXPORTS");
					//
					// CallResult callResult = iDEDataCtrl.Get(dataEntity);
					// if (callResult.IsError()) {
					// throw new Exception(StringHelper.format("查询实体[%1$s]数据[%2$s]发生错误，%3$s", iDEDataCtrl.GetDEHelper().getId(), deDataChg.getDATAKEY(), callResult.getErrorInfo()));
					// }
					//
					// if (iDEDataCtrl.GetDEHelper().GetDataChangeLogMode() == DataEntity.DEDataChgLOG_FULLDATA_ASYNC) {
					// ArrayList<XMLNode> exportXMLNodes = new ArrayList<XMLNode>();
					// // 导出XML
					// callResult = iDEDataCtrl.Export(dataEntity, exportXMLNodes, false, false);
					// if (callResult.IsError()) {
					// throw new Exception(StringHelper.format("导出实体[%1$s]数据模型发生错误，%2$s", iDEDataCtrl.GetDEHelper().getId(), callResult.getErrorInfo()));
					// }
					//
					// for (XMLNode xmlNode : exportXMLNodes) {
					// xmlNode.setNodeName("SRFDAXMLEXPORT");
					// rootNode.AddNode(xmlNode);
					// }
					// } else {
					// XMLNode xmlNode = new XMLNode();
					// xmlNode.setNodeName("SRFDAXMLEXPORT");
					// xmlNode.SetValue("SRFDEID", iDEDataCtrl.GetDEHelper().getId());
					// xmlNode.SetValue("SRFVALUE", BaseDataEntity.ToString(dataEntity, iDEDataCtrl.GetDEHelper().IsExportIncEmpty()));
					//
					// rootNode.AddNode(xmlNode);
					// }
					//
					// String strXML = XMLNode.Export(rootNode);
					// deDataChg.setDATA(strXML);
					// deDataChg2.setDATA(strXML);
					// deDataChg.setLOGICDATA(BaseDataEntity.ToString(dataEntity));
					// deDataChg2.setLOGICDATA(deDataChg.getLOGICDATA());
					// dataChangeDispatchParam.setExportNode(rootNode);
					// }
				}

				for (IDEDataChangeDispatcher iDEDataChangeDispatcher : dataChangeDispatcherList) {
					try {
						iDEDataChangeDispatcher.dispatch(dataChangeDispatchParam);
					}

					catch (Exception ex) {
						log.error(StringHelper.format("处理数据变更分发引擎【%1$s】发生异常，%2$s", iDEDataChangeDispatcher.getName(), ex.getMessage()), ex);
						if (!StringHelper.isNullOrEmpty(strDispError)) {
							strDispError += "\r\n";
						}
						strDispError += StringHelper.format("处理数据变更分发引擎【%1$s】发生异常，%2$s", iDEDataChangeDispatcher.getName(), ex.getMessage());
					}
				}
			} catch (Exception ex) {
				log.error(StringHelper.format("处理数据变更分发发生异常，%1$s", ex.getMessage()), ex);
				deDataChg2.setError(StringHelper.format("处理数据变更分发发生异常，%1$s", ex.getMessage()));
			}

			if (!StringHelper.isNullOrEmpty(strDispError)) deDataChg2.setDISPError(strDispError);

			// 移除已处理数据
			try {
				deDataChgService.remove(deDataChg);
			} catch (Exception ex) {
				log.error(StringHelper.format("移除已处理实体数据变更发生错误，%1$", ex.getMessage()));
				continue;
			}

			// 保存已处理数据
			try {
				deDataChg2Service.create(deDataChg2, false);
			} catch (Exception ex) {
				log.error(StringHelper.format("保存已处理实体数据变更发生错误，%1$", ex.getMessage()));
				continue;
			}
		}
	}
}
