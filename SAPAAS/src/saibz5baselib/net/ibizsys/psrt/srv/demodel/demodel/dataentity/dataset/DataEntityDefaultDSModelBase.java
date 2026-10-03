/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.demodel.demodel.dataentity.dataset;


import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.demodel.DEDataSetGroupParamModel;

@DEDataSet(id="0cbbb4ccda4e86a9e6f16ed5f3a171c2",name="DEFAULT",queries= {
    @DEDataSetQuery(queryid="85EB2DA6-F398-48D0-9F15-F21BFBDEBEE4",queryname="DEFAULT")
})

/**
 *  实体数据集合[DEFAULT]模型基类
 */
public abstract class DataEntityDefaultDSModelBase extends net.ibizsys.paas.demodel.DEDataSetModelBase {
    public DataEntityDefaultDSModelBase() {
        super();

        this.initAnnotation(DataEntityDefaultDSModelBase.class);
    }




}