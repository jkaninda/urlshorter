package com.github.jkaninda.urlshorter.service

import com.github.jkaninda.urlshorter.config.AppConfig
import com.github.jkaninda.urlshorter.dto.ResponseMessage
import com.github.jkaninda.urlshorter.dto.UrlShorterDto
import com.github.jkaninda.urlshorter.entity.UrlShorter
import com.github.jkaninda.urlshorter.exceptions.ExistException
import com.github.jkaninda.urlshorter.exceptions.NotFoundException
import com.github.jkaninda.urlshorter.repository.UrlShorterRepository
import com.github.jkaninda.urlshorter.utils.Utils
import com.sun.xml.bind.v2.TODO
import org.springframework.stereotype.Service
import org.springframework.util.ObjectUtils
import javax.servlet.http.HttpServletRequest

@Service
class UrlShorterServiceImpl(val urlShorterRepository: UrlShorterRepository,val appConfig: AppConfig) : UrlShorterService {
    override fun findByUrl(url: String): String {
        val urlShorter:UrlShorter?=urlShorterRepository.findUrlShorterByUrl(url)
        if (!ObjectUtils.isEmpty(urlShorter)) {
            return urlShorter!!.targetUrl
        }
        throw NotFoundException("URL not found")

    }
    override fun store(urlShorterDto: UrlShorterDto,request: HttpServletRequest): ResponseMessage {
        val urlShorter:UrlShorter?=urlShorterRepository.findUrlShorterByTargetUrl(urlShorterDto.targetUrl)
        if (ObjectUtils.isEmpty(urlShorter)) {
            val newUrlShorter: UrlShorter = urlShorterRepository.save(
                UrlShorter(
                    url = Utils.generateRandom(appConfig.urlLength),
                    targetUrl = urlShorterDto.targetUrl
                )
            )
            return ResponseMessage(true,"Short URL successfully created","${appConfig.domainURL}/${newUrlShorter.url}", targetUrl = newUrlShorter.targetUrl)

        }
        throw ExistException("This Url exist")
    }

    override fun findAll(): Iterable<UrlShorter>? {
        return urlShorterRepository.findAll()
    }
}