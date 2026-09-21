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
package net.ibizsys.pscore.srv.sysdeploy.demodel.psdepslnsyswf.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="FEF7EAB3-C725-4C05-8930-B9428420F32C", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`MEMO`, t1.`PSDEPSLNSYSID`, t11.`PSDEPSLNSYSNAME`, t1.`PSDEPSLNSYSWFID`, t1.`PSDEPSLNSYSWFNAME`, t1.`PSDEPSLNWFENGINEINSTID`, t21.`PSDEPSLNWFENGINEINSTNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSDEPSLNSYSWF` t1  LEFT JOIN T_SRFPSDEPSLNSYS t11 ON t1.PSDEPSLNSYSID = t11.PSDEPSLNSYSID  LEFT JOIN T_SRFPSDEPSLNWFENGINEINST t21 ON t1.PSDEPSLNWFENGINEINSTID = t21.PSDEPSLNWFENGINEINSTID  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=2), @DEDataQueryCodeExp(name="PSDEPSLNSYSID", expression="t1.`PSDEPSLNSYSID`", showorder=3), @DEDataQueryCodeExp(name="PSDEPSLNSYSNAME", expression="t11.`PSDEPSLNSYSNAME`", showorder=4), @DEDataQueryCodeExp(name="PSDEPSLNSYSWFID", expression="t1.`PSDEPSLNSYSWFID`", showorder=5), @DEDataQueryCodeExp(name="PSDEPSLNSYSWFNAME", expression="t1.`PSDEPSLNSYSWFNAME`", showorder=6), @DEDataQueryCodeExp(name="PSDEPSLNWFENGINEINSTID", expression="t1.`PSDEPSLNWFENGINEINSTID`", showorder=7), @DEDataQueryCodeExp(name="PSDEPSLNWFENGINEINSTNAME", expression="t21.`PSDEPSLNWFENGINEINSTNAME`", showorder=8), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=9), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=10)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.PSDEPSLNSYSID, t11.PSDEPSLNSYSNAME, t1.PSDEPSLNSYSWFID, t1.PSDEPSLNSYSWFNAME, t1.PSDEPSLNWFENGINEINSTID, t21.PSDEPSLNWFENGINEINSTNAME, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSDEPSLNSYSWF t1  LEFT JOIN T_SRFPSDEPSLNSYS t11 ON t1.PSDEPSLNSYSID = t11.PSDEPSLNSYSID  LEFT JOIN T_SRFPSDEPSLNWFENGINEINST t21 ON t1.PSDEPSLNWFENGINEINSTID = t21.PSDEPSLNWFENGINEINSTID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=2), @DEDataQueryCodeExp(name="PSDEPSLNSYSID", expression="t1.PSDEPSLNSYSID", showorder=3), @DEDataQueryCodeExp(name="PSDEPSLNSYSNAME", expression="t11.PSDEPSLNSYSNAME", showorder=4), @DEDataQueryCodeExp(name="PSDEPSLNSYSWFID", expression="t1.PSDEPSLNSYSWFID", showorder=5), @DEDataQueryCodeExp(name="PSDEPSLNSYSWFNAME", expression="t1.PSDEPSLNSYSWFNAME", showorder=6), @DEDataQueryCodeExp(name="PSDEPSLNWFENGINEINSTID", expression="t1.PSDEPSLNWFENGINEINSTID", showorder=7), @DEDataQueryCodeExp(name="PSDEPSLNWFENGINEINSTNAME", expression="t21.PSDEPSLNWFENGINEINSTNAME", showorder=8), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=9), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=10)}, conds={})})
public class PSDepSlnSysWFDefaultDQModel
extends DEDataQueryModelBase {
    public PSDepSlnSysWFDefaultDQModel() {
        this.initAnnotation(PSDepSlnSysWFDefaultDQModel.class);
    }
}

