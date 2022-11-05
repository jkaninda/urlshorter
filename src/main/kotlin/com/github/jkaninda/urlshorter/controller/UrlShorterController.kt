package com.github.jkaninda.urlshorter.controller

import com.github.jkaninda.urlshorter.config.AppConfig
import com.github.jkaninda.urlshorter.dto.ResponseMessage
import com.github.jkaninda.urlshorter.dto.UrlShorterDto
import com.github.jkaninda.urlshorter.entity.UrlShorter
import com.github.jkaninda.urlshorter.service.UrlShorterService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import java.net.URI
import java.util.*
import javax.servlet.http.HttpServletRequest

@Controller
@RequestMapping("/")
class UrlShorterController(private val urlShorterService:UrlShorterService,private val appConfig: AppConfig) {

 @GetMapping()
 fun index(model: Model):String{
     model.addAttribute("appName",appConfig.appName)

     return "home"
 }
 @GetMapping("{url}")
   fun find(@PathVariable url:String):ResponseEntity<Objects>?{
     return ResponseEntity.status(HttpStatus.FOUND)
         .location(URI.create(urlShorterService.findByUrl(url)))
         .build();
  }
}