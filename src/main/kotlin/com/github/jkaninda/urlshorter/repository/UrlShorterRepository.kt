package com.github.jkaninda.urlshorter.repository

import com.github.jkaninda.urlshorter.entity.UrlShorter
import org.springframework.data.jpa.repository.JpaRepository

interface UrlShorterRepository: JpaRepository<UrlShorter,Long>{
    fun findUrlShorterByUrl(url:String):UrlShorter?
    fun findUrlShorterByTargetUrl(url:String):UrlShorter?
}