package com.kotlin.example.kotlindemo

import org.springframework.boot.Banner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KotlinDemoApplication

fun main(args: Array<String>) {
	runApplication<KotlinDemoApplication>(*args){
		setBannerMode(Banner.Mode.OFF)
	}
}
