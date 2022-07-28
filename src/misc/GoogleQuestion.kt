package misc

import java.io.IOException
import kotlin.math.max

/**
 *
 * You are tasked with assembling a stream of data, from unordered chunks of data that arrive
 * continuously from the network (as done by the operating system in TCP).
 *
 * Each chunk of data has an offset (from the beginning of the stream) and a data buffer.
 * Assumptions:
 * 1) No duplicate packets
 * 2) No overlapping packets
 *
 * Implement stream reader for network packets (packet may arrive out of order)
 *
 * Example for the Packets:
 * packet 1: a b c     offset: 0, length: 3
 * packet 2: d e f g   offset: 3, length: 4
 * packet 3: h           offset: 7, length: 1
 * Example for the function calls:
 * read(1) => a
 * read(3) => b c d
 * read(100) => exception
 * read(1) => e
 * read(1) => f
 */

//abcdefg

fun main() {
    val streamer = TCPStreamer()
    streamer.receivePacket(Packet("abc", 0))
    streamer.receivePacket(Packet("defg", 3))
    streamer.receivePacket(Packet("h", 7))

    println(streamer.read(1))
    println(streamer.read(3))
    println(streamer.read(2))
    println(streamer.read(1))
    println(streamer.read(1))


    // exception
  /*  println(streamer.read(1))
    println(streamer.read(3))
    println(streamer.read(100))
    println(streamer.read(1))
    println(streamer.read(1))*/
}

data class Packet(val data: String, val offset: Int)

class TCPStreamer {
    var map = mutableMapOf<Int, Packet?>()
    var curr_segment = 0
    var curr_offset = 0
    var maxBufferLen: Long = 0L

    // Add any members that you want/need.  The interface for "receivePacket" and "read" must remain.
    fun receivePacket(packet: Packet?) {
        map[packet!!.offset] = packet
        maxBufferLen = max(maxBufferLen, (packet!!.offset + packet.data.length).toLong())
    }

    @Throws(IOException::class)
    fun read(length: Int): String {
        if (curr_offset + length > maxBufferLen)
            throw IOException("curr_offset + length > maxBufferLen");
        var output: String = ""
        var charsToRead = 0
        while (charsToRead < length) {
            //Read from current segment
            var p = map[curr_segment]
            //Find the index from where to start reading
            var startIdx = curr_offset - p!!.offset
            while (startIdx < p.data.length && charsToRead < length) {
                output += p.data[startIdx++]
                charsToRead++
                curr_offset++
            }
            //Decide if we want to read next segment
            if (charsToRead == length)
                break
            map.remove(curr_segment)
            curr_segment += curr_segment + p.data.length
        }
        return output
    }
}