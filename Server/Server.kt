import java.io.BufferedReader
import java.net.ServerSocket
import java.net.Socket

class Server(
    val port : Int = 8080) {

    val serverSocket = ServerSocket(port)
    fun start(){
        var clientSocket : Socket? = null
        try {
            clientSocket = serverSocket.accept()
            var bw = clientSocket.getInputStream().bufferedReader()
            println(bw.readLine())
            bw.close()
        }
        catch (e: Exception){
            println(e.message)
        }
        finally {
            clientSocket?.close()
            serverSocket.close()
        }


    }
}