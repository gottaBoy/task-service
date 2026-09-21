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
package net.ibizsys.pscore.srv.sysdeploy.demodel.psdepslnwfengineinst.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="562A0841-CCFB-4367-8310-95521CADFB00", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`DEFAULTFLAG`, t1.`MEMO`, t1.`PSDCWFENGINEINSTID`, t11.`PSDCWFENGINEINSTNAME`, t1.`PSDEPSLNID`, t21.`PSDEPSLNNAME`, t1.`PSDEPSLNWFENGINEINSTID`, t1.`PSDEPSLNWFENGINEINSTNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSDEPSLNWFENGINEINST` t1  LEFT JOIN T_SRFPSDCWFENGINEINST t11 ON t1.PSDCWFENGINEINSTID = t11.PSDCWFENGINEINSTID  LEFT JOIN T_SRFPSDEPSLN t21 ON t1.PSDEPSLNID = t21.PSDEPSLNID  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="DEFAULTFLAG", expression="t1.`DEFAULTFLAG`", showorder=2), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=3), @DEDataQueryCodeExp(name="PSDCWFENGINEINSTID", expression="t1.`PSDCWFENGINEINSTID`", showorder=4), @DEDataQueryCodeExp(name="PSDCWFENGINEINSTNAME", expression="t11.`PSDCWFENGINEINSTNAME`", showorder=5), @DEDataQueryCodeExp(name="PSDEPSLNID", expression="t1.`PSDEPSLNID`", showorder=6), @DEDataQueryCodeExp(name="PSDEPSLNNAME", expression="t21.`PSDEPSLNNAME`", showorder=7), @DEDataQueryCodeExp(name="PSDEPSLNWFENGINEINSTID", expression="t1.`PSDEPSLNWFENGINEINSTID`", showorder=8), @DEDataQueryCodeExp(name="PSDEPSLNWFENGINEINSTNAME", expression="t1.`PSDEPSLNWFENGINEINSTNAME`", showorder=9), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=10), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=11)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.DEFAULTFLAG, t1.MEMO, t1.PSDCWFENGINEINSTID, t11.PSDCWFENGINEINSTNAME, t1.PSDEPSLNID, t21.PSDEPSLNNAME, t1.PSDEPSLNWFENGINEINSTID, t1.PSDEPSLNWFENGINEINSTNAME, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSDEPSLNWFENGINEINST t1  LEFT JOIN T_SRFPSDCWFENGINEINST t11 ON t1.PSDCWFENGINEINSTID = t11.PSDCWFENGINEINSTID  LEFT JOIN T_SRFPSDEPSLN t21 ON t1.PSDEPSLNID = t21.PSDEPSLNID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="DEFAULTFLAG", expression="t1.DEFAULTFLAG", showorder=2), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=3), @DEDataQueryCodeExp(name="PSDCWFENGINEINSTID", expression="t1.PSDCWFENGINEINSTID", showorder=4), @DEDataQueryCodeExp(name="PSDCWFENGINEINSTNAME", expression="t11.PSDCWFENGINEINSTNAME", showorder=5), @DEDataQueryCodeExp(name="PSDEPSLNID", expression="t1.PSDEPSLNID", showorder=6), @DEDataQueryCodeExp(name="PSDEPSLNNAME", expression="t21.PSDEPSLNNAME", showorder=7), @DEDataQueryCodeExp(name="PSDEPSLNWFENGINEINSTID", expression="t1.PSDEPSLNWFENGINEINSTID", showorder=8), @DEDataQueryCodeExp(name="PSDEPSLNWFENGINEINSTNAME", expression="t1.PSDEPSLNWFENGINEINSTNAME", showorder=9), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=10), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=11)}, conds={})})
public class PSDepSlnWFEngineInstDefaultDQModel
extends DEDataQueryModelBase {
    public PSDepSlnWFEngineInstDefaultDQModel() {
        this.initAnnotation(PSDepSlnWFEngineInstDefaultDQModel.class);
    }
}

