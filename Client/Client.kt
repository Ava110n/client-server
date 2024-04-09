import java.net.Socket

class Client(
    val host: String = "localhost",
    val port: Int = 8080) {

    fun start(){
        var socket : Socket? = null
        try {
            socket = Socket(host, port)
        }
        catch (e: Exception){

        }
        finally{
            socket?.close()
        }
    }
}