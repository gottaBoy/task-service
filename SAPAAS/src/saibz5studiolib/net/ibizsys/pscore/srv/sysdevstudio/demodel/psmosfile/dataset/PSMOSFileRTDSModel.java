/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.IDEDataSetFetchContext
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.db.DBFetchResult
 *  net.ibizsys.paas.db.IDataRow
 *  net.ibizsys.paas.db.IDataSet
 *  net.ibizsys.paas.db.IDataTable
 *  net.ibizsys.paas.db.impl.SimpleDataRowImpl
 *  net.ibizsys.paas.db.impl.SimpleDataSetImpl
 *  net.ibizsys.paas.db.impl.SimpleDataTableImpl
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.web.WebContext
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.pscore.srv.sysdevstudio.demodel.psmosfile.dataset;

import net.ibizsys.paas.core.IDEDataSetFetchContext;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.db.DBFetchResult;
import net.ibizsys.paas.db.IDataRow;
import net.ibizsys.paas.db.IDataSet;
import net.ibizsys.paas.db.IDataTable;
import net.ibizsys.paas.db.impl.SimpleDataRowImpl;
import net.ibizsys.paas.db.impl.SimpleDataSetImpl;
import net.ibizsys.paas.db.impl.SimpleDataTableImpl;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.WebContext;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemService;
import net.ibizsys.pscore.srv.sysdevstudio.demodel.psmosfile.dataset.PSMOSFileRTDSModelBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.PSMOSFileUtil;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public class PSMOSFileRTDSModel
extends PSMOSFileRTDSModelBase {
    private static final Log log = LogFactory.getLog(PSMOSFileRTDSModel.class);

    public DBFetchResult fetchDEDataSet(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (WebContext.getCurrent() == null) {
            throw new Exception(StringHelper.format((String)"\u5f53\u524d\u8bf7\u6c42\u73af\u5883\u65e0\u6548"));
        }
        JSONObject jSONObject = WebContext.getAppData();
        DBFetchResult dBFetchResult = new DBFetchResult();
        SimpleDataSetImpl simpleDataSetImpl = new SimpleDataSetImpl();
        String string = jSONObject.optString("pssystemid", "");
        String string2 = DataObject.getStringValue((Object)iDEDataSetFetchContext.getActiveDataObject().get("NODEID"), (String)"");
        PSSystemService pSSystemService = (PSSystemService)ServiceGlobal.getService(PSSystemService.class, (SessionFactory)iDEDataSetFetchContext.getSessionFactory());
        PSMOSFile pSMOSFile = new PSMOSFile();
        pSMOSFile.setPSModelType("PSSYSTEM");
        pSMOSFile.setPSModelId(string);
        PSMOSFile[] pSMOSFileArray = null;
        try {
            pSMOSFileArray = pSSystemService.listFiles(pSMOSFile, string2, null);
        }
        catch (Exception exception) {
            log.error((Object)exception);
            throw new Exception(StringHelper.format((String)"\u67e5\u8be2\u6a21\u578b\u7cfb\u7edf\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)exception.getMessage()));
        }
        SimpleDataTableImpl simpleDataTableImpl = new SimpleDataTableImpl((IDataSet)simpleDataSetImpl);
        dBFetchResult.setTotalRow(0);
        if (pSMOSFileArray != null) {
            for (PSMOSFile pSMOSFile2 : pSMOSFileArray = PSMOSFileUtil.sort(pSMOSFileArray)) {
                String string3 = pSMOSFile2.getPSMOSFileName();
                if (StringHelper.compare((String)pSMOSFile2.getFileTag(), (String)"LINK", (boolean)true) == 0) {
                    string3 = "<span title=\"" + pSMOSFile2.getFileTag2() + "\">[L]</span>" + string3;
                } else if (StringHelper.compare((String)pSMOSFile2.getFileTag(), (String)"DR", (boolean)true) == 0 && pSMOSFile2.getFileCnt() != null && DataObject.getIntegerValue((Object)pSMOSFile2.getFileCnt(), (Integer)0) > 0) {
                    string3 = string3 + StringHelper.format((String)"(%1$s)", (Object)pSMOSFile2.getFileCnt());
                }
                pSMOSFile2.setPSMOSFileName(string3);
                SimpleDataRowImpl simpleDataRowImpl = new SimpleDataRowImpl();
                DataObject.fromJSONObject((IDataObject)simpleDataRowImpl, (JSONObject)DataObject.toJSONObject((IDataObject)pSMOSFile2, (boolean)false));
                simpleDataTableImpl.addCachedRow((IDataRow)simpleDataRowImpl);
            }
            dBFetchResult.setTotalRow(pSMOSFileArray.length);
        }
        simpleDataSetImpl.addDataTable((IDataTable)simpleDataTableImpl);
        dBFetchResult.setDataSet((IDataSet)simpleDataSetImpl);
        return dBFetchResult;
    }
}

