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
package net.ibizsys.pscore.srv.wfplatform.demodel.pswpengineinst.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="A1083B76-B1E9-48BD-AF02-68F120BDC42F", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`PSWPENGINEID`, t1.`PSWPENGINEINSTID`, t1.`PSWPENGINEINSTNAME`, t11.`PSWPENGINENAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSWPENGINEINST` t1  LEFT JOIN T_SRFPSWPENGINE t11 ON t1.PSWPENGINEID = t11.PSWPENGINEID  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="PSWPENGINEID", expression="t1.`PSWPENGINEID`", showorder=2), @DEDataQueryCodeExp(name="PSWPENGINEINSTID", expression="t1.`PSWPENGINEINSTID`", showorder=3), @DEDataQueryCodeExp(name="PSWPENGINEINSTNAME", expression="t1.`PSWPENGINEINSTNAME`", showorder=4), @DEDataQueryCodeExp(name="PSWPENGINENAME", expression="t11.`PSWPENGINENAME`", showorder=5), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=6), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=7)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.PSWPENGINEID, t1.PSWPENGINEINSTID, t1.PSWPENGINEINSTNAME, t11.PSWPENGINENAME, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSWPENGINEINST t1  LEFT JOIN T_SRFPSWPENGINE t11 ON t1.PSWPENGINEID = t11.PSWPENGINEID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="PSWPENGINEID", expression="t1.PSWPENGINEID", showorder=2), @DEDataQueryCodeExp(name="PSWPENGINEINSTID", expression="t1.PSWPENGINEINSTID", showorder=3), @DEDataQueryCodeExp(name="PSWPENGINEINSTNAME", expression="t1.PSWPENGINEINSTNAME", showorder=4), @DEDataQueryCodeExp(name="PSWPENGINENAME", expression="t11.PSWPENGINENAME", showorder=5), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=6), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=7)}, conds={})})
public class PSWPEngineInstDefaultDQModel
extends DEDataQueryModelBase {
    public PSWPEngineInstDefaultDQModel() {
        this.initAnnotation(PSWPEngineInstDefaultDQModel.class);
    }
}

