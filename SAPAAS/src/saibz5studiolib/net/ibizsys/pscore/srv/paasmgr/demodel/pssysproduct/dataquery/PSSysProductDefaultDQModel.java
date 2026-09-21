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
package net.ibizsys.pscore.srv.paasmgr.demodel.pssysproduct.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="9F01F8B8-F65B-48A6-9098-CE4DD083CD97", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t11.`MEMO`, t11.`PRODUCTSN`, t11.`PRODUCTSTATE`, t11.`PSPRODUCTTYPE`, t11.`PSSVRPROVIDERID`, t21.`PSSVRPROVIDERNAME`, t1.`PSSYSPRODUCTID`, t1.`PSSYSPRODUCTNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSSYSPRODUCT` t1  LEFT JOIN `T_SRFPSPRODUCT` t11 ON t1.`PSSYSPRODUCTID` = t11.`PSPRODUCTID`  LEFT JOIN `T_SRFPSSVRPROVIDER` t21 ON t11.`PSSVRPROVIDERID` = t21.`PSSVRPROVIDERID`  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t11.`MEMO`", showorder=2), @DEDataQueryCodeExp(name="PRODUCTSN", expression="t11.`PRODUCTSN`", showorder=3), @DEDataQueryCodeExp(name="PRODUCTSTATE", expression="t11.`PRODUCTSTATE`", showorder=4), @DEDataQueryCodeExp(name="PSPRODUCTTYPE", expression="t11.`PSPRODUCTTYPE`", showorder=5), @DEDataQueryCodeExp(name="PSSVRPROVIDERID", expression="t11.`PSSVRPROVIDERID`", showorder=6), @DEDataQueryCodeExp(name="PSSVRPROVIDERNAME", expression="t21.`PSSVRPROVIDERNAME`", showorder=7), @DEDataQueryCodeExp(name="PSSYSPRODUCTID", expression="t1.`PSSYSPRODUCTID`", showorder=8), @DEDataQueryCodeExp(name="PSSYSPRODUCTNAME", expression="t1.`PSSYSPRODUCTNAME`", showorder=9), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=10), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=11)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t11.MEMO, t11.PRODUCTSN, t11.PRODUCTSTATE, t11.PSPRODUCTTYPE, t11.PSSVRPROVIDERID, t21.PSSVRPROVIDERNAME, t1.PSSYSPRODUCTID, t1.PSSYSPRODUCTNAME, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSSYSPRODUCT t1  LEFT JOIN T_SRFPSPRODUCT t11 ON t1.PSSYSPRODUCTID = t11.PSPRODUCTID  LEFT JOIN T_SRFPSSVRPROVIDER t21 ON t11.PSSVRPROVIDERID = t21.PSSVRPROVIDERID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t11.MEMO", showorder=2), @DEDataQueryCodeExp(name="PRODUCTSN", expression="t11.PRODUCTSN", showorder=3), @DEDataQueryCodeExp(name="PRODUCTSTATE", expression="t11.PRODUCTSTATE", showorder=4), @DEDataQueryCodeExp(name="PSPRODUCTTYPE", expression="t11.PSPRODUCTTYPE", showorder=5), @DEDataQueryCodeExp(name="PSSVRPROVIDERID", expression="t11.PSSVRPROVIDERID", showorder=6), @DEDataQueryCodeExp(name="PSSVRPROVIDERNAME", expression="t21.PSSVRPROVIDERNAME", showorder=7), @DEDataQueryCodeExp(name="PSSYSPRODUCTID", expression="t1.PSSYSPRODUCTID", showorder=8), @DEDataQueryCodeExp(name="PSSYSPRODUCTNAME", expression="t1.PSSYSPRODUCTNAME", showorder=9), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=10), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=11)}, conds={})})
public class PSSysProductDefaultDQModel
extends DEDataQueryModelBase {
    public PSSysProductDefaultDQModel() {
        this.initAnnotation(PSSysProductDefaultDQModel.class);
    }
}

