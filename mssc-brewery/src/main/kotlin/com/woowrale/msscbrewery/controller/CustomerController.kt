package com.woowrale.msscbrewery.controller

import com.woowrale.msscbrewery.services.CustomerService
import com.woowrale.msscbrewery.controller.model.CustomerDto
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RequestMapping("/api/v1/customer/")
@RestController
class CustomerController {

    @Autowired
    lateinit var customerService: CustomerService

    @GetMapping("/{customerId}")
    fun getCustomer(@PathVariable customerId: UUID): ResponseEntity<CustomerDto> {
        return ResponseEntity(customerService.getCustomerById(customerId), HttpStatus.OK)
    }


    //POST create a new beer.
    @PostMapping
    fun handlePost(@RequestBody customerDto: CustomerDto): ResponseEntity<CustomerDto>{
        val savedDto = customerService.saveCustomer(customerDto)
        var headers: HttpHeaders = HttpHeaders()
        headers.add("Location", savedDto.id.toString())
        return ResponseEntity(headers, HttpStatus.CREATED)
    }

    //PUT update an existing beer.
    @PutMapping("/{customerId}")
    fun handleUpdate(@PathVariable("customerId") customerId: UUID, @RequestBody customerDto: CustomerDto):ResponseEntity<CustomerDto>{
        customerService.updateCustomer(customerId,customerDto)
        return ResponseEntity(HttpStatus.NO_CONTENT)
    }

    //DELETE delete an existing beer by Id
    @DeleteMapping("/{customerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteBeer(@PathVariable("customerId") customerId: UUID){
        customerService.deleteCustomer(customerId)
    }
}