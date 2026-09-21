/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataQuery
 *  net.ibizsys.paas.core.DEDataQueryCode
 *  net.ibizsys.paas.core.DEDataQueryCodeCond
 *  net.ibizsys.paas.core.DEDataQueryCodeExp
 *  net.ibizsys.paas.core.DEDataQueryCodes
 *  net.ibizsys.paas.demodel.DEDataQueryModelBase
 */
package net.ibizsys.pscore.srv.sysdevstudio.demodel.psdspaneltoolbox.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeCond;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="85D38F91-B623-4434-BA17-17CF3CE458FB", name="RawItem", viewlevel=2)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CAT`, t1.`ICONCLS`, t1.`ORDERVALUE`, t1.`PSDSPANELTOOLBOXID`, t1.`PSDSPANELTOOLBOXNAME`, t1.`TOOLBOXTYPE`, t1.`TOOLTIP` FROM `T_SRFPSDSPANELTOOLBOX` t1  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=-1), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=-1), @DEDataQueryCodeExp(name="INITPARAMS", expression="t1.`INITPARAMS`", showorder=-1), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=-1), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=-1), @DEDataQueryCodeExp(name="USERTAG", expression="t1.`USERTAG`", showorder=-1), @DEDataQueryCodeExp(name="USERTAG2", expression="t1.`USERTAG2`", showorder=-1), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.`VALIDFLAG`", showorder=-1), @DEDataQueryCodeExp(name="CAT", expression="t1.`CAT`", showorder=0), @DEDataQueryCodeExp(name="ICONCLS", expression="t1.`ICONCLS`", showorder=1), @DEDataQueryCodeExp(name="ORDERVALUE", expression="t1.`ORDERVALUE`", showorder=2), @DEDataQueryCodeExp(name="PSDSPANELTOOLBOXID", expression="t1.`PSDSPANELTOOLBOXID`", showorder=3), @DEDataQueryCodeExp(name="PSDSPANELTOOLBOXNAME", expression="t1.`PSDSPANELTOOLBOXNAME`", showorder=4), @DEDataQueryCodeExp(name="TOOLBOXTYPE", expression="t1.`TOOLBOXTYPE`", showorder=5), @DEDataQueryCodeExp(name="TOOLTIP", expression="t1.`TOOLTIP`", showorder=6)}, conds={@DEDataQueryCodeCond(condition="( t1.`TOOLBOXTYPE` = 'RAWITEM'  AND  t1.`VALIDFLAG` = 1 )")}), @DEDataQueryCode(querycode="SELECT t1.CAT, t1.ICONCLS, t1.ORDERVALUE, t1.PSDSPANELTOOLBOXID, t1.PSDSPANELTOOLBOXNAME, t1.TOOLBOXTYPE, t1.TOOLTIP FROM T_SRFPSDSPANELTOOLBOX t1  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=-1), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=-1), @DEDataQueryCodeExp(name="INITPARAMS", expression="t1.INITPARAMS", showorder=-1), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=-1), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=-1), @DEDataQueryCodeExp(name="USERTAG", expression="t1.USERTAG", showorder=-1), @DEDataQueryCodeExp(name="USERTAG2", expression="t1.USERTAG2", showorder=-1), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.VALIDFLAG", showorder=-1), @DEDataQueryCodeExp(name="CAT", expression="t1.CAT", showorder=0), @DEDataQueryCodeExp(name="ICONCLS", expression="t1.ICONCLS", showorder=1), @DEDataQueryCodeExp(name="ORDERVALUE", expression="t1.ORDERVALUE", showorder=2), @DEDataQueryCodeExp(name="PSDSPANELTOOLBOXID", expression="t1.PSDSPANELTOOLBOXID", showorder=3), @DEDataQueryCodeExp(name="PSDSPANELTOOLBOXNAME", expression="t1.PSDSPANELTOOLBOXNAME", showorder=4), @DEDataQueryCodeExp(name="TOOLBOXTYPE", expression="t1.TOOLBOXTYPE", showorder=5), @DEDataQueryCodeExp(name="TOOLTIP", expression="t1.TOOLTIP", showorder=6)}, conds={@DEDataQueryCodeCond(condition="( t1.TOOLBOXTYPE = 'RAWITEM'  AND  t1.VALIDFLAG = 1 )")})})
public class PSDSPanelToolBoxRawItemDQModel
extends DEDataQueryModelBase {
    public PSDSPanelToolBoxRawItemDQModel() {
        this.initAnnotation(PSDSPanelToolBoxRawItemDQModel.class);
    }
}

