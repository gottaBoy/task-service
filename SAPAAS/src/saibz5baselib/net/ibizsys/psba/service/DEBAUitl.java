package net.ibizsys.psba.service;

import java.util.ArrayList;
import java.util.List;

import net.ibizsys.paas.core.IDEBATable;
import net.ibizsys.paas.core.IDEField;
import net.ibizsys.paas.data.ISimpleDataObject;
import net.ibizsys.paas.demodel.IDEBATableModel;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.psba.core.IBASchemeModel;
import net.ibizsys.psba.core.IBATableDE;
import net.ibizsys.psba.core.IBATableModel;
import net.ibizsys.psba.dao.IBADAO;
import net.ibizsys.psba.entity.IBAEntity;


/**
 * 大数据表通用服务对象
 * 
 * @author Administrator
 *
 */
public class DEBAUitl {

	/**
	 * 同步实体数据
	 * @param iDataEntityModel
	 * @param iSimpleDataObject
	 * @return
	 * @throws Exception
	 */
	public static int syncData(IDataEntityModel iDataEntityModel,ISimpleDataObject iSimpleDataObject)throws Exception{
		
		java.util.Iterator<IDEBATable> deBATables = iDataEntityModel.getDEBATables();
		if(deBATables == null)
			return -1;
		
		int nCount = 0;
		while(deBATables.hasNext()){
			IDEBATableModel iDEBATable = (IDEBATableModel) deBATables.next();
			switch(iDEBATable.getBATableDEType()){
			case IBATableDE.BATABLEDETYPE_DEFAULT :
			case IBATableDE.BATABLEDETYPE_RELATED:
				//建立相应的数据
				IBASchemeModel iBASchemeModel= iDataEntityModel.getSystemModel().getBASchemeModel(iDEBATable.getBAThemeId());
				IBATableModel 	iBATableModel = (IBATableModel)	iBASchemeModel.getBATable(iDEBATable.getBATableName(), false);
				IBAEntity iBAEntity = iBATableModel.createBAEntity();
				String strRowKey = iDEBATable.getRowKey(iSimpleDataObject);
				if(StringHelper.isNullOrEmpty(strRowKey)){
					throw new Exception("没有指定数据键值");
				}
				iBAEntity.setRowKey(strRowKey);
				if(iDEBATable.getBATableDEType()==IBATableDE.BATABLEDETYPE_DEFAULT){
					//放入2个时间
					IDEField createDateField= 	iDataEntityModel.getDEFieldByPDT(IDEField.PREDEFINEDTYPE_CREATEDATE, true);
					IDEField updateDateField= 	iDataEntityModel.getDEFieldByPDT(IDEField.PREDEFINEDTYPE_UPDATEDATE, true);
					if(createDateField!=null){
						Object objValue = iSimpleDataObject.get(createDateField.getName());
						if(objValue!=null){
							iBAEntity.setCreateDate(DataTypeHelper.getTimestampValue(objValue));
						}
					}
					if(updateDateField!=null){
						Object objValue = iSimpleDataObject.get(updateDateField.getName());
						if(objValue!=null){
							iBAEntity.setUpdateDate(DataTypeHelper.getTimestampValue(objValue));
						}
					}
				}
				
				iBAEntity.setFamily(iDEBATable.getBAColSetName(), iSimpleDataObject);
				IBADAO iBADAO = iBASchemeModel.getBADAO(iBATableModel);
				iBADAO.executeCreateCmd(iBAEntity, new String[]{iDEBATable.getBAColSetName()});
				nCount ++;
				break;
			default:
				break;

			}
		}
		
		return nCount;
	}
	
	
	/**
	 * 批同步实体数据
	 * @param iDataEntityModel
	 * @param iSimpleDataObjects
	 * @return
	 * @throws Exception
	 */
	public static int syncDatas(IDataEntityModel iDataEntityModel,ISimpleDataObject[] iSimpleDataObjects)throws Exception{
		
		java.util.Iterator<IDEBATable> deBATables = iDataEntityModel.getDEBATables();
		if(deBATables == null)
			return -1;
		
		int nCount = 0;
		while(deBATables.hasNext()){
			IDEBATableModel iDEBATable = (IDEBATableModel) deBATables.next();
			switch(iDEBATable.getBATableDEType()){
			case IBATableDE.BATABLEDETYPE_DEFAULT :
			case IBATableDE.BATABLEDETYPE_RELATED:
				//建立相应的数据
				IBASchemeModel iBASchemeModel= iDataEntityModel.getSystemModel().getBASchemeModel(iDEBATable.getBAThemeId());
				IBATableModel 	iBATableModel = (IBATableModel)	iBASchemeModel.getBATable(iDEBATable.getBATableName(), false);
				List<IBAEntity> baEntityList = new ArrayList<IBAEntity>();
				for(int i=0;i<iSimpleDataObjects.length;i++){
					ISimpleDataObject iSimpleDataObject = iSimpleDataObjects[i];
					IBAEntity iBAEntity = iBATableModel.createBAEntity();

					String strRowKey = iDEBATable.getRowKey(iSimpleDataObject);
					if(StringHelper.isNullOrEmpty(strRowKey)){
						throw new Exception("没有指定数据键值");
					}
					iBAEntity.setRowKey(strRowKey);
					if(iDEBATable.getBATableDEType()==IBATableDE.BATABLEDETYPE_DEFAULT){
						//放入2个时间
						IDEField createDateField= 	iDataEntityModel.getDEFieldByPDT(IDEField.PREDEFINEDTYPE_CREATEDATE, true);
						IDEField updateDateField= 	iDataEntityModel.getDEFieldByPDT(IDEField.PREDEFINEDTYPE_UPDATEDATE, true);
						if(createDateField!=null){
							Object objValue = iSimpleDataObject.get(createDateField.getName());
							if(objValue!=null){
								iBAEntity.setCreateDate(DataTypeHelper.getTimestampValue(objValue));
							}
						}
						if(updateDateField!=null){
							Object objValue = iSimpleDataObject.get(updateDateField.getName());
							if(objValue!=null){
								iBAEntity.setUpdateDate(DataTypeHelper.getTimestampValue(objValue));
							}
						}
					}
					
					iBAEntity.setFamily(iDEBATable.getBAColSetName(), iSimpleDataObject);
					baEntityList.add(iBAEntity);
				}
				
				
				nCount += iSimpleDataObjects.length;
				IBADAO iBADAO = iBASchemeModel.getBADAO(iBATableModel);
				iBADAO.executeBatchCreateCmd(baEntityList.toArray(new IBAEntity[baEntityList.size()]), new String[]{iDEBATable.getBAColSetName()});
				
				
				break;
			default:
				break;

			}
		}
		
		return nCount;
	}
	
	
	/**
	 * 获取实体数据
	 * @param iDataEntityModel
	 * @param iSimpleDataObject
	 * @return
	 * @throws Exception
	 */
	public static int getData(IDataEntityModel iDataEntityModel,ISimpleDataObject iSimpleDataObject)throws Exception{
		
		java.util.Iterator<IDEBATable> deBATables = iDataEntityModel.getDEBATables();
		if(deBATables == null)
			return -1;
		
		int nCount = 0;
		while(deBATables.hasNext()){
			IDEBATableModel iDEBATable = (IDEBATableModel) deBATables.next();
			switch(iDEBATable.getBATableDEType()){
			case IBATableDE.BATABLEDETYPE_DEFAULT :
				//建立相应的数据
				IBASchemeModel iBASchemeModel= iDataEntityModel.getSystemModel().getBASchemeModel(iDEBATable.getBAThemeId());
				IBATableModel 	iBATableModel = (IBATableModel)	iBASchemeModel.getBATable(iDEBATable.getBATableName(), false);
				IBAEntity iBAEntity = iBATableModel.createBAEntity();
				String strRowKey = iDEBATable.getRowKey(iSimpleDataObject);
				if(StringHelper.isNullOrEmpty(strRowKey)){
					throw new Exception("没有指定数据键值");
				}
				iBAEntity.setRowKey(strRowKey);
				
				iBAEntity.setFamily(iDEBATable.getBAColSetName(), iSimpleDataObject);
				IBADAO iBADAO = iBASchemeModel.getBADAO(iBATableModel);
				iBADAO.executeGetCmd(iBAEntity, new String[]{iDEBATable.getBAColSetName()});
				return 1;
			default:
				break;

			}
		}
		
		return nCount;
	}
	
