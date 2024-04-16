import java.io.PrintWriter
import java.net.Socket

class Client(
    val host: String = "localhost",
    val port: Int = 8080) {

    fun start(){
        var socket : Socket? = null
        try {
            socket = Socket(host, port)

            var pw = PrintWriter(socket.getOutputStream())
            pw.println("hello from client")
            pw.flush()

            var br = socket.getInputStream().bufferedReader()
            println(br.readLine())
            pw.close()
            br.close()
        }
        catch (e: Exception){
            println(e.message)
        }
        finally{
            socket?.close()
        }
    }
}