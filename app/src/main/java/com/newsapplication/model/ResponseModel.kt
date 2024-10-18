package com.newsapplication.model

class ResponseModel (
    val status:String,
    val totalResult:Int,
    val articles:List<News>
){

}