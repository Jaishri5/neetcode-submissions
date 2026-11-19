
class Solution {
  public int countComponents(int n, int[][] edges) {
    // Your code goes here
    boolean[] visited = new boolean[n];
    List<List<Integer>> adjL = new ArrayList<>();
    int count = 0;
    for (int i = 0; i < n; i++) {
      adjL.add(new ArrayList<>());
    }
    for (int[] edge : edges) {
      int u = edge[0];
      int v = edge[1];
      adjL.get(u).add(v);
      adjL.get(v).add(u);
    }

    for (int i = 0; i < n; i++) {
      if (!visited[i]) {
        // visited[i]=true;
        count++;
        markConnectedNodesAsVisited(adjL, visited, i);
      }
    }
    return count;
  }

  public void markConnectedNodesAsVisited(List<List<Integer>> adjL, boolean[] visited, int node) {
    if (!visited[node]) {
      visited[node] = true;
      for (int adjNode : adjL.get(node)) {
        markConnectedNodesAsVisited(adjL, visited, adjNode);
      }
    }
  }
}
