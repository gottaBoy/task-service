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
package net.ibizsys.pscore.srv.sysdeploy.demodel.psdepslnsysmq.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="2AD39A50-4F21-4817-B0C4-02B0A428A85D", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`MEMO`, t1.`PSDEPSLNID`, t1.`PSDEPSLNMQINSTID`, t11.`PSDEPSLNMQINSTNAME`, t21.`PSDEPSLNNAME`, t1.`PSDEPSLNSYSID`, t1.`PSDEPSLNSYSMQID`, t1.`PSDEPSLNSYSMQNAME`, t31.`PSDEPSLNSYSNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSDEPSLNSYSMQ` t1  LEFT JOIN T_SRFPSDEPSLNMQINST t11 ON t1.PSDEPSLNMQINSTID = t11.PSDEPSLNMQINSTID  LEFT JOIN T_SRFPSDEPSLN t21 ON t1.PSDEPSLNID = t21.PSDEPSLNID  LEFT JOIN T_SRFPSDEPSLNSYS t31 ON t1.PSDEPSLNSYSID = t31.PSDEPSLNSYSID  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=2), @DEDataQueryCodeExp(name="PSDEPSLNID", expression="t1.`PSDEPSLNID`", showorder=3), @DEDataQueryCodeExp(name="PSDEPSLNMQINSTID", expression="t1.`PSDEPSLNMQINSTID`", showorder=4), @DEDataQueryCodeExp(name="PSDEPSLNMQINSTNAME", expression="t11.`PSDEPSLNMQINSTNAME`", showorder=5), @DEDataQueryCodeExp(name="PSDEPSLNNAME", expression="t21.`PSDEPSLNNAME`", showorder=6), @DEDataQueryCodeExp(name="PSDEPSLNSYSID", expression="t1.`PSDEPSLNSYSID`", showorder=7), @DEDataQueryCodeExp(name="PSDEPSLNSYSMQID", expression="t1.`PSDEPSLNSYSMQID`", showorder=8), @DEDataQueryCodeExp(name="PSDEPSLNSYSMQNAME", expression="t1.`PSDEPSLNSYSMQNAME`", showorder=9), @DEDataQueryCodeExp(name="PSDEPSLNSYSNAME", expression="t31.`PSDEPSLNSYSNAME`", showorder=10), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=11), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=12)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.PSDEPSLNID, t1.PSDEPSLNMQINSTID, t11.PSDEPSLNMQINSTNAME, t21.PSDEPSLNNAME, t1.PSDEPSLNSYSID, t1.PSDEPSLNSYSMQID, t1.PSDEPSLNSYSMQNAME, t31.PSDEPSLNSYSNAME, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSDEPSLNSYSMQ t1  LEFT JOIN T_SRFPSDEPSLNMQINST t11 ON t1.PSDEPSLNMQINSTID = t11.PSDEPSLNMQINSTID  LEFT JOIN T_SRFPSDEPSLN t21 ON t1.PSDEPSLNID = t21.PSDEPSLNID  LEFT JOIN T_SRFPSDEPSLNSYS t31 ON t1.PSDEPSLNSYSID = t31.PSDEPSLNSYSID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=2), @DEDataQueryCodeExp(name="PSDEPSLNID", expression="t1.PSDEPSLNID", showorder=3), @DEDataQueryCodeExp(name="PSDEPSLNMQINSTID", expression="t1.PSDEPSLNMQINSTID", showorder=4), @DEDataQueryCodeExp(name="PSDEPSLNMQINSTNAME", expression="t11.PSDEPSLNMQINSTNAME", showorder=5), @DEDataQueryCodeExp(name="PSDEPSLNNAME", expression="t21.PSDEPSLNNAME", showorder=6), @DEDataQueryCodeExp(name="PSDEPSLNSYSID", expression="t1.PSDEPSLNSYSID", showorder=7), @DEDataQueryCodeExp(name="PSDEPSLNSYSMQID", expression="t1.PSDEPSLNSYSMQID", showorder=8), @DEDataQueryCodeExp(name="PSDEPSLNSYSMQNAME", expression="t1.PSDEPSLNSYSMQNAME", showorder=9), @DEDataQueryCodeExp(name="PSDEPSLNSYSNAME", expression="t31.PSDEPSLNSYSNAME", showorder=10), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=11), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=12)}, conds={})})
public class PSDepSlnSysMQDefaultDQModel
extends DEDataQueryModelBase {
    public PSDepSlnSysMQDefaultDQModel() {
        this.initAnnotation(PSDepSlnSysMQDefaultDQModel.class);
    }
}

