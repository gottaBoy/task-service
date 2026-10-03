package net.ibizsys.paas.datasync;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Timer;
import java.util.TimerTask;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import net.ibizsys.paas.core.IDEDataSyncIn;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.service.ServiceBase;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.sysmodel.BackendServiceBase;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.psrt.srv.codelist.DataChangeEventCodeListModel;
import net.ibizsys.psrt.srv.common.entity.DataSyncAgent;
import net.ibizsys.psrt.srv.common.entity.DataSyncIn;
import net.ibizsys.psrt.srv.common.entity.DataSyncIn2;
import net.ibizsys.psrt.srv.common.entity.DataSyncOut;
import net.ibizsys.psrt.srv.common.entity.DataSyncOut2;
import net.ibizsys.psrt.srv.common.service.DataSyncAgentService;
import net.ibizsys.psrt.srv.common.service.DataSyncIn2Service;
import net.ibizsys.psrt.srv.common.service.DataSyncOut2Service;
import net.ibizsys.psrt.srv.common.service.DataSyncOutService;
import net.sf.json.JSONObject;

/**
 * 数据同步后台服务
 * 
 * @author Administrator
 * 
 */
public class DataSyncBackendService extends BackendServiceBase {

	private static Log log = LogFactory.getLog(DataSyncBackendService.class);

	/**
	 * 轮询间隔时间
	 */
	public final static String PARAM_POLLTIMER = "POLLTIMER";

	/**
	 * 查询的SQL语句
	 */
	public final static String PARAM_QUERYSQL = "QUERYSQL";

	private int nPollTimer = 30000;

	private Timer pollTimer = null;

	protected Hashtable<String, IDataSyncOutEngine> deDataSyncOutEngines = new Hashtable<String, IDataSyncOutEngine>();

	protected Hashtable<String, IDataSyncInEngine> deDataSyncInEngines = new Hashtable<String, IDataSyncInEngine>();

	// protected String strQuerySQL =
	// "SELECT t1.* from t_SRFDataSyncOut t1 where t1.SYNCAGENT='%1$s' ORDER BY t1.CREATEDATE ";

	private String strFileLocalPath = "";

	/**
	 * 数据输出未发送队列服务对象
	 */
	private DataSyncOutService dataSyncOutService = null;

	/**
	 * 数据输出已发送队列服务对象
	 */
	private DataSyncOut2Service dataSyncOut2Service = null;

	/**
	 * 数据输入已处理队列服务对象
	 */
	private DataSyncIn2Service dataSyncIn2Service = null;

	private DataSyncAgentService dataSyncAgentService = null;

