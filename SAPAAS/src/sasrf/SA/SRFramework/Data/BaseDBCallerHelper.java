/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.Data;

import SA.SRFramework.Data.CallParam;
import SA.SRFramework.Data.ConnectionContainer;
import SA.SRFramework.Data.DBCallConfigMgr;
import SA.SRFramework.Data.DBCallerConfig;
import SA.SRFramework.Data.DBProcCaller;
import SA.SRFramework.Data.DBResult;
import SA.SRFramework.Data.IDBInsertProcCaller;
import SA.SRFramework.Data.IDBRawProcCaller2;
import SA.SRFramework.Data.IDBRawProcCaller3;
import SA.SRFramework.Data.IDBRawProcCaller4;
import SA.SRFramework.Data.IDBSearchProcCaller;
import SA.SRFramework.Data.IDBSearchProcCaller2;
import SA.SRFramework.Data.IDBSelectProcCaller;
import SA.SRFramework.Data.IDBUpdateProcCaller;
import SA.SRFramework.Data.IDBUpdateProcCaller2;
import SA.SRFramework.Data.InsertResult;
import SA.SRFramework.Data.SASRFDataException;
import SA.SRFramework.Data.SearchResult;
import SA.SRFramework.Data.SearchResult2;
import SA.SRFramework.Data.SelectResult;
import SA.SRFramework.Data.SelectResult2;
import java.sql.Connection;
import java.util.Hashtable;
import java.util.Vector;

