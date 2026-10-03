package net.ibizsys.ssdyna.demodel;

import net.ibizsys.model.dataentity.ds.IPSDEDataSet;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.demodel.CodeListDEDataSetModelBase;

public class DynaCodeListDEDataSetModel extends CodeListDEDataSetModelBase {
	private IDynaDEModel iDynaDEModel = null;
	private IPSDEDataSet iPSDEDataSet = null;

	public void init(IDynaDEModel iDynaDEModel, IPSDEDataSet iPSDEDataSet) throws Exception {
		this.iDynaDEModel = iDynaDEModel;
		this.iPSDEDataSet = iPSDEDataSet;
		this.strId = this.iPSDEDataSet.getId();
		this.strName = this.iPSDEDataSet.getName();
		
//		if (iPSDEDataSet.isEnableGroup()) {
//			// 设置启用数据集合分组功能
//			this.setEnableGroup(true);
//			if (iPSDEDataSet.getGroupTopCount() > 0) {
//				this.setGroupTopCount(iPSDEDataSet.getGroupTopCount());
//			}
//		}
//
//		if (iPSDEDataSet.isEnableOrgDR()) {
//			this.setEnableOrgDR(true);
//			this.setOrgDR(iPSDEDataSet.getOrgDR());
//		}
//		if (iPSDEDataSet.isEnableSecDR()) {
//			this.setEnableSecDR(true);
//			this.setSecDR(iPSDEDataSet.getSecDR());
//		}
//		if (iPSDEDataSet.isEnableSecBC()) {
//			this.setEnableSecBC(true);
//			this.setSecBC(iPSDEDataSet.getSecBC());
//		}
//		if (iPSDEDataSet.isEnableUserDR()) {
//			this.setEnableUserDR(true);
//		}
		this.init(iDynaDEModel);

	}

	@Override
	public String getId() {
		return this.strId;
	}

	@Override
	public String getName() {
		return this.strName;
	}

	@Override
	protected ICodeList getCodeList() throws Exception {
		
//		IPSDataEntity ipsDataEntity = this.iDynaDEModel.getPSDataEntity();
//		if(StringHelper.compare(this.iPSDEDataSet.getPredefinedType(),"INDEXDE",true) == 0){
//			if(ipsDataEntity.getIndexTypePSDEField()!=null && ipsDataEntity.getIndexTypePSDEField().getPSCodeList()!=null){
//				return (ICodeList)CodeListGlobal.getCodeList(ipsDataEntity.getIndexTypePSDEField().getPSCodeList().getId());
//			}
//		}
//		if(StringHelper.compare(this.iPSDEDataSet.getPredefinedType(),"MULTIFORM",true) == 0){
//			if(ipsDataEntity.getFormTypePSDEField()!=null && ipsDataEntity.getFormTypePSDEField().getPSCodeList()!=null){
//				return (ICodeList)CodeListGlobal.getCodeList(ipsDataEntity.getFormTypePSDEField().getPSCodeList().getId());
//			}
//		}	
//		if(StringHelper.compare(this.iPSDEDataSet.getPredefinedType(),"CODELIST",true) == 0 ){
//			if( this.iPSDEDataSet.getPSCodeList()!=null){
//				return (ICodeList)CodeListGlobal.getCodeList(iPSDEDataSet.getPSCodeList().getId());
//			}
//		}	
		return null;
	}

	
	
}
