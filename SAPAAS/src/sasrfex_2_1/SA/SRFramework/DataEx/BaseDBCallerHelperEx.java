/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Data.BaseDBCallerHelper
 *  SA.SRFramework.Data.ConnectionContainer
 *  SA.SRFramework.Data.DBCallerConfig
 *  SA.SRFramework.Data.DBProcCaller
 *  SA.SRFramework.Data.DBResult
 *  SA.SRFramework.Data.InsertResult
 *  SA.SRFramework.Data.SASRFDataException
 *  SA.SRFramework.Data.SearchResult
 *  SA.SRFramework.Data.SelectResult
 *  SA.SRFramework.Data.UpdateResult
 */
package SA.SRFramework.DataEx;

import SA.SRFramework.Data.BaseDBCallerHelper;
import SA.SRFramework.Data.ConnectionContainer;
import SA.SRFramework.Data.DBCallerConfig;
import SA.SRFramework.Data.DBProcCaller;
import SA.SRFramework.Data.DBResult;
import SA.SRFramework.Data.InsertResult;
import SA.SRFramework.Data.SASRFDataException;
import SA.SRFramework.Data.SearchResult;
import SA.SRFramework.Data.SelectResult;
import SA.SRFramework.Data.UpdateResult;
import SA.SRFramework.DataEx.IDBDeleteCmdCaller;
import SA.SRFramework.DataEx.IDBInsertCmdCaller;
import SA.SRFramework.DataEx.IDBRawCmdCaller;
import SA.SRFramework.DataEx.IDBSearchCmdCaller;
import SA.SRFramework.DataEx.IDBSelectCmdCaller;
import SA.SRFramework.DataEx.IDBUpdateCmdCaller;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Hashtable;

