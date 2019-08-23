package com.easicare.device.service;

import com.easicare.device.entity.Customer;

import java.util.List;

/**
 * @author
 * @date 2019/8/17
 */
public interface CustomersInterface {
    public List<Customer> searchCity(Integer pageNumber, Integer pageSize, String searchContent);
}
