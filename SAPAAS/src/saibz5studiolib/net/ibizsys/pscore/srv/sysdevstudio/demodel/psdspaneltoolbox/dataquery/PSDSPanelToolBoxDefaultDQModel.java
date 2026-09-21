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
package net.ibizsys.pscore.srv.sysdevstudio.demodel.psdspaneltoolbox.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="CB1515D3-1C03-4033-AD2A-1B50CD0D0E84", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CAT`, t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`ICONCLS`, t1.`INITPARAMS`, t1.`ITEMTYPE`, t1.`ORDERVALUE`, t1.`PSDSPANELTOOLBOXID`, t1.`PSDSPANELTOOLBOXNAME`, t1.`TOOLBOXTYPE`, t1.`TOOLTIP`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`USERTAG`, t1.`USERTAG2`, t1.`VALIDFLAG` FROM `T_SRFPSDSPANELTOOLBOX` t1  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CAT", expression="t1.`CAT`", showorder=0), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=1), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=2), @DEDataQueryCodeExp(name="ICONCLS", expression="t1.`ICONCLS`", showorder=3), @DEDataQueryCodeExp(name="INITPARAMS", expression="t1.`INITPARAMS`", showorder=4), @DEDataQueryCodeExp(name="ITEMTYPE", expression="t1.`ITEMTYPE`", showorder=5), @DEDataQueryCodeExp(name="ORDERVALUE", expression="t1.`ORDERVALUE`", showorder=6), @DEDataQueryCodeExp(name="PSDSPANELTOOLBOXID", expression="t1.`PSDSPANELTOOLBOXID`", showorder=7), @DEDataQueryCodeExp(name="PSDSPANELTOOLBOXNAME", expression="t1.`PSDSPANELTOOLBOXNAME`", showorder=8), @DEDataQueryCodeExp(name="TOOLBOXTYPE", expression="t1.`TOOLBOXTYPE`", showorder=9), @DEDataQueryCodeExp(name="TOOLTIP", expression="t1.`TOOLTIP`", showorder=10), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=11), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=12), @DEDataQueryCodeExp(name="USERTAG", expression="t1.`USERTAG`", showorder=13), @DEDataQueryCodeExp(name="USERTAG2", expression="t1.`USERTAG2`", showorder=14), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.`VALIDFLAG`", showorder=15)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CAT, t1.CREATEDATE, t1.CREATEMAN, t1.ICONCLS, t1.INITPARAMS, t1.ITEMTYPE, t1.ORDERVALUE, t1.PSDSPANELTOOLBOXID, t1.PSDSPANELTOOLBOXNAME, t1.TOOLBOXTYPE, t1.TOOLTIP, t1.UPDATEDATE, t1.UPDATEMAN, t1.USERTAG, t1.USERTAG2, t1.VALIDFLAG FROM T_SRFPSDSPANELTOOLBOX t1  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CAT", expression="t1.CAT", showorder=0), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=1), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=2), @DEDataQueryCodeExp(name="ICONCLS", expression="t1.ICONCLS", showorder=3), @DEDataQueryCodeExp(name="INITPARAMS", expression="t1.INITPARAMS", showorder=4), @DEDataQueryCodeExp(name="ITEMTYPE", expression="t1.ITEMTYPE", showorder=5), @DEDataQueryCodeExp(name="ORDERVALUE", expression="t1.ORDERVALUE", showorder=6), @DEDataQueryCodeExp(name="PSDSPANELTOOLBOXID", expression="t1.PSDSPANELTOOLBOXID", showorder=7), @DEDataQueryCodeExp(name="PSDSPANELTOOLBOXNAME", expression="t1.PSDSPANELTOOLBOXNAME", showorder=8), @DEDataQueryCodeExp(name="TOOLBOXTYPE", expression="t1.TOOLBOXTYPE", showorder=9), @DEDataQueryCodeExp(name="TOOLTIP", expression="t1.TOOLTIP", showorder=10), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=11), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=12), @DEDataQueryCodeExp(name="USERTAG", expression="t1.USERTAG", showorder=13), @DEDataQueryCodeExp(name="USERTAG2", expression="t1.USERTAG2", showorder=14), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.VALIDFLAG", showorder=15)}, conds={})})
public class PSDSPanelToolBoxDefaultDQModel
extends DEDataQueryModelBase {
    public PSDSPanelToolBoxDefaultDQModel() {
        this.initAnnotation(PSDSPanelToolBoxDefaultDQModel.class);
    }
}

