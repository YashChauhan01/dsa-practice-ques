class Solution {
    public String foreignDictionary(String[] words) {
      Map<Character,List<Character>> adj=new HashMap<>();

      for(String word: words)
      {
        for(char c: word.toCharArray())
        {
            adj.putIfAbsent(c,new ArrayList<>());
        }
      }
      int n=words.length;
      for(int i=0;i<n-1;i++)
      {
        String s1=words[i];
        String s2=words[i+1];
        if(s1.length()>s2.length() && s1.startsWith(s2))
        return "";
        int len=Math.min(s1.length(),s2.length());
        for(int j=0;j<len;j++)
        {
            char ch1=s1.charAt(j);
            char ch2=s2.charAt(j);
            if(ch1!=ch2)
            {
                adj.get(ch1).add(ch2);
                break;
            }
        }
        
      }
      return topoSort(adj);
    }
    String topoSort(Map<Character,List<Character>> adj)
    {
        int n=adj.size();
        Map<Character,Integer> indeg=new HashMap<>();
        for (char ch : adj.keySet()) {
            indeg.put(ch, 0);
        }
        for(char ch: adj.keySet())
        {
            for(char it: adj.get(ch))
            {
                indeg.put(it,indeg.get(it)+1);
            }
        }
        Queue<Character> q=new LinkedList<>();
        for(char ch: adj.keySet())
        {
            if(indeg.get(ch)==0)
            q.add(ch);
        }
        StringBuilder sb=new StringBuilder();
        while(!q.isEmpty())
        {
            char node=q.poll();
            sb.append(node);
            for(char adjNode: adj.get(node))
            {
                indeg.put(adjNode,indeg.get(adjNode)-1);
                if(indeg.get(adjNode)==0)
                q.add(adjNode);
            }
        }
        if(sb.length()!=n)
        return "";
        return sb.toString();
    }
}
