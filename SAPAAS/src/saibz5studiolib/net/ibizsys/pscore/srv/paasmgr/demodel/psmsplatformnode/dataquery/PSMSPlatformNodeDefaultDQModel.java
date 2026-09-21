/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataQuery
 *  net.ibizsys.paas.core.DEDataQueryCode
 *  net.ibizsys.paas.core.DEDataQueryCodeExp
 *  net.ibizsys.paas.core.DEDataQueryCodes
 *  net.ibizsys.paas.demodel.DEDataQueryModelBase
 */
package net.ibizsys.pscore.srv.paasmgr.demodel.psmsplatformnode.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="53F0A120-A285-4295-B61B-BEAB6F38EE7F", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`IPADDR`, t1.`IPADDR2`, t1.`MEMO`, t1.`PASSWD`, t1.`PORT`, t1.`PSMSPLATFORMID`, t11.`PSMSPLATFORMNAME`, t1.`PSMSPLATFORMNODEID`, t1.`PSMSPLATFORMNODENAME`, t1.`SSHIPADDR`, t1.`SSHPORT`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`UPLOADFILEMODE`, t1.`UPLOADPATH`, t1.`USERNAME`, t1.`VALIDFLAG`, t1.`WORKSHOPPATH` FROM `T_SRFPSMSPLATFORMNODE` t1  LEFT JOIN T_SRFPSMSPLATFORM t11 ON t1.PSMSPLATFORMID = t11.PSMSPLATFORMID  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="IPADDR", expression="t1.`IPADDR`", showorder=2), @DEDataQueryCodeExp(name="IPADDR2", expression="t1.`IPADDR2`", showorder=3), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=4), @DEDataQueryCodeExp(name="PASSWD", expression="t1.`PASSWD`", showorder=5), @DEDataQueryCodeExp(name="PORT", expression="t1.`PORT`", showorder=6), @DEDataQueryCodeExp(name="PSMSPLATFORMID", expression="t1.`PSMSPLATFORMID`", showorder=7), @DEDataQueryCodeExp(name="PSMSPLATFORMNAME", expression="t11.`PSMSPLATFORMNAME`", showorder=8), @DEDataQueryCodeExp(name="PSMSPLATFORMNODEID", expression="t1.`PSMSPLATFORMNODEID`", showorder=9), @DEDataQueryCodeExp(name="PSMSPLATFORMNODENAME", expression="t1.`PSMSPLATFORMNODENAME`", showorder=10), @DEDataQueryCodeExp(name="SSHIPADDR", expression="t1.`SSHIPADDR`", showorder=11), @DEDataQueryCodeExp(name="SSHPORT", expression="t1.`SSHPORT`", showorder=12), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=13), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=14), @DEDataQueryCodeExp(name="UPLOADFILEMODE", expression="t1.`UPLOADFILEMODE`", showorder=15), @DEDataQueryCodeExp(name="UPLOADPATH", expression="t1.`UPLOADPATH`", showorder=16), @DEDataQueryCodeExp(name="USERNAME", expression="t1.`USERNAME`", showorder=17), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.`VALIDFLAG`", showorder=18), @DEDataQueryCodeExp(name="WORKSHOPPATH", expression="t1.`WORKSHOPPATH`", showorder=19)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.IPADDR, t1.IPADDR2, t1.MEMO, t1.PASSWD, t1.PORT, t1.PSMSPLATFORMID, t11.PSMSPLATFORMNAME, t1.PSMSPLATFORMNODEID, t1.PSMSPLATFORMNODENAME, t1.SSHIPADDR, t1.SSHPORT, t1.UPDATEDATE, t1.UPDATEMAN, t1.UPLOADFILEMODE, t1.UPLOADPATH, t1.USERNAME, t1.VALIDFLAG, t1.WORKSHOPPATH FROM T_SRFPSMSPLATFORMNODE t1  LEFT JOIN T_SRFPSMSPLATFORM t11 ON t1.PSMSPLATFORMID = t11.PSMSPLATFORMID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="IPADDR", expression="t1.IPADDR", showorder=2), @DEDataQueryCodeExp(name="IPADDR2", expression="t1.IPADDR2", showorder=3), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=4), @DEDataQueryCodeExp(name="PASSWD", expression="t1.PASSWD", showorder=5), @DEDataQueryCodeExp(name="PORT", expression="t1.PORT", showorder=6), @DEDataQueryCodeExp(name="PSMSPLATFORMID", expression="t1.PSMSPLATFORMID", showorder=7), @DEDataQueryCodeExp(name="PSMSPLATFORMNAME", expression="t11.PSMSPLATFORMNAME", showorder=8), @DEDataQueryCodeExp(name="PSMSPLATFORMNODEID", expression="t1.PSMSPLATFORMNODEID", showorder=9), @DEDataQueryCodeExp(name="PSMSPLATFORMNODENAME", expression="t1.PSMSPLATFORMNODENAME", showorder=10), @DEDataQueryCodeExp(name="SSHIPADDR", expression="t1.SSHIPADDR", showorder=11), @DEDataQueryCodeExp(name="SSHPORT", expression="t1.SSHPORT", showorder=12), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=13), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=14), @DEDataQueryCodeExp(name="UPLOADFILEMODE", expression="t1.UPLOADFILEMODE", showorder=15), @DEDataQueryCodeExp(name="UPLOADPATH", expression="t1.UPLOADPATH", showorder=16), @DEDataQueryCodeExp(name="USERNAME", expression="t1.USERNAME", showorder=17), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.VALIDFLAG", showorder=18), @DEDataQueryCodeExp(name="WORKSHOPPATH", expression="t1.WORKSHOPPATH", showorder=19)}, conds={})})
public class PSMSPlatformNodeDefaultDQModel
extends DEDataQueryModelBase {
    public PSMSPlatformNodeDefaultDQModel() {
        this.initAnnotation(PSMSPlatformNodeDefaultDQModel.class);
    }
}

