package com.github.jkaninda.urlshorter.dto

import javax.persistence.Column

class UrlShorterDto(
        val url:String?=null,
        val targetUrl:String,
        val customUrl:String?=null,

        )