public class BaseDBCallerHelperEx
extends BaseDBCallerHelper {
    public DBProcCaller InsertCmdCaller() {
        return null;
    }

    public InsertResult InsertCmd(String strConfigID, Hashtable paramList, String strOpPersonId) throws SASRFDataException {
        DBProcCaller insertCmdCall = this.InsertCmdCaller();
        if (insertCmdCall == null) {
            throw new SASRFDataException(2000);
        }
        insertCmdCall.SetContainer((ConnectionContainer)this);
        DBCallerConfig dbCallConfig = this.dbCallConfigMgr.Get(strConfigID);
        if (dbCallConfig == null) {
            throw new SASRFDataException(2001);
        }
        try {
            insertCmdCall.setConfig(dbCallConfig);
            IDBInsertCmdCaller interCall = (IDBInsertCmdCaller)insertCmdCall;
            InsertResult dbResult = interCall.Invoke(paramList, strOpPersonId);
            return dbResult;
        }
        catch (Exception ex) {
            ex.printStackTrace(System.out);
            return null;
        }
    }

    public InsertResult InsertCmd(Connection connection, String strConfigID, Hashtable paramList, String strOpPersonId) throws SASRFDataException {
        DBProcCaller insertCmdCall = this.InsertCmdCaller();
        if (insertCmdCall == null) {
            throw new SASRFDataException(2000);
        }
        insertCmdCall.SetContainer((ConnectionContainer)this);
        DBCallerConfig dbCallConfig = this.dbCallConfigMgr.Get(strConfigID);
        if (dbCallConfig == null) {
            throw new SASRFDataException(2001);
        }
        try {
            insertCmdCall.setConfig(dbCallConfig);
            IDBInsertCmdCaller interCall = (IDBInsertCmdCaller)insertCmdCall;
            InsertResult dbResult = interCall.Invoke(connection, paramList, strOpPersonId);
            return dbResult;
        }
        catch (Exception ex) {
            ex.printStackTrace(System.out);
            return null;
        }
    }

    public DBProcCaller UpdateCmdCaller() {
        return null;
    }

    public UpdateResult UpdateCmd(String strConfigID, Hashtable paramList, String strOpPersonId) throws SASRFDataException {
        DBProcCaller insertCmdCall = this.UpdateCmdCaller();
        if (insertCmdCall == null) {
            throw new SASRFDataException(2000);
        }
        insertCmdCall.SetContainer((ConnectionContainer)this);
        DBCallerConfig dbCallConfig = this.dbCallConfigMgr.Get(strConfigID);
        if (dbCallConfig == null) {
            throw new SASRFDataException(2001);
        }
        try {
            insertCmdCall.setConfig(dbCallConfig);
            IDBUpdateCmdCaller interCall = (IDBUpdateCmdCaller)insertCmdCall;
            UpdateResult dbResult = interCall.Invoke(paramList, strOpPersonId);
            return dbResult;
        }
        catch (Exception ex) {
            ex.printStackTrace(System.out);
            return null;
        }
    }

    public UpdateResult UpdateCmd(Connection connection, String strConfigID, Hashtable paramList, String strOpPersonId) throws SASRFDataException {
        DBProcCaller insertCmdCall = this.UpdateCmdCaller();
        if (insertCmdCall == null) {
            throw new SASRFDataException(2000);
        }
        insertCmdCall.SetContainer((ConnectionContainer)this);
        DBCallerConfig dbCallConfig = this.dbCallConfigMgr.Get(strConfigID);
        if (dbCallConfig == null) {
            throw new SASRFDataException(2001);
        }
        try {
            insertCmdCall.setConfig(dbCallConfig);
            IDBUpdateCmdCaller interCall = (IDBUpdateCmdCaller)insertCmdCall;
            UpdateResult dbResult = interCall.Invoke(connection, paramList, strOpPersonId);
            return dbResult;
        }
        catch (Exception ex) {
            ex.printStackTrace(System.out);
            return null;
        }
    }

    public DBProcCaller SelectCmdCaller() {
        return null;
    }

    public SelectResult SelectCmd(String strConfigID, Hashtable paramList, String strOpPersonId) throws SASRFDataException {
        DBProcCaller insertCmdCall = this.SelectCmdCaller();
        if (insertCmdCall == null) {
            throw new SASRFDataException(2000);
        }
        insertCmdCall.SetContainer((ConnectionContainer)this);
        DBCallerConfig dbCallConfig = this.dbCallConfigMgr.Get(strConfigID);
        if (dbCallConfig == null) {
            throw new SASRFDataException(2001);
        }
        try {
            insertCmdCall.setConfig(dbCallConfig);
            IDBSelectCmdCaller interCall = (IDBSelectCmdCaller)insertCmdCall;
            SelectResult dbResult = interCall.Invoke(paramList, strOpPersonId);
            return dbResult;
        }
        catch (Exception ex) {
            ex.printStackTrace(System.out);
            return null;
        }
    }

    public SelectResult SelectCmd(Connection connection, String strConfigID, Hashtable paramList, String strOpPersonId) throws SASRFDataException {
        DBProcCaller insertCmdCall = this.SelectCmdCaller();
        if (insertCmdCall == null) {
            throw new SASRFDataException(2000);
        }
        insertCmdCall.SetContainer((ConnectionContainer)this);
        DBCallerConfig dbCallConfig = this.dbCallConfigMgr.Get(strConfigID);
        if (dbCallConfig == null) {
            throw new SASRFDataException(2001);
        }
        try {
            insertCmdCall.setConfig(dbCallConfig);
            IDBSelectCmdCaller interCall = (IDBSelectCmdCaller)insertCmdCall;
            SelectResult dbResult = interCall.Invoke(connection, paramList, strOpPersonId);
            return dbResult;
        }
        catch (Exception ex) {
            ex.printStackTrace(System.out);
            return null;
        }
    }

    public DBProcCaller DeleteCmdCaller() {
        return null;
    }

    public DBResult DeleteCmd(String strConfigID, Hashtable paramList, String strOpPersonId) throws SASRFDataException {
        DBProcCaller insertCmdCall = this.DeleteCmdCaller();
        if (insertCmdCall == null) {
            throw new SASRFDataException(2000);
        }
        insertCmdCall.SetContainer((ConnectionContainer)this);
        DBCallerConfig dbCallConfig = this.dbCallConfigMgr.Get(strConfigID);
        if (dbCallConfig == null) {
            throw new SASRFDataException(2001);
        }
        try {
            insertCmdCall.setConfig(dbCallConfig);
            IDBDeleteCmdCaller interCall = (IDBDeleteCmdCaller)insertCmdCall;
            DBResult dbResult = interCall.Invoke(paramList, strOpPersonId);
            return dbResult;
        }
        catch (Exception ex) {
            ex.printStackTrace(System.out);
            return null;
        }
    }

    public DBResult DeleteCmd(Connection connection, String strConfigID, Hashtable paramList, String strOpPersonId) throws SASRFDataException {
        DBProcCaller insertCmdCall = this.DeleteCmdCaller();
        if (insertCmdCall == null) {
            throw new SASRFDataException(2000);
        }
        insertCmdCall.SetContainer((ConnectionContainer)this);
        DBCallerConfig dbCallConfig = this.dbCallConfigMgr.Get(strConfigID);
        if (dbCallConfig == null) {
            throw new SASRFDataException(2001);
        }
        try {
            insertCmdCall.setConfig(dbCallConfig);
            IDBDeleteCmdCaller interCall = (IDBDeleteCmdCaller)insertCmdCall;
            DBResult dbResult = interCall.Invoke(connection, paramList, strOpPersonId);
            return dbResult;
        }
        catch (Exception ex) {
            ex.printStackTrace(System.out);
            return null;
        }
    }

    public DBProcCaller DeleteCmdCallerEx() {
        return null;
    }

    public DBResult DeleteCmdEx(String strConfigID, Hashtable paramList, String strOpPersonId) throws SASRFDataException {
        DBProcCaller insertCmdCall = this.DeleteCmdCallerEx();
        if (insertCmdCall == null) {
            throw new SASRFDataException(2000);
        }
        insertCmdCall.SetContainer((ConnectionContainer)this);
        DBCallerConfig dbCallConfig = this.dbCallConfigMgr.Get(strConfigID);
        if (dbCallConfig == null) {
            throw new SASRFDataException(2001);
        }
        try {
            insertCmdCall.setConfig(dbCallConfig);
            IDBDeleteCmdCaller interCall = (IDBDeleteCmdCaller)insertCmdCall;
            DBResult dbResult = interCall.Invoke(paramList, strOpPersonId);
            return dbResult;
        }
        catch (Exception ex) {
            ex.printStackTrace(System.out);
            return null;
        }
    }

    public DBResult DeleteCmdEx(Connection connection, String strConfigID, Hashtable paramList, String strOpPersonId) throws SASRFDataException {
        DBProcCaller insertCmdCall = this.DeleteCmdCallerEx();
        if (insertCmdCall == null) {
            throw new SASRFDataException(2000);
        }
        insertCmdCall.SetContainer((ConnectionContainer)this);
        DBCallerConfig dbCallConfig = this.dbCallConfigMgr.Get(strConfigID);
        if (dbCallConfig == null) {
            throw new SASRFDataException(2001);
        }
        try {
            insertCmdCall.setConfig(dbCallConfig);
            IDBDeleteCmdCaller interCall = (IDBDeleteCmdCaller)insertCmdCall;
            DBResult dbResult = interCall.Invoke(connection, paramList, strOpPersonId);
            return dbResult;
        }
        catch (Exception ex) {
            ex.printStackTrace(System.out);
            return null;
        }
    }

    public DBProcCaller SearchCmdCaller() {
        return null;
    }

    public SearchResult SearchCmd(String strConfigID, int nCountPerPage, int nPageNO, String strSortParam, int nSortDirect, Hashtable paramList, String strOpPersonId) throws SASRFDataException {
        DBProcCaller searchCmdCall = this.SearchCmdCaller();
        if (searchCmdCall == null) {
            throw new SASRFDataException(2000);
        }
        searchCmdCall.SetContainer((ConnectionContainer)this);
        DBCallerConfig dbCallConfig = this.dbCallConfigMgr.Get(strConfigID);
        if (dbCallConfig == null) {
            throw new SASRFDataException(2001);
        }
        try {
            searchCmdCall.setConfig(dbCallConfig);
            IDBSearchCmdCaller interCall = (IDBSearchCmdCaller)searchCmdCall;
            SearchResult dbResult = interCall.Invoke(nCountPerPage, nPageNO, strSortParam, nSortDirect, paramList, strOpPersonId);
            return dbResult;
        }
        catch (Exception ex) {
            ex.printStackTrace(System.out);
            return null;
        }
    }

    public SearchResult SearchCmd(Connection connection, String strConfigID, int nCountPerPage, int nPageNO, String strSortParam, int nSortDirect, Hashtable paramList, String strOpPersonId) throws SASRFDataException {
        DBProcCaller searchCmdCall = this.SearchCmdCaller();
        if (searchCmdCall == null) {
            throw new SASRFDataException(2000);
        }
        searchCmdCall.SetContainer((ConnectionContainer)this);
        DBCallerConfig dbCallConfig = this.dbCallConfigMgr.Get(strConfigID);
        if (dbCallConfig == null) {
            throw new SASRFDataException(2001);
        }
        try {
            searchCmdCall.setConfig(dbCallConfig);
            IDBSearchCmdCaller interCall = (IDBSearchCmdCaller)searchCmdCall;
            SearchResult dbResult = interCall.Invoke(connection, nCountPerPage, nPageNO, strSortParam, nSortDirect, paramList, strOpPersonId);
            return dbResult;
        }
        catch (Exception ex) {
            ex.printStackTrace(System.out);
            return null;
        }
    }

    public DBProcCaller ConnectionCaller() {
        return null;
    }

    public DBProcCaller RawCmdCaller() {
        return null;
    }

    public DBResult RawCmdEx(ArrayList paramList, String strOpPersonId) throws SASRFDataException {
        DBProcCaller rawCmdCall = this.RawCmdCaller();
        if (rawCmdCall == null) {
            throw new SASRFDataException(2000);
        }
        rawCmdCall.SetContainer((ConnectionContainer)this);
        try {
            IDBRawCmdCaller interCall = (IDBRawCmdCaller)rawCmdCall;
            DBResult dbResult = interCall.Invoke(paramList, strOpPersonId);
            return dbResult;
        }
        catch (Exception ex) {
            ex.printStackTrace(System.out);
            return null;
        }
    }

    public DBResult RawCmdEx(Connection connection, ArrayList paramList, String strOpPersonId) throws SASRFDataException {
        DBProcCaller rawCmdCall = this.RawCmdCaller();
        if (rawCmdCall == null) {
            throw new SASRFDataException(2000);
        }
        rawCmdCall.SetContainer((ConnectionContainer)this);
        try {
            IDBRawCmdCaller interCall = (IDBRawCmdCaller)rawCmdCall;
            DBResult dbResult = interCall.Invoke(connection, paramList, strOpPersonId);
            return dbResult;
        }
        catch (Exception ex) {
            ex.printStackTrace(System.out);
            return null;
        }
    }
}

