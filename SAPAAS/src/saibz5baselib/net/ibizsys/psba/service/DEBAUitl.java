/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psba.service;

import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.paas.core.IDEBATable;
import net.ibizsys.paas.core.IDEField;
import net.ibizsys.paas.data.ISimpleDataObject;
import net.ibizsys.paas.demodel.IDEBATableModel;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.psba.core.IBASchemeModel;
import net.ibizsys.psba.core.IBATableModel;
import net.ibizsys.psba.dao.IBADAO;
import net.ibizsys.psba.entity.IBAEntity;

public class DEBAUitl {
    public static int syncData(IDataEntityModel iDataEntityModel, ISimpleDataObject iSimpleDataObject) throws Exception {
        Iterator<IDEBATable> deBATables = iDataEntityModel.getDEBATables();
        if (deBATables == null) {
            return -1;
        }
        int nCount = 0;
        while (deBATables.hasNext()) {
            IDEBATableModel iDEBATable = (IDEBATableModel)deBATables.next();
            switch (iDEBATable.getBATableDEType()) {
                case 0: 
                case 1: {
                    IBASchemeModel iBASchemeModel = iDataEntityModel.getSystemModel().getBASchemeModel(iDEBATable.getBAThemeId());
                    IBATableModel iBATableModel = (IBATableModel)iBASchemeModel.getBATable(iDEBATable.getBATableName(), false);
                    IBAEntity iBAEntity = iBATableModel.createBAEntity();
                    String strRowKey = iDEBATable.getRowKey(iSimpleDataObject);
                    if (StringHelper.isNullOrEmpty(strRowKey)) {
                        throw new Exception("\u6ca1\u6709\u6307\u5b9a\u6570\u636e\u952e\u503c");
                    }
                    iBAEntity.setRowKey(strRowKey);
                    if (iDEBATable.getBATableDEType() == 1) {
                        Object objValue;
                        IDEField createDateField = iDataEntityModel.getDEFieldByPDT("CREATEDATE", true);
                        IDEField updateDateField = iDataEntityModel.getDEFieldByPDT("UPDATEDATE", true);
                        if (createDateField != null && (objValue = iSimpleDataObject.get(createDateField.getName())) != null) {
                            iBAEntity.setCreateDate(DataTypeHelper.getTimestampValue(objValue));
                        }
                        if (updateDateField != null && (objValue = iSimpleDataObject.get(updateDateField.getName())) != null) {
                            iBAEntity.setUpdateDate(DataTypeHelper.getTimestampValue(objValue));
                        }
                    }
                    iBAEntity.setFamily(iDEBATable.getBAColSetName(), iSimpleDataObject);
                    IBADAO iBADAO = iBASchemeModel.getBADAO(iBATableModel);
                    iBADAO.executeCreateCmd(iBAEntity, new String[]{iDEBATable.getBAColSetName()});
                    ++nCount;
                    break;
                }
            }
        }
        return nCount;
    }

    public static int syncDatas(IDataEntityModel iDataEntityModel, ISimpleDataObject[] iSimpleDataObjects) throws Exception {
        Iterator<IDEBATable> deBATables = iDataEntityModel.getDEBATables();
        if (deBATables == null) {
            return -1;
        }
        int nCount = 0;
        while (deBATables.hasNext()) {
            IDEBATableModel iDEBATable = (IDEBATableModel)deBATables.next();
            switch (iDEBATable.getBATableDEType()) {
                case 0: 
                case 1: {
                    IBASchemeModel iBASchemeModel = iDataEntityModel.getSystemModel().getBASchemeModel(iDEBATable.getBAThemeId());
                    IBATableModel iBATableModel = (IBATableModel)iBASchemeModel.getBATable(iDEBATable.getBATableName(), false);
                    ArrayList<IBAEntity> baEntityList = new ArrayList<IBAEntity>();
                    int i = 0;
                    while (i < iSimpleDataObjects.length) {
                        ISimpleDataObject iSimpleDataObject = iSimpleDataObjects[i];
                        IBAEntity iBAEntity = iBATableModel.createBAEntity();
                        String strRowKey = iDEBATable.getRowKey(iSimpleDataObject);
                        if (StringHelper.isNullOrEmpty(strRowKey)) {
                            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u6570\u636e\u952e\u503c");
                        }
                        iBAEntity.setRowKey(strRowKey);
                        if (iDEBATable.getBATableDEType() == 1) {
                            Object objValue;
                            IDEField createDateField = iDataEntityModel.getDEFieldByPDT("CREATEDATE", true);
                            IDEField updateDateField = iDataEntityModel.getDEFieldByPDT("UPDATEDATE", true);
                            if (createDateField != null && (objValue = iSimpleDataObject.get(createDateField.getName())) != null) {
                                iBAEntity.setCreateDate(DataTypeHelper.getTimestampValue(objValue));
                            }
                            if (updateDateField != null && (objValue = iSimpleDataObject.get(updateDateField.getName())) != null) {
                                iBAEntity.setUpdateDate(DataTypeHelper.getTimestampValue(objValue));
                            }
                        }
                        iBAEntity.setFamily(iDEBATable.getBAColSetName(), iSimpleDataObject);
                        baEntityList.add(iBAEntity);
                        ++i;
                    }
                    nCount += iSimpleDataObjects.length;
                    IBADAO iBADAO = iBASchemeModel.getBADAO(iBATableModel);
                    iBADAO.executeBatchCreateCmd(baEntityList.toArray(new IBAEntity[baEntityList.size()]), new String[]{iDEBATable.getBAColSetName()});
                    break;
                }
            }
        }
        return nCount;
    }

