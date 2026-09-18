class CountSquares {
HashMap<Integer, HashMap<Integer,Integer>> mp; // x | (y, freq)
    public CountSquares() {
        mp = new HashMap<>();
    }
    
    public void add(int[] point) {
        int x = point[0];
        int y = point[1];
        
        if(!mp.containsKey(x)) mp.put(x,new HashMap<>());
        mp.get(x).put(y,mp.get(x).getOrDefault(y,0)+1);
    }
    
    public int count(int[] point) {
        int totalSqs = 0;

        int x1 = point[0];
        int y1 = point[1];

        // given point ka x coordinate  pehle se map me hai
        if(!mp.containsKey(x1)){
            return 0; // i.e we cant able to make square
        }

        // if exist karta hai, lets find its y coordinates
        for(Map.Entry<Integer,Integer> entry: mp.get(x1).entrySet()){
            int y2 = entry.getKey();
            int count_y2 = entry.getValue();

            if(y1 == y2) continue;

            int sideLength = Math.abs(y2-y1);
            // abhi isi sidelength ko x1 me subtract or add karke check karege 
            // ki apne pass baaki ke 2 corrdinates hai ya nhi

            totalSqs += calSqs(x1,y1,x1+sideLength,y2,count_y2);
            totalSqs += calSqs(x1,y1,x1-sideLength,y2,count_y2);
        }
        return totalSqs;
    }

    int calSqs(int x1, int y1, int req_x_point, int y2, int count_y2){
        if(mp.containsKey(req_x_point)){
            Map<Integer,Integer> mp2 = mp.get(req_x_point);
            return mp2.getOrDefault(y1,0)* mp2.getOrDefault(y2,0) * count_y2;
        }

        return 0;
    }
}
