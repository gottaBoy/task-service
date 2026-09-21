/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.core.IDEDataQueryCodeCond
 *  net.ibizsys.paas.core.IDEDataQueryCodeExp
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.service.SessionFactoryManager
 *  net.ibizsys.paas.web.IWebContext
 *  net.ibizsys.paas.web.WebContext
 *  net.ibizsys.paas.web.util.SimpleWebContext
 *  net.ibizsys.pscore.srv.PSCoreSysServiceBase
 *  net.ibizsys.pscore.srv.dedesign.entity.PSDEDQCode
 *  net.ibizsys.pscore.srv.dedesign.entity.PSDEDQCodeBase
 *  net.ibizsys.pscore.srv.dedesign.entity.PSDEDQCodeCond
 *  net.ibizsys.pscore.srv.dedesign.entity.PSDEDQCodeExp
 *  net.ibizsys.pscore.srv.dedesign.service.PSDEDQCodeCondService
 *  net.ibizsys.pscore.srv.dedesign.service.PSDEDQCodeExpService
 *  net.ibizsys.pscore.srv.dedesign.service.PSDEDQCodeService
 *  net.ibizsys.pscore.srv.util.PSSysModelInstGlobal
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package SA.SRFDA.PS.Core.DataEntity.DS;

import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDQCodePublisher;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDQEngine;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataQuery;
import SA.SRFDA.PS.Core.DataEntity.DS.PSDEDQAlias;
import SA.SRFDA.PS.Core.Database.IPSDBType;
import SA.SRFDA.PS.Core.Database.PSDBCodePublisherImpl;
import SA.SRFDA.PS.Core.Database.PSDBTypeImpl;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.Pub.IPSPublisherContext;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Utility.StringHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import net.ibizsys.paas.core.IDEDataQueryCodeCond;
import net.ibizsys.paas.core.IDEDataQueryCodeExp;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.service.SessionFactoryManager;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.WebContext;
import net.ibizsys.paas.web.util.SimpleWebContext;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDQCode;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDQCodeBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDQCodeCond;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDQCodeExp;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDQCodeCondService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDQCodeExpService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDQCodeService;
import net.ibizsys.pscore.srv.util.PSSysModelInstGlobal;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

