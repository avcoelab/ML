
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class  HuffmanNode implements  Comparable<HuffmanNode>{
    char c;
    int freq;
    HuffmanNode left,right;

    public HuffmanNode(char c,int freq){
        this.c=c;
        this.freq=freq;
        this.left=null;
        this.right=null;
    }

    @Override
    public  int compareTo(HuffmanNode node){
        return  this.freq -node.freq;
    }
}

public class HuffmanEncoding{
    public static  void buildHuffmanTree(HashMap<Character,Integer> nodes){
        PriorityQueue<HuffmanNode> pq=new PriorityQueue<>();
        for(Map.Entry<Character, Integer> entry:nodes.entrySet()){
            pq.add(new HuffmanNode(entry.getKey(), entry.getValue()));

        }
        while (pq.size()>1) { 
            HuffmanNode left=pq.poll();
            HuffmanNode right=pq.poll();

            HuffmanNode sum=new HuffmanNode('-',left.freq+right.freq);
            sum.left=left;
            sum.right=right;

            pq.add(sum);
            
        }
        HuffmanNode root=pq.poll();
        
        generateCodes(root,"");

    }

    public static  void   generateCodes(HuffmanNode node, String code){
        if(node==null){
            return;
        }

        if(node.left==null && node.right == null && node.c!='-'){
            System.out.println(node.c +" : "+ code);
            return;
        }

        generateCodes(node.left, code+"0");
        generateCodes(node.right, code+"1");
    }
    public static void main(String[] args) {
        HashMap<Character,Integer> map=new HashMap<>();
        map.put('a', 21);
        map.put('z', 3);
        map.put('c', 5);
        map.put('r', 1);
        map.put('p', 10);


        buildHuffmanTree(map);
    }
}
/*      
codes: 
a : 1
p : 01
c : 001
z : 0001
r : 0000
Huffman Tree
                      ['-',40] ------- Root
                    /0         \1
              ['-',19]      ['a',21]
            /0        \1
         ['-',9]    ['p',10]
        /0      \1
    ['-',4]    [c,5]
   /0      \1
 [r,1]   [z,3]
 */