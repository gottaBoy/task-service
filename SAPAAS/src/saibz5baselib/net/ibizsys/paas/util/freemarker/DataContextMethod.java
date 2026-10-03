package net.ibizsys.paas.util.freemarker;

import java.util.List;

import org.hibernate.SessionFactory;

import freemarker.template.TemplateMethodModel;
import freemarker.template.TemplateModelException;
import net.ibizsys.paas.core.DEDataSetFetchContext;
import net.ibizsys.paas.core.DataTypes;
import net.ibizsys.paas.core.IDEDataSetFetchContext;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.ISimpleDataObject;
import net.ibizsys.paas.db.SqlParam;
import net.ibizsys.paas.db.SqlParamList;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDEFieldModel;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.DataContextParam;
import net.ibizsys.paas.service.ServiceBase;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.WebContext;
import net.sf.json.JSONObject;

/**
 * 数据上下文值计算方法
 * 
 * @author Administrator
 *
 */
public class DataContextMethod implements TemplateMethodModel {
	public Object exec(List arg0) throws TemplateModelException {
		try {
			SqlParamList sqlParamList = SqlCodeHelper.getCurrentSqlParamList();
			SessionFactory sessionFactory = SqlCodeHelper.getCurrentSessionFactory();
			if (arg0.size() == 0) {
				throw new Exception(StringHelper.format("没有指定当前数据参数"));
			}

			String strKey = arg0.get(0).toString().toLowerCase();
			String strParam = "";
			DataContextParam iDataContextParam = null;
			boolean bIgnoreEmpty = false;
			if (arg0.size() > 1) {
				strParam = arg0.get(1).toString();
				if (!StringHelper.isNullOrEmpty(strParam)) {
					iDataContextParam = new DataContextParam(strParam);
					bIgnoreEmpty = iDataContextParam.isIgnoreEmpty();
				}
			}

			String strReferItem = WebContext.getReferItem();
			if (!StringHelper.isNullOrEmpty(strReferItem)) {
				if (iDataContextParam == null) iDataContextParam = new DataContextParam(null);
				iDataContextParam.setReferItem(strReferItem);
			}

			IDEDataSetFetchContext iDEDataSetFetchContext = DEDataSetFetchContext.getCurrent();
			if (iDEDataSetFetchContext != null && iDEDataSetFetchContext.getActiveDataObject() != null) {
				String strDEId = null;
				ISimpleDataObject iSimpleDataObject = iDEDataSetFetchContext.getActiveDataObject();
				if (iSimpleDataObject instanceof IEntity) {
					IEntity iEntity = (IEntity) iSimpleDataObject;
					strDEId = DataObject.getStringValue(iEntity.getEntityProperty("srfdeid"), "");
					if (!StringHelper.isNullOrEmpty(strDEId)) {
						strReferItem = DataObject.getStringValue(iEntity.getEntityProperty("srfreferitem"), "");
						if (!StringHelper.isNullOrEmpty(strReferItem)) {
							if (iDataContextParam == null) iDataContextParam = new DataContextParam(null);
							iDataContextParam.setReferItem(strReferItem);
						}
					}
				}
				if (!StringHelper.isNullOrEmpty(strDEId)) {
					IDataEntityModel iDataEntityModel = DEModelGlobal.getDEModel(strDEId);
					Object objValue = iDataEntityModel.getService(sessionFactory).getDataContextValue((IEntity) iDEDataSetFetchContext.getActiveDataObject(), strKey, iDataContextParam);
					if (objValue != null) {
						SqlParam sqlParam = new SqlParam(objValue);
						sqlParam.setParamName(strKey);

						if (objValue == null) {
							sqlParam.setDataType(DataTypes.VARCHAR);
						}

						sqlParamList.add(sqlParam);
						return "?";
					}
				} else if (iSimpleDataObject.contains(strKey)) {
					Object objValue = iSimpleDataObject.get(strKey);
					if (objValue == null && bIgnoreEmpty) {
						return "";
					} else {
						SqlParam sqlParam = new SqlParam(objValue);
						sqlParam.setParamName(strKey);

						if (objValue == null) {
							sqlParam.setDataType(DataTypes.VARCHAR);
						}

						sqlParamList.add(sqlParam);
						return "?";
					}

				}
			}

			boolean bParentData = false;
			boolean bReferData = false;
			JSONObject jo = WebContext.getActiveData();
			if (jo == null) {
				jo = WebContext.getReferData();
				if (jo != null) {
					bReferData = true;
				}
			}
			if (jo == null) {
				jo = WebContext.getParentData();
				if (jo != null) {
					bParentData = true;
				}
			}

			JSONObject appDataJo = WebContext.getAppData();
			Object objValue = null;
			if (jo == null) {
				if (appDataJo != null) {
					objValue = appDataJo.opt(strKey);
				}
				// throw new Exception(StringHelper.format("上下文数据无效"));
				if (objValue == null && arg0.size() >= 3) {
					objValue = arg0.get(2);
				}

				if (objValue == null && bIgnoreEmpty) {
					return "";
				} else {
					SqlParam sqlParam = new SqlParam(objValue);
					sqlParam.setParamName(strKey);

					if (objValue == null) {
						sqlParam.setDataType(DataTypes.VARCHAR);
					}

					sqlParamList.add(sqlParam);
					return "?";
				}
			} else {
				// 判断有无实体
				objValue = jo.opt(strKey);
				if (bReferData) {
					Object objDEId = jo.opt("srfdeid");
					if(!StringHelper.isNullOrEmpty(objDEId)){
						IDataEntityModel iDataEntityModel = DEModelGlobal.getDEModel((String) objDEId);
						IEntity iEntity = iDataEntityModel.createEntity();
						iEntity.setSessionFactory(sessionFactory);
						DataObject.fromJSONObject(iEntity, jo,true);
						objValue = iDataEntityModel.getService(sessionFactory).getDataContextValue(iEntity, strKey, iDataContextParam);
					}
				} else if (bParentData) {
					Object objDEId = jo.opt("srfparentdeid");
					Object objParentKey = jo.opt("srfparentkey");
					if (!StringHelper.isNullOrEmpty(objDEId) && objParentKey != null) {
						IDataEntityModel iDataEntityModel = DEModelGlobal.getDEModel((String) objDEId);
						if (iDataContextParam != null) {
							if ((!StringHelper.isNullOrEmpty(iDataContextParam.getDEName())) && (!StringHelper.isNullOrEmpty(iDataContextParam.getDEFName()))) {
								IDataEntityModel refDEModel = DEModelGlobal.getDEModel(iDataContextParam.getDEName());
								IDEFieldModel refDEFieldModel = (IDEFieldModel) refDEModel.getDEField(iDataContextParam.getDEFName(), true);
								if (refDEFieldModel != null) {
									if (iDataEntityModel.getKeyDEField() == refDEFieldModel.getRealDEField()) {
										objValue = DataTypeHelper.parse(iDataEntityModel.getKeyDEField().getStdDataType(), objParentKey.toString());
									}
								}
							}
						}
						if (objValue == null) {
							IEntity iEntity = iDataEntityModel.createEntity();
							iEntity.setSessionFactory(sessionFactory);
							iEntity.set(iDataEntityModel.getKeyDEField().getName(), objParentKey);
							String strKeyValue = objParentKey.toString();
							if (strKeyValue.indexOf(ServiceBase.TEMPKEY) == 0) {
								iDataEntityModel.getService(sessionFactory).getTemp(iEntity);
							} else
								iDataEntityModel.getService(sessionFactory).get(iEntity);
							objValue = iDataEntityModel.getService(sessionFactory).getDataContextValue(iEntity, strKey, iDataContextParam);
						}

					}
				}

				if (objValue == null && appDataJo != null) {
					objValue = appDataJo.opt(strKey);
				}

				if (objValue == null && bIgnoreEmpty) {
					return "";
				} else {
					SqlParam sqlParam = new SqlParam(objValue);
					sqlParam.setParamName(strKey);

					if (objValue == null) {
						sqlParam.setDataType(DataTypes.VARCHAR);
					}

					sqlParamList.add(sqlParam);
					return "?";
				}

			}

		} catch (Exception ex) {
			throw new TemplateModelException(ex);
		}

	}

