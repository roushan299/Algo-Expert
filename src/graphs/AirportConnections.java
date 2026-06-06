package graphs;

import java.util.*;

public class AirportConnections {

    public static class AirportNode{
        public String name;
        public boolean isReachable;
        public ArrayList<String> connections;
        public ArrayList<String> unreachableConnections;

        public AirportNode(String name){
            this.name = name;
            this.isReachable = true;
            this.connections = new ArrayList<>();
            this.unreachableConnections = new ArrayList<>();
        }
    }

    public static int airportConnections(List<String> airports, List<List<String>> routes, String startingAirport) {
        HashMap<String, AirportNode> airportGraph = createAirportGraph(airports, routes);
        ArrayList<AirportNode> unreachableAirportNodes = getUnreachableAirportsNodes(airportGraph, airports, startingAirport);
        makeUnreachableConnections(airportGraph, unreachableAirportNodes);
        return getMinNumberOfNewConnections(airportGraph, unreachableAirportNodes);
    }

    private static HashMap<String, AirportNode> createAirportGraph(List<String> airports, List<List<String>> routes) {
        HashMap<String, AirportNode> airportGraph = new HashMap<String, AirportNode>();

        for(String airport : airports){
            airportGraph.put(airport, new  AirportNode(airport));
        }

        for(List<String> route : routes){
            String source =  route.get(0);
            String destination = route.get(1);
            airportGraph.get(source).connections.add(destination);
        }

        return airportGraph;
    }

    private static ArrayList<AirportNode> getUnreachableAirportsNodes(HashMap<String, AirportNode> airportGraph, List<String> airports, String startingAirport) {
        HashSet<String> visitedAirports = new HashSet<>();
        depthFirstTraverseAirports(airportGraph, startingAirport, visitedAirports);
        ArrayList<AirportNode> unreachableAirportNodes = new ArrayList<>();

        for(String airport : airports){
            if(visitedAirports.contains(airport)) continue;
            AirportNode airportNode = airportGraph.get(airport);
            airportNode.isReachable = false;
            unreachableAirportNodes.add(airportNode);
        }
        return  unreachableAirportNodes;
    }

    private static void depthFirstTraverseAirports(HashMap<String, AirportNode> airportGraph, String airport, HashSet<String> visitedAirports) {
        if(visitedAirports.contains(airport)) return;

        visitedAirports.add(airport);
        ArrayList<String> connections = airportGraph.get(airport).connections;
        for(String connection : connections){
            depthFirstTraverseAirports(airportGraph, connection, visitedAirports);
        }
    }

    private static void makeUnreachableConnections(HashMap<String, AirportNode> airportGraph, ArrayList<AirportNode> unreachableAirportNodes) {

        for(AirportNode airportNode : unreachableAirportNodes){
            ArrayList<String> unreachableConnections = new ArrayList<>();
            HashSet<String> visitedAirports = new HashSet<>();
            depthFirstAddUnreachableConnection(airportGraph, airportNode.name, unreachableConnections, visitedAirports);
            airportNode.unreachableConnections = unreachableConnections;
        }
    }

    private static void depthFirstAddUnreachableConnection(HashMap<String, AirportNode> airportGraph, String airport, ArrayList<String> unreachableConnections, HashSet<String> visitedAirports) {
        AirportNode airportNode = airportGraph.get(airport);
        if(airportNode.isReachable) return;
        if(visitedAirports.contains(airport)) return;

        visitedAirports.add(airport);
        unreachableConnections.add(airport);
        ArrayList<String> connections = airportNode.connections;

        for(String connection : connections){
            depthFirstAddUnreachableConnection(airportGraph, connection, unreachableConnections, visitedAirports);
        }

    }

    private static int getMinNumberOfNewConnections(HashMap<String, AirportNode> airportGraph, ArrayList<AirportNode> unreachableAirportNodes) {
        unreachableAirportNodes.sort((airport1, airport2) ->
                Integer.compare(airport2.unreachableConnections.size(), airport1.unreachableConnections.size()));

        int numberOfNewConnections = 0;

        for(AirportNode airportNode : unreachableAirportNodes){
            if(airportNode.isReachable) continue;

            numberOfNewConnections++;
            for(String airport : airportNode.unreachableConnections){
                airportGraph.get(airport).isReachable = true;
            }
        }
        return numberOfNewConnections;
    }


}
