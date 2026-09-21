/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.IServiceWork
 *  net.ibizsys.paas.service.ITransaction
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.StringBuilderEx
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.devcenter.service;

import java.util.ArrayList;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.IServiceWork;
import net.ibizsys.paas.service.ITransaction;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.StringBuilderEx;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCBDInst;
import net.ibizsys.pscore.srv.devcenter.service.PSDCBDInstServiceBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysVerService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
public class PSDCBDInstService
extends PSDCBDInstServiceBase {
    private static final Log log = LogFactory.getLog(PSDCBDInstService.class);

    public void calcRefInfo(PSDCBDInst pSDCBDInst) throws Exception {
        final PSDCBDInst pSDCBDInst2 = pSDCBDInst;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (!pSDCBDInst2.isFullEntity()) {
                    PSDCBDInstService.this.get((IEntity)pSDCBDInst2);
                }
                PSDCBDInstService.this.onCalcRefInfo(pSDCBDInst2);
            }
        });
    }

    protected void onCalcRefInfo(PSDCBDInst pSDCBDInst) throws Exception {
        PSDevSlnSysService pSDevSlnSysService = (PSDevSlnSysService)ServiceGlobal.getService(PSDevSlnSysService.class, (SessionFactory)this.getSessionFactory());
        PSDevSlnSysVerService pSDevSlnSysVerService = (PSDevSlnSysVerService)ServiceGlobal.getService(PSDevSlnSysVerService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDevSlnSys> arrayList = null;
        Object var5_5 = null;
        if (StringHelper.compare((String)pSDCBDInst.getBDType(), (String)"HBASE", (boolean)true) == 0) {
            arrayList = pSDevSlnSysService.selectByHBasePSDCDBInst(pSDCBDInst);
        }
        int n = 0;
        StringBuilderEx stringBuilderEx = new StringBuilderEx();
        if (arrayList != null) {
            n += arrayList.size();
            for (PSDevSlnSys pSDevSlnSys : arrayList) {
                stringBuilderEx.append("[\u7cfb\u7edf][%1$s/%2$s]\r\n", (Object)pSDevSlnSys.getPSDevSlnName(), (Object)pSDevSlnSys.getPSDevSlnSysName());
            }
        }
        pSDCBDInst.setRefCount(n);
        pSDCBDInst.setRefInfo(stringBuilderEx.toString());
        this.update(pSDCBDInst);
    }
}

