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
package net.ibizsys.pscore.srv.devcenter.demodel.psdcsysproduct.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="82224E4E-9B36-4E81-AF8E-716E9CD7DADA", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t11.`MEMO`, t11.`PRODUCTSN`, t11.`PRODUCTSTATE`, t11.`PSDCPRODUCTTYPE`, t1.`PSDCSYSPRODUCTID`, t1.`PSDCSYSPRODUCTNAME`, t11.`PSDEVCENTERID`, t11.`PSDEVCENTERNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSDCSYSPRODUCT` t1  LEFT JOIN `T_SRFPSDCPRODUCT` t11 ON t1.`PSDCSYSPRODUCTID` = t11.`PSDCPRODUCTID`  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t11.`MEMO`", showorder=2), @DEDataQueryCodeExp(name="PRODUCTSN", expression="t11.`PRODUCTSN`", showorder=3), @DEDataQueryCodeExp(name="PRODUCTSTATE", expression="t11.`PRODUCTSTATE`", showorder=4), @DEDataQueryCodeExp(name="PSDCPRODUCTTYPE", expression="t11.`PSDCPRODUCTTYPE`", showorder=5), @DEDataQueryCodeExp(name="PSDCSYSPRODUCTID", expression="t1.`PSDCSYSPRODUCTID`", showorder=6), @DEDataQueryCodeExp(name="PSDCSYSPRODUCTNAME", expression="t1.`PSDCSYSPRODUCTNAME`", showorder=7), @DEDataQueryCodeExp(name="PSDEVCENTERID", expression="t11.`PSDEVCENTERID`", showorder=8), @DEDataQueryCodeExp(name="PSDEVCENTERNAME", expression="t11.`PSDEVCENTERNAME`", showorder=9), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=10), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=11)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t11.MEMO, t11.PRODUCTSN, t11.PRODUCTSTATE, t11.PSDCPRODUCTTYPE, t1.PSDCSYSPRODUCTID, t1.PSDCSYSPRODUCTNAME, t11.PSDEVCENTERID, t11.PSDEVCENTERNAME, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSDCSYSPRODUCT t1  LEFT JOIN T_SRFPSDCPRODUCT t11 ON t1.PSDCSYSPRODUCTID = t11.PSDCPRODUCTID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t11.MEMO", showorder=2), @DEDataQueryCodeExp(name="PRODUCTSN", expression="t11.PRODUCTSN", showorder=3), @DEDataQueryCodeExp(name="PRODUCTSTATE", expression="t11.PRODUCTSTATE", showorder=4), @DEDataQueryCodeExp(name="PSDCPRODUCTTYPE", expression="t11.PSDCPRODUCTTYPE", showorder=5), @DEDataQueryCodeExp(name="PSDCSYSPRODUCTID", expression="t1.PSDCSYSPRODUCTID", showorder=6), @DEDataQueryCodeExp(name="PSDCSYSPRODUCTNAME", expression="t1.PSDCSYSPRODUCTNAME", showorder=7), @DEDataQueryCodeExp(name="PSDEVCENTERID", expression="t11.PSDEVCENTERID", showorder=8), @DEDataQueryCodeExp(name="PSDEVCENTERNAME", expression="t11.PSDEVCENTERNAME", showorder=9), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=10), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=11)}, conds={})})
public class PSDCSysProductDefaultDQModel
extends DEDataQueryModelBase {
    public PSDCSysProductDefaultDQModel() {
        this.initAnnotation(PSDCSysProductDefaultDQModel.class);
    }
}

