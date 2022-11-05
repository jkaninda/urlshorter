package com.github.jkaninda.urlshorter.entity

import net.bytebuddy.implementation.bind.MethodDelegationBinder
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.util.*
import javax.persistence.*


@Entity
 class UrlShorter  (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    open var id: Long? = null,
    @Column(unique = true)
    var url:String,
    @Column(unique = true)
    var targetUrl:String,
    @CreationTimestamp
    var createdAt: Date? = null,
    @UpdateTimestamp
    var updatedAt: Date? = null

)