@PSModelIgnoreMeta
public class PSDEDQCodePublisherImpl
extends PSDBCodePublisherImpl
implements IPSDEDQCodePublisher {
    private static final Log log = LogFactory.getLog(PSDEDQCodePublisherImpl.class);
    protected IPSPublisherContext iPSPublisherContext = null;
    protected IPSDEDataQuery iPSDEDataQuery = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDBType iPSDBType) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setPSDBType(iPSDBType);
        this.onInit();
    }

    @Override
    public void generateCode(IPSPublisherContext iPSPublisherContext, IPSDEDataQuery iPSDEDataQuery) throws Exception {
        this.iPSPublisherContext = iPSPublisherContext;
        this.iPSDEDataQuery = iPSDEDataQuery;
        this.onGenerateCode();
    }

    protected void onGenerateCode() throws Exception {
        PSCoreSysServiceBase.setCurrentPSSystemId((String)this.iPSDEDataQuery.getPSDataEntity().getPSSystem().getId());
        if (WebContext.getCurrent() == null) {
            SimpleWebContext simpleWebContext = new SimpleWebContext();
            simpleWebContext.setSessionValue("SRFPERSONID", (Object)"SYSTEM");
            simpleWebContext.setSessionValue("SRFLOGINNAME", (Object)"SYSTEM");
            WebContext.setCurrent((IWebContext)simpleWebContext);
        }
        if (this.iPSDEDataQuery.isCustomCode()) {
            SessionFactoryManager.addRef();
            try {
                PSDEDQCode psDEDQCode = new PSDEDQCode();
                psDEDQCode.setPSDEDQId(this.iPSDEDataQuery.getId());
                psDEDQCode.setDBType(this.getPSDBType().getId());
                psDEDQCode.setPSDEDQCodeName(this.getPSDBType().getName());
                PSDEDQCodeService psDEDQCodeService = (PSDEDQCodeService)ServiceGlobal.getService(PSDEDQCodeService.class, (SessionFactory)PSSysModelInstGlobal.getSessionFactory((String)this.getPSSysModelInstId()));
                psDEDQCodeService.save((IEntity)psDEDQCode, false);
                SessionFactoryManager.releaseRef((boolean)true);
            }
            catch (Exception ex) {
                SessionFactoryManager.releaseRef((boolean)false);
                throw ex;
            }
        }
        IPSDEDQEngine iPSDEDQEngine = this.iPSDEDataQuery.getPSDEDQEngine(this.getPSDBType().getId());
        SessionFactoryManager.addRef();
        try {
            String strKey;
            PSDEDQCodeService psDEDQCodeService = (PSDEDQCodeService)ServiceGlobal.getService(PSDEDQCodeService.class, (SessionFactory)PSSysModelInstGlobal.getSessionFactory((String)this.getPSSysModelInstId()));
            PSDEDQCode psDEDQCode = new PSDEDQCode();
            psDEDQCode.setPSDEDQId(this.iPSDEDataQuery.getId());
            psDEDQCode.setDBType(this.getPSDBType().getId());
            psDEDQCodeService.fillEntityKeyValue((IEntity)psDEDQCode);
            boolean bGet = psDEDQCodeService.get((IEntity)psDEDQCode, true);
            if (!bGet || StringHelper.Compare((String)psDEDQCode.getPSDEDQCodeName(), (String)this.getPSDBType().getName(), (boolean)false) != 0 || PSDBTypeImpl.compareSQL(psDEDQCode.getQueryCode(), iPSDEDQEngine.getQueryScript()) != 0 || PSDBTypeImpl.compareSQL(psDEDQCode.getQueryCodeTemp(), iPSDEDQEngine.getQueryScriptTemp()) != 0) {
                Iterator<Object> aliasNames;
                PSDEDQCodeExpService psDEDQCodeExpService = (PSDEDQCodeExpService)ServiceGlobal.getService(PSDEDQCodeExpService.class, (SessionFactory)PSSysModelInstGlobal.getSessionFactory((String)this.getPSSysModelInstId()));
                psDEDQCode.setDBType(this.getPSDBType().getId());
                psDEDQCode.setPSDEDQCodeName(this.getPSDBType().getName());
                psDEDQCode.setQueryCode(iPSDEDQEngine.getQueryScript());
                psDEDQCode.setQueryCodeTemp(iPSDEDQEngine.getQueryScriptTemp());
                if (bGet) {
                    psDEDQCodeService.update((IEntity)psDEDQCode, false);
                } else {
                    psDEDQCodeService.create((IEntity)psDEDQCode, false);
                }
                ArrayList psDEDataQueryCodeExpList = psDEDQCodeExpService.selectByPSDEDQCode((PSDEDQCodeBase)psDEDQCode);
                HashMap<String, PSDEDQCodeExp> psDEDataQueryCodeExpMap = new HashMap<String, PSDEDQCodeExp>();
                for (PSDEDQCodeExp psDEDQCodeExp : psDEDataQueryCodeExpList) {
                    strKey = StringHelper.Format((String)"%1$s|%2$s", (Object)psDEDQCodeExp.getPSDEDQCodeId(), (Object)psDEDQCodeExp.getPSDEDQCodeExpName());
                    psDEDataQueryCodeExpMap.put(strKey, psDEDQCodeExp);
                }
                Iterator<IDEDataQueryCodeExp> deDataQueryExps = iPSDEDQEngine.getDEDataQueryCodeExps();
                if (deDataQueryExps != null) {
                    while (deDataQueryExps.hasNext()) {
                        IDEDataQueryCodeExp iDEDQCodeExp = deDataQueryExps.next();
                        PSDEDQCodeExp psDEDQCodeExp = new PSDEDQCodeExp();
                        psDEDQCodeExp.setPSDEDQCodeExpName(iDEDQCodeExp.getName());
                        psDEDQCodeExp.setPSDEDQCodeId(psDEDQCode.getPSDEDQCodeId());
                        psDEDQCodeExp.setExpCode(iDEDQCodeExp.getExpression());
                        psDEDQCodeExp.setOrderValue(Integer.valueOf(iDEDQCodeExp.getShowOrder()));
                        try {
                            String strKey2 = StringHelper.Format((String)"%1$s|%2$s", (Object)psDEDQCodeExp.getPSDEDQCodeId(), (Object)psDEDQCodeExp.getPSDEDQCodeExpName());
                            PSDEDQCodeExp psDEDQCodeExp2 = (PSDEDQCodeExp)psDEDataQueryCodeExpMap.remove(strKey2);
                            if (psDEDQCodeExp2 == null) {
                                psDEDQCodeExpService.create((IEntity)psDEDQCodeExp, false);
                                continue;
                            }
                            if (StringHelper.Compare((String)psDEDQCodeExp.getExpCode(), (String)psDEDQCodeExp2.getExpCode(), (boolean)false) == 0 && psDEDQCodeExp.getOrderValue() == psDEDQCodeExp2.getOrderValue()) continue;
                            psDEDQCodeExp.setPSDEDQCodeExpId(psDEDQCodeExp2.getPSDEDQCodeExpId());
                            psDEDQCodeExpService.update((IEntity)psDEDQCodeExp, false);
                        }
                        catch (Exception ex) {
                            throw new Exception(StringHelper.Format((String)"\u63d2\u5165\u67e5\u8be2\u4ee3\u7801\u8868\u8fbe\u5f0f[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)iDEDQCodeExp.getName(), (Object)ex.getMessage()));
                        }
                    }
                }
                if ((aliasNames = iPSDEDQEngine.getPSDEDQAliasNames()) != null) {
                    while (aliasNames.hasNext()) {
                        Object psDEDQAlias;
                        String strAliasName = (String)aliasNames.next();
                        if (StringHelper.Compare((String)strAliasName, (String)"MAIN", (boolean)true) == 0 || (psDEDQAlias = iPSDEDQEngine.getPSDEDQAlias(strAliasName, true)) == null) continue;
                        String strExpName = String.format("ALIAS.%1$s", strAliasName.toUpperCase());
                        PSDEDQCodeExp psDEDQCodeExp = new PSDEDQCodeExp();
                        psDEDQCodeExp.setPSDEDQCodeExpName(strExpName);
                        psDEDQCodeExp.setPSDEDQCodeId(psDEDQCode.getPSDEDQCodeId());
                        psDEDQCodeExp.setExpCode(String.format("t%1$s", ((PSDEDQAlias)psDEDQAlias).getAliasIndex() + 1));
                        psDEDQCodeExp.setOrderValue(Integer.valueOf(10000 + ((PSDEDQAlias)psDEDQAlias).getAliasIndex()));
                        try {
                            String strKey3 = StringHelper.Format((String)"%1$s|%2$s", (Object)psDEDQCodeExp.getPSDEDQCodeId(), (Object)psDEDQCodeExp.getPSDEDQCodeExpName());
                            PSDEDQCodeExp psDEDQCodeExp2 = (PSDEDQCodeExp)psDEDataQueryCodeExpMap.remove(strKey3);
                            if (psDEDQCodeExp2 == null) {
                                psDEDQCodeExpService.create((IEntity)psDEDQCodeExp, false);
                                continue;
                            }
                            if (StringHelper.Compare((String)psDEDQCodeExp.getExpCode(), (String)psDEDQCodeExp2.getExpCode(), (boolean)false) == 0 && psDEDQCodeExp.getOrderValue() == psDEDQCodeExp2.getOrderValue()) continue;
                            psDEDQCodeExp.setPSDEDQCodeExpId(psDEDQCodeExp2.getPSDEDQCodeExpId());
                            psDEDQCodeExpService.update((IEntity)psDEDQCodeExp, false);
                        }
                        catch (Exception ex) {
                            throw new Exception(StringHelper.Format((String)"\u63d2\u5165\u67e5\u8be2\u4ee3\u7801\u8868\u8fbe\u5f0f[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)strExpName, (Object)ex.getMessage()));
                        }
                    }
                }
                for (PSDEDQCodeExp psDEDQCodeExp : psDEDataQueryCodeExpMap.values()) {
                    psDEDQCodeExpService.remove((IEntity)psDEDQCodeExp);
                }
            }
            PSDEDQCodeCondService psDEDQCodeCondService = (PSDEDQCodeCondService)ServiceGlobal.getService(PSDEDQCodeCondService.class, (SessionFactory)PSSysModelInstGlobal.getSessionFactory((String)this.getPSSysModelInstId()));
            ArrayList psDEDataQueryCodeCondList = psDEDQCodeCondService.selectByPSDEDQCode((PSDEDQCodeBase)psDEDQCode);
            HashMap<String, PSDEDQCodeCond> psDEDataQueryCodeCondMap = new HashMap<String, PSDEDQCodeCond>();
            for (PSDEDQCodeCond psDEDataQueryCodeCond : psDEDataQueryCodeCondList) {
                strKey = StringHelper.Format((String)"%1$s|%2$s", (Object)psDEDataQueryCodeCond.getCondCode(), (Object)psDEDataQueryCodeCond.getOrderValue());
                psDEDataQueryCodeCondMap.put(strKey, psDEDataQueryCodeCond);
            }
            int nOrder = 0;
            Iterator<IDEDataQueryCodeCond> deDataQueryConds = iPSDEDQEngine.getDEDataQueryCodeConds();
            if (deDataQueryConds != null) {
                while (deDataQueryConds.hasNext()) {
                    IDEDataQueryCodeCond iDEDQCodeCond = deDataQueryConds.next();
                    PSDEDQCodeCond psDEDQCodeCond = new PSDEDQCodeCond();
                    psDEDQCodeCond.setPSDEDQCodeId(psDEDQCode.getPSDEDQCodeId());
                    psDEDQCodeCond.setCondCode(iDEDQCodeCond.getCustomCond());
                    psDEDQCodeCond.setOrderValue(Integer.valueOf(nOrder));
                    ++nOrder;
                    String strKey4 = StringHelper.Format((String)"%1$s|%2$s", (Object)psDEDQCodeCond.getCondCode(), (Object)psDEDQCodeCond.getOrderValue());
                    if (psDEDataQueryCodeCondMap.remove(strKey4) != null) continue;
                    psDEDQCodeCondService.create((IEntity)psDEDQCodeCond, false);
                }
            }
            for (PSDEDQCodeCond psDEDQCodeCond : psDEDataQueryCodeCondMap.values()) {
                psDEDQCodeCondService.remove((IEntity)psDEDQCodeCond);
            }
            SessionFactoryManager.releaseRef((boolean)true);
        }
        catch (Exception ex) {
            SessionFactoryManager.releaseRef((boolean)false);
            throw ex;
        }
    }

    @Override
    public void close() {
        this.iPSPublisherContext = null;
        this.iPSDEDataQuery = null;
        this.onClose();
        this.getPSDBType().releasePSDEDQCodePublisher(this);
    }

    @Override
    public String getPSSysModelInstId() {
        if (this.iPSDEDataQuery != null) {
            return this.iPSDEDataQuery.getPSSysModelInstId();
        }
        return null;
    }
}

