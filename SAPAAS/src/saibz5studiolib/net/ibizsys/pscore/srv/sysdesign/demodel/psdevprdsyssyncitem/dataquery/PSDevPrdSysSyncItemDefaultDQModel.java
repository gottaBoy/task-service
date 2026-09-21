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
package net.ibizsys.pscore.srv.sysdesign.demodel.psdevprdsyssyncitem.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="E252AAD0-9063-4496-B25F-D61F721DB4C6", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`ORDERVALUE`, t1.`PSDEVPRDSYSSYNCID`, t1.`PSDEVPRDSYSSYNCITEMID`, t1.`PSDEVPRDSYSSYNCITEMNAME`, t1.`PSDEVPRDSYSSYNCNAME`, t1.`SYNCACTION`, t1.`SYNCPARAM2`, t1.`SYNCPARAM3`, t1.`SYNCPARAM4`, t1.`SYNCPARAM5`, t1.`SYNCPARAM6`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSDEVPRDSYSSYNCITEM` t1  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="SYNCPARAM", expression="t1.`SYNCPARAM`", showorder=-1), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="ORDERVALUE", expression="t1.`ORDERVALUE`", showorder=2), @DEDataQueryCodeExp(name="PSDEVPRDSYSSYNCID", expression="t1.`PSDEVPRDSYSSYNCID`", showorder=3), @DEDataQueryCodeExp(name="PSDEVPRDSYSSYNCITEMID", expression="t1.`PSDEVPRDSYSSYNCITEMID`", showorder=4), @DEDataQueryCodeExp(name="PSDEVPRDSYSSYNCITEMNAME", expression="t1.`PSDEVPRDSYSSYNCITEMNAME`", showorder=5), @DEDataQueryCodeExp(name="PSDEVPRDSYSSYNCNAME", expression="t1.`PSDEVPRDSYSSYNCNAME`", showorder=6), @DEDataQueryCodeExp(name="SYNCACTION", expression="t1.`SYNCACTION`", showorder=7), @DEDataQueryCodeExp(name="SYNCPARAM2", expression="t1.`SYNCPARAM2`", showorder=8), @DEDataQueryCodeExp(name="SYNCPARAM3", expression="t1.`SYNCPARAM3`", showorder=9), @DEDataQueryCodeExp(name="SYNCPARAM4", expression="t1.`SYNCPARAM4`", showorder=10), @DEDataQueryCodeExp(name="SYNCPARAM5", expression="t1.`SYNCPARAM5`", showorder=11), @DEDataQueryCodeExp(name="SYNCPARAM6", expression="t1.`SYNCPARAM6`", showorder=12), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=13), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=14)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.ORDERVALUE, t1.PSDEVPRDSYSSYNCID, t1.PSDEVPRDSYSSYNCITEMID, t1.PSDEVPRDSYSSYNCITEMNAME, t1.PSDEVPRDSYSSYNCNAME, t1.SYNCACTION, t1.SYNCPARAM2, t1.SYNCPARAM3, t1.SYNCPARAM4, t1.SYNCPARAM5, t1.SYNCPARAM6, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSDEVPRDSYSSYNCITEM t1  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="SYNCPARAM", expression="t1.SYNCPARAM", showorder=-1), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="ORDERVALUE", expression="t1.ORDERVALUE", showorder=2), @DEDataQueryCodeExp(name="PSDEVPRDSYSSYNCID", expression="t1.PSDEVPRDSYSSYNCID", showorder=3), @DEDataQueryCodeExp(name="PSDEVPRDSYSSYNCITEMID", expression="t1.PSDEVPRDSYSSYNCITEMID", showorder=4), @DEDataQueryCodeExp(name="PSDEVPRDSYSSYNCITEMNAME", expression="t1.PSDEVPRDSYSSYNCITEMNAME", showorder=5), @DEDataQueryCodeExp(name="PSDEVPRDSYSSYNCNAME", expression="t1.PSDEVPRDSYSSYNCNAME", showorder=6), @DEDataQueryCodeExp(name="SYNCACTION", expression="t1.SYNCACTION", showorder=7), @DEDataQueryCodeExp(name="SYNCPARAM2", expression="t1.SYNCPARAM2", showorder=8), @DEDataQueryCodeExp(name="SYNCPARAM3", expression="t1.SYNCPARAM3", showorder=9), @DEDataQueryCodeExp(name="SYNCPARAM4", expression="t1.SYNCPARAM4", showorder=10), @DEDataQueryCodeExp(name="SYNCPARAM5", expression="t1.SYNCPARAM5", showorder=11), @DEDataQueryCodeExp(name="SYNCPARAM6", expression="t1.SYNCPARAM6", showorder=12), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=13), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=14)}, conds={})})
public class PSDevPrdSysSyncItemDefaultDQModel
extends DEDataQueryModelBase {
    public PSDevPrdSysSyncItemDefaultDQModel() {
        this.initAnnotation(PSDevPrdSysSyncItemDefaultDQModel.class);
    }
}

