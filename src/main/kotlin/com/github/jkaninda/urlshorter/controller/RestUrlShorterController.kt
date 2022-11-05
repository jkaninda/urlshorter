package com.github.jkaninda.urlshorter.controller

import com.github.jkaninda.urlshorter.dto.ResponseMessage
import com.github.jkaninda.urlshorter.dto.UrlShorterDto
import com.github.jkaninda.urlshorter.entity.UrlShorter
import com.github.jkaninda.urlshorter.service.UrlShorterService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import java.net.URI
import java.util.*
import javax.servlet.http.HttpServletRequest

@RestController
@RequestMapping("/api/shorter")
class RestUrlShorterController(private val urlShorterService:UrlShorterService) {

//    @RequestMapping()
//    @GetMapping
//    fun index():ResponseEntity<Iterable<UrlShorter>>{
//        return ResponseEntity.ok(urlShorterService.findAll())
//    }
    @PostMapping
    fun store(@RequestBody @Validated urlShorterDto: UrlShorterDto,request: HttpServletRequest):ResponseEntity<ResponseMessage>{
        return ResponseEntity.status(HttpStatus.CREATED).body(urlShorterService.store(urlShorterDto,request))

    }
 @GetMapping("{url}")
   fun find(@PathVariable url:String):ResponseEntity<Objects>?{
     return ResponseEntity.status(HttpStatus.FOUND)
         .location(URI.create(urlShorterService.findByUrl(url)))
         .build();
  }
}