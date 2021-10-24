package com.zzyy.study.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;

/**
 * @auther zzyy
 * @create 2020-10-25 13:32
 */
@NoArgsConstructor
@Data
public class Order
{
    private Long id;

    private String  orderName;
    private Integer orderStatus; // 0待支付  1已支付 2已超时
    private String  orderToken;
    private String  orderSerial;

    public Order(String orderName, Integer orderStatus, String orderToken, String orderSerial)
    {
        this.orderName = orderName;
        this.orderStatus = orderStatus;
        this.orderToken = orderToken;
        this.orderSerial = orderSerial;
    }

    public static void main(String[] args)
    {
        new HashMap<>().put(1,100);
    }
}
