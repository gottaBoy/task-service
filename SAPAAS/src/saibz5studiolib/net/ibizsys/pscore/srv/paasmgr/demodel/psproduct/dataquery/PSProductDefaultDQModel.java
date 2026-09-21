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
package net.ibizsys.pscore.srv.paasmgr.demodel.psproduct.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="2C7CD642-A547-44FF-8A17-3F49AE8C88A0", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`MEMO`, t1.`PRODUCTSN`, t1.`PRODUCTSTATE`, t1.`PSPRODUCTID`, t1.`PSPRODUCTNAME`, t1.`PSPRODUCTTYPE`, t1.`PSSVRPROVIDERID`, t11.`PSSVRPROVIDERNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSPRODUCT` t1  LEFT JOIN `T_SRFPSSVRPROVIDER` t11 ON t1.`PSSVRPROVIDERID` = t11.`PSSVRPROVIDERID`  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=2), @DEDataQueryCodeExp(name="PRODUCTSN", expression="t1.`PRODUCTSN`", showorder=3), @DEDataQueryCodeExp(name="PRODUCTSTATE", expression="t1.`PRODUCTSTATE`", showorder=4), @DEDataQueryCodeExp(name="PSPRODUCTID", expression="t1.`PSPRODUCTID`", showorder=5), @DEDataQueryCodeExp(name="PSPRODUCTNAME", expression="t1.`PSPRODUCTNAME`", showorder=6), @DEDataQueryCodeExp(name="PSPRODUCTTYPE", expression="t1.`PSPRODUCTTYPE`", showorder=7), @DEDataQueryCodeExp(name="PSSVRPROVIDERID", expression="t1.`PSSVRPROVIDERID`", showorder=8), @DEDataQueryCodeExp(name="PSSVRPROVIDERNAME", expression="t11.`PSSVRPROVIDERNAME`", showorder=9), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=10), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=11)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.PRODUCTSN, t1.PRODUCTSTATE, t1.PSPRODUCTID, t1.PSPRODUCTNAME, t1.PSPRODUCTTYPE, t1.PSSVRPROVIDERID, t11.PSSVRPROVIDERNAME, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSPRODUCT t1  LEFT JOIN T_SRFPSSVRPROVIDER t11 ON t1.PSSVRPROVIDERID = t11.PSSVRPROVIDERID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=2), @DEDataQueryCodeExp(name="PRODUCTSN", expression="t1.PRODUCTSN", showorder=3), @DEDataQueryCodeExp(name="PRODUCTSTATE", expression="t1.PRODUCTSTATE", showorder=4), @DEDataQueryCodeExp(name="PSPRODUCTID", expression="t1.PSPRODUCTID", showorder=5), @DEDataQueryCodeExp(name="PSPRODUCTNAME", expression="t1.PSPRODUCTNAME", showorder=6), @DEDataQueryCodeExp(name="PSPRODUCTTYPE", expression="t1.PSPRODUCTTYPE", showorder=7), @DEDataQueryCodeExp(name="PSSVRPROVIDERID", expression="t1.PSSVRPROVIDERID", showorder=8), @DEDataQueryCodeExp(name="PSSVRPROVIDERNAME", expression="t11.PSSVRPROVIDERNAME", showorder=9), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=10), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=11)}, conds={})})
public class PSProductDefaultDQModel
extends DEDataQueryModelBase {
    public PSProductDefaultDQModel() {
        this.initAnnotation(PSProductDefaultDQModel.class);
    }
}

