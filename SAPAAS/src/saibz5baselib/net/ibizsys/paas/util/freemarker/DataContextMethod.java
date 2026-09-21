/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  freemarker.template.TemplateMethodModel
 *  freemarker.template.TemplateModelException
 *  net.sf.json.JSONObject
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.paas.util.freemarker;

import freemarker.template.TemplateMethodModel;
import freemarker.template.TemplateModelException;
import java.util.List;
import net.ibizsys.paas.core.DEDataSetFetchContext;
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
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.util.freemarker.SqlCodeHelper;
import net.ibizsys.paas.web.WebContext;
import net.sf.json.JSONObject;
import org.hibernate.SessionFactory;

public class DataContextMethod
implements TemplateMethodModel {
    public Object exec(List arg0) throws TemplateModelException {
        Object objValue;
        String strKey;
        SqlParamList sqlParamList;
        block38: {
            Object objDEId;
            JSONObject appDataJo;
            JSONObject jo;
            boolean bReferData;
            boolean bParentData;
            boolean bIgnoreEmpty;
            DataContextParam iDataContextParam;
            SessionFactory sessionFactory;
            block36: {
                block37: {
                    block33: {
                        Object objValue2;
                        block35: {
                            ISimpleDataObject iSimpleDataObject;
                            block34: {
                                try {
                                    IEntity iEntity;
                                    IDEDataSetFetchContext iDEDataSetFetchContext;
                                    String strReferItem;
                                    sqlParamList = SqlCodeHelper.getCurrentSqlParamList();
                                    sessionFactory = SqlCodeHelper.getCurrentSessionFactory();
                                    if (arg0.size() == 0) {
                                        throw new Exception(StringHelper.format("\u6ca1\u6709\u6307\u5b9a\u5f53\u524d\u6570\u636e\u53c2\u6570"));
                                    }
                                    strKey = arg0.get(0).toString().toLowerCase();
                                    String strParam = "";
                                    iDataContextParam = null;
                                    bIgnoreEmpty = false;
                                    if (arg0.size() > 1 && !StringHelper.isNullOrEmpty(strParam = arg0.get(1).toString())) {
                                        iDataContextParam = new DataContextParam(strParam);
                                        bIgnoreEmpty = iDataContextParam.isIgnoreEmpty();
                                    }
                                    if (!StringHelper.isNullOrEmpty(strReferItem = WebContext.getReferItem())) {
                                        if (iDataContextParam == null) {
                                            iDataContextParam = new DataContextParam(null);
                                        }
                                        iDataContextParam.setReferItem(strReferItem);
                                    }
                                    if ((iDEDataSetFetchContext = DEDataSetFetchContext.getCurrent()) == null || iDEDataSetFetchContext.getActiveDataObject() == null) break block33;
                                    String strDEId = null;
                                    iSimpleDataObject = iDEDataSetFetchContext.getActiveDataObject();
                                    if (iSimpleDataObject instanceof IEntity && !StringHelper.isNullOrEmpty(strDEId = DataObject.getStringValue((iEntity = (IEntity)iSimpleDataObject).getEntityProperty("srfdeid"), "")) && !StringHelper.isNullOrEmpty(strReferItem = DataObject.getStringValue(iEntity.getEntityProperty("srfreferitem"), ""))) {
                                        if (iDataContextParam == null) {
                                            iDataContextParam = new DataContextParam(null);
                                        }
                                        iDataContextParam.setReferItem(strReferItem);
                                    }
                                    if (StringHelper.isNullOrEmpty(strDEId)) break block34;
                                    IDataEntityModel iDataEntityModel = DEModelGlobal.getDEModel(strDEId);
                                    Object objValue3 = iDataEntityModel.getService(sessionFactory).getDataContextValue((IEntity)iDEDataSetFetchContext.getActiveDataObject(), strKey, iDataContextParam);
                                    if (objValue3 != null) {
                                        SqlParam sqlParam = new SqlParam(objValue3);
                                        sqlParam.setParamName(strKey);
                                        if (objValue3 == null) {
                                            sqlParam.setDataType(25);
                                        }
                                        sqlParamList.add(sqlParam);
                                        return "?";
                                    }
                                    break block33;
                                }
                                catch (Exception ex) {
                                    throw new TemplateModelException(ex);
                                }
                            }
                            if (!iSimpleDataObject.contains(strKey)) break block33;
                            objValue2 = iSimpleDataObject.get(strKey);
                            if (objValue2 != null || !bIgnoreEmpty) break block35;
                            return "";
                        }
                        SqlParam sqlParam = new SqlParam(objValue2);
                        sqlParam.setParamName(strKey);
                        if (objValue2 == null) {
                            sqlParam.setDataType(25);
                        }
                        sqlParamList.add(sqlParam);
                        return "?";
                    }
                    bParentData = false;
                    bReferData = false;
                    jo = WebContext.getActiveData();
                    if (jo == null && (jo = WebContext.getReferData()) != null) {
                        bReferData = true;
                    }
                    if (jo == null && (jo = WebContext.getParentData()) != null) {
                        bParentData = true;
                    }
                    appDataJo = WebContext.getAppData();
                    objValue = null;
                    if (jo != null) break block36;
                    if (appDataJo != null) {
                        objValue = appDataJo.opt(strKey);
                    }
                    if (objValue == null && arg0.size() >= 3) {
                        objValue = arg0.get(2);
                    }
                    if (objValue != null || !bIgnoreEmpty) break block37;
                    return "";
                }
                SqlParam sqlParam = new SqlParam(objValue);
                sqlParam.setParamName(strKey);
                if (objValue == null) {
                    sqlParam.setDataType(25);
                }
                sqlParamList.add(sqlParam);
                return "?";
            }
            objValue = jo.opt(strKey);
            if (bReferData) {
                objDEId = jo.opt("srfdeid");
                if (!StringHelper.isNullOrEmpty(objDEId)) {
                    IDataEntityModel iDataEntityModel = DEModelGlobal.getDEModel((String)objDEId);
                    Object iEntity = iDataEntityModel.createEntity();
                    iEntity.setSessionFactory(sessionFactory);
                    DataObject.fromJSONObject(iEntity, jo, true);
                    objValue = iDataEntityModel.getService(sessionFactory).getDataContextValue(iEntity, strKey, iDataContextParam);
                }
            } else if (bParentData) {
                objDEId = jo.opt("srfparentdeid");
                Object objParentKey = jo.opt("srfparentkey");
                if (!StringHelper.isNullOrEmpty(objDEId) && objParentKey != null) {
                    IDataEntityModel refDEModel;
                    IDEFieldModel refDEFieldModel;
                    IDataEntityModel iDataEntityModel = DEModelGlobal.getDEModel((String)objDEId);
                    if (iDataContextParam != null && !StringHelper.isNullOrEmpty(iDataContextParam.getDEName()) && !StringHelper.isNullOrEmpty(iDataContextParam.getDEFName()) && (refDEFieldModel = (IDEFieldModel)(refDEModel = DEModelGlobal.getDEModel(iDataContextParam.getDEName())).getDEField(iDataContextParam.getDEFName(), true)) != null && iDataEntityModel.getKeyDEField() == refDEFieldModel.getRealDEField()) {
                        objValue = DataTypeHelper.parse(iDataEntityModel.getKeyDEField().getStdDataType(), objParentKey.toString());
                    }
                    if (objValue == null) {
                        Object iEntity = iDataEntityModel.createEntity();
                        iEntity.setSessionFactory(sessionFactory);
                        iEntity.set(iDataEntityModel.getKeyDEField().getName(), objParentKey);
                        String strKeyValue = objParentKey.toString();
                        if (strKeyValue.indexOf("SRFTEMPKEY:") == 0) {
                            iDataEntityModel.getService(sessionFactory).getTemp(iEntity);
                        } else {
                            iDataEntityModel.getService(sessionFactory).get(iEntity);
                        }
                        objValue = iDataEntityModel.getService(sessionFactory).getDataContextValue(iEntity, strKey, iDataContextParam);
                    }
                }
            }
            if (objValue == null && appDataJo != null) {
                objValue = appDataJo.opt(strKey);
            }
            if (objValue != null || !bIgnoreEmpty) break block38;
            return "";
        }
        SqlParam sqlParam = new SqlParam(objValue);
        sqlParam.setParamName(strKey);
        if (objValue == null) {
            sqlParam.setDataType(25);
        }
        sqlParamList.add(sqlParam);
        return "?";
    }

    public static Object getValue(String strKey) throws Exception {
        return DataContextMethod.getValue(strKey, null);
    }

    public static Object getValue(String strKey, SessionFactory sessionFactory) throws Exception {
        boolean bParentData = false;
        boolean bReferData = false;
        JSONObject jo = WebContext.getActiveData();
        if (jo == null && (jo = WebContext.getReferData()) != null) {
            bReferData = true;
        }
        if (jo == null && (jo = WebContext.getParentData()) != null) {
            bParentData = true;
        }
        JSONObject appDataJo = WebContext.getAppData();
        Object objValue = null;
        if (jo == null) {
            if (appDataJo != null) {
                objValue = appDataJo.opt(strKey);
            }
            return objValue;
        }
        objValue = jo.opt(strKey);
        if (bReferData) {
            Object objDEId = jo.opt("srfdeid");
            if (!StringHelper.isNullOrEmpty(objDEId)) {
                IDataEntityModel iDataEntityModel = DEModelGlobal.getDEModel((String)objDEId);
                Object iEntity = iDataEntityModel.createEntity();
                iEntity.setSessionFactory(sessionFactory);
                DataObject.fromJSONObject(iEntity, jo, true);
                objValue = iDataEntityModel.getService(sessionFactory).getDataContextValue(iEntity, strKey, null);
            }
        } else if (bParentData) {
            Object objDEId = jo.opt("srfparentdeid");
            Object objParentKey = jo.opt("srfparentkey");
            if (!StringHelper.isNullOrEmpty(objDEId) && objParentKey != null) {
                IDataEntityModel iDataEntityModel = DEModelGlobal.getDEModel((String)objDEId);
                Object iEntity = iDataEntityModel.createEntity();
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

