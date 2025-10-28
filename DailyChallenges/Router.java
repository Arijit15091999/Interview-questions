import java.util.*;

public class Router {
    public static void main(String[] args) {
        Router router = new Router(3);
        router.addPacket(1, 4, 90);
        router.addPacket(2, 5, 90);
        router.addPacket(1, 4, 90);
        router.addPacket(3, 5, 95);
        router.addPacket(4, 5, 105);
        router.forwardPacket();
        router.addPacket(5, 2, 110);
        router.getCount(5, 100, 110);
    }
    private Map<Integer, Set<Packet>> packetMap;
    private PriorityQueue<Packet> pq;
    private int memoryLimit;
    private int currentMemorySize;

    public Router(int memoryLimit) {
        this.packetMap = new HashMap<>();
        this.pq = new PriorityQueue<>();
        this.memoryLimit = memoryLimit;
        this.currentMemorySize = 0;
    }

    public boolean addPacket(int source, int destination, int timestamp) {
        Packet packetInfo = new Packet(source, destination, timestamp);
        Set<Packet> set = this.packetMap.getOrDefault(timestamp, new HashSet<>());
        if(set.contains(packetInfo)) {
            return false;
        }
        this.currentMemorySize++;
        set.add(packetInfo);
        pq.offer(new Packet(source, destination, timestamp));
        this.packetMap.put(timestamp, set);

        if(currentMemorySize > memoryLimit) {
            forwardPacket();
        }

        return true;
    }

    public int[] forwardPacket() {
        if(this.pq.isEmpty()) {
            return new int[]{};
        }

        Packet packet = pq.poll();
        this.packetMap.get(packet.timestamp).remove(packet);
        currentMemorySize--;

        return packet.toArray();
    }

    public int getCount(int destination, int startTime, int endTime) {
        int count = 0;
        for(int i = startTime; i <= endTime; i++) {
            Set<Packet> set = this.packetMap.get(i);
            if(set == null) continue;
            for(Packet packet : set) {
                if(packet.destination == destination) count++;
            }
        }
        return count;
    }

    private class Packet implements Comparable<Packet>{
        int source;
        int destination;
        int timestamp;

        Packet(int source, int destination, int timestamp) {
            this.source = source;
            this.destination = destination;
            this.timestamp = timestamp;
        }

        @Override
        public int compareTo(Packet other) {
            return Integer.compare(this.timestamp, other.timestamp);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Packet)) return false;
            Packet p = (Packet) o;
            return source == p.source && destination == p.destination && timestamp == p.timestamp;
        }

        @Override
        public int hashCode() {
            return Objects.hash(source, destination, timestamp);
        }

        public int[] toArray() {
            return new int[]{this.source, this.destination, this.timestamp};
        }
    }
}
