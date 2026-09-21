/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.db.DBCallResult
 *  net.ibizsys.paas.db.SqlParamList
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.exception.ErrorException
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.pscore.srv.util;

import java.util.HashMap;
import net.ibizsys.paas.db.DBCallResult;
import net.ibizsys.paas.db.SqlParamList;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.exception.ErrorException;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModelSeq;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.service.PSModelSeqService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public class PSModelFolderKeyHelper {
    private static final Log log = LogFactory.getLog(PSModelFolderKeyHelper.class);
    private static final HashMap<String, String> sysModelKeySeqMap = new HashMap();
    private static final HashMap<String, String> ignoreModelKeySeqMap = new HashMap();
    private static final HashMap<String, String> sysModelCatMap = new HashMap();
    public static final String SYSTEMTAG = "S";
    private static String strSql = StringHelper.format((String)"UPDATE T_SRFPSMODELSEQ SET CURVAL = ? WHERE PSMODELSEQID = ? AND CURVAL = ?");

    public static boolean registerPSModelKeySeq(String string, String string2) {
        String string3 = sysModelKeySeqMap.get(string);
        if (string3 != null) {
            if (!StringHelper.isNullOrEmpty((String)string3)) {
                log.error((Object)StringHelper.format((String)"\u6a21\u578b[%1$s]\u5df2\u7ecf\u6ce8\u518c\u4e86\u7236\u5c5e\u6027[%2$s]", (Object)string, (Object)string3));
            }
            return false;
        }
        sysModelKeySeqMap.put(string, string2);
        return true;
    }

    public static String getPSModelKeyField(String string) {
        return sysModelKeySeqMap.get(string);
    }

    public static String getModelKey(IEntity iEntity, PSSystem pSSystem, String string, String string2, SessionFactory sessionFactory) throws Exception {
        String string3 = sysModelKeySeqMap.get(string);
        if (StringHelper.isNullOrEmpty((String)string3)) {
            if (ignoreModelKeySeqMap.containsKey(string)) {
                return null;
            }
            log.warn((Object)StringHelper.format((String)"\u6a21\u578b[%1$s]\u6ca1\u6709\u6307\u5b9a\u7236\u5c5e\u6027\uff0c\u65e0\u6cd5\u8ba1\u7b97\u76ee\u5f55\u952e\u503c", (Object)string));
            return null;
        }
        if (StringHelper.compare((String)string3, (String)"PSSYSTEMID", (boolean)true) == 0) {
            if (StringHelper.isNullOrEmpty((String)string2) && (string2 = sysModelCatMap.get(string)) == null) {
                string2 = "";
            }
            int n = PSModelFolderKeyHelper.getModelSeq(pSSystem, string, null, sessionFactory);
            return StringHelper.format((String)"S0-%1$s%2$s", (Object)string2, (Object)n);
        }
        Object object = iEntity.get(string3);
        if (StringHelper.isNullOrEmpty((Object)object)) {
            throw new Exception(StringHelper.format((String)"\u6a21\u578b[%1$s]\u6ca1\u6709\u6307\u5b9a\u7236\u503c[%2$s]", (Object)string, (Object)string3));
        }
        int n = PSModelFolderKeyHelper.getModelSeq(pSSystem, string, object, sessionFactory);
        return StringHelper.format((String)"%3$s-%2$s%1$s", (Object)string2, (Object)n, (Object)object);
    }

    public static int getModelSeq(PSSystem pSSystem, String string, Object object, SessionFactory sessionFactory) throws Exception {
        String string2 = null;
        string2 = KeyValueHelper.genUniqueId((String)pSSystem.getPSSystemId(), (String)string);
        PSModelSeqService pSModelSeqService = (PSModelSeqService)ServiceGlobal.getService(PSModelSeqService.class, (SessionFactory)sessionFactory);
        PSModelSeq pSModelSeq = new PSModelSeq();
        pSModelSeq.setPSModelSeqId(string2);
        while (true) {
            ErrorException errorException;
            try {
                DBCallResult dBCallResult;
                do {
                    boolean bl;
                    if (!(bl = pSModelSeqService.get((IEntity)pSModelSeq, true))) {
                        pSModelSeq.setPSModelSeqName(string);
                        pSModelSeq.setUserTag(pSSystem.getPSSystemId());
                        pSModelSeq.setSysRowKey(pSSystem.getSysRowKey());
                        pSModelSeq.setCurVal(100);
                        pSModelSeqService.create(pSModelSeq);
                        return pSModelSeq.getCurVal();
                    }
                    errorException = new SqlParamList();
                    errorException.add((Object)(pSModelSeq.getCurVal() + 1), 9);
                    errorException.add((Object)string2, 25);
                    errorException.add((Object)pSModelSeq.getCurVal(), 9);
                    dBCallResult = pSModelSeqService.executeRaw(strSql, (SqlParamList)errorException);
                    if (dBCallResult.isOk()) continue;
                    throw new Exception(StringHelper.format((String)"\u6267\u884cSQL\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)dBCallResult.getErrorInfo()));
                } while (dBCallResult.getUpdateCount() == 0);
                return pSModelSeq.getCurVal() + 1;
            }
            catch (Exception exception) {
                if (exception instanceof ErrorException && (errorException = (ErrorException)((Object)exception)).getErrorCode() == 6) continue;
                throw exception;
            }
            break;
        }
    }

    public static boolean isIgnoreModel(String string) {
        return ignoreModelKeySeqMap.containsKey(string);
    }

    static {
        if (PSModelFolderKeyHelper.registerPSModelKeySeq("PSDATAENTITY", "PSSYSTEMID")) {
            // empty if block
        }
        if (PSModelFolderKeyHelper.registerPSModelKeySeq("PSMODULE", "PSSYSTEMID")) {
            // empty if block
        }
        if (PSModelFolderKeyHelper.registerPSModelKeySeq("PSSYSAPP", "PSSYSTEMID")) {
            // empty if block
        }
        if (PSModelFolderKeyHelper.registerPSModelKeySeq("PSDEACTIONTEMPL", "PSSYSTEMID")) {
            // empty if block
        }
        if (PSModelFolderKeyHelper.registerPSModelKeySeq("PSDEGROUP", "PSSYSTEMID")) {
            // empty if block
        }
        if (PSModelFolderKeyHelper.registerPSModelKeySeq("PSDYNADETEMPL", "PSSYSTEMID")) {
            // empty if block
        }
        if (PSModelFolderKeyHelper.registerPSModelKeySeq("PSSYSCSSCAT", "PSSYSTEMID")) {
            // empty if block
        }
        if (PSModelFolderKeyHelper.registerPSModelKeySeq("PSSYSCSS", "PSSYSTEMID")) {
            // empty if block
        }
        if (PSModelFolderKeyHelper.registerPSModelKeySeq("PSSYSDBSCHEME", "PSSYSTEMID")) {
            // empty if block
        }
        if (PSModelFolderKeyHelper.registerPSModelKeySeq("PSSYSDMVER", "PSSYSTEMID")) {
            // empty if block
        }
        if (PSModelFolderKeyHelper.registerPSModelKeySeq("PSSYSEDITORSTYLE", "PSSYSTEMID")) {
            // empty if block
        }
        if (PSModelFolderKeyHelper.registerPSModelKeySeq("PSSYSMSGTEMPL", "PSSYSTEMID")) {
            // empty if block
        }
        if (PSModelFolderKeyHelper.registerPSModelKeySeq("PSSYSOPPRIV", "PSSYSTEMID")) {
            // empty if block
        }
        if (PSModelFolderKeyHelper.registerPSModelKeySeq("PSSYSPDTVIEW", "PSSYSTEMID")) {
            // empty if block
        }
        if (PSModelFolderKeyHelper.registerPSModelKeySeq("PSSYSPFPLUGIN", "PSSYSTEMID")) {
            // empty if block
        }
        if (PSModelFolderKeyHelper.registerPSModelKeySeq("PSSYSSAMPLEVALUE", "PSSYSTEMID")) {
            // empty if block
        }
        if (PSModelFolderKeyHelper.registerPSModelKeySeq("PSSYSTITLEBAR", "PSSYSTEMID")) {
            // empty if block
        }
        if (PSModelFolderKeyHelper.registerPSModelKeySeq("PSSYSUSERMODE", "PSSYSTEMID")) {
            // empty if block
        }
        if (PSModelFolderKeyHelper.registerPSModelKeySeq("PSSYSUTILDE", "PSSYSTEMID")) {
            // empty if block
        }
        if (PSModelFolderKeyHelper.registerPSModelKeySeq("PSWFROLE", "PSSYSTEMID")) {
            // empty if block
        }
        if (PSModelFolderKeyHelper.registerPSModelKeySeq("PSWORKFLOW", "PSSYSTEMID")) {
            // empty if block
        }
        if (PSModelFolderKeyHelper.registerPSModelKeySeq("PSSYSUNIRES", "PSSYSTEMID")) {
            // empty if block
        }
        if (PSModelFolderKeyHelper.registerPSModelKeySeq("PSSYSUSERDR", "PSSYSTEMID")) {
            // empty if block
        }
        if (!PSModelFolderKeyHelper.registerPSModelKeySeq("PSSYSSERVICEAPI", "PSSYSTEMID") || !PSModelFolderKeyHelper.registerPSModelKeySeq("PSDESERVICEAPI", "PSSYSSERVICEAPIID") || PSModelFolderKeyHelper.registerPSModelKeySeq("PSDESADETAIL", "PSDESERVICEAPIID")) {
            // empty if block
        }
        if (!PSModelFolderKeyHelper.registerPSModelKeySeq("PSSUBSYSSERVICEAPI", "PSSYSTEMID") || PSModelFolderKeyHelper.registerPSModelKeySeq("PSSUBSYSSADETAIL", "PSSUBSYSSERVICEAPIID")) {
            // empty if block
        }
        if (PSModelFolderKeyHelper.registerPSModelKeySeq("PSSYSUNIT", "PSSYSTEMID")) {
            // empty if block
        }
        if (!PSModelFolderKeyHelper.registerPSModelKeySeq("PSSYSERMAP", "PSSYSTEMID") || PSModelFolderKeyHelper.registerPSModelKeySeq("PSSYSERMAPNODE", "PSSYSERMAPID")) {
            // empty if block
        }
        if (!PSModelFolderKeyHelper.registerPSModelKeySeq("PSSYSDYNAMODEL", "PSSYSTEMID") || PSModelFolderKeyHelper.registerPSModelKeySeq("PSSYSDYNAMODELATTR", "PSSYSDYNAMODELID")) {
            // empty if block
        }
        if (!PSModelFolderKeyHelper.registerPSModelKeySeq("PSSYSVIEWLOGIC", "PSSYSTEMID") || PSModelFolderKeyHelper.registerPSModelKeySeq("PSSYSVIEWLOGICPARAM", "PSSYSVIEWLOGICID")) {
            // empty if block
        }
        if (PSModelFolderKeyHelper.registerPSModelKeySeq("PSSYSTESTCASE", "PSSYSTEMID")) {
            if (PSModelFolderKeyHelper.registerPSModelKeySeq("PSSYSTCASSERT", "PSSYSTESTCASEID")) {
                // empty if block
            }
            if (PSModelFolderKeyHelper.registerPSModelKeySeq("PSSYSTCINPUT", "PSSYSTESTCASEID")) {
                // empty if block
            }
        }
        if (PSModelFolderKeyHelper.registerPSModelKeySeq("PSACHANDLER", "PSDEID")) {
            if (PSModelFolderKeyHelper.registerPSModelKeySeq("PSACHANDLER_SYS", "PSSYSTEMID")) {
                // empty if block
            }
            if (PSModelFolderKeyHelper.registerPSModelKeySeq("PSACHANDLERACTION", "PSACHANDLERID")) {
                // empty if block
            }
        }
        if (PSModelFolderKeyHelper.registerPSModelKeySeq("PSCODELIST", "PSDEID")) {
            if (PSModelFolderKeyHelper.registerPSModelKeySeq("PSCODELIST_SYS", "PSSYSTEMID")) {
                // empty if block
            }
            if (PSModelFolderKeyHelper.registerPSModelKeySeq("PSCODEITEM", "PSCODELISTID")) {
                // empty if block
            }
        }
        if (!PSModelFolderKeyHelper.registerPSModelKeySeq("PSDEACMODE", "PSDEID") || PSModelFolderKeyHelper.registerPSModelKeySeq("PSDEACMODEITEM", "PSDEACMODEID")) {
            // empty if block
        }
        if (!PSModelFolderKeyHelper.registerPSModelKeySeq("PSDEACTIONWIZARD", "PSDEID") || PSModelFolderKeyHelper.registerPSModelKeySeq("PSDEAWITEM", "PSDEACTIONWIZARDID")) {
            // empty if block
        }
        if (PSModelFolderKeyHelper.registerPSModelKeySeq("PSDEACTION", "PSDEID")) {
            if (PSModelFolderKeyHelper.registerPSModelKeySeq("PSDEACTIONLOGIC", "PSDEACTIONID")) {
                // empty if block
            }
            if (PSModelFolderKeyHelper.registerPSModelKeySeq("PSDEACTIONPARAM", "PSDEACTIONID")) {
                // empty if block
            }
        }
        if (!PSModelFolderKeyHelper.registerPSModelKeySeq("PSDEAWGROUP", "PSDEID") || PSModelFolderKeyHelper.registerPSModelKeySeq("PSDEAWGRPDETAIL", "PSDEAWGROUPID")) {
            // empty if block
        }
        if (PSModelFolderKeyHelper.registerPSModelKeySeq("PSDECHART", "PSDEID")) {
            if (PSModelFolderKeyHelper.registerPSModelKeySeq("PSDECHARTAXES", "PSDECHARTID")) {
                // empty if block
            }
            if (PSModelFolderKeyHelper.registerPSModelKeySeq("PSDECHARTPARAM", "PSDECHARTID")) {
                // empty if block
            }
        }
        if (PSModelFolderKeyHelper.registerPSModelKeySeq("PSDEDATAEXP", "PSDEID")) {
            // empty if block
        }
        if (!PSModelFolderKeyHelper.registerPSModelKeySeq("PSDEDATAIMP", "PSDEID") || PSModelFolderKeyHelper.registerPSModelKeySeq("PSDEDATAIMPITEM", "PSDEDATAIMPID")) {
            // empty if block
        }
        if (PSModelFolderKeyHelper.registerPSModelKeySeq("PSDEDATAQUERY", "PSDEID")) {
            if (PSModelFolderKeyHelper.registerPSModelKeySeq("PSDEDQCODE", "PSDEDQID")) {
                if (PSModelFolderKeyHelper.registerPSModelKeySeq("PSDEDQCODECOND", "PSDEDQCODEID")) {
                    // empty if block
                }
                if (PSModelFolderKeyHelper.registerPSModelKeySeq("PSDEDQCODEEXP", "PSDEDQCODEID")) {
                    // empty if block
                }
            }
            if (!PSModelFolderKeyHelper.registerPSModelKeySeq("PSDEDQJOIN", "PSDEDQID") || PSModelFolderKeyHelper.registerPSModelKeySeq("PSDEDQCOND", "PSDEDQJOINID")) {
                // empty if block
            }
        }
        if (!PSModelFolderKeyHelper.registerPSModelKeySeq("PSDEDATARELATION", "PSDEID") || PSModelFolderKeyHelper.registerPSModelKeySeq("PSDEDRDETAIL", "PSDEDRID")) {
            // empty if block
        }
        if (PSModelFolderKeyHelper.registerPSModelKeySeq("PSDEDATASET", "PSDEID")) {
            if (PSModelFolderKeyHelper.registerPSModelKeySeq("PSDEDSDQ", "PSDEDATASETID")) {
                // empty if block
            }
            if (PSModelFolderKeyHelper.registerPSModelKeySeq("PSDEDSGRPPARAM", "PSDEDSID")) {
                // empty if block
            }
        }
        if (PSModelFolderKeyHelper.registerPSModelKeySeq("PSDEDATASYNC", "PSDEID")) {
            // empty if block
        }
        if (!PSModelFolderKeyHelper.registerPSModelKeySeq("PSDEDATAVIEW", "PSDEID") || PSModelFolderKeyHelper.registerPSModelKeySeq("PSDEDATAVIEWITEM", "PSDEDATAVIEWID")) {
            // empty if block
        }
        if (!PSModelFolderKeyHelper.registerPSModelKeySeq("PSDEDBINDEX", "PSDEID") || PSModelFolderKeyHelper.registerPSModelKeySeq("PSDEDBIDXFIELD", "PSDEDBINDEXID")) {
            // empty if block
        }
        if (PSModelFolderKeyHelper.registerPSModelKeySeq("PSDEDRGROUP", "PSDEID")) {
            // empty if block
        }
        if (PSModelFolderKeyHelper.registerPSModelKeySeq("PSDEDRITEM", "PSDEID")) {
            // empty if block
        }
        if (PSModelFolderKeyHelper.registerPSModelKeySeq("PSDEDTSQUEUE", "PSDEID")) {
            // empty if block
        }
        if (!PSModelFolderKeyHelper.registerPSModelKeySeq("PSDEFGROUP", "PSDEID") || PSModelFolderKeyHelper.registerPSModelKeySeq("PSDEFGROUPDETAIL", "PSDEFGROUPID")) {
            // empty if block
        }
        if (PSModelFolderKeyHelper.registerPSModelKeySeq("PSDEFIELD", "PSDEID")) {
            if (PSModelFolderKeyHelper.registerPSModelKeySeq("PSDEFFORMITEM", "PSDEFID")) {
                // empty if block
            }
            if (PSModelFolderKeyHelper.registerPSModelKeySeq("PSDEFINPUTTIP", "PSDEFID")) {
                // empty if block
            }
            if (PSModelFolderKeyHelper.registerPSModelKeySeq("PSDEFSFITEM", "PSDEFID")) {
                // empty if block
            }
            if (!PSModelFolderKeyHelper.registerPSModelKeySeq("PSDEFVALUERULE", "PSDEFID") || PSModelFolderKeyHelper.registerPSModelKeySeq("PSDEFVRCOND", "PSDEFVRID")) {
                // empty if block
            }
        }
        if (PSModelFolderKeyHelper.registerPSModelKeySeq("PSDEFORM", "PSDEID")) {
            if (!PSModelFolderKeyHelper.registerPSModelKeySeq("PSDEFIUPDATE", "PSDEFORMID") || PSModelFolderKeyHelper.registerPSModelKeySeq("PSDEFIUDETAIL", "PSDEFIUPDATEID")) {
                // empty if block
            }
            if (PSModelFolderKeyHelper.registerPSModelKeySeq("PSDEFIVR", "PSDEFORMID")) {
                // empty if block
            }
            if (!PSModelFolderKeyHelper.registerPSModelKeySeq("PSDEFORMDETAIL", "PSDEFORMID") || PSModelFolderKeyHelper.registerPSModelKeySeq("PSDEFDLOGIC", "PSDEFORMDETAILID")) {
                // empty if block
            }
            if (PSModelFolderKeyHelper.registerPSModelKeySeq("PSDEFORMRF", "MAJORPSDEFORMID")) {
                // empty if block
            }
        }
        if (PSModelFolderKeyHelper.registerPSModelKeySeq("PSDEGRID", "PSDEID")) {
            if (!PSModelFolderKeyHelper.registerPSModelKeySeq("PSDEGEIUPDATE", "PSDEGRIDID") || PSModelFolderKeyHelper.registerPSModelKeySeq("PSDEGEIUDETAIL", "PSDEGEIUPDATEID")) {
                // empty if block
            }
            if (PSModelFolderKeyHelper.registerPSModelKeySeq("PSDEGRIDCOL", "PSDEGRIDID")) {
                // empty if block
            }
        }
        if (!PSModelFolderKeyHelper.registerPSModelKeySeq("PSDELIST", "PSDEID") || PSModelFolderKeyHelper.registerPSModelKeySeq("PSDELISTITEM", "PSDELISTID")) {
            // empty if block
        }
        if (PSModelFolderKeyHelper.registerPSModelKeySeq("PSDELOGIC", "PSDEID")) {
            if (!PSModelFolderKeyHelper.registerPSModelKeySeq("PSDELOGICLINK", "PSDELOGICID") || PSModelFolderKeyHelper.registerPSModelKeySeq("PSDELLCOND", "PSDELOGICLINKID")) {
                // empty if block
            }
            if (!PSModelFolderKeyHelper.registerPSModelKeySeq("PSDELOGICNODE", "PSDELOGICID") || PSModelFolderKeyHelper.registerPSModelKeySeq("PSDELNPARAM", "PSDELOGICNODEID")) {
                // empty if block
            }
            if (PSModelFolderKeyHelper.registerPSModelKeySeq("PSDELOGICPARAM", "PSDELOGICID")) {
                // empty if block
            }
        }
        if (PSModelFolderKeyHelper.registerPSModelKeySeq("PSDEMAINSTATE", "PSDEID")) {
            if (PSModelFolderKeyHelper.registerPSModelKeySeq("PSDEMSACTION", "PSDEMSID")) {
                // empty if block
            }
            if (PSModelFolderKeyHelper.registerPSModelKeySeq("PSDEMSOPPRIV", "PSDEMAINSTATEID")) {
                // empty if block
            }
        }
        if (PSModelFolderKeyHelper.registerPSModelKeySeq("PSDEMAP", "PSDEID")) {
            // empty if block
        }
        if (PSModelFolderKeyHelper.registerPSModelKeySeq("PSDEOPPRIVROLE", "PSDEID")) {
            // empty if block
        }
        if (!PSModelFolderKeyHelper.registerPSModelKeySeq("PSDEOPPRIV", "PSDEID") || PSModelFolderKeyHelper.registerPSModelKeySeq("PSDEOPPRIV_SYS", "PSSYSTEMID")) {
            // empty if block
        }
        if (PSModelFolderKeyHelper.registerPSModelKeySeq("PSDEPRINT", "PSDEID")) {
            // empty if block
        }
        if (!PSModelFolderKeyHelper.registerPSModelKeySeq("PSDEREPORT", "PSDEID") || PSModelFolderKeyHelper.registerPSModelKeySeq("PSDEREPITEM", "MAJORPSDEREPORTID")) {
            // empty if block
        }
        if (!PSModelFolderKeyHelper.registerPSModelKeySeq("PSDERGROUP", "PSSYSTEMID") || PSModelFolderKeyHelper.registerPSModelKeySeq("PSDERGROUPDETAIL", "PSDERGROUPID")) {
            // empty if block
        }
        if (!PSModelFolderKeyHelper.registerPSModelKeySeq("PSDER", "PSSYSTEMID") || PSModelFolderKeyHelper.registerPSModelKeySeq("PSDERDEFMAP", "PSDERID")) {
            // empty if block
        }
        if (PSModelFolderKeyHelper.registerPSModelKeySeq("PSDETABLE", "PSDEID")) {
            // empty if block
        }
        if (PSModelFolderKeyHelper.registerPSModelKeySeq("PSDETOOLBAR", "PSDEID")) {
            if (PSModelFolderKeyHelper.registerPSModelKeySeq("PSDETOOLBAR_SYS", "PSSYSTEMID")) {
                // empty if block
            }
            if (PSModelFolderKeyHelper.registerPSModelKeySeq("PSDETBITEM", "PSDETOOLBARID")) {
                // empty if block
            }
        }
        if (PSModelFolderKeyHelper.registerPSModelKeySeq("PSDETREEVIEW", "PSSYSTEMID")) {
            if (PSModelFolderKeyHelper.registerPSModelKeySeq("PSDETREECOL", "PSDETREEVIEWID")) {
                // empty if block
            }
            if (PSModelFolderKeyHelper.registerPSModelKeySeq("PSDETREENODERS", "PSDETREEVIEWID")) {
                // empty if block
            }
            if (PSModelFolderKeyHelper.registerPSModelKeySeq("PSDETREENODE", "PSDETREEVIEWID")) {
                if (PSModelFolderKeyHelper.registerPSModelKeySeq("PSDETREENODERV", "PSDETREENODEID")) {
                    // empty if block
                }
                if (PSModelFolderKeyHelper.registerPSModelKeySeq("PSDETREENODECOL", "PSDETREENODEID")) {
                    // empty if block
                }
            }
        }
        if (PSModelFolderKeyHelper.registerPSModelKeySeq("PSDEUAGROUP", "PSDEID")) {
            if (PSModelFolderKeyHelper.registerPSModelKeySeq("PSDEUAGROUP_SYS", "PSSYSTEMID")) {
                // empty if block
            }
            if (PSModelFolderKeyHelper.registerPSModelKeySeq("PSDEUAGRPDETAIL", "PSDEUAGROUPID")) {
                // empty if block
            }
        }
        if (!PSModelFolderKeyHelper.registerPSModelKeySeq("PSDEUIACTION", "PSDEID") || PSModelFolderKeyHelper.registerPSModelKeySeq("PSDEUIACTION_SYS", "PSSYSTEMID")) {
            // empty if block
        }
        if (PSModelFolderKeyHelper.registerPSModelKeySeq("PSDEUSERROLE", "PSDEID")) {
            // empty if block
        }
        if (PSModelFolderKeyHelper.registerPSModelKeySeq("PSDEUTILDE", "PSDEID")) {
            // empty if block
        }
        if (PSModelFolderKeyHelper.registerPSModelKeySeq("PSDEVIEWBASE", "PSDEID")) {
            if (PSModelFolderKeyHelper.registerPSModelKeySeq("PSDEVIEWCTRL", "PSDEVIEWBASEID")) {
                // empty if block
            }
            if (PSModelFolderKeyHelper.registerPSModelKeySeq("PSDEVIEWLOGIC", "PSDEVIEWBASEID")) {
                // empty if block
            }
            if (PSModelFolderKeyHelper.registerPSModelKeySeq("PSDEVIEWRV", "MAJORPSDEVIEWID")) {
                // empty if block
            }
            if (PSModelFolderKeyHelper.registerPSModelKeySeq("PSDEVIEWSERVICE", "PSDEVIEWBASEID")) {
                // empty if block
            }
        }
        if (PSModelFolderKeyHelper.registerPSModelKeySeq("PSDEWIZARD", "PSDEID")) {
            if (PSModelFolderKeyHelper.registerPSModelKeySeq("PSDEWIZARDFORM", "PSDEWIZARDID")) {
                // empty if block
            }
            if (PSModelFolderKeyHelper.registerPSModelKeySeq("PSDEWIZARDSTEP", "PSDEWIZARDID")) {
                // empty if block
            }
        }
        if (PSModelFolderKeyHelper.registerPSModelKeySeq("PSSYSBDTABLE", "PSSYSBDSCHEMEID")) {
            if (PSModelFolderKeyHelper.registerPSModelKeySeq("PSSYSBDCOLSET", "PSSYSBDTABLEID")) {
                // empty if block
            }
            if (PSModelFolderKeyHelper.registerPSModelKeySeq("PSSYSBDCOLUMN", "PSSYSBDTABLEID")) {
                // empty if block
            }
            if (PSModelFolderKeyHelper.registerPSModelKeySeq("PSSYSBDTABLEDER", "PSSYSBDTABLEID")) {
                // empty if block
            }
            if (PSModelFolderKeyHelper.registerPSModelKeySeq("PSSYSBDTABLEDE", "PSSYSBDTABLEID")) {
                // empty if block
            }
        }
        if (PSModelFolderKeyHelper.registerPSModelKeySeq("PSSYSCOUNTER", "PSSYSTEMID")) {
            // empty if block
        }
        if (!PSModelFolderKeyHelper.registerPSModelKeySeq("PSSYSDASHBOARD", "PSSYSTEMID") || PSModelFolderKeyHelper.registerPSModelKeySeq("PSSYSDBPART", "PSSYSDASHBOARDID")) {
            // empty if block
        }
        if (PSModelFolderKeyHelper.registerPSModelKeySeq("PSSYSPORTLET", "PSSYSTEMID")) {
            // empty if block
        }
        if (!PSModelFolderKeyHelper.registerPSModelKeySeq("PSSYSTESTDATA", "PSSYSTEMID") || PSModelFolderKeyHelper.registerPSModelKeySeq("PSSYSTDITEM", "PSSYSTESTDATAID")) {
            // empty if block
        }
        if (PSModelFolderKeyHelper.registerPSModelKeySeq("PSSYSVIEWPANEL", "PSSYSTEMID")) {
            if (PSModelFolderKeyHelper.registerPSModelKeySeq("PSPANELENGINE", "PSSYSVIEWPANELID")) {
                // empty if block
            }
            if (!PSModelFolderKeyHelper.registerPSModelKeySeq("PSSYSVIEWPANELITEM", "PSSYSVIEWPANELID") || PSModelFolderKeyHelper.registerPSModelKeySeq("PSPANELITEMLOGIC", "PSSYSVIEWPANELITEMID")) {
                // empty if block
            }
            if (PSModelFolderKeyHelper.registerPSModelKeySeq("PSSYSVIEWPANELLOGIC", "PSSYSVIEWPANELID")) {
                if (!PSModelFolderKeyHelper.registerPSModelKeySeq("PSPANELLOGICLINK", "PSSYSVIEWPANELLOGICID") || PSModelFolderKeyHelper.registerPSModelKeySeq("PSPANELLLCOND", "PSPANELLOGICLINKID")) {
                    // empty if block
                }
                if (!PSModelFolderKeyHelper.registerPSModelKeySeq("PSPANELLOGICNODE", "PSSYSVIEWPANELLOGICID") || PSModelFolderKeyHelper.registerPSModelKeySeq("PSPANELLNPARAM", "PSPANELLOGICNODEID")) {
                    // empty if block
                }
                if (PSModelFolderKeyHelper.registerPSModelKeySeq("PSPANELLOGICPARAM", "PSSYSVIEWPANELLOGICID")) {
                    // empty if block
                }
            }
            if (PSModelFolderKeyHelper.registerPSModelKeySeq("PSSYSVIEWPANELMODEL", "PSSYSVIEWPANELID")) {
                // empty if block
            }
        }
        if (PSModelFolderKeyHelper.registerPSModelKeySeq("PSAPPFUNC", "PSSYSAPPID")) {
            // empty if block
        }
        if (PSModelFolderKeyHelper.registerPSModelKeySeq("PSAPPLOCALDE", "PSSYSAPPID")) {
            // empty if block
        }
        if (!PSModelFolderKeyHelper.registerPSModelKeySeq("PSAPPMENU", "PSSYSAPPID") || PSModelFolderKeyHelper.registerPSModelKeySeq("PSAPPMENUITEM", "PSAPPMENUID")) {
            // empty if block
        }
        if (PSModelFolderKeyHelper.registerPSModelKeySeq("PSAPPMODULE", "PSSYSAPPID")) {
            // empty if block
        }
        if (PSModelFolderKeyHelper.registerPSModelKeySeq("PSAPPPDTVIEW", "PSSYSAPPID")) {
            // empty if block
        }
        if (PSModelFolderKeyHelper.registerPSModelKeySeq("PSAPPPKG", "PSSYSAPPID")) {
            // empty if block
        }
        if (PSModelFolderKeyHelper.registerPSModelKeySeq("PSAPPTITLEBAR", "PSSYSAPPID")) {
            // empty if block
        }
        if (PSModelFolderKeyHelper.registerPSModelKeySeq("PSAPPUISTYLE", "PSSYSAPPID")) {
            // empty if block
        }
        if (PSModelFolderKeyHelper.registerPSModelKeySeq("PSAPPUITHEME", "PSSYSAPPID")) {
            // empty if block
        }
        if (PSModelFolderKeyHelper.registerPSModelKeySeq("PSAPPUSERMODE", "PSSYSAPPID")) {
            // empty if block
        }
        if (PSModelFolderKeyHelper.registerPSModelKeySeq("PSAPPUTILPAGE", "PSSYSAPPID")) {
            // empty if block
        }
        if (PSModelFolderKeyHelper.registerPSModelKeySeq("PSAPPUTIL", "PSSYSAPPID")) {
            // empty if block
        }
        if (PSModelFolderKeyHelper.registerPSModelKeySeq("PSAPPVIEWSTYLE", "PSSYSAPPID")) {
            // empty if block
        }
        if (PSModelFolderKeyHelper.registerPSModelKeySeq("PSAPPVIEW", "PSSYSAPPID")) {
            // empty if block
        }
        if (PSModelFolderKeyHelper.registerPSModelKeySeq("PSAPPLAN", "PSSYSAPPID")) {
            // empty if block
        }
        if (PSModelFolderKeyHelper.registerPSModelKeySeq("PSMOBAPPSTARTPAGE", "PSSYSAPPID")) {
            // empty if block
        }
        if (PSModelFolderKeyHelper.registerPSModelKeySeq("PSWFVERSION", "PSWFID")) {
            if (PSModelFolderKeyHelper.registerPSModelKeySeq("PSWFLINK", "PSWFVERSIONID")) {
                if (PSModelFolderKeyHelper.registerPSModelKeySeq("PSWFLINKCOND", "PSWFLINKID")) {
                    // empty if block
                }
                if (PSModelFolderKeyHelper.registerPSModelKeySeq("PSWFLINKROLE", "PSWFLINKID")) {
                    // empty if block
                }
            }
            if (PSModelFolderKeyHelper.registerPSModelKeySeq("PSWFPROCESS", "PSWFVERSIONID")) {
                if (PSModelFolderKeyHelper.registerPSModelKeySeq("PSWFPROCPARAM", "PSWFPROCESSID")) {
                    // empty if block
                }
                if (PSModelFolderKeyHelper.registerPSModelKeySeq("PSWFPROCROLE", "PSWFPROCESSID")) {
                    // empty if block
                }
                if (PSModelFolderKeyHelper.registerPSModelKeySeq("PSWFPROCSUBWF", "PSWFPROCESSID")) {
                    // empty if block
                }
            }
        }
        ignoreModelKeySeqMap.put("PSSYSTEM", "");
        ignoreModelKeySeqMap.put("PSSYSTEMDBCFG", "");
        ignoreModelKeySeqMap.put("PSDEVSLNSYS", "");
        ignoreModelKeySeqMap.put("PSMODELSEQ", "");
        ignoreModelKeySeqMap.put("PSDEVUSERRECENT", "");
        sysModelCatMap.put("PSDATAENTITY", "D");
        sysModelCatMap.put("PSSYSAPP", "A");
        sysModelCatMap.put("PSWORKFLOW", "W");
        sysModelCatMap.put("PSSYSBDSCHEME", "B");
        sysModelCatMap.put("PSSYSSERVICEAPI", "I");
        sysModelCatMap.put("PSWXACCOUNT", "UW");
    }
}

