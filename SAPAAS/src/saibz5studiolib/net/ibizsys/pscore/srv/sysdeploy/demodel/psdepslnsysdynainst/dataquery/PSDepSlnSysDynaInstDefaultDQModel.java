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
package net.ibizsys.pscore.srv.sysdeploy.demodel.psdepslnsysdynainst.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="9543B96A-7DDA-42F1-8DD6-07F378E9E95B", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`INSTMODE`, t1.`MEMO`, t1.`PPSDEPSLNSYSDYNAINSTID`, t1.`PPSDEPSLNSYSDYNAINSTNAME`, t1.`PROXYPSDEPSLNSYSDYNAINSTID`, t1.`PROXYPSDEPSLNSYSDYNAINSTNAME`, t11.`PSDEPSLNID`, t1.`PSDEPSLNSYSDYNAINSTID`, t1.`PSDEPSLNSYSDYNAINSTNAME`, t1.`PSDEPSLNSYSID`, t11.`PSDEPSLNSYSNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`USERTAG`, t1.`USERTAG2`, t1.`VALIDFLAG` FROM `T_SRFPSDEPSLNSYSDYNAINST` t1  LEFT JOIN T_SRFPSDEPSLNSYS t11 ON t1.PSDEPSLNSYSID = t11.PSDEPSLNSYSID  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="INSTMODE", expression="t1.`INSTMODE`", showorder=2), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=3), @DEDataQueryCodeExp(name="PPSDEPSLNSYSDYNAINSTID", expression="t1.`PPSDEPSLNSYSDYNAINSTID`", showorder=4), @DEDataQueryCodeExp(name="PPSDEPSLNSYSDYNAINSTNAME", expression="t1.`PPSDEPSLNSYSDYNAINSTNAME`", showorder=5), @DEDataQueryCodeExp(name="PROXYPSDEPSLNSYSDYNAINSTID", expression="t1.`PROXYPSDEPSLNSYSDYNAINSTID`", showorder=6), @DEDataQueryCodeExp(name="PROXYPSDEPSLNSYSDYNAINSTNAME", expression="t1.`PROXYPSDEPSLNSYSDYNAINSTNAME`", showorder=7), @DEDataQueryCodeExp(name="PSDEPSLNID", expression="t11.`PSDEPSLNID`", showorder=8), @DEDataQueryCodeExp(name="PSDEPSLNSYSDYNAINSTID", expression="t1.`PSDEPSLNSYSDYNAINSTID`", showorder=9), @DEDataQueryCodeExp(name="PSDEPSLNSYSDYNAINSTNAME", expression="t1.`PSDEPSLNSYSDYNAINSTNAME`", showorder=10), @DEDataQueryCodeExp(name="PSDEPSLNSYSID", expression="t1.`PSDEPSLNSYSID`", showorder=11), @DEDataQueryCodeExp(name="PSDEPSLNSYSNAME", expression="t11.`PSDEPSLNSYSNAME`", showorder=12), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=13), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=14), @DEDataQueryCodeExp(name="USERTAG", expression="t1.`USERTAG`", showorder=15), @DEDataQueryCodeExp(name="USERTAG2", expression="t1.`USERTAG2`", showorder=16), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.`VALIDFLAG`", showorder=17)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.INSTMODE, t1.MEMO, t1.PPSDEPSLNSYSDYNAINSTID, t1.PPSDEPSLNSYSDYNAINSTNAME, t1.PROXYPSDEPSLNSYSDYNAINSTID, t1.PROXYPSDEPSLNSYSDYNAINSTNAME, t11.PSDEPSLNID, t1.PSDEPSLNSYSDYNAINSTID, t1.PSDEPSLNSYSDYNAINSTNAME, t1.PSDEPSLNSYSID, t11.PSDEPSLNSYSNAME, t1.UPDATEDATE, t1.UPDATEMAN, t1.USERTAG, t1.USERTAG2, t1.VALIDFLAG FROM T_SRFPSDEPSLNSYSDYNAINST t1  LEFT JOIN T_SRFPSDEPSLNSYS t11 ON t1.PSDEPSLNSYSID = t11.PSDEPSLNSYSID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="INSTMODE", expression="t1.INSTMODE", showorder=2), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=3), @DEDataQueryCodeExp(name="PPSDEPSLNSYSDYNAINSTID", expression="t1.PPSDEPSLNSYSDYNAINSTID", showorder=4), @DEDataQueryCodeExp(name="PPSDEPSLNSYSDYNAINSTNAME", expression="t1.PPSDEPSLNSYSDYNAINSTNAME", showorder=5), @DEDataQueryCodeExp(name="PROXYPSDEPSLNSYSDYNAINSTID", expression="t1.PROXYPSDEPSLNSYSDYNAINSTID", showorder=6), @DEDataQueryCodeExp(name="PROXYPSDEPSLNSYSDYNAINSTNAME", expression="t1.PROXYPSDEPSLNSYSDYNAINSTNAME", showorder=7), @DEDataQueryCodeExp(name="PSDEPSLNID", expression="t11.PSDEPSLNID", showorder=8), @DEDataQueryCodeExp(name="PSDEPSLNSYSDYNAINSTID", expression="t1.PSDEPSLNSYSDYNAINSTID", showorder=9), @DEDataQueryCodeExp(name="PSDEPSLNSYSDYNAINSTNAME", expression="t1.PSDEPSLNSYSDYNAINSTNAME", showorder=10), @DEDataQueryCodeExp(name="PSDEPSLNSYSID", expression="t1.PSDEPSLNSYSID", showorder=11), @DEDataQueryCodeExp(name="PSDEPSLNSYSNAME", expression="t11.PSDEPSLNSYSNAME", showorder=12), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=13), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=14), @DEDataQueryCodeExp(name="USERTAG", expression="t1.USERTAG", showorder=15), @DEDataQueryCodeExp(name="USERTAG2", expression="t1.USERTAG2", showorder=16), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.VALIDFLAG", showorder=17)}, conds={})})
public class PSDepSlnSysDynaInstDefaultDQModel
extends DEDataQueryModelBase {
    public PSDepSlnSysDynaInstDefaultDQModel() {
        this.initAnnotation(PSDepSlnSysDynaInstDefaultDQModel.class);
    }
}

