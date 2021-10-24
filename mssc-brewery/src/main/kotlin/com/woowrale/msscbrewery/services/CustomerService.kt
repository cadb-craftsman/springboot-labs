package com.woowrale.msscbrewery.services

import com.woowrale.msscbrewery.controller.model.CustomerDto
import org.springframework.stereotype.Service
import java.util.*

interface CustomerService{

    fun getCustomerById(customerId: UUID): CustomerDto
    fun saveCustomer(customerDto: CustomerDto): CustomerDto
    fun updateCustomer(customerId: UUID, customerDto: CustomerDto): CustomerDto
    fun deleteCustomer(customerId: UUID)
}

@Service
class CustomerServiceImpl: CustomerService{

    override fun getCustomerById(customerId: UUID): CustomerDto {
        return CustomerDto(customerId, "Jhon Conor", 30)
    }

    override fun saveCustomer(customerDto: CustomerDto): CustomerDto {
       return customerDto
    }

    override fun updateCustomer(customerId: UUID, customerDto: CustomerDto): CustomerDto {
        return customerDto
    }

    override fun deleteCustomer(customerId: UUID) {
        TODO("Not yet implemented")
    }

}