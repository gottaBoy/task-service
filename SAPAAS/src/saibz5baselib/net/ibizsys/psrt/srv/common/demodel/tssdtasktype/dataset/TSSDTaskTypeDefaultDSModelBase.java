/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.common.demodel.tssdtasktype.dataset;


import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.demodel.DEDataSetGroupParamModel;

@DEDataSet(id="43332c6488824ab95b327d64b4f23a1b",name="DEFAULT",queries= {
    @DEDataSetQuery(queryid="71E909AB-2C02-4C2A-8CD2-BC4F9278FB7F",queryname="DEFAULT")
})

/**
 *  实体数据集合[DEFAULT]模型基类
 */
public abstract class TSSDTaskTypeDefaultDSModelBase extends net.ibizsys.paas.demodel.DEDataSetModelBase {
    public TSSDTaskTypeDefaultDSModelBase() {
        super();

        this.initAnnotation(TSSDTaskTypeDefaultDSModelBase.class);
    }




}