public class BaseDBCallerHelper
extends ConnectionContainer {
    protected DBCallConfigMgr dbCallConfigMgr = null;
    protected String strDSN = "";
    protected String strUserName = "";
    protected String strPassword = "";
    protected boolean bConnectionPoolMode = true;

    public void setConfigMgr(DBCallConfigMgr value) {
        this.dbCallConfigMgr = value;
    }

    public DBCallConfigMgr getConfigMgr() {
        return this.dbCallConfigMgr;
    }

    public DBProcCaller SearchCall() {
        return null;
    }

    public DBProcCaller InsertCall() {
        return null;
    }

    public DBProcCaller SelectCall() {
        return null;
    }

    public DBProcCaller UpdateCall() {
        return null;
    }

    public DBProcCaller UpdateCall2() {
        return null;
    }

    public DBProcCaller RawCall2() {
        return null;
    }

    public DBProcCaller RawCall2(int nUserTag) {
        return null;
    }

    public DBProcCaller RawCall3() {
        return null;
    }

    public DBProcCaller RawCall4() {
        return null;
    }

    public DBProcCaller SearchCall2() {
        return null;
    }

    public SearchResult CallSearch(String strConfigID, int nCountPerPage, int nPageNO, String strSortParam, int nSortDirect, Hashtable paramList, String strOpPersonId) throws SASRFDataException {
        DBProcCaller searchCall = this.SearchCall();
        if (searchCall == null) {
            throw new SASRFDataException(2000);
        }
        searchCall.SetContainer(this);
        DBCallerConfig dbCallConfig = this.dbCallConfigMgr.Get(strConfigID);
        if (dbCallConfig == null) {
            throw new SASRFDataException(2001);
        }
        try {
            searchCall.setConfig(dbCallConfig);
            IDBSearchProcCaller interCall = (IDBSearchProcCaller)((Object)searchCall);
            SearchResult searchResult = interCall.Invoke(nCountPerPage, nPageNO, strSortParam, nSortDirect, paramList, strOpPersonId);
            return searchResult;
        }
        catch (Exception ex) {
            ex.printStackTrace(System.out);
            return null;
        }
    }

    public SearchResult2 CallSearch2(String strConfigID, int nCountPerPage, int nPageNO, String strSortParam, int nSortDirect, Hashtable paramList, String strOpPersonId) throws SASRFDataException {
        DBProcCaller searchCall = this.SearchCall2();
        if (searchCall == null) {
            throw new SASRFDataException(2000);
        }
        searchCall.SetContainer(this);
        DBCallerConfig dbCallConfig = this.dbCallConfigMgr.Get(strConfigID);
        if (dbCallConfig == null) {
            throw new SASRFDataException(2001);
        }
        try {
            searchCall.setConfig(dbCallConfig);
            IDBSearchProcCaller2 interCall = (IDBSearchProcCaller2)((Object)searchCall);
            SearchResult2 searchResult = interCall.Invoke(nCountPerPage, nPageNO, strSortParam, nSortDirect, paramList, strOpPersonId);
            return searchResult;
        }
        catch (Exception ex) {
            ex.printStackTrace(System.out);
            return null;
        }
    }

    public void ReleaseSearchResult2(SearchResult2 searchResult2) throws SASRFDataException {
        DBProcCaller searchCall = this.SearchCall2();
        if (searchCall == null) {
            throw new SASRFDataException(2000);
        }
        searchCall.SetContainer(this);
        try {
            IDBSearchProcCaller2 interCall = (IDBSearchProcCaller2)((Object)searchCall);
            interCall.ReleaseSearchResult(searchResult2);
        }
        catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
    }

    public SelectResult CallSelect(String strConfigID, Hashtable paramList) throws SASRFDataException {
        DBProcCaller selectCall = this.SelectCall();
        if (selectCall == null) {
            throw new SASRFDataException(2000);
        }
        selectCall.SetContainer(this);
        DBCallerConfig dbCallConfig = this.dbCallConfigMgr.Get(strConfigID);
        if (dbCallConfig == null) {
            throw new SASRFDataException(2001);
        }
        try {
            selectCall.setConfig(dbCallConfig);
            IDBSelectProcCaller interCall = (IDBSelectProcCaller)((Object)selectCall);
            SelectResult selectResult = interCall.Invoke(paramList);
            return selectResult;
        }
        catch (Exception ex) {
            ex.printStackTrace(System.out);
            return null;
        }
    }

    public InsertResult CallInsert(String strConfigID, Hashtable paramList, String strOpPersonId) throws SASRFDataException {
        DBProcCaller insertCall = this.InsertCall();
        if (insertCall == null) {
            throw new SASRFDataException(2000);
        }
        insertCall.SetContainer(this);
        DBCallerConfig dbCallConfig = this.dbCallConfigMgr.Get(strConfigID);
        if (dbCallConfig == null) {
            throw new SASRFDataException(2001);
        }
        try {
            insertCall.setConfig(dbCallConfig);
            IDBInsertProcCaller interCall = (IDBInsertProcCaller)((Object)insertCall);
            InsertResult insertResult = interCall.Invoke(paramList, strOpPersonId);
            return insertResult;
        }
        catch (Exception ex) {
            ex.printStackTrace(System.out);
            return null;
        }
    }

    public DBResult CallUpdate(String strConfigID, Hashtable paramList, String strOpPersonId) throws SASRFDataException {
        DBProcCaller updateCall = this.UpdateCall();
        if (updateCall == null) {
            throw new SASRFDataException(2000);
        }
        updateCall.SetContainer(this);
        DBCallerConfig dbCallConfig = this.dbCallConfigMgr.Get(strConfigID);
        if (dbCallConfig == null) {
            throw new SASRFDataException(2001);
        }
        try {
            updateCall.setConfig(dbCallConfig);
            IDBUpdateProcCaller interCall = (IDBUpdateProcCaller)((Object)updateCall);
            DBResult dbResult = interCall.Invoke(paramList, strOpPersonId);
            return dbResult;
        }
        catch (Exception ex) {
            ex.printStackTrace(System.out);
            return null;
        }
    }

    public DBResult CallUpdate2(String strConfigID, Hashtable paramList, String strOpPersonId) throws SASRFDataException {
        DBProcCaller updateCall2 = this.UpdateCall2();
        if (updateCall2 == null) {
            throw new SASRFDataException(2000);
        }
        updateCall2.SetContainer(this);
        DBCallerConfig dbCallConfig = this.dbCallConfigMgr.Get(strConfigID);
        if (dbCallConfig == null) {
            throw new SASRFDataException(2001);
        }
        try {
            updateCall2.setConfig(dbCallConfig);
            IDBUpdateProcCaller2 interCall = (IDBUpdateProcCaller2)((Object)updateCall2);
            DBResult dbResult = interCall.Invoke(paramList, strOpPersonId);
            return dbResult;
        }
        catch (Exception ex) {
            ex.printStackTrace(System.out);
            return null;
        }
    }

    public DBResult CallDelete(String strConfigID, Hashtable paramList, String strOpPersonId) throws SASRFDataException {
        DBProcCaller updateCall = this.UpdateCall();
        if (updateCall == null) {
            throw new SASRFDataException(2000);
        }
        updateCall.SetContainer(this);
        DBCallerConfig dbCallConfig = this.dbCallConfigMgr.Get(strConfigID);
        if (dbCallConfig == null) {
            throw new SASRFDataException(2001);
        }
        try {
            updateCall.setConfig(dbCallConfig);
            IDBUpdateProcCaller interCall = (IDBUpdateProcCaller)((Object)updateCall);
            DBResult dbResult = interCall.Invoke(paramList, strOpPersonId);
            return dbResult;
        }
        catch (Exception ex) {
            ex.printStackTrace(System.out);
            return null;
        }
    }

    public DBResult CallNormal(String strConfigID, Hashtable paramList, String strOpPersonId) throws SASRFDataException {
        DBProcCaller updateCall = this.UpdateCall();
        if (updateCall == null) {
            throw new SASRFDataException(2000);
        }
        updateCall.SetContainer(this);
        DBCallerConfig dbCallConfig = this.dbCallConfigMgr.Get(strConfigID);
        if (dbCallConfig == null) {
            throw new SASRFDataException(2001);
        }
        try {
            updateCall.setConfig(dbCallConfig);
            IDBUpdateProcCaller interCall = (IDBUpdateProcCaller)((Object)updateCall);
            DBResult dbResult = interCall.Invoke(paramList, strOpPersonId);
            return dbResult;
        }
        catch (Exception ex) {
            ex.printStackTrace(System.out);
            return null;
        }
    }

    public DBResult CallNormal2(String strConfigID, Hashtable paramList, String strOpPersonId) throws SASRFDataException {
        DBProcCaller updateCall2 = this.UpdateCall2();
        if (updateCall2 == null) {
            throw new SASRFDataException(2000);
        }
        updateCall2.SetContainer(this);
        DBCallerConfig dbCallConfig = this.dbCallConfigMgr.Get(strConfigID);
        if (dbCallConfig == null) {
            throw new SASRFDataException(2001);
        }
        try {
            updateCall2.setConfig(dbCallConfig);
            IDBUpdateProcCaller2 interCall = (IDBUpdateProcCaller2)((Object)updateCall2);
            DBResult dbResult = interCall.Invoke(paramList, strOpPersonId);
            return dbResult;
        }
        catch (Exception ex) {
            ex.printStackTrace(System.out);
            return null;
        }
    }

    public SelectResult CallRaw2(String strCommand) throws SASRFDataException {
        DBProcCaller rawCall2 = this.RawCall2();
        if (rawCall2 == null) {
            throw new SASRFDataException(2000);
        }
        rawCall2.SetContainer(this);
        try {
            IDBRawProcCaller2 interCall = (IDBRawProcCaller2)((Object)rawCall2);
            SelectResult selectResult = interCall.Invoke(strCommand);
            return selectResult;
        }
        catch (Exception ex) {
            ex.printStackTrace(System.out);
            return null;
        }
    }

    public SelectResult CallRaw2(Connection connection, String strCommand) throws SASRFDataException {
        DBProcCaller rawCall2 = this.RawCall2();
        if (rawCall2 == null) {
            throw new SASRFDataException(2000);
        }
        rawCall2.SetContainer(this);
        rawCall2.setConnection(connection);
        try {
            IDBRawProcCaller2 interCall = (IDBRawProcCaller2)((Object)rawCall2);
            SelectResult selectResult = interCall.Invoke(strCommand);
            return selectResult;
        }
        catch (Exception ex) {
            ex.printStackTrace(System.out);
            return null;
        }
    }

    public SelectResult CallRaw3(String strCommand, Vector<CallParam> list) throws SASRFDataException {
        DBProcCaller rawCall3 = this.RawCall3();
        if (rawCall3 == null) {
            throw new SASRFDataException(2000);
        }
        rawCall3.SetContainer(this);
        try {
            IDBRawProcCaller3 interCall = (IDBRawProcCaller3)((Object)rawCall3);
            SelectResult selectResult = interCall.Invoke(strCommand, list);
            return selectResult;
        }
        catch (Exception ex) {
            ex.printStackTrace(System.out);
            return null;
        }
    }

    public SelectResult CallRaw3(Connection connection, String strCommand, Vector<CallParam> list) throws SASRFDataException {
        DBProcCaller rawCall3 = this.RawCall3();
        if (rawCall3 == null) {
            throw new SASRFDataException(2000);
        }
        rawCall3.SetContainer(this);
        rawCall3.setConnection(connection);
        try {
            IDBRawProcCaller3 interCall = (IDBRawProcCaller3)((Object)rawCall3);
            SelectResult selectResult = interCall.Invoke(strCommand, list);
            return selectResult;
        }
        catch (Exception ex) {
            ex.printStackTrace(System.out);
            return null;
        }
    }

    public SelectResult2 CallRaw3ReturnRS(String strCommand, Vector<CallParam> list) throws SASRFDataException {
        DBProcCaller rawCall3 = this.RawCall3();
        if (rawCall3 == null) {
            throw new SASRFDataException(2000);
        }
        rawCall3.SetContainer(this);
        try {
            IDBRawProcCaller3 interCall = (IDBRawProcCaller3)((Object)rawCall3);
            SelectResult2 selectResult = interCall.Invoke3(strCommand, list);
            return selectResult;
        }
        catch (Exception ex) {
            ex.printStackTrace(System.out);
            return null;
        }
    }

    public SelectResult2 CallRaw3ReturnRS(Connection connection, String strCommand, Vector<CallParam> list) throws SASRFDataException {
        DBProcCaller rawCall3 = this.RawCall3();
        if (rawCall3 == null) {
            throw new SASRFDataException(2000);
        }
        rawCall3.SetContainer(this);
        rawCall3.setConnection(connection);
        try {
            IDBRawProcCaller3 interCall = (IDBRawProcCaller3)((Object)rawCall3);
            SelectResult2 selectResult = interCall.Invoke3(strCommand, list);
            return selectResult;
        }
        catch (Exception ex) {
            ex.printStackTrace(System.out);
            return null;
        }
    }

    public void ReleaseSelectResult2(SelectResult2 searchResult2) throws SASRFDataException {
        DBProcCaller rawCall3 = this.RawCall3();
        if (rawCall3 == null) {
            throw new SASRFDataException(2000);
        }
        rawCall3.SetContainer(this);
        try {
            IDBRawProcCaller3 interCall = (IDBRawProcCaller3)((Object)rawCall3);
            interCall.ReleaseSelectResult(searchResult2);
        }
        catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
    }

    public DBResult CallRaw3WithoutReturn(String strCommand, Vector<CallParam> list) throws SASRFDataException {
        DBProcCaller rawCall3 = this.RawCall3();
        if (rawCall3 == null) {
            throw new SASRFDataException(2000);
        }
        rawCall3.SetContainer(this);
        try {
            IDBRawProcCaller3 interCall = (IDBRawProcCaller3)((Object)rawCall3);
            DBResult dbResult = interCall.Invoke2(strCommand, list);
            return dbResult;
        }
        catch (Exception ex) {
            ex.printStackTrace(System.out);
            return null;
        }
    }

    public DBResult CallRaw3WithoutReturn(Connection connection, String strCommand, Vector<CallParam> list) throws SASRFDataException {
        DBProcCaller rawCall3 = this.RawCall3();
        if (rawCall3 == null) {
            throw new SASRFDataException(2000);
        }
        rawCall3.SetContainer(this);
        rawCall3.setConnection(connection);
        try {
            IDBRawProcCaller3 interCall = (IDBRawProcCaller3)((Object)rawCall3);
            DBResult dbResult = interCall.Invoke2(strCommand, list);
            return dbResult;
        }
        catch (Exception ex) {
            ex.printStackTrace(System.out);
            return null;
        }
    }

    public SelectResult CallRaw4(String strCommand, Vector<CallParam> list) throws SASRFDataException {
        DBProcCaller rawCall4 = this.RawCall4();
        if (rawCall4 == null) {
            throw new SASRFDataException(2000);
        }
        rawCall4.SetContainer(this);
        try {
            IDBRawProcCaller4 interCall = (IDBRawProcCaller4)((Object)rawCall4);
            SelectResult selectResult = interCall.Invoke(strCommand, list);
            return selectResult;
        }
        catch (Exception ex) {
            ex.printStackTrace(System.out);
            return null;
        }
    }

    public SelectResult CallRaw4(Connection connection, String strCommand, Vector<CallParam> list) throws SASRFDataException {
        DBProcCaller rawCall4 = this.RawCall4();
        if (rawCall4 == null) {
            throw new SASRFDataException(2000);
        }
        rawCall4.SetContainer(this);
        rawCall4.setConnection(connection);
        try {
            IDBRawProcCaller4 interCall = (IDBRawProcCaller4)((Object)rawCall4);
            SelectResult selectResult = interCall.Invoke(strCommand, list);
            return selectResult;
        }
        catch (Exception ex) {
            ex.printStackTrace(System.out);
            return null;
        }
    }

    public SelectResult CallRaw2(int nUserTag, String strCommand) throws SASRFDataException {
        DBProcCaller rawCall2 = this.RawCall2(nUserTag);
        if (rawCall2 == null) {
            throw new SASRFDataException(2000);
        }
        rawCall2.SetContainer(this);
        try {
            IDBRawProcCaller2 interCall = (IDBRawProcCaller2)((Object)rawCall2);
            SelectResult selectResult = interCall.Invoke(strCommand);
            return selectResult;
        }
        catch (Exception ex) {
            ex.printStackTrace(System.out);
            return null;
        }
    }

    public String getDSN() {
        return this.strDSN;
    }

    public String getUserName() {
        return this.strUserName;
    }

    public String getPassword() {
        return this.strPassword;
    }

    public void setDSN(String strDSN) {
        this.strDSN = strDSN;
    }

    public void setUserName(String strUserName) {
        this.strUserName = strUserName;
    }

    public void setPassword(String strPassword) {
        this.strPassword = strPassword;
    }

    public boolean isConnectionPoolMode() {
        return this.bConnectionPoolMode;
    }

    public void setConnectionPoolMode(boolean bConnectionPoolMode) {
        this.bConnectionPoolMode = bConnectionPoolMode;
    }
}

