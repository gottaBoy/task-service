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
package net.ibizsys.pscore.srv.config.demodel.psmodelresource.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="F01B3210-09E7-4B6B-A5D3-A1B8C766C9E9", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`IMAGEURL`, t1.`MEMO`, t1.`PSMODELRESOURCEID`, t1.`PSMODELRESOURCENAME`, t1.`RESOURCETYPE`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSMODELRESOURCE` t1  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="IMAGEURL", expression="t1.`IMAGEURL`", showorder=2), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=3), @DEDataQueryCodeExp(name="PSMODELRESOURCEID", expression="t1.`PSMODELRESOURCEID`", showorder=4), @DEDataQueryCodeExp(name="PSMODELRESOURCENAME", expression="t1.`PSMODELRESOURCENAME`", showorder=5), @DEDataQueryCodeExp(name="RESOURCETYPE", expression="t1.`RESOURCETYPE`", showorder=6), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=7), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=8)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.IMAGEURL, t1.MEMO, t1.PSMODELRESOURCEID, t1.PSMODELRESOURCENAME, t1.RESOURCETYPE, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSMODELRESOURCE t1  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="IMAGEURL", expression="t1.IMAGEURL", showorder=2), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=3), @DEDataQueryCodeExp(name="PSMODELRESOURCEID", expression="t1.PSMODELRESOURCEID", showorder=4), @DEDataQueryCodeExp(name="PSMODELRESOURCENAME", expression="t1.PSMODELRESOURCENAME", showorder=5), @DEDataQueryCodeExp(name="RESOURCETYPE", expression="t1.RESOURCETYPE", showorder=6), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=7), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=8)}, conds={})})
public class PSModelResourceDefaultDQModel
extends DEDataQueryModelBase {
    public PSModelResourceDefaultDQModel() {
        this.initAnnotation(PSModelResourceDefaultDQModel.class);
    }
}

