/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringBuilderEx
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.sysdesign.service;

import net.ibizsys.paas.util.StringBuilderEx;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSysRes;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysResServiceBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class PSDevSlnSysResService
extends PSDevSlnSysResServiceBase {
    private static final Log log = LogFactory.getLog(PSDevSlnSysResService.class);

    @Override
    protected void onBeforeCreate(PSDevSlnSysRes pSDevSlnSysRes) throws Exception {
        this.calcPSDevSlnSysResNameAndInfo(pSDevSlnSysRes);
        super.onBeforeCreate(pSDevSlnSysRes);
    }

    @Override
    protected void onBeforeUpdate(PSDevSlnSysRes pSDevSlnSysRes) throws Exception {
        this.calcPSDevSlnSysResNameAndInfo(pSDevSlnSysRes);
        super.onBeforeUpdate(pSDevSlnSysRes);
    }

    protected void calcPSDevSlnSysResNameAndInfo(PSDevSlnSysRes pSDevSlnSysRes) throws Exception {
        String string;
        StringBuilderEx stringBuilderEx = new StringBuilderEx();
        if (pSDevSlnSysRes.getPSDevCenterSVN() != null) {
            stringBuilderEx.append("[\u4ee3\u7801\u4ed3\u5e93]%1$s;", (Object)pSDevSlnSysRes.getPSDevCenterSVN().getPSDevCenterSVNName());
        }
        if (pSDevSlnSysRes.getResPos() == 1) {
            pSDevSlnSysRes.setPSDevSlnSysResName("\u5e73\u53f0\u8d44\u6e90\u6a21\u5f0f");
            if (pSDevSlnSysRes.getPSDevCenterAS() != null) {
                stringBuilderEx.append("[\u5e94\u7528\u5bb9\u5668]%1$s;", (Object)pSDevSlnSysRes.getPSDevCenterAS().getPSDevCenterASName());
            }
            if (pSDevSlnSysRes.getMySQLPSDCDBInst() != null) {
                stringBuilderEx.append("[MySQL\u5b9e\u4f8b]%1$s;", (Object)pSDevSlnSysRes.getMySQLPSDCDBInst().getPSDevCenterDBInstName());
            }
            if (pSDevSlnSysRes.getMSSqlPSDCDBInst() != null) {
                stringBuilderEx.append("[SqlServer\u5b9e\u4f8b]%1$s;", (Object)pSDevSlnSysRes.getMSSqlPSDCDBInst().getPSDevCenterDBInstName());
            }
            if (pSDevSlnSysRes.getOraPSDCDBInst() != null) {
                stringBuilderEx.append("[Oracle\u5b9e\u4f8b]%1$s;", (Object)pSDevSlnSysRes.getOraPSDCDBInst().getPSDevCenterDBInstName());
            }
            if (pSDevSlnSysRes.getDB2PSDCDBInst() != null) {
                stringBuilderEx.append("[DB2\u5b9e\u4f8b]%1$s;", (Object)pSDevSlnSysRes.getDB2PSDCDBInst().getPSDevCenterDBInstName());
            }
            if (pSDevSlnSysRes.getPGSQLPSDCDBInst() != null) {
                stringBuilderEx.append("[PGSQL\u5b9e\u4f8b]%1$s;", (Object)pSDevSlnSysRes.getPGSQLPSDCDBInst().getPSDevCenterDBInstName());
            }
            if (pSDevSlnSysRes.getPPASPSDCDBInst() != null) {
                stringBuilderEx.append("[PPAS\u5b9e\u4f8b]%1$s;", (Object)pSDevSlnSysRes.getPPASPSDCDBInst().getPSDevCenterDBInstName());
            }
        } else {
            pSDevSlnSysRes.setPSDevSlnSysResName("\u7528\u6237\u81ea\u5efa\u8d44\u6e90\u6a21\u5f0f");
            if (pSDevSlnSysRes.getUPSDevCenterAS() != null) {
                stringBuilderEx.append("[\u5e94\u7528\u5bb9\u5668]%1$s;", (Object)pSDevSlnSysRes.getUPSDevCenterAS().getPSDevCenterASName());
            }
            if (pSDevSlnSysRes.getUMySQLPSDCDBInst() != null) {
                stringBuilderEx.append("[MySQL\u5b9e\u4f8b]%1$s;", (Object)pSDevSlnSysRes.getUMySQLPSDCDBInst().getPSDevCenterDBInstName());
            }
            if (pSDevSlnSysRes.getUMSSqlPSDCDBInst() != null) {
                stringBuilderEx.append("[SqlServer\u5b9e\u4f8b]%1$s;", (Object)pSDevSlnSysRes.getUMSSqlPSDCDBInst().getPSDevCenterDBInstName());
            }
            if (pSDevSlnSysRes.getUOraPSDCDBInst() != null) {
                stringBuilderEx.append("[Oracle\u5b9e\u4f8b]%1$s;", (Object)pSDevSlnSysRes.getUOraPSDCDBInst().getPSDevCenterDBInstName());
            }
            if (pSDevSlnSysRes.getUDB2PSDCDBInst() != null) {
                stringBuilderEx.append("[DB2\u5b9e\u4f8b]%1$s;", (Object)pSDevSlnSysRes.getUDB2PSDCDBInst().getPSDevCenterDBInstName());
            }
            if (pSDevSlnSysRes.getUPGSQLPSDCDBInst() != null) {
                stringBuilderEx.append("[PGSQL\u5b9e\u4f8b]%1$s;", (Object)pSDevSlnSysRes.getUPGSQLPSDCDBInst().getPSDevCenterDBInstName());
            }
            if (pSDevSlnSysRes.getUPPASPSDCDBInst() != null) {
                stringBuilderEx.append("[PPAS\u5b9e\u4f8b]%1$s;", (Object)pSDevSlnSysRes.getUPPASPSDCDBInst().getPSDevCenterDBInstName());
            }
        }
        if ((string = stringBuilderEx.toString()).length() > 1000) {
            string = string.substring(0, 995);
            string = string + "...";
        }
        pSDevSlnSysRes.setResInfo(string);
    }

    @Override
    protected void onAfterUpdate(PSDevSlnSysRes pSDevSlnSysRes) throws Exception {
        super.onAfterUpdate(pSDevSlnSysRes);
    }
}

