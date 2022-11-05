package com.github.jkaninda.urlshorter.dto


data class ResponseMessage(
        var success:Boolean=true,
        var message:String?,
        var shortUrl:String,
        var targetUrl:String
)
