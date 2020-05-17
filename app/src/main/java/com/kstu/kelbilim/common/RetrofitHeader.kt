package com.kstu.kelbilim.common
class RetrofitHeader {
    private val headers = HashMap<String, String>()

    fun header(content: String): HashMap<String, String> {
        headers["Content-Type"] = "application/json"
        headers["Accept"] = "application/json"
        headers["User-Agent"] = System.getProperty("http.agent").toString()
        headers["Host"] = "85.113.28.182:8086"
        headers["Connection"] = "Keep-Alive"
        headers["Accept-Encoding"] = "gzip"
        headers["Content-Length"] =
            "${content.length}"
        return headers
    }
}