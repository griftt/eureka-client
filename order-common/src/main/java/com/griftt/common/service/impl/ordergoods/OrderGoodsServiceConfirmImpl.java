package com.griftt.common.service.impl.ordergoods;

import com.griftt.common.entity.Order;
import com.griftt.common.service.OrderGoodsService;
import org.bytesoft.bytetcc.supports.spring.aware.CompensableContextAware;
import org.bytesoft.compensable.CompensableContext;

public class OrderGoodsServiceConfirmImpl implements OrderGoodsService, CompensableContextAware {
    /**
     * 用于传递try的计算结果
     */
    private CompensableContext compensableContext;

    @Override
    public void setCompensableContext(CompensableContext compensableContext) {
        this.compensableContext=compensableContext;
    }

    @Override
    public void increaseOrderGoods(Integer goodsId, Order order) {

        //只可以获取compensableContext中的值，不能增删改。try阶段才可以
        Object value = this.compensableContext.getVariable("resultInTryPhase");
        //如果Confirm/Cancel阶段想知道其对应的try阶段是否执行成功，可以通过CompensableContext.isCurrentCompensableServiceTried()获知。
        boolean svcTried = this.compensableContext.isCurrentCompensableServiceTried();
    }
}
