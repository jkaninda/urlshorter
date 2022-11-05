package com.github.jkaninda.urlshorter.service

import com.github.jkaninda.urlshorter.dto.ResponseMessage
import com.github.jkaninda.urlshorter.dto.UrlShorterDto
import com.github.jkaninda.urlshorter.entity.UrlShorter
import org.springframework.stereotype.Service
import javax.servlet.http.HttpServletRequest

interface UrlShorterService {
    fun findByUrl(url:String):String
    fun store(urlShorterDto: UrlShorterDto,request: HttpServletRequest): ResponseMessage
    fun findAll():Iterable<UrlShorter>?
}