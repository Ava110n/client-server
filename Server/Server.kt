import java.io.BufferedReader
import java.io.PrintWriter
import java.net.ServerSocket
import java.net.Socket

class Server(
    var port : Int = 8080) {



    init{
        counter++
    }
    companion object {
        var counter = 0
    }

    constructor(v : Int, v1: Int) : this() {
        port = v
    }


    val serverSocket = ServerSocket(port)
    fun start(){
        var clientSocket : Socket? = null
        try {
            clientSocket = serverSocket.accept()
            var br = clientSocket.getInputStream().bufferedReader()
            println(br.readLine())


            var pw = PrintWriter(clientSocket.getOutputStream())
            pw.println("hello from server")
            pw.flush()
            br.close()
            pw.close()

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