import java.io.BufferedReader
import java.io.PrintWriter
import java.net.Socket

class Client(
    val host: String = "localhost",
    val port: Int = 8080) {


    var socket : Socket? = null
    var pw : PrintWriter? = null
    var br: BufferedReader? = null

    fun start(){
        try {
            socket = Socket(host, port)
        }
        catch (e: Exception){
            println(e.message)
        }
    }
    fun send(text: String){
        pw = PrintWriter(socket?.getOutputStream())
        pw?.println("hello from client")
        pw?.flush()
    }
    fun get(){
        br = socket?.getInputStream()?.bufferedReader()
        println(br?.readLine())
    }
    fun finish(){
        pw?.close()
        br?.close()
        socket?.close()
    }

}