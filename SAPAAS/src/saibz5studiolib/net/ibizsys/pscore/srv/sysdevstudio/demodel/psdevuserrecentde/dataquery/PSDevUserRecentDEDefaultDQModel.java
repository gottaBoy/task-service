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
package net.ibizsys.pscore.srv.sysdevstudio.demodel.psdevuserrecentde.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="C7684280-2936-478D-B7FA-E8B527174CF0", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t11.`LOGICNAME`, t1.`OBJID`, t1.`OBJTYPE`, t11.`PSDATAENTITYNAME`, t1.`PSDEVUSERID`, t1.`PSDEVUSERRECENTID`, t1.`PSDEVUSERRECENTNAME`, t1.`UPDATEDATE` FROM `T_SRFPSDEVUSERRECENT` t1  LEFT JOIN T_SRFPSDATAENTITY t11 ON t1.OBJID = t11.PSDATAENTITYID  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="LOGICNAME", expression="t11.`LOGICNAME`", showorder=0), @DEDataQueryCodeExp(name="OBJID", expression="t1.`OBJID`", showorder=1), @DEDataQueryCodeExp(name="OBJTYPE", expression="t1.`OBJTYPE`", showorder=2), @DEDataQueryCodeExp(name="PSDATAENTITYNAME", expression="t11.`PSDATAENTITYNAME`", showorder=3), @DEDataQueryCodeExp(name="PSDEVUSERID", expression="t1.`PSDEVUSERID`", showorder=4), @DEDataQueryCodeExp(name="PSDEVUSERRECENTID", expression="t1.`PSDEVUSERRECENTID`", showorder=5), @DEDataQueryCodeExp(name="PSDEVUSERRECENTNAME", expression="t1.`PSDEVUSERRECENTNAME`", showorder=6), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=7)}, conds={}), @DEDataQueryCode(querycode="SELECT t11.LOGICNAME, t1.OBJID, t1.OBJTYPE, t11.PSDATAENTITYNAME, t1.PSDEVUSERID, t1.PSDEVUSERRECENTID, t1.PSDEVUSERRECENTNAME, t1.UPDATEDATE FROM T_SRFPSDEVUSERRECENT t1  LEFT JOIN T_SRFPSDATAENTITY t11 ON t1.OBJID = t11.PSDATAENTITYID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="LOGICNAME", expression="t11.LOGICNAME", showorder=0), @DEDataQueryCodeExp(name="OBJID", expression="t1.OBJID", showorder=1), @DEDataQueryCodeExp(name="OBJTYPE", expression="t1.OBJTYPE", showorder=2), @DEDataQueryCodeExp(name="PSDATAENTITYNAME", expression="t11.PSDATAENTITYNAME", showorder=3), @DEDataQueryCodeExp(name="PSDEVUSERID", expression="t1.PSDEVUSERID", showorder=4), @DEDataQueryCodeExp(name="PSDEVUSERRECENTID", expression="t1.PSDEVUSERRECENTID", showorder=5), @DEDataQueryCodeExp(name="PSDEVUSERRECENTNAME", expression="t1.PSDEVUSERRECENTNAME", showorder=6), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=7)}, conds={})})
public class PSDevUserRecentDEDefaultDQModel
extends DEDataQueryModelBase {
    public PSDevUserRecentDEDefaultDQModel() {
        this.initAnnotation(PSDevUserRecentDEDefaultDQModel.class);
    }
}

