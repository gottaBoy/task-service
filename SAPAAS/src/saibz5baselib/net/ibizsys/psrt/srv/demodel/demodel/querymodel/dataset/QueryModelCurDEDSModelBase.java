/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.demodel.demodel.querymodel.dataset;


import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.demodel.DEDataSetGroupParamModel;

@DEDataSet(id="FE268EB7-8579-4E55-AEC0-BD51AB9C4D1D",name="CurDE",queries= {
    @DEDataSetQuery(queryid="DAA168A0-06ED-41E7-AB10-F521457AF6C2",queryname="CurDE")
})

/**
 *  实体数据集合[当前实体]模型基类
 */
public abstract class QueryModelCurDEDSModelBase extends net.ibizsys.paas.demodel.DEDataSetModelBase {
    public QueryModelCurDEDSModelBase() {
        super();

        this.initAnnotation(QueryModelCurDEDSModelBase.class);
    }




}