	/**
	 * 删除实体数据
	 * @param iDataEntityModel
	 * @param iSimpleDataObject
	 * @return
	 * @throws Exception
	 */
	public static int removeData(IDataEntityModel iDataEntityModel,ISimpleDataObject iSimpleDataObject)throws Exception{
		
		java.util.Iterator<IDEBATable> deBATables = iDataEntityModel.getDEBATables();
		if(deBATables == null)
			return -1;
		
		int nCount = 0;
		while(deBATables.hasNext()){
			IDEBATableModel iDEBATable = (IDEBATableModel) deBATables.next();
			switch(iDEBATable.getBATableDEType()){
			case IBATableDE.BATABLEDETYPE_DEFAULT :
			case IBATableDE.BATABLEDETYPE_RELATED:
				//建立相应的数据
				IBASchemeModel iBASchemeModel= iDataEntityModel.getSystemModel().getBASchemeModel(iDEBATable.getBAThemeId());
				IBATableModel 	iBATableModel = (IBATableModel)	iBASchemeModel.getBATable(iDEBATable.getBATableName(), false);
				IBAEntity iBAEntity = iBATableModel.createBAEntity();
				String strRowKey = iDEBATable.getRowKey(iSimpleDataObject);
				if(StringHelper.isNullOrEmpty(strRowKey)){
					throw new Exception("没有指定数据键值");
				}
				iBAEntity.setRowKey(strRowKey);
				IBADAO iBADAO = iBASchemeModel.getBADAO(iBATableModel);
				if(iDEBATable.getBATableDEType()== IBATableDE.BATABLEDETYPE_DEFAULT ){
					iBADAO.executeRemoveCmd(iBAEntity);
				}
				else{
					iBAEntity.setFamily(iDEBATable.getBAColSetName(), null);
					iBADAO.executeUpdateCmd(iBAEntity, new String[]{iDEBATable.getBAColSetName()});
				}
				
				//iBAEntity.children("aaa")
				return 1;
			default:
				return -1;

			}
		}
		
		return nCount;
	}
	
	
}
