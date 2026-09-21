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
package net.ibizsys.pscore.srv.sysdesign.demodel.psmodelref.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="AB1D7739-B6E8-4832-B4C5-FC131BA3CB20", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`MODELID`, t1.`MODELNAME`, t1.`MODELTYPE`, t1.`MODELTYPENAME`, t1.`PSMODELREFID`, t1.`PSMODELREFNAME`, t1.`REFMODE`, t1.`REFMODEL2ID`, t1.`REFMODEL2NAME`, t1.`REFMODEL2TYPE`, t1.`REFMODEL2TYPENAME`, t1.`REFMODELID`, t1.`REFMODELNAME`, t1.`REFMODELTYPE`, t1.`REFMODELTYPENAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSMODELREF` t1  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="MODELID", expression="t1.`MODELID`", showorder=2), @DEDataQueryCodeExp(name="MODELNAME", expression="t1.`MODELNAME`", showorder=3), @DEDataQueryCodeExp(name="MODELTYPE", expression="t1.`MODELTYPE`", showorder=4), @DEDataQueryCodeExp(name="MODELTYPENAME", expression="t1.`MODELTYPENAME`", showorder=5), @DEDataQueryCodeExp(name="PSMODELREFID", expression="t1.`PSMODELREFID`", showorder=6), @DEDataQueryCodeExp(name="PSMODELREFNAME", expression="t1.`PSMODELREFNAME`", showorder=7), @DEDataQueryCodeExp(name="REFMODE", expression="t1.`REFMODE`", showorder=8), @DEDataQueryCodeExp(name="REFMODEL2ID", expression="t1.`REFMODEL2ID`", showorder=9), @DEDataQueryCodeExp(name="REFMODEL2NAME", expression="t1.`REFMODEL2NAME`", showorder=10), @DEDataQueryCodeExp(name="REFMODEL2TYPE", expression="t1.`REFMODEL2TYPE`", showorder=11), @DEDataQueryCodeExp(name="REFMODEL2TYPENAME", expression="t1.`REFMODEL2TYPENAME`", showorder=12), @DEDataQueryCodeExp(name="REFMODELID", expression="t1.`REFMODELID`", showorder=13), @DEDataQueryCodeExp(name="REFMODELNAME", expression="t1.`REFMODELNAME`", showorder=14), @DEDataQueryCodeExp(name="REFMODELTYPE", expression="t1.`REFMODELTYPE`", showorder=15), @DEDataQueryCodeExp(name="REFMODELTYPENAME", expression="t1.`REFMODELTYPENAME`", showorder=16), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=17), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=18)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.MODELID, t1.MODELNAME, t1.MODELTYPE, t1.MODELTYPENAME, t1.PSMODELREFID, t1.PSMODELREFNAME, t1.REFMODE, t1.REFMODEL2ID, t1.REFMODEL2NAME, t1.REFMODEL2TYPE, t1.REFMODEL2TYPENAME, t1.REFMODELID, t1.REFMODELNAME, t1.REFMODELTYPE, t1.REFMODELTYPENAME, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSMODELREF t1  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="MODELID", expression="t1.MODELID", showorder=2), @DEDataQueryCodeExp(name="MODELNAME", expression="t1.MODELNAME", showorder=3), @DEDataQueryCodeExp(name="MODELTYPE", expression="t1.MODELTYPE", showorder=4), @DEDataQueryCodeExp(name="MODELTYPENAME", expression="t1.MODELTYPENAME", showorder=5), @DEDataQueryCodeExp(name="PSMODELREFID", expression="t1.PSMODELREFID", showorder=6), @DEDataQueryCodeExp(name="PSMODELREFNAME", expression="t1.PSMODELREFNAME", showorder=7), @DEDataQueryCodeExp(name="REFMODE", expression="t1.REFMODE", showorder=8), @DEDataQueryCodeExp(name="REFMODEL2ID", expression="t1.REFMODEL2ID", showorder=9), @DEDataQueryCodeExp(name="REFMODEL2NAME", expression="t1.REFMODEL2NAME", showorder=10), @DEDataQueryCodeExp(name="REFMODEL2TYPE", expression="t1.REFMODEL2TYPE", showorder=11), @DEDataQueryCodeExp(name="REFMODEL2TYPENAME", expression="t1.REFMODEL2TYPENAME", showorder=12), @DEDataQueryCodeExp(name="REFMODELID", expression="t1.REFMODELID", showorder=13), @DEDataQueryCodeExp(name="REFMODELNAME", expression="t1.REFMODELNAME", showorder=14), @DEDataQueryCodeExp(name="REFMODELTYPE", expression="t1.REFMODELTYPE", showorder=15), @DEDataQueryCodeExp(name="REFMODELTYPENAME", expression="t1.REFMODELTYPENAME", showorder=16), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=17), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=18)}, conds={})})
public class PSModelRefDefaultDQModel
extends DEDataQueryModelBase {
    public PSModelRefDefaultDQModel() {
        this.initAnnotation(PSModelRefDefaultDQModel.class);
    }
}

