package com.neuedu.credit.Service;

import com.neuedu.credit.pojo.OrderProduct;
import com.neuedu.credit.pojo.PaymentOrder;

import java.util.List;

/**
 * @Created by elvin on 2018/10/9 15:54.
 * @Describe:
 */
public interface OrderService {

    PaymentOrder add (PaymentOrder order,OrderProduct[] orderProducts);
    PaymentOrder get(String orderId);
    List<OrderProduct> getOrderProducts(String orderId);
    void changeStatus(String orderId,int status);
}
