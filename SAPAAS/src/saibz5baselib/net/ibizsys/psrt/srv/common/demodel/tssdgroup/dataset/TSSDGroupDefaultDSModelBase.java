/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.common.demodel.tssdgroup.dataset;


import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.demodel.DEDataSetGroupParamModel;

@DEDataSet(id="f37da71b9c7217fb86634c135e6fb7e0",name="DEFAULT",queries= {
    @DEDataSetQuery(queryid="E6AE041C-1F79-4723-A6CC-BB123A0E7A55",queryname="DEFAULT")
})

/**
 *  实体数据集合[DEFAULT]模型基类
 */
public abstract class TSSDGroupDefaultDSModelBase extends net.ibizsys.paas.demodel.DEDataSetModelBase {
    public TSSDGroupDefaultDSModelBase() {
        super();

        this.initAnnotation(TSSDGroupDefaultDSModelBase.class);
    }




}