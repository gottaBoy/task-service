package net.ibizsys.ssdyna.demodel;

import net.ibizsys.model.dataentity.ds.IPSDEDataQuery;
import net.ibizsys.model.dataentity.ds.IPSDEDataSet;
import net.ibizsys.paas.demodel.DEDataSetModelBase;

/**
 * 动态实体数据结合对象模型
 * @author Administrator
 *
 */
public class DynaDEDataSetModel extends DEDataSetModelBase {
	private IDynaDEModel iDynaDEModel = null;
	private IPSDEDataSet iPSDEDataSet = null;

	public void init(IDynaDEModel iDynaDEModel, IPSDEDataSet iPSDEDataSet) throws Exception {
		this.iDynaDEModel = iDynaDEModel;
		this.iPSDEDataSet = iPSDEDataSet;

		if (iPSDEDataSet.isEnableGroup()) {
			// 设置启用数据集合分组功能
			this.setEnableGroup(true);
			if (iPSDEDataSet.getGroupTopCount() > 0) {
				this.setGroupTopCount(iPSDEDataSet.getGroupTopCount());
			}
		}

		if (iPSDEDataSet.isEnableOrgDR()) {
			this.setEnableOrgDR(true);
			this.setOrgDR(iPSDEDataSet.getOrgDR());
		}
		if (iPSDEDataSet.isEnableSecDR()) {
			this.setEnableSecDR(true);
			this.setSecDR(iPSDEDataSet.getSecDR());
		}
		if (iPSDEDataSet.isEnableSecBC()) {
			this.setEnableSecBC(true);
			this.setSecBC(iPSDEDataSet.getSecBC());
		}
		if (iPSDEDataSet.isEnableUserDR()) {
			this.setEnableUserDR(true);
		}
		this.init(iDynaDEModel);

	}

	@Override
	public String getId() {
		return iPSDEDataSet.getId();
	}

	@Override
	public String getName() {
		return iPSDEDataSet.getName();
	}
	
	@Override
	protected void onInit() throws Exception {
		
		java.util.Iterator<IPSDEDataQuery> psDEDataQueries  = this.iPSDEDataSet.getPSDEDataQueries();
		if(psDEDataQueries!=null){
			while(psDEDataQueries.hasNext()){
				DynaDEDataSetQueryModel psJITDEDataSetQueryModel = new DynaDEDataSetQueryModel();
				psJITDEDataSetQueryModel.init(this, psDEDataQueries.next());
				this.deDataSetQueryList.add(psJITDEDataSetQueryModel);
			}
		}
		
		super.onInit();
	}

	

//<#if item.isEnableGroup()>
//	/* (non-Javadoc)
//	 * @see net.ibizsys.paas.demodel.DEDataSetModelBase#prepareDEDataSetGroupParams()
//	 */
//	@Override
//	protected void prepareDEDataSetGroupParams() throws Exception
//	{
//            
//<#list item.getPSDEDataSetGroupParams() as groupparam>
//            //注册 ${groupparam.name}
//            DEDataSetGroupParamModel paramModel${groupparam_index?c} = new DEDataSetGroupParamModel();
//            paramModel${groupparam_index?c}.setName("${groupparam.name}");
//<#if groupparam.getGroupCode()??>
//            paramModel${groupparam_index?c}.setGroupCode("${groupparam.getGroupCode()}");
//</#if>
//<#if groupparam.getSortDir()??>
//            paramModel${groupparam_index?c}.setSortDir("${groupparam.getSortDir()}");
//</#if>
//<#if groupparam.isEnableGroup()>
//            paramModel${groupparam_index?c}.setEnableGroup(true);
//</#if>
//<#if groupparam.isReCalc()>
//            paramModel${groupparam_index?c}.setReCalc(true);
//</#if>
//<#if groupparam.getGroupFields()??>                                                                                                                        
//           paramModel${groupparam_index?c}.setGroupFields(new String[]{ <#list groupparam.getGroupFields() as field><#if (field_index>0)>,</#if>"${field}"</#list> });
//</#if>
//            paramModel${groupparam_index?c}.init(this);
//            this.registerDEDataSetGroupParam(paramModel${groupparam_index?c});
//</#list>          
//	    super.prepareDEDataSetGroupParams();
//	}
//</#if>
}
