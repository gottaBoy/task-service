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
package net.ibizsys.pscore.srv.sysdeploy.demodel.psdepslnprd.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeCond;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="B4E3960F-0D42-4B4B-BED2-92EFEA0C1369", name="CurDepSln")
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`ENADYNAMICMODE`, t1.`MEMO`, t1.`PRDTYPE`, t1.`PSDCSYSRESID`, t11.`PSDCSYSRESNAME`, t1.`PSDEPSLNID`, t21.`PSDEPSLNNAME`, t1.`PSDEPSLNPRDID`, t1.`PSDEPSLNPRDNAME`, t1.`PSDEVSLNSYSVERID`, t31.`PSDEVSLNSYSVERNAME`, t1.`PSSYSMODELINSTID`, t41.`PSSYSMODELINSTNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSDEPSLNPRD` t1  LEFT JOIN T_SRFPSDCSYSRES t11 ON t1.PSDCSYSRESID = t11.PSDCSYSRESID  LEFT JOIN T_SRFPSDEPSLN t21 ON t1.PSDEPSLNID = t21.PSDEPSLNID  LEFT JOIN T_SRFPSDEVSLNSYSVER t31 ON t1.PSDEVSLNSYSVERID = t31.PSDEVSLNSYSVERID  LEFT JOIN T_SRFPSSYSMODELINST t41 ON t1.PSSYSMODELINSTID = t41.PSSYSMODELINSTID  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="ENADYNAMICMODE", expression="t1.`ENADYNAMICMODE`", showorder=2), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=3), @DEDataQueryCodeExp(name="PRDTYPE", expression="t1.`PRDTYPE`", showorder=4), @DEDataQueryCodeExp(name="PSDCSYSRESID", expression="t1.`PSDCSYSRESID`", showorder=5), @DEDataQueryCodeExp(name="PSDCSYSRESNAME", expression="t11.`PSDCSYSRESNAME`", showorder=6), @DEDataQueryCodeExp(name="PSDEPSLNID", expression="t1.`PSDEPSLNID`", showorder=7), @DEDataQueryCodeExp(name="PSDEPSLNNAME", expression="t21.`PSDEPSLNNAME`", showorder=8), @DEDataQueryCodeExp(name="PSDEPSLNPRDID", expression="t1.`PSDEPSLNPRDID`", showorder=9), @DEDataQueryCodeExp(name="PSDEPSLNPRDNAME", expression="t1.`PSDEPSLNPRDNAME`", showorder=10), @DEDataQueryCodeExp(name="PSDEVSLNSYSVERID", expression="t1.`PSDEVSLNSYSVERID`", showorder=11), @DEDataQueryCodeExp(name="PSDEVSLNSYSVERNAME", expression="t31.`PSDEVSLNSYSVERNAME`", showorder=12), @DEDataQueryCodeExp(name="PSSYSMODELINSTID", expression="t1.`PSSYSMODELINSTID`", showorder=13), @DEDataQueryCodeExp(name="PSSYSMODELINSTNAME", expression="t41.`PSSYSMODELINSTNAME`", showorder=14), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=15), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=16)}, conds={@DEDataQueryCodeCond(condition="( t1.`PSDEPSLNID` = 'psdepslnid' )")}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.ENADYNAMICMODE, t1.MEMO, t1.PRDTYPE, t1.PSDCSYSRESID, t11.PSDCSYSRESNAME, t1.PSDEPSLNID, t21.PSDEPSLNNAME, t1.PSDEPSLNPRDID, t1.PSDEPSLNPRDNAME, t1.PSDEVSLNSYSVERID, t31.PSDEVSLNSYSVERNAME, t1.PSSYSMODELINSTID, t41.PSSYSMODELINSTNAME, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSDEPSLNPRD t1  LEFT JOIN T_SRFPSDCSYSRES t11 ON t1.PSDCSYSRESID = t11.PSDCSYSRESID  LEFT JOIN T_SRFPSDEPSLN t21 ON t1.PSDEPSLNID = t21.PSDEPSLNID  LEFT JOIN T_SRFPSDEVSLNSYSVER t31 ON t1.PSDEVSLNSYSVERID = t31.PSDEVSLNSYSVERID  LEFT JOIN T_SRFPSSYSMODELINST t41 ON t1.PSSYSMODELINSTID = t41.PSSYSMODELINSTID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="ENADYNAMICMODE", expression="t1.ENADYNAMICMODE", showorder=2), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=3), @DEDataQueryCodeExp(name="PRDTYPE", expression="t1.PRDTYPE", showorder=4), @DEDataQueryCodeExp(name="PSDCSYSRESID", expression="t1.PSDCSYSRESID", showorder=5), @DEDataQueryCodeExp(name="PSDCSYSRESNAME", expression="t11.PSDCSYSRESNAME", showorder=6), @DEDataQueryCodeExp(name="PSDEPSLNID", expression="t1.PSDEPSLNID", showorder=7), @DEDataQueryCodeExp(name="PSDEPSLNNAME", expression="t21.PSDEPSLNNAME", showorder=8), @DEDataQueryCodeExp(name="PSDEPSLNPRDID", expression="t1.PSDEPSLNPRDID", showorder=9), @DEDataQueryCodeExp(name="PSDEPSLNPRDNAME", expression="t1.PSDEPSLNPRDNAME", showorder=10), @DEDataQueryCodeExp(name="PSDEVSLNSYSVERID", expression="t1.PSDEVSLNSYSVERID", showorder=11), @DEDataQueryCodeExp(name="PSDEVSLNSYSVERNAME", expression="t31.PSDEVSLNSYSVERNAME", showorder=12), @DEDataQueryCodeExp(name="PSSYSMODELINSTID", expression="t1.PSSYSMODELINSTID", showorder=13), @DEDataQueryCodeExp(name="PSSYSMODELINSTNAME", expression="t41.PSSYSMODELINSTNAME", showorder=14), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=15), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=16)}, conds={@DEDataQueryCodeCond(condition="( t1.PSDEPSLNID = 'psdepslnid' )")})})
public class PSDepSlnPrdCurDepSlnDQModel
extends DEDataQueryModelBase {
    public PSDepSlnPrdCurDepSlnDQModel() {
        this.initAnnotation(PSDepSlnPrdCurDepSlnDQModel.class);
    }
}