	/**
	 * 计算上下文数据
	 * 
	 * @param strKey
	 * @return
	 * @throws Exception
	 */
	public static Object getValue(String strKey) throws Exception {
		return getValue(strKey, null);
	}

	/**
	 * 计算上下文数据
	 * 
	 * @param strKey
	 * @param sessionFactory
	 * @return
	 * @throws Exception
	 */
	public static Object getValue(String strKey, SessionFactory sessionFactory) throws Exception {
		boolean bParentData = false;
		boolean bReferData = false;
		JSONObject jo = WebContext.getActiveData();
		if (jo == null) {
			jo = WebContext.getReferData();
			if (jo != null) {
				bReferData = true;
			}
		}
		if (jo == null) {
			jo = WebContext.getParentData();
			if (jo != null) {
				bParentData = true;
			}
		}

		JSONObject appDataJo = WebContext.getAppData();
		Object objValue = null;
		if (jo == null) {
			if (appDataJo != null) {
				objValue = appDataJo.opt(strKey);
			}

			return objValue;
		} else {
			// 判断有无实体
			objValue = jo.opt(strKey);
			if (bReferData) {
				Object objDEId = jo.opt("srfdeid");
				if (!StringHelper.isNullOrEmpty(objDEId)) {
					IDataEntityModel iDataEntityModel = DEModelGlobal.getDEModel((String) objDEId);
					IEntity iEntity = iDataEntityModel.createEntity();
					iEntity.setSessionFactory(sessionFactory);
					DataObject.fromJSONObject(iEntity, jo,true);
					objValue = iDataEntityModel.getService(sessionFactory).getDataContextValue(iEntity, strKey, null);
				}
			} else if (bParentData) {
				Object objDEId = jo.opt("srfparentdeid");
				Object objParentKey = jo.opt("srfparentkey");
				if (!StringHelper.isNullOrEmpty(objDEId) && objParentKey != null) {
					IDataEntityModel iDataEntityModel = DEModelGlobal.getDEModel((String) objDEId);
					IEntity iEntity = iDataEntityModel.createEntity();
					iEntity.setSessionFactory(sessionFactory);
					iEntity.set(iDataEntityModel.getKeyDEField().getName(), objParentKey);
					iDataEntityModel.getService(sessionFactory).get(iEntity);
					objValue = iDataEntityModel.getService(sessionFactory).getDataContextValue(iEntity, strKey, null);
				}
			}

			if (objValue == null && appDataJo != null) {
				objValue = appDataJo.opt(strKey);
			}

			return objValue;
		}
	}
}
