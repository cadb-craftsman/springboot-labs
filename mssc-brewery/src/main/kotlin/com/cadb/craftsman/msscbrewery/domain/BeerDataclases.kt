package com.cadb.craftsman.msscbrewery.domain

import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.GenericGenerator
import java.math.BigDecimal
import java.sql.Timestamp
import java.util.*
import javax.persistence.*

@Entity
class Beer {
    constructor(
        id: UUID,
        version: Long,
        createDate: Timestamp,
        lastModifiedDate: Timestamp,
        beerName: String,
        beerStyle: String,
        upc: Long,
        price: BigDecimal,
        minOnHand: Int,
        quantityToBrew: Int)
    :this(){
        this.id = id
        this.version = version
        this.createDate = createDate
        this.lastModifiedDate = lastModifiedDate
        this.beerName = beerName
        this.beerStyle = beerStyle
        this.upc = upc
        this.price = price
        this.minOnHand = minOnHand
        this.quantityToBrew = quantityToBrew
    }

    constructor()

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(length = 36, columnDefinition = "varchar", updatable = false, nullable = false)
    lateinit var id: UUID

    @Version
    var version: Long = 0

    @CreationTimestamp
    @Column(updatable = false)
    lateinit var createDate: Timestamp
    lateinit var lastModifiedDate: Timestamp
    lateinit var beerName: String
    lateinit var beerStyle: String

    @Column(updatable = false)
    var upc: Long = 0
    lateinit var price: BigDecimal
    var minOnHand: Int = 0
    var quantityToBrew: Int = 0
}
