package com.easicare.device.mapper;

import com.easicare.device.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * @author
 * @date 2019/8/17
 */
public interface CustomerRepository extends ElasticsearchRepository<Customer, String> {
    public List<Customer> findByAddress(String address);
    public Customer findByUserName(String userName);
    public int  deleteByUserName(String userName);
    public Page<Customer> findByAddress(String address, Pageable pageable);
}