	@Override
	protected void onInit() throws Exception {
		super.onInit();

		strFileLocalPath = this.getServiceParam("FILEFOLDER", "");
		if (StringHelper.isNullOrEmpty(strFileLocalPath)) {
			log.warn("没有定义本地文件存储路径，文件同步时可能会发生错误");
		}

		dataSyncOutService = (DataSyncOutService) ServiceGlobal.getService(DataSyncOutService.class);
		dataSyncOut2Service = (DataSyncOut2Service) ServiceGlobal.getService(DataSyncOut2Service.class);
		dataSyncOut2Service = (DataSyncOut2Service) ServiceGlobal.getService(DataSyncOut2Service.class);
		dataSyncAgentService = (DataSyncAgentService) ServiceGlobal.getService(DataSyncAgentService.class);
		dataSyncIn2Service = (DataSyncIn2Service) ServiceGlobal.getService(DataSyncIn2Service.class);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see SA.SRFDA.Ctrl.BaseService#OnStart()
	 */
	@Override
	protected void onStart() throws Exception {
		super.onStart();

		nPollTimer = Integer.parseInt(this.getServiceParam(PARAM_POLLTIMER, "30000"));
		// strQuerySQL = this.getServiceParam(PARAM_QUERYSQL, strQuerySQL);

		prepareDataSyncEngine();

		if (pollTimer == null) {
			pollTimer = new Timer("DEDATASYNCSERVICETIMER");
			pollTimer.schedule(new TimerTask() {
				@Override
				public void run() {
					runTask();
				}
			}, nPollTimer, nPollTimer);
		}

		log.info(StringHelper.format("DataSyncService Start"));
	}

	/**
	 * 准备数据同步引擎
	 * 
	 * @throws Exception
	 */
	protected void prepareDataSyncEngine() throws Exception {
		deDataSyncOutEngines.clear();
		deDataSyncInEngines.clear();

		SelectCond selectCond = new SelectCond();
		ArrayList<DataSyncAgent> dataSyncAgentList = dataSyncAgentService.select(selectCond);

		for (DataSyncAgent dataSyncAgent : dataSyncAgentList) {
			try {
				IDataSyncEngine iDataSyncEngine = createDataSyncEngine(dataSyncAgent);

				if (StringHelper.compare(iDataSyncEngine.getSyncDir(), IDataSyncEngine.SYNCDIR_OUT, true) == 0) {
					deDataSyncOutEngines.put(iDataSyncEngine.getId(), (IDataSyncOutEngine) iDataSyncEngine);
				} else {
					deDataSyncInEngines.put(iDataSyncEngine.getId(), (IDataSyncInEngine) iDataSyncEngine);
				}
			} catch (Exception ex) {
				log.error(StringHelper.format("同步引擎对象[%1$s]初始化发生异常，%2$s", dataSyncAgent.getDataSyncAgentId(), ex.getMessage()));
				continue;
			}
		}
	}

	/**
	 * 重置数据同步引擎
	 */
	protected void resetDataSyncEngine() {
		for (IDataSyncOutEngine iDataSyncOutEngine : deDataSyncOutEngines.values()) {
			try {
				iDataSyncOutEngine.quit();
			} catch (Exception ex) {
				log.error(StringHelper.format("同步引擎对象[%1$s]退出发生异常，%2$s", iDataSyncOutEngine.getId(), ex.getMessage()));
				continue;
			}
		}

		for (IDataSyncInEngine iDataSyncInEngine : deDataSyncInEngines.values()) {
			try {
				iDataSyncInEngine.quit();
			} catch (Exception ex) {
				log.error(StringHelper.format("同步引擎对象[%1$s]退出发生异常，%2$s", iDataSyncInEngine.getId(), ex.getMessage()));
				continue;
			}
		}

		deDataSyncOutEngines.clear();
		deDataSyncInEngines.clear();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.sysmodel.BackendServiceBase#onStop()
	 */
	@Override
	protected void onStop() throws Exception {
		log.info(StringHelper.format("DEDataSyncService Stop"));

		if (pollTimer != null) {
			pollTimer.cancel();
			pollTimer = null;
		}

		resetDataSyncEngine();

		super.onStop();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.sysmodel.BackendServiceBase#onRun()
	 */
	@Override
	protected void onRun() throws Exception {
		// 循环输出引擎，判断输出处于可用状态，才进行
		for (IDataSyncOutEngine iDataSyncOutEngine : deDataSyncOutEngines.values()) {
			try {
				if (!iDataSyncOutEngine.checkSend()) {
					log.error(StringHelper.format("数据同步发送引擎[%1$s]发送测试失败，忽略本轮发送", iDataSyncOutEngine.getName()));
					continue;
				}

				// String strSQL = StringHelper.format(strQuerySQL,
				// iDataSyncOutEngine.getId());
				int PAGESIZE = 500;
				SelectCond selectCond = new SelectCond();
				selectCond.setMaxRowCount(PAGESIZE);
				selectCond.setOrderInfo("ORDER BY CREATEDATE");
				selectCond.set(DataSyncOut.FIELD_SYNCAGENT, iDataSyncOutEngine.getId());

				ArrayList<DataSyncOut> dataSyncOutList = dataSyncOutService.select(selectCond);

				if (dataSyncOutList.size() == 0) continue;

				// 循环处理
				for (DataSyncOut dataSyncOut : dataSyncOutList) {
					DefaultDataSyncParam defaultDataSyncParam = new DefaultDataSyncParam();
					defaultDataSyncParam.setDataSyncOut(dataSyncOut);

					DataSyncOut2 dataSyncOut2 = new DataSyncOut2();
					dataSyncOut.copyTo(dataSyncOut2, false);
					dataSyncOut2.setDataSyncOut2Id(dataSyncOut.getDataSyncOutId());
					dataSyncOut2.setDataSyncOut2Name(dataSyncOut.getDataSyncOutName());

					try {
						iDataSyncOutEngine.send(defaultDataSyncParam);
					} catch (Exception ex) {
						dataSyncOut2.setError(StringHelper.format("处理实体数据同步发生异常，%1$s", ex.getMessage()));
					}

					// 删除数据
					dataSyncOutService.remove(dataSyncOut);

					dataSyncOut2Service.create(dataSyncOut2, false);
				}

			} catch (Exception ex) {
				log.error(StringHelper.format("数据同步接收引擎[%1$s]发送数据发生异常，%2$s", iDataSyncOutEngine.getName(), ex.getMessage()), ex);
			}
		}

		for (IDataSyncInEngine iDataSyncInEngine : deDataSyncInEngines.values()) {
			try {
				DefaultDataSyncParam defaultDataSyncParam = new DefaultDataSyncParam();
				iDataSyncInEngine.recv(defaultDataSyncParam);

				// 进行数据处理
				processDataSyncIns(defaultDataSyncParam.getDataSyncIns());
				defaultDataSyncParam.resetDataSyncIns();
			} catch (Exception ex) {
				log.error(StringHelper.format("数据同步接收引擎[%1$s]接收数据发生异常，%2$s", iDataSyncInEngine.getName(), ex.getMessage()), ex);
			}
		}

	}

	/**
	 * 处理数据同步输入
	 * 
	 * @param dataSyncInList
	 */
	protected void processDataSyncIns(ArrayList<DataSyncIn> dataSyncInList) throws Exception {
		if (dataSyncInList.size() == 0) return;

		for (DataSyncIn dataSyncIn : dataSyncInList) {

			java.util.Iterator<IDEDataSyncIn> deDataSyncIns = DataSyncGlobal.getDEDataSyncIns(dataSyncIn.getDEName());
			if (deDataSyncIns == null) continue;

			DataSyncIn2 dataSyncIn2 = new DataSyncIn2();
			dataSyncIn.copyTo(dataSyncIn2, true);
			dataSyncIn2.setDataSyncIn2Name(dataSyncIn.getDataSyncInName());

			while (deDataSyncIns.hasNext()) {
				IDEDataSyncIn iDEDataSyncIn = deDataSyncIns.next();
				if (StringHelper.compare(iDEDataSyncIn.getSyncAgent(), dataSyncIn.getSyncAgent(), false) != 0) continue;

				try {
					IService iService = DEModelGlobal.getDEModel(iDEDataSyncIn.getDataEntity().getName()).getService();
					iService.syncData(dataSyncIn, iDEDataSyncIn);
				} catch (Exception ex) {
					String strError = StringHelper.format("[%1$s]%2$s", iDEDataSyncIn.getDataEntity().getName(), ex.getMessage());
					if (StringHelper.isNullOrEmpty(dataSyncIn2.getError())) {
						dataSyncIn2.setError(strError);
					} else {
						dataSyncIn2.setError(dataSyncIn2.getError() + ";" + strError);
					}
				}
			}

			try {
				dataSyncIn2Service.create(dataSyncIn2, false);
			} catch (Exception ex) {
				dataSyncIn2.setError(StringHelper.format("保存数据同步输入队列(已处理)数据发生错误，%1$s", ex.getMessage()));
				log.error(dataSyncIn2.getError());
			}

		}
	}

	/**
	 * 判断数据是否导入
	 * 
	 * @param dataSyncIn
	 * @param iDEDataSyncIn
	 * @param iService
	 * @return
	 * @throws Exception
	 */
	protected boolean testDataImport(DataSyncIn dataSyncIn, IDEDataSyncIn iDEDataSyncIn, IService iService) throws Exception {
		if ((dataSyncIn.getEventType() & iDEDataSyncIn.getEventType()) == 0) return false;

		if (StringHelper.isNullOrEmpty(iDEDataSyncIn.getTestDEActionName())) {
			return true;
		}

		IEntity iEntity = iService.getDEModel().createEntity();
		if (!StringHelper.isNullOrEmpty(dataSyncIn.getLogicData())) {
			DataObject.fromJSONObject(iEntity, JSONObjectHelper.fromString(dataSyncIn.getLogicData()));
		}

		iService.executeAction(iDEDataSyncIn.getTestDEActionName(), iEntity);
		return DataObject.getBoolValue(iEntity, ServiceBase.RET, false);
	}

	/**
	 * 处理数据导入
	 * 
	 * @param dataSyncIn
	 * @param processInfo
	 * @throws Exception
	 */
	protected void processDataImport(DataSyncIn dataSyncIn, IDEDataSyncIn iDEDataSyncInc, IService iService) throws Exception {
		if (StringHelper.isNullOrEmpty(iDEDataSyncInc.getImportDEActionName())) {
			// 没有指定输入行为，按照常规处理
			if (dataSyncIn.getEventType() == DataChangeEventCodeListModel.DELETE) {
				// 移除数据
				IEntity iEntity = iService.getDEModel().createEntity();
				iEntity.set(iService.getDEModel().getKeyDEField().getName(), dataSyncIn.getDataKey());
				try {
					iService.remove(iEntity);
				} catch (Exception ex) {
					throw new Exception(StringHelper.format("移除实体[%1$s]数据[%2$s]发生错误，%3$s", dataSyncIn.getDEName(), dataSyncIn.getDataKey(), ex.getMessage()));
				}
			} else if ((dataSyncIn.getEventType() & DataChangeEventCodeListModel.CREATEORUPDATE) > 0) {
				IEntity iEntity = iService.getDEModel().createEntity();
				JSONObject jo = JSONObjectHelper.fromString(dataSyncIn.getLogicData());
				DataObject.fromJSONObject(iEntity, jo);
				try {
					iService.save(iEntity);
				} catch (Exception ex) {
					throw new Exception(StringHelper.format("保存实体[%1$s]数据[%2$s]发生错误，%3$s", dataSyncIn.getDEName(), dataSyncIn.getDataKey(), ex.getMessage()));
				}
			}
		} else {
			IEntity iEntity = iService.getDEModel().createEntity();
			JSONObject jo = JSONObjectHelper.fromString(dataSyncIn.getLogicData());
			DataObject.fromJSONObject(iEntity, jo);
			try {
				iService.executeAction(iDEDataSyncInc.getImportDEActionName(), iEntity);
			} catch (Exception ex) {
				throw new Exception(StringHelper.format("导入实体[%1$s]数据[%2$s]发生错误，%3$s", dataSyncIn.getDEName(), dataSyncIn.getDataKey(), ex.getMessage()));
			}
		}

		// // 新建或更新
		// XMLNode rootNode = XMLNode.LoadFromXML(dataSyncIn.getDATA());
		// if (rootNode == null) {
		// processInfo.Append("数据内容无效");
		// return;
		// }
		// if (rootNode.getChildNodes() != null) {
		// int nIndex = 0;
		// for (XMLNode xmlNode : rootNode.getChildNodes()) {
		// nIndex++;
		// String strDEId = xmlNode.GetExtValue("SRFDEID", "");
		// if (StringHelper.isNullOrEmpty(strDEId)) {
		// processInfo.Append("[%1$s]没有指定对应的数据对象\r\n", nIndex);
		// continue;
		// }
		//
		// IDEDataCtrl deDataCtrl =
		// this.getGlobalHelper().getDAModelStorage().FindGlobalDEDataCtrl(strDEId,
		// "SA.SRFDA.Ctrl.DataSync.DataSyncService");
		// if (deDataCtrl == null) {
		// processInfo.Append("[%1$s]无法获取实体[%2$s]数据访问对象\r\n", nIndex, strDEId);
		// continue;
		// }
		//
		// IDEHelper iDEHelper = deDataCtrl.GetDEHelper();
		//
		// CallResult callResult = null;
		// try {
		// xmlNode.SetValue("SRFACTIONMODE", deDataSync.getIMPORTACTIONMODE());
		// callResult = deDataCtrl.Import(xmlNode);
		// if (callResult.IsError()) {
		// processInfo.Append("[%1$s]导入数据失败：%2$s\r\n", nIndex,
		// callResult.getErrorInfo());
		// continue;
		// }
		// } catch (Exception ex) {
		// processInfo.Append("[%1$s]导入数据发生异常：%2$s\r\n", nIndex,
		// ex.getMessage());
		// continue;
		// }
		//
		// BaseDataEntity dataEntity = null;
		// if (callResult.getUserObject() != null && callResult.getUserObject()
		// instanceof BaseDataEntity) {
		// dataEntity = (BaseDataEntity) callResult.getUserObject();
		// }
		//
		// String strCustomCall = xmlNode.GetExtValue("SRFCUSTOMCALL", "");
		// if (StringHelper.isNullOrEmpty(strCustomCall)) {
		// String strRemoveCall = xmlNode.GetExtValue("SRFREMOVE", "");
		// if (StringHelper.compare(strRemoveCall, "TRUE", true) == 0) {
		// String strKeyData = xmlNode.GetExtValue("SRFARG", "");
		// if (callResult.getRetCode() == Errors.OK) {
		// continue;
		// } else {
		// processInfo.Append("[%1$s][%2$s:%3$s]删除数据[%4$s]失败：%5$s!\r\n", nIndex,
		// iDEHelper.getName(), iDEHelper.getLogicName(), strKeyData,
		// callResult.getErrorInfo());
		// continue;
		// }
		// } else {
		// String strSqlPatch = xmlNode.GetExtValue("SRFSQLPATCH", "");
		// if (StringHelper.compare(strSqlPatch, "TRUE", true) == 0) {
		// String strPatchName = xmlNode.GetExtValue("SQLPATCHNAME", "");
		// if (callResult.getRetCode() == Errors.OK) {
		// continue;
		// } else {
		// processInfo.Append("[%1$s][%2$s:%3$s]执行数据库补丁[%4$s]失败：%5$s!\r\n",
		// nIndex, iDEHelper.getName(), iDEHelper.getLogicName(), strPatchName,
		// callResult.getErrorInfo());
		// continue;
		// }
		// } else {
		// String strDER1NSYNC = xmlNode.GetExtValue("SRFDER1NSYNC", "");
		// if (StringHelper.compare(strDER1NSYNC, "TRUE", true) == 0) {
		// String strDER1NID = xmlNode.GetExtValue("SRFDER1NID", "");
		// if (callResult.getRetCode() == Errors.OK) {
		// continue;
		// } else {
		// processInfo.Append("[%1$s][%2$s:%3$s]同步1:N关系数据[%4$s]失败：%5$s!\r\n",
		// nIndex, iDEHelper.getName(), iDEHelper.getLogicName(), strDER1NID,
		// callResult.getErrorInfo());
		// continue;
		// }
		// } else {
		// if (callResult.getRetCode() == Errors.OK) {
		// continue;
		// } else {
		// processInfo.Append("[%1$s][%2$s:%3$s]导入数据[%4$s]失败：%5$s!\r\n", nIndex,
		// iDEHelper.getName(), iDEHelper.getLogicName(), (dataEntity == null) ?
		// "未知" : iDEHelper.GetDataInfo(dataEntity), callResult.getErrorInfo());
		// continue;
		// }
		// }
		// }
		// }
		// } else {
		// if (callResult.getRetCode() == Errors.OK) {
		// continue;
		// } else {
		// processInfo.Append("[%1$s][%2$s:%3$s]执行自定义操作[%5$s](%4$s)失败：%5$s!\r\n",
		// nIndex, iDEHelper.getName(), iDEHelper.getLogicName(), (dataEntity ==
		// null) ? "未知" : iDEHelper.GetDataInfo(dataEntity),
		// callResult.getErrorInfo(), strCustomCall);
		// continue;
		// }
		//
		// }
		// }
		// }
	}

	/**
	 * 建立数据同步引擎
	 * 
	 * @param dataSyncAgent
	 * @return
	 * @throws Exception
	 */
	protected IDataSyncEngine createDataSyncEngine(DataSyncAgent dataSyncAgent) throws Exception {
		ActiveMQDataSyncEngine activeMQDataSyncEngine = new ActiveMQDataSyncEngine();
		activeMQDataSyncEngine.init(dataSyncAgent);
		return activeMQDataSyncEngine;
	}
}
