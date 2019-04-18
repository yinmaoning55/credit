package com.neuedu.credit.Service.Imp;

import com.neuedu.credit.Service.OrderService;
import com.neuedu.credit.pojo.OrderProduct;
import com.neuedu.credit.pojo.PaymentOrder;
import com.neuedu.credit.repository.OrderProductRepository;
import com.neuedu.credit.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @Created by elvin on 2018/10/9 16:02.
 * @Describe:
 */
@Service("OrderService")
public class OrderServiceImp implements OrderService {

    @Autowired
    OrderRepository orderRepository;
    @Autowired
    OrderProductRepository orderProductRepository;

    @Override
    @Transactional
    public PaymentOrder add(PaymentOrder order, OrderProduct[] orderProducts) {
        orderRepository.save(order);
        for (OrderProduct orderProduct: orderProducts ) {
            orderProductRepository.save(orderProduct);
        }
        return order;
    }

    @Override
    public PaymentOrder get(String orderId) {
        return orderRepository.findById(orderId).get();
    }

    public List<OrderProduct> getOrderProducts(String orderId){
        return orderProductRepository.findAllByOrderno(orderId);
    }

    @Override
    public void changeStatus(String orderId, int status) {

    }
}