    public static int getData(IDataEntityModel iDataEntityModel, ISimpleDataObject iSimpleDataObject) throws Exception {
        Iterator<IDEBATable> deBATables = iDataEntityModel.getDEBATables();
        if (deBATables == null) {
            return -1;
        }
        int nCount = 0;
        while (deBATables.hasNext()) {
            IDEBATableModel iDEBATable = (IDEBATableModel)deBATables.next();
            switch (iDEBATable.getBATableDEType()) {
                case 1: {
                    IBASchemeModel iBASchemeModel = iDataEntityModel.getSystemModel().getBASchemeModel(iDEBATable.getBAThemeId());
                    IBATableModel iBATableModel = (IBATableModel)iBASchemeModel.getBATable(iDEBATable.getBATableName(), false);
                    IBAEntity iBAEntity = iBATableModel.createBAEntity();
                    String strRowKey = iDEBATable.getRowKey(iSimpleDataObject);
                    if (StringHelper.isNullOrEmpty(strRowKey)) {
                        throw new Exception("\u6ca1\u6709\u6307\u5b9a\u6570\u636e\u952e\u503c");
                    }
                    iBAEntity.setRowKey(strRowKey);
                    iBAEntity.setFamily(iDEBATable.getBAColSetName(), iSimpleDataObject);
                    IBADAO iBADAO = iBASchemeModel.getBADAO(iBATableModel);
                    iBADAO.executeGetCmd(iBAEntity, new String[]{iDEBATable.getBAColSetName()});
                    return 1;
                }
            }
        }
        return nCount;
    }

    public static int removeData(IDataEntityModel iDataEntityModel, ISimpleDataObject iSimpleDataObject) throws Exception {
        Iterator<IDEBATable> deBATables = iDataEntityModel.getDEBATables();
        if (deBATables == null) {
            return -1;
        }
        int nCount = 0;
        if (deBATables.hasNext()) {
            IDEBATableModel iDEBATable = (IDEBATableModel)deBATables.next();
            switch (iDEBATable.getBATableDEType()) {
                case 0: 
                case 1: {
                    IBASchemeModel iBASchemeModel = iDataEntityModel.getSystemModel().getBASchemeModel(iDEBATable.getBAThemeId());
                    IBATableModel iBATableModel = (IBATableModel)iBASchemeModel.getBATable(iDEBATable.getBATableName(), false);
                    IBAEntity iBAEntity = iBATableModel.createBAEntity();
                    String strRowKey = iDEBATable.getRowKey(iSimpleDataObject);
                    if (StringHelper.isNullOrEmpty(strRowKey)) {
                        throw new Exception("\u6ca1\u6709\u6307\u5b9a\u6570\u636e\u952e\u503c");
                    }
                    iBAEntity.setRowKey(strRowKey);
                    IBADAO iBADAO = iBASchemeModel.getBADAO(iBATableModel);
                    if (iDEBATable.getBATableDEType() == 1) {
                        iBADAO.executeRemoveCmd(iBAEntity);
                    } else {
                        iBAEntity.setFamily(iDEBATable.getBAColSetName(), null);
                        iBADAO.executeUpdateCmd(iBAEntity, new String[]{iDEBATable.getBAColSetName()});
                    }
                    return 1;
                }
            }
            return -1;
        }
        return nCount;
    }
}

