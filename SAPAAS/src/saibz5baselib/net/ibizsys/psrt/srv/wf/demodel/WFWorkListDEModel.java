/**
 *  iBizSys 5.0 用户自定义代码
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.wf.demodel;

import net.ibizsys.paas.control.form.IFormItem;
import net.ibizsys.paas.controller.IRedirectViewController;
import net.ibizsys.paas.controller.ViewController;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDEWFModel;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.web.WebContext;
import net.ibizsys.psrt.srv.wf.entity.WFWorkList;


/**
 * 实体[WFWORKLIST]模型对象
 */
public class WFWorkListDEModel extends WFWorkListDEModelBase {

    private static final long serialVersionUID = -1L;

    public WFWorkListDEModel() throws Exception {
        super();
    }

	@Override
	public String getSDDEViewPDTParam(WFWorkList et, boolean bEnableWF, boolean bWFWorkMode,int nAppType) throws Exception {

		boolean bEnableWorkflow = true;
		if(ViewController.getCurrent()!=null && (ViewController.getCurrent() instanceof IRedirectViewController)){
			bEnableWorkflow = ((IRedirectViewController)ViewController.getCurrent()).isEnableWorkflow();
		}
		
		String strDEId = et.getUserData4();
		IDataEntityModel iRealDEModel = DEModelGlobal.getDEModel(strDEId);
		// 进行数据查询
		IEntity iEntity = iRealDEModel.createEntity();
		iEntity.set(iRealDEModel.getKeyDEField().getName(), et.getUserData());
		iRealDEModel.getService(et.getSessionFactory()).get(iEntity);
		
//		
//		getActiveEntity(strKeyValue);
//		// 判断当前数据模式
//		IDataEntityModel iRealDEModel = this.getRealDEModel(iEntity);
//		if (iRealDEModel != this.getDEModel()) {
//			// 实体不一致
//			iEntity = getActiveEntity(iRealDEModel, strKeyValue);
//		}
		boolean bDataInWF = false;
		boolean bWFMode = false;
		// 计算数据模式
	//	if (bEnableWF) {
		if(bEnableWorkflow){
			IDEWFModel iDEWF = iRealDEModel.testDataInWF(iEntity);
			if (iDEWF != null) {
				bDataInWF = true;
				//bWFMode = iDEWF.testUserWFSubmit(iEntity, this.getWebContext().getCurUserId(), this.getSessionFactory());
				bWFMode = iDEWF.testUserWFSubmit(iEntity, WebContext.getCurrent().getCurUserId(),null);
			}
		}

		String strPDTViewParam =  iRealDEModel.getSDDEViewPDTParam(iEntity, bDataInWF, bWFMode,nAppType);
		String strRDMode =  "WLRD:"+iRealDEModel.getName() + ":" + strPDTViewParam;
		et.set(IFormItem.KEY, et.getUserData());
		return strRDMode;
		
		//return super.getSDDEViewPDTParam(et, bEnableWF, bWFWorkMode);
	}
	
	
	@Override
	public String getDEViewIdByPDT(String strPreDefinedType, boolean bTryMode) throws Exception {
		if(strPreDefinedType.indexOf("WLRD:")==0){
			strPreDefinedType = strPreDefinedType.substring(5);
			int nPos = strPreDefinedType.indexOf(":");
			if(nPos == -1)
				return null;
			
			String strDEId = strPreDefinedType.substring(0,nPos);
			strPreDefinedType = 	strPreDefinedType.substring(nPos+1);
			IDataEntityModel iRealDEModel = DEModelGlobal.getDEModel(strDEId);
			return iRealDEModel.getDEViewIdByPDT(strPreDefinedType,bTryMode);
		}
		return super.getDEViewIdByPDT(strPreDefinedType, bTryMode);
	}
    
}