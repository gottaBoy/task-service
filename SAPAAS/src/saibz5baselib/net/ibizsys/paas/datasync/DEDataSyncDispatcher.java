package net.ibizsys.paas.datasync;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import net.ibizsys.paas.core.DEDataChangeDispatcherBase;
import net.ibizsys.paas.core.IDEDataChangeDispatchParam;
import net.ibizsys.paas.core.IDEDataSync;
import net.ibizsys.paas.core.IDEDataSyncOut;
import net.ibizsys.paas.core.IDataEntity;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.service.ServiceBase;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.psrt.srv.common.entity.DataSyncOut;
import net.ibizsys.psrt.srv.common.service.DataSyncOutService;

/**
 * 数据同步派发器
 * 
 * @author LionLau
 *
 */
public class DEDataSyncDispatcher extends DEDataChangeDispatcherBase {

	private static final Log log = LogFactory.getLog(DEDataSyncDispatcher.class);

	private DataSyncOutService dataSyncOutService = null;

	@Override
	protected void onInit() throws Exception {
		this.dataSyncOutService = (DataSyncOutService) ServiceGlobal.getService(DataSyncOutService.class);
		super.onInit();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.DEDataChangeDispatcherBase#onDispatch(net.ibizsys.paas.core.IDEDataChangeDispatchParam)
	 */
	@Override
	protected void onDispatch(IDEDataChangeDispatchParam iDEDataChangeDispatchParam) throws Exception {
		IDataEntity iDataEntity = iDEDataChangeDispatchParam.getDataEntity();

		// 放入同步队列
		java.util.Iterator<IDEDataSync> iDEDataSyncOuts = iDataEntity.getDEDataSyncs(false);
		if (iDEDataSyncOuts == null) return;

		while (iDEDataSyncOuts.hasNext()) {
			IDEDataSyncOut iDEDataSyncOut = (IDEDataSyncOut) iDEDataSyncOuts.next();
			if (!onTestDispatch(iDEDataChangeDispatchParam, iDEDataSyncOut)) continue;

			// 放入队列中
			DataSyncOut dataSyncOut = new DataSyncOut();
			iDEDataChangeDispatchParam.getDEDataChg().copyTo(dataSyncOut, false);
			dataSyncOut.setSyncAgent(iDEDataSyncOut.getSyncAgent());

			if ((dataSyncOut.getEventType() & IService.DATACHGEVENT_INSERTORUPDATE) > 0) {
				// 判断有无制定文件属性
				// String strFileFields = iDEDataSyncOut.getFILEFIELDS();
				// if(!StringHelper.IsNullOrEmpty(strFileFields))
				// {
				// Vector<String> fileIds = new Vector<String>();
				// String []fields = StringHelper.SplitEx(strFileFields);
				// for(int i=0;i<fields.length;i++)
				// {
				// String strField = fields[i];
				// String strFieldValue = iDEDataChangeDispatchParam.getLogicData().GetParamStringValue(strField, "");
				// if(StringHelper.IsNullOrEmpty(strFieldValue))
				// continue;
				//
				// //判断是否为单文件存储
				// if(strFieldValue.indexOf("<?xml") == 0)
				// {
				// XMLNode fileListNode = new XMLNode();
				// XMLNode.LoadFromXML(strFieldValue,fileListNode);
				// if(fileListNode.getChildNodes()!=null)
				// {
				// for(XMLNode fileNode : fileListNode.getChildNodes())
				// {
				// String strFileId = fileNode.GetExtValue("FILEID", "");
				// if(!StringHelper.IsNullOrEmpty(strFileId))
				// fileIds.add(strFileId);
				// }
				// }
				// }
				// else
				// {
				// fileIds.add(strFieldValue);
				// }
				// }
				//
				// if(fileIds.size()>0)
				// {
				// String strFilePaths = "";
				// XMLNode dataNode = XMLNode.LoadFromXML(dataSyncOut.getDATA());
				// IDEDataCtrl fileDataCtrl = this.getGlobalHelper().getDAModelStorage().FindGlobalDEDataCtrl(SRFDAGlobal.DEID_FILE, "SA.SRFDA.Ctrl.DEDataSyncDispatcher");
				// for(String strFileId :fileIds)
				// {
				// //循环读出每个文件
				// File file = new File();
				// file.setFILE_ID(strFileId);
				// CallResult callResult = fileDataCtrl.Get(file);
				// if(callResult.IsError())
				// {
				// log.error(StringHelper.Format("查询文件[%1$s]数据发生错误，%2$s",strFileId,callResult.getErrorInfo()));
				// continue;
				// }
				//
				// //增加文件节点
				// String strFileData = BaseDataEntity.ToString(file, true);
				// XMLNode fileNode= new XMLNode();
				//
				// fileNode.setNodeName("SRFDAXMLEXPORT");
				// fileNode.SetValue("SRFDEID",SRFDAGlobal.DEID_FILE);
				// fileNode.SetValue("SRFVALUE", strFileData);
				//
				// dataNode.getChildNodes().add(fileNode);
				//
				// String strFolder = file.getFOLDER();
				// String strLocalPath = file.getLOCALPATH();
				// if(!StringHelper.IsNullOrEmpty(strLocalPath))
				// {
				// if(!StringHelper.IsNullOrEmpty(strFolder))
				// {
				// strLocalPath = strFolder + java.io.File.separator+strLocalPath;
				// }
				//
				// if(!StringHelper.IsNullOrEmpty(strFilePaths))
				// strFilePaths+="|";
				// strFilePaths+=strLocalPath;
				// }
				// }
				//
				// dataSyncOut.setDATA(XMLNode.Export(dataNode));
				// dataSyncOut.setFILELIST(strFilePaths);
				// }
				// }
			}

			this.dataSyncOutService.create(dataSyncOut, false);
		}
	}

	/**
	 * 测试是否派发数据
	 * 
	 * @param iDEDataChangeDispatchParam
	 * @param iDEDataSyncOut
	 * @return
	 * @throws Exception
	 */
	protected boolean onTestDispatch(IDEDataChangeDispatchParam iDEDataChangeDispatchParam, IDEDataSyncOut iDEDataSyncOut) throws Exception {
		if ((iDEDataChangeDispatchParam.getDEDataChg().getEventType() & iDEDataSyncOut.getEventType()) == 0) return false;

		// 判断有无逻辑
		if (StringHelper.isNullOrEmpty(iDEDataSyncOut.getTestDEActionName())) {
			return true;
		}

		IDataEntityModel iDataEntityModel = (IDataEntityModel) iDEDataSyncOut.getDataEntity();

		iDEDataChangeDispatchParam.getEntity().remove(ServiceBase.RET);

		iDataEntityModel.getService().executeAction(iDEDataSyncOut.getTestDEActionName(), iDEDataChangeDispatchParam.getEntity());
		boolean bRet = DataObject.getBoolValue(iDEDataChangeDispatchParam.getEntity(), ServiceBase.RET, false);
		iDEDataChangeDispatchParam.getEntity().remove(ServiceBase.RET);
		return bRet;
	}

}
